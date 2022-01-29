package com.danielsoo.blog_daniel.web.dto;


import org.assertj.core.api.Assertions;
import org.junit.Test;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "김동수";
        int amount = 9000;
        //when
        HelloResponseDto helloResponseDto = new HelloResponseDto(name, amount);

        //then
        Assertions.assertThat(helloResponseDto.getAmount()).isEqualTo(amount);
        Assertions.assertThat(helloResponseDto.getName()).isEqualTo(name);
    }
}
