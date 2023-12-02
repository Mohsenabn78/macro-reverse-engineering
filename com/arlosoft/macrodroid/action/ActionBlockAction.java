package com.arlosoft.macrodroid.action;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ActionBlockActionInfo;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.actionblock.list.ActionBlockListActivity;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ParcelExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasVariableNames;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.interfaces.UsesActionBlocks;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.koushikdutta.ion.loader.MtpConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DispatchedCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActionBlockAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nActionBlockAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockAction.kt\ncom/arlosoft/macrodroid/action/ActionBlockAction\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 View.kt\nandroidx/core/view/ViewKt\n+ 6 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 7 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,597:1\n526#2:598\n511#2,6:599\n453#2:613\n403#2:614\n125#3:605\n152#3,3:606\n1855#4:609\n1855#4,2:610\n1856#4:612\n1238#4,2:615\n1549#4:617\n1620#4,3:618\n1241#4:621\n1855#4:624\n1549#4:625\n1620#4,3:626\n1856#4:629\n1855#4,2:632\n1549#4:634\n1620#4,3:635\n1864#4,3:640\n1549#4:643\n1620#4,3:644\n177#5,2:622\n177#5,2:630\n37#6,2:638\n37#6,2:647\n37#6,2:653\n11065#7:649\n11400#7,3:650\n*S KotlinDebug\n*F\n+ 1 ActionBlockAction.kt\ncom/arlosoft/macrodroid/action/ActionBlockAction\n*L\n91#1:598\n91#1:599,6\n188#1:613\n188#1:614\n91#1:605\n91#1:606,3\n180#1:609\n181#1:610,2\n180#1:612\n188#1:615,2\n190#1:617\n190#1:618,3\n188#1:621\n305#1:624\n315#1:625\n315#1:626,3\n305#1:629\n435#1:632,2\n517#1:634\n517#1:635,3\n522#1:640,3\n544#1:643\n544#1:644,3\n301#1:622,2\n431#1:630,2\n517#1:638,2\n544#1:647,2\n549#1:653,2\n549#1:649\n549#1:650,3\n*E\n"})
/* loaded from: classes2.dex */
public final class ActionBlockAction extends Action implements HasVariableNames, BlockingAction, SupportsMagicText, UsesActionBlocks {
    private static final int REQUEST_ID_PICK_ACTION_BLOCK = 66;
    public static final int SELECT_ACTION_BLOCK_REQUEST = 0;
    private long actionBlockId;
    @NotNull
    private String actionBlockName;
    private boolean continueActionsWithoutWaiting;
    @NotNull
    private Map<String, DictionaryKeys> inputDictionaryMap;
    @NotNull
    private Map<String, String> inputVarsMap;
    private transient boolean isEnabled;
    @NotNull
    private Map<String, DictionaryKeys> outputDictionaryMap;
    @NotNull
    private Map<String, String> outputVarsMap;
    @NotNull
    private transient Map<String, String> tempInputVarsMap;
    @NotNull
    private transient Map<String, DictionaryKeys> workingInputDictionaryMap;
    @NotNull
    private transient Map<String, String> workingInputVarsMap;
    @NotNull
    private transient Map<String, DictionaryKeys> workingOutputDictionaryMap;
    @NotNull
    private transient Map<String, String> workingOutputVarsMap;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ActionBlockAction> CREATOR = new Parcelable.Creator<ActionBlockAction>() { // from class: com.arlosoft.macrodroid.action.ActionBlockAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ActionBlockAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ActionBlockAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ActionBlockAction[] newArray(int i4) {
            return new ActionBlockAction[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockAction.kt */
    @SourceDebugExtension({"SMAP\nActionBlockAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockAction.kt\ncom/arlosoft/macrodroid/action/ActionBlockAction$displayConfigurationDialog$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,597:1\n1855#2,2:598\n1855#2,2:600\n*S KotlinDebug\n*F\n+ 1 ActionBlockAction.kt\ncom/arlosoft/macrodroid/action/ActionBlockAction$displayConfigurationDialog$1\n*L\n284#1:598,2\n287#1:600,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ List<Spinner> $inputVarBooleans;
        final /* synthetic */ List<EditText> $inputVarTexts;
        int label;
        final /* synthetic */ ActionBlockAction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List<EditText> list, List<Spinner> list2, Activity activity, AppCompatDialog appCompatDialog, ActionBlockAction actionBlockAction, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$inputVarTexts = list;
            this.$inputVarBooleans = list2;
            this.$activity = activity;
            this.$dialog = appCompatDialog;
            this.this$0 = actionBlockAction;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$inputVarTexts, this.$inputVarBooleans, this.$activity, this.$dialog, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            String str;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActionBlockAction actionBlockAction = this.this$0;
                for (EditText editText : this.$inputVarTexts) {
                    Map map = actionBlockAction.tempInputVarsMap;
                    Object tag = editText.getTag();
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
                    map.put((String) tag, editText.getText().toString());
                }
                ActionBlockAction actionBlockAction2 = this.this$0;
                for (Spinner spinner : this.$inputVarBooleans) {
                    Map map2 = actionBlockAction2.tempInputVarsMap;
                    Object tag2 = spinner.getTag();
                    Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type kotlin.String");
                    String str2 = (String) tag2;
                    if (spinner.getSelectedItemPosition() == 0) {
                        str = "true";
                    } else {
                        str = "false";
                    }
                    map2.put(str2, str);
                }
                ActionBlockListActivity.Companion companion = ActionBlockListActivity.Companion;
                Activity activity = this.$activity;
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                companion.launch(activity, true, 66);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockAction.kt */
    /* loaded from: classes2.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ MagicText.MagicTextListener $magicTextListener;
        final /* synthetic */ MacroDroidVariable $variable;
        int label;
        final /* synthetic */ ActionBlockAction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(MacroDroidVariable macroDroidVariable, Activity activity, MagicText.MagicTextListener magicTextListener, ActionBlockAction actionBlockAction, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$variable = macroDroidVariable;
            this.$activity = activity;
            this.$magicTextListener = magicTextListener;
            this.this$0 = actionBlockAction;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$variable, this.$activity, this.$magicTextListener, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$variable.getType() == 2) {
                    MagicText.displaySelectionDialog(this.$activity, this.$magicTextListener, this.this$0.getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, this.this$0.isChildOfIterateDictionary());
                } else {
                    MagicText.displayNumberVariableSelectionDialog(this.$activity, this.this$0.getMacro(), this.$magicTextListener, R.style.Theme_App_Dialog_Action_SmallText, this.this$0.isChildOfIterateDictionary(), false);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockAction.kt */
    @SourceDebugExtension({"SMAP\nActionBlockAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockAction.kt\ncom/arlosoft/macrodroid/action/ActionBlockAction$displayConfigurationDialog$4\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,597:1\n1855#2,2:598\n1855#2,2:600\n*S KotlinDebug\n*F\n+ 1 ActionBlockAction.kt\ncom/arlosoft/macrodroid/action/ActionBlockAction$displayConfigurationDialog$4\n*L\n467#1:598,2\n470#1:600,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ List<Spinner> $inputVarBooleans;
        final /* synthetic */ List<EditText> $inputVarTexts;
        final /* synthetic */ CheckBox $waitUntilComplete;
        int label;
        final /* synthetic */ ActionBlockAction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List<EditText> list, List<Spinner> list2, ActionBlockAction actionBlockAction, CheckBox checkBox, AppCompatDialog appCompatDialog, Continuation<? super c> continuation) {
            super(3, continuation);
            this.$inputVarTexts = list;
            this.$inputVarBooleans = list2;
            this.this$0 = actionBlockAction;
            this.$waitUntilComplete = checkBox;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(this.$inputVarTexts, this.$inputVarBooleans, this.this$0, this.$waitUntilComplete, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z3;
            Map mutableMap;
            Map mutableMap2;
            Map mutableMap3;
            Map mutableMap4;
            String str;
            boolean startsWith$default;
            boolean startsWith$default2;
            int indexOf$default;
            int indexOf$default2;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActionBlockAction actionBlockAction = this.this$0;
                Iterator<T> it = this.$inputVarTexts.iterator();
                while (true) {
                    z3 = false;
                    String str2 = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    EditText editText = (EditText) it.next();
                    Map map = actionBlockAction.workingInputVarsMap;
                    Object tag = editText.getTag();
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
                    String str3 = (String) tag;
                    Editable text = editText.getText();
                    Intrinsics.checkNotNullExpressionValue(text, "it.text");
                    if (text.length() > 0) {
                        z3 = true;
                    }
                    if (z3) {
                        str2 = editText.getText().toString();
                    }
                    map.put(str3, str2);
                }
                ActionBlockAction actionBlockAction2 = this.this$0;
                for (Spinner spinner : this.$inputVarBooleans) {
                    Map map2 = actionBlockAction2.workingInputVarsMap;
                    Object tag2 = spinner.getTag();
                    Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type kotlin.String");
                    String str4 = (String) tag2;
                    int selectedItemPosition = spinner.getSelectedItemPosition();
                    if (selectedItemPosition != 0) {
                        if (selectedItemPosition != 1) {
                            if (selectedItemPosition != 2) {
                                Object selectedItem = spinner.getSelectedItem();
                                Intrinsics.checkNotNull(selectedItem, "null cannot be cast to non-null type kotlin.String");
                                String str5 = (String) selectedItem;
                                startsWith$default = kotlin.text.m.startsWith$default(str5, "(" + actionBlockAction2.getContext().getString(R.string.variable_local) + ")", z3, 2, null);
                                if (startsWith$default) {
                                    indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str5, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, 0, false, 6, (Object) null);
                                    String substring = str5.substring(indexOf$default2 + 1);
                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                                    str = "[lv=" + substring + "]";
                                } else {
                                    startsWith$default2 = kotlin.text.m.startsWith$default(str5, "(" + actionBlockAction2.getContext().getString(R.string.variable_global) + ")", false, 2, null);
                                    if (startsWith$default2) {
                                        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str5, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, 0, false, 6, (Object) null);
                                        String substring2 = str5.substring(indexOf$default + 1);
                                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                                        str = "[v=" + substring2 + "]";
                                    } else {
                                        str = "";
                                    }
                                }
                            } else {
                                str = "false";
                            }
                        } else {
                            str = "true";
                        }
                    } else {
                        str = null;
                    }
                    map2.put(str4, str);
                    z3 = false;
                }
                ActionBlockAction actionBlockAction3 = this.this$0;
                mutableMap = kotlin.collections.s.toMutableMap(actionBlockAction3.workingInputVarsMap);
                actionBlockAction3.inputVarsMap = mutableMap;
                ActionBlockAction actionBlockAction4 = this.this$0;
                mutableMap2 = kotlin.collections.s.toMutableMap(actionBlockAction4.workingInputDictionaryMap);
                actionBlockAction4.inputDictionaryMap = mutableMap2;
                ActionBlockAction actionBlockAction5 = this.this$0;
                mutableMap3 = kotlin.collections.s.toMutableMap(actionBlockAction5.workingOutputVarsMap);
                actionBlockAction5.outputVarsMap = mutableMap3;
                ActionBlockAction actionBlockAction6 = this.this$0;
                mutableMap4 = kotlin.collections.s.toMutableMap(actionBlockAction6.workingOutputDictionaryMap);
                actionBlockAction6.outputDictionaryMap = mutableMap4;
                this.this$0.continueActionsWithoutWaiting = !this.$waitUntilComplete.isChecked();
                this.$dialog.dismiss();
                this.this$0.itemComplete();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockAction.kt */
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

    public /* synthetic */ ActionBlockAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void N(EditText editText, MacroDroidVariable macroDroidVariable) {
        int i4;
        int type = macroDroidVariable.getType();
        if (type != 1) {
            if (type != 3) {
                i4 = 524288;
            } else {
                i4 = MtpConstants.FORMAT_SCRIPT;
            }
        } else {
            i4 = InputDeviceCompat.SOURCE_TOUCHSCREEN;
        }
        editText.setInputType(i4);
    }

    @SuppressLint({"SetTextI18n"})
    private final void O() {
        Map<String, String> mutableMap;
        Map<String, DictionaryKeys> mutableMap2;
        Map<String, DictionaryKeys> mutableMap3;
        ArrayList arrayList;
        ArrayList arrayList2;
        Button button;
        Button button2;
        CheckBox checkBox;
        ArrayList arrayList3;
        AppCompatDialog appCompatDialog;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        List<MacroDroidVariable> list;
        LinearLayout linearLayout3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        String str;
        String str2;
        final MacroDroidVariable macroDroidVariable;
        String str3;
        MacroDroidVariable macroDroidVariable2;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int collectionSizeOrDefault;
        String str9;
        Object[] plus;
        String str10;
        boolean startsWith$default;
        int indexOf;
        int coerceAtLeast;
        boolean startsWith$default2;
        boolean startsWith$default3;
        int indexOf2;
        boolean startsWith$default4;
        String str11;
        int i4;
        ArrayList arrayList6;
        String str12;
        int i5;
        DispatchedCoroutine dispatchedCoroutine;
        AppCompatDialog appCompatDialog2;
        final ActionBlockAction actionBlockAction = this;
        if (!checkActivityAlive()) {
            return;
        }
        ActionBlock actionBlockByGuid = Q().getActionBlockByGuid(actionBlockAction.actionBlockId);
        String str13 = "activity";
        if (actionBlockByGuid != null) {
            mutableMap = kotlin.collections.s.toMutableMap(actionBlockAction.outputVarsMap);
            actionBlockAction.workingOutputVarsMap = mutableMap;
            mutableMap2 = kotlin.collections.s.toMutableMap(actionBlockAction.outputDictionaryMap);
            actionBlockAction.workingOutputDictionaryMap = mutableMap2;
            mutableMap3 = kotlin.collections.s.toMutableMap(actionBlockAction.inputDictionaryMap);
            actionBlockAction.workingInputDictionaryMap = mutableMap3;
            List<MacroDroidVariable> inputVars = actionBlockByGuid.getInputOnlyActionBlockVariables(false);
            List<MacroDroidVariable> outputOnlyActionBlockVariables = actionBlockByGuid.getOutputOnlyActionBlockVariables(false);
            Activity activity = getActivity();
            AppCompatDialog appCompatDialog3 = new AppCompatDialog(activity, getDialogTheme());
            appCompatDialog3.setContentView(R.layout.dialog_action_block_config);
            appCompatDialog3.setTitle(R.string.action_action_block);
            DialogExtensionsKt.setWidthToParent(appCompatDialog3, 0);
            Button button3 = (Button) appCompatDialog3.findViewById(R.id.actionBlockName);
            View findViewById = appCompatDialog3.findViewById(R.id.inputVarsContainer);
            Intrinsics.checkNotNull(findViewById);
            LinearLayout linearLayout4 = (LinearLayout) findViewById;
            View findViewById2 = appCompatDialog3.findViewById(R.id.outputVarsContainer);
            Intrinsics.checkNotNull(findViewById2);
            LinearLayout linearLayout5 = (LinearLayout) findViewById2;
            View findViewById3 = appCompatDialog3.findViewById(R.id.waitToCompleteCheckBox);
            Intrinsics.checkNotNull(findViewById3);
            CheckBox checkBox2 = (CheckBox) findViewById3;
            Button button4 = (Button) appCompatDialog3.findViewById(R.id.okButton);
            Button button5 = (Button) appCompatDialog3.findViewById(R.id.cancelButton);
            ArrayList arrayList7 = new ArrayList();
            ArrayList arrayList8 = new ArrayList();
            ArrayList arrayList9 = new ArrayList();
            checkBox2.setChecked(!actionBlockAction.continueActionsWithoutWaiting);
            if (button3 != null) {
                button3.setText(actionBlockAction.actionBlockName);
            }
            if (button3 != null) {
                arrayList = arrayList8;
                arrayList2 = arrayList7;
                button = button5;
                button2 = button4;
                checkBox = checkBox2;
                appCompatDialog = appCompatDialog3;
                linearLayout = linearLayout5;
                arrayList3 = arrayList9;
                linearLayout2 = linearLayout4;
                ViewExtensionsKt.onClick$default(button3, null, new a(arrayList7, arrayList, activity, appCompatDialog3, this, null), 1, null);
            } else {
                arrayList = arrayList8;
                arrayList2 = arrayList7;
                button = button5;
                button2 = button4;
                checkBox = checkBox2;
                arrayList3 = arrayList9;
                appCompatDialog = appCompatDialog3;
                linearLayout = linearLayout5;
                linearLayout2 = linearLayout4;
            }
            String str14 = "]";
            String str15 = "[";
            String str16 = ": ";
            String str17 = "context";
            if (inputVars.isEmpty()) {
                TextView textView = new TextView(getContext());
                textView.setText(R.string.none);
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.margin_medium);
                textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                textView.setTextColor(ContextCompat.getColor(getContext(), R.color.default_text_color));
                linearLayout2.addView(textView);
            } else {
                Intrinsics.checkNotNullExpressionValue(inputVars, "inputVars");
                for (final MacroDroidVariable variable : inputVars) {
                    if (variable.getType() == 0) {
                        View inflate = activity.getLayoutInflater().inflate(R.layout.view_action_block_input_variable_boolean, (ViewGroup) linearLayout2, false);
                        Spinner booleanSpinner = (Spinner) inflate.findViewById(R.id.variableBooleanSpinner);
                        Intrinsics.checkNotNullExpressionValue(booleanSpinner, "booleanSpinner");
                        ArrayList arrayList10 = arrayList;
                        arrayList10.add(booleanSpinner);
                        booleanSpinner.setTag(variable.getName());
                        String[] strArr = {getContext().getString(R.string.default_value), getContext().getString(R.string.true_label), getContext().getString(R.string.false_label)};
                        ArrayList<MacroDroidVariable> allBooleanVariables = getAllBooleanVariables();
                        Intrinsics.checkNotNullExpressionValue(allBooleanVariables, "allBooleanVariables");
                        linearLayout3 = linearLayout;
                        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(allBooleanVariables, 10);
                        ArrayList arrayList11 = new ArrayList(collectionSizeOrDefault);
                        Iterator it = allBooleanVariables.iterator();
                        while (true) {
                            list = outputOnlyActionBlockVariables;
                            str9 = str13;
                            if (!it.hasNext()) {
                                break;
                            }
                            MacroDroidVariable macroDroidVariable3 = (MacroDroidVariable) it.next();
                            Iterator it2 = it;
                            Context context = getContext();
                            if (macroDroidVariable3.isLocalVar()) {
                                str11 = str14;
                                i4 = R.string.variable_local;
                            } else {
                                str11 = str14;
                                i4 = R.string.variable_global;
                            }
                            arrayList11.add("(" + context.getString(i4) + ") " + macroDroidVariable3.getName());
                            outputOnlyActionBlockVariables = list;
                            str13 = str9;
                            it = it2;
                            str14 = str11;
                        }
                        String str18 = str14;
                        plus = ArraysKt___ArraysJvmKt.plus((Object[]) strArr, (Collection) arrayList11);
                        String[] strArr2 = (String[]) plus;
                        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), (int) R.layout.simple_spinner_item, strArr2);
                        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
                        booleanSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
                        String str19 = actionBlockAction.tempInputVarsMap.get(variable.getName());
                        if (str19 == null && (str19 = actionBlockAction.inputVarsMap.get(variable.getName())) == null) {
                            str19 = "";
                        }
                        if (Intrinsics.areEqual(str19, "true")) {
                            str10 = str15;
                            coerceAtLeast = 1;
                        } else if (Intrinsics.areEqual(str19, "false")) {
                            str10 = str15;
                            coerceAtLeast = 2;
                        } else {
                            str10 = str15;
                            startsWith$default = kotlin.text.m.startsWith$default(str19, "[lv=", false, 2, null);
                            if (!startsWith$default) {
                                startsWith$default2 = kotlin.text.m.startsWith$default(str19, "{lv=", false, 2, null);
                                if (!startsWith$default2) {
                                    startsWith$default3 = kotlin.text.m.startsWith$default(str19, "[v=", false, 2, null);
                                    if (!startsWith$default3) {
                                        startsWith$default4 = kotlin.text.m.startsWith$default(str19, "{v=", false, 2, null);
                                        if (!startsWith$default4) {
                                            coerceAtLeast = 0;
                                        }
                                    }
                                    String string = getContext().getString(R.string.variable_global);
                                    String substring = str19.substring(3, str19.length() - 1);
                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                                    indexOf2 = ArraysKt___ArraysKt.indexOf(strArr2, "(" + string + ") " + substring);
                                    coerceAtLeast = kotlin.ranges.h.coerceAtLeast(indexOf2, 0);
                                }
                            }
                            String string2 = getContext().getString(R.string.variable_local);
                            String substring2 = str19.substring(4, str19.length() - 1);
                            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                            indexOf = ArraysKt___ArraysKt.indexOf(strArr2, "(" + string2 + ") " + substring2);
                            coerceAtLeast = kotlin.ranges.h.coerceAtLeast(indexOf, 0);
                        }
                        booleanSpinner.setSelection(coerceAtLeast);
                        Context context2 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, str17);
                        ((TextView) inflate.findViewById(R.id.variableName)).setText(variable.getTypeAsString(context2) + str16 + variable.getName());
                        linearLayout2.addView(inflate);
                        str4 = str17;
                        str5 = str16;
                        arrayList4 = arrayList2;
                        arrayList5 = arrayList10;
                        str = str10;
                        str13 = str9;
                        str2 = str18;
                    } else {
                        String str20 = str13;
                        String str21 = str14;
                        list = outputOnlyActionBlockVariables;
                        linearLayout3 = linearLayout;
                        String str22 = str15;
                        ArrayList arrayList12 = arrayList;
                        if (variable.getType() != 4 && variable.getType() != 5) {
                            View inflate2 = activity.getLayoutInflater().inflate(R.layout.view_action_block_input_variable, (ViewGroup) linearLayout2, false);
                            final EditText inputEditText = (EditText) inflate2.findViewById(R.id.variableValue);
                            TextView textView2 = (TextView) inflate2.findViewById(R.id.variableName);
                            Button inputMagicTextButton = (Button) inflate2.findViewById(R.id.variableMagicTextButton);
                            inputEditText.setTag(variable.getName());
                            Intrinsics.checkNotNullExpressionValue(inputEditText, "inputEditText");
                            ArrayList arrayList13 = arrayList2;
                            arrayList13.add(inputEditText);
                            String str23 = actionBlockAction.tempInputVarsMap.get(variable.getName());
                            if (str23 == null && (str23 = actionBlockAction.inputVarsMap.get(variable.getName())) == null) {
                                str23 = "";
                            }
                            inputEditText.setText(str23);
                            Intrinsics.checkNotNullExpressionValue(variable, "variable");
                            actionBlockAction.N(inputEditText, variable);
                            MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.e
                                @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
                                public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                                    ActionBlockAction.P(inputEditText, magicTextPair);
                                }
                            };
                            if (inputMagicTextButton != null) {
                                Intrinsics.checkNotNullExpressionValue(inputMagicTextButton, "inputMagicTextButton");
                                str7 = str17;
                                str8 = str16;
                                arrayList4 = arrayList13;
                                arrayList5 = arrayList12;
                                ViewExtensionsKt.onClick$default(inputMagicTextButton, null, new b(variable, activity, magicTextListener, this, null), 1, null);
                            } else {
                                str7 = str17;
                                str8 = str16;
                                arrayList4 = arrayList13;
                                arrayList5 = arrayList12;
                            }
                            textView2.setText(String.valueOf(variable.getName()));
                            inputEditText.setHint("<" + SelectableItem.r(R.string.default_value) + ">");
                            linearLayout2.addView(inflate2);
                            str = str22;
                            str13 = str20;
                            str2 = str21;
                            str4 = str7;
                            str5 = str8;
                        } else {
                            String str24 = str17;
                            String str25 = str16;
                            arrayList4 = arrayList2;
                            arrayList5 = arrayList12;
                            View inflate3 = activity.getLayoutInflater().inflate(R.layout.view_action_block_input_variable_dictionary, (ViewGroup) linearLayout2, false);
                            Spinner spinner = (Spinner) inflate3.findViewById(R.id.variableDictionarySpinner);
                            ArrayList arrayList14 = new ArrayList();
                            String r4 = SelectableItem.r(R.string.output_variable_not_used);
                            StringBuilder sb = new StringBuilder();
                            str = str22;
                            sb.append(str);
                            sb.append(r4);
                            str2 = str21;
                            sb.append(str2);
                            arrayList14.add(sb.toString());
                            String str26 = actionBlockAction.inputVarsMap.get(variable.getName());
                            DictionaryKeys dictionaryKeys = actionBlockAction.inputDictionaryMap.get(variable.getName());
                            if (variable.getType() == 4) {
                                str13 = str20;
                                Intrinsics.checkNotNullExpressionValue(activity, str13);
                                Intrinsics.checkNotNullExpressionValue(spinner, "spinner");
                                Macro macro = getMacro();
                                if (str26 != null) {
                                    str6 = str26 + VariableHelper.getFormattedDictionaryKeys(dictionaryKeys);
                                } else {
                                    str6 = null;
                                }
                                macroDroidVariable = variable;
                                VariableHelper.configureDictionaryVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro, arrayList14, str6, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.ActionBlockAction$displayConfigurationDialog$2$1
                                    @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
                                    public void customItemSelected(int i6, @NotNull String value) {
                                        Intrinsics.checkNotNullParameter(value, "value");
                                        ActionBlockAction.this.workingInputVarsMap.put(variable.getName(), null);
                                        ActionBlockAction.this.workingInputDictionaryMap.put(variable.getName(), null);
                                    }

                                    @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
                                    public void variableSelected(@NotNull MacroDroidVariable selectedVar, @Nullable List<String> list2) {
                                        DictionaryKeys dictionaryKeys2;
                                        Intrinsics.checkNotNullParameter(selectedVar, "selectedVar");
                                        ActionBlockAction.this.workingInputVarsMap.put(variable.getName(), selectedVar.getName());
                                        Map map = ActionBlockAction.this.workingInputDictionaryMap;
                                        String name = variable.getName();
                                        if (list2 != null) {
                                            dictionaryKeys2 = new DictionaryKeys(list2);
                                        } else {
                                            dictionaryKeys2 = null;
                                        }
                                        map.put(name, dictionaryKeys2);
                                    }
                                });
                            } else {
                                macroDroidVariable = variable;
                                str13 = str20;
                                if (macroDroidVariable.getType() == 5) {
                                    Intrinsics.checkNotNullExpressionValue(activity, str13);
                                    Intrinsics.checkNotNullExpressionValue(spinner, "spinner");
                                    Macro macro2 = getMacro();
                                    if (str26 != null) {
                                        str3 = str26 + VariableHelper.getFormattedDictionaryKeys(dictionaryKeys);
                                    } else {
                                        str3 = null;
                                    }
                                    macroDroidVariable2 = macroDroidVariable;
                                    VariableHelper.configureArrayVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro2, arrayList14, str3, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.ActionBlockAction$displayConfigurationDialog$2$2
                                        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
                                        public void customItemSelected(int i6, @NotNull String value) {
                                            Intrinsics.checkNotNullParameter(value, "value");
                                            ActionBlockAction.this.workingInputVarsMap.put(macroDroidVariable.getName(), null);
                                            ActionBlockAction.this.workingInputDictionaryMap.put(macroDroidVariable.getName(), null);
                                        }

                                        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
                                        public void variableSelected(@NotNull MacroDroidVariable selectedVar, @Nullable List<String> list2) {
                                            DictionaryKeys dictionaryKeys2;
                                            Intrinsics.checkNotNullParameter(selectedVar, "selectedVar");
                                            ActionBlockAction.this.workingInputVarsMap.put(macroDroidVariable.getName(), selectedVar.getName());
                                            Map map = ActionBlockAction.this.workingInputDictionaryMap;
                                            String name = macroDroidVariable.getName();
                                            if (list2 != null) {
                                                dictionaryKeys2 = new DictionaryKeys(list2);
                                            } else {
                                                dictionaryKeys2 = null;
                                            }
                                            map.put(name, dictionaryKeys2);
                                        }
                                    });
                                    Context context3 = getContext();
                                    str4 = str24;
                                    Intrinsics.checkNotNullExpressionValue(context3, str4);
                                    String typeAsString = macroDroidVariable2.getTypeAsString(context3);
                                    String name = macroDroidVariable2.getName();
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(typeAsString);
                                    str5 = str25;
                                    sb2.append(str5);
                                    sb2.append(name);
                                    ((TextView) inflate3.findViewById(R.id.variableName)).setText(sb2.toString());
                                    linearLayout2.addView(inflate3);
                                    str17 = str4;
                                    str14 = str2;
                                    str16 = str5;
                                    arrayList = arrayList5;
                                    arrayList2 = arrayList4;
                                    linearLayout = linearLayout3;
                                    str15 = str;
                                    outputOnlyActionBlockVariables = list;
                                }
                            }
                            macroDroidVariable2 = macroDroidVariable;
                            Context context32 = getContext();
                            str4 = str24;
                            Intrinsics.checkNotNullExpressionValue(context32, str4);
                            String typeAsString2 = macroDroidVariable2.getTypeAsString(context32);
                            String name2 = macroDroidVariable2.getName();
                            StringBuilder sb22 = new StringBuilder();
                            sb22.append(typeAsString2);
                            str5 = str25;
                            sb22.append(str5);
                            sb22.append(name2);
                            ((TextView) inflate3.findViewById(R.id.variableName)).setText(sb22.toString());
                            linearLayout2.addView(inflate3);
                            str17 = str4;
                            str14 = str2;
                            str16 = str5;
                            arrayList = arrayList5;
                            arrayList2 = arrayList4;
                            linearLayout = linearLayout3;
                            str15 = str;
                            outputOnlyActionBlockVariables = list;
                        }
                    }
                    str17 = str4;
                    str14 = str2;
                    str16 = str5;
                    arrayList = arrayList5;
                    arrayList2 = arrayList4;
                    linearLayout = linearLayout3;
                    str15 = str;
                    outputOnlyActionBlockVariables = list;
                }
            }
            String str27 = str17;
            List<MacroDroidVariable> outputVars = outputOnlyActionBlockVariables;
            LinearLayout linearLayout6 = linearLayout;
            String str28 = str15;
            ArrayList arrayList15 = arrayList2;
            int i6 = R.id.variableName;
            String str29 = str16;
            String str30 = str14;
            ArrayList arrayList16 = arrayList;
            if (outputVars.isEmpty()) {
                TextView textView3 = new TextView(getContext());
                textView3.setText(R.string.none);
                int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.margin_medium);
                textView3.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
                textView3.setTextColor(ContextCompat.getColor(getContext(), R.color.default_text_color));
                linearLayout6.addView(textView3);
            } else {
                Intrinsics.checkNotNullExpressionValue(outputVars, "outputVars");
                for (final MacroDroidVariable macroDroidVariable4 : outputVars) {
                    View inflate4 = activity.getLayoutInflater().inflate(R.layout.view_action_block_output_variable, (ViewGroup) null);
                    TextView textView4 = (TextView) inflate4.findViewById(i6);
                    if (textView4 != null) {
                        Context context4 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context4, str27);
                        textView4.setText(macroDroidVariable4.getTypeAsString(context4) + str29 + macroDroidVariable4.getName());
                    }
                    Spinner variableSpinner = (Spinner) inflate4.findViewById(R.id.variableSpinner);
                    variableSpinner.setTag(macroDroidVariable4.getName());
                    ArrayList arrayList17 = new ArrayList();
                    arrayList17.add(str28 + SelectableItem.r(R.string.output_variable_not_used) + str30);
                    String str31 = actionBlockAction.outputVarsMap.get(macroDroidVariable4.getName());
                    DictionaryKeys dictionaryKeys2 = actionBlockAction.outputDictionaryMap.get(macroDroidVariable4.getName());
                    int type = macroDroidVariable4.getType();
                    Activity activity2 = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity2, "getActivity()");
                    Intrinsics.checkNotNullExpressionValue(variableSpinner, "variableSpinner");
                    Macro macro3 = getMacro();
                    if (str31 != null) {
                        arrayList6 = arrayList17;
                        str12 = str31 + VariableHelper.getFormattedDictionaryKeys(dictionaryKeys2);
                    } else {
                        arrayList6 = arrayList17;
                        str12 = null;
                    }
                    VariableHelper.configureVarSpinnerOfType(type, activity2, R.style.Theme_App_Dialog_Action, this, variableSpinner, macro3, arrayList6, str12, "", new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.ActionBlockAction$displayConfigurationDialog$3$1
                        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
                        public void customItemSelected(int i7, @NotNull String value) {
                            Intrinsics.checkNotNullParameter(value, "value");
                            ActionBlockAction.this.workingOutputVarsMap.put(macroDroidVariable4.getName(), null);
                            ActionBlockAction.this.workingOutputDictionaryMap.put(macroDroidVariable4.getName(), null);
                        }

                        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
                        public void variableSelected(@NotNull MacroDroidVariable variable2, @Nullable List<String> list2) {
                            DictionaryKeys dictionaryKeys3;
                            Intrinsics.checkNotNullParameter(variable2, "variable");
                            ActionBlockAction.this.workingOutputVarsMap.put(macroDroidVariable4.getName(), variable2.getName());
                            Map map = ActionBlockAction.this.workingOutputDictionaryMap;
                            String name3 = macroDroidVariable4.getName();
                            if (list2 != null) {
                                dictionaryKeys3 = new DictionaryKeys(list2);
                            } else {
                                dictionaryKeys3 = null;
                            }
                            map.put(name3, dictionaryKeys3);
                        }
                    });
                    linearLayout6.addView(inflate4);
                    arrayList3.add(variableSpinner);
                    str27 = str27;
                    str28 = str28;
                    i6 = R.id.variableName;
                    actionBlockAction = this;
                }
            }
            Button button6 = button2;
            if (button6 != null) {
                i5 = 1;
                dispatchedCoroutine = null;
                ViewExtensionsKt.onClick$default(button6, null, new c(arrayList15, arrayList16, this, checkBox, appCompatDialog, null), 1, null);
            } else {
                i5 = 1;
                dispatchedCoroutine = null;
            }
            Button button7 = button;
            if (button7 != null) {
                appCompatDialog2 = appCompatDialog;
                ViewExtensionsKt.onClick$default(button7, dispatchedCoroutine, new d(appCompatDialog2, dispatchedCoroutine), i5, dispatchedCoroutine);
            } else {
                appCompatDialog2 = appCompatDialog;
            }
            appCompatDialog2.show();
            return;
        }
        ActionBlockListActivity.Companion companion = ActionBlockListActivity.Companion;
        Activity activity3 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity3, "activity");
        companion.launch(activity3, true, 66);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(EditText editText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNull(editText);
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        editText.setInputType(1);
        Editable text = editText.getText();
        if (text != null) {
            int min = Math.min(max, max2);
            int max3 = Math.max(max, max2);
            String str = magicTextPair.magicText;
            text.replace(min, max3, str, 0, str.length());
        }
    }

    private final ActionBlockStore Q() {
        MacroStore macroStore = MacroStore.getInstance();
        Intrinsics.checkNotNullExpressionValue(macroStore, "getInstance()");
        return macroStore;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    protected void doDisable() {
        if (this.isEnabled) {
            this.isEnabled = false;
            ActionBlock actionBlockByGuid = Q().getActionBlockByGuid(this.actionBlockId);
            if (actionBlockByGuid == null) {
                return;
            }
            Iterator<Action> it = actionBlockByGuid.getActions().iterator();
            while (it.hasNext()) {
                Action next = it.next();
                for (Constraint constraint : next.getConstraints()) {
                    if (constraint.isEnabled()) {
                        constraint.disableConstraintCheckingThreadSafe();
                    }
                }
                next.disableActionThreadSafe();
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    protected void doEnable() {
        if (!this.isEnabled) {
            this.isEnabled = true;
            ActionBlock actionBlockByGuid = Q().getActionBlockByGuid(this.actionBlockId);
            if (actionBlockByGuid == null) {
                return;
            }
            Iterator<Action> it = actionBlockByGuid.getActions().iterator();
            while (it.hasNext()) {
                Action next = it.next();
                for (Constraint constraint : next.getConstraints()) {
                    if (constraint.isEnabled()) {
                        constraint.checkAllPermissions();
                        constraint.enableConstraintCheckingThreadSafe();
                    }
                }
                next.checkAllPermissions();
                next.enableActionThreadSafe();
            }
        }
    }

    public final long getActionBlockId() {
        return this.actionBlockId;
    }

    @NotNull
    public final String getActionBlockName() {
        return this.actionBlockName;
    }

    @Override // com.arlosoft.macrodroid.interfaces.UsesActionBlocks
    @NotNull
    public List<String> getActionBlockNames() {
        List<String> listOf;
        listOf = kotlin.collections.e.listOf(this.actionBlockName);
        return listOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a0, code lost:
        r0 = "";
     */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getExtendedDetail() {
        /*
            r14 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r14.inputVarsMap     // Catch: java.lang.Exception -> Lde
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap     // Catch: java.lang.Exception -> Lde
            r1.<init>()     // Catch: java.lang.Exception -> Lde
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Exception -> Lde
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> Lde
        Lf:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Exception -> Lde
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3b
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Exception -> Lde
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch: java.lang.Exception -> Lde
            java.lang.Object r5 = r2.getKey()     // Catch: java.lang.Exception -> Lde
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> Lde
            java.lang.Object r5 = r2.getValue()     // Catch: java.lang.Exception -> Lde
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> Lde
            if (r5 == 0) goto L2c
            goto L2d
        L2c:
            r3 = 0
        L2d:
            if (r3 == 0) goto Lf
            java.lang.Object r3 = r2.getKey()     // Catch: java.lang.Exception -> Lde
            java.lang.Object r2 = r2.getValue()     // Catch: java.lang.Exception -> Lde
            r1.put(r3, r2)     // Catch: java.lang.Exception -> Lde
            goto Lf
        L3b:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Exception -> Lde
            int r0 = r1.size()     // Catch: java.lang.Exception -> Lde
            r5.<init>(r0)     // Catch: java.lang.Exception -> Lde
            java.util.Set r0 = r1.entrySet()     // Catch: java.lang.Exception -> Lde
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> Lde
        L4c:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> Lde
            if (r1 == 0) goto L7c
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> Lde
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Exception -> Lde
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Exception -> Lde
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> Lde
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Exception -> Lde
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> Lde
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lde
            r6.<init>()     // Catch: java.lang.Exception -> Lde
            r6.append(r2)     // Catch: java.lang.Exception -> Lde
            java.lang.String r2 = " = "
            r6.append(r2)     // Catch: java.lang.Exception -> Lde
            r6.append(r1)     // Catch: java.lang.Exception -> Lde
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Exception -> Lde
            r5.add(r1)     // Catch: java.lang.Exception -> Lde
            goto L4c
        L7c:
            java.lang.String r6 = ", "
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 62
            r13 = 0
            java.lang.String r0 = kotlin.collections.CollectionsKt.joinToString$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Exception -> Lde
            long r1 = r14.actionBlockId     // Catch: java.lang.Exception -> Lde
            r5 = 0
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto Ldb
            java.lang.String r5 = r14.actionBlockName     // Catch: java.lang.Exception -> Lde
            if (r0 == 0) goto L9e
            int r6 = r0.length()     // Catch: java.lang.Exception -> Lde
            if (r6 != 0) goto L9d
            goto L9e
        L9d:
            r3 = 0
        L9e:
            if (r3 == 0) goto La3
            java.lang.String r0 = ""
            goto Lb9
        La3:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lde
            r3.<init>()     // Catch: java.lang.Exception -> Lde
            java.lang.String r4 = " ("
            r3.append(r4)     // Catch: java.lang.Exception -> Lde
            r3.append(r0)     // Catch: java.lang.Exception -> Lde
            java.lang.String r0 = ")"
            r3.append(r0)     // Catch: java.lang.Exception -> Lde
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Exception -> Lde
        Lb9:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lde
            r3.<init>()     // Catch: java.lang.Exception -> Lde
            java.lang.String r4 = "<a href=\"macrodroid://www.macrodroid.com/actionblock/"
            r3.append(r4)     // Catch: java.lang.Exception -> Lde
            r3.append(r1)     // Catch: java.lang.Exception -> Lde
            java.lang.String r1 = "\">"
            r3.append(r1)     // Catch: java.lang.Exception -> Lde
            r3.append(r5)     // Catch: java.lang.Exception -> Lde
            java.lang.String r1 = "</a>"
            r3.append(r1)     // Catch: java.lang.Exception -> Lde
            r3.append(r0)     // Catch: java.lang.Exception -> Lde
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Exception -> Lde
            goto Le0
        Ldb:
            java.lang.String r0 = r14.actionBlockName     // Catch: java.lang.Exception -> Lde
            goto Le0
        Lde:
            java.lang.String r0 = r14.actionBlockName
        Le0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.ActionBlockAction.getExtendedDetail():java.lang.String");
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return ActionBlockActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String name = getName();
        String str = this.actionBlockName;
        return name + " (" + str + ")";
    }

    @NotNull
    public final Map<String, DictionaryKeys> getOutputDictionaryMap() {
        return this.outputDictionaryMap;
    }

    @NotNull
    public final Map<String, String> getOutputVarsMap() {
        return this.outputVarsMap;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        int collectionSizeOrDefault;
        Collection<String> values = this.inputVarsMap.values();
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(values, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str : values) {
            if (str == null) {
                str = "";
            }
            arrayList.add(str);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public String[] getVariableNames() {
        int collectionSizeOrDefault;
        Set<String> keySet = this.outputVarsMap.keySet();
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(keySet, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str : keySet) {
            arrayList.add(this.outputVarsMap.get(str));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public Integer[] getVariableTypes() {
        int i4;
        String[] variableNames = getVariableNames();
        ArrayList arrayList = new ArrayList(variableNames.length);
        for (String str : variableNames) {
            MacroDroidVariable variableByName = getVariableByName(str);
            if (variableByName != null) {
                i4 = variableByName.getType();
            } else {
                i4 = 2;
            }
            arrayList.add(Integer.valueOf(i4));
        }
        return (Integer[]) arrayList.toArray(new Integer[0]);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(@NotNull Activity activity, int i4, int i5, @Nullable Intent intent) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        setActivity(activity);
        if (i4 == 66 && i5 == -1) {
            long j4 = this.actionBlockId;
            long j5 = 0;
            if (intent != null) {
                j5 = intent.getLongExtra(Constants.EXTRA_ACTION_BLOCK_GUID, 0L);
            }
            this.actionBlockId = j5;
            if (j5 != j4) {
                this.tempInputVarsMap.clear();
            }
            if (intent != null) {
                str = intent.getStringExtra(Constants.EXTRA_ACTION_BLOCK_NAME);
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            this.actionBlockName = str;
            O();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        this.tempInputVarsMap.clear();
        if (this.actionBlockId == 0) {
            ActionBlockListActivity.Companion companion = ActionBlockListActivity.Companion;
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            companion.launch(activity, true, 66);
            return;
        }
        O();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isExtendedHtml() {
        return true;
    }

    public final void setActionBlockId(long j4) {
        this.actionBlockId = j4;
    }

    public final void setActionBlockName(@NotNull String actionBlockName) {
        Intrinsics.checkNotNullParameter(actionBlockName, "actionBlockName");
        this.actionBlockName = actionBlockName;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        boolean z3;
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        try {
            int i4 = 0;
            for (Object obj : this.inputVarsMap.keySet()) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                String str = (String) obj;
                String str2 = magicText[i4];
                Map<String, String> map = this.inputVarsMap;
                if (str2.length() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    str2 = null;
                }
                map.put(str, str2);
                i4 = i5;
            }
        } catch (Exception e4) {
            SystemLog.logError("Failed to set magic text on action block: " + e4);
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    public void setVariableNames(@NotNull String[] varNames) {
        Intrinsics.checkNotNullParameter(varNames, "varNames");
        if (varNames.length == this.outputVarsMap.size()) {
            int i4 = 0;
            for (String str : this.outputVarsMap.keySet()) {
                this.outputVarsMap.put(str, varNames[i4]);
                i4++;
            }
            return;
        }
        SystemLog.logError("Error when renaming variables in action block unexpected length.");
    }

    public final void updateVarName(@NotNull String oldName, @NotNull String newName) {
        Intrinsics.checkNotNullParameter(oldName, "oldName");
        Intrinsics.checkNotNullParameter(newName, "newName");
        String str = this.inputVarsMap.get(oldName);
        if (str != null) {
            this.inputVarsMap.remove(oldName);
            this.inputVarsMap.put(newName, str);
        }
        String str2 = this.outputVarsMap.get(oldName);
        if (str2 != null) {
            this.outputVarsMap.remove(oldName);
            this.outputVarsMap.put(newName, str2);
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeLong(this.actionBlockId);
        out.writeString(this.actionBlockName);
        ParcelExtensionsKt.writeStringMap(out, this.inputVarsMap);
        ParcelExtensionsKt.writeStringMap(out, this.outputVarsMap);
        out.writeInt(this.continueActionsWithoutWaiting ? 1 : 0);
    }

    public ActionBlockAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        setMacro(macro);
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        int mapCapacity;
        DictionaryKeys dictionaryKeys;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        try {
            ActionBlock actionBlockByGuid = Q().getActionBlockByGuid(this.actionBlockId);
            ActionBlock cloneActionBlock$default = actionBlockByGuid != null ? ActionBlock.cloneActionBlock$default(actionBlockByGuid, false, false, 2, null) : null;
            if (cloneActionBlock$default != null) {
                ArrayList<Action> actions = cloneActionBlock$default.getActions();
                Intrinsics.checkNotNullExpressionValue(actions, "actionBlockInstance.actions");
                for (Action action : actions) {
                    List<Constraint> constraints = action.getConstraints();
                    Intrinsics.checkNotNullExpressionValue(constraints, "action.constraints");
                    for (Constraint constraint : constraints) {
                        constraint.enableConstraintCheckingThreadSafe(true);
                    }
                }
                cloneActionBlock$default.setIsClonedInstance(true);
                Q().addActionBlock(cloneActionBlock$default);
                cloneActionBlock$default.setActionThatInvoked(this);
                Map<String, DictionaryKeys> map = this.inputDictionaryMap;
                mapCapacity = kotlin.collections.r.mapCapacity(map.size());
                LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
                for (Object obj : map.entrySet()) {
                    try {
                        Object key = ((Map.Entry) obj).getKey();
                        DictionaryKeys dictionaryKeys2 = (DictionaryKeys) ((Map.Entry) obj).getValue();
                        if (dictionaryKeys2 != null) {
                            List<String> keys = dictionaryKeys2.getKeys();
                            collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(keys, 10);
                            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                            for (String str : keys) {
                                arrayList.add(MagicText.replaceMagicText(getContext(), str, triggerContextInfo, false, getMacro()));
                            }
                            dictionaryKeys = new DictionaryKeys(arrayList);
                        } else {
                            dictionaryKeys = null;
                        }
                        linkedHashMap.put(key, dictionaryKeys);
                    } catch (Exception unused) {
                        Long macroGuid = getMacroGuid();
                        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                        SystemLog.logError("Failed to run action block: " + this.actionBlockName, macroGuid.longValue());
                        if (z4) {
                            return;
                        }
                        getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo);
                        return;
                    }
                }
                if (!z4 && !this.continueActionsWithoutWaiting) {
                    Macro macro = getMacro();
                    cloneActionBlock$default.invokeActions(triggerContextInfo, true, new ResumeMacroInfo(macro != null ? macro.getGUID() : 0L, i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo, null, 64, null), this.inputVarsMap, (Map<String, DictionaryKeys>) linkedHashMap, getMacro());
                } else {
                    Macro macro2 = getMacro();
                    cloneActionBlock$default.invokeActions(triggerContextInfo, true, new ResumeMacroInfo(macro2 != null ? macro2.getGUID() : 0L, 99999999, triggerContextInfo, z3, new Stack(), null, null, 64, null), this.inputVarsMap, (Map<String, DictionaryKeys>) linkedHashMap, getMacro());
                }
                if (!this.continueActionsWithoutWaiting || z4) {
                    return;
                }
                getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo);
                return;
            }
            Long macroGuid2 = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
            SystemLog.logError("Failed to find action block: " + this.actionBlockName, macroGuid2.longValue());
            if (z4) {
                return;
            }
            getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo);
        } catch (Exception unused2) {
        }
    }

    public ActionBlockAction() {
        this.actionBlockName = "";
        this.inputVarsMap = new LinkedHashMap();
        this.inputDictionaryMap = new LinkedHashMap();
        this.outputVarsMap = new LinkedHashMap();
        this.outputDictionaryMap = new LinkedHashMap();
        this.tempInputVarsMap = new LinkedHashMap();
        this.workingInputVarsMap = new LinkedHashMap();
        this.workingOutputVarsMap = new LinkedHashMap();
        this.workingInputDictionaryMap = new LinkedHashMap();
        this.workingOutputDictionaryMap = new LinkedHashMap();
    }

    private ActionBlockAction(Parcel parcel) {
        super(parcel);
        Map<String, String> mutableMap;
        Map<String, String> mutableMap2;
        this.actionBlockName = "";
        this.inputVarsMap = new LinkedHashMap();
        this.inputDictionaryMap = new LinkedHashMap();
        this.outputVarsMap = new LinkedHashMap();
        this.outputDictionaryMap = new LinkedHashMap();
        this.tempInputVarsMap = new LinkedHashMap();
        this.workingInputVarsMap = new LinkedHashMap();
        this.workingOutputVarsMap = new LinkedHashMap();
        this.workingInputDictionaryMap = new LinkedHashMap();
        this.workingOutputDictionaryMap = new LinkedHashMap();
        this.actionBlockId = parcel.readLong();
        String readString = parcel.readString();
        this.actionBlockName = readString != null ? readString : "";
        mutableMap = kotlin.collections.s.toMutableMap(ParcelExtensionsKt.readStringMap(parcel));
        this.inputVarsMap = mutableMap;
        mutableMap2 = kotlin.collections.s.toMutableMap(ParcelExtensionsKt.readStringMap(parcel));
        this.outputVarsMap = mutableMap2;
        this.continueActionsWithoutWaiting = parcel.readInt() != 0;
    }

    /* compiled from: ActionBlockAction.kt */
    /* loaded from: classes2.dex */
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
