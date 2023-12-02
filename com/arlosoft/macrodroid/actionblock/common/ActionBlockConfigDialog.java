package com.arlosoft.macrodroid.actionblock.common;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.f;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.h;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.m;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DispatchedCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActionBlockConfigDialog.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nActionBlockConfigDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockConfigDialog.kt\ncom/arlosoft/macrodroid/actionblock/common/ActionBlockConfigDialog\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,264:1\n262#2,2:265\n262#2,2:267\n177#2,2:269\n177#2,2:277\n1855#3:271\n1549#3:272\n1620#3,3:273\n1856#3:276\n1855#3,2:279\n*S KotlinDebug\n*F\n+ 1 ActionBlockConfigDialog.kt\ncom/arlosoft/macrodroid/actionblock/common/ActionBlockConfigDialog\n*L\n53#1:265,2\n54#1:267,2\n63#1:269,2\n157#1:277,2\n68#1:271\n76#1:272\n76#1:273,3\n68#1:276\n161#1:279,2\n*E\n"})
/* loaded from: classes.dex */
public final class ActionBlockConfigDialog {
    public static final int $stable = 0;
    @NotNull
    public static final ActionBlockConfigDialog INSTANCE = new ActionBlockConfigDialog();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockConfigDialog.kt */
    /* loaded from: classes.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ MagicText.MagicTextListener $magicTextListener;
        final /* synthetic */ SelectableItem $selectableItem;
        final /* synthetic */ MacroDroidVariable $variable;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(MacroDroidVariable macroDroidVariable, Activity activity, MagicText.MagicTextListener magicTextListener, SelectableItem selectableItem, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$variable = macroDroidVariable;
            this.$activity = activity;
            this.$magicTextListener = magicTextListener;
            this.$selectableItem = selectableItem;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$variable, this.$activity, this.$magicTextListener, this.$selectableItem, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Macro macro = null;
                if (this.$variable.getType() == 2) {
                    Activity activity = this.$activity;
                    MagicText.MagicTextListener magicTextListener = this.$magicTextListener;
                    SelectableItem selectableItem = this.$selectableItem;
                    if (selectableItem != null) {
                        macro = selectableItem.getMacro();
                    }
                    MagicText.displaySelectionDialog(activity, magicTextListener, macro, true, true, true, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
                } else {
                    Activity activity2 = this.$activity;
                    SelectableItem selectableItem2 = this.$selectableItem;
                    if (selectableItem2 != null) {
                        macro = selectableItem2.getMacro();
                    }
                    MagicText.displayNumberVariableSelectionDialog(activity2, macro, this.$magicTextListener, R.style.Theme_App_Dialog_Action_SmallText, null, false);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockConfigDialog.kt */
    @SourceDebugExtension({"SMAP\nActionBlockConfigDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockConfigDialog.kt\ncom/arlosoft/macrodroid/actionblock/common/ActionBlockConfigDialog$displayConfigurationDialog$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,264:1\n1855#2,2:265\n1855#2,2:267\n1855#2,2:269\n1855#2,2:271\n*S KotlinDebug\n*F\n+ 1 ActionBlockConfigDialog.kt\ncom/arlosoft/macrodroid/actionblock/common/ActionBlockConfigDialog$displayConfigurationDialog$3\n*L\n196#1:265,2\n199#1:267,2\n202#1:269,2\n223#1:271,2\n*E\n"})
    /* loaded from: classes.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ActionBlockData, Unit> $actionBlockDataConfigured;
        final /* synthetic */ ActionBlockData $actionBlockDataReturn;
        final /* synthetic */ Activity $activity;
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ List<Spinner> $inputVarBooleans;
        final /* synthetic */ List<EditText> $inputVarTexts;
        final /* synthetic */ List<Spinner> $outputVarSpinners;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(List<EditText> list, List<Spinner> list2, List<Spinner> list3, AppCompatDialog appCompatDialog, Function1<? super ActionBlockData, Unit> function1, ActionBlockData actionBlockData, Activity activity, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$inputVarTexts = list;
            this.$inputVarBooleans = list2;
            this.$outputVarSpinners = list3;
            this.$dialog = appCompatDialog;
            this.$actionBlockDataConfigured = function1;
            this.$actionBlockDataReturn = actionBlockData;
            this.$activity = activity;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$inputVarTexts, this.$inputVarBooleans, this.$outputVarSpinners, this.$dialog, this.$actionBlockDataConfigured, this.$actionBlockDataReturn, this.$activity, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z3;
            int i4;
            String str;
            boolean startsWith$default;
            boolean startsWith$default2;
            int indexOf$default;
            int indexOf$default2;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActionBlockData actionBlockData = this.$actionBlockDataReturn;
                for (EditText editText : this.$inputVarTexts) {
                    HashMap<String, String> inputVarsMap = actionBlockData.getInputVarsMap();
                    Object tag = editText.getTag();
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
                    inputVarsMap.put((String) tag, editText.getText().toString());
                }
                ActionBlockData actionBlockData2 = this.$actionBlockDataReturn;
                Iterator<T> it = this.$inputVarTexts.iterator();
                while (true) {
                    z3 = false;
                    i4 = 1;
                    String str2 = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    EditText editText2 = (EditText) it.next();
                    HashMap<String, String> inputVarsMap2 = actionBlockData2.getInputVarsMap();
                    Object tag2 = editText2.getTag();
                    Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type kotlin.String");
                    String str3 = (String) tag2;
                    Editable text = editText2.getText();
                    Intrinsics.checkNotNullExpressionValue(text, "it.text");
                    if (text.length() > 0) {
                        z3 = true;
                    }
                    if (z3) {
                        str2 = editText2.getText().toString();
                    }
                    inputVarsMap2.put(str3, str2);
                }
                ActionBlockData actionBlockData3 = this.$actionBlockDataReturn;
                Activity activity = this.$activity;
                for (Spinner spinner : this.$inputVarBooleans) {
                    HashMap<String, String> inputVarsMap3 = actionBlockData3.getInputVarsMap();
                    Object tag3 = spinner.getTag();
                    Intrinsics.checkNotNull(tag3, "null cannot be cast to non-null type kotlin.String");
                    String str4 = (String) tag3;
                    int selectedItemPosition = spinner.getSelectedItemPosition();
                    if (selectedItemPosition != 0) {
                        if (selectedItemPosition != i4) {
                            if (selectedItemPosition != 2) {
                                Object selectedItem = spinner.getSelectedItem();
                                Intrinsics.checkNotNull(selectedItem, "null cannot be cast to non-null type kotlin.String");
                                String str5 = (String) selectedItem;
                                startsWith$default = m.startsWith$default(str5, "(" + activity.getString(R.string.variable_local) + ")", z3, 2, null);
                                if (startsWith$default) {
                                    indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str5, MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, 0, false, 6, (Object) null);
                                    String substring = str5.substring(indexOf$default2 + i4);
                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                                    str = "[lv=" + substring + "]";
                                } else {
                                    startsWith$default2 = m.startsWith$default(str5, "(" + activity.getString(R.string.variable_global) + ")", false, 2, null);
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
                    inputVarsMap3.put(str4, str);
                    z3 = false;
                    i4 = 1;
                }
                ActionBlockData actionBlockData4 = this.$actionBlockDataReturn;
                Activity activity2 = this.$activity;
                for (Spinner spinner2 : this.$outputVarSpinners) {
                    String obj2 = spinner2.getSelectedItem().toString();
                    HashMap<String, String> outputVarsMap = actionBlockData4.getOutputVarsMap();
                    Object tag4 = spinner2.getTag();
                    Intrinsics.checkNotNull(tag4, "null cannot be cast to non-null type kotlin.String");
                    String str6 = (String) tag4;
                    if (Intrinsics.areEqual(obj2, activity2.getString(R.string.trigger_variable_no_variables)) || Intrinsics.areEqual(obj2, activity2.getString(R.string.output_variable_not_used))) {
                        obj2 = null;
                    }
                    outputVarsMap.put(str6, obj2);
                }
                this.$dialog.dismiss();
                this.$actionBlockDataConfigured.invoke(this.$actionBlockDataReturn);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockConfigDialog.kt */
    /* loaded from: classes.dex */
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

    private ActionBlockConfigDialog() {
    }

    private final void b(EditText editText, MacroDroidVariable macroDroidVariable) {
        int i4;
        int type = macroDroidVariable.getType();
        if (type != 1) {
            if (type != 3) {
                i4 = 524288;
            } else {
                i4 = 8194;
            }
        } else {
            i4 = 2;
        }
        editText.setInputType(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EditText editText, MagicText.MagicTextPair magicTextPair) {
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

    private final List<MacroDroidVariable> d(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        List<MacroDroidVariable> allDecimalVariables = MacroDroidVariableStore.getInstance().getAllDecimalVariables();
                        Intrinsics.checkNotNullExpressionValue(allDecimalVariables, "getInstance().allDecimalVariables");
                        return allDecimalVariables;
                    }
                    List<MacroDroidVariable> allDecimalVariables2 = MacroDroidVariableStore.getInstance().getAllDecimalVariables();
                    Intrinsics.checkNotNullExpressionValue(allDecimalVariables2, "getInstance().allDecimalVariables");
                    return allDecimalVariables2;
                }
                List<MacroDroidVariable> allStringVariables = MacroDroidVariableStore.getInstance().getAllStringVariables();
                Intrinsics.checkNotNullExpressionValue(allStringVariables, "getInstance().allStringVariables");
                return allStringVariables;
            }
            List<MacroDroidVariable> allIntegerVariables = MacroDroidVariableStore.getInstance().getAllIntegerVariables();
            Intrinsics.checkNotNullExpressionValue(allIntegerVariables, "getInstance().allIntegerVariables");
            return allIntegerVariables;
        }
        List<MacroDroidVariable> allBooleanVariables = MacroDroidVariableStore.getInstance().getAllBooleanVariables();
        Intrinsics.checkNotNullExpressionValue(allBooleanVariables, "getInstance().allBooleanVariables");
        return allBooleanVariables;
    }

    @JvmStatic
    @SuppressLint({"SetTextI18n"})
    public static final void displayConfigurationDialog(@NotNull Activity activity, @NotNull ActionBlock actionBlock, @NotNull ActionBlockData actionBlockData, @Nullable SelectableItem selectableItem, @NotNull Function1<? super ActionBlockData, Unit> actionBlockDataConfigured) {
        ArrayList arrayList;
        ActionBlockData actionBlockData2;
        List<MacroDroidVariable> list;
        AppCompatDialog appCompatDialog;
        LinearLayout linearLayout;
        Button button;
        Button button2;
        MacroDroidVariable macroDroidVariable;
        ArrayList arrayList2;
        String str;
        ArrayList arrayList3;
        ArrayList arrayList4;
        List emptyList;
        List list2;
        Object[] plus;
        ArrayList arrayList5;
        boolean startsWith$default;
        int indexOf;
        int coerceAtLeast;
        boolean startsWith$default2;
        boolean startsWith$default3;
        int indexOf2;
        boolean startsWith$default4;
        ArrayList<MacroDroidVariable> allBooleanVariables;
        int collectionSizeOrDefault;
        Iterator it;
        int i4;
        List<MacroDroidVariable> d4;
        int i5;
        DispatchedCoroutine dispatchedCoroutine;
        AppCompatDialog appCompatDialog2;
        SelectableItem selectableItem2 = selectableItem;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        Intrinsics.checkNotNullParameter(actionBlockData, "actionBlockData");
        Intrinsics.checkNotNullParameter(actionBlockDataConfigured, "actionBlockDataConfigured");
        ActionBlockData copy$default = ActionBlockData.copy$default(actionBlockData, null, 0L, null, null, 15, null);
        List<MacroDroidVariable> inputVars = actionBlock.getInputOnlyActionBlockVariables(false);
        List<MacroDroidVariable> outputOnlyActionBlockVariables = actionBlock.getOutputOnlyActionBlockVariables(false);
        AppCompatDialog appCompatDialog3 = new AppCompatDialog(activity, R.style.Theme_App_Dialog_Action);
        appCompatDialog3.setContentView(R.layout.dialog_action_block_config);
        appCompatDialog3.setTitle(actionBlock.getName());
        DialogExtensionsKt.setWidthToParent(appCompatDialog3, 0);
        Button button3 = (Button) appCompatDialog3.findViewById(R.id.actionBlockName);
        View findViewById = appCompatDialog3.findViewById(R.id.inputVarsContainer);
        Intrinsics.checkNotNull(findViewById);
        ViewGroup viewGroup = (LinearLayout) findViewById;
        View findViewById2 = appCompatDialog3.findViewById(R.id.outputVarsContainer);
        Intrinsics.checkNotNull(findViewById2);
        LinearLayout linearLayout2 = (LinearLayout) findViewById2;
        Button button4 = (Button) appCompatDialog3.findViewById(R.id.okButton);
        Button button5 = (Button) appCompatDialog3.findViewById(R.id.cancelButton);
        View findViewById3 = appCompatDialog3.findViewById(R.id.waitToCompleteCheckBox);
        Intrinsics.checkNotNull(findViewById3);
        ((CheckBox) findViewById3).setVisibility(8);
        if (button3 != null) {
            button3.setVisibility(8);
        }
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        String str2 = ": ";
        if (inputVars.isEmpty()) {
            TextView textView = new TextView(activity);
            textView.setText(R.string.none);
            arrayList = arrayList8;
            int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.margin_medium);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            textView.setTextColor(ContextCompat.getColor(activity, R.color.default_text_color));
            textView.setTextColor(ContextCompat.getColor(activity, R.color.default_text_color));
            viewGroup.addView(textView);
        } else {
            arrayList = arrayList8;
            Intrinsics.checkNotNullExpressionValue(inputVars, "inputVars");
            Iterator it2 = inputVars.iterator();
            while (it2.hasNext()) {
                MacroDroidVariable variable = (MacroDroidVariable) it2.next();
                String str3 = "";
                Iterator it3 = it2;
                if (variable.getType() == 0) {
                    View inflate = activity.getLayoutInflater().inflate(R.layout.view_action_block_input_variable_boolean, viewGroup, false);
                    Spinner booleanSpinner = (Spinner) inflate.findViewById(R.id.variableBooleanSpinner);
                    button2 = button5;
                    actionBlockData2 = copy$default;
                    String[] strArr = {activity.getString(R.string.default_value), activity.getString(R.string.true_label), activity.getString(R.string.false_label)};
                    appCompatDialog = appCompatDialog3;
                    if (selectableItem2 != null && (allBooleanVariables = selectableItem.getAllBooleanVariables()) != null) {
                        button = button4;
                        collectionSizeOrDefault = f.collectionSizeOrDefault(allBooleanVariables, 10);
                        list2 = new ArrayList(collectionSizeOrDefault);
                        Iterator it4 = allBooleanVariables.iterator();
                        while (it4.hasNext()) {
                            MacroDroidVariable macroDroidVariable2 = (MacroDroidVariable) it4.next();
                            if (macroDroidVariable2.isLocalVar()) {
                                it = it4;
                                i4 = R.string.variable_local;
                            } else {
                                it = it4;
                                i4 = R.string.variable_global;
                            }
                            String string = activity.getString(i4);
                            String name = macroDroidVariable2.getName();
                            LinearLayout linearLayout3 = linearLayout2;
                            list2.add("(" + string + ") " + name);
                            it4 = it;
                            linearLayout2 = linearLayout3;
                        }
                        linearLayout = linearLayout2;
                    } else {
                        linearLayout = linearLayout2;
                        button = button4;
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        list2 = emptyList;
                    }
                    plus = ArraysKt___ArraysJvmKt.plus((Object[]) strArr, list2);
                    String[] strArr2 = (String[]) plus;
                    ArrayAdapter arrayAdapter = new ArrayAdapter(activity, (int) R.layout.simple_spinner_item, strArr2);
                    arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
                    booleanSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
                    Intrinsics.checkNotNullExpressionValue(booleanSpinner, "booleanSpinner");
                    arrayList7.add(booleanSpinner);
                    booleanSpinner.setTag(variable.getName());
                    String str4 = actionBlockData.getInputVarsMap().get(variable.getName());
                    if (str4 == null) {
                        str4 = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(str4, "actionBlockData.inputVarsMap[variable.name] ?: \"\"");
                    if (Intrinsics.areEqual(str4, "true")) {
                        arrayList5 = arrayList7;
                        list = outputOnlyActionBlockVariables;
                        coerceAtLeast = 1;
                    } else if (Intrinsics.areEqual(str4, "false")) {
                        arrayList5 = arrayList7;
                        list = outputOnlyActionBlockVariables;
                        coerceAtLeast = 2;
                    } else {
                        arrayList5 = arrayList7;
                        startsWith$default = m.startsWith$default(str4, "[lv=", false, 2, null);
                        if (!startsWith$default) {
                            list = outputOnlyActionBlockVariables;
                            startsWith$default2 = m.startsWith$default(str4, "{lv=", false, 2, null);
                            if (!startsWith$default2) {
                                startsWith$default3 = m.startsWith$default(str4, "[v=", false, 2, null);
                                if (!startsWith$default3) {
                                    startsWith$default4 = m.startsWith$default(str4, "{v=", false, 2, null);
                                    if (!startsWith$default4) {
                                        coerceAtLeast = 0;
                                    }
                                }
                                String string2 = activity.getString(R.string.variable_global);
                                String substring = str4.substring(3, str4.length() - 1);
                                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                                indexOf2 = ArraysKt___ArraysKt.indexOf(strArr2, "(" + string2 + ") " + substring);
                                coerceAtLeast = h.coerceAtLeast(indexOf2, 0);
                            }
                        } else {
                            list = outputOnlyActionBlockVariables;
                        }
                        String string3 = activity.getString(R.string.variable_local);
                        String substring2 = str4.substring(4, str4.length() - 1);
                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        indexOf = ArraysKt___ArraysKt.indexOf(strArr2, "(" + string3 + ") " + substring2);
                        coerceAtLeast = h.coerceAtLeast(indexOf, 0);
                    }
                    booleanSpinner.setSelection(coerceAtLeast);
                    String typeAsString = variable.getTypeAsString(activity);
                    String name2 = variable.getName();
                    ((TextView) inflate.findViewById(R.id.variableName)).setText(typeAsString + str2 + name2);
                    viewGroup.addView(inflate);
                    arrayList2 = arrayList6;
                    str = str2;
                    arrayList3 = arrayList;
                    arrayList4 = arrayList5;
                } else {
                    ArrayList arrayList9 = arrayList7;
                    actionBlockData2 = copy$default;
                    list = outputOnlyActionBlockVariables;
                    appCompatDialog = appCompatDialog3;
                    linearLayout = linearLayout2;
                    button = button4;
                    button2 = button5;
                    View inflate2 = activity.getLayoutInflater().inflate(R.layout.view_action_block_input_variable, viewGroup, false);
                    final EditText inputEditText = (EditText) inflate2.findViewById(R.id.variableValue);
                    TextView textView2 = (TextView) inflate2.findViewById(R.id.variableName);
                    Button inputMagicTextButton = (Button) inflate2.findViewById(R.id.variableMagicTextButton);
                    inputEditText.setTag(variable.getName());
                    Intrinsics.checkNotNullExpressionValue(inputEditText, "inputEditText");
                    arrayList6.add(inputEditText);
                    if (actionBlockData.getInputVarsMap().get(variable.getName()) != null) {
                        str3 = actionBlockData.getInputVarsMap().get(variable.getName());
                    }
                    inputEditText.setText(str3);
                    ActionBlockConfigDialog actionBlockConfigDialog = INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(variable, "variable");
                    actionBlockConfigDialog.b(inputEditText, variable);
                    MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.actionblock.common.a
                        @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
                        public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                            ActionBlockConfigDialog.c(inputEditText, magicTextPair);
                        }
                    };
                    if (inputMagicTextButton != null) {
                        Intrinsics.checkNotNullExpressionValue(inputMagicTextButton, "inputMagicTextButton");
                        ArrayList arrayList10 = arrayList;
                        macroDroidVariable = variable;
                        arrayList4 = arrayList9;
                        arrayList2 = arrayList6;
                        arrayList3 = arrayList10;
                        str = str2;
                        ViewExtensionsKt.onClick$default(inputMagicTextButton, null, new a(variable, activity, magicTextListener, selectableItem, null), 1, null);
                    } else {
                        macroDroidVariable = variable;
                        arrayList2 = arrayList6;
                        str = str2;
                        arrayList3 = arrayList;
                        arrayList4 = arrayList9;
                    }
                    textView2.setText(String.valueOf(macroDroidVariable.getName()));
                    String string4 = activity.getString(R.string.default_value);
                    inputEditText.setHint("<" + string4 + ">");
                    viewGroup.addView(inflate2);
                }
                selectableItem2 = selectableItem;
                str2 = str;
                arrayList7 = arrayList4;
                arrayList6 = arrayList2;
                it2 = it3;
                button5 = button2;
                arrayList = arrayList3;
                copy$default = actionBlockData2;
                appCompatDialog3 = appCompatDialog;
                button4 = button;
                outputOnlyActionBlockVariables = list;
                linearLayout2 = linearLayout;
            }
        }
        ArrayList arrayList11 = arrayList6;
        ActionBlockData actionBlockData3 = copy$default;
        List<MacroDroidVariable> outputVars = outputOnlyActionBlockVariables;
        AppCompatDialog appCompatDialog4 = appCompatDialog3;
        LinearLayout linearLayout4 = linearLayout2;
        Button button6 = button4;
        Button button7 = button5;
        ArrayList arrayList12 = arrayList;
        ArrayList arrayList13 = arrayList7;
        String str5 = str2;
        if (outputVars.isEmpty()) {
            TextView textView3 = new TextView(activity);
            textView3.setText(R.string.none);
            int dimensionPixelSize2 = activity.getResources().getDimensionPixelSize(R.dimen.margin_medium);
            textView3.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
            textView3.setTextColor(ContextCompat.getColor(activity, R.color.default_text_color));
            linearLayout4.addView(textView3);
        } else {
            Intrinsics.checkNotNullExpressionValue(outputVars, "outputVars");
            for (MacroDroidVariable macroDroidVariable3 : outputVars) {
                View inflate3 = activity.getLayoutInflater().inflate(R.layout.view_action_block_output_variable, (ViewGroup) null);
                TextView textView4 = (TextView) inflate3.findViewById(R.id.variableName);
                if (textView4 != null) {
                    String typeAsString2 = macroDroidVariable3.getTypeAsString(activity);
                    String name3 = macroDroidVariable3.getName();
                    textView4.setText(typeAsString2 + str5 + name3);
                }
                Spinner variableSpinner = (Spinner) inflate3.findViewById(R.id.variableSpinner);
                variableSpinner.setTag(macroDroidVariable3.getName());
                ActionBlockConfigDialog actionBlockConfigDialog2 = INSTANCE;
                int type = macroDroidVariable3.getType();
                if (selectableItem != null) {
                    d4 = actionBlockConfigDialog2.e(type, selectableItem);
                } else {
                    d4 = actionBlockConfigDialog2.d(type);
                }
                ArrayList arrayList14 = new ArrayList();
                if (d4.size() == 0) {
                    String string5 = activity.getString(R.string.trigger_variable_no_variables);
                    arrayList14.add("[" + string5 + "]");
                } else {
                    String string6 = activity.getString(R.string.output_variable_not_used);
                    arrayList14.add("[" + string6 + "]");
                }
                String str6 = actionBlockData.getOutputVarsMap().get(macroDroidVariable3.getName());
                int i6 = 0;
                int i7 = 1;
                for (MacroDroidVariable macroDroidVariable4 : d4) {
                    arrayList14.add(macroDroidVariable4.getName());
                    if (Intrinsics.areEqual(str6, macroDroidVariable4.getName())) {
                        i6 = i7;
                    }
                    i7++;
                }
                ArrayAdapter arrayAdapter2 = new ArrayAdapter(activity, 17367048, arrayList14);
                arrayAdapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
                variableSpinner.setAdapter((SpinnerAdapter) arrayAdapter2);
                variableSpinner.setSelection(i6, false);
                linearLayout4.addView(inflate3);
                Intrinsics.checkNotNullExpressionValue(variableSpinner, "variableSpinner");
                arrayList12.add(variableSpinner);
            }
        }
        if (button6 != null) {
            i5 = 1;
            dispatchedCoroutine = null;
            ViewExtensionsKt.onClick$default(button6, null, new b(arrayList11, arrayList13, arrayList12, appCompatDialog4, actionBlockDataConfigured, actionBlockData3, activity, null), 1, null);
        } else {
            i5 = 1;
            dispatchedCoroutine = null;
        }
        if (button7 != null) {
            appCompatDialog2 = appCompatDialog4;
            ViewExtensionsKt.onClick$default(button7, dispatchedCoroutine, new c(appCompatDialog2, dispatchedCoroutine), i5, dispatchedCoroutine);
        } else {
            appCompatDialog2 = appCompatDialog4;
        }
        appCompatDialog2.show();
    }

    private final List<MacroDroidVariable> e(int i4, SelectableItem selectableItem) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        ArrayList<MacroDroidVariable> allDecimalVariables = selectableItem.getAllDecimalVariables();
                        Intrinsics.checkNotNullExpressionValue(allDecimalVariables, "selectableItem.allDecimalVariables");
                        return allDecimalVariables;
                    }
                    ArrayList<MacroDroidVariable> allDecimalVariables2 = selectableItem.getAllDecimalVariables();
                    Intrinsics.checkNotNullExpressionValue(allDecimalVariables2, "selectableItem.allDecimalVariables");
                    return allDecimalVariables2;
                }
                ArrayList<MacroDroidVariable> allStringVariables = selectableItem.getAllStringVariables();
                Intrinsics.checkNotNullExpressionValue(allStringVariables, "selectableItem.allStringVariables");
                return allStringVariables;
            }
            ArrayList<MacroDroidVariable> allIntegerVariables = selectableItem.getAllIntegerVariables();
            Intrinsics.checkNotNullExpressionValue(allIntegerVariables, "selectableItem.allIntegerVariables");
            return allIntegerVariables;
        }
        ArrayList<MacroDroidVariable> allBooleanVariables = selectableItem.getAllBooleanVariables();
        Intrinsics.checkNotNullExpressionValue(allBooleanVariables, "selectableItem.allBooleanVariables");
        return allBooleanVariables;
    }
}
