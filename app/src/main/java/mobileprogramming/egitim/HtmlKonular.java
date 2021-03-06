package mobileprogramming.egitim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HtmlKonular extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htmlkonular);

        Button btnDersAdi=(Button)findViewById(R.id.btnDersAdiKonu);
        final Button btnKonu1=(Button)findViewById(R.id.btnKonu1);
        final Button btnKonu2=(Button)findViewById(R.id.btnKonu2);
        final Button btnKonu3=(Button)findViewById(R.id.btnKonu3);

//BUTONLARA KONU ADLARINI EKLEME
        btnKonu1.setText("HTML GİRİŞ");
        btnKonu2.setText("HTML ETİKETLER");
        btnKonu3.setText("METİN BİÇİMLENDİRME");

        Bundle extras=getIntent().getExtras();
        final String secilenders=extras.getString("mesaj");
        btnDersAdi.setText(secilenders);
        btnKonu1.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
              String konuadi= (String) btnKonu1.getText();

              Intent k=new Intent(HtmlKonular.this,Soru.class);
              k.putExtra("mesaj",secilenders);
              k.putExtra("mesaj2",konuadi);
              startActivity(k);
            }
        });
        btnKonu2.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                String konuadi= (String) btnKonu2.getText();

                Intent k=new Intent(HtmlKonular.this,Soru.class);
                k.putExtra("mesaj",secilenders);
                k.putExtra("mesaj2",konuadi);
                startActivity(k);
            }
        });
        btnKonu3.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                String konuadi= (String) btnKonu3.getText();

                Intent k=new Intent(HtmlKonular.this,Soru.class);
                k.putExtra("mesaj",secilenders);
                k.putExtra("mesaj2",konuadi);
                startActivity(k);
            }
        });

        TextView btnGeri=(TextView)findViewById(R.id.btnGeri);
        btnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(HtmlKonular.this,Konu.class);
                startActivity(k);
            }
        });
        Toast.makeText(HtmlKonular.this,secilenders,Toast.LENGTH_SHORT).show();
    }
}
