package com.Railworld.Shop.Management.Spring.Boot.service;


import com.Railworld.Shop.Management.Spring.Boot.Dto.AddSweetDto;
import com.Railworld.Shop.Management.Spring.Boot.Dto.AdminDto;
import com.Railworld.Shop.Management.Spring.Boot.Dto.ExpenseDto;
import com.Railworld.Shop.Management.Spring.Boot.model.Admin;
import com.Railworld.Shop.Management.Spring.Boot.model.Expense;
import com.Railworld.Shop.Management.Spring.Boot.model.Sweet;
import com.Railworld.Shop.Management.Spring.Boot.repo.AdminRepository;
import com.Railworld.Shop.Management.Spring.Boot.repo.ExpenseRepository;
import com.Railworld.Shop.Management.Spring.Boot.repo.SweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private SweetRepository sweetRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public Admin register(AdminDto adminDto){
        Admin admin = new Admin();
//        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        System.out.println("Before encoded: " + adminDto.getAdminName() + " " + adminDto.getAdminPassword());
        admin.setAPassword(encoder.encode(adminDto.getAdminPassword()));
        System.out.println("after: " + admin.getAPassword());
        admin.setAName(adminDto.getAdminName());
        System.out.println(admin.getAPassword());
        return adminRepository.save(admin);
    }

    public Admin getAdmin(int id){
        Optional<Admin> admin = adminRepository.findById(id);
        return admin.get();
    }

    public Sweet addSweet(AddSweetDto addSweetDto) {
        Sweet sweet = sweetRepository.findBysName(addSweetDto.getSweetName());
        if(sweet == null){
            sweet = new Sweet();
            sweet.setSQuantity(addSweetDto.getSweetQuantity());
            sweet.setSCost(addSweetDto.getSweetCost());
            sweet.setSName(addSweetDto.getSweetName());
            sweetRepository.save(sweet);
            int id = sweetRepository.findBysName(sweet.getSName()).getSId();
            addExpense(id,addSweetDto.getSweetQuantity(),addSweetDto.getSweetCost());
        }
        int vq = addSweetDto.getSweetQuantity() -  sweet.getSQuantity();
        int vc = addSweetDto.getSweetCost() - sweet.getSCost();

        sweet.setSQuantity(addSweetDto.getSweetQuantity());
        sweet.setSCost(addSweetDto.getSweetCost());
        sweet.setSName(addSweetDto.getSweetName());
        sweetRepository.save(sweet);
        int id = sweetRepository.findBysName(sweet.getSName()).getSId();
        addExpense(id,vq,vc);
        return sweetRepository.findById(id).get();
    }

    public List<Sweet> getSweets() {
        return sweetRepository.findAll();
    }

    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

     public void addExpense(int sId, int sQuantity, int sCost){
        Expense expense = new Expense();
        expense.setExpenseAmount(sCost * sQuantity);
        expense.setSweetQuantity(sQuantity);
        expense.setSweetId(sId);
        expenseRepository.save(expense);
    }
    public Expense updateExpense(int id, ExpenseDto expenseDto) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense == null) return null;
        optionalExpense.get().setExpenseAmount(expenseDto.getSweet_cost() * expenseDto.getSweet_quantity());
        optionalExpense.get().setSweetQuantity(expenseDto.getSweet_quantity());
        optionalExpense.get().setSweetId(expenseDto.getSweet_id());
        return optionalExpense.get();
    }
}
