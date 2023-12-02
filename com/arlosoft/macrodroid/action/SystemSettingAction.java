package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.Editable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SystemSettingActionInfo;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.helper.HelperCommonFunctionality;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.HelperSystemCommands;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DispatchedCoroutine;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SystemSettingAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nSystemSettingAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SystemSettingAction.kt\ncom/arlosoft/macrodroid/action/SystemSettingAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,398:1\n1002#2,2:399\n1549#2:401\n1620#2,3:402\n*S KotlinDebug\n*F\n+ 1 SystemSettingAction.kt\ncom/arlosoft/macrodroid/action/SystemSettingAction\n*L\n275#1:399,2\n277#1:401\n277#1:402,3\n*E\n"})
/* loaded from: classes2.dex */
public final class SystemSettingAction extends Action implements SupportsMagicText {
    @NotNull
    private static final String[] DIALOG_OPTIONS = {"System", "Secure<br/><small>(" + SelectableItem.r(R.string.root_or_adb_hack) + ")</small>", "Global<br/><small>(" + SelectableItem.r(R.string.root_or_adb_hack) + ")</small>"};
    @NotNull
    private String settingString;
    private int tableOption;
    private boolean useHelper;
    @NotNull
    private String valueString;
    private int valueType;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SystemSettingAction> CREATOR = new Parcelable.Creator<SystemSettingAction>() { // from class: com.arlosoft.macrodroid.action.SystemSettingAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SystemSettingAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SystemSettingAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SystemSettingAction[] newArray(int i4) {
            return new SystemSettingAction[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemSettingAction.kt */
    /* loaded from: classes2.dex */
    public static final class a extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        int label;

        a(Continuation<? super a> continuation) {
            super(4, continuation);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            return new a(continuation).invokeSuspend(Unit.INSTANCE);
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
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemSettingAction.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements Function1<Integer, Unit> {
        final /* synthetic */ EditText $keyText;
        final /* synthetic */ Spinner $typeSpinner;
        final /* synthetic */ List<Pair<String, String>> $updatedList;
        final /* synthetic */ EditText $valueText;
        final /* synthetic */ SystemSettingAction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List<Pair<String, String>> list, EditText editText, EditText editText2, Spinner spinner, SystemSettingAction systemSettingAction) {
            super(1);
            this.$updatedList = list;
            this.$keyText = editText;
            this.$valueText = editText2;
            this.$typeSpinner = spinner;
            this.this$0 = systemSettingAction;
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
                Spinner spinner = this.$typeSpinner;
                if (spinner != null) {
                    spinner.setSelection(this.this$0.g0(pair.getSecond()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemSettingAction.kt */
    /* loaded from: classes2.dex */
    public static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ CheckBox $helperCheckbox;
        final /* synthetic */ EditText $keyText;
        final /* synthetic */ Spinner $typeSpinner;
        final /* synthetic */ EditText $valueText;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CheckBox checkBox, EditText editText, EditText editText2, Spinner spinner, AppCompatDialog appCompatDialog, Continuation<? super c> continuation) {
            super(3, continuation);
            this.$helperCheckbox = checkBox;
            this.$keyText = editText;
            this.$valueText = editText2;
            this.$typeSpinner = spinner;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(this.$helperCheckbox, this.$keyText, this.$valueText, this.$typeSpinner, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z3;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SystemSettingAction systemSettingAction = SystemSettingAction.this;
                CheckBox checkBox = this.$helperCheckbox;
                int i4 = 0;
                if (checkBox != null && checkBox.isChecked()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                systemSettingAction.useHelper = z3;
                SystemSettingAction.this.settingString = this.$keyText.getText().toString();
                SystemSettingAction.this.valueString = this.$valueText.getText().toString();
                SystemSettingAction systemSettingAction2 = SystemSettingAction.this;
                Spinner spinner = this.$typeSpinner;
                if (spinner != null) {
                    i4 = spinner.getSelectedItemPosition();
                }
                systemSettingAction2.valueType = i4;
                SystemSettingAction.this.itemComplete();
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemSettingAction.kt */
    /* loaded from: classes2.dex */
    public static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(AppCompatDialog appCompatDialog, Continuation<? super d> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
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

    public /* synthetic */ SystemSettingAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(SystemSettingAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(SystemSettingAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(SystemSettingAction this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(SystemSettingAction this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    private final void Y(List<Pair<String, String>> list) {
        boolean z3;
        List mutableList;
        int collectionSizeOrDefault;
        Button button;
        CheckBox checkBox;
        Button button2;
        Button button3;
        int i4;
        DispatchedCoroutine dispatchedCoroutine;
        boolean z4;
        Button button4;
        CheckBox checkBox2;
        String sb;
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_system_setting);
        appCompatDialog.setTitle(Companion.a()[this.tableOption]);
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog, 0, 1, null);
        View findViewById = appCompatDialog.findViewById(R.id.key);
        Intrinsics.checkNotNull(findViewById);
        final EditText editText = (EditText) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.value);
        Intrinsics.checkNotNull(findViewById2);
        final EditText editText2 = (EditText) findViewById2;
        Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.typeSpinner);
        Spinner spinner2 = (Spinner) appCompatDialog.findViewById(R.id.spinner);
        Button button5 = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button6 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        CheckBox checkBox3 = (CheckBox) appCompatDialog.findViewById(R.id.helperFileCheckBox);
        Button button7 = (Button) appCompatDialog.findViewById(R.id.keyMagicTextButton);
        Button button8 = (Button) appCompatDialog.findViewById(R.id.valueMagicTextButton);
        String str = this.settingString;
        if (str != null && str.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            if (checkBox3 != null) {
                checkBox3.setChecked(ApplicationChecker.isMacroDroidNewHelperInstalled());
            }
        } else if (checkBox3 != null) {
            checkBox3.setChecked(this.useHelper);
        }
        if (checkBox3 != null) {
            Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(checkBox3, (CoroutineContext) null, new a(null), 1, (Object) null);
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        if (mutableList.size() > 1) {
            kotlin.collections.h.sortWith(mutableList, new Comparator() { // from class: com.arlosoft.macrodroid.action.SystemSettingAction$displaySettingsDialog$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t3, T t4) {
                    int compareValues;
                    compareValues = kotlin.comparisons.f.compareValues((String) ((Pair) t3).getFirst(), (String) ((Pair) t4).getFirst());
                    return compareValues;
                }
            });
        }
        mutableList.add(0, new Pair(SelectableItem.r(R.string.select_option), ""));
        Activity activity2 = getActivity();
        List list2 = mutableList;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            Iterator it2 = it;
            Object first = pair.getFirst();
            if (((CharSequence) pair.getSecond()).length() == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                button4 = button7;
                checkBox2 = checkBox3;
                sb = "";
            } else {
                Object second = pair.getSecond();
                button4 = button7;
                StringBuilder sb2 = new StringBuilder();
                checkBox2 = checkBox3;
                sb2.append(" (");
                sb2.append(second);
                sb2.append(")");
                sb = sb2.toString();
            }
            arrayList.add(first + sb);
            it = it2;
            button7 = button4;
            checkBox3 = checkBox2;
        }
        Button button9 = button7;
        CheckBox checkBox4 = checkBox3;
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity2, 17367048, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) arrayAdapter);
        }
        if (spinner2 != null) {
            spinner2.setSelection(0, false);
        }
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(getActivity(), 17367048, Companion.b());
        arrayAdapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) arrayAdapter2);
        }
        if (spinner != null) {
            spinner.setSelection(this.valueType);
        }
        if (spinner2 != null) {
            button = button8;
            button2 = button6;
            checkBox = checkBox4;
            button3 = button9;
            ViewExtensionsKt.itemSelected(spinner2, new b(mutableList, editText, editText2, spinner, this));
        } else {
            button = button8;
            checkBox = checkBox4;
            button2 = button6;
            button3 = button9;
        }
        editText.setText(this.settingString);
        editText2.setText(this.valueString);
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.ep
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SystemSettingAction.Z(editText, magicTextPair);
            }
        };
        if (button3 != null) {
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.fp
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SystemSettingAction.a0(SystemSettingAction.this, magicTextListener, view);
                }
            });
        }
        final MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.gp
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SystemSettingAction.b0(editText2, magicTextPair);
            }
        };
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.hp
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SystemSettingAction.c0(SystemSettingAction.this, magicTextListener2, view);
                }
            });
        }
        if (button5 != null) {
            i4 = 1;
            dispatchedCoroutine = null;
            ViewExtensionsKt.onClick$default(button5, null, new c(checkBox, editText, editText2, spinner, appCompatDialog, null), 1, null);
        } else {
            i4 = 1;
            dispatchedCoroutine = null;
        }
        if (button2 != null) {
            ViewExtensionsKt.onClick$default(button2, dispatchedCoroutine, new d(appCompatDialog, dispatchedCoroutine), i4, dispatchedCoroutine);
        }
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(EditText keyText, MagicText.MagicTextPair pair) {
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
    public static final void a0(SystemSettingAction this$0, MagicText.MagicTextListener keyMagicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(keyMagicTextListener, "$keyMagicTextListener");
        MagicText.displaySelectionDialog(this$0.getActivity(), keyMagicTextListener, this$0.getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(EditText valueText, MagicText.MagicTextPair pair) {
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
    public static final void c0(SystemSettingAction this$0, MagicText.MagicTextListener valueMagicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(valueMagicTextListener, "$valueMagicTextListener");
        MagicText.displaySelectionDialog(this$0.getActivity(), valueMagicTextListener, this$0.getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    private final String d0() {
        int i4 = this.tableOption;
        if (i4 != 0) {
            if (i4 != 1) {
                return HelperCommandsKt.HELPER_SETTING_TYPE_GLOBAL;
            }
            return "secure";
        }
        return HelperCommandsKt.HELPER_SETTING_TYPE_SYSTEM;
    }

    private final String e0() {
        int i4 = this.valueType;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return "string";
                }
                return HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_LONG;
            }
            return "float";
        }
        return HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_INT;
    }

    private final String f0(String str, TriggerContextInfo triggerContextInfo) {
        String replace$default;
        String replaceMagicText = MagicText.replaceMagicText(getContext(), str, triggerContextInfo, getMacro());
        Intrinsics.checkNotNullExpressionValue(replaceMagicText, "replaceMagicText(context…text, contextInfo, macro)");
        replace$default = kotlin.text.m.replace$default(replaceMagicText, "\\n", "\n", false, 4, (Object) null);
        return replace$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int g0(String str) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0077 -> B:62:0x021a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x009c -> B:62:0x021a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0131 -> B:62:0x021a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0156 -> B:62:0x021a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x01e3 -> B:62:0x021a). Please submit an issue!!! */
    private final void h0(TriggerContextInfo triggerContextInfo) {
        String f02 = f0(this.settingString, triggerContextInfo);
        String f03 = f0(this.valueString, triggerContextInfo);
        try {
            int i4 = this.tableOption;
            String str = ": ";
            if (i4 != 0) {
                String str2 = ", you need to grant permission via adb with the command: adb shell pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS";
                f02 = f02;
                str = str;
                if (i4 != 1) {
                    if (i4 == 2) {
                        if (!RootToolsHelper.isAccessGiven()) {
                            try {
                                try {
                                    int i5 = this.valueType;
                                    if (i5 != 0) {
                                        if (i5 != 1) {
                                            if (i5 != 2) {
                                                if (i5 != 3) {
                                                    f02 = f02;
                                                    str = str;
                                                } else {
                                                    Settings.Global.putString(getContext().getContentResolver(), f02, f03);
                                                    f02 = f02;
                                                    str = str;
                                                }
                                            } else {
                                                Settings.Global.putLong(getContext().getContentResolver(), f02, Long.parseLong(f03));
                                                f02 = f02;
                                                str = str;
                                            }
                                        } else {
                                            Settings.Global.putFloat(getContext().getContentResolver(), f02, Float.parseFloat(f03));
                                            f02 = f02;
                                            str = str;
                                        }
                                    } else {
                                        Settings.Global.putInt(getContext().getContentResolver(), f02, Integer.parseInt(f03));
                                        f02 = f02;
                                        str = str;
                                    }
                                } catch (SecurityException unused) {
                                    String str3 = "Could not set " + f02 + str2;
                                    Long macroGuid = getMacroGuid();
                                    Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                                    long longValue = macroGuid.longValue();
                                    SystemLog.logError(str3, longValue);
                                    f02 = longValue;
                                    str = str;
                                }
                            } catch (Exception e4) {
                                String str4 = "Could not set " + f02 + str + e4;
                                Long macroGuid2 = getMacroGuid();
                                Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
                                long longValue2 = macroGuid2.longValue();
                                SystemLog.logError(str4, longValue2);
                                f02 = longValue2;
                                str = str;
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("settings put global ");
                            sb.append(f02);
                            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                            sb.append(f03);
                            Util.runAsRoot(new String[]{sb.toString()});
                            f02 = f02;
                            str = sb;
                        }
                    }
                    return;
                }
                if (!RootToolsHelper.isAccessGiven()) {
                    try {
                        int i6 = this.valueType;
                        if (i6 != 0) {
                            if (i6 != 1) {
                                if (i6 != 2) {
                                    if (i6 != 3) {
                                        f02 = f02;
                                        str = str;
                                    } else {
                                        Settings.Secure.putString(getContext().getContentResolver(), f02, f03);
                                        f02 = f02;
                                        str = str;
                                    }
                                } else {
                                    Settings.Secure.putLong(getContext().getContentResolver(), f02, Long.parseLong(f03));
                                    f02 = f02;
                                    str = str;
                                }
                            } else {
                                Settings.Secure.putFloat(getContext().getContentResolver(), f02, Float.parseFloat(f03));
                                f02 = f02;
                                str = str;
                            }
                        } else {
                            Settings.Secure.putInt(getContext().getContentResolver(), f02, Integer.parseInt(f03));
                            f02 = f02;
                            str = str;
                        }
                    } catch (SecurityException unused2) {
                        String str5 = "Could not set " + f02 + str2;
                        Long macroGuid3 = getMacroGuid();
                        Intrinsics.checkNotNullExpressionValue(macroGuid3, "macroGuid");
                        long longValue3 = macroGuid3.longValue();
                        SystemLog.logError(str5, longValue3);
                        f02 = longValue3;
                        str = str;
                    } catch (Exception e5) {
                        String str6 = "Could not set " + f02 + str + e5;
                        Long macroGuid4 = getMacroGuid();
                        Intrinsics.checkNotNullExpressionValue(macroGuid4, "macroGuid");
                        long longValue4 = macroGuid4.longValue();
                        SystemLog.logError(str6, longValue4);
                        f02 = longValue4;
                        str = str;
                    }
                } else {
                    String str7 = this.valueString;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("settings put secure ");
                    sb2.append(f02);
                    sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb2.append(str7);
                    String sb3 = sb2.toString();
                    Util.runAsRoot(new String[]{sb3});
                    f02 = sb3;
                    str = sb2;
                }
                return;
            }
            try {
                int i7 = this.valueType;
                if (i7 != 0) {
                    if (i7 != 1) {
                        if (i7 != 2) {
                            if (i7 != 3) {
                                f02 = f02;
                                str = str;
                            } else {
                                Settings.System.putString(getContext().getContentResolver(), f02, f03);
                                f02 = f02;
                                str = str;
                            }
                        } else {
                            Settings.System.putLong(getContext().getContentResolver(), f02, Long.parseLong(f03));
                            f02 = f02;
                            str = str;
                        }
                    } else {
                        Settings.System.putFloat(getContext().getContentResolver(), f02, Float.parseFloat(f03));
                        f02 = f02;
                        str = str;
                    }
                } else {
                    Settings.System.putInt(getContext().getContentResolver(), f02, Integer.parseInt(f03));
                    f02 = f02;
                    str = str;
                }
            } catch (Exception e6) {
                String str8 = "Could not set " + f02 + str + e6;
                Long macroGuid5 = getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid5, "macroGuid");
                long longValue5 = macroGuid5.longValue();
                SystemLog.logError(str8, longValue5);
                f02 = longValue5;
                str = str;
            }
            return;
        } catch (Exception e7) {
            String obj = e7.toString();
            Long macroGuid6 = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid6, "macroGuid");
            SystemLog.logError(obj, macroGuid6.longValue());
        }
        String obj2 = e7.toString();
        Long macroGuid62 = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid62, "macroGuid");
        SystemLog.logError(obj2, macroGuid62.longValue());
    }

    private final void i0(TriggerContextInfo triggerContextInfo) {
        if (ApplicationChecker.isMacroDroidNewHelperInstalled()) {
            String f02 = f0(this.settingString, triggerContextInfo);
            String f03 = f0(this.valueString, triggerContextInfo);
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logInfo("Calling helper file to set system setting.", macroGuid.longValue());
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            HelperSystemCommands.sendSystemSetting(context, d0(), e0(), f02, f03);
            return;
        }
        Long macroGuid2 = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
        SystemLog.logError("System setting is configured to use the helper file, but the helper file is not installed. Please see: https://macrodroidforum.com/index.php?threads/macrodroid-helper-apk.1/", macroGuid2.longValue());
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        String name = getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        HelperCommonFunctionality.showMissingHelperFileNotification(context2, name, "1.4");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.tableOption = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public List<String> getAdbHackPermissionRequired() {
        List<String> listOf;
        if (this.tableOption != 0 && !this.useHelper) {
            listOf = kotlin.collections.e.listOf("android.permission.WRITE_SECURE_SETTINGS");
            return listOf;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.tableOption;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = Companion.a()[this.tableOption];
        String str2 = this.settingString;
        String str3 = this.valueString;
        return "[" + str + "] " + str2 + " = " + str3;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return SystemSettingActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.settingString, this.valueString};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        if (this.useHelper) {
            i0(triggerContextInfo);
        } else {
            h0(triggerContextInfo);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isRootOnly() {
        if (this.tableOption > 0 && !this.useHelper) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    protected AlertDialog l() {
        final ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), m());
        final String[] o4 = o();
        ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter<CharSequence>(contextThemeWrapper, o4) { // from class: com.arlosoft.macrodroid.action.SystemSettingAction$displaySecondaryOptionsDialog$adapter$1
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            @NotNull
            public View getView(int i4, @Nullable View view, @NotNull ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                View view2 = super.getView(i4, view, parent);
                Intrinsics.checkNotNullExpressionValue(view2, "super.getView(position, convertView, parent)");
                ((TextView) view2.findViewById(16908308)).setText(MDTextUtils.fromHtml(String.valueOf(getItem(i4))));
                return view2;
            }
        };
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(arrayAdapter, getCheckedItemIndex(), new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ap
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SystemSettingAction.U(SystemSettingAction.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.bp
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SystemSettingAction.V(SystemSettingAction.this, dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.cp
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SystemSettingAction.W(SystemSettingAction.this, dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.dp
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                SystemSettingAction.X(SystemSettingAction.this, dialogInterface);
            }
        });
        return create;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] o() {
        return DIALOG_OPTIONS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String p() {
        String r4 = SelectableItem.r(R.string.action_system_setting_select_settings_table);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.actio…ng_select_settings_table)");
        return r4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresWriteSettings() {
        return !this.useHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
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
            Y(arrayList);
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

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.tableOption);
        out.writeString(this.settingString);
        out.writeString(this.valueString);
        out.writeInt(this.valueType);
        out.writeInt(this.useHelper ? 1 : 0);
    }

    public SystemSettingAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SystemSettingAction() {
        this.settingString = "";
        this.valueString = "";
    }

    private SystemSettingAction(Parcel parcel) {
        super(parcel);
        this.settingString = "";
        this.valueString = "";
        this.tableOption = parcel.readInt();
        String readString = parcel.readString();
        this.settingString = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.valueString = readString2 != null ? readString2 : "";
        this.valueType = parcel.readInt();
        this.useHelper = parcel.readInt() != 0;
    }

    /* compiled from: SystemSettingAction.kt */
    /* loaded from: classes2.dex */
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
