package com.james.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @version 1.8
 * @ClassName User
 * @Description TODO
 * @Author James
 * @date 2020/12/15 0:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int uid;
    private String uname;
    private String upwd;
    private String email;

    //private List<Message> messageList;   //记录每个人可以收到很多条信息
}
