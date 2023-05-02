package arranger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

import dataset.Task;

public class BfsArranger extends Arranger{
	
	private LinkedList<Task> result = new LinkedList<>();
    private HashMap<Task, Integer> HashMap= new HashMap<Task, Integer>();

    @Override
    public LinkedList<Task> arrange(LinkedList<Task> tasks){
        LinkedList<Task> starters = getStarters(tasks);
        for (Task Task: starters){
            bfs(Task);
        }
        return result;
    }

    public void bfs(Task Task){
        Queue<Task> queue = new LinkedList<>();
        queue.add(Task);
        HashMap.put(Task, 1);
        while(!queue.isEmpty()){
            Task task = queue.remove();
            result.add(task);
            for (Task Task1: task.dependencies){
                if (HashMap.get(Task1) == null){
                    queue.add(Task1);
                    HashMap.put(Task1, 1);
                }
            }
        }
    }
}
