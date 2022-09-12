/*
 *comprobara el token
se activará cada vez que un usuario no autenticado solicite un recurso HTTP
 */
package com.example.porfolio.jwt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint{

    
    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);
   
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
       logger.error("fallo el metodo commence");
       response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no autorizado");
    } 
}

