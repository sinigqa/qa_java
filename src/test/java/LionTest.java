import com.example.Lion;
import com.example.Predator;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LionTest {

    private Predator mockPredator;

    @Before
    public void setUp() {
        mockPredator = mock(Predator.class);
    }

    @Test
    public void testGetFood() throws Exception {
        when(mockPredator.eatMeat()).thenReturn(List.of("Животные"));

        Lion lion = new Lion("Самка", mockPredator);
        List<String> food = lion.getFood();

        verify(mockPredator).eatMeat();
        assertEquals(List.of("Животные"), food);
    }

    @Test
    public void testGetKittens() throws Exception {
        when(mockPredator.getKittens()).thenReturn(2);

        Lion lion = new Lion("Самка", mockPredator);
        int kittens = lion.getKittens();

        verify(mockPredator).getKittens();
        assertEquals(2, kittens);
    }

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        new Lion("Неизвестный", mockPredator);
    }
}
