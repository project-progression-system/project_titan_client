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


  @NonNull
  public String getId() {
    return id;
  }

  public void setId(@NonNull String id) {
    this.id = id;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }


  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  @NonNull
  public String getAuthor() {
    return author;
  }

  public void setAuthor(@NonNull String author) {
    this.author = author;
  }

  @NonNull
  public Long getUserId() {
    return userId;
  }

  public void setUserId(@NonNull Long userId) {
    this.userId = userId;
  }


}
