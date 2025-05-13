import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    private Bun bun;
    @Before
    public void createInstance() {
        bun = new Bun("original", 200.0f);
    }
    @Test
    public void getName(){
        String expectedName = "original";
        String actualName = bun.getName();
        assertEquals("Данное имя не совпадает с ожидаемым" , expectedName, actualName);
    }

    @Test
    public void getPrice() {
        float expectedPrice = 200.0f;
        float actualPrice = bun.getPrice();
        assertEquals("Данная цена не совпадает с ожидаемой" , expectedPrice, actualPrice);
    }
}
