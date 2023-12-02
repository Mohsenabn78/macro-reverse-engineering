package com.arlosoft.macrodroid.variables;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.variables.VariableHelper$showDictionaryEditScreen$7;
import com.arlosoft.macrodroid.variables.VariableValue;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
@SourceDebugExtension({"SMAP\nVariableHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VariableHelper.kt\ncom/arlosoft/macrodroid/variables/VariableHelper$showDictionaryEditScreen$7\n+ 2 AlertDialog.kt\nsplitties/alertdialog/appcompat/AlertDialogKt\n*L\n1#1,1920:1\n27#2,3:1921\n204#2,2:1924\n226#2,2:1926\n215#2,2:1928\n30#2:1930\n*S KotlinDebug\n*F\n+ 1 VariableHelper.kt\ncom/arlosoft/macrodroid/variables/VariableHelper$showDictionaryEditScreen$7\n*L\n1084#1:1921,3\n1087#1:1924,2\n1094#1:1926,2\n1106#1:1928,2\n1084#1:1930\n*E\n"})
/* loaded from: classes3.dex */
public final class VariableHelper$showDictionaryEditScreen$7 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Ref.ObjectRef<DictionaryVariableAdapter> $adapter;
    final /* synthetic */ AppCompatDialog $dialog;
    final /* synthetic */ VariableValue.Dictionary $dictionary;
    final /* synthetic */ DictionaryEventListener $dictionaryEventListener;
    final /* synthetic */ TextView $emptyView;
    final /* synthetic */ String $keyName;
    final /* synthetic */ VariableValue.Dictionary $parentDictionary;
    final /* synthetic */ RecyclerView $recyclerView;
    final /* synthetic */ boolean $showDeleteDictionaryOption;
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

    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements Function1<VariableValue.DictionaryEntry, Boolean> {
        final /* synthetic */ String $keyName;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.$keyName = str;
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull VariableValue.DictionaryEntry it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(Intrinsics.areEqual(it.getKey(), this.$keyName));
        }
    }

    /* compiled from: VariableHelper.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function0<Unit> {
        final /* synthetic */ DictionaryEventListener $dictionaryEventListener;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(DictionaryEventListener dictionaryEventListener) {
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
    public VariableHelper$showDictionaryEditScreen$7(Activity activity, boolean z3, VariableValue.Dictionary dictionary, Ref.ObjectRef<DictionaryVariableAdapter> objectRef, TextView textView, RecyclerView recyclerView, DictionaryEventListener dictionaryEventListener, VariableValue.Dictionary dictionary2, AppCompatDialog appCompatDialog, String str, Continuation<? super VariableHelper$showDictionaryEditScreen$7> continuation) {
        super(3, continuation);
        this.$activity = activity;
        this.$showDeleteDictionaryOption = z3;
        this.$dictionary = dictionary;
        this.$adapter = objectRef;
        this.$emptyView = textView;
        this.$recyclerView = recyclerView;
        this.$dictionaryEventListener = dictionaryEventListener;
        this.$parentDictionary = dictionary2;
        this.$dialog = appCompatDialog;
        this.$keyName = str;
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    /* renamed from: a */
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
        return new VariableHelper$showDictionaryEditScreen$7(this.$activity, this.$showDeleteDictionaryOption, this.$dictionary, this.$adapter, this.$emptyView, this.$recyclerView, this.$dictionaryEventListener, this.$parentDictionary, this.$dialog, this.$keyName, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i4;
        kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Activity activity = this.$activity;
            boolean z3 = this.$showDeleteDictionaryOption;
            final VariableValue.Dictionary dictionary = this.$dictionary;
            final Ref.ObjectRef<DictionaryVariableAdapter> objectRef = this.$adapter;
            final TextView textView = this.$emptyView;
            final RecyclerView recyclerView = this.$recyclerView;
            final DictionaryEventListener dictionaryEventListener = this.$dictionaryEventListener;
            final VariableValue.Dictionary dictionary2 = this.$parentDictionary;
            final AppCompatDialog appCompatDialog = this.$dialog;
            final String str = this.$keyName;
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            AlertDialogKt.setTitleResource(builder, R.string.delete_all);
            AlertDialogKt.setMessageResource(builder, R.string.delete_all_variable_entries_confirm);
            builder.setPositiveButton(R.string.variable_delete_all_entries, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.VariableHelper$showDictionaryEditScreen$7$invokeSuspend$lambda$3$$inlined$positiveButton$1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(@NotNull DialogInterface dialog, int i5) {
                    DictionaryVariableAdapter dictionaryVariableAdapter;
                    Intrinsics.checkNotNullParameter(dialog, "dialog");
                    VariableValue.Dictionary.this.deleteAll();
                    VariableHelper variableHelper = VariableHelper.INSTANCE;
                    VariableValue.Dictionary dictionary3 = VariableValue.Dictionary.this;
                    T t3 = objectRef.element;
                    if (t3 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        dictionaryVariableAdapter = null;
                    } else {
                        dictionaryVariableAdapter = (DictionaryVariableAdapter) t3;
                    }
                    variableHelper.N(dictionary3, dictionaryVariableAdapter, textView, recyclerView, new VariableHelper$showDictionaryEditScreen$7.a(dictionaryEventListener));
                }
            });
            if (z3) {
                if (dictionary.isArray()) {
                    i4 = R.string.variable_delete_array;
                } else {
                    i4 = R.string.variable_delete_dictionary;
                }
                builder.setNegativeButton(i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.VariableHelper$showDictionaryEditScreen$7$invokeSuspend$lambda$3$$inlined$negativeButton$1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(@NotNull DialogInterface dialog, int i5) {
                        DictionaryVariableAdapter dictionaryVariableAdapter;
                        Intrinsics.checkNotNullParameter(dialog, "dialog");
                        VariableValue.Dictionary dictionary3 = VariableValue.Dictionary.this;
                        if (dictionary3 != null) {
                            kotlin.collections.i.removeAll((List) dictionary3.getEntries(), (Function1) new VariableHelper$showDictionaryEditScreen$7.b(str));
                            VariableHelper variableHelper = VariableHelper.INSTANCE;
                            VariableValue.Dictionary dictionary4 = VariableValue.Dictionary.this;
                            T t3 = objectRef.element;
                            if (t3 == 0) {
                                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                                dictionaryVariableAdapter = null;
                            } else {
                                dictionaryVariableAdapter = (DictionaryVariableAdapter) t3;
                            }
                            variableHelper.N(dictionary4, dictionaryVariableAdapter, textView, recyclerView, new VariableHelper$showDictionaryEditScreen$7.c(dictionaryEventListener));
                        } else {
                            dictionaryEventListener.dictionaryDeleted();
                        }
                        appCompatDialog.dismiss();
                    }
                });
            }
            builder.setNeutralButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.VariableHelper$showDictionaryEditScreen$7$invokeSuspend$lambda$3$$inlined$neutralButton$1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(@NotNull DialogInterface dialog, int i5) {
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
