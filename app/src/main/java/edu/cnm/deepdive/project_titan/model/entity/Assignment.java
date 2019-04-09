package edu.cnm.deepdive.project_titan.model.entity;

import com.google.gson.annotations.Expose;

public class Assignment {

  @Expose
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
