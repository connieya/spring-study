package hello.springdbjdbc.exception.basic;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckedTest {


    @Test
    void checked_catch(){
        Service service = new Service();
        service.callCatch();
    }

    @Test
    void checked_throw() {
        Service service = new Service();
        Assertions.assertThatThrownBy(()-> service.callThrow())
                .isInstanceOf(MyCheckedException.class);
    }

    static class MyCheckedException extends Exception {
        public MyCheckedException(String message) {
            super(message);
        }
    }

    static class Service {
        Repository repository = new Repository();

        public void callCatch(){
            try {
                repository.call();
            } catch (MyCheckedException e) {
                System.out.println("예외 처리 , message = "+e.getMessage());
            }
        }

    /*

        체크 예외를 밖으로 던지는 코드
        체크 예외는 예욀르 잡지 않고 밖으로 던지려면 throws 예외를 메서드에 필수로 선언해야 한다.
    * */
        public void callThrow() throws MyCheckedException {
            repository.call();
        }
    }

    static class Repository {
        public void call() throws MyCheckedException{
            throw new MyCheckedException("ex");
        }
    }
}
