import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100f},
                {IngredientType.FILLING, "cutlet", 100f}
        };
    }

    //проверяем getName()
    @Test
    public void getNameIngredientClassTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        String actualResult = ingredient.getName();
        String expectedResult = name;
        Assert.assertEquals(expectedResult, actualResult);
    }

    //проверяем getPrice()
    @Test
    public void getPriceIngredientClassTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        float actualResult = ingredient.getPrice();
        float expectedResult = price;
        Assert.assertEquals(expectedResult, actualResult, 0.0);
    }

    //проверяем метод getType
    @Test
    public void getTypeIngredientClassTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        IngredientType actualResult = ingredient.getType();
        IngredientType expectedResult = ingredientType;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
