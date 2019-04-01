package edu.cnm.deepdive.project_titan.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.cnm.deepdive.project_titan.R;

public class Fragment2 extends Fragment {

  public static final String BODY_TEXT_KEY = "body_text";

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
//    Bundle args = getArguments();
//    if (args != null) {
//      String body = args.getString(BODY_TEXT_KEY);
//      if (body != null) {
//        TextView bodytext = view.findViewById(R.id.body_text);
//        bodytext.setText(body);
//      }
//    }
    return view;
  }

}
