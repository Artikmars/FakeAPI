package com.artamonov.fakeapi.network;

import com.artamonov.fakeapi.model.detail.Comment;
import com.artamonov.fakeapi.model.detail.Photo;
import com.artamonov.fakeapi.model.detail.User;
import com.artamonov.fakeapi.model.main.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface FakeApiInterface {

    @GET("/posts")
    Call<List<Post>> getPosts();

    @GET("/users")
    Call<List<User>> getUsers();

    @GET("/comments")
    Call<List<Comment>> getComments();

    @GET("/photos")
    Call<List<Photo>> getPhotos();
}
