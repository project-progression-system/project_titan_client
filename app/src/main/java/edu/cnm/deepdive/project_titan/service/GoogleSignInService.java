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


import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import edu.cnm.deepdive.project_titan.R;
import edu.cnm.deepdive.project_titan.TitanApplication;


/**
 * This service provides all of the {@link GoogleSignInService} allowing our app to utilize this and
 * all of its functions.
 */
public class GoogleSignInService {

  private GoogleSignInClient client;
  private GoogleSignInAccount account;


  private GoogleSignInService() {
    GoogleSignInOptions options =
        new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestId()
            .requestIdToken(TitanApplication.getInstance().getString(R.string.client_id))
            .build();
    client = GoogleSignIn.getClient(TitanApplication.getInstance(), options);
  }


  /**
   * Gets an instance of {@link GoogleSignIn}.
   *
   * @return an instance of {@link GoogleSignIn}.
   */
  public static GoogleSignInService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Gets a client from {@link GoogleSignIn}.
   *
   * @return a client.
   */
  public GoogleSignInClient getClient() {
    return client;
  }

  /**
   * Sets a client for {@link GoogleSignIn}.
   *
   * @param client returns this client from {@link GoogleSignInClient}
   */
  public void setClient(GoogleSignInClient client) {
    this.client = client;
  }

  /**
   * Gets client from {@link GoogleSignInAccount}
   *
   * @return the {@link GoogleSignInAccount}.
   */
  public GoogleSignInAccount getAccount() {
    return account;
  }

  /**
   * Sets account for {@link GoogleSignInAccount}.
   *
   * @param account Takes a {@link GoogleSignInAccount} and uses an account to assign it.
   */
  public void setAccount(GoogleSignInAccount account) {
    this.account = account;
  }

  private static class InstanceHolder {

    private static final GoogleSignInService INSTANCE = new GoogleSignInService();

  }

}