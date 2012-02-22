package com.wboard.common;

import org.apache.hadoop.io.Writable;

/**
 * Child of hadoop writable interface
 * @author SKCCADMIN
 *
 */
public interface WObject extends Writable, Comparable<WObject> {
	
	/**
	 * Return this object id
	 * @return
	 */
	public long getOid();

}
