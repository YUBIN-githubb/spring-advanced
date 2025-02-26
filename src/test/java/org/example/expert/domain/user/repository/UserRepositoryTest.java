package org.example.expert.domain.user.repository;

import org.example.expert.domain.user.entity.User;
import org.example.expert.domain.user.enums.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void 이메일로_사용자를_조회할_수_있다() {
        //given
        String email = "abc@abc.com";
        User user = new User(email , "Abcddfds123", UserRole.USER);
        userRepository.save(user);

        //when
        User foundUser = userRepository.findByEmail(email).orElseThrow();

        //then
        //assertThat(foundUser).isNotNull();
        assertNotNull(foundUser);
        //assertThat(foundUser.getEmail()).isEqualTo(email);
        assertEquals(email, foundUser.getEmail());
    }
}