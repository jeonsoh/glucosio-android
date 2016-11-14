package org.glucosio.android.presenter;

import org.glucosio.android.tools.SplitDateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


@RunWith(MockitoJUnitRunner.class)
public class AddReadingPresenterTest {
    private static final String TEST_DATE_VALUE = "2016/11/08";
    private static final String TEST_TIME_VALUE = "10:01 PM";
    private static final String TEST_TEXT_VALUE = "test";

    @InjectMocks
    private AddReadingPresenter presenter;

    @Mock
    private SplitDateTime splitDateTime;

    @Mock Calendar cal;
    @Mock Date date;

    @Before
    public void setUp() {
        initMocks(this);
    }


    @Test
    public void SouldReturnFalseFromReading_WhenCorrectDateInput() throws Exception{
        assertTrue(presenter.validateDate(TEST_DATE_VALUE));
    }
    @Test
    public void SouldReturnFalseFromReading_WhenCorrectTimeInput() throws Exception{
        assertTrue(presenter.validateTime(TEST_TIME_VALUE));
    }
    @Test
    public void SouldReturnFalseFromReading_WhenCorrectTextInput() throws Exception{
        assertTrue(presenter.validateText(TEST_TEXT_VALUE));
    }



}
