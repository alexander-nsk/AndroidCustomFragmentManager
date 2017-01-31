package com.alexsoft.androidcustomfragmentmanager;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import java.util.LinkedList;

/**
 * Created by Alex on 30.01.2017.
 */

public class FragmentManager {

    private LinkedList<Fragment> fragmentList = new LinkedList<>();
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
        rootView.removeAllViews();      //remove all fragments from root view
        rootView.addView(fragment);     //add new fragment to rootView

        fragmentList.add(fragment);     //add fragment to list
    }

    /**
     * Remove the last fragment from list
     */
    public void pop() throws Exception {
        if (fragmentList.isEmpty()) {
            throw new Exception("Can't remove the last fragment from list. Cause: List is empty");
        }

        fragmentList.removeLast();                  //remove last fragment from list

        if (fragmentList.isEmpty()) {               //check if list is empty
            return;
        }

        rootView.removeAllViews();                  //remove all fragments from root view
        rootView.addView(fragmentList.getLast());   //add the last fragment to root view
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
