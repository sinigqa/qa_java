import com.example.Cat;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CatTest {

    private Predator mockPredator;
    private Cat cat;

    @Before
    public void setUp() {
        mockPredator = mock(Predator.class);
        cat = new Cat(mockPredator);
    }

    @Test
    public void testSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        when(mockPredator.eatMeat()).thenReturn(List.of("Мышки"));
        List<String> food = cat.getFood();
        verify(mockPredator).eatMeat();
        assertEquals(List.of("Мышки"), food);
    }
}