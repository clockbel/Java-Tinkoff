package edu.hw1;

public final class Task7 {
    private Task7() {
    }

    public static int rotateLeft(int number, int shift) {
        int newNumber = number;
        int shiftCount = shift;
        if (newNumber < 0) {
            newNumber = -newNumber;
        }
        int numBits = (Integer.toBinaryString(newNumber)).length();
        shiftCount %= numBits;
        int res = (newNumber << shiftCount) | (newNumber >> (numBits - shiftCount));
        int rankRes = (int) Math.pow(2, numBits);
        if (number != Integer.MAX_VALUE) {
            rankRes -= 1;
        }
        return res & rankRes;
    }

    public static int rotateRight(int number, int shift) {
        int newNumber = number;
        int shiftCount = shift;
        if (newNumber < 0) {
            newNumber = -newNumber;
        }
        int numBits = (Integer.toBinaryString(newNumber)).length();
        shiftCount %= numBits;
        int res = (newNumber >> shiftCount) | (newNumber << (numBits - shiftCount));
        int rankRes = (int) Math.pow(2, numBits);
        if (number != Integer.MAX_VALUE) {
            rankRes -= 1;
        }
        return res & rankRes;
    }
}
