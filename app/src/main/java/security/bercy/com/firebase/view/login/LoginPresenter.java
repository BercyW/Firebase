package security.bercy.com.firebase.view.login;

import android.util.Log;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Bercy on 12/20/17.
 */

public class LoginPresenter implements LoginContract.Presenter,LoginAuthenticator.OnLoginInteraction{

    LoginContract.View view;
    LoginAuthenticator loginAuthenticator;



    public LoginPresenter(LoginAuthenticator loginAuthenticator) {
        this.loginAuthenticator = loginAuthenticator;
        loginAuthenticator.initInterator(this);
    }


    @Override
    public void attchView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void validateUser(String email, String password) {
        //check user

        loginAuthenticator.validateUser(email,password,this);


    }

    @Override
    public void createUser(String email, String password) {
        Log.d("LoginPresenterTag", "createUser: ");
        loginAuthenticator.createUSer(email,password,this);
    }

    @Override
    public void checkSession() {
        loginAuthenticator.checkUser();
    }

    @Override
    public void onUserCreation(FirebaseUser user) {
        if(user!=null)
            view.onUserCreation(true);
        else
            view.onUserCreation(false);
    }

    @Override
    public void onUserValidation(FirebaseUser user) {
        if(user!=null)
            view.onUserValidation(true);
        else
            view.onUserValidation(false);
    }

    @Override
    public void onUserSessionValid(boolean isValid) {
        view.isSessionVaild(isValid);
    }
}
