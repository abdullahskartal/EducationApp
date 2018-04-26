package mobileprogramming.egitim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DersKonulari extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ders_konulari);

        Button btnDersAdi=(Button)findViewById(R.id.btnDersAdi);
        final Button btnKonu1=(Button)findViewById(R.id.btnKonu1);
        final Button btnKonu2=(Button)findViewById(R.id.btnKonu2);
        final Button btnKonu3=(Button)findViewById(R.id.btnKonu3);
        final Button btnKonu4=(Button)findViewById(R.id.btnKonu4);

//BUTONLARA KONU ADLARINI EKLEME
        btnKonu2.setText("HTML ETİKETLER");
        btnKonu1.setText("HTML GİRİŞ");

        Bundle extras=getIntent().getExtras();
        final String secilenders=extras.getString("mesaj");












        btnKonu1.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
              String konuadi= (String) btnKonu1.getText();

              Intent k=new Intent(DersKonulari.this,Soru.class);
              k.putExtra("mesaj",secilenders);
              k.putExtra("mesaj2",konuadi);
              startActivity(k);
            }
        });
        btnKonu2.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                String konuadi= (String) btnKonu2.getText();

                Intent k=new Intent(DersKonulari.this,Soru.class);
                k.putExtra("mesaj",secilenders);
                k.putExtra("mesaj2",konuadi);
                startActivity(k);
            }
        });
        btnKonu3.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                String konuadi= (String) btnKonu3.getText();

                Intent k=new Intent(DersKonulari.this,Soru.class);
                k.putExtra("mesaj",secilenders);
                k.putExtra("mesaj2",konuadi);
                startActivity(k);
            }
        });
        btnKonu4.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                String konuadi= (String) btnKonu4.getText();

                Intent k=new Intent(DersKonulari.this,Soru.class);
                k.putExtra("mesaj",secilenders);
                k.putExtra("mesaj2",konuadi);
                startActivity(k);
            }
        });




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
