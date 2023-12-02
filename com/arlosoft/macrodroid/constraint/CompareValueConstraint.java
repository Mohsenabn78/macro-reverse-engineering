package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.CompareValueConstraintInfo;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.ExpressionUtils;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CompareValueConstraint.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class CompareValueConstraint extends Constraint implements SupportsMagicText {
    public static final int COMPARISON_CONTAINS = 4;
    public static final int COMPARISON_EQUALS = 0;
    public static final int COMPARISON_EXCLUDES = 5;
    public static final int COMPARISON_GREATER_THAN = 3;
    public static final int COMPARISON_LESS_THAN = 2;
    public static final int COMPARISON_NOT_EQUALS = 1;
    private int comparisonType;
    private boolean enableRegex;
    private boolean ignoreCase;
    private int option;
    private int type;
    @NotNull
    private String value1;
    @NotNull
    private String value2;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<CompareValueConstraint> CREATOR = new Parcelable.Creator<CompareValueConstraint>() { // from class: com.arlosoft.macrodroid.constraint.CompareValueConstraint$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CompareValueConstraint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CompareValueConstraint(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CompareValueConstraint[] newArray(int i4) {
            return new CompareValueConstraint[i4];
        }
    };

    /* compiled from: CompareValueConstraint.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ CheckBox $caseInsensitive;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(CheckBox checkBox, Continuation<? super a> continuation) {
            super(4, continuation);
            this.$caseInsensitive = checkBox;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            a aVar = new a(this.$caseInsensitive, continuation);
            aVar.Z$0 = z3;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$caseInsensitive.setEnabled(!this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ CompareValueConstraint(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(EditText value1EditText, MagicText.MagicTextPair pair) {
        Intrinsics.checkNotNullParameter(value1EditText, "$value1EditText");
        Intrinsics.checkNotNullParameter(pair, "pair");
        int max = Math.max(value1EditText.getSelectionStart(), 0);
        int max2 = Math.max(value1EditText.getSelectionEnd(), 0);
        Editable text = value1EditText.getText();
        Intrinsics.checkNotNull(text);
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = pair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Activity activity, MagicText.MagicTextListener value1MagicListener, CompareValueConstraint this$0, View view) {
        Intrinsics.checkNotNullParameter(value1MagicListener, "$value1MagicListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, value1MagicListener, this$0.getMacro(), this$0.getDialogTheme(), this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(EditText value2EditText, MagicText.MagicTextPair pair) {
        Intrinsics.checkNotNullParameter(value2EditText, "$value2EditText");
        Intrinsics.checkNotNullParameter(pair, "pair");
        int max = Math.max(value2EditText.getSelectionStart(), 0);
        int max2 = Math.max(value2EditText.getSelectionEnd(), 0);
        Editable text = value2EditText.getText();
        Intrinsics.checkNotNull(text);
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = pair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Activity activity, MagicText.MagicTextListener value2MagicListener, CompareValueConstraint this$0, View view) {
        Intrinsics.checkNotNullParameter(value2MagicListener, "$value2MagicListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, value2MagicListener, this$0.getMacro(), this$0.getDialogTheme(), this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ca, code lost:
        if (r27.isChecked() != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0089, code lost:
        if (r2 != 3) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Y(com.arlosoft.macrodroid.constraint.CompareValueConstraint r16, android.widget.Spinner r17, android.widget.RadioButton r18, android.widget.RadioButton r19, android.widget.RadioButton r20, android.widget.RadioButton r21, android.widget.RadioButton r22, android.widget.RadioButton r23, android.widget.RadioButton r24, android.widget.RadioButton r25, android.widget.RadioButton r26, android.widget.RadioButton r27, android.widget.EditText r28, android.app.Activity r29, android.widget.EditText r30, android.widget.CheckBox r31, android.widget.CheckBox r32, androidx.appcompat.app.AppCompatDialog r33, android.view.View r34) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.constraint.CompareValueConstraint.Y(com.arlosoft.macrodroid.constraint.CompareValueConstraint, android.widget.Spinner, android.widget.RadioButton, android.widget.RadioButton, android.widget.RadioButton, android.widget.RadioButton, android.widget.RadioButton, android.widget.RadioButton, android.widget.RadioButton, android.widget.RadioButton, android.widget.RadioButton, android.widget.RadioButton, android.widget.EditText, android.app.Activity, android.widget.EditText, android.widget.CheckBox, android.widget.CheckBox, androidx.appcompat.app.AppCompatDialog, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    private final String a0(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                return TypeDescription.Generic.OfWildcardType.SYMBOL;
                            }
                            String r4 = SelectableItem.r(R.string.excludes);
                            Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.excludes)");
                            return r4;
                        }
                        String r5 = SelectableItem.r(R.string.contains);
                        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.contains)");
                        return r5;
                    }
                    return ">";
                }
                return "<";
            }
            return "!=";
        }
        return "=";
    }

    private final String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.enabled), SelectableItem.r(R.string.disabled)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(@Nullable TriggerContextInfo triggerContextInfo) {
        boolean equals;
        boolean equals2;
        boolean equals3;
        boolean equals4;
        String g4 = g(this.value1, triggerContextInfo);
        String g5 = g(this.value2, triggerContextInfo);
        Long macroGuid = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        SystemLog.logVerbose("Comparing values: " + g4 + " and " + g5, macroGuid.longValue());
        int i4 = this.type;
        boolean z3 = false;
        if (i4 == 0) {
            equals = kotlin.text.m.equals(g4, "true", true);
            if (!equals) {
                equals4 = kotlin.text.m.equals(g4, "false", true);
                if (!equals4) {
                    Long macroGuid2 = getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
                    SystemLog.logWarning("Failed to convert value 1 to a boolean (setting to false), value 1 is: " + g4, macroGuid2.longValue());
                }
            }
            equals2 = kotlin.text.m.equals(g5, "true", true);
            if (!equals2) {
                equals3 = kotlin.text.m.equals(g5, "false", true);
                if (!equals3) {
                    Long macroGuid3 = getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid3, "macroGuid");
                    SystemLog.logWarning("Failed to convert value 2 to a boolean (setting to false), value 2 is: " + g5, macroGuid3.longValue());
                }
            }
            boolean parseBoolean = Boolean.parseBoolean(g4);
            boolean parseBoolean2 = Boolean.parseBoolean(g5);
            int i5 = this.comparisonType;
            if (i5 == 0) {
                if (parseBoolean != parseBoolean2) {
                    return false;
                }
                return true;
            } else if (i5 == 1 && parseBoolean == parseBoolean2) {
                return false;
            } else {
                return true;
            }
        } else if (i4 == 2) {
            String regexPattern = WildCardHelper.getRegexPattern(g5, this.enableRegex, this.ignoreCase);
            String regexContainsPattern = WildCardHelper.getRegexContainsPattern(g5, this.enableRegex, this.ignoreCase);
            int i6 = this.comparisonType;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 != 4) {
                        if (i6 != 5 || WildCardHelper.matches(g4, regexContainsPattern, this.enableRegex, this.ignoreCase)) {
                            return false;
                        }
                    } else {
                        return WildCardHelper.matches(g4, regexContainsPattern, this.enableRegex, this.ignoreCase);
                    }
                } else if (WildCardHelper.matches(g4, regexPattern, this.enableRegex, this.ignoreCase)) {
                    return false;
                }
                return true;
            }
            return WildCardHelper.matches(g4, regexPattern, this.enableRegex, this.ignoreCase);
        } else if (i4 == 1) {
            try {
                long calculateExpressionLong = ExpressionUtils.calculateExpressionLong(getContext(), getMacro(), g4, triggerContextInfo);
                try {
                    long calculateExpressionLong2 = ExpressionUtils.calculateExpressionLong(getContext(), getMacro(), g5, triggerContextInfo);
                    int i7 = this.comparisonType;
                    if (i7 != 0) {
                        if (i7 != 1) {
                            if (i7 != 2) {
                                if (i7 == 3 && calculateExpressionLong <= calculateExpressionLong2) {
                                    return false;
                                }
                                return true;
                            } else if (calculateExpressionLong >= calculateExpressionLong2) {
                                return false;
                            } else {
                                return true;
                            }
                        } else if (calculateExpressionLong == calculateExpressionLong2) {
                            return false;
                        } else {
                            return true;
                        }
                    } else if (calculateExpressionLong != calculateExpressionLong2) {
                        return false;
                    } else {
                        return true;
                    }
                } catch (Exception unused) {
                    Long macroGuid4 = getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid4, "macroGuid");
                    SystemLog.logWarning("Failed to convert value 2 to an integer, value 2 is: " + g5, macroGuid4.longValue());
                    return false;
                }
            } catch (Exception unused2) {
                String str = "Failed to convert value 1 to an integer, value 1 is: " + g4;
                Long macroGuid5 = getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid5, "macroGuid");
                SystemLog.logWarning(str, macroGuid5.longValue());
                return false;
            }
        } else if (i4 == 3) {
            try {
                double calculateExpression = ExpressionUtils.calculateExpression(getContext(), getMacro(), g4, triggerContextInfo);
                try {
                    double calculateExpression2 = ExpressionUtils.calculateExpression(getContext(), getMacro(), g5, triggerContextInfo);
                    int i8 = this.comparisonType;
                    if (i8 != 0) {
                        if (i8 != 1) {
                            if (i8 != 2) {
                                if (i8 == 3 && calculateExpression <= calculateExpression2) {
                                    return false;
                                }
                                return true;
                            } else if (calculateExpression >= calculateExpression2) {
                                return false;
                            } else {
                                return true;
                            }
                        }
                        if (calculateExpression == calculateExpression2) {
                            z3 = true;
                        }
                        return !z3;
                    } else if (calculateExpression != calculateExpression2) {
                        return false;
                    } else {
                        return true;
                    }
                } catch (Exception unused3) {
                    Long macroGuid6 = getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid6, "macroGuid");
                    SystemLog.logWarning("Failed to convert value 2 to a decimal, value 2 is: " + g5, macroGuid6.longValue());
                    return false;
                }
            } catch (Exception unused4) {
                String str2 = "Failed to convert value 1 to a decimal, value 1 is: " + g4;
                Long macroGuid7 = getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid7, "macroGuid");
                SystemLog.logWarning(str2, macroGuid7.longValue());
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        boolean z3;
        String str;
        String str2 = this.value1;
        String a02 = a0(this.comparisonType);
        if (this.value2.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            str = "\"\"";
        } else {
            str = this.value2;
        }
        return str2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + a02 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return CompareValueConstraintInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        return String.valueOf(getExtendedDetail());
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.value1, this.value2};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getSystemLogEntryName(@Nullable TriggerContextInfo triggerContextInfo) {
        boolean z3;
        String str;
        String str2 = this.value1;
        String a02 = a0(this.comparisonType);
        if (this.value2.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            str = "\"\"";
        } else {
            str = this.value2;
        }
        return str2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + a02 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    protected AlertDialog l() {
        int i4;
        int i5;
        int i6;
        int i7;
        final RadioButton radioButton;
        final RadioButton radioButton2;
        final RadioButton radioButton3;
        final RadioButton radioButton4;
        RadioButton radioButton5;
        RadioButton radioButton6;
        RadioButton radioButton7;
        RadioButton radioButton8;
        RadioButton radioButton9;
        final RadioButton radioButton10;
        int i8;
        int i9;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_compare_values_constraint);
        appCompatDialog.setTitle(R.string.constraint_compare_values);
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog, 0, 1, null);
        View findViewById = appCompatDialog.findViewById(R.id.variable_constraint_dialog_button_ok);
        Intrinsics.checkNotNull(findViewById);
        Button button = (Button) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.variable_constraint_dialog_button_cancel);
        Intrinsics.checkNotNull(findViewById2);
        Button button2 = (Button) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.value_1);
        Intrinsics.checkNotNull(findViewById3);
        final EditText editText = (EditText) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.value_2);
        Intrinsics.checkNotNull(findViewById4);
        final EditText editText2 = (EditText) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.value_1_magic_button);
        Intrinsics.checkNotNull(findViewById5);
        Button button3 = (Button) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.value_2_magic_button);
        Intrinsics.checkNotNull(findViewById6);
        Button button4 = (Button) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.typeSpinner);
        Intrinsics.checkNotNull(findViewById7);
        final Spinner spinner = (Spinner) findViewById7;
        View findViewById8 = appCompatDialog.findViewById(R.id.booleanComparisonOptions);
        Intrinsics.checkNotNull(findViewById8);
        final RadioGroup radioGroup = (RadioGroup) findViewById8;
        View findViewById9 = appCompatDialog.findViewById(R.id.numberComparisonOptions);
        Intrinsics.checkNotNull(findViewById9);
        final RadioGroup radioGroup2 = (RadioGroup) findViewById9;
        View findViewById10 = appCompatDialog.findViewById(R.id.stringComparisonOptions);
        Intrinsics.checkNotNull(findViewById10);
        final RadioGroup radioGroup3 = (RadioGroup) findViewById10;
        View findViewById11 = appCompatDialog.findViewById(R.id.stringSecondaryOptions);
        Intrinsics.checkNotNull(findViewById11);
        final ViewGroup viewGroup = (ViewGroup) findViewById11;
        View findViewById12 = appCompatDialog.findViewById(R.id.stringEqualsRadioButton);
        Intrinsics.checkNotNull(findViewById12);
        final RadioButton radioButton11 = (RadioButton) findViewById12;
        View findViewById13 = appCompatDialog.findViewById(R.id.stringNotEqualsRadioButton);
        Intrinsics.checkNotNull(findViewById13);
        final RadioButton radioButton12 = (RadioButton) findViewById13;
        View findViewById14 = appCompatDialog.findViewById(R.id.stringContainsRadioButton);
        Intrinsics.checkNotNull(findViewById14);
        final RadioButton radioButton13 = (RadioButton) findViewById14;
        View findViewById15 = appCompatDialog.findViewById(R.id.stringExcludesRadioButton);
        Intrinsics.checkNotNull(findViewById15);
        final RadioButton radioButton14 = (RadioButton) findViewById15;
        View findViewById16 = appCompatDialog.findViewById(R.id.numberEqualsRadioButton);
        Intrinsics.checkNotNull(findViewById16);
        final RadioButton radioButton15 = (RadioButton) findViewById16;
        View findViewById17 = appCompatDialog.findViewById(R.id.numberNotEqualsRadioButton);
        Intrinsics.checkNotNull(findViewById17);
        final RadioButton radioButton16 = (RadioButton) findViewById17;
        View findViewById18 = appCompatDialog.findViewById(R.id.numberLessThanRadioButton);
        Intrinsics.checkNotNull(findViewById18);
        final RadioButton radioButton17 = (RadioButton) findViewById18;
        View findViewById19 = appCompatDialog.findViewById(R.id.numberGreaterThanRadioButton);
        Intrinsics.checkNotNull(findViewById19);
        final RadioButton radioButton18 = (RadioButton) findViewById19;
        View findViewById20 = appCompatDialog.findViewById(R.id.booleanEqualsRadioButton);
        Intrinsics.checkNotNull(findViewById20);
        final RadioButton radioButton19 = (RadioButton) findViewById20;
        View findViewById21 = appCompatDialog.findViewById(R.id.booleanNotEqualsRadioButton);
        Intrinsics.checkNotNull(findViewById21);
        final RadioButton radioButton20 = (RadioButton) findViewById21;
        View findViewById22 = appCompatDialog.findViewById(R.id.enableRegexCheckbox);
        Intrinsics.checkNotNull(findViewById22);
        final CheckBox checkBox = (CheckBox) findViewById22;
        View findViewById23 = appCompatDialog.findViewById(R.id.ignoreCaseCheckbox);
        Intrinsics.checkNotNull(findViewById23);
        final CheckBox checkBox2 = (CheckBox) findViewById23;
        if (this.type == 0) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        radioGroup.setVisibility(i4);
        int i10 = this.type;
        if (i10 != 1 && i10 != 3) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        radioGroup2.setVisibility(i5);
        if (this.type == 2) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        radioGroup3.setVisibility(i6);
        if (this.type == 2) {
            i7 = 0;
        } else {
            i7 = 8;
        }
        viewGroup.setVisibility(i7);
        editText.setText(this.value1);
        editText2.setText(this.value2);
        checkBox.setChecked(this.enableRegex);
        checkBox2.setChecked(this.ignoreCase);
        checkBox2.setEnabled(!this.enableRegex);
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(checkBox, (CoroutineContext) null, new a(checkBox2, null), 1, (Object) null);
        spinner.setSelection(this.type);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.arlosoft.macrodroid.constraint.CompareValueConstraint$displaySecondaryOptionsDialog$2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(@Nullable AdapterView<?> adapterView, @Nullable View view, int i11, long j4) {
                int i12;
                int i13;
                int i14;
                int i15;
                int i16;
                int i17;
                int i18;
                int i19;
                int i20;
                CompareValueConstraint.this.type = i11;
                RadioGroup radioGroup4 = radioGroup;
                int i21 = 8;
                if (i11 == 0) {
                    i12 = 0;
                } else {
                    i12 = 8;
                }
                radioGroup4.setVisibility(i12);
                RadioGroup radioGroup5 = radioGroup2;
                if (i11 != 1 && i11 != 3) {
                    i13 = 8;
                } else {
                    i13 = 0;
                }
                radioGroup5.setVisibility(i13);
                RadioGroup radioGroup6 = radioGroup3;
                if (i11 == 2) {
                    i14 = 0;
                } else {
                    i14 = 8;
                }
                radioGroup6.setVisibility(i14);
                ViewGroup viewGroup2 = viewGroup;
                if (i11 == 2) {
                    i21 = 0;
                }
                viewGroup2.setVisibility(i21);
                if (i11 == 0) {
                    i15 = CompareValueConstraint.this.comparisonType;
                    if (i15 != 2) {
                        i16 = CompareValueConstraint.this.comparisonType;
                        if (i16 != 3) {
                            return;
                        }
                    }
                    CompareValueConstraint.this.comparisonType = 0;
                    radioButton19.setChecked(true);
                    radioButton20.setChecked(false);
                    return;
                }
                if (i11 != 1) {
                    if (i11 == 2) {
                        i19 = CompareValueConstraint.this.comparisonType;
                        if (i19 != 2) {
                            i20 = CompareValueConstraint.this.comparisonType;
                            if (i20 != 3) {
                                return;
                            }
                        }
                        radioButton11.setChecked(true);
                        radioButton12.setChecked(false);
                        radioButton13.setChecked(false);
                        radioButton14.setChecked(false);
                        return;
                    } else if (i11 != 3) {
                        return;
                    }
                }
                i17 = CompareValueConstraint.this.comparisonType;
                if (i17 != 4) {
                    i18 = CompareValueConstraint.this.comparisonType;
                    if (i18 != 5) {
                        return;
                    }
                }
                CompareValueConstraint.this.comparisonType = 0;
                radioButton15.setChecked(true);
                radioButton16.setChecked(false);
                radioButton17.setChecked(false);
                radioButton18.setChecked(false);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(@Nullable AdapterView<?> adapterView) {
            }
        });
        int i11 = this.type;
        if (i11 != 0) {
            if (i11 != 1) {
                i8 = 2;
                if (i11 != 2) {
                    i9 = 3;
                    radioButton = radioButton13;
                    radioButton2 = radioButton14;
                    if (i11 != 3) {
                        radioButton3 = radioButton15;
                        radioButton4 = radioButton16;
                        radioButton5 = radioButton17;
                        radioButton6 = radioButton18;
                        radioButton9 = radioButton19;
                        radioButton10 = radioButton20;
                        radioButton7 = radioButton11;
                    } else {
                        radioButton7 = radioButton11;
                        radioButton8 = radioButton12;
                    }
                } else {
                    int i12 = this.comparisonType;
                    if (i12 != 0) {
                        if (i12 != 1) {
                            if (i12 != 4) {
                                if (i12 != 5) {
                                    radioButton7 = radioButton11;
                                    radioButton7.setChecked(true);
                                    radioButton = radioButton13;
                                    radioButton2 = radioButton14;
                                } else {
                                    radioButton2 = radioButton14;
                                    radioButton7 = radioButton11;
                                    radioButton2.setChecked(true);
                                    radioButton = radioButton13;
                                }
                            } else {
                                radioButton = radioButton13;
                                radioButton2 = radioButton14;
                                radioButton7 = radioButton11;
                                radioButton.setChecked(true);
                            }
                            radioButton3 = radioButton15;
                            radioButton4 = radioButton16;
                            radioButton5 = radioButton17;
                            radioButton6 = radioButton18;
                            radioButton9 = radioButton19;
                            radioButton10 = radioButton20;
                        } else {
                            radioButton = radioButton13;
                            radioButton2 = radioButton14;
                            radioButton7 = radioButton11;
                            radioButton8 = radioButton12;
                            radioButton8.setChecked(true);
                        }
                    } else {
                        radioButton = radioButton13;
                        radioButton2 = radioButton14;
                        radioButton7 = radioButton11;
                        radioButton8 = radioButton12;
                        radioButton7.setChecked(true);
                    }
                    radioButton3 = radioButton15;
                    radioButton4 = radioButton16;
                    radioButton5 = radioButton17;
                    radioButton6 = radioButton18;
                    radioButton9 = radioButton19;
                    radioButton10 = radioButton20;
                }
                radioButton8 = radioButton12;
            } else {
                radioButton = radioButton13;
                radioButton2 = radioButton14;
                radioButton7 = radioButton11;
                radioButton8 = radioButton12;
                i8 = 2;
                i9 = 3;
            }
            int i13 = this.comparisonType;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 != i8) {
                        if (i13 != i9) {
                            radioButton3 = radioButton15;
                            radioButton3.setChecked(true);
                            radioButton4 = radioButton16;
                            radioButton5 = radioButton17;
                            radioButton6 = radioButton18;
                        } else {
                            radioButton3 = radioButton15;
                            radioButton6 = radioButton18;
                            radioButton6.setChecked(true);
                            radioButton4 = radioButton16;
                            radioButton5 = radioButton17;
                        }
                    } else {
                        radioButton3 = radioButton15;
                        radioButton5 = radioButton17;
                        radioButton6 = radioButton18;
                        radioButton5.setChecked(true);
                        radioButton4 = radioButton16;
                    }
                } else {
                    radioButton3 = radioButton15;
                    radioButton4 = radioButton16;
                    radioButton5 = radioButton17;
                    radioButton6 = radioButton18;
                    radioButton4.setChecked(true);
                }
            } else {
                radioButton3 = radioButton15;
                radioButton4 = radioButton16;
                radioButton5 = radioButton17;
                radioButton6 = radioButton18;
                radioButton3.setChecked(true);
            }
            radioButton9 = radioButton19;
            radioButton10 = radioButton20;
        } else {
            radioButton = radioButton13;
            radioButton2 = radioButton14;
            radioButton3 = radioButton15;
            radioButton4 = radioButton16;
            radioButton5 = radioButton17;
            radioButton6 = radioButton18;
            radioButton7 = radioButton11;
            radioButton8 = radioButton12;
            int i14 = this.comparisonType;
            if (i14 != 0) {
                if (i14 != 1) {
                    radioButton9 = radioButton19;
                    radioButton9.setChecked(true);
                    radioButton10 = radioButton20;
                } else {
                    radioButton9 = radioButton19;
                    radioButton10 = radioButton20;
                    radioButton10.setChecked(true);
                }
            } else {
                radioButton9 = radioButton19;
                radioButton10 = radioButton20;
                radioButton9.setChecked(true);
            }
        }
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.constraint.m0
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                CompareValueConstraint.U(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CompareValueConstraint.V(activity, magicTextListener, this, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.constraint.o0
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                CompareValueConstraint.W(editText2, magicTextPair);
            }
        };
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CompareValueConstraint.X(activity, magicTextListener2, this, view);
            }
        });
        final RadioButton radioButton21 = radioButton9;
        final RadioButton radioButton22 = radioButton7;
        final RadioButton radioButton23 = radioButton8;
        final RadioButton radioButton24 = radioButton5;
        final RadioButton radioButton25 = radioButton6;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CompareValueConstraint.Y(CompareValueConstraint.this, spinner, radioButton21, radioButton10, radioButton22, radioButton23, radioButton, radioButton2, radioButton3, radioButton4, radioButton24, radioButton25, editText, activity, editText2, checkBox, checkBox2, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CompareValueConstraint.Z(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.show();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 2) {
            this.value1 = magicText[0];
            this.value2 = magicText[1];
            return;
        }
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        String str = this.m_classType;
        firebaseCrashlytics.recordException(new RuntimeException("SetPossibleMagicText incorrect array length (" + str + ")"));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
        out.writeInt(this.type);
        out.writeString(this.value1);
        out.writeString(this.value2);
        out.writeInt(this.comparisonType);
        out.writeInt(this.enableRegex ? 1 : 0);
        out.writeInt(this.ignoreCase ? 1 : 0);
    }

    public CompareValueConstraint(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
        this.ignoreCase = true;
    }

    public CompareValueConstraint() {
        this.value1 = "";
        this.value2 = "";
    }

    private CompareValueConstraint(Parcel parcel) {
        super(parcel);
        this.value1 = "";
        this.value2 = "";
        this.option = parcel.readInt();
        this.type = parcel.readInt();
        String readString = parcel.readString();
        this.value1 = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.value2 = readString2 != null ? readString2 : "";
        this.comparisonType = parcel.readInt();
        this.enableRegex = parcel.readInt() != 0;
        this.ignoreCase = parcel.readInt() != 0;
    }

    /* compiled from: CompareValueConstraint.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
