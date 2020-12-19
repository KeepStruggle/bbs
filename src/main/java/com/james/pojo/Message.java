package com.james.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.8
 * @ClassName Message
 * @Description TODO
 * @Author James
 * @date 2020/12/15 22:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private int id;
    private int fid;
    private int tid;
    private String title;
    private String content;
    private int state;
    private String date;

    //private User fUser;
    //private User tUser;
}
