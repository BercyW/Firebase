package security.bercy.com.firebase.di.Component;

import dagger.Module;
import dagger.Subcomponent;
import security.bercy.com.firebase.di.Module.LoginModule;

/**
 * Created by Bercy on 12/21/17.
 */
@Subcomponent(modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginModule loginModule);
}
