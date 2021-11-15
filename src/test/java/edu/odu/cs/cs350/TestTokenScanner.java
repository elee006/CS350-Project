package edu.odu.cs.cs350;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
/* https://git.cs.odu.edu/zeil/jflexdemo/-/blob/master/src/test/java/edu/odu/cs/cs350/jflexdemo/TestScanner.java
*/
public class TestTokenScanner{

    @Test 
    public void testScanner(){
        File file = new File("C:\\CS350-Project\\test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String inputString = null;

        inputString = br.readLine();

        Reader input = new StringReader(inputString);
        TokenStream ts = new TokenStream(input);
        ArrayList<token> tokens = new ArrayList<token>();
        









    }
    
}
