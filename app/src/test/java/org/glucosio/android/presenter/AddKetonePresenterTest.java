package org.glucosio.android.presenter;

import org.glucosio.android.activity.AddKetoneActivity;
import org.glucosio.android.db.DatabaseHandler;
import org.glucosio.android.db.User;
import org.glucosio.android.fragment.AssistantFragment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class AddKetonePresenterTest {

    @Mock
    private DatabaseHandler dbHandlerMock;

    @InjectMocks
    private AddKetonePresenter presenter;

    @Mock
    private AddKetoneActivity addKetoneActivityMock;

    @Mock
    private AddReadingPresenter addReadingPresenterMock;//부모

    @Mock
    private User userMock;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        when(presenter.getUnitMeasuerement()).thenReturn("mmol/L");


    }


}
