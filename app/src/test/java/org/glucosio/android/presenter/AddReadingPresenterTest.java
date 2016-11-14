package org.glucosio.android.presenter;

import org.glucosio.android.tools.SplitDateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class AddReadingPresenterTest {
    private static final String TEST_DATE_VALUE = "2016/11/08";
    private static final String TEST_TIME_VALUE = "10:01 PM";
    private static final String TEST_TEXT_VALUE = "test";

    @InjectMocks
    private AddReadingPresenter presenter;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void SouldReturnTrueFromReading_WhenCorrectDateInput() throws Exception{
        assertTrue(presenter.validateDate(TEST_DATE_VALUE));
    }
    @Test
    public void SouldReturnTrueFromReading_WhenCorrectTimeInput() throws Exception{
        assertTrue(presenter.validateTime(TEST_TIME_VALUE));
    }
    @Test
    public void SouldReturnTrueFromReading_WhenCorrectTextInput() throws Exception{
        assertTrue(presenter.validateText(TEST_TEXT_VALUE));
    }

    @Test
    public void ShouldUpdateAllValues_WhenUpdateDate() throws Exception {
        String mdate = "2016/01/01 01:00:00";
        Date testreadingDate = new Date(mdate);
        presenter.updateReadingSplitDateTime(testreadingDate);

        assertThat(presenter.getReadingYear()).isEqualTo("2016");
        assertThat(presenter.getReadingMonth()).isEqualTo("01");
        assertThat(presenter.getReadingTime()).isAfterOrEqualsTo("2016-01-01T01:00:00");
    }

    @Test
    public void ShouldSetAllValues_WhenSetDate() throws Exception {
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date formatted = Calendar.getInstance().getTime();

        SplitDateTime addSplitDateTime = new SplitDateTime(formatted, inputFormat);
        presenter.setReadingTimeNow();

        assertThat(presenter.getReadingYear()).isEqualTo(addSplitDateTime.getYear());
        assertThat(presenter.getReadingMonth()).isEqualTo(addSplitDateTime.getMonth());
    }

    @Test
    public void ShouldReturnCorrectTime_WhenRungetReadingCal() throws Exception{
        String mdate = "2016/01/01 01:00:00";
        Date testreadingDate = new Date(mdate);
        presenter.updateReadingSplitDateTime(testreadingDate);

        Calendar cal = presenter.getReadingCal();
        assertThat(cal.getTime()).isAfterOrEqualsTo("2016-01-01T01:00:00");
    }
}
