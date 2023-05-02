package dataset;
import java.time.LocalDate;

public class Task {
	Task(int taskId, int daysToFinish){
		this.taskId = taskId;
		this.daysToFinish = daysToFinish;
	}
	// unique in a given project
	public int taskId;
	public int daysToFinish = 0;
	public LocalDate deadline = null;
}
