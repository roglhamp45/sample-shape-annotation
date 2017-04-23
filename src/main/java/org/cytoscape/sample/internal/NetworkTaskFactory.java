package org.cytoscape.sample.internal;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.work.TaskIterator;

public interface NetworkTaskFactory {

	public abstract TaskIterator createTaskIterator(CyNetwork cynetwork);

	public abstract boolean isReady(CyNetwork cynetwork);
}
