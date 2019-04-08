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
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;

/**
 * @author Thomas Herrera, Alex Rauenzahn, Lance Zotigh
 * @version 1.0
 */


/**
 * Encapsulates attributes from a single {@link User}. Utilizing Room and GSON annotations to
 * specify entity &amp; attribute for mapping persistence, and property mapping for JSON
 * serialization/deserialization mapping.
 */

@Entity(foreignKeys = @ForeignKey(
    entity = User.class,
    parentColumns = "user_id", childColumns = "id",
    onDelete = ForeignKey.CASCADE
))

public class Assignment {


  @PrimaryKey
  @NonNull
  @Expose
  @ColumnInfo(name = "id")
  private String id;

  @NonNull
  @Expose
  @ColumnInfo(name = "name")
  private String name;

  @NonNull
  @Expose
  @ColumnInfo(name = "points")
  private int points;

  @NonNull
  @Expose
  @ColumnInfo(name = "author")
  private String author;

  @NonNull
  @Expose
  @ColumnInfo(name = "user_id")
  private Long userId;


  /**
   * Gets an id.
   *
   * @return an id.
   */
  @NonNull
  public String getId() {
    return id;
  }

  /**
   * Sets an id, will not allow a null value.
   */
  public void setId(@NonNull String id) {
    this.id = id;
  }

  /**
   * Gets a name from the {@link User}. Cannot be null.
   *
   * @return a name.
   */
  @NonNull
  public String getName() {
    return name;
  }

  /**
   * Sets a name for the {@link User}. Cannot be null.
   *
   * @param name returns a name, specifically this name.
   */
  public void setName(@NonNull String name) {
    this.name = name;
  }


  /**
   * Gets points acquired by the {@link User}.
   *
   * @return the points earned by {@link User}.
   */
  public int getPoints() {
    return points;
  }

  /**
   * Sets the points earned by {@link User}.
   *
   * @param points earned by the {@link User}.
   */
  public void setPoints(int points) {
    this.points = points;
  }

  /**
   * Gets the author of the assignment.
   *
   * @return the author of the assignment.
   */
  @NonNull
  public String getAuthor() {
    return author;
  }

  /**
   * Sets the author of the assignment. Cannot be a null value.
   *
   * @param author Acquires the author of the assignment, takes a String as an author.
   */
  public void setAuthor(@NonNull String author) {
    this.author = author;
  }

  /**
   * Gets the {@link User} id, cannot be a null value.
   *
   * @return the userId.
   */
  @NonNull
  public Long getUserId() {
    return userId;
  }

  /**
   * Sets the {@link User} id, cannot be a null value.
   *
   * @param userId Uses a long to generate a userId.
   */
  public void setUserId(@NonNull Long userId) {
    this.userId = userId;
  }


}
