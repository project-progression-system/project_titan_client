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
package edu.cnm.deepdive.project_titan.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import edu.cnm.deepdive.project_titan.TitanApplication;
import edu.cnm.deepdive.project_titan.model.entity.CompletedAssignments;
import edu.cnm.deepdive.project_titan.model.entity.User;

@Database(
    entities = {CompletedAssignments.class, User.class},
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
