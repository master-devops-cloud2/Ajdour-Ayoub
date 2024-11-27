package ma.fpl.livreursvc.service;

import ma.fpl.livreursvc.entity.Livreur;
import ma.fpl.livreursvc.repository.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreurService {

    @Autowired
    private LivreurRepository livreurRepository;

    public Livreur saveLivreur(Livreur livreur) {
        return livreurRepository.save(livreur);
    }

    public List<Livreur> getAllLivreurs() {
        return livreurRepository.findAll();
    }

    public Livreur getLivreurById(Long id) {
        Optional<Livreur> livreur = livreurRepository.findById(id);
        return livreur.orElse(null);
    }

    public Livreur updateLivreur(Long id, Livreur livreurDetails) {
        Optional<Livreur> optionalLivreur = livreurRepository.findById(id);
        if (optionalLivreur.isPresent()) {
            Livreur livreur = optionalLivreur.get();
            livreur.setNom(livreurDetails.getNom());
            livreur.setTelephone(livreurDetails.getTelephone());
            livreur.setDisponible(livreurDetails.isDisponible());
            return livreurRepository.save(livreur);
        }
        return null;
    }

    public boolean deleteLivreur(Long id) {
        if (livreurRepository.existsById(id)) {
            livreurRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
