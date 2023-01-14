package Generics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Generics<T> {
    static String[] strArray = {"One", "Two", "Three", "Four"};
    static Integer[] intArray = {1, 2, 3, 4, 5};
    static Boolean[] boolArray = {true, false, true};

    public static <T> List<T> arrayToList(T[] inArray, List<T> outList){
        for (T element :
                inArray) {
            outList.add(element);
        }
        return outList;
    };

    private static void printShopping(String... items) {
        System.out.println("Shopping list:");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> strings = arrayToList(strArray, new ArrayList<>());
        List<Integer> integers = arrayToList(intArray, new ArrayList<>());
        List<Boolean> booleans = arrayToList(boolArray, new ArrayList<>());

        printShopping("Orange");
        printShopping("Oranges", "Potato");
        printShopping(new String[] {"meat", "bread", "milk", "eggs"});

        //Liscov Substitution Principle
        Building office = new Office();
        Building building = new Building();
        construct(building);
        construct(office);

        List<Building> buildings = new ArrayList<>();
        buildings.add(office);
        buildings.add(building);
        printBuildings(buildings);

        List<Office> offices = new ArrayList<>();
        offices.add(new Office());
        offices.add(new Office());
        printBuildings(offices); // violation without wildcard
        Thread.sleep(1000);

        List<House> houses = new ArrayList<>();
        addHouseToList(houses);

        printBuildings(houses);

    }

    private static void addHouseToList(List<? super House> houses) {
        houses.add(new House());
        System.out.println();
    }

    private static void printBuildings(List<? extends Building> buildings) {
        buildings.forEach(System.out::println);
    }

    private static void construct(Building building) {
        System.out.println(("Constructing a new " + building.toString()));
    }
}
