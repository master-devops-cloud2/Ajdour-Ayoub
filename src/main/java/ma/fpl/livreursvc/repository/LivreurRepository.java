package ma.fpl.livreursvc.repository;


import ma.fpl.livreursvc.entity.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;



public interface LivreurRepository extends JpaRepository<Livreur,Long> {
}
