package id.my.aspian.axiom;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @SuppressLint("DefaultLocale")
    public void hitung(View v) {
        float result = 0;
        EditText raw_nama = findViewById(R.id.nama);
        String nama = raw_nama.getText().toString();
        EditText[] mata_pelajaran = {
                findViewById(R.id.bahasa_indonesia),
                findViewById(R.id.bahasa_inggris),
                findViewById(R.id.matematika),
                findViewById(R.id.sejarah),
                findViewById(R.id.ppkn),
                findViewById(R.id.pai)
        };

        for (EditText mapel : mata_pelajaran) {
            String raw = mapel.getText().toString();
            result += (raw.isEmpty()) ? 0 : Float.parseFloat(raw);
        }

        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.layout_output);

        TextView output_nama = dialog.findViewById(R.id.output_nama);
        TextView output_nilai = dialog.findViewById(R.id.output_nilai);

        output_nama.setText(nama);
        output_nilai.setText(String.format("%.2f", result / 6));

        dialog.show();
        dialog.findViewById(R.id.back).setOnClickListener(view -> dialog.dismiss());
    }
}