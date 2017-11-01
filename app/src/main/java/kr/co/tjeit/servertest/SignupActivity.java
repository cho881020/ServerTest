package kr.co.tjeit.servertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.json.JSONObject;

import kr.co.tjeit.servertest.utils.ServerUtil;

public class SignupActivity extends BaseActivity {

    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.RadioButton man;
    private android.widget.RadioButton woman;
    private android.widget.Button signupBtn;
    private EditText nameEdt;
    private EditText phoneEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.phoneEdt = (EditText) findViewById(R.id.phoneEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.signupBtn = (Button) findViewById(R.id.signupBtn);
        this.woman = (RadioButton) findViewById(R.id.woman);
        this.man = (RadioButton) findViewById(R.id.man);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);

        final int genderValue = man.isChecked() ? 0 : 1;

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ServerUtil.register_user(mContext,
                    idEdt.getText().toString(),
                    pwEdt.getText().toString(),
                    nameEdt.getText().toString(),
                    phoneEdt.getText().toString(),
                    new ServerUtil.JsonResponseHandler() {
                @Override
                public void onResponse(JSONObject json) {

                    Toast.makeText(mContext, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
            }
        });
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

    }
}
