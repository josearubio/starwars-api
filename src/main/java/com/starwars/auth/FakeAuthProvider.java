package com.starwars.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by jaro on 26/07/17.
 */

@Service
public class FakeAuthProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String name = auth.getName();
        String pass = auth.getCredentials().toString();

        if(name.equals(pass)) {
            return new UsernamePasswordAuthenticationToken(name, pass, new ArrayList<>());
        }

        throw new BadCredentialsException("Incorrect User or Password");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}