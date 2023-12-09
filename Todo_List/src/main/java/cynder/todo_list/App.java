package cynder.todo_list;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import cynder.todo_list.TodoListMap;

public class App extends Application {

    private VBox menu;
    private VBox miniTodoList;
    private HBox theWholeThing;
    private VBox todoListContainer;
    TodoListMap map = new TodoListMap();
    Button addButton = new Button("+");
    Label aaa = new Label("Teste");

    @Override
    public void start(Stage stage) {

        // Layout horizontal para a coisa toda que é horizontal
        theWholeThing = new HBox();

        // Layout vertical para a miniTodoList e menu
        miniTodoList = new VBox();
        menu = new VBox();

        // Contêiner para os itens da lista (APENAS OS ITENS)
        todoListContainer = new VBox();
        map.addVbox("teste", todoListContainer);
        

        // Botão de adição
        addButton.setOnAction(event -> addTodoItem(map.getVbox("teste")));
        miniTodoList.getChildren().addAll(map.getVbox("teste"), addButton);

        // Adicionando elementos ao menu
        menu.getChildren().addAll(aaa);

        // Adicionando miniTodoList e menu ao theWholeThing
        theWholeThing.getChildren().addAll(menu, miniTodoList);

        // A parte que faz aparecer os elementos
        Scene scene = new Scene(theWholeThing, 440, 560);
        stage.setTitle("To-do List de milhões");
        stage.setScene(scene);
        stage.show();
    }

    private HBox createTodoItem(String description) {
        HBox todoItem = new HBox(); // Layout horizontal
        CheckBox checkBox = new CheckBox();
        Label label = new Label(description);

        todoItem.getChildren().addAll(checkBox, label);

        return todoItem;
    }

    private void addTodoItem(VBox vbox) {
        TextField inputField = new TextField();

        addButton.setDisable(true);

        inputField.setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Enter")) {
                String description = inputField.getText();

                if (!description.isEmpty()) {
                    vbox.getChildren().add(createTodoItem(description));

                    inputField.clear();

                    vbox.getChildren().remove(inputField);

                    addButton.setDisable(false);
                }
            }
        });

        vbox.getChildren().add(inputField);
    }

    public static void main(String[] args) {
        launch();
    }
}
