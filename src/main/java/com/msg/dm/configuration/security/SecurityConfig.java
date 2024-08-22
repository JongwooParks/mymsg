package com.msg.dm.configuration.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@Slf4j
public class SecurityConfig {
    /**
     * 이 메서드는 정적 자원에 대해 보안을 적용하지 않도록 설정한다.
     * 정적 자원은 보통 HTML, CSS, JavaScript, 이미지 파일 등을 의미하며, 이들에 대해 보안을 적용하지 않음으로써 성능을 향상시킬 수 있다.
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("X-Requested-With", "Content-Type", "Authorization", "X-XSRF-token"));
        configuration.setAllowCredentials(false);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    /**
     * Spring Security 설정을 정의하는 메서드.
     * <ul>
     *     <li>CSRF 방지 기능 비활성화</li>
     *     <li>CORS 설정 적용</li>
     *     <li>`/resources/**`, `/main/rootPage` 경로 접근 허용</li>
     *     <li>나머지 요청은 인증된 사용자만 접근 허용</li>
     *     <li>헤더의 JWT 토큰을 추출하고 검증하는 `JwtAuthorizationFilter` 적용</li>
     *     <li>세션을 상태 없이 관리</li>
     *     <li>로그인 페이지 설정 및 로그인 성공 시 리다이렉트 경로 설정</li>
     *     <li>사용자 이름과 비밀번호 인증을 위한 `CustomAuthenticationFilter` 적용</li>
     * </ul>
     *
     * @param http Spring Security의 HttpSecurity 객체
     * @return 구성된 SecurityFilterChain 객체
     * @throws Exception 설정 중 발생할 수 있는 예외
     */


    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http
    )throws Exception{
        log.info("WebSecurityConfig Start!!");
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(req ->
                        req
                            .requestMatchers("/sign/**","/auth/**").permitAll()
                            .anyRequest().authenticated()
                )
                .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
