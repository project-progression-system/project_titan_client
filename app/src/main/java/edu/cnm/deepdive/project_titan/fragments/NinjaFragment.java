/**
 *  Copyright 2019 Lance Zotigh, Alex Rauenzahn, Thomas Herrera & Deep Dive Coding Licensed under the
 *  Apache License, Version 2.0 (the “License”); you may not use this file except in compliance with the
 *  License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package edu.cnm.deepdive.project_titan.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import android.view.Gravity;
import android.view.MotionEvent;
import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import edu.cnm.deepdive.project_titan.R;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.ux.TransformableNode;

/**
 * @authors Thomas Herrera, Alex Rauenzahn, Lance Zotigh @version 1.0
 *
 * Creates an {@link ArFragment} within {@link NinjaFragment}. This fragment will ask the user for the proper
 * permissions and then launches an augmented reality view that displays the ninja drop mesh. Users are able to
 * interact with the mesh through simple gesture controls that will allow resizing, rotating, and creation of the
 * mesh.
 */

public class NinjaFragment extends Fragment {

  public static final String BODY_TEXT_KEY = "body_text";

  private ModelRenderable ninjaRenderable;
  ArFragment arFragment;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_ninja, container, false);
    arFragment = (ArFragment) getChildFragmentManager().findFragmentByTag("ArFragment");
    ModelRenderable.builder()
        .setSource(getActivity(), R.raw.ninja_drop)
        .build()
        .thenAccept(renderable -> ninjaRenderable = renderable)
        .exceptionally(
            throwable -> {
              Log.e("renderable", "Unable to load Renderable.", throwable);
              Toast toast =
                  Toast
                      .makeText(getActivity(), "Unable to load andy renderable", Toast.LENGTH_LONG);
              toast.setGravity(Gravity.CENTER, 0, 0);
              toast.show();
              return null;
            });

    arFragment.setOnTapArPlaneListener(
        (HitResult hitResult, Plane plane, MotionEvent motionEvent) -> {
          if (ninjaRenderable == null) {
            return;
          }

          // Create the Anchor.
          Anchor anchor = hitResult.createAnchor();
          AnchorNode anchorNode = new AnchorNode(anchor);
          anchorNode.setParent(arFragment.getArSceneView().getScene());

          // Create the transformable andy and add it to the anchor.
          TransformableNode andy = new TransformableNode(arFragment.getTransformationSystem());
          andy.setParent(anchorNode);
          andy.setRenderable(ninjaRenderable);
          andy.select();
        });
    return view;
  }
}
