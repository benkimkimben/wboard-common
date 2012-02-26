/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wboard.common.protocol;

import org.apache.hadoop.ipc.VersionedProtocol;

import com.wboard.common.model.DrawableObject;


/**
 * Interface (protocol) of Server used by Clients
 * @author Ben Kim
 * @see org.apache.hadoop.hbase.ipc.HRegionInterface
 */
public interface ServerProtocol extends VersionedProtocol {

	public static final long versionID = 100L;
	
	/**
	 * Create a room in server
	 * @param title
	 * @param uid
	 * @param type
	 * @return
	 */
	public boolean createRoom(String title);
	
	/**
	 * Create a user
	 * @param name
	 * @return
	 */
	public boolean createUser(String name);
	
	/**
	 * Associate user with room
	 * @param uname
	 * @return
	 */
	public boolean joinRoom(int roomid, int userid);
	
	
	/**
	 * Draw a drawable object on a whiteboard
	 * It's really just adding a drawable object to a server-side room
	 * Actual drawing happens on client-side
	 * Each object has position, depth, and owner info
	 * @param roomid
	 * @param userid
	 * @param obj
	 */
	public void draw(int roomid, DrawableObject obj);
	
	
	/**
	 * Erase a drawn object on a whiteboard
	 * @param roomid
	 * @param userid
	 * @param objid
	 */
	public void erase(int roomid, int userid, int objid);

}
