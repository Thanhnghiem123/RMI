package server;

import dao.AlbumDao;
import dao.impl.AlbumDaoImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            Context context = new InitialContext();

            AlbumDao albumDao = new AlbumDaoImpl();

            LocateRegistry.createRegistry(4501);

            context.bind("rmi://THANHNGHIEM:4501/albumDao", albumDao);

            System.out.println("Server is running...");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

    }

}
