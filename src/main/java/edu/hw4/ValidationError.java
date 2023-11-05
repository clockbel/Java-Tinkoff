package edu.hw4;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class ValidationError extends RuntimeException {
    private final IncorrectState incorrectState;
    private final String incorrectMessage;

    public enum IncorrectState {
        NAME,
        TYPE,
        SEX,
        AGE,
        HEIGHT,
        WEIGHT
    }

    public ValidationError(IncorrectState state, String massage) {
        this.incorrectState = state;
        this.incorrectMessage = massage;
    }

    public IncorrectState getIncorrectState() {
        return incorrectState;
    }

    public String getIncorrectMessage() {
        return incorrectMessage;
    }

    public static Set<ValidationError> validateAnimal(Animal animal) {
        Set<ValidationError> errorSet = new LinkedHashSet<>();
        errorSet.addAll(errorName(animal));
        errorSet.addAll(errorType(animal));
        errorSet.addAll(errorSex(animal));
        errorSet.addAll(errorAge(animal));
        errorSet.addAll(errorHeight(animal));
        errorSet.addAll(errorWeight(animal));
        return errorSet;
    }

    @SuppressWarnings("MagicNumber")
    private
    static Set<ValidationError> errorName(Animal animal) {
        Set<ValidationError> errorSet = new LinkedHashSet<>();
        if (animal.name() == null || animal.name().isEmpty()) {
            errorSet.add(new ValidationError(IncorrectState.NAME, "Name is empty or equal null"));
        } else if (animal.name().length() < 3) {
            errorSet.add(new ValidationError(IncorrectState.NAME, "Name is short"));
        } else if (animal.name().length() > 20) {
            errorSet.add(new ValidationError(IncorrectState.NAME, "Name is long"));
        }
        return errorSet;
    }

    private static Set<ValidationError> errorType(Animal animal) {
        Set<ValidationError> errorSet = new HashSet<>();

        if (animal.type() == null) {
            errorSet.add(new ValidationError(IncorrectState.TYPE, "Type is null"));
        }
        return errorSet;
    }

    private static Set<ValidationError> errorSex(Animal animal) {
        Set<ValidationError> errorSet = new HashSet<>();

        if (animal.sex() == null) {
            errorSet.add(new ValidationError(IncorrectState.SEX, "Sex is null"));
        }
        return errorSet;
    }

    private static Set<ValidationError> errorAge(Animal animal) {
        Set<ValidationError> errorSet = new HashSet<>();

        if (animal.age() < 0) {
            errorSet.add(new ValidationError(IncorrectState.AGE, "Age < 0"));
        }
        return errorSet;
    }

    private static Set<ValidationError> errorHeight(Animal animal) {
        Set<ValidationError> errorSet = new HashSet<>();

        if (animal.height() < 0) {
            errorSet.add(new ValidationError(IncorrectState.HEIGHT, "Height < 0"));
        }
        return errorSet;
    }

    private static Set<ValidationError> errorWeight(Animal animal) {
        Set<ValidationError> errorSet = new HashSet<>();

        if (animal.weight() < 0) {
            errorSet.add(new ValidationError(IncorrectState.WEIGHT, "Weight < 0"));
        }
        return errorSet;
    }

    public static String setErrorsToString(Set<ValidationError> set) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Errors:");
        for (ValidationError i : set) {
            stringBuilder.append(i.incorrectMessage).append("; ");
        }
//        if ) {
//            stringBuilder.append(" NAME: Name is empty or equal null;");
//        }
//        if (set.contains(new ValidationError(IncorrectState.NAME, "Name is short"))) {
//            stringBuilder.append(" NAME: Name is short;");
//        }
//        if (set.contains(new ValidationError(IncorrectState.NAME, "Name is long"))) {
//            stringBuilder.append(" NAME: Name is long;");
//        }
//        if (set.contains(new ValidationError(IncorrectState.TYPE, "Type is null"))) {
//            stringBuilder.append(" TYPE: Type is null");
//        }
//        if (set.contains(new ValidationError(IncorrectState.SEX, "Sex is null"))) {
//            stringBuilder.append(" SEX: Sex is null");
//        }
//        if (set.contains(new ValidationError(IncorrectState.AGE, "Age < 0"))) {
//            stringBuilder.append(" AGE: Age < 0");
//        }
//        if (set.contains(new ValidationError(IncorrectState.HEIGHT, "Height < 0"))) {
//            stringBuilder.append(" HEIGHT: Height < 0");
//        }
//        if (set.contains(new ValidationError(IncorrectState.WEIGHT, "Weight < 0"))) {
//            stringBuilder.append(" WEIGHT: Weight < 0");
//        }
        return stringBuilder.toString();
    }
}
