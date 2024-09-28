package jpabook.jpashop;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

/**
 * 8-3. 실전 예제4 - 상속관계 맵핑
 */
@MappedSuperclass
public abstract class BasicEntity {

    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
}
