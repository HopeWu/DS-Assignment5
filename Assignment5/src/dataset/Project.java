package dataset;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 * Represents a set of tasks to be completed for a given timeline. It's modelled 
 * upon real world "Project" in a company setting where each project comprise of 
 * tasks with deadlines. It is used by project manager who handles most of the 
 * bookkeeping tasks for a project such as resolving dependencies, conflicts etc.
 * 
 * @author haopengwu
 *
 */
public class Project {
	/**
	 * Date time data type specifying the project deadline
	 */
	public LocalDate deadline;
	/**
	 *  List of tasks to be completed for succesful completion of the project.
	 */
	public LinkedList<Task> tasks;
	
	/**
	 * Constructor which initializes member variables deadline and tasks.
	 * 
	 * @param tasks - Array of Task for the project.
	 * @param deadline - A Date time object denoting deadline.
	 */
	public Project(Task[] tasks, LocalDate deadline) {
		super();
		this.deadline = deadline;
		this.tasks = new LinkedList<Task>();
		
		for(Task task: tasks) {
			this.tasks.add(task);
		}
	}
    
	/**
	 * Overrides toString method for displaying project information.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Project [deadline=" + deadline + ", tasks=" + tasks + "]";
	}
}