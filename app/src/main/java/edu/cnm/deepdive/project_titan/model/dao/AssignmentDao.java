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


package edu.cnm.deepdive.project_titan.model.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.project_titan.model.entity.Assignment;
import java.util.List;


/**
 * Declares basic CRUD operations for {@link Assignment} instances in the local database, using Room annotations.
 */
@Dao
public interface AssignmentDao {


  /**
   * Selects all {@link Assignment} in descending order.
   *
   * @return A List of {@link Assignment}.
   */
  @Query("SELECT * FROM Assignment ORDER BY id DESC")
  List<Assignment> findAll();

  /**
   * Inserts the points for {@link Assignment}.
   *
   * @param completedAssignments takes {@link Assignment} and returns them as completed assignments.
   * @return a List of long values as completed assignments.
   */
  @Insert
  List<Long> insertPoints(Assignment... completedAssignments);


}
