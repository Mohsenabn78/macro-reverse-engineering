package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.PauseActionActivity;
import com.arlosoft.macrodroid.action.info.PauseActionInfo;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasVariable;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes2.dex */
public class PauseAction extends Action implements HasVariable, HasDictionaryKeys {
    public static final Parcelable.Creator<PauseAction> CREATOR = new a();
    public static final String DICTIONARY_KEYS_EXTRA = "DictionaryKeys";
    public static final String MILLI_SECONDS_EXTRA = "MilliSeconds";
    public static final String SECONDS_EXTRA = "Seconds";
    private static final int SET_DELAY = 1066;
    public static final String UNIT_FOR_VARS_EXTRA = "UnitForVars";
    public static final String USE_ALARM_EXTRA = "Alarm";
    public static final String VARIABLE_EXTRA = "Variable";
    public static final int VARIABLE_USE_MINUTES = 1;
    public static final int VARIABLE_USE_SECONDS = 0;
    private int m_delayInMilliSeconds;
    private int m_delayInSeconds;
    private boolean m_useAlarm;
    private MacroDroidVariable m_variable;
    private int unitForVariables;
    private DictionaryKeys varDictionaryKeys;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<PauseAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PauseAction createFromParcel(Parcel parcel) {
            return new PauseAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PauseAction[] newArray(int i4) {
            return new PauseAction[i4];
        }
    }

    /* synthetic */ PauseAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        String str;
        String str2;
        String r4;
        String r5 = SelectableItem.r(R.string.wait_duration_parameter);
        if (this.m_variable != null) {
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append(SelectableItem.r(R.string.variable_short_name));
            sb.append(": ");
            sb.append(this.m_variable.getName());
            sb.append(VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys));
            sb.append(" (");
            if (this.unitForVariables == 0) {
                r4 = SelectableItem.r(R.string.seconds);
            } else {
                r4 = SelectableItem.r(R.string.minutes);
            }
            sb.append(r4);
            sb.append(")");
            objArr[0] = sb.toString();
            return String.format(r5, objArr);
        }
        int i4 = this.m_delayInSeconds;
        if (i4 < 1) {
            return String.format(r5, this.m_delayInMilliSeconds + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.milliseconds_capital).toLowerCase());
        }
        String str3 = "";
        if (i4 == 1) {
            Object[] objArr2 = new Object[1];
            StringBuilder sb2 = new StringBuilder();
            sb2.append("1 ");
            sb2.append(SelectableItem.r(R.string.second));
            if (this.m_delayInMilliSeconds != 0) {
                str3 = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_delayInMilliSeconds + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.milliseconds_capital).toLowerCase();
            }
            sb2.append(str3);
            objArr2[0] = sb2.toString();
            return String.format(r5, objArr2);
        } else if (i4 < 60) {
            Object[] objArr3 = new Object[1];
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.m_delayInSeconds);
            sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb3.append(SelectableItem.r(R.string.seconds));
            if (this.m_delayInMilliSeconds != 0) {
                str3 = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_delayInMilliSeconds + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.milliseconds_capital).toLowerCase();
            }
            sb3.append(str3);
            objArr3[0] = sb3.toString();
            return String.format(r5, objArr3);
        } else if (i4 < 120) {
            int i5 = i4 % 60;
            Object[] objArr4 = new Object[1];
            StringBuilder sb4 = new StringBuilder();
            sb4.append("1 ");
            sb4.append(SelectableItem.r(R.string.minute));
            if (i5 != 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                if (i5 != 1) {
                    str2 = i5 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.seconds);
                } else {
                    str2 = "1 " + SelectableItem.r(R.string.second);
                }
                sb5.append(str2);
                str3 = sb5.toString();
            }
            sb4.append(str3);
            objArr4[0] = sb4.toString();
            return String.format(r5, objArr4);
        } else {
            int i6 = i4 % 60;
            Object[] objArr5 = new Object[1];
            StringBuilder sb6 = new StringBuilder();
            sb6.append(this.m_delayInSeconds / 60);
            sb6.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb6.append(SelectableItem.r(R.string.minutes));
            if (i6 != 0) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                if (i6 != 1) {
                    str = i6 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.seconds);
                } else {
                    str = "1 " + SelectableItem.r(R.string.second);
                }
                sb7.append(str);
                str3 = sb7.toString();
            }
            sb6.append(str3);
            objArr5[0] = sb6.toString();
            return String.format(r5, objArr5);
        }
    }

    public int getDelayInMilliseconds() {
        return (this.m_delayInSeconds * 1000) + this.m_delayInMilliSeconds;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    @Nullable
    public DictionaryKeys getDictionaryKeys() {
        return this.varDictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return PauseActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 31) {
            return new String[0];
        }
        return super.getPermissions();
    }

    public int getUnitForVariables() {
        return this.unitForVariables;
    }

    public boolean getUseAlarm() {
        return this.m_useAlarm;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariable
    public MacroDroidVariable getVariable() {
        return this.m_variable;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == SET_DELAY && i5 == -1) {
            this.unitForVariables = intent.getIntExtra(UNIT_FOR_VARS_EXTRA, 0);
            this.m_variable = (MacroDroidVariable) intent.getParcelableExtra("Variable");
            this.m_delayInSeconds = intent.getIntExtra("Seconds", 0);
            this.m_delayInMilliSeconds = intent.getIntExtra(MILLI_SECONDS_EXTRA, 0);
            this.m_useAlarm = intent.getBooleanExtra(USE_ALARM_EXTRA, false);
            this.varDictionaryKeys = (DictionaryKeys) intent.getParcelableExtra(DICTIONARY_KEYS_EXTRA);
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (!checkActivityAlive()) {
            return;
        }
        Activity activity = getActivity();
        Intent intent = new Intent(activity, PauseActionActivity.class);
        intent.putExtra(UNIT_FOR_VARS_EXTRA, this.unitForVariables);
        intent.putExtra("Seconds", this.m_delayInSeconds);
        intent.putExtra("Variable", this.m_variable);
        intent.putExtra(MILLI_SECONDS_EXTRA, this.m_delayInMilliSeconds);
        intent.putExtra(USE_ALARM_EXTRA, this.m_useAlarm);
        intent.putExtra("Seconds", this.m_delayInSeconds);
        intent.putExtra(DICTIONARY_KEYS_EXTRA, this.varDictionaryKeys);
        if (MacroStore.getInstance().getMacroByGUID(getMacro().getGUID()) != null) {
            intent.putExtra(Constants.EXTRA_MACRO_GUID, getMacro().getGUID());
        } else {
            intent.putExtra("Macro", getMacro());
        }
        intent.putExtra("selectable_item", this);
        activity.startActivityForResult(intent, SET_DELAY);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresScheduleExactAlarm() {
        return true;
    }

    public void setDelay(int i4) {
        this.m_delayInSeconds = i4;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    public void setDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        this.varDictionaryKeys = dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_delayInSeconds);
        parcel.writeInt(this.m_delayInMilliSeconds);
        parcel.writeParcelable(this.m_variable, i4);
        parcel.writeInt(this.m_useAlarm ? 1 : 0);
        parcel.writeInt(this.unitForVariables);
        parcel.writeParcelable(this.varDictionaryKeys, i4);
    }

    public PauseAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public PauseAction() {
        this.m_useAlarm = true;
        this.m_delayInSeconds = 1;
    }

    private PauseAction(Parcel parcel) {
        super(parcel);
        this.m_useAlarm = true;
        this.m_delayInSeconds = parcel.readInt();
        this.m_delayInMilliSeconds = parcel.readInt();
        this.m_variable = (MacroDroidVariable) parcel.readParcelable(MacroDroidVariable.class.getClassLoader());
        this.m_useAlarm = parcel.readInt() != 0;
        this.unitForVariables = parcel.readInt();
        this.varDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
    }
}
