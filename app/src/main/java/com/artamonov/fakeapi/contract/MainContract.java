package com.artamonov.fakeapi.contract;

import com.artamonov.fakeapi.model.main.Post;

import java.util.List;

public interface MainContract {
    interface MainPresenter {

        void getPosts();

        void setPostsList(List<Post> postsList);

        void setErrorType(Throwable t);

    }

    interface MainView {

        void showProgressDialog();

        void dismissProgressDialog();

        void setPostsAdapter(List<Post> response);

        void showFailureMessage(Throwable t);
    }


}
