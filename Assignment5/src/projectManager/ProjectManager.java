package projectManager;

import java.util.ArrayList;
import java.util.HashMap;
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
	public LinkedList<Task> manage(Project project) {
		LinkedList<Task> managedTasks = new LinkedList<Task>();
		// arrange the tasks and order them
		LinkedList<Task> arrangedTasks = arranger.arrange(project.tasks);
		
		// Timing them
		LocalDate deadline = project.deadline;
		Task task;
		while(!arrangedTasks.isEmpty()) {
			task = arrangedTasks.removeLast();
			task.deadline = deadline;
			managedTasks.add(task);
			deadline.minusDays(task.daysToFinish);
		}
		return managedTasks;
	}
}
