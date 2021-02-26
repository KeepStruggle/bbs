package com.james.service;

import com.james.pojo.Message;

import java.util.List;

public interface MessageService {

    //根据用户编号显示收件的列表信息
    List<Message> showAllByUid(int uid);

    //根据消息id，查看具体消息信息
    Message findById(int id);

    //发送信息
    boolean add(Message msg);

    //根据消息id，删除信息
    boolean del(int id);

    //修改消息状态
    boolean update(int id);
}
