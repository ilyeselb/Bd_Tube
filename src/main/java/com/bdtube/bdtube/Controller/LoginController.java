package com.bdtube.bdtube.Controller;

import com.bdtube.bdtube.Model.Account;
import com.bdtube.bdtube.Model.User;
import com.bdtube.bdtube.Repository.AccountRepository;
import com.bdtube.bdtube.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    AccountRepository ar;
   public static User user;
    @Autowired
    UserRepository ur;

    @GetMapping("/DoLogin/{u}/{password}")
    public User Dologin(@PathVariable String u, @PathVariable String password) {
        System.out.println(u);
        User us = new User();
        for (Account uu : ar.findAll()) {

            System.out.println(uu);
            if (uu.getUsername().equals(u)) {
                if (uu.getPassword().equals(password))
                   us=uu.getUser();

            }
        }

        System.out.println("loginnnnnnnnn");
        System.out.println(us);
        user= us ;
        return us;



    }

    @PostMapping ("/addacount/{u}/{password}")
    public void addaccount(@PathVariable String u, @PathVariable String password,@RequestBody User us ) {

       us.setHas_account(1);
       User uss= us;
       System.out.println(uss);
       ur.save(uss);
       Account ac = new Account(uss,password,u);
        System.out.println(ac);
        ar.save(ac);
    }

    @GetMapping("/userstatic")
    public User getuserstatic() {
        System.out.println("staticoupas");

        return user;
    }
    @GetMapping("/logout")
    public User logout() {
        System.out.println("logout");
        System.out.println(user);


        user=null;
        return user;
    }

     @GetMapping("/alluser")
    public List<User> alluser()

     { List<User> lu = new ArrayList <>();
         for(User u : ur.findAll())
         {
             if(u.getHas_account()==0)
             {
                 lu.add(u);
             }
         }
         return lu;
     }
    }





