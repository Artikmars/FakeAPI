package com.artamonov.fakeapi.network;

import android.support.annotation.NonNull;

import com.artamonov.fakeapi.model.detail.Comment;
import com.artamonov.fakeapi.model.detail.Photo;
import com.artamonov.fakeapi.model.detail.User;
import com.artamonov.fakeapi.model.main.Post;
import com.artamonov.fakeapi.presenter.DetailPresenter;
import com.artamonov.fakeapi.presenter.MainPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitRunner {

    public static void getPosts(final MainPresenter mainPresenter) {

        Retrofit retrofit = RetrofitInstance.getRetrofitInstance();
        FakeApiInterface service = retrofit.create(FakeApiInterface.class);
        service.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                List<Post> postsList = response.body();
                mainPresenter.setPostsList(postsList);
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                mainPresenter.setErrorType(t);
            }
        });

    }

    public static void getUsers(final DetailPresenter detailPresenter) {

        Retrofit retrofit = RetrofitInstance.getRetrofitInstance();
        FakeApiInterface service = retrofit.create(FakeApiInterface.class);
        service.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(@NonNull Call<List<User>> call, @NonNull Response<List<User>> response) {
                List<User> usersList = response.body();
                detailPresenter.setUsersList(usersList);
            }

            @Override
            public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable t) {
                detailPresenter.setErrorType(t);

            }
        });
    }

    public static void getComments(final DetailPresenter detailPresenter) {

        Retrofit retrofit = RetrofitInstance.getRetrofitInstance();
        FakeApiInterface service = retrofit.create(FakeApiInterface.class);
        service.getComments().enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(@NonNull Call<List<Comment>> call, @NonNull Response<List<Comment>> response) {
                List<Comment> commentList = response.body();
                detailPresenter.setCommentsList(commentList);
            }

            @Override
            public void onFailure(@NonNull Call<List<Comment>> call, @NonNull Throwable t) {
                detailPresenter.setErrorType(t);
            }

        });
    }

    public static void getPhotos(final DetailPresenter detailPresenter) {

        Retrofit retrofit = RetrofitInstance.getRetrofitInstance();
        FakeApiInterface service = retrofit.create(FakeApiInterface.class);
        service.getPhotos().enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(@NonNull Call<List<Photo>> call, @NonNull Response<List<Photo>> response) {
                List<Photo> photoList = response.body();
                detailPresenter.setPhotoList(photoList);
            }

            @Override
            public void onFailure(@NonNull Call<List<Photo>> call, @NonNull Throwable t) {
                detailPresenter.setErrorType(t);
            }

        });
    }

}
