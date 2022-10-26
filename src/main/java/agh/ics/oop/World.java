package agh.ics.oop;

public class World {

    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(animal);
        String[] movements = new String[]{"r","a","forward","forward","f","left","b"};
        MoveDirection[] directions = OptionsParser.parse(movements);
        for (MoveDirection direct : directions) {
            animal.move(direct);
            System.out.println(animal);
        }
    }
}

