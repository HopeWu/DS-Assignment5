package arranger;

import java.util.LinkedList;
import java.util.HashMap;
import dataset.Task;

/**
 * The postorder DFS traversal order naturally matches the order of dependence route,
 * which is used by this algorithm. The deepest node has no dependency so it should 
 * be performed first.
 * 
 * @author haopengwu
 *
 */
public class DfsArranger extends Arranger {
	
	protected LinkedList<Task> result = new LinkedList<>();
    private HashMap<Task, Integer> hashMap= new HashMap<Task, Integer>();
     
    /**
     * Invokes the Depth First Search Algorithm to generate the order of 
     * the tasks and its dependencies to be completed.
     * 
     * @param tasks - Set of task and its dependent sub tasks with deadlines
     * 				  to be arranged.
     * @return list of tasks in order of their dependencies to be completed
     * 			within the stipulated deadline.
     */
    @Override
    public LinkedList<Task> arrange(LinkedList<Task> tasks){
        
    	for (Task task : tasks) {
            dfs(task);
        }

        return result;
    }
    
    /**
     * Depth First Search Implementation which uses Task which
     * is an adjacency list containing neighbor tasks that are
     * modelled here as dependent tasks. It uses recursive app-
     * roach (Stack is an alternative) to visit all the neighb-
     * ors in till all the "unvisited/ non-dependent" tasks 
     * are visited. The results are then stored in a list to 
     * be which represents the path of tasks and its dependents.
     * 
     * @param task - Task instance which is an adjacency list
     * 				 containing deadline and sub tasks (other
     * 				 tasks in the neighbourhood). 				.
     */
    public void dfs(Task task){
    	if (task == null) return;
    	// Check if this task it visited before
        if (hashMap.get(task) != null) return;
        // Get the dependencies of the current task
        LinkedList<Task> dependencies = task.dependencies;
        // If the current task has no dependencies, just push it into the stack
        if (dependencies.isEmpty()) {
            result.add(task);
            hashMap.put(task, 1);
        } else {
        	// Push the dependencies of this task first before push it into the stack
            for (Task dependentTask: dependencies) {
                dfs(dependentTask);
            }
            result.add(task);
            hashMap.put(task, 1);
        }
    }
}