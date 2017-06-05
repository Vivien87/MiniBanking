package com.vivi.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
@Order(value=2)
public class SpringSecurityFilterConfiguration extends AbstractSecurityWebApplicationInitializer {


}
