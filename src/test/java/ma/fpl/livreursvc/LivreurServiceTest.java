//package ma.fpl.livreursvc;
//
//import ma.fpl.livreursvc.entity.Livreur;
//import ma.fpl.livreursvc.repository.LivreurRepository;
//import ma.fpl.livreursvc.service.LivreurService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class LivreurServiceTest {
//
//    @Mock
//    private LivreurRepository livreurRepository;
//
//    @InjectMocks
//    private LivreurService livreurService;
//
//    @BeforeEach
//    void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testSaveLivreur() {
//        Livreur livreur = new Livreur(null, "Ayoub Ajdour", "0678123456", true);
//        Livreur savedLivreur = new Livreur(1L, "Ayoub Ajdour", "0678123456", false);
//
//        when(livreurRepository.save(livreur)).thenReturn(savedLivreur);
//
//        Livreur result = livreurService.saveLivreur(livreur);
//        assertNotNull(result);
//        assertEquals(1L, result.getId());
//        assertEquals("Ayoub Ajdour", result.getNom());
//        verify(livreurRepository, times(1)).save(livreur);
//    }
//
//    @Test
//    void testGetLivreurById() {
//        Livreur livreur = new Livreur(1L, "Ayoub Ajdour", "0678123456", true);
//
//        when(livreurRepository.findById(1L)).thenReturn(Optional.of(livreur));
//
//        Livreur result = livreurService.getLivreurById(1L);
//        assertNotNull(result);
//        assertEquals("Ayoub Ajdour", result.getNom());
//        verify(livreurRepository, times(1)).findById(1L);
//    }
//}
