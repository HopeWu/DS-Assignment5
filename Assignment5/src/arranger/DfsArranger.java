package arranger;

import java.util.LinkedList;
import java.util.Stack;
import java.util.HashMap;

import dataset.Task;

public class DfsArranger extends Arranger {
	
	protected Stack<Task> stack = new Stack<>();
    private HashMap<Task, Integer> HashMap= new HashMap<Task, Integer>();

    @Override
    public LinkedList<Task> arrange(LinkedList<Task> tasks){
        LinkedList<Task> starters = getStarters(tasks);
        for (Task Task: starters){
            dfs(Task);
        }
        LinkedList<Task> result = new LinkedList<>();
        while(!stack.isEmpty()) result.add(stack.pop());
        return result;
    }

    private void dfs(Task Task){
        if (HashMap.get(Task) != null) return;
        LinkedList<Task> adjacents = Task.dependencies;
        if (adjacents.isEmpty()){
            stack.push(Task);
            HashMap.put(Task, 1);
        }else{
            for (Task Task1: adjacents){
                dfs(Task1);
            }
            stack.push(Task);
            HashMap.put(Task, 1);
        }
    }

}
