package security.bercy.com.firebase.view.login;

import security.bercy.com.firebase.utils.BasePresenter;
import security.bercy.com.firebase.utils.BaseView;

/**
 * Created by Bercy on 12/20/17.
 */

public interface LoginContract {
    interface View extends BaseView {

        void onUserCreation(boolean isCreated);

        void onUserValidation(boolean isValid);

        void isSessionVaild(boolean isValid);
    }

    interface Presenter extends BasePresenter<View> {

        void validateUser(String email, String password);

        void createUser(String email, String password);

        void checkSession();
    }
}
