package com.sobey.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Spring Bean工具类
 *
 * @author Jalena
 * @create 2017-05-08 23:25
 */
@Component
@Lazy(value = false)
public class BeanFactoryUtil implements ApplicationContextAware {

	public BeanFactoryUtil() {
	}

	// spring 上下文对象
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}


	/**
	 * 根据类唯一标识名获取Bean
	 *
	 * @param beanName 唯一标识名称（ID）
	 * @return Object
	 * @throws BeansException
	 */
	public static Object getBeanByName(String beanName) throws BeansException {
		return applicationContext.getBean(beanName);
	}

	/**
	 * 根据类Class获取Bean
	 *
	 * @param requiredType 类Class
	 * @param <T>          类型
	 * @return
	 * @throws BeansException
	 */
	public static <T> T getBeanByClass(Class<T> requiredType) throws BeansException {
		return applicationContext.getBean(requiredType);
	}

	/**
	 * 根据类唯一标识名及类Class获取Bean
	 *
	 * @param beanName     唯一标识名
	 * @param requiredType 类Class
	 * @param <T>          类型
	 * @return
	 * @throws BeansException
	 */
	public static <T> T getBeanByNameAndClass(String beanName, Class<T> requiredType) throws BeansException {
		return applicationContext.getBean(beanName, requiredType);
	}
}

