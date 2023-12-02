package com.arlosoft.macrodroid.templatestore.ui.userlist.data;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.model.User;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: UserViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UserViewModel extends ViewModel {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private LiveData<PagedList<User>> f14272a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CompositeDisposable f14273b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final UserDataSourceFactory f14274c;

    public UserViewModel(@NotNull TemplateStoreApi api, @NotNull String searchTerm) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(searchTerm, "searchTerm");
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f14273b = compositeDisposable;
        UserDataSourceFactory userDataSourceFactory = new UserDataSourceFactory(api, compositeDisposable, searchTerm);
        this.f14274c = userDataSourceFactory;
        this.f14272a = new LivePagedListBuilder(userDataSourceFactory, new PagedList.Config.Builder().setPageSize(20).setInitialLoadSizeHint(40).setEnablePlaceholders(false).build()).build();
    }

    @NotNull
    public final LiveData<PagedList<User>> getUserList() {
        return this.f14272a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f14273b.dispose();
    }

    public final void setUserList(@NotNull LiveData<PagedList<User>> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.f14272a = liveData;
    }
}
