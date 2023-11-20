package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import static edu.hw4.ValidationError.setErrorsToString;
import static edu.hw4.ValidationError.validateAnimal;

public final class Tasks {
    private Tasks() {
    }

    public static List<Animal> task1SortedAnimals(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        return animals.stream().sorted(Comparator.comparing(Animal::height)).toList();
    }

    public static List<Animal> task2SortedAnimals(List<Animal> animals, int k) {
        if (animals == null) {
            return null;
        }
        return animals.stream().sorted(Comparator.comparing(Animal::weight).reversed()).limit(k).toList();
    }

    public static Map<Animal.Type, Integer> task3CountAnimals(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        return animals.stream().collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(value -> 1)));
    }

    public static Animal task4MaxLenghtAnimal(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        return animals.stream().max(Comparator.comparing(Animal::name, Comparator.comparingInt(String::length)))
            .orElse(null);
    }

    public static Animal.Sex task5CountMale(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        long maleAnimal = animals.stream().filter(animal -> animal.sex() == Animal.Sex.M).count();
        long femaleAnimal = animals.stream().filter(animal -> animal.sex() == Animal.Sex.F).count();
        return maleAnimal > femaleAnimal ? Animal.Sex.M : Animal.Sex.F;
    }

    public static Map<Animal.Type, Animal> task6HeavyAnimal(List<Animal> animals) {
        return animals.stream().collect(Collectors.toMap(
            Animal::type,
            animal -> animal,
            (first, second) -> first.weight() > second.weight() ? first : second
        ));
    }

    public static Animal task7OldestAnimal(List<Animal> animals) {
        return animals.stream().max(Comparator.comparing(Animal::age)).orElse(null);
    }

    public static Optional<Animal> task8HeavyAnimalShort(List<Animal> animals, int k) {
        return animals.stream().filter(animal -> (animal.height() < k)).max(Comparator.comparing(Animal::weight));
    }

    public static long task9CountPaws(List<Animal> animals) {
        return animals.stream().mapToInt(Animal::paws).sum();
    }

    public static List<Animal> task10AgeNotEqualPaws(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.age() != animal.paws()).toList();
    }

    private static final int ONE_HUNDRED_HEIGHT = 100;

    public static List<Animal> task11BitesAnimals(List<Animal> animals) {
        return animals.stream().filter(animal -> (animal.bites() && animal.height() > ONE_HUNDRED_HEIGHT)).toList();
    }

    public static Integer task12WeightMoreHeight(List<Animal> animals) {
        return (int) animals.stream().filter(animal -> animal.weight() > animal.height()).count();
    }

    public static List<Animal> task13NameMoreTwoWord(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.name().split(" ").length > 2).toList();

    }

    public static Boolean task14DogMoreHeightK(List<Animal> animals, int k) {
        return animals.stream().anyMatch(animal -> (animal.type() == Animal.Type.DOG && animal.height() > k));
    }

    public static Map<Animal.Type, Integer> task15SumWeight(List<Animal> animals, int k, int i) {
        return animals.stream().filter(animal -> animal.age() >= k && animal.age() <= i)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    public static List<Animal> task16SortedThreeList(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name)).toList();
    }

    public static Boolean task17DogSpider(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.type() == Animal.Type.SPIDER && animal.bites()).count()
            > animals.stream().filter(animal -> animal.type() == Animal.Type.DOG && animal.bites()).count();
    }

    public static Animal task18HeavyFish(List<List<Animal>> animals) {
        return animals.stream().flatMap(List::stream).filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparing(Animal::weight)).orElse(null);
    }

    public static Map<String, Set<ValidationError>> task19MapValidationError(List<Animal> animals) {
        return animals.stream().collect(Collectors.toMap(Animal::name, ValidationError::validateAnimal)).entrySet()
            .stream().filter(state -> !state.getValue().isEmpty())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, String> task20MapValidationError(List<Animal> animals) {
        return animals.stream().collect(Collectors.toMap(
            Animal::name,
            animal -> setErrorsToString(validateAnimal(animal))
        ));
    }
}
