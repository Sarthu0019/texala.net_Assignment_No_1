package com.assignment.Junit;


import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static com.assignment.service.Service.getUrlResponseBody;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


public class Junit {



    /* executed before every test: create temporary files */
    @Test
    public void testFileCreated() {


        try {
            Path numbers  = Path.of("web-content.txt");
            getUrlResponseBody("https://www.google.co.in/");
            assertTrue(Files.exists(numbers));
        }
        catch( Exception e ) {
            System.err.println(
                    "error creating temporary test file in " +
                            e.getMessage() );
            fail();
        }
    }

}
