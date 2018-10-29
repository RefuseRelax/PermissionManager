/**
 * 
 */
package com.yy.pm.websocket;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import com.yy.pm.config.WSGetHttpSessionConfigurator;
import com.yy.pm.vo.InfoUserVO;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint(value="/websocket",configurator=WSGetHttpSessionConfigurator.class)
public class WebSocketService {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<WebSocketService> webSocketSet = new CopyOnWriteArraySet<WebSocketService>();
    
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    
    //获取用户会话
    private HttpSession httpSession;
    
    private InfoUserVO infoUserVO;
    
    private ServletContext context;

    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session,EndpointConfig endpointConfig){
    	this.httpSession = (HttpSession)endpointConfig.getUserProperties().get(HttpSession.class.getName());
    	this.context = httpSession.getServletContext();
        this.session = session;
        this.infoUserVO = ((InfoUserVO)httpSession.getAttribute("loginUser"));
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
        onOnlineMessage(""+getOnlineCount(),session);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);  //从set中删除
        String username = ((InfoUserVO)httpSession.getAttribute("loginUser")).getUsername();
        Map<String,InfoUserVO> map = (Map<String,InfoUserVO>)context.getAttribute("logined");
		map.remove(username);
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
        onOnlineMessage(""+getOnlineCount(),session);
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
    
//    @OnMessage
//    public void onMessage(String message, Session session) {
//        System.out.println("来自客户端的消息:" + message);
//        if(session.getId().equals("0")){ 
//	        //群发消息
//	        for(WebSocketTest item: webSocketSet){
//	        	if(item.session.getId().equals("1")){
//		            try {
//		                item.sendMessage(message);
//		                break;
//		            } catch (IOException e) {
//		                e.printStackTrace();
//		                continue;
//		            }
//	            }
//	        }
//        }else{
//        	//群发消息
//	        for(WebSocketTest item: webSocketSet){
//	        	if(item.session.getId().equals("0")){
//		            try {
//		                item.sendMessage(message);
//		                break;
//		            } catch (IOException e) {
//		                e.printStackTrace();
//		                continue;
//		            }
//	            }
//	        }
//        }
//    }
     */
   
    
    
    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息 登录人数
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
    	//System.out.println("来自客户端的消息:" + message);
    	onProcessMessage(message,httpSession,infoUserVO);
    }
    
    public void onOnlineMessage(String message, Session session){
    	System.out.println("来自人数的消息:" + message);
        //群发消息
        for(WebSocketService item: webSocketSet){
            try {
                item.sendMessage(""+onlineCount);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }
    
    
    public void onProcessMessage(String message, HttpSession session,InfoUserVO vo) {
        System.out.println("来自客户端的消息:" + message);
        //群发消息
        for(WebSocketService item: webSocketSet){
               String username =  item.getInfoUserVO().getUsername();
               if("admin".equals(username)){
            	   try {
						item.sendAsyncMessage(message);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	   break;
               }
            
        }
    }
    

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);;
        //this.session.getAsyncRemote().sendText(message);
    }
    
    public void sendAsyncMessage(String message) throws IOException{
       // this.session.getBasicRemote().sendText(message);;
        this.session.getAsyncRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketService.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketService.onlineCount--;
    }

	public HttpSession getHttpSession() {
		return httpSession;
	}

	public void setHttpSession(HttpSession httpSession) {
		this.httpSession = httpSession;
	}

	public InfoUserVO getInfoUserVO() {
		return infoUserVO;
	}

	public void setInfoUserVO(InfoUserVO infoUserVO) {
		this.infoUserVO = infoUserVO;
	}
    
}
