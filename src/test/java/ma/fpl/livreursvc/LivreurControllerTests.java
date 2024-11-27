//package ma.fpl.livreursvc;
//
//import ma.fpl.livreursvc.entity.Livreur;
//import ma.fpl.livreursvc.service.LivreurService;
//import ma.fpl.livreursvc.web.LivreurController;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class LivreurControllerTests {
//
//    @Mock
//    private LivreurService livreurService;
//
//    @InjectMocks
//    private LivreurController livreurController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testCreateLivreur() {
//        Livreur livreur = new Livreur();
//        livreur.setId(1L);
//        livreur.setNom("Ayoub Ajdour");
//
//        when(livreurService.saveLivreur(any(Livreur.class))).thenReturn(livreur);
//
//        ResponseEntity<Livreur> response = livreurController.createLivreur(livreur);
//
//        assertEquals(201, response.getStatusCodeValue());
//        assertNotNull(response.getBody());
//        assertEquals("Ayoub Ajdour", response.getBody().getNom());
//    }
//
//    @Test
//    void testGetLivreurById() {
//        Livreur livreur = new Livreur();
//        livreur.setId(1L);
//        livreur.setNom("Ayoub Ajdour");
//
//        when(livreurService.getLivreurById(1L)).thenReturn(livreur);
//
//        ResponseEntity<Livreur> response = livreurController.getLivreurById(1L);
//
//        assertEquals(200, response.getStatusCodeValue());
//        assertNotNull(response.getBody());
//        assertEquals("Ayoub Ajdour", response.getBody().getNom());
//    }
//}
