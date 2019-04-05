package edu.cnm.deepdive.project_titan.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import edu.cnm.deepdive.project_titan.model.entity.CompletedAssignments;
/**
 * @authors Thomas Herrera, Alex Rauenzahn, Lance Zotigh
 * @version 1.0
 */

@Dao
public interface PointsDao {



  @Insert
  Long insertPoints (CompletedAssignments completedAssignments);




}
