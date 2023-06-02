package ik.dev.bugsbunny;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class DeadActivity extends AppCompatActivity {

    TextView txt_score_1;

    Button btn_try_again;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dead);

        txt_score_1 = (TextView)findViewById(R.id.txt_score_1);

        btn_try_again = (Button)findViewById(R.id.btn_try_again);

        txt_score_1.setText(getIntent().getExtras().getString("score"));

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-<id>");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        dead_sound();

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Log.i("Ads", "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.i("Ads", "onAdFailedToLoad");
            }

            @Override
            public void onAdOpened() {
                Log.i("Ads", "onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                Log.i("Ads", "onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                Log.i("Ads", "onAdClosed");
            }
        });

        Button btn_try_again = (Button)findViewById(R.id.btn_try_again);
        btn_try_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeadActivity.this, MainActivity.class));
                finish();
            }
        });

    }

    private void dead_sound() {
        MediaPlayer mPlayer = MediaPlayer.create(DeadActivity.this, R.raw.bugs46);
        mPlayer.start();
    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(DeadActivity.this, MainActivity.class));

        finish();

    }

}
