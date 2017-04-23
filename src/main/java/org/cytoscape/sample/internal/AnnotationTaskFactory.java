package org.cytoscape.sample.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.task.AbstractNetworkViewTaskFactory;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.presentation.annotations.AnnotationFactory;
import org.cytoscape.view.presentation.annotations.AnnotationManager;
import org.cytoscape.work.TaskIterator;

/*
 *  AnnotationTaskFactory extends the AbstractNetworkViewTaskFactory
 *  using TaskIterator to initialize a new AnnotationTask (Shape annotation)
 *  
 */

/**
 * @authors Roger Hampton, Solomon Garedew, Samantha Watkins Coding excerpts
 *          from Adam Treister and Scooter Morris
 * 
 */

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
		return new TaskIterator(new AnnotationTask(cyAppManager, networkView,
				annotationManager, annotationFactory));
	}
}