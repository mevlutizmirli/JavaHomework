package util;

public enum Grade {

    //We defined the numbers corresponding to the letters.
    F("F", 0),
    D("D", 1),
    C("C", 2),
    B("B", 3),
    A("A", 4);

    private String stringValue;
    private int numericValue;

    //A constructor is defined for enum elements.

    Grade(String stringValue, int numericValue) {
        this.stringValue = stringValue;
        this.numericValue = numericValue;
    }

    //Get methods are defined.
    public String getStringValue() {
        return stringValue;
    }

    public int getNumericValue() {
        return numericValue;
    }

    // toString method
    @Override
    public String toString() {
        return "Grade " + this.stringValue
                + " corresponds to numeric grade of "
                + this.numericValue;
    }
}
