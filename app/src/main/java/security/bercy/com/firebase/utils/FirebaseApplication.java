package security.bercy.com.firebase.utils;

import android.app.Application;
import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import security.bercy.com.firebase.di.Component.AppComponent;

import security.bercy.com.firebase.di.Component.DaggerAppComponent;
import security.bercy.com.firebase.di.Component.LoginComponent;
import security.bercy.com.firebase.di.Component.MovieComponent;
import security.bercy.com.firebase.di.Module.AppModule;
import security.bercy.com.firebase.di.Module.MovieModule;

/**
 * Created by Bercy on 12/21/17.
 */

public class FirebaseApplication extends Application {
    AppComponent appComponent;
    LoginComponent loginComponent;
    MovieComponent movieComponent;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;

    @Override
    public void onCreate() {
        super.onCreate();

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        AppModule appModule = new AppModule(firebaseDatabase,firebaseAuth);

        appComponent = DaggerAppComponent.builder()
                .appModule(appModule).build();


    }
    public static FirebaseApplication get(Context context) {
        return (FirebaseApplication) context.getApplicationContext();
    }
    public MovieComponent getMovieComponent() {
        movieComponent = appComponent.add(new MovieModule());
        return movieComponent;
    }

    public void clearMovieComponent() {
        movieComponent = null;
    }

}
