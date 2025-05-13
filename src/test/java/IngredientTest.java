import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;


import static junit.framework.TestCase.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    private Ingredient ingredient;
    @Before
    public void createIngredient() {
        ingredient = new Ingredient(SAUCE,"chili sauce", 150.0f);
    }
    @Test
    public void getName(){
        String expectedName = "chili sauce";
        String actualName = ingredient.getName();
        assertEquals("Данное имя не совпадает с ожидаемым" , expectedName, actualName);
    }
    @Test
    public void getPrice() {
        float expectedPrice = 150.0f;
        float actualPrice = ingredient.getPrice();
        assertEquals("Данная цена не совпадает с ожидаемой", expectedPrice, actualPrice);
    }

}
