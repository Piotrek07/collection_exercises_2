package Maps.Zadanie2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class InformacjeOPojezdzie {
    private String nrREj;
    private TypPojazdu typPojazdu;
    private LocalDateTime dataWjazdu;

    public InformacjeOPojezdzie(String nrREj, TypPojazdu typPojazdu) {
        this.nrREj = nrREj;
        this.typPojazdu = typPojazdu;
    }
}
