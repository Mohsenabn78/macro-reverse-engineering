package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
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
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.MacroDroidVariableConstraintInfo;
import com.arlosoft.macrodroid.interfaces.HasMultipleDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasVariables;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
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
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class MacroDroidVariableConstraint extends Constraint implements HasVariables, SupportsMagicText, HasMultipleDictionaryKeys {
    public static final Parcelable.Creator<MacroDroidVariableConstraint> CREATOR = new f();
    private static final int DICTIONARY_OR_ARRAY_TYPE_NOT_SET = -1;
    private static final int STRING_CONTAINS = 1;
    private static final int STRING_EQUALITY_CHECK = 0;
    private static final int STRING_EXCLUDES = 2;
    private boolean checkCase;
    private DictionaryKeys compareVarDictionaryKeys;
    private DictionaryKeys dictionaryKeys;
    private int dictionaryType;
    private boolean enableRegex;
    private boolean m_booleanValue;
    private double m_doubleValue;
    private String m_expression;
    private boolean m_intCompareVariable;
    private boolean m_intGreaterThan;
    private boolean m_intLessThan;
    private boolean m_intNotEqual;
    private long m_intValue;
    private MacroDroidVariable m_otherValueToCompare;
    private int m_stringComparisonType;
    private boolean m_stringEqual;
    private String m_stringValue;
    private MacroDroidVariable m_variable;
    private transient int selectedIndex;
    private DictionaryKeys workingCompareVarDictionaryKeys;
    private MacroDroidVariable workingOtherVarToCompare;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CheckBox f10201a;

        b(CheckBox checkBox) {
            this.f10201a = checkBox;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            this.f10201a.setEnabled(!z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements VariableHelper.VariableSelectedListener {
        e() {
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void customItemSelected(int i4, @NonNull String str) {
            MacroDroidVariableConstraint.this.workingOtherVarToCompare = null;
            MacroDroidVariableConstraint.this.workingCompareVarDictionaryKeys = null;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void variableSelected(@NonNull MacroDroidVariable macroDroidVariable, List<String> list) {
            DictionaryKeys dictionaryKeys;
            MacroDroidVariableConstraint.this.workingOtherVarToCompare = macroDroidVariable;
            MacroDroidVariableConstraint macroDroidVariableConstraint = MacroDroidVariableConstraint.this;
            if (list != null) {
                dictionaryKeys = new DictionaryKeys(list);
            } else {
                dictionaryKeys = null;
            }
            macroDroidVariableConstraint.workingCompareVarDictionaryKeys = dictionaryKeys;
        }
    }

    /* loaded from: classes3.dex */
    class f implements Parcelable.Creator<MacroDroidVariableConstraint> {
        f() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MacroDroidVariableConstraint createFromParcel(Parcel parcel) {
            return new MacroDroidVariableConstraint(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MacroDroidVariableConstraint[] newArray(int i4) {
            return new MacroDroidVariableConstraint[i4];
        }
    }

    /* synthetic */ MacroDroidVariableConstraint(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void c0(Spinner spinner) {
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
    /* JADX WARN: Removed duplicated region for block: B:106:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0469  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d0(final int r49, final java.util.ArrayList<java.lang.String> r50) {
        /*
            Method dump skipped, instructions count: 1280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.constraint.MacroDroidVariableConstraint.d0(int, java.util.ArrayList):void");
    }

    private String e0(int i4) {
        int i5;
        StringBuilder sb;
        StringBuilder sb2;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        String str = this.m_expression;
                        if (str == null) {
                            if (this.m_intCompareVariable) {
                                sb2 = new StringBuilder();
                                sb2.append(this.m_otherValueToCompare.getName());
                                sb2.append(VariableHelper.getFormattedDictionaryKeys(this.compareVarDictionaryKeys));
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
                    int i6 = this.m_stringComparisonType;
                    if (i6 == 0) {
                        if (this.m_stringEqual) {
                            return "= " + this.m_stringValue;
                        }
                        return "!= " + this.m_stringValue;
                    } else if (i6 == 1) {
                        return SelectableItem.r(R.string.contains).toLowerCase() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_stringValue;
                    } else if (i6 == 2) {
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
                    sb.append(VariableHelper.getFormattedDictionaryKeys(this.compareVarDictionaryKeys));
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
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("= ");
        if (this.m_booleanValue) {
            i5 = R.string.true_label;
        } else {
            i5 = R.string.false_label;
        }
        sb3.append(SelectableItem.r(i5));
        return sb3.toString();
    }

    private boolean f0(boolean z3, boolean z4, boolean z5, String str, String str2) {
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
    public static /* synthetic */ void g0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displayNumberVariableSelectionDialog(activity, getMacro(), magicTextListener, getDialogTheme(), null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(int i4, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, EditText editText, EditText editText2, RadioButton radioButton6, RadioButton radioButton7, RadioButton radioButton8, RadioButton radioButton9, RadioButton radioButton10, EditText editText3, CheckBox checkBox, CheckBox checkBox2, ArrayList arrayList, AppCompatDialog appCompatDialog, View view) {
        if (i4 != 0) {
            String str = null;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        this.m_intGreaterThan = radioButton2.isChecked();
                        this.m_intLessThan = radioButton3.isChecked();
                        this.m_intNotEqual = radioButton4.isChecked();
                        if (radioButton5.isChecked()) {
                            str = editText.getText().toString();
                        }
                        this.m_expression = str;
                        if (editText2.length() > 0) {
                            this.m_doubleValue = Double.valueOf(editText2.getText().toString()).doubleValue();
                        } else {
                            this.m_doubleValue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        }
                        this.m_intCompareVariable = radioButton6.isChecked();
                        this.m_otherValueToCompare = this.workingOtherVarToCompare;
                        this.compareVarDictionaryKeys = this.workingCompareVarDictionaryKeys;
                    }
                } else {
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
                }
            } else {
                this.m_intGreaterThan = radioButton2.isChecked();
                this.m_intLessThan = radioButton3.isChecked();
                this.m_intNotEqual = radioButton4.isChecked();
                if (radioButton5.isChecked()) {
                    str = editText.getText().toString();
                }
                this.m_expression = str;
                if (editText2.length() > 0) {
                    try {
                        this.m_intValue = Long.valueOf(editText2.getText().toString()).longValue();
                    } catch (NumberFormatException unused) {
                        ToastCompat.makeText(getContext(), (int) R.string.invalid_value, 0).show();
                        return;
                    }
                } else {
                    this.m_intValue = 0L;
                }
                this.m_intCompareVariable = radioButton6.isChecked();
                this.m_otherValueToCompare = this.workingOtherVarToCompare;
                this.compareVarDictionaryKeys = this.workingCompareVarDictionaryKeys;
            }
        } else {
            this.m_booleanValue = radioButton.isChecked();
        }
        this.checkCase = true ^ checkBox.isChecked();
        this.enableRegex = checkBox2.isChecked();
        this.dictionaryType = i4;
        this.dictionaryKeys = new DictionaryKeys(arrayList);
        appCompatDialog.cancel();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), getDialogTheme(), isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(Spinner spinner, RadioButton radioButton, RadioButton radioButton2, EditText editText, Button button, LinearLayout linearLayout, EditText editText2, Button button2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            c0(spinner);
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            editText.setEnabled(false);
            button.setEnabled(false);
            linearLayout.setVisibility(8);
            editText2.setEnabled(false);
            spinner.setVisibility(0);
            button2.setEnabled(f0(radioButton.isChecked(), radioButton3.isChecked(), radioButton2.isChecked(), editText2.getText().toString(), editText.getText().toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(RadioButton radioButton, EditText editText, RadioButton radioButton2, EditText editText2, Button button, LinearLayout linearLayout, Spinner spinner, Button button2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            editText.setEnabled(false);
            radioButton2.setChecked(false);
            editText2.setEnabled(false);
            button.setEnabled(false);
            linearLayout.setVisibility(8);
            spinner.setVisibility(8);
            editText.setEnabled(true);
            button2.setEnabled(f0(radioButton3.isChecked(), radioButton.isChecked(), radioButton2.isChecked(), editText.getText().toString(), editText2.getText().toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(RadioButton radioButton, EditText editText, RadioButton radioButton2, Spinner spinner, EditText editText2, Button button, LinearLayout linearLayout, Button button2, RadioButton radioButton3, CompoundButton compoundButton, boolean z3) {
        if (z3) {
            radioButton.setChecked(false);
            editText.setEnabled(false);
            radioButton2.setChecked(false);
            spinner.setVisibility(8);
            editText2.setEnabled(true);
            button.setEnabled(true);
            linearLayout.setVisibility(0);
            button2.setEnabled(f0(radioButton.isChecked(), radioButton2.isChecked(), radioButton3.isChecked(), editText.getText().toString(), editText2.getText().toString()));
        }
    }

    private void p0(@NonNull MacroDroidVariable macroDroidVariable) {
        int type = macroDroidVariable.getType();
        if (type != 4 && type != 5) {
            d0(macroDroidVariable.getType(), new ArrayList<>());
        } else {
            q0(macroDroidVariable, macroDroidVariable.getDictionary(), new ArrayList<>(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(MacroDroidVariable macroDroidVariable, VariableValue.Dictionary dictionary, ArrayList<String> arrayList, int i4) {
        String str;
        List<String> list = null;
        if (arrayList.size() > i4) {
            str = arrayList.get(i4);
        } else {
            str = null;
        }
        Activity activity = getActivity();
        int m4 = m();
        DictionaryKeys dictionaryKeys = this.dictionaryKeys;
        if (dictionaryKeys != null) {
            list = dictionaryKeys.getKeys();
        }
        VariableHelper.showSelectKeyDialog(activity, m4, dictionary, null, str, false, new VariableHelper.ManualKeyOption(true, list), false, VariableHelper.ShowThisDictionaryOption.DONT_SHOW, true, new a(macroDroidVariable, dictionary, arrayList, i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.selectedIndex = i4;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(TriggerContextInfo triggerContextInfo) {
        List<String> applyMagicTextToDictionaryKeys;
        VariableValue variableValue;
        MacroDroidVariable macroDroidVariable;
        MacroDroidVariable macroDroidVariable2;
        double intValue;
        MacroDroidVariable variableByName = getVariableByName(this.m_variable.getName());
        if (variableByName == null) {
            SystemLog.logError("Variable constraint failed, variable not found: " + this.m_variable.getName(), getMacroGuid().longValue());
            return false;
        }
        ArrayList<String> arrayList = null;
        if (getMacro() == null) {
            SystemLog.logWarning("Checking constraint (" + getConfiguredName() + "), macro is null");
            applyMagicTextToDictionaryKeys = this.dictionaryKeys.getKeys();
        } else if (this.dictionaryKeys == null) {
            applyMagicTextToDictionaryKeys = null;
        } else {
            applyMagicTextToDictionaryKeys = VariableHelper.applyMagicTextToDictionaryKeys(getContext(), this.dictionaryKeys.getKeys(), triggerContextInfo, getMacro());
        }
        if (applyMagicTextToDictionaryKeys == null) {
            applyMagicTextToDictionaryKeys = null;
        }
        VariableValue.DictionaryEntry targetDictionaryEntry = variableByName.getTargetDictionaryEntry(applyMagicTextToDictionaryKeys, false);
        if (targetDictionaryEntry != null) {
            variableValue = targetDictionaryEntry.getVariable();
        } else if (variableByName.getType() != 4 && variableByName.getType() != 5) {
            variableValue = variableByName.getVariableValue();
        } else {
            SystemLog.logError("Variable constraint failed, variable not found: " + this.m_variable.getName() + VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys), getMacroGuid().longValue());
            return false;
        }
        if (variableValue == null) {
            SystemLog.logError("Variable constraint failed, variable not found: " + this.m_variable.getName() + VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys), getMacroGuid().longValue());
            return false;
        }
        int variableType = variableValue.getVariableType();
        if (variableType != 0) {
            if (variableType != 1) {
                if (variableType != 2) {
                    if (variableType == 3) {
                        VariableValue.DecimalValue decimalValue = (VariableValue.DecimalValue) variableValue;
                        double d4 = this.m_doubleValue;
                        if (this.m_expression != null) {
                            try {
                                d4 = ExpressionUtils.calculateExpression(getContext(), getMacro(), this.m_expression, triggerContextInfo);
                            } catch (IllegalArgumentException unused) {
                                SystemLog.logError("Variable constraint checking not working, expression evaluation failed", getMacroGuid().longValue());
                                d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                            }
                        } else if (this.m_intCompareVariable && (macroDroidVariable2 = this.m_otherValueToCompare) != null) {
                            MacroDroidVariable variableByName2 = getVariableByName(macroDroidVariable2.getName());
                            if (variableByName2 != null) {
                                VariableValue variableValue2 = variableByName2.getVariableValue();
                                if (this.compareVarDictionaryKeys != null) {
                                    arrayList = VariableHelper.applyMagicTextToDictionaryKeys(getContext(), this.compareVarDictionaryKeys.getKeys(), triggerContextInfo, getMacro());
                                }
                                VariableValue.DictionaryEntry targetDictionaryEntry2 = variableByName2.getTargetDictionaryEntry(arrayList, false);
                                if (targetDictionaryEntry2 != null) {
                                    variableValue2 = targetDictionaryEntry2.getVariable();
                                } else if (variableValue2 instanceof VariableValue.Dictionary) {
                                    SystemLog.logError("Variable constraint failed, variable not found: " + variableByName2.getName() + VariableHelper.getFormattedDictionaryKeys(this.compareVarDictionaryKeys), getMacroGuid().longValue());
                                    return false;
                                }
                                if (variableValue2 instanceof VariableValue.DecimalValue) {
                                    intValue = ((VariableValue.DecimalValue) variableValue2).getDecimalValue();
                                } else if (variableValue2 instanceof VariableValue.IntegerValue) {
                                    intValue = ((VariableValue.IntegerValue) variableValue2).getIntValue();
                                }
                                d4 = intValue;
                            } else {
                                SystemLog.logError("Variable constraint failed, variable not found: " + this.m_otherValueToCompare.getName(), getMacroGuid().longValue());
                                return false;
                            }
                        }
                        if (this.m_intGreaterThan) {
                            if (decimalValue.getDecimalValue() <= d4) {
                                return false;
                            }
                            return true;
                        } else if (this.m_intLessThan) {
                            if (decimalValue.getDecimalValue() >= d4) {
                                return false;
                            }
                            return true;
                        } else if (this.m_intNotEqual) {
                            return !MathsUtils.areDecimalsEqual(decimalValue.getDecimalValue(), d4);
                        } else {
                            return MathsUtils.areDecimalsEqual(decimalValue.getDecimalValue(), d4);
                        }
                    }
                } else {
                    VariableValue.StringValue stringValue = (VariableValue.StringValue) variableValue;
                    String replaceMagicText = MagicText.replaceMagicText(getContext(), this.m_stringValue, triggerContextInfo, getMacro());
                    String regexPattern = WildCardHelper.getRegexPattern(replaceMagicText, this.enableRegex, !this.checkCase);
                    String regexContainsPattern = WildCardHelper.getRegexContainsPattern(replaceMagicText, this.enableRegex, !this.checkCase);
                    int i4 = this.m_stringComparisonType;
                    if (i4 == 0) {
                        if (this.m_stringEqual) {
                            return WildCardHelper.matches(stringValue.getTextValue(), regexPattern, this.enableRegex, !this.checkCase);
                        }
                        return !WildCardHelper.matches(stringValue.getTextValue(), regexPattern, this.enableRegex, !this.checkCase);
                    } else if (i4 == 1) {
                        return WildCardHelper.matches(stringValue.getTextValue(), regexContainsPattern, this.enableRegex, !this.checkCase);
                    } else {
                        if (i4 == 2) {
                            return !WildCardHelper.matches(stringValue.getTextValue(), regexContainsPattern, this.enableRegex, !this.checkCase);
                        }
                    }
                }
                return true;
            }
            VariableValue.IntegerValue integerValue = (VariableValue.IntegerValue) variableValue;
            long j4 = this.m_intValue;
            if (this.m_expression != null) {
                try {
                    j4 = (long) ExpressionUtils.calculateExpression(getContext(), getMacro(), this.m_expression, triggerContextInfo);
                } catch (IllegalArgumentException unused2) {
                    SystemLog.logError("Variable constraint checking not working, expression evaluation failed", getMacroGuid().longValue());
                    j4 = 0;
                }
            } else if (this.m_intCompareVariable && (macroDroidVariable = this.m_otherValueToCompare) != null) {
                MacroDroidVariable variableByName3 = getVariableByName(macroDroidVariable.getName());
                if (variableByName3 != null) {
                    VariableValue variableValue3 = variableByName3.getVariableValue();
                    if (this.compareVarDictionaryKeys != null) {
                        arrayList = VariableHelper.applyMagicTextToDictionaryKeys(getContext(), this.compareVarDictionaryKeys.getKeys(), triggerContextInfo, getMacro());
                    }
                    VariableValue.DictionaryEntry targetDictionaryEntry3 = variableByName3.getTargetDictionaryEntry(arrayList, false);
                    if (targetDictionaryEntry3 != null) {
                        variableValue3 = targetDictionaryEntry3.getVariable();
                    } else if (variableValue3 instanceof VariableValue.Dictionary) {
                        SystemLog.logError("Variable constraint failed, variable not found: " + variableByName3.getName() + VariableHelper.getFormattedDictionaryKeys(this.compareVarDictionaryKeys), getMacroGuid().longValue());
                        return false;
                    }
                    if (variableValue3 instanceof VariableValue.DecimalValue) {
                        if (this.m_intGreaterThan) {
                            if (integerValue.getIntValue() <= ((VariableValue.DecimalValue) variableValue3).getDecimalValue()) {
                                return false;
                            }
                            return true;
                        } else if (this.m_intLessThan) {
                            if (integerValue.getIntValue() >= ((VariableValue.DecimalValue) variableValue3).getDecimalValue()) {
                                return false;
                            }
                            return true;
                        } else if (this.m_intNotEqual) {
                            if (integerValue.getIntValue() == ((VariableValue.DecimalValue) variableValue3).getDecimalValue()) {
                                return false;
                            }
                            return true;
                        } else if (integerValue.getIntValue() != ((VariableValue.DecimalValue) variableValue3).getDecimalValue()) {
                            return false;
                        } else {
                            return true;
                        }
                    } else if (variableValue3 instanceof VariableValue.IntegerValue) {
                        j4 = ((VariableValue.IntegerValue) variableValue3).getIntValue();
                    }
                } else {
                    SystemLog.logError("Variable constraint failed, variable not found: " + this.m_otherValueToCompare.getName(), getMacroGuid().longValue());
                    return false;
                }
            }
            if (this.m_intGreaterThan) {
                if (integerValue.getIntValue() <= j4) {
                    return false;
                }
                return true;
            } else if (this.m_intLessThan) {
                if (integerValue.getIntValue() >= j4) {
                    return false;
                }
                return true;
            } else if (this.m_intNotEqual) {
                if (integerValue.getIntValue() == j4) {
                    return false;
                }
                return true;
            } else if (integerValue.getIntValue() != j4) {
                return false;
            } else {
                return true;
            }
        } else if (((VariableValue.BooleanValue) variableValue).getBooleanValue() != this.m_booleanValue) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        ArrayList<MacroDroidVariable> allVariables = getAllVariables();
        if (this.m_variable != null) {
            for (int i4 = 0; i4 < allVariables.size(); i4++) {
                if (allVariables.get(i4).getName().equals(this.m_variable.getName())) {
                    this.selectedIndex = i4;
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

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        MacroDroidVariable macroDroidVariable = this.m_variable;
        if (macroDroidVariable != null) {
            int type = macroDroidVariable.getType();
            if (type != 4 && type != 5) {
                return this.m_variable.getName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + e0(this.m_variable.getType());
            }
            return this.m_variable.getName() + VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + e0(this.dictionaryType);
        }
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return MacroDroidVariableConstraintInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + MDTextUtils.truncateIfRequired(getExtendedDetail(), 20) + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_stringValue, this.m_expression};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getConfiguredName() + " (" + MDTextUtils.truncateIfRequired(getExtendedDetail(), 200) + ")";
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

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        Macro macro = this.m_macro;
        if (macro == null || !macro.isCompleted() || getVariableByName(this.m_variable.getName()) != null) {
            return true;
        }
        return false;
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
        ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) getContext().getString(R.string.constraint_macrodroid_variable_no_variables), 1).show();
        return new String[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.constraint_macrodroid_variable_select);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        MacroDroidVariable macroDroidVariable = getAllVariables().get(this.selectedIndex);
        this.m_variable = macroDroidVariable;
        p0(macroDroidVariable);
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
        parcel.writeDouble(this.m_doubleValue);
        parcel.writeInt(this.m_stringComparisonType);
        parcel.writeString(this.m_expression);
        parcel.writeInt(this.enableRegex ? 1 : 0);
        parcel.writeInt(this.checkCase ? 1 : 0);
        parcel.writeInt(this.dictionaryType);
        parcel.writeParcelable(this.dictionaryKeys, i4);
        parcel.writeParcelable(this.compareVarDictionaryKeys, i4);
    }

    public MacroDroidVariableConstraint(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private MacroDroidVariableConstraint() {
        this.compareVarDictionaryKeys = null;
        this.dictionaryType = -1;
        this.m_stringEqual = true;
    }

    private MacroDroidVariableConstraint(Parcel parcel) {
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
        final /* synthetic */ MacroDroidVariable f10195a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ VariableValue.Dictionary f10196b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f10197c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f10198d;

        /* renamed from: com.arlosoft.macrodroid.constraint.MacroDroidVariableConstraint$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0097a implements Function1<VariableHelper.ManualKeyData, Unit> {
            C0097a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public Unit invoke(VariableHelper.ManualKeyData manualKeyData) {
                a.this.f10197c.clear();
                a.this.f10197c.addAll(manualKeyData.getKeys());
                MacroDroidVariableConstraint.this.d0(manualKeyData.getVarType().intValue(), a.this.f10197c);
                return null;
            }
        }

        a(MacroDroidVariable macroDroidVariable, VariableValue.Dictionary dictionary, ArrayList arrayList, int i4) {
            this.f10195a = macroDroidVariable;
            this.f10196b = dictionary;
            this.f10197c = arrayList;
            this.f10198d = i4;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void keyChosen(@NonNull VariableValue.DictionaryEntry dictionaryEntry) {
            this.f10197c.add(dictionaryEntry.getKey());
            if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                MacroDroidVariableConstraint.this.q0(this.f10195a, (VariableValue.Dictionary) dictionaryEntry.getVariable(), this.f10197c, this.f10198d + 1);
            } else {
                MacroDroidVariableConstraint.this.d0(dictionaryEntry.getVariable().getVariableType(), this.f10197c);
            }
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
        public void manualKeyEntryChosen(@Nullable List<String> list) {
            VariableHelper.defineKeysManually(MacroDroidVariableConstraint.this.getActivity(), MacroDroidVariableConstraint.this.m(), this.f10195a, this.f10196b, ((SelectableItem) MacroDroidVariableConstraint.this).m_macro, this.f10197c, list, true, MacroDroidVariableConstraint.this, false, new C0097a());
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
        final /* synthetic */ Button f10203a;

        c(Button button) {
            this.f10203a = button;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f10203a;
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
        final /* synthetic */ EditText f10205a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Button f10206b;

        d(EditText editText, Button button) {
            this.f10205a = editText;
            this.f10206b = button;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                ExpressionUtils.calculateExpression(MacroDroidVariableConstraint.this.getContext(), MacroDroidVariableConstraint.this.getMacro(), this.f10205a.getText().toString(), null);
                this.f10206b.setEnabled(true);
            } catch (Exception unused) {
                this.f10206b.setEnabled(false);
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
