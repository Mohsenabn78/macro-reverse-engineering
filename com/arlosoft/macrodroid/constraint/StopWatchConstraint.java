package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.StopWatchConstraintInfo;
import com.arlosoft.macrodroid.interfaces.HasStopwatch;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.stopwatch.StopWatch;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class StopWatchConstraint extends Constraint implements HasStopwatch {
    public static final Parcelable.Creator<StopWatchConstraint> CREATOR = new b();
    private boolean m_greaterThan;
    private String m_stopwatchName;
    private int m_timePeriodSeconds;
    private String m_variableName;

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<StopWatchConstraint> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StopWatchConstraint createFromParcel(Parcel parcel) {
            return new StopWatchConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public StopWatchConstraint[] newArray(int i4) {
            return new StopWatchConstraint[i4];
        }
    }

    /* synthetic */ StopWatchConstraint(Parcel parcel, a aVar) {
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
    public /* synthetic */ void S(Spinner spinner, List list, RadioButton radioButton, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, AppCompatDialog appCompatDialog, View view) {
        if (spinner.getSelectedItemPosition() == 0) {
            this.m_variableName = null;
        } else {
            this.m_variableName = ((MacroDroidVariable) list.get(spinner.getSelectedItemPosition() - 1)).getName();
        }
        this.m_greaterThan = radioButton.isChecked();
        this.m_timePeriodSeconds = numberPicker.getValue() + (numberPicker2.getValue() * 60) + (numberPicker3.getValue() * 3600);
        appCompatDialog.dismiss();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_stopwatchName = o()[i4];
    }

    protected void U() {
        boolean z3;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_stopwatch_constraint);
        appCompatDialog.setTitle(this.m_stopwatchName);
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final NumberPicker numberPicker = (NumberPicker) appCompatDialog.findViewById(R.id.second_picker);
        final NumberPicker numberPicker2 = (NumberPicker) appCompatDialog.findViewById(R.id.minute_picker);
        final NumberPicker numberPicker3 = (NumberPicker) appCompatDialog.findViewById(R.id.hour_picker);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.greater_than);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.spinner);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.time_layout);
        numberPicker.setMinimum(0);
        numberPicker.setMaximum(59);
        numberPicker2.setMinimum(0);
        numberPicker2.setMaximum(59);
        numberPicker3.setMinimum(0);
        radioButton.setChecked(this.m_greaterThan);
        ((RadioButton) appCompatDialog.findViewById(R.id.less_than)).setChecked(!this.m_greaterThan);
        ArrayList arrayList = new ArrayList();
        arrayList.add(SelectableItem.r(R.string.fixed_duration));
        final ArrayList<MacroDroidVariable> allIntegerVariables = getAllIntegerVariables();
        allIntegerVariables.addAll(getAllDecimalVariables());
        int i4 = 0;
        int i5 = 1;
        for (MacroDroidVariable macroDroidVariable : allIntegerVariables) {
            String str = this.m_variableName;
            if (str != null && str.equals(macroDroidVariable.getName())) {
                i4 = i5;
            }
            arrayList.add(SelectableItem.r(R.string.variable_short_name) + ": " + macroDroidVariable.getName() + " (" + SelectableItem.r(R.string.seconds_one_char) + ")");
            i5++;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), (int) R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setSelection(i4, false);
        spinner.setOnItemSelectedListener(new a(viewGroup, spinner, button, numberPicker2, numberPicker3, numberPicker));
        if (spinner.getSelectedItemPosition() == 0) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
        numberPicker.setValue(this.m_timePeriodSeconds % 60);
        int i6 = this.m_timePeriodSeconds;
        if (i6 > 59) {
            numberPicker2.setValue((i6 / 60) % 60);
        }
        int i7 = this.m_timePeriodSeconds;
        if (i7 > 3599) {
            numberPicker3.setValue(i7 / 3600);
        }
        NumberPicker.Listener listener = new NumberPicker.Listener() { // from class: com.arlosoft.macrodroid.constraint.f4
            @Override // com.arlosoft.macrodroid.common.NumberPicker.Listener
            public final void valueUpdated() {
                StopWatchConstraint.R(button, numberPicker2, numberPicker3, numberPicker);
            }
        };
        numberPicker.setListener(listener);
        numberPicker2.setListener(listener);
        numberPicker3.setListener(listener);
        if (this.m_timePeriodSeconds != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        button.setEnabled(z3);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.g4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StopWatchConstraint.this.S(spinner, allIntegerVariables, radioButton, numberPicker, numberPicker2, numberPicker3, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.h4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void applyImport() {
        List<String> stopWatches = StopWatch.getStopWatches(getContext());
        if (!stopWatches.contains(this.m_stopwatchName)) {
            stopWatches.add(this.m_stopwatchName);
            StopWatch.setStopWatches(getContext(), stopWatches);
        }
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        long j4;
        long longValue;
        boolean z3;
        long stopWatchDuration = StopWatch.getStopWatchDuration(getContext(), this.m_stopwatchName);
        String str = this.m_variableName;
        if (str == null) {
            j4 = this.m_timePeriodSeconds * 1000;
        } else {
            MacroDroidVariable variableByName = getVariableByName(str);
            if (variableByName != null && (variableByName.getType() == 3 || variableByName.getType() == 1)) {
                if (variableByName.isDecimal()) {
                    longValue = (long) variableByName.getDecimalValue();
                } else if (variableByName.isInt()) {
                    longValue = variableByName.getLongValue();
                } else {
                    j4 = 0;
                }
                j4 = longValue * 1000;
            } else {
                SystemLog.logError("Stop watch constraint failed, numerical variable not found: " + this.m_variableName, getMacroGuid().longValue());
                return true;
            }
        }
        if (stopWatchDuration > j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 == this.m_greaterThan) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        String[] o4 = o();
        for (int i4 = 0; i4 < o4.length; i4++) {
            String str = this.m_stopwatchName;
            if (str != null && str.equals(o4[i4])) {
                return i4;
            }
        }
        return 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str;
        String str2 = this.m_variableName;
        if (str2 == null) {
            int i4 = this.m_timePeriodSeconds;
            if (i4 >= 3600) {
                str2 = (this.m_timePeriodSeconds / 3600) + SelectableItem.r(R.string.hour_one_char) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + ((this.m_timePeriodSeconds / 60) % 60) + SelectableItem.r(R.string.minute_one_char) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + (this.m_timePeriodSeconds % 60) + SelectableItem.r(R.string.second_one_char);
            } else if (i4 >= 60) {
                str2 = ((this.m_timePeriodSeconds / 60) % 60) + SelectableItem.r(R.string.minute_one_char) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + (this.m_timePeriodSeconds % 60) + SelectableItem.r(R.string.second_one_char);
            } else {
                str2 = (this.m_timePeriodSeconds % 60) + SelectableItem.r(R.string.second_one_char);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.m_stopwatchName);
        if (this.m_greaterThan) {
            str = " > ";
        } else {
            str = " < ";
        }
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return StopWatchConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getExtendedDetail();
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasStopwatch
    public String getStopwatchName() {
        return this.m_stopwatchName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        String[] o4 = o();
        if (o4 != null && o4.length > 0) {
            k();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        return StopWatch.getStopWatches(getContext()).contains(this.m_stopwatchName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        List<String> stopWatches = StopWatch.getStopWatches(getContext());
        if (stopWatches.size() == 0) {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.no_stopwatches_defined, 0).show();
            return new String[0];
        }
        if (this.m_stopwatchName == null && stopWatches.size() > 0) {
            this.m_stopwatchName = stopWatches.get(0);
        }
        return (String[]) stopWatches.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        U();
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasStopwatch
    public void setStopwatchName(String str) {
        this.m_stopwatchName = str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_stopwatchName);
        parcel.writeInt(this.m_timePeriodSeconds);
        parcel.writeInt(this.m_greaterThan ? 1 : 0);
        parcel.writeString(this.m_variableName);
    }

    public StopWatchConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private StopWatchConstraint() {
        this.m_greaterThan = true;
    }

    private StopWatchConstraint(Parcel parcel) {
        super(parcel);
        this.m_stopwatchName = parcel.readString();
        this.m_timePeriodSeconds = parcel.readInt();
        this.m_greaterThan = parcel.readInt() != 0;
        this.m_variableName = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f10223a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Spinner f10224b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Button f10225c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ NumberPicker f10226d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ NumberPicker f10227e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ NumberPicker f10228f;

        a(ViewGroup viewGroup, Spinner spinner, Button button, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3) {
            this.f10223a = viewGroup;
            this.f10224b = spinner;
            this.f10225c = button;
            this.f10226d = numberPicker;
            this.f10227e = numberPicker2;
            this.f10228f = numberPicker3;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            int i5;
            ViewGroup viewGroup = this.f10223a;
            boolean z3 = false;
            if (this.f10224b.getSelectedItemPosition() == 0) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            viewGroup.setVisibility(i5);
            this.f10225c.setEnabled((i4 <= 0 && this.f10226d.getValue() == 0 && this.f10227e.getValue() == 0 && this.f10228f.getValue() == 0) ? true : true);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}
