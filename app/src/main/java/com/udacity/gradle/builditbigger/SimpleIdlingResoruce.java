package com.udacity.gradle.builditbigger;

import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleIdlingResoruce implements IdlingResource {
    ResourceCallback mCallBack;
    AtomicBoolean idleState = new AtomicBoolean(true);

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isIdleNow() {
        return idleState.get();
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        mCallBack = callback;
    }

    public void setIdleState(boolean idleState) {
        this.idleState.set(idleState);

        if(idleState && mCallBack != null){
            mCallBack.onTransitionToIdle();
        }
    }
}
