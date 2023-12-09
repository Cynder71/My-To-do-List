package cynder.todo_list;

import javafx.scene.layout.VBox;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TodoListMap {
    
    private Map<String, VBox> VboxesMap;

    public TodoListMap() {
        VboxesMap = new HashMap<>();
    }

    public void addVbox(String nome, VBox vbox) {
        VboxesMap.put(nome, vbox);
    }

    public VBox getVbox(String nome) {
        return VboxesMap.get(nome);
    }

    public void removeVbox(String nome) {
        VboxesMap.remove(nome);
    }

    public void alterVbox(String nome, VBox novoVbox) {
        if (VboxesMap.containsKey(nome)) {
            VboxesMap.put(nome, novoVbox);
        } else {
            System.out.println("Vbox com o nome '" + nome + "' não encontrado.");
        }
    }
    
    public Set<String> getVboxKeys() {
        return VboxesMap.keySet();
    }
    
}
