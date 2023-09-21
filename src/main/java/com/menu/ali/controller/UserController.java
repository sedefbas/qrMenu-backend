package com.menu.ali.controller;

import com.menu.ali.Model.User;
import com.menu.ali.core.results.DataResult;
import com.menu.ali.core.results.Result;
import com.menu.ali.manager.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getAll() {
        return userService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<User> getById(@RequestParam int id) {
        return userService.getById(id);
    }
   @PutMapping("/update/password")
    public Result updatePassword(@RequestParam int id,@RequestParam String newPasssword){
        return userService.updateNewPassword(id,newPasssword);
    }




}
