package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")

public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        // if the password verify, go to user/index
        model.addAttribute("user", user);
        if (user.getPassword().equals(verify)){
            return "user/index";
        }
        model.addAttribute("error", "Password do not match!");
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email",user.getEmail());
        //if password does not verify, go back to the form
        return "user/add";
        }
    }
