import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LocationDAO locationDAO = new LocationDAO();
        EventoDAO eventoDAO = new EventoDAO();
        PersonaDAO personaDAO = new PersonaDAO();
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();


        Evento e1= new Evento("GNX TOUR",LocalDate.of(2025,8,2),"RapConcert",TipoEvento.PRIVATO,100000);

eventoDAO.save(e1);


Location l1= new Location("Olimpico","Roma");
        locationDAO.save(l1);



    }
}
