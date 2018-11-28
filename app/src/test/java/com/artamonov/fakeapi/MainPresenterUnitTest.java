package com.artamonov.fakeapi;

import com.artamonov.fakeapi.contract.MainContract;
import com.artamonov.fakeapi.presenter.MainPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Unit Test which tests Main Presenter to check whether the list which is passed to adapter
 * is not null.
 */

public class MainPresenterUnitTest {

    private MainContract.MainPresenter mainPresenter;

    @Mock
    private MainContract.MainView mainView;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mainPresenter = new MainPresenter(mainView);
    }

    @Test
    public void getPosts() {
        mainPresenter.getPosts();
        verify(mainView, never()).setPostsAdapter(null);
    }


}