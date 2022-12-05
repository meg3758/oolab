package agh.ics.oop;
import agh.ics.oop.gui.App;
import java.util.List;
import java.util.ArrayList;
import javafx.application.Platform;

public class SimulationEngine implements IEngine,Runnable{
    private final List<MoveDirection> directions;
    private final GrassField map;
    private final List<Animal> Animals;
    private final App app;
    private int moveDelay = 1000;
    public SimulationEngine(MoveDirection[] directions,GrassField map, Vector2d[] positions,App app){
        this.map=map;
        this.directions=List.of(directions);
        this.Animals=new ArrayList<>();
        this.app=app;
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
        Platform.runLater(() -> {
            this.app.renderMap(this.map);
        });
        try {
            Thread.sleep(this.moveDelay);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < directions.size(); i++) {
            Animals.get(i % Animals.size()).move(directions.get(i));
            Platform.runLater(() -> {
                this.app.renderMap(this.map);
            });
            try {
                Thread.sleep(this.moveDelay);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
