package mobileprogramming.egitim;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity implements View.OnClickListener {

    String login_sifre;
    EditText kullanıcıadi,sifregiris;
    TextView KayıtOl,giris;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth=FirebaseAuth.getInstance();

        if (auth.getCurrentUser()!=null){
            startActivity(new Intent(login.this,Konu.class));
            finish();
        }

        setContentView(R.layout.activity_login);


        kullanıcıadi=(EditText)findViewById(R.id.login_email);
        sifregiris=(EditText)findViewById(R.id.login_sifre);
        giris=(TextView)findViewById(R.id.giris);

        giris.setOnClickListener(this);

        auth=FirebaseAuth.getInstance();







        KayıtOl=(TextView)findViewById(R.id.textView5);
        KayıtOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,register.class);
                startActivity(intent);
            }
        });

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=kullanıcıadi.getText().toString();
                final String sifre= sifregiris.getText().toString();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Email adresinizi giriniz!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(sifre)){

                    Toast.makeText(getApplicationContext(),"Şifrenizi giriniz!",Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email,sifre)
                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()){

                                    Toast.makeText(getApplicationContext(),"Birşeyler ters gitti!",Toast.LENGTH_SHORT).show();

                                }else{
                                    Intent intent=new Intent(login.this,Konu.class);
                                    startActivity(intent);
                                    finish();

                                }
                            }
                        });


            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.giris:
                break;
        }
    }
}
