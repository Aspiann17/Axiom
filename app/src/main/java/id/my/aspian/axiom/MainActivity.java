package id.my.aspian.axiom;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

//        findViewById(R.id.about).setOnClickListener(v -> {});
    }

    @SuppressLint("DefaultLocale")
    public void calculate(View v) {
        float result = 0;
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

        Button button = findViewById(R.id.button);
        button.setText(String.format("%.2f", result / 6));
    }
}