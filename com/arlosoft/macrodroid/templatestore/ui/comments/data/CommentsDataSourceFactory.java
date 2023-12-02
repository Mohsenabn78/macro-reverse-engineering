package com.arlosoft.macrodroid.templatestore.ui.comments.data;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.model.Comment;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: CommentsDataSourceFactory.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class CommentsDataSourceFactory extends DataSource.Factory<Long, Comment> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final TemplateStoreApi f13768a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CompositeDisposable f13769b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13770c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final MutableLiveData<CommentsDataSource> f13771d;

    public CommentsDataSourceFactory(@NotNull TemplateStoreApi api, @NotNull CompositeDisposable compositeDisposable, int i4) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(compositeDisposable, "compositeDisposable");
        this.f13768a = api;
        this.f13769b = compositeDisposable;
        this.f13770c = i4;
        this.f13771d = new MutableLiveData<>();
    }

    @Override // androidx.paging.DataSource.Factory
    @NotNull
    public DataSource<Long, Comment> create() {
        CommentsDataSource commentsDataSource = new CommentsDataSource(this.f13768a, this.f13769b, this.f13770c);
        this.f13771d.postValue(commentsDataSource);
        return commentsDataSource;
    }

    @NotNull
    public final MutableLiveData<CommentsDataSource> getCommentsDataSourceLiveData() {
        return this.f13771d;
    }
}
