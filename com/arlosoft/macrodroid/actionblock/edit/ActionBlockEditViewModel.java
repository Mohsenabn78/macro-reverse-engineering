package com.arlosoft.macrodroid.actionblock.edit;

import android.content.res.Resources;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import com.arlosoft.macrodroid.utils.ToastHelper;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActionBlockEditViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class ActionBlockEditViewModel extends ViewModel implements LifecycleObserver {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ActionBlockStore f5546a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ToastHelper f5547b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Resources f5548c;

    /* renamed from: d  reason: collision with root package name */
    private long f5549d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final MutableLiveData<ActionBlock> f5550e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final LiveData<ActionBlock> f5551f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final SingleLiveEvent<Boolean> f5552g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final SingleLiveEvent<ActionBlock> f5553h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private String f5554i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private String f5555j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5556k;

    /* compiled from: ActionBlockEditViewModel.kt */
    /* loaded from: classes.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ActionBlock $actionBlock;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ActionBlock actionBlock, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$actionBlock = actionBlock;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$actionBlock, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActionBlockEditViewModel.this.f5546a.deleteActionBlock(this.$actionBlock);
                String name = this.$actionBlock.getName();
                SystemLog.logInfo("Action Block Deleted - " + name, this.$actionBlock.getGUID());
                ActionBlockEditViewModel.this.getCloseScreenEvent().postValue(Boxing.boxBoolean(ActionBlockEditViewModel.this.f5556k ^ true));
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

    /* compiled from: ActionBlockEditViewModel.kt */
    @SourceDebugExtension({"SMAP\nActionBlockEditViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockEditViewModel.kt\ncom/arlosoft/macrodroid/actionblock/edit/ActionBlockEditViewModel$onResume$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,125:1\n1#2:126\n*E\n"})
    /* loaded from: classes.dex */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ActionBlockEditViewModel.kt */
        /* loaded from: classes.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ActionBlockEditViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ActionBlockEditViewModel actionBlockEditViewModel, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = actionBlockEditViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ToastHelper toastHelper = this.this$0.f5547b;
                    String string = this.this$0.f5548c.getString(R.string.action_block_not_found);
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…g.action_block_not_found)");
                    toastHelper.showToast(string, true);
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
            Object coroutine_suspended;
            ActionBlock actionBlockByGuid;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                if (ActionBlockEditViewModel.this.f5549d == -1) {
                    actionBlockByGuid = ActionBlock.Companion.createEmpty();
                    ActionBlockEditViewModel.this.f5546a.addActionBlock(actionBlockByGuid);
                } else {
                    actionBlockByGuid = ActionBlockEditViewModel.this.f5546a.getActionBlockByGuid(ActionBlockEditViewModel.this.f5549d);
                }
                if (actionBlockByGuid != null) {
                    String str = ActionBlockEditViewModel.this.f5554i;
                    if (str != null) {
                        actionBlockByGuid.setName(str);
                    }
                    String str2 = ActionBlockEditViewModel.this.f5555j;
                    if (str2 != null) {
                        actionBlockByGuid.setDescription(str2);
                    }
                    ActionBlockEditViewModel.this.f5550e.postValue(actionBlockByGuid);
                    return Unit.INSTANCE;
                }
                MainCoroutineDispatcher main = Dispatchers.getMain();
                a aVar = new a(ActionBlockEditViewModel.this, null);
                this.label = 1;
                if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            ActionBlockEditViewModel.this.getCloseScreenEvent().postValue(Boxing.boxBoolean(!ActionBlockEditViewModel.this.f5556k));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditViewModel.kt */
    /* loaded from: classes.dex */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ActionBlock $actionBlock;
        final /* synthetic */ boolean $closeScreen;
        final /* synthetic */ String $descriptionText;
        final /* synthetic */ boolean $isDescriptionVisible;
        final /* synthetic */ String $nameText;
        Object L$0;
        int label;
        final /* synthetic */ ActionBlockEditViewModel this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ActionBlockEditViewModel.kt */
        /* loaded from: classes.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ActionBlock $actionBlock;
            int label;
            final /* synthetic */ ActionBlockEditViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ActionBlockEditViewModel actionBlockEditViewModel, ActionBlock actionBlock, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = actionBlockEditViewModel;
                this.$actionBlock = actionBlock;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, this.$actionBlock, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.f5546a.updateActionBlock(this.$actionBlock);
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
        /* compiled from: ActionBlockEditViewModel.kt */
        /* loaded from: classes.dex */
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Macro $macro;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Macro macro, Continuation<? super b> continuation) {
                super(2, continuation);
                this.$macro = macro;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new b(this.$macro, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    MacroStore.getInstance().updateMacro(this.$macro);
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ActionBlock actionBlock, boolean z3, String str, String str2, boolean z4, ActionBlockEditViewModel actionBlockEditViewModel, Continuation<? super c> continuation) {
            super(2, continuation);
            this.$actionBlock = actionBlock;
            this.$isDescriptionVisible = z3;
            this.$nameText = str;
            this.$descriptionText = str2;
            this.$closeScreen = z4;
            this.this$0 = actionBlockEditViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(this.$actionBlock, this.$isDescriptionVisible, this.$nameText, this.$descriptionText, this.$closeScreen, this.this$0, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x008b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
            /*
                r17 = this;
                r0 = r17
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 0
                r4 = 2
                r5 = 0
                r6 = 1
                if (r2 == 0) goto L26
                if (r2 == r6) goto L22
                if (r2 != r4) goto L1a
                java.lang.Object r2 = r0.L$0
                java.util.Iterator r2 = (java.util.Iterator) r2
                kotlin.ResultKt.throwOnFailure(r18)
                goto L84
            L1a:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L22:
                kotlin.ResultKt.throwOnFailure(r18)
                goto L67
            L26:
                kotlin.ResultKt.throwOnFailure(r18)
                com.arlosoft.macrodroid.actionblock.data.ActionBlock r2 = r0.$actionBlock
                boolean r7 = r0.$isDescriptionVisible
                r2.setDescriptionOpen(r7)
                com.arlosoft.macrodroid.actionblock.data.ActionBlock r2 = r0.$actionBlock
                java.lang.String r7 = r0.$nameText
                r2.setName(r7)
                com.arlosoft.macrodroid.actionblock.data.ActionBlock r2 = r0.$actionBlock
                java.lang.String r7 = r0.$descriptionText
                r2.setDescription(r7)
                com.arlosoft.macrodroid.actionblock.data.ActionBlock r2 = r0.$actionBlock
                r2.setCompleted(r6)
                com.arlosoft.macrodroid.actionblock.data.ActionBlock r2 = r0.$actionBlock
                r2.setIsBeingImported(r5)
                com.arlosoft.macrodroid.actionblock.data.ActionBlock r2 = r0.$actionBlock
                long r7 = java.lang.System.currentTimeMillis()
                r2.setLastEditedTimestamp(r7)
                kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
                com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditViewModel$c$a r7 = new com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditViewModel$c$a
                com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditViewModel r8 = r0.this$0
                com.arlosoft.macrodroid.actionblock.data.ActionBlock r9 = r0.$actionBlock
                r7.<init>(r8, r9, r3)
                r0.label = r6
                java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r2, r7, r0)
                if (r2 != r1) goto L67
                return r1
            L67:
                boolean r2 = r0.$closeScreen
                if (r2 == 0) goto L78
                com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditViewModel r2 = r0.this$0
                com.arlosoft.macrodroid.utils.SingleLiveEvent r2 = r2.getCloseScreenEvent()
                java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
                r2.postValue(r7)
            L78:
                com.arlosoft.macrodroid.macro.MacroStore r2 = com.arlosoft.macrodroid.macro.MacroStore.getInstance()
                java.util.List r2 = r2.getAllCompletedMacrosWithActionBlocks(r5)
                java.util.Iterator r2 = r2.iterator()
            L84:
                r7 = r0
            L85:
                boolean r8 = r2.hasNext()
                if (r8 == 0) goto Le0
                java.lang.Object r8 = r2.next()
                com.arlosoft.macrodroid.macro.Macro r8 = (com.arlosoft.macrodroid.macro.Macro) r8
                java.util.ArrayList r9 = r8.getActions()
                java.util.Iterator r9 = r9.iterator()
                r10 = 0
            L9a:
                boolean r11 = r9.hasNext()
                if (r11 == 0) goto Lca
                java.lang.Object r11 = r9.next()
                com.arlosoft.macrodroid.action.Action r11 = (com.arlosoft.macrodroid.action.Action) r11
                boolean r12 = r11 instanceof com.arlosoft.macrodroid.action.ActionBlockAction
                if (r12 == 0) goto L9a
                com.arlosoft.macrodroid.actionblock.data.ActionBlock r12 = r7.$actionBlock
                long r12 = r12.getGUID()
                com.arlosoft.macrodroid.action.ActionBlockAction r11 = (com.arlosoft.macrodroid.action.ActionBlockAction) r11
                long r14 = r11.getActionBlockId()
                int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r16 != 0) goto L9a
                com.arlosoft.macrodroid.actionblock.data.ActionBlock r10 = r7.$actionBlock
                java.lang.String r10 = r10.getName()
                java.lang.String r12 = "actionBlock.name"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
                r11.setActionBlockName(r10)
                r10 = 1
                goto L9a
            Lca:
                if (r10 == 0) goto L85
                kotlinx.coroutines.MainCoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getMain()
                com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditViewModel$c$b r10 = new com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditViewModel$c$b
                r10.<init>(r8, r3)
                r7.L$0 = r2
                r7.label = r4
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r9, r10, r7)
                if (r8 != r1) goto L85
                return r1
            Le0:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditViewModel.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Inject
    public ActionBlockEditViewModel(@NotNull ActionBlockStore actionBlockStore, @NotNull ToastHelper toastHelper, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(actionBlockStore, "actionBlockStore");
        Intrinsics.checkNotNullParameter(toastHelper, "toastHelper");
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.f5546a = actionBlockStore;
        this.f5547b = toastHelper;
        this.f5548c = resources;
        this.f5549d = -1L;
        MutableLiveData<ActionBlock> mutableLiveData = new MutableLiveData<>();
        this.f5550e = mutableLiveData;
        this.f5551f = mutableLiveData;
        this.f5552g = new SingleLiveEvent<>();
        this.f5553h = new SingleLiveEvent<>();
    }

    public static /* synthetic */ void saveActionBlock$default(ActionBlockEditViewModel actionBlockEditViewModel, ActionBlock actionBlock, String str, String str2, boolean z3, boolean z4, int i4, Object obj) {
        boolean z5;
        if ((i4 & 16) != 0) {
            z5 = true;
        } else {
            z5 = z4;
        }
        actionBlockEditViewModel.saveActionBlock(actionBlock, str, str2, z3, z5);
    }

    public final void deleteActionBlock(@NotNull ActionBlock actionBlock) {
        Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new a(actionBlock, null), 2, null);
    }

    @NotNull
    public final LiveData<ActionBlock> getActionBlock() {
        return this.f5551f;
    }

    @NotNull
    public final SingleLiveEvent<ActionBlock> getCloseScreenAndShowActionBlockEvent() {
        return this.f5553h;
    }

    @NotNull
    public final SingleLiveEvent<Boolean> getCloseScreenEvent() {
        return this.f5552g;
    }

    public final void onCloneActionBlockClicked(@NotNull ActionBlock actionBlock) {
        Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        this.f5553h.postValue(actionBlock.cloneActionBlock(true, false));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new b(null), 2, null);
    }

    public final void saveActionBlock(@NotNull ActionBlock actionBlock, @NotNull String nameText, @NotNull String descriptionText, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        Intrinsics.checkNotNullParameter(nameText, "nameText");
        Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new c(actionBlock, z3, nameText, descriptionText, z4, this, null), 2, null);
    }

    public final void setActionBlockId(long j4, boolean z3) {
        this.f5556k = z3;
        this.f5549d = j4;
    }

    public final void updateDescription(@NotNull String descriptionText) {
        Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
        this.f5555j = descriptionText;
    }

    public final void updateName(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f5554i = name;
    }
}
