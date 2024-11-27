package ma.fpl.livreursvc;

import ma.fpl.livreursvc.entity.Livreur;
import ma.fpl.livreursvc.repository.LivreurRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.CommandLineRunner;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringJUnitConfig
public class LivreurSvcApplicationTests {

    @Mock
    private LivreurRepository livreurRepository;

    @InjectMocks
    private LivreurSvcApplication livreurSvcApplication;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCommandLineRunner() throws Exception {
        CommandLineRunner commandLineRunner = livreurSvcApplication.commandLineRunner(livreurRepository);
        commandLineRunner.run();
        verify(livreurRepository, times(3)).save(any(Livreur.class));
        verify(livreurRepository).save(argThat(livreur -> livreur.getNom().equals("Ahmed")));
        verify(livreurRepository).save(argThat(livreur -> livreur.getNom().equals("Fatima")));
        verify(livreurRepository).save(argThat(livreur -> livreur.getNom().equals("Youssef")));
    }

    @Test
    void testSaveLivreur() {
        Livreur livreur = new Livreur(null, "Ayoub Ajdour", "0657017246", true);
        Livreur savedLivreur = new Livreur(1L, "Ayoub Ajdour", "0657017246", true);
        when(livreurRepository.save(livreur)).thenReturn(savedLivreur);
        Livreur result = livreurRepository.save(livreur);
        assertNotNull(result);
        assertEquals("Ayoub Ajdour", result.getNom());
        assertEquals("0657017246", result.getTelephone());
        assertTrue(result.isDisponible());
        verify(livreurRepository, times(1)).save(livreur);
    }

    @Test
    void testGetLivreurById() {
        Livreur livreur = new Livreur(1L, "Ayoub Ajdour", "0657017246", true);
        when(livreurRepository.findById(1L)).thenReturn(java.util.Optional.of(livreur));
        Livreur result = livreurRepository.findById(1L).orElse(null);
        assertNotNull(result);
        assertEquals("Ayoub Ajdour", result.getNom());
        assertEquals("0678123456", result.getTelephone());
        assertTrue(result.isDisponible());
        verify(livreurRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateLivreur() {
        Livreur existingLivreur = new Livreur(1L, "Ayoub Ajdour", "0657017246", true);
        Livreur updatedLivreur = new Livreur(1L, "Ayoub Ajdour Updated", "0657017246", false);
        when(livreurRepository.findById(1L)).thenReturn(java.util.Optional.of(existingLivreur));
        when(livreurRepository.save(updatedLivreur)).thenReturn(updatedLivreur);
        Livreur result = livreurRepository.save(updatedLivreur);
        assertNotNull(result);
        assertEquals("Ayoub Ajdour Updated", result.getNom());
        assertFalse(result.isDisponible());
        verify(livreurRepository, times(1)).save(updatedLivreur);
    }

    @Test
    void testDeleteLivreur() {
        Livreur livreurToDelete = new Livreur(1L, "Ayoub Ajdour", "0657017246", true);
        when(livreurRepository.findById(1L)).thenReturn(java.util.Optional.of(livreurToDelete));
        livreurRepository.delete(livreurToDelete);
        verify(livreurRepository, times(1)).delete(livreurToDelete);
    }
}
