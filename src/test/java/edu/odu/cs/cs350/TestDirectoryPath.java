package edu.odu.cs.cs350;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
class TestDirectoryPath{
    @Test
    void TestDirectoryPathconstructor(){
        String directoryName = "cFolder";
        String directoryName2 = " cFolder ";
        File directory = new File(directoryName);
        File directory2 = new File(directoryName2.trim());
        assertEquals(directory.getName(), "cFolder");
        assertNotEquals(directory2.getName(), " cFolder ");
    }
    @Test
    void TestprintDirFiles(){
        
    }
    @Test
    void TestnumofFiles(){
        String[] testlist = {"test1.C","test2.cpp","test3.H","test4.hpp"};
        assertEquals(testlist.length, 4);

    }
    @Test
    void TestgetCFiles(){
        

    }
    
}