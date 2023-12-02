package com.arlosoft.macrodroid.plugins.data;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.arlosoft.macrodroid.plugins.api.PluginListApi;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PluginDataSourceFactory.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class PluginDataSourceFactory extends DataSource.Factory<Integer, PluginDetail> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final PluginListApi f13184a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CompositeDisposable f13185b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13186c;

    /* renamed from: d  reason: collision with root package name */
    private final int f13187d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final String f13188e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final String f13189f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final MutableLiveData<PluginDataSource> f13190g;

    public /* synthetic */ PluginDataSourceFactory(PluginListApi pluginListApi, CompositeDisposable compositeDisposable, int i4, int i5, String str, String str2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(pluginListApi, compositeDisposable, i4, i5, str, (i6 & 32) != 0 ? null : str2);
    }

    @Override // androidx.paging.DataSource.Factory
    @NotNull
    public DataSource<Integer, PluginDetail> create() {
        PluginDataSource pluginDataSource = new PluginDataSource(this.f13184a, this.f13185b, this.f13186c, this.f13187d, this.f13188e, this.f13189f);
        this.f13190g.postValue(pluginDataSource);
        return pluginDataSource;
    }

    @NotNull
    public final MutableLiveData<PluginDataSource> getPluginDataSourceLive() {
        return this.f13190g;
    }

    public final void setSearchTerm(@Nullable String str) {
        PluginDataSource value = this.f13190g.getValue();
        if (value != null) {
            value.setSearchTerm(str);
        }
    }

    public PluginDataSourceFactory(@NotNull PluginListApi api, @NotNull CompositeDisposable compositeDisposable, int i4, int i5, @NotNull String language, @Nullable String str) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(compositeDisposable, "compositeDisposable");
        Intrinsics.checkNotNullParameter(language, "language");
        this.f13184a = api;
        this.f13185b = compositeDisposable;
        this.f13186c = i4;
        this.f13187d = i5;
        this.f13188e = language;
        this.f13189f = str;
        this.f13190g = new MutableLiveData<>();
    }
}
