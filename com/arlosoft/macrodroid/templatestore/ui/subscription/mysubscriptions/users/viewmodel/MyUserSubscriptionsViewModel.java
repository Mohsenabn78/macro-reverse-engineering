package com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.users.viewmodel;

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
import com.arlosoft.macrodroid.database.room.UserSubscription;
import com.arlosoft.macrodroid.database.room.UserSubscriptionDao;
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

/* compiled from: MyUserSubscriptionsViewModel.kt */
@StabilityInferred(parameters = 0)
@ActivityScope
@SourceDebugExtension({"SMAP\nMyUserSubscriptionsViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyUserSubscriptionsViewModel.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/mysubscriptions/users/viewmodel/MyUserSubscriptionsViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,65:1\n1#2:66\n*E\n"})
/* loaded from: classes3.dex */
public final class MyUserSubscriptionsViewModel extends ViewModel implements DefaultLifecycleObserver {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final MacroDroidRoomDatabase f13916a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ScreenLoader f13917b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<Boolean> f13918c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final LiveData<Boolean> f13919d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final MutableLiveData<List<UserSubscription>> f13920e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final LiveData<List<UserSubscription>> f13921f;

    /* compiled from: MyUserSubscriptionsViewModel.kt */
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
                MyUserSubscriptionsViewModel.this.f13918c.postValue(Boxing.boxBoolean(true));
                UserSubscriptionDao userSubscriptionDao = MyUserSubscriptionsViewModel.this.f13916a.userSubscriptionDao();
                this.label = 1;
                obj = userSubscriptionDao.getAllUserSubscriptions(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            MyUserSubscriptionsViewModel.this.f13920e.postValue((List) obj);
            MyUserSubscriptionsViewModel.this.f13918c.postValue(Boxing.boxBoolean(false));
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
    /* compiled from: MyUserSubscriptionsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Task<Void> $task;
        final /* synthetic */ UserSubscription $userSubscription;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Task<Void> task, UserSubscription userSubscription, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$task = task;
            this.$userSubscription = userSubscription;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$task, this.$userSubscription, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$task.isSuccessful()) {
                    String userName = this.$userSubscription.getUserName();
                    SystemLog.logVerbose("Unsubscribed from user: " + userName);
                } else {
                    String userName2 = this.$userSubscription.getUserName();
                    SystemLog.logDebug("Unsubscribe failed for user: " + userName2);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyUserSubscriptionsViewModel.kt */
    @SourceDebugExtension({"SMAP\nMyUserSubscriptionsViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyUserSubscriptionsViewModel.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/mysubscriptions/users/viewmodel/MyUserSubscriptionsViewModel$unsubscribeItem$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,65:1\n766#2:66\n857#2,2:67\n*S KotlinDebug\n*F\n+ 1 MyUserSubscriptionsViewModel.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/mysubscriptions/users/viewmodel/MyUserSubscriptionsViewModel$unsubscribeItem$3\n*L\n56#1:66\n56#1:67,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UserSubscription $userSubscription;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(UserSubscription userSubscription, Continuation<? super c> continuation) {
            super(2, continuation);
            this.$userSubscription = userSubscription;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(this.$userSubscription, continuation);
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
                UserSubscriptionDao userSubscriptionDao = MyUserSubscriptionsViewModel.this.f13916a.userSubscriptionDao();
                int userId = this.$userSubscription.getUserId();
                this.label = 1;
                if (userSubscriptionDao.deleteUserSubscription(userId, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            MutableLiveData mutableLiveData = MyUserSubscriptionsViewModel.this.f13920e;
            T value = MyUserSubscriptionsViewModel.this.f13920e.getValue();
            Intrinsics.checkNotNull(value);
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) value);
            UserSubscription userSubscription = this.$userSubscription;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : mutableList) {
                if (!Intrinsics.areEqual((UserSubscription) obj2, userSubscription)) {
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
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Inject
    public MyUserSubscriptionsViewModel(@NotNull MacroDroidRoomDatabase roomDatabase, @NotNull ScreenLoader screenLoader) {
        Intrinsics.checkNotNullParameter(roomDatabase, "roomDatabase");
        Intrinsics.checkNotNullParameter(screenLoader, "screenLoader");
        this.f13916a = roomDatabase;
        this.f13917b = screenLoader;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.f13918c = mutableLiveData;
        this.f13919d = mutableLiveData;
        MutableLiveData<List<UserSubscription>> mutableLiveData2 = new MutableLiveData<>();
        this.f13920e = mutableLiveData2;
        this.f13921f = mutableLiveData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MyUserSubscriptionsViewModel this$0, UserSubscription userSubscription, Task task) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(userSubscription, "$userSubscription");
        Intrinsics.checkNotNullParameter(task, "task");
        e.e(ViewModelKt.getViewModelScope(this$0), Dispatchers.getIO(), null, new b(task, userSubscription, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(UserSubscription userSubscription, Exception exception) {
        Intrinsics.checkNotNullParameter(userSubscription, "$userSubscription");
        Intrinsics.checkNotNullParameter(exception, "exception");
        String userName = userSubscription.getUserName();
        SystemLog.logDebug("Unsubscribe failed for user: " + userName + " failure = " + exception);
    }

    public final void deleteItemAtPosition(int i4) {
        UserSubscription userSubscription;
        List<UserSubscription> value = this.f13921f.getValue();
        if (value != null) {
            userSubscription = value.get(i4);
        } else {
            userSubscription = null;
        }
        if (userSubscription != null) {
            unsubscribeItem(userSubscription);
        }
    }

    @NotNull
    public final LiveData<List<UserSubscription>> getUpdateItems() {
        return this.f13921f;
    }

    @NotNull
    public final LiveData<Boolean> isLoading() {
        return this.f13919d;
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

    public final void onUpdateItemClicked(@NotNull UserSubscription user) {
        Intrinsics.checkNotNullParameter(user, "user");
        ScreenLoader.loadUserDetailsScreen$default(this.f13917b, user.getUserName(), user.getUserImage(), user.getUserId(), null, 8, null);
    }

    public final void unsubscribeItem(@NotNull final UserSubscription userSubscription) {
        Intrinsics.checkNotNullParameter(userSubscription, "userSubscription");
        FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
        int userId = userSubscription.getUserId();
        firebaseMessaging.unsubscribeFromTopic("user-" + userId).addOnCompleteListener(new OnCompleteListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.users.viewmodel.a
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                MyUserSubscriptionsViewModel.c(MyUserSubscriptionsViewModel.this, userSubscription, task);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.users.viewmodel.b
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                MyUserSubscriptionsViewModel.d(UserSubscription.this, exc);
            }
        });
        e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new c(userSubscription, null), 2, null);
    }
}
