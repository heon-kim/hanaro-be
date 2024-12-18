package org.conan.myboot.handler;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.WeakKeyException;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

public class JWTUtil {
    private static String key = "1234567890123456789012345678901234567890";
    public static String generateToken(Map<String, Object> valueMap, int min){
        SecretKey key = null;
        try{
            key = Keys.hmacShaKeyFor(JWTUtil.key.getBytes("UTF-8"));
        }catch (WeakKeyException | UnsupportedEncodingException e){
            throw new RuntimeException(e.getMessage());
        }
        String jwtStr = Jwts.builder().setHeader(Map.of("typ", "JWT"))
                .setClaims(valueMap).setIssuedAt(Date.from(ZonedDateTime.now().toInstant()))
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(min).toInstant()))
                .signWith(key).compact();
        return jwtStr;
    }
    public static Map<String, Object> validateToken(String token){
        Map<String, Object> claim = null;
        SecretKey key;
        try{
            key = Keys.hmacShaKeyFor(JWTUtil.key.getBytes("UTF-8"));
            claim = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        }catch (WeakKeyException e){
            throw new CustomJWTException("WeakKeyException");
        }catch(UnsupportedEncodingException e){
            throw new CustomJWTException("UnsupportedEncodingException");
        }catch(MalformedJwtException malformedJwtException){
            throw new CustomJWTException("Malformed");
        }catch(ExpiredJwtException expiredJwtException){
            throw new CustomJWTException("Expired");
        }catch(InvalidClaimException invalidClaimException){
            throw new CustomJWTException("Invalid");
        }catch(JwtException jwtException){
            throw new CustomJWTException("JWT Error");
        }catch (Exception e){
            throw new CustomJWTException("Error");
        }
        return claim;
    }
}
