package com.algorithms.recruitment.classic;

import com.algorithms.recruitment.classic.strings.UniqueCharacters;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UniqueCharactersTest {
    @Test
    public void isUniqueTimeOnMemoryOconstant1TestWithDuplicates() throws Exception{
        assertFalse(new UniqueCharacters("test").isUniqueTimeOnMemoryOconstant1());
    }

    @Test
    public void isUniqueTimeOnMemoryOconstant1TestWithoutDuplicates() throws Exception{
        assertTrue(new UniqueCharacters("abcdefghijklmn").isUniqueTimeOnMemoryOconstant1());
    }

    @Test
    public void isUniqueTimeOnMemoryOconstant2TestWithDuplicates() throws Exception{
        assertFalse(new UniqueCharacters("test").isUniqueTimeOnMemoryOconstant2());
    }

    @Test
    public void isUniqueTimeOnMemoryOconstant2TestWithoutDuplicates() throws Exception{
        assertTrue(new UniqueCharacters("abcdefghijklmn").isUniqueTimeOnMemoryOconstant2());
    }
}
