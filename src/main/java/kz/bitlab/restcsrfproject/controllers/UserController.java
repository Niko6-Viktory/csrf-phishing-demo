package kz.bitlab.restcsrfproject.controllers;

import jakarta.servlet.http.HttpServletRequest;
import kz.bitlab.restcsrfproject.entities.User;
import kz.bitlab.restcsrfproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class UserController {

    @GetMapping("/fishTrap")
    public String fishTrap() {
        return "fishTrap";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login-page")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login-form")
    @ResponseBody
    public String loginFromForm(@RequestParam String email,
                                @RequestParam String password,
                                HttpServletRequest request) {
        User foundedUser = userRepository.findAllByEmail(email);
        if (foundedUser != null && password.equals(foundedUser.getPassword())) {
            request.getSession().setAttribute("value", foundedUser);
            return "success";
        }
        return "failure";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody User reqUser,
                        HttpServletRequest request){
        User foundedUser = userRepository.findAllByEmail(reqUser.getEmail());
        if (foundedUser != null && reqUser.getPassword().equals(foundedUser.getPassword())){
//            if (reqUser.getPassword().equals(foundedUser.getPassword())){
            request.getSession().setAttribute("value", foundedUser);
            return "success";
//            }
        }
        return "failure";
    }


    @PostMapping("/update-password")
    @ResponseBody
    public String updatePassword(@RequestParam("newPassword") String newPassword,
                                 HttpServletRequest request) {

        User currentUser = (User) request.getSession().getAttribute("value");

        if (currentUser != null) {
            currentUser.setPassword(newPassword);
            userRepository.save(currentUser);

            System.out.println("CSRF УСПЕШНА: Пароль изменен для " + currentUser.getEmail());
            return "Password updated successfully to: " + newPassword;
        }

        return "Error: No session found!";
    }
}