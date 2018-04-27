package mobileprogramming.egitim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Soru extends AppCompatActivity {


    private FirebaseAuth auth;
    private DatabaseReference mDatabase;

    public EditText txtSoru;
    public Button txtA;
    public Button txtB;
    public Button txtC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru);

        txtSoru=(EditText)findViewById(R.id.txtSoru);
        txtA=(Button)findViewById(R.id.txtA);
        txtB=(Button)findViewById(R.id.txtB);
        txtC=(Button)findViewById(R.id.txtC);
        Button btnBaslik=(Button)findViewById(R.id.btnDersAdiKonu);

        Bundle extras=getIntent().getExtras();
        String secilenDers=extras.getString("mesaj");
        String secilenKonu=extras.getString("mesaj2");

        btnBaslik.setText(secilenDers+" "+secilenKonu);

        int quesNum=1;
        //String SoruNo=Integer.toString(quesNum);
        soruGetir(secilenDers,secilenKonu,quesNum);

    }

    public void soruGetir(String secilenDers,String secilenKonu,int quesNum) {

        String SoruNo=String.valueOf(quesNum);

        DatabaseReference ref= FirebaseDatabase.getInstance().getReference();
        DatabaseReference refSoru=ref.child(secilenDers).child(secilenKonu).child(SoruNo).child("Soru");

        DatabaseReference refSoruA=ref.child(secilenDers).child(secilenKonu).child(SoruNo).child("cevapA");
        DatabaseReference refSoruB=ref.child(secilenDers).child(secilenKonu).child(SoruNo).child("cevapB");
        DatabaseReference refSoruC=ref.child(secilenDers).child(secilenKonu).child(SoruNo).child("cevapC");

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
}
