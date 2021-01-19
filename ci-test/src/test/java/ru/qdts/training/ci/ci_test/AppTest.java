package ru.qdts.training.ci.ci_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

/**
 * Unit test for simple App.
 */
@DisplayName("Hello World Test")
public class AppTest 
{
	private final static ByteArrayOutputStream out = new ByteArrayOutputStream();
	private final static ByteArrayOutputStream err = new ByteArrayOutputStream();
	private final static PrintStream originalOut = System.out;
	private final static PrintStream originalErr = System.err;
	
	@BeforeAll
	public static void catchIO() {
	    System.setOut(new PrintStream(out));
	    System.setErr(new PrintStream(err));
	}

	@AfterAll
	public static void releaseIO() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	@Test
	@DisplayName("Hello World Test")
    public void checkOutput()
    {
        App.main(new String[0]);
        assertEquals("Hello World!" + System.lineSeparator(), out.toString());
    }
}
