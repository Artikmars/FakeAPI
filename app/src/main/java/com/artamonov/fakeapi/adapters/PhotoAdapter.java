package com.artamonov.fakeapi.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.artamonov.fakeapi.R;
import com.artamonov.fakeapi.model.detail.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private final List<Photo> photoList;


    public PhotoAdapter(List<Photo> photoList) {
        this.photoList = photoList;
    }

    @NonNull
    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_photos_items, viewGroup, false);
        return new PhotoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PhotoAdapter.ViewHolder viewHolder, final int position) {

        /*
        Obtains Picasso instance to make a request, gets the image and populates the corresponding
        view by that image.
         */

        Picasso.get()
                .load(photoList.get(position).getThumbnailUrl())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder_error)
                .into(viewHolder.imageView);
    }


    /**
     * The method returns the fixed amount of photos due to the great amount of the photos
     * in the list.
     *
     * @return 10 as the fixed amount of photos
     */
    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_photo);
        }
    }
}


