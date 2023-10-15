package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;
    @Test
    public void checkSoundTest() {
        Cat tom=new Cat(feline);
        Assert.assertEquals("Мяу", tom.getSound());
    }
    @Test
    public void checkEatingFood() throws Exception{
        Cat barsik=new Cat(feline);
        Mockito.lenient().when(feline.eatMeat()).thenReturn(List.of("Kitekat", "Мясо"));
        Assert.assertEquals(List.of("Kitekat", "Мясо"), barsik.getFood());
    }
}