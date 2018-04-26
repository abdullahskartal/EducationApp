package mobileprogramming.egitim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class CsharpKonular extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csharp_konular);

        final Button btnDersiAdiKonu=(Button)findViewById(R.id.btnDersAdiKonu);

        final Button btnKonu1=(Button)findViewById(R.id.btnKonu1);
        final Button btnKonu2=(Button)findViewById(R.id.btnKonu2);
        final Button btnKonu3=(Button)findViewById(R.id.btnKonu3);
        final Button btnKonu4=(Button)findViewById(R.id.btnKonu4);
    }
}
