package com.jti.aplikasihijau;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jti.aplikasihijau.Model.ModelProfile;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {
    Context context;


    private List<ModelProfile> mDataset;
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text;
        public ImageView imageView;


        public ViewHolder(View v) {
            super(v);
            text = (TextView) v.findViewById(R.id.text);
            imageView = (ImageView) v.findViewById(R.id.icon);


        }
    }
    public void add(int position, ModelProfile item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }
    public void remove(ModelProfile item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }
    public myAdapter(List<ModelProfile> myDataset) {
        mDataset = myDataset;
    }
    @Override
    public myAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.text.setText(mDataset.get(position).getFirstName());
        Glide.with(holder.imageView.getContext()).load(mDataset.get(position).getImageProfil()).into(holder.imageView);



    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }



}