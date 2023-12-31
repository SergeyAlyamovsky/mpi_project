package cinema.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                    .disable()
                .authorizeRequests()
                	.antMatchers("/profile", "/addBookmark", "/removeBookmark").hasRole("USER")
                	.antMatchers("/css/**", "/images/**").permitAll()
                    .antMatchers("/registration").not().fullyAuthenticated()
                    .antMatchers("/catalog", "/film").permitAll()
                    .antMatchers("/h2", "/h2/**").permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/authorization")
                    .defaultSuccessUrl("/catalog")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                    .logoutSuccessUrl("/catalog")
                 .and()  
                    .headers()
                    .frameOptions()
                    .sameOrigin();
    }   
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
        throws Exception {
      auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());     
    }
}
