package org.cytoscape.sample.internal;

import org.cytoscape.model.CyNetwork;

//Referenced classes of package org.cytoscape.task:
//         NetworkTaskFactory

public abstract class AbstractNetworkTaskFactory implements NetworkTaskFactory {

	public AbstractNetworkTaskFactory() {
	}

	public boolean isReady(CyNetwork network) {
		return network != null;
	}
}
