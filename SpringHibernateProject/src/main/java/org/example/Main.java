package org.example;


import org.example.config.AppConfig;
import org.example.entity.City;
import org.example.service.CityService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        CityService service = context.getBean(CityService.class);


        service.addCity(new City("Hyderabad"));
        service.addCity(new City("Bangalore"));

         System.out.println("Cities in DB:");
        service.getAllCities().forEach(c -> System.out.println(c.getName()));

         service.deleteCity(1L);
        System.out.println("After deletion:");
        service.getAllCities().forEach(c -> System.out.println(c.getName()));

        context.close();
    }
}
