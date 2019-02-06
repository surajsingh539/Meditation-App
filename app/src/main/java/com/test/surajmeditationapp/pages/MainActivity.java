package com.test.surajmeditationapp.pages;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.test.surajmeditationapp.R;
import com.test.surajmeditationapp.utils.ActivityManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.focus_rl)
    void onFocusClicked(){

        startMediActivity("focus");
    }

    @OnClick(R.id.calm_down_rl)
    void onCalmDownClicked(){

        startMediActivity("calm_down");
    }

    @OnClick(R.id.destress_rl)
    void onDestressClicked(){

        startMediActivity("destress");
    }

    @OnClick(R.id.relax_rl)
    void onRelaxClicked(){

        startMediActivity("relax");
    }


    private void startMediActivity(String collection_id){

        ActivityManager.MEDITATION_ACTIVITY(this, collection_id);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    @OnClick(R.id.logout)
    void onLogout(){

        FirebaseAuth.getInstance().signOut();
        ActivityManager.LOGIN(this);
        finish();

    }
}
