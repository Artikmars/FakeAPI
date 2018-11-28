package com.artamonov.fakeapi.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.artamonov.fakeapi.R;
import com.artamonov.fakeapi.adapters.PostsAdapter;
import com.artamonov.fakeapi.contract.MainContract;
import com.artamonov.fakeapi.model.main.Post;
import com.artamonov.fakeapi.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private RecyclerView rvPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainPresenter mainPresenter = new MainPresenter(this);
        rvPosts = findViewById(R.id.rv_posts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvPosts.setLayoutManager(layoutManager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvPosts.addItemDecoration(itemDecoration);
        mainPresenter.getPosts();
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }

    @Override
    public void setPostsAdapter(List<Post> response) {
        List<Post> postList = response;
        PostsAdapter postsAdapter = new PostsAdapter(postList, MainActivity.this);
        rvPosts.setAdapter(postsAdapter);
        rvPosts.setHasFixedSize(true);
    }

    @Override
    public void showFailureMessage(Throwable t) {

    }
}
