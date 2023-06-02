package ik.dev.bugsbunny;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public static final long NOTIFY_INTERVAL = 1 * 1000;

    private Handler mHandler = new Handler();

    private Timer mTimer = null;

    ImageView img_cartoon;

    TextView txt_score;

    TextView txt_winner;

    int count = 0;

    String sound_on_or_off = "on";

    ImageView app_sound_status;

    ConstraintLayout layout_con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_cartoon = (ImageView)findViewById(R.id.img_cartoon);

        txt_score = (TextView)findViewById(R.id.txt_score);

        txt_winner = (TextView)findViewById(R.id.txt_winner);

        txt_winner.setVisibility(View.INVISIBLE);

        app_sound_status = (ImageView)findViewById(R.id.app_sound_status);

        layout_con = (ConstraintLayout)findViewById(R.id.layout_con);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        ConstraintLayout layout_con = (ConstraintLayout)findViewById(R.id.layout_con);
        layout_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DeadActivity.class);
                intent.putExtra("score", txt_score.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        final ImageView app_sound_status = (ImageView) findViewById(R.id.app_sound_status);
        app_sound_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sound_on_or_off == "on") {
                    sound_on_or_off = "off";
                    app_sound_status.setImageResource(R.drawable.ic_sound_off);
                }else if (sound_on_or_off == "off") {
                    sound_on_or_off = "on";
                    app_sound_status.setImageResource(R.drawable.ic_sound_on);
                }
            }
        });

        if (mTimer != null) {
            mTimer.cancel();
        } else {
            mTimer = new Timer();
        }

        mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 0, NOTIFY_INTERVAL);


        ImageView btn1 = (ImageView)findViewById(R.id.img_cartoon);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;

                txt_score.setText("Score : " + String.valueOf(count));

                clicked_sound();

                txt_winner.setVisibility(View.VISIBLE);

                count_timer();

            }
        });

    }

    class TimeDisplayTimerTask extends TimerTask {

        @Override
        public void run() {

            mHandler.post(new Runnable() {

                @Override
                public void run() {

                       tt();
                       kk();
                       bb();
                       gg();
                       lol();
                       mm();

                }

            });
        }

    }

    private void count_timer() {

        new CountDownTimer(2000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                txt_winner.setVisibility(View.INVISIBLE);
            }
        }.start();

    }

    private void tt() {

        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                img_cartoon.setY(500);
                img_cartoon.setX(500);
            }
        }.start();

    }

    private void kk() {

        new CountDownTimer(4000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                img_cartoon.setY(900);
                img_cartoon.setX(900);
            }
        }.start();

    }

    private void bb() {

        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                img_cartoon.setY(400);
                img_cartoon.setX(700);
            }
        }.start();

    }

    private void gg() {

        new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                img_cartoon.setY(832);
                img_cartoon.setX(350);
            }
        }.start();

    }

    private void lol() {

        new CountDownTimer(7000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                img_cartoon.setY(832);
                img_cartoon.setX(100);
            }
        }.start();

    }

    private void mm() {

        new CountDownTimer(8000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                img_cartoon.setY(432);
                img_cartoon.setX(100);
            }
        }.start();

    }

    private void clicked_sound() {
        MediaPlayer mPlayer = MediaPlayer.create(MainActivity.this, R.raw.clicked_cartoon_object_sound);
        if (sound_on_or_off == "on") {
         mPlayer.start();
       }else if (sound_on_or_off == "off") {
           mPlayer.stop();
       }

    }

    @Override
    public void onBackPressed() {

        startService(new Intent(MainActivity.this,BugsBunny_Service.class));

        finish();

    }

}
