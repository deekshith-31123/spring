package org.example.repository;

import org.example.entity.City;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
//@Transactional
public class CityRepository {

    @Autowired
    private EntityManagerFactory emf;

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void save(City city) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();
        em.close();
    }

    public List<City> findAll() {
        EntityManager em = getEntityManager();
        List<City> cities = em.createQuery("from City", City.class).getResultList();
        em.close();
        return cities;
    }

    public void delete(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        City c = em.find(City.class, id);
        if(c != null) em.remove(c);
        em.getTransaction().commit();
        em.close();
    }
}
