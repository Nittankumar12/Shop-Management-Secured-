# Shop-Management-Secured-
Shop Management App using authorization and authentication of admin (by Configuration) and customer (by JWT token and filters)

For better view download the file or check the project


**Security Steps:- **




A. By validating csrf token on postman 
	1. Create a getMapping request in the controller.
	2. By providing authorization details on postman, send the request
	3. You'll get a Token and that token is used to validate your requests
	4. Add a header named "X-CSRF-TOKEN" as name and "token-value" in value



B. By using the Security Configuration
	1. Create a class SecurityConfiguration
	2. Use annotations @EnableWebSecurity and @Configuration
	3. Create a @Bean of SecurityFilterChain and return its object
	4. Firstly we have to disable CSRF token
	5. By using authorizeHttpRequests(), we make every request to be authenticated
	6. By using httpBasic(Customizer.withDefaults()), we configure the http basic request
	7. If we want that everytime we reload the page the session also change to maintain more security we use function sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	8. at last by using build(), we return the SecurityFilterChain object
	9. Now we can login by using two ways: static & dynamic

		a. STATIC
			1. Create a @Bean of UserDetailsService 
			2. We have to return InMemoryUserDetailsManager (Imp of UserDetailsService, which uses static username and password)
			3. Also for this you can set passwordEncoder() which encodes your password
			4. Set role and build() the object of it.
			5. Return the new InMemoryUserDetails()

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
    
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails = User.withDefaultPasswordEncoder().username("nittan").password("nittan").roles("user").build();
        return new InMemoryUserDetailsManager(userDetails);
    }

		b. DYNAMIC (username and password fetched from the database and password stored in database is encoded password)
			1. Comment out @Bean of UserDetailsService
			2. Create a @Bean of AuthenticationProvider which used to authenticate our user and also we can fetch our users from the database
			3. DaoAuthenticationProvider provides the methods -> setUserDetails() and setPasswordEncoder() so we return its object by creating the object 				of it by setting values in it. 
   
			4. @Autowire Properly your UserDetailsService and Create your own implementation of UserDetailsService
			5. Create MyUserDetailsService which implements UserDetails and implement its method loadUserByUsername()
			6. By using Jpa Dsl query find user by its name 
			7. If user found, then continue else return a exception that user is not found
			8. Then return the object of new class (also known as Principalclass or implementation class of UserDetails)
			9. Create a AdminPrincipal class or UserDetailsImplementation class which implements UserDetails
			10. Implement its methods and create a object of your User and then set values according to it by creating a constructor of it. 
			11. Aslo by using grantedAuthority we can provide roles to our user like USER,ADMIN.
			12. Create object of PasswordEncoder and pass it to the function where we setPasswordEncoder for it.
			13. Give request on postman and now you are able to acheive authorisation and authentication. 

