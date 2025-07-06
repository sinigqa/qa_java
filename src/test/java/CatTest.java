import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CatTest {

    private Feline mockFeline;
    private Cat cat;

    @Before
    public void setUp() {
        mockFeline = mock(Feline.class); // теперь используем Feline, а не Predator
        cat = new Cat(mockFeline);
    }

    @Test
    public void testSound_ReturnsMew() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood_ReturnsCorrectFoodList() throws Exception {
        when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetFood_CallsEatMeatOnce() throws Exception {
        when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        cat.getFood();
        verify(mockFeline, times(1)).eatMeat();
    }
}