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
