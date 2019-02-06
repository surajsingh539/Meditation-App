package com.test.surajmeditationapp.utils;

import android.content.Context;
import android.content.Intent;

import com.test.surajmeditationapp.pages.LogIn;
import com.test.surajmeditationapp.pages.MainActivity;
import com.test.surajmeditationapp.pages.MeditationActivity;

public class ActivityManager {

    public static void HOME(Context context){

        context.startActivity(new Intent(context, MainActivity.class));
    }

    public static void LOGIN(Context context){

        context.startActivity(new Intent(context, LogIn.class));
    }

    public static void MEDITATION_ACTIVITY(Context context, String collection_id){

        Intent intent = new Intent(context, MeditationActivity.class);
        intent.putExtra("collection_id", collection_id);
        context.startActivity(intent);
    }
}
