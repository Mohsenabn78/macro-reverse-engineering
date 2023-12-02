package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.os.ParcelCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.interfaces.HasVariableNames;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.IntentReceivedTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.IntentReceivedTriggerReceiver;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IntentReceivedTrigger.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nIntentReceivedTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntentReceivedTrigger.kt\ncom/arlosoft/macrodroid/triggers/IntentReceivedTrigger\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,222:1\n262#2,2:223\n262#2,2:237\n262#2,2:239\n1549#3:225\n1620#3,3:226\n1549#3:231\n1620#3,3:232\n37#4,2:229\n37#4,2:235\n*S KotlinDebug\n*F\n+ 1 IntentReceivedTrigger.kt\ncom/arlosoft/macrodroid/triggers/IntentReceivedTrigger\n*L\n123#1:223,2\n118#1:237,2\n152#1:239,2\n212#1:225\n212#1:226,3\n216#1:231\n216#1:232,3\n212#1:229,2\n216#1:235,2\n*E\n"})
/* loaded from: classes3.dex */
public final class IntentReceivedTrigger extends Trigger implements HasVariableNames {
    @Nullable
    private String action;
    private boolean enableRegex;
    @NotNull
    private List<String> extraParams;
    @NotNull
    private List<String> extraValuePatterns;
    @NotNull
    private List<String> extraVariables;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<IntentReceivedTrigger> CREATOR = new Parcelable.Creator<IntentReceivedTrigger>() { // from class: com.arlosoft.macrodroid.triggers.IntentReceivedTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public IntentReceivedTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new IntentReceivedTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public IntentReceivedTrigger[] newArray(int i4) {
            return new IntentReceivedTrigger[i4];
        }
    };
    @NotNull
    private static final HashMap<Long, String> triggerIdActionsMap = new HashMap<>();
    @NotNull
    private static final HashMap<String, IntentReceivedTriggerReceiver> actionReceiverMap = new HashMap<>();

    public /* synthetic */ IntentReceivedTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void T(Context context, final LinearLayout linearLayout, final CheckBox checkBox, String str, String str2, String str3) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.include_intent_extra, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        final ViewGroup viewGroup = (ViewGroup) inflate;
        linearLayout.addView(viewGroup);
        ((ImageView) viewGroup.findViewById(R.id.delete_button)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.l4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntentReceivedTrigger.V(linearLayout, viewGroup, checkBox, view);
            }
        });
        String r4 = SelectableItem.r(R.string.wildcards_supported);
        String r5 = SelectableItem.r(R.string.value);
        ((TextView) viewGroup.findViewById(R.id.wildcards_text)).setText(r4 + " (" + r5 + ")");
        final EditText editText = (EditText) viewGroup.findViewById(R.id.value);
        ((EditText) viewGroup.findViewById(R.id.parameter_name)).setText(str);
        editText.setText(str2);
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.m4
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                IntentReceivedTrigger.W(editText, magicTextPair);
            }
        };
        ((Button) viewGroup.findViewById(R.id.special_text_button)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.n4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntentReceivedTrigger.X(IntentReceivedTrigger.this, magicTextListener, view);
            }
        });
        ArrayList<MacroDroidVariable> allStringVariables = getAllStringVariables();
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, SelectableItem.r(R.string.none));
        final Spinner spinner = (Spinner) viewGroup.findViewById(R.id.variable_spinner);
        ((Button) viewGroup.findViewById(R.id.add_variable_button)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.o4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntentReceivedTrigger.Y(IntentReceivedTrigger.this, spinner, view);
            }
        });
        Iterator<MacroDroidVariable> it = allStringVariables.iterator();
        int i4 = 0;
        int i5 = 0;
        while (it.hasNext()) {
            i5++;
            MacroDroidVariable next = it.next();
            if (Intrinsics.areEqual(str3, next.getName())) {
                i4 = i5;
            }
            arrayList.add(next.getName());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, (int) R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.simple_dropdown_item_1line);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setSelection(i4, false);
    }

    static /* synthetic */ void U(IntentReceivedTrigger intentReceivedTrigger, Context context, LinearLayout linearLayout, CheckBox checkBox, String str, String str2, String str3, int i4, Object obj) {
        String str4;
        String str5;
        String str6;
        if ((i4 & 8) != 0) {
            str4 = "";
        } else {
            str4 = str;
        }
        if ((i4 & 16) != 0) {
            str5 = "";
        } else {
            str5 = str2;
        }
        if ((i4 & 32) != 0) {
            str6 = null;
        } else {
            str6 = str3;
        }
        intentReceivedTrigger.T(context, linearLayout, checkBox, str4, str5, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(LinearLayout extrasContainer, ViewGroup intentLayout, CheckBox enableRegexCheckBox, View view) {
        boolean z3;
        Intrinsics.checkNotNullParameter(extrasContainer, "$extrasContainer");
        Intrinsics.checkNotNullParameter(intentLayout, "$intentLayout");
        Intrinsics.checkNotNullParameter(enableRegexCheckBox, "$enableRegexCheckBox");
        extrasContainer.removeView(intentLayout);
        int i4 = 0;
        if (extrasContainer.getChildCount() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            i4 = 8;
        }
        enableRegexCheckBox.setVisibility(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(IntentReceivedTrigger this$0, MagicText.MagicTextListener magicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        MagicText.displaySelectionDialog(this$0.getActivity(), magicTextListener, this$0.getMacro(), false, true, true, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(IntentReceivedTrigger this$0, Spinner spinner, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VariablesHelper.createNewVariable(this$0.getActivity(), spinner, (SelectableItem) this$0, this$0.getDialogTheme(), true, (VariablesHelper.VariableCreatedListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(IntentReceivedTrigger this$0, AppCompatDialog dialog, LinearLayout linearLayout, CheckBox enableRegexCheckBox, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(enableRegexCheckBox, "$enableRegexCheckBox");
        Context context = dialog.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "dialog.context");
        Intrinsics.checkNotNull(linearLayout);
        U(this$0, context, linearLayout, enableRegexCheckBox, null, null, null, 56, null);
        enableRegexCheckBox.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(IntentReceivedTrigger this$0, EditText editText, CheckBox enableRegexCheckBox, LinearLayout linearLayout, AppCompatDialog dialog, View view) {
        Editable editable;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(enableRegexCheckBox, "$enableRegexCheckBox");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        this$0.action = String.valueOf(editable);
        this$0.enableRegex = enableRegexCheckBox.isChecked();
        this$0.extraParams.clear();
        this$0.extraValuePatterns.clear();
        this$0.extraVariables.clear();
        Intrinsics.checkNotNull(linearLayout);
        int childCount = linearLayout.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = linearLayout.getChildAt(i4);
            this$0.extraParams.add(((TextView) childAt.findViewById(R.id.parameter_name)).getText().toString());
            this$0.extraValuePatterns.add(((TextView) childAt.findViewById(R.id.value)).getText().toString());
            Spinner spinner = (Spinner) childAt.findViewById(R.id.variable_spinner);
            if (spinner.getSelectedItemPosition() == 0) {
                this$0.extraVariables.add(null);
            } else {
                List<String> list = this$0.extraVariables;
                Object selectedItem = spinner.getSelectedItem();
                Intrinsics.checkNotNull(selectedItem, "null cannot be cast to non-null type kotlin.String");
                list.add((String) selectedItem);
            }
        }
        dialog.dismiss();
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        try {
            String str = this.action;
            if (str != null) {
                HashMap<Long, String> hashMap = triggerIdActionsMap;
                hashMap.remove(Long.valueOf(getSIGUID()));
                if (!hashMap.values().contains(str)) {
                    HashMap<String, IntentReceivedTriggerReceiver> hashMap2 = actionReceiverMap;
                    IntentReceivedTriggerReceiver intentReceivedTriggerReceiver = hashMap2.get(str);
                    if (intentReceivedTriggerReceiver != null) {
                        getContext().unregisterReceiver(intentReceivedTriggerReceiver);
                    }
                    hashMap2.remove(str);
                }
            }
        } catch (Exception e4) {
            FirebaseCrashlytics.getInstance().recordException(e4);
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        String str = this.action;
        if (str != null) {
            HashMap<Long, String> hashMap = triggerIdActionsMap;
            if (!hashMap.values().contains(str)) {
                IntentFilter intentFilter = new IntentFilter(str);
                IntentReceivedTriggerReceiver intentReceivedTriggerReceiver = new IntentReceivedTriggerReceiver();
                actionReceiverMap.put(str, intentReceivedTriggerReceiver);
                getContext().registerReceiver(intentReceivedTriggerReceiver, intentFilter);
            }
            hashMap.put(Long.valueOf(getSIGUID()), str);
        }
    }

    @Nullable
    public final String getAction() {
        return this.action;
    }

    public final boolean getEnableRegex() {
        return this.enableRegex;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String getExtendedDetail() {
        return this.action;
    }

    @NotNull
    public final List<String> getExtraParams() {
        return this.extraParams;
    }

    @NotNull
    public final List<String> getExtraValuePatterns() {
        return this.extraValuePatterns;
    }

    @NotNull
    public final List<String> getExtraVariables() {
        return this.extraVariables;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return IntentReceivedTriggerInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String name = getName();
        String extendedDetail = getExtendedDetail();
        return name + ": " + extendedDetail;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public String[] getVariableNames() {
        int collectionSizeOrDefault;
        List<String> list = this.extraVariables;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str : list) {
            if (str == null) {
                str = "";
            }
            arrayList.add(str);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public Integer[] getVariableTypes() {
        int collectionSizeOrDefault;
        List<String> list = this.extraVariables;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str : list) {
            arrayList.add(2);
        }
        return (Integer[]) arrayList.toArray(new Integer[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        WindowManager.LayoutParams layoutParams;
        Iterable<IndexedValue> withIndex;
        int i4;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_intent_receive);
        appCompatDialog.setTitle(R.string.trigger_intent_received);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        layoutParams2.copyFrom(layoutParams);
        layoutParams2.width = -1;
        Window window2 = appCompatDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams2);
        }
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.action);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final LinearLayout linearLayout = (LinearLayout) appCompatDialog.findViewById(R.id.extras_container);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.add_extra_button);
        View findViewById = appCompatDialog.findViewById(R.id.enable_regex);
        Intrinsics.checkNotNull(findViewById);
        final CheckBox checkBox = (CheckBox) findViewById;
        withIndex = CollectionsKt___CollectionsKt.withIndex(this.extraParams);
        for (IndexedValue indexedValue : withIndex) {
            Context context = appCompatDialog.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "dialog.context");
            Intrinsics.checkNotNull(linearLayout);
            T(context, linearLayout, checkBox, (String) indexedValue.getValue(), this.extraValuePatterns.get(indexedValue.getIndex()), this.extraVariables.get(indexedValue.getIndex()));
        }
        if (button3 != null) {
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.i4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IntentReceivedTrigger.Z(IntentReceivedTrigger.this, appCompatDialog, linearLayout, checkBox, view);
                }
            });
        }
        if (editText != null) {
            editText.setText(this.action);
        }
        checkBox.setChecked(this.enableRegex);
        if (!this.extraParams.isEmpty()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        checkBox.setVisibility(i4);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.j4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IntentReceivedTrigger.a0(IntentReceivedTrigger.this, editText, checkBox, linearLayout, appCompatDialog, view);
                }
            });
        }
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.k4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IntentReceivedTrigger.b0(AppCompatDialog.this, view);
                }
            });
        }
        appCompatDialog.show();
    }

    public final void setAction(@Nullable String str) {
        this.action = str;
    }

    public final void setEnableRegex(boolean z3) {
        this.enableRegex = z3;
    }

    public final void setExtraParams(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.extraParams = list;
    }

    public final void setExtraValuePatterns(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.extraValuePatterns = list;
    }

    public final void setExtraVariables(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.extraVariables = list;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    public void setVariableNames(@NotNull String[] varNames) {
        List<String> mutableList;
        Intrinsics.checkNotNullParameter(varNames, "varNames");
        mutableList = ArraysKt___ArraysKt.toMutableList(varNames);
        this.extraVariables = mutableList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.action);
        out.writeStringList(this.extraParams);
        out.writeStringList(this.extraValuePatterns);
        out.writeStringList(this.extraVariables);
        ParcelCompat.writeBoolean(out, this.enableRegex);
    }

    public IntentReceivedTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public IntentReceivedTrigger() {
        this.extraParams = new ArrayList();
        this.extraValuePatterns = new ArrayList();
        this.extraVariables = new ArrayList();
    }

    private IntentReceivedTrigger(Parcel parcel) {
        super(parcel);
        this.extraParams = new ArrayList();
        this.extraValuePatterns = new ArrayList();
        this.extraVariables = new ArrayList();
        this.action = parcel.readString();
        parcel.readStringList(this.extraParams);
        parcel.readStringList(this.extraValuePatterns);
        parcel.readStringList(this.extraVariables);
        this.enableRegex = ParcelCompat.readBoolean(parcel);
    }

    /* compiled from: IntentReceivedTrigger.kt */
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
