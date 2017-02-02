package com.example.android.tlkntbrapp;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

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
        public CircleImageView mImageButton;
        public TextView mTextView;
        public CardView mCardView;

        public ViewHolder(View view) {
            super(view);
            mImageButton = (CircleImageView) view.findViewById(R.id.contact_icon);
            mTextView = (TextView) view.findViewById(R.id.contact_name);
//            mCardView = (CardView) view.findViewById(R.id.cardview);

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

        int leftMargin = 0;
        int rightMargin = 0;
        int topMargin = 0;
        int bottomMargin = 0;
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) holder.mImageButton.getLayoutParams();
        if (((position + 1) % 4) == 1) {
            leftMargin = 24;
            topMargin = 8;
            rightMargin = 24;
            bottomMargin = 16;
        } else if (((position + 1) % 4) == 2) {
            leftMargin = 32;
            topMargin = 32;
            rightMargin = 16;
            bottomMargin = 8;
        } else if (((position + 1) % 4) == 3) {
            leftMargin = 32;
            topMargin = 8;
            rightMargin = 16;
            bottomMargin = 16;
        } else if (((position + 1) % 4) == 0) {
            leftMargin = 24;
            topMargin = 32;
            rightMargin = 24;
            bottomMargin = 8;
        }
        params.setMargins(convertdptopx(leftMargin), convertdptopx(topMargin), convertdptopx(rightMargin), convertdptopx(bottomMargin));
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
        holder.mImageButton.setContentDescription(holder.mTextView.getText());

    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public int convertdptopx(int dp) {
        Resources resources = mContext.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                resources.getDisplayMetrics()
        );
    }
}
