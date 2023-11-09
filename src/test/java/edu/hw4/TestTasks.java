package edu.project2;

import edu.hw4.Animal;
import edu.hw4.Tasks;
import edu.hw4.ValidationError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class TestTasks {
    @Test
    @DisplayName("Task1")
    public void Test1() {
        Animal a = new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 1, 50, 10, true);
        Animal b = new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 1, 60, 10, true);
        Animal c = new Animal("Dog3", Animal.Type.DOG, Animal.Sex.M, 1, 70, 10, true);

        List<Animal> list = new ArrayList<>();
        list.add(c);
        list.add(b);
        list.add(a);

        List<Animal> sortedAnimals = new ArrayList<>();
        sortedAnimals.add(a);
        sortedAnimals.add(b);
        sortedAnimals.add(c);
        assertThat(Tasks.task1SortedAnimals(list)).isEqualTo(sortedAnimals);
    }

    @Test
    @DisplayName("Task2")
    public void Test2() {
        Animal a = new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 1, 50, 50, true);
        Animal b = new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 60, 40, true);
        Animal c = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 3, 70, 20, true);
        Animal d = new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.F, 4, 70, 10, true);
        Animal e = new Animal("Fish", Animal.Type.FISH, Animal.Sex.M, 5, 70, 30, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        List<Animal> sortedList = new ArrayList<>();
        sortedList.add(a);
        sortedList.add(b);
        sortedList.add(e);
        int k = 3;
        assertThat(Tasks.task2SortedAnimals(list, k)).isEqualTo(sortedList);
    }

    @Test
    @DisplayName("Task3")
    public void Test3() {
        Animal a = new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 1, 50, 50, true);
        Animal b = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.F, 2, 60, 40, true);
        Animal c = new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 3, 70, 20, true);
        Animal d = new Animal("Dog3", Animal.Type.DOG, Animal.Sex.F, 4, 70, 10, true);
        Animal e = new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 5, 70, 30, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        Map<Animal.Type, Integer> animals = new HashMap<>();
        animals.put(Animal.Type.CAT, 2);
        animals.put(Animal.Type.DOG, 3);
        assertThat(Tasks.task3CountAnimals(list)).isEqualTo(animals);
    }

    @Test
    @DisplayName("Task4")
    public void Task4() {
        Animal a = new Animal("Dog1Doffe", Animal.Type.DOG, Animal.Sex.M, 1, 50, 50, true);
        Animal b = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.F, 2, 60, 40, true);
        Animal c = new Animal("Dog2Dof", Animal.Type.DOG, Animal.Sex.M, 3, 70, 20, true);
        Animal d = new Animal("Dog3", Animal.Type.DOG, Animal.Sex.F, 4, 70, 10, true);
        Animal e = new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 5, 70, 30, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        assertThat(Tasks.task4MaxLenghtAnimal(list)).isEqualTo(a);
    }

    @Test
    @DisplayName("Task5")
    public void Task5() {
        Animal a = new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 1, 50, 50, true);
        Animal b = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.F, 2, 60, 40, true);
        Animal c = new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 3, 70, 20, true);
        Animal d = new Animal("Dog3", Animal.Type.DOG, Animal.Sex.F, 4, 70, 10, true);
        Animal e = new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 5, 70, 30, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        assertThat(Tasks.task5CountMale(list)).isEqualTo(Animal.Sex.M);
    }

    @Test
    @DisplayName("Task6")
    public void Task6() {
        Animal a = new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 1, 50, 50, true);
        Animal b = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.F, 2, 60, 40, true);
        Animal c = new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 3, 70, 20, true);
        Animal d = new Animal("Dog3", Animal.Type.DOG, Animal.Sex.F, 4, 70, 10, true);
        Animal e = new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 5, 70, 30, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        Map<Animal.Type, Animal> animals = new HashMap<>();
        animals.put(Animal.Type.DOG, a);
        animals.put(Animal.Type.CAT, b);
        assertThat(Tasks.task6HeavyAnimal(list)).isEqualTo(animals);
    }

    @Test
    @DisplayName("Task7")
    public void Task7() {
        Animal a = new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 1, 50, 50, true);
        Animal b = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.F, 2, 60, 40, true);
        Animal c = new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 3, 70, 20, true);
        Animal d = new Animal("Dog3", Animal.Type.DOG, Animal.Sex.F, 4, 70, 10, true);
        Animal e = new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 5, 70, 30, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        assertThat(Tasks.task7OldestAnimal(list)).isEqualTo(e);
    }

    @Test
    @DisplayName("Task8")
    public void Task8() {
        Animal a = new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 1, 50, 50, true);
        Animal b = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.F, 2, 60, 40, true);
        Animal c = new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 3, 70, 20, true);
        Animal d = new Animal("Dog3", Animal.Type.DOG, Animal.Sex.F, 4, 70, 10, true);
        Animal e = new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 5, 70, 30, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        int height = 68;
        Optional<Animal> animal = Optional.of(a);
        assertThat(Tasks.task8HeavyAnimalShort(list, height)).isEqualTo(animal);
    }

    @Test
    @DisplayName("Task9")
    public void Task9() {
        Animal a = new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 1, 50, 50, true);
        Animal b = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.F, 2, 60, 40, true);
        Animal c = new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 3, 70, 20, true);
        Animal d = new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.F, 4, 70, 10, true);
        Animal e = new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 5, 70, 30, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        assertThat(Tasks.task9CountPaws(list)).isEqualTo(22);
    }

    @Test
    @DisplayName("Task10")
    public void Task10() {
        Animal a = new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 4, 50, 50, true);
        Animal b = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.F, 3, 60, 40, true);
        Animal c = new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 3, 70, 20, true);
        Animal d = new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.F, 2, 70, 10, true);
        Animal e = new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 5, 70, 30, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        List<Animal> animals = new ArrayList<>();
        animals.add(b);
        animals.add(c);
        animals.add(e);
        assertThat(Tasks.task10AgeNotEqualPaws(list)).isEqualTo(animals);
    }

    @Test
    @DisplayName("Task11")
    public void Task11() {
        Animal a = new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 4, 150, 50, true);
        Animal b = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.F, 3, 60, 40, false);
        Animal c = new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 3, 110, 20, true);
        Animal d = new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.F, 2, 170, 10, false);
        Animal e = new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 5, 70, 30, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        List<Animal> animals = new ArrayList<>();
        animals.add(a);
        animals.add(c);
        assertThat(Tasks.task11BitesAnimals(list)).isEqualTo(animals);
    }

    @Test
    @DisplayName("Task12")
    public void Task12() {
        Animal a = new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 4, 150, 500, true);
        Animal b = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.F, 3, 60, 400, false);
        Animal c = new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 3, 110, 20, true);
        Animal d = new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.F, 2, 170, 10, false);
        Animal e = new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 5, 70, 30, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        int result = 2;
        assertThat(Tasks.task12WeightMoreHeight(list)).isEqualTo(result);
    }

    @Test
    @DisplayName("Task13")
    public void Task13() {
        Animal a = new Animal("Dog1 Dog1 Dog1", Animal.Type.DOG, Animal.Sex.M, 4, 150, 500, true);
        Animal b = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.F, 3, 60, 400, false);
        Animal c = new Animal("Dog2 Dog2 Dog2", Animal.Type.DOG, Animal.Sex.M, 3, 110, 20, true);
        Animal d = new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.F, 2, 170, 10, false);
        Animal e = new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 5, 70, 30, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        List<Animal> animals = new ArrayList<>();
        animals.add(a);
        animals.add(c);
        assertThat(Tasks.task13NameMoreTwoWord(list)).isEqualTo(animals);
    }

    @Test
    @DisplayName("Task14")
    public void Task14() {
        Animal a = new Animal("Dog1 Dog1 Dog1", Animal.Type.DOG, Animal.Sex.M, 4, 150, 500, true);
        Animal b = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.F, 3, 60, 400, false);
        Animal c = new Animal("Dog2 Dog2 Dog2", Animal.Type.DOG, Animal.Sex.M, 3, 110, 20, true);
        Animal d = new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.F, 2, 170, 10, false);
        Animal e = new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 5, 70, 30, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        assertThat(Tasks.task14DogMoreHeightK(list, 120)).isTrue();
    }

    @Test
    @DisplayName("Task15")
    public void Task15() {
        Animal a = new Animal("Dog1 Dog1 Dog1", Animal.Type.DOG, Animal.Sex.M, 3, 150, 500, true);
        Animal b = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.F, 4, 60, 400, false);
        Animal c = new Animal("Dog2 Dog2 Dog2", Animal.Type.DOG, Animal.Sex.M, 5, 110, 20, true);
        Animal d = new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.F, 1, 170, 10, false);
        Animal e = new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 2, 70, 30, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        Map<Animal.Type, Integer> map = new HashMap<>();
        map.put(Animal.Type.DOG, 500);
        map.put(Animal.Type.SPIDER, 30);
        map.put(Animal.Type.CAT, 400);
        assertThat(Tasks.task15SumWeight(list, 2, 4)).isEqualTo(map);
    }

    @Test
    @DisplayName("Task16")
    public void Task16() {
        Animal a = new Animal("Dog1 Dog1 Dog1", Animal.Type.DOG, Animal.Sex.M, 4, 150, 500, true);
        Animal b = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.F, 3, 60, 400, false);
        Animal c = new Animal("Dog2 Dog2 Dog2", Animal.Type.DOG, Animal.Sex.M, 3, 110, 20, true);
        Animal d = new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.F, 2, 170, 10, false);
        Animal e = new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 5, 70, 30, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        List<Animal> sortedList = new ArrayList<>();
        sortedList.add(b);
        sortedList.add(a);
        sortedList.add(c);
        sortedList.add(d);
        sortedList.add(e);
        assertThat(Tasks.task16SortedThreeList(list)).isEqualTo(sortedList);
    }

    @Test
    @DisplayName("Task17")
    public void Task17() {
        Animal a = new Animal("Dog1 Dog1 Dog1", Animal.Type.DOG, Animal.Sex.M, 4, 150, 500, true);
        Animal b = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.F, 3, 60, 400, false);
        Animal c = new Animal("Dog2 Dog2 Dog2", Animal.Type.DOG, Animal.Sex.M, 3, 110, 20, true);
        Animal d = new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.F, 2, 170, 10, false);
        Animal e = new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 5, 70, 30, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        assertThat(Tasks.task17DogSpider(list)).isFalse();
    }

    @Test
    @DisplayName("Task18")
    public void Task18() {
        Animal a = new Animal("Fish1", Animal.Type.FISH, Animal.Sex.M, 4, 150, 500, true);
        Animal b = new Animal("Fish2", Animal.Type.FISH, Animal.Sex.F, 3, 60, 400, false);
        Animal c = new Animal("Fish3", Animal.Type.FISH, Animal.Sex.M, 3, 110, 20, true);
        Animal d = new Animal("Fish4", Animal.Type.FISH, Animal.Sex.F, 2, 170, 10, false);
        Animal e = new Animal("Fish5", Animal.Type.FISH, Animal.Sex.M, 5, 70, 30, true);
        List<Animal> list1 = new ArrayList<>();
        List<Animal> list2 = new ArrayList<>();
        list1.add(a);
        list1.add(b);
        list1.add(c);
        list2.add(d);
        list2.add(e);
        List<List<Animal>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        assertThat(Tasks.task18HeavyFish(list)).isEqualTo(a);
    }

    @Test
    @DisplayName("Task19")
    public void Task19() {
        Animal a = new Animal(null, null, null, -1, -1, -1, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        Map<String, Set<ValidationError>> map = Tasks.task19MapValidationError(list);
        Set<ValidationError> set = map.get(null);
        List<ValidationError> list2 = set.stream().toList();
        ValidationError error1 = list2.get(0);
        ValidationError error2 = list2.get(1);
        ValidationError error3 = list2.get(2);
        ValidationError error4 = list2.get(3);
        ValidationError error5 = list2.get(4);
        ValidationError error6 = list2.get(5);
        assertThat(error1.getIncorrectState()).isEqualTo(ValidationError.IncorrectState.NAME);
        assertThat(error2.getIncorrectState()).isEqualTo(ValidationError.IncorrectState.TYPE);
        assertThat(error3.getIncorrectState()).isEqualTo(ValidationError.IncorrectState.SEX);
        assertThat(error4.getIncorrectState()).isEqualTo(ValidationError.IncorrectState.AGE);
        assertThat(error5.getIncorrectState()).isEqualTo(ValidationError.IncorrectState.HEIGHT);
        assertThat(error6.getIncorrectState()).isEqualTo(ValidationError.IncorrectState.WEIGHT);
    }
    @Test
    @DisplayName("Task20")
    public void Task20() {
        Animal a = new Animal(null, null, null, -1, -1, -1, true);
        List<Animal> list = new ArrayList<>();
        list.add(a);
        Map<String , String> map= new HashMap<>();
        map.put(null, "Errors:Name is empty or equal null; Type is null; Sex is null; Age < 0; Height < 0; Weight < 0; ");
        assertThat(Tasks.task20MapValidationError(list)).isEqualTo(map);
    }
}
