package jpa01.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity                         // JPA 에게 이 객체가 데이터를 쓰기위한 객체임을 표시
@Table(name = "customer_tb")    // 어떤 테이블에 데이터를 넣을지 표시
public class Customer {

    @Id // PK 표시
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private long registerDate;

    public Customer (Long id, String name) {
        this.id = id;
        this.name = name;
        this.registerDate = System.currentTimeMillis();
    }

        public static Customer sample (){
            return new Customer ( 19L, "Kim");
    }

}

/*
 서버에 테이블 생성
 CREATE TABLE customer_tb (
 id VARCHAR(255) NOT NULL,
 name VARCHAR(255) NOT NULL,
 registerDate BIGINT NOT NULL,
 PRIMARY KEY(id)
 );
 */
