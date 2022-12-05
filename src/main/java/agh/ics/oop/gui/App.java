package agh.ics.oop.gui;
import agh.ics.oop.*;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class App extends Application{
    private GrassField map;
    GridPane gridPane = new GridPane();


    @Override
    public void start(Stage primaryStage)  {
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(20, 20, 20, 20));

        gridPane.setGridLinesVisible(true);
        Scene scene = new Scene(gridPane, 700, 700);
        primaryStage.setTitle("World Map Visualization");

        this.addObjectsToGrid(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void addObjectsToGrid(GridPane gridPane){
        Vector2d lower = this.map.lowerLeftCorner();
        Vector2d upper = this.map.upperRightCorner();

        for (int i=0; lower.x + i <= upper.x+1; i++){
            gridPane.getColumnConstraints().add(new ColumnConstraints(40));
        }
        for (int i=0; lower.y + i <= upper.y+1; i++){
            gridPane.getRowConstraints().add(new RowConstraints(40));
        }

        Label l = new Label("y/x");
        gridPane.add(l, 0, 0);

        for (int i = lower.x; i <= upper.x; i++){
            Label new_element = new Label(Integer.toString(i));
            GridPane.setHalignment(new_element, HPos.CENTER);
            gridPane.add(new_element, i - lower.x+1, 0);
        }

        for (int i = lower.y; i <= upper.y; i++){
            Label new_element = new Label(Integer.toString(i));
            GridPane.setHalignment(new_element, HPos.CENTER);
            gridPane.add(new_element, 0, upper.y+1-i);
        }

        for (int x = lower.x; x<=upper.x; x++){
            for (int y = lower.y; y<=upper.y; y++){
                if (map.isOccupied(new Vector2d(x,y))){
                    Object obj = this.map.objectAt(new Vector2d(x,y));
                    if (obj != null){
                        GuiElementBox vBox = new GuiElementBox((IMapElement) map.objectAt(new Vector2d(x,y)));
                        Label label = new Label();
                        GridPane.setHalignment(label, HPos.CENTER);
                        gridPane.add(vBox.vBox, x-lower.x+1, upper.y+1-y);
                    }
                }
            }
        }
    }
    public void renderMap(GrassField newMap) {
        this.gridPane.setGridLinesVisible(false);
        this.gridPane.getColumnConstraints().clear();
        this.gridPane.getRowConstraints().clear();
        this.gridPane.getChildren().clear();
        this.gridPane.setGridLinesVisible(true);
        this.map=newMap;
        addObjectsToGrid(gridPane);
    }
    @Override
    public void init() throws Exception{
        super.init();
        try {
            MoveDirection[] directions = new OptionsParser().parse(new String[]{"f", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
            this.map = new GrassField(15);
            //Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            Vector2d[] positions = {new Vector2d(1,1),new Vector2d(2,3),new Vector2d(4,5)};
            IEngine engine = new SimulationEngine(directions, map, positions,this);
            Thread engineThread = new Thread(engine::run);
            engineThread.start();
            //System.out.println(map);
        }
        catch(IllegalArgumentException exception){
            System.out.println(exception);
        }
    }

}
