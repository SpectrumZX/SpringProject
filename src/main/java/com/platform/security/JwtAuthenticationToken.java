package com.platform.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import javax.security.auth.Subject;
import java.security.Principal;
import java.util.Collection;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String token;
    private RawAccessJwtToken rawAccessToken;
  //  private UserContext userContext;
    JwtUtil util = new JwtUtil();
    User user;




    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token=token;
        user = util.parseToken(token);


    }

    public JwtAuthenticationToken(Collection<GrantedAuthority> authorities){
        super(null, null);

    }


    @Override
    public Object getCredentials() {
        if(user!=null) return user.getRole();

        return null;
    }

    @Override
    public Object getPrincipal() {
        if(user!=null) return new JwtPrincipal(user.getUsername());
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }

    public String getToken(){
        return this.token;
    }
}
