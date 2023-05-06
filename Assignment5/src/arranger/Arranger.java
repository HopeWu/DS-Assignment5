package arranger;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import dataset.Task;

/**
 * Arranger provides a blueprint for organizing a given set of Tasks
 * according to its dependencies with other tasks, which would be defined
 * by its concrete classes.
 * 
 * @author haopengwu
 *
 */
public abstract class Arranger {
		
	/**
	 * Computes a list of tasks with no dependencies by keeping a count of
	 * dependent tasks in a hashmap removing the instances of tasks with
	 * 1 dependent task.
	 * 
	 * @param tasks - List of tasks with dependencies.
	 * @return list of tasks with no dependencies.
	 */
	static protected LinkedList<Task> getStarters(LinkedList<Task> tasks){
        HashMap<Task, Integer> hashmap = new HashMap<>();
        
        for (Task task : tasks) {
            hashmap.put(task, 0);
        }
        
        for (Task task : tasks) {
            for(Task subtask : task.dependencies) {
                hashmap.put(subtask, 1);
            }
        }

        hashmap.values().removeAll(Collections.singleton(1));
        return new LinkedList<>(hashmap.keySet());
    }
	
	/**
	 * Contract with input as a list of tasks with deadline. The
	 * implementor method is responsible for computing the seque-
	 * nces of tasks and returns that in form of list.
	 * 
	 * @param tasks - Set of tasks with deadline and dependent tasks.
	 * @return List of tasks in order of its completion.
	 */
	public abstract LinkedList<Task> arrange(LinkedList<Task> tasks);
}