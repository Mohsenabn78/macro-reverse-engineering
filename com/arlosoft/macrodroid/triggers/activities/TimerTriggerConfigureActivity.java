package com.arlosoft.macrodroid.triggers.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.arlosoft.macrodroid.MacroDroidDialogBaseActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.triggers.TimerTrigger;
import com.ikovac.timepickerwithseconds.TimePicker;

/* loaded from: classes3.dex */
public class TimerTriggerConfigureActivity extends MacroDroidDialogBaseActivity {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(CheckBox[] checkBoxArr, Button button, CompoundButton compoundButton, boolean z3) {
        boolean z4 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= checkBoxArr.length) {
                break;
            } else if (checkBoxArr[i4].isChecked()) {
                z4 = true;
                break;
            } else {
                i4++;
            }
        }
        button.setEnabled(z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(TimePicker timePicker, CheckBox[] checkBoxArr, CheckBox checkBox, View view) {
        int intValue = timePicker.getCurrentHour().intValue();
        int intValue2 = timePicker.getCurrentMinute().intValue();
        int intValue3 = timePicker.getCurrentSeconds().intValue();
        boolean[] zArr = new boolean[7];
        for (int i4 = 0; i4 < checkBoxArr.length; i4++) {
            zArr[i4] = checkBoxArr[i4].isChecked();
        }
        Intent intent = new Intent();
        intent.putExtra(TimerTrigger.DAYS_OF_WEEK_EXTRA, zArr);
        intent.putExtra(Constants.EXTRA_HOUR, intValue);
        intent.putExtra(Constants.EXTRA_MINUTE, intValue2);
        intent.putExtra(Constants.EXTRA_SECOND, intValue3);
        intent.putExtra(Constants.EXTRA_USE_ALARM, checkBox.isChecked());
        setResult(-1, intent);
        finish();
    }

    @Override // com.arlosoft.macrodroid.MacroDroidDialogBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.timer_trigger_configure);
        setTitle(R.string.trigger_timer);
        getWindow().setLayout(-1, -2);
        int i4 = getIntent().getExtras().getInt(Constants.EXTRA_HOUR, 0);
        int i5 = getIntent().getExtras().getInt(Constants.EXTRA_MINUTE, 0);
        int i6 = getIntent().getExtras().getInt(Constants.EXTRA_SECOND, 0);
        boolean[] booleanArray = getIntent().getExtras().getBooleanArray(TimerTrigger.DAYS_OF_WEEK_EXTRA);
        boolean z3 = getIntent().getExtras().getBoolean(Constants.EXTRA_USE_ALARM);
        final TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(Boolean.TRUE);
        timePicker.setCurrentHour(Integer.valueOf(i4));
        timePicker.setCurrentMinute(Integer.valueOf(i5));
        timePicker.setCurrentSecond(Integer.valueOf(i6));
        int[] iArr = {R.id.checkBoxMonday, R.id.checkBoxTuesday, R.id.checkBoxWednesday, R.id.checkBoxThursday, R.id.checkBoxFriday, R.id.checkBoxSaturday, R.id.checkBoxSunday};
        final CheckBox[] checkBoxArr = new CheckBox[7];
        final Button button = (Button) findViewById(R.id.okButton);
        Button button2 = (Button) findViewById(R.id.cancelButton);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.force_alarm_checkbox);
        TextView textView = (TextView) findViewById(R.id.force_alarm_description);
        checkBox.setChecked(z3);
        for (int i7 = 0; i7 < 7; i7++) {
            CheckBox checkBox2 = (CheckBox) findViewById(iArr[i7]);
            checkBoxArr[i7] = checkBox2;
            if (booleanArray[i7]) {
                checkBox2.setChecked(true);
                button.setEnabled(true);
            }
            checkBoxArr[i7].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.activities.x
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                    TimerTriggerConfigureActivity.k(checkBoxArr, button, compoundButton, z4);
                }
            });
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimerTriggerConfigureActivity.this.l(view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimerTriggerConfigureActivity.this.m(timePicker, checkBoxArr, checkBox, view);
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
