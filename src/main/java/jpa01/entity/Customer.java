package jpa01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity                         // JPA 에게 이 객체가 데이터를 쓰기위한 객체임을 표시
@Table(name = "customer_tb")    // 어떤 테이블에 데이터를 넣을지 표시
public class Customer {

    @Id     // PK 표시
    private String id;

    private String name;

    private long registerDate;

    public Customer (String id, String name) {
        this.id = id;
        this.name = name;
        this.registerDate = System.currentTimeMillis();
    }

        public static Customer sample (){
            return new Customer ( "ID0001", "Kim");
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
