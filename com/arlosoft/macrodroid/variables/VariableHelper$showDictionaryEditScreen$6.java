package com.arlosoft.macrodroid.variables;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.variables.VariableHelper$showDictionaryEditScreen$6;
import com.arlosoft.macrodroid.variables.VariableValue;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import splitties.alertdialog.appcompat.AlertDialogKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VariableHelper.kt */
@SourceDebugExtension({"SMAP\nVariableHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VariableHelper.kt\ncom/arlosoft/macrodroid/variables/VariableHelper$showDictionaryEditScreen$6\n+ 2 AlertDialog.kt\nsplitties/alertdialog/appcompat/AlertDialogKt\n*L\n1#1,1920:1\n27#2,3:1921\n165#2,2:1924\n183#2,2:1926\n30#2:1928\n*S KotlinDebug\n*F\n+ 1 VariableHelper.kt\ncom/arlosoft/macrodroid/variables/VariableHelper$showDictionaryEditScreen$6\n*L\n1071#1:1921,3\n1074#1:1924,2\n1080#1:1926,2\n1071#1:1928\n*E\n"})
/* loaded from: classes3.dex */
public final class VariableHelper$showDictionaryEditScreen$6 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Ref.ObjectRef<DictionaryVariableAdapter> $adapter;
    final /* synthetic */ VariableValue.Dictionary $dictionary;
    final /* synthetic */ DictionaryEventListener $dictionaryEventListener;
    final /* synthetic */ TextView $emptyView;
    final /* synthetic */ RecyclerView $recyclerView;
    int label;

    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ DictionaryEventListener $dictionaryEventListener;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DictionaryEventListener dictionaryEventListener) {
            super(0);
            this.$dictionaryEventListener = dictionaryEventListener;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$dictionaryEventListener.entriesCleared();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VariableHelper$showDictionaryEditScreen$6(Activity activity, VariableValue.Dictionary dictionary, Ref.ObjectRef<DictionaryVariableAdapter> objectRef, TextView textView, RecyclerView recyclerView, DictionaryEventListener dictionaryEventListener, Continuation<? super VariableHelper$showDictionaryEditScreen$6> continuation) {
        super(3, continuation);
        this.$activity = activity;
        this.$dictionary = dictionary;
        this.$adapter = objectRef;
        this.$emptyView = textView;
        this.$recyclerView = recyclerView;
        this.$dictionaryEventListener = dictionaryEventListener;
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    /* renamed from: a */
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
        return new VariableHelper$showDictionaryEditScreen$6(this.$activity, this.$dictionary, this.$adapter, this.$emptyView, this.$recyclerView, this.$dictionaryEventListener, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Activity activity = this.$activity;
            final VariableValue.Dictionary dictionary = this.$dictionary;
            final Ref.ObjectRef<DictionaryVariableAdapter> objectRef = this.$adapter;
            final TextView textView = this.$emptyView;
            final RecyclerView recyclerView = this.$recyclerView;
            final DictionaryEventListener dictionaryEventListener = this.$dictionaryEventListener;
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            AlertDialogKt.setTitleResource(builder, R.string.action_clear_notifications_clear_all);
            AlertDialogKt.setMessageResource(builder, R.string.clear_all_variable_entries_confirm);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.VariableHelper$showDictionaryEditScreen$6$invokeSuspend$lambda$2$$inlined$okButton$1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(@NotNull DialogInterface dialog, int i4) {
                    DictionaryVariableAdapter dictionaryVariableAdapter;
                    Intrinsics.checkNotNullParameter(dialog, "dialog");
                    VariableValue.Dictionary.this.clearAll();
                    VariableHelper variableHelper = VariableHelper.INSTANCE;
                    VariableValue.Dictionary dictionary2 = VariableValue.Dictionary.this;
                    T t3 = objectRef.element;
                    if (t3 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        dictionaryVariableAdapter = null;
                    } else {
                        dictionaryVariableAdapter = (DictionaryVariableAdapter) t3;
                    }
                    variableHelper.N(dictionary2, dictionaryVariableAdapter, textView, recyclerView, new VariableHelper$showDictionaryEditScreen$6.a(dictionaryEventListener));
                }
            });
            builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.VariableHelper$showDictionaryEditScreen$6$invokeSuspend$lambda$2$$inlined$cancelButton$1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(@NotNull DialogInterface dialog, int i4) {
                    Intrinsics.checkNotNullParameter(dialog, "dialog");
                }
            });
            AlertDialog create = builder.create();
            Intrinsics.checkNotNullExpressionValue(create, "Builder(this)\n        .apply(dialogConfig)\n        .create()");
            create.show();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
