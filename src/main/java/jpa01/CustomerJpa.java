package jpa01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpa01.entity.Customer;

public class CustomerJpa {

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
        em.persist(Customer.sample());

        tx.commit();

        // 모든 작업 이후 em, emf 닫기
        em.close();
        emf.close();

        /*
        EntityManagerFactory 를 통해 EntityManager 를 얻어오고
        EntityManager 를 통해
        EntityTransaction tx = em.getTransaction();
        tx.begin(); 트랜잭션 시작
        시작이후 EntityManager 로 데이터 작업을 수행
        tx.commit(); 로 커밋을 하고
        마지막으로 관련 리소스를 닫는다.
         */

    }
}
