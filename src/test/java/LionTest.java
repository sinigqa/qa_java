import com.example.Lion;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LionTest {

    private Feline mockFeline;
    private Lion lionMale;
    private Lion lionFemale;

    @Before
    public void setUp() throws Exception {
        mockFeline = mock(Feline.class);
        lionMale = new Lion("Самец", mockFeline);
        lionFemale = new Lion("Самка", mockFeline);
    }

    @Test
    public void testGetFood_ReturnsCorrectFoodList() throws Exception {
        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food = lionMale.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetFood_CallsGetFoodOnce() throws Exception {
        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        lionMale.getFood();
        verify(mockFeline, times(1)).getFood("Хищник");
    }

    @Test
    public void testGetKittens_ReturnsDefaultCountOfOne() throws Exception {
        when(mockFeline.getKittens()).thenReturn(1);
        int kittens = lionMale.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    public void testDoesHaveMane_Male_ReturnsTrue() {
        assertTrue(lionMale.doesHaveMane());
    }

    @Test
    public void testDoesHaveMane_Female_ReturnsFalse() {
        assertFalse(lionFemale.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testInvalidSex_ThrowsException() throws Exception {
        new Lion("Неизвестный", mockFeline);
    }
}
