package security.bercy.com.firebase.di.Module;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import dagger.Module;
import dagger.Provides;
import security.bercy.com.firebase.data.firebase.FirebaseWrapper;
import security.bercy.com.firebase.view.login.LoginAuthenticator;

/**
 * Created by Bercy on 12/21/17.
 */
@Module
public class AppModule {
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;

    public AppModule(FirebaseDatabase firebaseDatabase, FirebaseAuth firebaseAuth) {
        this.firebaseDatabase = firebaseDatabase;
        this.firebaseAuth = firebaseAuth;
    }

//    @Provides
//    LoginAuthenticator providesLoginAuthenticator() {
//        return new LoginAuthenticator(fi)
//    }
    @Provides
    FirebaseWrapper providesFirebaseWrapper() {
        return new FirebaseWrapper(firebaseDatabase);
    }

}
