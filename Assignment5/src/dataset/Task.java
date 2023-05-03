package dataset;
import java.time.LocalDate;
import java.util.LinkedList;

public class Task {
	
	public Task() {
		super();
		this.dependencies = new LinkedList<Task>();
	}

	// how many days does it take to finish this task
	public int daysToFinish;
	// unique in a given project
	public int taskId;
	public int task = 0;
	public LocalDate deadline = null;
	public LinkedList<Task> dependencies;
	
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", daysToFinish=" + daysToFinish + ", deadline=" + deadline + ", dependencies=" + dependencies+"]";
	}
}
