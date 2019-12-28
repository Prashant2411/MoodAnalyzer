import com.bridgelabz.MoodAnalyzer;
import com.bridgelabz.MoodAnalyzerFactory;
import com.bridgelabz.MoodException;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerTest {
    Constructor<?> constructor=null;

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
            moodAnalyzer.analyze();
        } catch (MoodException e){
            Assert.assertEquals("Please enter valid input",e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyzerObject_whenProper_shouldReturnObject() {
        try {
            constructor = Class.forName("com.bridgelabz.MoodAnalyzer").getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Object myObj = constructor.newInstance("I am happy now");
            MoodAnalyzer moodAnalyzer = (MoodAnalyzer) myObj;
            try {
                String mood = moodAnalyzer.analyze();
                Assert.assertEquals("Happy", mood);
            }
            catch (MoodException e) {
                e.printStackTrace();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClass_whenProper_shouldReturnObject() {
        MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("Please enter valid input");
        String mood = moodAnalyzer.analyze();
        Assert.assertEquals("Sad",mood);
    }

    @Test
    public void givenMoodAnalyzerClass_whenIsProper_shouldReturnObject() {
        MoodAnalyzer obj1 = new MoodAnalyzer("I am Happy");
        MoodAnalyzer obj2 = MoodAnalyzerFactory.createMoodAnalyzer("I am Happy");
        Assert.assertEquals(obj1, obj2);
    }

    @Test
    public void givenClassName_whenImproper_shouldReturnException() {
        try {
            constructor = Class.forName("com.bridgelabz.MoodAnalyser").getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            try{
                throw new MoodException(MoodException.ExceptionType.NO_CLASS_FOUND, "No such Class found");
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
    }

    @Test
    public void givenClassName_whenConstructorImproper_shouldReturnException() {
        try {
            constructor = Class.forName("com.bridgelabz.MoodAnalyzer").getConstructor(Character.class);
        } catch (NoSuchMethodException e) {
            try{
                throw new MoodException(MoodException.ExceptionType.NO_METHOD_FOUND, "No such method found");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    8
}
