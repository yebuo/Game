package com.example.yebuo_admin.game.Presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yebuo_admin.game.Model.Unit;
import com.example.yebuo_admin.game.R;

import java.util.ArrayList;

/**
 * Created by Yebuo on 28.11.2017.
 */

public class UnitAdapter extends android.support.v7.widget.RecyclerView.Adapter<UnitAdapter.CardHolder>{

    private final ArrayList<Unit> mValues;
    private final Context mContext;

    public UnitAdapter(ArrayList<Unit> mValues, Context context) {
        this.mValues = mValues;
        this.mContext = context;
    }

    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_unit_selection, parent, false);
        CardHolder cardHolder = new CardHolder(view);
        return cardHolder;
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {
        holder.unit = mValues.get(position);
        holder.unitName.setText(mValues.get(position).getName());
        holder.unitHP.setText(Integer.toString(mValues.get(position).getHp()));
        holder.unitAttack.setText(Integer.toString(mValues.get(position).getAttack()));
        holder.unitDefence.setText(Integer.toString(mValues.get(position).getDefence()));
        holder.unitImage.setImageResource(R.drawable.archer);
//        holder.uri = mValues.get(position).
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class CardHolder extends RecyclerView.ViewHolder {
        Unit unit;
        TextView unitName;
        TextView unitHP;
        TextView unitAttack;
        TextView unitDefence;
        ImageView unitImage;
        String uri;

        public CardHolder(View itemView) {
            super(itemView);
            unitName = (TextView) itemView.findViewById(R.id.unitName);
            unitImage = (ImageView) itemView.findViewById(R.id.unitImage);
            unitHP = (TextView) itemView.findViewById(R.id.unitHP);
            unitAttack = (TextView) itemView.findViewById(R.id.unitAttack);
            unitDefence = (TextView) itemView.findViewById(R.id.unitDefence);
        }
    }
}
