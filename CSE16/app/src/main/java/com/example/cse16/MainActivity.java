
package com.example.cse16;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class MainActivity extends AppCompatActivity {

    private Button bt;
    private EditText boxmail,boxpassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bt = findViewById(R.id.btn);
        boxmail = findViewById(R.id.email);
        boxpassword = findViewById(R.id.pass);
        mAuth = FirebaseAuth.getInstance();
    }


    public void doit(View view) {
        String Mail = boxmail.getText().toString().trim();
        String Pass = boxpassword.getText().toString().trim();

        if(Mail.isEmpty())
        {
            boxmail.setError("Enter an email address");
            boxmail.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(Mail).matches())
        {
            boxmail.setError("Enter a valid email address");
            boxmail.requestFocus();
            return;
        }

        //checking the validity of the password
        if(Pass.isEmpty())
        {
            boxpassword.setError("Enter a password");
            boxpassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(Mail,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();

                    Intent ok = new Intent(MainActivity.this,body.class);
                    startActivity(ok);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Failed "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


    public void newac(View view) {
        Intent in = new Intent(MainActivity.this,login.class);
        startActivity(in);
    }
}
