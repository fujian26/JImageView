package com.jacob.imageview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mLv;
    private ArrayAdapter<String> mAdapter;
    private List<String> mList;
    private String mPath;

    public static final String PARAM_PATH = "path";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPath = getIntent().getStringExtra(PARAM_PATH);

        mLv = (ListView) findViewById(R.id.lv);
        mList = new ArrayList<>();
        mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mList);
        mLv.setAdapter(mAdapter);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MListActivity.class);
                intent.putExtra(MListActivity.PARAM_PATH, mList.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateList();
    }

    private void updateList() {
        mList.clear();
        File root = Environment.getExternalStorageDirectory();
        if (!TextUtils.isEmpty(mPath)) {
            root = new File(root.getAbsolutePath() + "/" + mPath);
            Intent intent = new Intent(this, MListActivity.class);
            intent.putExtra(MListActivity.PARAM_PATH, root.getAbsolutePath());
            startActivity(intent);
            finish();
        } else {
            for (File file : root.listFiles()) {
                mList.add(file.getAbsolutePath());
            }
            mAdapter.notifyDataSetChanged();
        }
    }
}
