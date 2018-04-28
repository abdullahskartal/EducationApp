package mobileprogramming.egitim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Soru extends AppCompatActivity {


    private FirebaseAuth auth;
    private DatabaseReference mDatabase;

    public TextView txtSoru;
    public Button txtA;
    public Button txtB;
    public Button txtC;
    public TextView txtDogruSayisi;
    public int quesNum=1;
    public String dogruCevapDB;
    public int CevaplananSoruSayisi=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru);

        final TextView btnSoruAtla =(TextView)findViewById(R.id.btnSoruGec);
        final TextView btnSinaviBitir =(TextView)findViewById(R.id.btnSinavBitir);

        txtDogruSayisi=(TextView)findViewById(R.id.txtDogruSayisi);
        txtSoru=(TextView) findViewById(R.id.txtSoru);
        txtA=(Button)findViewById(R.id.txtA);
        txtB=(Button)findViewById(R.id.txtB);
        txtC=(Button)findViewById(R.id.txtC);



        Button btnBaslik=(Button)findViewById(R.id.btnDersAdiKonu);

        Bundle extras=getIntent().getExtras();
        final String secilenDers=extras.getString("mesaj");
        final String secilenKonu=extras.getString("mesaj2");


        btnBaslik.setText(secilenDers+" + "+secilenKonu);

        soruGetir(secilenDers,secilenKonu,quesNum);
        txtDogruSayisi.setText("0");

        btnSoruAtla.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                quesNum=quesNum+1;
                if (quesNum<4)
                {
                    soruGetir(secilenDers,secilenKonu,quesNum);

                }
                else{
                    btnSinaviBitir.performClick();
                }

            }
        });

        btnSinaviBitir.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent t=new Intent(Soru.this,SinavSonuc.class);
                //k.putExtra("Puan",txtDogruSayisi.getText().toString());
                String dogrusayi=txtDogruSayisi.getText().toString();
                String cvpsayisi=Integer.toString(CevaplananSoruSayisi);
                t.putExtra("DogruSayisi",dogrusayi);
                t.putExtra("CevaplananSayisi",cvpsayisi);

                startActivity(t);
            }
        });

        txtA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDogruSayisi.setText(cevapKontrol(txtA.getText().toString(),dogruCevapDB));
                CevaplananSoruSayisi=CevaplananSoruSayisi+1;
                btnSoruAtla.performClick();
            }
        });
        txtB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDogruSayisi.setText(cevapKontrol(txtB.getText().toString(),dogruCevapDB));
                CevaplananSoruSayisi=CevaplananSoruSayisi+1;
                btnSoruAtla.performClick();
            }
        });
        txtC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtDogruSayisi.setText(cevapKontrol(txtC.getText().toString(),dogruCevapDB));
                CevaplananSoruSayisi=CevaplananSoruSayisi+1;
                btnSoruAtla.performClick();
            }
        });

    }





    public void soruGetir(String secilenDers,String secilenKonu,int quesNum) {

        String SoruNo=String.valueOf(quesNum);

        DatabaseReference ref= FirebaseDatabase.getInstance().getReference();
        DatabaseReference refSoru=ref.child(secilenDers).child(secilenKonu).child(SoruNo).child("Soru");

        DatabaseReference refSoruA=ref.child(secilenDers).child(secilenKonu).child(SoruNo).child("cevapA");
        DatabaseReference refSoruB=ref.child(secilenDers).child(secilenKonu).child(SoruNo).child("cevapB");
        DatabaseReference refSoruC=ref.child(secilenDers).child(secilenKonu).child(SoruNo).child("cevapC");
        DatabaseReference refDogru=ref.child(secilenDers).child(secilenKonu).child(SoruNo).child("DogruCevap");

        refDogru.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dogruCevapDB= dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        refSoru.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                txtSoru.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        refSoruA.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                txtA.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        refSoruB.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                txtB.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        refSoruC.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                txtC.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

    public String cevapKontrol(String verilenCevap,String dogruCVP){
        int a= Integer.parseInt(txtDogruSayisi.getText().toString());


        if ( verilenCevap.equals(dogruCVP)){
            a++;
            Toast.makeText(Soru.this,"Doğru Bildiniz",Toast.LENGTH_LONG).show();

            return Integer.toString(a);
        }
        else{
            Toast.makeText(Soru.this,dogruCVP,Toast.LENGTH_SHORT).show();
            return Integer.toString(a);

        }
    }
}