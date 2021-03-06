package kr.co.tjeit.servertest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import kr.co.tjeit.servertest.utils.ServerUtil;

public class MakePostActivity extends BaseActivity {

    private android.widget.EditText contentEdt;
    private android.widget.Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_post);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ServerUtil.register_absent(mContext,
                        contentEdt.getText().toString(),
                        new ServerUtil.JsonResponseHandler() {
                            @Override
                            public void onResponse(JSONObject json) {

                            }
                        });

//                ServerUtil.register_post(mContext,
//                        1,
//                        contentEdt.getText().toString(),
//                        new ServerUtil.JsonResponseHandler() {
//                            @Override
//                            public void onResponse(JSONObject json) {
//                                Toast.makeText(mContext, "게시글 등록됨.", Toast.LENGTH_SHORT).show();
//
//                                finish();
//                            }
//                        });


            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        this.okBtn = (Button) findViewById(R.id.okBtn);
        this.contentEdt = (EditText) findViewById(R.id.contentEdt);
    }
}
