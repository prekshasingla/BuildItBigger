package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.mylibrary.JokeActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements ReceivedListener {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button b=(Button) root.findViewById(R.id.button);
        b.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        //String joke=new MyClass().getJoke();
                        //Toast.makeText(getActivity(), joke, Toast.LENGTH_LONG).show();
                        //Intent intent = new Intent(getActivity(), JokeActivity.class);
                        //intent.putExtra("joke", joke);
                        //startActivity(intent);
                        new EndpointsAsyncTask().execute(MainActivityFragment.this);

                    }

                });

                        return root;
    }

    public void onReceive(String joke) {

        Intent intent = new Intent(getActivity(), JokeActivity.class);
        intent.putExtra("joke", joke);
        startActivity(intent);

        //Toast.makeText(getContext(), joke, Toast.LENGTH_SHORT).show();
    }


}
