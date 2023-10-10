package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class LionTestWithoutParam {
    @Mock
    Feline feline;
    @Test
    public void CheckDoesHaveManeWithThrow() throws Exception {
        try{
        Lion lion = new Lion(feline, "неведома зверушка");
        }catch (Exception exception){
        String expected ="Используйте допустимые значения пола животного - самец или самка";
        String actual = exception.getMessage();
        assertEquals(expected, actual);
        }
    }
}