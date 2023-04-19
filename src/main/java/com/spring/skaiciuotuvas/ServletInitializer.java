package com.spring.skaiciuotuvas;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/* Servlet yra Java programa veikianti Web serveryje
 Servlet paleidžaimas kai vartotojas paspaudžia nuorodą, pateikia forma, ar atlieka
 kitokius veiksmus internet svetainėje.
 Kiekviena kliento užklauza(request) praeina per Servlet,
 kuri jį perdauda kontrolieriui request maping atributui
*/
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InternetinisSkaiciuotuvasApplication.class);
	}

}
