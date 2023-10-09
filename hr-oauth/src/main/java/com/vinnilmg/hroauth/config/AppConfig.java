package com.vinnilmg.hroauth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Slf4j
@RefreshScope
@Configuration
public class AppConfig {

    @Value("${jwt.secret}")
    private String jwtSecretKey;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        log.info("init bCryptPasswordEncoder");
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        log.info("init accessTokenConverter");
        var tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey(jwtSecretKey);
        return tokenConverter;
    }

    @Bean
    public JwtTokenStore tokenStore() {
        log.info("init tokenStore");
        return new JwtTokenStore(accessTokenConverter());
    }

}
