package com.frame.controller;

import com.frame.controller.controllermodel.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/start")
    public ResponseResult<Object> getStart(){
        String start = "hello world 2";
        return new ResponseResult<Object>(start);
    }



}
