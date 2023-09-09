package com.myproject.code.arrayConcept;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondLargestNumberTest {
    @Test
    public void testSum()
    {
        int exceptedSecondNumber = 116;
      int actualSecondNumber =  SecondLargestNumber.main();
        Assertions.assertEquals(exceptedSecondNumber, actualSecondNumber);


    }

}