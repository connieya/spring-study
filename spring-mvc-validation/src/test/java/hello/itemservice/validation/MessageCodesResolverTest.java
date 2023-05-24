package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.*;

import static org.assertj.core.api.Assertions.*;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    public void messageCodesResolverObject() {
        //given
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");

        //when
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }


        //then
        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    public void messageCodesResolverField() {
        //given
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        //when
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }
        //then

        new FieldError("item","itemName",null,false,messageCodes,null,null);
        assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        );
    }
}
