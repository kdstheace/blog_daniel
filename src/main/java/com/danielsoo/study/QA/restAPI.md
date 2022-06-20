
1)에외 만들 때 다음 두개의 차이를 설명하시오.
```java
class A {
    private String message;
    public A(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}

class B {
    private String message;
    public B(String message){
        super(message);
    }
    public String getMessage(){
        return this.message;
    }
}

throw new A("hello"); > a.getMessage()?
throw new B("hello"); > b.getMessage()?
```

답: 글로벌 핸들러로 Exception으로 받을 때 A는 a.getMessage()하면 A를 생성할때 파라미터로 지정한 메시지가 노출되지만,
B의 경우 b.getMessage()하면 null이 나온다. 본래 getMessage()는 Throwable의 detailMessage라는 필드의 리터럴을 반환하지만  
오버라이딩된 getMessage()에서는 상속한 Exception의 getMesage()를 반환하기 때문이다.
따라서 getMessage()를 오버라이딩 할 경우, 필드변수를 불러오고 그 값은 null이므로
super()안에 메시지를 정의해주기 보단, 직접 message를 인스턴스 변수로 만들자.

#Spring Security
1. CSRF TOKEN이란? 작동원리
   1. ANTMATCHERS, MVCMATCHERS?
   2. Spring Configuration을 하지 않으면 디폴트로 
      1) user, 비번을 주고
      2) 모든 url에 대해 필터링을 하며(인증)
      3) CSRF TOKEN을 끼워넣는다.

      따라서, 스프링시큐리티 설정을 해줘야하는데, 이를 위해서는 설정 클래스를 만들어
      1) @Configuration
      2) @EnableWebSecurity
      3) WebSecurityConfigurerAdapter클래스 상속받는다.
      4) configure()을 오버라이딩한다.

      여기서 사용되는 체인 메소드로
      1) http.authorizeRequests(): 메소드로 특정 경로에 특정 권한을 가진 사용자만 접근할 수 잇도록 함
      2) 경로를 특정해서 권한 설정하는 메소드<br>
            mvcMatchers(): /info 하면 /info 경로와 매칭<br>
            antMatchers(): /info 하면 /info/, /info.html 경로와 매칭
      3) http.formLogin(): 인증이 필요한 요청은 SS사용하는 기본 로그인폼을 사용<br>
         http.httpBasic(): http basic authentication사용(팝업형태)
         * 이 둘의 차이는 단순히 형태만아 아니라 "http헤더로 인증이 가능한지 여부"도 있다.
   
      이 때, RestfulAPI에서 같은 경로이지만 메소드로 구분하는 경우
      1) @EnableGlobalMethodSecurity을 활성화해서
      2) .authorizeRequests()
         .antMatchers(HttpMethod.GET, "/api/**").permitAll() // allUser에게 허용
      3) (prePostEnabled = true): @PreAuthorize어노테이션 활성화
         여러 역할에 대한 분담을 하고 싶으면 @PreAuthorize 하나만 하려면 @Secured로 충분
      4) @PreAuthorize("hasRole('ADMIN')") : 컨트롤러 메소드에 붙이면 이 권한만 허용한다는 뜻

      패스워드 인코더를 이용해 In-Memory계정만들기
      ```java
       @Bean
       PasswordEncoder passwordEncoder(){
           return new BCryptPasswordEncoder();
       }
   
       @Override
       @Bean
       protected UserDetailsService userDetailsService() {
           UserDetails dongsoo = User.builder().username("dongsoo")
               .password(passwordEncoder().encode("pw")).roles("USER").build();
           UserDetails admin = User.builder().username("admin")
               .password(passwordEncoder().encode("admin")).roles("ADMIN").build();
           //encoded format of pw
           return new InMemoryUserDetailsManager(dongsoo, admin);
       }

   
2. ManyToMany연관관계 매핑
   1. 테이블 하나를 끼워서 1:다 로 연결.

#JWT(JSON Web Token)
###1. What is JWT
1. An open standard that defines a compact and self-contained way for securely transmitting information btw parties as a JSON Object.
   1. JWT is a standard that is mostly used for securing REST APIs
   2. JWT is the best way to communicate securely btw client - server
   3. JWT follows stateless authentication mechanism
###2. Usage of JWT
   1. Authorization
      1. Information Exchange
###3. Structure of JWT
   1. it consists of three parts separated by dots(.)
      - xxxxx.yyyyyy.zzzzz (header.payload.signature)
      1) Header
         ```json
         {
            "alg":"HS256", - algorithm being used
            "typ":"JWT" - tpye of token
         }
      2) Payload: contains claims(state of entity) of information
         ```json
         {
            "sub":"1234567890", 
            "name":"Sexy Soo"
            "admin":true
         }
      3) Signature
         ```json
         {
            HMCASHA256(
               base64UrlEncode(header) + "." +
               base64UrlEncode(payload),
               secret -- 시크릿키
            )
         }
###4. How it works?
   1. (C>S) POST로 ID와 PW로 auth요청 보냄
   2. ( S ) ID, PW 검증하고 시크릿키를 사용해 JWT를 생성
   3. (S>C) 생성된 JWT전달
   4. (C>S) 어떤 요청이든 전달할 떄마다 헤더에 JWT를 넣음
   5. ( S ) 시크릿키를 이용해 JWT를 검증함
   6. (S>C) 응답을 전달
###5. Benefits
   1. BasicAuth에서는 요청할 때마다 ID/PW 넣어줘야 했음
   2. JWT를 쓰면 로그인하면 계속 JWT를 주니까, 다른 요청에는 헤더에 토큰만 넣어주면됨.
###6. Implementing JWT to SpringBoot Project
   1. Adding JWT Dependency
   2. Create JwtAuthenticationEntryPoint (implements AuthenticationEntryPoint)
      1. to handle Exception due to unauthorized client
      2. override commence(): for whenever exception is thrown due to unauthorized user trying to access rsc that requires authentication
      3. add errmsg on response Object
   3. Add JWT properties in application.properties file
   4. Create JwtTokenProvider
   5. JwtAuthenticationFilter
      1. guarantees single execution per request dispatch, or any servlet container
   6. Create JWTAuthResponseDTO
   7. Configure JWT in SpringSecurityConfiguration
   8. Change login/signin API to return token to client





