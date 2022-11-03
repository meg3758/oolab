package agh.ics.oop;

import java.util.List;
import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private final List<MoveDirection> directions;
    private final IWorldMap map;
    private final List<Animal> Animals;
    public SimulationEngine(MoveDirection[] directions,IWorldMap map, Vector2d[] positions){
        this.map=map;
        this.directions=List.of(directions);
        this.Animals=new ArrayList<>();
        for(Vector2d position: positions){
            Animal a = new Animal(map,position);
            Animals.add(a);
            map.place(a);
        }
    }
    public Animal getAnimal(int i){
        return Animals.get(i);
    }
    @Override
    public void run() {
        for (int i = 0; i < directions.size(); i++) {
            Animals.get(i % Animals.size()).move(directions.get(i));
        }
    }
}
