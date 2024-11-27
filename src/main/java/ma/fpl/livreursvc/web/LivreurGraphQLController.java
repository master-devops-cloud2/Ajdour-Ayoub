package ma.fpl.livreursvc.web;

import lombok.AllArgsConstructor;
import ma.fpl.livreursvc.dto.LivreurRequest;
import ma.fpl.livreursvc.entity.Livreur;
import ma.fpl.livreursvc.mapper.LivreurMapper;
import ma.fpl.livreursvc.repository.LivreurRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class LivreurGraphQLController {

    private LivreurRepository livreurRepository;
    private LivreurMapper livreurMapper;

    @QueryMapping
    public List<Livreur> AllLivreurs() {
        return livreurRepository.findAll();
    }

    @QueryMapping
    public Livreur LivreurById(@Argument Long id) {
        return livreurRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Livreur createLivreur(@Argument LivreurRequest livreurRequest) {
        Livreur livreur = livreurMapper.from(livreurRequest);
        return livreurRepository.save(livreur);
    }

    @MutationMapping
    public Livreur updateLivreur(@Argument Long id,
                                 @Argument String nom,
                                 @Argument String telephone,
                                 @Argument Boolean disponible) {
        Optional<Livreur> livreurOpt = livreurRepository.findById(id);
        if (livreurOpt.isPresent()) {
            Livreur livreur = livreurOpt.get();
            if (nom != null) livreur.setNom(nom);
            if (telephone != null) livreur.setTelephone(telephone);
            if (disponible != null) livreur.setDisponible(disponible);

            return livreurRepository.save(livreur);
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteLivreur(@Argument Long id) {
        Optional<Livreur> livreurOpt = livreurRepository.findById(id);
        if (livreurOpt.isPresent()) {
            livreurRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
