package org.example.lession9.lession3;

public class Phone {
    private final String value;
    private final PhoneType type;

    public Phone(String value, PhoneType type) {
        this.value = value;
        this.type = type;
    }
    public String value() { return value; }
    public PhoneType type() { return type; }
}
