package com.test.surajmeditationapp.pages;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.test.surajmeditationapp.R;
import com.test.surajmeditationapp.application.MyApplication;
import com.test.surajmeditationapp.utils.ActivityManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Splash extends AppCompatActivity {

    @BindView(R.id.lottie) LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        init();
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (MyApplication.get().getmAuth().getCurrentUser() != null){

                    ActivityManager.HOME(Splash.this);
                    finish();

                }else {

                    ActivityManager.LOGIN(Splash.this);
                    finish();
                }
            }
        }, 4000);
    }

    private void init(){

        lottie.setAnimation("loading.json");
        lottie.loop(true);
        lottie.playAnimation();
    }
}
