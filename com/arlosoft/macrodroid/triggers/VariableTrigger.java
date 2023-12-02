package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.VariableUpdatedListener;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.interfaces.HasMultipleDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasVariables;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.info.VariableTriggerInfo;
import com.arlosoft.macrodroid.utils.ExpressionUtils;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.arlosoft.macrodroid.utils.MathsUtils;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class VariableTrigger extends Trigger implements HasVariables, SupportsMagicText, HasMultipleDictionaryKeys {
    public static final Parcelable.Creator<VariableTrigger> CREATOR = new f();
    private static final int DICTIONARY_OR_ARRAY_TYPE_NOT_SET = -1;
    private static final int STRING_CONTAINS = 1;
    private static final int STRING_EQUALITY_CHECK = 0;
    private static final int STRING_EXCLUDES = 2;
    private static int s_triggerCounter;
    private static g s_updateListener;
    private boolean checkCase;
    private DictionaryKeys compareVarDictionaryKeys;
    private DictionaryKeys dictionaryKeys;
    private int dictionaryType;
    private boolean enableRegex;
    private boolean m_anyValueChange;
    private boolean m_booleanValue;
    private double m_doubleValue;
    private String m_expression;
    private boolean m_intCompareVariable;
    private boolean m_intGreaterThan;
    private boolean m_intLessThan;
    private boolean m_intNotEqual;
    private long m_intValue;
    private MacroDroidVariable m_otherValueToCompare;
    private transient int m_selectedIndex;
    private int m_stringComparisonType;
    private boolean m_stringEqual;
    private String m_stringValue;
    private MacroDroidVariable m_variable;
    private DictionaryKeys workingCompareVarDictionaryKeys;
    private MacroDroidVariable workingOtherVarToCompare;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CheckBox f14439a;

        b(CheckBox checkBox) {
            this.f14439a = checkBox;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            this.f14439a.setEnabled(!z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements VariableHelper.VariableSelectedListener {
        e() {
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void customItemSelected(int i4, @NonNull String str) {
            VariableTrigger.this.workingOtherVarToCompare = null;
            VariableTrigger.this.workingCompareVarDictionaryKeys = null;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void variableSelected(@NonNull MacroDroidVariable macroDroidVariable, List<String> list) {
            DictionaryKeys dictionaryKeys;
            VariableTrigger.this.workingOtherVarToCompare = macroDroidVariable;
            VariableTrigger variableTrigger = VariableTrigger.this;
            if (list != null) {
                dictionaryKeys = new DictionaryKeys(list);
            } else {
                dictionaryKeys = null;
            }
            variableTrigger.workingCompareVarDictionaryKeys = dictionaryKeys;
        }
    }

    /* loaded from: classes3.dex */
    class f implements Parcelable.Creator<VariableTrigger> {
        f() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public VariableTrigger createFromParcel(Parcel parcel) {
            return new VariableTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public VariableTrigger[] newArray(int i4) {
            return new VariableTrigger[i4];
        }
    }

    /* loaded from: classes3.dex */
    private static class g implements VariableUpdatedListener {

        /* renamed from: a  reason: collision with root package name */
        private Context f14447a;

        public g(Context context) {
            this.f14447a = context;
        }

        private boolean a(@NonNull VariableTrigger variableTrigger, @NonNull Macro macro, @NonNull ArrayList<Macro> arrayList, @NonNull VariableValue.BooleanValue booleanValue, long j4) {
            if (variableTrigger.y0() && variableTrigger.constraintsMet()) {
                macro.setTriggerThatInvoked(variableTrigger);
                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                    arrayList.add(macro);
                    return true;
                }
                return false;
            } else if (variableTrigger.z0() == booleanValue.getBooleanValue() && variableTrigger.constraintsMet()) {
                macro.setTriggerThatInvoked(variableTrigger);
                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                    arrayList.add(macro);
                    return true;
                }
                return false;
            } else {
                return false;
            }
        }

        private boolean b(@NonNull VariableTrigger variableTrigger, @NonNull Macro macro, @NonNull ArrayList<Macro> arrayList, @NonNull VariableValue.DecimalValue decimalValue, @NonNull VariableValue.DecimalValue decimalValue2, long j4) {
            boolean z3;
            if (variableTrigger.y0() && variableTrigger.constraintsMet()) {
                macro.setTriggerThatInvoked(variableTrigger);
                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                    arrayList.add(macro);
                    return true;
                }
            }
            double A0 = variableTrigger.A0();
            String expression = variableTrigger.getExpression();
            if (variableTrigger.y0() && variableTrigger.constraintsMet()) {
                macro.setTriggerThatInvoked(variableTrigger);
                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                    arrayList.add(macro);
                    return true;
                }
            }
            ArrayList<String> arrayList2 = null;
            if (expression != null) {
                try {
                    A0 = ExpressionUtils.calculateExpression(MacroDroidApplication.getInstance(), macro, expression, null);
                } catch (IllegalArgumentException e4) {
                    SystemLog.logError("Variable trigger, expression evaluation failed: " + e4, variableTrigger.getMacroGuid().longValue());
                    A0 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                }
            }
            if (variableTrigger.C0() && variableTrigger.I0() != null) {
                MacroDroidVariable variableByName = variableTrigger.getVariableByName(variableTrigger.I0().getName());
                if (variableByName != null) {
                    if (variableTrigger.dictionaryKeys != null) {
                        arrayList2 = VariableHelper.applyMagicTextToDictionaryKeys(this.f14447a, variableTrigger.dictionaryKeys.getKeys(), macro.getTriggerContextInfo(), macro);
                    }
                    Double decimalValue3 = variableByName.getDecimalValue(arrayList2);
                    if (decimalValue3 != null) {
                        A0 = decimalValue3.doubleValue();
                    } else {
                        SystemLog.logError("Variable trigger, variable not found: " + variableTrigger.I0().getName() + VariableHelper.getFormattedDictionaryKeys(variableTrigger.compareVarDictionaryKeys), variableTrigger.getMacroGuid().longValue());
                    }
                } else {
                    SystemLog.logError("Variable trigger, variable not found: " + variableTrigger.I0().getName(), variableTrigger.getMacroGuid().longValue());
                    return false;
                }
            }
            if (!variableTrigger.D0() ? !(!variableTrigger.E0() ? !variableTrigger.F0() ? !MathsUtils.areDecimalsEqual(decimalValue.getDecimalValue(), A0) : MathsUtils.areDecimalsEqual(decimalValue.getDecimalValue(), A0) : decimalValue.getDecimalValue() >= A0 || decimalValue2.getDecimalValue() < A0) : !(decimalValue.getDecimalValue() <= A0 || decimalValue2.getDecimalValue() > A0)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3 || !variableTrigger.constraintsMet()) {
                return false;
            }
            macro.setTriggerThatInvoked(variableTrigger);
            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                arrayList.add(macro);
            }
            return true;
        }

        private boolean c(@NonNull VariableTrigger variableTrigger, @NonNull Macro macro, @NonNull ArrayList<Macro> arrayList, @NonNull VariableValue.IntegerValue integerValue, @NonNull VariableValue.IntegerValue integerValue2, long j4) {
            boolean z3;
            if (variableTrigger.y0() && variableTrigger.constraintsMet()) {
                macro.setTriggerThatInvoked(variableTrigger);
                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                    arrayList.add(macro);
                    return true;
                }
            }
            long G0 = variableTrigger.G0();
            String expression = variableTrigger.getExpression();
            ArrayList<String> arrayList2 = null;
            if (expression != null) {
                try {
                    G0 = (int) ExpressionUtils.calculateExpression(MacroDroidApplication.getInstance(), macro, expression, null);
                } catch (IllegalArgumentException unused) {
                    SystemLog.logError("Variable constraint checking not working, expression evaluation failed");
                    G0 = 0;
                }
            } else if (variableTrigger.C0() && variableTrigger.I0() != null) {
                MacroDroidVariable variableByName = variableTrigger.getVariableByName(variableTrigger.I0().getName());
                if (variableByName != null) {
                    if (variableTrigger.dictionaryKeys != null) {
                        arrayList2 = VariableHelper.applyMagicTextToDictionaryKeys(this.f14447a, variableTrigger.dictionaryKeys.getKeys(), macro.getTriggerContextInfo(), macro);
                    }
                    Long longValue = variableByName.getLongValue(arrayList2);
                    if (longValue != null) {
                        G0 = longValue.longValue();
                    } else {
                        SystemLog.logError("Variable trigger, variable not found: " + variableTrigger.I0().getName() + VariableHelper.getFormattedDictionaryKeys(variableTrigger.compareVarDictionaryKeys), variableTrigger.getMacroGuid().longValue());
                    }
                } else {
                    SystemLog.logError("Variable trigger, variable not found: " + variableTrigger.I0().getName(), variableTrigger.getMacroGuid().longValue());
                    return false;
                }
            }
            if (!variableTrigger.D0() ? !(!variableTrigger.E0() ? !variableTrigger.F0() ? integerValue.getIntValue() != G0 : integerValue.getIntValue() == G0 : integerValue.getIntValue() >= G0 || integerValue2.getIntValue() < G0) : !(integerValue.getIntValue() <= G0 || integerValue2.getIntValue() > G0)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3 || !variableTrigger.constraintsMet()) {
                return false;
            }
            macro.setTriggerThatInvoked(variableTrigger);
            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                arrayList.add(macro);
            }
            return true;
        }

        private boolean d(@NonNull VariableTrigger variableTrigger, @NonNull Macro macro, @NonNull ArrayList<Macro> arrayList, @NonNull VariableValue variableValue, @NonNull VariableValue variableValue2, long j4) {
            if (variableValue instanceof VariableValue.BooleanValue) {
                return a(variableTrigger, macro, arrayList, (VariableValue.BooleanValue) variableValue, j4);
            }
            if (variableValue instanceof VariableValue.StringValue) {
                return e(variableTrigger, macro, arrayList, (VariableValue.StringValue) variableValue, j4);
            }
            if (variableValue instanceof VariableValue.DecimalValue) {
                return b(variableTrigger, macro, arrayList, (VariableValue.DecimalValue) variableValue, (VariableValue.DecimalValue) variableValue2, j4);
            }
            if (variableValue instanceof VariableValue.IntegerValue) {
                return c(variableTrigger, macro, arrayList, (VariableValue.IntegerValue) variableValue, (VariableValue.IntegerValue) variableValue2, j4);
            }
            return false;
        }

        private boolean e(@NonNull VariableTrigger variableTrigger, @NonNull Macro macro, @NonNull ArrayList<Macro> arrayList, @NonNull VariableValue.StringValue stringValue, long j4) {
            if (variableTrigger.y0() && variableTrigger.constraintsMet()) {
                macro.setTriggerThatInvoked(variableTrigger);
                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                    arrayList.add(macro);
                    return true;
                }
            }
            String replaceMagicText = MagicText.replaceMagicText(this.f14447a, variableTrigger.L0(), null, macro);
            String regexPattern = WildCardHelper.getRegexPattern(replaceMagicText, variableTrigger.enableRegex, !variableTrigger.checkCase);
            String regexContainsPattern = WildCardHelper.getRegexContainsPattern(replaceMagicText, variableTrigger.enableRegex, !variableTrigger.checkCase);
            String textValue = stringValue.getTextValue();
            if (variableTrigger.J0() == 0) {
                if (variableTrigger.K0()) {
                    if (WildCardHelper.matches(textValue, regexPattern, variableTrigger.enableRegex, !variableTrigger.checkCase) && variableTrigger.constraintsMet()) {
                        macro.setTriggerThatInvoked(variableTrigger);
                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                            arrayList.add(macro);
                        }
                        return true;
                    }
                    return false;
                } else if (!WildCardHelper.matches(textValue, regexPattern, variableTrigger.enableRegex, !variableTrigger.checkCase) && variableTrigger.constraintsMet()) {
                    macro.setTriggerThatInvoked(variableTrigger);
                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                        arrayList.add(macro);
                    }
                    return true;
                } else {
                    return false;
                }
            } else if (variableTrigger.J0() == 1) {
                if (WildCardHelper.matches(textValue, regexContainsPattern, variableTrigger.enableRegex, !variableTrigger.checkCase) && variableTrigger.constraintsMet()) {
                    macro.setTriggerThatInvoked(variableTrigger);
                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                        arrayList.add(macro);
                    }
                    return true;
                }
                return false;
            } else if (variableTrigger.J0() == 2 && !WildCardHelper.matches(textValue, regexContainsPattern, variableTrigger.enableRegex, !variableTrigger.checkCase) && variableTrigger.constraintsMet()) {
                macro.setTriggerThatInvoked(variableTrigger);
                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                    arrayList.add(macro);
                }
                return true;
            } else {
                return false;
            }
        }

        private boolean f(@Nullable List<String> list, @Nullable List<String> list2) {
            if (list == null && (list2 == null || list2.isEmpty())) {
                return true;
            }
            if (list2 == null && list.isEmpty()) {
                return true;
            }
            if (list != null && list.equals(list2)) {
                return true;
            }
            return false;
        }

        @Override // com.arlosoft.macrodroid.common.VariableUpdatedListener
        public void variableValueUpdated(@NonNull MacroDroidVariable macroDroidVariable, @NonNull VariableValue variableValue, @NonNull VariableValue variableValue2, long j4) {
            VariableValue variableValue3;
            ArrayList<String> arrayList;
            VariableValue variableValue4 = variableValue;
            if (variableValue2 instanceof VariableValue.Empty) {
                return;
            }
            if (variableValue4 instanceof VariableValue.DictionaryEntry) {
                variableValue4 = ((VariableValue.DictionaryEntry) variableValue4).getVariable();
            }
            VariableValue variableValue5 = variableValue4;
            if (variableValue2 instanceof VariableValue.DictionaryEntry) {
                variableValue3 = ((VariableValue.DictionaryEntry) variableValue2).getVariable();
            } else {
                variableValue3 = variableValue2;
            }
            ArrayList<Macro> arrayList2 = new ArrayList<>();
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                if (!macroDroidVariable.isLocalVar() || j4 == macro.getGUID()) {
                    Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                    while (it.hasNext()) {
                        Trigger next = it.next();
                        if (next instanceof VariableTrigger) {
                            VariableTrigger variableTrigger = (VariableTrigger) next;
                            if (variableTrigger.dictionaryKeys != null) {
                                if (variableTrigger.dictionaryKeys == null) {
                                    arrayList = new ArrayList<>();
                                } else {
                                    arrayList = VariableHelper.applyMagicTextToDictionaryKeys(this.f14447a, variableTrigger.dictionaryKeys.getKeys(), macro.getTriggerContextInfo(), macro);
                                }
                            } else {
                                arrayList = new ArrayList<>();
                            }
                            if (macroDroidVariable.getName().equals(variableTrigger.getVariable().getName()) && f(variableValue5.getParentKeys(), arrayList) && d(variableTrigger, macro, arrayList2, variableValue5, variableValue3, j4)) {
                                break;
                            }
                        }
                    }
                }
            }
            Iterator<Macro> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Macro next2 = it2.next();
                next2.invokeActions(next2.getTriggerContextInfo());
            }
        }
    }

    /* synthetic */ VariableTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double A0() {
        return this.m_doubleValue;
    }

    private String B0(int i4) {
        StringBuilder sb;
        StringBuilder sb2;
        if (this.m_anyValueChange) {
            return "(" + SelectableItem.r(R.string.trigger_variable_any_change) + ")";
        } else if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        String str = this.m_expression;
                        if (str == null) {
                            if (this.m_intCompareVariable) {
                                sb2 = new StringBuilder();
                                sb2.append(this.m_otherValueToCompare.getName());
                                sb2.append(VariableHelper.getFormattedDictionaryKeys(this.workingCompareVarDictionaryKeys));
                            } else {
                                sb2 = new StringBuilder();
                                sb2.append("");
                                sb2.append(this.m_doubleValue);
                            }
                            str = sb2.toString();
                        }
                        if (this.m_intGreaterThan) {
                            return "> " + str;
                        } else if (this.m_intLessThan) {
                            return "< " + str;
                        } else if (this.m_intNotEqual) {
                            return "!= " + str;
                        } else {
                            return "= " + str;
                        }
                    }
                } else {
                    int i5 = this.m_stringComparisonType;
                    if (i5 == 0) {
                        if (this.m_stringEqual) {
                            return "= " + this.m_stringValue;
                        }
                        return "!= " + this.m_stringValue;
                    } else if (i5 == 1) {
                        return SelectableItem.r(R.string.contains).toLowerCase() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_stringValue;
                    } else if (i5 == 2) {
                        return SelectableItem.r(R.string.excludes).toLowerCase() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_stringValue;
                    }
                }
                return "";
            }
            String str2 = this.m_expression;
            if (str2 == null) {
                if (this.m_intCompareVariable) {
                    sb = new StringBuilder();
                    sb.append(this.m_otherValueToCompare.getName());
                    sb.append(VariableHelper.getFormattedDictionaryKeys(this.workingCompareVarDictionaryKeys));
                } else {
                    sb = new StringBuilder();
                    sb.append("");
                    sb.append(this.m_intValue);
                }
                str2 = sb.toString();
            }
            if (this.m_intGreaterThan) {
                return "> " + str2;
            } else if (this.m_intLessThan) {
                return "< " + str2;
            } else if (this.m_intNotEqual) {
                return "!= " + str2;
            } else {
                return "= " + str2;
            }
        } else {
            return "= " + this.m_booleanValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C0() {
        return this.m_intCompareVariable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D0() {
        return this.m_intGreaterThan;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E0() {
        return this.m_intLessThan;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F0() {
        return this.m_intNotEqual;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long G0() {
        return this.m_intValue;
    }

    private boolean H0(boolean z3, boolean z4, boolean z5, String str, String str2) {
        if (z4) {
            return true;
        }
        if (z3) {
            return !TextUtils.isEmpty(str);
        }
        try {
            ExpressionUtils.calculateExpression(getContext(), getMacro(), str2, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MacroDroidVariable I0() {
        return this.m_otherValueToCompare;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int J0() {
        return this.m_stringComparisonType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K0() {
        return this.m_stringEqual;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String L0() {
        return this.m_stringValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(DialogInterface dialogInterface, int i4) {
        boolean z3 = true;
        if (i4 != 1) {
            z3 = false;
        }
        this.m_anyValueChange = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(int i4, ArrayList arrayList, DialogInterface dialogInterface, int i5) {
        if (this.m_anyValueChange) {
            this.dictionaryType = i4;
            this.dictionaryKeys = new DictionaryKeys(arrayList);
            itemComplete();
            return;
        }
        x0(i4, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(Spinner spinner, RadioButton radioButton, RadioButton radioButton2, EditText editText, Button button, LinearLayout linearLayout, EditText editText2, Button button2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            v0(spinner);
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            editText.setEnabled(false);
            button.setEnabled(false);
            linearLayout.setVisibility(8);
            editText2.setEnabled(false);
            spinner.setVisibility(0);
            button2.setEnabled(H0(radioButton.isChecked(), radioButton3.isChecked(), radioButton2.isChecked(), editText2.getText().toString(), editText.getText().toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(RadioButton radioButton, EditText editText, RadioButton radioButton2, EditText editText2, Button button, LinearLayout linearLayout, Spinner spinner, Button button2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            editText.setEnabled(false);
            radioButton2.setChecked(false);
            editText2.setEnabled(false);
            button.setEnabled(false);
            linearLayout.setVisibility(8);
            spinner.setVisibility(8);
            editText.setEnabled(true);
            button2.setEnabled(H0(radioButton3.isChecked(), radioButton.isChecked(), radioButton2.isChecked(), editText.getText().toString(), editText2.getText().toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(RadioButton radioButton, EditText editText, RadioButton radioButton2, Spinner spinner, EditText editText2, Button button, LinearLayout linearLayout, Button button2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            editText.setEnabled(false);
            radioButton2.setChecked(false);
            spinner.setVisibility(8);
            editText2.setEnabled(true);
            button.setEnabled(true);
            linearLayout.setVisibility(0);
            button2.setEnabled(H0(radioButton.isChecked(), radioButton2.isChecked(), radioButton3.isChecked(), editText.getText().toString(), editText2.getText().toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displayNumberVariableSelectionDialog(activity, getMacro(), magicTextListener, R.style.Theme_App_Dialog_Trigger_SmallText, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(Spinner spinner, int i4, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, EditText editText, EditText editText2, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, RadioButton radioButton9, RadioButton radioButton10, EditText editText3, CheckBox checkBox, CheckBox checkBox2, ArrayList arrayList, AppCompatDialog appCompatDialog, View view) {
        Math.max(0, spinner.getSelectedItemPosition());
        if (i4 != 0) {
            if (i4 == 1) {
                this.m_intGreaterThan = radioButton2.isChecked();
                this.m_intLessThan = radioButton3.isChecked();
                this.m_intNotEqual = radioButton4.isChecked();
                this.m_expression = radioButton5.isChecked() ? editText.getText().toString() : null;
                if (editText2.length() > 0) {
                    this.m_intValue = Long.valueOf(editText2.getText().toString()).longValue();
                } else {
                    this.m_intValue = 0L;
                }
                boolean isChecked = radioButton6.isChecked();
                this.m_intCompareVariable = isChecked;
                if (isChecked) {
                    this.m_otherValueToCompare = this.workingOtherVarToCompare;
                    this.compareVarDictionaryKeys = this.workingCompareVarDictionaryKeys;
                }
            } else if (i4 == 2) {
                if (!radioButton7.isChecked() && !radioButton8.isChecked()) {
                    if (radioButton9.isChecked()) {
                        this.m_stringComparisonType = 1;
                    } else if (radioButton10.isChecked()) {
                        this.m_stringComparisonType = 2;
                    }
                } else {
                    this.m_stringComparisonType = 0;
                    this.m_stringEqual = radioButton7.isChecked();
                }
                this.m_stringValue = editText3.getText().toString();
            } else if (i4 == 3) {
                this.m_intGreaterThan = radioButton2.isChecked();
                this.m_intLessThan = radioButton3.isChecked();
                this.m_intNotEqual = radioButton4.isChecked();
                this.m_expression = radioButton5.isChecked() ? editText.getText().toString() : null;
                if (editText2.length() > 0) {
                    this.m_doubleValue = Double.valueOf(editText2.getText().toString()).doubleValue();
                } else {
                    this.m_doubleValue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                }
                boolean isChecked2 = radioButton6.isChecked();
                this.m_intCompareVariable = isChecked2;
                if (isChecked2) {
                    this.m_otherValueToCompare = this.workingOtherVarToCompare;
                    this.compareVarDictionaryKeys = this.workingCompareVarDictionaryKeys;
                }
            }
        } else {
            this.m_booleanValue = radioButton.isChecked();
        }
        this.checkCase = true ^ checkBox.isChecked();
        this.enableRegex = checkBox2.isChecked();
        this.dictionaryType = i4;
        this.dictionaryKeys = new DictionaryKeys(arrayList);
        appCompatDialog.dismiss();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Trigger_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0(MacroDroidVariable macroDroidVariable, VariableValue.Dictionary dictionary, ArrayList<String> arrayList, int i4) {
        String str;
        DictionaryKeys dictionaryKeys = this.dictionaryKeys;
        List<String> list = null;
        if (dictionaryKeys != null && dictionaryKeys.getKeys().size() > i4) {
            str = this.dictionaryKeys.getKeys().get(i4);
        } else {
            str = null;
        }
        Activity activity = getActivity();
        DictionaryKeys dictionaryKeys2 = this.dictionaryKeys;
        if (dictionaryKeys2 != null) {
            list = dictionaryKeys2.getKeys();
        }
        VariableHelper.showSelectKeyDialog(activity, R.style.Theme_App_Dialog_Action, dictionary, null, str, true, new VariableHelper.ManualKeyOption(true, list), false, VariableHelper.ShowThisDictionaryOption.DONT_SHOW, true, new a(macroDroidVariable, dictionary, arrayList, i4));
    }

    private void v0(Spinner spinner) {
        String str;
        Activity activity = getActivity();
        Macro macro = getMacro();
        ArrayList arrayList = new ArrayList();
        if (this.workingOtherVarToCompare != null) {
            str = this.workingOtherVarToCompare.getName() + VariableHelper.getFormattedDictionaryKeys(this.workingCompareVarDictionaryKeys);
        } else {
            str = null;
        }
        VariableHelper.configureNumberVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro, arrayList, str, "", false, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(final int i4, final ArrayList<String> arrayList) {
        String[] strArr = {getContext().getResources().getString(R.string.trigger_variable_specific_change), getContext().getResources().getString(R.string.trigger_variable_any_change)};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_option);
        builder.setSingleChoiceItems(strArr, this.m_anyValueChange ? 1 : 0, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.u8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                VariableTrigger.this.M0(dialogInterface, i5);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.y8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                VariableTrigger.this.N0(dialogInterface, i5);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.z8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                VariableTrigger.this.O0(i4, arrayList, dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.triggers.a9
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                VariableTrigger.this.P0(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x04fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void x0(final int r55, final java.util.ArrayList<java.lang.String> r56) {
        /*
            Method dump skipped, instructions count: 1430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.VariableTrigger.x0(int, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y0() {
        return this.m_anyValueChange;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z0() {
        return this.m_booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_selectedIndex = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        s_triggerCounter--;
        Macro macro = this.m_macro;
        if (macro != null) {
            macro.removeLocalVariableUpdatedListener(s_updateListener);
        }
        if (s_triggerCounter == 0) {
            s_updateListener = null;
            MacroDroidVariableStore.getInstance().setVariableUpdatedListener(null);
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_updateListener = new g(getContext());
            MacroDroidVariableStore.getInstance().setVariableUpdatedListener(s_updateListener);
        }
        Macro macro = this.m_macro;
        if (macro != null) {
            macro.addLocalVariableUpdatedListener(s_updateListener);
        } else {
            SystemLog.logError("Variable trigger, macro is null", getMacroGuid().longValue());
        }
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        ArrayList<MacroDroidVariable> allVariables = getAllVariables();
        if (this.m_variable != null) {
            for (int i4 = 0; i4 < allVariables.size(); i4++) {
                if (allVariables.get(i4).getName().equals(this.m_variable.getName())) {
                    this.m_selectedIndex = i4;
                    return i4;
                }
            }
        }
        return 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredNameFlowControl() {
        return getExtendedDetail();
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasMultipleDictionaryKeys
    @NonNull
    public DictionaryKeys[] getDictionaryKeys() {
        return new DictionaryKeys[]{this.dictionaryKeys, this.compareVarDictionaryKeys};
    }

    public String getExpression() {
        return this.m_expression;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        MacroDroidVariable macroDroidVariable = this.m_variable;
        if (macroDroidVariable != null) {
            int type = macroDroidVariable.getType();
            if (type != 4 && type != 5) {
                return this.m_variable.getName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + B0(this.m_variable.getType());
            }
            return this.m_variable.getName() + VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + B0(this.dictionaryType);
        }
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return VariableTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        if (this.m_anyValueChange) {
            return getConfiguredName() + " (" + SelectableItem.r(R.string.any) + ")";
        }
        return getConfiguredName() + " (" + MDTextUtils.truncateIfRequired(getExtendedDetail(), 20) + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_stringValue, this.m_expression};
    }

    public MacroDroidVariable getVariable() {
        return this.m_variable;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariables
    public List<MacroDroidVariable> getVariables() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.m_variable);
        if (this.m_intCompareVariable) {
            arrayList.add(this.m_otherValueToCompare);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        String[] o4 = o();
        if (o4 != null && o4.length > 0) {
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        ArrayList<MacroDroidVariable> allVariables = getAllVariables();
        if (allVariables.size() > 0) {
            String[] strArr = new String[allVariables.size()];
            for (int i4 = 0; i4 < allVariables.size(); i4++) {
                strArr[i4] = allVariables.get(i4).getName();
            }
            return strArr;
        }
        ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) SelectableItem.r(R.string.trigger_variable_no_variables), 1).show();
        return new String[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return SelectableItem.r(R.string.trigger_variable_select);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        MacroDroidVariable macroDroidVariable = getAllVariables().get(this.m_selectedIndex);
        this.m_variable = macroDroidVariable;
        int type = macroDroidVariable.getType();
        if (type != 4 && type != 5) {
            w0(this.m_variable.getType(), new ArrayList<>());
            return;
        }
        MacroDroidVariable macroDroidVariable2 = this.m_variable;
        Z0(macroDroidVariable2, macroDroidVariable2.getDictionary(), new ArrayList<>(), 0);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasMultipleDictionaryKeys
    public void setDictionaryKeys(@NonNull DictionaryKeys[] dictionaryKeysArr) {
        if (dictionaryKeysArr.length >= 2) {
            this.dictionaryKeys = dictionaryKeysArr[0];
            this.compareVarDictionaryKeys = dictionaryKeysArr[1];
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 2) {
            this.m_stringValue = strArr[0];
            this.m_expression = strArr[1];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeParcelable(this.m_variable, i4);
        parcel.writeLong(this.m_intValue);
        parcel.writeParcelable(this.m_otherValueToCompare, i4);
        parcel.writeInt(this.m_intGreaterThan ? 1 : 0);
        parcel.writeInt(this.m_intLessThan ? 1 : 0);
        parcel.writeInt(this.m_intNotEqual ? 1 : 0);
        parcel.writeInt(this.m_intCompareVariable ? 1 : 0);
        parcel.writeInt(this.m_booleanValue ? 1 : 0);
        parcel.writeString(this.m_stringValue);
        parcel.writeInt(this.m_stringEqual ? 1 : 0);
        parcel.writeInt(this.m_anyValueChange ? 1 : 0);
        parcel.writeDouble(this.m_doubleValue);
        parcel.writeInt(this.m_stringComparisonType);
        parcel.writeString(this.m_expression);
        parcel.writeInt(this.enableRegex ? 1 : 0);
        parcel.writeInt(this.checkCase ? 1 : 0);
        parcel.writeInt(this.dictionaryType);
        parcel.writeParcelable(this.dictionaryKeys, i4);
        parcel.writeParcelable(this.compareVarDictionaryKeys, i4);
    }

    public VariableTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private VariableTrigger() {
        this.compareVarDictionaryKeys = null;
        this.dictionaryType = -1;
        this.m_stringEqual = true;
        this.m_anyValueChange = false;
        this.m_stringValue = "";
    }

    private VariableTrigger(Parcel parcel) {
        super(parcel);
        this.compareVarDictionaryKeys = null;
        this.dictionaryType = -1;
        this.m_variable = (MacroDroidVariable) parcel.readParcelable(MacroDroidVariable.class.getClassLoader());
        this.m_intValue = parcel.readLong();
        this.m_otherValueToCompare = (MacroDroidVariable) parcel.readParcelable(MacroDroidVariable.class.getClassLoader());
        this.m_intGreaterThan = parcel.readInt() != 0;
        this.m_intLessThan = parcel.readInt() != 0;
        this.m_intNotEqual = parcel.readInt() != 0;
        this.m_intCompareVariable = parcel.readInt() != 0;
        this.m_booleanValue = parcel.readInt() != 0;
        this.m_stringValue = parcel.readString();
        this.m_stringEqual = parcel.readInt() != 0;
        this.m_anyValueChange = parcel.readInt() != 0;
        this.m_doubleValue = parcel.readDouble();
        this.m_stringComparisonType = parcel.readInt();
        this.m_expression = parcel.readString();
        this.enableRegex = parcel.readInt() != 0;
        this.checkCase = parcel.readInt() != 0;
        this.dictionaryType = parcel.readInt();
        this.dictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
        this.compareVarDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements VariableHelper.KeyDialogOptionChosenCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MacroDroidVariable f14433a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ VariableValue.Dictionary f14434b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f14435c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f14436d;

        /* renamed from: com.arlosoft.macrodroid.triggers.VariableTrigger$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0126a implements Function1<VariableHelper.ManualKeyData, Unit> {
            C0126a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public Unit invoke(VariableHelper.ManualKeyData manualKeyData) {
                a.this.f14435c.clear();
                a.this.f14435c.addAll(manualKeyData.getKeys());
                VariableTrigger.this.x0(manualKeyData.getVarType().intValue(), a.this.f14435c);
                return null;
            }
        }

        a(MacroDroidVariable macroDroidVariable, VariableValue.Dictionary dictionary, ArrayList arrayList, int i4) {
            this.f14433a = macroDroidVariable;
            this.f14434b = dictionary;
            this.f14435c = arrayList;
            this.f14436d = i4;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void keyChosen(@NonNull VariableValue.DictionaryEntry dictionaryEntry) {
            this.f14435c.add(dictionaryEntry.getKey());
            if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                VariableTrigger.this.Z0(this.f14433a, (VariableValue.Dictionary) dictionaryEntry.getVariable(), this.f14435c, this.f14436d + 1);
            } else {
                VariableTrigger.this.w0(dictionaryEntry.getVariable().getVariableType(), this.f14435c);
            }
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void manualKeyEntryChosen(@Nullable List<String> list) {
            VariableHelper.defineKeysManually(VariableTrigger.this.getActivity(), R.style.Theme_App_Dialog_Action, this.f14433a, this.f14434b, ((SelectableItem) VariableTrigger.this).m_macro, this.f14435c, list, true, VariableTrigger.this, false, new C0126a());
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void addKeyChosen() {
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void copyAllChosen() {
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void thisDictionaryChosen() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14441a;

        c(Button button) {
            this.f14441a = button;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f14441a;
            if (editable.length() > 0) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f14443a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Button f14444b;

        d(EditText editText, Button button) {
            this.f14443a = editText;
            this.f14444b = button;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                ExpressionUtils.calculateExpression(VariableTrigger.this.getContext(), VariableTrigger.this.getMacro(), this.f14443a.getText().toString(), null);
                this.f14444b.setEnabled(true);
            } catch (Exception unused) {
                this.f14444b.setEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
