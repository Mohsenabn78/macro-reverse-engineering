package com.arlosoft.macrodroid.templatestore.ui.comments.data;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.common.LoadState;
import com.arlosoft.macrodroid.templatestore.model.Comment;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: commentsViewModelForPlugin.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public class CommentsViewModel extends ViewModel {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private LiveData<PagedList<Comment>> f13772a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CompositeDisposable f13773b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final CommentsDataSourceFactory f13774c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: commentsViewModelForPlugin.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<CommentsDataSource, LiveData<LoadState>> {

        /* renamed from: d  reason: collision with root package name */
        public static final a f13775d = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        /* renamed from: a */
        public final LiveData<LoadState> invoke(CommentsDataSource commentsDataSource) {
            return commentsDataSource.getLoadState();
        }
    }

    public CommentsViewModel(@NotNull TemplateStoreApi api, int i4) {
        Intrinsics.checkNotNullParameter(api, "api");
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f13773b = compositeDisposable;
        CommentsDataSourceFactory commentsDataSourceFactory = new CommentsDataSourceFactory(api, compositeDisposable, i4);
        this.f13774c = commentsDataSourceFactory;
        this.f13772a = new LivePagedListBuilder(commentsDataSourceFactory, new PagedList.Config.Builder().setPageSize(10).setInitialLoadSizeHint(20).setEnablePlaceholders(false).build()).build();
    }

    @NotNull
    public final LiveData<PagedList<Comment>> getCommentsList() {
        return this.f13772a;
    }

    @NotNull
    public final LiveData<LoadState> getLoadState() {
        return Transformations.switchMap(this.f13774c.getCommentsDataSourceLiveData(), a.f13775d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f13773b.dispose();
    }

    public final void setCommentsList(@NotNull LiveData<PagedList<Comment>> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.f13772a = liveData;
    }
}
