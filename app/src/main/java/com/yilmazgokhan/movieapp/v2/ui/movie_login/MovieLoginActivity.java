package com.yilmazgokhan.movieapp.v2.ui.movie_login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.account.AccountAuthManager;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.request.AccountAuthParamsHelper;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.account.service.AccountAuthService;
import com.yilmazgokhan.movieapp.v2.databinding.ActivityMovieLoginBinding;
import com.yilmazgokhan.movieapp.v2.ui.movie_search.MovieSearchActivity;

public class MovieLoginActivity extends AppCompatActivity {

    // AccountAuthService provides a set of APIs, including silentSignIn, getSignInIntent, and signOut.
    private AccountAuthService mAuthService;
    // Define the request code for signInIntent.
    private static final int REQUEST_CODE_SIGN_IN = 1000;
    // Define the log flag.
    private static final String TAG = "Account";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.yilmazgokhan.movieapp.v2.databinding.ActivityMovieLoginBinding binding = ActivityMovieLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.HuaweiIdAuthButton.setOnClickListener(v -> silentSignInByHwId());
    }

    /**
     * Silent sign-in: If a user has authorized your app and signed in, no authorization or sign-in screen will appear during subsequent sign-ins, and the user will directly sign in.
     * After a successful silent sign-in, the HUAWEI ID information will be returned in the success event listener.
     * If the user has not authorized your app or signed in, the silent sign-in will fail. In this case, your app will show the authorization or sign-in screen to the user.
     */
    private void silentSignInByHwId() {
        // 1. Use AccountAuthParams to specify the user information to be obtained, including the user ID (OpenID and UnionID), email address, and profile (nickname and picture).
        // 2. By default, DEFAULT_AUTH_REQUEST_PARAM specifies two items to be obtained, that is, the user ID and profile.
        // 3. If your app needs to obtain the user's email address, call setEmail().
        // 4. To support ID token-based HUAWEI ID sign-in, use setIdToken(). User information can be parsed from the ID token.
        // Set HUAWEI ID sign-in authorization parameters.
        AccountAuthParams mAuthParam = new AccountAuthParamsHelper(AccountAuthParams.DEFAULT_AUTH_REQUEST_PARAM)
                .setEmail()
                .setIdToken()
                .createParams();
        // Use AccountAuthParams to build AccountAuthService.
        mAuthService = AccountAuthManager.getService(this, mAuthParam);
        // Sign in with a HUAWEI ID silently.
        Task<AuthAccount> task = mAuthService.silentSignIn();
        // The silent sign-in is successful. Process the returned AuthAccount object to obtain the HUAWEI ID information.
        task.addOnSuccessListener(this::dealWithResultOfSignIn);
        task.addOnFailureListener(e -> {
            // The silent sign-in fails. Your app will call getSignInIntent() to show the authorization or sign-in screen.
            if (e instanceof ApiException) {
                Intent signInIntent = mAuthService.getSignInIntent();
                startActivityForResult(signInIntent, REQUEST_CODE_SIGN_IN);
                Toast.makeText(MovieLoginActivity.this, "sign in failed : " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    /**
     * Process the returned AuthAccount object to obtain the HUAWEI ID information.
     *
     * @param authAccount AuthAccount object, which contains the HUAWEI ID information.
     */
    private void dealWithResultOfSignIn(AuthAccount authAccount) {
        Log.i(TAG, "idToken:" + authAccount.getIdToken());

        if (authAccount.getIdToken() != null) {
            Toast.makeText(this, authAccount.getIdToken(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MovieLoginActivity.this, MovieSearchActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "ID Token not found!", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SIGN_IN) {
            Log.i(TAG, "onActivityResult of sigInInIntent, request code: " + REQUEST_CODE_SIGN_IN);
            Task<AuthAccount> authAccountTask = AccountAuthManager.parseAuthResultFromIntent(data);
            if (authAccountTask.isSuccessful()) {
                // The sign-in is successful, and the authAccount object that contains the HUAWEI ID information is obtained.
                AuthAccount authAccount = authAccountTask.getResult();
                dealWithResultOfSignIn(authAccount);
                Log.i(TAG, "onActivityResult of sigInInIntent, request code: " + REQUEST_CODE_SIGN_IN);
            } else {
                // The sign-in fails. Find the failure cause from the status code. For more information, please refer to the "Error Codes" section in the API Reference.
                Log.e(TAG, "sign in failed : " +((ApiException)authAccountTask.getException()).getStatusCode());
                Toast.makeText(this, "sign in failed : " +((ApiException)authAccountTask.getException()).getStatusCode(), Toast.LENGTH_SHORT).show();
            }
        }
    }

}
