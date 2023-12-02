package com.arlosoft.macrodroid.actionblock.list;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.actionblock.list.ActionBlockEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.EmptyTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActionBlockListViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class ActionBlockListViewModel extends ViewModel implements ActionBlockClickListener, LifecycleObserver {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ActionBlockStore f5604a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final MutableLiveData<List<ActionBlock>> f5605b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final LiveData<List<ActionBlock>> f5606c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final SingleLiveEvent<ActionBlockEvent> f5607d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final SingleLiveEvent<ActionBlock> f5608e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final SingleLiveEvent<Macro> f5609f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5610g;

    /* compiled from: ActionBlockListViewModel.kt */
    /* loaded from: classes.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActionBlock createEmpty = ActionBlock.Companion.createEmpty();
                ActionBlockListViewModel.this.f5604a.addActionBlock(createEmpty);
                ActionBlockListViewModel.this.getActionBlockEvent().postValue(new ActionBlockEvent.AddNewBlock(createEmpty));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockListViewModel.kt */
    @SourceDebugExtension({"SMAP\nActionBlockListViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockListViewModel.kt\ncom/arlosoft/macrodroid/actionblock/list/ActionBlockListViewModel$refreshActionBlocks$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n766#2:113\n857#2,2:114\n766#2:116\n857#2,2:117\n1855#2,2:119\n*S KotlinDebug\n*F\n+ 1 ActionBlockListViewModel.kt\ncom/arlosoft/macrodroid/actionblock/list/ActionBlockListViewModel$refreshActionBlocks$1\n*L\n43#1:113\n43#1:114,2\n45#1:116\n45#1:117,2\n45#1:119,2\n*E\n"})
    /* loaded from: classes.dex */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List<ActionBlock> allActionBlocksSorted = ActionBlockListViewModel.this.f5604a.getAllActionBlocksSorted();
                MutableLiveData mutableLiveData = ActionBlockListViewModel.this.f5605b;
                List<ActionBlock> list = allActionBlocksSorted;
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if (!((ActionBlock) obj2).getIsBeingImported()) {
                        arrayList.add(obj2);
                    }
                }
                mutableLiveData.postValue(arrayList);
                ArrayList<ActionBlock> arrayList2 = new ArrayList();
                for (Object obj3 : list) {
                    if (((ActionBlock) obj3).getIsBeingImported()) {
                        arrayList2.add(obj3);
                    }
                }
                ActionBlockListViewModel actionBlockListViewModel = ActionBlockListViewModel.this;
                for (ActionBlock actionBlock : arrayList2) {
                    actionBlockListViewModel.f5604a.deleteActionBlock(actionBlock);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Inject
    public ActionBlockListViewModel(@NotNull ActionBlockStore actionBlockStore) {
        Intrinsics.checkNotNullParameter(actionBlockStore, "actionBlockStore");
        this.f5604a = actionBlockStore;
        MutableLiveData<List<ActionBlock>> mutableLiveData = new MutableLiveData<>();
        this.f5605b = mutableLiveData;
        this.f5606c = mutableLiveData;
        this.f5607d = new SingleLiveEvent<>();
        this.f5608e = new SingleLiveEvent<>();
        this.f5609f = new SingleLiveEvent<>();
    }

    public final void deleteAllActionBlocks() {
        this.f5604a.deleteAllActionBlocks();
        refreshActionBlocks();
    }

    @NotNull
    public final SingleLiveEvent<ActionBlockEvent> getActionBlockEvent() {
        return this.f5607d;
    }

    @NotNull
    public final LiveData<List<ActionBlock>> getActionBlockList() {
        return this.f5606c;
    }

    @NotNull
    public final SingleLiveEvent<ActionBlock> getActionBlockSelectedEvent() {
        return this.f5608e;
    }

    @NotNull
    public final SingleLiveEvent<Macro> getNavigateToMacroEvent() {
        return this.f5609f;
    }

    @Override // com.arlosoft.macrodroid.actionblock.list.ActionBlockClickListener
    public void onActionBlockClicked(@NotNull ActionBlock actionBlock) {
        Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        if (this.f5610g) {
            this.f5608e.postValue(actionBlock);
        } else {
            this.f5607d.postValue(new ActionBlockEvent.OpenActionBlock(actionBlock));
        }
    }

    @Override // com.arlosoft.macrodroid.actionblock.list.ActionBlockClickListener
    public void onActionBlockLongClicked(@NotNull ActionBlock actionBlock) {
        Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        this.f5607d.postValue(new ActionBlockEvent.ShowActionBlockMenu(actionBlock));
    }

    @Override // com.arlosoft.macrodroid.actionblock.list.ActionBlockClickListener
    public void onActionBlockNavigateToClicked(@NotNull Macro macro) {
        Intrinsics.checkNotNullParameter(macro, "macro");
        this.f5609f.postValue(macro);
    }

    public final void onAddClicked() {
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new a(null), 2, null);
    }

    public final void onCloneActionBlockClicked(@NotNull ActionBlock actionBlock) {
        Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        this.f5607d.postValue(new ActionBlockEvent.OpenActionBlock(actionBlock.cloneActionBlock(true, false)));
    }

    public final void onDeleteClicked(@NotNull ActionBlock actionBlock) {
        Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        this.f5604a.deleteActionBlock(actionBlock);
        refreshActionBlocks();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        refreshActionBlocks();
    }

    public final void onTestActionsClicked(@NotNull ActionBlock actionBlock) {
        Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        try {
            String name = actionBlock.getName();
            SystemLog.logInfo("Testing Action Block: " + name, actionBlock.getGUID());
            TriggerContextInfo triggerContextInfo = new TriggerContextInfo(new EmptyTrigger());
            ActionBlock cloneActionBlock$default = ActionBlock.cloneActionBlock$default(actionBlock, false, false, 2, null);
            cloneActionBlock$default.setIsClonedInstance(true);
            cloneActionBlock$default.setTriggerThatInvoked(null);
            this.f5604a.addActionBlock(cloneActionBlock$default);
            cloneActionBlock$default.invokeActions(triggerContextInfo, true, null);
        } catch (Exception unused) {
        }
    }

    public final void refreshActionBlocks() {
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new b(null), 2, null);
    }

    public final void setSelectMode(boolean z3) {
        this.f5610g = z3;
    }
}
