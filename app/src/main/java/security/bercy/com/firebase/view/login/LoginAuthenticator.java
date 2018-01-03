package security.bercy.com.firebase.view.login;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;

/**
 * Created by Bercy on 12/20/17.
 */

public class LoginAuthenticator {
    FirebaseAuth mAuth;
    LoginActivity activity;
    OnLoginInteraction onLoginInteraction;
    private FirebaseUser user;

    public LoginAuthenticator(FirebaseAuth mAuth, LoginActivity activity) {
        this.mAuth = mAuth;
        this.activity = activity;
    }

    public void validateUser(String email, String password,LoginPresenter loginPresenter) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        onLoginInteraction.onUserValidation(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            //Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                            //      Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }

    public void createUSer(String email, String password,LoginPresenter loginPresenter) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            user = mAuth.getCurrentUser();
                            onLoginInteraction.onUserCreation(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            // Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                            //  Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }

    public void checkUser() {
        user = mAuth.getCurrentUser();
        if(user!=null)
            onLoginInteraction.onUserSessionValid(true);
        else
            onLoginInteraction.onUserSessionValid(false);
    }



    public void initInterator(LoginPresenter loginPresenter) {
        onLoginInteraction = loginPresenter;
    }

    interface OnLoginInteraction {
        void onUserCreation(FirebaseUser user);
        void onUserValidation(FirebaseUser user);
        void onUserSessionValid(boolean isValid);
    }
}
