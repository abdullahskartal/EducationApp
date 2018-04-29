package mobileprogramming.egitim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Profil extends AppCompatActivity {
    public   TextView txtHakkinda;
    public TextView txtiletisim;
    public TextView txtUsername;

    private FirebaseAuth auth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        txtHakkinda=(TextView)findViewById(R.id.txtHakkinda);
        txtiletisim=(TextView)findViewById(R.id.txtiletisim);
        txtUsername=(TextView)findViewById(R.id.txtUsername);


        auth=FirebaseAuth.getInstance();

        DatabaseReference ref= FirebaseDatabase.getInstance().getReference();
        String ida=auth.getCurrentUser().getUid().toString();
        DatabaseReference refusername=ref.child("Kullanici").child(ida).child("username");
        DatabaseReference refHakkinda=ref.child("Kullanici").child(ida).child("userhakkinda");
        DatabaseReference refiletisim=ref.child("Kullanici").child(ida).child("userIletisim");

        refusername.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

               txtUsername.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        refHakkinda.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

              txtHakkinda.setText(dataSnapshot.getValue(String.class));
               }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        refiletisim.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                txtiletisim.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
