package org.cytoscape.sample.internal;

import java.util.List;

//Referenced classes of package org.cytoscape.view.presentation.annotations:
//         Annotation

public interface ShapeAnnotation extends Annotation {

	@SuppressWarnings("rawtypes")
	public abstract List getSupportedShapes();

	public abstract void setSize(double d, double d1);

	public abstract String getShapeType();

	public abstract void setShapeType(String s);

	/*
	 * ELLIPSE. RECTANGLE. TRIANGLE. DIAMOND. HEXAGON. OCTAGON. PARALLELOGRAM.
	 * ROUNDRECT.
	 */
	public abstract double getBorderWidth();

	public abstract void setBorderWidth(double d);

	public abstract java.awt.Paint getBorderColor();

	public abstract java.awt.Paint getFillColor();

	public abstract void setBorderColor(java.awt.Paint paint);

	public abstract void setFillColor(java.awt.Paint paint);

	public abstract void setCustomShape(java.awt.Shape shape);

	public abstract java.awt.Shape getShape();
}
