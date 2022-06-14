package com.danielsoo.study.javaFundamental;

import java.util.ArrayList;
import java.util.List;

public class AnnotationStudy {
    /**
    @Spring boot
     1. Start
        1) @SpringBootApplication: 항상 최상단에서 사용, 여기서부터 읽기 시작함
        2)
     2. Controller
        1) 상단
            - @RestController: 컨트롤러를 JSON으로 반환하는 컨트롤러로 만들어 준다. @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 함.
        2) 메소드별
            - @ResponseBody: convert Java Object(DTO) into JSON as return(response)
            - @RequestMapping: (method=RequestMethod.GET) 등을 붙여서 HTTP METHOD를 받게한 옛날 방식
            - @GetMapping: HTTP Method의 Get 요청을 받을 수 있는 API를 만듦
     3. Test
        1) Class상단
            - @RunWith(SpringRunner.class) : 테스트 진행할 때 SpringRunner라는 스프링 실행자를 사용하여, 스프링부트테스트와 JUnit사이의 연결자 역할을 한다.
            - @WebMvcTest(Controllers = Ctrler.class)
                    : 여러 테스트어노테이션 중, Web에 집중할 수 있는 어노테이션, 선언할 경우 , @Controller, @ControllerAdvice 등 사용 가능
                      단, @Service, @Component, @Repository는 사용 불가
     4. Exception
        1) @ResponseStatus: causes SpringBoot to respond with the specified HTTP status code whenever this exception is thrown from a Controller
    */

    /**
     @Lombok
     1. @Data
     2. @AllArgsConstructor: generates an all-args constructor.
     3. @NoArgsConstructor: because Hibernate internally uses proxies to create objects
     */

    /**
     @JPA
     1. @Entity
     2. @Table(
            name="tbName", uniqueConstraints={@UniqueConstraint(columnNames={"title"})}
        ) : name지정안해주면 자동으로 class이름이 됨.
     2. @AllArgsConstructor: (from lombok)generates an all-args constructor.
     3. @NoArgsConstructor: (from lombok)because Hibernate internally uses proxies to create objects
     4. @JoinColumn(name="post_id"), nullable = false)
     5. @ManyToOne(fetch=FetchType.LAZY)
     6. @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
     */

    /**
    @Java in General
    1. 어노테이션: 프로그램 소스코드 안에 다른 프로그램을 위한 정보를 약속된 형식으로 포함시킨 것.
                 주석처럼 프로그래밍언어에 영향을 미치지 않으면서도 '타 프로그램'에 유용한 정보제공
    2. 표준어노테이션: 주로 컴파일러를 위해 정보를 제공 + 새로운 어노테이션을 정의할 때 사용하는 메타어노테이션 제공
        - @Override
            : (메소드) notRequired, 조상메소드 오버라이드할 경우, 오타나면 컴파일러는 새로운 메소드라 인식하지만, 이거 붙이면 체크해줌.
        - @Deprecated
            : (필드/메소드) 더 이상 사용되지 않는 필드나 메서드에 붙임. 강제는 아님
        - @FunctionalInterface
            : 함수형 인터페이스를 선언할 때, 컴파일러가 함수형인터페이스가 올바르게 선언했는지 확인, 잘못되면 에러
        - @SuppressWarnings
            : 컴파일러가 표시하는 경고메시지 나타나지 않게 억제함. 묵인해야하는 경고에 사용.
            -ex, deprecation, unchecked(제네릭스로 타입지정X), rawtypes(제네릭스를 사용안함), varargs(가변인자 타입이 제네릭타입일 때)
            -한개만 억제 @SuppressWarnings("rawtypes")
            -두개 이상 억제 @SupressWarnings({"depreciation", "unchecked", "varags"})
            -억제범위는 메소드 위에 붙여도되지만, 억제 범위를 최소화하기 위해 필요한 필드에 붙이기도 한다.
        - @SafeVarargs
            : 메서드에 선언된 가변인자의 타입이 non-refiable타입일 경우, 해당 메서드를 선언하는 부분과 호출하는 부분에서 unchecked경고 발생
              이 경고를 억제하기 위해 사용
            -오버라이드 될 수 없는 메소드에서만 사용 (static이나 final이 붙은 메서드와 생성자에만)
            * reifiable: 제네릭스에서 컴파일 후에도 제거되지 않는 타입
              non-reifiable: 컴파일 후에 제거되는 타입
            * SuppressWarnings를 대신 쓸 경우, 호출하는 곳/선언하는 곳 모두에 붙여줘야한다. 그렇다고 @SafeVarags만 쓸 경우,
              unchecked경고는 억제할 수 있지만 varargs는 억제할 수 없기 때문에, 둘이 같이 쓰인다.
              @SafeVarags
              @SuppressWarnings("varargs")
     */
    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <T> List<T> asList(T... a){
        // return new ArrayList<>(a);
        return null;
    }

}
