package nyc.c4q.yojana.dietapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.is_on_diet);
        String currentVal = "Are you dieting: " + isOnDiet();
        textView.setText(currentVal);
        button = (Button) findViewById(R.id.button_text_view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (isOnDiet()) {
//                    setIsUserDieting(false);
//                } else {
//                    setIsUserDieting(true);
//                }
//                String newVal = "Are you dieting: " + isOnDiet();
//                textView.setText(newVal);

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout,new MyFragment()).commit();
            }
        });

    }

    void setIsUserDieting(boolean isUserDieting) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(getString(R.string.is_user_dieting), isUserDieting).apply();
    }

    public boolean isOnDiet() {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getBoolean(getString(R.string.is_user_dieting), false);
    }

}
