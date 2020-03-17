package com.example.cse16;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class body extends AppCompatActivity {

    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    AlertDialog.Builder bye;
    ListView listView;

    private  List<cse> cseList;
    private  CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        databaseReference = FirebaseDatabase.getInstance().getReference("cse16");
        cseList = new ArrayList<>();
        customAdapter = new CustomAdapter(body.this,cseList);
        listView = findViewById(R.id.list);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cseList.clear();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren() )
                {
                    cse cs = dataSnapshot1.getValue(cse.class);
                    cseList.add(cs);
                }
                listView.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();

    }

    public void EXIT()
    {
        bye = new AlertDialog.Builder(this);
        bye.setMessage("Do You Want To EXIT?");
        bye.setTitle("CSE 16");
        bye.setCancelable(false);
        bye.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        bye.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = bye.create();
        alertDialog.show();


    }

    @Override
    public void onBackPressed() {
        EXIT();
    }
}
