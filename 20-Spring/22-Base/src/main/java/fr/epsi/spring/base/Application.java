package fr.epsi.spring.base;

import fr.epsi.spring.base.service.GareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    GareService gareService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Recherche d'une gare à lille : ");
        System.out.println(this.gareService.findGareByVille("Lille").orElseThrow().toString());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
