package mobileprogramming.egitim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CssKonular extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_css_konular);

        final Button btnDersAdiKonu=(Button)findViewById(R.id.btnDersAdiKonu);

        final Button btnKonu1=(Button)findViewById(R.id.btnKonu1);
        final Button btnKonu2=(Button)findViewById(R.id.btnKonu2);
        final Button btnKonu3=(Button)findViewById(R.id.btnKonu3);
        final Button btnKonu4=(Button)findViewById(R.id.btnKonu4);

        btnKonu1.setText("CSS SINIFLANDIRMA");
        btnKonu2.setText("FONT ÖZELLİKLERİ");

        Bundle extras=getIntent().getExtras();
        final String secilenders=extras.getString("mesaj");
        btnDersAdiKonu.setText(secilenders);
        btnKonu1.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                String konuadi= (String) btnKonu1.getText();

                Intent k=new Intent(CssKonular.this,Soru.class);
                k.putExtra("mesaj",secilenders);
                k.putExtra("mesaj2",konuadi);
                startActivity(k);
            }
        });
        btnKonu2.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                String konuadi= (String) btnKonu2.getText();

                Intent k=new Intent(CssKonular.this,Soru.class);
                k.putExtra("mesaj",secilenders);
                k.putExtra("mesaj2",konuadi);
                startActivity(k);
            }
        });
        btnKonu3.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                String konuadi= (String) btnKonu3.getText();

                Intent k=new Intent(CssKonular.this,Soru.class);
                k.putExtra("mesaj",secilenders);
                k.putExtra("mesaj2",konuadi);
                startActivity(k);
            }
        });
        btnKonu4.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                String konuadi= (String) btnKonu4.getText();

                Intent k=new Intent(CssKonular.this,Soru.class);
                k.putExtra("mesaj",secilenders);
                k.putExtra("mesaj2",konuadi);
                startActivity(k);
            }
        });




        TextView btnGeri=(TextView)findViewById(R.id.btnGeri);
        btnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(CssKonular.this,Konu.class);
                startActivity(k);
            }
        });
        Toast.makeText(CssKonular.this,secilenders,Toast.LENGTH_SHORT).show();
    }
}
