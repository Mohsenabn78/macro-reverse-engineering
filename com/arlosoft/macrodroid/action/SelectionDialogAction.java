package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.SelectionDialogAction;
import com.arlosoft.macrodroid.action.activities.SelectionDialogActivity;
import com.arlosoft.macrodroid.action.info.SelectionDialogActionInfo;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasVariableNames;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.arlosoft.macrodroid.variables.VariableWithDictionaryKeys;
import com.google.android.material.card.MaterialCardView;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SelectionDialogAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nSelectionDialogAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectionDialogAction.kt\ncom/arlosoft/macrodroid/action/SelectionDialogAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,612:1\n1549#2:613\n1620#2,3:614\n1549#2:617\n1620#2,3:618\n1549#2:635\n1620#2,3:636\n1559#2:641\n1590#2,4:642\n262#3,2:621\n262#3,2:623\n68#3,4:625\n40#3:629\n56#3:630\n75#3:631\n68#3,4:646\n40#3:650\n56#3:651\n75#3:652\n37#4,2:632\n37#4,2:639\n1#5:634\n*S KotlinDebug\n*F\n+ 1 SelectionDialogAction.kt\ncom/arlosoft/macrodroid/action/SelectionDialogAction\n*L\n123#1:613\n123#1:614,3\n125#1:617\n125#1:618,3\n553#1:635\n553#1:636,3\n560#1:641\n560#1:642,4\n308#1:621,2\n309#1:623,2\n526#1:625,4\n526#1:629\n526#1:630\n526#1:631\n412#1:646,4\n412#1:650\n412#1:651\n412#1:652\n535#1:632,2\n554#1:639,2\n*E\n"})
/* loaded from: classes2.dex */
public final class SelectionDialogAction extends Action implements HasVariableNames, SupportsMagicText, BlockingAction {
    public static final int OPTION_DEFINE_MANUALLY = 0;
    public static final int OPTION_USE_DICTIONARY_OR_ARRAY = 1;
    private int bgColor;
    @NotNull
    private List<CustomEntry> customEntries;
    @Nullable
    private DictionaryKeys dictionaryKeys;
    @Nullable
    private String dictionaryVarName;
    @NotNull
    private String message;
    private int option;
    private boolean preventBackButtonClose;
    @Nullable
    private VariableWithDictionaryKeys saveIndexVariable;
    @Nullable
    private VariableWithDictionaryKeys saveValueVariable;
    private int textColor;
    private transient int workingBgColor;
    @Nullable
    private transient DictionaryKeys workingDictionaryKeys;
    @Nullable
    private transient String workingDictionaryVariableName;
    @NotNull
    private transient List<CustomEntry> workingEntries;
    @Nullable
    private transient VariableWithDictionaryKeys workingSaveValueVariable;
    private transient int workingTextColor;
    @Nullable
    private transient VariableWithDictionaryKeys workingsaveIndexVariable;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SelectionDialogAction> CREATOR = new Parcelable.Creator<SelectionDialogAction>() { // from class: com.arlosoft.macrodroid.action.SelectionDialogAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SelectionDialogAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SelectionDialogAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SelectionDialogAction[] newArray(int i4) {
            return new SelectionDialogAction[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectionDialogAction.kt */
    /* loaded from: classes2.dex */
    public static final class a extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<CustomEntry, Unit> $entryUpdated;
        final /* synthetic */ Ref.ObjectRef<CustomEntry> $workingEntry;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Ref.ObjectRef<CustomEntry> objectRef, Function1<? super CustomEntry, Unit> function1, Continuation<? super a> continuation) {
            super(4, continuation);
            this.$workingEntry = objectRef;
            this.$entryUpdated = function1;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            a aVar = new a(this.$workingEntry, this.$entryUpdated, continuation);
            aVar.Z$0 = z3;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, com.arlosoft.macrodroid.action.CustomEntry] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z3 = this.Z$0;
                Ref.ObjectRef<CustomEntry> objectRef = this.$workingEntry;
                objectRef.element = CustomEntry.copy$default(objectRef.element, null, 0, z3, false, 11, null);
                this.$entryUpdated.invoke(this.$workingEntry.element);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectionDialogAction.kt */
    /* loaded from: classes2.dex */
    public static final class b extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<CustomEntry, Unit> $entryUpdated;
        final /* synthetic */ Ref.ObjectRef<CustomEntry> $workingEntry;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Ref.ObjectRef<CustomEntry> objectRef, Function1<? super CustomEntry, Unit> function1, Continuation<? super b> continuation) {
            super(4, continuation);
            this.$workingEntry = objectRef;
            this.$entryUpdated = function1;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            b bVar = new b(this.$workingEntry, this.$entryUpdated, continuation);
            bVar.Z$0 = z3;
            return bVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, com.arlosoft.macrodroid.action.CustomEntry] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z3 = this.Z$0;
                Ref.ObjectRef<CustomEntry> objectRef = this.$workingEntry;
                objectRef.element = CustomEntry.copy$default(objectRef.element, null, 0, false, z3, 7, null);
                this.$entryUpdated.invoke(this.$workingEntry.element);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectionDialogAction.kt */
    /* loaded from: classes2.dex */
    public static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f2457a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(EditText editText) {
            this.f2457a = editText;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f2457a.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectionDialogAction.kt */
    /* loaded from: classes2.dex */
    public static final class d extends Lambda implements Function1<CustomEntry, Unit> {
        final /* synthetic */ int $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i4) {
            super(1);
            this.$index = i4;
        }

        public final void a(@NotNull CustomEntry updatedEntry) {
            Intrinsics.checkNotNullParameter(updatedEntry, "updatedEntry");
            SelectionDialogAction.this.workingEntries.set(this.$index - 1, updatedEntry);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CustomEntry customEntry) {
            a(customEntry);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectionDialogAction.kt */
    /* loaded from: classes2.dex */
    public static final class e extends Lambda implements Function1<Integer, Unit> {
        final /* synthetic */ LinearLayout $customItemsContainer;
        final /* synthetic */ AppCompatDialog $dialog;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(LinearLayout linearLayout, AppCompatDialog appCompatDialog) {
            super(1);
            this.$customItemsContainer = linearLayout;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i4) {
            SelectionDialogAction.this.workingEntries.remove(i4 - 1);
            SelectionDialogAction.b0(this.$customItemsContainer, SelectionDialogAction.this, this.$dialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectionDialogAction.kt */
    /* loaded from: classes2.dex */
    public static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ScrollView f2458a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(ScrollView scrollView) {
            this.f2458a = scrollView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f2458a.fullScroll(130);
        }
    }

    /* compiled from: SelectionDialogAction.kt */
    @SourceDebugExtension({"SMAP\nSelectionDialogAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectionDialogAction.kt\ncom/arlosoft/macrodroid/action/SelectionDialogAction$handleItemSelected$12\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,612:1\n1747#2,3:613\n*S KotlinDebug\n*F\n+ 1 SelectionDialogAction.kt\ncom/arlosoft/macrodroid/action/SelectionDialogAction$handleItemSelected$12\n*L\n423#1:613,3\n*E\n"})
    /* loaded from: classes2.dex */
    static final class g extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ Spinner $dialogOptionsSpinner;
        final /* synthetic */ EditText $messageText;
        final /* synthetic */ CheckBox $preventBackButtonCloseCheckBox;
        int label;
        final /* synthetic */ SelectionDialogAction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Spinner spinner, SelectionDialogAction selectionDialogAction, EditText editText, CheckBox checkBox, AppCompatDialog appCompatDialog, Continuation<? super g> continuation) {
            super(3, continuation);
            this.$dialogOptionsSpinner = spinner;
            this.this$0 = selectionDialogAction;
            this.$messageText = editText;
            this.$preventBackButtonCloseCheckBox = checkBox;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new g(this.$dialogOptionsSpinner, this.this$0, this.$messageText, this.$preventBackButtonCloseCheckBox, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z3;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$dialogOptionsSpinner.getSelectedItemPosition() == 0) {
                    if (!this.this$0.workingEntries.isEmpty()) {
                        List list = this.this$0.workingEntries;
                        boolean z4 = false;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            Iterator it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                String text = ((CustomEntry) it.next()).getText();
                                if (text != null && text.length() != 0) {
                                    z3 = false;
                                    continue;
                                } else {
                                    z3 = true;
                                    continue;
                                }
                                if (z3) {
                                    z4 = true;
                                    break;
                                }
                            }
                        }
                        if (z4) {
                            Util.displayErrorDialog(this.this$0.getActivity(), SelectableItem.r(R.string.error), SelectableItem.r(R.string.action_selection_dialog_ensure_all_entries_have_text));
                            return Unit.INSTANCE;
                        }
                    } else {
                        Util.displayErrorDialog(this.this$0.getActivity(), SelectableItem.r(R.string.error), SelectableItem.r(R.string.variable_multi_entry_no_entries));
                        return Unit.INSTANCE;
                    }
                }
                this.this$0.message = this.$messageText.getText().toString();
                SelectionDialogAction selectionDialogAction = this.this$0;
                selectionDialogAction.dictionaryVarName = selectionDialogAction.workingDictionaryVariableName;
                SelectionDialogAction selectionDialogAction2 = this.this$0;
                selectionDialogAction2.dictionaryKeys = selectionDialogAction2.workingDictionaryKeys;
                SelectionDialogAction selectionDialogAction3 = this.this$0;
                selectionDialogAction3.customEntries = selectionDialogAction3.workingEntries;
                SelectionDialogAction selectionDialogAction4 = this.this$0;
                selectionDialogAction4.textColor = selectionDialogAction4.workingTextColor;
                SelectionDialogAction selectionDialogAction5 = this.this$0;
                selectionDialogAction5.bgColor = selectionDialogAction5.workingBgColor;
                this.this$0.option = this.$dialogOptionsSpinner.getSelectedItemPosition();
                SelectionDialogAction selectionDialogAction6 = this.this$0;
                selectionDialogAction6.saveIndexVariable = selectionDialogAction6.workingsaveIndexVariable;
                SelectionDialogAction selectionDialogAction7 = this.this$0;
                selectionDialogAction7.saveValueVariable = selectionDialogAction7.workingSaveValueVariable;
                this.this$0.preventBackButtonClose = this.$preventBackButtonCloseCheckBox.isChecked();
                this.this$0.itemComplete();
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: SelectionDialogAction.kt */
    /* loaded from: classes2.dex */
    static final class h extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(AppCompatDialog appCompatDialog, Continuation<? super h> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new h(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
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

    /* compiled from: SelectionDialogAction.kt */
    /* loaded from: classes2.dex */
    static final class i extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MaterialCardView $textColorButton;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(MaterialCardView materialCardView, Continuation<? super i> continuation) {
            super(3, continuation);
            this.$textColorButton = materialCardView;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new i(this.$textColorButton, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SelectionDialogAction.X(SelectionDialogAction.this, this.$textColorButton);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: SelectionDialogAction.kt */
    /* loaded from: classes2.dex */
    static final class j extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MaterialCardView $textColorButton;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(MaterialCardView materialCardView, Continuation<? super j> continuation) {
            super(3, continuation);
            this.$textColorButton = materialCardView;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new j(this.$textColorButton, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SelectionDialogAction.X(SelectionDialogAction.this, this.$textColorButton);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: SelectionDialogAction.kt */
    /* loaded from: classes2.dex */
    static final class k extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MaterialCardView $bgColorButton;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(MaterialCardView materialCardView, Continuation<? super k> continuation) {
            super(3, continuation);
            this.$bgColorButton = materialCardView;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new k(this.$bgColorButton, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SelectionDialogAction.W(SelectionDialogAction.this, this.$bgColorButton);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: SelectionDialogAction.kt */
    /* loaded from: classes2.dex */
    static final class l extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MaterialCardView $bgColorButton;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(MaterialCardView materialCardView, Continuation<? super l> continuation) {
            super(3, continuation);
            this.$bgColorButton = materialCardView;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new l(this.$bgColorButton, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SelectionDialogAction.W(SelectionDialogAction.this, this.$bgColorButton);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectionDialogAction.kt */
    /* loaded from: classes2.dex */
    public static final class m extends Lambda implements Function1<CustomEntry, Unit> {
        final /* synthetic */ IndexedValue<CustomEntry> $entry;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(IndexedValue<CustomEntry> indexedValue) {
            super(1);
            this.$entry = indexedValue;
        }

        public final void a(@NotNull CustomEntry updatedEntry) {
            Intrinsics.checkNotNullParameter(updatedEntry, "updatedEntry");
            SelectionDialogAction.this.workingEntries.set(this.$entry.getIndex(), updatedEntry);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CustomEntry customEntry) {
            a(customEntry);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectionDialogAction.kt */
    /* loaded from: classes2.dex */
    public static final class n extends Lambda implements Function1<Integer, Unit> {
        final /* synthetic */ LinearLayout $customItemsContainer;
        final /* synthetic */ AppCompatDialog $dialog;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(LinearLayout linearLayout, AppCompatDialog appCompatDialog) {
            super(1);
            this.$customItemsContainer = linearLayout;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i4) {
            SelectionDialogAction.this.workingEntries.remove(i4 - 1);
            SelectionDialogAction.b0(this.$customItemsContainer, SelectionDialogAction.this, this.$dialog);
        }
    }

    public /* synthetic */ SelectionDialogAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void S(final Activity activity, Context context, LinearLayout linearLayout, final int i4, CustomEntry customEntry, final Function1<? super CustomEntry, Unit> function1, final Function1<? super Integer, Unit> function12) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = customEntry;
        View inflate = LayoutInflater.from(context).inflate(R.layout.include_selection_dialog_item, (ViewGroup) linearLayout, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.delete_button);
        final EditText editText = (EditText) inflate.findViewById(R.id.item_text);
        View findViewById = inflate.findViewById(R.id.color_button);
        Intrinsics.checkNotNull(findViewById);
        MaterialCardView materialCardView = (MaterialCardView) findViewById;
        CheckBox boldCheckbox = (CheckBox) inflate.findViewById(R.id.bold_checkbox);
        CheckBox italicCheckbox = (CheckBox) inflate.findViewById(R.id.italic_checkbox);
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.fh
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SelectionDialogAction.T(editText, magicTextPair);
            }
        };
        materialCardView.setCardBackgroundColor(customEntry.getColor());
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getContext().getString(R.string.action_selection_dialog_item_with_number);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…_dialog_item_with_number)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i4)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        ((TextView) inflate.findViewById(R.id.item_label)).setText(format);
        ((Button) inflate.findViewById(R.id.actionButtonLabelMagicTextButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.gh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectionDialogAction.U(activity, magicTextListener, this, view);
            }
        });
        editText.setText(customEntry.getText());
        boldCheckbox.setChecked(customEntry.isBold());
        Intrinsics.checkNotNullExpressionValue(boldCheckbox, "boldCheckbox");
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(boldCheckbox, (CoroutineContext) null, new a(objectRef, function1, null), 1, (Object) null);
        italicCheckbox.setChecked(customEntry.isItalic());
        Intrinsics.checkNotNullExpressionValue(italicCheckbox, "italicCheckbox");
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(italicCheckbox, (CoroutineContext) null, new b(objectRef, function1, null), 1, (Object) null);
        linearLayout.addView(inflate);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.SelectionDialogAction$addCustomItemLayout$4
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable s3) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@NotNull CharSequence s3, int i5, int i6, int i7) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }

            /* JADX WARN: Type inference failed for: r8v1, types: [T, com.arlosoft.macrodroid.action.CustomEntry] */
            @Override // android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence s3, int i5, int i6, int i7) {
                Intrinsics.checkNotNullParameter(s3, "s");
                Ref.ObjectRef<CustomEntry> objectRef2 = objectRef;
                objectRef2.element = CustomEntry.copy$default(objectRef2.element, s3.toString(), 0, false, false, 14, null);
                function1.invoke(objectRef.element);
            }
        });
        ViewExtensionsKt.onClick$default(materialCardView, null, new SelectionDialogAction$addCustomItemLayout$5(customEntry, activity, materialCardView, objectRef, function1, null), 1, null);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.hh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectionDialogAction.V(Function1.this, i4, view);
            }
        });
        if (ViewCompat.isLaidOut(editText) && !editText.isLayoutRequested()) {
            new Handler(Looper.getMainLooper()).postDelayed(new c(editText), 100L);
            editText.requestFocus();
            return;
        }
        editText.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.arlosoft.macrodroid.action.SelectionDialogAction$addCustomItemLayout$$inlined$doOnLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(@NotNull View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
                Intrinsics.checkNotNullParameter(view, "view");
                view.removeOnLayoutChangeListener(this);
                new Handler(Looper.getMainLooper()).postDelayed(new SelectionDialogAction.c(editText), 100L);
                editText.requestFocus();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(EditText editText, MagicText.MagicTextPair pair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(pair, "pair");
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(editText.getSelectionStart(), 0);
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        coerceAtMost = kotlin.ranges.h.coerceAtMost(coerceAtLeast, coerceAtLeast2);
        int max = Math.max(coerceAtLeast, coerceAtLeast2);
        String str = pair.magicText;
        text.replace(coerceAtMost, max, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(Activity activity, MagicText.MagicTextListener magicTextListener, SelectionDialogAction this$0, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, magicTextListener, this$0.getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 deleteCallback, int i4, View view) {
        Intrinsics.checkNotNullParameter(deleteCallback, "$deleteCallback");
        deleteCallback.invoke(Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(final SelectionDialogAction selectionDialogAction, final MaterialCardView materialCardView) {
        ColorPickerDialog create = ColorPickerDialog.newBuilder().setColor(selectionDialogAction.workingBgColor).setDialogType(1).setAllowCustom(true).setShowAlphaSlider(false).setAllowPresets(false).create();
        create.setColorPickerDialogListener(new ColorPickerDialogListener() { // from class: com.arlosoft.macrodroid.action.SelectionDialogAction$handleItemSelected$handlePickBackgroundColor$1
            @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
            public void onColorSelected(int i4, int i5) {
                MaterialCardView.this.setCardBackgroundColor(i5);
                selectionDialogAction.workingBgColor = i5;
            }

            @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
            public void onDialogDismissed(int i4) {
            }
        });
        Activity activity = selectionDialogAction.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        create.show(((FragmentActivity) activity).getSupportFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(final SelectionDialogAction selectionDialogAction, final MaterialCardView materialCardView) {
        ColorPickerDialog create = ColorPickerDialog.newBuilder().setColor(selectionDialogAction.workingTextColor).setDialogType(1).setAllowCustom(true).setShowAlphaSlider(false).setAllowPresets(false).create();
        create.setColorPickerDialogListener(new ColorPickerDialogListener() { // from class: com.arlosoft.macrodroid.action.SelectionDialogAction$handleItemSelected$handlePickTextColor$1
            @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
            public void onColorSelected(int i4, int i5) {
                MaterialCardView.this.setCardBackgroundColor(i5);
                selectionDialogAction.workingTextColor = i5;
            }

            @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
            public void onDialogDismissed(int i4) {
            }
        });
        Activity activity = selectionDialogAction.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        create.show(((FragmentActivity) activity).getSupportFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(EditText messageText, MagicText.MagicTextPair pair) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int coerceAtMost;
        int coerceAtLeast3;
        Intrinsics.checkNotNullParameter(messageText, "$messageText");
        Intrinsics.checkNotNullParameter(pair, "pair");
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(messageText.getSelectionStart(), 0);
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(messageText.getSelectionEnd(), 0);
        Editable text = messageText.getText();
        if (text != null) {
            coerceAtMost = kotlin.ranges.h.coerceAtMost(coerceAtLeast, coerceAtLeast2);
            coerceAtLeast3 = kotlin.ranges.h.coerceAtLeast(coerceAtLeast, coerceAtLeast2);
            String str = pair.magicText;
            text.replace(coerceAtMost, coerceAtLeast3, str, 0, str.length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(SelectionDialogAction this$0, MagicText.MagicTextListener magicTextListenerMessage, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(magicTextListenerMessage, "$magicTextListenerMessage");
        MagicText.displaySelectionDialog(this$0.getActivity(), magicTextListenerMessage, this$0.getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(SelectionDialogAction this$0, AppCompatDialog dialog, LinearLayout customItemsContainer, Button okButton, final ScrollView scrollView, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(customItemsContainer, "$customItemsContainer");
        Intrinsics.checkNotNullParameter(okButton, "$okButton");
        Intrinsics.checkNotNullParameter(scrollView, "$scrollView");
        this$0.workingEntries.add(new CustomEntry(null, ContextCompat.getColor(this$0.getActivity(), R.color.default_text_color), false, false, 13, null));
        int size = this$0.workingEntries.size();
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Context context = dialog.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "dialog.context");
        this$0.S(activity, context, customItemsContainer, size, new CustomEntry(null, this$0.workingTextColor, false, false, 13, null), new d(size), new e(customItemsContainer, dialog));
        okButton.setEnabled(true);
        if (ViewCompat.isLaidOut(customItemsContainer) && !customItemsContainer.isLayoutRequested()) {
            scrollView.post(new f(scrollView));
        } else {
            customItemsContainer.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.arlosoft.macrodroid.action.SelectionDialogAction$handleItemSelected$lambda$6$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(@NotNull View view2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    Intrinsics.checkNotNullParameter(view2, "view");
                    view2.removeOnLayoutChangeListener(this);
                    ScrollView scrollView2 = scrollView;
                    scrollView2.post(new SelectionDialogAction.f(scrollView2));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(LinearLayout linearLayout, SelectionDialogAction selectionDialogAction, AppCompatDialog appCompatDialog) {
        Iterable<IndexedValue> withIndex;
        linearLayout.removeAllViews();
        withIndex = CollectionsKt___CollectionsKt.withIndex(selectionDialogAction.workingEntries);
        for (IndexedValue indexedValue : withIndex) {
            Activity activity = selectionDialogAction.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            Context context = appCompatDialog.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "dialog.context");
            selectionDialogAction.S(activity, context, linearLayout, indexedValue.getIndex() + 1, (CustomEntry) indexedValue.getValue(), new m(indexedValue), new n(linearLayout, appCompatDialog));
        }
    }

    public static /* synthetic */ int getColorFromAttr$default(SelectionDialogAction selectionDialogAction, Context context, int i4, TypedValue typedValue, boolean z3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            typedValue = new TypedValue();
        }
        if ((i5 & 4) != 0) {
            z3 = true;
        }
        return selectionDialogAction.getColorFromAttr(context, i4, typedValue, z3);
    }

    @ColorInt
    public final int getColorFromAttr(@NotNull Context context, @AttrRes int i4, @NotNull TypedValue typedValue, boolean z3) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(typedValue, "typedValue");
        context.getTheme().resolveAttribute(i4, typedValue, z3);
        return typedValue.data;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        return this.message;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return SelectionDialogActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        int collectionSizeOrDefault;
        List list;
        List listOf;
        List plus;
        List<CustomEntry> list2 = this.customEntries;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (CustomEntry customEntry : list2) {
            arrayList.add(customEntry.getText());
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        listOf = kotlin.collections.e.listOf(this.message);
        plus = CollectionsKt___CollectionsKt.plus((Collection) listOf, (Iterable) list);
        return (String[]) plus.toArray(new String[0]);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public String[] getVariableNames() {
        List listOf;
        String variableName;
        String[] strArr = new String[3];
        String str = this.dictionaryVarName;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        strArr[0] = str;
        VariableWithDictionaryKeys variableWithDictionaryKeys = this.saveIndexVariable;
        strArr[1] = (variableWithDictionaryKeys == null || (r1 = variableWithDictionaryKeys.getVariableName()) == null) ? "" : "";
        VariableWithDictionaryKeys variableWithDictionaryKeys2 = this.saveValueVariable;
        if (variableWithDictionaryKeys2 != null && (variableName = variableWithDictionaryKeys2.getVariableName()) != null) {
            str2 = variableName;
        }
        strArr[2] = str2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) strArr);
        return (String[]) listOf.toArray(new String[0]);
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    @NotNull
    public Integer[] getVariableTypes() {
        return new Integer[]{4, 1, 2};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        List<CustomEntry> mutableList;
        List listOf;
        boolean z3;
        int i4;
        boolean z4;
        String str;
        String str2;
        this.workingDictionaryVariableName = this.dictionaryVarName;
        this.workingDictionaryKeys = this.dictionaryKeys;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.customEntries);
        this.workingEntries = mutableList;
        this.workingSaveValueVariable = this.saveValueVariable;
        this.workingsaveIndexVariable = this.saveIndexVariable;
        int i5 = this.textColor;
        if (i5 == Integer.MAX_VALUE) {
            i5 = ContextCompat.getColor(getContext(), R.color.default_text_color);
        }
        this.workingTextColor = i5;
        int i6 = this.bgColor;
        if (i6 == Integer.MAX_VALUE) {
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            i6 = getColorFromAttr$default(this, activity, 16842836, null, false, 6, null);
        }
        this.workingBgColor = i6;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setTitle(R.string.action_selection_dialog);
        appCompatDialog.setContentView(R.layout.configure_selection_dialog);
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog, 0, 1, null);
        View findViewById = appCompatDialog.findViewById(R.id.dialog_message);
        Intrinsics.checkNotNull(findViewById);
        final EditText editText = (EditText) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.message_magic_text_button);
        Intrinsics.checkNotNull(findViewById2);
        View findViewById3 = appCompatDialog.findViewById(R.id.dialog_options_spinner);
        Intrinsics.checkNotNull(findViewById3);
        Spinner spinner = (Spinner) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.dictionary_array_spinner);
        Intrinsics.checkNotNull(findViewById4);
        final Spinner spinner2 = (Spinner) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.add_item_button);
        Intrinsics.checkNotNull(findViewById5);
        Button button = (Button) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.arrayItemsTopLevelContainer);
        Intrinsics.checkNotNull(findViewById6);
        final ViewGroup viewGroup = (ViewGroup) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.customItemsTopLevelContainer);
        Intrinsics.checkNotNull(findViewById7);
        final ViewGroup viewGroup2 = (ViewGroup) findViewById7;
        View findViewById8 = appCompatDialog.findViewById(R.id.customItemsContainer);
        Intrinsics.checkNotNull(findViewById8);
        final LinearLayout linearLayout = (LinearLayout) findViewById8;
        View findViewById9 = appCompatDialog.findViewById(R.id.scroll_view);
        Intrinsics.checkNotNull(findViewById9);
        final ScrollView scrollView = (ScrollView) findViewById9;
        View findViewById10 = appCompatDialog.findViewById(R.id.text_color_button);
        Intrinsics.checkNotNull(findViewById10);
        MaterialCardView materialCardView = (MaterialCardView) findViewById10;
        View findViewById11 = appCompatDialog.findViewById(R.id.bg_color_button);
        Intrinsics.checkNotNull(findViewById11);
        MaterialCardView materialCardView2 = (MaterialCardView) findViewById11;
        View findViewById12 = appCompatDialog.findViewById(R.id.background_color_label);
        Intrinsics.checkNotNull(findViewById12);
        TextView textView = (TextView) findViewById12;
        View findViewById13 = appCompatDialog.findViewById(R.id.text_color_label);
        Intrinsics.checkNotNull(findViewById13);
        TextView textView2 = (TextView) findViewById13;
        View findViewById14 = appCompatDialog.findViewById(R.id.save_index_spinner);
        Intrinsics.checkNotNull(findViewById14);
        Spinner spinner3 = (Spinner) findViewById14;
        View findViewById15 = appCompatDialog.findViewById(R.id.add_numerical_variable_button);
        Intrinsics.checkNotNull(findViewById15);
        View findViewById16 = appCompatDialog.findViewById(R.id.save_value_spinner);
        Intrinsics.checkNotNull(findViewById16);
        Spinner spinner4 = (Spinner) findViewById16;
        View findViewById17 = appCompatDialog.findViewById(R.id.add_string_variable_button);
        Intrinsics.checkNotNull(findViewById17);
        View findViewById18 = appCompatDialog.findViewById(R.id.prevent_back_button_checkbox);
        Intrinsics.checkNotNull(findViewById18);
        CheckBox checkBox = (CheckBox) findViewById18;
        View findViewById19 = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById19);
        final Button button2 = (Button) findViewById19;
        View findViewById20 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById20);
        Button button3 = (Button) findViewById20;
        listOf = kotlin.collections.e.listOf(SelectableItem.r(R.string.none));
        ViewExtensionsKt.onClick$default((Button) findViewById15, null, new SelectionDialogAction$handleItemSelected$1(this, spinner3, listOf, null), 1, null);
        ViewExtensionsKt.onClick$default((Button) findViewById17, null, new SelectionDialogAction$handleItemSelected$2(this, spinner4, listOf, null), 1, null);
        editText.setText(this.message);
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.ih
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SelectionDialogAction.Y(editText, magicTextPair);
            }
        };
        ((Button) findViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.jh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectionDialogAction.Z(SelectionDialogAction.this, magicTextListener, view);
            }
        });
        checkBox.setChecked(this.preventBackButtonClose);
        ViewExtensionsKt.itemSelected(spinner, new Function1<Integer, Unit>() { // from class: com.arlosoft.macrodroid.action.SelectionDialogAction$handleItemSelected$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i7) {
                List emptyList;
                String str3;
                DictionaryKeys dictionaryKeys;
                if (i7 == 1) {
                    if (SelectionDialogAction.this.getAllDictionaryAndArrayVariables().isEmpty()) {
                        ToastCompat.makeText(SelectionDialogAction.this.getContext(), (int) R.string.no_dictionary_or_array_variables_defined, 1).show();
                        return;
                    }
                    if ((spinner2.getChildCount() == 0) && !SelectionDialogAction.this.getAllDictionaryAndArrayVariables().isEmpty()) {
                        Activity activity2 = SelectionDialogAction.this.getActivity();
                        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                        SelectionDialogAction selectionDialogAction = SelectionDialogAction.this;
                        Spinner spinner5 = spinner2;
                        Macro macro = selectionDialogAction.getMacro();
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        if (SelectionDialogAction.this.workingDictionaryVariableName != null) {
                            String str4 = SelectionDialogAction.this.workingDictionaryVariableName;
                            dictionaryKeys = SelectionDialogAction.this.dictionaryKeys;
                            str3 = str4 + VariableHelper.getFormattedDictionaryKeys(dictionaryKeys);
                        } else {
                            str3 = null;
                        }
                        String str5 = str3;
                        final SelectionDialogAction selectionDialogAction2 = SelectionDialogAction.this;
                        VariableHelper.configureDictionaryAndArrayVarSpinner(activity2, R.style.Theme_App_Dialog_Action, selectionDialogAction, spinner5, macro, emptyList, str5, false, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.SelectionDialogAction$handleItemSelected$4.1
                            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
                            public void customItemSelected(int i8, @NotNull String value) {
                                Intrinsics.checkNotNullParameter(value, "value");
                            }

                            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
                            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                                DictionaryKeys dictionaryKeys2;
                                Intrinsics.checkNotNullParameter(variable, "variable");
                                SelectionDialogAction.this.workingDictionaryVariableName = variable.getName();
                                SelectionDialogAction selectionDialogAction3 = SelectionDialogAction.this;
                                if (list != null) {
                                    dictionaryKeys2 = new DictionaryKeys(list);
                                } else {
                                    dictionaryKeys2 = null;
                                }
                                selectionDialogAction3.workingDictionaryKeys = dictionaryKeys2;
                            }
                        });
                    }
                }
                viewGroup2.setVisibility(i7 == 0 ? 0 : 8);
                viewGroup.setVisibility(i7 == 1 ? 0 : 8);
            }
        });
        spinner.setSelection(this.option);
        if (this.option == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        int i7 = 8;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        viewGroup2.setVisibility(i4);
        if (this.option == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            i7 = 0;
        }
        viewGroup.setVisibility(i7);
        materialCardView.setCardBackgroundColor(this.workingTextColor);
        ViewExtensionsKt.onClick$default(materialCardView, null, new i(materialCardView, null), 1, null);
        ViewExtensionsKt.onClick$default(textView2, null, new j(materialCardView, null), 1, null);
        materialCardView2.setCardBackgroundColor(this.workingBgColor);
        ViewExtensionsKt.onClick$default(materialCardView2, null, new k(materialCardView2, null), 1, null);
        ViewExtensionsKt.onClick$default(textView, null, new l(materialCardView2, null), 1, null);
        b0(linearLayout, this, appCompatDialog);
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        Macro macro = getMacro();
        VariableWithDictionaryKeys variableWithDictionaryKeys = this.workingsaveIndexVariable;
        if (variableWithDictionaryKeys != null) {
            Intrinsics.checkNotNull(variableWithDictionaryKeys);
            String variableName = variableWithDictionaryKeys.getVariableName();
            VariableWithDictionaryKeys variableWithDictionaryKeys2 = this.workingsaveIndexVariable;
            Intrinsics.checkNotNull(variableWithDictionaryKeys2);
            str = variableName + VariableHelper.getFormattedDictionaryKeys(variableWithDictionaryKeys2.getKeys());
        } else {
            str = null;
        }
        VariableHelper.configureNumberVarSpinner(activity2, R.style.Theme_App_Dialog_Action, this, spinner3, macro, listOf, str, "", false, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.SelectionDialogAction$handleItemSelected$9
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i8, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                SelectionDialogAction.this.workingsaveIndexVariable = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                Intrinsics.checkNotNullParameter(variable, "variable");
                SelectionDialogAction selectionDialogAction = SelectionDialogAction.this;
                String name = variable.getName();
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                selectionDialogAction.workingsaveIndexVariable = new VariableWithDictionaryKeys(name, new DictionaryKeys(list));
            }
        });
        Activity activity3 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity3, "activity");
        Macro macro2 = getMacro();
        VariableWithDictionaryKeys variableWithDictionaryKeys3 = this.workingSaveValueVariable;
        if (variableWithDictionaryKeys3 != null) {
            Intrinsics.checkNotNull(variableWithDictionaryKeys3);
            String variableName2 = variableWithDictionaryKeys3.getVariableName();
            VariableWithDictionaryKeys variableWithDictionaryKeys4 = this.workingSaveValueVariable;
            Intrinsics.checkNotNull(variableWithDictionaryKeys4);
            str2 = variableName2 + VariableHelper.getFormattedDictionaryKeys(variableWithDictionaryKeys4.getKeys());
        } else {
            str2 = null;
        }
        VariableHelper.configureStringVarSpinner(activity3, R.style.Theme_App_Dialog_Action, this, spinner4, macro2, listOf, str2, false, null, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.SelectionDialogAction$handleItemSelected$10
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i8, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                SelectionDialogAction.this.workingSaveValueVariable = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                Intrinsics.checkNotNullParameter(variable, "variable");
                SelectionDialogAction selectionDialogAction = SelectionDialogAction.this;
                String name = variable.getName();
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                selectionDialogAction.workingSaveValueVariable = new VariableWithDictionaryKeys(name, new DictionaryKeys(list));
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.kh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectionDialogAction.a0(SelectionDialogAction.this, appCompatDialog, linearLayout, button2, scrollView, view);
            }
        });
        button2.setEnabled(true);
        ViewExtensionsKt.onClick$default(button2, null, new g(spinner, this, editText, checkBox, appCompatDialog, null), 1, null);
        ViewExtensionsKt.onClick$default(button3, null, new h(appCompatDialog, null), 1, null);
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        int collectionSizeOrDefault;
        List<CustomEntry> mutableList;
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == this.customEntries.size() + 1) {
            int i4 = 0;
            this.message = magicText[0];
            List<CustomEntry> list = this.customEntries;
            collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (Object obj : list) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(CustomEntry.copy$default((CustomEntry) obj, magicText[i5], 0, false, false, 14, null));
                i4 = i5;
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
            this.customEntries = mutableList;
            return;
        }
        SystemLog.logError("Invalid number of magic text entries for SelectionDialogAction");
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableNames
    public void setVariableNames(@NotNull String[] varNames) {
        VariableWithDictionaryKeys variableWithDictionaryKeys;
        VariableWithDictionaryKeys variableWithDictionaryKeys2;
        VariableWithDictionaryKeys variableWithDictionaryKeys3;
        Intrinsics.checkNotNullParameter(varNames, "varNames");
        if (varNames.length == 3) {
            this.dictionaryVarName = varNames[0];
            String str = varNames[1];
            VariableWithDictionaryKeys variableWithDictionaryKeys4 = null;
            if (str != null && (variableWithDictionaryKeys3 = this.saveIndexVariable) != null) {
                variableWithDictionaryKeys = VariableWithDictionaryKeys.copy$default(variableWithDictionaryKeys3, str, null, 2, null);
            } else {
                variableWithDictionaryKeys = null;
            }
            this.saveIndexVariable = variableWithDictionaryKeys;
            String str2 = varNames[2];
            if (str2 != null && (variableWithDictionaryKeys2 = this.saveValueVariable) != null) {
                variableWithDictionaryKeys4 = VariableWithDictionaryKeys.copy$default(variableWithDictionaryKeys2, str2, null, 2, null);
            }
            this.saveValueVariable = variableWithDictionaryKeys4;
            return;
        }
        SystemLog.logError("Invalid number of variable names for SelectionDialogAction");
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
        out.writeString(this.message);
        out.writeInt(this.textColor);
        out.writeInt(this.bgColor);
        out.writeString(this.dictionaryVarName);
        out.writeParcelable(this.dictionaryKeys, i4);
        out.writeParcelable(this.saveIndexVariable, i4);
        out.writeParcelable(this.saveValueVariable, i4);
        out.writeInt(this.preventBackButtonClose ? 1 : 0);
        if (Build.VERSION.SDK_INT >= 29) {
            out.writeParcelableList(this.customEntries, i4);
            return;
        }
        List<CustomEntry> list = this.customEntries;
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<com.arlosoft.macrodroid.beacons.BeaconWithName>");
        out.writeList(list);
    }

    public SelectionDialogAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        String replace$default;
        List arrayList;
        int collectionSizeOrDefault;
        List<String> emptyList;
        List<VariableValue.DictionaryEntry> entries;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        String messageWithMagicText = MagicText.replaceMagicText(getContext(), this.message, triggerContextInfo, getMacro());
        Intrinsics.checkNotNullExpressionValue(messageWithMagicText, "messageWithMagicText");
        replace$default = kotlin.text.m.replace$default(messageWithMagicText, "\\n", "\n", false, 4, (Object) null);
        if (this.option == 1) {
            MacroDroidVariable variableByName = getMacro().getVariableByName(this.dictionaryVarName);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            DictionaryKeys dictionaryKeys = this.dictionaryKeys;
            if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            VariableValue.Dictionary dictionaryFromKeyList$default = variableByName != null ? MacroDroidVariable.getDictionaryFromKeyList$default(variableByName, VariableHelper.applyMagicTextToDictionaryKeys(context, emptyList, triggerContextInfo, getMacro()), false, false, 6, null) : null;
            if (dictionaryFromKeyList$default == null || (entries = dictionaryFromKeyList$default.getEntries()) == null) {
                arrayList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                List<VariableValue.DictionaryEntry> list = entries;
                collectionSizeOrDefault2 = kotlin.collections.f.collectionSizeOrDefault(list, 10);
                arrayList = new ArrayList(collectionSizeOrDefault2);
                for (VariableValue.DictionaryEntry dictionaryEntry : list) {
                    arrayList.add(new CustomEntry(dictionaryEntry.getVariable().getValueAsText(), this.textColor, false, false, 12, null));
                }
            }
        } else {
            List<CustomEntry> list2 = this.customEntries;
            collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list2, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            for (CustomEntry customEntry : list2) {
                String replaceMagicText = MagicText.replaceMagicText(getContext(), customEntry.getText(), triggerContextInfo, getMacro());
                Intrinsics.checkNotNullExpressionValue(replaceMagicText, "replaceMagicText(context…text, contextInfo, macro)");
                arrayList.add(CustomEntry.copy$default(customEntry, replaceMagicText, 0, false, false, 14, null));
            }
        }
        List list3 = arrayList;
        if (list3.isEmpty()) {
            ToastCompat.makeText(getContext(), (int) R.string.variable_multi_entry_no_entries, 0).show();
            String r4 = SelectableItem.r(R.string.action_selection_dialog_no_entries_to_show);
            Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.actio…ialog_no_entries_to_show)");
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError(r4, macroGuid.longValue());
            return;
        }
        SelectionDialogActivity.Companion companion = SelectionDialogActivity.Companion;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        Long macroGuid2 = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
        companion.showSelectionDialog(context2, macroGuid2.longValue(), replace$default, this.textColor, this.bgColor, this.saveIndexVariable, this.saveValueVariable, this.preventBackButtonClose, new ArrayList<>(list3), triggerContextInfo, getMacro().getTriggerThatInvoked(), i4, skipEndifIndexStack, z3, z4, resumeMacroInfo);
    }

    public SelectionDialogAction() {
        this.message = "";
        this.textColor = Integer.MAX_VALUE;
        this.bgColor = Integer.MAX_VALUE;
        this.customEntries = new ArrayList();
        this.workingTextColor = this.textColor;
        this.workingBgColor = this.bgColor;
        this.workingEntries = new ArrayList();
    }

    private SelectionDialogAction(Parcel parcel) {
        super(parcel);
        this.message = "";
        this.textColor = Integer.MAX_VALUE;
        this.bgColor = Integer.MAX_VALUE;
        this.customEntries = new ArrayList();
        this.workingTextColor = this.textColor;
        this.workingBgColor = this.bgColor;
        this.workingEntries = new ArrayList();
        this.option = parcel.readInt();
        String readString = parcel.readString();
        this.message = readString != null ? readString : "";
        this.textColor = parcel.readInt();
        this.bgColor = parcel.readInt();
        this.dictionaryVarName = parcel.readString();
        this.dictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
        this.saveIndexVariable = (VariableWithDictionaryKeys) parcel.readParcelable(VariableWithDictionaryKeys.class.getClassLoader());
        this.saveValueVariable = (VariableWithDictionaryKeys) parcel.readParcelable(VariableWithDictionaryKeys.class.getClassLoader());
        this.preventBackButtonClose = parcel.readInt() != 0;
        if (Build.VERSION.SDK_INT >= 29) {
            parcel.readParcelableList(this.customEntries, CustomEntry.class.getClassLoader());
            return;
        }
        List<CustomEntry> list = this.customEntries;
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<com.arlosoft.macrodroid.action.CustomEntry>");
        parcel.readList(list, CustomEntry.class.getClassLoader());
    }

    /* compiled from: SelectionDialogAction.kt */
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
