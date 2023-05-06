package testdrive;

import java.util.ArrayList;
import arranger.Arranger;
import arranger.BrutalForceArranger;
import arranger.DfsArranger;
import dataset.Dataset;
import dataset.Project;
import dataset.Task;
import projectManager.ProjectManager;

/**
 * A test class used to do all the comparison experiments.
 */
public class TestDrive {
	public static void main(String[] args) {
		
		// Create two kinds of graphs to be used
		Arranger bfsArranger = new BrutalForceArranger();
		Arranger dfsArranger = new DfsArranger();
		
		// Create two project managers
		ProjectManager pm1 = new ProjectManager(bfsArranger);
		ProjectManager pm2 = new ProjectManager(dfsArranger);
		
		// Create an instance of Dataset to generate testing data.
		Dataset dataset = new Dataset();
		
		System.out.println("Type, Data Size, Time (ms), Memory (bytes)");
		
		for (int dataSize = 10000; dataSize <= 100000; dataSize += 10000) {
			// Generate a project instance containing N number of tasks
			Project project = dataset.getProjectOf(dataSize);
			
			countTimeMem(pm1, project, "BFS", dataSize);
			countTimeMem(pm2, project, "DFS", dataSize);
		}		
	}
	
	/**
	 * Counts the time and memory required to arrange a project containing a specified number of tasks
	 * @param pm 
	 * @param project A project containing a specified number of tasks
	 * @param type The type of search algorithms to be used (BFS/DFS)
	 * @param dataSize The number of tasks to be arranged
	 */
	private static void countTimeMem(ProjectManager pm, Project project, String type, int dataSize) {
		long startTime = System.currentTimeMillis();
		
		Runtime r = Runtime.getRuntime(); // for memory consumption check
		r.gc(); // run the garbage collector before experiment
		
		long startMem = r.totalMemory() - r.freeMemory(); // free memory in the beginning
		
		ArrayList<Task> orderToDo = pm.manage(project);	
		
	    long endTime = System.currentTimeMillis();
	    long time = endTime - startTime; // total execution time 
	    	    
		long endMem = r.totalMemory() - r.freeMemory(); // free memory in the end
		long mem= endMem - startMem ; // memory consumption
		
		System.out.println(type + ", " + dataSize + ", " + time + ", " + mem);		
	}
}