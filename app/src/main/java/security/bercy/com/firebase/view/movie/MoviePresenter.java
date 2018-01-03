package security.bercy.com.firebase.view.movie;

import security.bercy.com.firebase.data.firebase.FirebaseWrapper;
import security.bercy.com.firebase.model.Movie;

/**
 * Created by Bercy on 12/21/17.
 */

public class MoviePresenter implements MovieContract.Presenter {

    MovieContract.View view;
    FirebaseWrapper firebaseWrapper;

    public MoviePresenter(FirebaseWrapper firebaseWrapper) {
        this.firebaseWrapper = firebaseWrapper;
    }

    @Override
    public void attchView(MovieContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void saveMovie(Movie movie) {
        firebaseWrapper.saveSimpleData("saving simple");
        firebaseWrapper.saveMovie(movie);
    }

    @Override
    public void getMovieList() {
        //firebaseWrapper.readSimpleData();
        firebaseWrapper.getMovieList();
    }
}
