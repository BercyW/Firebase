package security.bercy.com.firebase.di.Component;

import dagger.Component;
import security.bercy.com.firebase.di.Module.AppModule;
import security.bercy.com.firebase.di.Module.LoginModule;
import security.bercy.com.firebase.di.Module.MovieModule;

/**
 * Created by Bercy on 12/21/17.
 */
@Component(modules = AppModule.class)
public interface AppComponent {

    LoginComponent add(LoginModule loginModule);
    MovieComponent add(MovieModule movieModule);
}
