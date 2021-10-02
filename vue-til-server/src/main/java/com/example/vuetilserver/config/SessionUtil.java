package com.example.vuetilserver.config;

import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@NoArgsConstructor
public class SessionUtil {

    private static Optional<Authentication> getInfo(){
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
    }
    public static ExtendPrincipal getSession() {
        if(!SessionUtil.getInfo().isPresent()) {
            return new ExtendPrincipal();
        } else if(ExtendPrincipal.class.isAssignableFrom(SessionUtil.getInfo().get().getPrincipal().getClass())) {
            return (ExtendPrincipal) SessionUtil.getInfo().get().getPrincipal();
        } else {
            return new ExtendPrincipal();
        }
    }

    public static Long getUsername(){
        return SessionUtil.getSession().getKey();
    }
}
