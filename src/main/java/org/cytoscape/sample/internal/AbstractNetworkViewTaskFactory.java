package org.cytoscape.sample.internal;

import org.cytoscape.view.model.CyNetworkView;

//Referenced classes of package org.cytoscape.task:
//         NetworkViewTaskFactory

public abstract class AbstractNetworkViewTaskFactory implements
		NetworkViewTaskFactory {

	public AbstractNetworkViewTaskFactory() {
	}

	public boolean isReady(CyNetworkView networkView) {
		return networkView != null;
	}
}
