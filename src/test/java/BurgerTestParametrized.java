import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static junit.framework.TestCase.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerTestParametrized {
    private Burger burger;
    private Ingredient ingredients;
    private Ingredient sauce;
    private Ingredient filling;
    private final String name;
    private final float price;


    public BurgerTestParametrized(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Before
    public void createBurgerParametrized() {
        sauce = new Ingredient(SAUCE, "hot sauce", 100);
        filling = new Ingredient(FILLING, "dinosaur", 200);
        burger = new Burger();
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerTestParametrize() {
        return new Object[][]{
                {"sour cream", 200},
                {"sausage", 300}
        };
    }
    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        float expected = bun.getPrice() * 2 + sauce.price + filling.price;
        float actual = burger.getPrice();
        assertEquals("Данное имя не совпадает с ожидаемым" , expected, actual);
    }
}
