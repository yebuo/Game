package com.example.yebuo_admin.game.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.yebuo_admin.game.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StartActivity extends AppCompatActivity {

    //button startujący grę
    Button startGameButton;
    Long value;
    ProgressDialog mProgressDialog;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Fullscreen enable, no title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_start);

        load();

        //start button init
        startGameButton = (Button) findViewById(R.id.startGameButton);
        startGameButton.setText("START");
        startGameButton.setOnClickListener(view ->{
            startGame();
        });

        if(FirebaseAuth.getInstance().getCurrentUser() != null) {
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        }

    }

    //start new game
    protected void startGame()
    {
        startActivity(new Intent(StartActivity.this, GameActivity.class));
    }

    private void load(){
        mProgressDialog = ProgressDialog.show(this, "Czekaj", "");

        loadData();

    }

    private void loadData(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Fraction").child("Human").child("Archer").child("Attack");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value = dataSnapshot.getValue(Long.class);
                startGameButton.setText("START");
                mProgressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
