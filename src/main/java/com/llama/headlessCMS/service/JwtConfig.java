package com.llama.headlessCMS.service;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

@Component
public class JwtConfig
{
    private final String salt="akdgsfmkljgnfkjgfd";
    private final int expire=60 *60 *24;

    private final SignatureAlgorithm sigAlg=SignatureAlgorithm.HS256;
    private final Key signingKey;


    public JwtConfig() {
        byte[] saltyBytes = DatatypeConverter.parseBase64Binary(salt);
        signingKey = new SecretKeySpec(saltyBytes, sigAlg.getJcaName());
    }
    public int getExpiration() {
        return expire;
    }

    public SignatureAlgorithm getSigAlg() {
        return sigAlg;
    }

    public Key getSigningKey() {
        return signingKey;
    }


}
