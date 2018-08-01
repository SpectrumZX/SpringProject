package com.platform;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TokenHandler {

/*    String createAccessToken(SessionUser user) {

        String refreshToken = UUID.randomUUID().toString();
        final Date now = new Date();

        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("USER_ID", String.valueOf(user.getUserId()));
     //   claims.put(AUTHORITIES, StringUtils.join(user.getAuthorities(), ','));
        return Jwts.builder()
                .setClaims(claims)
                .setId(refreshToken)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + TimeUnit.MINUTES.toMillis(10L)))
                .signWith(SignatureAlgorithm.HS512, "some-random-secret-key")
                .compact();
    }
*/
}
