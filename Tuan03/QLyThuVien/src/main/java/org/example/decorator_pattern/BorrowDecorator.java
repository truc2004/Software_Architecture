package org.example.decorator_pattern;

public abstract class BorrowDecorator implements Borrow {

    protected Borrow borrow;

    public BorrowDecorator(Borrow borrow) {
        this.borrow = borrow;
    }

    public String getDescription() {
        return borrow.getDescription();
    }
}