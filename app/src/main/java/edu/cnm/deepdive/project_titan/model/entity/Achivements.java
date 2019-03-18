package edu.cnm.deepdive.project_titan.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(
    foreignKeys = @ForeignKey(
        entity = UserInfo.class,
        parentColumns = "user_id", childColumns = "user_id",
        onDelete = ForeignKey.CASCADE
    )
)
public class Achivements {

  @ColumnInfo(name = "achievements_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "user_id")
  private long userId;

  @NonNull
  @ColumnInfo(name = "assignment_name")
  private String AssignmentName;

  @ColumnInfo(name = "points_earned")
  private long pointsEarned;


  @NonNull
  @ColumnInfo(name = "source_name")
  private String sourceName;

  @NonNull
  @ColumnInfo(name = "achievement_origin")
  private String achievementOrigin;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  @NonNull
  public String getAssignmentName() {
    return AssignmentName;
  }

  public void setAssignmentName(@NonNull String assignmentName) {
    AssignmentName = assignmentName;
  }

  public long getPointsEarned() {
    return pointsEarned;
  }

  public void setPointsEarned(long pointsEarned) {
    this.pointsEarned = pointsEarned;
  }

  @NonNull
  public String getSourceName() {
    return sourceName;
  }

  public void setSourceName(@NonNull String sourceName) {
    this.sourceName = sourceName;
  }

  @NonNull
  public String getAchievementOrigin() {
    return achievementOrigin;
  }

  public void setAchievementOrigin(@NonNull String achievementOrigin) {
    this.achievementOrigin = achievementOrigin;
  }
}
