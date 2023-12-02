package com.arlosoft.macrodroid.variables;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VariableValue.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public abstract class VariableValue implements Parcelable {
    @Nullable
    private List<String> parentKeys;
    @NotNull
    private final String type;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: VariableValue.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    /* loaded from: classes3.dex */
    public static final class BooleanValue extends VariableValue {
        private final boolean booleanValue;
        @Nullable
        private final List<String> parents;
        private final int variableType;
        @NotNull
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        @NotNull
        public static final Parcelable.Creator<BooleanValue> CREATOR = new Creator();

        /* compiled from: VariableValue.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ VariableValue getValueFromString$default(Companion companion, String str, List list, int i4, Object obj) {
                if ((i4 & 2) != 0) {
                    list = null;
                }
                return companion.getValueFromString(str, list);
            }

            @NotNull
            public final VariableValue getValueFromString(@NotNull String stringValue, @Nullable List<String> list) {
                boolean equals;
                Intrinsics.checkNotNullParameter(stringValue, "stringValue");
                String lowerCase = stringValue.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                boolean z3 = true;
                if (!Intrinsics.areEqual(lowerCase, "true")) {
                    equals = kotlin.text.m.equals(stringValue, MacroDroidApplication.Companion.getInstance().getString(R.string.true_label), true);
                    if (!equals) {
                        z3 = false;
                    }
                }
                return new BooleanValue(z3, list);
            }
        }

        /* compiled from: VariableValue.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<BooleanValue> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final BooleanValue createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new BooleanValue(parcel.readInt() != 0, parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final BooleanValue[] newArray(int i4) {
                return new BooleanValue[i4];
            }
        }

        public BooleanValue() {
            this(false, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BooleanValue copy$default(BooleanValue booleanValue, boolean z3, List list, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                z3 = booleanValue.booleanValue;
            }
            if ((i4 & 2) != 0) {
                list = booleanValue.parents;
            }
            return booleanValue.copy(z3, list);
        }

        public final boolean component1() {
            return this.booleanValue;
        }

        @Nullable
        public final List<String> component2() {
            return this.parents;
        }

        @NotNull
        public final BooleanValue copy(boolean z3, @Nullable List<String> list) {
            return new BooleanValue(z3, list);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            BooleanValue booleanValue;
            if (obj instanceof BooleanValue) {
                booleanValue = (BooleanValue) obj;
            } else {
                booleanValue = null;
            }
            if (booleanValue == null || this.booleanValue != booleanValue.booleanValue) {
                return false;
            }
            return true;
        }

        public final boolean getBooleanValue() {
            return this.booleanValue;
        }

        @Nullable
        public final List<String> getParents() {
            return this.parents;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        @NotNull
        public String getValueAsText() {
            return String.valueOf(this.booleanValue);
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        public int getVariableType() {
            return this.variableType;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            int hashCode;
            boolean z3 = this.booleanValue;
            ?? r02 = z3;
            if (z3) {
                r02 = 1;
            }
            int i4 = r02 * 31;
            List<String> list = this.parents;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            return i4 + hashCode;
        }

        @NotNull
        public String toString() {
            boolean z3 = this.booleanValue;
            List<String> list = this.parents;
            return "BooleanValue(booleanValue=" + z3 + ", parents=" + list + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(this.booleanValue ? 1 : 0);
            out.writeStringList(this.parents);
        }

        public BooleanValue(boolean z3, @Nullable List<String> list) {
            super(list, null);
            this.booleanValue = z3;
            this.parents = list;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        @NotNull
        public VariableValue copy() {
            return new BooleanValue(this.booleanValue, this.parents);
        }

        public /* synthetic */ BooleanValue(boolean z3, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? false : z3, (i4 & 2) != 0 ? null : list);
        }
    }

    /* compiled from: VariableValue.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    /* loaded from: classes3.dex */
    public static final class DecimalValue extends VariableValue {
        private final double decimalValue;
        @Nullable
        private final List<String> parents;
        private final int variableType;
        @NotNull
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        @NotNull
        public static final Parcelable.Creator<DecimalValue> CREATOR = new Creator();

        /* compiled from: VariableValue.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ VariableValue getValueFromString$default(Companion companion, String str, List list, int i4, Object obj) {
                if ((i4 & 2) != 0) {
                    list = null;
                }
                return companion.getValueFromString(str, list);
            }

            @NotNull
            public final VariableValue getValueFromString(@NotNull String stringValue, @Nullable List<String> list) {
                Double doubleOrNull;
                double d4;
                Intrinsics.checkNotNullParameter(stringValue, "stringValue");
                doubleOrNull = kotlin.text.k.toDoubleOrNull(stringValue);
                if (doubleOrNull != null) {
                    d4 = doubleOrNull.doubleValue();
                } else {
                    d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                }
                return new DecimalValue(d4, list);
            }
        }

        /* compiled from: VariableValue.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<DecimalValue> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final DecimalValue createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DecimalValue(parcel.readDouble(), parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final DecimalValue[] newArray(int i4) {
                return new DecimalValue[i4];
            }
        }

        public DecimalValue() {
            this(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DecimalValue copy$default(DecimalValue decimalValue, double d4, List list, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                d4 = decimalValue.decimalValue;
            }
            if ((i4 & 2) != 0) {
                list = decimalValue.parents;
            }
            return decimalValue.copy(d4, list);
        }

        public final double component1() {
            return this.decimalValue;
        }

        @Nullable
        public final List<String> component2() {
            return this.parents;
        }

        @NotNull
        public final DecimalValue copy(double d4, @Nullable List<String> list) {
            return new DecimalValue(d4, list);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            DecimalValue decimalValue;
            double d4 = this.decimalValue;
            Double d5 = null;
            if (obj instanceof DecimalValue) {
                decimalValue = (DecimalValue) obj;
            } else {
                decimalValue = null;
            }
            if (decimalValue != null) {
                d5 = Double.valueOf(decimalValue.decimalValue);
            }
            return Intrinsics.areEqual(d4, d5);
        }

        public final double getDecimalValue() {
            return this.decimalValue;
        }

        @Nullable
        public final List<String> getParents() {
            return this.parents;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        @NotNull
        public String getValueAsText() {
            return String.valueOf(this.decimalValue);
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        public int getVariableType() {
            return this.variableType;
        }

        public int hashCode() {
            int hashCode;
            int a4 = androidx.compose.animation.core.b.a(this.decimalValue) * 31;
            List<String> list = this.parents;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            return a4 + hashCode;
        }

        @NotNull
        public String toString() {
            double d4 = this.decimalValue;
            List<String> list = this.parents;
            return "DecimalValue(decimalValue=" + d4 + ", parents=" + list + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeDouble(this.decimalValue);
            out.writeStringList(this.parents);
        }

        public DecimalValue(double d4, @Nullable List<String> list) {
            super(list, null);
            this.decimalValue = d4;
            this.parents = list;
            this.variableType = 3;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        @NotNull
        public VariableValue copy() {
            return new DecimalValue(this.decimalValue, this.parents);
        }

        public /* synthetic */ DecimalValue(double d4, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d4, (i4 & 2) != 0 ? null : list);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public DecimalValue(@org.jetbrains.annotations.NotNull java.lang.String r9) {
            /*
                r8 = this;
                java.lang.String r0 = "valueAsString"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                double r0 = java.lang.Double.parseDouble(r9)     // Catch: java.lang.Exception -> Lb
            L9:
                r3 = r0
                goto Le
            Lb:
                r0 = 0
                goto L9
            Le:
                r5 = 0
                r6 = 2
                r7 = 0
                r2 = r8
                r2.<init>(r3, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.variables.VariableValue.DecimalValue.<init>(java.lang.String):void");
        }
    }

    /* compiled from: VariableValue.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    @SourceDebugExtension({"SMAP\nVariableValue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VariableValue.kt\ncom/arlosoft/macrodroid/variables/VariableValue$Dictionary\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,384:1\n1045#2:385\n350#2,7:386\n288#2,2:393\n1864#2,3:395\n766#2:398\n857#2,2:399\n766#2:401\n857#2,2:402\n1855#2,2:404\n1855#2,2:406\n1855#2,2:408\n1855#2,2:410\n1855#2,2:412\n1855#2,2:414\n*S KotlinDebug\n*F\n+ 1 VariableValue.kt\ncom/arlosoft/macrodroid/variables/VariableValue$Dictionary\n*L\n193#1:385\n228#1:386,7\n237#1:393,2\n253#1:395,3\n259#1:398\n259#1:399,2\n265#1:401\n265#1:402,2\n271#1:404,2\n285#1:406,2\n299#1:408,2\n313#1:410,2\n327#1:412,2\n341#1:414,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class Dictionary extends VariableValue {
        public static final int $stable = 8;
        @NotNull
        public static final Parcelable.Creator<Dictionary> CREATOR = new Creator();
        @NotNull
        private final List<DictionaryEntry> entries;
        private final boolean isArray;
        @Nullable
        private final List<String> parents;
        private final int variableType;

        /* compiled from: VariableValue.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Dictionary> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Dictionary createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i4 = 0; i4 != readInt; i4++) {
                    arrayList.add(DictionaryEntry.CREATOR.createFromParcel(parcel));
                }
                return new Dictionary(arrayList, parcel.readInt() != 0, parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Dictionary[] newArray(int i4) {
                return new Dictionary[i4];
            }
        }

        /* compiled from: VariableValue.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function2<DictionaryEntry, DictionaryEntry, Integer> {

            /* renamed from: d */
            public static final a f16297d = new a();

            a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            /* renamed from: a */
            public final Integer mo1invoke(DictionaryEntry dictionaryEntry, DictionaryEntry dictionaryEntry2) {
                int compareTo = StringExtensionsKt.removeNumbersFromEnd(dictionaryEntry.getKey()).compareTo(StringExtensionsKt.removeNumbersFromEnd(dictionaryEntry2.getKey()));
                if (compareTo == 0) {
                    if (StringExtensionsKt.getNumberOnEnd(dictionaryEntry.getKey()) < StringExtensionsKt.getNumberOnEnd(dictionaryEntry2.getKey())) {
                        compareTo = -1;
                    } else if (StringExtensionsKt.getNumberOnEnd(dictionaryEntry.getKey()) > StringExtensionsKt.getNumberOnEnd(dictionaryEntry2.getKey())) {
                        compareTo = 1;
                    } else {
                        compareTo = 0;
                    }
                }
                return Integer.valueOf(compareTo);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: VariableValue.kt */
        /* loaded from: classes3.dex */
        public static final class b extends Lambda implements Function1<DictionaryEntry, Boolean> {
            final /* synthetic */ String $keyName;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(String str) {
                super(1);
                this.$keyName = str;
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            /* renamed from: a */
            public final Boolean invoke(@NotNull DictionaryEntry it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(it.getKey(), this.$keyName));
            }
        }

        /* compiled from: VariableValue.kt */
        /* loaded from: classes3.dex */
        public static final class c extends Lambda implements Function1<DictionaryEntry, CharSequence> {

            /* renamed from: d */
            public static final c f16298d = new c();

            c() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            /* renamed from: a */
            public final CharSequence invoke(@NotNull DictionaryEntry it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String key = it.getKey();
                String valueAsText = it.getVariable().getValueAsText();
                return "[" + key + "]: " + valueAsText;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Dictionary(@NotNull List<DictionaryEntry> entries, boolean z3, @Nullable List<String> list) {
            super(list, null);
            Intrinsics.checkNotNullParameter(entries, "entries");
            this.entries = entries;
            this.isArray = z3;
            this.parents = list;
            this.variableType = z3 ? 5 : 4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Dictionary copy$default(Dictionary dictionary, List list, boolean z3, List list2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                list = dictionary.entries;
            }
            if ((i4 & 2) != 0) {
                z3 = dictionary.isArray;
            }
            if ((i4 & 4) != 0) {
                list2 = dictionary.parents;
            }
            return dictionary.copy(list, z3, list2);
        }

        public static final int getEntriesSorted$lambda$1(Function2 tmp0, Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return ((Number) tmp0.mo1invoke(obj, obj2)).intValue();
        }

        public final void clearAll() {
            int i4 = 0;
            for (Object obj : this.entries) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                this.entries.set(i4, DictionaryEntry.copy$default((DictionaryEntry) obj, null, Empty.INSTANCE, null, 5, null));
                i4 = i5;
            }
        }

        @NotNull
        public final List<DictionaryEntry> component1() {
            return this.entries;
        }

        public final boolean component2() {
            return this.isArray;
        }

        @Nullable
        public final List<String> component3() {
            return this.parents;
        }

        @NotNull
        public final Dictionary copy(@NotNull List<DictionaryEntry> entries, boolean z3, @Nullable List<String> list) {
            Intrinsics.checkNotNullParameter(entries, "entries");
            return new Dictionary(entries, z3, list);
        }

        public final void deleteAll() {
            this.entries.clear();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Dictionary)) {
                return false;
            }
            Dictionary dictionary = (Dictionary) obj;
            if (Intrinsics.areEqual(this.entries, dictionary.entries) && this.isArray == dictionary.isArray && Intrinsics.areEqual(this.parents, dictionary.parents)) {
                return true;
            }
            return false;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        @NotNull
        public String getComparisonValueAsText() {
            StringBuilder sb = new StringBuilder();
            for (DictionaryEntry dictionaryEntry : this.entries) {
                sb.append(dictionaryEntry.getVariable().getComparisonValueAsText());
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
            return sb2;
        }

        @NotNull
        public final List<DictionaryEntry> getDictionaryOrArryEntriesOnly() {
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.entries) {
                if (((DictionaryEntry) obj).getVariable() instanceof Dictionary) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }

        @NotNull
        public final List<DictionaryEntry> getEntries() {
            return this.entries;
        }

        @NotNull
        public final List<DictionaryEntry> getEntriesArrayOrder() {
            List<DictionaryEntry> sortedWith;
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(this.entries, new Comparator() { // from class: com.arlosoft.macrodroid.variables.VariableValue$Dictionary$getEntriesArrayOrder$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t3, T t4) {
                    int i4;
                    int compareValues;
                    int i5 = 0;
                    try {
                        i4 = Integer.parseInt(((VariableValue.DictionaryEntry) t3).getKey());
                    } catch (Exception unused) {
                        i4 = 0;
                    }
                    Integer valueOf = Integer.valueOf(i4);
                    try {
                        i5 = Integer.parseInt(((VariableValue.DictionaryEntry) t4).getKey());
                    } catch (Exception unused2) {
                    }
                    compareValues = kotlin.comparisons.f.compareValues(valueOf, Integer.valueOf(i5));
                    return compareValues;
                }
            });
            return sortedWith;
        }

        @NotNull
        public final List<DictionaryEntry> getEntriesSorted() {
            List<DictionaryEntry> mutableList;
            List<DictionaryEntry> mutableList2;
            if (!this.isArray) {
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.entries);
                try {
                    final a aVar = a.f16297d;
                    kotlin.collections.h.sortWith(mutableList, new Comparator() { // from class: com.arlosoft.macrodroid.variables.n0
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            int entriesSorted$lambda$1;
                            entriesSorted$lambda$1 = VariableValue.Dictionary.getEntriesSorted$lambda$1(Function2.this, obj, obj2);
                            return entriesSorted$lambda$1;
                        }
                    });
                    return mutableList;
                } catch (Exception e4) {
                    FirebaseAnalyticsEventLogger.log(this.entries.toString());
                    FirebaseAnalyticsEventLogger.logHandledException(e4);
                    mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) this.entries);
                    return mutableList2;
                }
            }
            return getEntriesArrayOrder();
        }

        @Nullable
        public final DictionaryEntry getEntry(@NotNull String keyName) {
            Object obj;
            Intrinsics.checkNotNullParameter(keyName, "keyName");
            Iterator<T> it = this.entries.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((DictionaryEntry) obj).getKey(), keyName)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            return (DictionaryEntry) obj;
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0041, code lost:
            if (hasNumericalChildren((com.arlosoft.macrodroid.variables.VariableValue.Dictionary) r3) != false) goto L19;
         */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0049 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x000d A[SYNTHETIC] */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.util.List<com.arlosoft.macrodroid.variables.VariableValue.DictionaryEntry> getNumEntriesOnly() {
            /*
                r5 = this;
                java.util.List<com.arlosoft.macrodroid.variables.VariableValue$DictionaryEntry> r0 = r5.entries
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.Iterator r0 = r0.iterator()
            Ld:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L4d
                java.lang.Object r2 = r0.next()
                r3 = r2
                com.arlosoft.macrodroid.variables.VariableValue$DictionaryEntry r3 = (com.arlosoft.macrodroid.variables.VariableValue.DictionaryEntry) r3
                com.arlosoft.macrodroid.variables.VariableValue r4 = r3.getVariable()
                boolean r4 = r4 instanceof com.arlosoft.macrodroid.variables.VariableValue.IntegerValue
                if (r4 != 0) goto L46
                com.arlosoft.macrodroid.variables.VariableValue r4 = r3.getVariable()
                boolean r4 = r4 instanceof com.arlosoft.macrodroid.variables.VariableValue.DecimalValue
                if (r4 != 0) goto L46
                com.arlosoft.macrodroid.variables.VariableValue r4 = r3.getVariable()
                boolean r4 = r4 instanceof com.arlosoft.macrodroid.variables.VariableValue.Dictionary
                if (r4 == 0) goto L44
                com.arlosoft.macrodroid.variables.VariableValue r3 = r3.getVariable()
                java.lang.String r4 = "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r4)
                com.arlosoft.macrodroid.variables.VariableValue$Dictionary r3 = (com.arlosoft.macrodroid.variables.VariableValue.Dictionary) r3
                boolean r3 = r5.hasNumericalChildren(r3)
                if (r3 == 0) goto L44
                goto L46
            L44:
                r3 = 0
                goto L47
            L46:
                r3 = 1
            L47:
                if (r3 == 0) goto Ld
                r1.add(r2)
                goto Ld
            L4d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.variables.VariableValue.Dictionary.getNumEntriesOnly():java.util.List");
        }

        @Nullable
        public final List<String> getParents() {
            return this.parents;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        @NotNull
        public String getValueAsText() {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = MacroDroidApplication.Companion.getInstance().getString(R.string.variable_multi_entry_num_entries);
            Intrinsics.checkNotNullExpressionValue(string, "MacroDroidApplication.in…_multi_entry_num_entries)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.entries.size())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        public int getVariableType() {
            return this.variableType;
        }

        public final boolean hasArrayChildren(@NotNull Dictionary dictionary) {
            Intrinsics.checkNotNullParameter(dictionary, "dictionary");
            for (DictionaryEntry dictionaryEntry : dictionary.entries) {
                if (dictionaryEntry.getVariable() instanceof Dictionary) {
                    VariableValue variable = dictionaryEntry.getVariable();
                    Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                    if (((Dictionary) variable).isArray) {
                        return true;
                    }
                }
                if (dictionaryEntry.getVariable() instanceof Dictionary) {
                    VariableValue variable2 = dictionaryEntry.getVariable();
                    Intrinsics.checkNotNull(variable2, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                    if (hasArrayChildren((Dictionary) variable2)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final boolean hasBooleanChildren(@NotNull Dictionary dictionary) {
            Intrinsics.checkNotNullParameter(dictionary, "dictionary");
            for (DictionaryEntry dictionaryEntry : dictionary.entries) {
                if (dictionaryEntry.getVariable() instanceof BooleanValue) {
                    return true;
                }
                if (dictionaryEntry.getVariable() instanceof Dictionary) {
                    VariableValue variable = dictionaryEntry.getVariable();
                    Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                    if (hasBooleanChildren((Dictionary) variable)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final boolean hasDictionaryChildren(@NotNull Dictionary dictionary) {
            Intrinsics.checkNotNullParameter(dictionary, "dictionary");
            for (DictionaryEntry dictionaryEntry : dictionary.entries) {
                if (dictionaryEntry.getVariable() instanceof Dictionary) {
                    VariableValue variable = dictionaryEntry.getVariable();
                    Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                    if (!((Dictionary) variable).isArray) {
                        return true;
                    }
                }
                if (dictionaryEntry.getVariable() instanceof Dictionary) {
                    VariableValue variable2 = dictionaryEntry.getVariable();
                    Intrinsics.checkNotNull(variable2, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                    if (hasDictionaryChildren((Dictionary) variable2)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final boolean hasDictionaryOrArrayChildren(@NotNull Dictionary dictionary) {
            Intrinsics.checkNotNullParameter(dictionary, "dictionary");
            for (DictionaryEntry dictionaryEntry : dictionary.entries) {
                if (dictionaryEntry.getVariable() instanceof Dictionary) {
                    return true;
                }
            }
            return false;
        }

        public final boolean hasNumericalChildren(@NotNull Dictionary dictionary) {
            Intrinsics.checkNotNullParameter(dictionary, "dictionary");
            for (DictionaryEntry dictionaryEntry : dictionary.entries) {
                if (!(dictionaryEntry.getVariable() instanceof IntegerValue) && !(dictionaryEntry.getVariable() instanceof DecimalValue)) {
                    if (dictionaryEntry.getVariable() instanceof Dictionary) {
                        VariableValue variable = dictionaryEntry.getVariable();
                        Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                        if (hasNumericalChildren((Dictionary) variable)) {
                        }
                    }
                }
                return true;
            }
            return false;
        }

        public final boolean hasStringChildren(@NotNull Dictionary dictionary) {
            Intrinsics.checkNotNullParameter(dictionary, "dictionary");
            for (DictionaryEntry dictionaryEntry : dictionary.entries) {
                if (dictionaryEntry.getVariable() instanceof StringValue) {
                    return true;
                }
                if (dictionaryEntry.getVariable() instanceof Dictionary) {
                    VariableValue variable = dictionaryEntry.getVariable();
                    Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                    if (hasStringChildren((Dictionary) variable)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2 = this.entries.hashCode() * 31;
            boolean z3 = this.isArray;
            int i4 = z3;
            if (z3 != 0) {
                i4 = 1;
            }
            int i5 = (hashCode2 + i4) * 31;
            List<String> list = this.parents;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            return i5 + hashCode;
        }

        public final boolean isArray() {
            return this.isArray;
        }

        public final void removeEntry(@NotNull DictionaryEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            this.entries.remove(entry);
        }

        public final void removeKey(@NotNull String keyName) {
            Intrinsics.checkNotNullParameter(keyName, "keyName");
            kotlin.collections.i.removeAll((List) this.entries, (Function1) new b(keyName));
        }

        public final void setEntry(@NotNull DictionaryEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            Iterator<DictionaryEntry> it = this.entries.iterator();
            int i4 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(it.next().getKey(), entry.getKey())) {
                        break;
                    }
                    i4++;
                } else {
                    i4 = -1;
                    break;
                }
            }
            if (i4 >= 0) {
                this.entries.set(i4, entry);
            } else {
                this.entries.add(entry);
            }
        }

        @NotNull
        public String toString() {
            String joinToString$default;
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(getEntriesSorted(), "\n", null, null, 0, null, c.f16298d, 30, null);
            return joinToString$default;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            List<DictionaryEntry> list = this.entries;
            out.writeInt(list.size());
            for (DictionaryEntry dictionaryEntry : list) {
                dictionaryEntry.writeToParcel(out, i4);
            }
            out.writeInt(this.isArray ? 1 : 0);
            out.writeStringList(this.parents);
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        @NotNull
        public VariableValue copy() {
            return new Dictionary(this.entries, this.isArray, null, 4, null);
        }

        public /* synthetic */ Dictionary(List list, boolean z3, List list2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i4 & 2) != 0 ? false : z3, (i4 & 4) != 0 ? null : list2);
        }
    }

    /* compiled from: VariableValue.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    /* loaded from: classes3.dex */
    public static final class DictionaryEntry extends VariableValue {
        public static final int $stable = 8;
        @NotNull
        public static final Parcelable.Creator<DictionaryEntry> CREATOR = new Creator();
        @NotNull
        private final String key;
        @Nullable
        private final List<String> parents;
        @NotNull
        private VariableValue variable;
        private final int variableType;

        /* compiled from: VariableValue.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<DictionaryEntry> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final DictionaryEntry createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DictionaryEntry(parcel.readString(), (VariableValue) parcel.readParcelable(DictionaryEntry.class.getClassLoader()), parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final DictionaryEntry[] newArray(int i4) {
                return new DictionaryEntry[i4];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DictionaryEntry(@NotNull String key, @NotNull VariableValue variable, @Nullable List<String> list) {
            super(list, null);
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(variable, "variable");
            this.key = key;
            this.variable = variable;
            this.parents = list;
            this.variableType = 11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DictionaryEntry copy$default(DictionaryEntry dictionaryEntry, String str, VariableValue variableValue, List list, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = dictionaryEntry.key;
            }
            if ((i4 & 2) != 0) {
                variableValue = dictionaryEntry.variable;
            }
            if ((i4 & 4) != 0) {
                list = dictionaryEntry.parents;
            }
            return dictionaryEntry.copy(str, variableValue, list);
        }

        @NotNull
        public final String component1() {
            return this.key;
        }

        @NotNull
        public final VariableValue component2() {
            return this.variable;
        }

        @Nullable
        public final List<String> component3() {
            return this.parents;
        }

        @NotNull
        public final DictionaryEntry copy(@NotNull String key, @NotNull VariableValue variable, @Nullable List<String> list) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(variable, "variable");
            return new DictionaryEntry(key, variable, list);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DictionaryEntry)) {
                return false;
            }
            DictionaryEntry dictionaryEntry = (DictionaryEntry) obj;
            if (Intrinsics.areEqual(this.key, dictionaryEntry.key) && Intrinsics.areEqual(this.variable, dictionaryEntry.variable) && Intrinsics.areEqual(this.parents, dictionaryEntry.parents)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }

        @Nullable
        public final List<String> getParents() {
            return this.parents;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        @NotNull
        public String getValueAsText() {
            return this.variable.getValueAsText();
        }

        @NotNull
        public final VariableValue getVariable() {
            return this.variable;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        public int getVariableType() {
            return this.variableType;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.key.hashCode() * 31) + this.variable.hashCode()) * 31;
            List<String> list = this.parents;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            return hashCode2 + hashCode;
        }

        public final void setVariable(@NotNull VariableValue variableValue) {
            Intrinsics.checkNotNullParameter(variableValue, "<set-?>");
            this.variable = variableValue;
        }

        @NotNull
        public String toString() {
            String str = this.key;
            VariableValue variableValue = this.variable;
            List<String> list = this.parents;
            return "DictionaryEntry(key=" + str + ", variable=" + variableValue + ", parents=" + list + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.key);
            out.writeParcelable(this.variable, i4);
            out.writeStringList(this.parents);
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        @NotNull
        public VariableValue copy() {
            return new DictionaryEntry(this.key, this.variable, this.parents);
        }

        public /* synthetic */ DictionaryEntry(String str, VariableValue variableValue, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, variableValue, (i4 & 4) != 0 ? null : list);
        }
    }

    /* compiled from: VariableValue.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    /* loaded from: classes3.dex */
    public static final class Empty extends VariableValue {
        public static final int $stable = 0;
        @NotNull
        public static final Empty INSTANCE = new Empty();
        private static final int variableType = -1;
        @NotNull
        public static final Parcelable.Creator<Empty> CREATOR = new Creator();

        /* compiled from: VariableValue.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Empty> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Empty createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Empty.INSTANCE;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Empty[] newArray(int i4) {
                return new Empty[i4];
            }
        }

        private Empty() {
            super((DefaultConstructorMarker) null);
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        @NotNull
        public VariableValue copy() {
            return INSTANCE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        @NotNull
        public String getValueAsText() {
            return "";
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        public int getVariableType() {
            return variableType;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(1);
        }
    }

    /* compiled from: VariableValue.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    /* loaded from: classes3.dex */
    public static final class IntegerValue extends VariableValue {
        private final long intValue;
        @Nullable
        private final List<String> parents;
        private final int variableType;
        @NotNull
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        @NotNull
        public static final Parcelable.Creator<IntegerValue> CREATOR = new Creator();

        /* compiled from: VariableValue.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ VariableValue getValueFromString$default(Companion companion, String str, List list, int i4, Object obj) {
                if ((i4 & 2) != 0) {
                    list = null;
                }
                return companion.getValueFromString(str, list);
            }

            @NotNull
            public final VariableValue getValueFromString(@NotNull String stringValue, @Nullable List<String> list) {
                Long longOrNull;
                long j4;
                Intrinsics.checkNotNullParameter(stringValue, "stringValue");
                longOrNull = kotlin.text.l.toLongOrNull(stringValue);
                if (longOrNull != null) {
                    j4 = longOrNull.longValue();
                } else {
                    j4 = 0;
                }
                return new IntegerValue(j4, list);
            }
        }

        /* compiled from: VariableValue.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<IntegerValue> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final IntegerValue createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new IntegerValue(parcel.readLong(), parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final IntegerValue[] newArray(int i4) {
                return new IntegerValue[i4];
            }
        }

        public IntegerValue() {
            this(0L, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ IntegerValue copy$default(IntegerValue integerValue, long j4, List list, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                j4 = integerValue.intValue;
            }
            if ((i4 & 2) != 0) {
                list = integerValue.parents;
            }
            return integerValue.copy(j4, list);
        }

        public final long component1() {
            return this.intValue;
        }

        @Nullable
        public final List<String> component2() {
            return this.parents;
        }

        @NotNull
        public final IntegerValue copy(long j4, @Nullable List<String> list) {
            return new IntegerValue(j4, list);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            IntegerValue integerValue;
            if (obj instanceof IntegerValue) {
                integerValue = (IntegerValue) obj;
            } else {
                integerValue = null;
            }
            if (integerValue == null || this.intValue != integerValue.intValue) {
                return false;
            }
            return true;
        }

        public final long getIntValue() {
            return this.intValue;
        }

        @Nullable
        public final List<String> getParents() {
            return this.parents;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        @NotNull
        public String getValueAsText() {
            return String.valueOf(this.intValue);
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        public int getVariableType() {
            return this.variableType;
        }

        public int hashCode() {
            int hashCode;
            int a4 = androidx.compose.animation.a.a(this.intValue) * 31;
            List<String> list = this.parents;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            return a4 + hashCode;
        }

        @NotNull
        public String toString() {
            long j4 = this.intValue;
            List<String> list = this.parents;
            return "IntegerValue(intValue=" + j4 + ", parents=" + list + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeLong(this.intValue);
            out.writeStringList(this.parents);
        }

        public IntegerValue(long j4, @Nullable List<String> list) {
            super(list, null);
            this.intValue = j4;
            this.parents = list;
            this.variableType = 1;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        @NotNull
        public VariableValue copy() {
            return new IntegerValue(this.intValue, this.parents);
        }

        public /* synthetic */ IntegerValue(long j4, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0L : j4, (i4 & 2) != 0 ? null : list);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public IntegerValue(@org.jetbrains.annotations.NotNull java.lang.String r9) {
            /*
                r8 = this;
                java.lang.String r0 = "valueAsString"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                long r0 = java.lang.Long.parseLong(r9)     // Catch: java.lang.Exception -> Lb
            L9:
                r3 = r0
                goto Le
            Lb:
                r0 = 0
                goto L9
            Le:
                r5 = 0
                r6 = 2
                r7 = 0
                r2 = r8
                r2.<init>(r3, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.variables.VariableValue.IntegerValue.<init>(java.lang.String):void");
        }
    }

    /* compiled from: VariableValue.kt */
    @StabilityInferred(parameters = 0)
    @DontObfuscate
    @Parcelize
    /* loaded from: classes3.dex */
    public static final class StringValue extends VariableValue {
        @Nullable
        private final List<String> parents;
        @NotNull
        private final String textValue;
        private final int variableType;
        @NotNull
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        @NotNull
        public static final Parcelable.Creator<StringValue> CREATOR = new Creator();

        /* compiled from: VariableValue.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ VariableValue getValueFromString$default(Companion companion, String str, List list, int i4, Object obj) {
                if ((i4 & 2) != 0) {
                    list = null;
                }
                return companion.getValueFromString(str, list);
            }

            @NotNull
            public final VariableValue getValueFromString(@NotNull String stringValue, @Nullable List<String> list) {
                Intrinsics.checkNotNullParameter(stringValue, "stringValue");
                return new StringValue(stringValue, list);
            }
        }

        /* compiled from: VariableValue.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<StringValue> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final StringValue createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new StringValue(parcel.readString(), parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final StringValue[] newArray(int i4) {
                return new StringValue[i4];
            }
        }

        public StringValue() {
            this(null, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StringValue copy$default(StringValue stringValue, String str, List list, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = stringValue.textValue;
            }
            if ((i4 & 2) != 0) {
                list = stringValue.parents;
            }
            return stringValue.copy(str, list);
        }

        @NotNull
        public final String component1() {
            return this.textValue;
        }

        @Nullable
        public final List<String> component2() {
            return this.parents;
        }

        @NotNull
        public final StringValue copy(@NotNull String textValue, @Nullable List<String> list) {
            Intrinsics.checkNotNullParameter(textValue, "textValue");
            return new StringValue(textValue, list);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            StringValue stringValue;
            String str = this.textValue;
            String str2 = null;
            if (obj instanceof StringValue) {
                stringValue = (StringValue) obj;
            } else {
                stringValue = null;
            }
            if (stringValue != null) {
                str2 = stringValue.textValue;
            }
            return Intrinsics.areEqual(str, str2);
        }

        @Nullable
        public final List<String> getParents() {
            return this.parents;
        }

        @NotNull
        public final String getTextValue() {
            return this.textValue;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        @NotNull
        public String getValueAsText() {
            return this.textValue;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        public int getVariableType() {
            return this.variableType;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.textValue.hashCode() * 31;
            List<String> list = this.parents;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            String str = this.textValue;
            List<String> list = this.parents;
            return "StringValue(textValue=" + str + ", parents=" + list + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel out, int i4) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.textValue);
            out.writeStringList(this.parents);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringValue(@NotNull String textValue, @Nullable List<String> list) {
            super(list, null);
            Intrinsics.checkNotNullParameter(textValue, "textValue");
            this.textValue = textValue;
            this.parents = list;
            this.variableType = 2;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableValue
        @NotNull
        public VariableValue copy() {
            return new StringValue(this.textValue, this.parents);
        }

        public /* synthetic */ StringValue(String str, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? null : list);
        }
    }

    public /* synthetic */ VariableValue(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    @JvmStatic
    @NotNull
    public static final VariableValue createForType(int i4) {
        return Companion.createForType(i4);
    }

    @JvmStatic
    @NotNull
    public static final VariableValue fromTextValueForType(@Nullable String str, int i4, @Nullable List<String> list) {
        return Companion.fromTextValueForType(str, i4, list);
    }

    @NotNull
    public abstract VariableValue copy();

    @NotNull
    public String getComparisonValueAsText() {
        return getValueAsText();
    }

    @Nullable
    public final List<String> getParentKeys() {
        return this.parentKeys;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public abstract String getValueAsText();

    public abstract int getVariableType();

    public final void setParentKeys(@Nullable List<String> list) {
        this.parentKeys = list;
    }

    public /* synthetic */ VariableValue(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final VariableValue createForType(int i4, @NotNull List<String> list) {
        return Companion.createForType(i4, list);
    }

    private VariableValue(List<String> list) {
        this.parentKeys = list;
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
        this.type = simpleName;
    }

    public /* synthetic */ VariableValue(List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : list, null);
    }

    /* compiled from: VariableValue.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VariableValue fromTextValueForType$default(Companion companion, String str, int i4, List list, int i5, Object obj) {
            if ((i5 & 4) != 0) {
                list = null;
            }
            return companion.fromTextValueForType(str, i4, list);
        }

        @JvmStatic
        @NotNull
        public final VariableValue createForType(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                if (i4 != 5) {
                                    return Empty.INSTANCE;
                                }
                                return new Dictionary(new ArrayList(), true, null, 4, null);
                            }
                            return new Dictionary(new ArrayList(), false, null, 6, null);
                        }
                        return new DecimalValue(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, 2, null);
                    }
                    return new StringValue("", null, 2, null);
                }
                return new IntegerValue(0L, null, 2, null);
            }
            return new BooleanValue(false, null, 2, null);
        }

        @JvmStatic
        @NotNull
        public final VariableValue fromTextValueForType(@Nullable String str, int i4, @Nullable List<String> list) {
            if (str == null) {
                str = "";
            }
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            return Empty.INSTANCE;
                        }
                        return DecimalValue.Companion.getValueFromString(str, list);
                    }
                    return StringValue.Companion.getValueFromString(str, list);
                }
                return IntegerValue.Companion.getValueFromString(str, list);
            }
            return BooleanValue.Companion.getValueFromString(str, list);
        }

        @JvmStatic
        @NotNull
        public final VariableValue createForType(int i4, @NotNull List<String> parents) {
            Intrinsics.checkNotNullParameter(parents, "parents");
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                if (i4 != 5) {
                                    return Empty.INSTANCE;
                                }
                                return new Dictionary(new ArrayList(), true, parents);
                            }
                            return new Dictionary(new ArrayList(), false, parents);
                        }
                        return new DecimalValue(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, parents);
                    }
                    return new StringValue("", parents);
                }
                return new IntegerValue(0L, parents);
            }
            return new BooleanValue(false, parents);
        }
    }

    private VariableValue() {
        this(null, null);
    }
}
