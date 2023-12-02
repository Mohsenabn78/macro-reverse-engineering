package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SwitchCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.UpdateBrightnessActivity;
import com.arlosoft.macrodroid.action.info.SetBrightnessActionInfo;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.HasVariable;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.PieBrightnessLookup;
import com.arlosoft.macrodroid.utils.UIUtils;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import java.util.ArrayList;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class SetBrightnessAction extends Action implements HasVariable {
    private static final int AUTO_BRIGHTNESS = 999;
    public static final Parcelable.Creator<SetBrightnessAction> CREATOR = new c();
    public static final int MAX_BRIGHTNESS = 255;
    private static final String SCREEN_BRIGHTNESS_MODE = "screen_brightness_mode";
    private static final int SCREEN_BRIGHTNESS_MODE_AUTOMATIC = 1;
    private static final int SCREEN_BRIGHTNESS_MODE_MANUAL = 0;
    private int forceValue;
    private boolean forceValueEnabled;
    private int m_brightness;
    private int m_brightnessPercent;
    private transient int m_brightnessToRestore;
    private boolean m_forcePieMode;
    private transient int m_minimumBrightness;
    private MacroDroidVariable m_variable;
    private DictionaryKeys varDictionaryKeys;
    private transient DictionaryKeys workingDictionaryKeys;
    private transient MacroDroidVariable workingVariable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements VariableHelper.VariableSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2487a;

        a(ViewGroup viewGroup) {
            this.f2487a = viewGroup;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void customItemSelected(int i4, @NonNull String str) {
            this.f2487a.setVisibility(0);
            SetBrightnessAction.this.workingVariable = null;
            SetBrightnessAction.this.workingDictionaryKeys = null;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void variableSelected(@NonNull MacroDroidVariable macroDroidVariable, List<String> list) {
            DictionaryKeys dictionaryKeys;
            this.f2487a.setVisibility(8);
            SetBrightnessAction.this.workingVariable = macroDroidVariable;
            SetBrightnessAction setBrightnessAction = SetBrightnessAction.this;
            if (list != null) {
                dictionaryKeys = new DictionaryKeys(list);
            } else {
                dictionaryKeys = null;
            }
            setBrightnessAction.workingDictionaryKeys = dictionaryKeys;
        }
    }

    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<SetBrightnessAction> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetBrightnessAction createFromParcel(Parcel parcel) {
            return new SetBrightnessAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetBrightnessAction[] newArray(int i4) {
            return new SetBrightnessAction[i4];
        }
    }

    /* synthetic */ SetBrightnessAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private int V(int i4) {
        int i5 = this.m_minimumBrightness;
        return Math.round(((i4 - i5) / (255 - i5)) * 100.0f);
    }

    private void W() {
        int i4 = this.m_brightness;
        if (i4 > 0) {
            this.m_brightnessPercent = V(i4);
            this.m_brightness = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int X(int i4) {
        if (i4 > 100) {
            i4 = 100;
        } else if (i4 < 0) {
            i4 = 0;
        }
        int i5 = this.m_minimumBrightness;
        return ((int) (i4 * ((255 - i5) / 100.0f))) + i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(TextView textView, CompoundButton compoundButton, boolean z3) {
        int i4;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView.setVisibility(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z(Spinner spinner, SeekBar seekBar, CompoundButton compoundButton, boolean z3) {
        spinner.setEnabled(!z3);
        seekBar.setEnabled(!z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a0(Spinner spinner, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || spinner.getAdapter().getCount() > 1) {
            return false;
        }
        ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.no_integer_variables_defined, 0).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(SwitchCompat switchCompat, SeekBar seekBar, CheckBox checkBox, CheckBox checkBox2, TextView textView, AppCompatDialog appCompatDialog, View view) {
        if (switchCompat.isChecked()) {
            this.m_brightnessPercent = 999;
        } else {
            this.m_brightnessPercent = seekBar.getProgress();
        }
        this.m_variable = this.workingVariable;
        this.varDictionaryKeys = this.workingDictionaryKeys;
        this.m_forcePieMode = checkBox.isChecked();
        this.forceValueEnabled = checkBox2.isChecked();
        if (!textView.getText().toString().isEmpty()) {
            try {
                this.forceValue = Integer.valueOf(textView.getText().toString()).intValue();
            } catch (Exception unused) {
                this.forceValue = 0;
            }
        } else {
            this.forceValue = 0;
        }
        appCompatDialog.dismiss();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(Activity activity, DialogInterface dialogInterface) {
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.screenBrightness = this.m_brightnessToRestore / 255.0f;
            activity.getWindow().setAttributes(attributes);
        } catch (NullPointerException unused) {
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        W();
        if (this.forceValueEnabled) {
            return String.valueOf(this.forceValue);
        }
        if (this.m_brightnessPercent == 999) {
            return SelectableItem.r(R.string.action_set_brightness_auto);
        }
        if (this.m_variable != null) {
            return this.m_variable.getName() + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        }
        return this.m_brightnessPercent + "%";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetBrightnessActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariable
    public MacroDroidVariable getVariable() {
        return this.m_variable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        int i4;
        int i5;
        int i6;
        String str;
        boolean z3;
        if (!checkActivityAlive()) {
            return;
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.brightness_dialog);
        appCompatDialog.setTitle(R.string.action_set_brightness);
        this.workingVariable = this.m_variable;
        this.workingDictionaryKeys = this.varDictionaryKeys;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final SeekBar seekBar = (SeekBar) appCompatDialog.findViewById(R.id.brightness_dialog_seek_bar);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.variablesSpinner);
        final SwitchCompat switchCompat = (SwitchCompat) appCompatDialog.findViewById(R.id.brightness_dialog_auto_switch);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.brightness_bar_layout);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.brightness_percent_text);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.use_android_pie_checkbox);
        TextView textView2 = (TextView) appCompatDialog.findViewById(R.id.use_android_pie_text);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.force_value_checkbox);
        final TextView textView3 = (TextView) appCompatDialog.findViewById(R.id.force_value_value);
        TextView textView4 = (TextView) appCompatDialog.findViewById(R.id.force_value_description);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 28) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView2.setVisibility(i4);
        if (i7 >= 28) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        checkBox.setVisibility(i5);
        checkBox.setChecked(this.m_forcePieMode);
        checkBox2.setChecked(this.forceValueEnabled);
        textView3.setText(String.valueOf(this.forceValue));
        if (i7 >= 28) {
            checkBox2.setVisibility(0);
            textView4.setVisibility(0);
            if (this.forceValueEnabled) {
                textView3.setVisibility(0);
            }
        }
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.zi
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                SetBrightnessAction.Y(textView3, compoundButton, z4);
            }
        });
        int i8 = this.m_brightnessPercent;
        if (i8 == 999) {
            i6 = 50;
        } else {
            i6 = i8;
        }
        textView.setText(i6 + "%");
        try {
            this.m_brightnessToRestore = Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException unused) {
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(SelectableItem.r(R.string.use_slider_value));
        Activity activity2 = getActivity();
        Macro macro = getMacro();
        if (this.m_variable != null) {
            str = this.m_variable.getName() + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        } else {
            str = null;
        }
        int i9 = i6;
        VariableHelper.configureNumberVarSpinner(activity2, R.style.Theme_App_Dialog_Action, this, spinner, macro, arrayList, str, "", false, new a(viewGroup));
        if (this.workingVariable == null) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.aj
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                SetBrightnessAction.Z(spinner, seekBar, compoundButton, z4);
            }
        });
        if (this.m_brightnessPercent == 999) {
            z3 = true;
        } else {
            z3 = false;
        }
        switchCompat.setChecked(z3);
        spinner.setEnabled(!switchCompat.isChecked());
        seekBar.setEnabled(!switchCompat.isChecked());
        spinner.setOnTouchListener(new View.OnTouchListener() { // from class: com.arlosoft.macrodroid.action.bj
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean a02;
                a02 = SetBrightnessAction.this.a0(spinner, view, motionEvent);
                return a02;
            }
        });
        seekBar.setProgress(Math.round(i9));
        seekBar.setOnSeekBarChangeListener(new b(activity, textView));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.cj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetBrightnessAction.this.b0(switchCompat, seekBar, checkBox, checkBox2, textView3, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.dj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.arlosoft.macrodroid.action.ej
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SetBrightnessAction.this.d0(activity, dialogInterface);
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        int X;
        W();
        if (this.forceValueEnabled) {
            X = this.forceValue;
        } else {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 28 && this.m_forcePieMode) {
                int lookup = PieBrightnessLookup.lookup(this.m_brightnessPercent, false);
                if (i4 >= 31 && lookup == 0) {
                    X = 1;
                } else {
                    X = lookup;
                }
            } else {
                X = X(this.m_brightnessPercent);
            }
        }
        if (this.m_brightnessPercent == 999) {
            Settings.System.putInt(getContext().getContentResolver(), SCREEN_BRIGHTNESS_MODE, 1);
        } else {
            Settings.System.putInt(getContext().getContentResolver(), SCREEN_BRIGHTNESS_MODE, 0);
            MacroDroidVariable macroDroidVariable = this.m_variable;
            if (macroDroidVariable != null) {
                MacroDroidVariable variableByName = getVariableByName(macroDroidVariable.getName());
                if (variableByName == null) {
                    SystemLog.logError("Variable does not exist: " + this.m_variable.getName(), getMacroGuid().longValue());
                    return;
                }
                Long longValue = variableByName.getLongValue(this.varDictionaryKeys);
                if (longValue == null) {
                    SystemLog.logError("Variable does not exist: " + variableByName.getName() + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys), getMacroGuid().longValue());
                    return;
                } else if (this.forceValueEnabled) {
                    X = longValue.intValue();
                } else {
                    int intValue = longValue.intValue();
                    if (intValue < 0) {
                        intValue = 0;
                    }
                    if (intValue > 100) {
                        intValue = 100;
                    }
                    if (Build.VERSION.SDK_INT >= 28 && this.m_forcePieMode) {
                        X = PieBrightnessLookup.lookup(intValue, false);
                    } else {
                        X = X(intValue);
                    }
                }
            }
            try {
                Settings.System.putInt(getContext().getContentResolver(), "screen_brightness", X);
            } catch (Exception e4) {
                SystemLog.logError("Failed to set brightness: " + e4.toString(), getMacroGuid().longValue());
            }
        }
        Intent intent = new Intent();
        intent.setClass(getContext(), UpdateBrightnessActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(UpdateBrightnessActivity.BRIGHTNESS_EXTRA, X);
        getContext().startActivity(intent);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresWriteSettings() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_brightness);
        parcel.writeInt(this.m_brightnessPercent);
        parcel.writeParcelable(this.m_variable, i4);
        parcel.writeInt(this.m_forcePieMode ? 1 : 0);
        parcel.writeInt(this.forceValueEnabled ? 1 : 0);
        parcel.writeInt(this.forceValue);
        parcel.writeParcelable(this.varDictionaryKeys, i4);
    }

    public SetBrightnessAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private SetBrightnessAction() {
        this.m_brightnessToRestore = 0;
        this.m_minimumBrightness = 0;
        int i4 = this.m_brightness;
        if (i4 == 0) {
            this.m_brightnessPercent = 50;
        } else {
            this.m_brightnessPercent = V(i4);
            this.m_brightness = 0;
        }
        this.m_minimumBrightness = UIUtils.getMinimumScreenBrightnessSetting(getContext());
    }

    private SetBrightnessAction(Parcel parcel) {
        super(parcel);
        this.m_brightnessToRestore = 0;
        this.m_minimumBrightness = 0;
        this.m_brightness = parcel.readInt();
        this.m_brightnessPercent = parcel.readInt();
        this.m_variable = (MacroDroidVariable) parcel.readParcelable(MacroDroidVariable.class.getClassLoader());
        this.m_forcePieMode = parcel.readInt() != 0;
        this.forceValueEnabled = parcel.readInt() != 0;
        this.forceValue = parcel.readInt();
        this.varDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* loaded from: classes2.dex */
    class b implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f2489a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TextView f2490b;

        b(Activity activity, TextView textView) {
            this.f2489a = activity;
            this.f2490b = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            int X = SetBrightnessAction.this.X(i4);
            if (X == 0) {
                X = 1;
            }
            float f4 = X / 255.0f;
            try {
                WindowManager.LayoutParams attributes = this.f2489a.getWindow().getAttributes();
                attributes.screenBrightness = f4;
                this.f2489a.getWindow().setAttributes(attributes);
            } catch (NullPointerException unused) {
            }
            TextView textView = this.f2490b;
            textView.setText(i4 + "%");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
