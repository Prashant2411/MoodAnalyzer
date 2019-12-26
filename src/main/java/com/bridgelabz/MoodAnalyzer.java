package com.bridgelabz;

public class MoodAnalyzer {
    public String analyze(String message) throws MoodException {
        try {
            if (message.length() == 0)
                throw new MoodException(MoodException.ExceptionType.ENTERED_EMPTY,"Please enter valid input");
            if (message.contains("Sad")||message.contains("sad"))
                return "Sad";
            else
                return "Happy";
        }
        catch (Exception e) {
            throw new MoodException(MoodException.ExceptionType.ENTERED_NULL, "Please enter valid input");
        }
    }
}
