package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.view.View;
import android.widget.Spinner;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableWithDictionaryKeys;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SelectionDialogAction.kt */
/* loaded from: classes2.dex */
final class SelectionDialogAction$handleItemSelected$2 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $noneList;
    final /* synthetic */ Spinner $saveValueSpinner;
    int label;
    final /* synthetic */ SelectionDialogAction this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionDialogAction$handleItemSelected$2(SelectionDialogAction selectionDialogAction, Spinner spinner, List<String> list, Continuation<? super SelectionDialogAction$handleItemSelected$2> continuation) {
        super(3, continuation);
        this.this$0 = selectionDialogAction;
        this.$saveValueSpinner = spinner;
        this.$noneList = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final SelectionDialogAction selectionDialogAction, Spinner spinner, List list, MacroDroidVariable macroDroidVariable) {
        List emptyList;
        String str;
        String name = macroDroidVariable.getName();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        selectionDialogAction.workingSaveValueVariable = new VariableWithDictionaryKeys(name, new DictionaryKeys(emptyList));
        Activity activity = selectionDialogAction.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Macro macro = selectionDialogAction.getMacro();
        if (selectionDialogAction.workingSaveValueVariable != null) {
            VariableWithDictionaryKeys variableWithDictionaryKeys = selectionDialogAction.workingSaveValueVariable;
            Intrinsics.checkNotNull(variableWithDictionaryKeys);
            String variableName = variableWithDictionaryKeys.getVariableName();
            VariableWithDictionaryKeys variableWithDictionaryKeys2 = selectionDialogAction.workingSaveValueVariable;
            Intrinsics.checkNotNull(variableWithDictionaryKeys2);
            str = variableName + VariableHelper.getFormattedDictionaryKeys(variableWithDictionaryKeys2.getKeys());
        } else {
            str = null;
        }
        VariableHelper.configureStringVarSpinner(activity, R.style.Theme_App_Dialog_Action, selectionDialogAction, spinner, macro, list, str, false, null, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.SelectionDialogAction$handleItemSelected$2$1$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                SelectionDialogAction.this.workingSaveValueVariable = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list2) {
                Intrinsics.checkNotNullParameter(variable, "variable");
                SelectionDialogAction selectionDialogAction2 = SelectionDialogAction.this;
                String name2 = variable.getName();
                if (list2 == null) {
                    list2 = CollectionsKt__CollectionsKt.emptyList();
                }
                selectionDialogAction2.workingSaveValueVariable = new VariableWithDictionaryKeys(name2, new DictionaryKeys(list2));
            }
        });
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    /* renamed from: b */
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
        return new SelectionDialogAction$handleItemSelected$2(this.this$0, this.$saveValueSpinner, this.$noneList, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Activity activity = this.this$0.getActivity();
            Spinner spinner = this.$saveValueSpinner;
            SelectionDialogAction selectionDialogAction = this.this$0;
            int dialogTheme = selectionDialogAction.getDialogTheme();
            final SelectionDialogAction selectionDialogAction2 = this.this$0;
            final Spinner spinner2 = this.$saveValueSpinner;
            final List<String> list = this.$noneList;
            VariablesHelper.createNewVariable(activity, spinner, selectionDialogAction, dialogTheme, 2, true, false, new VariablesHelper.VariableCreatedListener() { // from class: com.arlosoft.macrodroid.action.mh
                @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
                public final void variableCreated(MacroDroidVariable macroDroidVariable) {
                    SelectionDialogAction$handleItemSelected$2.c(SelectionDialogAction.this, spinner2, list, macroDroidVariable);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
