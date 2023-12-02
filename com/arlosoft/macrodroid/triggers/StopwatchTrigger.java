package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.NotificationCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.alarm.AlarmHelper;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.common.NumberPicker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.VariableUpdatedListener;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasStopwatch;
import com.arlosoft.macrodroid.interfaces.HasStringVariableName;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.stopwatch.StopWatch;
import com.arlosoft.macrodroid.triggers.info.StopwatchTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.StopWatchTriggerReceiver;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class StopwatchTrigger extends Trigger implements VariableUpdatedListener, HasStringVariableName, HasStopwatch, HasDictionaryKeys {
    public static final Parcelable.Creator<StopwatchTrigger> CREATOR = new c();
    private static int s_alarmCounter = 543850;
    private boolean dontUseAlarm;
    private transient Handler handler;
    private transient int m_alarmId;
    private transient PendingIntent m_pendingIntent;
    private int m_seconds;
    private String m_stopwatchName;
    private String m_variableName;
    private DictionaryKeys varDictionaryKeys;
    private transient DictionaryKeys workingDictionaryKeys;
    private transient String workingVariableName;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements VariableHelper.VariableSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14418a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NumberPicker f14419b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ NumberPicker f14420c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ NumberPicker f14421d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ViewGroup f14422e;

        a(Button button, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, ViewGroup viewGroup) {
            this.f14418a = button;
            this.f14419b = numberPicker;
            this.f14420c = numberPicker2;
            this.f14421d = numberPicker3;
            this.f14422e = viewGroup;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void customItemSelected(int i4, @NonNull String str) {
            boolean z3;
            Button button = this.f14418a;
            if (this.f14419b.getValue() == 0 && this.f14420c.getValue() == 0 && this.f14421d.getValue() == 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            button.setEnabled(z3);
            this.f14422e.setVisibility(0);
            StopwatchTrigger.this.workingVariableName = null;
            StopwatchTrigger.this.workingDictionaryKeys = null;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void variableSelected(@NonNull MacroDroidVariable macroDroidVariable, List<String> list) {
            DictionaryKeys dictionaryKeys;
            this.f14418a.setEnabled(true);
            this.f14422e.setVisibility(8);
            StopwatchTrigger.this.workingVariableName = macroDroidVariable.getName();
            StopwatchTrigger stopwatchTrigger = StopwatchTrigger.this;
            if (list != null) {
                dictionaryKeys = new DictionaryKeys(list);
            } else {
                dictionaryKeys = null;
            }
            stopwatchTrigger.workingDictionaryKeys = dictionaryKeys;
        }
    }

    /* loaded from: classes3.dex */
    class c implements Parcelable.Creator<StopwatchTrigger> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StopwatchTrigger createFromParcel(Parcel parcel) {
            return new StopwatchTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public StopwatchTrigger[] newArray(int i4) {
            return new StopwatchTrigger[i4];
        }
    }

    /* synthetic */ StopwatchTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void W(MacroDroidVariable macroDroidVariable) {
        if (macroDroidVariable.getName().equals(this.m_variableName)) {
            scheduleAlarm();
        }
    }

    private void X(@NonNull final List<String> list) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_new_stopwatch);
        appCompatDialog.setTitle(R.string.action_stop_watch_create_new);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.name);
        editText.addTextChangedListener(new b(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.w7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StopwatchTrigger.this.Z(editText, list, appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.x7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    private void Y() {
        final List<String> stopWatches = StopWatch.getStopWatches(getContext());
        String[] strArr = new String[stopWatches.size() + 1];
        int i4 = 0;
        strArr[0] = "<" + SelectableItem.r(R.string.action_stop_watch_create_new) + ">";
        for (int i5 = 1; i5 < stopWatches.size() + 1; i5++) {
            String str = stopWatches.get(i5 - 1);
            strArr[i5] = str;
            String str2 = this.m_stopwatchName;
            if (str2 != null && str2.equals(str)) {
                i4 = i5;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setSingleChoiceItems(strArr, i4, (DialogInterface.OnClickListener) null);
        builder.setTitle(p());
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.u7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                StopwatchTrigger.this.b0(stopWatches, dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(EditText editText, List list, AppCompatDialog appCompatDialog, View view) {
        String obj = editText.getText().toString();
        if (list.contains(obj)) {
            h0();
            return;
        }
        list.add(obj);
        StopWatch.setStopWatches(getContext(), list);
        appCompatDialog.dismiss();
        i0(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(List list, DialogInterface dialogInterface, int i4) {
        ListView listView = ((AlertDialog) dialogInterface).getListView();
        int checkedItemPosition = listView.getCheckedItemPosition();
        if (checkedItemPosition == 0) {
            X(list);
        } else {
            i0((String) listView.getAdapter().getItem(checkedItemPosition));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d0(Button button, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3) {
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
    public /* synthetic */ void e0(String str, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, CheckBox checkBox, AppCompatDialog appCompatDialog, View view) {
        this.m_variableName = this.workingVariableName;
        this.varDictionaryKeys = this.workingDictionaryKeys;
        this.m_stopwatchName = str;
        this.m_seconds = numberPicker.getValue() + (numberPicker2.getValue() * 60) + (numberPicker3.getValue() * 3600);
        this.dontUseAlarm = !checkBox.isChecked();
        appCompatDialog.dismiss();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(Intent intent, PowerManager.WakeLock wakeLock) {
        try {
            getContext().sendBroadcast(intent);
        } finally {
            if (wakeLock.isHeld()) {
                wakeLock.release();
            }
        }
    }

    private void h0() {
        MacroDroidBaseActivity macroDroidBaseActivity = (MacroDroidBaseActivity) getActivity();
        if (!macroDroidBaseActivity.isDestroyedOrFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(macroDroidBaseActivity, R.style.Theme_App_Dialog_Variables);
            builder.setTitle(R.string.error);
            builder.setMessage(R.string.action_stop_watch_already_exists);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.b8
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        }
    }

    private void j0(long j4, final Intent intent) {
        final PowerManager.WakeLock newWakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "macrodroid:waitForTime");
        newWakeLock.setReferenceCounted(false);
        newWakeLock.acquire(500 + j4);
        this.handler.postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.v7
            @Override // java.lang.Runnable
            public final void run() {
                StopwatchTrigger.this.g0(intent, newWakeLock);
            }
        }, j4);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void applyImport() {
        List<String> stopWatches = StopWatch.getStopWatches(getContext());
        if (!stopWatches.contains(this.m_stopwatchName)) {
            stopWatches.add(this.m_stopwatchName);
            StopWatch.setStopWatches(getContext(), stopWatches);
        }
    }

    public void cancelAlarm() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.m_pendingIntent != null) {
            ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.m_pendingIntent);
            this.m_pendingIntent = null;
            if (getMacro() != null) {
                SystemLog.logVerbose("[" + getMacro().getName() + " - " + this.m_stopwatchName + "] - Cancelling alarm (" + this.m_alarmId + ")", getMacroGuid().longValue());
            }
        }
    }

    public void clearPendingIntent() {
        this.m_pendingIntent = null;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        cancelAlarm();
        String str = this.m_variableName;
        if (str != null && getVariableByName(str) != null) {
            MacroDroidVariableStore.getInstance().removeStopWatchVariableUpdatedListener(this);
            this.m_macro.removeLocalVariableUpdatedListener(this);
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        int i4 = s_alarmCounter;
        s_alarmCounter = i4 + 1;
        this.m_alarmId = i4;
        scheduleAlarm();
        String str = this.m_variableName;
        if (str != null && getVariableByName(str) != null) {
            MacroDroidVariableStore.getInstance().addStopWatchVariableUpdatedListener(this);
            this.m_macro.addLocalVariableUpdatedListener(this);
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    @Nullable
    public DictionaryKeys getDictionaryKeys() {
        return this.varDictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str;
        if (this.m_variableName == null) {
            int i4 = this.m_seconds;
            if (i4 >= 3600) {
                str = (this.m_seconds / 3600) + SelectableItem.r(R.string.hour_one_char) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + ((this.m_seconds / 60) % 60) + SelectableItem.r(R.string.minute_one_char) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + (this.m_seconds % 60) + SelectableItem.r(R.string.second_one_char);
            } else if (i4 >= 60) {
                str = ((this.m_seconds / 60) % 60) + SelectableItem.r(R.string.minute_one_char) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + (this.m_seconds % 60) + SelectableItem.r(R.string.second_one_char);
            } else {
                str = (this.m_seconds % 60) + SelectableItem.r(R.string.second_one_char);
            }
        } else {
            str = this.m_variableName + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        }
        return this.m_stopwatchName + ": " + str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return StopwatchTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getExtendedDetail();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 31) {
            return new String[0];
        }
        return super.getPermissions();
    }

    public int getRequestId() {
        return this.m_alarmId;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasStopwatch
    public String getStopwatchName() {
        return this.m_stopwatchName;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public String getVariableName() {
        return this.m_variableName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Y();
    }

    protected void i0(final String str) {
        String str2;
        final NumberPicker numberPicker;
        boolean z3;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_stopwatch_constraint);
        appCompatDialog.setTitle(R.string.trigger_at);
        this.workingVariableName = this.m_variableName;
        this.workingDictionaryKeys = this.varDictionaryKeys;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final NumberPicker numberPicker2 = (NumberPicker) appCompatDialog.findViewById(R.id.second_picker);
        final NumberPicker numberPicker3 = (NumberPicker) appCompatDialog.findViewById(R.id.minute_picker);
        NumberPicker numberPicker4 = (NumberPicker) appCompatDialog.findViewById(R.id.hour_picker);
        Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.spinner);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.time_layout);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.force_alarm_checkbox);
        ((ViewGroup) appCompatDialog.findViewById(R.id.constraint_options)).setVisibility(8);
        numberPicker2.setMaximum(59);
        numberPicker2.setMinimum(0);
        numberPicker3.setMaximum(59);
        numberPicker3.setMinimum(0);
        numberPicker4.setMinimum(0);
        checkBox.setVisibility(0);
        checkBox.setChecked(!this.dontUseAlarm);
        ((TextView) appCompatDialog.findViewById(R.id.force_alarm_description)).setVisibility(0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(SelectableItem.r(R.string.use_slider_value));
        Activity activity = getActivity();
        Macro macro = getMacro();
        if (this.workingVariableName != null) {
            str2 = this.workingVariableName + VariableHelper.getFormattedDictionaryKeys(this.workingDictionaryKeys);
        } else {
            str2 = null;
        }
        VariableHelper.configureNumberVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro, arrayList, str2, " (" + SelectableItem.r(R.string.seconds_one_char) + ")", false, new a(button, numberPicker3, numberPicker4, numberPicker2, viewGroup));
        if (this.workingVariableName == null) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
        numberPicker2.setValue(this.m_seconds % 60);
        int i4 = this.m_seconds;
        if (i4 > 59) {
            numberPicker3.setValue((i4 / 60) % 60);
        }
        int i5 = this.m_seconds;
        if (i5 > 3599) {
            numberPicker = numberPicker4;
            numberPicker.setValue(i5 / 3600);
        } else {
            numberPicker = numberPicker4;
        }
        NumberPicker.Listener listener = new NumberPicker.Listener() { // from class: com.arlosoft.macrodroid.triggers.y7
            @Override // com.arlosoft.macrodroid.common.NumberPicker.Listener
            public final void valueUpdated() {
                StopwatchTrigger.d0(button, numberPicker3, numberPicker, numberPicker2);
            }
        };
        numberPicker2.setListener(listener);
        numberPicker3.setListener(listener);
        numberPicker.setListener(listener);
        if (this.m_seconds == 0 && this.m_variableName == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        button.setEnabled(z3);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.z7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StopwatchTrigger.this.e0(str, numberPicker2, numberPicker3, numberPicker, checkBox, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.a8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        return StopWatch.getStopWatches(getContext()).contains(this.m_stopwatchName);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresScheduleExactAlarm() {
        return true;
    }

    public void scheduleAlarm() {
        int i4;
        cancelAlarm();
        if (StopWatch.isActive(getContext(), this.m_stopwatchName)) {
            long stopWatchDuration = StopWatch.getStopWatchDuration(getContext(), this.m_stopwatchName);
            String str = this.m_variableName;
            if (str != null) {
                MacroDroidVariable variableByName = getVariableByName(str);
                if (variableByName == null) {
                    SystemLog.logError("Can't schedule stopwatch trigger: " + this.m_variableName + " does not exist", getMacroGuid().longValue());
                    return;
                }
                Long longValue = variableByName.getLongValue(this.varDictionaryKeys);
                if (longValue != null) {
                    i4 = longValue.intValue();
                } else {
                    SystemLog.logError("Can't schedule stopwatch trigger: " + this.m_variableName + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys) + " does not exist", getMacroGuid().longValue());
                    return;
                }
            } else {
                i4 = this.m_seconds;
            }
            long j4 = i4 * 1000;
            if (stopWatchDuration < j4) {
                long j5 = j4 - stopWatchDuration;
                Intent intent = new Intent(getContext(), StopWatchTriggerReceiver.class);
                intent.putExtra(TimerTrigger.EXTRA_ALARM_ID, this.m_alarmId);
                long j6 = j5 / 1000;
                if (j6 <= 5) {
                    j0(j5, intent);
                    return;
                }
                this.m_pendingIntent = PendingIntent.getBroadcast(getContext(), this.m_alarmId, intent, 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
                AlarmHelper.scheduleExactRTCWithAlarmOption(!this.dontUseAlarm, System.currentTimeMillis() + j5, this.m_pendingIntent);
                StringBuilder sb = new StringBuilder();
                sb.append("Scheduling alarm (");
                sb.append(this.m_alarmId);
                sb.append(") for: ");
                sb.append(j6);
                sb.append("s");
                if (getMacro() != null) {
                    SystemLog.logVerbose("[" + getMacro().getName() + " - " + this.m_stopwatchName + "] - StopWatch alarm (" + this.m_alarmId + ") scheduled for " + j6 + "s", getMacroGuid().longValue());
                }
            }
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    public void setDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        this.varDictionaryKeys = dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasStopwatch
    public void setStopwatchName(String str) {
        this.m_stopwatchName = str;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public void setVariableName(String str) {
        this.m_variableName = str;
    }

    @Override // com.arlosoft.macrodroid.common.VariableUpdatedListener
    public void variableValueUpdated(@NonNull MacroDroidVariable macroDroidVariable, @NonNull VariableValue variableValue, @NonNull VariableValue variableValue2, long j4) {
        W(macroDroidVariable);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_seconds);
        parcel.writeString(this.m_stopwatchName);
        parcel.writeString(this.m_variableName);
        parcel.writeInt(this.dontUseAlarm ? 1 : 0);
        parcel.writeParcelable(this.varDictionaryKeys, i4);
    }

    public StopwatchTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public StopwatchTrigger() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    private StopwatchTrigger(Parcel parcel) {
        super(parcel);
        this.handler = new Handler(Looper.getMainLooper());
        this.m_seconds = parcel.readInt();
        this.m_stopwatchName = parcel.readString();
        this.m_variableName = parcel.readString();
        this.dontUseAlarm = parcel.readInt() != 0;
        this.varDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14424a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f14425b;

        b(Button button, EditText editText) {
            this.f14424a = button;
            this.f14425b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f14424a;
            if (this.f14425b.getText().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
