package mobileprogramming.egitim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DersKonulari extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ders_konulari);


        Bundle extras=getIntent().getExtras();
        String secilenders=extras.getString("mesaj");

        TextView btnGeri=(TextView)findViewById(R.id.btnGeri);
        btnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(DersKonulari.this,Konu.class);
                startActivity(k);
            }
        });
        Toast.makeText(DersKonulari.this,secilenders,Toast.LENGTH_SHORT).show();
    }
}
