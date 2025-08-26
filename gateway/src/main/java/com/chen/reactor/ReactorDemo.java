package com.chen.reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReactorDemo {


    // 模拟数据库：使用线程安全的 List 存储数据
    private static final List<String> DATABASE = new CopyOnWriteArrayList<>();
    private static final int PAGE_SIZE = 100;

    public static void main(String[] args) {
        pageConsume2();

    }

    //模拟数据库动态增长
    private static void pageConsume3() {
        // 初始化数据库 2000 条
        DATABASE.addAll(IntStream.rangeClosed(1, 2000)
                .mapToObj(i -> "Task-" + i)
                .collect(Collectors.toList()));

        // 模拟：5 秒后有新数据插入数据库
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                DATABASE.addAll(IntStream.rangeClosed(2001, 2050)
                        .mapToObj(i -> "Task-" + i)
                        .collect(Collectors.toList()));
                System.out.println("🚀 数据库新增了 50 条数据");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 分页查询 + 消费
        fetchFromDbPaged()
                .flatMap(task -> consume(task)
                                .doOnNext(result -> System.out.println(Thread.currentThread().getName() + " -> " + result)),
                        20) // 并发消费 20
                .blockLast(); // 阻塞直到所有任务完成
    }

    // 模拟分页查询数据库（动态）
    private static Flux<String> fetchFromDbPaged() {
        AtomicInteger page = new AtomicInteger(0);

        return Flux.defer(() -> {
                    int currentPage = page.getAndIncrement();
                    int start = currentPage * PAGE_SIZE;
                    int end = Math.min((currentPage + 1) * PAGE_SIZE, DATABASE.size());

                    if (start >= DATABASE.size()) {
                        return Flux.empty(); // 没有更多数据
                    }

                    List<String> pageData = DATABASE.subList(start, end);
                    System.out.println("查询数据库: 第 " + currentPage + " 页, 记录数=" + pageData.size());

                    return Flux.fromIterable(pageData);
                })
                .repeat() // 继续查询，直到没有新数据
                ;
    }

    //分页并行 + 消费并行
    private static void pageConsume2() {
        // 模拟数据库：2000 条数据
        List<String> allData = IntStream.rangeClosed(1, 2000)
                .mapToObj(i -> "Task-" + i)
                .collect(Collectors.toList());

        int pageSize = 100;
        int totalPages = (int) Math.ceil(allData.size() / (double) pageSize);

        // Flux.range -> 页码流
        Flux.range(0, totalPages)
                // 并行分页查询（最多 5 个页同时查询）
                .flatMap(page -> Flux.defer(() -> {
                    List<String> pageData = queryFromDb(allData, page, pageSize);
                    System.out.println("查询到第 " + page + " 页, 数据量=" + pageData.size());
                    return Flux.fromIterable(pageData);
                }).subscribeOn(Schedulers.elastic()), 5) // 控制查询并发
                // 并发消费（最多 20 个任务同时消费）
                .flatMap(task -> consume(task)
                                .doOnNext(result -> System.out.println(Thread.currentThread().getName() + " -> " + result)),
                        20
                )
                .blockLast();
    }

    //分页消费一遍查询数据库，一遍消费，每次最多在途也是20个
    private static void pageConsume() {
        // 模拟数据库：2000 条数据
        List<String> allData = IntStream.rangeClosed(1, 2000)
                .mapToObj(i -> "Task-" + i)
                .collect(Collectors.toList());

        // 每页大小
        int pageSize = 100;

        // Flux.defer 保证每次订阅时才触发查询（而不是一次性查完）
        Flux.range(0, (int) Math.ceil(allData.size() / (double) pageSize))
                .concatMap(page -> Flux.defer(() -> {
                    List<String> pageData = queryFromDb(allData, page, pageSize);
                    System.out.println("查询到第 " + page + " 页, 数据量=" + pageData.size());
                    return Flux.fromIterable(pageData);
                }))
                // 并发消费，最多同时20个任务
                .flatMap(task -> consume(task)
                                .doOnNext(result -> System.out.println(Thread.currentThread().getName() + " -> " + result)),
                        20
                )
                .blockLast();
    }


    //一次全查完，然后控制并发每次20个
    private static void allData() {
        // 模拟数据库查出 2000 条数据
        List<String> dbData = IntStream.rangeClosed(1, 2000)
                .mapToObj(i -> "Task-" + i)
                .collect(Collectors.toList());

        // 用 Flux 模拟数据源
        Flux.fromIterable(dbData)
                // flatMap 控制并发消费，maxConcurrency=20 表示最多同时消费20个
                .flatMap(task -> consume(task)
                                .doOnNext(result -> System.out.println(Thread.currentThread().getName() + " -> " + result)),
                        20 // 最大并发数
                )
                .blockLast(); // 等待所有数据消费完
    }

    /**
     * 模拟数据库分页查询
     */
    private static List<String> queryFromDb(List<String> allData, int page, int pageSize) {
        int start = page * pageSize;
        int end = Math.min(start + pageSize, allData.size());
        if (start >= allData.size()) {
            return new ArrayList<>();
        }
        return allData.subList(start, end);
    }

    // 模拟消费：延迟1秒后返回
    private static Flux<String> consume(String task) {
        return Flux.just(task)
                .delayElements(Duration.ofSeconds(1), Schedulers.parallel()) // 延迟1s模拟耗时
                .map(t -> "消费完成: " + t);
    }
}
