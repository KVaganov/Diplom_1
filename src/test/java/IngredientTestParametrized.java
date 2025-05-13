import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static junit.framework.TestCase.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTestParametrized {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTestParametrized(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getIngredientTestParametrized() {
        return new Object[][]{
                {SAUCE, "sour cream", 200},
                {FILLING, "sausage", 300},
                {null, null, 0.0f}
        };
    }
    @Test
    public void getType(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        assertEquals("Данный тип не совпадает с ожидаемым", type, actualType);

    }
}
