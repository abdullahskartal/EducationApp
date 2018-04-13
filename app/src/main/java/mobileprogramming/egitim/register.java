package mobileprogramming.egitim;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;


public class register extends AppCompatActivity {
    private EditText register_email,register_sifre;
    private FirebaseAuth auth;
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
        String rEmail = this.email.getText().toString();
        String rPassword = this.sifre.getText().toString();
        auth.createUserWithEmailAndPassword(rEmail, rPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(register.this, "Authentication completed.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void startLoginActivity (View view) {
        Intent startActivity = new Intent(register.this, login.class);
        startActivity(startActivity);
    }

}
