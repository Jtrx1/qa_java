package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Mock
    Feline feline;

    @Test
    public void checkGetFamily() {
        feline.getFamily();
        Mockito.verify(feline).getFamily();
    }
    @Test
    public void checkEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline).eatMeat();
    }
    @Test
    public void checkEatMeatWithTrows() {
        Feline feline = new Feline();
        String expected ="Неизвестный вид животного, используйте значение Травоядное или Хищник";
        String actual = assertThrows(Exception.class, () -> feline.getFood("Всеядное")).getMessage();
        assertEquals(expected, actual);
    }
    @Test
    public void checkGetKittensWithoutInputValue(){
        feline.getKittens();
        Mockito.verify(feline).getKittens();
    }
    @Test
    public void checkGetKittensWithInputValue(){
        int expected = 10;
        feline.getKittens(expected);
        Mockito.verify(feline).getKittens(expected);
    }
}