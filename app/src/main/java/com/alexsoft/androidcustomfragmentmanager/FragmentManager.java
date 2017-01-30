package com.alexsoft.androidcustomfragmentmanager;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 30.01.2017.
 */

public class FragmentManager {

    private List<Fragment> fragmentList = new LinkedList<>();

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
    public Fragment getRootView() {
        int size = fragmentList.size();
        if (size == 0) {
            return null;
        }

        return fragmentList.get(size);
    }
}
