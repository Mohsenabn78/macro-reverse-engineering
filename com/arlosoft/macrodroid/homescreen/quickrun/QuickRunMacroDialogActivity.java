package com.arlosoft.macrodroid.homescreen.quickrun;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.databinding.DialogQuickRunMacroBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.InvokedByQuickRunTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.widget.SquareMinDimensionMaterialCardView;
import com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: QuickRunMacroDialogActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nQuickRunMacroDialogActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QuickRunMacroDialogActivity.kt\ncom/arlosoft/macrodroid/homescreen/quickrun/QuickRunMacroDialogActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,150:1\n68#2,4:151\n40#2:155\n56#2:156\n75#2:157\n68#2,4:158\n40#2:162\n56#2:163\n75#2:164\n262#2,2:176\n262#2,2:178\n262#2,2:180\n262#2,2:182\n262#2,2:184\n766#3:165\n857#3:166\n1549#3:167\n1620#3,3:168\n858#3:171\n1549#3:172\n1620#3,3:173\n*S KotlinDebug\n*F\n+ 1 QuickRunMacroDialogActivity.kt\ncom/arlosoft/macrodroid/homescreen/quickrun/QuickRunMacroDialogActivity\n*L\n46#1:151,4\n46#1:155\n46#1:156\n46#1:157\n65#1:158,4\n65#1:162\n65#1:163\n65#1:164\n95#1:176,2\n141#1:178,2\n143#1:180,2\n145#1:182,2\n147#1:184,2\n75#1:165\n75#1:166\n75#1:167\n75#1:168,3\n75#1:171\n75#1:172\n75#1:173,3\n*E\n"})
/* loaded from: classes3.dex */
public final class QuickRunMacroDialogActivity extends MacroDroidBaseActivity {
    public static final int $stable = 8;

    /* renamed from: f  reason: collision with root package name */
    private DialogQuickRunMacroBinding f12388f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final QuickRunMacroDialogActivity$backCallback$1 f12389g = new OnBackPressedCallback() { // from class: com.arlosoft.macrodroid.homescreen.quickrun.QuickRunMacroDialogActivity$backCallback$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            QuickRunMacroDialogActivity.this.n();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QuickRunMacroDialogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        a(Continuation<? super a> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                QuickRunMacroDialogActivity.this.n();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QuickRunMacroDialogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        b(Continuation<? super b> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                QuickRunMacroDialogActivity.this.startActivity(new Intent(QuickRunMacroDialogActivity.this, QuickRunAddMacrosActivity.class));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QuickRunMacroDialogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ QuickRunMacroAdapter $macroAdapter;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(QuickRunMacroAdapter quickRunMacroAdapter, Continuation<? super c> continuation) {
            super(3, continuation);
            this.$macroAdapter = quickRunMacroAdapter;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(this.$macroAdapter, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            int i4;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                DialogQuickRunMacroBinding dialogQuickRunMacroBinding = QuickRunMacroDialogActivity.this.f12388f;
                if (dialogQuickRunMacroBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogQuickRunMacroBinding = null;
                }
                ImageView imageView = dialogQuickRunMacroBinding.editButton;
                if (this.$macroAdapter.isInEditMode()) {
                    i4 = R.drawable.ic_mode_edit_white_24dp;
                } else {
                    i4 = R.drawable.ic_pencil_off;
                }
                imageView.setImageResource(i4);
                QuickRunMacroAdapter quickRunMacroAdapter = this.$macroAdapter;
                quickRunMacroAdapter.showEditMode(!quickRunMacroAdapter.isInEditMode());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding = this.f12388f;
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding2 = null;
        if (dialogQuickRunMacroBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding = null;
        }
        dialogQuickRunMacroBinding.title.animate().alpha(0.0f).setDuration(100L);
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding3 = this.f12388f;
        if (dialogQuickRunMacroBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding3 = null;
        }
        dialogQuickRunMacroBinding3.emptyText.animate().alpha(0.0f).setDuration(100L);
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding4 = this.f12388f;
        if (dialogQuickRunMacroBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogQuickRunMacroBinding2 = dialogQuickRunMacroBinding4;
        }
        dialogQuickRunMacroBinding2.macroGrid.animate().alpha(0.0f).setDuration(100L);
        new Handler().postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.homescreen.quickrun.j
            @Override // java.lang.Runnable
            public final void run() {
                QuickRunMacroDialogActivity.o(QuickRunMacroDialogActivity.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(QuickRunMacroDialogActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f12389g.remove();
            super.onBackPressed();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        int collectionSizeOrDefault;
        List mutableList;
        boolean z3;
        int i4;
        int i5;
        int collectionSizeOrDefault2;
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding = this.f12388f;
        if (dialogQuickRunMacroBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding = null;
        }
        SquareMinDimensionMaterialCardView squareMinDimensionMaterialCardView = dialogQuickRunMacroBinding.tileContainer;
        Intrinsics.checkNotNullExpressionValue(squareMinDimensionMaterialCardView, "binding.tileContainer");
        if (ViewCompat.isLaidOut(squareMinDimensionMaterialCardView) && !squareMinDimensionMaterialCardView.isLayoutRequested()) {
            DialogQuickRunMacroBinding dialogQuickRunMacroBinding2 = this.f12388f;
            if (dialogQuickRunMacroBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogQuickRunMacroBinding2 = null;
            }
            ViewGroup.LayoutParams layoutParams = dialogQuickRunMacroBinding2.topLevelContainer.getLayoutParams();
            DialogQuickRunMacroBinding dialogQuickRunMacroBinding3 = this.f12388f;
            if (dialogQuickRunMacroBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogQuickRunMacroBinding3 = null;
            }
            layoutParams.width = dialogQuickRunMacroBinding3.tileContainer.getWidth();
            DialogQuickRunMacroBinding dialogQuickRunMacroBinding4 = this.f12388f;
            if (dialogQuickRunMacroBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogQuickRunMacroBinding4 = null;
            }
            ViewGroup.LayoutParams layoutParams2 = dialogQuickRunMacroBinding4.topLevelContainer.getLayoutParams();
            DialogQuickRunMacroBinding dialogQuickRunMacroBinding5 = this.f12388f;
            if (dialogQuickRunMacroBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogQuickRunMacroBinding5 = null;
            }
            layoutParams2.height = dialogQuickRunMacroBinding5.tileContainer.getHeight();
        } else {
            squareMinDimensionMaterialCardView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.arlosoft.macrodroid.homescreen.quickrun.QuickRunMacroDialogActivity$configureUi$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(@NotNull View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.removeOnLayoutChangeListener(this);
                    DialogQuickRunMacroBinding dialogQuickRunMacroBinding6 = QuickRunMacroDialogActivity.this.f12388f;
                    DialogQuickRunMacroBinding dialogQuickRunMacroBinding7 = null;
                    if (dialogQuickRunMacroBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogQuickRunMacroBinding6 = null;
                    }
                    ViewGroup.LayoutParams layoutParams3 = dialogQuickRunMacroBinding6.topLevelContainer.getLayoutParams();
                    DialogQuickRunMacroBinding dialogQuickRunMacroBinding8 = QuickRunMacroDialogActivity.this.f12388f;
                    if (dialogQuickRunMacroBinding8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogQuickRunMacroBinding8 = null;
                    }
                    layoutParams3.width = dialogQuickRunMacroBinding8.tileContainer.getWidth();
                    DialogQuickRunMacroBinding dialogQuickRunMacroBinding9 = QuickRunMacroDialogActivity.this.f12388f;
                    if (dialogQuickRunMacroBinding9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        dialogQuickRunMacroBinding9 = null;
                    }
                    ViewGroup.LayoutParams layoutParams4 = dialogQuickRunMacroBinding9.topLevelContainer.getLayoutParams();
                    DialogQuickRunMacroBinding dialogQuickRunMacroBinding10 = QuickRunMacroDialogActivity.this.f12388f;
                    if (dialogQuickRunMacroBinding10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        dialogQuickRunMacroBinding7 = dialogQuickRunMacroBinding10;
                    }
                    layoutParams4.height = dialogQuickRunMacroBinding7.tileContainer.getHeight();
                }
            });
        }
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding6 = this.f12388f;
        if (dialogQuickRunMacroBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding6 = null;
        }
        FrameLayout frameLayout = dialogQuickRunMacroBinding6.mainContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.mainContainer");
        ViewExtensionsKt.onClick$default(frameLayout, null, new a(null), 1, null);
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding7 = this.f12388f;
        if (dialogQuickRunMacroBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding7 = null;
        }
        dialogQuickRunMacroBinding7.macroGrid.setLayoutManager(new GridLayoutManager(this, 2));
        final MacroStore macroStore = MacroStore.getInstance();
        final List<Macro> allMacros = macroStore.getAllCompletedMacros();
        List<Long> quickRunMacroGuids = Settings.getQuickRunMacroGuids(this);
        Intrinsics.checkNotNullExpressionValue(quickRunMacroGuids, "getQuickRunMacroGuids(this)");
        ArrayList<Long> arrayList = new ArrayList();
        for (Object obj : quickRunMacroGuids) {
            Long l4 = (Long) obj;
            Intrinsics.checkNotNullExpressionValue(allMacros, "allMacros");
            List<Macro> list = allMacros;
            collectionSizeOrDefault2 = kotlin.collections.f.collectionSizeOrDefault(list, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            for (Macro macro : list) {
                arrayList2.add(Long.valueOf(macro.getGUID()));
            }
            if (arrayList2.contains(l4)) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        for (Long it : arrayList) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList3.add(macroStore.getMacroByGUID(it.longValue()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
        final QuickRunMacroAdapter quickRunMacroAdapter = new QuickRunMacroAdapter(mutableList);
        quickRunMacroAdapter.setMacroSelectedListener(new MacroSelectionListener() { // from class: com.arlosoft.macrodroid.homescreen.quickrun.QuickRunMacroDialogActivity$configureUi$3
            @Override // com.arlosoft.macrodroid.homescreen.quickrun.MacroSelectionListener
            public void onMacroDeleted(@NotNull Macro macro2) {
                int collectionSizeOrDefault3;
                boolean z4;
                Intrinsics.checkNotNullParameter(macro2, "macro");
                List<Long> macroGuidList = Settings.getQuickRunMacroGuids(QuickRunMacroDialogActivity.this);
                macroGuidList.remove(Long.valueOf(macro2.getGUID()));
                Settings.setQuickRunMacroGuids(QuickRunMacroDialogActivity.this, macroGuidList);
                Intrinsics.checkNotNullExpressionValue(macroGuidList, "macroGuidList");
                List<Long> list2 = macroGuidList;
                MacroStore macroStore2 = macroStore;
                collectionSizeOrDefault3 = kotlin.collections.f.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault3);
                for (Long it2 : list2) {
                    Intrinsics.checkNotNullExpressionValue(it2, "it");
                    arrayList4.add(macroStore2.getMacroByGUID(it2.longValue()));
                }
                quickRunMacroAdapter.removeMacro(macro2);
                QuickRunMacroDialogActivity.this.q(arrayList4, allMacros.isEmpty());
                DialogQuickRunMacroBinding dialogQuickRunMacroBinding8 = QuickRunMacroDialogActivity.this.f12388f;
                if (dialogQuickRunMacroBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogQuickRunMacroBinding8 = null;
                }
                ImageView imageView = dialogQuickRunMacroBinding8.addButton;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.addButton");
                int size = macroStore.getAllCompletedMacros().size();
                int size2 = arrayList4.size();
                int i6 = 0;
                if (size > size2) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!z4) {
                    i6 = 8;
                }
                imageView.setVisibility(i6);
            }

            @Override // com.arlosoft.macrodroid.homescreen.quickrun.MacroSelectionListener
            public void onMacroSelected(@NotNull Macro macro2) {
                Intrinsics.checkNotNullParameter(macro2, "macro");
                macro2.setTriggerThatInvoked(InvokedByQuickRunTrigger.getInstance());
                macro2.invokeActions(new TriggerContextInfo(QuickRunMacroDialogActivity.class.getSimpleName()), true);
                QuickRunMacroDialogActivity.this.finish();
            }
        });
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding8 = this.f12388f;
        if (dialogQuickRunMacroBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding8 = null;
        }
        ImageView imageView = dialogQuickRunMacroBinding8.addButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.addButton");
        if (macroStore.getAllCompletedMacros().size() > arrayList3.size()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        imageView.setVisibility(i4);
        q(arrayList3, allMacros.isEmpty());
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding9 = this.f12388f;
        if (dialogQuickRunMacroBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding9 = null;
        }
        ImageView imageView2 = dialogQuickRunMacroBinding9.addButton;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.addButton");
        ViewExtensionsKt.onClick$default(imageView2, null, new b(null), 1, null);
        RecyclerViewDragDropManager recyclerViewDragDropManager = new RecyclerViewDragDropManager();
        RecyclerView.Adapter createWrappedAdapter = recyclerViewDragDropManager.createWrappedAdapter(quickRunMacroAdapter);
        Intrinsics.checkNotNullExpressionValue(createWrappedAdapter, "dragDropManager.createWrappedAdapter(macroAdapter)");
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding10 = this.f12388f;
        if (dialogQuickRunMacroBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding10 = null;
        }
        dialogQuickRunMacroBinding10.macroGrid.setAdapter(createWrappedAdapter);
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding11 = this.f12388f;
        if (dialogQuickRunMacroBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding11 = null;
        }
        dialogQuickRunMacroBinding11.title.animate().alpha(1.0f).setDuration(500L);
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding12 = this.f12388f;
        if (dialogQuickRunMacroBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding12 = null;
        }
        dialogQuickRunMacroBinding12.emptyText.animate().alpha(1.0f).setDuration(500L);
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding13 = this.f12388f;
        if (dialogQuickRunMacroBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding13 = null;
        }
        dialogQuickRunMacroBinding13.macroGrid.animate().alpha(1.0f).setDuration(500L);
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding14 = this.f12388f;
        if (dialogQuickRunMacroBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding14 = null;
        }
        dialogQuickRunMacroBinding14.addButton.animate().alpha(1.0f).setDuration(500L);
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding15 = this.f12388f;
        if (dialogQuickRunMacroBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding15 = null;
        }
        dialogQuickRunMacroBinding15.editButton.animate().alpha(1.0f).setDuration(500L);
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding16 = this.f12388f;
        if (dialogQuickRunMacroBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding16 = null;
        }
        RecyclerView.ItemAnimator itemAnimator = dialogQuickRunMacroBinding16.macroGrid.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        recyclerViewDragDropManager.setInitiateOnMove(false);
        recyclerViewDragDropManager.setInitiateOnLongPress(true);
        recyclerViewDragDropManager.setDraggingItemAlpha(1.0f);
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding17 = this.f12388f;
        if (dialogQuickRunMacroBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding17 = null;
        }
        recyclerViewDragDropManager.attachRecyclerView(dialogQuickRunMacroBinding17.macroGrid);
        recyclerViewDragDropManager.setOnItemDragEventListener(new RecyclerViewDragDropManager.OnItemDragEventListener() { // from class: com.arlosoft.macrodroid.homescreen.quickrun.QuickRunMacroDialogActivity$configureUi$5
            @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.OnItemDragEventListener
            public void onItemDragFinished(int i6, int i7, boolean z4) {
                int collectionSizeOrDefault3;
                QuickRunMacroDialogActivity quickRunMacroDialogActivity = QuickRunMacroDialogActivity.this;
                List<Macro> macros = quickRunMacroAdapter.getMacros();
                collectionSizeOrDefault3 = kotlin.collections.f.collectionSizeOrDefault(macros, 10);
                ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault3);
                for (Macro macro2 : macros) {
                    arrayList4.add(Long.valueOf(macro2.getGUID()));
                }
                Settings.setQuickRunMacroGuids(quickRunMacroDialogActivity, arrayList4);
            }

            @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.OnItemDragEventListener
            public void onItemDragStarted(int i6) {
            }

            @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.OnItemDragEventListener
            public void onItemDragMoveDistanceUpdated(int i6, int i7) {
            }

            @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.OnItemDragEventListener
            public void onItemDragPositionChanged(int i6, int i7) {
            }
        });
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding18 = this.f12388f;
        if (dialogQuickRunMacroBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding18 = null;
        }
        ImageView imageView3 = dialogQuickRunMacroBinding18.editButton;
        if (quickRunMacroAdapter.isInEditMode()) {
            i5 = R.drawable.ic_pencil_off;
        } else {
            i5 = R.drawable.ic_mode_edit_white_24dp;
        }
        imageView3.setImageResource(i5);
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding19 = this.f12388f;
        if (dialogQuickRunMacroBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding19 = null;
        }
        ImageView imageView4 = dialogQuickRunMacroBinding19.editButton;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.editButton");
        ViewExtensionsKt.onClick$default(imageView4, null, new c(quickRunMacroAdapter, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(List<? extends Macro> list, boolean z3) {
        int i4;
        int i5 = 4;
        int i6 = 8;
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding = null;
        if (z3) {
            DialogQuickRunMacroBinding dialogQuickRunMacroBinding2 = this.f12388f;
            if (dialogQuickRunMacroBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogQuickRunMacroBinding2 = null;
            }
            TextView textView = dialogQuickRunMacroBinding2.emptyText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.emptyText");
            textView.setVisibility(0);
            DialogQuickRunMacroBinding dialogQuickRunMacroBinding3 = this.f12388f;
            if (dialogQuickRunMacroBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogQuickRunMacroBinding3 = null;
            }
            dialogQuickRunMacroBinding3.macroGrid.setVisibility(4);
            DialogQuickRunMacroBinding dialogQuickRunMacroBinding4 = this.f12388f;
            if (dialogQuickRunMacroBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogQuickRunMacroBinding = dialogQuickRunMacroBinding4;
            }
            ImageView imageView = dialogQuickRunMacroBinding.editButton;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.editButton");
            imageView.setVisibility(8);
            return;
        }
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding5 = this.f12388f;
        if (dialogQuickRunMacroBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding5 = null;
        }
        TextView textView2 = dialogQuickRunMacroBinding5.emptyText;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.emptyText");
        if (list.isEmpty()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView2.setVisibility(i4);
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding6 = this.f12388f;
        if (dialogQuickRunMacroBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding6 = null;
        }
        RecyclerView recyclerView = dialogQuickRunMacroBinding6.macroGrid;
        List<? extends Macro> list2 = list;
        if (!list2.isEmpty()) {
            i5 = 0;
        }
        recyclerView.setVisibility(i5);
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding7 = this.f12388f;
        if (dialogQuickRunMacroBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogQuickRunMacroBinding = dialogQuickRunMacroBinding7;
        }
        ImageView imageView2 = dialogQuickRunMacroBinding.editButton;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.editButton");
        if (!list2.isEmpty()) {
            i6 = 0;
        }
        imageView2.setVisibility(i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DialogQuickRunMacroBinding inflate = DialogQuickRunMacroBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f12388f = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        getOnBackPressedDispatcher().addCallback(this.f12389g);
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        DialogQuickRunMacroBinding dialogQuickRunMacroBinding = this.f12388f;
        if (dialogQuickRunMacroBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogQuickRunMacroBinding = null;
        }
        FrameLayout root = dialogQuickRunMacroBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        if (ViewCompat.isLaidOut(root) && !root.isLayoutRequested()) {
            p();
        } else {
            root.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.arlosoft.macrodroid.homescreen.quickrun.QuickRunMacroDialogActivity$onResume$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(@NotNull View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.removeOnLayoutChangeListener(this);
                    QuickRunMacroDialogActivity.this.p();
                }
            });
        }
    }
}
