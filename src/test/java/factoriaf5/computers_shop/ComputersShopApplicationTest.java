package factoriaf5.computers_shop;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


@SpringBootTest
public class ComputersShopApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        // Verifies if the application context loads without errors
        assertThat("Application context should be loaded", applicationContext, is(notNullValue()));
    }

    @Test
    public void testBeanPresence() {
        // Verifies critical beans are present in the application context
        assertThat("ComputerService bean should be present",
                applicationContext.containsBean("computerService"), is(true));
        assertThat("ShopService bean should be present",
                applicationContext.containsBean("shopService"), is(true));
        assertThat("ComputerRepository bean should be present",
                applicationContext.containsBean("computerRepository"), is(true));
        assertThat("ShopRepository bean should be present",
                applicationContext.containsBean("shopRepository"), is(true));
    }
}
