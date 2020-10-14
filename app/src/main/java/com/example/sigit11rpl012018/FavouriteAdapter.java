package com.example.sigit11rpl012018;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.MyViewHolder> {
    private List<ModelMovieRealm> movieModel;
    Context context;

    public FavouriteAdapter(Context context, List<ModelMovieRealm> movieModel){
        this.context = context;
        this.movieModel = movieModel;
    }

    @NonNull
    @Override
    public FavouriteAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapterrv, parent, false);
        return new FavouriteAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteAdapter.MyViewHolder holder, int position) {
        holder.txtNama.setText(movieModel.get(position).getJudul());
        holder.txtDate.setText(movieModel.get(position).getReleaseDate());
        holder.txtNpm.setText(movieModel.get(position).getDesc());
        Log.d("makananku", "onBindViewHolder: "+movieModel.get(position).getPath());
        Glide.with(holder.itemView)
                .load(movieModel.get(position).getPath())
                .override(Target.SIZE_ORIGINAL)
//                .apply(new RequestOptions().override(600, 300))
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ivprofile);
    }

    @Override
    public int getItemCount() {
        return movieModel.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNama, txtNpm, txtDate;
        CardView card;
        ImageView ivprofile;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            card = (CardView) itemView.findViewById(R.id.cardku);
            ivprofile = (ImageView) itemView.findViewById(R.id.ivprofile);
            txtNama = (TextView) itemView.findViewById(R.id.tvname);
            txtNpm = (TextView) itemView.findViewById(R.id.tvdesc);
            txtDate = (TextView)itemView.findViewById(R.id.tvdate);
        }
    }
}
