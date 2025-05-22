import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("GaraAtletica")
@Table(name = "gare_di_atletica")
public class GaraDiAtletica extends Evento {
@ManyToMany
@JoinTable(name = "gare_atleti",joinColumns = @JoinColumn(name = "gara_di_atletica_id")
        ,inverseJoinColumns =@JoinColumn(name = "persona_id") )
    private Set<Persona> atleti;
@ManyToOne
@JoinColumn(name = "vincitore")
    private Persona vincitore;


public GaraDiAtletica(){}

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);

    }

    public GaraDiAtletica(Persona vincitore) {
        this.vincitore = vincitore;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                "} " + super.toString();
    }
}
