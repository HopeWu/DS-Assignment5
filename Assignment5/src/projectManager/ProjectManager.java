package projectManager;

import java.util.ArrayList;
import java.util.LinkedList;
import arranger.Arranger;
import java.time.LocalDate;
import dataset.Project;
import dataset.Task;

/**
 * This class is responsible for managing the overall status of the projects.
 * It is modelled upon a real world Project Manager, whose task is to manage
 * deadlines of the tasks assigned to co-workers in a team to ensure timely
 * completion of tasks. An arrager class defines the project workflow which
 * is then followed by the team.
 * 
 * @author haopengwu
 *
 */
public class ProjectManager {
	
	Arranger arranger;
	
	/**
	 * Constructor which initializes arranger member variable with either
	 * of the concrete class implementation of Arranger.
	 * 
	 * @param arranger - Choice of Arranger class to handle the p
	 */
	public ProjectManager(Arranger arranger) {
		super();
		this.arranger = arranger;
	}

	/**
	 * Output an order in which the tasks should be performed.
	 * 
	 * @param project - Instance of Project with respective Tasks and deadline
	 * @return - List of tasks in order of completion to meet deadline.
	 */
	public ArrayList<Task> manage(Project project) {
		// Arrange the tasks and order them based on their dependencies
		LinkedList<Task> arrangedTasks = arranger.arrange(project.tasks);
		
		// Time them
		LocalDate deadline = project.deadline;
		ArrayList<Task> managedTasks = new ArrayList<Task>();
		
		while(!arrangedTasks.isEmpty()) {
			Task task = arrangedTasks.removeLast();
			task.deadline = deadline;
			managedTasks.add(task);
			deadline = deadline.minusDays(task.daysToFinish);
		}
		
		return managedTasks;
	}
}