package ch.hearc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
  @Autowired
  DataSource dataSource;
 
  @Autowired
  public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username,password, enabled from users where username=?")
        .authoritiesByUsernameQuery("select users.username, roles.name from users "
        		+ "inner join roles ON users.role_id = roles.id where users.username=?")
        .passwordEncoder(new BCryptPasswordEncoder());
  }
 
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/register", "/user/insert").permitAll()
    .antMatchers("/userItem/all", "/userItem/create", "/userItem/insert","/admin", "/user/all","/user/update").hasRole("ADMIN")
    .antMatchers("/userItem/all", "/userItem/create", "/userItem/insert").hasRole("TEACHER")
    .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();
    http.exceptionHandling().accessDeniedPage("/403");

    //http.authorizeRequests().antMatchers("/").permitAll();

  }
  
  @Bean
  BCryptPasswordEncoder passwordEncoder() {
  return new BCryptPasswordEncoder();
  }
}