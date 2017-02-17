package com.yousoftskills.ramzi.fingerprintauthentication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aitorvs.android.fingerlock.FingerLock;
import com.aitorvs.android.fingerlock.FingerLockManager;
import com.aitorvs.android.fingerlock.FingerLockResultCallback;

public class MainActivity extends AppCompatActivity implements FingerLockResultCallback {
    private FingerLockManager mFingerLockManager;
    private Button mButton;
    private String KEY_NAME="ok";
    private TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFingerLockManager = FingerLock.initialize(this,KEY_NAME );
        textView=(TextView)findViewById(R.id.textView);
        mButton = (Button) findViewById(R.id.button_authenticate);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFingerLockManager.start();
            }
        });

    }

    @Override
    public void onFingerLockError(int i, Exception e) {

    }

    @Override
    public void onFingerLockAuthenticationSucceeded() {
        textView.setText("good it's successfully");

    }

    @Override
    public void onFingerLockReady() {

    }

    @Override
    public void onFingerLockScanning(boolean b) {

    }
}
