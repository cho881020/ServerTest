package kr.co.tjeit.servertest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.servertest.adapter.AbsentAdapter;
import kr.co.tjeit.servertest.data.Absent;
import kr.co.tjeit.servertest.utils.ServerUtil;

public class MainActivity extends BaseActivity {

    private android.widget.Button makePostBtn;
    private android.widget.ListView postListView;
    List<Absent> mAbsentList = new ArrayList<>();
    AbsentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ServerUtil.all_absents(mContext, new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                try {
                    if (json.getBoolean("result")) {
                        JSONArray absents = json.getJSONArray("absents");

                        mAbsentList.clear();

                        for (int i=0 ; i < absents.length() ; i++) {
                            Absent abs = Absent.getAbsentFromJson(absents.getJSONObject(i));
                            mAbsentList.add(abs);
                        }

                        mAdapter.notifyDataSetChanged();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public void setupEvents() {
        makePostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MakePostActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setValues() {

        mAdapter = new AbsentAdapter(mContext, mAbsentList);
        postListView.setAdapter(mAdapter);

    }

    @Override
    public void bindViews() {

        this.postListView = (ListView) findViewById(R.id.postListView);
        this.makePostBtn = (Button) findViewById(R.id.makePostBtn);
    }
}
