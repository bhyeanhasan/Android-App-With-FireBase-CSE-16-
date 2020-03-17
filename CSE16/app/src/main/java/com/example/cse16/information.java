package com.example.cse16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class information extends AppCompatActivity {

    EditText ID,Reg,Name,Phone,Email,Date,Blood;
    DatabaseReference data;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Date = findViewById(R.id.date);
        Reg = findViewById(R.id.reg);
        Name = findViewById(R.id.name);
        Phone = findViewById(R.id.phone);
        Email = findViewById(R.id.mail);
        Blood = findViewById(R.id.blood);

        data = FirebaseDatabase.getInstance().getReference("cse16");
    }

    public void donow(View view) {
            String mail = Email.getText().toString().trim();
            String reg = Reg.getText().toString().trim();
            String name = Name.getText().toString().trim();
            String phone = Phone.getText().toString().trim();
            String date = Date.getText().toString().trim();
            String blood = Blood.getText().toString().trim();
            Bundle bundle = getIntent().getExtras();
            String key = bundle.getString("k");

            cse send = new cse(key,name,phone,date,mail,reg,blood);

            try
            {
                data.child(key).setValue(send);
                Intent go = new Intent(information.this,body.class);
                startActivity(go);
            }
            catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),"NOOO",Toast.LENGTH_SHORT).show();
            }

        Toast.makeText(getApplicationContext(),"done",Toast.LENGTH_SHORT).show();

    }
}
