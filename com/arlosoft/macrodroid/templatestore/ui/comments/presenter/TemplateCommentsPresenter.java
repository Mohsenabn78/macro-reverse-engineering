package com.arlosoft.macrodroid.templatestore.ui.comments.presenter;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.mvp.Presenter;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.database.room.BlockedUser;
import com.arlosoft.macrodroid.database.room.BlockedUserDao;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApiKt;
import com.arlosoft.macrodroid.templatestore.events.UserBlockedEvent;
import com.arlosoft.macrodroid.templatestore.model.Comment;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.arlosoft.macrodroid.templatestore.model.PostCommentBody;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsViewContract;
import com.arlosoft.macrodroid.templatestore.ui.templateList.LocalTemplateOverrideStore;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.utils.SigningHelper;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;

/* compiled from: TemplateCommentsPresenter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TemplateCommentsPresenter extends Presenter<TemplateCommentsViewContract> implements CoroutineScope {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ScreenLoader f13782b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final TemplateStoreApi f13783c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final UserProvider f13784d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final LocalTemplateOverrideStore f13785e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final MacroDroidRoomDatabase f13786f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private CompletableJob f13787g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private CoroutineContext f13788h;

    /* renamed from: i  reason: collision with root package name */
    private MacroTemplate f13789i;

    /* renamed from: j  reason: collision with root package name */
    private CompositeDisposable f13790j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateCommentsPresenter.kt */
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
            boolean z3 = (th instanceof HttpException) && ((HttpException) th).code() == 403;
            TemplateCommentsViewContract view = TemplateCommentsPresenter.this.getView();
            if (view != null) {
                view.showCommentUploadFailed(z3);
            }
            TemplateCommentsViewContract view2 = TemplateCommentsPresenter.this.getView();
            if (view2 != null) {
                view2.setCommentEnabledState(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateCommentsPresenter.kt */
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
            TemplateCommentsViewContract view = TemplateCommentsPresenter.this.getView();
            if (view != null) {
                view.showDeleteFailed();
            }
            TemplateCommentsViewContract view2 = TemplateCommentsPresenter.this.getView();
            if (view2 != null) {
                view2.setCommentEnabledState(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateCommentsPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<List<? extends MacroTemplate>, Unit> {
        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends MacroTemplate> list) {
            invoke2((List<MacroTemplate>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<MacroTemplate> it) {
            Object first;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (!it.isEmpty()) {
                TemplateCommentsPresenter templateCommentsPresenter = TemplateCommentsPresenter.this;
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) it);
                templateCommentsPresenter.f13789i = (MacroTemplate) first;
                TemplateCommentsViewContract view = TemplateCommentsPresenter.this.getView();
                if (view != null) {
                    MacroTemplate macroTemplate = TemplateCommentsPresenter.this.f13789i;
                    if (macroTemplate == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
                        macroTemplate = null;
                    }
                    view.showMacroTemplate(macroTemplate);
                    return;
                }
                return;
            }
            TemplateCommentsViewContract view2 = TemplateCommentsPresenter.this.getView();
            if (view2 != null) {
                view2.showTemplateError();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateCommentsPresenter.kt */
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
            TemplateCommentsViewContract view = TemplateCommentsPresenter.this.getView();
            if (view != null) {
                view.showTemplateError();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateCommentsPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Comment $comment;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TemplateCommentsPresenter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TemplateCommentsPresenter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(TemplateCommentsPresenter templateCommentsPresenter, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = templateCommentsPresenter;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    TemplateCommentsViewContract view = this.this$0.getView();
                    if (view != null) {
                        MacroTemplate macroTemplate = this.this$0.f13789i;
                        if (macroTemplate == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
                            macroTemplate = null;
                        }
                        view.showMacroTemplate(macroTemplate);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Comment comment, Continuation<? super e> continuation) {
            super(2, continuation);
            this.$comment = comment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new e(this.$comment, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                BlockedUserDao blockedUserDao = TemplateCommentsPresenter.this.f13786f.blockedUserDao();
                BlockedUser blockedUser = new BlockedUser(this.$comment.getUserId(), this.$comment.getUsername());
                this.label = 1;
                if (blockedUserDao.addBlockedUser(blockedUser, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            EventBusUtils.getEventBus().post(new UserBlockedEvent(this.$comment.getUserId()));
            MainCoroutineDispatcher main = Dispatchers.getMain();
            a aVar = new a(TemplateCommentsPresenter.this, null);
            this.label = 2;
            if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateCommentsPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Comment $comment;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TemplateCommentsPresenter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TemplateCommentsPresenter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(TemplateCommentsPresenter templateCommentsPresenter, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = templateCommentsPresenter;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    TemplateCommentsViewContract view = this.this$0.getView();
                    if (view != null) {
                        MacroTemplate macroTemplate = this.this$0.f13789i;
                        if (macroTemplate == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
                            macroTemplate = null;
                        }
                        view.showMacroTemplate(macroTemplate);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Comment comment, Continuation<? super f> continuation) {
            super(2, continuation);
            this.$comment = comment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new f(this.$comment, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                BlockedUserDao blockedUserDao = TemplateCommentsPresenter.this.f13786f.blockedUserDao();
                int userId = this.$comment.getUserId();
                this.label = 1;
                if (blockedUserDao.deleteBlockedUser(userId, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            EventBusUtils.getEventBus().post(new UserBlockedEvent(this.$comment.getUserId()));
            MainCoroutineDispatcher main = Dispatchers.getMain();
            a aVar = new a(TemplateCommentsPresenter.this, null);
            this.label = 2;
            if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateCommentsPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class g extends Lambda implements Function1<Throwable, Unit> {
        g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            boolean z3 = (th instanceof HttpException) && ((HttpException) th).code() == 403;
            TemplateCommentsViewContract view = TemplateCommentsPresenter.this.getView();
            if (view != null) {
                view.showCommentUploadFailed(z3);
            }
            TemplateCommentsViewContract view2 = TemplateCommentsPresenter.this.getView();
            if (view2 != null) {
                view2.setDialogCommentEnabledState(true);
            }
            TemplateCommentsViewContract view3 = TemplateCommentsPresenter.this.getView();
            if (view3 != null) {
                view3.setUpdatingComment(false);
            }
        }
    }

    @Inject
    public TemplateCommentsPresenter(@NotNull ScreenLoader screenLoader, @NotNull TemplateStoreApi api, @NotNull UserProvider userProvider, @NotNull LocalTemplateOverrideStore localTemplateOverrideStore, @NotNull MacroDroidRoomDatabase roomDatabase) {
        CompletableJob c4;
        Intrinsics.checkNotNullParameter(screenLoader, "screenLoader");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(userProvider, "userProvider");
        Intrinsics.checkNotNullParameter(localTemplateOverrideStore, "localTemplateOverrideStore");
        Intrinsics.checkNotNullParameter(roomDatabase, "roomDatabase");
        this.f13782b = screenLoader;
        this.f13783c = api;
        this.f13784d = userProvider;
        this.f13785e = localTemplateOverrideStore;
        this.f13786f = roomDatabase;
        c4 = u.c(null, 1, null);
        this.f13787g = c4;
        this.f13788h = c4.plus(Dispatchers.getIO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(TemplateCommentsPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TemplateCommentsViewContract view = this$0.getView();
        if (view != null) {
            view.clearCommentText();
        }
        TemplateCommentsViewContract view2 = this$0.getView();
        if (view2 != null) {
            view2.commentsUpdated();
        }
        TemplateCommentsViewContract view3 = this$0.getView();
        if (view3 != null) {
            view3.setCommentEnabledState(true);
        }
        MacroTemplate macroTemplate = this$0.f13789i;
        MacroTemplate macroTemplate2 = null;
        if (macroTemplate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
            macroTemplate = null;
        }
        MacroTemplate updateCommentCount = macroTemplate.updateCommentCount(true);
        this$0.f13789i = updateCommentCount;
        LocalTemplateOverrideStore localTemplateOverrideStore = this$0.f13785e;
        if (updateCommentCount == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
            updateCommentCount = null;
        }
        int id = updateCommentCount.getId();
        MacroTemplate macroTemplate3 = this$0.f13789i;
        if (macroTemplate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
        } else {
            macroTemplate2 = macroTemplate3;
        }
        localTemplateOverrideStore.addLocalOverride(id, macroTemplate2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(TemplateCommentsPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TemplateCommentsViewContract view = this$0.getView();
        if (view != null) {
            view.clearCommentText();
        }
        TemplateCommentsViewContract view2 = this$0.getView();
        if (view2 != null) {
            view2.commentsUpdated();
        }
        TemplateCommentsViewContract view3 = this$0.getView();
        if (view3 != null) {
            view3.setCommentEnabledState(true);
        }
        MacroTemplate macroTemplate = this$0.f13789i;
        MacroTemplate macroTemplate2 = null;
        if (macroTemplate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
            macroTemplate = null;
        }
        MacroTemplate updateCommentCount = macroTemplate.updateCommentCount(false);
        this$0.f13789i = updateCommentCount;
        LocalTemplateOverrideStore localTemplateOverrideStore = this$0.f13785e;
        if (updateCommentCount == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
            updateCommentCount = null;
        }
        int id = updateCommentCount.getId();
        MacroTemplate macroTemplate3 = this$0.f13789i;
        if (macroTemplate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
        } else {
            macroTemplate2 = macroTemplate3;
        }
        localTemplateOverrideStore.addLocalOverride(id, macroTemplate2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(TemplateCommentsPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TemplateCommentsViewContract view = this$0.getView();
        if (view != null) {
            view.clearUpdateDialog();
        }
        TemplateCommentsViewContract view2 = this$0.getView();
        if (view2 != null) {
            view2.commentsUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.arlosoft.macrodroid.app.mvp.Presenter
    protected void a() {
        CompositeDisposable compositeDisposable = this.f13790j;
        if (compositeDisposable != null) {
            if (compositeDisposable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
                compositeDisposable = null;
            }
            compositeDisposable.clear();
        }
        Job.DefaultImpls.cancel$default((Job) this.f13787g, (CancellationException) null, 1, (Object) null);
    }

    public final void addComment(@NotNull String commentText) {
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
        MacroTemplate macroTemplate = this.f13789i;
        MacroTemplate macroTemplate2 = null;
        if (macroTemplate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
            macroTemplate = null;
        }
        String sha256 = StringExtensionsKt.sha256(macroTemplate.getId() + TemplateStoreApiKt.TEMPLATE_API_SALT + this.f13784d.getUser().getUserId() + commentText);
        CompositeDisposable compositeDisposable = this.f13790j;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        CompletableSource[] completableSourceArr = new CompletableSource[2];
        completableSourceArr[0] = Completable.timer(2L, TimeUnit.SECONDS);
        TemplateStoreApi templateStoreApi = this.f13783c;
        int userId = this.f13784d.getUser().getUserId();
        MacroTemplate macroTemplate3 = this.f13789i;
        if (macroTemplate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macroTemplate");
        } else {
            macroTemplate2 = macroTemplate3;
        }
        completableSourceArr[1] = templateStoreApi.postComment(sha256, new PostCommentBody(userId, macroTemplate2.getId(), commentText));
        Completable observeOn = Completable.mergeArray(completableSourceArr).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Action action = new Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.comments.presenter.a
            @Override // io.reactivex.functions.Action
            public final void run() {
                TemplateCommentsPresenter.k(TemplateCommentsPresenter.this);
            }
        };
        final a aVar = new a();
        compositeDisposable.add(observeOn.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.comments.presenter.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TemplateCommentsPresenter.l(Function1.this, obj);
            }
        }));
        TemplateCommentsViewContract view = getView();
        if (view != null) {
            view.showSendingComment();
        }
        TemplateCommentsViewContract view2 = getView();
        if (view2 != null) {
            view2.setCommentEnabledState(false);
        }
    }

    @Override // com.arlosoft.macrodroid.app.mvp.Presenter
    protected void b() {
        this.f13790j = new CompositeDisposable();
    }

    public final void deleteComment(@NotNull Comment comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        int id = comment.getId();
        int macroId = comment.getMacroId();
        String sha256 = StringExtensionsKt.sha256(id + TemplateStoreApiKt.TEMPLATE_API_SALT + macroId);
        CompositeDisposable compositeDisposable = this.f13790j;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        Completable observeOn = this.f13783c.deleteComment(sha256, comment.getId(), comment.getMacroId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Action action = new Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.comments.presenter.c
            @Override // io.reactivex.functions.Action
            public final void run() {
                TemplateCommentsPresenter.m(TemplateCommentsPresenter.this);
            }
        };
        final b bVar = new b();
        compositeDisposable.add(observeOn.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.comments.presenter.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TemplateCommentsPresenter.n(Function1.this, obj);
            }
        }));
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.f13788h;
    }

    public final void loadTemplate(int i4) {
        User user = this.f13784d.getUser();
        String signingKeySha1 = SigningHelper.INSTANCE.getSigningKeySha1(MacroDroidApplication.Companion.getInstance());
        int userId = user.getUserId();
        String sha256 = StringExtensionsKt.sha256(userId + TemplateStoreApiKt.TEMPLATE_API_SALT + signingKeySha1 + "0");
        CompositeDisposable compositeDisposable = this.f13790j;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        TemplateStoreApi templateStoreApi = this.f13783c;
        int userId2 = user.getUserId();
        Single<List<MacroTemplate>> observeOn = templateStoreApi.getMacros(sha256, 0, userId2, 0, 0, 1, 0, "id=" + i4, "en").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final c cVar = new c();
        Consumer<? super List<MacroTemplate>> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.comments.presenter.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TemplateCommentsPresenter.o(Function1.this, obj);
            }
        };
        final d dVar = new d();
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.comments.presenter.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TemplateCommentsPresenter.p(Function1.this, obj);
            }
        }));
    }

    public final void onBlockUser(@NotNull Comment comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        kotlinx.coroutines.e.e(this, null, null, new e(comment, null), 3, null);
    }

    public final void onCommentEditClicked(@NotNull Comment comment) {
        TemplateCommentsViewContract view;
        Intrinsics.checkNotNullParameter(comment, "comment");
        if (comment.getUserId() == this.f13784d.getUser().getUserId() && (view = getView()) != null) {
            view.showCommentOptions(comment);
        }
    }

    public final void onDeletePressed(@NotNull Comment comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        TemplateCommentsViewContract view = getView();
        if (view != null) {
            view.confirmDelete(comment);
        }
    }

    public final void onEditPressed(@NotNull Comment comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        TemplateCommentsViewContract view = getView();
        if (view != null) {
            view.editComment(comment);
        }
    }

    public final void onUnblockUser(@NotNull Comment comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        kotlinx.coroutines.e.e(this, null, null, new f(comment, null), 3, null);
    }

    public final void onUpgradePressed() {
        this.f13782b.loadUpgradeScreen();
    }

    public final void onUserClicked(@NotNull Comment comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        ScreenLoader.loadUserDetailsScreen$default(this.f13782b, comment.getUsername(), comment.getUserImage(), comment.getUserId(), null, 8, null);
    }

    public void setCoroutineContext(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<set-?>");
        this.f13788h = coroutineContext;
    }

    public final void setTemplate(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        this.f13789i = macroTemplate;
    }

    public final void updateComment(@NotNull Comment comment, @NotNull String newCommentText) {
        boolean z3;
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(newCommentText, "newCommentText");
        if (Intrinsics.areEqual(comment.getText(), newCommentText)) {
            TemplateCommentsViewContract view = getView();
            if (view != null) {
                view.clearUpdateDialog();
                return;
            }
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
        CompositeDisposable compositeDisposable = this.f13790j;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        Completable observeOn = Completable.mergeArray(Completable.timer(2L, TimeUnit.SECONDS), this.f13783c.updateComment(sha256, this.f13784d.getUser().getUserId(), comment.getId(), newCommentText)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Action action = new Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.comments.presenter.e
            @Override // io.reactivex.functions.Action
            public final void run() {
                TemplateCommentsPresenter.q(TemplateCommentsPresenter.this);
            }
        };
        final g gVar = new g();
        compositeDisposable.add(observeOn.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.comments.presenter.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TemplateCommentsPresenter.r(Function1.this, obj);
            }
        }));
        TemplateCommentsViewContract view2 = getView();
        if (view2 != null) {
            view2.setUpdatingComment(true);
        }
        TemplateCommentsViewContract view3 = getView();
        if (view3 != null) {
            view3.setDialogCommentEnabledState(false);
        }
    }
}
