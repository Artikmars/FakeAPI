package com.artamonov.fakeapi.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.artamonov.fakeapi.R;
import com.artamonov.fakeapi.model.main.Post;
import com.artamonov.fakeapi.ui.DetailActivity;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private final List<Post> postList;
    private final Context context;

    public PostsAdapter(List<Post> artistsList, Context context) {
        this.postList = artistsList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {

        viewHolder.postTitle.setText(postList.get(position).getTitle());
        viewHolder.postBody.setText(postList.get(position).getBody());

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer postId = postList.get(position).getId();
                Integer userId = postList.get(position).getUserId();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("postId", postId);
                intent.putExtra("userId", userId);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return postList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView postTitle;
        private final TextView postBody;
        private final LinearLayout linearLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            postTitle = itemView.findViewById(R.id.post_title);
            postBody = itemView.findViewById(R.id.post_body);
            linearLayout = itemView.findViewById(R.id.linear_layout_artist);
        }
    }
}
