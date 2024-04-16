package dao;

import entity.Album;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface AlbumDao extends Remote {
    public boolean updatePriceOfAlbum(String id, double price) throws RemoteException;
    public List<Album> listAlbumByGenre(String genre, int yearOfRelease)throws RemoteException;
    public Map<String, Long> getNumberOfAlbumsByGenre()throws RemoteException;
    public List<Album> getAllAlbums()throws RemoteException;

}
