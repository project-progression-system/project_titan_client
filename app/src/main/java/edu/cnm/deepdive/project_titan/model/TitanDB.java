package edu.cnm.deepdive.project_titan.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import edu.cnm.deepdive.project_titan.model.entity.Achivements;
import edu.cnm.deepdive.project_titan.model.entity.UserInfo;

@Database(
    entities = {Achivements.class, UserInfo.class},
    version = 1,
    exportSchema = true
)


public abstract class TitanDB extends RoomDatabase {

}
