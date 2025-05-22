import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("PartitaCalcio")
@NamedQueries({
        @NamedQuery(name = "getPartitaVincenteInCasa",query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente= p.squadraDiCasa"),
        @NamedQuery(name = "getPartitaVincenteInTrasferta",query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite"),
        @NamedQuery(name = "getPartitePareggiate", query = "SELECT p FROM PartitaDiCalcio p WHERE p.numeroGolSquadraDiCasa = p.numeroGolSquadraOspite")
})
public class PartitaDiCalcio extends Evento {
@Column(name = "squadra_casa")
    private String squadraDiCasa;
@Column(name = "squadra_ospite")
    private String squadraOspite;
@Column(name = "squadra_vincente")
    private String squadraVincente;
@Column(name = "numero_gol_squadra_di_casa")
    private int numeroGolSquadraDiCasa;
@Column(name = "numero_gol_squadra_ospite")
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
