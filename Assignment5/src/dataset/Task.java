package dataset;
import java.time.LocalDate;
import java.util.LinkedList;

/**
 * Adjacency List Representation for the Project Management Graph Problem.
 * Its Holds the dependent tasks(neighbors) in a LinkedList.
 * 
 * @author haopengwu
 *
 */
public class Task {
	
	/**
	 * Constructor which initialezes the dependencies member variable.
	 */
	public Task() {
		super();
		this.dependencies = new LinkedList<Task>();
	}

	/**
	 * Number of days it takes to finish this task.
	 */
	public int daysToFinish;
	/**
	 * Unique id in a given project.
	 */
	public int taskId;
	/**
	 * Date Time type instance to represent deadline for the task.
	 */
	public LocalDate deadline = null;
	/**
	 * List of neighbour tasks for representing dependencies.
	 */
	public LinkedList<Task> dependencies;
	
	/**
	 * Overriding toString for displaying task details.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", daysToFinish=" + daysToFinish + ", deadline=" + deadline + ", dependencies=" + dependencies+"]";
	}
}