package arranger;

import java.util.LinkedList;

import dataset.Task;

public interface Arranger {

	LinkedList<Task> arrange(LinkedList<Task> tasks);
}
