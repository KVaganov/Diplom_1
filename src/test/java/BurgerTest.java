import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private static final float DELTA = 0.001f;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredients;
    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient filling;
    @Mock
    private Burger burger;
    @Mock
    private Ingredient ingredient;

    @Before
    public void createBurger() {
        burger = new Burger();
    }
    @Test
    public void setBuns() {
    burger.setBuns(bun);
    Bun actual = burger.bun;
    assertEquals("Данное имя не совпадает с ожидаемым" , bun, actual);
    }
    @Test
    public void addIngredient() {
        burger.addIngredient(ingredients);
        List<Ingredient> expected = List.of(ingredients);
        List<Ingredient> actual = burger.ingredients;
        assertEquals("Ингредиент некорректно добавлен" , expected, actual);
    }
    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredients);
        burger.removeIngredient(0);
        List<Ingredient> actual = burger.ingredients;
        assertEquals("Ингредиент некорректно удален" , List.of(), actual);
    }
    @Test
    public void moveIngredient() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);
        Ingredient actual = burger.ingredients.get(1);
        assertEquals("Ингредиент некорректно перемещен" , sauce, actual);

    }
    @Test
    public void getPrice() {
        when(bun.getPrice()).thenReturn(10.0f);
        when(ingredient.getPrice()).thenReturn(5.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(25.0f, burger.getPrice(), DELTA);
    }

    @Test
    public void getReceipt() {
        Mockito.when(bun.getName()).thenReturn("original");
        Mockito.when(bun.getPrice()).thenReturn(200.0f);
        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("chili");
        Mockito.when(ingredient.getPrice()).thenReturn(20.0f);
        burger.addIngredient(ingredient);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        List<Ingredient> ingredients = burger.ingredients;

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().name().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        String expected = receipt.toString();
        String actual = burger.getReceipt();

        assertEquals("Некорректный рецепт бургера", expected, actual);
    }
}
