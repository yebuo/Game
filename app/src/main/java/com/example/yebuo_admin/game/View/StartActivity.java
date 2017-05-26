package com.example.yebuo_admin.game.View;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.yebuo_admin.game.R;

public class StartActivity extends AppCompatActivity {

    //button startujący grę
    Button startGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Fullscreen enable, no title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_start);

        //start button init
        startGameButton = (Button) findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
            }
        });

    }

    //start new game
    protected void startGame()
    {
        startActivity(new Intent(StartActivity.this, GameActivity.class));
    }
}
