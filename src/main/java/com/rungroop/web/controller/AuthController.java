package com.rungroop.web.controller;
import com.rungroop.web.dto.RegistrationDto;
import com.rungroop.web.models.UserEntity;
import com.rungroop.web.service.Userservice;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private Userservice userservice;
    public AuthController(Userservice userservice) {
        this.userservice = userservice;
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        RegistrationDto newuser = new RegistrationDto();
        model.addAttribute("newuser", newuser);
        return "register";
    }

    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user")RegistrationDto user,
                           BindingResult result, Model model) {
        System.out.println("==============================");
        System.out.println(user);
        UserEntity existingUserEmail = userservice.findByEmail(user.getEmail());
        System.out.println(existingUserEmail);
        System.out.println("Existing user");
        if(existingUserEmail != null && existingUserEmail.getEmail() != null && !existingUserEmail.getEmail().isEmpty()) {
            return "redirect:/register?fail";
        }
        UserEntity existingUserUsername = userservice.findByUserName(user.getUsername());
        if(existingUserUsername != null && existingUserUsername.getUsername() != null && !existingUserUsername.getUsername().isEmpty()) {
            return "redirect:/register?fail";
        }
        if(result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        System.out.println(user);
        userservice.saveUser(user);
        return "redirect:/?success";
    }
}
