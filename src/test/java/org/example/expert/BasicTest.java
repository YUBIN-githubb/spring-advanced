package org.example.expert;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

//이건 그냥 자바 테스트
public class BasicTest {

    @Test
    @DisplayName("a와 b를 더하는 테스트임")
    //public 안붙이는 걸 선호..?
    //안붙이면 테스트 느낌이 나서..?
    void test() {
        //given
        int a = 1;
        int b = 2;

        //when
        int i = a + b;

        //then
        assertEquals(3,i);
        assertThat(i).isEqualTo(3);
    }
}
