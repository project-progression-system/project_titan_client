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
 *
 * @version 1.0
 * @author Thomas Herrera, Alex Rauenzahn, Lance Zotigh
 */


package edu.cnm.deepdive.project_titan.model;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import edu.cnm.deepdive.project_titan.TitanApplication;
import edu.cnm.deepdive.project_titan.model.TitanDB.Converters;
import edu.cnm.deepdive.project_titan.model.entity.Assignment;
import edu.cnm.deepdive.project_titan.model.entity.User;

/**
 * Defines the local database as a collections of its entities and converters. With the
 * implementation of the for the app-wide use of a single connection, and declares methods to
 * retrieve a data-access object or (DAO) for the database entities.
 */
@Database(
    entities = {Assignment.class, User.class},
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters.class)
public abstract class TitanDB extends RoomDatabase {

  public static String DB_NAME = "titan_db";

  /**
   * Returns the single instance of {@link TitanDB} for the current application context.
   */
  public synchronized static TitanDB getInstance() {
    return InstanceHolder.INSTANCE;
  }

  private static class InstanceHolder {

    private static final TitanDB INSTANCE = Room.databaseBuilder(
        TitanApplication.getInstance().getApplicationContext(), TitanDB.class, DB_NAME)
        .build();
  }

  /**
   * Supports conversion operations for persistence of relevant types not natively supported by
   * Room/SQLite.
   */
  public static class Converters {

    /**
     * Converts {@link User} to String.
     *
     * @param typeString
     * @return typeString
     */
    @TypeConverter
    public static User.Type stringToUserType(String typeString) {
      return User.Type.valueOf(typeString);
    }


    /**
     * Takes a {@link User} and converts to a String
     *
     * @param type takes a {@link User}.
     * @return a String
     */
    @TypeConverter
    public static String userTypeToString(User.Type type) {

      return type.toString();
    }
  }
}




