package com.danielsoo.blog_daniel.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danielsoo.blog_daniel.web.dto.HelloResponseDto;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloJson(@RequestParam("name") String name, @RequestParam("amount") int amount){
        HelloResponseDto helloResponseDto = new HelloResponseDto(name, amount);
        return helloResponseDto;
    }


}
