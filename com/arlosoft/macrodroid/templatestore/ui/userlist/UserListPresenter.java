package com.arlosoft.macrodroid.templatestore.ui.userlist;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import com.arlosoft.macrodroid.app.mvp.Presenter;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.events.UserBlockedEvent;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.SearchTermListener;
import com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider;
import com.arlosoft.macrodroid.templatestore.ui.upload.TemplateRefreshNotifier;
import com.arlosoft.macrodroid.templatestore.ui.userlist.data.UserViewModel;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserListPresenter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UserListPresenter extends Presenter<UserListViewContract> implements SearchTermListener {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ScreenLoader f14247b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final TemplateStoreApi f14248c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final TemplateRefreshNotifier f14249d;

    /* renamed from: e  reason: collision with root package name */
    private CompositeDisposable f14250e;

    /* renamed from: f  reason: collision with root package name */
    private UserViewModel f14251f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private SearchTermProvider f14252g;

    /* renamed from: h  reason: collision with root package name */
    private int f14253h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserListPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Observer<PagedList<User>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UserListViewContract f14255b;

        a(UserListViewContract userListViewContract) {
            this.f14255b = userListViewContract;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(@NotNull PagedList<User> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            if (UserListPresenter.this.d(list)) {
                this.f14255b.showLoadDataError();
            } else if (UserListPresenter.this.e(list)) {
                this.f14255b.showPirateUserError();
            } else if (!list.isEmpty()) {
                this.f14255b.showLoadingState(false);
                this.f14255b.updateList(list);
            }
        }
    }

    /* compiled from: UserListPresenter.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements Function1<Boolean, Unit> {
        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            UserListPresenter.this.loadUsers();
        }
    }

    @Inject
    public UserListPresenter(@NotNull ScreenLoader screenLoader, @NotNull TemplateStoreApi api, @NotNull TemplateRefreshNotifier templateRefreshNotifier) {
        Intrinsics.checkNotNullParameter(screenLoader, "screenLoader");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(templateRefreshNotifier, "templateRefreshNotifier");
        this.f14247b = screenLoader;
        this.f14248c = api;
        this.f14249d = templateRefreshNotifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d(PagedList<User> pagedList) {
        boolean z3;
        boolean z4;
        if (pagedList != null && pagedList.size() == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            User user = pagedList.get(0);
            if (user != null) {
                z4 = user.isErrorUser();
            } else {
                z4 = false;
            }
            if (z4) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(PagedList<User> pagedList) {
        boolean z3;
        boolean z4;
        if (pagedList != null && pagedList.size() == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            User user = pagedList.get(0);
            if (user != null) {
                z4 = user.isPirateUser();
            } else {
                z4 = false;
            }
            if (z4) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.arlosoft.macrodroid.app.mvp.Presenter
    protected void a() {
        CompositeDisposable compositeDisposable = this.f14250e;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        compositeDisposable.clear();
        this.f14252g = null;
        EventBusUtils.getEventBus().unregister(this);
    }

    @Override // com.arlosoft.macrodroid.app.mvp.Presenter
    protected void b() {
        this.f14250e = new CompositeDisposable();
        loadUsers();
        SearchTermProvider searchTermProvider = this.f14252g;
        if (searchTermProvider != null) {
            searchTermProvider.addSearchTermListener(this);
        }
        CompositeDisposable compositeDisposable = this.f14250e;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        Flowable<Boolean> requiresRefreshFlowable = this.f14249d.requiresRefreshFlowable();
        final b bVar = new b();
        compositeDisposable.add(requiresRefreshFlowable.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.userlist.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                UserListPresenter.f(Function1.this, obj);
            }
        }));
        EventBusUtils.getEventBus().register(this);
    }

    public final void loadUsers() {
        TemplateStoreApi templateStoreApi = this.f14248c;
        SearchTermProvider searchTermProvider = this.f14252g;
        this.f14251f = new UserViewModel(templateStoreApi, (searchTermProvider == null || (r2 = searchTermProvider.getSearchTerm()) == null) ? "" : "");
        UserListViewContract view = getView();
        if (view != null) {
            view.showLoadingState(true);
        }
        UserListViewContract view2 = getView();
        if (view2 != null) {
            view2.initialiseList();
        }
        UserListViewContract view3 = getView();
        if (view3 != null) {
            UserViewModel userViewModel = this.f14251f;
            if (userViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userViewModel");
                userViewModel = null;
            }
            userViewModel.getUserList().observe(view3, new a(view3));
        }
    }

    public final void onEventMainThread(@NotNull UserBlockedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        UserListViewContract view = getView();
        if (view != null) {
            view.refresh();
        }
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.SearchTermListener
    public void onSearchTermUpdated(@NotNull String searchTerm) {
        Intrinsics.checkNotNullParameter(searchTerm, "searchTerm");
        loadUsers();
    }

    public final void onUserClicked(@NotNull User user, @NotNull AvatarView avatarImage) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(avatarImage, "avatarImage");
        this.f14247b.loadUserDetailsScreen(user.getUsername(), user.getImage(), user.getUserId(), avatarImage);
    }

    public final void takeView(@NotNull UserListViewContract view, @NotNull SearchTermProvider searchTermProvider, int i4) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(searchTermProvider, "searchTermProvider");
        this.f14252g = searchTermProvider;
        this.f14253h = i4;
        super.takeView(view);
    }
}
