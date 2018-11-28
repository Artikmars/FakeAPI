package com.artamonov.fakeapi;

import com.artamonov.fakeapi.contract.DetailContract;
import com.artamonov.fakeapi.presenter.DetailPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


/**
 * Unit Test which tests Detail Presenter to check whether the list which is passed to adapter
 * is not null.
 */
public class DetailPresenterUnitTest {
    private DetailContract.DetailPresenter detailPresenter;
    @Mock

    private DetailContract.DetailView detailView;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        detailPresenter = new DetailPresenter(detailView);
    }

    @Test
    public void getUsers() {
        detailPresenter.getUsers();
        verify(detailView, never()).setUsersData(null);
    }

    @Test
    public void getPhotos() {
        detailPresenter.getPhotos();
        verify(detailView, never()).setPhotoAdapter(null);
    }

    @Test
    public void getComments() {
        detailPresenter.getComments();
        verify(detailView, never()).setCommentsAdapter(null);
    }


}
