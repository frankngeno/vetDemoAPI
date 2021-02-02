package com.vetInfor.controller;

import com.vetInfor.dao.LocationRepo;
import com.vetInfor.dao.UserRepo;
import com.vetInfor.model.Location;
import com.vetInfor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private LocationRepo locationRepo;

    @GetMapping("/users")
    public List<User> users(){

        return userRepo.findAll();
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @GetMapping("users/{id}") // particular user
    public ResponseEntity<User> userById(@PathVariable Long id) throws Exception{
       User user=userRepo.findById(id).orElseThrow(() -> new Exception("User not found with "+id));
       return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/users/{id}") //delete
    public Map<String, Boolean> deleteUser(@PathVariable Long id) throws Exception{
        User user=userRepo.findById(id).orElseThrow(() -> new Exception("User not found with "+ id));
        userRepo.delete(user);
         Map<String, Boolean> response = new HashMap<>();
         response.put("delete success", Boolean.TRUE);
         return response;

    }

    @PutMapping("/users/{id}")
    //@Transactional
    public ResponseEntity <User> updateUser(@PathVariable Long id, @RequestBody User userDetail) throws Exception {
        User user=userRepo.findById(id).orElseThrow(() -> new Exception("User not found with "+ id));
        user.setUsername(userDetail.getUsername());
        user.setLastName(userDetail.getLastName());
        user.setEmail(userDetail.getEmail());
        userRepo.save(userDetail);
        return ResponseEntity.ok().body(userDetail);
    }


}
