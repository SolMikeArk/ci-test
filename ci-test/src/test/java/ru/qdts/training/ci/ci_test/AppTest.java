package ru.qdts.training.ci.ci_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;

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
	private final static PipedOutputStream pipe = new PipedOutputStream();
	private final static ByteArrayOutputStream out = new ByteArrayOutputStream();
	private final static ByteArrayOutputStream err = new ByteArrayOutputStream();
	
	private final static InputStream originalIn = System.in;
	private final static PrintStream originalOut = System.out;
	private final static PrintStream originalErr = System.err;
	
	@BeforeAll
	public static void catchIO() throws IOException {
	    System.setOut(new PrintStream(out));
	    System.setErr(new PrintStream(err));
	    System.setIn(new PipedInputStream(pipe));
	}

	@AfterAll
	public static void releaseIO() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	    System.setIn(originalIn);
	}
		
	@Test
	@DisplayName("Test Main")
    public void testMain() throws IOException
    {
        String name = "Ivan";
		var in = new PrintWriter(new OutputStreamWriter(pipe), true);
        in.println(name);
        App.main(new String[0]);
        String [] output = out.toString().split(System.lineSeparator());
        assertEquals("Enter your name, please", output[0]);
        assertEquals("Hello, Ivan!", output[1]);
    }
}	

