package arranger;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import dataset.Task;

public abstract class Arranger {

	public abstract LinkedList<Task> arrange(LinkedList<Task> tasks);
	
	/**
	 * 
	 * @param tasks
	 * @return
	 */
	static protected LinkedList<Task> getStarters(LinkedList<Task> tasks){
        HashMap<Task, Integer> hashmap = new HashMap<>();
        for (Task Task: tasks){
            hashmap.put(Task, 0);
        }
        for (Task Task: tasks){
            for( Task task: Task.dependencies){
                hashmap.put(task, 1);
            }
        }

        hashmap.values().removeAll(Collections.singleton(1));
        return new LinkedList<>(hashmap.keySet());
    }
}
