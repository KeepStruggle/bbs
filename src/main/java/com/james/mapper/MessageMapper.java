package com.james.mapper;

import com.james.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {

    //根据收件人Id查看所有历史信息消息
    List<Message> showByTid(int tid);

    //给消息表添加一条数据
    int addMessage(Message message);

    //根据消息id查看具体消息
    Message findById(int id);

    //根据消息id删除消息
    int deleteMessage(int id);

    //修改消息状态为已读，0
    int updateMessage(Message message);
}
