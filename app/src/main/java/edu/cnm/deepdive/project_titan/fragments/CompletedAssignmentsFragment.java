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


package edu.cnm.deepdive.project_titan.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import edu.cnm.deepdive.project_titan.R;
import edu.cnm.deepdive.project_titan.model.TitanDB;
import edu.cnm.deepdive.project_titan.model.entity.Complete;
import edu.cnm.deepdive.project_titan.service.BaseFluentAsyncTask.ResultListener;
import edu.cnm.deepdive.project_titan.service.ProjectTitanService.GetAchievementTask;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompletedAssignmentsFragment extends Fragment {

  private List<Complete> completes;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.completed_assignments_fragment, container, false);
    completes = new ArrayList<>();
    ListView listView = view.findViewById(R.id.completed_list);
    ArrayAdapter<Complete> adapter = new ArrayAdapter<>(
        CompletedAssignmentsFragment.this.getContext(),
        android.R.layout.simple_list_item_1,
        completes);
    listView.setAdapter(adapter);

    new GetAchievementTask()
        .setSuccessListener(new ResultListener<List<Complete>>() {
          @Override
          public void handle(List<Complete> completes) {
            CompletedAssignmentsFragment.this.completes.clear();
            CompletedAssignmentsFragment.this.completes.addAll(completes);
            adapter.notifyDataSetChanged();
          }
        })
        .execute();
    return view;
  }


}

