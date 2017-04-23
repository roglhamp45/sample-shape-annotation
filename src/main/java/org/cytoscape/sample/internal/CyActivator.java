package org.cytoscape.sample.internal;

import static org.cytoscape.work.ServiceProperties.IN_MENU_BAR;

import static org.cytoscape.work.ServiceProperties.PREFERRED_MENU;
import static org.cytoscape.work.ServiceProperties.TITLE;

import java.util.Properties;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.task.NetworkViewTaskFactory;
import org.cytoscape.view.presentation.annotations.AnnotationFactory;
import org.cytoscape.view.presentation.annotations.AnnotationManager;
import org.cytoscape.view.presentation.annotations.ShapeAnnotation;
import org.cytoscape.view.presentation.annotations.TextAnnotation;
import org.osgi.framework.BundleContext;

/* Primary required class, CyActivator bundles services for Cytoscape applications.*/

public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}

	public void start(BundleContext bc) {
		CyApplicationManager cyApplicationManager = getService(bc,
				CyApplicationManager.class);
		AnnotationManager cyAnnotationManager = getService(bc,
				AnnotationManager.class);
		@SuppressWarnings("unchecked")
		AnnotationFactory<TextAnnotation> textFactory = getService(bc,
				AnnotationFactory.class, "(type=TextAnnotation.class)");
		@SuppressWarnings("unchecked")
		AnnotationFactory<ShapeAnnotation> shapeFactory = getService(bc,
				AnnotationFactory.class, "(type=ShapeAnnotation.class)");
		/*
		 * NetworkViewTaskFactory taskTextFactory instantiates
		 * AnnotationTextTask
		 */
		NetworkViewTaskFactory textTaskFactory = new AnnotationTextTaskFactory(
				cyApplicationManager, cyAnnotationManager, textFactory);
		Properties props2 = new Properties();
		props2.setProperty(PREFERRED_MENU, "Apps.Legend");
		props2.setProperty(TITLE, "Add Text");
		props2.setProperty(IN_MENU_BAR, "true");
		registerService(bc, textTaskFactory, NetworkViewTaskFactory.class,
				props2);
		/*
		 * NetworkViewTaskFactory taskFactory instantiates
		 * AnnotationTask
		 */
		NetworkViewTaskFactory taskFactory = new AnnotationTaskFactory(
				cyApplicationManager, cyAnnotationManager, shapeFactory);
		Properties props1 = new Properties();
		props1.setProperty(PREFERRED_MENU, "Apps.Legend");
		props1.setProperty(TITLE, "Add Shape");
		props1.setProperty(IN_MENU_BAR, "true");
		registerService(bc, taskFactory, NetworkViewTaskFactory.class, props1);

	}
}