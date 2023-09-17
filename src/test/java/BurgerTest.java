import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class BurgerTest {
    private final String bunName;
    private final float bunPrice;
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    private String expectedResult;

    public BurgerTest(String bunName, float bunPrice, IngredientType ingredientType, String ingredientName, float ingredientPrice, String expectedResult) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {"black bun", 100f, IngredientType.SAUCE, "hot sauce", 100f, String.format("(==== black bun ====)%n= sauce hot sauce =%n(==== black bun ====)%n%nPrice: 300,000000%n")},
                {"white bun", 200f, IngredientType.FILLING, "cutlet", 100f, String.format("(==== white bun ====)%n= filling cutlet =%n(==== white bun ====)%n%nPrice: 500,000000%n")},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        float expectedResult = 300f;
        float actualResult = burger.getPrice();
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        String actualResult = burger.getReceipt();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
