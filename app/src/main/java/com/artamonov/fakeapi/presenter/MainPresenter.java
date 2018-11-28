package com.artamonov.fakeapi.presenter;

import android.app.Activity;

import com.artamonov.fakeapi.contract.MainContract;
import com.artamonov.fakeapi.model.main.Post;
import com.artamonov.fakeapi.network.RetrofitRunner;

import java.util.List;

public class MainPresenter implements MainContract.MainPresenter {

    private final MainContract.MainView view;

    public MainPresenter(MainContract.MainView view) {

        this.view = view;
    }

    @Override
    public void getPosts() {
        // view.showProgressDialog();
        RetrofitRunner.getPosts(this);
    }

    @Override
    public void setPostsList(List<Post> postsList) {
        // view.dismissProgressDialog();
        view.setPostsAdapter(postsList);

    }

    @Override
    public void setErrorType(Throwable t) {
        view.showFailureMessage(t);
        view.dismissProgressDialog();

    }

    @Override
    public void hideKeyboard(Activity activity) {

    }

   /* public void hideKeyboard(Activity activity) {
        KeyboardUtils.hideKeyboard(activity);
    }*/
}

