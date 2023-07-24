package com.example.moviereview.Models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ComedyDataManager implements ComedyDataDAO {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public ComedyDataManager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("MovieReview");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void addComedyData(ComedyData comedyData) {
        entityManager.getTransaction().begin();
        entityManager.persist(comedyData);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateComedyData(ComedyData comedyData) {
        entityManager.getTransaction().begin();
        entityManager.merge(comedyData);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteComedyData(ComedyData comedyData) {
        entityManager.getTransaction().begin();
        entityManager.remove(comedyData);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<ComedyData> getAllComedyData() {
        TypedQuery<ComedyData> query = entityManager.createQuery("SELECT cd FROM ComedyData cd", ComedyData.class);
        return query.getResultList();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

}

