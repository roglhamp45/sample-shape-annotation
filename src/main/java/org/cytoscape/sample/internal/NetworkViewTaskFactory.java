package org.cytoscape.sample.internal;

import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.work.TaskIterator;

public interface NetworkViewTaskFactory {

	public abstract TaskIterator createTaskIterator(CyNetworkView cynetworkview);

	public abstract boolean isReady(CyNetworkView cynetworkview);
}
