package edu.hw4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import static edu.hw4.ValidationError.validateAnimal;
import static edu.hw4.ValidationError.setErrorsToString;

public class Tasks {
    private final static Logger LOGGER = LogManager.getLogger();

    public static List<Animal> Task1SortedAnimals(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        return animals.stream().sorted(Comparator.comparing(Animal::height)).toList();
    }

    public static List<Animal> Task2SortedAnimals(List<Animal> animals, int k) {
        if (animals == null) {
            return null;
        }
        return animals.stream().sorted(Comparator.comparing(Animal::weight).reversed()).limit(k).toList();
    }

    public static Map<Animal.Type, Integer> Task3CountAnimals(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        return animals.stream().collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(value -> 1)));
    }

    public static Animal Task4MaxLenghtAnimal(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        return animals.stream().max(Comparator.comparing(Animal::name, Comparator.comparingInt(String::length)))
            .orElse(null);
    }

    public static Animal.Sex Task5CountMale(List<Animal> animals) {
        if (animals == null) {
            return null;
        }
        long maleAnimal = animals.stream().filter(animal -> animal.sex() == Animal.Sex.M).count();
        long femaleAnimal = animals.stream().filter(animal -> animal.sex() == Animal.Sex.F).count();
        return maleAnimal > femaleAnimal ? Animal.Sex.M : Animal.Sex.F;
    }

    public static Map<Animal.Type, Animal> Task6HeavyAnimal(List<Animal> animals) {
        return animals.stream().collect(Collectors.toMap(
            Animal::type,
            animal -> animal,
            (first, second) -> first.weight() > second.weight() ? first : second
        ));
    }

    public static Animal Task7OldestAnimal(List<Animal> animals) {
        return animals.stream().max(Comparator.comparing(Animal::age)).orElse(null);
    }

    public static Optional<Animal> Task8HeavyAnimalShort(List<Animal> animals, int k) {
        return animals.stream().filter(animal -> (animal.height() < k)).max(Comparator.comparing(Animal::weight));
    }

    public static long Task9CountPaws(List<Animal> animals) {
        return animals.stream().mapToInt(Animal::paws).sum();
    }

    public static List<Animal> Task10AgeNotEqualPaws(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.age() != animal.paws()).toList();
    }

    public static List<Animal> Task11BitesAnimals(List<Animal> animals) {
        return animals.stream().filter(animal -> (animal.bites() && animal.height() > 100)).toList();
    }

    public static Integer Task12WeightMoreHeight(List<Animal> animals) {
        return (int) animals.stream().filter(animal -> animal.weight() > animal.height()).count();
    }

    public static List<Animal> Task13NameMoreTwoWord(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.name().split(" ").length > 2).toList();

    }

    public static Boolean Task14DogMoreHeightK(List<Animal> animals, int k) {
        return animals.stream().anyMatch(animal -> (animal.type() == Animal.Type.DOG && animal.height() > k));
    }

    public static Integer Task15SumWeight(List<Animal> animals, int k, int i) {
        return (int) animals.stream().filter(animal -> animal.weight() > k && animal.weight() < i)
            .mapToInt(Animal::weight).sum();
    }

    public static List<Animal> Task16SortedThreeList(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name)).toList();
    }

    public static Boolean Task17DogSpider(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.type() == Animal.Type.DOG).count() >
            animals.stream().filter(animal -> animal.type() == Animal.Type.SPIDER).count();
    }

    public static Animal Task18HeavyFish(List<List<Animal>> animals) {
        return animals.stream().flatMap(List::stream).filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparing(Animal::weight)).orElse(null);
    }

    public static Map<String, Set<ValidationError>> Task19MapValidationError(List<Animal> animals) {
        return animals.stream().collect(Collectors.toMap(Animal::name, ValidationError::validateAnimal)).entrySet()
            .stream().filter(state -> !state.getValue().isEmpty())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, String> Task20MapValidationError(List<Animal> animals) {
        return animals.stream().collect(Collectors.toMap(
            Animal::name,
            animal -> setErrorsToString(validateAnimal(animal))
        ));
    }

    public static void main(String[] args) {
        Animal first = new Animal("Marcis", Animal.Type.CAT, Animal.Sex.F, 4, 500, 2000, true);
        Animal second = new Animal("Lord Richard", Animal.Type.CAT, Animal.Sex.M, 2, 50, 4000, true);
        Animal third = new Animal("Tom Gun", Animal.Type.CAT, Animal.Sex.M, 3, 300, 1000, true);
        Animal fourth = new Animal("Tomas", Animal.Type.DOG, Animal.Sex.M, 1, 400, 100, true);
        Animal fifth = new Animal("", null, null, -10, -10, -10, false);
        List<Animal> zoo = new ArrayList<>();
        zoo.add(first);
        zoo.add(second);
        zoo.add(third);
        zoo.add(fourth);
        zoo.add(fifth);
//        LOGGER.info(Task1SortedAnimals(zoo));
//        LOGGER.info(Task2SortedAnimals(zoo, 2));
//        LOGGER.info(Task3CountAnimals(zoo));
//        LOGGER.info(Task4MaxLenghtAnimal(zoo));
//        LOGGER.info(Task5CountMale(zoo));
//        LOGGER.info(Task6HeavyAnimal(zoo));
//        LOGGER.info(Task7OldestAnimal(zoo));
//        LOGGER.info(Task8HeavyAnimalShort(zoo, 3));
//        LOGGER.info(Task9CountPaws(zoo));
//        LOGGER.info(Task10AgeNotEqualPaws(zoo));
//        LOGGER.info(Task11BitesAnimals(zoo));
//        LOGGER.info(Task12WeightMoreHeight(zoo));
//        LOGGER.info(Task13NameMoreTwoWord(zoo));
//        LOGGER.info(Task14DogMoreHeightK(zoo, 300));
        LOGGER.info(Task19MapValidationError(zoo));
        LOGGER.info(Task20MapValidationError(zoo));
    }
}
