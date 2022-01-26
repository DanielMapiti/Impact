package numberrangesummarizer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class NumberRangeSummarizerImplTest {

    //Test collect method
    @Test
    public void testCollect(){
        NumberRangeSummarizerImpl numberRangeSummarizerObj = new NumberRangeSummarizerImpl();
        String input= "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> results =numberRangeSummarizerObj.collect(input);
        assertEquals(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31),results);
    }

    //Test summerizeCollection method
    @Test
    public void testSummerizeCollection(){
        NumberRangeSummarizerImpl numberRangeSummarizerObj = new NumberRangeSummarizerImpl();
        String input= "1,3,6,7,8,12,13,14,15,21,22,23,24,31" ;
        Collection<Integer> collectResults = numberRangeSummarizerObj.collect(input);
        String results = numberRangeSummarizerObj.summarizeCollection(collectResults);
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", results);
    }

    //Test if invalid input throws exception
    @Test
    public void testInput(){
        NumberRangeSummarizerImpl numberRangeSummarizerObj = new NumberRangeSummarizerImpl();
        String input= "a,24,31" ;
        Throwable exception = assertThrows(NumberFormatException.class,
                ()->{numberRangeSummarizerObj.collect(input);} );
    }

}