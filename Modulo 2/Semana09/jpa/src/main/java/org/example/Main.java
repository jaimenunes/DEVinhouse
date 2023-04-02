package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.model.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome("Fulano");
        pessoa.setEmail("fulano@gmail.com");
        pessoa.setIdade(30);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ex03");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(pessoa);
        em.getTransaction().commit();
        em.close();
    }
}