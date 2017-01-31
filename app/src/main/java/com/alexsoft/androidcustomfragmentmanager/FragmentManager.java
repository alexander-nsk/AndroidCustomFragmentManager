package com.alexsoft.androidcustomfragmentmanager;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 30.01.2017.
 */

public class FragmentManager {

    private List<Fragment> fragmentList = new LinkedList<>();
    private LinearLayout rootView;

    public FragmentManager(Context context) {
        this.rootView = new LinearLayout(context);
    }

    /**
     * Add fragment to stack
     *
     * @param fragment - object of custom Fragment class
     */
    public void add(Fragment fragment) {
        fragmentList.add(fragment);
    }

    /**
     * Remove the last fragment from list
     */
    public void pop() {
        int size = fragmentList.size();
        if (size == 0) {
            return;
        }

        fragmentList.remove(size - 1);
    }

    /**
     * get root view for main activity
     *
     * @return root view
     */
    public View getRootView() {
        return rootView;
    }
}
