package jp.suntech.s22005.bmicalculators005;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btcalculation = findViewById(R.id.btCalculation);
        btcalculation.setOnClickListener(new ButtonClickListener());
        Button btclear = findViewById(R.id.btClear);
        btclear.setOnClickListener(new ButtonClickListener());

    }

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            EditText age = findViewById(R.id.etAge);
            EditText height = findViewById(R.id.etHeight);
            EditText weight = findViewById(R.id.etWeight);
            TextView output = findViewById(R.id.tvOutput);
            TextView output1 = findViewById(R.id.tvOutput1);
            TextView output2 = findViewById(R.id.tvOutput2);
            TextView output3 = findViewById(R.id.tvOutput3);
            TextView output4 = findViewById(R.id.tvOutput4);
            int id = v.getId();
            if (id == R.id.btCalculation) {
                double heightStr = Double.parseDouble((height.getText().toString()));
                double weightStr = Double.parseDouble((weight.getText().toString()));
                double ageStr = Double.parseDouble(String.valueOf((age.getText())));
                double BMI = weightStr / (heightStr / 100.0 * heightStr / 100.0);
                double appropriate = (heightStr / 100.0 * heightStr / 100.0) * 22;
                double result = Double.parseDouble((String.format("%.2f", BMI)));
                if (result < 18.5) {
                    output.setText("あなたの肥満度は");
                    output1.setText("低体重");
                    output2.setText("あなたの適正体重は");
                    output3.setText((String.format("%.1f",appropriate)));
                    output4.setText("kg");
                } else if (result < 25) {
                    output.setText("あなたの肥満度は");
                    output1.setText("普通体重");
                    output2.setText("あなたの適正体重は");
                    output3.setText((String.format("%.1f",appropriate) ));
                    output4.setText("kg");
                } else if (result < 30) {
                    output.setText("あなたの肥満度は");
                    output1.setText("肥満(1度)");
                    output2.setText("あなたの適正体重は");
                    output3.setText((String.format("%.1f",appropriate)));
                    output4.setText("kg");
                } else if (result < 35) {
                    output.setText("あなたの肥満度は");
                    output1.setText("肥満(2度)");
                    output2.setText("あなたの適正体重は");
                    output3.setText((String.format("%.1f",appropriate)));
                    output4.setText("kg");
                } else if (result < 40) {
                    output.setText("あなたの肥満度は");
                    output1.setText("肥満(3度)");
                    output2.setText("あなたの適正体重は");
                    output3.setText((String.format("%.1f",appropriate)));
                    output4.setText("kg");
                } else if (result >= 40) {
                    output.setText("あなたの肥満度は");
                    output1.setText("肥満(4度)");
                    output2.setText("あなたの適正体重は");
                    output3.setText((String.format("%.1f",appropriate)));
                    output4.setText("kg");
                }
                if (ageStr < 16){
                   showAgeDailog();
                }
            } else if (id == R.id.btClear) {
                age.setText("");
                height.setText("");
                weight.setText("");
                output.setText("");
                output1.setText("");
                output2.setText("");
                output3.setText("");
                output4.setText("");
            }
        }
        private void showAgeDailog(){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("年齢が16歳未満のため、適切な肥満度を求めることができませんでした。")
                    .setTitle("警告")
                    .setPositiveButton("確認",null);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}