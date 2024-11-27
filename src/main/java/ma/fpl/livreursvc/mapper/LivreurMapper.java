package ma.fpl.livreursvc.mapper;

import ma.fpl.livreursvc.dto.LivreurRequest;
import ma.fpl.livreursvc.entity.Livreur;
//import ma.fpl.livreursvc.stub.LivreurServiceOuterClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LivreurMapper {
    private ModelMapper modelMapper = new ModelMapper();

    // Convert LivreurRequest (if exists) to Livreur entity (if you have LivreurRequest class)
    public Livreur from(LivreurRequest request) {
        return modelMapper.map(request, Livreur.class);
    }

    // Convert Livreur entity to gRPC Livreur object
//    public LivreurServiceOuterClass.Livreur fromLivreur(Livreur livreur) {
//        return modelMapper.map(livreur, LivreurServiceOuterClass.Livreur.Builder.class).build();
//    }

    // Convert gRPC Livreur object to Livreur entity
//    public Livreur toLivreur(LivreurServiceOuterClass.Livreur grpcLivreur) {
//        return modelMapper.map(grpcLivreur, Livreur.class);
//    }
//
//    // Convert list of Livreur entities to list of gRPC Livreur objects
//    public List<LivreurServiceOuterClass.Livreur> fromLivreurList(List<Livreur> livreurs) {
//        return livreurs.stream()
//                .map(this::fromLivreur)
//                .collect(Collectors.toList());
//    }
}
