package com.example.moviereview.Models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class FantasyDataManager implements FantasyDataDAO {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public FantasyDataManager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("MovieReview");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void addFantasyData(FantasyData fantasyData) {
        entityManager.getTransaction().begin();
        entityManager.persist(fantasyData);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateFantasyData(FantasyData fantasyData) {
        entityManager.getTransaction().begin();
        entityManager.merge(fantasyData);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteFantasyData(FantasyData fantasyData) {
        entityManager.getTransaction().begin();
        entityManager.remove(fantasyData);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<FantasyData> getAllFantasyData() {
        TypedQuery<FantasyData> query = entityManager.createQuery("SELECT fd FROM FantasyData fd", FantasyData.class);
        return query.getResultList();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

}

