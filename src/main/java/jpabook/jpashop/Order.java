package jpabook.jpashop;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 0. 실전 예제 1 - 요구사항 분석과 기본 맵핑
 */

/**
 * 4. 실전 예제 2 - 연관관계 맵핑 시작
 * `주문 아이템`에서 `order_id`를 이용해서 주문 내역을 확인할 수 있다.
 * `외래 키`는 `OrderItem`에 있다.
 * `Order` -> `OrderItem`의 연관관계를 갖게한다. == 양방향 연관관계을 설정한다.
 * 객체 관점 : `주문내역`에서 `주문 아이템`을 찾을 수 있게 하는 건, 비지니스적으로 의미가 있을 수도 있다.
 * 객체 관점 :  `주문 아이템`에서 주문 내역을 찾을 수 있다.ㅌ
 */

@Entity
@Table(name = "orders")
public class Order extends BasicEntity{

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // `order`객체의 `id`를 가지고 `orderItem`을 담는다.
    @OneToMany(mappedBy = "order")
    List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    //Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
