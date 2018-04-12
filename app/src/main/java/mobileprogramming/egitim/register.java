package mobileprogramming.egitim;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;


public class register extends AppCompatActivity implements View.OnClickListener {
    private EditText register_email,register_sifre;
    private FirebaseAuth auth;
    TextView girissayfası,hesapolustur;
    EditText kullanıcıadı,email,sifre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth=FirebaseAuth.getInstance();
        kullanıcıadı=(EditText)findViewById(R.id.kullanıcı_adi);
        email=(EditText)findViewById(R.id.register_email);
        sifre=(EditText)findViewById(R.id.register_sifre);
        hesapolustur=(TextView)findViewById(R.id.hesap_olustur);

        hesapolustur.setOnClickListener(this);


        hesapolustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=register_email.getText().toString().trim();
                String sifre=register_sifre.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Email adresinizi giriniz!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(sifre)){
                    Toast.makeText(getApplicationContext(),"Şifrenizi giriniz!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (sifre.length()<6){
                    Toast.makeText(getApplicationContext(),"Şifreniz minimum 6 karakter barındırmalı!",Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.createUserWithEmailAndPassword(email,sifre)
                        .addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(register.this,"createUserWithEmail:onComplete:"+task.isSuccessful(),Toast.LENGTH_SHORT).show();

                                if (!task.isSuccessful()){
                                    Toast.makeText(register.this,"Yetkilendirme hatası"+task.getException(),Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    startActivity(new Intent(register.this,login.class));
                                    finish();
                                }
                            }
                        });

            }
        });


        girissayfası=(TextView)findViewById(R.id.textView8);
        girissayfası.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(register.this,login.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hesap_olustur:
                break;
        }
    }
}
