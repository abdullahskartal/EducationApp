package mobileprogramming.egitim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SinavSonuc extends AppCompatActivity {


    private FirebaseAuth auth;
    public TextView txtCevapSayisi;
    public TextView txtDogruSayisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinav_sonuc);

        txtCevapSayisi=(TextView)findViewById(R.id.txtSonucCevapSayisi);
        txtDogruSayisi=(TextView)findViewById(R.id.txtSonucDogruSayisi);


        Bundle extras=getIntent().getExtras();
        String DogruSayisi=extras.getString("DogruSayisi");
        String CevaplananSayisi=extras.getString("CevaplananSayisi");

        txtDogruSayisi.setText(DogruSayisi);
        txtCevapSayisi.setText(CevaplananSayisi);

        TextView btnGeri=(TextView)findViewById(R.id.btnGeri);
        btnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(SinavSonuc.this,Konu.class);
                startActivity(k);
            }
        });

    }
}