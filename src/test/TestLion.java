package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;
    Lion lion;

    @Test
    public void testGetFoodReturnList() throws Exception {
        Lion lion = new Lion( feline, "Самец");
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
    @Test
    public void testGetKittensReturnKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        assertEquals(0, lion.getKittens());
    }

    @Test
    public void testLionEatPredatorFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }
    @Test
    public void testDoesHaveManeUnknownSexThrowsException() {
        try {
            lion = new Lion(feline, "sex");
            fail("Ожидается Exception");
        } catch (Exception exception) {
            String expected = "Используйте допустимые значения пола животного - самец или самка";
            String actual = exception.getMessage();
            assertEquals(expected, actual);
        }
    }

}