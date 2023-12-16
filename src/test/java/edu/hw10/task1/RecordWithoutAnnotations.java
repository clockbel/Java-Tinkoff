package edu.hw10.task1;

record RecordWithoutAnnotations(int value, String string) {
    public static RecordWithoutAnnotations start(int value, String string) {
        return new RecordWithoutAnnotations(value, string);
    }
}
