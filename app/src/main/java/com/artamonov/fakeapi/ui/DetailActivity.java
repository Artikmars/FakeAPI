package com.artamonov.fakeapi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.artamonov.fakeapi.R;
import com.artamonov.fakeapi.adapters.CommentsAdapter;
import com.artamonov.fakeapi.adapters.PhotoAdapter;
import com.artamonov.fakeapi.contract.DetailContract;
import com.artamonov.fakeapi.model.detail.Comment;
import com.artamonov.fakeapi.model.detail.Photo;
import com.artamonov.fakeapi.model.detail.User;
import com.artamonov.fakeapi.presenter.DetailPresenter;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity implements DetailContract.DetailView {

    private Integer userId;
    private Integer postId;
    private RecyclerView rvComments;
    private RecyclerView rvPhotos;
    private TextView tvUserName;
    private TextView tvUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DetailPresenter detailPresenter = new DetailPresenter(this);

        Intent intent = getIntent();
        //check if string
        userId = intent.getIntExtra("userId", 0);
        postId = intent.getIntExtra("postId", 0);

        rvComments = findViewById(R.id.rv_comments);
        rvPhotos = findViewById(R.id.rv_photos);
        tvUserEmail = findViewById(R.id.user_email);
        tvUserName = findViewById(R.id.user_name);


        rvPhotos.setLayoutManager(new GridLayoutManager(this, 3));
        RecyclerView.ItemDecoration itemPhotosDecoration = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        rvPhotos.addItemDecoration(itemPhotosDecoration);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvComments.setLayoutManager(layoutManager);
        RecyclerView.ItemDecoration itemCommentsDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvComments.addItemDecoration(itemCommentsDecoration);

        detailPresenter.getPhotos();
        detailPresenter.getComments();
        detailPresenter.getUsers();


    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }

    @Override
    public void setCommentsAdapter(List<Comment> response) {
        List<Comment> result = new ArrayList<>();
        for (int i = 0; i < response.size(); i++) {

            if (response.get(i).getPostId().equals(postId)) {
                Log.i("myLogs", "postId: " + postId);
                result.add(response.get(i));
            }
        }

        CommentsAdapter commentsAdapter = new CommentsAdapter(result);
        rvComments.setAdapter(commentsAdapter);
        rvComments.setHasFixedSize(true);
    }

    @Override
    public void setPhotoAdapter(List<Photo> photoList) {

        PhotoAdapter photoAdapter = new PhotoAdapter(photoList);
        rvPhotos.setAdapter(photoAdapter);
        rvPhotos.setHasFixedSize(true);
    }

    @Override
    public void setUsersData(List<User> response) {
        tvUserName.setText(response.get(userId).getName());
        tvUserEmail.setText(response.get(userId).getEmail());
    }


    @Override
    public void showFailureMessage(Throwable t) {

    }
}
