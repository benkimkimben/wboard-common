package com.wboard.common.model;

import org.eclipse.swt.graphics.Point;

import com.wboard.common.WObject;

public abstract class DrawableObject implements WObject{
	
	private long oid;
	
	private static final long serialVersionUID = -7534130951626336299L;
	
	private Point position;
	
	private int depth;
	
	private int ownerid;

	/**
	 * No point of comparing two abstract classes.
	 */
	@Override
	public abstract int compareTo(WObject o) ;

	@Override
	public long getOid() {		return oid;		}



	public void setPosition(Point position) {
		this.position = position;
	}

	public Point getPosition() {
		return position;
	}

}
