package org.cytoscape.sample.internal;

import java.awt.Color;
import java.awt.Font;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyTableUtil;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.view.presentation.annotations.AnnotationFactory;
import org.cytoscape.view.presentation.annotations.AnnotationManager;
import org.cytoscape.view.presentation.annotations.TextAnnotation;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;

/*AnnotationTextTask is an AbstractTask that contains the necessary elements to draw Text Annotations on the current network canvas */

/**
 * @authors Roger Hampton, Solomon Garedew, Samantha Watkins Coding excerpts
 *          from Adam Treister and Scooter Morris
 * 
 */

public class AnnotationTextTask extends AbstractTask {

	private TextAnnotation mAnnotation = null;
	private CyNetworkView view;
	private final AnnotationManager annotationManager;
	private AnnotationFactory<TextAnnotation> factory = null;
	private final CyApplicationManager cyAppManager;

	public AnnotationTextTask(CyApplicationManager cyAppManager,
			CyNetworkView view, AnnotationManager manager,
			AnnotationFactory<TextAnnotation> factory) {
		annotationManager = manager;
		this.factory = factory;
		this.view = view;
		this.cyAppManager = cyAppManager;
		if (factory == null)
			JOptionPane.showMessageDialog(null,
					"No factory to build TextAnnotations");
		if (cyAppManager == null)
			JOptionPane.showMessageDialog(null, "No App Manager");
	}

	public void run(TaskMonitor monitor) {

		CyNetwork net = cyAppManager.getCurrentNetwork();

		CyTableUtil.getNodesInState(cyAppManager.getCurrentNetwork(),
				"selected", true);
		CyTableUtil.getEdgesInState(cyAppManager.getCurrentNetwork(),
				"selected", true);
		cyAppManager.getCurrentNetwork().getEdgeList();

		final Map<String, String> map1 = new HashMap<String, String>();

		for (CyNode node1 : net.getNodeList()) {
			if (net.getRow(node1).get(CyNetwork.SELECTED, Boolean.class) == false) {
				View<CyNode> nodeView1 = view.getNodeView(node1);
				double tempNetworkWidth = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_WIDTH);
				double tempNetworkCenter = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_CENTER_X_LOCATION);
				double networkWidth = (tempNetworkCenter - tempNetworkWidth);

				map1.put("x", String.valueOf(networkWidth));
			}
		}

		map1.put("y", String.valueOf(-250));
		map1.put("zoom", "3.0");
		map1.put("canvas", "foreground");

		mAnnotation = factory
				.createAnnotation(TextAnnotation.class, view, map1);
		mAnnotation.setFont(new Font(Font.SERIF, 18, 0));
		mAnnotation.setTextColor(Color.black);
		mAnnotation.setFontStyle(1);
		mAnnotation.setFontSize(40);
		mAnnotation.setText("VISUAL LEGEND");
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

				map.put("x", String.valueOf(networkWidth));
			}
		}
		map.put("y", String.valueOf(-225));
		map.put("zoom", "3.0");
		map.put("canvas", "foreground");
		mAnnotation = factory.createAnnotation(TextAnnotation.class, view, map);
		mAnnotation.setFont(new Font(Font.SERIF, 18, 0));
		mAnnotation.setTextColor(Color.black);
		mAnnotation.setFontSize(30);
		mAnnotation.setText("Table Name:  "
				+ cyAppManager.getCurrentNetwork().getDefaultNodeTable()
						.getTitle());
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

				map2.put("x", String.valueOf(networkWidth));
			}
		}
		map2.put("y", String.valueOf(-100));
		map2.put("zoom", "3.0");
		map2.put("canvas", "foreground");
		mAnnotation = factory
				.createAnnotation(TextAnnotation.class, view, map2);
		mAnnotation.setFont(new Font(Font.SERIF, 18, 0));
		mAnnotation.setTextColor(Color.black);
		mAnnotation.setFontSize(24);
		for (CyNode node2 : net.getNodeList()) {
			 if (net.getRow(node2).get(CyNetwork.SELECTED, Boolean.class) == true) {
				View<CyNode> nodeView2 = view.getNodeView(node2);
				String currentNodeLabel_2 = nodeView2
						.getVisualProperty(BasicVisualLexicon.NODE_LABEL);

				mAnnotation.setText("Selected Node Color (Selected) W/Label:  "
						+ currentNodeLabel_2);
			}
		}

		annotationManager.addAnnotation(mAnnotation);

		final Map<String, String> map3 = new HashMap<String, String>();
		for (CyNode node1 : net.getNodeList()) {
			if (net.getRow(node1).get(CyNetwork.SELECTED, Boolean.class) == false) {
				View<CyNode> nodeView1 = view.getNodeView(node1);
				double tempNetworkWidth = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_WIDTH);
				double tempNetworkCenter = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_CENTER_X_LOCATION);
				double networkWidth = (tempNetworkCenter - tempNetworkWidth);

				map3.put("x", String.valueOf(networkWidth));
			}
		}
		map3.put("y", String.valueOf(-75));
		map3.put("zoom", "3.0");
		map3.put("canvas", "foreground");
		mAnnotation = factory
				.createAnnotation(TextAnnotation.class, view, map3);
		mAnnotation.setFont(new Font(Font.SERIF, 18, 0));
		mAnnotation.setTextColor(Color.black);
		mAnnotation.setFontSize(24);
		mAnnotation.setText("Selected Node Fill Color (White=Zero Selected)");
		annotationManager.addAnnotation(mAnnotation);

		final Map<String, String> map4 = new HashMap<String, String>();
		for (CyNode node1 : net.getNodeList()) {
			if (net.getRow(node1).get(CyNetwork.SELECTED, Boolean.class) == false) {
				View<CyNode> nodeView1 = view.getNodeView(node1);
				double tempNetworkWidth = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_WIDTH);
				double tempNetworkCenter = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_CENTER_X_LOCATION);
				double networkWidth = (tempNetworkCenter - tempNetworkWidth);

				map4.put("x", String.valueOf(networkWidth));
			}
		}
		map4.put("y", String.valueOf(-50));
		map4.put("zoom", "3.0");
		map4.put("canvas", "foreground");
		mAnnotation = factory
				.createAnnotation(TextAnnotation.class, view, map4);
		mAnnotation.setFont(new Font(Font.SERIF, 18, 0));
		mAnnotation.setTextColor(Color.black);
		mAnnotation.setFontSize(24);
		Set<CyNode> theseNodes = getSelectedNodes(cyAppManager
				.getCurrentNetwork());
		mAnnotation.setText("Selected node UIDs: " + theseNodes);
		annotationManager.addAnnotation(mAnnotation);

		final Map<String, String> map5 = new HashMap<String, String>();
		for (CyNode node1 : net.getNodeList()) {
			if (net.getRow(node1).get(CyNetwork.SELECTED, Boolean.class) == false) {
				View<CyNode> nodeView1 = view.getNodeView(node1);
				double tempNetworkWidth = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_WIDTH);
				double tempNetworkCenter = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_CENTER_X_LOCATION);
				double networkWidth = (tempNetworkCenter - tempNetworkWidth);

				map5.put("x", String.valueOf(networkWidth));
			}
		}
		map5.put("y", String.valueOf(-150));
		map5.put("zoom", "3.0");
		map5.put("canvas", "foreground");
		mAnnotation = factory
				.createAnnotation(TextAnnotation.class, view, map5);
		mAnnotation.setFont(new Font(Font.SERIF, 18, 0));
		mAnnotation.setTextColor(Color.black);
		mAnnotation.setFontSize(30);
		mAnnotation.setText("Node Size is Proportional to Out Degree.");
		annotationManager.addAnnotation(mAnnotation);

		final Map<String, String> map50 = new HashMap<String, String>();
		for (CyNode node1 : net.getNodeList()) {
			if (net.getRow(node1).get(CyNetwork.SELECTED, Boolean.class) == false) {
				View<CyNode> nodeView1 = view.getNodeView(node1);
				double tempNetworkWidth = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_WIDTH);
				double tempNetworkCenter = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_CENTER_X_LOCATION);
				double networkWidth = (tempNetworkCenter - tempNetworkWidth);

				map50.put("x", String.valueOf(networkWidth));
			}
		}
		map50.put("y", String.valueOf(-125));
		map50.put("zoom", "3.0");
		map50.put("canvas", "foreground");
		mAnnotation = factory.createAnnotation(TextAnnotation.class, view,
				map50);
		mAnnotation.setFont(new Font(Font.SERIF, 18, 0));
		mAnnotation.setTextColor(Color.black);
		mAnnotation.setFontSize(30);
		mAnnotation.setText("Node Paint Mapping");
		annotationManager.addAnnotation(mAnnotation);

		final Map<String, String> map51 = new HashMap<String, String>();
		for (CyNode node1 : net.getNodeList()) {
			if (net.getRow(node1).get(CyNetwork.SELECTED, Boolean.class) == false) {
				View<CyNode> nodeView1 = view.getNodeView(node1);
				double tempNetworkWidth = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_WIDTH);
				double tempNetworkCenter = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_CENTER_X_LOCATION);
				double networkWidth = (tempNetworkCenter - tempNetworkWidth);

				map51.put("x", String.valueOf(networkWidth));
			}
		}
		map51.put("y", String.valueOf(-200));
		map51.put("zoom", "3.0");
		map51.put("canvas", "foreground");
		mAnnotation = factory.createAnnotation(TextAnnotation.class, view,
				map51);
		mAnnotation.setFont(new Font(Font.SERIF, 18, 0));
		mAnnotation.setTextColor(Color.black);
		mAnnotation.setFontSize(24);
		mAnnotation.setText("Selected Edge Stroke Color (White=Zero Selected)");
		annotationManager.addAnnotation(mAnnotation);

		final Map<String, String> map52 = new HashMap<String, String>();
		for (CyNode node1 : net.getNodeList()) {
			if (net.getRow(node1).get(CyNetwork.SELECTED, Boolean.class) == false) {
				View<CyNode> nodeView1 = view.getNodeView(node1);
				double tempNetworkWidth = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_WIDTH);
				double tempNetworkCenter = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_CENTER_X_LOCATION);
				double networkWidth = (tempNetworkCenter - tempNetworkWidth);

				map52.put("x", String.valueOf(networkWidth));
			}
		}
		map52.put("y", String.valueOf(-175));
		map52.put("zoom", "3.0");
		map52.put("canvas", "foreground");
		mAnnotation = factory.createAnnotation(TextAnnotation.class, view,
				map52);
		mAnnotation.setFont(new Font(Font.SERIF, 18, 0));
		mAnnotation.setTextColor(Color.black);
		mAnnotation.setFontSize(24);
		mAnnotation.setText("Unselected Edge Stroke Color");
		annotationManager.addAnnotation(mAnnotation);

		final Map<String, String> map6 = new HashMap<String, String>();
		for (CyNode node1 : net.getNodeList()) {
			if (net.getRow(node1).get(CyNetwork.SELECTED, Boolean.class) == false) {
				View<CyNode> nodeView1 = view.getNodeView(node1);
				double tempNetworkWidth = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_WIDTH);
				double tempNetworkCenter = nodeView1
						.getVisualProperty(BasicVisualLexicon.NETWORK_CENTER_X_LOCATION);
				double networkWidth = (tempNetworkCenter - tempNetworkWidth);

				map6.put("x", String.valueOf(networkWidth));
			}
		}
		map6.put("y", String.valueOf(-25));
		map6.put("zoom", "3.0");
		map6.put("canvas", "foreground");
		mAnnotation = factory
				.createAnnotation(TextAnnotation.class, view, map6);
		mAnnotation.setFont(new Font(Font.SERIF, 18, 0));
		mAnnotation.setTextColor(Color.black);
		mAnnotation.setFontSize(24);

		for (CyNode node1 : net.getNodeList()) {
			if (net.getRow(node1).get(CyNetwork.SELECTED, Boolean.class) == true) {
				View<CyNode> nodeView1 = view.getNodeView(node1);
				String currentNodeLabel_1 = nodeView1
						.getVisualProperty(BasicVisualLexicon.NODE_LABEL);

				mAnnotation.setText("Current Label: " + currentNodeLabel_1);
			}
		}

		annotationManager.addAnnotation(mAnnotation);

		view.updateView();

	}

	private Set<CyNode> getSelectedNodes(CyNetwork network) {
		if (network == null)
			return Collections.emptySet();
		Set<CyNode> nodes1 = new HashSet<CyNode>();
		Iterator<?> it1 = network.getNodeList().iterator();
		do {
			if (!it1.hasNext())
				break;
			CyNode node = (CyNode) it1.next();
			if (network.getRow(node).get(CyNetwork.SELECTED, Boolean.class) == true) {
				network.getRow(node);
				nodes1.add(node);
			}
		} while (true);
		return nodes1;
	}

}
