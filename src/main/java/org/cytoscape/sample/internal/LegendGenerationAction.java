package org.cytoscape.sample.internal;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JOptionPane;

import org.cytoscape.task.NetworkTaskFactory;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyTableUtil;
import org.cytoscape.sample.internal.AnnotationTaskFactory;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.task.AbstractNetworkViewTaskFactory;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.presentation.annotations.AnnotationFactory;
import org.cytoscape.view.presentation.annotations.AnnotationManager;
import org.cytoscape.work.TaskIterator;

public class LegendGenerationAction extends AbstractCyAction {

	private static final long serialVersionUID = 1L;
	private AnnotationFactory annotationFactory;
	private AnnotationManager annotationManager;
	private CyApplicationManager cyAppManager;

	public LegendGenerationAction(CyApplicationManager cyAppManager) {
		super("Legend");
		setPreferredMenu("Apps.Legend");
		this.cyAppManager = cyAppManager;

	}

	public class AnnotationTextTaskFactory extends
			AbstractNetworkViewTaskFactory {
		@SuppressWarnings("rawtypes")
		AnnotationFactory annotationFactory;
		AnnotationManager annotationManager;
		CyApplicationManager cyAppManager;

		public AnnotationTextTaskFactory(CyApplicationManager cyAppManagr,
				AnnotationManager mgr,
				@SuppressWarnings("rawtypes") AnnotationFactory factory) {
			this.annotationFactory = factory;
			this.annotationManager = mgr;
			this.cyAppManager = cyAppManagr;

		}

		@SuppressWarnings("unchecked")
		public TaskIterator createTaskIterator(CyNetworkView networkView) {
			return new TaskIterator(new AnnotationTextTask(cyAppManager,
					networkView, annotationManager, annotationFactory));
		}
	}

	public class AnnotationTaskFactory extends AbstractNetworkViewTaskFactory {
		@SuppressWarnings("rawtypes")
		AnnotationFactory annotationFactory;
		AnnotationManager annotationManager;
		CyApplicationManager cyAppManager;

		public AnnotationTaskFactory(CyApplicationManager cyAppManagr,
				AnnotationManager mgr,
				@SuppressWarnings("rawtypes") AnnotationFactory factory) {
			this.annotationFactory = factory;
			this.annotationManager = mgr;
			this.cyAppManager = cyAppManagr;
		}

		@SuppressWarnings("unchecked")
		public TaskIterator createTaskIterator(CyNetworkView networkView) {
			return new TaskIterator(new AnnotationTask(cyAppManager,
					networkView, annotationManager, annotationFactory));
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (cyAppManager.getCurrentNetwork() == null) {
			return;
		}

		AnnotationTaskFactory annotationTaskFactory = new AnnotationTaskFactory(
				cyAppManager, annotationManager, annotationFactory);
		
		AnnotationTextTaskFactory annotationTextTaskFactory = new AnnotationTextTaskFactory(
				cyAppManager, annotationManager, annotationFactory);
		annotationTextTaskFactory.createTaskIterator(cyAppManager
				.getCurrentNetworkView());
	
	}

}
