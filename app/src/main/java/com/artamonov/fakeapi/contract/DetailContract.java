package com.artamonov.fakeapi.contract;

import com.artamonov.fakeapi.model.detail.Comment;
import com.artamonov.fakeapi.model.detail.Photo;
import com.artamonov.fakeapi.model.detail.User;

import java.util.List;

public interface DetailContract {

    interface DetailPresenter {

        void getComments();

        void getUsers();

        void getPhotos();

        void setErrorType(Throwable t);

        void setCommentsList(List<Comment> commentList);

        void setPhotoList(List<Photo> photoList);

        void setUsersList(List<User> usersList);

    }

    interface DetailView {

        void showProgressDialog();

        void dismissProgressDialog();

        void setCommentsAdapter(List<Comment> response);

        void setPhotoAdapter(List<Photo> response);

        void setUsersData(List<User> response);

        void showFailureMessage(Throwable t);
    }

}

