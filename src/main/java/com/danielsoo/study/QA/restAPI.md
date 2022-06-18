
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
2. ANTMATCHERS, MVCMATCHERS?
3. Spring Configuration을 하지 않으면 디폴트로 
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
   ```
   
