package com.example.dev.clp_test;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.dev.clp_test.views.PreviewView;

/**
 * Created by Dev on 3/9/2015.
 */
public class PreviewAdapter extends ArrayAdapter<PreviewView> {

    public PreviewAdapter(Context context, int resource)
    {
        super(context, resource);
    }
}
