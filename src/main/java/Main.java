import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EventoDAO dao= new EventoDAO();
        Evento e= new Evento(1,"Incredibileeee", LocalDate.of(2025,05,20),"imperdibile",TipoEvento.PUBBLICO,300);
        try {
            dao.save(e);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        System.out.println(dao.getById(e.getId()));
        dao.remove(e.getId());
        dao.remove(1);
    }
}
