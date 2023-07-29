package jpa01;

import jakarta.persistence.*;
import jpa01.entity.Customer;

import java.util.List;

public class CustomerJpa03 {

    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em= emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            Customer customer = new Customer();

            customer.setName("Jung");
            customer.setRegisterDate(System.currentTimeMillis());

            em.persist(customer);

            System.out.println("=====before commit=====");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
