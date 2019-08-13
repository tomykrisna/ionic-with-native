package cordova.plugin.greatdayatt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import io.ionic.starter.R;

public class AttActivity extends Activity {
  private Button mButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_att);
    String sessionId = getIntent().getStringExtra("value");
    Log.d("on next activity", sessionId);


    TextView tvName = (TextView) findViewById(R.id.textView);
    tvName.setText(sessionId);


    Intent intent = getIntent();
    String data = intent.getStringExtra("value");
    Log.d("data form intent", data);


    mButton = findViewById(R.id.button);
    mButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        // Do something
        String backData = "i'm Back";
        onClickData(backData);
      }
    });

  }

  public void onClickData(String data) {
    String message = ((EditText)findViewById(R.id.edit_message)).getText().toString();
    Log.d("message input", message);

    Log.d("masuk click button", data);
    Intent returnIntent = new Intent();
    returnIntent.putExtra("result", message);
    setResult(RESULT_OK, returnIntent);
    finish();
  }

}
