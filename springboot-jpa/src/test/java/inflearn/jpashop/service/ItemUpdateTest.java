package inflearn.jpashop.service;

import inflearn.jpashop.domain.item.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemUpdateTest {

    @PersistenceContext
    EntityManager em;

    @Test
    public void updateTest(){
        Book book = em.find(Book.class, 1L);
        book.setName("SDAS@");
        //when

    //then

    }
}
