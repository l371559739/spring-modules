/* 
 * Created on Sep 24, 2004
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * Copyright @2004 the original author or authors.
 */

package org.springmodules.cache.provider.jcs;

import org.springmodules.cache.provider.CacheModel;
import org.springmodules.util.Strings;

/**
 * <p>
 * Configuration options for accessing JCS.
 * 
 * @author Alex Ruiz
 * 
 * @version $Revision$ $Date$
 */
public class JcsModel implements CacheModel {

  private static final long serialVersionUID = 3257282547976057398L;

  /**
   * Name of the JCS cache.
   */
  private String cacheName;

  /**
   * The group the object to cache belongs to.
   */
  private String group;

  public JcsModel() {
    super();
  }

  public JcsModel(String cacheName) {
    this();
    setCacheName(cacheName);
  }

  public JcsModel(String cacheName, String group) {
    this(cacheName);
    setGroup(group);
  }

  /**
   * @see Object#equals(java.lang.Object)
   */
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof JcsModel)) {
      return false;
    }

    final JcsModel cacheModel = (JcsModel) obj;

    if (cacheName != null ? !cacheName.equals(cacheModel.cacheName)
        : cacheModel.cacheName != null) {
      return false;
    }
    if (group != null ? !group.equals(cacheModel.group)
        : cacheModel.group != null) {
      return false;
    }

    return true;
  }

  public final String getCacheName() {
    return cacheName;
  }

  public final String getGroup() {
    return group;
  }

  /**
   * @see Object#hashCode()
   */
  public int hashCode() {
    int multiplier = 31;
    int hash = 7;
    hash = multiplier * hash + (cacheName != null ? cacheName.hashCode() : 0);
    hash = multiplier * hash + (group != null ? group.hashCode() : 0);
    return hash;
  }

  public final void setCacheName(String newCacheName) {
    cacheName = newCacheName;
  }

  public final void setGroup(String newGroup) {
    group = newGroup;
  }

  /**
   * @see Object#toString()
   */
  public String toString() {
    StringBuffer buffer = new StringBuffer(getClass().getName());
    buffer.append("@" + System.identityHashCode(this) + "[");
    buffer.append("cacheName=" + Strings.quote(cacheName) + ", ");
    buffer.append("group=" + Strings.quote(group) + "]");

    return buffer.toString();
  }
}