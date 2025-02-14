package circus;

import circus.animal.*;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(animals.length);
//        makeAnimalsTalk();
//        System.out.println("Total value of animals " + calculateAssetValue(animals));
//        System.out.println("Total value of equipments " + calculateAssetValue(equipments));
//        animals[3] = new Elephant("Strong One");
//        System.out.println(animals.length);

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));

        Parrot perry = new Parrot("Perry");
        animalArrayList.add(perry);
        animalArrayList.add(new Elephant("Brute"));
        Duck andy = new Duck("Andy");
        animalArrayList.add(andy);

        // substitutability allows to add specific animals to "Animal" ArrayList

        System.out.println("Before sorting");
        printAnimals(animalArrayList);
        System.out.println("size of the array list: " + animalArrayList.size());

        System.out.println("Perry is in position: " + animalArrayList.indexOf(perry));

        animalArrayList.sort(Animal.AnimalNameComparator);

        System.out.println("After sorting");
        printAnimals(animalArrayList);
    }

    private static void printAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }
}
