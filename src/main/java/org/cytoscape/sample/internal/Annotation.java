package org.cytoscape.sample.internal;

import java.awt.geom.Point2D;
import java.util.Map;
import java.util.Set;
import org.cytoscape.view.model.CyNetworkView;

// Referenced classes of package org.cytoscape.view.presentation.annotations:
//            ArrowAnnotation

public interface Annotation {

	public abstract CyNetworkView getNetworkView();

	public abstract String getCanvasName();

	public abstract void setCanvas(String s);

	public abstract void moveAnnotation(Point2D point2d);

	public abstract double getZoom();

	public abstract void setZoom(double d);

	public abstract double getSpecificZoom();

	public abstract void setSpecificZoom(double d);

	public abstract boolean isSelected();

	public abstract void setSelected(boolean flag);

	// public abstract void addArrow(ArrowAnnotation arrowannotation);

	// public abstract void removeArrow(ArrowAnnotation arrowannotation);

	public abstract Set getArrows();

	public abstract Map getArgMap();

	public static final String BACKGROUND = "background";
	public static final String FOREGROUND = "foreground";
	public static final String ZOOM = "zoom";
	public static final String CANVAS = "canvas";
	public static final String X = "x";
	public static final String Y = "y";
}
