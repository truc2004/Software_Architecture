package org.example.decorator_pattern;

public class SpecialEditionDecorator extends BorrowDecorator {

    public SpecialEditionDecorator(Borrow borrow) {
        super(borrow);
    }

    public String getDescription() {
        return borrow.getDescription() + " + special edition";
    }
}