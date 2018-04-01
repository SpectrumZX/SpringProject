package com.platform;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthentication {

  /*  TokenHandler tokenHandler = new TokenHandler();

    public void addAuthentication(HttpServletResponse response, SessionUser user) {
        Cookie cookie = new Cookie("access_token", tokenHandler.createAccessToken(user));
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(request.isSecure());
        response.addCookie(cookie);
    }*/

}
