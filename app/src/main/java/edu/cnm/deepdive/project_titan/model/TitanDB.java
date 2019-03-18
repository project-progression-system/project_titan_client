package edu.cnm.deepdive.project_titan.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import edu.cnm.deepdive.project_titan.TitanApplication;
import edu.cnm.deepdive.project_titan.model.entity.Achievements;
import edu.cnm.deepdive.project_titan.model.entity.UserInfo;

@Database(
    entities = {Achievements.class, UserInfo.class},
    version = 1,
    exportSchema = true
)


public abstract class TitanDB extends RoomDatabase {

  public static String DB_NAME = "titan_db";

  public synchronized static TitanDB getInstance() {
    return InstanceHolder.INSTANCE;
  }

  private static class InstanceHolder {

    private static final TitanDB INSTANCE = Room.databaseBuilder(
        TitanApplication.getInstance().getApplicationContext(), TitanDB.class, DB_NAME)
        .build();
  }

}
