package com.example.moviereview.Models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class HorrorDataManager implements HorrorDataDAO {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public HorrorDataManager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("MovieReview");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void addHorrorData(HorrorData horrorData) {
        entityManager.getTransaction().begin();
        entityManager.persist(horrorData);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateHorrorData(HorrorData horrorData) {
        entityManager.getTransaction().begin();
        entityManager.merge(horrorData);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteHorrorData(HorrorData horrorData) {
        entityManager.getTransaction().begin();
        entityManager.remove(horrorData);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<HorrorData> getAllHorrorData() {
        TypedQuery<HorrorData> query = entityManager.createQuery("SELECT hd FROM HorrorData hd", HorrorData.class);
        return query.getResultList();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

}

