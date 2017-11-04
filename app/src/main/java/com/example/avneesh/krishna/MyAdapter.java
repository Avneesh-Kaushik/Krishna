package com.example.avneesh.krishna;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Avneesh on 15-Aug-17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<ListItem> mylist;
    Context context;
    static int[] sid;

    public MyAdapter(Context context, List<ListItem> list, int sid[]) {
        this.context = context;
        this.mylist = list;
        this.sid = sid;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListItem list = mylist.get(position);
        holder.tv1.setText(list.getString());
        holder.imgbtn.setImageResource(list.getId());
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                            }
        });
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public LinearLayout linear;
        public TextView tv1;
        public ImageView imgbtn;
        MediaPlayer mp = null;

        public ViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            imgbtn = (ImageView) itemView.findViewById(R.id.imgbtn);
            linear = (LinearLayout) itemView.findViewById(R.id.list_item);
            imgbtn.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgbtn.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("myOnclick", "In onclick");
            try{
                if(mp!=null) {
                    if(mp.isPlaying()) {
                        mp.stop();
                        Toast.makeText(context,"stopped",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                mp = mp.create(context, sid[getAdapterPosition()]);
                mp.start();
                Toast.makeText(context,"Playing",Toast.LENGTH_SHORT).show();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
