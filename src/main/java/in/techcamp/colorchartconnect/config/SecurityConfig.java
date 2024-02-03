package in.techcamp.colorchartconnect.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //ログイン時
    http.formLogin(login -> login
                    .loginProcessingUrl("/login")
                    .loginPage("/login")
                    .failureUrl("/login?error")
                    .usernameParameter("nickname")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/",true)
                    .permitAll()
            //ログアウト時
    ).logout(logout -> logout
                    .logoutSuccessUrl("/")
            //ログイン不要部分
    ).authorizeHttpRequests(authz -> authz
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
            .requestMatchers("/css/**").permitAll()
            .requestMatchers("/").permitAll()
            .requestMatchers("/user/signup").permitAll()
            .requestMatchers("/signup").permitAll()
            .requestMatchers("/product/**").permitAll()
            .requestMatchers("/product/{product_id}").permitAll()
            .requestMatchers("/product/{product_id}/edit").permitAll()
            .anyRequest().authenticated()
    );
    return http.build();
  }
}