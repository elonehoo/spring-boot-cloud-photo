package com.inet;

import cn.hutool.core.lang.Validator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootInetCloudPhotoApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(Validator.isMobile("176058189"));
    }

}
