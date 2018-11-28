package com.artamonov.fakeapi.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.artamonov.fakeapi.R;
import com.artamonov.fakeapi.model.detail.Comment;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    private final List<Comment> commentList;

    public CommentsAdapter(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comment_item, viewGroup, false);
        return new CommentsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CommentsAdapter.ViewHolder viewHolder, final int position) {
        viewHolder.commentEmail.setText(commentList.get(position).getEmail());
        viewHolder.commentBody.setText(commentList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView commentEmail;
        private final TextView commentBody;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            commentEmail = itemView.findViewById(R.id.comment_email);
            commentBody = itemView.findViewById(R.id.comment_body);

        }
    }
}
