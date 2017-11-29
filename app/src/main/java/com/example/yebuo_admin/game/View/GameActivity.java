package com.example.yebuo_admin.game.View;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yebuo_admin.game.Model.Unit;
import com.example.yebuo_admin.game.Presenter.UnitAdapter;
import com.example.yebuo_admin.game.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;

    ArrayList<Unit> unitsArray = new ArrayList<>();
    ImageView img;
    TextView txt;
    ProgressDialog mProgressDialog;
    UnitAdapter unitViewAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Fullscreen enable, no title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_game);


        load();
        Unit u1 = new Unit("test", 10, 5, 5, 5, 6, 10);
        unitsArray.add(u1);

        unitViewAdapter = new UnitAdapter(unitsArray, this);
        recyclerView = (RecyclerView) findViewById(R.id.unitList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(unitViewAdapter);
        unitViewAdapter.notifyItemRangeChanged(0,unitViewAdapter.getItemCount());
    }

    private void load(){
//        mProgressDialog = ProgressDialog.show(this, "Czekaj", "");

        loadData();

    }

    private void loadData(){
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Fraction").child("Human");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    Unit unit = new Unit();
                    String nam = (String) snapshot.child("Name").getValue();
                    Long atk = (Long) snapshot.child("Attack").getValue();
                    Long hp = (Long) snapshot.child("HP").getValue();
                    Long def = (Long) snapshot.child("Defence").getValue();
                    Long max = (Long) snapshot.child("DmgMax").getValue();
                    Long min = (Long) snapshot.child("DmgMin").getValue();
                    Long cost = (Long) snapshot.child("Cost").getValue();
                    unit.setAttack(atk.intValue());
                    unit.setDefence(def.intValue());
                    unit.setDmgMax(max.intValue());
                    unit.setDmgMin(min.intValue());
                    unit.setHp(hp.intValue());
                    unit.setCost(cost.intValue());
                    unit.setName(nam);
                    //Unit unit = snapshot.getValue(Unit.class);
                    unitsArray.add(unit);
                }
//                mProgressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
