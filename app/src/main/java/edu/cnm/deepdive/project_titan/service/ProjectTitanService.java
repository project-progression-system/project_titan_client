package edu.cnm.deepdive.project_titan.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.project_titan.R;
import edu.cnm.deepdive.project_titan.TitanApplication;
import edu.cnm.deepdive.project_titan.model.entity.Achievements;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ProjectTitanService {

    @GET("quotes/random")
    Call<Achievements> get();

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

    class GetAcheivmentTask extends BaseFluentAsyncTask<Void, Void, Achievements, Achievements> {

      private Achievements achievement;

      @Override
      protected Achievements perform(Void... voids) throws TaskException {
        try {
          Response<Achievements> response = InstanceHolder.INSTANCE.get().execute();
          if (!response.isSuccessful()) {
            throw new TaskException();
          }
          return response.body();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }

    }


  }
