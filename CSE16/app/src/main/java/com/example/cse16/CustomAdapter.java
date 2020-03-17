package com.example.cse16;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<cse> {

    private Activity context;
    List<cse> cseList;

    public CustomAdapter(Activity context, List<cse> cseList) {
        super(context, R.layout.sample,cseList);
        this.context = context;
        this.cseList = cseList;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample,null,true);

        cse cse = cseList.get(position);

        TextView ID = view.findViewById(R.id.id);
        TextView REG = view.findViewById(R.id.res);
        TextView NAME = view.findViewById(R.id.name);
        TextView PHONE = view.findViewById(R.id.phone);
        TextView MAIL = view.findViewById(R.id.mail);
        TextView DATE = view.findViewById(R.id.date);
        TextView BLOOD = view.findViewById(R.id.blood);

        try
        {
            ID.setText("ID : "+cse.getID());
            NAME.setText("NAME : "+cse.getName());
            PHONE.setText("PHONE : "+cse.getPhone());
            DATE.setText("BIRTHDATE : "+cse.getDate());
            MAIL.setText("EMAIL : "+cse.getEmail());
            REG.setText("REG : "+cse.getReg());
            BLOOD.setText("BLOOD : "+cse.getBlood());
        }
        catch (Exception e)
        {

        }

        return view;
    }
}
