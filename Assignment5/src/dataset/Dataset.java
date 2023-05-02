package dataset;

import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public class Dataset {
	/**
	 * for generating a future date
	 */
	static long now = System.currentTimeMillis();
	/**
	 * Randomly pick one to assign to a task's daysToFinish field. 
	 * Duplicates affect the distribution.
	 */
	static final int[] daysNeed = {1,1,1,2,2,3,3,5};
	
	Random rand = new Random();
	
	/**
	 * To generate Tasks of a given size. Randomly generate dependencies among them.
	 * Made sure there is no loop in it by always make dependencies in one direction.
	 * @param taskNumber
	 * @return
	 */
	public Project getProjectOf(int taskNumber) {
		// Generate an array of tasks
		Task[] tasks = new Task[taskNumber];
		
		/**
		 * assign the "taskId" and "daysToFinish" field to each task.
		 * taskId is assigned in order from zero.
		 * daysToFinish is assigned randomly
		 * 
		 * assign the dependencies among them. Always assign dependencies from left to right to avoid loop.
		 */
		for (int i = 0; i < taskNumber; i++) {
			tasks[i].taskId = i;
			tasks[i].daysToFinish = daysNeed[rand.nextInt(daysNeed.length)];
			
			/**
			 * Around 0.3 chance this task has no dependencies at all.
			 */
			double probability = 0.7;
			
			while(probability > 0.05) {
				int dependencyIndex = randomDependency(i+1, taskNumber, probability);
				if (dependencyIndex == -1) break;
				
				tasks[i].dependencies.add(tasks[dependencyIndex]);
				
				probability /= 2;
			}
		}
		
		// Randomly generate a deadline
		Date deadline = new Date(rand.nextLong(now, now - 100000000000L));
		
		Project project = new Project(tasks, deadline.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		
		return project;
	};
	
	/**
	 * Randomly get dependencies for a task. Always look in only one direction.
	 * @param startIndex, look from this index
	 * @param length, the length of the underlying array
	 * @param chance, the probability of getting one
	 * @return the index of the dependent task on the underlying array
	 */
	int randomDependency(int startIndex, int length, double chance){
		if (chance > 1 || chance < 0) return -1;
		if (startIndex > length-1) return -1;
		if (rand.nextInt(10) < chance*10) {
			return rand.nextInt(startIndex, length);
		}else
			return -1;
	}
}
