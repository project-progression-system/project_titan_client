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
 */
package edu.cnm.deepdive.project_titan.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Thomas Herrera, Alex Rauenzahn, Lance Zotigh
 * @version 1.0
 */


/**
 * Encapsulates attributes of a single USer. Room and GSON annotations are used to specify entity
 * &amp; attribute mapping for database persistence, and property mapping for JSON
 * serialization/deserialization mapping.
 */
@Entity
public class User {

  /**
   * Sets the primary key of this entity.
   */
  @ColumnInfo(name = "user_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @Expose
  @SerializedName("name")
  private String name;

  @Expose
  @SerializedName("author")
  private String author;

  @Expose
  @ColumnInfo(index = true)
  private Type type;

  private String subject;

  /**
   * Returns the autogenerated primary key of this instance.
   *
   * @return primary key value.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the primary key of this instance. This method is invoked by Room to set the autogenerated
   * value of a new instance, and when loading an existing instance from the database.
   *
   * @param id primary key value.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Returns name
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name
   *
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets author.
   *
   * @return author
   */
  public String getAuthor() {
    return author;
  }

  /**
   * Sets the author
   *
   * @param author
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * Gets the type
   *
   * @return type
   */
  public Type getType() {
    return type;
  }

  /**
   * Gets the subject
   *
   * @return subject
   */
  public String getSubject() {
    return subject;
  }

  /**
   * Sets the subject.
   *
   * @param subject
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * Sets the type.
   *
   * @param type
   */
  public void setType(Type type) {
    this.type = type;
  }

  /**
   * Sets the enum for {@link User} for TEACHER and STUDENT.
   */
  public enum Type {
    TEACHER,
    STUDENT
  }
}
