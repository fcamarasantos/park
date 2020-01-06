package br.com.hackathonfc.park.util;

import br.com.hackathonfc.park.model.User;
import br.com.hackathonfc.park.repository.UserRepository;
import br.com.hackathonfc.park.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter extends BasicAuthenticationFilter {

    private TokenService tokenService;

    private UserDetailsService userDetailsService;

    private UserRepository userRepository;

    public AuthorizationFilter(AuthenticationManager authenticationManager, TokenService tokenService, UserDetailsService userDetailsService, UserRepository userRepository) {
        super(authenticationManager);
        this.tokenService = tokenService;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = tokenService.recuperarToken(request);

        boolean valid = tokenService.isTokenValid(token);

        if (valid) {
            UsernamePasswordAuthenticationToken auth = getAuthentication(request, token);
            if (auth != null)
                SecurityContextHolder.getContext().setAuthentication(auth);
        }

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request, String token){
            String username = tokenService.getUsername(token);
            UserDetails user = userDetailsService.loadUserByUsername(username);
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }
}
