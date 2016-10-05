package com.github.stephenvinouze.shapeviewsample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.stephenvinouze.shapeviewsample.R;

/**
 * Created by Stephen Vinouze on 06/11/2015.
 */
public class HalfCircleEdgeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_half_circle_edge, container, false);
    }

}
