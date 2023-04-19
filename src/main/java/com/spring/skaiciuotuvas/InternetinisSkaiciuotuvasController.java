package com.spring.skaiciuotuvas;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
/* Web controller leidžia viduje naudoti @RequestMapping
 RestController anotacija nurodo, jog pvz: String tipo rezultatas turėtų būti išspauzdinamas toks koks yra. */
@EnableAutoConfiguration
// Žymi konfiguracijos komponentą, vidue leidžia kurti bean per metodus su @Bean anotacija
// Ši klasės lygio anotacija nurodo Spring karkasui "atspėti" konfiguraciją remiantys priklausomybėmis, Jar bibliotekomis,
// kurias programuotojas įtraukia į projektą (pom.xml) šiuo atvėju jį veikia kartu su main metodu
public class InternetinisSkaiciuotuvasController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld bean = (HelloWorld) applicationContext.getBean("helloWorld");
        return bean.getHello();
        // bean- atitinka singleton šabloną

    /* ApplicationContext yra interfeisas skirtas suteikti informaciją apie aplikacijos konfiguracija
    Šiuo atveju naudojama informacija paimama iš xml failo
     */

  /*  return "Internetinis skaiciuotuvas <p>"+
            "Galimos operacijos: <br>"+
            "<li>&nbsp;&nbsp; sudeti <br>"+
            "<li>&nbsp;&nbsp; atimti <br>"+
            "<li>&nbsp;&nbsp; dauginti <br>"+
            "<li>&nbsp;&nbsp; dalinti <br> </p>"; */
    }

}
