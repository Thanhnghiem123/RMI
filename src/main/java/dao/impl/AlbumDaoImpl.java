package dao.impl;

import dao.AlbumDao;
import entity.Album;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AlbumDaoImpl extends UnicastRemoteObject implements AlbumDao, Serializable {
    EntityManager em;
    public  AlbumDaoImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("music2").createEntityManager();
    }

    @Override
    public boolean updatePriceOfAlbum(String id, double price) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Album album = em.find(Album.class, id);
            if (album == null) {
                return false;
            }
            album.setPrice(price);
            em.merge(album);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Album> listAlbumByGenre(String genre, int yearOfRelease) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            List<Album> albums = em.createQuery("select a from Album a where a.genre.name like CONCAT(:genre, '%') and a.yearOfRelease = :yearOfRelease")
                    .setParameter("genre", "%" + genre + "%")
                    .setParameter("yearOfRelease", yearOfRelease )
                    .getResultList();
            tx.commit();
            return albums;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, Long> getNumberOfAlbumsByGenre() {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            List<Object[]> result = em.createQuery("select a.genre.name, count(a) from Album a group by a.genre.name").getResultList();
            tx.commit();
            return result.stream().collect(Collectors.toMap(e -> (String) e[0], e -> (Long) e[1]));
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Album> getAllAlbums() {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            List<Album> albums = em.createQuery("select a from Album a").getResultList();
            tx.commit();
            return albums;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return null;
    }
}
