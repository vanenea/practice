package com.chen.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@Slf4j
public class TaskController {
    // 模拟任务源（比如数据库、消息队列等）
    private Flux<Integer> taskSource() {
        return Flux.range(1, 100) // 100 个任务
                .delayElements(Duration.ofMillis(100)); // 模拟生产间隔
    }

    // 模拟任务处理逻辑
    private Mono<String> processTask(Integer taskId) {
        return Mono.just("任务-" + taskId)
                .delayElement(Duration.ofMillis(1000)) // 模拟耗时处理
                .doOnNext(t -> System.out.println(Thread.currentThread().getName() + " 消费中: " + t));
    }

    // API: 在途最多 20 个任务，消费完一个补一个
    @GetMapping("/consume")
    public Flux<String> consumeTasks() {
        //log.info("consume");
        return taskSource()
                //.delayElements(Duration.ofMillis(100)) // 每 100ms 取一个 = 10/s
                .flatMap(this::processTask, 20) // 并发度 = 20
                .doOnNext(result -> System.out.println("完成: " + result));
    }
}
