package mobileprogramming.egitim;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Register extends AppCompatActivity {
    private EditText register_email,register_sifre;
    private FirebaseAuth auth;
    private DatabaseReference mDatabase;
    private
    EditText email, sifre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth=FirebaseAuth.getInstance();

        this.email=findViewById(R.id.register_email);
        this.sifre=findViewById(R.id.register_sifre);

    }

    public void registerButton (View view) {
        final String rEmail = this.email.getText().toString();
        final String rPassword = this.sifre.getText().toString();
        auth.createUserWithEmailAndPassword(rEmail, rPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            DBusers yenikisi=new DBusers();

                            yenikisi.setUsermail(rEmail);
                            yenikisi.setUserpass(rPassword);

                            // database de kullanici alanının referansı alınıyor. burada işlemin yapılacağı belirtiliyor.
                            mDatabase = FirebaseDatabase.getInstance().getReference("Kullanici");

                            // database/kullanici/ içinde kayıt olan kişinin id si çeklip yeni kisi oluşturuluyor.
                            mDatabase.child(auth.getCurrentUser().getUid()).setValue(yenikisi);


                            Toast.makeText(Register.this, "Authentication completed.",
                                    Toast.LENGTH_SHORT).show();

                            Intent myIntent=new Intent(Register.this,Login.class);
                            startActivity(myIntent);} else {
                            Toast.makeText(Register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void startLoginActivity (View view) {
        Intent startActivity = new Intent(Register.this, Login.class);
        startActivity(startActivity);
    }



}
