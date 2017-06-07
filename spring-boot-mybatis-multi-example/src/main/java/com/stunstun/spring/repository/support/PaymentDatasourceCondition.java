package com.stunstun.spring.repository.support;

import com.stunstun.spring.properties.PaymentDatabaseProperties;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author minhyeok
 */
public class PaymentDatasourceCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        PaymentDatabaseProperties properties = null;
        try {
            properties = (PaymentDatabaseProperties) context.getBeanFactory().getBean("paymentDatabaseProperties");
            System.out.println("PaymentDatasourceCondition=" + properties);
        } catch (NoSuchBeanDefinitionException e) {

        }
        return (properties != null);
    }
}
