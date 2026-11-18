package com.example.docker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller 
public class GreetingController {

    @GetMapping("/")
    public String showHomepage(){
        return "index";
    }

    @PostMapping("/greet")
    public String greetUser(@RequestParam ("name") String name, Model model){
        String cleanedName = name.trim();
        if(cleanedName.isEmpty()){
            model.addAttribute("error","Please enter your name ...");
            return "index";
        }
        model.addAttribute("name",cleanedName);
        return "greeting";
    }
    
    
}
