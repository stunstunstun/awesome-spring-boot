package com.stunstun.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 19.
 */
@ContextConfiguration(locations={"/META-INF/spring/applicationContext-test.xml"})
abstract public class AbstractTestableContext extends AbstractJUnit4SpringContextTests {
	protected static final Logger logger = LoggerFactory.getLogger(AbstractTestableContext.class);
}
