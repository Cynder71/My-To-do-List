package cynder.todo_list;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private VBox root;
    private VBox todoListContainer;

    @Override
    public void start(Stage stage) {
        root = new VBox(); // Layout vertical

        // Contêiner para os itens da lista
        todoListContainer = new VBox();

        // Adiciona alguns itens iniciais
        todoListContainer.getChildren().add(createTodoItem("Item 1"));
        todoListContainer.getChildren().add(createTodoItem("Item 2"));

        // Botão de adição
        Button addButton = new Button("+");
        addButton.setOnAction(event -> addTodoItem());
        root.getChildren().addAll(todoListContainer, addButton);

        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("To-do List App");
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

    private void addTodoItem() {
        // Adiciona um novo item à lista
        todoListContainer.getChildren().add(createTodoItem("Novo Item"));
    }

    public static void main(String[] args) {
        launch();
    }
}
