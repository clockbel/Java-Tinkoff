package edu.hw2.task4;

public record CallingInfo(String className, String methodName) {
    private static final int COUNT_OF_STACK = 3;


    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= COUNT_OF_STACK) {
            StackTraceElement callingMethod = stackTrace[2];
            String className = callingMethod.getClassName();
            String methodName = callingMethod.getMethodName();
            return new CallingInfo(className, methodName);
        } else {
            return null;
        }
    }
}
