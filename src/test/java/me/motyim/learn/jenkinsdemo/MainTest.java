package me.motyim.learn.jenkinsdemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void setUpStreams() {
        // After this all System.out.println() statements will come to outContent stream.
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testCase(){

        String expectedOutput  = "Welcome in Jenkins Demo";

        //call main method of class
        Main.main(null);

        String output = outContent.toString().trim();
        assertThat(output, is(expectedOutput));

    }


    @After
    public void cleanUpStreams() {
        //reset after end
        System.setOut(System.out);
    }
}