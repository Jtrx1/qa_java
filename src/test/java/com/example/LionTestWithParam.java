package com.example;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class LionTestWithParam {
    String sex;
    boolean hasMane;

    public LionTestWithParam(String sex, boolean hasMane){
        this.sex = sex;
        this.hasMane = hasMane;
    }
    @Parameterized.Parameters
    public static Object[][] lionParam() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Feline feline;

    @Test
    public void checkGetKittens() throws Exception {
        Lion lion = new Lion(feline, sex);
        int expected = 1;
        Mockito.when(feline.getKittens()).thenReturn(expected);
        int actual = lion.getKittens();
        assertEquals(expected, actual);
    }
    @Test
    public void checkGetFood() throws Exception {
        Lion lion = new Lion(feline, sex);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual =lion.getFood();
        assertEquals(expected, actual);
    }
    @Test
    public void checksHasMane() throws Exception {
        Lion lion = new Lion(feline, sex);
        assertEquals(hasMane, lion.doesHaveMane());
    }

}