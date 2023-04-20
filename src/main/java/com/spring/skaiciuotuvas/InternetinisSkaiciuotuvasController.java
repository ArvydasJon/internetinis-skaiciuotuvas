package com.spring.skaiciuotuvas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

//@RestController
/* @RestController naudojama tada, kai frontende nenaudojame springo (java script, react, angular)
Dažniausiai naudojami formatai jason, xml, t.y. negražiname vaizdo (formos HTML JSP)
 */

/* Kadangi reikia grąžinti vaizdą (view) pagal spring MVC, naudosime @Controller
 */
@Controller
/* Web controller leidžia viduje naudoti @RequestMapping
 RestController anotacija nurodo, jog pvz: String tipo rezultatas turėtų būti išspauzdinamas toks koks yra. */
//@EnableAutoConfiguration
// Žymi konfiguracijos komponentą, vidue leidžia kurti bean per metodus su @Bean anotacija
// Ši klasės lygio anotacija nurodo Spring karkasui "atspėti" konfiguraciją remiantys priklausomybėmis, Jar bibliotekomis,
// kurias programuotojas įtraukia į projektą (pom.xml) šiuo atvėju jį veikia kartu su main metodu
public class InternetinisSkaiciuotuvasController {
    @RequestMapping(method = RequestMethod.POST, value = "/skaiciuoti")
    // URL pavyzzdys: localhost:8080/skaiciuoti?sk1=2&sk2=3&zenklas=*
    //
    public String skaiciuoti(@RequestParam HashMap<String, String> ivedimoSarasas, ModelMap isvedimoSarasas) {
        // Pirmas Stringas (sk1,sk2, zenklas), o antras reiksme
        // raktai fronende ir backende turi sutapti
        //@RequestParam anotacija perduoda šiuo atvėju per URL perduotus duomenys(du skaičiai ir operacijos ženklas)
        // kurie patalpinami į HashMap sąrašą: raktas reikšmė
        // per URL perduodamas raktas(kintamas) sk1
        //pagal raktą sk1 ištarukiama reikšmė
        // tarkim vart įvedė 8
        // vadinasi reikia konvertuoti iš stringo į intą
        double ats = 0;
        int sk1 = Integer.parseInt(ivedimoSarasas.get("sk1"));
        int sk2 = Integer.parseInt(ivedimoSarasas.get("sk2"));
        String zenklas = ivedimoSarasas.get("zenklas");
        //TODO suskaiciuoti ir atspausdinti rezultatą
      /*  switch (zenklas) {
            case "*":
                ats = sk1 * sk2;
                break;
            case "/":
                ats = sk1 / sk2;
                break;
            case "+":
                ats = sk1 + sk2;
                break;
            case "*":
                ats = sk1 - sk2;
                break;
        } */

        if (zenklas.equals("*")) {
            ats = sk1 * sk2;
        } else if (zenklas.equals("/")) {
            ats = sk1 / sk2;
        } else if (zenklas.equals("+")) {
            ats = sk1 + sk2;
        } else if (zenklas.equals("-")) {
            ats = sk1 - sk2;
        }

        // ivedimo sarasas naudojama siųsti duomenys iš Spring MVC Controllerio į jsp failą(vaizdą)
        isvedimoSarasas.put("sk1",sk1);
        isvedimoSarasas.put("sk2",sk2);
        isvedimoSarasas.put("zenklas",zenklas);
        isvedimoSarasas.put("rezultatas",ats);

        //grąžinamas vaizdas(forma), svarbu nuroditi prefix ir suffix, nes pagal tai ieško vaizdą
        return sk1 + " " + zenklas + " " + sk2 + " = " + ats;
        //  ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //   HelloWorld bean = (HelloWorld) applicationContext.getBean("helloWorld");
        //   return bean.getHello();
        // bean- atitinka singleton šabloną
    /* ApplicationContext yra interfeisas skirtas suteikti informaciją apie aplikacijos konfiguracija
    Šiuo atveju naudojama informacija paimama iš xml failo
     */
 /*  @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        return "Internetinis skaiciuotuvas <p>" +
                "Galimos operacijos: <br>" +
                "<li>&nbsp;&nbsp; sudeti <br>" +
                "<li>&nbsp;&nbsp; atimti <br>" +
                "<li>&nbsp;&nbsp; dauginti <br>" +
                "<li>&nbsp;&nbsp; dalinti <br> </p>";
    }  */
    }
    @RequestMapping (method = RequestMethod.GET,value = "/")
    public String rodytiPagrindiniPuslapi() {
        // Grąžiname jsp failą, kuris turi būti talpinamas "webapp->WEB-INF->JSP" aplanke
        return "skaiciuotuvas";
    }

}