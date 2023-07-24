package com.example.moviereview.Models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class RomanceDataManager implements RomanceDataDAO {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public RomanceDataManager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("MovieReview");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void addRomanceData(RomanceData romanceData) {
        entityManager.getTransaction().begin();
        entityManager.persist(romanceData);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateRomanceData(RomanceData romanceData) {
        entityManager.getTransaction().begin();
        entityManager.merge(romanceData);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteRomanceData(RomanceData romanceData) {
        entityManager.getTransaction().begin();
        entityManager.remove(romanceData);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<RomanceData> getAllRomanceData() {
        TypedQuery<RomanceData> query = entityManager.createQuery("SELECT rd FROM RomanceData rd", RomanceData.class);
        return query.getResultList();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

}

