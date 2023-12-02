package com.arlosoft.macrodroid.plugins.pluginlist;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagingSource;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.data.OrderByOption;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.plugins.api.PluginListApi;
import com.arlosoft.macrodroid.plugins.data.LocalPluginListOverrideStore;
import com.arlosoft.macrodroid.plugins.data.PluginDataSource;
import com.arlosoft.macrodroid.plugins.data.PluginDataSourceFactory;
import com.arlosoft.macrodroid.plugins.data.PluginDetail;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApiKt;
import com.arlosoft.macrodroid.templatestore.common.LoadState;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PluginListViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class PluginListViewModel extends ViewModel {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final PluginListApi f13219a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final UserProvider f13220b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ScreenLoader f13221c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final LocalPluginListOverrideStore f13222d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Context f13223e;

    /* renamed from: f  reason: collision with root package name */
    private int f13224f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final SingleLiveEvent<UiEvent> f13225g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final SingleLiveEvent<PluginDetail> f13226h;

    /* renamed from: i  reason: collision with root package name */
    private PluginDataSourceFactory f13227i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final CompositeDisposable f13228j;
    public LiveData<PagedList<PluginDetail>> pagedList;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: PluginListViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PluginListViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static abstract class UiEvent {
        public static final int $stable = 0;

        /* compiled from: PluginListViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class RefreshList extends UiEvent {
            public static final int $stable = 0;
            @NotNull
            public static final RefreshList INSTANCE = new RefreshList();

            private RefreshList() {
                super(null);
            }
        }

        /* compiled from: PluginListViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class ReportFailed extends UiEvent {
            public static final int $stable = 0;
            @NotNull
            public static final ReportFailed INSTANCE = new ReportFailed();

            private ReportFailed() {
                super(null);
            }
        }

        /* compiled from: PluginListViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class ReportSubmitted extends UiEvent {
            public static final int $stable = 0;
            @NotNull
            public static final ReportSubmitted INSTANCE = new ReportSubmitted();

            private ReportSubmitted() {
                super(null);
            }
        }

        /* compiled from: PluginListViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class ShowOptionsDialog extends UiEvent {
            public static final int $stable = 0;
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final PluginDetail f13229a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowOptionsDialog(@NotNull PluginDetail pluginDetail) {
                super(null);
                Intrinsics.checkNotNullParameter(pluginDetail, "pluginDetail");
                this.f13229a = pluginDetail;
            }

            @NotNull
            public final PluginDetail getPluginDetail() {
                return this.f13229a;
            }
        }

        /* compiled from: PluginListViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class StarRequiresSignIn extends UiEvent {
            public static final int $stable = 0;
            @NotNull
            public static final StarRequiresSignIn INSTANCE = new StarRequiresSignIn();

            private StarRequiresSignIn() {
                super(null);
            }
        }

        private UiEvent() {
        }

        public /* synthetic */ UiEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PluginListViewModel.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function1<PluginDataSource, LiveData<LoadState>> {

        /* renamed from: d  reason: collision with root package name */
        public static final a f13230d = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        /* renamed from: a */
        public final LiveData<LoadState> invoke(PluginDataSource pluginDataSource) {
            return pluginDataSource.getLoadState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginListViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<Throwable, Unit> {
        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            PluginListViewModel.this.getUiEvent().postValue(UiEvent.ReportFailed.INSTANCE);
        }
    }

    /* compiled from: PluginListViewModel.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ PluginDetail $overridenPluginDetail;
        final /* synthetic */ PluginDetail $pluginDetail;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(PluginDetail pluginDetail, PluginDetail pluginDetail2) {
            super(1);
            this.$overridenPluginDetail = pluginDetail;
            this.$pluginDetail = pluginDetail2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            PluginListViewModel.this.f13222d.addLocalOverride(this.$overridenPluginDetail.getId(), this.$pluginDetail);
            PluginListViewModel.this.getUiEvent().postValue(UiEvent.RefreshList.INSTANCE);
        }
    }

    @Inject
    public PluginListViewModel(@NotNull PluginListApi api, @NotNull UserProvider userProvider, @NotNull ScreenLoader screenLoader, @NotNull LocalPluginListOverrideStore pluginListOverrideStore, @ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(userProvider, "userProvider");
        Intrinsics.checkNotNullParameter(screenLoader, "screenLoader");
        Intrinsics.checkNotNullParameter(pluginListOverrideStore, "pluginListOverrideStore");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f13219a = api;
        this.f13220b = userProvider;
        this.f13221c = screenLoader;
        this.f13222d = pluginListOverrideStore;
        this.f13223e = context;
        this.f13225g = new SingleLiveEvent<>();
        this.f13226h = new SingleLiveEvent<>();
        this.f13228j = new CompositeDisposable();
    }

    private final void e(final PluginDetail pluginDetail, int i4) {
        if (Settings.getPluginReportIds(this.f13223e).contains(String.valueOf(pluginDetail.getId()))) {
            this.f13225g.postValue(UiEvent.ReportSubmitted.INSTANCE);
            return;
        }
        CompositeDisposable compositeDisposable = this.f13228j;
        Completable observeOn = this.f13219a.reportPlugin(pluginDetail.getId(), pluginDetail.getName(), i4).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Action action = new Action() { // from class: com.arlosoft.macrodroid.plugins.pluginlist.e
            @Override // io.reactivex.functions.Action
            public final void run() {
                PluginListViewModel.f(PluginListViewModel.this, pluginDetail);
            }
        };
        final b bVar = new b();
        compositeDisposable.add(observeOn.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.plugins.pluginlist.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PluginListViewModel.g(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(PluginListViewModel this$0, PluginDetail pluginDetail) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pluginDetail, "$pluginDetail");
        Set<String> pluginReportIds = Settings.getPluginReportIds(this$0.f13223e);
        pluginReportIds.add(String.valueOf(pluginDetail.getId()));
        Settings.setPluginReportIds(this$0.f13223e, pluginReportIds);
        this$0.f13225g.postValue(UiEvent.ReportSubmitted.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @NotNull
    public final SingleLiveEvent<PluginDetail> getLoadCommentsEvent() {
        return this.f13226h;
    }

    @NotNull
    public final LiveData<LoadState> getLoadState() {
        PluginDataSourceFactory pluginDataSourceFactory = this.f13227i;
        if (pluginDataSourceFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sourceFactory");
            pluginDataSourceFactory = null;
        }
        return Transformations.switchMap(pluginDataSourceFactory.getPluginDataSourceLive(), a.f13230d);
    }

    @NotNull
    public final LiveData<PagedList<PluginDetail>> getPagedList() {
        LiveData<PagedList<PluginDetail>> liveData = this.pagedList;
        if (liveData != null) {
            return liveData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pagedList");
        return null;
    }

    @NotNull
    public final SingleLiveEvent<UiEvent> getUiEvent() {
        return this.f13225g;
    }

    public final void initialiseWithOrder(@OrderByOption int i4) {
        this.f13224f = i4;
        this.f13227i = new PluginDataSourceFactory(this.f13219a, this.f13228j, this.f13220b.getUser().getUserId(), i4, "en", null, 32, null);
        PagedList.Config build = new PagedList.Config.Builder().setPageSize(50).setInitialLoadSizeHint(100).setEnablePlaceholders(false).build();
        PluginDataSourceFactory pluginDataSourceFactory = this.f13227i;
        if (pluginDataSourceFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sourceFactory");
            pluginDataSourceFactory = null;
        }
        setPagedList(new LivePagedListBuilder(pluginDataSourceFactory, build).build());
    }

    public final void invalidatePagedList() {
        PagingSource<?, PluginDetail> pagingSource;
        try {
            PagedList<PluginDetail> value = getPagedList().getValue();
            if (value != null && (pagingSource = value.getPagingSource()) != null) {
                pagingSource.invalidate();
            }
        } catch (IllegalStateException e4) {
            FirebaseAnalyticsEventLogger.logHandledException(e4);
        }
    }

    public final void onLoadCommentClicked(@NotNull PluginDetail plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.f13226h.postValue(plugin);
    }

    public final void onOverflowClicked(@NotNull PluginDetail plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.f13225g.postValue(new UiEvent.ShowOptionsDialog(plugin));
    }

    public final void onUsernameClicked(@NotNull PluginDetail pluginDetail, @NotNull AvatarView avatarImage) {
        Intrinsics.checkNotNullParameter(pluginDetail, "pluginDetail");
        Intrinsics.checkNotNullParameter(avatarImage, "avatarImage");
        this.f13221c.loadUserDetailsScreen(pluginDetail.getUsername(), pluginDetail.getUserImage(), pluginDetail.getUserId(), avatarImage);
    }

    public final void reportBrokenDownload(@NotNull PluginDetail pluginDetail) {
        Intrinsics.checkNotNullParameter(pluginDetail, "pluginDetail");
        e(pluginDetail, 0);
    }

    public final void reportInvalidPlugin(@NotNull PluginDetail pluginDetail) {
        Intrinsics.checkNotNullParameter(pluginDetail, "pluginDetail");
        e(pluginDetail, 1);
    }

    public final void setPagedList(@NotNull LiveData<PagedList<PluginDetail>> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.pagedList = liveData;
    }

    @NotNull
    public final LiveData<PagedList<PluginDetail>> setSearchText(@NotNull String searchText) {
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        this.f13224f = this.f13224f;
        this.f13227i = new PluginDataSourceFactory(this.f13219a, this.f13228j, this.f13220b.getUser().getUserId(), this.f13224f, "en", searchText);
        PagedList.Config build = new PagedList.Config.Builder().setPageSize(50).setInitialLoadSizeHint(100).setEnablePlaceholders(false).build();
        PluginDataSourceFactory pluginDataSourceFactory = this.f13227i;
        if (pluginDataSourceFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sourceFactory");
            pluginDataSourceFactory = null;
        }
        setPagedList(new LivePagedListBuilder(pluginDataSourceFactory, build).build());
        return getPagedList();
    }

    public final void starClicked(@NotNull PluginDetail pluginDetail) {
        Intrinsics.checkNotNullParameter(pluginDetail, "pluginDetail");
        int userId = this.f13220b.getUser().getUserId();
        if (userId == 0) {
            this.f13225g.postValue(UiEvent.StarRequiresSignIn.INSTANCE);
            return;
        }
        PluginDetail localOverride = this.f13222d.getLocalOverride(pluginDetail.getId());
        if (localOverride == null) {
            localOverride = pluginDetail;
        }
        boolean z3 = !localOverride.getStarred();
        this.f13222d.addLocalOverride(localOverride.getId(), localOverride.updateStarRating(z3));
        String sha256 = StringExtensionsKt.sha256(pluginDetail.getId() + TemplateStoreApiKt.TEMPLATE_API_SALT + userId);
        CompositeDisposable compositeDisposable = this.f13228j;
        Completable observeOn = this.f13219a.starPlugin(sha256, localOverride.getId(), userId, z3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Action action = new Action() { // from class: com.arlosoft.macrodroid.plugins.pluginlist.g
            @Override // io.reactivex.functions.Action
            public final void run() {
                PluginListViewModel.h();
            }
        };
        final c cVar = new c(localOverride, pluginDetail);
        compositeDisposable.add(observeOn.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.plugins.pluginlist.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PluginListViewModel.i(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
    }
}
