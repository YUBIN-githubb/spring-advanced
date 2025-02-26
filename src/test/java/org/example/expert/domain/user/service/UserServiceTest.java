package org.example.expert.domain.user.service;

import org.example.expert.config.PasswordEncoder;
import org.example.expert.domain.common.exception.InvalidRequestException;
import org.example.expert.domain.user.dto.response.UserResponse;
import org.example.expert.domain.user.entity.User;
import org.example.expert.domain.user.enums.UserRole;
import org.example.expert.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

//import static org.assertj.core.api.BDDAssumptions.given;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @InjectMocks
    private UserService userService;

    @Test
    void 유저를_ID로_조회할_수_있다() {
        //given
        Long userId = 1l;
        String email = "abc@abc.com";
        User user = new User(email , "Abcddfds123", UserRole.USER);
        ReflectionTestUtils.setField(user, "id", userId);

        given(userRepository.findById(anyLong())).willReturn(Optional.of(user));

        //when
        UserResponse userResponse = userService.getUser(userId);


        //then
        assertThat(userResponse).isNotNull();
        assertThat(userResponse.getId()).isEqualTo(userId);
        assertThat(userResponse.getEmail()).isEqualTo(email);
    }

    @Test
    void 존재하지_않는_유저를_조회_시_InvalidRequestException을_던진다() {
        //given
        Long userId = 1l;
        given(userRepository.findById(anyLong())).willReturn(Optional.empty());

        //when then
        assertThrows(InvalidRequestException.class,
                () -> userService.getUser(userId),
                "User not found");
    }
}