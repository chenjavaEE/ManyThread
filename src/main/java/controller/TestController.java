package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author david
 * @Date 2020/3/28 21:10
 */

@Controller
public class TestController {
    
    //dddddddddddddd
    
    @GetMapping("test")
   
    public String test(){//ddddddddddddd

        System.out.println("1111111");
        return "2222222";
    }
}
