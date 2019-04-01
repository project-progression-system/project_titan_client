package edu.cnm.deepdive.project_titan.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.cnm.deepdive.project_titan.R;

public class Fragment3 extends Fragment {

  public static final String BODY_TEXT_KEY = "body_text";

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_fragment3, container, false);

    return view;
  }

}