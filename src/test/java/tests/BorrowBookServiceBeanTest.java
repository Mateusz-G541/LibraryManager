package tests;

import mg.librarymanager.services.BorrowItemService;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BorrowBookServiceBeanTest {

    @Autowired
    ApplicationContext context;

    @Test
    void shouldCallBeanService(){
        BorrowItemService bean = (BorrowItemService) context.getBean(BorrowItemService.class);
    }
}
