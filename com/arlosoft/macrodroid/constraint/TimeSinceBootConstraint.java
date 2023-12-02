package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.TimeSinceBootConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes3.dex */
public class TimeSinceBootConstraint extends Constraint {
    public static final Parcelable.Creator<TimeSinceBootConstraint> CREATOR = new a();
    private boolean m_lessThan;
    private int m_timePeriodSeconds;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<TimeSinceBootConstraint> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TimeSinceBootConstraint createFromParcel(Parcel parcel) {
            return new TimeSinceBootConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TimeSinceBootConstraint[] newArray(int i4) {
            return new TimeSinceBootConstraint[i4];
        }
    }

    /* synthetic */ TimeSinceBootConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R(Button button, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3) {
        boolean z3;
        if (button != null) {
            if (numberPicker.getValue() == 0 && numberPicker2.getValue() == 0 && numberPicker3.getValue() == 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            button.setEnabled(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, RadioButton radioButton, AppCompatDialog appCompatDialog, View view) {
        this.m_timePeriodSeconds = numberPicker.getValue() + (numberPicker2.getValue() * 60) + (numberPicker3.getValue() * 3600);
        this.m_lessThan = radioButton.isChecked();
        appCompatDialog.cancel();
        itemComplete();
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        if (SystemClock.elapsedRealtime() / 1000 <= this.m_timePeriodSeconds) {
            return this.m_lessThan;
        }
        return !this.m_lessThan;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        Context context;
        int i4;
        StringBuilder sb = new StringBuilder();
        if (this.m_lessThan) {
            context = getContext();
            i4 = R.string.less_than;
        } else {
            context = getContext();
            i4 = R.string.greater_than;
        }
        sb.append(context.getString(i4));
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        String sb2 = sb.toString();
        int i5 = this.m_timePeriodSeconds;
        if (i5 >= 3600) {
            return sb2 + (this.m_timePeriodSeconds / 3600) + SelectableItem.r(R.string.hour_one_char) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + ((this.m_timePeriodSeconds / 60) % 60) + SelectableItem.r(R.string.minute_one_char) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + (this.m_timePeriodSeconds % 60) + SelectableItem.r(R.string.second_one_char);
        } else if (i5 >= 60) {
            return sb2 + ((this.m_timePeriodSeconds / 60) % 60) + SelectableItem.r(R.string.minute_one_char) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + (this.m_timePeriodSeconds % 60) + SelectableItem.r(R.string.second_one_char);
        } else {
            return sb2 + (this.m_timePeriodSeconds % 60) + SelectableItem.r(R.string.second_one_char);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return TimeSinceBootConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getName() + ": " + getExtendedDetail();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.time_since_boot_constraint);
        appCompatDialog.setTitle(R.string.constraint_time_since_boot);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final NumberPicker numberPicker = (NumberPicker) appCompatDialog.findViewById(R.id.time_since_boot_constraint_second_picker);
        final NumberPicker numberPicker2 = (NumberPicker) appCompatDialog.findViewById(R.id.time_since_boot_constraint_minute_picker);
        final NumberPicker numberPicker3 = (NumberPicker) appCompatDialog.findViewById(R.id.time_since_boot_constraint_hour_picker);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.time_since_boot_constraint_less_than);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.time_since_boot_constraint_greater_than);
        numberPicker.setMaximum(59);
        numberPicker2.setMaximum(59);
        boolean z3 = false;
        numberPicker.setMinimum(0);
        numberPicker2.setMinimum(0);
        numberPicker3.setMinimum(0);
        if (!this.m_lessThan) {
            radioButton2.setChecked(true);
        }
        numberPicker.setValue(this.m_timePeriodSeconds % 60);
        int i4 = this.m_timePeriodSeconds;
        if (i4 > 59) {
            numberPicker2.setValue((i4 / 60) % 60);
        }
        int i5 = this.m_timePeriodSeconds;
        if (i5 > 3599) {
            numberPicker3.setValue(i5 / 3600);
        }
        NumberPicker.Listener listener = new NumberPicker.Listener() { // from class: com.arlosoft.macrodroid.constraint.r4
            @Override // com.arlosoft.macrodroid.common.NumberPicker.Listener
            public final void valueUpdated() {
                TimeSinceBootConstraint.R(button, numberPicker2, numberPicker3, numberPicker);
            }
        };
        numberPicker.setListener(listener);
        numberPicker2.setListener(listener);
        numberPicker3.setListener(listener);
        if (this.m_timePeriodSeconds != 0) {
            z3 = true;
        }
        button.setEnabled(z3);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.s4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimeSinceBootConstraint.this.S(numberPicker, numberPicker2, numberPicker3, radioButton, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.t4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_timePeriodSeconds);
        parcel.writeInt(!this.m_lessThan ? 1 : 0);
    }

    public TimeSinceBootConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private TimeSinceBootConstraint() {
        this.m_timePeriodSeconds = 0;
        this.m_lessThan = true;
    }

    private TimeSinceBootConstraint(Parcel parcel) {
        super(parcel);
        this.m_timePeriodSeconds = parcel.readInt();
        this.m_lessThan = parcel.readInt() == 0;
    }
}
