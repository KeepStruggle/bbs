package com.james.mapper;

import com.james.pojo.Message;

import java.util.List;

public interface MessageMapper {

    //根据收件人Id查看所有历史信息消息
    List<Message> showByTid(int Tid);

    //给消息表添加一条数据
    int add(Message message);

    //根据消息id查看具体消息
    Message findById(int id);

    //根据消息id删除消息
    int delete(int id);
}
