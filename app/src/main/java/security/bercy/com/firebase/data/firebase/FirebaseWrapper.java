package security.bercy.com.firebase.data.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import security.bercy.com.firebase.model.Movie;

/**
 * Created by Bercy on 12/21/17.
 */

public class FirebaseWrapper {


    private static final String TAG = "warrer";

    FirebaseDatabase firebaseDatabase;
    DatabaseReference mySimpleRef;
    DatabaseReference myRef;
    private DatabaseReference movieRef;


    public static class Reference {
        public static final String MOVIE="movie";

    }


    public FirebaseWrapper(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase = firebaseDatabase;
        initReference();
    }

    public void saveSimpleData(String message) {

        // Write a message to the database
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");


            mySimpleRef = firebaseDatabase.getReference("myRef");
            mySimpleRef.setValue(message);
    }

    public void readSimpleData() {
        myRef=firebaseDatabase.getReference("myRef");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String simpleData= dataSnapshot.getValue(String.class);
                Log.d(TAG, "onDataChange: "+simpleData);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void saveMovie(Movie movie) {

        movieRef.push().setValue(movie);
    }

    private void initReference() {
        movieRef = firebaseDatabase.getReference(Reference.MOVIE);
    }


    public void getMovieList() {
        final List<Movie> movieList = new ArrayList<>();
        movieRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()) {
                    movieList.add(snapshot.getValue(Movie.class));
                    Log.d(TAG, "onDataChange: "+movieList.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

}
