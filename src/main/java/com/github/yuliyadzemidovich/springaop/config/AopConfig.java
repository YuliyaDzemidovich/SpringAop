package com.github.yuliyadzemidovich.springaop.config;

import com.github.yuliyadzemidovich.springaop.SpringAopApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Spring Configuration that is extracted into a separate class in order to keep {@link SpringAopApplication} cleaner.
 */
@Configuration
@EnableAspectJAutoProxy // enable Spring AOP
public class AopConfig {
}
