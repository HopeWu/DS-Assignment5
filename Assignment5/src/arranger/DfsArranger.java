package arranger;

import java.util.LinkedList;
import java.util.Stack;
import java.util.HashMap;

import dataset.Task;

/**
 * The postorder DFS traversal order naturally matches the order of dependence route.
 * This algorithm makes use of that. The deepest node has no dependency so it 
 * should be performed first.
 * @author haopengwu
 *
 */
public class DfsArranger extends Arranger {
	
	protected LinkedList<Task> result = new LinkedList<>();
    private HashMap<Task, Integer> HashMap= new HashMap<Task, Integer>();

    @Override
    public LinkedList<Task> arrange(LinkedList<Task> tasks){
        for (Task task: tasks){
            dfs(task);
        }

//        result.forEach((node -> {System.out.print(node.taskId); System.out.println(node.dependencies);}));
        return result;
    }

    public void dfs(Task task){
    	if (task == null) return;
    	// check if this task it visited before
        if (HashMap.get(task) != null) return;
        // get the dependencies of the current task
        LinkedList<Task> dependencies = task.dependencies;
        // if the current task has no dependencies, just push it into the stack
        if (dependencies.isEmpty()){
            result.add(task);
            HashMap.put(task, 1);
        }else{
        	// push the dependencies of this task first before push it into the stack
            for (Task t: dependencies){
                dfs(t);
            }
            result.add(task);
            HashMap.put(task, 1);
        }
    }
}
