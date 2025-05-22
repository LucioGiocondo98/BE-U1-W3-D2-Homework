import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("PartitaCalcio")
@NamedQueries({
        @NamedQuery(name = "PartitaDiCalcio.getPartitaVincenteInCasa",query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente= p.squadraDiCasa"),
        @NamedQuery(name = "PartitaDiCalcio.getPartitaVincenteInTrasferta",query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite"),
        @NamedQuery(name = "PartitaDiCalcio.getPartitePareggiate", query = "SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraDiCasa = p.numeroGolSquadraOspite")
})
public class PartitaDiCalcio extends Evento {
private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int numeroGolSquadraDiCasa;
    private int getNumeroGolSquadraOspite;

    public PartitaDiCalcio(){}

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, String squadraDiCasa, String squadraOspite, String squadraVincente, int numeroGolSquadraDiCasa, int getNumeroGolSquadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
        this.getNumeroGolSquadraOspite = getNumeroGolSquadraOspite;
    }


    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraCincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumeroGolSquadraDiCasa() {
        return numeroGolSquadraDiCasa;
    }

    public void setNumeroGolSquadraDiCasa(int numeroGolSquadraDiCasa) {
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
    }

    public int getGetNumeroGolSquadraOspite() {
        return getNumeroGolSquadraOspite;
    }

    public void setGetNumeroGolSquadraOspite(int getNumeroGolSquadraOspite) {
        this.getNumeroGolSquadraOspite = getNumeroGolSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraCincente='" + squadraVincente + '\'' +
                ", numeroGolSquadraDiCasa=" + numeroGolSquadraDiCasa +
                ", getNumeroGolSquadraOspite=" + getNumeroGolSquadraOspite +
                "} " + super.toString();
    }
}
