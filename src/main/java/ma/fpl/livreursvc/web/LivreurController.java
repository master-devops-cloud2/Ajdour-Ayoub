package ma.fpl.livreursvc.web;

import ma.fpl.livreursvc.entity.Livreur;
import ma.fpl.livreursvc.service.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livreurs")
public class LivreurController {

    @Autowired
    private LivreurService livreurService;

    @PostMapping
    public ResponseEntity<Livreur> createLivreur(@RequestBody Livreur livreur) {
        Livreur createdLivreur = livreurService.saveLivreur(livreur);
        return new ResponseEntity<>(createdLivreur, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Livreur> getAllLivreurs() {
        return livreurService.getAllLivreurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livreur> getLivreurById(@PathVariable Long id) {
        Livreur livreur = livreurService.getLivreurById(id);
        if (livreur != null) {
            return new ResponseEntity<>(livreur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livreur> updateLivreur(@PathVariable Long id, @RequestBody Livreur livreurDetails) {
        Livreur updatedLivreur = livreurService.updateLivreur(id, livreurDetails);
        if (updatedLivreur != null) {
            return new ResponseEntity<>(updatedLivreur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivreur(@PathVariable Long id) {
        if (livreurService.deleteLivreur(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
