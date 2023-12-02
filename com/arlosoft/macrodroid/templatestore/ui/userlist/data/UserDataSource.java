package com.arlosoft.macrodroid.templatestore.ui.userlist.data;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PageKeyedDataSource;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.rest.BaseError;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApiKt;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.userlist.data.UserDataSource;
import com.arlosoft.macrodroid.utils.SigningHelper;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Publisher;
import retrofit2.HttpException;
import retrofit2.Response;

/* compiled from: UserDataSource.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UserDataSource extends PageKeyedDataSource<Integer, User> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final TemplateStoreApi f14260a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CompositeDisposable f14261b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f14262c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f14263d;

    /* compiled from: UserDataSource.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function1<Flowable<Throwable>, Publisher<?>> {

        /* renamed from: d  reason: collision with root package name */
        public static final a f14264d = new a();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UserDataSource.kt */
        /* renamed from: com.arlosoft.macrodroid.templatestore.ui.userlist.data.UserDataSource$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0125a extends Lambda implements Function1<Throwable, Publisher<? extends Long>> {

            /* renamed from: d  reason: collision with root package name */
            public static final C0125a f14265d = new C0125a();

            C0125a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final Publisher<? extends Long> invoke(@NotNull Throwable error) {
                Intrinsics.checkNotNullParameter(error, "error");
                if (new BaseError(error, null, 2, null).isNetworkOrTimeoutError()) {
                    return Observable.timer(2L, TimeUnit.SECONDS).toFlowable(BackpressureStrategy.DROP);
                }
                return Flowable.error(error);
            }
        }

        a() {
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
            final C0125a c0125a = C0125a.f14265d;
            return errors.flatMap(new Function() { // from class: com.arlosoft.macrodroid.templatestore.ui.userlist.data.g
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Publisher c4;
                    c4 = UserDataSource.a.c(Function1.this, obj);
                    return c4;
                }
            });
        }
    }

    /* compiled from: UserDataSource.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements Function1<Flowable<Throwable>, Publisher<?>> {

        /* renamed from: d  reason: collision with root package name */
        public static final b f14266d = new b();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UserDataSource.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<Throwable, Publisher<? extends Long>> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f14267d = new a();

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

        b() {
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
            final a aVar = a.f14267d;
            return errors.flatMap(new Function() { // from class: com.arlosoft.macrodroid.templatestore.ui.userlist.data.h
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Publisher c4;
                    c4 = UserDataSource.b.c(Function1.this, obj);
                    return c4;
                }
            });
        }
    }

    /* compiled from: UserDataSource.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<List<? extends User>, Unit> {
        final /* synthetic */ PageKeyedDataSource.LoadCallback<Integer, User> $callback;
        final /* synthetic */ PageKeyedDataSource.LoadParams<Integer> $params;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(PageKeyedDataSource.LoadCallback<Integer, User> loadCallback, PageKeyedDataSource.LoadParams<Integer> loadParams) {
            super(1);
            this.$callback = loadCallback;
            this.$params = loadParams;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends User> list) {
            invoke2((List<User>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<User> userList) {
            PageKeyedDataSource.LoadCallback<Integer, User> loadCallback = this.$callback;
            Intrinsics.checkNotNullExpressionValue(userList, "userList");
            loadCallback.onResult(userList, Integer.valueOf(this.$params.key.intValue() + 1));
        }
    }

    /* compiled from: UserDataSource.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ PageKeyedDataSource.LoadCallback<Integer, User> $callback;
        final /* synthetic */ PageKeyedDataSource.LoadParams<Integer> $params;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(PageKeyedDataSource.LoadCallback<Integer, User> loadCallback, PageKeyedDataSource.LoadParams<Integer> loadParams) {
            super(1);
            this.$callback = loadCallback;
            this.$params = loadParams;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            List<? extends User> emptyList;
            PageKeyedDataSource.LoadCallback<Integer, User> loadCallback = this.$callback;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            loadCallback.onResult(emptyList, Integer.valueOf(this.$params.key.intValue() + 1));
        }
    }

    /* compiled from: UserDataSource.kt */
    /* loaded from: classes3.dex */
    static final class e extends Lambda implements Function1<List<? extends User>, Unit> {
        final /* synthetic */ PageKeyedDataSource.LoadInitialCallback<Integer, User> $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(PageKeyedDataSource.LoadInitialCallback<Integer, User> loadInitialCallback) {
            super(1);
            this.$callback = loadInitialCallback;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends User> list) {
            invoke2((List<User>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<User> userList) {
            PageKeyedDataSource.LoadInitialCallback<Integer, User> loadInitialCallback = this.$callback;
            Intrinsics.checkNotNullExpressionValue(userList, "userList");
            loadInitialCallback.onResult(userList, -1, 2);
        }
    }

    /* compiled from: UserDataSource.kt */
    /* loaded from: classes3.dex */
    static final class f extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ PageKeyedDataSource.LoadInitialCallback<Integer, User> $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(PageKeyedDataSource.LoadInitialCallback<Integer, User> loadInitialCallback) {
            super(1);
            this.$callback = loadInitialCallback;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            List<? extends User> listOf;
            List<? extends User> listOf2;
            if (th instanceof HttpException) {
                Response<?> response = ((HttpException) th).response();
                boolean z3 = false;
                if (response != null && response.code() == 401) {
                    z3 = true;
                }
                if (z3) {
                    PageKeyedDataSource.LoadInitialCallback<Integer, User> loadInitialCallback = this.$callback;
                    listOf2 = kotlin.collections.e.listOf(User.Companion.createPirateUser());
                    loadInitialCallback.onResult(listOf2, -1, -1);
                    return;
                }
            }
            PageKeyedDataSource.LoadInitialCallback<Integer, User> loadInitialCallback2 = this.$callback;
            listOf = kotlin.collections.e.listOf(User.Companion.createErrorUser());
            loadInitialCallback2.onResult(listOf, -1, -1);
        }
    }

    public UserDataSource(@NotNull TemplateStoreApi api, @NotNull CompositeDisposable compositeDisposable, @NotNull String searchTerm) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(compositeDisposable, "compositeDisposable");
        Intrinsics.checkNotNullParameter(searchTerm, "searchTerm");
        this.f14260a = api;
        this.f14261b = compositeDisposable;
        this.f14262c = searchTerm;
        this.f14263d = SigningHelper.INSTANCE.getSigningKeySha1(MacroDroidApplication.Companion.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher g(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher h(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadAfter(@NotNull PageKeyedDataSource.LoadParams<Integer> params, @NotNull PageKeyedDataSource.LoadCallback<Integer, User> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str = this.f14263d;
        String sha256 = StringExtensionsKt.sha256(TemplateStoreApiKt.TEMPLATE_API_SALT + str);
        CompositeDisposable compositeDisposable = this.f14261b;
        Single<List<User>> usersByRank = this.f14260a.getUsersByRank(sha256, params.requestedLoadSize * params.key.intValue(), params.requestedLoadSize);
        final a aVar = a.f14264d;
        Single<List<User>> retryWhen = usersByRank.retryWhen(new Function() { // from class: com.arlosoft.macrodroid.templatestore.ui.userlist.data.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher g4;
                g4 = UserDataSource.g(Function1.this, obj);
                return g4;
            }
        });
        final b bVar = b.f14266d;
        Single<List<User>> retryWhen2 = retryWhen.retryWhen(new Function() { // from class: com.arlosoft.macrodroid.templatestore.ui.userlist.data.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher h4;
                h4 = UserDataSource.h(Function1.this, obj);
                return h4;
            }
        });
        final c cVar = new c(callback, params);
        Consumer<? super List<User>> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.userlist.data.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UserDataSource.i(Function1.this, obj);
            }
        };
        final d dVar = new d(callback, params);
        compositeDisposable.add(retryWhen2.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.userlist.data.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UserDataSource.j(Function1.this, obj);
            }
        }));
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadBefore(@NotNull PageKeyedDataSource.LoadParams<Integer> params, @NotNull PageKeyedDataSource.LoadCallback<Integer, User> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadInitial(@NotNull PageKeyedDataSource.LoadInitialParams<Integer> params, @NotNull PageKeyedDataSource.LoadInitialCallback<Integer, User> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str = this.f14263d;
        String sha256 = StringExtensionsKt.sha256(TemplateStoreApiKt.TEMPLATE_API_SALT + str);
        CompositeDisposable compositeDisposable = this.f14261b;
        Single<List<User>> usersByRank = this.f14260a.getUsersByRank(sha256, 0, params.requestedLoadSize);
        final e eVar = new e(callback);
        Consumer<? super List<User>> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.userlist.data.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UserDataSource.k(Function1.this, obj);
            }
        };
        final f fVar = new f(callback);
        compositeDisposable.add(usersByRank.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.userlist.data.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UserDataSource.l(Function1.this, obj);
            }
        }));
    }
}
