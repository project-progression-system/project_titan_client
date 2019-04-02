package edu.cnm.deepdive.project_titan.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import edu.cnm.deepdive.project_titan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AchievementsFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.achievements_fragment, container, false);

    ListView listView = view.findViewById(R.id.achievement_list);

    return view;
  }

}
