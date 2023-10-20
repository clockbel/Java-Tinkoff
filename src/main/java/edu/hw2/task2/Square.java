package edu.hw2.task2;

public class Square extends Rectangle {
    private boolean checkWidht = false;
    private boolean checkHeight = false;

    @Override
    void setWidth(int width) {
        if (!checkHeight) {
            super.setHeight(width);
        }
        super.setWidth(width);
        checkWidht = true;
    }

    @Override
    void setHeight(int height) {
        super.setHeight(height);
        if (!checkWidht) {
            super.setWidth(height);
        }
        checkHeight = true;
    }
}
