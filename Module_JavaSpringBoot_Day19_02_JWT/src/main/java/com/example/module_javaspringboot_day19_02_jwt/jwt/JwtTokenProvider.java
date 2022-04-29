package com.example.module_javaspringboot_day19_02_jwt.jwt;

import com.example.module_javaspringboot_day19_02_jwt.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.SignatureException;
import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider{
    @Value("${jwt.app.JWT_SECRET}")
    private String JWT_SECRET;
//    @Value("${jwt.app.JWT_EXPIRATION}")
    @Value("${bezkoder.app.jwtExpirationMs}")
//    private Long JWT_EXPIRATION;
    private Long JWT_EXPIRATION;

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    public String generateToken(UserDetailsImpl customerUserService){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        return Jwts.builder()
                .setSubject(Long.toString(customerUserService.getUserEntity().getId()))
                .setExpiration(expiryDate)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET)
                .compact();
    }
    public String generateTokenFormUserName(String username){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiryDate)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET)
                .compact();
    }
    public String getUserIdFromJWT(String token, HttpServletRequest request){
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
//    public Long getUserIdFromJWT(String token, HttpServletRequest request){
//        Claims claims = Jwts.parser()
//                .setSigningKey(JWT_SECRET)
//                .parseClaimsJws(token)
//                .getBody();
//        String username = claims.getSubject();
//        return Long.parseLong(claims.getSubject());
//    }

    public Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + JWT_EXPIRATION);
    }

    public Claims getClaimsFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().after(new Date());
    }

    public String getUserNameFromJwtToken(String token) {
        Claims claims = getClaimsFromJwtToken(token);
        if (claims != null && isTokenExpired(claims)) {
            return claims.getSubject();
        }
        return null;
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
