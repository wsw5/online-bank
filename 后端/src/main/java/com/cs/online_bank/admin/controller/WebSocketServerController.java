package com.cs.online_bank.admin.controller;
 import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cs.online_bank.admin.model.MsgVO;

@Component
@ServerEndpoint("/groupChat/{cid}/{userName}")
public class WebSocketServerController {

    /**
     * 房间号 -> 组成员信息
     */
    private static ConcurrentHashMap<Integer, List<Session>> groupMemberInfoMap = new ConcurrentHashMap<>();
    /**
     * 房间号 -> 在线人数
     */
    private static ConcurrentHashMap<Integer, Set<String>> onlineUserMap = new ConcurrentHashMap<>();

    /**
     * 收到消息调用的方法，群成员发送消息
     *
     * @param sid:房间号
     * @param userId：用户id
     * @param message：发送消息
     */
    @OnMessage
    public void onMessage(@PathParam("cid") Integer cid, @PathParam("userName") String userName, String message) {
        List<Session> sessionList = groupMemberInfoMap.get(cid);
        Set<String> onlineUserList = onlineUserMap.get(cid);
        System.out.println(sessionList.size());
        // 先一个群组内的成员发送消息
        sessionList.forEach(item -> {
            try {
                // json字符串转对象
                MsgVO msg = JSONObject.parseObject(message, MsgVO.class);
                msg.setCount(onlineUserList.size());
                // json对象转字符串
                String text = JSONObject.toJSONString(msg);
                item.getBasicRemote().sendText(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 建立连接调用的方法，群成员加入
     *
     * @param session
     * @param sid
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("cid") Integer cid, @PathParam("userName") String userName) {
        List<Session> sessionList = groupMemberInfoMap.computeIfAbsent(cid, k -> new ArrayList<>());
        Set<String> onlineUserList = onlineUserMap.computeIfAbsent(cid, k -> new HashSet<>());
        onlineUserList.add(userName);
        sessionList.add(session);
        System.out.println(sessionList.size());
        // 发送上线通知
        sendInfo(cid, userName, onlineUserList.size(), "");
    }


    public void sendInfo(Integer cid, String userName, Integer onlineSum, String info) {
        
        // 发送通知
        MsgVO msg = new MsgVO();
        msg.setCount(onlineSum);
        msg.setcId(cid);
        msg.setUserName(userName);
        msg.setMsg(info);
        // json对象转字符串
        String text = JSONObject.toJSONString(msg);
        onMessage(cid, userName, text);
    }

    /**
     * 关闭连接调用的方法，群成员退出
     *
     * @param session
     * @param sid
     */
    @OnClose
    public void onClose(Session session, @PathParam("cid") Integer cid, @PathParam("userName") String userName) {
        List<Session> sessionList = groupMemberInfoMap.get(cid);
        
        sessionList.remove(session);
        System.out.println(sessionList.size());
        Set<String> onlineUserList = onlineUserMap.get(cid);
        onlineUserList.remove(userName);
        // 发送离线通知
        sendInfo(cid, userName, onlineUserList.size(), "");
    }

    /**
     * 传输消息错误调用的方法
     *
     * @param error
     */
    @OnError
    public void OnError(Throwable error) {
        System.out.println("失败");
    }
}
