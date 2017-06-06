package com.stunstun.spring;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author minhyeok
 */
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public abstract class AbstractIntegrationTest {}
