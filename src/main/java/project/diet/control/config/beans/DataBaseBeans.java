package project.diet.control.config.beans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;

import lib.base.backend.persistance.GenericCrud;
import lib.base.backend.persistance.GenericPersistence;
import lib.base.backend.persistance.transaction.GenericJpaPeristanceImpl;

@Configuration
public class DataBaseBeans {
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Bean
	@Primary
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public GenericPersistence generateGenericPersistance() {
		return new GenericJpaPeristanceImpl(entityManager);
	}
	
	@Bean("customPersistanceApp")
	@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public GenericPersistence generateGenericAppPersistance() {
		return new GenericJpaPeristanceImpl(entityManager);
	}
	
	@Bean("customPersistance")
	public GenericPersistence generateCustomGenericPersistence() {
		return new GenericJpaPeristanceImpl(entityManagerFactory);
	}

}
