package projectManager;

import java.util.ArrayList;
import java.util.LinkedList;

import arranger.Arranger;

import java.time.LocalDate;

import dataset.Project;
import dataset.Task;

public class ProjectManager {
	Arranger arranger;
	
	public ProjectManager(Arranger arranger) {
		super();
		this.arranger = arranger;
	}

	/**
	 * Output an order in which the tasks should be performed.
	 * @param tasks
	 * @return
	 */
	public ArrayList<Task> manage(Project project) {
		ArrayList<Task> managedTasks = new ArrayList<Task>();
		// arrange the tasks and order them
		LinkedList<Task> arrangedTasks = arranger.arrange(project.tasks);
//		System.out.println(arrangedTasks);
		
		// Timing them
		LocalDate deadline = project.deadline;
		Task task;
		while(!arrangedTasks.isEmpty()) {
			task = arrangedTasks.removeLast();
			task.deadline = deadline;
			managedTasks.add(task);
			deadline = deadline.minusDays(task.daysToFinish);
		}
		return managedTasks;
	}
}
