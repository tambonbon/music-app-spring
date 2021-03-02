package io.github.tambonbon.musicappspring;

import io.github.tambonbon.musicappspring.models.Song;
import io.github.tambonbon.musicappspring.repositories.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class MusicAppSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicAppSpringApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//            System.out.println("Let's inspect the beans provided by Spring Boot");
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//        };
//    }
    @Bean
    public CommandLineRunner loadData(SongRepository songRepository) {
        return args -> {
            songRepository.save(new Song("Lover", "03:20"));
            songRepository.save(new Song("Thriller", "03:40"));
            songRepository.save(new Song("Billie Jeans", "04:10"));
            songRepository.save(new Song("Here comes the sun", "03:30"));

        };
    }

}
