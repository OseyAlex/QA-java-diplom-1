package praktikum.burger_tests;

import jdk.jfr.Name;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerGetPriceTest {
    private static List<Ingredient> ingredients = new ArrayList<>();
    private static List<Bun> buns = new ArrayList<>();
    private float expectedPrice;
    private int numberOfIngredients;

    @BeforeClass
    public static void prepareTestData() {
        ingredients.add(new Ingredient(SAUCE, "Кетчуп", 5));
        ingredients.add(new Ingredient(SAUCE, "Горчица", 10));
        ingredients.add(new Ingredient(SAUCE, "Кетчунез", 15));
        buns.add(new Bun("Булка", 25));
    }

    public BurgerGetPriceTest(int numberOfIngredients, float expectedPrice) {
        this.numberOfIngredients = numberOfIngredients;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {1, 55},
                {2, 65},
                {3, 80}
        };
    }

    @Test
    @Name("Позитивная проверка метода getPrice")
    public void burgerGetPriceTest() {
        Burger burger = new Burger();
        for (int i = 0; i < numberOfIngredients; i++) {
            burger.addIngredient(ingredients.get(i));
        }
        burger.setBuns(buns.get(0));

        assertEquals("Цена не совпадает с ожидаемой", expectedPrice, burger.getPrice(), 0);
    }
}
