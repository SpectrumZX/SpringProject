package com.platform.controller;

import com.platform.TokenAuthentication;
import com.platform.db.dao.PostDAO;
import com.platform.db.entity.PostEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/login")

public class LoginController {


    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/signup")
    @ResponseBody
    public ResponseEntity login() {
        return new ResponseEntity(null, HttpStatus.OK);
    }

 /*   TokenAuthentication tokenAuthenticationService = new TokenAuthentication();

    @RequestMapping(value = "/login", produces = "application/json", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void login(HttpServletResponse response) {
        SessionUser user = (SessionUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        tokenAuthenticationService.addAuthentication(response, user);
    }
*/
// SessionUser - реализация UserDetails
// https://docs.spring.io/spring-security/site/docs/current/apidocs/org/springframework/security/core/userdetails/UserDetails.html"

}
