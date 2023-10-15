package com.example;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class LionTestWithParamThrows {
    String sex;
    boolean hasMane;

    public LionTestWithParamThrows(String sex, boolean hasMane){
        this.sex = sex;
        this.hasMane = hasMane;
    }
    @Parameterized.Parameters
    public static Object[][] lionParam() {
        return new Object[][] {
                {"Кто-то", true},
                {"Кто-то", false},
        };
    }
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    Feline feline;

    @Test
    public void checkDoesHaveManeWithThrow() {
        try{
            Lion lion = new Lion(feline, sex);
            lion.doesHaveMane();
        } catch (Exception exception) {
            String expected ="Используйте допустимые значения пола животного - самец или самка";
            String actual = exception.getMessage();
            assertEquals(expected, actual);
        }
    }
}