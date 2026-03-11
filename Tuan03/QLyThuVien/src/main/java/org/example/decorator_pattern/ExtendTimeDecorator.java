package org.example.decorator_pattern;

public class ExtendTimeDecorator extends BorrowDecorator {

    public ExtendTimeDecorator(Borrow borrow) {
        super(borrow);
    }

    public String getDescription() {
        return borrow.getDescription() + " + extended borrow time";
    }
}