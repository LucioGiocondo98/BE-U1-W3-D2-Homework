import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LocationDAO locationDAO = new LocationDAO();
        EventoDAO eventoDAO = new EventoDAO();
        PersonaDAO personaDAO = new PersonaDAO();
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();


        Location location = new Location();
        location.setNome("Stadio Olimpico");
        location.setCitta("Roma");
        locationDAO.save(location);


        Evento evento = new Evento();
        evento.setId(1);
        evento.setTitolo("GNX TOUR");
        evento.setDataEvento(LocalDate.of(2025, 6, 20));
        evento.setDescrizione("K-DOT");
        evento.setTipoEvento(TipoEvento.PUBBLICO);
        evento.setNumeroMassimoPartecipanti(100000);
        evento.setLocation(location);
        evento.setPartecipazioni(new ArrayList<>());
        eventoDAO.save(evento);

        Persona persona = new Persona();
        persona.setNome("Lucio");
        persona.setCognome("Giocondo");
        persona.setEmail("luciogiocondo@hotmail.com");
        persona.setDataNascita(LocalDate.of(1998, 7, 24));
        persona.setSesso(Sesso.M);
        persona.setPartecipazioni(new ArrayList<>());
        personaDAO.save(persona);


        Partecipazione partecipazione = new Partecipazione();
        partecipazione.setEvento(evento);
        partecipazione.setPersona(persona);
        partecipazione.setStato(Stato.CONFERMATA);
        partecipazioneDAO.save(partecipazione);

        evento.getPartecipazioni().add(partecipazione);
        persona.getPartecipazioni().add(partecipazione);
        eventoDAO.save(evento);
        personaDAO.save(persona);

        System.out.println("Evento salvato:\n" + eventoDAO.getById(1));
        System.out.println("Persona salvata:\n" + personaDAO.getById(persona.getId()));
        System.out.println("Partecipazione salvata:\n" + partecipazioneDAO.getById(partecipazione.getId()));
    }
}
