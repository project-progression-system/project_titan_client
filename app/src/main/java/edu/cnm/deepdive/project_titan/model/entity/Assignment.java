/*
 *  Copyright 2019 Lance Zotigh, Alex Rauenzahn, Thomas Herrera & Deep Dive Coding
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 * @version 1.0
 * @author Thomas Herrera, Alex Rauenzahn, Lance Zotigh
 */
package edu.cnm.deepdive.project_titan.model.entity;

import com.google.gson.annotations.Expose;

/**
 * Encapsulates attributes of a single USer. Room and GSON annotations are used to specify entity
 * &amp; attribute mapping for database persistence, and property mapping for JSON
 * serialization/deserialization mapping.
 */
public class Assignment {

  @Expose
  private String name;

  /**
   * Gets the string name
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * sets the name in a String
   *
   * @param name sets name
   */
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
