package ge.neso.info08.lib.picker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import ge.neso.info08.utils.MyConverter;
import ge.neso.info08.utils.MyDate;

public class MyEditTextDatePicker implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    EditText editText;
    private long timestamp = 0;

    public MyEditTextDatePicker(EditText editText) {
        this.editText = editText;
        this.editText.setOnClickListener(this);
        this.editText.setClickable(true);
        this.editText.setFocusable(false);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, 0, 0);

        timestamp = calendar.getTimeInMillis();

        updateDisplay();
    }

    @Override
    public void onClick(View v) {

        if (timestamp == 0) {
            timestamp = MyDate.getTodayTimestamp();
        }

        Context context = editText.getContext();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);

        DatePickerDialog dialog = new DatePickerDialog(context, this, year, month, day);
        dialog.show();
    }

    /**
     * sets date value
     *
     * @param timestamp
     */
    public void setDate(long timestamp) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);

        calendar.set(year, month, day, 0, 0);

        this.timestamp = calendar.getTimeInMillis();

        updateDisplay();
    }

    /**
     * gets timestamp
     *
     * @return
     */
    public long getDate() {

        return timestamp;
    }

    /**
     * updates display of the field
     */
    public void updateDisplay() {

            StringBuilder sb = new StringBuilder();
            sb.append(MyConverter.timestampToDate(timestamp));
            editText.setText(sb.toString());

    }
}
