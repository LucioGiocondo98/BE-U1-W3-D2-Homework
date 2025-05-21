import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        e1.setLocation(l1);


Persona p1=new Persona("Lucio","Giocondo","luciogiocondo@gmail.com",LocalDate.of(1998,7,24),Sesso.M);
personaDAO.save(p1);


Partecipazione part= new Partecipazione(Stato.CONFERMATA);
partecipazioneDAO.save(part);
part.setEvento(e1);
part.setPersona(p1);

partecipazioneDAO.save(part);
    }
}
