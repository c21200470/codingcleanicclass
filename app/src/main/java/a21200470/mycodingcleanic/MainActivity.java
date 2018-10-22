package a21200470.mycodingcleanic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    Button bt;
    public static final String EXTRA_MESSAGE = "This is it.";
    Button SecondAvtiviyButton;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.txt);
        bt = findViewById(R.id.button);
        SecondAvtiviyButton = findViewById(R.id.secondactivitybutton);
        bt.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {

            tv.setText("Bye World!");
        }
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}

