//package ma.fpl.livreursvc.web;
//
//import io.grpc.stub.StreamObserver;
//import ma.fpl.livreursvc.entity.Livreur;
//import ma.fpl.livreursvc.mapper.LivreurMapper;
//import ma.fpl.livreursvc.repository.LivreurRepository;
//import ma.fpl.livreursvc.stub.LivreurServiceGrpc;
//import ma.fpl.livreursvc.stub.LivreurServiceOuterClass;
//import net.devh.boot.grpc.server.service.GrpcService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@GrpcService
//public class LivreurGrpcController extends LivreurServiceGrpc.LivreurServiceImplBase {
//    @Autowired
//    private LivreurRepository livreurRepository;
//    @Autowired
//    private LivreurMapper livreurMapper;
//
//    @Override
//    public void getAllLivreurs(LivreurServiceOuterClass.GetAllLivreursRequest request, StreamObserver<LivreurServiceOuterClass.GetAllLivreursResponse> responseObserver) {
//        List<Livreur> all = livreurRepository.findAll();
//        List<LivreurServiceOuterClass.Livreur> grpcAll = all.stream().map(livreurMapper::fromLivreur).collect(Collectors.toList());
//        LivreurServiceOuterClass.GetAllLivreursResponse livreursResponse = LivreurServiceOuterClass.GetAllLivreursResponse.newBuilder()
//                .addAllLivreurs(grpcAll)
//                .build();
//        responseObserver.onNext(livreursResponse);
//        responseObserver.onCompleted();
//    }
//
//    @Override
//    public void getLivreurById(LivreurServiceOuterClass.GetLivreurByIdRequest request, StreamObserver<LivreurServiceOuterClass.GetLivreurByIdResponse> responseObserver) {
//        System.out.println("getLivreurById invoked with ID: " + request.getId());
//        Long id = request.getId();
//        Livreur livreur = livreurRepository.findById(id).orElse(null);
//        if (livreur == null) {
//            System.out.println("Livreur not found");
//            responseObserver.onError(new RuntimeException("Livreur not found"));
//        } else {
//            LivreurServiceOuterClass.Livreur grpcLivreur = livreurMapper.fromLivreur(livreur);
//            LivreurServiceOuterClass.GetLivreurByIdResponse response = LivreurServiceOuterClass.GetLivreurByIdResponse.newBuilder()
//                    .setLivreur(grpcLivreur)
//                    .build();
//            System.out.println("Livreur found, returning response");
//            responseObserver.onNext(response);
//            responseObserver.onCompleted();
//        }
//    }
//
//    @Override
//    public void createLivreur(LivreurServiceOuterClass.CreateLivreurRequest request, StreamObserver<LivreurServiceOuterClass.CreateLivreurResponse> responseObserver) {
//        LivreurServiceOuterClass.Livreur grpcLivreur = request.getLivreur();
//        Livreur livreur = livreurMapper.toLivreur(grpcLivreur);
//        Livreur savedLivreur = livreurRepository.save(livreur);
//        LivreurServiceOuterClass.Livreur createdLivreur = livreurMapper.fromLivreur(savedLivreur);
//        LivreurServiceOuterClass.CreateLivreurResponse response = LivreurServiceOuterClass.CreateLivreurResponse.newBuilder()
//                .setLivreur(createdLivreur)
//                .build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//
//    @Override
//    public void updateLivreur(LivreurServiceOuterClass.UpdateLivreurRequest request, StreamObserver<LivreurServiceOuterClass.UpdateLivreurResponse> responseObserver) {
//        Long id = request.getId();
//        LivreurServiceOuterClass.Livreur grpcLivreur = request.getLivreur();
//        Livreur livreurDetails = livreurMapper.toLivreur(grpcLivreur);
//
//        Livreur livreur = livreurRepository.findById(id).orElse(null);
//        if (livreur == null) {
//            responseObserver.onError(new RuntimeException("Livreur not found"));
//        } else {
//            livreur.setNom(livreurDetails.getNom());
//            livreur.setTelephone(livreurDetails.getTelephone());
////            livreur.setDisponible(livreurDetails.getDisponible());
//            Livreur updatedLivreur = livreurRepository.save(livreur);
//            LivreurServiceOuterClass.Livreur grpcUpdatedLivreur = livreurMapper.fromLivreur(updatedLivreur);
//            LivreurServiceOuterClass.UpdateLivreurResponse response = LivreurServiceOuterClass.UpdateLivreurResponse.newBuilder()
//                    .setLivreur(grpcUpdatedLivreur)
//                    .build();
//            responseObserver.onNext(response);
//            responseObserver.onCompleted();
//        }
//    }
//
//    @Override
//    public void deleteLivreur(LivreurServiceOuterClass.DeleteLivreurRequest request, StreamObserver<LivreurServiceOuterClass.DeleteLivreurResponse> responseObserver) {
//        Long id = request.getId();
//        boolean exists = livreurRepository.existsById(id);
//        if (!exists) {
//            responseObserver.onError(new RuntimeException("Livreur not found"));
//        } else {
//            livreurRepository.deleteById(id);
//            LivreurServiceOuterClass.DeleteLivreurResponse response = LivreurServiceOuterClass.DeleteLivreurResponse.newBuilder()
//                    .setSuccess(true)
//                    .build();
//            responseObserver.onNext(response);
//            responseObserver.onCompleted();
//        }
//    }
//}
