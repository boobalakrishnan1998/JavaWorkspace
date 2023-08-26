package com.myproject.code.arrayConcept;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MediumOfTwoSortedArrayTest {

    @Test
    void TestMediumOfTwoArray(){
       double sum= MediumOfTwoSortedArray.getMeddle(new int[]{1,2},new int[]{3,4});
        Assertions.assertEquals(2.5, sum);
    }


}