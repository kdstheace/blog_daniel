package com.danielsoo.study.javaFundamental;

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
                - @RequestMapping: (method=RequestMethod.GET) 등을 붙여서 HTTP METHOD를 받게한 옛날 방식
                - @GetMapping: HTTP Method의 Get 요청을 받을 수 있는 API를 만듦,
        3.
    */

    /**
    @Java in General
        1. 어노테이션: 프로그램 소스코드 안에 다른 프로그램을 위한 정보를 약속된 형식으로 포함시킨 것.
                     주석처럼 프로그래밍언어에 영향을 미치지 않으면서도 '타 프로그램'에 유용한 정보제공
        2. 표준어노테이션: 주로 컴파일러를 위해 정보를 제공 + 새로운 어노테이션을 정의할 때 사용하는 메타어노테이션 제공
            - @Override:
    */
}
