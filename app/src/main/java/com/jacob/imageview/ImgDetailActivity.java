package com.jacob.imageview;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class ImgDetailActivity extends AppCompatActivity {

    private ViewPager mVp;
    private MPagerAdapter mAdapter;
    private List<String> mList;

    public static final String PARAM_LIST = "list";
    public static final String PARAM_POS = "pos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_detail);

        mList = getIntent().getStringArrayListExtra(PARAM_LIST);
        int pos = getIntent().getIntExtra(PARAM_POS, 0);

        mVp = (ViewPager) findViewById(R.id.vp);
        mAdapter = new MPagerAdapter(mList);
        mVp.setAdapter(mAdapter);
        mVp.setCurrentItem(pos);
    }
}
