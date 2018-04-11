package com.hexa;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hexa.service.BusSer;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan("com.hexa.entity")
public class BusReserveApplication extends SpringBootServletInitializer {

	private BusSer ser;

	@Autowired
	public void setSer(BusSer ser) {
		this.ser = ser;
	}

	@Autowired
	private EntityManagerFactory emf;

	@Bean
	public SessionFactory getSessionFactory() {
		System.out.println(emf);
		return emf.unwrap(SessionFactory.class);
	}

	@Bean
	@Autowired
	public HibernateTransactionManager getTxmanger(SessionFactory sfac) {
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(sfac);
		return tx;
	}

	public static void main(String[] args) {
		SpringApplication.run(BusReserveApplication.class, args);
	}

}
