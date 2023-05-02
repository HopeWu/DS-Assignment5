package arranger;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import dataset.Task;

public abstract class Arranger {

	abstract LinkedList<Task> arrange(LinkedList<Task> tasks);
	
	static protected LinkedList<Task> getStarters(LinkedList<Task> projects){
        HashMap<Task, Integer> hashmap = new HashMap<>();
        for (Task Task: projects){
            hashmap.put(Task, 0);
        }
        for (Task Task: projects){
            for( Task task: Task.dependencies){
                hashmap.put(task, 1);
            }
        }

        hashmap.values().removeAll(Collections.singleton(1));
        return new LinkedList<>(hashmap.keySet());
    }
}
