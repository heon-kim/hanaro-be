package org.conan.myboot.handler;

import com.google.gson.Gson;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.SubscriberDTO;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Log4j2
public class JWTCheckFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("-------------------JWTCheckFilter---------------------");
        String authHeaderStr = request.getHeader("Authorization");
        try{
            String accessToken = authHeaderStr.substring(7);
            Map<String, Object> claims = JWTUtil.validateToken(accessToken);

            log.info("JWT Claims:"+claims);
            String email = (String) claims.get("email");
            String pwd = (String) claims.get("pwd");
            String nickname = (String) claims.get("nickname");
            Boolean social = (Boolean) claims.get("social");
            List<String> roleNames = (List<String>) claims.get("roleNames");
            SubscriberDTO subscriberDTO = new SubscriberDTO(email, pwd, nickname, social.booleanValue(), roleNames);
            log.info("--------------------------------");
            log.info(subscriberDTO);
            log.info(subscriberDTO.getAuthorities());
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, pwd, subscriberDTO.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            filterChain.doFilter(request, response);
        }catch (Exception e){
            Gson gson = new Gson();
            String msg = gson.toJson(Map.of("error", "ERROR_ACCESS_TOKEN"));
            response.setContentType("application/json");
            PrintWriter pw = response.getWriter();
            pw.println(msg);
            pw.close();
        }
    }

    @Override
    protected boolean shouldNotFilter(@NonNull HttpServletRequest request) throws ServletException {
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        String path = request.getRequestURI();
        log.info("check url .................." + path);
        if (path.startsWith("/api/subscriber")) {
            return true;
        }
        return false;
    }

}
