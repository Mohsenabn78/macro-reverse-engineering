package com.arlosoft.macrodroid.common;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.serialization.Exclude;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.VariableUpdatedEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MacroDroidVariable.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nMacroDroidVariable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MacroDroidVariable.kt\ncom/arlosoft/macrodroid/common/MacroDroidVariable\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,633:1\n1855#2,2:634\n1855#2,2:636\n1855#2,2:638\n1855#2,2:640\n1855#2,2:642\n1855#2,2:644\n1855#2,2:646\n*S KotlinDebug\n*F\n+ 1 MacroDroidVariable.kt\ncom/arlosoft/macrodroid/common/MacroDroidVariable\n*L\n127#1:634,2\n148#1:636,2\n170#1:638,2\n191#1:640,2\n212#1:642,2\n423#1:644,2\n496#1:646,2\n*E\n"})
/* loaded from: classes3.dex */
public final class MacroDroidVariable implements Parcelable, Comparable<MacroDroidVariable> {
    @NotNull
    public static final String ARRAY_KEY_HEADING = "<[_array_]>";
    @NotNull
    public static final String ARRAY_KEY_HEADING_USER_FRIENDLY = "_A_";
    private static final int MAX_CHARS_STRING = 500000;
    public static final int TYPE_ARRAY = 5;
    public static final int TYPE_ARRAY_ENTRY = 12;
    public static final int TYPE_BOOLEAN = 0;
    public static final int TYPE_DECIMAL = 3;
    public static final int TYPE_DICTIONARY = 4;
    public static final int TYPE_DICTIONARY_ENTRY = 11;
    public static final int TYPE_INTEGER = 1;
    public static final int TYPE_STRING = 2;
    @Exclude

    /* renamed from: a */
    private int f9869a;
    @Exclude

    /* renamed from: b */
    private int f9870b;
    @NotNull
    private VariableValue.Dictionary dictionary;
    private boolean isActionBlockWorkingVar;
    @SerializedName(alternate = {"isLocal"}, value = "isLocalVar")
    private boolean isLocalVar;
    private boolean m_booleanValue;
    private double m_decimalValue;
    private long m_intValue;
    @NotNull
    private String m_name;
    @NotNull
    private String m_stringValue;
    private int m_type;
    private boolean supportsInput;
    @SerializedName(alternate = {"supportOutput"}, value = "supportsOutput")
    private boolean supportsOutput;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<MacroDroidVariable> CREATOR = new Parcelable.Creator<MacroDroidVariable>() { // from class: com.arlosoft.macrodroid.common.MacroDroidVariable$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MacroDroidVariable createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MacroDroidVariable(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MacroDroidVariable[] newArray(int i4) {
            return new MacroDroidVariable[i4];
        }
    };

    /* compiled from: MacroDroidVariable.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final String getRawKeyName(@NotNull String keyName) {
            boolean startsWith$default;
            boolean startsWith$default2;
            Intrinsics.checkNotNullParameter(keyName, "keyName");
            startsWith$default = kotlin.text.m.startsWith$default(keyName, MacroDroidVariable.ARRAY_KEY_HEADING, false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = kotlin.text.m.startsWith$default(keyName, MacroDroidVariable.ARRAY_KEY_HEADING_USER_FRIENDLY, false, 2, null);
                if (startsWith$default2) {
                    String substring = keyName.substring(3);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    return substring;
                }
                return keyName;
            }
            String substring2 = keyName.substring(11);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            return substring2;
        }

        @JvmStatic
        @NotNull
        public final String getTypeAsString(@NotNull Context context, int i4) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (i4 < 0) {
                return "";
            }
            return VariableHelper.getVariableTypesList(context).get(i4);
        }
    }

    /* compiled from: MacroDroidVariable.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<VariableValue.DictionaryEntry, CharSequence> {

        /* renamed from: d */
        public static final a f9871d = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull VariableValue.DictionaryEntry it) {
            Intrinsics.checkNotNullParameter(it, "it");
            String key = it.getKey();
            String valueAsText = it.getVariable().getValueAsText();
            return "[" + key + "]: " + valueAsText;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MacroDroidVariable.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<VariableValue.DictionaryEntry, CharSequence> {

        /* renamed from: d */
        public static final b f9872d = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull VariableValue.DictionaryEntry it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getVariable().getValueAsText();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MacroDroidVariable.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<VariableValue.DictionaryEntry, CharSequence> {

        /* renamed from: d */
        public static final c f9873d = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull VariableValue.DictionaryEntry it) {
            Intrinsics.checkNotNullParameter(it, "it");
            String key = it.getKey();
            String valueAsText = it.getVariable().getValueAsText();
            return "[" + key + "]: " + valueAsText;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MacroDroidVariable(int i4, @NotNull String name) {
        this(i4, name, false, 4, null);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    private final boolean a(VariableValue.Dictionary dictionary) {
        for (VariableValue.DictionaryEntry dictionaryEntry : dictionary.getEntries()) {
            if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                VariableValue variable = dictionaryEntry.getVariable();
                Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                if (((VariableValue.Dictionary) variable).isArray()) {
                    return true;
                }
            }
            if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                VariableValue variable2 = dictionaryEntry.getVariable();
                Intrinsics.checkNotNull(variable2, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                if (a((VariableValue.Dictionary) variable2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean b(VariableValue.Dictionary dictionary) {
        for (VariableValue.DictionaryEntry dictionaryEntry : dictionary.getEntries()) {
            if (dictionaryEntry.getVariable() instanceof VariableValue.BooleanValue) {
                return true;
            }
            if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                VariableValue variable = dictionaryEntry.getVariable();
                Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                if (b((VariableValue.Dictionary) variable)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean c(VariableValue.Dictionary dictionary) {
        for (VariableValue.DictionaryEntry dictionaryEntry : dictionary.getEntries()) {
            if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                VariableValue variable = dictionaryEntry.getVariable();
                Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                if (!((VariableValue.Dictionary) variable).isArray()) {
                    return true;
                }
            }
            if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                VariableValue variable2 = dictionaryEntry.getVariable();
                Intrinsics.checkNotNull(variable2, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                if (c((VariableValue.Dictionary) variable2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean d(VariableValue.Dictionary dictionary) {
        for (VariableValue.DictionaryEntry dictionaryEntry : dictionary.getEntries()) {
            if (!(dictionaryEntry.getVariable() instanceof VariableValue.IntegerValue) && !(dictionaryEntry.getVariable() instanceof VariableValue.DecimalValue)) {
                if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                    VariableValue variable = dictionaryEntry.getVariable();
                    Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                    if (d((VariableValue.Dictionary) variable)) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    private final boolean e(VariableValue.Dictionary dictionary) {
        for (VariableValue.DictionaryEntry dictionaryEntry : dictionary.getEntries()) {
            if (dictionaryEntry.getVariable() instanceof VariableValue.StringValue) {
                return true;
            }
            if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                VariableValue variable = dictionaryEntry.getVariable();
                Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                if (e((VariableValue.Dictionary) variable)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final Double f(List<String> list) {
        boolean z3;
        List<String> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            return Double.valueOf(getDecimalValue());
        }
        VariableValue.DictionaryEntry targetDictionaryEntry = getTargetDictionaryEntry(list, false);
        if (targetDictionaryEntry != null && (targetDictionaryEntry.getVariable() instanceof VariableValue.DecimalValue)) {
            VariableValue variable = targetDictionaryEntry.getVariable();
            Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.DecimalValue");
            return Double.valueOf(((VariableValue.DecimalValue) variable).getDecimalValue());
        } else if (targetDictionaryEntry != null && (targetDictionaryEntry.getVariable() instanceof VariableValue.IntegerValue)) {
            VariableValue variable2 = targetDictionaryEntry.getVariable();
            Intrinsics.checkNotNull(variable2, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.IntegerValue");
            return Double.valueOf(((VariableValue.IntegerValue) variable2).getIntValue());
        } else {
            return null;
        }
    }

    private final void g(VariableValue variableValue, VariableValue.DictionaryEntry dictionaryEntry) {
        if (variableValue.getParentKeys() != null && dictionaryEntry != null) {
            if (variableValue instanceof VariableValue.BooleanValue) {
                dictionaryEntry.setVariable(new VariableValue.BooleanValue(((VariableValue.BooleanValue) variableValue).getBooleanValue(), null, 2, null));
            } else if (variableValue instanceof VariableValue.IntegerValue) {
                dictionaryEntry.setVariable(new VariableValue.IntegerValue(((VariableValue.IntegerValue) variableValue).getIntValue(), null, 2, null));
            } else if (variableValue instanceof VariableValue.StringValue) {
                dictionaryEntry.setVariable(new VariableValue.StringValue(((VariableValue.StringValue) variableValue).getTextValue(), null, 2, null));
            } else if (variableValue instanceof VariableValue.DecimalValue) {
                dictionaryEntry.setVariable(new VariableValue.DecimalValue(((VariableValue.DecimalValue) variableValue).getDecimalValue(), null, 2, null));
            } else if (variableValue instanceof VariableValue.Dictionary) {
                VariableValue.Dictionary dictionary = (VariableValue.Dictionary) variableValue;
                dictionaryEntry.setVariable(new VariableValue.Dictionary(dictionary.getEntries(), dictionary.isArray(), null, 4, null));
            }
        }
    }

    public static /* synthetic */ VariableValue.Dictionary getDictionaryFromKeyList$default(MacroDroidVariable macroDroidVariable, List list, boolean z3, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        return macroDroidVariable.getDictionaryFromKeyList(list, z3, z4);
    }

    @JvmStatic
    @NotNull
    public static final String getRawKeyName(@NotNull String str) {
        return Companion.getRawKeyName(str);
    }

    @JvmStatic
    @NotNull
    public static final String getTypeAsString(@NotNull Context context, int i4) {
        return Companion.getTypeAsString(context, i4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean getBooleanValue() {
        return this.m_booleanValue;
    }

    public final double getDecimalValue() {
        if (this.m_type == 1) {
            return this.m_intValue;
        }
        return this.m_decimalValue;
    }

    @NotNull
    public final VariableValue.Dictionary getDictionary() {
        return this.dictionary;
    }

    @Nullable
    public final VariableValue.DictionaryEntry getDictionaryEntryFromKeyList(@NotNull List<String> keyList) {
        Intrinsics.checkNotNullParameter(keyList, "keyList");
        VariableValue.Dictionary dictionary = this.dictionary;
        for (String str : keyList) {
            VariableValue.DictionaryEntry entry = dictionary.getEntry(str);
            if (entry != null && (entry.getVariable() instanceof VariableValue.Dictionary)) {
                VariableValue variable = entry.getVariable();
                Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                dictionary = (VariableValue.Dictionary) variable;
            } else {
                return entry;
            }
        }
        return null;
    }

    @NotNull
    public final VariableValue.Dictionary getDictionaryFromKeyList(@NotNull List<String> keyList, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(keyList, "keyList");
        if (keyList.isEmpty()) {
            return this.dictionary;
        }
        VariableValue.DictionaryEntry targetDictionaryEntry = getTargetDictionaryEntry(keyList, z3);
        if (targetDictionaryEntry != null && (targetDictionaryEntry.getVariable() instanceof VariableValue.Dictionary)) {
            VariableValue variable = targetDictionaryEntry.getVariable();
            Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
            return (VariableValue.Dictionary) variable;
        }
        VariableValue.Dictionary dictionary = new VariableValue.Dictionary(new ArrayList(), z4, null, 4, null);
        if (targetDictionaryEntry != null) {
            targetDictionaryEntry.setVariable(dictionary);
        }
        return dictionary;
    }

    public final boolean getHasArrayChildren() {
        int i4 = this.m_type;
        if (i4 != 4 && i4 != 5) {
            return false;
        }
        return a(this.dictionary);
    }

    public final boolean getHasBooleanChildren() {
        int i4 = this.m_type;
        if (i4 != 4 && i4 != 5) {
            return false;
        }
        return b(this.dictionary);
    }

    public final boolean getHasDictionaryChildren() {
        int i4 = this.m_type;
        if (i4 != 4 && i4 != 5) {
            return false;
        }
        return c(this.dictionary);
    }

    public final boolean getHasNumericalChildren() {
        int i4 = this.m_type;
        if (i4 != 4 && i4 != 5) {
            return false;
        }
        return d(this.dictionary);
    }

    public final boolean getHasNumericalValue() {
        int i4 = this.m_type;
        if (i4 == 1 || i4 == 3) {
            return true;
        }
        return false;
    }

    public final boolean getHasStringChildren() {
        int i4 = this.m_type;
        if (i4 != 4 && i4 != 5) {
            return false;
        }
        return e(this.dictionary);
    }

    public final long getLongValue() {
        if (this.m_type == 3) {
            return (long) this.m_decimalValue;
        }
        return this.m_intValue;
    }

    @NotNull
    public final String getName() {
        return this.m_name;
    }

    @Nullable
    public final Double getNumericalValue(@Nullable DictionaryKeys dictionaryKeys) {
        List<String> list;
        if (dictionaryKeys != null) {
            list = dictionaryKeys.getKeys();
        } else {
            list = null;
        }
        return f(list);
    }

    @NotNull
    public final String getStringNoTranslation() {
        if (this.m_type == 0) {
            boolean z3 = this.m_booleanValue;
            StringBuilder sb = new StringBuilder();
            sb.append(z3);
            return sb.toString();
        }
        return toString();
    }

    @NotNull
    public final String getStringValue() {
        boolean contains$default;
        boolean contains$default2;
        String str = this.m_stringValue;
        String str2 = this.m_name;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) ("[lv=" + str2 + "]"), false, 2, (Object) null);
        if (!contains$default) {
            String str3 = this.m_stringValue;
            String name = getName();
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) ("[v=" + name + "]"), false, 2, (Object) null);
            if (!contains$default2) {
                String replaceMagicText = MagicText.replaceMagicText(MacroDroidApplication.Companion.getInstance(), this.m_stringValue, null, null);
                Intrinsics.checkNotNullExpressionValue(replaceMagicText, "{\n            MagicText.…ue, null, null)\n        }");
                return replaceMagicText;
            }
        }
        return this.m_stringValue;
    }

    @NotNull
    public final String getStringValueIgnoreMagicText() {
        return this.m_stringValue;
    }

    public final boolean getSupportsInput() {
        return this.supportsInput;
    }

    public final boolean getSupportsOutput() {
        return this.supportsOutput;
    }

    @Nullable
    public final VariableValue.DictionaryEntry getTargetDictionaryEntry(@Nullable List<String> list, boolean z3) {
        boolean z4;
        boolean startsWith$default;
        boolean startsWith$default2;
        List<String> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            return null;
        }
        VariableValue.Dictionary dictionary = this.dictionary;
        VariableValue.DictionaryEntry dictionaryEntry = null;
        for (int i4 = 0; i4 < list.size(); i4++) {
            Companion companion = Companion;
            VariableValue.DictionaryEntry entry = dictionary.getEntry(companion.getRawKeyName(list.get(i4)));
            if (entry == null) {
                if (z3) {
                    startsWith$default = kotlin.text.m.startsWith$default(list.get(i4), ARRAY_KEY_HEADING, false, 2, null);
                    if (!startsWith$default) {
                        startsWith$default2 = kotlin.text.m.startsWith$default(list.get(i4), ARRAY_KEY_HEADING_USER_FRIENDLY, false, 2, null);
                        if (!startsWith$default2) {
                            dictionaryEntry = new VariableValue.DictionaryEntry(list.get(i4), new VariableValue.Dictionary(new ArrayList(), false, null, 6, null), null, 4, null);
                            dictionary.setEntry(dictionaryEntry);
                        }
                    }
                    dictionaryEntry = new VariableValue.DictionaryEntry(companion.getRawKeyName(list.get(i4)), new VariableValue.Dictionary(new ArrayList(), true, null, 4, null), null, 4, null);
                    dictionary.setEntry(dictionaryEntry);
                } else {
                    return null;
                }
            } else {
                dictionaryEntry = entry;
            }
            if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                VariableValue variable = dictionaryEntry.getVariable();
                Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                dictionary = (VariableValue.Dictionary) variable;
            }
        }
        return dictionaryEntry;
    }

    public final int getType() {
        int i4 = this.f9869a;
        if (i4 != 0) {
            this.m_type = i4;
            this.f9869a = 0;
        } else {
            int i5 = this.f9870b;
            if (i5 != 0) {
                this.m_type = i5;
                this.f9870b = 0;
            }
        }
        return this.m_type;
    }

    public final int getValueAsInt() {
        return (int) getLongValue();
    }

    @NotNull
    public final VariableValue getVariableValue() {
        int type = getType();
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type != 4 && type != 5) {
                            int type2 = getType();
                            throw new IllegalArgumentException("Invalid variable type: " + type2);
                        }
                        return this.dictionary;
                    }
                    return new VariableValue.DecimalValue(getDecimalValue(), null, 2, null);
                }
                return new VariableValue.StringValue(getStringValue(), null, 2, null);
            }
            return new VariableValue.IntegerValue(getLongValue(), null, 2, null);
        }
        return new VariableValue.BooleanValue(getBooleanValue(), null, 2, null);
    }

    @NotNull
    public final VariableValue getVariableValueNoMagicText() {
        int type = getType();
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type != 4 && type != 5) {
                            int type2 = getType();
                            throw new IllegalArgumentException("Invalid variable type: " + type2);
                        }
                        return this.dictionary;
                    }
                    return new VariableValue.DecimalValue(getDecimalValue(), null, 2, null);
                }
                return new VariableValue.StringValue(getStringValueIgnoreMagicText(), null, 2, null);
            }
            return new VariableValue.IntegerValue(getLongValue(), null, 2, null);
        }
        return new VariableValue.BooleanValue(getBooleanValue(), null, 2, null);
    }

    public final boolean isActionBlockWorkingVar() {
        return this.isActionBlockWorkingVar;
    }

    public final boolean isArray() {
        if (this.m_type == 5) {
            return true;
        }
        return false;
    }

    public final boolean isBoolean() {
        if (this.m_type == 0) {
            return true;
        }
        return false;
    }

    public final boolean isBooleanValue(@Nullable List<String> list) {
        boolean z3;
        List<String> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            if (this.m_type == 0) {
                return true;
            }
            return false;
        }
        VariableValue.DictionaryEntry targetDictionaryEntry = getTargetDictionaryEntry(list, false);
        if (targetDictionaryEntry != null && (targetDictionaryEntry.getVariable() instanceof VariableValue.BooleanValue)) {
            return true;
        }
        return false;
    }

    public final boolean isDecimal() {
        if (this.m_type == 3) {
            return true;
        }
        return false;
    }

    public final boolean isDictionary() {
        if (this.m_type == 4) {
            return true;
        }
        return false;
    }

    public final boolean isInt() {
        if (this.m_type == 1) {
            return true;
        }
        return false;
    }

    public final boolean isLocalVar() {
        return this.isLocalVar;
    }

    public final boolean isString() {
        if (this.m_type == 2) {
            return true;
        }
        return false;
    }

    public final void setDictionary(@NotNull VariableValue.Dictionary dictionary) {
        Intrinsics.checkNotNullParameter(dictionary, "<set-?>");
        this.dictionary = dictionary;
    }

    public final void setIsActionBlockWorkingVar(boolean z3) {
        this.isActionBlockWorkingVar = z3;
    }

    public final void setIsInput(boolean z3) {
        this.supportsInput = z3;
        this.supportsOutput = !z3;
    }

    public final void setLocalVar(boolean z3) {
        this.isLocalVar = z3;
    }

    public final void setName(@NotNull String newName) {
        Intrinsics.checkNotNullParameter(newName, "newName");
        this.m_name = newName;
    }

    public final void setVariableValue(@NotNull VariableValue variableValue, boolean z3, @Nullable VariableValue variableValue2, @Nullable Macro macro) {
        boolean z4;
        Iterator<T> it;
        long j4;
        VariableValue.IntegerValue integerValue;
        Intrinsics.checkNotNullParameter(variableValue, "variableValue");
        String name = getName();
        List<String> parentKeys = variableValue.getParentKeys();
        if (parentKeys != null && !parentKeys.isEmpty()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4) {
            if (variableValue instanceof VariableValue.BooleanValue) {
                this.m_booleanValue = ((VariableValue.BooleanValue) variableValue).getBooleanValue();
            } else if (variableValue instanceof VariableValue.IntegerValue) {
                this.m_decimalValue = integerValue.getIntValue();
                this.m_intValue = ((VariableValue.IntegerValue) variableValue).getIntValue();
            } else if (variableValue instanceof VariableValue.StringValue) {
                this.m_stringValue = ((VariableValue.StringValue) variableValue).getTextValue();
            } else if (variableValue instanceof VariableValue.DecimalValue) {
                this.m_decimalValue = ((VariableValue.DecimalValue) variableValue).getDecimalValue();
            } else if (variableValue instanceof VariableValue.Dictionary) {
                this.dictionary = (VariableValue.Dictionary) variableValue;
            }
        } else {
            List<String> parentKeys2 = variableValue.getParentKeys();
            Intrinsics.checkNotNull(parentKeys2);
            VariableValue.DictionaryEntry targetDictionaryEntry = getTargetDictionaryEntry(parentKeys2, true);
            List<String> parentKeys3 = variableValue.getParentKeys();
            Intrinsics.checkNotNull(parentKeys3);
            while (parentKeys3.iterator().hasNext()) {
                name = ((Object) name) + "[" + ((String) it.next()) + "]";
            }
            g(variableValue, targetDictionaryEntry);
        }
        String str = name;
        if (z3 && variableValue2 != null && !Intrinsics.areEqual(variableValue2.getValueAsText(), variableValue.getValueAsText())) {
            String valueAsText = variableValue2.getValueAsText();
            String valueAsText2 = variableValue.getValueAsText();
            if (macro != null) {
                j4 = macro.getGUID();
            } else {
                j4 = 0;
            }
            SystemLog.logVariableChange(str, valueAsText, valueAsText2, j4, this.isLocalVar);
        }
        EventBusUtils.getEventBus().post(new VariableUpdatedEvent());
    }

    @NotNull
    public String toString() {
        int i4;
        String joinToString$default;
        int i5 = this.m_type;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 == 4 || i5 == 5) {
                            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.dictionary.getEntriesSorted(), "\n", null, null, 0, null, a.f9871d, 30, null);
                            return joinToString$default;
                        }
                        return "";
                    }
                    double d4 = this.m_decimalValue;
                    StringBuilder sb = new StringBuilder();
                    sb.append(d4);
                    return sb.toString();
                }
                return getStringValue();
            }
            long j4 = this.m_intValue;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(j4);
            return sb2.toString();
        }
        MacroDroidApplication companion = MacroDroidApplication.Companion.getInstance();
        if (this.m_booleanValue) {
            i4 = R.string.true_label;
        } else {
            i4 = R.string.false_label;
        }
        String string = companion.getString(i4);
        Intrinsics.checkNotNullExpressionValue(string, "MacroDroidApplication.in…lse R.string.false_label)");
        return string;
    }

    @NotNull
    public final String toStringArrayDictionaryCommaSeparator() {
        int i4;
        String joinToString$default;
        int i5 = this.m_type;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 == 4 || i5 == 5) {
                            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.dictionary.getEntriesSorted(), ",", null, null, 0, null, b.f9872d, 30, null);
                            return joinToString$default;
                        }
                        return "";
                    }
                    double d4 = this.m_decimalValue;
                    StringBuilder sb = new StringBuilder();
                    sb.append(d4);
                    return sb.toString();
                }
                return getStringValueIgnoreMagicText();
            }
            long j4 = this.m_intValue;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(j4);
            return sb2.toString();
        }
        MacroDroidApplication companion = MacroDroidApplication.Companion.getInstance();
        if (this.m_booleanValue) {
            i4 = R.string.true_label;
        } else {
            i4 = R.string.false_label;
        }
        String string = companion.getString(i4);
        Intrinsics.checkNotNullExpressionValue(string, "MacroDroidApplication.in…lse R.string.false_label)");
        return string;
    }

    @NotNull
    public final String toStringNoMagicText() {
        int i4;
        String joinToString$default;
        int i5 = this.m_type;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 == 4 || i5 == 5) {
                            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.dictionary.getEntriesSorted(), "\n", null, null, 0, null, c.f9873d, 30, null);
                            return joinToString$default;
                        }
                        return "";
                    }
                    double d4 = this.m_decimalValue;
                    StringBuilder sb = new StringBuilder();
                    sb.append(d4);
                    return sb.toString();
                }
                return getStringValueIgnoreMagicText();
            }
            long j4 = this.m_intValue;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(j4);
            return sb2.toString();
        }
        MacroDroidApplication companion = MacroDroidApplication.Companion.getInstance();
        if (this.m_booleanValue) {
            i4 = R.string.true_label;
        } else {
            i4 = R.string.false_label;
        }
        String string = companion.getString(i4);
        Intrinsics.checkNotNullExpressionValue(string, "MacroDroidApplication.in…lse R.string.false_label)");
        return string;
    }

    @NotNull
    public final String toStringNoMagicTextNoDictionaries() {
        int i4;
        int i5 = this.m_type;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4 && i5 != 5) {
                            return "";
                        }
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String string = MacroDroidApplication.Companion.getInstance().getString(R.string.variable_multi_entry_num_entries);
                        Intrinsics.checkNotNullExpressionValue(string, "MacroDroidApplication.in…_multi_entry_num_entries)");
                        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.dictionary.getEntries().size())}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        return format;
                    }
                    double d4 = this.m_decimalValue;
                    StringBuilder sb = new StringBuilder();
                    sb.append(d4);
                    return sb.toString();
                }
                return getStringValueIgnoreMagicText();
            }
            long j4 = this.m_intValue;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(j4);
            return sb2.toString();
        }
        MacroDroidApplication companion = MacroDroidApplication.Companion.getInstance();
        if (this.m_booleanValue) {
            i4 = R.string.true_label;
        } else {
            i4 = R.string.false_label;
        }
        String string2 = companion.getString(i4);
        Intrinsics.checkNotNullExpressionValue(string2, "MacroDroidApplication.in…lse R.string.false_label)");
        return string2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.m_type);
        out.writeLong(this.m_intValue);
        out.writeInt(this.m_booleanValue ? 1 : 0);
        out.writeString(this.m_stringValue);
        out.writeString(this.m_name);
        out.writeDouble(this.m_decimalValue);
        out.writeInt(this.isLocalVar ? 1 : 0);
        out.writeInt(this.supportsInput ? 1 : 0);
        out.writeInt(this.supportsOutput ? 1 : 0);
        out.writeInt(this.isActionBlockWorkingVar ? 1 : 0);
        out.writeParcelable(this.dictionary, i4);
    }

    public /* synthetic */ MacroDroidVariable(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull MacroDroidVariable other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.m_name.compareTo(other.getName());
    }

    public final boolean getBooleanValue(@Nullable List<String> list) {
        List<String> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return getBooleanValue();
        }
        VariableValue.DictionaryEntry targetDictionaryEntry = getTargetDictionaryEntry(list, false);
        if (targetDictionaryEntry == null || !(targetDictionaryEntry.getVariable() instanceof VariableValue.BooleanValue)) {
            return false;
        }
        VariableValue variable = targetDictionaryEntry.getVariable();
        Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.BooleanValue");
        return ((VariableValue.BooleanValue) variable).getBooleanValue();
    }

    @NotNull
    public final String getTypeAsString(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return VariableHelper.getVariableTypesList(context).get(getType());
    }

    public MacroDroidVariable() {
        this.m_stringValue = "";
        this.m_name = "";
        this.dictionary = new VariableValue.Dictionary(new ArrayList(), false, null, 6, null);
        this.supportsInput = true;
        this.supportsOutput = true;
    }

    @Nullable
    public final Double getDecimalValue(@Nullable List<String> list) {
        List<String> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return Double.valueOf(getDecimalValue());
        }
        VariableValue.DictionaryEntry targetDictionaryEntry = getTargetDictionaryEntry(list, false);
        if (targetDictionaryEntry == null || !(targetDictionaryEntry.getVariable() instanceof VariableValue.DecimalValue)) {
            return null;
        }
        VariableValue variable = targetDictionaryEntry.getVariable();
        Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.DecimalValue");
        return Double.valueOf(((VariableValue.DecimalValue) variable).getDecimalValue());
    }

    @Nullable
    public final Long getLongValue(@Nullable List<String> list) {
        List<String> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return Long.valueOf(getLongValue());
        }
        VariableValue.DictionaryEntry targetDictionaryEntry = getTargetDictionaryEntry(list, false);
        if ((targetDictionaryEntry != null ? targetDictionaryEntry.getVariable() : null) != null) {
            if (targetDictionaryEntry.getVariable() instanceof VariableValue.IntegerValue) {
                VariableValue variable = targetDictionaryEntry.getVariable();
                Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.IntegerValue");
                return Long.valueOf(((VariableValue.IntegerValue) variable).getIntValue());
            } else if (targetDictionaryEntry.getVariable() instanceof VariableValue.DecimalValue) {
                VariableValue variable2 = targetDictionaryEntry.getVariable();
                Intrinsics.checkNotNull(variable2, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.DecimalValue");
                return Long.valueOf((long) ((VariableValue.DecimalValue) variable2).getDecimalValue());
            }
        } else {
            SystemLog.logError("No entry for keys: " + list);
        }
        return null;
    }

    @Nullable
    public final String getStringValue(@Nullable List<String> list) {
        List<String> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return getStringValue();
        }
        VariableValue.DictionaryEntry targetDictionaryEntry = getTargetDictionaryEntry(list, false);
        if (targetDictionaryEntry == null || !(targetDictionaryEntry.getVariable() instanceof VariableValue.StringValue)) {
            return null;
        }
        VariableValue variable = targetDictionaryEntry.getVariable();
        Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.StringValue");
        return ((VariableValue.StringValue) variable).getTextValue();
    }

    public final boolean getBooleanValue(@Nullable DictionaryKeys dictionaryKeys) {
        if (dictionaryKeys == null) {
            return getBooleanValue();
        }
        return getBooleanValue(dictionaryKeys.getKeys());
    }

    @Nullable
    public final Double getDecimalValue(@Nullable DictionaryKeys dictionaryKeys) {
        if (dictionaryKeys == null) {
            return Double.valueOf(getDecimalValue());
        }
        return getDecimalValue(dictionaryKeys.getKeys());
    }

    @JvmOverloads
    public MacroDroidVariable(int i4, @NotNull String name, boolean z3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.m_stringValue = "";
        this.m_name = "";
        this.dictionary = new VariableValue.Dictionary(new ArrayList(), false, null, 6, null);
        this.supportsInput = true;
        this.supportsOutput = true;
        this.m_type = i4;
        this.m_name = name;
        this.m_stringValue = "";
        this.isLocalVar = z3;
        this.dictionary = new VariableValue.Dictionary(new ArrayList(), i4 == 5, null, 4, null);
    }

    @Nullable
    public final String getStringValue(@Nullable DictionaryKeys dictionaryKeys) {
        if (dictionaryKeys == null) {
            return getStringValue();
        }
        return getStringValue(dictionaryKeys.getKeys());
    }

    @Nullable
    public final Long getLongValue(@Nullable DictionaryKeys dictionaryKeys) {
        if (dictionaryKeys == null) {
            return Long.valueOf(getLongValue());
        }
        return getLongValue(dictionaryKeys.getKeys());
    }

    public /* synthetic */ MacroDroidVariable(int i4, String str, boolean z3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i4, str, (i5 & 4) != 0 ? false : z3);
    }

    private MacroDroidVariable(Parcel parcel) {
        this.m_stringValue = "";
        this.m_name = "";
        this.dictionary = new VariableValue.Dictionary(new ArrayList(), false, null, 6, null);
        this.supportsInput = true;
        this.supportsOutput = true;
        this.m_type = parcel.readInt();
        this.m_intValue = parcel.readLong();
        this.m_booleanValue = parcel.readInt() != 0;
        String readString = parcel.readString();
        this.m_stringValue = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.m_name = readString2 != null ? readString2 : "";
        this.m_decimalValue = parcel.readDouble();
        this.isLocalVar = parcel.readInt() != 0;
        this.supportsInput = parcel.readInt() != 0;
        this.supportsOutput = parcel.readInt() != 0;
        this.isActionBlockWorkingVar = parcel.readInt() != 0;
        VariableValue.Dictionary dictionary = (VariableValue.Dictionary) parcel.readParcelable(VariableValue.Dictionary.class.getClassLoader());
        this.dictionary = dictionary == null ? new VariableValue.Dictionary(new ArrayList(), false, null, 6, null) : dictionary;
    }
}
