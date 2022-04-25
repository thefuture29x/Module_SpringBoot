package com.example.module_javaspringboot_day19_01_jwt.jwt;

import com.example.module_javaspringboot_day19_01_jwt.service.CustomerUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {

    private final String JWT_SECRET = "seabreeze";
    private final Long JWT_EXPIRATION = 5*60*60L;
//    private final String HEADER_STRING = "autho";

    public String generateToken(CustomerUserDetails customerUserDetails){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        return Jwts.builder()
                .setSubject(Long.toString(customerUserDetails.getUserEntity().getId()))
                .setExpiration(expiryDate)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET)
                .compact();

    }

    public Long getUserIdFromJWT(String token, HttpServletRequest request){
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

}
