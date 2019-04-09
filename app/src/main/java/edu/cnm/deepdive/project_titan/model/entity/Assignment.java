package edu.cnm.deepdive.project_titan.model.entity;

import com.google.gson.annotations.Expose;

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
