package com.arlosoft.macrodroid.triggers.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import com.arlosoft.macrodroid.MacroDroidDialogBaseActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.utils.DateTimeUtils;

/* loaded from: classes3.dex */
public class DayOfWeekConfigureActivity extends MacroDroidDialogBaseActivity {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(TimePicker timePicker, Spinner spinner, CheckBox checkBox, View view) {
        int intValue = timePicker.getCurrentHour().intValue();
        int intValue2 = timePicker.getCurrentMinute().intValue();
        Intent intent = new Intent();
        intent.putExtra(Constants.EXTRA_DAY_OF_WEEK, spinner.getSelectedItemPosition());
        intent.putExtra(Constants.EXTRA_HOUR, intValue);
        intent.putExtra(Constants.EXTRA_MINUTE, intValue2);
        intent.putExtra(Constants.EXTRA_USE_ALARM, checkBox.isChecked());
        setResult(-1, intent);
        finish();
    }

    @Override // com.arlosoft.macrodroid.MacroDroidDialogBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_day_of_week_trigger);
        setTitle(R.string.trigger_day_of_week);
        getWindow().setLayout(-1, -2);
        int i4 = getIntent().getExtras().getInt(Constants.EXTRA_HOUR, 0);
        int i5 = getIntent().getExtras().getInt(Constants.EXTRA_MINUTE, 0);
        int i6 = getIntent().getExtras().getInt(Constants.EXTRA_DAY_OF_WEEK, 0);
        boolean z3 = getIntent().getExtras().getBoolean(Constants.EXTRA_USE_ALARM);
        final Spinner spinner = (Spinner) findViewById(R.id.dialog_day_of_week_dialog_spinner_day);
        final TimePicker timePicker = (TimePicker) findViewById(R.id.dialog_day_of_week_dialog_time_picker);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.force_alarm_checkbox);
        timePicker.setIs24HourView(Boolean.TRUE);
        timePicker.setCurrentHour(Integer.valueOf(i4));
        timePicker.setCurrentMinute(Integer.valueOf(i5));
        checkBox.setVisibility(8);
        ((TextView) findViewById(R.id.force_alarm_description)).setVisibility(8);
        checkBox.setChecked(z3);
        String[] strArr = new String[7];
        for (int i7 = 0; i7 < 7; i7++) {
            strArr[i7] = DateTimeUtils.getFullDayName(i7);
        }
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(this, (int) R.layout.simple_spinner_dropdown_item, strArr));
        spinner.setSelection(i6);
        ((Button) findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DayOfWeekConfigureActivity.this.j(view);
            }
        });
        ((Button) findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DayOfWeekConfigureActivity.this.k(timePicker, spinner, checkBox, view);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
