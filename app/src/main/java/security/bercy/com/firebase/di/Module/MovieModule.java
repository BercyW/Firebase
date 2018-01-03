package security.bercy.com.firebase.di.Module;

import dagger.Module;
import dagger.Provides;
import security.bercy.com.firebase.data.firebase.FirebaseWrapper;
import security.bercy.com.firebase.view.movie.MoviePresenter;

/**
 * Created by Bercy on 12/21/17.
 */
@Module
public class MovieModule {
    @Provides
    MoviePresenter providesMoviePresenter(FirebaseWrapper firebaseWrapper) {
        return new MoviePresenter(firebaseWrapper);
    }
}
