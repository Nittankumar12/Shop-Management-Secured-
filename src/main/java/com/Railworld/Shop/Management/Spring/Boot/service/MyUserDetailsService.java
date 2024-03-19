package com.Railworld.Shop.Management.Spring.Boot.service;

import com.Railworld.Shop.Management.Spring.Boot.model.Admin;
import com.Railworld.Shop.Management.Spring.Boot.model.AdminPrincipal;
import com.Railworld.Shop.Management.Spring.Boot.repo.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Entered in loadbyusername");
        Admin admin  = adminRepository.findByaName(username);
        System.out.println(admin.toString());
        if(admin == null){
            System.out.println("admin not found");
            throw new UsernameNotFoundException(" Admin 404");
    }
        System.out.println("Found");
        return new AdminPrincipal(admin);
    }
}
