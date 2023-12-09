package cynder.todo_list;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import cynder.todo_list.TodoListMap;

public class Menu {
    private VBox menu;
    private TodoListMap todoListMap;

    public Menu(TodoListMap todoListMap) {
        this.menu = new VBox();
        this.todoListMap = todoListMap;
        initializeButtons();
    }

    public VBox getMenu() {
        return menu;
    }

    private void initializeButtons() {
        for (String key : todoListMap.getVboxKeys()) {
            Button button = new Button(key);
            button.setOnAction(event -> displayTodoList(key));
            menu.getChildren().add(button);
        }
    }

    private void displayTodoList(String key) {
        
    }
}
