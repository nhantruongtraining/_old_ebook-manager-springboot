package com.axonactive.training.ebookapp.service.impl;

import com.axonactive.training.ebookapp.service.UserEbookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserEbookServiceImplTest {

    @Autowired
    UserEbookService userEbookService;

//    @Test
//    void findByEbookTitleContaining() {
//        assertEquals(1, userEbookService.findByEbookTitleContaining("Expectations").size());
//    }
}