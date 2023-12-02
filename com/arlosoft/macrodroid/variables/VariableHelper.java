package com.arlosoft.macrodroid.variables;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.ActionBlockAction;
import com.arlosoft.macrodroid.action.WaitUntilTriggerAction;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.VariableUpdatedListener;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.constraint.LogicConstraint;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.drawer.model.DrawerConfiguration;
import com.arlosoft.macrodroid.drawer.model.DrawerItem;
import com.arlosoft.macrodroid.drawer.model.DrawerItemVariable;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.interfaces.HasVariable;
import com.arlosoft.macrodroid.interfaces.HasVariableName;
import com.arlosoft.macrodroid.interfaces.HasVariableNames;
import com.arlosoft.macrodroid.interfaces.HasVariables;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.interfaces.VariableNameUpdater;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.utils.ExpressionUtils;
import com.arlosoft.macrodroid.utils.OverlayUtils;
import com.arlosoft.macrodroid.variables.DictionaryVariableAdapter;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableOrOption;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.koushikdutta.ion.loader.MtpConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import net.bytebuddy.pool.TypePool;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VariableHelper.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nVariableHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VariableHelper.kt\ncom/arlosoft/macrodroid/variables/VariableHelper\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 7 SpannableStringBuilder.kt\nandroidx/core/text/SpannableStringBuilderKt\n*L\n1#1,1920:1\n262#2,2:1921\n262#2,2:1923\n262#2,2:1925\n262#2,2:1927\n262#2,2:1929\n262#2,2:1931\n262#2,2:1969\n262#2,2:1971\n262#2,2:1973\n262#2,2:1995\n262#2,2:1997\n262#2,2:1999\n262#2,2:2020\n262#2,2:2022\n262#2,2:2024\n262#2,2:2026\n262#2,2:2028\n262#2,2:2030\n262#2,2:2032\n262#2,2:2034\n262#2,2:2036\n262#2,2:2038\n262#2,2:2040\n262#2,2:2042\n262#2,2:2044\n262#2,2:2046\n262#2,2:2048\n262#2,2:2107\n766#3:1933\n857#3,2:1934\n766#3:1936\n857#3,2:1937\n766#3:1939\n857#3,2:1940\n766#3:1942\n857#3,2:1943\n766#3:1945\n857#3,2:1946\n766#3:1948\n857#3,2:1949\n766#3:1951\n857#3,2:1952\n766#3:1954\n857#3,2:1955\n1549#3:1957\n1620#3,3:1958\n1549#3:1961\n1620#3,3:1962\n1549#3:1965\n1620#3,3:1966\n766#3:2069\n857#3,2:2070\n1549#3:2072\n1620#3,3:2073\n1855#3,2:2103\n1855#3,2:2105\n49#4:1975\n65#4,16:1976\n93#4,3:1992\n65#4,16:2001\n93#4,3:2017\n65#4,16:2050\n93#4,3:2066\n65#4,16:2084\n93#4,3:2100\n37#5,2:2076\n1627#6,6:2078\n144#7:2109\n74#7,4:2110\n144#7:2114\n74#7,4:2115\n115#7:2119\n74#7,4:2120\n115#7:2124\n74#7,4:2125\n144#7:2129\n74#7,4:2130\n144#7:2134\n74#7,4:2135\n115#7:2139\n74#7,4:2140\n115#7:2144\n74#7,4:2145\n115#7:2149\n74#7,4:2150\n115#7:2154\n74#7,4:2155\n*S KotlinDebug\n*F\n+ 1 VariableHelper.kt\ncom/arlosoft/macrodroid/variables/VariableHelper\n*L\n442#1:1921,2\n443#1:1923,2\n448#1:1925,2\n566#1:1927,2\n577#1:1929,2\n590#1:1931,2\n986#1:1969,2\n987#1:1971,2\n989#1:1973,2\n1126#1:1995,2\n1127#1:1997,2\n1176#1:1999,2\n1268#1:2020,2\n1269#1:2022,2\n1271#1:2024,2\n1316#1:2026,2\n1317#1:2028,2\n1321#1:2030,2\n1322#1:2032,2\n1324#1:2034,2\n1325#1:2036,2\n1349#1:2038,2\n1353#1:2040,2\n1354#1:2042,2\n1358#1:2044,2\n1359#1:2046,2\n1380#1:2048,2\n1763#1:2107,2\n663#1:1933\n663#1:1934,2\n689#1:1936\n689#1:1937,2\n710#1:1939\n710#1:1940,2\n711#1:1942\n711#1:1943,2\n730#1:1945\n730#1:1946,2\n750#1:1948\n750#1:1949,2\n751#1:1951\n751#1:1952,2\n774#1:1954\n774#1:1955,2\n796#1:1957\n796#1:1958,3\n797#1:1961\n797#1:1962,3\n931#1:1965\n931#1:1966,3\n1458#1:2069\n1458#1:2070,2\n1458#1:2072\n1458#1:2073,3\n1592#1:2103,2\n1602#1:2105,2\n1062#1:1975\n1062#1:1976,16\n1062#1:1992,3\n1178#1:2001,16\n1178#1:2017,3\n1384#1:2050,16\n1384#1:2066,3\n1554#1:2084,16\n1554#1:2100,3\n1471#1:2076,2\n1473#1:2078,6\n1830#1:2109\n1830#1:2110,4\n1840#1:2114\n1840#1:2115,4\n1843#1:2119\n1843#1:2120,4\n1845#1:2124\n1845#1:2125,4\n1851#1:2129\n1851#1:2130,4\n1851#1:2134\n1851#1:2135,4\n1854#1:2139\n1854#1:2140,4\n1856#1:2144\n1856#1:2145,4\n1861#1:2149\n1861#1:2150,4\n1863#1:2154\n1863#1:2155,4\n*E\n"})
/* loaded from: classes3.dex */
public final class VariableHelper {
    public static final int $stable = 0;
    @NotNull
    public static final VariableHelper INSTANCE = new VariableHelper();

    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public interface KeyDialogOptionChosenCallback {

        /* compiled from: VariableHelper.kt */
        /* loaded from: classes3.dex */
        public static final class DefaultImpls {
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ void manualKeyEntryChosen$default(KeyDialogOptionChosenCallback keyDialogOptionChosenCallback, List list, int i4, Object obj) {
                if (obj == null) {
                    if ((i4 & 1) != 0) {
                        list = null;
                    }
                    keyDialogOptionChosenCallback.manualKeyEntryChosen(list);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: manualKeyEntryChosen");
            }
        }

        void addKeyChosen();

        void copyAllChosen();

        void keyChosen(@NotNull VariableValue.DictionaryEntry dictionaryEntry);

        void manualKeyEntryChosen(@Nullable List<String> list);

        void thisDictionaryChosen();
    }

    /* compiled from: VariableHelper.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ManualKeyData {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f16212a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final Integer f16213b;

        public ManualKeyData(@NotNull List<String> keys, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(keys, "keys");
            this.f16212a = keys;
            this.f16213b = num;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ManualKeyData copy$default(ManualKeyData manualKeyData, List list, Integer num, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                list = manualKeyData.f16212a;
            }
            if ((i4 & 2) != 0) {
                num = manualKeyData.f16213b;
            }
            return manualKeyData.copy(list, num);
        }

        @NotNull
        public final String asString() {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.f16212a.iterator();
            while (it.hasNext()) {
                sb.append("[" + it.next() + "]");
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
            return sb2;
        }

        @NotNull
        public final List<String> component1() {
            return this.f16212a;
        }

        @Nullable
        public final Integer component2() {
            return this.f16213b;
        }

        @NotNull
        public final ManualKeyData copy(@NotNull List<String> keys, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(keys, "keys");
            return new ManualKeyData(keys, num);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ManualKeyData)) {
                return false;
            }
            ManualKeyData manualKeyData = (ManualKeyData) obj;
            if (Intrinsics.areEqual(this.f16212a, manualKeyData.f16212a) && Intrinsics.areEqual(this.f16213b, manualKeyData.f16213b)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final List<String> getKeys() {
            return this.f16212a;
        }

        @Nullable
        public final Integer getVarType() {
            return this.f16213b;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.f16212a.hashCode() * 31;
            Integer num = this.f16213b;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            List<String> list = this.f16212a;
            Integer num = this.f16213b;
            return "ManualKeyData(keys=" + list + ", varType=" + num + ")";
        }

        public /* synthetic */ ManualKeyData(List list, Integer num, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i4 & 2) != 0 ? null : num);
        }
    }

    /* compiled from: VariableHelper.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ManualKeyOption {
        public static final int $stable = 8;

        /* renamed from: a  reason: collision with root package name */
        private final boolean f16214a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f16215b;

        public ManualKeyOption(boolean z3, @Nullable List<String> list) {
            this.f16214a = z3;
            this.f16215b = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ManualKeyOption copy$default(ManualKeyOption manualKeyOption, boolean z3, List list, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                z3 = manualKeyOption.f16214a;
            }
            if ((i4 & 2) != 0) {
                list = manualKeyOption.f16215b;
            }
            return manualKeyOption.copy(z3, list);
        }

        public final boolean component1() {
            return this.f16214a;
        }

        @Nullable
        public final List<String> component2() {
            return this.f16215b;
        }

        @NotNull
        public final ManualKeyOption copy(boolean z3, @Nullable List<String> list) {
            return new ManualKeyOption(z3, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ManualKeyOption)) {
                return false;
            }
            ManualKeyOption manualKeyOption = (ManualKeyOption) obj;
            if (this.f16214a == manualKeyOption.f16214a && Intrinsics.areEqual(this.f16215b, manualKeyOption.f16215b)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final List<String> getExistingKeys() {
            return this.f16215b;
        }

        public final boolean getShowManualKeys() {
            return this.f16214a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            int hashCode;
            boolean z3 = this.f16214a;
            ?? r02 = z3;
            if (z3) {
                r02 = 1;
            }
            int i4 = r02 * 31;
            List<String> list = this.f16215b;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            return i4 + hashCode;
        }

        @NotNull
        public String toString() {
            boolean z3 = this.f16214a;
            List<String> list = this.f16215b;
            return "ManualKeyOption(showManualKeys=" + z3 + ", existingKeys=" + list + ")";
        }

        public /* synthetic */ ManualKeyOption(boolean z3, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(z3, (i4 & 2) != 0 ? null : list);
        }
    }

    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public interface NewVariableCreationListener {
        void newVariableCreated(@NotNull MacroDroidVariable macroDroidVariable, boolean z3);

        boolean validateVariableName(@NotNull String str);
    }

    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public enum ShowThisDictionaryOption {
        DONT_SHOW,
        SHOW_DICTIONARIES_AND_ARRAYS,
        SHOW_DICTIONARIES_ONLY,
        SHOW_ARRAYS_ONLY
    }

    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public interface VariableSelectedListener {
        void customItemSelected(int i4, @NotNull String str);

        void variableSelected(@NotNull MacroDroidVariable macroDroidVariable, @Nullable List<String> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<VariableValue, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final a f16217d = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull VariableValue variableValue) {
            boolean z3;
            Intrinsics.checkNotNullParameter(variableValue, "variableValue");
            if (variableValue instanceof VariableValue.Dictionary) {
                VariableValue.Dictionary dictionary = (VariableValue.Dictionary) variableValue;
                if (dictionary.isArray() || dictionary.hasArrayChildren(dictionary)) {
                    z3 = true;
                    return Boolean.valueOf(z3);
                }
            }
            z3 = false;
            return Boolean.valueOf(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class a0 extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ Button $okButton;
        final /* synthetic */ EditText $valueEditText;
        final /* synthetic */ MacroDroidVariable $variable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a0(Button button, MacroDroidVariable macroDroidVariable, EditText editText) {
            super(1);
            this.$okButton = button;
            this.$variable = macroDroidVariable;
            this.$valueEditText = editText;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Button button = this.$okButton;
            if (button == null) {
                return;
            }
            boolean z3 = true;
            if (this.$variable.getType() != 2) {
                Editable text = this.$valueEditText.getText();
                Intrinsics.checkNotNullExpressionValue(text, "valueEditText.text");
                if (!(text.length() > 0)) {
                    z3 = false;
                }
            }
            button.setEnabled(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<VariableValue, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final b f16218d = new b();

        b() {
            super(1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
            if (r2.hasBooleanChildren(r2) != false) goto L11;
         */
        @Override // kotlin.jvm.functions.Function1
        @org.jetbrains.annotations.NotNull
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Boolean invoke(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.variables.VariableValue r2) {
            /*
                r1 = this;
                java.lang.String r0 = "variableValue"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                boolean r0 = r2 instanceof com.arlosoft.macrodroid.variables.VariableValue.BooleanValue
                if (r0 != 0) goto L18
                boolean r0 = r2 instanceof com.arlosoft.macrodroid.variables.VariableValue.Dictionary
                if (r0 == 0) goto L16
                com.arlosoft.macrodroid.variables.VariableValue$Dictionary r2 = (com.arlosoft.macrodroid.variables.VariableValue.Dictionary) r2
                boolean r2 = r2.hasBooleanChildren(r2)
                if (r2 == 0) goto L16
                goto L18
            L16:
                r2 = 0
                goto L19
            L18:
                r2 = 1
            L19:
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.variables.VariableHelper.b.invoke(com.arlosoft.macrodroid.variables.VariableValue):java.lang.Boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    @SourceDebugExtension({"SMAP\nVariableHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VariableHelper.kt\ncom/arlosoft/macrodroid/variables/VariableHelper$showLocalVarsDialogStandard$5\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1920:1\n1855#2,2:1921\n1855#2,2:1923\n*S KotlinDebug\n*F\n+ 1 VariableHelper.kt\ncom/arlosoft/macrodroid/variables/VariableHelper$showLocalVarsDialogStandard$5\n*L\n500#1:1921,2\n506#1:1923,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class b0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ DictionaryEventListener $dictionaryEventListener;
        final /* synthetic */ Macro $macro;
        final /* synthetic */ EditText $nameEditText;
        final /* synthetic */ RadioButton $trueRadio;
        final /* synthetic */ EditText $valueEditText;
        final /* synthetic */ MacroDroidVariable $variable;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b0(EditText editText, MacroDroidVariable macroDroidVariable, Macro macro, Activity activity, RadioButton radioButton, EditText editText2, DictionaryEventListener dictionaryEventListener, AppCompatDialog appCompatDialog, Continuation<? super b0> continuation) {
            super(3, continuation);
            this.$nameEditText = editText;
            this.$variable = macroDroidVariable;
            this.$macro = macro;
            this.$activity = activity;
            this.$trueRadio = radioButton;
            this.$valueEditText = editText2;
            this.$dictionaryEventListener = dictionaryEventListener;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b0(this.$nameEditText, this.$variable, this.$macro, this.$activity, this.$trueRadio, this.$valueEditText, this.$dictionaryEventListener, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Editable editable;
            Editable editable2;
            List<VariableUpdatedListener> list;
            List<VariableUpdatedListener> list2;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                EditText editText = this.$nameEditText;
                if (editText != null) {
                    editable = editText.getText();
                } else {
                    editable = null;
                }
                String valueOf = String.valueOf(editable);
                if (!Intrinsics.areEqual(valueOf, this.$variable.getName())) {
                    if (this.$macro.findLocalVariableByName(valueOf) == null) {
                        VariableHelper.INSTANCE.X(this.$variable, this.$macro, valueOf);
                    } else {
                        VariableHelper.showAlreadyExistsDialog(this.$activity, R.style.Theme_App_Dialog_LocalVariables);
                        return Unit.INSTANCE;
                    }
                }
                if (this.$variable.isBoolean()) {
                    VariableValue variableValue = this.$variable.getVariableValue();
                    RadioButton radioButton = this.$trueRadio;
                    boolean z3 = false;
                    if (radioButton != null && radioButton.isChecked()) {
                        z3 = true;
                    }
                    VariableValue.BooleanValue booleanValue = new VariableValue.BooleanValue(z3, null, 2, null);
                    this.$variable.setVariableValue(booleanValue, true ^ this.$macro.isExcludedFromLog(), variableValue, null);
                    Set<VariableUpdatedListener> localVariableUpdatedListeners = this.$macro.getLocalVariableUpdatedListeners();
                    Intrinsics.checkNotNullExpressionValue(localVariableUpdatedListeners, "macro.localVariableUpdatedListeners");
                    list2 = CollectionsKt___CollectionsKt.toList(localVariableUpdatedListeners);
                    MacroDroidVariable macroDroidVariable = this.$variable;
                    Macro macro = this.$macro;
                    for (VariableUpdatedListener variableUpdatedListener : list2) {
                        variableUpdatedListener.variableValueUpdated(macroDroidVariable, booleanValue, variableValue, macro.getGUID());
                    }
                } else {
                    VariableValue variableValue2 = this.$variable.getVariableValue();
                    VariableValue.Companion companion = VariableValue.Companion;
                    EditText editText2 = this.$valueEditText;
                    if (editText2 != null) {
                        editable2 = editText2.getText();
                    } else {
                        editable2 = null;
                    }
                    VariableValue fromTextValueForType$default = VariableValue.Companion.fromTextValueForType$default(companion, String.valueOf(editable2), this.$variable.getType(), null, 4, null);
                    this.$variable.setVariableValue(fromTextValueForType$default, true ^ this.$macro.isExcludedFromLog(), variableValue2, null);
                    Set<VariableUpdatedListener> localVariableUpdatedListeners2 = this.$macro.getLocalVariableUpdatedListeners();
                    Intrinsics.checkNotNullExpressionValue(localVariableUpdatedListeners2, "macro.localVariableUpdatedListeners");
                    list = CollectionsKt___CollectionsKt.toList(localVariableUpdatedListeners2);
                    MacroDroidVariable macroDroidVariable2 = this.$variable;
                    Macro macro2 = this.$macro;
                    for (VariableUpdatedListener variableUpdatedListener2 : list) {
                        variableUpdatedListener2.variableValueUpdated(macroDroidVariable2, fromTextValueForType$default, variableValue2, macro2.getGUID());
                    }
                }
                this.$dictionaryEventListener.refreshRequired();
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<VariableValue, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final c f16219d = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull VariableValue variableValue) {
            Intrinsics.checkNotNullParameter(variableValue, "variableValue");
            return Boolean.valueOf(variableValue instanceof VariableValue.Dictionary);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class c0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c0(AppCompatDialog appCompatDialog, Continuation<? super c0> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c0(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements Function1<VariableValue, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final d f16241d = new d();

        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull VariableValue variableValue) {
            boolean z3;
            Intrinsics.checkNotNullParameter(variableValue, "variableValue");
            if (variableValue instanceof VariableValue.Dictionary) {
                VariableValue.Dictionary dictionary = (VariableValue.Dictionary) variableValue;
                if (!dictionary.isArray() || dictionary.hasDictionaryChildren(dictionary)) {
                    z3 = true;
                    return Boolean.valueOf(z3);
                }
            }
            z3 = false;
            return Boolean.valueOf(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class e extends Lambda implements Function1<VariableValue, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final e f16249d = new e();

        e() {
            super(1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r2.hasNumericalChildren(r2) != false) goto L13;
         */
        @Override // kotlin.jvm.functions.Function1
        @org.jetbrains.annotations.NotNull
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Boolean invoke(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.variables.VariableValue r2) {
            /*
                r1 = this;
                java.lang.String r0 = "variableValue"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                boolean r0 = r2 instanceof com.arlosoft.macrodroid.variables.VariableValue.IntegerValue
                if (r0 != 0) goto L1c
                boolean r0 = r2 instanceof com.arlosoft.macrodroid.variables.VariableValue.DecimalValue
                if (r0 != 0) goto L1c
                boolean r0 = r2 instanceof com.arlosoft.macrodroid.variables.VariableValue.Dictionary
                if (r0 == 0) goto L1a
                com.arlosoft.macrodroid.variables.VariableValue$Dictionary r2 = (com.arlosoft.macrodroid.variables.VariableValue.Dictionary) r2
                boolean r2 = r2.hasNumericalChildren(r2)
                if (r2 == 0) goto L1a
                goto L1c
            L1a:
                r2 = 0
                goto L1d
            L1c:
                r2 = 1
            L1d:
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.variables.VariableHelper.e.invoke(com.arlosoft.macrodroid.variables.VariableValue):java.lang.Boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class f extends Lambda implements Function1<VariableValue, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final f f16250d = new f();

        f() {
            super(1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
            if (r2.hasStringChildren(r2) != false) goto L11;
         */
        @Override // kotlin.jvm.functions.Function1
        @org.jetbrains.annotations.NotNull
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Boolean invoke(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.variables.VariableValue r2) {
            /*
                r1 = this;
                java.lang.String r0 = "variableValue"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                boolean r0 = r2 instanceof com.arlosoft.macrodroid.variables.VariableValue.StringValue
                if (r0 != 0) goto L18
                boolean r0 = r2 instanceof com.arlosoft.macrodroid.variables.VariableValue.Dictionary
                if (r0 == 0) goto L16
                com.arlosoft.macrodroid.variables.VariableValue$Dictionary r2 = (com.arlosoft.macrodroid.variables.VariableValue.Dictionary) r2
                boolean r2 = r2.hasStringChildren(r2)
                if (r2 == 0) goto L16
                goto L18
            L16:
                r2 = 0
                goto L19
            L18:
                r2 = 1
            L19:
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.variables.VariableHelper.f.invoke(com.arlosoft.macrodroid.variables.VariableValue):java.lang.Boolean");
        }
    }

    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    static final class g extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ VariableValue.Dictionary $dictionary;
        final /* synthetic */ Macro $macro;
        final /* synthetic */ MagicText.MagicTextListener $magicTextListener;
        final /* synthetic */ int $style;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(VariableValue.Dictionary dictionary, Activity activity, Macro macro, MagicText.MagicTextListener magicTextListener, int i4, Continuation<? super g> continuation) {
            super(3, continuation);
            this.$dictionary = dictionary;
            this.$activity = activity;
            this.$macro = macro;
            this.$magicTextListener = magicTextListener;
            this.$style = i4;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new g(this.$dictionary, this.$activity, this.$macro, this.$magicTextListener, this.$style, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$dictionary.isArray()) {
                    MagicText.displayNumberVariableSelectionDialog(this.$activity, this.$macro, this.$magicTextListener, this.$style, IteratorType.NONE, false);
                } else {
                    MagicText.displaySelectionDialog(this.$activity, this.$magicTextListener, this.$macro, true, true, true, this.$style, IteratorType.NONE);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class h extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ VariableValue.Dictionary $dictionary;
        final /* synthetic */ Macro $macro;
        final /* synthetic */ MagicText.MagicTextListener $magicTextListener;
        final /* synthetic */ SelectableItem $selectableItem;
        final /* synthetic */ int $style;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(VariableValue.Dictionary dictionary, Activity activity, Macro macro, MagicText.MagicTextListener magicTextListener, int i4, SelectableItem selectableItem, Continuation<? super h> continuation) {
            super(3, continuation);
            this.$dictionary = dictionary;
            this.$activity = activity;
            this.$macro = macro;
            this.$magicTextListener = magicTextListener;
            this.$style = i4;
            this.$selectableItem = selectableItem;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new h(this.$dictionary, this.$activity, this.$macro, this.$magicTextListener, this.$style, this.$selectableItem, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IteratorType iteratorType;
            IteratorType iteratorType2;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                IteratorType iteratorType3 = null;
                if (this.$dictionary.isArray()) {
                    Activity activity = this.$activity;
                    Macro macro = this.$macro;
                    MagicText.MagicTextListener magicTextListener = this.$magicTextListener;
                    int i4 = this.$style;
                    SelectableItem selectableItem = this.$selectableItem;
                    if (selectableItem != null) {
                        iteratorType3 = selectableItem.isChildOfIterateDictionary();
                    }
                    if (iteratorType3 == null) {
                        iteratorType2 = IteratorType.NONE;
                    } else {
                        iteratorType2 = iteratorType3;
                    }
                    MagicText.displayNumberVariableSelectionDialog(activity, macro, magicTextListener, i4, iteratorType2, false);
                } else {
                    Activity activity2 = this.$activity;
                    MagicText.MagicTextListener magicTextListener2 = this.$magicTextListener;
                    Macro macro2 = this.$macro;
                    int i5 = this.$style;
                    SelectableItem selectableItem2 = this.$selectableItem;
                    if (selectableItem2 != null) {
                        iteratorType3 = selectableItem2.isChildOfIterateDictionary();
                    }
                    if (iteratorType3 == null) {
                        iteratorType = IteratorType.NONE;
                    } else {
                        iteratorType = iteratorType3;
                    }
                    MagicText.displaySelectionDialog(activity2, magicTextListener2, macro2, true, true, true, i5, iteratorType);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class i extends Lambda implements Function1<String, CharSequence> {

        /* renamed from: d  reason: collision with root package name */
        public static final i f16251d = new i();

        i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return "[" + it + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class j extends Lambda implements Function1<String, CharSequence> {

        /* renamed from: d  reason: collision with root package name */
        public static final j f16252d = new j();

        j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return "[" + it + "]";
        }
    }

    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    static final class k extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ MagicText.MagicTextListener $authPasswordTextListener;
        final /* synthetic */ VariableValue.Dictionary $dictionary;
        final /* synthetic */ IteratorType $iteratorType;
        final /* synthetic */ EditText $keyName;
        final /* synthetic */ Macro $macro;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(EditText editText, VariableValue.Dictionary dictionary, Activity activity, Macro macro, MagicText.MagicTextListener magicTextListener, IteratorType iteratorType, Continuation<? super k> continuation) {
            super(3, continuation);
            this.$keyName = editText;
            this.$dictionary = dictionary;
            this.$activity = activity;
            this.$macro = macro;
            this.$authPasswordTextListener = magicTextListener;
            this.$iteratorType = iteratorType;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new k(this.$keyName, this.$dictionary, this.$activity, this.$macro, this.$authPasswordTextListener, this.$iteratorType, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$keyName.setInputType(1);
                if (this.$dictionary.isArray()) {
                    MagicText.displayNumberVariableSelectionDialog(this.$activity, this.$macro, this.$authPasswordTextListener, R.style.Theme_App_Dialog_Action_SmallText, this.$iteratorType, false);
                } else {
                    MagicText.displaySelectionDialog(this.$activity, this.$authPasswordTextListener, this.$macro, R.style.Theme_App_Dialog_Action_SmallText, this.$iteratorType);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    static final class l extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ Function1<Pair<String, Integer>, Unit> $keyAndTypeChosen;
        final /* synthetic */ EditText $keyName;
        final /* synthetic */ Spinner $valueTypeSpinner;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        l(Function1<? super Pair<String, Integer>, Unit> function1, EditText editText, Spinner spinner, AppCompatDialog appCompatDialog, Continuation<? super l> continuation) {
            super(3, continuation);
            this.$keyAndTypeChosen = function1;
            this.$keyName = editText;
            this.$valueTypeSpinner = spinner;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new l(this.$keyAndTypeChosen, this.$keyName, this.$valueTypeSpinner, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$keyAndTypeChosen.invoke(new Pair<>(this.$keyName.getText().toString(), Boxing.boxInt(this.$valueTypeSpinner.getSelectedItemPosition())));
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    static final class m extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(AppCompatDialog appCompatDialog, Continuation<? super m> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new m(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    @SourceDebugExtension({"SMAP\nVariableHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VariableHelper.kt\ncom/arlosoft/macrodroid/variables/VariableHelper$showDictionaryEditScreen$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,1920:1\n260#2,4:1921\n*S KotlinDebug\n*F\n+ 1 VariableHelper.kt\ncom/arlosoft/macrodroid/variables/VariableHelper$showDictionaryEditScreen$1\n*L\n982#1:1921,4\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class n extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewGroup $searchContainer;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(ViewGroup viewGroup, Continuation<? super n> continuation) {
            super(3, continuation);
            this.$searchContainer = viewGroup;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new n(this.$searchContainer, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z3;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ViewGroup viewGroup = this.$searchContainer;
                int i4 = 0;
                if (viewGroup.getVisibility() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!(!z3)) {
                    i4 = 8;
                }
                viewGroup.setVisibility(i4);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class o extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ DictionaryEventListener $dictionaryEventListener;
        final /* synthetic */ Macro $macro;
        final /* synthetic */ TextView $varName;
        final /* synthetic */ MacroDroidVariable $variable;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(Activity activity, Macro macro, MacroDroidVariable macroDroidVariable, TextView textView, DictionaryEventListener dictionaryEventListener, Continuation<? super o> continuation) {
            super(3, continuation);
            this.$activity = activity;
            this.$macro = macro;
            this.$variable = macroDroidVariable;
            this.$varName = textView;
            this.$dictionaryEventListener = dictionaryEventListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(TextView textView, MacroDroidVariable macroDroidVariable, DictionaryEventListener dictionaryEventListener, View view) {
            textView.setText(macroDroidVariable.getName());
            dictionaryEventListener.refreshRequired();
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: b */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new o(this.$activity, this.$macro, this.$variable, this.$varName, this.$dictionaryEventListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Activity activity = this.$activity;
                Macro macro = this.$macro;
                final MacroDroidVariable macroDroidVariable = this.$variable;
                final TextView textView = this.$varName;
                final DictionaryEventListener dictionaryEventListener = this.$dictionaryEventListener;
                VariableHelper.promptForNewName(activity, macro, macroDroidVariable, new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.m0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VariableHelper.o.c(textView, macroDroidVariable, dictionaryEventListener, view);
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class p extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ VariableValue.Dictionary $dictionary;
        final /* synthetic */ VariableHelper$showDictionaryEditScreen$interceptDictionaryEventListener$1 $interceptDictionaryEventListener;
        final /* synthetic */ ArrayList<String> $parentKeys;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(Activity activity, VariableValue.Dictionary dictionary, ArrayList<String> arrayList, VariableHelper$showDictionaryEditScreen$interceptDictionaryEventListener$1 variableHelper$showDictionaryEditScreen$interceptDictionaryEventListener$1, Continuation<? super p> continuation) {
            super(3, continuation);
            this.$activity = activity;
            this.$dictionary = dictionary;
            this.$parentKeys = arrayList;
            this.$interceptDictionaryEventListener = variableHelper$showDictionaryEditScreen$interceptDictionaryEventListener$1;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new p(this.$activity, this.$dictionary, this.$parentKeys, this.$interceptDictionaryEventListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                VariableHelper.showEditDictionaryEntryDialog(this.$activity, R.style.Theme_App_Dialog_Variables_NoTitle, this.$dictionary, null, this.$parentKeys, this.$interceptDictionaryEventListener);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class q extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<DictionaryVariableAdapter> $adapter;
        final /* synthetic */ EditText $searchText;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(EditText editText, Ref.ObjectRef<DictionaryVariableAdapter> objectRef, Continuation<? super q> continuation) {
            super(3, continuation);
            this.$searchText = editText;
            this.$adapter = objectRef;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new q(this.$searchText, this.$adapter, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            DictionaryVariableAdapter dictionaryVariableAdapter;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$searchText.setText("");
                DictionaryVariableAdapter dictionaryVariableAdapter2 = this.$adapter.element;
                if (dictionaryVariableAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    dictionaryVariableAdapter = null;
                } else {
                    dictionaryVariableAdapter = dictionaryVariableAdapter2;
                }
                dictionaryVariableAdapter.getFilter().filter("");
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class r extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(AppCompatDialog appCompatDialog, Continuation<? super r> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new r(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class s extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ VariableValue.Dictionary $dictionary;
        final /* synthetic */ VariableValue.DictionaryEntry $dictionaryEntry;
        final /* synthetic */ DictionaryEventListener $dictionaryEventListener;
        final /* synthetic */ EditText $keyName;
        final /* synthetic */ ArrayList<String> $parentKeys;
        final /* synthetic */ EditText $textValue;
        final /* synthetic */ RadioButton $trueRadio;
        final /* synthetic */ Spinner $valueTypeSpinner;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(EditText editText, Spinner spinner, RadioButton radioButton, EditText editText2, VariableValue.DictionaryEntry dictionaryEntry, ArrayList<String> arrayList, VariableValue.Dictionary dictionary, DictionaryEventListener dictionaryEventListener, AppCompatDialog appCompatDialog, Continuation<? super s> continuation) {
            super(3, continuation);
            this.$keyName = editText;
            this.$valueTypeSpinner = spinner;
            this.$trueRadio = radioButton;
            this.$textValue = editText2;
            this.$dictionaryEntry = dictionaryEntry;
            this.$parentKeys = arrayList;
            this.$dictionary = dictionary;
            this.$dictionaryEventListener = dictionaryEventListener;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new s(this.$keyName, this.$valueTypeSpinner, this.$trueRadio, this.$textValue, this.$dictionaryEntry, this.$parentKeys, this.$dictionary, this.$dictionaryEventListener, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
            /*
                r8 = this;
                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r8.label
                if (r0 != 0) goto Ld2
                kotlin.ResultKt.throwOnFailure(r9)
                android.widget.EditText r9 = r8.$keyName
                android.text.Editable r9 = r9.getText()
                java.lang.String r1 = r9.toString()
                android.widget.Spinner r9 = r8.$valueTypeSpinner
                int r9 = r9.getSelectedItemPosition()
                r0 = 2
                r2 = 0
                if (r9 == 0) goto L84
                r3 = 1
                if (r9 == r3) goto L74
                if (r9 == r0) goto L64
                r0 = 3
                if (r9 == r0) goto L54
                r0 = 4
                if (r9 == r0) goto L44
                r0 = 5
                if (r9 != r0) goto L3c
                com.arlosoft.macrodroid.variables.VariableValue$Dictionary r9 = new com.arlosoft.macrodroid.variables.VariableValue$Dictionary
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                r4 = 1
                r5 = 0
                r6 = 4
                r7 = 0
                r2 = r9
                r2.<init>(r3, r4, r5, r6, r7)
                goto L90
            L3c:
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "Invalid Dictionary Value"
                r9.<init>(r0)
                throw r9
            L44:
                com.arlosoft.macrodroid.variables.VariableValue$Dictionary r9 = new com.arlosoft.macrodroid.variables.VariableValue$Dictionary
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                r4 = 0
                r5 = 0
                r6 = 6
                r7 = 0
                r2 = r9
                r2.<init>(r3, r4, r5, r6, r7)
                goto L90
            L54:
                com.arlosoft.macrodroid.variables.VariableValue$DecimalValue r9 = new com.arlosoft.macrodroid.variables.VariableValue$DecimalValue
                android.widget.EditText r0 = r8.$textValue
                android.text.Editable r0 = r0.getText()
                java.lang.String r0 = r0.toString()
                r9.<init>(r0)
                goto L8f
            L64:
                com.arlosoft.macrodroid.variables.VariableValue$StringValue r9 = new com.arlosoft.macrodroid.variables.VariableValue$StringValue
                android.widget.EditText r3 = r8.$textValue
                android.text.Editable r3 = r3.getText()
                java.lang.String r3 = r3.toString()
                r9.<init>(r3, r2, r0, r2)
                goto L8f
            L74:
                com.arlosoft.macrodroid.variables.VariableValue$IntegerValue r9 = new com.arlosoft.macrodroid.variables.VariableValue$IntegerValue
                android.widget.EditText r0 = r8.$textValue
                android.text.Editable r0 = r0.getText()
                java.lang.String r0 = r0.toString()
                r9.<init>(r0)
                goto L8f
            L84:
                com.arlosoft.macrodroid.variables.VariableValue$BooleanValue r9 = new com.arlosoft.macrodroid.variables.VariableValue$BooleanValue
                android.widget.RadioButton r3 = r8.$trueRadio
                boolean r3 = r3.isChecked()
                r9.<init>(r3, r2, r0, r2)
            L8f:
                r2 = r9
            L90:
                com.arlosoft.macrodroid.variables.VariableValue$DictionaryEntry r9 = r8.$dictionaryEntry
                if (r9 == 0) goto La5
                java.lang.String r9 = r9.getKey()
                if (r9 == 0) goto La5
                com.arlosoft.macrodroid.variables.VariableValue$Dictionary r0 = r8.$dictionary
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r9)
                if (r3 != 0) goto La5
                r0.removeKey(r9)
            La5:
                java.util.ArrayList<java.lang.String> r9 = r8.$parentKeys
                java.util.List r9 = kotlin.collections.CollectionsKt.plus(r9, r1)
                r2.setParentKeys(r9)
                com.arlosoft.macrodroid.variables.VariableValue$DictionaryEntry r9 = new com.arlosoft.macrodroid.variables.VariableValue$DictionaryEntry
                r3 = 0
                r4 = 4
                r5 = 0
                r0 = r9
                r0.<init>(r1, r2, r3, r4, r5)
                com.arlosoft.macrodroid.variables.VariableValue$Dictionary r0 = r8.$dictionary
                r0.setEntry(r9)
                com.arlosoft.macrodroid.variables.DictionaryEventListener r0 = r8.$dictionaryEventListener
                com.arlosoft.macrodroid.variables.VariableValue$DictionaryEntry r1 = r8.$dictionaryEntry
                r0.entryUpdated(r9, r1)
                com.arlosoft.macrodroid.common.MacroDroidVariableStore r9 = com.arlosoft.macrodroid.common.MacroDroidVariableStore.getInstance()
                r9.persistData()
                androidx.appcompat.app.AppCompatDialog r9 = r8.$dialog
                r9.dismiss()
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            Ld2:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.variables.VariableHelper.s.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class t extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(AppCompatDialog appCompatDialog, Continuation<? super t> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new t(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class u extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ VariableValue.Dictionary $dictionary;
        final /* synthetic */ VariableValue.DictionaryEntry $dictionaryEntry;
        final /* synthetic */ DictionaryEventListener $dictionaryEventListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(VariableValue.DictionaryEntry dictionaryEntry, AppCompatDialog appCompatDialog, VariableValue.Dictionary dictionary, DictionaryEventListener dictionaryEventListener, Continuation<? super u> continuation) {
            super(3, continuation);
            this.$dictionaryEntry = dictionaryEntry;
            this.$dialog = appCompatDialog;
            this.$dictionary = dictionary;
            this.$dictionaryEventListener = dictionaryEventListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new u(this.$dictionaryEntry, this.$dialog, this.$dictionary, this.$dictionaryEventListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                VariableValue.DictionaryEntry dictionaryEntry = this.$dictionaryEntry;
                if (dictionaryEntry != null) {
                    VariableValue.Dictionary dictionary = this.$dictionary;
                    DictionaryEventListener dictionaryEventListener = this.$dictionaryEventListener;
                    dictionary.removeEntry(dictionaryEntry);
                    dictionaryEventListener.entryRemoved(dictionaryEntry);
                }
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    static final class v extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ VariableValue.Dictionary $dictionary;
        final /* synthetic */ VariableValue.DictionaryEntry $dictionaryEntry;
        final /* synthetic */ DictionaryEventListener $dictionaryEventListener;
        final /* synthetic */ EditText $keyName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v(EditText editText, VariableValue.DictionaryEntry dictionaryEntry, VariableValue.Dictionary dictionary, DictionaryEventListener dictionaryEventListener, AppCompatDialog appCompatDialog, Continuation<? super v> continuation) {
            super(3, continuation);
            this.$keyName = editText;
            this.$dictionaryEntry = dictionaryEntry;
            this.$dictionary = dictionary;
            this.$dictionaryEventListener = dictionaryEventListener;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new v(this.$keyName, this.$dictionaryEntry, this.$dictionary, this.$dictionaryEventListener, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                String obj2 = this.$keyName.getText().toString();
                String key = this.$dictionaryEntry.getKey();
                VariableValue.Dictionary dictionary = this.$dictionary;
                if (!Intrinsics.areEqual(obj2, key)) {
                    dictionary.removeKey(key);
                }
                VariableValue.DictionaryEntry dictionaryEntry = this.$dictionaryEntry;
                Intrinsics.checkNotNull(dictionaryEntry);
                VariableValue.DictionaryEntry dictionaryEntry2 = new VariableValue.DictionaryEntry(obj2, dictionaryEntry.getVariable(), null, 4, null);
                this.$dictionary.setEntry(dictionaryEntry2);
                this.$dictionaryEventListener.entryUpdated(dictionaryEntry2, this.$dictionaryEntry);
                this.$dictionaryEventListener.refreshRequired();
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    static final class w extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(AppCompatDialog appCompatDialog, Continuation<? super w> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new w(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
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

    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    static final class x extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ VariableValue.Dictionary $dictionary;
        final /* synthetic */ VariableValue.DictionaryEntry $dictionaryEntry;
        final /* synthetic */ DictionaryEventListener $dictionaryEventListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        x(VariableValue.DictionaryEntry dictionaryEntry, AppCompatDialog appCompatDialog, VariableValue.Dictionary dictionary, DictionaryEventListener dictionaryEventListener, Continuation<? super x> continuation) {
            super(3, continuation);
            this.$dictionaryEntry = dictionaryEntry;
            this.$dialog = appCompatDialog;
            this.$dictionary = dictionary;
            this.$dictionaryEventListener = dictionaryEventListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new x(this.$dictionaryEntry, this.$dialog, this.$dictionary, this.$dictionaryEventListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                VariableValue.DictionaryEntry dictionaryEntry = this.$dictionaryEntry;
                VariableValue.Dictionary dictionary = this.$dictionary;
                DictionaryEventListener dictionaryEventListener = this.$dictionaryEventListener;
                dictionary.removeEntry(dictionaryEntry);
                dictionaryEventListener.entryRemoved(dictionaryEntry);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class y extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ EditText $valueEditText;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        y(EditText editText, Continuation<? super y> continuation) {
            super(3, continuation);
            this.$valueEditText = editText;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new y(this.$valueEditText, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                EditText editText = this.$valueEditText;
                if (editText != null) {
                    editText.setText("");
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    public static final class z extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ DictionaryEventListener $dictionaryEventListener;
        final /* synthetic */ Macro $macro;
        final /* synthetic */ int $themeTitle;
        final /* synthetic */ MacroDroidVariable $variable;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z(Activity activity, MacroDroidVariable macroDroidVariable, Macro macro, int i4, AppCompatDialog appCompatDialog, DictionaryEventListener dictionaryEventListener, Continuation<? super z> continuation) {
            super(3, continuation);
            this.$activity = activity;
            this.$variable = macroDroidVariable;
            this.$macro = macro;
            this.$themeTitle = i4;
            this.$dialog = appCompatDialog;
            this.$dictionaryEventListener = dictionaryEventListener;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new z(this.$activity, this.$variable, this.$macro, this.$themeTitle, this.$dialog, this.$dictionaryEventListener, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                VariableHelper.INSTANCE.z(this.$activity, this.$variable, this.$macro, this.$themeTitle, this.$dialog, this.$dictionaryEventListener);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private VariableHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Macro macro, MacroDroidVariable variable, DictionaryEventListener dictionaryEventListener, Dialog dialogToClose, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(macro, "$macro");
        Intrinsics.checkNotNullParameter(variable, "$variable");
        Intrinsics.checkNotNullParameter(dictionaryEventListener, "$dictionaryEventListener");
        Intrinsics.checkNotNullParameter(dialogToClose, "$dialogToClose");
        macro.getLocalVariables().remove(variable);
        dictionaryEventListener.refreshRequired();
        dialogToClose.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(EditText keyName, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(keyName, "$keyName");
        keyName.setInputType(1);
        int max = Math.max(keyName.getSelectionStart(), 0);
        int max2 = Math.max(keyName.getSelectionEnd(), 0);
        Editable text = keyName.getText();
        if (text != null) {
            int min = Math.min(max, max2);
            int max3 = Math.max(max, max2);
            String str = magicTextPair.magicText;
            text.replace(min, max3, str, 0, str.length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(Function1 keyChosen, EditText keyName, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(keyChosen, "$keyChosen");
        Intrinsics.checkNotNullParameter(keyName, "$keyName");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        keyChosen.invoke(keyName.getText().toString());
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(EditText variableName, MagicText.MagicTextPair pair) {
        Intrinsics.checkNotNullParameter(variableName, "$variableName");
        Intrinsics.checkNotNullParameter(pair, "pair");
        int max = Math.max(variableName.getSelectionStart(), 0);
        int max2 = Math.max(variableName.getSelectionEnd(), 0);
        Editable text = variableName.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = pair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Activity activity, MagicText.MagicTextListener textMagicTextListener, Macro macro, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(textMagicTextListener, "$textMagicTextListener");
        MagicText.displaySelectionDialog(activity, textMagicTextListener, macro, true, true, true, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(EditText variableName, NewVariableCreationListener newVariableCreationListener, Activity activity, Integer num, Spinner variableTypeSpinner, boolean z3, boolean z4, RadioButton radioButtonLocal, boolean z5, AppCompatDialog dialog, Ref.ObjectRef createNowCheckbox, boolean z6, View view) {
        CharSequence trim;
        int selectedItemPosition;
        int selectedItemPosition2;
        boolean z7;
        Intrinsics.checkNotNullParameter(variableName, "$variableName");
        Intrinsics.checkNotNullParameter(newVariableCreationListener, "$newVariableCreationListener");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(variableTypeSpinner, "$variableTypeSpinner");
        Intrinsics.checkNotNullParameter(radioButtonLocal, "$radioButtonLocal");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(createNowCheckbox, "$createNowCheckbox");
        trim = StringsKt__StringsKt.trim(variableName.getText().toString());
        String obj = trim.toString();
        if (!newVariableCreationListener.validateVariableName(obj)) {
            showAlreadyExistsDialog(activity, R.style.Theme_App_Dialog_Variables);
            return;
        }
        if (num != null) {
            selectedItemPosition = num.intValue();
        } else {
            selectedItemPosition = variableTypeSpinner.getSelectedItemPosition();
        }
        if (!z3 && (selectedItemPosition == 5 || selectedItemPosition == 4)) {
            UpgradeActivity2.Companion.animateInUpgradeSceen(activity);
            return;
        }
        if (z4) {
            z5 = radioButtonLocal.isChecked();
        }
        if (num != null) {
            selectedItemPosition2 = num.intValue();
        } else {
            selectedItemPosition2 = variableTypeSpinner.getSelectedItemPosition();
        }
        MacroDroidVariable macroDroidVariable = new MacroDroidVariable(selectedItemPosition2, obj, z5);
        dialog.dismiss();
        if (!((CheckBox) createNowCheckbox.element).isChecked() && z6) {
            z7 = false;
        } else {
            z7 = true;
        }
        newVariableCreationListener.newVariableCreated(macroDroidVariable, z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(EditText keyText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(keyText, "$keyText");
        keyText.setInputType(1);
        int max = Math.max(keyText.getSelectionStart(), 0);
        int max2 = Math.max(keyText.getSelectionEnd(), 0);
        Editable text = keyText.getText();
        if (text != null) {
            int min = Math.min(max, max2);
            int max3 = Math.max(max, max2);
            String str = magicTextPair.magicText;
            text.replace(min, max3, str, 0, str.length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(EditText keyText, Spinner valueTypeSpinner, Function1 keyChosen, AppCompatDialog dialog, View view) {
        boolean z3;
        Intrinsics.checkNotNullParameter(keyText, "$keyText");
        Intrinsics.checkNotNullParameter(valueTypeSpinner, "$valueTypeSpinner");
        Intrinsics.checkNotNullParameter(keyChosen, "$keyChosen");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        List<String> M = INSTANCE.M(keyText.getText().toString());
        List<String> list = M;
        if (list != null && !list.isEmpty()) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3 && !M.contains("")) {
            keyChosen.invoke(new ManualKeyData(M, Integer.valueOf(valueTypeSpinner.getSelectedItemPosition())));
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> M(String str) {
        boolean endsWith$default;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        endsWith$default = kotlin.text.m.endsWith$default(str, "]", false, 2, null);
        if (!endsWith$default) {
            return null;
        }
        int length = str.length();
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (str.charAt(i5) == '[') {
                i4++;
                if (i4 == 1) {
                    sb = new StringBuilder();
                } else {
                    sb.append(str.charAt(i5));
                }
            } else if (str.charAt(i5) == ']') {
                i4--;
                if (i4 == 0) {
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "entryBuilder.toString()");
                    arrayList.add(sb2);
                } else {
                    sb.append(str.charAt(i5));
                }
            } else {
                sb.append(str.charAt(i5));
            }
        }
        if (i4 != 0) {
            return null;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(VariableValue.Dictionary dictionary, DictionaryVariableAdapter dictionaryVariableAdapter, View view, RecyclerView recyclerView, Function0<Unit> function0) {
        int i4;
        MacroDroidVariableStore.getInstance().persistData();
        dictionaryVariableAdapter.updateDictionary(dictionary);
        int i5 = 0;
        if (dictionary.getEntries().isEmpty()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        view.setVisibility(i4);
        if (!(!dictionary.getEntries().isEmpty())) {
            i5 = 8;
        }
        recyclerView.setVisibility(i5);
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void O(Context context, final MacroDroidVariable macroDroidVariable, final DictionaryKeys dictionaryKeys, final View.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
        VariableValue.DictionaryEntry dictionaryEntryFromKeyList;
        VariableValue variableValue = macroDroidVariable.getVariableValue();
        if (dictionaryKeys != null && (dictionaryEntryFromKeyList = macroDroidVariable.getDictionaryEntryFromKeyList(dictionaryKeys.getKeys())) != null) {
            variableValue = dictionaryEntryFromKeyList.getVariable();
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(context, R.style.Theme_App_Dialog_Variables);
        appCompatDialog.setContentView(R.layout.enter_boolean_value_dialog);
        String name = macroDroidVariable.getName();
        String formattedDictionaryKeys = getFormattedDictionaryKeys(dictionaryKeys);
        appCompatDialog.setTitle(name + formattedDictionaryKeys);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.trueRadio);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.falseRadio);
        Intrinsics.checkNotNull(radioButton);
        Intrinsics.checkNotNull(variableValue, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.BooleanValue");
        VariableValue.BooleanValue booleanValue = (VariableValue.BooleanValue) variableValue;
        radioButton.setChecked(booleanValue.getBooleanValue());
        Intrinsics.checkNotNull(radioButton2);
        Intrinsics.checkNotNull(variableValue, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.BooleanValue");
        radioButton2.setChecked(!booleanValue.getBooleanValue());
        Intrinsics.checkNotNull(button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VariableHelper.P(MacroDroidVariable.this, radioButton, dictionaryKeys, onClickListener, appCompatDialog, view);
            }
        });
        Intrinsics.checkNotNull(button2);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VariableHelper.Q(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.setOnDismissListener(onDismissListener);
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        window.setType(OverlayUtils.getOverlayType());
        appCompatDialog.show();
        Window window2 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setSoftInputMode(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(MacroDroidVariable variable, RadioButton radioButton, DictionaryKeys dictionaryKeys, View.OnClickListener onClickListener, AppCompatDialog dialog, View view) {
        List<String> list;
        Intrinsics.checkNotNullParameter(variable, "$variable");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        MacroDroidVariableStore macroDroidVariableStore = MacroDroidVariableStore.getInstance();
        boolean isChecked = radioButton.isChecked();
        if (dictionaryKeys != null) {
            list = dictionaryKeys.getKeys();
        } else {
            list = null;
        }
        macroDroidVariableStore.variableUpdate(variable, new VariableValue.BooleanValue(isChecked, list), true, null);
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(EditText editText, MacroDroidVariable variable, AppCompatDialog dialog, Context context, Macro macro, View.OnClickListener onClickListener, View view) {
        Intrinsics.checkNotNullParameter(variable, "$variable");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(context, "$context");
        String obj = editText.getText().toString();
        if (Intrinsics.areEqual(obj, variable.getName())) {
            dialog.dismiss();
        } else if (MacroDroidVariableStore.getInstance().getVariableByName(obj) != null) {
            showAlreadyExistsDialog(context, R.style.Theme_App_Dialog_Variables);
        } else {
            if (!variable.isLocalVar()) {
                INSTANCE.W(variable, obj);
            } else if (macro != null) {
                INSTANCE.X(variable, macro, obj);
            }
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(MacroDroidVariable variable, EditText editText, Ref.ObjectRef variableValue, DictionaryKeys dictionaryKeys, View.OnClickListener onClickListener, AppCompatDialog dialog, View view) {
        List<String> list;
        Intrinsics.checkNotNullParameter(variable, "$variable");
        Intrinsics.checkNotNullParameter(variableValue, "$variableValue");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        MacroDroidVariableStore macroDroidVariableStore = MacroDroidVariableStore.getInstance();
        VariableValue.Companion companion = VariableValue.Companion;
        String obj = editText.getText().toString();
        int variableType = ((VariableValue) variableValue.element).getVariableType();
        if (dictionaryKeys != null) {
            list = dictionaryKeys.getKeys();
        } else {
            list = null;
        }
        macroDroidVariableStore.variableUpdate(variable, companion.fromTextValueForType(obj, variableType, list), true, null);
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    private final void V(String str, String str2, String str3) {
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacrosWithActionBlocks(false)) {
            Iterator<Action> it = macro.getActions().iterator();
            while (it.hasNext()) {
                Action next = it.next();
                if (next instanceof ActionBlockAction) {
                    ActionBlockAction actionBlockAction = (ActionBlockAction) next;
                    if (Intrinsics.areEqual(actionBlockAction.getActionBlockName(), str)) {
                        actionBlockAction.updateVarName(str2, str3);
                    }
                }
            }
        }
    }

    private final void W(MacroDroidVariable macroDroidVariable, String str) {
        String name = macroDroidVariable.getName();
        List<Macro> allCompletedMacrosWithActionBlocks = MacroStore.getInstance().getAllCompletedMacrosWithActionBlocks(false);
        MacroDroidVariableStore.getInstance().variablesetName(macroDroidVariable, str);
        for (Macro macro : allCompletedMacrosWithActionBlocks) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger trigger = it.next();
                Intrinsics.checkNotNullExpressionValue(trigger, "trigger");
                Y(trigger, name, str);
                f0(trigger, name, str);
                for (Constraint constraint : trigger.getConstraints()) {
                    Intrinsics.checkNotNullExpressionValue(constraint, "constraint");
                    x(constraint, name, str);
                }
            }
            Iterator<Action> it2 = macro.getActions().iterator();
            while (it2.hasNext()) {
                Action action = it2.next();
                Intrinsics.checkNotNullExpressionValue(action, "action");
                Y(action, name, str);
                f0(action, name, str);
                for (Constraint constraint2 : action.getConstraints()) {
                    Intrinsics.checkNotNullExpressionValue(constraint2, "constraint");
                    x(constraint2, name, str);
                }
                if (action instanceof WaitUntilTriggerAction) {
                    Iterator<Trigger> it3 = ((WaitUntilTriggerAction) action).getTriggersToWaitFor().iterator();
                    while (it3.hasNext()) {
                        Trigger trigger2 = it3.next();
                        Intrinsics.checkNotNullExpressionValue(trigger2, "trigger");
                        Y(trigger2, name, str);
                        f0(trigger2, name, str);
                        for (Constraint constraint3 : trigger2.getConstraints()) {
                            Intrinsics.checkNotNullExpressionValue(constraint3, "constraint");
                            x(constraint3, name, str);
                        }
                    }
                }
            }
            for (Constraint constraint4 : macro.getConstraints()) {
                Intrinsics.checkNotNullExpressionValue(constraint4, "constraint");
                x(constraint4, name, str);
            }
        }
        DrawerConfiguration drawerConfiguration = Settings.getDrawerConfiguration(MacroDroidApplication.Companion.getInstance());
        for (DrawerItem drawerItem : drawerConfiguration.drawerItems) {
            if (drawerItem instanceof DrawerItemVariable) {
                DrawerItemVariable drawerItemVariable = (DrawerItemVariable) drawerItem;
                if (Intrinsics.areEqual(drawerItemVariable.getVariableName(), name)) {
                    drawerItemVariable.setVariableName(str);
                }
            }
        }
        Settings.setDrawerConfiguration(MacroDroidApplication.Companion.getInstance(), drawerConfiguration);
        MacroStore.getInstance().writeToJSON();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(MacroDroidVariable macroDroidVariable, Macro macro, String str) {
        String name = macroDroidVariable.getName();
        macro.renameLocalVariable(macroDroidVariable, str);
        Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
        while (it.hasNext()) {
            Trigger trigger = it.next();
            Intrinsics.checkNotNullExpressionValue(trigger, "trigger");
            Y(trigger, name, str);
            f0(trigger, name, str);
            for (Constraint constraint : trigger.getConstraints()) {
                Intrinsics.checkNotNullExpressionValue(constraint, "constraint");
                x(constraint, name, str);
            }
        }
        Iterator<Action> it2 = macro.getActions().iterator();
        while (it2.hasNext()) {
            Action action = it2.next();
            Intrinsics.checkNotNullExpressionValue(action, "action");
            Y(action, name, str);
            f0(action, name, str);
            for (Constraint constraint2 : action.getConstraints()) {
                Intrinsics.checkNotNullExpressionValue(constraint2, "constraint");
                x(constraint2, name, str);
            }
            if (action instanceof WaitUntilTriggerAction) {
                Iterator<Trigger> it3 = ((WaitUntilTriggerAction) action).getTriggersToWaitFor().iterator();
                while (it3.hasNext()) {
                    Trigger trigger2 = it3.next();
                    Intrinsics.checkNotNullExpressionValue(trigger2, "trigger");
                    Y(trigger2, name, str);
                    f0(trigger2, name, str);
                    for (Constraint constraint3 : trigger2.getConstraints()) {
                        Intrinsics.checkNotNullExpressionValue(constraint3, "constraint");
                        x(constraint3, name, str);
                    }
                }
            }
        }
        for (Constraint constraint4 : macro.getConstraints()) {
            Intrinsics.checkNotNullExpressionValue(constraint4, "constraint");
            x(constraint4, name, str);
        }
        if (macro instanceof ActionBlock) {
            String name2 = ((ActionBlock) macro).getName();
            Intrinsics.checkNotNullExpressionValue(name2, "macro.name");
            V(name2, name, str);
        }
        MacroStore.getInstance().writeToJSON();
    }

    private final void Y(SelectableItem selectableItem, String str, String str2) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        String replace$default;
        String replace$default2;
        String replace$default3;
        String replace$default4;
        String replace$default5;
        String replace$default6;
        String replace$default7;
        String replace$default8;
        String replace$default9;
        String replace$default10;
        String replace$default11;
        String replace$default12;
        String replace$default13;
        String replace$default14;
        String replace$default15;
        String replace$default16;
        boolean contains$default4;
        boolean contains$default5;
        if (selectableItem instanceof SupportsMagicText) {
            SupportsMagicText supportsMagicText = (SupportsMagicText) selectableItem;
            String[] possibleMagicText = supportsMagicText.getPossibleMagicText();
            int length = possibleMagicText.length;
            boolean z3 = false;
            int i4 = 0;
            while (i4 < length) {
                if (!TextUtils.isEmpty(possibleMagicText[i4])) {
                    String str3 = possibleMagicText[i4];
                    Intrinsics.checkNotNullExpressionValue(str3, "textValues[i]");
                    contains$default = StringsKt__StringsKt.contains$default(str3, "v=" + str, z3, 2, (Object) null);
                    if (!contains$default) {
                        String str4 = possibleMagicText[i4];
                        Intrinsics.checkNotNullExpressionValue(str4, "textValues[i]");
                        contains$default4 = StringsKt__StringsKt.contains$default(str4, "strlen=" + str, z3, 2, (Object) null);
                        if (!contains$default4) {
                            String str5 = possibleMagicText[i4];
                            Intrinsics.checkNotNullExpressionValue(str5, "textValues[i]");
                            contains$default5 = StringsKt__StringsKt.contains$default(str5, "strval=" + str, z3, 2, (Object) null);
                            if (!contains$default5) {
                            }
                        }
                    }
                    String str6 = possibleMagicText[i4];
                    Intrinsics.checkNotNullExpressionValue(str6, "textValues[i]");
                    contains$default2 = StringsKt__StringsKt.contains$default(str6, "stopwatch=" + str, z3, 2, (Object) null);
                    if (!contains$default2) {
                        String str7 = possibleMagicText[i4];
                        Intrinsics.checkNotNullExpressionValue(str7, "textValues[i]");
                        contains$default3 = StringsKt__StringsKt.contains$default(str7, "stopwatchtime=" + str, z3, 2, (Object) null);
                        if (!contains$default3) {
                            String str8 = possibleMagicText[i4];
                            Intrinsics.checkNotNullExpressionValue(str8, "textValues[i]");
                            replace$default = kotlin.text.m.replace$default(str8, "{v=" + str + "}", "{v=" + str2 + "}", false, 4, (Object) null);
                            possibleMagicText[i4] = replace$default;
                            Intrinsics.checkNotNullExpressionValue(replace$default, "textValues[i]");
                            replace$default2 = kotlin.text.m.replace$default(replace$default, "[v=" + str + "]", "[v=" + str2 + "]", false, 4, (Object) null);
                            possibleMagicText[i4] = replace$default2;
                            Intrinsics.checkNotNullExpressionValue(replace$default2, "textValues[i]");
                            replace$default3 = kotlin.text.m.replace$default(replace$default2, "{v=" + str + "[", "{v=" + str2 + "[", false, 4, (Object) null);
                            possibleMagicText[i4] = replace$default3;
                            Intrinsics.checkNotNullExpressionValue(replace$default3, "textValues[i]");
                            replace$default4 = kotlin.text.m.replace$default(replace$default3, "[v=" + str + "[", "[v=" + str2 + "[", false, 4, (Object) null);
                            possibleMagicText[i4] = replace$default4;
                            Intrinsics.checkNotNullExpressionValue(replace$default4, "textValues[i]");
                            replace$default5 = kotlin.text.m.replace$default(replace$default4, "{lv=" + str + "}", "{lv=" + str2 + "}", false, 4, (Object) null);
                            possibleMagicText[i4] = replace$default5;
                            Intrinsics.checkNotNullExpressionValue(replace$default5, "textValues[i]");
                            replace$default6 = kotlin.text.m.replace$default(replace$default5, "[lv=" + str + "]", "[lv=" + str2 + "]", false, 4, (Object) null);
                            possibleMagicText[i4] = replace$default6;
                            Intrinsics.checkNotNullExpressionValue(replace$default6, "textValues[i]");
                            replace$default7 = kotlin.text.m.replace$default(replace$default6, "{lv=" + str + "[", "{lv=" + str2 + "[", false, 4, (Object) null);
                            possibleMagicText[i4] = replace$default7;
                            Intrinsics.checkNotNullExpressionValue(replace$default7, "textValues[i]");
                            replace$default8 = kotlin.text.m.replace$default(replace$default7, "[lv=" + str + "[", "[lv=" + str2 + "[", false, 4, (Object) null);
                            possibleMagicText[i4] = replace$default8;
                            Intrinsics.checkNotNullExpressionValue(replace$default8, "textValues[i]");
                            replace$default9 = kotlin.text.m.replace$default(replace$default8, "{strlen=" + str + "}", "{strlen=" + str2 + "}", false, 4, (Object) null);
                            possibleMagicText[i4] = replace$default9;
                            Intrinsics.checkNotNullExpressionValue(replace$default9, "textValues[i]");
                            replace$default10 = kotlin.text.m.replace$default(replace$default9, "[strlen=" + str + "]", "[strlen=" + str2 + "]", false, 4, (Object) null);
                            possibleMagicText[i4] = replace$default10;
                            Intrinsics.checkNotNullExpressionValue(replace$default10, "textValues[i]");
                            replace$default11 = kotlin.text.m.replace$default(replace$default10, "{strlen=" + str + "[", "{strlen=" + str2 + "[", false, 4, (Object) null);
                            possibleMagicText[i4] = replace$default11;
                            Intrinsics.checkNotNullExpressionValue(replace$default11, "textValues[i]");
                            replace$default12 = kotlin.text.m.replace$default(replace$default11, "[strlen=" + str + "[", "[strlen=" + str2 + "[", false, 4, (Object) null);
                            possibleMagicText[i4] = replace$default12;
                            Intrinsics.checkNotNullExpressionValue(replace$default12, "textValues[i]");
                            replace$default13 = kotlin.text.m.replace$default(replace$default12, "{strval=" + str + "}", "{strval=" + str2 + "}", false, 4, (Object) null);
                            possibleMagicText[i4] = replace$default13;
                            Intrinsics.checkNotNullExpressionValue(replace$default13, "textValues[i]");
                            replace$default14 = kotlin.text.m.replace$default(replace$default13, "[strval=" + str + "]", "[strval=" + str2 + "]", false, 4, (Object) null);
                            possibleMagicText[i4] = replace$default14;
                            Intrinsics.checkNotNullExpressionValue(replace$default14, "textValues[i]");
                            replace$default15 = kotlin.text.m.replace$default(replace$default14, "{strval=" + str + "[", "{strval=" + str2 + "[", false, 4, (Object) null);
                            possibleMagicText[i4] = replace$default15;
                            Intrinsics.checkNotNullExpressionValue(replace$default15, "textValues[i]");
                            replace$default16 = kotlin.text.m.replace$default(replace$default15, "[strval=" + str + "[", "[strval=" + str2 + "[", false, 4, (Object) null);
                            possibleMagicText[i4] = replace$default16;
                        }
                    }
                }
                i4++;
                z3 = false;
            }
            supportsMagicText.setPossibleMagicText(possibleMagicText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(TextView textView, String str, String str2) {
        SpannableStringBuilder append = new SpannableStringBuilder().append((CharSequence) String.valueOf(str));
        Intrinsics.checkNotNullExpressionValue(append, "SpannableStringBuilder()…      .append(\"$varName\")");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.3f);
        int length = append.length();
        append.append((CharSequence) MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        append.setSpan(relativeSizeSpan, length, append.length(), 17);
        int color = ContextCompat.getColor(textView.getContext(), R.color.manual_dictionary_formatting_param);
        int color2 = ContextCompat.getColor(textView.getContext(), R.color.manual_dictionary_formatting_bad);
        int length2 = str2.length();
        int i4 = 0;
        for (int i5 = 0; i5 < length2; i5++) {
            char charAt = str2.charAt(i5);
            if (charAt == '[') {
                i4++;
                if (i4 == 1) {
                    RelativeSizeSpan relativeSizeSpan2 = new RelativeSizeSpan(1.2f);
                    int length3 = append.length();
                    append.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
                    append.setSpan(relativeSizeSpan2, length3, append.length(), 17);
                } else if (i4 >= 2) {
                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
                    int length4 = append.length();
                    append.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
                    append.setSpan(foregroundColorSpan, length4, append.length(), 17);
                } else {
                    ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(color2);
                    int length5 = append.length();
                    append.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
                    append.setSpan(foregroundColorSpan2, length5, append.length(), 17);
                }
            } else if (charAt == ']') {
                i4--;
                if (i4 == 0) {
                    RelativeSizeSpan relativeSizeSpan3 = new RelativeSizeSpan(1.2f);
                    int length6 = append.length();
                    append.append((CharSequence) "]");
                    append.setSpan(relativeSizeSpan3, length6, append.length(), 17);
                    RelativeSizeSpan relativeSizeSpan4 = new RelativeSizeSpan(0.3f);
                    int length7 = append.length();
                    append.append((CharSequence) MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    append.setSpan(relativeSizeSpan4, length7, append.length(), 17);
                } else if (i4 >= 1) {
                    ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(color);
                    int length8 = append.length();
                    append.append(']');
                    append.setSpan(foregroundColorSpan3, length8, append.length(), 17);
                } else {
                    ForegroundColorSpan foregroundColorSpan4 = new ForegroundColorSpan(color2);
                    int length9 = append.length();
                    append.append(']');
                    append.setSpan(foregroundColorSpan4, length9, append.length(), 17);
                }
            } else if (i4 >= 1) {
                ForegroundColorSpan foregroundColorSpan5 = new ForegroundColorSpan(color);
                int length10 = append.length();
                append.append(charAt);
                append.setSpan(foregroundColorSpan5, length10, append.length(), 17);
            } else {
                ForegroundColorSpan foregroundColorSpan6 = new ForegroundColorSpan(color2);
                int length11 = append.length();
                append.append(charAt);
                append.setSpan(foregroundColorSpan6, length11, append.length(), 17);
            }
        }
        textView.setText(append);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(EditText keyName, MagicText.MagicTextPair magicTextPair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost;
        int coerceAtLeast3;
        Intrinsics.checkNotNullParameter(keyName, "$keyName");
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(keyName.getSelectionStart(), 0);
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(keyName.getSelectionEnd(), 0);
        Editable text = keyName.getText();
        if (text != null) {
            coerceAtMost = kotlin.ranges.h.coerceAtMost(coerceAtLeast, coerceAtLeast2);
            coerceAtLeast3 = kotlin.ranges.h.coerceAtLeast(coerceAtLeast, coerceAtLeast2);
            String str = magicTextPair.magicText;
            text.replace(coerceAtMost, coerceAtLeast3, str, 0, str.length());
        }
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<String> applyMagicTextToDictionaryKeys(@NotNull Context context, @NotNull List<String> dictionaryKeys, @Nullable TriggerContextInfo triggerContextInfo, @Nullable Macro macro) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dictionaryKeys, "dictionaryKeys");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : dictionaryKeys) {
            arrayList.add(MagicText.replaceMagicText(context, str, triggerContextInfo, macro));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(DialogInterface dialog, int i4) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [kotlin.coroutines.Continuation, java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r13v5 */
    private final void c0(Activity activity, MacroDroidVariable macroDroidVariable, Macro macro, int i4, int i5, DictionaryEventListener dictionaryEventListener) {
        int i6;
        Object obj;
        Button button;
        int i7;
        ?? r13;
        boolean z3;
        boolean z4;
        int i8;
        int i9;
        AppCompatDialog appCompatDialog = new AppCompatDialog(activity, i4);
        appCompatDialog.setContentView(R.layout.local_variable_edit_dialog);
        appCompatDialog.setTitle(macroDroidVariable.getName());
        DialogExtensionsKt.setWidthToParent(appCompatDialog, 0);
        final Button button2 = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        EditText editText = (EditText) appCompatDialog.findViewById(R.id.enter_variable_dialog_value);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.variable_name);
        View findViewById = appCompatDialog.findViewById(R.id.booleanValueContainer);
        View findViewById2 = appCompatDialog.findViewById(R.id.textValueContainer);
        RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.trueRadio);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.falseRadio);
        ImageView imageView = (ImageView) appCompatDialog.findViewById(R.id.clearButton);
        ImageView imageView2 = (ImageView) appCompatDialog.findViewById(R.id.deleteButton);
        int i10 = 8;
        if (findViewById != null) {
            if (macroDroidVariable.isBoolean()) {
                i9 = 0;
            } else {
                i9 = 8;
            }
            findViewById.setVisibility(i9);
        }
        if (findViewById2 != null) {
            if (!macroDroidVariable.isBoolean()) {
                i8 = 0;
            } else {
                i8 = 8;
            }
            findViewById2.setVisibility(i8);
        }
        if (editText2 != null) {
            editText2.setText(macroDroidVariable.getName());
        }
        if (imageView != null) {
            if (macroDroidVariable.isString()) {
                i10 = 0;
            }
            imageView.setVisibility(i10);
        }
        if (macroDroidVariable.isBoolean()) {
            if (radioButton != null) {
                radioButton.setChecked(macroDroidVariable.getBooleanValue());
            }
            if (radioButton2 != null) {
                radioButton2.setChecked(!macroDroidVariable.getBooleanValue());
            }
        } else {
            if (editText != null) {
                editText.setText(macroDroidVariable.toStringNoMagicText());
            }
            if (editText != null) {
                int type = macroDroidVariable.getType();
                if (type != 1) {
                    if (type != 3) {
                        i6 = 655361;
                    } else {
                        i6 = MtpConstants.FORMAT_SCRIPT;
                    }
                } else {
                    i6 = InputDeviceCompat.SOURCE_TOUCHSCREEN;
                }
                editText.setInputType(i6);
            }
        }
        if (imageView != null) {
            ViewExtensionsKt.onClick$default(imageView, null, new y(editText, null), 1, null);
        }
        if (imageView2 != null) {
            button = button3;
            i7 = 1;
            obj = null;
            ViewExtensionsKt.onClick$default(imageView2, null, new z(activity, macroDroidVariable, macro, i5, appCompatDialog, dictionaryEventListener, null), 1, null);
        } else {
            obj = null;
            button = button3;
            i7 = 1;
        }
        if (editText2 != null) {
            editText2.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.variables.VariableHelper$showLocalVarsDialogStandard$3
                @Override // android.text.TextWatcher
                public void afterTextChanged(@NotNull Editable s3) {
                    boolean z5;
                    Intrinsics.checkNotNullParameter(s3, "s");
                    Button button4 = button2;
                    if (button4 != null) {
                        Editable text = editText2.getText();
                        Intrinsics.checkNotNullExpressionValue(text, "nameEditText.text");
                        if (text.length() > 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        button4.setEnabled(z5);
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(@NotNull CharSequence s3, int i11, int i12, int i13) {
                    Intrinsics.checkNotNullParameter(s3, "s");
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(@NotNull CharSequence s3, int i11, int i12, int i13) {
                    Intrinsics.checkNotNullParameter(s3, "s");
                }
            });
        }
        if (button2 != null) {
            if (macroDroidVariable.getType() != 2) {
                if (String.valueOf(editText).length() > 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!z4) {
                    z3 = false;
                    button2.setEnabled(z3);
                }
            }
            z3 = true;
            button2.setEnabled(z3);
        }
        if (editText != null) {
            ViewExtensionsKt.setCursorAtEnd(editText);
        }
        if (editText != null) {
            ViewExtensionsKt.afterTextChanged(editText, new a0(button2, macroDroidVariable, editText));
        }
        if (button2 != null) {
            ?? r132 = obj;
            ViewExtensionsKt.onClick$default(button2, r132, new b0(editText2, macroDroidVariable, macro, activity, radioButton, editText, dictionaryEventListener, appCompatDialog, null), i7, r132);
            r13 = r132;
        } else {
            r13 = obj;
        }
        if (button != null) {
            ViewExtensionsKt.onClick$default(button, r13, new c0(appCompatDialog, r13), i7, r13);
        }
        appCompatDialog.show();
        Window window = appCompatDialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(5);
        }
    }

    @JvmStatic
    public static final void configureArrayVarSpinner(@NotNull Activity activity, int i4, @NotNull SelectableItem selectableItem, @NotNull Spinner spinner, @Nullable Macro macro, @NotNull List<String> customItems, @Nullable String str, @NotNull VariableSelectedListener variableSelectedListener) {
        List plus;
        List distinct;
        boolean z3;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(selectableItem, "selectableItem");
        Intrinsics.checkNotNullParameter(spinner, "spinner");
        Intrinsics.checkNotNullParameter(customItems, "customItems");
        Intrinsics.checkNotNullParameter(variableSelectedListener, "variableSelectedListener");
        a aVar = a.f16217d;
        ArrayList<MacroDroidVariable> allDictionaryAndArrayVariables = selectableItem.getAllDictionaryAndArrayVariables();
        Intrinsics.checkNotNullExpressionValue(allDictionaryAndArrayVariables, "selectableItem.allDictionaryAndArrayVariables");
        ArrayList arrayList = new ArrayList();
        for (Object obj : allDictionaryAndArrayVariables) {
            MacroDroidVariable macroDroidVariable = (MacroDroidVariable) obj;
            if (!macroDroidVariable.isArray() && !macroDroidVariable.getHasArrayChildren()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                arrayList.add(obj);
            }
        }
        ArrayList<MacroDroidVariable> allDictionaryAndArrayVariables2 = selectableItem.getAllDictionaryAndArrayVariables();
        Intrinsics.checkNotNullExpressionValue(allDictionaryAndArrayVariables2, "selectableItem.allDictionaryAndArrayVariables");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : allDictionaryAndArrayVariables2) {
            if (((MacroDroidVariable) obj2).getHasArrayChildren()) {
                arrayList2.add(obj2);
            }
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
        distinct = CollectionsKt___CollectionsKt.distinct(plus);
        y(activity, i4, spinner, macro, true, customItems, distinct, str, "", ShowThisDictionaryOption.SHOW_ARRAYS_ONLY, selectableItem, null, aVar, variableSelectedListener);
    }

    @JvmStatic
    public static final void configureBooleanVarSpinner(@NotNull Activity activity, int i4, @NotNull SelectableItem selectableItem, @NotNull Spinner spinner, @Nullable Macro macro, boolean z3, @NotNull List<String> customItems, @Nullable String str, @NotNull String labelSuffix, boolean z4, @NotNull VariableSelectedListener variableSelectedListener) {
        List plus;
        boolean z5;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(selectableItem, "selectableItem");
        Intrinsics.checkNotNullParameter(spinner, "spinner");
        Intrinsics.checkNotNullParameter(customItems, "customItems");
        Intrinsics.checkNotNullParameter(labelSuffix, "labelSuffix");
        Intrinsics.checkNotNullParameter(variableSelectedListener, "variableSelectedListener");
        b bVar = b.f16218d;
        ArrayList<MacroDroidVariable> allBoolVars = selectableItem.getAllBooleanVariables();
        ArrayList<MacroDroidVariable> allDictionaryAndArrayVariables = selectableItem.getAllDictionaryAndArrayVariables();
        Intrinsics.checkNotNullExpressionValue(allDictionaryAndArrayVariables, "selectableItem.allDictionaryAndArrayVariables");
        ArrayList arrayList = new ArrayList();
        for (Object obj : allDictionaryAndArrayVariables) {
            MacroDroidVariable macroDroidVariable = (MacroDroidVariable) obj;
            if (!z4 && !macroDroidVariable.getHasBooleanChildren()) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z5) {
                arrayList.add(obj);
            }
        }
        Intrinsics.checkNotNullExpressionValue(allBoolVars, "allBoolVars");
        plus = CollectionsKt___CollectionsKt.plus((Collection) allBoolVars, (Iterable) arrayList);
        y(activity, i4, spinner, macro, z3, customItems, plus, str, labelSuffix, ShowThisDictionaryOption.DONT_SHOW, selectableItem, null, bVar, variableSelectedListener);
    }

    public static /* synthetic */ void configureBooleanVarSpinner$default(Activity activity, int i4, SelectableItem selectableItem, Spinner spinner, Macro macro, boolean z3, List list, String str, String str2, boolean z4, VariableSelectedListener variableSelectedListener, int i5, Object obj) {
        String str3;
        if ((i5 & 256) != 0) {
            str3 = "";
        } else {
            str3 = str2;
        }
        configureBooleanVarSpinner(activity, i4, selectableItem, spinner, macro, z3, list, str, str3, z4, variableSelectedListener);
    }

    @JvmStatic
    public static final void configureDictionaryAndArrayVarSpinner(@NotNull Activity activity, int i4, @NotNull SelectableItem selectableItem, @NotNull Spinner spinner, @Nullable Macro macro, @NotNull List<String> customItems, @Nullable String str, boolean z3, @NotNull VariableSelectedListener variableSelectedListener) {
        List plus;
        List distinct;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(selectableItem, "selectableItem");
        Intrinsics.checkNotNullParameter(spinner, "spinner");
        Intrinsics.checkNotNullParameter(customItems, "customItems");
        Intrinsics.checkNotNullParameter(variableSelectedListener, "variableSelectedListener");
        c cVar = c.f16219d;
        ArrayList<MacroDroidVariable> dictionaryVars = selectableItem.getAllDictionaryAndArrayVariables();
        ArrayList<MacroDroidVariable> allDictionaryAndArrayVariables = selectableItem.getAllDictionaryAndArrayVariables();
        Intrinsics.checkNotNullExpressionValue(allDictionaryAndArrayVariables, "selectableItem.allDictionaryAndArrayVariables");
        ArrayList arrayList = new ArrayList();
        for (Object obj : allDictionaryAndArrayVariables) {
            if (((MacroDroidVariable) obj).getHasDictionaryChildren()) {
                arrayList.add(obj);
            }
        }
        Intrinsics.checkNotNullExpressionValue(dictionaryVars, "dictionaryVars");
        plus = CollectionsKt___CollectionsKt.plus((Collection) dictionaryVars, (Iterable) arrayList);
        distinct = CollectionsKt___CollectionsKt.distinct(plus);
        y(activity, i4, spinner, macro, z3, customItems, distinct, str, "", ShowThisDictionaryOption.SHOW_DICTIONARIES_AND_ARRAYS, selectableItem, null, cVar, variableSelectedListener);
    }

    @JvmStatic
    public static final void configureDictionaryVarSpinner(@NotNull Activity activity, int i4, @NotNull SelectableItem selectableItem, @NotNull Spinner spinner, @Nullable Macro macro, @NotNull List<String> customItems, @Nullable String str, @NotNull VariableSelectedListener variableSelectedListener) {
        List plus;
        List distinct;
        boolean z3;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(selectableItem, "selectableItem");
        Intrinsics.checkNotNullParameter(spinner, "spinner");
        Intrinsics.checkNotNullParameter(customItems, "customItems");
        Intrinsics.checkNotNullParameter(variableSelectedListener, "variableSelectedListener");
        d dVar = d.f16241d;
        ArrayList<MacroDroidVariable> allDictionaryAndArrayVariables = selectableItem.getAllDictionaryAndArrayVariables();
        Intrinsics.checkNotNullExpressionValue(allDictionaryAndArrayVariables, "selectableItem.allDictionaryAndArrayVariables");
        ArrayList arrayList = new ArrayList();
        for (Object obj : allDictionaryAndArrayVariables) {
            MacroDroidVariable macroDroidVariable = (MacroDroidVariable) obj;
            if (macroDroidVariable.isArray() && !macroDroidVariable.getHasDictionaryChildren()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                arrayList.add(obj);
            }
        }
        ArrayList<MacroDroidVariable> allDictionaryAndArrayVariables2 = selectableItem.getAllDictionaryAndArrayVariables();
        Intrinsics.checkNotNullExpressionValue(allDictionaryAndArrayVariables2, "selectableItem.allDictionaryAndArrayVariables");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : allDictionaryAndArrayVariables2) {
            if (((MacroDroidVariable) obj2).getHasDictionaryChildren()) {
                arrayList2.add(obj2);
            }
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
        distinct = CollectionsKt___CollectionsKt.distinct(plus);
        y(activity, i4, spinner, macro, true, customItems, distinct, str, "", ShowThisDictionaryOption.SHOW_DICTIONARIES_ONLY, selectableItem, null, dVar, variableSelectedListener);
    }

    @JvmStatic
    public static final void configureNumberVarSpinner(@NotNull Activity activity, int i4, @NotNull SelectableItem selectableItem, @NotNull Spinner spinner, @Nullable Macro macro, @NotNull List<String> customItems, @Nullable String str, @NotNull String labelSuffix, boolean z3, @NotNull VariableSelectedListener variableSelectedListener) {
        List plus;
        List plus2;
        boolean z4;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(selectableItem, "selectableItem");
        Intrinsics.checkNotNullParameter(spinner, "spinner");
        Intrinsics.checkNotNullParameter(customItems, "customItems");
        Intrinsics.checkNotNullParameter(labelSuffix, "labelSuffix");
        Intrinsics.checkNotNullParameter(variableSelectedListener, "variableSelectedListener");
        e eVar = e.f16249d;
        ArrayList<MacroDroidVariable> allIntVars = selectableItem.getAllIntegerVariables();
        ArrayList<MacroDroidVariable> allDecimalVars = selectableItem.getAllDecimalVariables();
        ArrayList<MacroDroidVariable> allDictionaryAndArrayVariables = selectableItem.getAllDictionaryAndArrayVariables();
        Intrinsics.checkNotNullExpressionValue(allDictionaryAndArrayVariables, "selectableItem.allDictionaryAndArrayVariables");
        ArrayList arrayList = new ArrayList();
        for (Object obj : allDictionaryAndArrayVariables) {
            MacroDroidVariable macroDroidVariable = (MacroDroidVariable) obj;
            if (!z3 && !macroDroidVariable.getHasNumericalChildren()) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                arrayList.add(obj);
            }
        }
        Intrinsics.checkNotNullExpressionValue(allIntVars, "allIntVars");
        Intrinsics.checkNotNullExpressionValue(allDecimalVars, "allDecimalVars");
        plus = CollectionsKt___CollectionsKt.plus((Collection) allIntVars, (Iterable) allDecimalVars);
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) arrayList);
        y(activity, i4, spinner, macro, true, customItems, plus2, str, labelSuffix, ShowThisDictionaryOption.DONT_SHOW, selectableItem, null, eVar, variableSelectedListener);
    }

    public static /* synthetic */ void configureNumberVarSpinner$default(Activity activity, int i4, SelectableItem selectableItem, Spinner spinner, Macro macro, List list, String str, String str2, boolean z3, VariableSelectedListener variableSelectedListener, int i5, Object obj) {
        String str3;
        if ((i5 & 128) != 0) {
            str3 = "";
        } else {
            str3 = str2;
        }
        configureNumberVarSpinner(activity, i4, selectableItem, spinner, macro, list, str, str3, z3, variableSelectedListener);
    }

    @JvmStatic
    public static final void configureStringVarSpinner(@NotNull Activity activity, int i4, @NotNull SelectableItem selectableItem, @NotNull Spinner spinner, @Nullable Macro macro, @NotNull List<String> customItems, @Nullable String str, boolean z3, @Nullable Integer num, @NotNull VariableSelectedListener variableSelectedListener) {
        List plus;
        boolean z4;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(selectableItem, "selectableItem");
        Intrinsics.checkNotNullParameter(spinner, "spinner");
        Intrinsics.checkNotNullParameter(customItems, "customItems");
        Intrinsics.checkNotNullParameter(variableSelectedListener, "variableSelectedListener");
        f fVar = f.f16250d;
        ArrayList<MacroDroidVariable> stringVars = selectableItem.getAllStringVariables();
        ArrayList<MacroDroidVariable> allDictionaryAndArrayVariables = selectableItem.getAllDictionaryAndArrayVariables();
        Intrinsics.checkNotNullExpressionValue(allDictionaryAndArrayVariables, "selectableItem.allDictionaryAndArrayVariables");
        ArrayList arrayList = new ArrayList();
        for (Object obj : allDictionaryAndArrayVariables) {
            MacroDroidVariable macroDroidVariable = (MacroDroidVariable) obj;
            if (!z3 && !macroDroidVariable.getHasStringChildren()) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                arrayList.add(obj);
            }
        }
        Intrinsics.checkNotNullExpressionValue(stringVars, "stringVars");
        plus = CollectionsKt___CollectionsKt.plus((Collection) stringVars, (Iterable) arrayList);
        y(activity, i4, spinner, macro, true, customItems, plus, str, "", ShowThisDictionaryOption.DONT_SHOW, selectableItem, num, fVar, variableSelectedListener);
    }

    public static /* synthetic */ void configureStringVarSpinner$default(Activity activity, int i4, SelectableItem selectableItem, Spinner spinner, Macro macro, List list, String str, boolean z3, Integer num, VariableSelectedListener variableSelectedListener, int i5, Object obj) {
        Integer num2;
        if ((i5 & 256) != 0) {
            num2 = null;
        } else {
            num2 = num;
        }
        configureStringVarSpinner(activity, i4, selectableItem, spinner, macro, list, str, z3, num2, variableSelectedListener);
    }

    @JvmStatic
    public static final void configureVarSpinnerOfType(int i4, @NotNull Activity activity, int i5, @NotNull SelectableItem selectableItem, @NotNull Spinner spinner, @Nullable Macro macro, @NotNull List<String> customItems, @Nullable String str, @NotNull String labelSuffix, @NotNull VariableSelectedListener variableSelectedListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(selectableItem, "selectableItem");
        Intrinsics.checkNotNullParameter(spinner, "spinner");
        Intrinsics.checkNotNullParameter(customItems, "customItems");
        Intrinsics.checkNotNullParameter(labelSuffix, "labelSuffix");
        Intrinsics.checkNotNullParameter(variableSelectedListener, "variableSelectedListener");
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 == 5) {
                                configureArrayVarSpinner(activity, i5, selectableItem, spinner, macro, customItems, str, variableSelectedListener);
                                return;
                            }
                            return;
                        }
                        configureDictionaryVarSpinner(activity, i5, selectableItem, spinner, macro, customItems, str, variableSelectedListener);
                        return;
                    }
                } else {
                    configureStringVarSpinner(activity, i5, selectableItem, spinner, macro, customItems, str, false, null, variableSelectedListener);
                    return;
                }
            }
            configureNumberVarSpinner(activity, i5, selectableItem, spinner, macro, customItems, str, labelSuffix, false, variableSelectedListener);
            return;
        }
        configureBooleanVarSpinner(activity, i5, selectableItem, spinner, macro, true, customItems, str, labelSuffix, false, variableSelectedListener);
    }

    public static /* synthetic */ void configureVarSpinnerOfType$default(int i4, Activity activity, int i5, SelectableItem selectableItem, Spinner spinner, Macro macro, List list, String str, String str2, VariableSelectedListener variableSelectedListener, int i6, Object obj) {
        String str3;
        if ((i6 & 256) != 0) {
            str3 = "";
        } else {
            str3 = str2;
        }
        configureVarSpinnerOfType(i4, activity, i5, selectableItem, spinner, macro, list, str, str3, variableSelectedListener);
    }

    @JvmStatic
    public static final void copyDictionary(@NotNull VariableValue.Dictionary dicToUpdate, @NotNull VariableValue.Dictionary dicToCopy) {
        Intrinsics.checkNotNullParameter(dicToUpdate, "dicToUpdate");
        Intrinsics.checkNotNullParameter(dicToCopy, "dicToCopy");
        dicToUpdate.getEntries().clear();
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        obtain.writeParcelable(dicToCopy, 0);
        obtain.setDataPosition(0);
        Parcelable readParcelable = obtain.readParcelable(VariableValue.Dictionary.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable);
        obtain.recycle();
        dicToUpdate.getEntries().addAll(((VariableValue.Dictionary) readParcelable).getEntries());
    }

    @JvmStatic
    public static final void createNewKey(@NotNull final Activity activity, int i4, @NotNull final VariableValue.Dictionary dictionary, @Nullable final Macro macro, @NotNull final Function1<? super String, Unit> keyChosen) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(dictionary, "dictionary");
        Intrinsics.checkNotNullParameter(keyChosen, "keyChosen");
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, i4);
        appCompatDialog.setContentView(R.layout.variable_new_key_dialog);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        Window window2 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        View findViewById = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById);
        final Button button = (Button) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById2);
        Button button2 = (Button) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.keyName);
        Intrinsics.checkNotNull(findViewById3);
        final EditText editText = (EditText) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.magicTextButton);
        Intrinsics.checkNotNull(findViewById4);
        Button button3 = (Button) findViewById4;
        if (dictionary.isArray()) {
            appCompatDialog.setTitle(R.string.variable_dictionary_add_array_index);
            editText.setHint(R.string.variable_array_index);
            editText.setInputType(2);
        } else {
            appCompatDialog.setTitle(R.string.variable_dictionary_add_key);
            editText.setHint(R.string.variable_dictionary_key);
            editText.setInputType(655361);
        }
        ViewExtensionsKt.onClick$default(button3, null, new g(dictionary, activity, macro, new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.variables.q
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                VariableHelper.C(editText, magicTextPair);
            }
        }, i4, null), 1, null);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.variables.VariableHelper$createNewKey$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable s3) {
                Intrinsics.checkNotNullParameter(s3, "s");
                boolean z3 = true;
                if (VariableValue.Dictionary.this.isArray()) {
                    try {
                        ExpressionUtils.calculateExpression(activity, macro, s3.toString(), null);
                        button.setEnabled(true);
                        return;
                    } catch (IllegalArgumentException unused) {
                        button.setEnabled(false);
                        return;
                    } catch (IndexOutOfBoundsException unused2) {
                        button.setEnabled(false);
                        return;
                    }
                }
                Button button4 = button;
                Editable text = editText.getText();
                Intrinsics.checkNotNullExpressionValue(text, "keyName.text");
                if (text.length() <= 0) {
                    z3 = false;
                }
                button4.setEnabled(z3);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@NotNull CharSequence s3, int i5, int i6, int i7) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence s3, int i5, int i6, int i7) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VariableHelper.D(Function1.this, editText, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VariableHelper.E(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, android.view.View, java.lang.Object] */
    @JvmStatic
    public static final void createNewVariable(@NotNull final Activity activity, final boolean z3, final boolean z4, int i4, final boolean z5, final boolean z6, int i5, @NotNull String secondaryColorAsString, boolean z7, @Nullable final Macro macro, @Nullable final Integer num, @NotNull final NewVariableCreationListener newVariableCreationListener) {
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(secondaryColorAsString, "secondaryColorAsString");
        Intrinsics.checkNotNullParameter(newVariableCreationListener, "newVariableCreationListener");
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, i4);
        appCompatDialog.setContentView(R.layout.variable_new_variable_dialog);
        appCompatDialog.setTitle(R.string.create_new_variable);
        View findViewById = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById);
        final Button button = (Button) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById2);
        Button button2 = (Button) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.type_container);
        Intrinsics.checkNotNull(findViewById3);
        ViewGroup viewGroup = (ViewGroup) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.variable_new_variable_dialog_name);
        Intrinsics.checkNotNull(findViewById4);
        final EditText editText = (EditText) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.variable_new_variable_type_spinner);
        Intrinsics.checkNotNull(findViewById5);
        final Spinner spinner = (Spinner) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.local_global_layout);
        Intrinsics.checkNotNull(findViewById6);
        ViewGroup viewGroup2 = (ViewGroup) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.radio_button_local);
        Intrinsics.checkNotNull(findViewById7);
        final RadioButton radioButton = (RadioButton) findViewById7;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? findViewById8 = appCompatDialog.findViewById(R.id.create_now_check_box);
        Intrinsics.checkNotNull(findViewById8);
        objectRef.element = findViewById8;
        View findViewById9 = appCompatDialog.findViewById(R.id.create_var_magic_text);
        Intrinsics.checkNotNull(findViewById9);
        Button button3 = (Button) findViewById9;
        View view = (View) objectRef.element;
        if (z5) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        view.setVisibility(i6);
        if (z6) {
            i7 = 0;
        } else {
            i7 = 8;
        }
        viewGroup2.setVisibility(i7);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.variables.VariableHelper$createNewVariable$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable s3) {
                boolean z8;
                Intrinsics.checkNotNullParameter(s3, "s");
                Button button4 = button;
                Editable text = editText.getText();
                Intrinsics.checkNotNullExpressionValue(text, "variableName.text");
                if (text.length() > 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                button4.setEnabled(z8);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@NotNull CharSequence s3, int i8, int i9, int i10) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence s3, int i8, int i9, int i10) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }
        });
        if (z7) {
            button3.setVisibility(0);
            final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.variables.x
                @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
                public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                    VariableHelper.F(editText, magicTextPair);
                }
            };
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    VariableHelper.G(activity, magicTextListener, macro, view2);
                }
            });
        }
        spinner.setAdapter((SpinnerAdapter) getVariableTypeAdapter$default(activity, true, !z3, secondaryColorAsString, i5, false, 32, null));
        if (num != null) {
            viewGroup.setVisibility(8);
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VariableHelper.H(editText, newVariableCreationListener, activity, num, spinner, z3, z6, radioButton, z4, appCompatDialog, objectRef, z5, view2);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VariableHelper.I(AppCompatDialog.this, view2);
            }
        });
        button.setEnabled(false);
        DialogExtensionsKt.setWidthToParent(appCompatDialog, activity.getResources().getDimensionPixelOffset(R.dimen.margin_large));
        appCompatDialog.show();
        Window window = appCompatDialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Ref.IntRef selectedIndex, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(selectedIndex, "$selectedIndex");
        selectedIndex.element = i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0117, code lost:
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r36, "", null, null, 0, null, com.arlosoft.macrodroid.variables.VariableHelper.i.f16251d, 30, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0134, code lost:
        r3 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r37, "", null, null, 0, null, com.arlosoft.macrodroid.variables.VariableHelper.j.f16252d, 30, null);
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void defineKeysManually(@org.jetbrains.annotations.NotNull final android.app.Activity r31, int r32, @org.jetbrains.annotations.NotNull final com.arlosoft.macrodroid.common.MacroDroidVariable r33, @org.jetbrains.annotations.NotNull final com.arlosoft.macrodroid.variables.VariableValue.Dictionary r34, @org.jetbrains.annotations.Nullable final com.arlosoft.macrodroid.macro.Macro r35, @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> r36, @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> r37, boolean r38, @org.jetbrains.annotations.Nullable com.arlosoft.macrodroid.common.SelectableItem r39, boolean r40, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function1<? super com.arlosoft.macrodroid.variables.VariableHelper.ManualKeyData, kotlin.Unit> r41) {
        /*
            Method dump skipped, instructions count: 555
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.variables.VariableHelper.defineKeysManually(android.app.Activity, int, com.arlosoft.macrodroid.common.MacroDroidVariable, com.arlosoft.macrodroid.variables.VariableValue$Dictionary, com.arlosoft.macrodroid.macro.Macro, java.util.List, java.util.List, boolean, com.arlosoft.macrodroid.common.SelectableItem, boolean, kotlin.jvm.functions.Function1):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(String[] keys, Ref.IntRef selectedIndex, Activity activity, KeyDialogOptionChosenCallback optionChosenCallback, ManualKeyOption manualKeyOption, VariableValue.Dictionary dictionary, DialogInterface dialog, int i4) {
        boolean areEqual;
        Intrinsics.checkNotNullParameter(keys, "$keys");
        Intrinsics.checkNotNullParameter(selectedIndex, "$selectedIndex");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(optionChosenCallback, "$optionChosenCallback");
        Intrinsics.checkNotNullParameter(manualKeyOption, "$manualKeyOption");
        Intrinsics.checkNotNullParameter(dictionary, "$dictionary");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        String str = keys[selectedIndex.element];
        boolean z3 = true;
        if (Intrinsics.areEqual(str, activity.getString(R.string.variable_copy_other_array))) {
            areEqual = true;
        } else {
            areEqual = Intrinsics.areEqual(str, activity.getString(R.string.variable_copy_other_dictionary));
        }
        if (areEqual) {
            optionChosenCallback.copyAllChosen();
        } else {
            if (!Intrinsics.areEqual(str, activity.getString(R.string.variable_dictionary_add_array_index))) {
                z3 = Intrinsics.areEqual(str, activity.getString(R.string.variable_dictionary_add_key));
            }
            if (z3) {
                optionChosenCallback.addKeyChosen();
            } else if (Intrinsics.areEqual(str, activity.getString(R.string.variable_dictionary_array_define_indexes_or_keys_manually))) {
                optionChosenCallback.manualKeyEntryChosen(manualKeyOption.getExistingKeys());
            } else if (Intrinsics.areEqual(str, activity.getString(R.string.variable_this_array))) {
                optionChosenCallback.thisDictionaryChosen();
            } else if (Intrinsics.areEqual(str, activity.getString(R.string.variable_this_dictionary))) {
                optionChosenCallback.thisDictionaryChosen();
            } else {
                VariableValue.DictionaryEntry entry = dictionary.getEntry(keys[selectedIndex.element]);
                Intrinsics.checkNotNull(entry);
                optionChosenCallback.keyChosen(entry);
            }
        }
        dialog.dismiss();
    }

    private final void f0(SelectableItem selectableItem, String str, String str2) {
        HasVariableName hasVariableName;
        String variableName;
        MacroDroidVariable variable;
        if ((selectableItem instanceof HasVariable) && (variable = ((HasVariable) selectableItem).getVariable()) != null && Intrinsics.areEqual(variable.getName(), str)) {
            variable.setName(str2);
        }
        if ((selectableItem instanceof HasVariableName) && (variableName = (hasVariableName = (HasVariableName) selectableItem).getVariableName()) != null && Intrinsics.areEqual(variableName, str)) {
            hasVariableName.setVariableName(str2);
        }
        if (selectableItem instanceof HasVariableNames) {
            HasVariableNames hasVariableNames = (HasVariableNames) selectableItem;
            String[] variableNames = hasVariableNames.getVariableNames();
            int length = variableNames.length;
            for (int i4 = 0; i4 < length; i4++) {
                String str3 = variableNames[i4];
                if (str3 != null && Intrinsics.areEqual(str3, str)) {
                    variableNames[i4] = str2;
                }
            }
            hasVariableNames.setVariableNames(variableNames);
        }
        if (selectableItem instanceof HasVariables) {
            for (MacroDroidVariable macroDroidVariable : ((HasVariables) selectableItem).getVariables()) {
                if (macroDroidVariable != null && Intrinsics.areEqual(macroDroidVariable.getName(), str)) {
                    macroDroidVariable.setName(str2);
                }
            }
        }
        if (selectableItem instanceof VariableNameUpdater) {
            ((VariableNameUpdater) selectableItem).updateVariableName(str, str2);
        }
    }

    @JvmStatic
    @NotNull
    public static final List<VariableWithDictionaryKeys> getAllDictionariesAndSubDictionariesWithKeys(@NotNull List<MacroDroidVariable> dictionaryList, boolean z3) {
        List<String> emptyList;
        List emptyList2;
        Intrinsics.checkNotNullParameter(dictionaryList, "dictionaryList");
        ArrayList arrayList = new ArrayList();
        for (MacroDroidVariable macroDroidVariable : dictionaryList) {
            if (macroDroidVariable.isArray() == z3) {
                String name = macroDroidVariable.getName();
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                arrayList.add(new VariableWithDictionaryKeys(name, new DictionaryKeys(emptyList2)));
            }
            VariableHelper variableHelper = INSTANCE;
            VariableValue.Dictionary dictionary = macroDroidVariable.getDictionary();
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            variableHelper.w(macroDroidVariable, dictionary, z3, arrayList, emptyList);
        }
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final String getFormattedDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        return dictionaryKeys == null ? "" : getFormattedDictionaryKeys(dictionaryKeys.getKeys());
    }

    @JvmStatic
    @NotNull
    public static final ArrayAdapter<CharSequence> getVariableTypeAdapter(@NotNull Activity activity, boolean z3, boolean z4, @NotNull String secondaryColorAsString, int i4, boolean z5) {
        List mutableList;
        List listOf;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(secondaryColorAsString, "secondaryColorAsString");
        CharSequence[] textArray = activity.getResources().getTextArray(R.array.variable_type_options);
        Intrinsics.checkNotNullExpressionValue(textArray, "activity.resources.getTe…ay.variable_type_options)");
        mutableList = ArraysKt___ArraysKt.toMutableList(textArray);
        if (z3) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{activity.getString(R.string.variable_type_dictionary), activity.getString(R.string.variable_type_array)});
            if (z4) {
                List list = listOf;
                collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String string = activity.getString(R.string.pro_version_required);
                    arrayList.add(Html.fromHtml(((String) it.next()) + "<br/><font color=" + secondaryColorAsString + "><small>" + string + "</small></font>"));
                }
                mutableList.addAll(arrayList);
            } else {
                mutableList.addAll(listOf);
            }
        }
        if (z5) {
            mutableList.add(0, activity.getString(R.string.variable_type_filter_all_variables));
        }
        return new ArrayAdapter<>(activity, i4, mutableList);
    }

    public static /* synthetic */ ArrayAdapter getVariableTypeAdapter$default(Activity activity, boolean z3, boolean z4, String str, int i4, boolean z5, int i5, Object obj) {
        boolean z6;
        if ((i5 & 32) != 0) {
            z6 = false;
        } else {
            z6 = z5;
        }
        return getVariableTypeAdapter(activity, z3, z4, str, i4, z6);
    }

    @JvmStatic
    @NotNull
    public static final List<String> getVariableTypesList(@NotNull Context context) {
        List list;
        List<String> mutableList;
        List listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        String[] stringArray = context.getResources().getStringArray(R.array.variable_type_options);
        Intrinsics.checkNotNullExpressionValue(stringArray, "context.resources.getStr…ay.variable_type_options)");
        list = ArraysKt___ArraysKt.toList(stringArray);
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) new ArrayList(list));
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{context.getString(R.string.variable_type_dictionary), context.getString(R.string.variable_type_array)});
        mutableList.addAll(listOf);
        return mutableList;
    }

    @JvmStatic
    public static final void promptForNewName(@NotNull final Context context, @Nullable final Macro macro, @NotNull final MacroDroidVariable variable, @Nullable final View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(variable, "variable");
        final AppCompatDialog appCompatDialog = new AppCompatDialog(context, R.style.Theme_App_Dialog_Variables);
        appCompatDialog.setContentView(R.layout.enter_variable_value_dialog);
        appCompatDialog.setTitle(R.string.enter_variable_name);
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.enter_variable_dialog_value);
        Intrinsics.checkNotNull(editText);
        editText.setHint(R.string.enter_variable_name);
        editText.setText(variable.getName());
        editText.setSelection(editText.length());
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.variables.VariableHelper$promptForNewName$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable s3) {
                boolean z3;
                Intrinsics.checkNotNullParameter(s3, "s");
                Button button3 = button;
                Intrinsics.checkNotNull(button3);
                if (editText.getText().length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                button3.setEnabled(z3);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }
        });
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        if (!context.getResources().getBoolean(R.bool.is_tablet)) {
            layoutParams.width = -1;
        }
        Window window2 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        appCompatDialog.show();
        Window window3 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setSoftInputMode(5);
        Intrinsics.checkNotNull(button2);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VariableHelper.R(AppCompatDialog.this, view);
            }
        });
        Intrinsics.checkNotNull(button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VariableHelper.S(editText, variable, appCompatDialog, context, macro, onClickListener, view);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.arlosoft.macrodroid.variables.VariableValue, T] */
    /* JADX WARN: Type inference failed for: r0v47, types: [com.arlosoft.macrodroid.variables.VariableValue, T] */
    @JvmStatic
    public static final void promptForNewValue(@NotNull Context context, @NotNull final MacroDroidVariable variable, @Nullable final DictionaryKeys dictionaryKeys, @Nullable final View.OnClickListener onClickListener, boolean z3, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        VariableValue.DictionaryEntry dictionaryEntryFromKeyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(variable, "variable");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = variable.getVariableValueNoMagicText();
        if (dictionaryKeys != null && (dictionaryEntryFromKeyList = variable.getDictionaryEntryFromKeyList(dictionaryKeys.getKeys())) != null) {
            objectRef.element = dictionaryEntryFromKeyList.getVariable();
        }
        if (((VariableValue) objectRef.element).getVariableType() == 0) {
            INSTANCE.O(context, variable, dictionaryKeys, onClickListener, onDismissListener);
            return;
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(context, R.style.Theme_App_Dialog_Variables);
        appCompatDialog.setContentView(R.layout.enter_variable_value_dialog);
        appCompatDialog.setTitle(variable.getName());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        if (!context.getResources().getBoolean(R.bool.is_tablet)) {
            layoutParams.width = -1;
        }
        Window window2 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.enter_variable_dialog_value);
        int variableType = ((VariableValue) objectRef.element).getVariableType();
        boolean z4 = true;
        if (variableType != 1) {
            if (variableType != 3) {
                Intrinsics.checkNotNull(editText);
                editText.setInputType(655361);
                editText.setText(((VariableValue) objectRef.element).getValueAsText());
            } else {
                Intrinsics.checkNotNull(editText);
                editText.setText(((VariableValue) objectRef.element).getValueAsText());
                editText.setInputType(MtpConstants.FORMAT_SCRIPT);
            }
        } else {
            Intrinsics.checkNotNull(editText);
            editText.setInputType(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            editText.setText(((VariableValue) objectRef.element).getValueAsText());
        }
        Intrinsics.checkNotNull(button);
        if (((VariableValue) objectRef.element).getVariableType() != 2 && editText.toString().length() <= 0) {
            z4 = false;
        }
        button.setEnabled(z4);
        editText.setSelection(editText.getText().length());
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.variables.VariableHelper$promptForNewValue$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable s3) {
                boolean z5;
                Intrinsics.checkNotNullParameter(s3, "s");
                Button button3 = button;
                if (objectRef.element.getVariableType() != 2 && editText.getText().length() <= 0) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                button3.setEnabled(z5);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VariableHelper.T(MacroDroidVariable.this, editText, objectRef, dictionaryKeys, onClickListener, appCompatDialog, view);
            }
        });
        appCompatDialog.setOnDismissListener(onDismissListener);
        Intrinsics.checkNotNull(button2);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VariableHelper.U(AppCompatDialog.this, view);
            }
        });
        if (z3) {
            Window window3 = appCompatDialog.getWindow();
            Intrinsics.checkNotNull(window3);
            window3.setType(OverlayUtils.getOverlayType());
        }
        appCompatDialog.show();
        Window window4 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window4);
        window4.setSoftInputMode(5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x00d4, code lost:
        r1 = kotlin.text.l.toIntOrNull(r1);
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void showAddEntryDialogDictionaryValue(@org.jetbrains.annotations.NotNull android.app.Activity r20, int r21, @org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.common.MacroDroidVariable r22, @org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.variables.VariableValue.Dictionary r23, @org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.macro.Macro r24, @org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.data.IteratorType r25, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.Pair<java.lang.String, java.lang.Integer>, kotlin.Unit> r26) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.variables.VariableHelper.showAddEntryDialogDictionaryValue(android.app.Activity, int, com.arlosoft.macrodroid.common.MacroDroidVariable, com.arlosoft.macrodroid.variables.VariableValue$Dictionary, com.arlosoft.macrodroid.macro.Macro, com.arlosoft.macrodroid.data.IteratorType, kotlin.jvm.functions.Function1):void");
    }

    @JvmStatic
    public static final void showAlreadyExistsDialog(@Nullable Context context, int i4) {
        Intrinsics.checkNotNull(context);
        AlertDialog.Builder builder = new AlertDialog.Builder(context, i4);
        builder.setTitle(R.string.variable_creation_failed);
        builder.setMessage(R.string.variable_already_exists);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.k0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                VariableHelper.b0(dialogInterface, i5);
            }
        });
        builder.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v29, types: [com.arlosoft.macrodroid.variables.DictionaryVariableAdapter, T, androidx.recyclerview.widget.RecyclerView$Adapter] */
    /* JADX WARN: Type inference failed for: r12v1, types: [kotlin.coroutines.Continuation, java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r15v1, types: [android.view.View, androidx.recyclerview.widget.RecyclerView] */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.arlosoft.macrodroid.variables.VariableHelper$showDictionaryEditScreen$interceptDictionaryEventListener$1] */
    @JvmStatic
    public static final void showDictionaryEditScreen(@NotNull final Activity activity, @Nullable final Macro macro, @Nullable MacroDroidVariable macroDroidVariable, @NotNull final String parentName, @NotNull String keyName, @NotNull final VariableValue.Dictionary dictionary, boolean z3, @Nullable VariableValue.Dictionary dictionary2, @NotNull final ArrayList<String> parentKeys, @NotNull final DictionaryEventListener dictionaryEventListener) {
        int i4;
        int i5;
        boolean z4;
        int i6;
        FloatingActionButton floatingActionButton;
        EditText editText;
        ImageButton imageButton;
        ImageButton imageButton2;
        ImageButton imageButton3;
        ImageButton imageButton4;
        int i7;
        Ref.ObjectRef objectRef;
        Object obj;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(keyName, "keyName");
        Intrinsics.checkNotNullParameter(dictionary, "dictionary");
        Intrinsics.checkNotNullParameter(parentKeys, "parentKeys");
        Intrinsics.checkNotNullParameter(dictionaryEventListener, "dictionaryEventListener");
        AppCompatDialog appCompatDialog = new AppCompatDialog(activity, R.style.Theme_App_Dialog_Variables_NoTitle);
        appCompatDialog.setContentView(R.layout.dialog_multi_entry_list);
        View findViewById = appCompatDialog.findViewById(R.id.emptyView);
        Intrinsics.checkNotNull(findViewById);
        final TextView textView = (TextView) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.entriesRecyclerView);
        Intrinsics.checkNotNull(findViewById2);
        final ?? r15 = (RecyclerView) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.addEntryButton);
        Intrinsics.checkNotNull(findViewById3);
        FloatingActionButton floatingActionButton2 = (FloatingActionButton) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.varName);
        Intrinsics.checkNotNull(findViewById4);
        TextView textView2 = (TextView) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.clearButton);
        Intrinsics.checkNotNull(findViewById5);
        ImageButton imageButton5 = (ImageButton) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.deleteButton);
        Intrinsics.checkNotNull(findViewById6);
        ImageButton imageButton6 = (ImageButton) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.backButton);
        Intrinsics.checkNotNull(findViewById7);
        ImageButton imageButton7 = (ImageButton) findViewById7;
        View findViewById8 = appCompatDialog.findViewById(R.id.searchButton);
        Intrinsics.checkNotNull(findViewById8);
        ImageButton imageButton8 = (ImageButton) findViewById8;
        View findViewById9 = appCompatDialog.findViewById(R.id.searchText);
        Intrinsics.checkNotNull(findViewById9);
        EditText editText2 = (EditText) findViewById9;
        View findViewById10 = appCompatDialog.findViewById(R.id.searchContainer);
        Intrinsics.checkNotNull(findViewById10);
        View findViewById11 = appCompatDialog.findViewById(R.id.clearSearchButton);
        Intrinsics.checkNotNull(findViewById11);
        ImageButton imageButton9 = (ImageButton) findViewById11;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = activity.getString(R.string.variable_multi_entry_num_entries);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…_multi_entry_num_entries)");
        String format = String.format(string, Arrays.copyOf(new Object[]{0}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
        textView2.setText(parentName);
        ViewExtensionsKt.onClick$default(imageButton8, null, new n((ViewGroup) findViewById10, null), 1, null);
        if (dictionary.getEntries().isEmpty()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView.setVisibility(i4);
        if (!dictionary.getEntries().isEmpty()) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        r15.setVisibility(i5);
        if (dictionary.getEntries().size() > 5) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        imageButton8.setVisibility(i6);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        if (macroDroidVariable != null) {
            editText = editText2;
            objectRef = objectRef2;
            imageButton = imageButton7;
            imageButton2 = imageButton9;
            imageButton3 = imageButton6;
            i7 = 1;
            imageButton4 = imageButton5;
            floatingActionButton = floatingActionButton2;
            obj = null;
            ViewExtensionsKt.onClick$default(textView2, null, new o(activity, macro, macroDroidVariable, textView2, dictionaryEventListener, null), 1, null);
        } else {
            floatingActionButton = floatingActionButton2;
            editText = editText2;
            imageButton = imageButton7;
            imageButton2 = imageButton9;
            imageButton3 = imageButton6;
            imageButton4 = imageButton5;
            i7 = 1;
            objectRef = objectRef2;
            obj = null;
        }
        final Ref.ObjectRef objectRef3 = objectRef;
        final ?? r8 = new DictionaryEventListener() { // from class: com.arlosoft.macrodroid.variables.VariableHelper$showDictionaryEditScreen$interceptDictionaryEventListener$1
            private final void a() {
                DictionaryVariableAdapter dictionaryVariableAdapter;
                int i8;
                DictionaryVariableAdapter dictionaryVariableAdapter2 = objectRef3.element;
                DictionaryVariableAdapter dictionaryVariableAdapter3 = null;
                if (dictionaryVariableAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    dictionaryVariableAdapter = null;
                } else {
                    dictionaryVariableAdapter = dictionaryVariableAdapter2;
                }
                dictionaryVariableAdapter.updateDictionary(dictionary);
                TextView textView3 = textView;
                int i9 = 0;
                if (dictionary.getEntries().isEmpty()) {
                    i8 = 0;
                } else {
                    i8 = 8;
                }
                textView3.setVisibility(i8);
                RecyclerView recyclerView = r15;
                if (!(!dictionary.getEntries().isEmpty())) {
                    i9 = 8;
                }
                recyclerView.setVisibility(i9);
                DictionaryVariableAdapter dictionaryVariableAdapter4 = objectRef3.element;
                if (dictionaryVariableAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    dictionaryVariableAdapter3 = dictionaryVariableAdapter4;
                }
                dictionaryVariableAdapter3.notifyDataSetChanged();
            }

            @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
            public void dictionaryDeleted() {
                a();
                DictionaryEventListener.this.dictionaryDeleted();
            }

            @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
            public void entriesCleared() {
                a();
                DictionaryEventListener.this.entriesCleared();
            }

            @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
            public void entryRemoved(@NotNull VariableValue.DictionaryEntry removedEntry) {
                Intrinsics.checkNotNullParameter(removedEntry, "removedEntry");
                a();
                DictionaryEventListener.this.entryRemoved(removedEntry);
            }

            @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
            public void entryUpdated(@NotNull VariableValue.DictionaryEntry newEntry, @Nullable VariableValue.DictionaryEntry dictionaryEntry) {
                Intrinsics.checkNotNullParameter(newEntry, "newEntry");
                a();
                DictionaryEventListener.this.entryUpdated(newEntry, dictionaryEntry);
            }

            @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
            public void refreshRequired() {
                a();
                DictionaryEventListener.this.refreshRequired();
            }
        };
        ?? r12 = obj;
        DictionaryVariableAdapter.ElementSelectedListener elementSelectedListener = new DictionaryVariableAdapter.ElementSelectedListener() { // from class: com.arlosoft.macrodroid.variables.VariableHelper$showDictionaryEditScreen$elementSelectedListener$1
            @Override // com.arlosoft.macrodroid.variables.DictionaryVariableAdapter.ElementSelectedListener
            public void onElementSelected(@NotNull VariableValue.DictionaryEntry dictionaryEntry, boolean z5) {
                Intrinsics.checkNotNullParameter(dictionaryEntry, "dictionaryEntry");
                if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                    if (!z5) {
                        parentKeys.add(dictionaryEntry.getKey());
                        Activity activity2 = activity;
                        Macro macro2 = macro;
                        String key = dictionaryEntry.getKey();
                        VariableValue variable = dictionaryEntry.getVariable();
                        Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                        VariableHelper.showDictionaryEditScreen(activity2, macro2, null, parentName + "[" + dictionaryEntry.getKey() + "]", key, (VariableValue.Dictionary) variable, true, dictionary, parentKeys, r8);
                        return;
                    }
                    VariableHelper.showEditEntryDialogKeyOnly(activity, R.style.Theme_App_Dialog_Variables_NoTitle, dictionary, dictionaryEntry, r8);
                    return;
                }
                VariableHelper.showEditDictionaryEntryDialog(activity, R.style.Theme_App_Dialog_Variables_NoTitle, dictionary, dictionaryEntry, parentKeys, r8);
            }
        };
        ViewExtensionsKt.onClick$default(floatingActionButton, r12, new p(activity, dictionary, parentKeys, r8, null), i7, r12);
        ?? dictionaryVariableAdapter = new DictionaryVariableAdapter(dictionary, elementSelectedListener);
        final Ref.ObjectRef objectRef4 = objectRef;
        objectRef4.element = dictionaryVariableAdapter;
        r15.setAdapter(dictionaryVariableAdapter);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.variables.VariableHelper$showDictionaryEditScreen$$inlined$doOnTextChanged$1
            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i8, int i9, int i10) {
                DictionaryVariableAdapter dictionaryVariableAdapter2;
                T t3 = Ref.ObjectRef.this.element;
                if (t3 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    dictionaryVariableAdapter2 = null;
                } else {
                    dictionaryVariableAdapter2 = (DictionaryVariableAdapter) t3;
                }
                dictionaryVariableAdapter2.getFilter().filter(charSequence);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i8, int i9, int i10) {
            }
        });
        ViewExtensionsKt.onClick$default(imageButton2, r12, new q(editText, objectRef4, r12), i7, r12);
        ViewExtensionsKt.onClick$default(imageButton4, r12, new VariableHelper$showDictionaryEditScreen$6(activity, dictionary, objectRef4, textView, r15, dictionaryEventListener, null), 1, r12);
        ViewExtensionsKt.onClick$default(imageButton3, r12, new VariableHelper$showDictionaryEditScreen$7(activity, z3, dictionary, objectRef4, textView, r15, dictionaryEventListener, dictionary2, appCompatDialog, keyName, null), 1, r12);
        ViewExtensionsKt.onClick$default(imageButton, r12, new r(appCompatDialog, r12), 1, r12);
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog, 0, 1, r12);
        DialogExtensionsKt.setHeightToParent$default(appCompatDialog, 0, 1, r12);
        appCompatDialog.show();
    }

    @JvmStatic
    public static final void showEditDictionaryEntryDialog(@NotNull Activity activity, int i4, @NotNull VariableValue.Dictionary dictionary, @Nullable VariableValue.DictionaryEntry dictionaryEntry, @NotNull ArrayList<String> parentKeys, @NotNull DictionaryEventListener dictionaryEventListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(dictionary, "dictionary");
        Intrinsics.checkNotNullParameter(parentKeys, "parentKeys");
        Intrinsics.checkNotNullParameter(dictionaryEventListener, "dictionaryEventListener");
        showEditEntryDialogGeneric(activity, i4, dictionaryEntry, dictionary, false, parentKeys, dictionaryEventListener);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x011b, code lost:
        r2 = kotlin.text.l.toIntOrNull(r2);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02c6  */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.AbsSpinner, android.widget.AdapterView, android.widget.Spinner] */
    /* JADX WARN: Type inference failed for: r12v6, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.view.View, android.view.ViewGroup] */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void showEditEntryDialogGeneric(@org.jetbrains.annotations.NotNull android.app.Activity r25, int r26, @org.jetbrains.annotations.Nullable com.arlosoft.macrodroid.variables.VariableValue.DictionaryEntry r27, @org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.variables.VariableValue.Dictionary r28, boolean r29, @org.jetbrains.annotations.NotNull java.util.ArrayList<java.lang.String> r30, @org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.variables.DictionaryEventListener r31) {
        /*
            Method dump skipped, instructions count: 732
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.variables.VariableHelper.showEditEntryDialogGeneric(android.app.Activity, int, com.arlosoft.macrodroid.variables.VariableValue$DictionaryEntry, com.arlosoft.macrodroid.variables.VariableValue$Dictionary, boolean, java.util.ArrayList, com.arlosoft.macrodroid.variables.DictionaryEventListener):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x009e, code lost:
        r2 = kotlin.text.l.toIntOrNull(r2);
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void showEditEntryDialogKeyOnly(@org.jetbrains.annotations.NotNull android.app.Activity r19, int r20, @org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.variables.VariableValue.Dictionary r21, @org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.variables.VariableValue.DictionaryEntry r22, @org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.variables.DictionaryEventListener r23) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.variables.VariableHelper.showEditEntryDialogKeyOnly(android.app.Activity, int, com.arlosoft.macrodroid.variables.VariableValue$Dictionary, com.arlosoft.macrodroid.variables.VariableValue$DictionaryEntry, com.arlosoft.macrodroid.variables.DictionaryEventListener):void");
    }

    @JvmStatic
    public static final void showSelectKeyDialog(@NotNull final Activity activity, final int i4, @NotNull final MacroDroidVariable variable, @Nullable final Macro macro, final boolean z3, @NotNull final VariableValue.Dictionary dictionary, @Nullable final Function1<? super VariableValue, Boolean> function1, @NotNull final ArrayList<String> keyList, final int i5, @NotNull final ShowThisDictionaryOption showThisDictionaryOption, final boolean z4, @Nullable final SelectableItem selectableItem, final boolean z5, @NotNull final Function1<? super List<String>, Unit> keysChosen) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(variable, "variable");
        Intrinsics.checkNotNullParameter(dictionary, "dictionary");
        Intrinsics.checkNotNullParameter(keyList, "keyList");
        Intrinsics.checkNotNullParameter(showThisDictionaryOption, "showThisDictionaryOption");
        Intrinsics.checkNotNullParameter(keysChosen, "keysChosen");
        if (z5 && showThisDictionaryOption == ShowThisDictionaryOption.SHOW_DICTIONARIES_ONLY && !dictionary.hasDictionaryChildren(dictionary)) {
            keysChosen.invoke(keyList);
        } else if (z5 && showThisDictionaryOption == ShowThisDictionaryOption.SHOW_ARRAYS_ONLY && !dictionary.hasArrayChildren(dictionary)) {
            keysChosen.invoke(keyList);
        } else {
            showSelectKeyDialog(activity, i4, dictionary, function1, null, z3, new ManualKeyOption(true, null), false, showThisDictionaryOption, z4, new KeyDialogOptionChosenCallback() { // from class: com.arlosoft.macrodroid.variables.VariableHelper$showSelectKeyDialog$1

                /* compiled from: VariableHelper.kt */
                /* loaded from: classes3.dex */
                static final class a extends Lambda implements Function1<String, Unit> {
                    final /* synthetic */ ArrayList<String> $keyList;
                    final /* synthetic */ Function1<List<String>, Unit> $keysChosen;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    a(ArrayList<String> arrayList, Function1<? super List<String>, Unit> function1) {
                        super(1);
                        this.$keyList = arrayList;
                        this.$keysChosen = function1;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull String keyName) {
                        Intrinsics.checkNotNullParameter(keyName, "keyName");
                        this.$keyList.add(keyName);
                        this.$keysChosen.invoke(this.$keyList);
                    }
                }

                /* compiled from: VariableHelper.kt */
                /* loaded from: classes3.dex */
                static final class b extends Lambda implements Function1<VariableHelper.ManualKeyData, Unit> {
                    final /* synthetic */ Function1<List<String>, Unit> $keysChosen;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    b(Function1<? super List<String>, Unit> function1) {
                        super(1);
                        this.$keysChosen = function1;
                    }

                    public final void a(@NotNull VariableHelper.ManualKeyData manualKeyData) {
                        Intrinsics.checkNotNullParameter(manualKeyData, "manualKeyData");
                        this.$keysChosen.invoke(manualKeyData.getKeys());
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(VariableHelper.ManualKeyData manualKeyData) {
                        a(manualKeyData);
                        return Unit.INSTANCE;
                    }
                }

                @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
                public void addKeyChosen() {
                    VariableHelper.createNewKey(activity, i4, dictionary, macro, new a(keyList, keysChosen));
                }

                @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
                public void keyChosen(@NotNull VariableValue.DictionaryEntry dictionaryEntry) {
                    boolean booleanValue;
                    boolean z6;
                    Intrinsics.checkNotNullParameter(dictionaryEntry, "dictionaryEntry");
                    keyList.add(dictionaryEntry.getKey());
                    if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                        VariableValue variable2 = dictionaryEntry.getVariable();
                        Intrinsics.checkNotNull(variable2, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                        List<VariableValue.DictionaryEntry> entries = ((VariableValue.Dictionary) variable2).getEntries();
                        Function1<VariableValue, Boolean> function12 = function1;
                        if (!(entries instanceof Collection) || !entries.isEmpty()) {
                            for (VariableValue.DictionaryEntry dictionaryEntry2 : entries) {
                                if (function12 == null) {
                                    booleanValue = true;
                                    continue;
                                } else {
                                    booleanValue = function12.invoke(dictionaryEntry2.getVariable()).booleanValue();
                                    continue;
                                }
                                if (booleanValue) {
                                    z6 = false;
                                    break;
                                }
                            }
                        }
                        z6 = true;
                        if (z6) {
                            keysChosen.invoke(keyList);
                            return;
                        }
                        Activity activity2 = activity;
                        int i6 = i4;
                        MacroDroidVariable macroDroidVariable = variable;
                        Macro macro2 = macro;
                        boolean z7 = z3;
                        VariableValue variable3 = dictionaryEntry.getVariable();
                        Intrinsics.checkNotNull(variable3, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                        VariableHelper.showSelectKeyDialog(activity2, i6, macroDroidVariable, macro2, z7, (VariableValue.Dictionary) variable3, function1, keyList, i5 + 1, showThisDictionaryOption, z4, selectableItem, z5, keysChosen);
                        return;
                    }
                    keysChosen.invoke(keyList);
                }

                @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
                public void manualKeyEntryChosen(@Nullable List<String> list) {
                    VariableHelper.defineKeysManually(activity, i4, variable, dictionary, macro, null, null, false, selectableItem, false, new b(keysChosen));
                }

                @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
                public void thisDictionaryChosen() {
                    keysChosen.invoke(keyList);
                }

                @Override // com.arlosoft.macrodroid.variables.VariableHelper.KeyDialogOptionChosenCallback
                public void copyAllChosen() {
                }
            });
        }
    }

    private final void w(MacroDroidVariable macroDroidVariable, VariableValue.Dictionary dictionary, boolean z3, List<VariableWithDictionaryKeys> list, List<String> list2) {
        List<String> plus;
        for (VariableValue.DictionaryEntry dictionaryEntry : dictionary.getEntries()) {
            if (dictionaryEntry.getVariable() instanceof VariableValue.Dictionary) {
                VariableValue variable = dictionaryEntry.getVariable();
                Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                VariableValue.Dictionary dictionary2 = (VariableValue.Dictionary) variable;
                plus = CollectionsKt___CollectionsKt.plus((Collection<? extends String>) ((Collection<? extends Object>) list2), dictionaryEntry.getKey());
                if (dictionary2.isArray() == z3) {
                    list.add(new VariableWithDictionaryKeys(macroDroidVariable.getName(), new DictionaryKeys(plus)));
                }
                if ((z3 && dictionary2.hasArrayChildren(dictionary2)) || (!z3 && dictionary2.hasDictionaryChildren(dictionary2))) {
                    VariableHelper variableHelper = INSTANCE;
                    VariableValue variable2 = dictionaryEntry.getVariable();
                    Intrinsics.checkNotNull(variable2, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableValue.Dictionary");
                    variableHelper.w(macroDroidVariable, (VariableValue.Dictionary) variable2, z3, list, plus);
                }
            }
        }
    }

    private final void x(Constraint constraint, String str, String str2) {
        Y(constraint, str, str2);
        f0(constraint, str, str2);
        if (constraint instanceof LogicConstraint) {
            for (Constraint lc : ((LogicConstraint) constraint).getConstraints()) {
                Intrinsics.checkNotNullExpressionValue(lc, "lc");
                x(lc, str, str2);
            }
        }
    }

    @JvmStatic
    private static final void y(final Activity activity, final int i4, Spinner spinner, final Macro macro, final boolean z3, List<String> list, List<MacroDroidVariable> list2, final String str, final String str2, final ShowThisDictionaryOption showThisDictionaryOption, final SelectableItem selectableItem, Integer num, final Function1<? super VariableValue, Boolean> function1, final VariableSelectedListener variableSelectedListener) {
        Iterable<IndexedValue> withIndex;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        final List plus;
        withIndex = CollectionsKt___CollectionsKt.withIndex(list);
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(withIndex, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (IndexedValue indexedValue : withIndex) {
            arrayList.add(new VariableOrOption.Option((String) indexedValue.getValue(), indexedValue.getIndex()));
        }
        List<MacroDroidVariable> list3 = list2;
        collectionSizeOrDefault2 = kotlin.collections.f.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (MacroDroidVariable macroDroidVariable : list3) {
            arrayList2.add(new VariableOrOption.Variable(macroDroidVariable, str2));
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
        final VariableWithTypeSpinnerAdapter variableWithTypeSpinnerAdapter = new VariableWithTypeSpinnerAdapter(activity, plus, num);
        spinner.setAdapter((SpinnerAdapter) variableWithTypeSpinnerAdapter);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.arlosoft.macrodroid.variables.VariableHelper$configureVarOfTypeSpinner$1

            /* compiled from: VariableHelper.kt */
            /* loaded from: classes3.dex */
            static final class a extends Lambda implements Function1<List<? extends String>, Unit> {
                final /* synthetic */ Ref.BooleanRef $hasSelected;
                final /* synthetic */ String $labelSuffix;
                final /* synthetic */ VariableWithTypeSpinnerAdapter $spinnerArrayAdapter;
                final /* synthetic */ MacroDroidVariable $variable;
                final /* synthetic */ VariableHelper.VariableSelectedListener $variableSelectedListener;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(VariableHelper.VariableSelectedListener variableSelectedListener, MacroDroidVariable macroDroidVariable, VariableWithTypeSpinnerAdapter variableWithTypeSpinnerAdapter, String str, Ref.BooleanRef booleanRef) {
                    super(1);
                    this.$variableSelectedListener = variableSelectedListener;
                    this.$variable = macroDroidVariable;
                    this.$spinnerArrayAdapter = variableWithTypeSpinnerAdapter;
                    this.$labelSuffix = str;
                    this.$hasSelected = booleanRef;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                    invoke2((List<String>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull List<String> keys) {
                    Intrinsics.checkNotNullParameter(keys, "keys");
                    this.$variableSelectedListener.variableSelected(this.$variable, keys);
                    VariableWithTypeSpinnerAdapter variableWithTypeSpinnerAdapter = this.$spinnerArrayAdapter;
                    String name = this.$variable.getName();
                    String formattedDictionaryKeys = VariableHelper.getFormattedDictionaryKeys(keys);
                    String str = this.$labelSuffix;
                    variableWithTypeSpinnerAdapter.forceSelectedValueName(name + formattedDictionaryKeys + str);
                    this.$spinnerArrayAdapter.notifyDataSetChanged();
                    this.$hasSelected.element = true;
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(@Nullable AdapterView<?> adapterView, @Nullable View view, int i5, long j4) {
                if (plus.isEmpty()) {
                    return;
                }
                Ref.BooleanRef booleanRef3 = booleanRef;
                boolean z4 = false;
                if (booleanRef3.element) {
                    booleanRef3.element = false;
                } else if (plus.get(i5) instanceof VariableOrOption.Option) {
                    VariableOrOption variableOrOption = plus.get(i5);
                    Intrinsics.checkNotNull(variableOrOption, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableOrOption.Option");
                    VariableOrOption.Option option = (VariableOrOption.Option) variableOrOption;
                    variableWithTypeSpinnerAdapter.forceSelectedValueName(null);
                    variableWithTypeSpinnerAdapter.notifyDataSetChanged();
                    variableSelectedListener.customItemSelected(option.getIndex(), option.getLabel());
                } else {
                    VariableOrOption variableOrOption2 = plus.get(i5);
                    Intrinsics.checkNotNull(variableOrOption2, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableOrOption.Variable");
                    MacroDroidVariable variable = ((VariableOrOption.Variable) variableOrOption2).getVariable();
                    if (!variable.isArray() && !variable.isDictionary()) {
                        variableWithTypeSpinnerAdapter.forceSelectedValueName(null);
                        variableWithTypeSpinnerAdapter.notifyDataSetChanged();
                        variableSelectedListener.variableSelected(variable, null);
                        return;
                    }
                    Activity activity2 = activity;
                    int i6 = i4;
                    Macro macro2 = macro;
                    boolean z5 = z3;
                    VariableValue.Dictionary dictionary = variable.getDictionary();
                    Function1<VariableValue, Boolean> function12 = function1;
                    ArrayList arrayList3 = new ArrayList();
                    VariableHelper.ShowThisDictionaryOption showThisDictionaryOption2 = showThisDictionaryOption;
                    SelectableItem selectableItem2 = selectableItem;
                    if (str == null && !booleanRef2.element) {
                        z4 = true;
                    }
                    VariableHelper.showSelectKeyDialog(activity2, i6, variable, macro2, z5, dictionary, function12, arrayList3, 0, showThisDictionaryOption2, false, selectableItem2, z4, new a(variableSelectedListener, variable, variableWithTypeSpinnerAdapter, str2, booleanRef2));
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(@Nullable AdapterView<?> adapterView) {
            }
        });
        if (str != null) {
            variableWithTypeSpinnerAdapter.forceSelectedValueName(str + str2);
            variableWithTypeSpinnerAdapter.notifyDataSetChanged();
            return;
        }
        booleanRef.element = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(Activity activity, final MacroDroidVariable macroDroidVariable, final Macro macro, int i4, final Dialog dialog, final DictionaryEventListener dictionaryEventListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, i4);
        builder.setTitle(R.string.delete_variable);
        builder.setMessage(activity.getString(R.string.are_you_sure_delete_variable));
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                VariableHelper.A(Macro.this, macroDroidVariable, dictionaryEventListener, dialog, dialogInterface, i5);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                VariableHelper.B(dialogInterface, i5);
            }
        });
        builder.show();
    }

    public final void showLocalVarsDialog(@NotNull Activity activity, @NotNull MacroDroidVariable variable, @NotNull Macro macro, int i4, int i5, @NotNull DictionaryEventListener dictionaryEventListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(variable, "variable");
        Intrinsics.checkNotNullParameter(macro, "macro");
        Intrinsics.checkNotNullParameter(dictionaryEventListener, "dictionaryEventListener");
        if (!variable.isDictionary() && !variable.isArray()) {
            c0(activity, variable, macro, i4, i5, dictionaryEventListener);
        } else {
            showDictionaryEditScreen(activity, macro, variable, variable.getName(), variable.getName(), variable.getDictionary(), true, null, new ArrayList(), dictionaryEventListener);
        }
    }

    @JvmStatic
    @NotNull
    public static final String getFormattedDictionaryKeys(@Nullable List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (String str : list) {
                sb.append("[");
                sb.append(MacroDroidVariable.Companion.getRawKeyName(str));
                sb.append("]");
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "dictionaryKeysString.toString()");
        return sb2;
    }

    @JvmStatic
    public static final void showSelectKeyDialog(@NotNull final Activity activity, int i4, @NotNull final VariableValue.Dictionary dictionary, @Nullable Function1<? super VariableValue, Boolean> function1, @Nullable String str, boolean z3, @NotNull final ManualKeyOption manualKeyOption, boolean z4, @NotNull ShowThisDictionaryOption showThisDictionaryOption, boolean z5, @NotNull final KeyDialogOptionChosenCallback optionChosenCallback) {
        List<VariableValue.DictionaryEntry> list;
        int collectionSizeOrDefault;
        List list2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(dictionary, "dictionary");
        Intrinsics.checkNotNullParameter(manualKeyOption, "manualKeyOption");
        Intrinsics.checkNotNullParameter(showThisDictionaryOption, "showThisDictionaryOption");
        Intrinsics.checkNotNullParameter(optionChosenCallback, "optionChosenCallback");
        if (function1 == null) {
            list = dictionary.getEntriesSorted();
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : dictionary.getEntriesSorted()) {
                if (function1.invoke(((VariableValue.DictionaryEntry) obj).getVariable()).booleanValue()) {
                    arrayList.add(obj);
                }
            }
            list = arrayList;
        }
        List<VariableValue.DictionaryEntry> list3 = list;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (VariableValue.DictionaryEntry dictionaryEntry : list3) {
            arrayList2.add(dictionaryEntry.getKey());
        }
        list2 = CollectionsKt___CollectionsKt.toList(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        boolean z6 = showThisDictionaryOption == ShowThisDictionaryOption.SHOW_DICTIONARIES_AND_ARRAYS || (showThisDictionaryOption == ShowThisDictionaryOption.SHOW_DICTIONARIES_ONLY && !dictionary.isArray()) || (showThisDictionaryOption == ShowThisDictionaryOption.SHOW_ARRAYS_ONLY && dictionary.isArray());
        if (z6) {
            String string = activity.getString(dictionary.isArray() ? R.string.variable_this_array : R.string.variable_this_dictionary);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(if (d…variable_this_dictionary)");
            arrayList3.add(string);
        }
        if (z4) {
            String string2 = activity.getString(dictionary.isArray() ? R.string.variable_copy_other_array : R.string.variable_copy_other_dictionary);
            Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(if (d…le_copy_other_dictionary)");
            arrayList3.add(string2);
        }
        if (z3) {
            String string3 = activity.getString(dictionary.isArray() ? R.string.variable_dictionary_add_array_index : R.string.variable_dictionary_add_key);
            Intrinsics.checkNotNullExpressionValue(string3, "activity.getString(if (d…iable_dictionary_add_key)");
            arrayList3.add(string3);
        }
        if (manualKeyOption.getShowManualKeys()) {
            String string4 = activity.getString(R.string.variable_dictionary_array_define_indexes_or_keys_manually);
            Intrinsics.checkNotNullExpressionValue(string4, "activity.getString(R.str…indexes_or_keys_manually)");
            arrayList3.add(string4);
        }
        arrayList3.addAll(list2);
        final String[] strArr = (String[]) arrayList3.toArray(new String[0]);
        final Ref.IntRef intRef = new Ref.IntRef();
        int length = strArr.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                i5 = -1;
                break;
            } else if (Intrinsics.areEqual(strArr[i5], str)) {
                break;
            } else {
                i5++;
            }
        }
        intRef.element = i5;
        if (i5 < 0) {
            intRef.element = 0;
        }
        if (z6 && strArr.length == 1) {
            optionChosenCallback.thisDictionaryChosen();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, i4);
        builder.setTitle(dictionary.isArray() ? R.string.variable_array_index : R.string.variable_dictionary_select_key);
        builder.setSingleChoiceItems(strArr, intRef.element, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.i0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                VariableHelper.d0(Ref.IntRef.this, dialogInterface, i6);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.j0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                VariableHelper.e0(strArr, intRef, activity, optionChosenCallback, manualKeyOption, dictionary, dialogInterface, i6);
            }
        });
        builder.setCancelable(z5);
        builder.show();
    }
}
