package com.alexsoft.androidcustomfragmentmanager;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Stack;

/**
 * Created by Alex on 30.01.2017.
 */

public class FragmentManager {

    private Stack<Fragment> fragmentStack = new Stack<>();
    private LinearLayout rootView;
    private Context context;

    public FragmentManager(Context context) {
        this.context = context;
        this.rootView = new LinearLayout(context);
    }

    public Context getContext() {
        return context;
    }

    /**
     * Add fragment to stack
     *
     * @param fragment - object of custom Fragment class
     */
    public void add(Fragment fragment) {
        rootView.removeAllViews();    //remove all fragments from root view
        rootView.addView(fragment);     //add new fragment to rootView

        fragmentStack.push(fragment);     //add fragment to list
    }

    /**
     * Remove the last fragment from list
     */
    public void pop() throws IllegalStateException {
        if (fragmentStack.isEmpty()) {
            throw new IllegalStateException("Can't remove the last fragment from list. Cause: List is empty");
        }

        rootView.removeView(fragmentStack.pop());                  //remove all fragments from root view

        if (fragmentStack.isEmpty()) {               //check if list is empty
            return;
        }

        rootView.addView(fragmentStack.lastElement());   //add the last fragment to root view
    }

    /**
     * get root view for main activity
     *
     * @return root view
     */
    public View getRootView() {
        return rootView;
    }

    /**
     * @return true, if manager have no fragments
     */
    public boolean isEmpty() {
        return fragmentStack.isEmpty();
    }
}
