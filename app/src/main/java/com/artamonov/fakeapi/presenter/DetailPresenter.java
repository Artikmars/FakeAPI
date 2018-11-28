package com.artamonov.fakeapi.presenter;

import android.app.Activity;

import com.artamonov.fakeapi.contract.DetailContract;
import com.artamonov.fakeapi.model.detail.Comment;
import com.artamonov.fakeapi.model.detail.Photo;
import com.artamonov.fakeapi.model.detail.User;
import com.artamonov.fakeapi.network.RetrofitRunner;

import java.util.List;

public class DetailPresenter implements DetailContract.DetailPresenter {

    private final DetailContract.DetailView view;

    public DetailPresenter(DetailContract.DetailView view) {

        this.view = view;
    }


    @Override
    public void hideKeyboard(Activity activity) {

    }

    @Override
    public void getComments() {
        // view.showProgressDialog();
        RetrofitRunner.getComments(this);
    }

    @Override
    public void getUsers() {
        // view.showProgressDialog();
        RetrofitRunner.getUsers(this);
    }

    @Override
    public void getPhotos() {
        // view.showProgressDialog();
        RetrofitRunner.getPhotos(this);
    }

    @Override
    public void setErrorType(Throwable t) {
        view.showFailureMessage(t);
        view.dismissProgressDialog();

    }

    @Override

    public void setCommentsList(List<Comment> commentList) {
        // view.dismissProgressDialog();
        view.setCommentsAdapter(commentList);

    }

    @Override
    public void setPhotoList(List<Photo> photoList) {
        // view.dismissProgressDialog();
        view.setPhotoAdapter(photoList);

    }

    @Override
    public void setUsersList(List<User> usersList) {
        // view.dismissProgressDialog();
        view.setUsersData(usersList);

    }

}
