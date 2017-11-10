package com.smart.dynamiccreatebean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class UserServiceFactoryBean implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)configurableListableBeanFactory;

        /********************* 这块完整的定义了一个userService的Bean ***************************/
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserService.class);

        // 设置属性userDao (注入属性userDao)
        beanDefinitionBuilder.addPropertyReference("userDao", "userDao");

        beanFactory.registerBeanDefinition("userService1", beanDefinitionBuilder.getRawBeanDefinition());
        /***************************************************************************************/

        // 直接注册一个bean实例
        UserService userService = new UserService();
        userService.setUserDao(new UserDao());
        beanFactory.registerSingleton("userService2", userService);
    }
}
