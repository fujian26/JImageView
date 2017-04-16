package com.jacob.imageview;

import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by hujian on 2017/4/16.
 */

public class MPagerAdapter extends PagerAdapter {

    private List<String> mList;
    private SparseArray<ImageView> mViews;

    public MPagerAdapter(List<String> list) {
        mList = list;
        mViews = new SparseArray<>();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = mViews.get(position);
        if (imageView == null) {
            imageView = new ImageView(container.getContext());
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            container.addView(imageView, layoutParams);
        }
        Glide.with(container.getContext())
                .load("file://" + mList.get(position))
                .centerCrop()
                .into(imageView);
        return imageView;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViews.get(position));
        mViews.delete(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
