package com.stunstun.spring.repository.support;

import com.stunstun.spring.properties.PaymentDatabaseProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author minhyeok
 */
public class PaymentDatasourceCondition implements Condition {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentDatasourceCondition.class);

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        PaymentDatabaseProperties properties = null;
        try {
            properties = (PaymentDatabaseProperties) context.getBeanFactory().getBean("paymentDatabaseProperties");
        } catch (NoSuchBeanDefinitionException e) {
            LOGGER.warn(e.getMessage());
        }
        return (properties != null);
    }
}
