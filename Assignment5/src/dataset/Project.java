package dataset;

import java.time.LocalDate;
import java.util.LinkedList;

public class Project {
	public LocalDate deadline;
	public LinkedList<Task> tasks;
	
	public Project(Task[] tasks, LocalDate deadline) {
		super();
		this.deadline = deadline;
		this.tasks = new LinkedList<Task>();
		for( Task task: tasks) {
			this.tasks.add(task);
		}
	}

	@Override
	public String toString() {
		return "Project [deadline=" + deadline + ", tasks=" + tasks + "]";
	}
}
