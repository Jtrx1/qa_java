package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    Feline feline;

    @Test
    public void checkGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void checkEatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual =feline.eatMeat();
        assertEquals(expected , actual);
    }
    @Test
    public void checkEatMeatWithTrows() {
        String expected ="Неизвестный вид животного, используйте значение Травоядное или Хищник";
        String actual = assertThrows(Exception.class, () -> feline.getFood("Всеядное")).getMessage();
        assertEquals(expected, actual);
    }
    @Test
    public void checkGetKittensWithoutInputValue(){
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected, actual);
    }
    @Test
    public void checkGetKittensWithInputValue(){
        int expected = 10;
        int actual = feline.getKittens(expected);
        assertEquals(expected, actual);
    }
}