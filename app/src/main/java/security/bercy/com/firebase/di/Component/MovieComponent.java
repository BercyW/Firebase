package security.bercy.com.firebase.di.Component;

import dagger.Subcomponent;
import security.bercy.com.firebase.di.Module.MovieModule;
import security.bercy.com.firebase.view.movie.MovieActivity;

/**
 * Created by Bercy on 12/21/17.
 */
@Subcomponent(modules = MovieModule.class)
public interface MovieComponent {
    void inject(MovieActivity movieActivity);
}
