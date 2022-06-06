package com.danielsoo.blog_daniel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication // 항상 최상단에서 사용, 여기서부터 읽기 시작함
public class Application {
    public static void main(String[] args){
        //내장 WAS를 어플리케이션 실행할 때 같이 실행. 항성 서버에 톰캣을 설치할 필요없이, Jar파일로 실행하면 끝.
        SpringApplication.run(Application.class, args);
    }
}
