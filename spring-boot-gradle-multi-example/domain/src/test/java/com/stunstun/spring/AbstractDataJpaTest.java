package com.stunstun.spring;

import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author minhyeok
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public abstract class AbstractDataJpaTest {

    @SpringBootApplication
    static class Configuration {}
}
