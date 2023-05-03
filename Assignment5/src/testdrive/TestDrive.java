package testdrive;
import java.util.ArrayList;
import java.util.LinkedList;

import arranger.Arranger;
import arranger.BfsArranger;
import arranger.DfsArranger;
import dataset.Dataset;
import dataset.Project;
import dataset.Task;
import projectManager.ProjectManager;

public class TestDrive {
	public static void main(String[] args) {
		// Create two kinds of graphs to be used
		Arranger bfsArranger = new BfsArranger();
		Arranger dfsArranger = new DfsArranger();
		
		// Create two project managers
		ProjectManager pm1 = new ProjectManager(bfsArranger);
		ProjectManager pm2 = new ProjectManager(dfsArranger);
		
		// Create an instance of Dataset to generate testing data.
		Dataset dataset = new Dataset();
		
		// Create a dataset of size 20 and try these three managers with it
		Project project1 = dataset.getProjectOf(5);
		Project project2 = dataset.getProjectOf(5);
		
		// timer starts counting
		ArrayList<Task> orderToDo1 = pm1.manage(project1);
		// timer ends counting	
		
		orderToDo1.forEach((node -> {System.out.print(node.taskId); System.out.println(node.dependencies);}));

		System.out.println();
		
		// timer starts counting
		ArrayList<Task> orderToDo2 = pm2.manage(project2);
		// timer ends counting
		
		orderToDo2.forEach((node -> {System.out.print(node.taskId); System.out.println(node.dependencies);}));

		
		// Create a dataset of size 50 and try these three managers with it
		
		// Create a dataset of size 100 and try these three managers with it
		
		// Create a dataset of size 1000 and try these three managers with it
		
	}
}
