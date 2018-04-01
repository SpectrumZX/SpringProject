package com.platform.controller;

import com.mysql.cj.core.util.StringUtils;
import com.platform.db.dao.UserDAO;
import com.platform.db.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/manage")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @GetMapping(value = "/users")
    @ResponseBody
    public ResponseEntity allUsers() {
        List<UserEntity> usrList = UserDAO.findAll();
        return new ResponseEntity(usrList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/users/{user_id}")
    @ResponseBody
    public ResponseEntity getUserById(@PathVariable("user_id") Integer user_id) {
        UserEntity user = UserDAO.findById(user_id);
        if (user == null) return new ResponseEntity("user not found", HttpStatus.NOT_FOUND);
        ResponseEntity response = new ResponseEntity(user, HttpStatus.OK);
        return response;
    }
    @DeleteMapping(value = "/users/{user_id}")
    @ResponseBody
    public ResponseEntity deleteUserById(@PathVariable("user_id") Integer user_id) {
        UserEntity user = UserDAO.findById(user_id);
        if (user==null) return new ResponseEntity("User #"+ user_id +" not found", HttpStatus.NOT_FOUND);
        if (UserDAO.removeUser(user)) return new ResponseEntity("User was deleted. id:" + user.getId(), HttpStatus.OK);
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PostMapping(value = "/users")
    public ResponseEntity addUser(@RequestBody UserEntity jsonUser) {
        UserEntity userRes = UserDAO.findByName(jsonUser.getUserName());
        if(userRes!=null)
            return new ResponseEntity("UserName "+ jsonUser.getUserName() +" already exists", HttpStatus.BAD_REQUEST);
        UserDAO.addUser(jsonUser);
        return new ResponseEntity("Item was added successfully", HttpStatus.OK);

    }

    @PutMapping(value = "/users")
    public ResponseEntity updateUser(@RequestBody UserEntity jsonUser) {
        if(jsonUser.getId()==null)
            return new ResponseEntity("UserID is required", HttpStatus.BAD_REQUEST);
        UserEntity userRes = UserDAO.findById(jsonUser.getId());
        if(userRes==null)
            return new ResponseEntity("User #"+ jsonUser.getId() +" don't exists", HttpStatus.BAD_REQUEST);
        UserDAO.update(jsonUser);
        return new ResponseEntity("Item #"+ jsonUser.getId() +" was updated successfully", HttpStatus.OK);

    }
}