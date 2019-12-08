package io.github.xkerman.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebRequest request = new WebRequest(new WebRequest.Listener() {
                    @Override
                    public void onSuccess(String title) {
                        Toast toast = Toast.makeText(MainActivity.this, title, Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
                String url = editText.getText().toString();
                request.execute(url);
            }
        });
    }
}
