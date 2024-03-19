package com.Railworld.Shop.Management.Spring.Boot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class DemoController {
    @GetMapping("/")
    public ResponseEntity<String> home(HttpServletRequest request){
        return ResponseEntity.ok("Home called" + request.getSession().getId());
    }
}
