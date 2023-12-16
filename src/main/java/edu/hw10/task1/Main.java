package edu.hw10.task1;

import edu.hw10.task1.annotation.Max;
import edu.hw10.task1.annotation.Min;
import edu.hw10.task1.annotation.NotNull;

class MyClass {
    @Min(10)
    @Max(1000)
    private final int intValue;
    @NotNull
    private final String stringValue;

    public MyClass(int intValue, String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    public static MyClass create(int intValue, String stringValue) {
        return new MyClass(intValue, stringValue);
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}

record MyClass2(@Min(10) @Max(12) double value, @NotNull String string) {
    public static MyClass2 start(double value, String string) {
        return new MyClass2(value, string);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        RandomObjectGenerator rog = new RandomObjectGenerator();
        MyClass myClass = rog.nextObject(MyClass.class, "create");
        System.out.println(myClass.getIntValue());
        System.out.println(myClass.getStringValue());
//
//        MyClass myClassFromFactory = rog.nextObject(MyClass.class, "create");
//        System.out.println(myClassFromFactory.getIntValue());
//        System.out.println(myClassFromFactory.getStringValue());
//
//        MyClass2 myClass2 = rog.generateObject(MyClass2.class);
//        System.out.println(myClass2.value());
//        System.out.println(myClass2.string());

        MyClass2 myClassFromFactory3 = rog.nextObject(MyClass2.class, "start");
        System.out.println(myClassFromFactory3.value());
        System.out.println(myClassFromFactory3.string());

    }
}
