package com.arlosoft.macrodroid.plugins.comments.data;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.arlosoft.macrodroid.plugins.api.PluginListApi;
import com.arlosoft.macrodroid.templatestore.model.Comment;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: PluginCommentsDataSourceFactory.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class PluginCommentsDataSourceFactory extends DataSource.Factory<Long, Comment> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final PluginListApi f13155a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CompositeDisposable f13156b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13157c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final MutableLiveData<PluginCommentsDataSource> f13158d;

    public PluginCommentsDataSourceFactory(@NotNull PluginListApi api, @NotNull CompositeDisposable compositeDisposable, int i4) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(compositeDisposable, "compositeDisposable");
        this.f13155a = api;
        this.f13156b = compositeDisposable;
        this.f13157c = i4;
        this.f13158d = new MutableLiveData<>();
    }

    @Override // androidx.paging.DataSource.Factory
    @NotNull
    public DataSource<Long, Comment> create() {
        PluginCommentsDataSource pluginCommentsDataSource = new PluginCommentsDataSource(this.f13155a, this.f13156b, this.f13157c);
        this.f13158d.postValue(pluginCommentsDataSource);
        return pluginCommentsDataSource;
    }

    @NotNull
    public final MutableLiveData<PluginCommentsDataSource> getCommentsDataSourceLiveData() {
        return this.f13158d;
    }

    public final void refresh() {
        PluginCommentsDataSource value = this.f13158d.getValue();
        if (value != null) {
            value.invalidate();
        }
    }
}
