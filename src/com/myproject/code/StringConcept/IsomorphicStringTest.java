package com.myproject.code.StringConcept;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing Isomorphic")
class IsomorphicStringTest {

    @Test
    @DisplayName("test non isomorphic ")
    public void testNonIsomorphic(){
       boolean isIsomorphic= IsomorphicString.isIsomorphic("bar","foo");
        Assertions.assertFalse(isIsomorphic);
    }
    @Test
    @DisplayName("test isomorphic ")
    public void testIsomorphic(){
        boolean isIsomorphic= IsomorphicString.isIsomorphic("bar","for");
        Assertions.assertTrue(isIsomorphic);
    }

    @Test
    @DisplayName("test isomorphic with different length")
    public void testDiffLenIsomorphic(){
        boolean isIsomorphic= IsomorphicString.isIsomorphic("fooo","foo");
        Assertions.assertFalse(isIsomorphic);
    }




}