package com.example.moviereview.Models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class SciFiDataManager implements SciFiDataDAO {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public SciFiDataManager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("MovieReview");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void addSciFiData(SciFiData sciFiData) {
        entityManager.getTransaction().begin();
        entityManager.persist(sciFiData);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateSciFiData(SciFiData sciFiData) {
        entityManager.getTransaction().begin();
        entityManager.merge(sciFiData);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteSciFiData(SciFiData sciFiData) {
        entityManager.getTransaction().begin();
        entityManager.remove(sciFiData);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<SciFiData> getAllSciFiData() {
        TypedQuery<SciFiData> query = entityManager.createQuery("SELECT sfd FROM SciFiData sfd", SciFiData.class);
        return query.getResultList();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

}

