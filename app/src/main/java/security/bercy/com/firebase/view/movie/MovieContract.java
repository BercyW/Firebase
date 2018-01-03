package security.bercy.com.firebase.view.movie;

import java.util.List;

import security.bercy.com.firebase.model.Movie;
import security.bercy.com.firebase.utils.BasePresenter;
import security.bercy.com.firebase.utils.BaseView;

/**
 * Created by Bercy on 12/21/17.
 */

public interface MovieContract {

    interface  View extends BaseView {
        void onMovieAdded(boolean isAdded);

        void onMovieListReceived(List<Movie> movies);
    }

    interface Presenter extends BasePresenter<View> {
        void saveMovie(Movie movie);
        void getMovieList();
    }
}
