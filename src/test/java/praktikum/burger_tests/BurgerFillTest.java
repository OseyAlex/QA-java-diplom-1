package praktikum.burger_tests;

import jdk.jfr.Name;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

public class BurgerFillTest {

    private Burger burger;
    private static List<Ingredient> ingredients = new ArrayList<>();
    private static List<Bun> buns = new ArrayList<>();

    @Before
    public void init() {
        burger = new Burger();
        ingredients.add(new Ingredient(SAUCE, "Кетчуп", 5));
        ingredients.add(new Ingredient(SAUCE, "Горчица", 10));
        buns.add(new Bun("Булка", 25));
    }

    @Test
    @Name("Проверка метода addIngredient")
    public void addIngredientTest() {
        burger.addIngredient(ingredients.get(0));

        assertEquals("Кетчуп", burger.ingredients.get(0).getName());
        assertEquals(SAUCE, burger.ingredients.get(0).getType());
        assertEquals(5, burger.ingredients.get(0).getPrice(), 0);
    }

    @Test
    @Name("Проверка метода setBuns")
    public void setBunsTest() {
        burger.setBuns(buns.get(0));

        assertEquals("Булка", burger.bun.getName());
        assertEquals(25, burger.bun.getPrice(), 0);
    }

    @Test
    @Name("Проверка удаления ингредиента removeIngredient")
    public void removeIngredientTest() {
        burger.addIngredient(ingredients.get(0));
        burger.removeIngredient(0);

        assertTrue("Список игредиентов не пустой", burger.ingredients.size() == 0);
    }

    @Test
    @Name("Проверка перемещения ингредиента moveIngredient")
    public void moveIngredientTest() {
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.moveIngredient(0, 1);

        assertEquals("Перемещение ингредиентов не сработало", "Горчица", burger.ingredients.get(0).getName());
        assertEquals("Перемещение ингредиентов не сработало", "Кетчуп", burger.ingredients.get(1).getName());
    }
}
