package id.hanifah.tugaspraktikum2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etKomentar;
    private TextView tvHitungKarakter;

    private static final int MAKS_KARAKTER = 100;
    private static final String KEY_KOMENTAR = "komentar";
    private static final String KEY_HITUNGAN = "hitungan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etKomentar = findViewById(R.id.etKomentar);
        tvHitungKarakter = findViewById(R.id.tvHitungKarakter);

        if (savedInstanceState != null) {
            String komentar = savedInstanceState.getString(KEY_KOMENTAR, "");
            etKomentar.setText(komentar);

            String hitungan = savedInstanceState.getString(
                    KEY_HITUNGAN,
                    komentar.length() + "/" + MAKS_KARAKTER + " karakter"
            );
            tvHitungKarakter.setText(hitungan);
        } else {
            tvHitungKarakter.setText("0/" + MAKS_KARAKTER + " karakter");
        }

        etKomentar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                tvHitungKarakter.setText(
                        s.length() + "/" + MAKS_KARAKTER + " karakter"
                );
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_KOMENTAR, etKomentar.getText().toString());
        outState.putString(
                KEY_HITUNGAN,
                tvHitungKarakter.getText().toString()
        );

        super.onSaveInstanceState(outState);
    }
}