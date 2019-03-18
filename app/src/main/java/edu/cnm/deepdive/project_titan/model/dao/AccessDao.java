package edu.cnm.deepdive.project_titan.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import edu.cnm.deepdive.project_titan.model.entity.Achievements;

@Dao
public interface AccessDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insert(Achievements... achievement);

  @Delete
  int delete(Achievements... achievement);
}
