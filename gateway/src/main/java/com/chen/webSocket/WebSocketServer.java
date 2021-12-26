package com.chen.webSocket;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


@ServerEndpoint("/websocket")
@Component
public class WebSocketServer {
	
	private static Logger LOGGER = Logger.getLogger(WebSocketServer.class);
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //接收sid
    private String id;
    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        List<String> list = session.getRequestParameterMap().get("id");
        if(list != null && list.size()>0)
        	this.id= list.get(0);
        else
        	this.id = String.valueOf(new Random().nextInt(100000));
        LOGGER.info("有新窗口开始监听:"+id+",当前在线人数为" + getOnlineCount());
      
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        LOGGER.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     	* 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
    	LOGGER.info("收到来自窗口"+id+"的信息:"+message);
        //群发消息
        for (WebSocketServer item : webSocketSet) {
            try {
            	if(this.id != null && !this.id.equals(item.id))
            		item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	/**
	 * 
	 * @param session
	 * @param error
	 */
    @OnError
    public void onError(Session session, Throwable error) {
    	LOGGER.error("发生错误");
        error.printStackTrace();
    }
	/**
	 * 实现服务器主动推送
	 */
    public synchronized void sendMessage(String message) throws IOException {
    		this.session.getAsyncRemote().sendText(message);
		
    }


    /**
     * 群发自定义消息
     * */
    public static void sendInfo(String message,@PathParam("sid") String sid) throws IOException {
    	LOGGER.info("推送消息到窗口"+sid+"，推送内容:"+message);
        for (WebSocketServer item : webSocketSet) {
            try {
            	//这里可以设定只推送给这个sid的，为null则全部推送
            	if(sid==null) {
            		item.sendMessage(message);
            	}else if(item.id.equals(sid)){
            		item.sendMessage(message);
            	}
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

	@Override
	public String toString() {
		return "WebSocketServer [session=" + session + ", id=" + id + "]";
	}
    
    
}
