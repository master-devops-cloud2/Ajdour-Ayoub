package ma.fpl.livreursvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class LivreurRequest {
    private String nom;
    private String telephone;
    private boolean disponible;
}
