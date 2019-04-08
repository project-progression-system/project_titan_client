package edu.cnm.deepdive.project_titan.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.project_titan.model.entity.User;

/**
 * @author Thomas Herrera, Alex Rauenzahn, Lance Zotigh
 * @version 1.0
 */

@Dao
public interface UserDao {

  @Insert
  String insertUser(User user);

  @Query("SELECT * FROM User")
  Iterable<User> getUser();
}
