package jpabook.jpashop;

import jakarta.persistence.*;

@Entity
public class Delivery extends BasicEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    private String city;
    private String street;
    private String zipCode;

    private DeliveryStatus deliveryStatus;
}
