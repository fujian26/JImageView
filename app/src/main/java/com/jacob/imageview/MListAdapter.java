package com.jacob.imageview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hujian on 2017/4/16.
 */

public class MListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> mList;
    private Context mContext;

    public MListAdapter(List<String> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                parent.getContext().getResources().getDimensionPixelSize(R.dimen.image_height));
        layoutParams.leftMargin = parent.getContext().getResources().getDimensionPixelSize(R.dimen.margin_8);
        layoutParams.topMargin = parent.getContext().getResources().getDimensionPixelSize(R.dimen.margin_8);
        parent.addView(imageView, layoutParams);
        return new ViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(mContext)
                .load("file://" + mList.get(position))
                .centerCrop()
                .thumbnail(0.1f)
                .into((ImageView) viewHolder.itemView);
        final int finalPos = position;
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ImgDetailActivity.class);
                intent.putStringArrayListExtra(ImgDetailActivity.PARAM_LIST, (ArrayList<String>) mList);
                intent.putExtra(ImgDetailActivity.PARAM_POS, finalPos);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
