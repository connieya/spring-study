package inflearn.jpashop.service;

import inflearn.jpashop.domain.Address;
import inflearn.jpashop.domain.Member;
import inflearn.jpashop.domain.Order;
import inflearn.jpashop.domain.OrderStatus;
import inflearn.jpashop.domain.item.Book;
import inflearn.jpashop.domain.item.Item;
import inflearn.jpashop.exception.NotEnoughStockException;
import inflearn.jpashop.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @PersistenceContext
    EntityManager em;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 상품주문(){
    //given
        Member member = createMember();
        Item book = createdBook("시골 JPA", 10000, 10);

        em.persist(book);
        //when
        int orderCount = 2;
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        //then
        Order getOrder = orderRepository.findOne(orderId);
        assertThat(OrderStatus.ORDER).isEqualTo(getOrder.getStatus());
        assertThat(getOrder.getOrderItems().size()).isEqualTo(1);
        assertThat(getOrder.getTotalPrice()).isEqualTo(10000*orderCount);
        assertThat(book.getStockQuantity()).isEqualTo(8);

    }

    private Member createMember() {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울","경기","123-123"));
        em.persist(member);
        return member;
    }

    private Item createdBook(String name, int orderPrice, int stockQuantity) {
        Item book = new Book();
        book.setName(name);
        book.setPrice(orderPrice);
        book.setStockQuantity(stockQuantity);
        return book;
    }

    @Test()
    public void 상품주문_재고수량초과() {
    //given
        Member member = createMember();
        Item item = createdBook("시골 JPA", 10000, 10);
        int orderCount = 11;
       assertThrows(NotEnoughStockException.class, ()-> orderService.order(member.getId(),item.getId(),orderCount) );



    }

    @Test
    public void 주문취소(){
    //given
        Member member = createMember();
        Item item = createdBook("시골 JPA", 10000, 10);

        int orderCount = 2;

        Long order = orderService.order(member.getId(), item.getId(), orderCount);
        //when
        orderService.cancelOrder(order);

    //then
        Order getOrder = orderRepository.findOne(order);
        assertThat(OrderStatus.CANCEL).isEqualTo(getOrder.getStatus());
        assertThat(10).isEqualTo(item.getStockQuantity());

    }
}