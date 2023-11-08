package com.rungroop.web.controller;


import com.rungroop.web.dto.RegistrationDto;
import com.rungroop.web.models.UserEntity;
import com.rungroop.web.repository.ClubRepository;
import com.rungroop.web.repository.EventRepository;
import com.rungroop.web.service.Userservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    public AuthController(EventRepository eventRepository, ClubRepository clubRepository) {

    }
    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user,
                           BindingResult result, Model model) {
        UserEntity existingUserEmail = userservice.findByEmail(user.getEmail());
        if(existingUserEmail != null && existingUserEmail.getEmail() != null && !existingUserEmail.getEmail().isEmpty()){
            result.rejectValue("email", "There is aleady a user with this email/user");
        }
        UserEntity existingUserUserName = userservice.findByUserName(user.getUsername());
        if(existingUserUserName != null && existingUserUserName.getUsername() != null && !existingUserUserName.getUsername().isEmpty()){
            result.rejectValue("user", "There is aleady a user with this email/user");
        }

        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "register";
        }
        userservice.saveUser(user);
        return "redirect:/clubs?success";
    }
}
