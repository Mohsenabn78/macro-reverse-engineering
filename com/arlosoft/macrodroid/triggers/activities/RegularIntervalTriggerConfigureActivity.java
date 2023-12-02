package com.arlosoft.macrodroid.triggers.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.TimePicker;
import com.arlosoft.macrodroid.MacroDroidDialogBaseActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.triggers.RegularIntervalTrigger;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class RegularIntervalTriggerConfigureActivity extends MacroDroidDialogBaseActivity implements NumberPicker.Listener {

    /* renamed from: d  reason: collision with root package name */
    private Button f14527d;

    /* renamed from: e  reason: collision with root package name */
    private Button f14528e;

    /* renamed from: f  reason: collision with root package name */
    private NumberPicker f14529f;

    /* renamed from: g  reason: collision with root package name */
    private NumberPicker f14530g;

    /* renamed from: h  reason: collision with root package name */
    private NumberPicker f14531h;

    /* renamed from: i  reason: collision with root package name */
    private TimePicker f14532i;

    /* renamed from: j  reason: collision with root package name */
    private CheckBox f14533j;

    /* renamed from: k  reason: collision with root package name */
    private View f14534k;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(CheckBox checkBox, View view) {
        int value = this.f14531h.getValue() + (this.f14530g.getValue() * 60) + (this.f14529f.getValue() * 60 * 60);
        if (Build.VERSION.SDK_INT >= 31 && value < 5) {
            ToastCompat.makeText((Context) this, (CharSequence) String.format(getString(R.string.regular_interval_must_be_at_least_x_seconds), 5), 1).show();
            return;
        }
        if (value == 0) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("The RegularIntervalTrigger was set to 0 minutes!"));
        }
        Intent intent = new Intent();
        intent.putExtra("Seconds", value);
        intent.putExtra(RegularIntervalTrigger.START_MINUTE_EXTRA, this.f14532i.getCurrentHour().intValue());
        intent.putExtra(RegularIntervalTrigger.START_HOUR_EXTRA, this.f14532i.getCurrentMinute().intValue());
        intent.putExtra(RegularIntervalTrigger.IGNORE_START_TIME, !this.f14533j.isChecked());
        intent.putExtra(Constants.EXTRA_USE_ALARM, checkBox.isChecked());
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(CompoundButton compoundButton, boolean z3) {
        int i4;
        TimePicker timePicker = this.f14532i;
        int i5 = 0;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        timePicker.setVisibility(i4);
        View view = this.f14534k;
        if (z3) {
            i5 = 8;
        }
        view.setVisibility(i5);
    }

    @Override // com.arlosoft.macrodroid.MacroDroidDialogBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z3;
        super.onCreate(bundle);
        setContentView(R.layout.regular_interval_setting);
        setTitle(R.string.trigger_regular_interval);
        getWindow().setLayout(-1, -2);
        int intExtra = getIntent().getIntExtra("Seconds", 0);
        int intExtra2 = getIntent().getIntExtra(RegularIntervalTrigger.START_HOUR_EXTRA, 0);
        int intExtra3 = getIntent().getIntExtra(RegularIntervalTrigger.START_MINUTE_EXTRA, 0);
        boolean booleanExtra = getIntent().getBooleanExtra(RegularIntervalTrigger.IGNORE_START_TIME, false);
        boolean booleanExtra2 = getIntent().getBooleanExtra(Constants.EXTRA_USE_ALARM, false);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.force_alarm_checkbox);
        TextView textView = (TextView) findViewById(R.id.force_alarm_description);
        int i4 = intExtra / 3600;
        this.f14534k = findViewById(R.id.regular_interval_setting_padding);
        this.f14533j = (CheckBox) findViewById(R.id.regular_interval_setting_reference_start_time_checkbox);
        this.f14529f = (NumberPicker) findViewById(R.id.regular_interval_setting_hour_picker);
        this.f14530g = (NumberPicker) findViewById(R.id.regular_interval_setting_minute_picker);
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.regular_interval_setting_second_picker);
        this.f14531h = numberPicker;
        numberPicker.setValue(intExtra % 60);
        this.f14531h.setMinimum(0);
        this.f14531h.setMaximum(59);
        this.f14531h.setListener(this);
        this.f14530g.setValue((intExtra / 60) % 60);
        this.f14530g.setMinimum(0);
        this.f14530g.setMaximum(59);
        this.f14530g.setListener(this);
        this.f14529f.setValue(i4);
        this.f14529f.setListener(this);
        this.f14529f.setMinimum(0);
        this.f14529f.setMaximum(999);
        TimePicker timePicker = (TimePicker) findViewById(R.id.regular_interval_setting_time_picker);
        this.f14532i = timePicker;
        timePicker.setIs24HourView(Boolean.TRUE);
        this.f14532i.setCurrentHour(Integer.valueOf(intExtra2));
        this.f14532i.setCurrentMinute(Integer.valueOf(intExtra3));
        Button button = (Button) findViewById(R.id.okButton);
        this.f14527d = button;
        if (this.f14531h.getValue() == 0 && this.f14530g.getValue() == 0 && this.f14529f.getValue() == 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        button.setEnabled(z3);
        this.f14527d.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegularIntervalTriggerConfigureActivity.this.k(checkBox, view);
            }
        });
        Button button2 = (Button) findViewById(R.id.cancelButton);
        this.f14528e = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegularIntervalTriggerConfigureActivity.this.l(view);
            }
        });
        checkBox.setChecked(booleanExtra2);
        if (booleanExtra) {
            this.f14532i.setVisibility(8);
            this.f14534k.setVisibility(0);
        } else {
            this.f14532i.setVisibility(0);
            this.f14534k.setVisibility(8);
        }
        this.f14533j.setChecked(!booleanExtra);
        this.f14533j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.activities.s
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                RegularIntervalTriggerConfigureActivity.this.m(compoundButton, z4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = Math.max(attributes.width, (getResources().getDisplayMetrics().widthPixels * 90) / 100);
        getWindow().setAttributes(attributes);
    }

    @Override // com.arlosoft.macrodroid.common.NumberPicker.Listener
    public void valueUpdated() {
        boolean z3;
        Button button = this.f14527d;
        if (this.f14530g.getValue() == 0 && this.f14529f.getValue() == 0 && this.f14531h.getValue() == 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        button.setEnabled(z3);
    }
}
