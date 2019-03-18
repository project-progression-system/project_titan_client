package edu.cnm.deepdive.project_titan.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class UserInfo {

  @ColumnInfo(name = "user_id")
  @PrimaryKey(autoGenerate =  true)
  private long id;

  @Expose
  @SerializedName("user_name")
  private String userName;

  @Expose
  @SerializedName("first_name")
  private String FN;

  @Expose
  @SerializedName("last_name")
  private String LN;

  @Expose
  @SerializedName("a_r_image")
  private String ARImage;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getFN() {
    return FN;
  }

  public void setFN(String FN) {
    this.FN = FN;
  }

  public String getLN() {
    return LN;
  }

  public void setLN(String LN) {
    this.LN = LN;
  }

  public String getARImage() {
    return ARImage;
  }

  public void setARImage(String ARImage) {
    this.ARImage = ARImage;
  }
}
