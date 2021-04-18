package bo.ucb.edu.covid_tracer_platform_backend.util.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/data/country/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/data/department//{isoDepartment}/download").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/api/v1/data/department/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/data/municipality/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/data/country/admin/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/data/department/{isoDepartment}/admin/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/data/municipality/{isoDepartment}/admin/{id}").hasRole("ADMIN")
                .anyRequest().authenticated()
                //.and().cors().disable();
                .and().cors().configurationSource(corsConfigurationSource());
                /*.and()
                .oauth2Login()
                .loginPage("/**//*auth");*/
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization", "responseType", "Content-Disposition", "ContenDisposition"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter(){
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
