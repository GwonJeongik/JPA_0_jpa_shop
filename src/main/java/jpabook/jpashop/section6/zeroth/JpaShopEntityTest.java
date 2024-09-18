package jpabook.jpashop.section6.zeroth;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.Member;
import jpabook.jpashop.Order;

/**
 * 0. 실전 예제 1 - 요구사항 분석과 기본 맵핑
 * Section 5 마지막 부분이다.
 * `Order`에서 `memberId`를 통해서 `Member`를 찾는 것은, `객체 설계`를 해야하는데, `테이블 설계`에 맞춰서 설계한 방식이다. -> 원하는 상황이 아니다.
 * `Order`에서 `Member`를 바로 찾는 게, 참조를 통해서 객체 그래프 탐색이 가능한 옳은 방법이다.
 * <p>
 * `Order`에서 `Member`를 바로 찾는다. -> `memberId`를 찾아서 `Member`를 찾는 게 아니다.
 * `Member`의 참조값을 통해서 객체 그래프 탐색이 부드럽다.
 */
public class JpaShopEntityTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            System.out.println("== `객체 설계`를 `테이블 설계`에 맞춘 방식 시점 시작 ==");
            //`Order`를 찾아온다.
            Order findOrder = em.find(Order.class, 1L);
            //찾아온 `Order`에서 `memberId`를 가져온다.
            Long findOrderMemberId = findOrder.getMemberId();
            //`memberId`를 통해서 다시 데이터베이스에서 `Member`를 가져온다.
            Member findMember = em.find(Member.class, findOrderMemberId);
            System.out.println("== `객체 설계`를 `테이블 설계`에 맞춘 방식 시점 종료 ==");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
