package com.arlosoft.macrodroid.templatestore.ui.user.presenter;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.mvp.Presenter;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.database.room.BlockedUser;
import com.arlosoft.macrodroid.database.room.BlockedUserDao;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.database.room.UserSubscription;
import com.arlosoft.macrodroid.database.room.UserSubscriptionDao;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.events.TemplateDeletedEvent;
import com.arlosoft.macrodroid.templatestore.events.UserBlockedEvent;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.templatestore.ui.user.UserViewContract;
import com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Publisher;

/* compiled from: UserPresenter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UserPresenter extends Presenter<UserViewContract> implements CoroutineScope {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ScreenLoader f14202b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final TemplateStoreApi f14203c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final PremiumStatusHandler f14204d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final UserProvider f14205e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final MacroDroidRoomDatabase f14206f;

    /* renamed from: g  reason: collision with root package name */
    private int f14207g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private String f14208h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private String f14209i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14210j;

    /* renamed from: k  reason: collision with root package name */
    private CompositeDisposable f14211k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final CompletableJob f14212l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final CoroutineContext f14213m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $userId;
        final /* synthetic */ String $username;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UserPresenter.kt */
        /* renamed from: com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0122a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $userId;
            int label;
            final /* synthetic */ UserPresenter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0122a(UserPresenter userPresenter, int i4, Continuation<? super C0122a> continuation) {
                super(2, continuation);
                this.this$0 = userPresenter;
                this.$userId = i4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0122a(this.this$0, this.$userId, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    UserViewContract view = this.this$0.getView();
                    if (view != null) {
                        view.setUserBlocked();
                    }
                    UserViewContract view2 = this.this$0.getView();
                    if (view2 != null) {
                        view2.refreshMacros();
                    }
                    EventBusUtils.getEventBus().post(new UserBlockedEvent(this.$userId));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((C0122a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i4, String str, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$userId = i4;
            this.$username = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$userId, this.$username, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                BlockedUserDao blockedUserDao = UserPresenter.this.f14206f.blockedUserDao();
                BlockedUser blockedUser = new BlockedUser(this.$userId, this.$username);
                this.label = 1;
                if (blockedUserDao.addBlockedUser(blockedUser, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            MainCoroutineDispatcher main = Dispatchers.getMain();
            C0122a c0122a = new C0122a(UserPresenter.this, this.$userId, null);
            this.label = 2;
            if (BuildersKt.withContext(main, c0122a, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
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
    /* compiled from: UserPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ User $user;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UserPresenter.kt */
        @SourceDebugExtension({"SMAP\nUserPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserPresenter.kt\ncom/arlosoft/macrodroid/templatestore/ui/user/presenter/UserPresenter$getSubscribedState$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,214:1\n1549#2:215\n1620#2,3:216\n*S KotlinDebug\n*F\n+ 1 UserPresenter.kt\ncom/arlosoft/macrodroid/templatestore/ui/user/presenter/UserPresenter$getSubscribedState$1$1\n*L\n209#1:215\n209#1:216,3\n*E\n"})
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ User $user;
            final /* synthetic */ List<UserSubscription> $userSubscriptions;
            int label;
            final /* synthetic */ UserPresenter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(UserPresenter userPresenter, List<UserSubscription> list, User user, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = userPresenter;
                this.$userSubscriptions = list;
                this.$user = user;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, this.$userSubscriptions, this.$user, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                int collectionSizeOrDefault;
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    UserPresenter userPresenter = this.this$0;
                    List<UserSubscription> list = this.$userSubscriptions;
                    collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (UserSubscription userSubscription : list) {
                        arrayList.add(Boxing.boxInt(userSubscription.getUserId()));
                    }
                    userPresenter.f14210j = arrayList.contains(Boxing.boxInt(this.$user.getUserId()));
                    UserViewContract view = this.this$0.getView();
                    if (view != null) {
                        view.updateSubscribedState(this.this$0.f14210j, false);
                    }
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(User user, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$user = user;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$user, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                UserSubscriptionDao userSubscriptionDao = UserPresenter.this.f14206f.userSubscriptionDao();
                this.label = 1;
                obj = userSubscriptionDao.getAllUserSubscriptions(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            MainCoroutineDispatcher main = Dispatchers.getMain();
            a aVar = new a(UserPresenter.this, (List) obj, this.$user, null);
            this.label = 2;
            if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
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
    /* compiled from: UserPresenter.kt */
    @SourceDebugExtension({"SMAP\nUserPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserPresenter.kt\ncom/arlosoft/macrodroid/templatestore/ui/user/presenter/UserPresenter$getUser$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,214:1\n1549#2:215\n1620#2,3:216\n*S KotlinDebug\n*F\n+ 1 UserPresenter.kt\ncom/arlosoft/macrodroid/templatestore/ui/user/presenter/UserPresenter$getUser$1\n*L\n177#1:215\n177#1:216,3\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UserPresenter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isBlocked;
            int label;
            final /* synthetic */ UserPresenter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(boolean z3, UserPresenter userPresenter, Continuation<? super a> continuation) {
                super(2, continuation);
                this.$isBlocked = z3;
                this.this$0 = userPresenter;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.$isBlocked, this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.$isBlocked) {
                        this.this$0.o();
                    } else {
                        UserViewContract view = this.this$0.getView();
                        if (view != null) {
                            view.setUserBlocked();
                        }
                    }
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

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            int collectionSizeOrDefault;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                BlockedUserDao blockedUserDao = UserPresenter.this.f14206f.blockedUserDao();
                this.label = 1;
                obj = blockedUserDao.getAllBlockedUsers(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            Iterable<BlockedUser> iterable = (Iterable) obj;
            collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(iterable, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (BlockedUser blockedUser : iterable) {
                arrayList.add(Boxing.boxInt(blockedUser.getUserId()));
            }
            boolean contains = arrayList.contains(Boxing.boxInt(UserPresenter.this.f14207g));
            MainCoroutineDispatcher main = Dispatchers.getMain();
            a aVar = new a(contains, UserPresenter.this, null);
            this.label = 2;
            if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements Function1<Flowable<Throwable>, Publisher<?>> {

        /* renamed from: d  reason: collision with root package name */
        public static final d f14214d = new d();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UserPresenter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<Throwable, Publisher<? extends Long>> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f14215d = new a();

            a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final Publisher<? extends Long> invoke(@NotNull Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Observable.timer(2L, TimeUnit.SECONDS).toFlowable(BackpressureStrategy.DROP);
            }
        }

        d() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Publisher c(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (Publisher) tmp0.invoke(obj);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Publisher<?> invoke(@NotNull Flowable<Throwable> errors) {
            Intrinsics.checkNotNullParameter(errors, "errors");
            final a aVar = a.f14215d;
            return errors.flatMap(new Function() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.presenter.k
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Publisher c4;
                    c4 = UserPresenter.d.c(Function1.this, obj);
                    return c4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class e extends Lambda implements Function1<User, Unit> {
        e() {
            super(1);
        }

        public final void a(User user) {
            UserViewContract view = UserPresenter.this.getView();
            if (view != null) {
                Intrinsics.checkNotNullExpressionValue(user, "user");
                view.setUserDetails(user);
            }
            UserPresenter userPresenter = UserPresenter.this;
            Intrinsics.checkNotNullExpressionValue(user, "user");
            userPresenter.m(user);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            a(user);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class f extends Lambda implements Function1<Throwable, Unit> {

        /* renamed from: d  reason: collision with root package name */
        public static final f f14216d = new f();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UserPresenter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function0<Unit> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f14217d = new a();

            a() {
                super(0);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }

        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            a aVar = a.f14217d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class g extends Lambda implements Function1<Throwable, Unit> {
        g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            UserViewContract view = UserPresenter.this.getView();
            if (view != null) {
                view.showReportFailed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UserPresenter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ UserPresenter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(UserPresenter userPresenter, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = userPresenter;
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
                    UserViewContract view = this.this$0.getView();
                    if (view != null) {
                        view.updateSubscribedState(true, true);
                    }
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

        h(Continuation<? super h> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new h(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                UserSubscriptionDao userSubscriptionDao = UserPresenter.this.f14206f.userSubscriptionDao();
                UserSubscription userSubscription = new UserSubscription(UserPresenter.this.f14207g, UserPresenter.this.f14208h, UserPresenter.this.f14209i);
                this.label = 1;
                if (userSubscriptionDao.addUserSubscription(userSubscription, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            MainCoroutineDispatcher main = Dispatchers.getMain();
            a aVar = new a(UserPresenter.this, null);
            this.label = 2;
            if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Task<Void> $task;
        int label;
        final /* synthetic */ UserPresenter this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UserPresenter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ UserPresenter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(UserPresenter userPresenter, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = userPresenter;
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
                    UserViewContract view = this.this$0.getView();
                    if (view != null) {
                        view.updateSubscribedState(false, true);
                        return Unit.INSTANCE;
                    }
                    return null;
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
        /* compiled from: UserPresenter.kt */
        /* loaded from: classes3.dex */
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ UserPresenter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(UserPresenter userPresenter, Continuation<? super b> continuation) {
                super(2, continuation);
                this.this$0 = userPresenter;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new b(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    UserViewContract view = this.this$0.getView();
                    if (view != null) {
                        view.subscriptionUpdateFailed(false);
                        return Unit.INSTANCE;
                    }
                    return null;
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
        i(Task<Void> task, UserPresenter userPresenter, Continuation<? super i> continuation) {
            super(2, continuation);
            this.$task = task;
            this.this$0 = userPresenter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new i(this.$task, this.this$0, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0060 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L23
                if (r1 == r5) goto L1f
                if (r1 == r4) goto L1b
                if (r1 != r3) goto L13
                goto L1b
            L13:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1b:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L75
            L1f:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L4d
            L23:
                kotlin.ResultKt.throwOnFailure(r7)
                com.google.android.gms.tasks.Task<java.lang.Void> r7 = r6.$task
                boolean r7 = r7.isSuccessful()
                if (r7 == 0) goto L61
                com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter r7 = r6.this$0
                r1 = 0
                com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter.access$setSubscribed$p(r7, r1)
                com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter r7 = r6.this$0
                com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase r7 = com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter.access$getRoomDatabase$p(r7)
                com.arlosoft.macrodroid.database.room.UserSubscriptionDao r7 = r7.userSubscriptionDao()
                com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter r1 = r6.this$0
                int r1 = com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter.access$getUserBeingShownId$p(r1)
                r6.label = r5
                java.lang.Object r7 = r7.deleteUserSubscription(r1, r6)
                if (r7 != r0) goto L4d
                return r0
            L4d:
                kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
                com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter$i$a r1 = new com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter$i$a
                com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter r3 = r6.this$0
                r1.<init>(r3, r2)
                r6.label = r4
                java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r1, r6)
                if (r7 != r0) goto L75
                return r0
            L61:
                kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
                com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter$i$b r1 = new com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter$i$b
                com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter r4 = r6.this$0
                r1.<init>(r4, r2)
                r6.label = r3
                java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r1, r6)
                if (r7 != r0) goto L75
                return r0
            L75:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((i) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $userId;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UserPresenter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $userId;
            int label;
            final /* synthetic */ UserPresenter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(UserPresenter userPresenter, int i4, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = userPresenter;
                this.$userId = i4;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, this.$userId, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    UserViewContract view = this.this$0.getView();
                    if (view != null) {
                        view.setUserUnblocked();
                    }
                    UserViewContract view2 = this.this$0.getView();
                    if (view2 != null) {
                        view2.refreshMacros();
                    }
                    EventBusUtils.getEventBus().post(new UserBlockedEvent(this.$userId));
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(int i4, Continuation<? super j> continuation) {
            super(2, continuation);
            this.$userId = i4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new j(this.$userId, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                BlockedUserDao blockedUserDao = UserPresenter.this.f14206f.blockedUserDao();
                int i5 = this.$userId;
                this.label = 1;
                if (blockedUserDao.deleteBlockedUser(i5, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            UserPresenter.this.o();
            MainCoroutineDispatcher main = Dispatchers.getMain();
            a aVar = new a(UserPresenter.this, this.$userId, null);
            this.label = 2;
            if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Inject
    public UserPresenter(@NotNull ScreenLoader screenLoader, @NotNull TemplateStoreApi api, @NotNull PremiumStatusHandler premiumStatusHandler, @NotNull UserProvider userProvider, @NotNull MacroDroidRoomDatabase roomDatabase) {
        CompletableJob c4;
        Intrinsics.checkNotNullParameter(screenLoader, "screenLoader");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "premiumStatusHandler");
        Intrinsics.checkNotNullParameter(userProvider, "userProvider");
        Intrinsics.checkNotNullParameter(roomDatabase, "roomDatabase");
        this.f14202b = screenLoader;
        this.f14203c = api;
        this.f14204d = premiumStatusHandler;
        this.f14205e = userProvider;
        this.f14206f = roomDatabase;
        this.f14208h = "";
        this.f14209i = "";
        c4 = u.c(null, 1, null);
        this.f14212l = c4;
        this.f14213m = c4.plus(Dispatchers.getIO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(User user) {
        kotlinx.coroutines.e.e(this, Dispatchers.getIO(), null, new b(user, null), 2, null);
    }

    private final void n() {
        kotlinx.coroutines.e.e(this, Dispatchers.getIO(), null, new c(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        CompositeDisposable compositeDisposable = this.f14211k;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        Single<User> userById = this.f14203c.getUserById(this.f14207g);
        final d dVar = d.f14214d;
        Single<User> observeOn = userById.retryWhen(new Function() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.presenter.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher p4;
                p4 = UserPresenter.p(Function1.this, obj);
                return p4;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final e eVar = new e();
        Consumer<? super User> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.presenter.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UserPresenter.q(Function1.this, obj);
            }
        };
        final f fVar = f.f14216d;
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.presenter.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UserPresenter.r(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher p(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(UserPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UserViewContract view = this$0.getView();
        if (view != null) {
            view.showReportUploading(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(UserPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UserViewContract view = this$0.getView();
        if (view != null) {
            view.showReported();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(UserPresenter this$0, Task task) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            this$0.f14210j = true;
            kotlinx.coroutines.e.e(this$0, Dispatchers.getIO(), null, new h(null), 2, null);
            return;
        }
        UserViewContract view = this$0.getView();
        if (view != null) {
            view.subscriptionUpdateFailed(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(UserPresenter this$0, Exception it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        UserViewContract view = this$0.getView();
        if (view != null) {
            view.subscriptionUpdateFailed(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(UserPresenter this$0, Task task) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(task, "task");
        kotlinx.coroutines.e.e(this$0, Dispatchers.getIO(), null, new i(task, this$0, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(UserPresenter this$0, Exception it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        UserViewContract view = this$0.getView();
        if (view != null) {
            view.subscriptionUpdateFailed(false);
        }
    }

    @Override // com.arlosoft.macrodroid.app.mvp.Presenter
    protected void a() {
        CompositeDisposable compositeDisposable = this.f14211k;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        compositeDisposable.clear();
        EventBusUtils.getEventBus().unregister(this);
        Job.DefaultImpls.cancel$default((Job) this.f14212l, (CancellationException) null, 1, (Object) null);
    }

    @Override // com.arlosoft.macrodroid.app.mvp.Presenter
    protected void b() {
        this.f14211k = new CompositeDisposable();
        EventBusUtils.getEventBus().register(this);
        n();
    }

    public final void blockUser(int i4, @NotNull String username) {
        Intrinsics.checkNotNullParameter(username, "username");
        kotlinx.coroutines.e.e(this, null, null, new a(i4, username, null), 3, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.f14213m;
    }

    public final void onEventMainThread(@NotNull TemplateDeletedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        n();
    }

    public final void reportUser(int i4, int i5, @NotNull String reasonText) {
        Intrinsics.checkNotNullParameter(reasonText, "reasonText");
        UserViewContract view = getView();
        if (view != null) {
            view.showReportUploading(true);
        }
        CompositeDisposable compositeDisposable = this.f14211k;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        Completable doFinally = Completable.mergeArray(Completable.timer(1500L, TimeUnit.MILLISECONDS), this.f14203c.reportUser(i4, this.f14205e.getUser().getUserId(), i5, reasonText)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.presenter.e
            @Override // io.reactivex.functions.Action
            public final void run() {
                UserPresenter.s(UserPresenter.this);
            }
        });
        Action action = new Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.presenter.f
            @Override // io.reactivex.functions.Action
            public final void run() {
                UserPresenter.t(UserPresenter.this);
            }
        };
        final g gVar = new g();
        compositeDisposable.add(doFinally.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.presenter.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UserPresenter.u(Function1.this, obj);
            }
        }));
    }

    public final void setUserBeingShownId(int i4, @NotNull String userName, @NotNull String userImage) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(userImage, "userImage");
        this.f14207g = i4;
        this.f14208h = userName;
        this.f14209i = userImage;
    }

    public final void subscribeUserClicked() {
        if (!this.f14204d.getPremiumStatus().isPro()) {
            UserViewContract view = getView();
            if (view != null) {
                view.showSubscriptionProOnly();
            }
        } else if (this.f14205e.getUser().isGuest()) {
            UserViewContract view2 = getView();
            if (view2 != null) {
                view2.showSubscriptionSignedInOnly();
            }
        } else {
            UserViewContract view3 = getView();
            if (view3 != null) {
                view3.showSubscriptionInProgress();
            }
            if (!this.f14210j) {
                FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
                int i4 = this.f14207g;
                firebaseMessaging.subscribeToTopic("user-" + i4).addOnCompleteListener(new OnCompleteListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.presenter.a
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        UserPresenter.v(UserPresenter.this, task);
                    }
                }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.presenter.b
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        UserPresenter.w(UserPresenter.this, exc);
                    }
                });
                return;
            }
            FirebaseMessaging firebaseMessaging2 = FirebaseMessaging.getInstance();
            int i5 = this.f14207g;
            firebaseMessaging2.unsubscribeFromTopic("user-" + i5).addOnCompleteListener(new OnCompleteListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.presenter.c
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    UserPresenter.x(UserPresenter.this, task);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.user.presenter.d
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    UserPresenter.y(UserPresenter.this, exc);
                }
            });
        }
    }

    public final void unblockUser(int i4) {
        kotlinx.coroutines.e.e(this, null, null, new j(i4, null), 3, null);
    }

    public final void onEventMainThread(@NotNull UserBlockedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getUserId() == this.f14207g) {
            n();
        }
    }
}
