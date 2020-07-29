package com.example.demo.controller;

import java.util.Map;

import com.example.demo.annotation.CurrentUser;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;

/**
 * SecurityController
 *
 * @author fyx
 * @date 2020/7/27
 *
 */
@Slf4j
@Controller
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private UserService userService ;

    /**
     * ������ҳ
     * @return String
     */
    @GetMapping("/index")
    public String root() {
        return "index";
    }

    @GetMapping("/toLogin")
    public String toLogin(Map<String, Object> map) {

        map.put("user", new User());

        return "login";
    }

    @ResponseBody
    @PostMapping(value="/login")
    public Boolean login(@RequestBody User user, Map<String, Object> map,
                         @CurrentUser UserInfo userInfo){

        //userInfo���û���¼��Ϣ
        log.info(userInfo.toString());

        if(userService.getById(user.getUserNo()) != null){
            User user1=userService.getById(user.getUserNo());
            if(user1.getUserPwd().equals(user.getUserPwd())){
                map.put("user",user1);
                return true;
            }
        }

        return false;
    }

    @GetMapping("/mainController/{userNo}")
    public String main(@PathVariable String userNo, Map<String, Object> map){
        map.put("user",userService.getById(userNo));
        return "main";
    }

    @GetMapping("/logout")
    public String logout(){

        return "redirect:/security/toLogin";

    }

}