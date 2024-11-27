package ma.fpl.livreursvc;

import ma.fpl.livreursvc.entity.Livreur;
import ma.fpl.livreursvc.repository.LivreurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LivreurSvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivreurSvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(LivreurRepository livreurRepository) {
        return args -> {
            livreurRepository.save(Livreur.builder()
                    .nom("Ahmed")
                    .telephone("0612345678")
                    .disponible(true)
                    .build());

            livreurRepository.save(Livreur.builder()
                    .nom("Fatima")
                    .telephone("0698765432")
                    .disponible(false)
                    .build());

            livreurRepository.save(Livreur.builder()
                    .nom("Youssef")
                    .telephone("0623456789")
                    .disponible(true)
                    .build());
        };
    }
}
