package com.Railworld.Shop.Management.Spring.Boot.controller;

import com.Railworld.Shop.Management.Spring.Boot.Dto.AddSweetDto;
import com.Railworld.Shop.Management.Spring.Boot.Dto.AdminDto;
import com.Railworld.Shop.Management.Spring.Boot.Dto.ExpenseDto;
import com.Railworld.Shop.Management.Spring.Boot.model.Admin;
import com.Railworld.Shop.Management.Spring.Boot.model.Expense;
import com.Railworld.Shop.Management.Spring.Boot.model.Sweet;
import com.Railworld.Shop.Management.Spring.Boot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody AdminDto adminDto ){
        System.out.println("Entered Controller");
        return adminService.register(adminDto);
    }

    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable int id){
        return adminService.getAdmin(id);
    }
    @PostMapping("/addSweet")
    public Sweet addSweet( @RequestBody AddSweetDto addSweetDto){
        return adminService.addSweet(addSweetDto);
    }
    @GetMapping("/getSweets")
    public List<Sweet> getSweets(){
        return adminService.getSweets();
    }

    @PutMapping("/updateSweet")
    public Sweet updateSweet(@RequestBody AddSweetDto addSweetDto){
        return adminService.addSweet(addSweetDto);
    }

    @PostMapping("/addExpense")
    public void addExpense(@RequestBody ExpenseDto expenseDto){
        adminService.addExpense(expenseDto.getSweet_id(), expenseDto.getSweet_quantity(),expenseDto.getSweet_cost());
    }

    @GetMapping("/getExpenses")
    public List<Expense> getExpenses(){
        return adminService.getExpenses();
    }

    @PutMapping("/updateExpense")
    public Expense updateExpense(@PathVariable int id, @RequestBody ExpenseDto expenseDto){
        return adminService.updateExpense(id,expenseDto);
    }
}
