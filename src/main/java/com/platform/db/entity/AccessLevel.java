package com.platform.db.entity;

public enum AccessLevel {

    ADMIN(0, "Administrator"),
    USER(1, "User"),
    GUEST(2, "Root");

    private Byte value;
    private String description;

    AccessLevel(int value, String description)
    {
        this.value = (byte)value;
        this.description = description;
    }

    @Override
    public String toString()
    {
        return "AccessLevel{" +
                value +
                ": " + description +
                '}';
    }

    public Byte code()
    {
        return value;
    }

    public String description()
    {
        return description;
    }
}
