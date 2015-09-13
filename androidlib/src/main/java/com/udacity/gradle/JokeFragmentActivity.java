package com.udacity.gradle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokeFragmentActivity extends Fragment {

    public JokeFragmentActivity() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_jokes, container, false);

        TextView textView = (TextView) v.findViewById(R.id.joke);

        String joke = getActivity().getIntent().getStringExtra("joke");
        textView.setText(joke + "");

        return v;

    }
}
