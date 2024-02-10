package in.techcamp.colorchartconnect.config;

import in.techcamp.colorchartconnect.domain.user.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

  @Autowired
  private UserDetailServiceImpl userDetailService;

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
                    .usernameParameter("username")
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
            .requestMatchers("/general").hasRole("GENERAL")
            .requestMatchers("/user/signup").permitAll()
            .requestMatchers("/signup").permitAll()
            .requestMatchers("/product/**").permitAll()
            .requestMatchers("/product/{product_id}").permitAll()
            .requestMatchers("/product/{product_id}/edit").permitAll()
            .anyRequest().authenticated()
    );
    return http.build();
  }


  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

      PasswordEncoder encoder = passwordEncoder();
//       //インメモリ認証
//       auth.inMemoryAuthentication()
//               .passwordEncoder(passwordEncoder())
//               .withUser("test")
//               .password(encoder.encode("password"))
//               .roles("GENERAL");

      //ユーザーデータ認証
      auth.userDetailsService(userDetailService).passwordEncoder(encoder);
  }
}