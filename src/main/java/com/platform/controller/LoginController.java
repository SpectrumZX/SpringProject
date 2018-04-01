package com.platform.controller;

import com.platform.TokenAuthentication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;



public class LoginController {

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
