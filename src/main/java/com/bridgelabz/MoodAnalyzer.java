package com.bridgelabz;

import java.util.Objects;

public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyzer that = (MoodAnalyzer) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    public MoodAnalyzer(String message) {
        this.message=message;
    }

    public String analyze() throws MoodException {
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
