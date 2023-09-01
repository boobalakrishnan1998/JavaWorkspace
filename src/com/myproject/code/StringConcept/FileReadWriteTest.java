package com.myproject.code.StringConcept;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;


class FileReadWriteTest {

    @Test
    void testFileReadOperation(){

        FileReadWrite.fileReadWrite();

    }
    @Test
    @Disabled
    void testGetFileContentByFilePath() throws FileNotFoundException {
       String expectedStr= "hey dude";
       String acualStr= FileReadWrite.getFileContentByFilePath("C:\\Users\\DELL\\Music\\JavaWorkspace\\src\\com\\myproject\\code\\StringConcept\\sample").toString();
        Assertions.assertEquals(expectedStr,acualStr);
    }
    @Test
     void testGetFileContentException() {
        String expectedStr= "hey dude";
        String filePath="C:\\sers\\DELL\\Music\\JavaWorkspace\\src\\com\\myproject\\code\\StringConcept\\sample";
        Assertions.assertThrows(FileNotFoundException.class, () -> FileReadWrite.getFileContentByFilePath(filePath));
    }
    @Test
    void testGetFileContentByFilePathAndRemoveSpeacial() throws IOException {
        String expectedStr= "hey dude";
        String acualStr= FileReadWrite.readFileByChar("C:\\Users\\DELL\\Music\\JavaWorkspace\\src\\com\\myproject\\code\\StringConcept\\sample");
        Assertions.assertEquals(expectedStr,acualStr);
    }



}