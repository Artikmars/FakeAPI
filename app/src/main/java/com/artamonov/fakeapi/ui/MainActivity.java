package com.artamonov.fakeapi.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.artamonov.fakeapi.R;
import com.artamonov.fakeapi.adapters.PostsAdapter;
import com.artamonov.fakeapi.contract.MainContract;
import com.artamonov.fakeapi.model.main.Post;
import com.artamonov.fakeapi.presenter.MainPresenter;
import com.artamonov.fakeapi.utils.NetworkUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private RecyclerView rvPosts;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainPresenter mainPresenter = new MainPresenter(this);
        progressDialog = new ProgressDialog(this);
        rvPosts = findViewById(R.id.rv_posts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvPosts.setLayoutManager(layoutManager);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvPosts.addItemDecoration(itemDecoration);

        /*
        If the Internet connection is missed the corresponding message pops up.
         */
        if (NetworkUtils.isNetworkAvailable(getApplicationContext())) {
            mainPresenter.getPosts();
        } else {
            Snackbar.make(getWindow().getDecorView().getRootView(), "Check your Internet connection or try later", Snackbar.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void showProgressDialog() {
        progressDialog.setMessage("Loading...");
        progressDialog.setMax(100);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void setPostsAdapter(List<Post> response) {
        PostsAdapter postsAdapter = new PostsAdapter(response, MainActivity.this);
        rvPosts.setAdapter(postsAdapter);
        rvPosts.setHasFixedSize(true);

    }

    @Override
    public void showFailureMessage(Throwable t) {

    }
}
