package com.danielsoo.blog_daniel.web;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 인덱스작동테스트(){
        //when
        String body = this.restTemplate.getForObject("/", String.class);
        System.out.println(">>>>>>");
        System.out.println(body);
        //then
        Assertions.assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");

    }
}
