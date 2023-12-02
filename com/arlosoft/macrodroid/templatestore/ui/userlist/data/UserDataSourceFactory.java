package com.arlosoft.macrodroid.templatestore.ui.userlist.data;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.model.User;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: UserDataSourceFactory.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UserDataSourceFactory extends DataSource.Factory<Integer, User> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final TemplateStoreApi f14268a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CompositeDisposable f14269b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f14270c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final MutableLiveData<UserDataSource> f14271d;

    public UserDataSourceFactory(@NotNull TemplateStoreApi api, @NotNull CompositeDisposable compositeDisposable, @NotNull String searchTerm) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(compositeDisposable, "compositeDisposable");
        Intrinsics.checkNotNullParameter(searchTerm, "searchTerm");
        this.f14268a = api;
        this.f14269b = compositeDisposable;
        this.f14270c = searchTerm;
        this.f14271d = new MutableLiveData<>();
    }

    @Override // androidx.paging.DataSource.Factory
    @NotNull
    public DataSource<Integer, User> create() {
        UserDataSource userDataSource = new UserDataSource(this.f14268a, this.f14269b, this.f14270c);
        this.f14271d.postValue(userDataSource);
        return userDataSource;
    }
}
