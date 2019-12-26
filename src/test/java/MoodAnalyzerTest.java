import com.bridgelabz.MoodAnalyzer;
import com.bridgelabz.MoodException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyzerTest {
    @Test
    public void whenGivenSad_shouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String message = moodAnalyzer.analyze("I am sad right know");
        Assert.assertEquals("Sad", message);
    }

    @Test
    public void whenGivenHappy_shouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String message = moodAnalyzer.analyze("I am happy right know");
        Assert.assertEquals("Happy", message);
    }

    @Test
    public void whenGivenSadMessageWithAlphabetCapital_shouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String message = moodAnalyzer.analyze("I am Sad right know");
        Assert.assertEquals("Sad", message);
    }

    @Test
    public void whenGivenNullInput_shouldReturnInvalid() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String message = null;
        try {
         //   ExpectedException exceptionRule = ExpectedException.none();
         //   exceptionRule.expect(MoodException.class); Used only when exception class extends Exception
            moodAnalyzer.analyze(null);
        } catch (MoodException e) {
            Assert.assertEquals("Please enter valid input", e.getMessage());
        }
    }
}
