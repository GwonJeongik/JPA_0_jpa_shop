package jpabook.jpashop;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 실전 예제 1 - 요구사항 분석과 기본 맵핑
 */

/**
 * 4. 실전 예제 2 - 연관관계 맵핑 시작
 */
@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @Column(length = 10)
    private String name;
    private String city;
    private String street;
    private String zipcode;

    //Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
