package security.bercy.com.firebase.view.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Inject;

import security.bercy.com.firebase.R;
import security.bercy.com.firebase.data.firebase.FirebaseWrapper;
import security.bercy.com.firebase.model.Movie;
import security.bercy.com.firebase.utils.FirebaseApplication;

public class MovieActivity extends AppCompatActivity {
    @Inject
     MoviePresenter moviePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseApplication.get(this).getMovieComponent().inject(this);

        setContentView(R.layout.activity_movie);
       // FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        //FirebaseWrapper firebaseWrapper = new FirebaseWrapper(firebaseDatabase);

       //moviePresenter = new MoviePresenter(firebaseWrapper);



    }

    public void addMovieToFirebase(View view) {
        Movie moive = new Movie("sd","sd","sd","sd");
        moviePresenter.saveMovie(moive);
    }

    public void getMoive(View view) {
        moviePresenter.getMovieList();
    }
}
