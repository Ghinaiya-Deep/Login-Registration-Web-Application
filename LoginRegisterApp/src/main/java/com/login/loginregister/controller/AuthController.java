package com.login.loginregister.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.login.loginregister.dto.LoginDto;
import com.login.loginregister.dto.UserDto;
import com.login.loginregister.entity.User;
import com.login.loginregister.service.UserService;

@Controller
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String showLoginForm(Model model, HttpSession session) {
        // Redirect to home if already logged in
        if (session.getAttribute("loggedInUser") != null) {
            return "redirect:/home";
        }
        model.addAttribute("loginDto", new LoginDto());
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginDto") LoginDto loginDto,
                       BindingResult result,
                       Model model,
                       HttpSession session) {
        
        if (result.hasErrors()) {
            return "login";
        }
        
        User user = userService.authenticateUser(loginDto);
        
        if (user == null) {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
        
        // Store user in session
        session.setAttribute("loggedInUser", user);
        
        return "redirect:/home";
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model, HttpSession session) {
        // Redirect to home if already logged in
        if (session.getAttribute("loggedInUser") != null) {
            return "redirect:/home";
        }
        model.addAttribute("user", new UserDto());
        return "register";
    }
    
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") UserDto userDto,
                              BindingResult result,
                              Model model) {
        
        if (userService.checkIfUserExists(userDto.getEmail())) {
            result.rejectValue("email", "error.user", "Email already registered");
        }
        
        if (result.hasErrors()) {
            return "register";
        }
        
        userService.registerUser(userDto);
        model.addAttribute("success", true);
        return "redirect:/login?success";
    }
    
    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        
        model.addAttribute("user", loggedInUser);
        return "home";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout";
    }
}