package com.wboard.common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public interface WObject extends Serializable, Comparable<WObject> {
	
	/**
	 * Return this object id
	 * @return
	 */
	public long getOid();

	/**
	 * Perform the default de-serialization first
	 * @param in
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException;
	
	/**
	 * Perform the default serialization for all non-transient, non-static fields
	 * @param out
	 * @throws IOException
	 */
	public void writeObject(ObjectOutputStream out) throws IOException;
}
