package com.jce.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 19.
 */
@ContextConfiguration(locations={"classpath*:com/jce/test/applicationContext-test.xml"})
abstract public class AbstractContextTest extends AbstractJUnit4SpringContextTests {

	protected static final Logger logger = LoggerFactory.getLogger(AbstractContextTest.class);
}
