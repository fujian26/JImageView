package com.jacob.imageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MListActivity extends AppCompatActivity {

    private List<String> mPaths = new ArrayList<>();
    public static final String PARAM_PATH = "path";
    private RecyclerView mRv;
    private MListAdapter mAdapter;
    private String mPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mlist);

        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new MListAdapter(mPaths, this);
        mRv.setAdapter(mAdapter);

        mPath = getIntent().getStringExtra(PARAM_PATH);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPaths.clear();
        findBitmap(new File(mPath));
        mAdapter.notifyDataSetChanged();
    }

    private void findBitmap(File file) {
        if (file.isDirectory()) {
            for (File file1 : file.listFiles()) {
                findBitmap(file1);
            }
        } else {
            if (file.getAbsolutePath().contains(".jpg")
                    || file.getAbsolutePath().contains(".jpeg")
                    || file.getAbsolutePath().contains(".png")) {
                mPaths.add(file.getAbsolutePath());
            }
        }
    }
}
