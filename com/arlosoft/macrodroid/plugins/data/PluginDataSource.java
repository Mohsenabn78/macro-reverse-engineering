package com.arlosoft.macrodroid.plugins.data;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.plugins.api.PluginListApi;
import com.arlosoft.macrodroid.plugins.data.PluginDataSource;
import com.arlosoft.macrodroid.rest.BaseError;
import com.arlosoft.macrodroid.templatestore.common.LoadState;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Publisher;

/* compiled from: PluginDataSource.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class PluginDataSource extends PageKeyedDataSource<Integer, PluginDetail> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final PluginListApi f13173a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CompositeDisposable f13174b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13175c;

    /* renamed from: d  reason: collision with root package name */
    private final int f13176d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final String f13177e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private String f13178f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private MutableLiveData<LoadState> f13179g;

    /* compiled from: PluginDataSource.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function1<Flowable<Throwable>, Publisher<?>> {

        /* renamed from: d  reason: collision with root package name */
        public static final a f13180d = new a();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PluginDataSource.kt */
        /* renamed from: com.arlosoft.macrodroid.plugins.data.PluginDataSource$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0111a extends Lambda implements Function1<Throwable, Publisher<? extends Long>> {

            /* renamed from: d  reason: collision with root package name */
            public static final C0111a f13181d = new C0111a();

            C0111a() {
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
            final C0111a c0111a = C0111a.f13181d;
            return errors.flatMap(new Function() { // from class: com.arlosoft.macrodroid.plugins.data.g
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Publisher c4;
                    c4 = PluginDataSource.a.c(Function1.this, obj);
                    return c4;
                }
            });
        }
    }

    /* compiled from: PluginDataSource.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements Function1<Flowable<Throwable>, Publisher<?>> {

        /* renamed from: d  reason: collision with root package name */
        public static final b f13182d = new b();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PluginDataSource.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<Throwable, Publisher<? extends Long>> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f13183d = new a();

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
            final a aVar = a.f13183d;
            return errors.flatMap(new Function() { // from class: com.arlosoft.macrodroid.plugins.data.h
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Publisher c4;
                    c4 = PluginDataSource.b.c(Function1.this, obj);
                    return c4;
                }
            });
        }
    }

    /* compiled from: PluginDataSource.kt */
    @SourceDebugExtension({"SMAP\nPluginDataSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginDataSource.kt\ncom/arlosoft/macrodroid/plugins/data/PluginDataSource$loadAfter$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,76:1\n766#2:77\n857#2,2:78\n*S KotlinDebug\n*F\n+ 1 PluginDataSource.kt\ncom/arlosoft/macrodroid/plugins/data/PluginDataSource$loadAfter$3\n*L\n60#1:77\n60#1:78,2\n*E\n"})
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<List<? extends PluginDetail>, Unit> {
        final /* synthetic */ PageKeyedDataSource.LoadCallback<Integer, PluginDetail> $callback;
        final /* synthetic */ PageKeyedDataSource.LoadParams<Integer> $params;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(PageKeyedDataSource.LoadCallback<Integer, PluginDetail> loadCallback, PageKeyedDataSource.LoadParams<Integer> loadParams) {
            super(1);
            this.$callback = loadCallback;
            this.$params = loadParams;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends PluginDetail> list) {
            invoke2((List<PluginDetail>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<PluginDetail> pluginList) {
            PageKeyedDataSource.LoadCallback<Integer, PluginDetail> loadCallback = this.$callback;
            Intrinsics.checkNotNullExpressionValue(pluginList, "pluginList");
            ArrayList arrayList = new ArrayList();
            for (Object obj : pluginList) {
                if (!Intrinsics.areEqual(((PluginDetail) obj).getPackageName(), BuildConfig.APPLICATION_ID)) {
                    arrayList.add(obj);
                }
            }
            loadCallback.onResult(arrayList, Integer.valueOf(this.$params.key.intValue() + 1));
        }
    }

    /* compiled from: PluginDataSource.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ PageKeyedDataSource.LoadCallback<Integer, PluginDetail> $callback;
        final /* synthetic */ PageKeyedDataSource.LoadParams<Integer> $params;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(PageKeyedDataSource.LoadCallback<Integer, PluginDetail> loadCallback, PageKeyedDataSource.LoadParams<Integer> loadParams) {
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
            List<? extends PluginDetail> emptyList;
            PageKeyedDataSource.LoadCallback<Integer, PluginDetail> loadCallback = this.$callback;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            loadCallback.onResult(emptyList, Integer.valueOf(this.$params.key.intValue() + 1));
        }
    }

    /* compiled from: PluginDataSource.kt */
    @SourceDebugExtension({"SMAP\nPluginDataSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginDataSource.kt\ncom/arlosoft/macrodroid/plugins/data/PluginDataSource$loadInitial$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,76:1\n766#2:77\n857#2,2:78\n*S KotlinDebug\n*F\n+ 1 PluginDataSource.kt\ncom/arlosoft/macrodroid/plugins/data/PluginDataSource$loadInitial$1\n*L\n31#1:77\n31#1:78,2\n*E\n"})
    /* loaded from: classes3.dex */
    static final class e extends Lambda implements Function1<List<? extends PluginDetail>, Unit> {
        final /* synthetic */ PageKeyedDataSource.LoadInitialCallback<Integer, PluginDetail> $callback;
        final /* synthetic */ PluginDataSource this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(PageKeyedDataSource.LoadInitialCallback<Integer, PluginDetail> loadInitialCallback, PluginDataSource pluginDataSource) {
            super(1);
            this.$callback = loadInitialCallback;
            this.this$0 = pluginDataSource;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends PluginDetail> list) {
            invoke2((List<PluginDetail>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<PluginDetail> pluginList) {
            PageKeyedDataSource.LoadInitialCallback<Integer, PluginDetail> loadInitialCallback = this.$callback;
            Intrinsics.checkNotNullExpressionValue(pluginList, "pluginList");
            ArrayList arrayList = new ArrayList();
            for (Object obj : pluginList) {
                if (!Intrinsics.areEqual(((PluginDetail) obj).getPackageName(), BuildConfig.APPLICATION_ID)) {
                    arrayList.add(obj);
                }
            }
            loadInitialCallback.onResult(arrayList, -1, 2);
            if (pluginList.isEmpty()) {
                this.this$0.m(LoadState.EMPTY);
            } else {
                this.this$0.m(LoadState.HAS_DATA);
            }
        }
    }

    /* compiled from: PluginDataSource.kt */
    /* loaded from: classes3.dex */
    static final class f extends Lambda implements Function1<Throwable, Unit> {
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
            PluginDataSource.this.m(LoadState.ERROR);
        }
    }

    public /* synthetic */ PluginDataSource(PluginListApi pluginListApi, CompositeDisposable compositeDisposable, int i4, int i5, String str, String str2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(pluginListApi, compositeDisposable, i4, i5, str, (i6 & 32) != 0 ? null : str2);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(LoadState loadState) {
        this.f13179g.postValue(loadState);
    }

    @NotNull
    public final MutableLiveData<LoadState> getLoadState() {
        return this.f13179g;
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadAfter(@NotNull PageKeyedDataSource.LoadParams<Integer> params, @NotNull PageKeyedDataSource.LoadCallback<Integer, PluginDetail> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        CompositeDisposable compositeDisposable = this.f13174b;
        Single<List<PluginDetail>> plugins = this.f13173a.getPlugins(this.f13175c, params.requestedLoadSize * params.key.intValue(), params.requestedLoadSize, this.f13176d, this.f13177e, this.f13178f);
        final a aVar = a.f13180d;
        Single<List<PluginDetail>> retryWhen = plugins.retryWhen(new Function() { // from class: com.arlosoft.macrodroid.plugins.data.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher g4;
                g4 = PluginDataSource.g(Function1.this, obj);
                return g4;
            }
        });
        final b bVar = b.f13182d;
        Single<List<PluginDetail>> retryWhen2 = retryWhen.retryWhen(new Function() { // from class: com.arlosoft.macrodroid.plugins.data.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher h4;
                h4 = PluginDataSource.h(Function1.this, obj);
                return h4;
            }
        });
        final c cVar = new c(callback, params);
        Consumer<? super List<PluginDetail>> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.plugins.data.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PluginDataSource.i(Function1.this, obj);
            }
        };
        final d dVar = new d(callback, params);
        compositeDisposable.add(retryWhen2.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.plugins.data.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PluginDataSource.j(Function1.this, obj);
            }
        }));
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadBefore(@NotNull PageKeyedDataSource.LoadParams<Integer> params, @NotNull PageKeyedDataSource.LoadCallback<Integer, PluginDetail> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadInitial(@NotNull PageKeyedDataSource.LoadInitialParams<Integer> params, @NotNull PageKeyedDataSource.LoadInitialCallback<Integer, PluginDetail> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        CompositeDisposable compositeDisposable = this.f13174b;
        Single<List<PluginDetail>> plugins = this.f13173a.getPlugins(this.f13175c, 0, params.requestedLoadSize, this.f13176d, this.f13177e, this.f13178f);
        final e eVar = new e(callback, this);
        Consumer<? super List<PluginDetail>> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.plugins.data.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PluginDataSource.k(Function1.this, obj);
            }
        };
        final f fVar = new f();
        compositeDisposable.add(plugins.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.plugins.data.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PluginDataSource.l(Function1.this, obj);
            }
        }));
    }

    public final void setLoadState(@NotNull MutableLiveData<LoadState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f13179g = mutableLiveData;
    }

    public final void setSearchTerm(@Nullable String str) {
        this.f13178f = str;
    }

    public PluginDataSource(@NotNull PluginListApi api, @NotNull CompositeDisposable compositeDisposable, int i4, int i5, @NotNull String language, @Nullable String str) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(compositeDisposable, "compositeDisposable");
        Intrinsics.checkNotNullParameter(language, "language");
        this.f13173a = api;
        this.f13174b = compositeDisposable;
        this.f13175c = i4;
        this.f13176d = i5;
        this.f13177e = language;
        this.f13178f = str;
        this.f13179g = new MutableLiveData<>();
    }
}
