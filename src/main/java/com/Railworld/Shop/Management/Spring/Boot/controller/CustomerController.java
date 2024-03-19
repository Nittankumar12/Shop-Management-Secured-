package com.Railworld.Shop.Management.Spring.Boot.controller;

import com.Railworld.Shop.Management.Spring.Boot.Dto.CustomerDto;
import com.Railworld.Shop.Management.Spring.Boot.model.Customer;
import com.Railworld.Shop.Management.Spring.Boot.service.CustomerService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    // USING CSRF TOKEN

//    @GetMapping("/getCsrf")
//    public CsrfToken getCsrf(HttpServletRequest request){
//        return (CsrfToken) request.getAttribute("_csrf");
//    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CustomerDto customerDto){
        customerService.register(customerDto);
        return ResponseEntity.ok("done");
    }
    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }

}
