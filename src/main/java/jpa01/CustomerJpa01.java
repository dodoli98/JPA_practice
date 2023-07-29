package jpa01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpa01.entity.Customer;

public class CustomerJpa01 {

    public static void main(String[] args) {
        /*
        pom.xml 로 라이브러리 설정

        resources/META-INF/persistence.xml 설정파일 생성
        JPA 로 데이터베이스에 접근하기위한 환경 정보를 저장
         */

        // persistence.xml 파일에 저장한 persistence unit 이름으로 설정
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em= emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin(); // 이 코드 이후로 데이터작업이 가능

        try{
            // Create
            em.persist(Customer.sample());

            // Read
            // Customer foundCustomer = em.find(Customer.class, "ID0001");
            // 엔티티 매니저로 객체를 생성할때는 기본 생성자로 불러와야한다.
            //      - 내부적으로 JDBC를 통해 DB에 접근해 레코드를 가져오고, 애플리케이션에서는 이 레코드를 Customer 객체로 변환해야한다.
            //        결론적으로 find() 메서드로 데이터를 가져오면 해당 객체로 생성할 수 있어야한다. 따라서 엔테테 객체에 기본 생성자를 만들어야한다.
            Customer foundCustomer = em.find(Customer.class, "ID0001");


            // Update
            // foundCustomer 이 객체는 엔티티 매니저가 관리하고 있고, 이 객체의 데이터를 바꿔주면
            // 업데이트를 따로 하지 않아도 엔테테 매니저가 업데이트를 해준다.
            foundCustomer.setName("Park");

            // Delete
            em.remove(foundCustomer);


            System.out.println(foundCustomer.toString());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
