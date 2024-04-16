package main;

import dao.AlbumDao;
import dao.impl.AlbumDaoImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.rmi.RemoteException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class testt {

    @BeforeAll
    public void setUp() throws RemoteException {
        AlbumDao albumDao = new AlbumDaoImpl();
    }

    @Test
    public void testUpdatePriceOfAlbum() throws RemoteException {
        AlbumDao albumDao = new AlbumDaoImpl();
        boolean result = albumDao.updatePriceOfAlbum("album1", 10);
        System.out.println(result);
    }

    @Test
    public void testListAlbumByGenre() throws RemoteException {
        AlbumDao albumDao = new AlbumDaoImpl();
        albumDao.listAlbumByGenre("Rock", 2020).forEach(System.out::println);
    }

    @Test
    public void testGetNumberOfAlbumByGenre() throws RemoteException {
        AlbumDao albumDao = new AlbumDaoImpl();
        albumDao.getNumberOfAlbumsByGenre().forEach((k, v) -> System.out.println(k + ": " + v));
    }

    @Test
//    public void testGetAllAlbum() throws RemoteException {
//        AlbumDao albumDao = new AlbumDaoImpl();
//        albumDao.getAllAlbums().forEach(System.out::println);
//    }
    public void testGetAllAlbum() throws RemoteException {
        AlbumDao albumDao = new AlbumDaoImpl();
        albumDao.getAllAlbums().forEach(System.out::println);
    }

}
