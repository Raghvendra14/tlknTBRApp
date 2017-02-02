package com.example.android.tlkntbrapp;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.HashMap;

/**
 * Created by Raghvendra on 02-02-2017.
 */
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private HashMap<Integer, String> nameList;
    private HashMap<Integer, String> picUrlList;

    public CustomRecyclerViewAdapter(Context context, HashMap<Integer, String> contactNameList, HashMap<Integer, String> contactPicUrlList) {
        mContext = context;
        nameList = contactNameList;
        picUrlList = contactPicUrlList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageButton mImageButton;
        public TextView mTextView;

        public ViewHolder(View view) {
            super(view);
            mImageButton = (ImageButton) view.findViewById(R.id.contact_icon);
            mTextView = (TextView) view.findViewById(R.id.contact_name);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.contact_list, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

//        Log.d("Hello", "message is " + picUrlList.get(position));
        Uri thumbnailUri = null;
        try {
            thumbnailUri = Uri.parse(picUrlList.get(position));
//            Log.d("Hello Thumbnail", thumbnailUri.toString());
        } catch (Exception e) {
            e.printStackTrace();
//            Log.e(CustomRecyclerViewAdapter.class.getSimpleName(), "Cannot able to parse" + picUrlList.get(position) + " " + position);
        }
        Glide.with(mContext)
                .load(thumbnailUri)
                .error(R.drawable.contact_icon)
                .crossFade()
                .into(holder.mImageButton);

        holder.mTextView.setText(nameList.get(position));
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }
}
