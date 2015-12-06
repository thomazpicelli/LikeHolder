
import com.br.lp3.DAO.ArtistaDAO;
import com.br.lp3.DAO.EventoDAO;
import com.br.lp3.DAO.MusicaDAO;
import com.br.lp3.DAO.UsuarioDAO;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Thomaz
 */
public class RMIServer {
    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.createRegistry(1099);
            
            registro.rebind("UsuarioDAO", new UsuarioDAO());
            registro.rebind("ArtistaDAO", new ArtistaDAO());
            registro.rebind("MusicaDAO", new MusicaDAO());
            registro.rebind("EventoDAO", new EventoDAO());
            
            System.out.println("Serviço registrado com sucesso");
        } catch (RemoteException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
