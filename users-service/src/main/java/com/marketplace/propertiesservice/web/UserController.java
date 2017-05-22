package com.marketplace.propertiesservice.web;

import com.marketplace.propertiesservice.backend.UserService;
import com.marketplace.propertiesservice.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        user.setId(null);
        return userService.create(user);
    }

    @PutMapping
    @ResponseBody
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("{userId}")
    @ResponseBody
    public User get(@PathVariable String userId) {
        return userService.get(userId);
    }

    @DeleteMapping("{userId}")
    public void delete(@PathVariable String userId) {
        userService.delete(userId);
    }
}
