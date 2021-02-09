package com.example.demo.config;

import com.example.demo.security.RestAuthenticationEntryPoint;
import com.example.demo.security.TokenAuthenticationFilter;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	// Implementacija PasswordEncoder-a koriscenjem BCrypt hashing funkcije.
		// BCrypt po defalt-u radi 10 rundi hesiranja prosledjene vrednosti.
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

		// Servis koji se koristi za citanje podataka o korisnicima aplikacije
		@Autowired
		private CustomUserDetailsService jwtUserDetailsService;

		// Handler za vracanje 401 kada klijent sa neodogovarajucim korisnickim imenom i lozinkom pokusa da pristupi resursu
		@Autowired
		private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

		// Registrujemo authentication manager koji ce da uradi autentifikaciju korisnika za nas
		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}

		// Definisemo uputstvo za authentication managera koji servis da koristi da izvuce podatke o korisniku koji zeli da se autentifikuje,
		//kao i kroz koji enkoder da provuce lozinku koju je dobio od klijenta u zahtevu da bi adekvatan hash koji dobije kao rezultat bcrypt algoritma uporedio sa onim koji se nalazi u bazi (posto se u bazi ne cuva plain lozinka)
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
		}

		// Injektujemo implementaciju iz TokenUtils klase kako bismo mogli da koristimo njene metode za rad sa JWT u TokenAuthenticationFilteru
		@Autowired
		private TokenUtils tokenUtils;

		// Definisemo prava pristupa odredjenim URL-ovima
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					// komunikacija izmedju klijenta i servera je stateless posto je u pitanju REST aplikacija
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

					// sve neautentifikovane zahteve obradi uniformno i posalji 401 gresku
					.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()

					// svim korisnicima dopusti da pristupe putanjama /auth/**, (/h2-console/** ako se koristi H2 baza) i /api/foo
					.authorizeRequests().antMatchers("/users/login").permitAll()
					.antMatchers("/users/register").permitAll()
					.antMatchers("/pharmacies/**").permitAll()
					.antMatchers("/appointments/**").permitAll()
					.antMatchers("/appointmentTypes/**").permitAll()
					.antMatchers("/appointmentStatuses/**").permitAll()
					.antMatchers("/medicine/**").permitAll()
					.antMatchers("/medicineIngredients/**").permitAll()
					.antMatchers("/medicineReservation/**").permitAll()
					.antMatchers("/pharmacists/**").permitAll()
					.antMatchers("/dermatologists/**").permitAll()
					.antMatchers("/patients/**").permitAll()
					.antMatchers("/doctors/**").permitAll()
					.antMatchers("/vacations/**").permitAll()
					.antMatchers("/reports/**").permitAll()
					//.antMatchers("/**").permitAll()

					.antMatchers("/pharmacyAdmins/**").permitAll()
					.antMatchers("/**").permitAll().and()

					// za svaki drugi zahtev korisnik mora biti autentifikovan
					//.anyRequest().authenticated().and()

					// za development svrhe ukljuci konfiguraciju za CORS iz WebConfig klase
					.cors().and()
				
					// umetni custom filter TokenAuthenticationFilter kako bi se vrsila provera JWT tokena umesto cistih korisnickog imena i lozinke (koje radi BasicAuthenticationFilter)
					.addFilterBefore(new TokenAuthenticationFilter(tokenUtils, jwtUserDetailsService),
							BasicAuthenticationFilter.class);
			// zbog jednostavnosti primera
			http.csrf().disable();
		}

		// Generalna bezbednost aplikacije
		@Override
		public void configure(WebSecurity web) throws Exception {
			// TokenAuthenticationFilter ce ignorisati sve ispod navedene putanje
			web.ignoring().antMatchers(HttpMethod.POST, "/users/login");
			web.ignoring().antMatchers(HttpMethod.POST, "/users/register");
			web.ignoring().antMatchers(HttpMethod.GET, "/", "/webjars/**", "/*.html", "/favicon.ico", "/**/*.html",
					"/**/*.css", "/**/*.js");
		}
}
