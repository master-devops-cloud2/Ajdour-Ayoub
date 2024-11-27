package ma.fpl.livreursvc.web;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import ma.fpl.livreursvc.dto.LivreurRequest;
import ma.fpl.livreursvc.entity.Livreur;
import ma.fpl.livreursvc.mapper.LivreurMapper;
import ma.fpl.livreursvc.service.LivreurService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(serviceName = "LivreurWService")
@AllArgsConstructor
public class LivreurSOAPController {

    private final LivreurService livreurService;
    private final LivreurMapper livreurMapper;

    @WebMethod
    public Livreur getLivreurById(@WebParam(name = "id") Long id) {
        Livreur livreur = livreurService.getLivreurById(id);
        if (livreur == null) {
            throw new RuntimeException("Livreur not found with id: " + id);
        }
        return livreur;
    }

    @WebMethod
    public Livreur createLivreur(@WebParam(name = "livreur") LivreurRequest livreurRequest) {
        return livreurService.saveLivreur(livreurMapper.from(livreurRequest));
    }

    @WebMethod
    public Livreur updateLivreur(@WebParam(name = "id") Long id, @WebParam(name = "livreurDetails") Livreur livreurDetails) {
        return livreurService.updateLivreur(id, livreurDetails);
    }

    @WebMethod
    public boolean deleteLivreur(@WebParam(name = "id") Long id) {
        return livreurService.deleteLivreur(id);
    }

    @WebMethod
    public List<Livreur> getAllLivreurs() {
        return livreurService.getAllLivreurs();
    }
}
