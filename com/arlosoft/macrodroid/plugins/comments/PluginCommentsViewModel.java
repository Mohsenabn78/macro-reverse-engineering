package com.arlosoft.macrodroid.plugins.comments;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.plugins.api.PluginListApi;
import com.arlosoft.macrodroid.plugins.comments.data.PluginCommentsDataSource;
import com.arlosoft.macrodroid.plugins.comments.data.PluginCommentsDataSourceFactory;
import com.arlosoft.macrodroid.plugins.data.LocalPluginListOverrideStore;
import com.arlosoft.macrodroid.plugins.data.PluginDetail;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApiKt;
import com.arlosoft.macrodroid.templatestore.common.LoadState;
import com.arlosoft.macrodroid.templatestore.model.Comment;
import com.arlosoft.macrodroid.templatestore.model.PluginPostCommentBody;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;

/* compiled from: PluginCommentsViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class PluginCommentsViewModel extends ViewModel {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final PluginListApi f13128a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final UserProvider f13129b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final LocalPluginListOverrideStore f13130c;
    public LiveData<PagedList<Comment>> commentsList;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final SingleLiveEvent<UiState> f13131d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final CompositeDisposable f13132e;

    /* renamed from: f  reason: collision with root package name */
    private PluginCommentsDataSourceFactory f13133f;

    /* renamed from: g  reason: collision with root package name */
    private PluginDetail f13134g;

    /* compiled from: PluginCommentsViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static abstract class UiState {
        public static final int $stable = 0;

        /* compiled from: PluginCommentsViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class CommentUpdateFailed extends UiState {
            public static final int $stable = 0;

            /* renamed from: a  reason: collision with root package name */
            private final boolean f13135a;

            public CommentUpdateFailed(boolean z3) {
                super(null);
                this.f13135a = z3;
            }

            public final boolean getNotAllowed() {
                return this.f13135a;
            }
        }

        /* compiled from: PluginCommentsViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class CommentUpdated extends UiState {
            public static final int $stable = 0;
            @NotNull
            public static final CommentUpdated INSTANCE = new CommentUpdated();

            private CommentUpdated() {
                super(null);
            }
        }

        /* compiled from: PluginCommentsViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class CommentUploadFailed extends UiState {
            public static final int $stable = 0;

            /* renamed from: a  reason: collision with root package name */
            private final boolean f13136a;

            public CommentUploadFailed(boolean z3) {
                super(null);
                this.f13136a = z3;
            }

            public final boolean getNotAllowed() {
                return this.f13136a;
            }
        }

        /* compiled from: PluginCommentsViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class CommentUploaded extends UiState {
            public static final int $stable = 0;
            @NotNull
            public static final CommentUploaded INSTANCE = new CommentUploaded();

            private CommentUploaded() {
                super(null);
            }
        }

        /* compiled from: PluginCommentsViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class DeleteFailed extends UiState {
            public static final int $stable = 0;
            @NotNull
            public static final DeleteFailed INSTANCE = new DeleteFailed();

            private DeleteFailed() {
                super(null);
            }
        }

        private UiState() {
        }

        public /* synthetic */ UiState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginCommentsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Throwable, Unit> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            PluginCommentsViewModel.this.getUiState().postValue(UiState.DeleteFailed.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginCommentsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<PluginCommentsDataSource, LiveData<LoadState>> {

        /* renamed from: d  reason: collision with root package name */
        public static final b f13137d = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        /* renamed from: a */
        public final LiveData<LoadState> invoke(PluginCommentsDataSource pluginCommentsDataSource) {
            return pluginCommentsDataSource.getLoadState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginCommentsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<Throwable, Unit> {
        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            PluginCommentsViewModel.this.getUiState().postValue(new UiState.CommentUploadFailed((th instanceof HttpException) && ((HttpException) th).code() == 403));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginCommentsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements Function1<Throwable, Unit> {
        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            PluginCommentsViewModel.this.getUiState().postValue(new UiState.CommentUpdateFailed((th instanceof HttpException) && ((HttpException) th).code() == 403));
        }
    }

    @Inject
    public PluginCommentsViewModel(@NotNull PluginListApi api, @NotNull UserProvider userProvider, @NotNull LocalPluginListOverrideStore pluginListOverrideStore) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(userProvider, "userProvider");
        Intrinsics.checkNotNullParameter(pluginListOverrideStore, "pluginListOverrideStore");
        this.f13128a = api;
        this.f13129b = userProvider;
        this.f13130c = pluginListOverrideStore;
        this.f13131d = new SingleLiveEvent<>();
        this.f13132e = new CompositeDisposable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(PluginCommentsViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f13131d.postValue(UiState.CommentUpdated.INSTANCE);
        PluginDetail pluginDetail = this$0.f13134g;
        PluginDetail pluginDetail2 = null;
        if (pluginDetail == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pluginDetail");
            pluginDetail = null;
        }
        PluginDetail updateCommentCount = pluginDetail.updateCommentCount(false);
        this$0.f13134g = updateCommentCount;
        LocalPluginListOverrideStore localPluginListOverrideStore = this$0.f13130c;
        if (updateCommentCount == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pluginDetail");
            updateCommentCount = null;
        }
        int id = updateCommentCount.getId();
        PluginDetail pluginDetail3 = this$0.f13134g;
        if (pluginDetail3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pluginDetail");
        } else {
            pluginDetail2 = pluginDetail3;
        }
        localPluginListOverrideStore.addLocalOverride(id, pluginDetail2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(PluginCommentsViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PluginCommentsDataSourceFactory pluginCommentsDataSourceFactory = this$0.f13133f;
        PluginDetail pluginDetail = null;
        if (pluginCommentsDataSourceFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sourceFactory");
            pluginCommentsDataSourceFactory = null;
        }
        pluginCommentsDataSourceFactory.refresh();
        this$0.f13131d.postValue(UiState.CommentUploaded.INSTANCE);
        PluginDetail pluginDetail2 = this$0.f13134g;
        if (pluginDetail2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pluginDetail");
            pluginDetail2 = null;
        }
        PluginDetail updateCommentCount = pluginDetail2.updateCommentCount(true);
        this$0.f13134g = updateCommentCount;
        LocalPluginListOverrideStore localPluginListOverrideStore = this$0.f13130c;
        if (updateCommentCount == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pluginDetail");
            updateCommentCount = null;
        }
        int id = updateCommentCount.getId();
        PluginDetail pluginDetail3 = this$0.f13134g;
        if (pluginDetail3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pluginDetail");
        } else {
            pluginDetail = pluginDetail3;
        }
        localPluginListOverrideStore.addLocalOverride(id, pluginDetail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(PluginCommentsViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f13131d.postValue(UiState.CommentUpdated.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void deleteComment(@NotNull Comment comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        int id = comment.getId();
        int pluginId = comment.getPluginId();
        String sha256 = StringExtensionsKt.sha256(id + TemplateStoreApiKt.TEMPLATE_API_SALT + pluginId);
        CompositeDisposable compositeDisposable = this.f13132e;
        Completable observeOn = this.f13128a.deleteComment(sha256, comment.getId(), comment.getPluginId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Action action = new Action() { // from class: com.arlosoft.macrodroid.plugins.comments.b
            @Override // io.reactivex.functions.Action
            public final void run() {
                PluginCommentsViewModel.g(PluginCommentsViewModel.this);
            }
        };
        final a aVar = new a();
        compositeDisposable.add(observeOn.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.plugins.comments.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PluginCommentsViewModel.h(Function1.this, obj);
            }
        }));
    }

    @NotNull
    public final LiveData<PagedList<Comment>> getCommentsList() {
        LiveData<PagedList<Comment>> liveData = this.commentsList;
        if (liveData != null) {
            return liveData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("commentsList");
        return null;
    }

    @NotNull
    public final LiveData<LoadState> getLoadState() {
        PluginCommentsDataSourceFactory pluginCommentsDataSourceFactory = this.f13133f;
        if (pluginCommentsDataSourceFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sourceFactory");
            pluginCommentsDataSourceFactory = null;
        }
        return Transformations.switchMap(pluginCommentsDataSourceFactory.getCommentsDataSourceLiveData(), b.f13137d);
    }

    @NotNull
    public final SingleLiveEvent<UiState> getUiState() {
        return this.f13131d;
    }

    public final void initialiseWithPluginId(@NotNull PluginDetail pluginDetail) {
        Intrinsics.checkNotNullParameter(pluginDetail, "pluginDetail");
        this.f13134g = pluginDetail;
        this.f13133f = new PluginCommentsDataSourceFactory(this.f13128a, this.f13132e, pluginDetail.getId());
        PagedList.Config build = new PagedList.Config.Builder().setPageSize(10).setInitialLoadSizeHint(20).setEnablePlaceholders(false).build();
        PluginCommentsDataSourceFactory pluginCommentsDataSourceFactory = this.f13133f;
        if (pluginCommentsDataSourceFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sourceFactory");
            pluginCommentsDataSourceFactory = null;
        }
        setCommentsList(new LivePagedListBuilder(pluginCommentsDataSourceFactory, build).build());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.f13132e.dispose();
    }

    public final void sendComment(@NotNull String commentText) {
        boolean z3;
        Intrinsics.checkNotNullParameter(commentText, "commentText");
        if (commentText.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return;
        }
        PluginDetail pluginDetail = this.f13134g;
        PluginDetail pluginDetail2 = null;
        if (pluginDetail == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pluginDetail");
            pluginDetail = null;
        }
        String sha256 = StringExtensionsKt.sha256(pluginDetail.getId() + TemplateStoreApiKt.TEMPLATE_API_SALT + this.f13129b.getUser().getUserId() + commentText);
        CompositeDisposable compositeDisposable = this.f13132e;
        CompletableSource[] completableSourceArr = new CompletableSource[2];
        completableSourceArr[0] = Completable.timer(2L, TimeUnit.SECONDS);
        PluginListApi pluginListApi = this.f13128a;
        int userId = this.f13129b.getUser().getUserId();
        PluginDetail pluginDetail3 = this.f13134g;
        if (pluginDetail3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pluginDetail");
        } else {
            pluginDetail2 = pluginDetail3;
        }
        completableSourceArr[1] = pluginListApi.postComment(sha256, new PluginPostCommentBody(userId, pluginDetail2.getId(), commentText));
        Completable observeOn = Completable.mergeArray(completableSourceArr).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Action action = new Action() { // from class: com.arlosoft.macrodroid.plugins.comments.d
            @Override // io.reactivex.functions.Action
            public final void run() {
                PluginCommentsViewModel.i(PluginCommentsViewModel.this);
            }
        };
        final c cVar = new c();
        compositeDisposable.add(observeOn.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.plugins.comments.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PluginCommentsViewModel.j(Function1.this, obj);
            }
        }));
    }

    public final void setCommentsList(@NotNull LiveData<PagedList<Comment>> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<set-?>");
        this.commentsList = liveData;
    }

    public final void updateComment(@NotNull Comment comment, @NotNull String newCommentText) {
        boolean z3;
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(newCommentText, "newCommentText");
        if (Intrinsics.areEqual(comment.getText(), newCommentText)) {
            return;
        }
        if (newCommentText.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return;
        }
        int id = comment.getId();
        String sha256 = StringExtensionsKt.sha256(id + TemplateStoreApiKt.TEMPLATE_API_SALT + newCommentText);
        CompositeDisposable compositeDisposable = this.f13132e;
        Completable observeOn = Completable.mergeArray(Completable.timer(2L, TimeUnit.SECONDS), this.f13128a.updateComment(sha256, this.f13129b.getUser().getUserId(), comment.getId(), newCommentText)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Action action = new Action() { // from class: com.arlosoft.macrodroid.plugins.comments.f
            @Override // io.reactivex.functions.Action
            public final void run() {
                PluginCommentsViewModel.k(PluginCommentsViewModel.this);
            }
        };
        final d dVar = new d();
        compositeDisposable.add(observeOn.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.plugins.comments.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PluginCommentsViewModel.l(Function1.this, obj);
            }
        }));
    }
}
