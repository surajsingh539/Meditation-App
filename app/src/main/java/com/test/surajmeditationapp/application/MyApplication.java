package com.test.surajmeditationapp.application;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class MyApplication extends Application {

    private static MyApplication instance = null;
    private FirebaseFirestore mFirebaseFirestore;
    FirebaseUser mFirebaseUser;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.init(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

    public static MyApplication get(){
        return instance;
    }

    public FirebaseFirestore getmFirebaseFirestore() {
        if (mFirebaseFirestore == null)
            mFirebaseFirestore = FirebaseFirestore.getInstance();
        return mFirebaseFirestore;
    }

    public FirebaseAuth getmAuth() {
        if (mAuth == null) {
            mAuth = FirebaseAuth.getInstance();
        }
        return mAuth;
    }

    public FirebaseUser getmFirebaseUser() {
        if (mFirebaseUser == null) {
            mFirebaseUser = mAuth.getCurrentUser();
        }
        return mFirebaseUser;
    }
}
