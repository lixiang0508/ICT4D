package com.zlx.ict4d.demo.utils;

import com.zlx.ict4d.demo.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.zlx.ict4d.demo.utils.JWTUtils.geneJsonWebToken;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JWTUtilsTest {

    @Test
    void geneJsonWebToken1() {
        User user1 = new User("hejie","1378654");

        System.out.println(geneJsonWebToken(user1));

    }

    @Test
    void checkJWT() {
    }
}