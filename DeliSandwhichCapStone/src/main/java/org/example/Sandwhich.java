package org.example;

public class Sandwhich {
    private Integer Size;
    private String BreadType;
    private boolean isToasted;


    public Sandwhich(Integer size, String breadType, boolean isToasted) {
        Size = size;
        BreadType = breadType;
        this.isToasted = isToasted;
    }
}
