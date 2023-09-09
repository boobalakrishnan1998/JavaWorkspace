package com.myproject.CoforgeCodingRound;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

@DisplayName("Test Longest SubString without repeating characters")
class MainTest {
    /*Positive
      multiple Character
      single character
      continuous Character
      Check File Reader
      Check All SubString Length
     //Nagative
       Check FileNotFound Exception if invalid filePath
       Check valid input String or not
       Check with Empty String
     */

    @Test
    @DisplayName("Test multiple different Characters")
    public void testMultipleCharacter() throws FileNotFoundException {
        String filePath="C:\\Users\\boobalakrishnan.v\\Documents\\CodeTest\\src\\input";
        Integer[] expected={3,1,3};
        Integer[] actual= Main.findAllLongestSubString(filePath).toArray(new Integer[0]);
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    @DisplayName("Test single  Character")
    public void testSingleCharacter() throws FileNotFoundException {
        String filePath="C:\\Users\\boobalakrishnan.v\\Documents\\CodeTest\\src\\SingleCharacterFile";
        Integer[] expected={1,1,1,1,1};
        Integer[] actual= Main.findAllLongestSubString(filePath).toArray(new Integer[0]);
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    @DisplayName("Test continuous  Characters")
    public void testcontinuousCharacter() throws FileNotFoundException {
        String filePath="C:\\Users\\boobalakrishnan.v\\Documents\\CodeTest\\src\\FileWithContinuousCharcter";
        Integer[] expected={1,1,1};
        Integer[] actual= Main.findAllLongestSubString(filePath).toArray(new Integer[0]);
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Test multiple different Characters")
    public void testFileReader() throws FileNotFoundException {
        String filePath="C:\\Users\\boobalakrishnan.v\\Documents\\CodeTest\\src\\input";
        String[] expected={"abcabcbb","bbbbb","pwwkew"};
        String[] actual= Main.getStringFromFile(filePath).toArray(new String[0]);
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    @DisplayName("Test fileNotFoundException")
    public void testFileReaderWithInvalidPath() throws FileNotFoundException {
        String filePath="C:\\Users\\boobalakrishnan.v\\Documents\\CodeTest\\input";
        Assertions.assertThrows(FileNotFoundException.class,()-> Main.getStringFromFile(filePath));
    }
    @Test
    @DisplayName("Test Empty file")
    public void testFileReaderWithEmptyString() {
        String filePath="C:\\Users\\boobalakrishnan.v\\Documents\\CodeTest\\src\\EmptyFile";
        Assertions.assertThrows(InputMismatchException.class,()-> Main.getStringFromFile(filePath));
    }


}