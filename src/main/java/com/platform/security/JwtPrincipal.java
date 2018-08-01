package com.platform.security;


import java.security.Principal;

public class JwtPrincipal implements Principal {

    private String name;

    public JwtPrincipal(String name){
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }
}
