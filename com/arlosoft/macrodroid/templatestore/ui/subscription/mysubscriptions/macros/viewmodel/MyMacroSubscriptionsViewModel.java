package com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.macros.viewmodel;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.d;
import com.arlosoft.macrodroid.app.di.annotations.ActivityScope;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.database.room.MacroSubscription;
import com.arlosoft.macrodroid.database.room.MacroSubscriptionDao;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MyMacroSubscriptionsViewModel.kt */
@StabilityInferred(parameters = 0)
@ActivityScope
@SourceDebugExtension({"SMAP\nMyMacroSubscriptionsViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyMacroSubscriptionsViewModel.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/mysubscriptions/macros/viewmodel/MyMacroSubscriptionsViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,68:1\n1#2:69\n*E\n"})
/* loaded from: classes3.dex */
public final class MyMacroSubscriptionsViewModel extends ViewModel implements DefaultLifecycleObserver {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final MacroDroidRoomDatabase f13892a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ScreenLoader f13893b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<Boolean> f13894c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final LiveData<Boolean> f13895d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final MutableLiveData<List<MacroSubscription>> f13896e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final LiveData<List<MacroSubscription>> f13897f;

    /* compiled from: MyMacroSubscriptionsViewModel.kt */
    /* loaded from: classes3.dex */
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
            Object coroutine_suspended;
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
                MyMacroSubscriptionsViewModel.this.f13894c.postValue(Boxing.boxBoolean(true));
                MacroSubscriptionDao macroSubscriptionDao = MyMacroSubscriptionsViewModel.this.f13892a.macroSubscriptionDao();
                this.label = 1;
                obj = macroSubscriptionDao.getAllMacroSubscriptions(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            MyMacroSubscriptionsViewModel.this.f13896e.postValue((List) obj);
            MyMacroSubscriptionsViewModel.this.f13894c.postValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyMacroSubscriptionsViewModel.kt */
    @SourceDebugExtension({"SMAP\nMyMacroSubscriptionsViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyMacroSubscriptionsViewModel.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/mysubscriptions/macros/viewmodel/MyMacroSubscriptionsViewModel$unsubscribeItem$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n766#2:69\n857#2,2:70\n*S KotlinDebug\n*F\n+ 1 MyMacroSubscriptionsViewModel.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/mysubscriptions/macros/viewmodel/MyMacroSubscriptionsViewModel$unsubscribeItem$3\n*L\n55#1:69\n55#1:70,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MacroSubscription $macroSubscription;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(MacroSubscription macroSubscription, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$macroSubscription = macroSubscription;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$macroSubscription, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            List mutableList;
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
                MacroSubscriptionDao macroSubscriptionDao = MyMacroSubscriptionsViewModel.this.f13892a.macroSubscriptionDao();
                int macroId = this.$macroSubscription.getMacroId();
                this.label = 1;
                if (macroSubscriptionDao.deleteMacroSubscription(macroId, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            MutableLiveData mutableLiveData = MyMacroSubscriptionsViewModel.this.f13896e;
            T value = MyMacroSubscriptionsViewModel.this.f13896e.getValue();
            Intrinsics.checkNotNull(value);
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) value);
            MacroSubscription macroSubscription = this.$macroSubscription;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : mutableList) {
                if (!Intrinsics.areEqual((MacroSubscription) obj2, macroSubscription)) {
                    arrayList.add(obj2);
                }
            }
            mutableLiveData.postValue(arrayList);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Inject
    public MyMacroSubscriptionsViewModel(@NotNull MacroDroidRoomDatabase roomDatabase, @NotNull ScreenLoader screenLoader) {
        Intrinsics.checkNotNullParameter(roomDatabase, "roomDatabase");
        Intrinsics.checkNotNullParameter(screenLoader, "screenLoader");
        this.f13892a = roomDatabase;
        this.f13893b = screenLoader;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.f13894c = mutableLiveData;
        this.f13895d = mutableLiveData;
        MutableLiveData<List<MacroSubscription>> mutableLiveData2 = new MutableLiveData<>();
        this.f13896e = mutableLiveData2;
        this.f13897f = mutableLiveData2;
    }

    private final void c(int i4) {
        this.f13893b.loadTemplateSearchScreen(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MacroSubscription macroSubscription, Task task) {
        Intrinsics.checkNotNullParameter(macroSubscription, "$macroSubscription");
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            String macroName = macroSubscription.getMacroName();
            SystemLog.logVerbose("Unsubscribed from macro: " + macroName);
            return;
        }
        String macroName2 = macroSubscription.getMacroName();
        SystemLog.logDebug("Unsubscribe failed for macro: " + macroName2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MacroSubscription macroSubscription, Exception exception) {
        Intrinsics.checkNotNullParameter(macroSubscription, "$macroSubscription");
        Intrinsics.checkNotNullParameter(exception, "exception");
        String macroName = macroSubscription.getMacroName();
        SystemLog.logDebug("Unsubscribe failed for macro: " + macroName);
    }

    public final void deleteItemAtPosition(int i4) {
        MacroSubscription macroSubscription;
        List<MacroSubscription> value = this.f13897f.getValue();
        if (value != null) {
            macroSubscription = value.get(i4);
        } else {
            macroSubscription = null;
        }
        if (macroSubscription != null) {
            unsubscribeItem(macroSubscription);
        }
    }

    @NotNull
    public final LiveData<List<MacroSubscription>> getUpdateItems() {
        return this.f13897f;
    }

    @NotNull
    public final LiveData<Boolean> isLoading() {
        return this.f13895d;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        d.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        d.b(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        d.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new a(null), 2, null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        d.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        d.f(this, lifecycleOwner);
    }

    public final void onUpdateItemClicked(@NotNull MacroSubscription macro) {
        Intrinsics.checkNotNullParameter(macro, "macro");
        c(macro.getMacroId());
    }

    public final void unsubscribeItem(@NotNull final MacroSubscription macroSubscription) {
        Intrinsics.checkNotNullParameter(macroSubscription, "macroSubscription");
        FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
        int macroId = macroSubscription.getMacroId();
        firebaseMessaging.unsubscribeFromTopic("macro-" + macroId).addOnCompleteListener(new OnCompleteListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.macros.viewmodel.a
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                MyMacroSubscriptionsViewModel.d(MacroSubscription.this, task);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.macros.viewmodel.b
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                MyMacroSubscriptionsViewModel.e(MacroSubscription.this, exc);
            }
        });
        e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new b(macroSubscription, null), 2, null);
    }
}
