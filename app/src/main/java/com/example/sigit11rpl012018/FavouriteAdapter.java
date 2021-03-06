package com.example.sigit11rpl012018;

import android.content.Context;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.MyViewHolder> {
    private List<ModelMovieRealm> modelMovie;
    private Callback callback;
    View viewku;
    int posku;

    interface Callback {
        void onClick(int position);
        void test();
    }


    public FavouriteAdapter(List<ModelMovieRealm> dataList, Callback callback) {
        this.callback = callback;
        this.modelMovie = dataList;
        Log.d("makanan", "MahasiswaAdapter: "+dataList.size()+"");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapterrv, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.txtNama.setText(modelMovie.get(position).getJudul());
        holder.txtNpm.setText(modelMovie.get(position).getReleaseDate());
        Log.d("makananku", "onBindViewHolder: "+modelMovie.get(position).getPath());
        //pakai glide karena untuk nampilkan data gambar dari URL / permission / graddle
        Glide.with(holder.itemView)
                .load(modelMovie.get(position).getPath())
                .override(Target.SIZE_ORIGINAL)
//                .apply(new RequestOptions().override(600, 200))
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ivprofile);

    }

    @Override
    public int getItemCount() {
        return (modelMovie != null) ? modelMovie.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        private TextView txtNama, txtNpm;
        CardView card;
        ImageView ivprofile;

        public MyViewHolder(View itemView) {
            super(itemView);
            viewku=itemView;
            card = (CardView) itemView.findViewById(R.id.cardku);
            ivprofile = (ImageView) itemView.findViewById(R.id.ivprofile);
            txtNama = (TextView) itemView.findViewById(R.id.tvname);
            txtNpm = (TextView) itemView.findViewById(R.id.tvdesc);
            itemView.setOnCreateContextMenuListener(this);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onClick(getAdapterPosition());
                }
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Edit = menu.add(Menu.NONE, 1, 1, "Edit");
            MenuItem Delete = menu.add(Menu.NONE, 2, 2, "Delete");
            posku=getAdapterPosition();
            Edit.setOnMenuItemClickListener(onEditMenu);
            Delete.setOnMenuItemClickListener(onEditMenu);
        }

    }
    private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId()) {
                case 1:
                    //Do stuff
                    Toast.makeText(viewku.getContext(), ""+posku, Toast.LENGTH_SHORT).show();
                    break;

                case 2:
                    //Do stuff

                    break;
            }
            return true;
        }
    };

}

