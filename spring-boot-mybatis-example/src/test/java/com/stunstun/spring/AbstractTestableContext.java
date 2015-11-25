package com.stunstun.spring;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 19.
 */
@Transactional
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootMybatisExampleApplication.class)
@WebAppConfiguration
abstract public class AbstractTestableContext {
	
}
