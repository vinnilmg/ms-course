package com.vinnilmg.hrapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String[] PUBLIC_PATHS = { "/hr-oauth/oauth/token" };
    private static final String[] OPERATOR_PATHS = { "/hr-worker/**" };
    private static final String[] ADMIN_PATHS = {
            "/hr-payroll/**", "/hr-user/**", "/actuator/**", "/hr-worker/actuator/**", "/hr-oauth/actuator/**", "/hr-oauth/users/**" };

    private static final String ADMIN_PROFILE = "ADMIN";
    private static final String OPERATOR_PROFILE = "OPERATOR";

    @Autowired
    private JwtTokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(PUBLIC_PATHS).permitAll()
                .antMatchers(OPERATOR_PATHS).hasAnyRole(OPERATOR_PROFILE, ADMIN_PROFILE)
                .antMatchers(ADMIN_PATHS).hasAnyRole(ADMIN_PROFILE)
                .anyRequest().authenticated();
    }
}
