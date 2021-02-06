package omar.az.catbasictask2;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText numberET;
    private TextView displayTestTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        // initializing the required views
        numberET = findViewById(R.id.numberET);
        displayTestTV = findViewById(R.id.displayTV);
    }

    private boolean isNumber(String number) {
        // check if the string is number
        try {
            double castedNumber = Double.parseDouble(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void showTheText(View view) {
        // show the text if not empty or show an error
        String text = numberET.getText().toString();
        if (!text.isEmpty()) displayTestTV.setText(text);
        else numberET.setError("Please write a number");
    }

    // this  method is for searching google
    public void searchTheWeb(View view) {
        String text = numberET.getText().toString();
        if (isNumber(text)) {
            // search the web
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, text);
            startActivity(intent);
        } else {
            numberET.setError("Please enter a valid number");
        }
    }
}