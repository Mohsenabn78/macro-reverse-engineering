package com.arlosoft.macrodroid.constraint;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.SystemSettingConstraintInfo;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SystemSettingConstraint.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nSystemSettingConstraint.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SystemSettingConstraint.kt\ncom/arlosoft/macrodroid/constraint/SystemSettingConstraint\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,435:1\n1002#2,2:436\n1549#2:438\n1620#2,3:439\n65#3,16:442\n93#3,3:458\n65#3,16:461\n93#3,3:477\n*S KotlinDebug\n*F\n+ 1 SystemSettingConstraint.kt\ncom/arlosoft/macrodroid/constraint/SystemSettingConstraint\n*L\n280#1:436,2\n282#1:438\n282#1:439,3\n356#1:442,16\n356#1:458,3\n359#1:461,16\n359#1:477,3\n*E\n"})
/* loaded from: classes3.dex */
public final class SystemSettingConstraint extends Constraint implements SupportsMagicText {
    private static final int EQUALITY_CHECK_EQUALS = 0;
    private static final int EQUALITY_CHECK_GREATER_THAN_OR_EXCLUDES = 3;
    private static final int EQUALITY_CHECK_LESS_THAN_OR_CONTAINS = 2;
    private static final int EQUALITY_CHECK_NOT_EQUALS = 1;
    private static final int TABLE_OPTION_SYSTEM = 0;
    private static final int VALUE_TYPE_FLOAT = 1;
    private static final int VALUE_TYPE_INT = 0;
    private static final int VALUE_TYPE_LONG = 2;
    private static final int VALUE_TYPE_STRING = 3;
    private int equalityCheckOption;
    @NotNull
    private String settingString;
    private int tableOption;
    @NotNull
    private String valueString;
    private int valueType;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SystemSettingConstraint> CREATOR = new Parcelable.Creator<SystemSettingConstraint>() { // from class: com.arlosoft.macrodroid.constraint.SystemSettingConstraint$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SystemSettingConstraint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SystemSettingConstraint(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SystemSettingConstraint[] newArray(int i4) {
            return new SystemSettingConstraint[i4];
        }
    };
    @NotNull
    private static final String[] DIALOG_OPTIONS = {"System", "Secure", "Global"};
    private static final int TABLE_OPTION_SECURE = 1;
    private static final int TABLE_OPTION_GLOBAL = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemSettingConstraint.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Integer, Unit> {
        final /* synthetic */ EditText $keyText;
        final /* synthetic */ Spinner $typeSpinner;
        final /* synthetic */ List<Pair<String, String>> $updatedList;
        final /* synthetic */ EditText $valueText;
        final /* synthetic */ SystemSettingConstraint this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List<Pair<String, String>> list, EditText editText, EditText editText2, Spinner spinner, SystemSettingConstraint systemSettingConstraint) {
            super(1);
            this.$updatedList = list;
            this.$keyText = editText;
            this.$valueText = editText2;
            this.$typeSpinner = spinner;
            this.this$0 = systemSettingConstraint;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i4) {
            if (i4 > 0) {
                Pair<String, String> pair = this.$updatedList.get(i4);
                this.$keyText.setText(pair.getFirst());
                this.$valueText.setText(pair.getSecond());
                this.$typeSpinner.setSelection(this.this$0.a0(pair.getSecond()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemSettingConstraint.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ EditText $keyText;
        final /* synthetic */ RadioButton $radioButtonEquals;
        final /* synthetic */ RadioButton $radioButtonLessOrContains;
        final /* synthetic */ RadioButton $radioButtonNotEquals;
        final /* synthetic */ Spinner $typeSpinner;
        final /* synthetic */ EditText $valueText;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(EditText editText, EditText editText2, Spinner spinner, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, AppCompatDialog appCompatDialog, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$keyText = editText;
            this.$valueText = editText2;
            this.$typeSpinner = spinner;
            this.$radioButtonEquals = radioButton;
            this.$radioButtonNotEquals = radioButton2;
            this.$radioButtonLessOrContains = radioButton3;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$keyText, this.$valueText, this.$typeSpinner, this.$radioButtonEquals, this.$radioButtonNotEquals, this.$radioButtonLessOrContains, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            int i4;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SystemSettingConstraint.this.settingString = this.$keyText.getText().toString();
                SystemSettingConstraint.this.valueString = this.$valueText.getText().toString();
                SystemSettingConstraint systemSettingConstraint = SystemSettingConstraint.this;
                Spinner spinner = this.$typeSpinner;
                int i5 = 0;
                if (spinner != null) {
                    i4 = spinner.getSelectedItemPosition();
                } else {
                    i4 = 0;
                }
                systemSettingConstraint.valueType = i4;
                SystemSettingConstraint systemSettingConstraint2 = SystemSettingConstraint.this;
                if (!this.$radioButtonEquals.isChecked()) {
                    if (this.$radioButtonNotEquals.isChecked()) {
                        i5 = 1;
                    } else if (this.$radioButtonLessOrContains.isChecked()) {
                        i5 = 2;
                    } else {
                        i5 = 3;
                    }
                }
                systemSettingConstraint2.equalityCheckOption = i5;
                SystemSettingConstraint.this.itemComplete();
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemSettingConstraint.kt */
    /* loaded from: classes3.dex */
    public static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AppCompatDialog appCompatDialog, Continuation<? super c> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ SystemSettingConstraint(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final boolean S(float f4) {
        Float floatOrNull;
        float f5;
        boolean z3;
        floatOrNull = kotlin.text.k.toFloatOrNull(this.valueString);
        if (floatOrNull != null) {
            f5 = floatOrNull.floatValue();
        } else {
            f5 = 0.0f;
        }
        int i4 = this.equalityCheckOption;
        if (i4 == 2) {
            if (f4 < f5) {
                return true;
            }
        } else if (i4 == 3) {
            if (f4 > f5) {
                return true;
            }
        } else if (i4 == 0) {
            if (f5 == f4) {
                return true;
            }
        } else {
            if (f5 == f4) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                return true;
            }
        }
        return false;
    }

    private final boolean T(long j4) {
        Long longOrNull;
        long j5;
        longOrNull = kotlin.text.l.toLongOrNull(this.valueString);
        if (longOrNull != null) {
            j5 = longOrNull.longValue();
        } else {
            j5 = 0;
        }
        int i4 = this.equalityCheckOption;
        if (i4 == 2) {
            if (j4 < j5) {
                return true;
            }
        } else if (i4 == 3) {
            if (j4 > j5) {
                return true;
            }
        } else if (i4 == 0) {
            if (j5 == j4) {
                return true;
            }
        } else if (j5 != j4) {
            return true;
        }
        return false;
    }

    private final boolean U(String str, TriggerContextInfo triggerContextInfo) {
        String replaceMagicText = MagicText.replaceMagicText(getContext(), this.valueString, triggerContextInfo, getMacro());
        String regexPattern = WildCardHelper.getRegexPattern(replaceMagicText, false, true);
        String regexContainsPattern = WildCardHelper.getRegexContainsPattern(replaceMagicText, false, true);
        int i4 = this.equalityCheckOption;
        if (i4 == 2) {
            return WildCardHelper.matches(str, regexContainsPattern, false, true);
        }
        if (i4 == 3) {
            if (WildCardHelper.matches(str, regexContainsPattern, false, true)) {
                return false;
            }
        } else {
            boolean matches = WildCardHelper.matches(str, regexPattern, false, true);
            if (this.equalityCheckOption == 0) {
                return matches;
            }
            if (matches) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0295  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void V(java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> r26) {
        /*
            Method dump skipped, instructions count: 667
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.constraint.SystemSettingConstraint.V(java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(EditText keyText, MagicText.MagicTextPair pair) {
        Intrinsics.checkNotNullParameter(keyText, "$keyText");
        Intrinsics.checkNotNullParameter(pair, "pair");
        int max = Math.max(keyText.getSelectionStart(), 0);
        int max2 = Math.max(keyText.getSelectionEnd(), 0);
        Editable text = keyText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = pair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(SystemSettingConstraint this$0, MagicText.MagicTextListener keyMagicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(keyMagicTextListener, "$keyMagicTextListener");
        MagicText.displaySelectionDialog(this$0.getActivity(), keyMagicTextListener, this$0.getMacro(), true, true, true, this$0.getDialogTheme(), this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(EditText valueText, MagicText.MagicTextPair pair) {
        Intrinsics.checkNotNullParameter(valueText, "$valueText");
        Intrinsics.checkNotNullParameter(pair, "pair");
        int max = Math.max(valueText.getSelectionStart(), 0);
        int max2 = Math.max(valueText.getSelectionEnd(), 0);
        Editable text = valueText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = pair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(Spinner typeSpinner, SystemSettingConstraint this$0, MagicText.MagicTextListener valueMagicTextListener, View view) {
        Intrinsics.checkNotNullParameter(typeSpinner, "$typeSpinner");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(valueMagicTextListener, "$valueMagicTextListener");
        if (typeSpinner.getSelectedItemPosition() == 3) {
            MagicText.displaySelectionDialog(this$0.getActivity(), valueMagicTextListener, this$0.getMacro(), true, true, true, this$0.getDialogTheme(), this$0.isChildOfIterateDictionary());
        } else {
            MagicText.displayNumberVariableSelectionDialog(this$0.getActivity(), this$0.getMacro(), valueMagicTextListener, this$0.getDialogTheme(), this$0.isChildOfIterateDictionary(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int a0(String str) {
        try {
            try {
                try {
                    Integer.parseInt(str);
                    return 0;
                } catch (NumberFormatException unused) {
                    Float.parseFloat(str);
                    return 1;
                }
            } catch (NumberFormatException unused2) {
                return 3;
            }
        } catch (NumberFormatException unused3) {
            Long.parseLong(str);
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.tableOption = i4;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(@Nullable TriggerContextInfo triggerContextInfo) {
        int i4;
        float f4;
        long j4;
        String string;
        String replaceMagicText = MagicText.replaceMagicText(getContext(), this.settingString, triggerContextInfo, getMacro());
        try {
            int i5 = this.valueType;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            return true;
                        }
                        int i6 = this.tableOption;
                        if (i6 == TABLE_OPTION_SYSTEM) {
                            string = Settings.System.getString(getContext().getContentResolver(), replaceMagicText);
                        } else if (i6 == TABLE_OPTION_SECURE) {
                            string = Settings.Secure.getString(getContext().getContentResolver(), replaceMagicText);
                        } else if (i6 == TABLE_OPTION_GLOBAL) {
                            string = Settings.Global.getString(getContext().getContentResolver(), replaceMagicText);
                        } else {
                            throw new IllegalArgumentException();
                        }
                        if (string != null) {
                            return U(string, triggerContextInfo);
                        }
                        SystemLog.logError("Constraint check failed. The setting (" + replaceMagicText + ") does not exist on this device: " + replaceMagicText);
                        return false;
                    }
                    int i7 = this.tableOption;
                    if (i7 == TABLE_OPTION_SYSTEM) {
                        j4 = Settings.System.getLong(getContext().getContentResolver(), replaceMagicText);
                    } else if (i7 == TABLE_OPTION_SECURE) {
                        j4 = Settings.Secure.getLong(getContext().getContentResolver(), replaceMagicText);
                    } else if (i7 == TABLE_OPTION_GLOBAL) {
                        j4 = Settings.Global.getLong(getContext().getContentResolver(), replaceMagicText);
                    } else {
                        throw new IllegalArgumentException();
                    }
                    return T(j4);
                }
                int i8 = this.tableOption;
                if (i8 == TABLE_OPTION_SYSTEM) {
                    f4 = Settings.System.getFloat(getContext().getContentResolver(), replaceMagicText);
                } else if (i8 == TABLE_OPTION_SECURE) {
                    f4 = Settings.Secure.getFloat(getContext().getContentResolver(), replaceMagicText);
                } else if (i8 == TABLE_OPTION_GLOBAL) {
                    f4 = Settings.Global.getFloat(getContext().getContentResolver(), replaceMagicText);
                } else {
                    throw new IllegalArgumentException();
                }
                return S(f4);
            }
            int i9 = this.tableOption;
            if (i9 == TABLE_OPTION_SYSTEM) {
                i4 = Settings.System.getInt(getContext().getContentResolver(), replaceMagicText);
            } else if (i9 == TABLE_OPTION_SECURE) {
                i4 = Settings.Secure.getInt(getContext().getContentResolver(), replaceMagicText);
            } else if (i9 == TABLE_OPTION_GLOBAL) {
                i4 = Settings.Global.getInt(getContext().getContentResolver(), replaceMagicText);
            } else {
                throw new IllegalArgumentException();
            }
            return T(i4);
        } catch (Settings.SettingNotFoundException unused) {
            SystemLog.logError("Constraint check failed. The setting (" + replaceMagicText + ") does not exist on this device: " + replaceMagicText);
            return false;
        } catch (SecurityException e4) {
            SystemLog.logError("Constraint check failed. The setting (" + replaceMagicText + ") cannot be red: " + e4);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.tableOption;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = Companion.a()[this.tableOption] + "(" + this.settingString + ")";
        String str2 = "!=";
        if (this.valueType == 3) {
            int i4 = this.equalityCheckOption;
            if (i4 != 0) {
                if (i4 != 1) {
                    str2 = i4 != 2 ? ">" : "<";
                }
            }
            str2 = "=";
        } else {
            int i5 = this.equalityCheckOption;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        str2 = SelectableItem.r(R.string.excludes);
                        Intrinsics.checkNotNullExpressionValue(str2, "getString(R.string.excludes)");
                    } else {
                        str2 = SelectableItem.r(R.string.contains);
                        Intrinsics.checkNotNullExpressionValue(str2, "getString(R.string.contains)");
                    }
                }
            }
            str2 = "=";
        }
        return str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.valueString;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return SystemSettingConstraintInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String name = getName();
        String extendedDetail = getExtendedDetail();
        return name + " (" + extendedDetail + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.settingString, this.valueString};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] o() {
        return DIALOG_OPTIONS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        try {
            ContentResolver contentResolver = getContext().getContentResolver();
            String lowerCase = Companion.a()[this.tableOption].toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            Cursor query = contentResolver.query(Uri.parse("content://settings/" + lowerCase), new String[]{"name", "value"}, null, null, null);
            Intrinsics.checkNotNull(query);
            ArrayList arrayList = new ArrayList();
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("name"));
                String string2 = query.getString(query.getColumnIndex("value"));
                if (string2 == null) {
                    string2 = "";
                }
                arrayList.add(new Pair(string, string2));
            }
            V(arrayList);
            query.close();
        } catch (Exception unused) {
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 2) {
            this.settingString = magicText[0];
            this.valueString = magicText[1];
            return;
        }
        SystemLog.logError("SystemSettingAction - Incorrect length when setting magic text");
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.valueType);
        out.writeInt(this.tableOption);
        out.writeString(this.settingString);
        out.writeString(this.valueString);
        out.writeInt(this.equalityCheckOption);
    }

    public SystemSettingConstraint(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SystemSettingConstraint() {
        this.settingString = "";
        this.valueString = "";
    }

    private SystemSettingConstraint(Parcel parcel) {
        super(parcel);
        this.settingString = "";
        this.valueString = "";
        this.valueType = parcel.readInt();
        this.tableOption = parcel.readInt();
        String readString = parcel.readString();
        this.settingString = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.valueString = readString2 != null ? readString2 : "";
        this.equalityCheckOption = parcel.readInt();
    }

    /* compiled from: SystemSettingConstraint.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String[] a() {
            return new String[]{"System", "Secure", "Global"};
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String[] b() {
            String r4 = SelectableItem.r(R.string.action_system_setting_type_integer);
            Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.actio…tem_setting_type_integer)");
            Locale locale = Locale.ROOT;
            String lowerCase = r4.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            String r5 = SelectableItem.r(R.string.action_system_setting_type_floating_point_number);
            Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.actio…pe_floating_point_number)");
            String r6 = SelectableItem.r(R.string.action_system_setting_type_long_number);
            Intrinsics.checkNotNullExpressionValue(r6, "getString(R.string.actio…setting_type_long_number)");
            String r7 = SelectableItem.r(R.string.action_system_setting_type_string);
            Intrinsics.checkNotNullExpressionValue(r7, "getString(R.string.actio…stem_setting_type_string)");
            String lowerCase2 = r7.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return new String[]{lowerCase, r5, r6, lowerCase2};
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
