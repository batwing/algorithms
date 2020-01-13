package com.algorithms.recruitment.bolt;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class TaxifyWordReverserTest {
    @Test(expected=Exception.class)
    public void reverseWordsTestWithNullInput() throws Exception{
        new TaxifyWordReverser().reverseWords(null);
    }

    @Test
    public void reverseWordsTestWithEmptyInput() throws Exception{
        char[] actual = new TaxifyWordReverser().reverseWords(new char[]{});
        assertEquals(0, actual.length);
    }

    @Test
    public void reverseWordsTestWithCorrectInput() throws Exception{
        char[] expected = new char[]{'I', ' ', 'l','o','v','e',' ','T','a','x','i','f','y'};
        char[] actual = new TaxifyWordReverser().reverseWords(new char[]{'I', ' ', 'e','v','o','l',' ','y','f','i','x','a','T'});
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseWordsTestWithFewSpacesInInput() throws Exception{
        char[] expected = new char[]{'I', ' ', 'l','o','v','e',' ',' ','T','a','x','i','f','y'};
        char[] actual = new TaxifyWordReverser().reverseWords(new char[]{'I', ' ', 'e','v','o','l',' ',' ','y','f','i','x','a','T'});
        assertArrayEquals(expected, actual);
    }


    @Test
    public void reverseWordsTestWithLastSpace() throws Exception{
        char[] expected = new char[]{'I', ' ', 'l','o','v','e',' ','T','a','x','i','f','y',' '};
        char[] actual = new TaxifyWordReverser().reverseWords(new char[]{'I', ' ', 'e','v','o','l',' ','y','f','i','x','a','T', ' '});
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseWordsTestWithouSpaces() throws Exception{
        char[] expected = new char[]{'T','a','x','i','f','y'};
        char[] actual = new TaxifyWordReverser().reverseWords(new char[]{'y','f','i','x','a','T'});
        assertArrayEquals(expected, actual);
    }
}
