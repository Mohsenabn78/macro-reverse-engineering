package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.card.MaterialCardView;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SelectionDialogAction.kt */
/* loaded from: classes2.dex */
final class SelectionDialogAction$addCustomItemLayout$5 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ MaterialCardView $colorButton;
    final /* synthetic */ CustomEntry $customEntry;
    final /* synthetic */ Function1<CustomEntry, Unit> $entryUpdated;
    final /* synthetic */ Ref.ObjectRef<CustomEntry> $workingEntry;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectionDialogAction$addCustomItemLayout$5(CustomEntry customEntry, Activity activity, MaterialCardView materialCardView, Ref.ObjectRef<CustomEntry> objectRef, Function1<? super CustomEntry, Unit> function1, Continuation<? super SelectionDialogAction$addCustomItemLayout$5> continuation) {
        super(3, continuation);
        this.$customEntry = customEntry;
        this.$activity = activity;
        this.$colorButton = materialCardView;
        this.$workingEntry = objectRef;
        this.$entryUpdated = function1;
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    /* renamed from: a */
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
        return new SelectionDialogAction$addCustomItemLayout$5(this.$customEntry, this.$activity, this.$colorButton, this.$workingEntry, this.$entryUpdated, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ColorPickerDialog create = ColorPickerDialog.newBuilder().setColor(this.$customEntry.getColor()).setDialogType(1).setAllowCustom(true).setShowAlphaSlider(false).setAllowPresets(false).create();
            final MaterialCardView materialCardView = this.$colorButton;
            final Ref.ObjectRef<CustomEntry> objectRef = this.$workingEntry;
            final Function1<CustomEntry, Unit> function1 = this.$entryUpdated;
            create.setColorPickerDialogListener(new ColorPickerDialogListener() { // from class: com.arlosoft.macrodroid.action.SelectionDialogAction$addCustomItemLayout$5.1
                /* JADX WARN: Type inference failed for: r10v1, types: [T, com.arlosoft.macrodroid.action.CustomEntry] */
                @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
                public void onColorSelected(int i4, int i5) {
                    MaterialCardView.this.setCardBackgroundColor(i5);
                    Ref.ObjectRef<CustomEntry> objectRef2 = objectRef;
                    objectRef2.element = CustomEntry.copy$default(objectRef2.element, null, i5, false, false, 13, null);
                    function1.invoke(objectRef.element);
                }

                @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
                public void onDialogDismissed(int i4) {
                }
            });
            Activity activity = this.$activity;
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            create.show(((FragmentActivity) activity).getSupportFragmentManager(), (String) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
