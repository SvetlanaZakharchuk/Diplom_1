//тестиурем модель булочки
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }

    //проверяем getName()
    @Test
    public void testGetNameBunTest() {
       Bun bun = new Bun(name, price);
       String actualResult = bun.getName();
       String expectedResult = name;

       Assert.assertEquals(expectedResult, actualResult);
    }

    //проверяем getPrice()

    @Test
    public void testGetPriceBunClassTest() {
        Bun bun = new Bun(name, price);
        float actualResult = bun.getPrice();
        float expectedResult = price;
        Assert.assertEquals(expectedResult, actualResult, 0.0);
    }
}
