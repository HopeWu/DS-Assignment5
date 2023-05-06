package arranger;

import java.util.LinkedList;
import java.util.HashMap;

import dataset.Task;

/**
 * The preorder BFS traversal order happens to be the reverser of the dependency
 * order.
 * 
 * @author haopengwu
 *
 */
public class BrutalForceArranger extends Arranger {
	private LinkedList<Task> result = new LinkedList<>();

	/**
	 * For fast access of tasks and its dependencies.
	 */
	private HashMap<Task, LinkedList<Task>> dependOn = new HashMap<Task, LinkedList<Task>>();
	
	/**
	 *  An Brute force approach to visit every neighbour task with no dependency and
	 *  removes its count from other tasks containing it.
	 *  
	 * @param tasks - Set of task and its dependent sub tasks with deadlines
     * 				  to be arranged.
	 * @return list of tasks in order of their dependencies to be completed
     * 			within the stipulated deadline.
	 */
	@Override
	public LinkedList<Task> arrange(LinkedList<Task> tasks) {
		// Initializes the dependencyMap
		for (Task task : tasks) {
			for (Task dependentTask : task.dependencies) {
				if (dependOn.get(dependentTask) == null)
					dependOn.put(dependentTask, new LinkedList<Task>());
				dependOn.get(dependentTask).add(task);
			}
		}

		HashMap<Task, Integer> dependencyCount = new HashMap<Task, Integer>();
		
		for (Task task : tasks) {
			dependencyCount.put(task, task.dependencies.size());
		}
	
		// Find the tasks that don't have any dependencies and perform them. 
		int count = 0;
		
		while (count < tasks.size()) {
			for (Task task : tasks) {
				// Add them
				if (dependencyCount.get(task) == 0) {
					result.add(task);
					++count;
					dependencyCount.put(task, -1);
				} else {
					continue;
				}
				// Delete count for those that has this task as dependency
				if(dependOn.get(task) == null) continue;
				
				for (Task dependentTask : dependOn.get(task)) {
					dependencyCount.put(dependentTask, (dependencyCount.get(dependentTask) - 1));
					dependOn.get(task);
				}
			}
		}
		
		result.forEach((node -> {System.out.print(node.taskId); System.out.println(node.dependencies);}));
		return result;
	}
}