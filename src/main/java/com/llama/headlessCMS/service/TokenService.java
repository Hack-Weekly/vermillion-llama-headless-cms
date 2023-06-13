package com.llama.headlessCMS.service;
import com.llama.headlessCMS.dto.Principal;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class TokenService {

    @Autowired
    private JwtConfig jwtConfig;
    TokenService(){
        super();
    }

    TokenService(JwtConfig jwt1)
    {
        this.jwtConfig=jwt1;
    }

    public String generateToken(Principal subject)
    {
        Instant now=Instant.now();
        JwtBuilder jwt=Jwts.builder()
                .setSubject(subject.getUsername())
                .setId(subject.getId())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(600, ChronoUnit.MINUTES)))
                .setIssuer("vermillonLlama")
                .claim("role",subject.getRole())
                .signWith(jwtConfig.getSigAlg(), jwtConfig.getSigningKey());


        return (jwt.compact());
    }

}
