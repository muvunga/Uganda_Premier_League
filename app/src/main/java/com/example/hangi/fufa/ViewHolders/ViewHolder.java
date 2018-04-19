package com.example.hangi.fufa.ViewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hangi.fufa.R;
import com.squareup.picasso.Picasso;

import static com.example.hangi.fufa.R.id.TeamA;
import static com.example.hangi.fufa.R.id.TeamB;

/**
 * Created by hangi on 4/1/18.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    public View view;

    public ViewHolder(View itemView) {
        super(itemView);
        view = itemView;
    }



    public void setNewstitle(String newstitle) {
        TextView mtitle = itemView.findViewById(R.id.newsTitle);
        mtitle.setText(newstitle);
    }


    public void setNewscontent(String newscontent) {
        TextView mcontent = itemView.findViewById(R.id.contentnews);
        mcontent.setText(newscontent);    }


    public void setImg(Context context, String img) {
        ImageView mimg = itemView.findViewById(R.id.img_news);
        Picasso.with(context).load(img).into(mimg);
    }


}
