package security.bercy.com.firebase.view.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import security.bercy.com.firebase.R;
import security.bercy.com.firebase.view.movie.MovieActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private static final String TAG = "login activity";
    private EditText etEmail;
    private EditText etPassword;
    private FirebaseAuth firebaseAuth;
    private LoginAuthenticator loginAuthenticator;
    private LoginPresenter presenter;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        firebaseAuth = FirebaseAuth.getInstance();
        loginAuthenticator = new LoginAuthenticator(firebaseAuth,this);
        presenter = new LoginPresenter(loginAuthenticator);
        presenter.attchView(this);
        presenter.checkSession();
    }

    public void OnFireBaseSignUp(View view) {
        getCredentials();
       presenter.createUser(email,password);

    }
    public void getCredentials() {
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();

    }
    public void OnFireBaseSignIn(View view) {
    getCredentials();
    presenter.validateUser(email,password);


    }

    private void bindViews() {
        etEmail = findViewById(R.id.et_userName);
        etPassword = findViewById(R.id.et_passWord);
    }


    @Override
    public void showError(String error) {

    }

    @Override
    public void onUserCreation(boolean isCreated) {
        Log.d(TAG, "onUserCreation: " + isCreated);
        if(isCreated) {
            showToast("User Created");
        }else {
            showToast("User created failed");
        }
    }

    @Override
    public void onUserValidation(boolean isValid) {
        Log.d(TAG, "onUserValidation: "+isValid);
        if(isValid) {
            showToast("Signed in");
        }else {
            showToast("Signed in failed");
        }
    }

    @Override
    public void isSessionVaild(boolean isValid) {
        if(isValid) {
            Intent intent = new Intent(getApplicationContext(), MovieActivity.class);
            startActivity(intent);
        }
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
