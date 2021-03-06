package kr.co.tjeit.servertest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import kr.co.tjeit.servertest.R;
import kr.co.tjeit.servertest.data.Absent;

/**
 * Created by user on 2017-11-01.
 */

public class AbsentAdapter extends ArrayAdapter<Absent> {

    Context mContext;
    List<Absent> mList;
    LayoutInflater inf;

    public AbsentAdapter(Context context, List<Absent> list) {
        super(context, R.layout.post_list_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            row = inf.inflate(R.layout.post_list_item, null);
        }

        Absent data = mList.get(position);

        TextView writerNameTxt = row.findViewById(R.id.writerNameTxt);
        TextView contentTxt = row.findViewById(R.id.contentTxt);

        writerNameTxt.setText(data.getStudent().getName());

        contentTxt.setText(data.getReason());



        return row;
    }
}
