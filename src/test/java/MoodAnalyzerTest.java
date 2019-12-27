import com.bridgelabz.MoodAnalyzer;
import com.bridgelabz.MoodException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;

public class MoodAnalyzerTest {
    @Test
    public void whenGivenSad_shouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am sad right now");
        String message = moodAnalyzer.analyze();
        Assert.assertEquals("Sad", message);
    }

    @Test
    public void whenGivenHappy_shouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am happy now");
        String message = moodAnalyzer.analyze();
        Assert.assertEquals("Happy", message);
    }

    @Test
    public void whenGivenSadMessageWithAlphabetCapital_shouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am Sad now");
        String message = moodAnalyzer.analyze();
        Assert.assertEquals("Sad", message);
    }

    @Test
    public void whenGivenNullInput_shouldReturnInvalid() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try {
         //   ExpectedException exceptionRule = ExpectedException.none();
         //   exceptionRule.expect(MoodException.class); Used only when exception class extends Exception
            moodAnalyzer.analyze();
        } catch (MoodException e);
    }
}
