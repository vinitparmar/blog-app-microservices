package com.blog.api_gateway.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthFilter implements GlobalFilter {
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain){
		
		String path = exchange.getRequest().getURI().getPath();
		
		if(path.startsWith("/auth")) {
			return chain.filter(exchange);
		}
		
		
		String authHeader = exchange.getRequest()
				.getHeaders()
				.getFirst(HttpHeaders.AUTHORIZATION);
		
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
		
		try {
			Claims claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(authHeader.substring(7))
                    .getBody();

            exchange = exchange.mutate()
                    .request(r -> r.header(
                            "X-USER-ID",
                            claims.get("userId").toString()))
                    .build();
			
		}catch(Exception e){
			exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
		}
		
		return chain.filter(exchange);
	}

}
