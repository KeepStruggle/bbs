package com.james.service.impl;

import com.james.mapper.MessageMapper;
import com.james.pojo.Message;
import com.james.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.8
 * @ClassName MessageServiceImpl
 * @Description TODO
 * @Author James
 * @date 2020/12/16 15:56
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> showAllByUid(int uid) {
        List<Message> messageList = messageMapper.showByTid(uid);
        return messageList;
    }

    @Override
    public Message findById(int id) {
        Message message = messageMapper.findById(id);
        return message;
    }

    @Override
    public boolean add(Message msg) {
        int row = messageMapper.addMessage(msg);
        if(row > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean del(int id) {
        int row = messageMapper.deleteMessage(id);
        if(row > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(int id) {

        Message message = new Message();
        message.setId(id);
        message.setState(0);
        if(messageMapper.updateMessage(message) > 0){
            return true;
        }
        return false;
    }
}
