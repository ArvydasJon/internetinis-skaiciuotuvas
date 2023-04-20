package com.spring.skaiciuotuvas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* Ši anotacija lygi @Configuration, @Enableautoconfiguration, @ComponentScan
*  ši anotacija nurodoma klasėje turinčioje pagrindini main metodą
* */
@SpringBootApplication
public class InternetinisSkaiciuotuvasApplication {

	public static void main(String[] args) {
		/* Programos kontrolė deleguojama statiniam klasės metodui run
		nurodant aplikacijos šakninį(root) komponentą
		Spring karkasas paleis aplikacija, t.y. startuos Tomcat serveryje
		 */
		SpringApplication.run(InternetinisSkaiciuotuvasApplication.class, args);
	}
}
