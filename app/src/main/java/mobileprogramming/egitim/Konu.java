package mobileprogramming.egitim;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Konu extends AppCompatActivity {


    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konu);

        Button signOut = (Button) findViewById(R.id.sign_out);

        Button btnC=(Button) findViewById(R.id.btnCdersi);
        Button btnCsharp =(Button) findViewById(R.id.btnCsharpDersi);
        Button btnHtml=(Button)findViewById(R.id.btnHtmlDersi);
        Button btnCss=(Button)findViewById(R.id.btnCssDersi);



        auth = FirebaseAuth.getInstance();

    /*
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user !=null){
            Toast.makeText(getApplicationContext(),user.getEmail(),Toast.LENGTH_SHORT).show();
        }
     */

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dersAdi="C";
                Intent k=new Intent(Konu.this,DersKonulari.class);
                k.putExtra("mesaj",dersAdi);
                startActivity(k);
            }
        });

        btnCsharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dersAdi="C#";
                Intent k=new Intent(Konu.this,DersKonulari.class);
                k.putExtra("mesaj",dersAdi);
                startActivity(k);
            }
        });
        btnCss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dersAdi="CSS";
                Intent k=new Intent(Konu.this,DersKonulari.class);
                k.putExtra("mesaj",dersAdi);
                startActivity(k);
            }
        });
        btnHtml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dersAdi="HTML";
                Intent k=new Intent(Konu.this,DersKonulari.class);
                k.putExtra("mesaj",dersAdi);
                startActivity(k);
            }
        });



        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                Intent k = new Intent(Konu.this, login.class);
                startActivity(k);

            }
        });




    }






}