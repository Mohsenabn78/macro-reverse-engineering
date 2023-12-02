package com.arlosoft.macrodroid.plugins.comments.data;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.ItemKeyedDataSource;
import com.arlosoft.macrodroid.plugins.api.PluginListApi;
import com.arlosoft.macrodroid.plugins.comments.data.PluginCommentsDataSource;
import com.arlosoft.macrodroid.templatestore.common.LoadState;
import com.arlosoft.macrodroid.templatestore.model.Comment;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;

/* compiled from: PluginCommentsDataSource.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class PluginCommentsDataSource extends ItemKeyedDataSource<Long, Comment> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final PluginListApi f13147a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CompositeDisposable f13148b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13149c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final MutableLiveData<LoadState> f13150d;

    /* compiled from: PluginCommentsDataSource.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function1<Flowable<Throwable>, Publisher<?>> {

        /* renamed from: d  reason: collision with root package name */
        public static final a f13151d = new a();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PluginCommentsDataSource.kt */
        /* renamed from: com.arlosoft.macrodroid.plugins.comments.data.PluginCommentsDataSource$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0110a extends Lambda implements Function1<Throwable, Publisher<? extends Long>> {

            /* renamed from: d  reason: collision with root package name */
            public static final C0110a f13152d = new C0110a();

            C0110a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final Publisher<? extends Long> invoke(@NotNull Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Observable.timer(3L, TimeUnit.SECONDS).toFlowable(BackpressureStrategy.DROP);
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
            final C0110a c0110a = C0110a.f13152d;
            return errors.flatMap(new Function() { // from class: com.arlosoft.macrodroid.plugins.comments.data.e
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Publisher c4;
                    c4 = PluginCommentsDataSource.a.c(Function1.this, obj);
                    return c4;
                }
            });
        }
    }

    /* compiled from: PluginCommentsDataSource.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements Function1<List<? extends Comment>, Unit> {
        final /* synthetic */ ItemKeyedDataSource.LoadCallback<Comment> $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ItemKeyedDataSource.LoadCallback<Comment> loadCallback) {
            super(1);
            this.$callback = loadCallback;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Comment> list) {
            invoke2((List<Comment>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<Comment> commentList) {
            ItemKeyedDataSource.LoadCallback<Comment> loadCallback = this.$callback;
            Intrinsics.checkNotNullExpressionValue(commentList, "commentList");
            loadCallback.onResult(commentList);
        }
    }

    /* compiled from: PluginCommentsDataSource.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<Flowable<Throwable>, Publisher<?>> {

        /* renamed from: d  reason: collision with root package name */
        public static final c f13153d = new c();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PluginCommentsDataSource.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<Throwable, Publisher<? extends Long>> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f13154d = new a();

            a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final Publisher<? extends Long> invoke(@NotNull Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Observable.timer(3L, TimeUnit.SECONDS).toFlowable(BackpressureStrategy.DROP);
            }
        }

        c() {
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
            final a aVar = a.f13154d;
            return errors.flatMap(new Function() { // from class: com.arlosoft.macrodroid.plugins.comments.data.f
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Publisher c4;
                    c4 = PluginCommentsDataSource.c.c(Function1.this, obj);
                    return c4;
                }
            });
        }
    }

    /* compiled from: PluginCommentsDataSource.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function1<List<? extends Comment>, Unit> {
        final /* synthetic */ ItemKeyedDataSource.LoadInitialCallback<Comment> $callback;
        final /* synthetic */ PluginCommentsDataSource this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ItemKeyedDataSource.LoadInitialCallback<Comment> loadInitialCallback, PluginCommentsDataSource pluginCommentsDataSource) {
            super(1);
            this.$callback = loadInitialCallback;
            this.this$0 = pluginCommentsDataSource;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Comment> list) {
            invoke2((List<Comment>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<Comment> commentList) {
            ItemKeyedDataSource.LoadInitialCallback<Comment> loadInitialCallback = this.$callback;
            Intrinsics.checkNotNullExpressionValue(commentList, "commentList");
            loadInitialCallback.onResult(commentList);
            if (commentList.isEmpty()) {
                this.this$0.i(LoadState.EMPTY);
            } else {
                this.this$0.i(LoadState.HAS_DATA);
            }
        }
    }

    public PluginCommentsDataSource(@NotNull PluginListApi api, @NotNull CompositeDisposable compositeDisposable, int i4) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(compositeDisposable, "compositeDisposable");
        this.f13147a = api;
        this.f13148b = compositeDisposable;
        this.f13149c = i4;
        this.f13150d = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher e(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher g(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(LoadState loadState) {
        this.f13150d.postValue(loadState);
    }

    @NotNull
    public final MutableLiveData<LoadState> getLoadState() {
        return this.f13150d;
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadAfter(@NotNull ItemKeyedDataSource.LoadParams<Long> params, @NotNull ItemKeyedDataSource.LoadCallback<Comment> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        CompositeDisposable compositeDisposable = this.f13148b;
        Single<List<Comment>> comments = this.f13147a.getComments(this.f13149c, params.key.longValue(), params.requestedLoadSize);
        final a aVar = a.f13151d;
        Single<List<Comment>> retryWhen = comments.retryWhen(new Function() { // from class: com.arlosoft.macrodroid.plugins.comments.data.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher e4;
                e4 = PluginCommentsDataSource.e(Function1.this, obj);
                return e4;
            }
        });
        final b bVar = new b(callback);
        compositeDisposable.add(retryWhen.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.plugins.comments.data.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PluginCommentsDataSource.f(Function1.this, obj);
            }
        }));
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadBefore(@NotNull ItemKeyedDataSource.LoadParams<Long> params, @NotNull ItemKeyedDataSource.LoadCallback<Comment> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadInitial(@NotNull ItemKeyedDataSource.LoadInitialParams<Long> params, @NotNull ItemKeyedDataSource.LoadInitialCallback<Comment> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        i(LoadState.LOADING);
        CompositeDisposable compositeDisposable = this.f13148b;
        Single<List<Comment>> comments = this.f13147a.getComments(this.f13149c, Long.MAX_VALUE, params.requestedLoadSize);
        final c cVar = c.f13153d;
        Single<List<Comment>> retryWhen = comments.retryWhen(new Function() { // from class: com.arlosoft.macrodroid.plugins.comments.data.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher g4;
                g4 = PluginCommentsDataSource.g(Function1.this, obj);
                return g4;
            }
        });
        final d dVar = new d(callback, this);
        compositeDisposable.add(retryWhen.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.plugins.comments.data.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PluginCommentsDataSource.h(Function1.this, obj);
            }
        }));
    }

    @Override // androidx.paging.ItemKeyedDataSource
    @NotNull
    public Long getKey(@NotNull Comment item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return Long.valueOf(item.getTimestamp());
    }
}
