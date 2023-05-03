package arranger;

import java.util.LinkedList;
import java.util.Queue;
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
	private HashMap<Task, Integer> visited = new HashMap<Task, Integer>();

	/**
	 * For fast accessing
	 */
	private HashMap<Task, LinkedList<Task>> dependOn = new HashMap<Task, LinkedList<Task>>();

	@Override
	public LinkedList<Task> arrange(LinkedList<Task> tasks) {

		// initialize the dependencyMap
		for (Task task : tasks) {
			for (Task d : task.dependencies) {
				if (dependOn.get(d) == null)
					dependOn.put(d, new LinkedList<Task>());
				dependOn.get(d).add(task);
			}
		}

		HashMap<Task, Integer> dependencyCount = new HashMap<Task, Integer>();
		for (Task task : tasks) {
			dependencyCount.put(task, task.dependencies.size());
		}

		/**
		 * Find the those don't have any dependencies and do them.
		 */
		int count = 0;
		while (count < tasks.size()) {
			for (Task task : tasks) {
				// add this
				if (dependencyCount.get(task) == 0) {
					result.add(task);
					count += 1;
					dependencyCount.put(task, -1);
				}else
					// 
					continue;
				// delete count for those that has this task as dependency
				if(dependOn.get(task) == null) continue;
				for (Task d : dependOn.get(task)) {
					dependencyCount.put(d, (dependencyCount.get(d) - 1));
					dependOn.get(task);
				}
			}
		}
		result.forEach((node -> {System.out.print(node.taskId); System.out.println(node.dependencies);}));
		return result;

	}

//    public void bfs(Task task){
//        Queue<Task> queue = new LinkedList<Task>();
//        queue.add(task);
//        visited.put(task, 1);
//        while(!queue.isEmpty()){
//            Task t = queue.remove();
//            result.add(t);
//            if (dependOn.get(t) == null) continue;
//            for (Task subTask: dependOn.get(t)){
//                if (visited.get(subTask) == null){
//                    queue.add(subTask);
//                    visited.put(subTask, 1);
//                }
//            }
//        }
//    }

//    @Override
//    public LinkedList<Task> arrange(LinkedList<Task> tasks){
//        LinkedList<Task> starters = getStarters(tasks);
//        for (Task Task: starters){
//            bfs(Task);
//        }
//        // reverse the _result and return
//        LinkedList<Task> result = new LinkedList<>();
//        _result.forEach((node -> {System.out.print(node.taskId); System.out.println(node.dependencies);}));
////        while(!_result.isEmpty()) result.add(_result.removeLast());
////        System.out.println();
////        result.forEach((node -> System.out.print(node.taskId)));
//        return _result;
//    }

}
