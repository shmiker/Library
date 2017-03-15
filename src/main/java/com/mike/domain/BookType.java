package com.mike.domain;

/**
 * Created by mike on 15.02.2017.
 */
public enum BookType {
    Book("книга"), Journal("журнал");

    private String value;

    BookType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static BookType getEnum(String value) {
        for(BookType v : values())
            if(v.getValue().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
