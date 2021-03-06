package ma.enset.patientmvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

//tte classe avec cette annotation va etre instancier au 1er lieu
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /* la stratégie comment spring sec va chercher les users*/
        //ici comment spring sec va chercher les users & roles
        //BDD pour chercher un user ou des users mémoire ou annuaire LDAP
        //pour ne pas encoder les pwd {noop} ==>.password("{noop}123")
        // PasswordEncoder passwordEncoder = passwordEncoder();
        /*//mem auth
        String encodedPwd = passwordEncoder.encode("123");
        System.out.println(encodedPwd);
        auth.inMemoryAuthentication().withUser("user1").password(encodedPwd).roles("USER");
        auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("123")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("123")).roles("USER","ADMIN");*/

        //JDBC auth
     /*   auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username as principal, password as credentials, active from users where username =?")
                .authoritiesByUsernameQuery("select username as principal, role as role from users_roles where username=?")
                .rolePrefix("ROLE_")
                .passwordEncoder(passwordEncoder);*/

        PasswordEncoder passwordEncoder = passwordEncoder();
        String encodedPWD = passwordEncoder.encode("1234");
        System.out.println(encodedPWD);
        auth.inMemoryAuthentication().withUser("user1").password(encodedPWD).roles("USER");
        auth.inMemoryAuthentication().withUser("rabab").password(passwordEncoder.encode("Azerty2020")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("1234")).roles("USER", "ADMIN");

        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username as principal, password as credentials,active from users where username = ?")
                .authoritiesByUsernameQuery("select username as principal, role as users_roles from roles where username=?")
                .rolePrefix("ROLE_").passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //je demande à spring sec une formulaire d'auth
        /*pour une formulaire personnalisée
         *http.formLogin().loginPage("/login"); */
        http.formLogin();
        //ne nécessite pas une auth
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/user/**").hasRole("USER");
        http.authorizeRequests().antMatchers("/webjars/**").permitAll();
        /*gérer les droits d'accés*/
        //toutes les req nécessite une auth
        http.authorizeRequests().anyRequest().authenticated();
        //gestion des exceptions
        http.exceptionHandling().accessDeniedPage("/403");
    }

    @Bean
        //au démarrage crée moi un PasswordEncoder et tu le place dans context
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
