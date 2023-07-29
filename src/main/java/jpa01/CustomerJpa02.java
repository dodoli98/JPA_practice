package jpa01;

import jakarta.persistence.*;
import jpa01.entity.Customer;

import java.util.List;

public class CustomerJpa02 {

    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em= emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            Customer customer = new Customer(10L, "Park");  // 비영속 상태(New)

            em.persist(customer);   // Customer 객체가 영속 상태 (Managed)

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
