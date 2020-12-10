package com.james.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @version 1.8
 * @ClassName HelloController
 * @Description TODO
 * @Author James
 * @date 2020/12/11 0:15
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String Hello(){
        return "index";
    }
}
