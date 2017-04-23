package org.cytoscape.sample.internal;

import java.awt.Color;
import java.awt.Paint;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.view.presentation.annotations.AnnotationFactory;
import org.cytoscape.view.presentation.annotations.AnnotationManager;
import org.cytoscape.view.presentation.annotations.ShapeAnnotation;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;

/*AnnotationTask is an AbstractTask that contains the necessary elements to draw Shape Annotations on the current network canvas */

/**
 * @authors Roger Hampton, Solomon Garedew, Samantha Watkins Coding excerpts
 *          from Adam Treister and Scooter Morris
 * 
 */
public class AnnotationTask extends AbstractTask {

	private ShapeAnnotation mAnnotation = null;
	private CyNetworkView view;
	private final AnnotationManager annotationManager;
	private AnnotationFactory<ShapeAnnotation> factory = null;
	private final CyApplicationManager cyAppManager;

	public AnnotationTask(CyApplicationManager cyAppManager,
			CyNetworkView view, AnnotationManager manager,
			AnnotationFactory<ShapeAnnotation> factory) {
		annotationManager = manager;
		this.factory = factory;
		this.view = view;
		this.cyAppManager = cyAppManager;

		if (factory == null)
			System.out.println("No factory to build TextAnnotations");
		if (cyAppManager == null)
			JOptionPane.showMessageDialog(null, "No App Manager");
	}

	public void run(TaskMonitor monitor) {

		CyNetwork net = cyAppManager.getCurrentNetwork();
		double bordWidth = 1.0;
		final Map<String, String> map1 = new HashMap<String, String>();
		for (CyNode node1 : net.getNodeList()) {
			if (net.getRow(node1).get(CyNetwork.SELECTED, Boolean.class) == false) {
				View<CyNode> nodeView1 = view.getNodeView(node1);
				double tempNetworkWidth = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_WIDTH);
				double tempNetworkCenter = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_CENTER_X_LOCATION);
				double networkWidth = (tempNetworkCenter - tempNetworkWidth);

				map1.put("x", String.valueOf((networkWidth - 15.0)));
			}
		}
		map1.put("y", String.valueOf(-100));
		map1.put("zoom", "3.0");
		map1.put("canvas", "foreground");
		mAnnotation = factory.createAnnotation(ShapeAnnotation.class, view,
				map1);
		mAnnotation.setBorderColor(Color.black);
		mAnnotation.setSize(20.0, 20.0);
		mAnnotation.setShapeType("ROUNDRECT");
		mAnnotation.setBorderWidth(bordWidth);
		for (CyNode node : net.getNodeList()) {
			if (net.getRow(node).get(CyNetwork.SELECTED, Boolean.class) == false) {
				View<CyNode> nodeView = view.getNodeView(node);
				Paint currentColor2 = nodeView
						.getVisualProperty(BasicVisualLexicon.NODE_FILL_COLOR);

				mAnnotation.setFillColor(currentColor2);
			}
		}
		annotationManager.addAnnotation(mAnnotation);

		final Map<String, String> map = new HashMap<String, String>();
		for (CyNode node1 : net.getNodeList()) {
			if (net.getRow(node1).get(CyNetwork.SELECTED, Boolean.class) == false) {
				View<CyNode> nodeView1 = view.getNodeView(node1);
				double tempNetworkWidth = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_WIDTH);
				double tempNetworkCenter = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_CENTER_X_LOCATION);
				double networkWidth = (tempNetworkCenter - tempNetworkWidth);

				map.put("x", String.valueOf((networkWidth - 15.0)));
			}
		}
		map.put("y", String.valueOf(-75));
		map.put("zoom", "3.0");
		map.put("canvas", "foreground");

		mAnnotation = factory
				.createAnnotation(ShapeAnnotation.class, view, map);
		mAnnotation.setBorderColor(Color.black);
		mAnnotation.setSize(20.0, 20.0);
		mAnnotation.setShapeType("ellipse");
		mAnnotation.setBorderWidth(bordWidth);
		for (CyNode node : net.getNodeList()) {
			if (net.getRow(node).get(CyNetwork.SELECTED, Boolean.class) == true) {
				View<CyNode> nodeView = view.getNodeView(node);
				Paint currentColor = nodeView
						.getVisualProperty(BasicVisualLexicon.NODE_FILL_COLOR);

				mAnnotation.setFillColor(currentColor);
			}
		}

		annotationManager.addAnnotation(mAnnotation);

		final Map<String, String> map2 = new HashMap<String, String>();
		for (CyNode node1 : net.getNodeList()) {
			if (net.getRow(node1).get(CyNetwork.SELECTED, Boolean.class) == false) {
				View<CyNode> nodeView1 = view.getNodeView(node1);
				double tempNetworkWidth = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_WIDTH);
				double tempNetworkCenter = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_CENTER_X_LOCATION);
				double networkWidth = (tempNetworkCenter - tempNetworkWidth);

				map2.put("x", String.valueOf((networkWidth - 15.0)));
			}
		}
		map2.put("y", String.valueOf(-200));
		map2.put("zoom", "3.0");
		map2.put("canvas", "foreground");
		mAnnotation = factory.createAnnotation(ShapeAnnotation.class, view,
				map2);
		mAnnotation.setSize(20.0, 20.0);
		mAnnotation.setBorderColor(Color.black);
		mAnnotation.setShapeType("rectangle");
		mAnnotation.setBorderWidth(bordWidth);

		for (CyEdge edge : net.getEdgeList()) {
			if (net.getRow(edge).get(CyNetwork.SELECTED, Boolean.class) == true) {
				View<CyEdge> edgeView = view.getEdgeView(edge);
				Paint edgeColor1 = edgeView
						.getVisualProperty(BasicVisualLexicon.EDGE_STROKE_SELECTED_PAINT);

				mAnnotation.setFillColor(edgeColor1);
			}
		}

		annotationManager.addAnnotation(mAnnotation);

		final Map<String, String> map21 = new HashMap<String, String>();
		for (CyNode node1 : net.getNodeList()) {
			if (net.getRow(node1).get(CyNetwork.SELECTED, Boolean.class) == false) {
				View<CyNode> nodeView1 = view.getNodeView(node1);
				double tempNetworkWidth = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_WIDTH);
				double tempNetworkCenter = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_CENTER_X_LOCATION);
				double networkWidth = (tempNetworkCenter - tempNetworkWidth);

				map21.put("x", String.valueOf((networkWidth - 15.0)));
			}
		}
		map21.put("y", String.valueOf(-175));
		map21.put("zoom", "3.0");
		map21.put("canvas", "foreground");
		mAnnotation = factory.createAnnotation(ShapeAnnotation.class, view,
				map21);
		mAnnotation.setSize(20.0, 20.0);
		mAnnotation.setBorderColor(Color.black);
		mAnnotation.setShapeType("rectangle");
		mAnnotation.setBorderWidth(bordWidth);

		for (CyEdge edge : net.getEdgeList()) {
			if (net.getRow(edge).get(CyNetwork.SELECTED, Boolean.class) == false) {
				View<CyEdge> edgeView = view.getEdgeView(edge);
				Paint edgeColor1 = edgeView
						.getVisualProperty(BasicVisualLexicon.EDGE_STROKE_UNSELECTED_PAINT);

				mAnnotation.setFillColor(edgeColor1);
			}
		}

		annotationManager.addAnnotation(mAnnotation);

		final Map<String, String> map3 = new HashMap<String, String>();
		for (CyNode node13 : net.getNodeList()) {
			if (net.getRow(node13).get(CyNetwork.SELECTED, Boolean.class) == false) {
				View<CyNode> nodeView13 = view.getNodeView(node13);
				double tempNetworkWidth13 = nodeView13
						.getVisualProperty(BasicVisualLexicon.NETWORK_WIDTH);
				double tempNetworkCenter13 = nodeView13
						.getVisualProperty(BasicVisualLexicon.NETWORK_CENTER_X_LOCATION);
				double networkWidth13 = (tempNetworkCenter13 - tempNetworkWidth13);

				map3.put("x", String.valueOf((networkWidth13 - 15.0)));
			}
		}
		map3.put("y", String.valueOf(-25));
		map3.put("zoom", "3.0");
		map3.put("canvas", "foreground");
		mAnnotation = factory.createAnnotation(ShapeAnnotation.class, view,
				map3);
		mAnnotation.setSize(20.0, 20.0);
		mAnnotation.setBorderColor(Color.black);
		mAnnotation.setShapeType("triangle");
		mAnnotation.setBorderWidth(bordWidth);

		for (CyNode node31 : net.getNodeList()) {
			if (net.getRow(node31).get(CyNetwork.SELECTED, Boolean.class) == true) {
				View<CyNode> nodeView31 = view.getNodeView(node31);
				Paint currentColor31 = nodeView31
						.getVisualProperty(BasicVisualLexicon.NODE_FILL_COLOR);

				mAnnotation.setFillColor(currentColor31);
			}
		}
		annotationManager.addAnnotation(mAnnotation);

		view.updateView();
	}
}