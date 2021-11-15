package edu.odu.cs.cs350;
import org.junit.jupiter.api.Test;
import java.io.File;

class TestDirectoryPath{

    @Test
    void TestDirectoryPathconstructor(){
        String directoryName = "cFolder";
        String directoryName2 = " cFolder ";
        File directory = new File(directoryName);
        File directory2 = new File(directoryName2);
        assertEquals(directory.getName(), "cFolder");
        assertNotEquals(directory2.getName(), " cFolder ");

    }
    
    @Test
    void TestsetDirFiles(){
        String[] testlist = {"test1.C","test2.cpp","test3.H","test4.hpp"};
        String[] files; 
        setDirFiles(testlist);
    }

    @Test
    void TestprintDirFiles(){
        

    }

    @Test
    void TestnumofFiles(){
        String[] testlist = {"test1.C","test2.cpp","test3.H","test4.hpp"};
        assertEquals(testlist.length, 4);


    }

    
}
        // String directoryName = "cFolder";
        // String directoryName2 = " cFolder ";
        // AssertEquals(directoryName.getDirectory(), "cFolder");
        // AssertNotEquals(directoryName2.getDirectory(), " cFolder ");