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


package edu.cnm.deepdive.project_titan.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.project_titan.R;
import edu.cnm.deepdive.project_titan.TitanApplication;
import edu.cnm.deepdive.project_titan.model.entity.Assignment;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface ProjectTitanService {

//    @GET("completions/assignments")
//    Call<Achievements> get();

  class InstanceHolder {

    private static final ProjectTitanService INSTANCE;

    static {
      TitanApplication application = TitanApplication.getInstance();
      Gson gson = new GsonBuilder()
          .excludeFieldsWithoutExposeAnnotation()
          .create();
      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(application.getApplicationContext().getString(R.string.base_url))
          .addConverterFactory(GsonConverterFactory.create(gson))
          .build();
      INSTANCE = retrofit.create(ProjectTitanService.class);
    }

  }

  class GetAcheivmentTask extends
      BaseFluentAsyncTask<Void, Void, Assignment, Assignment> {

    private Assignment assignment;

//    @Override
//    protected Assignment perform(Void... voids) throws TaskException {
//      try {
//        Response<Assignment> response = InstanceHolder.INSTANCE.get().execute();
//        if (!response.isSuccessful()) {
//          throw new TaskException();
//        }
//        return response.body();
//      } catch (IOException e) {
//        throw new RuntimeException(e);
//      }
//    }

  }


}
