package org.br.lucaspjardim.dao;

import org.br.lucaspjardim.domain.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * Author: Lucas Jardim
 */
public class MarcaDAO implements IMarcaDAO {

    @Override
    public Marca cadastrar(Marca marca) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("JPAavancado");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


        return marca;
    }
}
