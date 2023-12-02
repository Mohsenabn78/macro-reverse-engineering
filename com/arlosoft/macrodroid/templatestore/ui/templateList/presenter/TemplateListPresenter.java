package com.arlosoft.macrodroid.templatestore.ui.templateList.presenter;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.actionblock.ActionBlockHelper;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.app.mvp.Presenter;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.categories.CategoriesHelper;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.data.OrderByOption;
import com.arlosoft.macrodroid.database.room.BlockedMacro;
import com.arlosoft.macrodroid.database.room.BlockedMacroDao;
import com.arlosoft.macrodroid.database.room.BlockedUser;
import com.arlosoft.macrodroid.database.room.BlockedUserDao;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.database.room.MacroSubscription;
import com.arlosoft.macrodroid.database.room.MacroSubscriptionDao;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.AppPreferences;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApiKt;
import com.arlosoft.macrodroid.templatestore.events.TemplateDeletedEvent;
import com.arlosoft.macrodroid.templatestore.events.UserBlockedEvent;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.SearchTermListener;
import com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider;
import com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter;
import com.arlosoft.macrodroid.templatestore.ui.templateList.LocalTemplateOverrideStore;
import com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateCategoryManager;
import com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract;
import com.arlosoft.macrodroid.templatestore.ui.templateList.data.TemplateViewModel;
import com.arlosoft.macrodroid.templatestore.ui.upload.TemplateRefreshNotifier;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.u;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateListPresenter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TemplateListPresenter extends Presenter<TemplateStoreListViewContract> implements TemplateItemPresenter, TemplateCategoryManager.CategoryUpdatedListener, SearchTermListener, CoroutineScope {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Context f14069b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ScreenLoader f14070c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final TemplateStoreApi f14071d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final UserProvider f14072e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final LocalTemplateOverrideStore f14073f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final Gson f14074g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final TemplateCategoryManager f14075h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final TemplateRefreshNotifier f14076i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final AppPreferences f14077j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final CategoriesHelper f14078k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final ActionBlockStore f14079l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final PremiumStatusHandler f14080m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final MacroDroidRoomDatabase f14081n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private CompletableJob f14082o;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private CoroutineContext f14083p;

    /* renamed from: q  reason: collision with root package name */
    private CompositeDisposable f14084q;

    /* renamed from: r  reason: collision with root package name */
    private TemplateViewModel f14085r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private SearchTermProvider f14086s;

    /* renamed from: t  reason: collision with root package name */
    private int f14087t;

    /* renamed from: u  reason: collision with root package name */
    private int f14088u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f14089v;

    /* compiled from: TemplateListPresenter.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $macroId;
        final /* synthetic */ String $macroName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i4, String str, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$macroId = i4;
            this.$macroName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$macroId, this.$macroName, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                BlockedMacroDao blockedMacroDao = TemplateListPresenter.this.f14081n.blockedMacroDao();
                BlockedMacro blockedMacro = new BlockedMacro(this.$macroId, this.$macroName);
                this.label = 1;
                if (blockedMacroDao.addBlockedMacro(blockedMacro, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            TemplateListPresenter.this.loadCategory(false);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: TemplateListPresenter.kt */
    /* loaded from: classes3.dex */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $userId;
        final /* synthetic */ String $username;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i4, String str, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$userId = i4;
            this.$username = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$userId, this.$username, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                BlockedUserDao blockedUserDao = TemplateListPresenter.this.f14081n.blockedUserDao();
                BlockedUser blockedUser = new BlockedUser(this.$userId, this.$username);
                this.label = 1;
                if (blockedUserDao.addBlockedUser(blockedUser, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            TemplateListPresenter.this.loadCategory(false);
            EventBusUtils.getEventBus().post(new UserBlockedEvent(this.$userId));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: TemplateListPresenter.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<Throwable, Unit> {
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
            TemplateStoreListViewContract view = TemplateListPresenter.this.getView();
            if (view != null) {
                view.showDeleteFailed();
            }
        }
    }

    /* compiled from: TemplateListPresenter.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function1<Boolean, Unit> {
        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            TemplateStoreListViewContract view = TemplateListPresenter.this.getView();
            if (view != null) {
                view.setSwipeRefreshVisible(false);
            }
            TemplateListPresenter.loadCategory$default(TemplateListPresenter.this, false, 1, null);
        }
    }

    /* compiled from: TemplateListPresenter.kt */
    /* loaded from: classes3.dex */
    static final class e extends Lambda implements Function1<Throwable, Unit> {
        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            TemplateStoreListViewContract view = TemplateListPresenter.this.getView();
            if (view != null) {
                view.showReportFailed();
            }
        }
    }

    /* compiled from: TemplateListPresenter.kt */
    /* loaded from: classes3.dex */
    static final class f extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ MacroTemplate $macroTemplate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(MacroTemplate macroTemplate) {
            super(1);
            this.$macroTemplate = macroTemplate;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            TemplateListPresenter.this.f14073f.addLocalOverride(this.$macroTemplate.getId(), this.$macroTemplate);
            TemplateStoreListViewContract view = TemplateListPresenter.this.getView();
            if (view != null) {
                view.refresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateListPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $macroName;
        final /* synthetic */ MacroTemplate $macroTemplate;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TemplateListPresenter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $macroName;
            int label;
            final /* synthetic */ TemplateListPresenter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(TemplateListPresenter templateListPresenter, String str, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = templateListPresenter;
                this.$macroName = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, this.$macroName, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    TemplateStoreListViewContract view = this.this$0.getView();
                    if (view != null) {
                        view.refresh();
                    }
                    Context context = this.this$0.f14069b;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = this.this$0.f14069b.getString(R.string.template_store_subscribed_to);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…late_store_subscribed_to)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{this.$macroName}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    ToastCompat.makeText(context, (CharSequence) format, 0).show();
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
        g(MacroTemplate macroTemplate, String str, Continuation<? super g> continuation) {
            super(2, continuation);
            this.$macroTemplate = macroTemplate;
            this.$macroName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new g(this.$macroTemplate, this.$macroName, continuation);
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
                MacroSubscriptionDao macroSubscriptionDao = TemplateListPresenter.this.f14081n.macroSubscriptionDao();
                MacroSubscription macroSubscription = new MacroSubscription(this.$macroTemplate.getId(), this.$macroName);
                this.label = 1;
                if (macroSubscriptionDao.addMacroSubscription(macroSubscription, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            MainCoroutineDispatcher main = Dispatchers.getMain();
            a aVar = new a(TemplateListPresenter.this, this.$macroName, null);
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
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateListPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $macroName;
        final /* synthetic */ MacroTemplate $macroTemplate;
        final /* synthetic */ Task<Void> $task;
        int label;
        final /* synthetic */ TemplateListPresenter this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TemplateListPresenter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $msg;
            int label;
            final /* synthetic */ TemplateListPresenter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(TemplateListPresenter templateListPresenter, String str, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = templateListPresenter;
                this.$msg = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, this.$msg, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ToastCompat.makeText(this.this$0.f14069b, (CharSequence) this.$msg, 0).show();
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
        h(Task<Void> task, TemplateListPresenter templateListPresenter, MacroTemplate macroTemplate, String str, Continuation<? super h> continuation) {
            super(2, continuation);
            this.$task = task;
            this.this$0 = templateListPresenter;
            this.$macroTemplate = macroTemplate;
            this.$macroName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new h(this.$task, this.this$0, this.$macroTemplate, this.$macroName, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x009f A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1f
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                kotlin.ResultKt.throwOnFailure(r7)
                goto La0
            L13:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1b:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L43
            L1f:
                kotlin.ResultKt.throwOnFailure(r7)
                com.google.android.gms.tasks.Task<java.lang.Void> r7 = r6.$task
                boolean r7 = r7.isSuccessful()
                if (r7 == 0) goto L6c
                com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r7 = r6.this$0
                com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase r7 = com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter.access$getRoomDatabase$p(r7)
                com.arlosoft.macrodroid.database.room.MacroSubscriptionDao r7 = r7.macroSubscriptionDao()
                com.arlosoft.macrodroid.templatestore.model.MacroTemplate r1 = r6.$macroTemplate
                int r1 = r1.getId()
                r6.label = r3
                java.lang.Object r7 = r7.deleteMacroSubscription(r1, r6)
                if (r7 != r0) goto L43
                return r0
            L43:
                kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
                com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r7 = r6.this$0
                android.content.Context r7 = com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter.access$getContext$p(r7)
                r1 = 2131955353(0x7f130e99, float:1.9547231E38)
                java.lang.String r7 = r7.getString(r1)
                java.lang.String r1 = "context.getString(R.stri…_store_unsubscribed_from)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
                java.lang.Object[] r1 = new java.lang.Object[r3]
                r4 = 0
                java.lang.String r5 = r6.$macroName
                r1[r4] = r5
                java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r3)
                java.lang.String r7 = java.lang.String.format(r7, r1)
                java.lang.String r1 = "format(format, *args)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
                goto L7e
            L6c:
                com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r7 = r6.this$0
                android.content.Context r7 = com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter.access$getContext$p(r7)
                r1 = 2131955352(0x7f130e98, float:1.954723E38)
                java.lang.String r7 = r7.getString(r1)
                java.lang.String r1 = "{\n                      …                        }"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            L7e:
                com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r1 = r6.this$0
                java.lang.Object r1 = r1.getView()
                com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract r1 = (com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateStoreListViewContract) r1
                if (r1 == 0) goto L8b
                r1.refresh()
            L8b:
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
                com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter$h$a r3 = new com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter$h$a
                com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter r4 = r6.this$0
                r5 = 0
                r3.<init>(r4, r7, r5)
                r6.label = r2
                java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r1, r3, r6)
                if (r7 != r0) goto La0
                return r0
            La0:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.TemplateListPresenter.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: TemplateListPresenter.kt */
    /* loaded from: classes3.dex */
    static final class i extends Lambda implements Function1<Throwable, Unit> {
        i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            TemplateStoreListViewContract view = TemplateListPresenter.this.getView();
            if (view != null) {
                view.setUpdatingText(false);
            }
            TemplateStoreListViewContract view2 = TemplateListPresenter.this.getView();
            if (view2 != null) {
                view2.showUpdateFailed();
            }
        }
    }

    /* compiled from: TemplateListPresenter.kt */
    /* loaded from: classes3.dex */
    static final class j extends Lambda implements Function1<Throwable, Unit> {
        j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            TemplateStoreListViewContract view = TemplateListPresenter.this.getView();
            if (view != null) {
                view.showUpdateFailed();
            }
        }
    }

    @Inject
    public TemplateListPresenter(@ApplicationContext @NotNull Context context, @NotNull ScreenLoader screenLoader, @NotNull TemplateStoreApi api, @NotNull UserProvider userProvider, @NotNull LocalTemplateOverrideStore localTemplateOverrideStore, @NotNull Gson gson, @NotNull TemplateCategoryManager categoryManager, @NotNull TemplateRefreshNotifier templateRefreshNotifier, @NotNull AppPreferences appPreferences, @NotNull CategoriesHelper categoriesHelper, @NotNull ActionBlockStore actionBlockStore, @NotNull PremiumStatusHandler premiumStatusHandler, @NotNull MacroDroidRoomDatabase roomDatabase) {
        CompletableJob c4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(screenLoader, "screenLoader");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(userProvider, "userProvider");
        Intrinsics.checkNotNullParameter(localTemplateOverrideStore, "localTemplateOverrideStore");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(categoryManager, "categoryManager");
        Intrinsics.checkNotNullParameter(templateRefreshNotifier, "templateRefreshNotifier");
        Intrinsics.checkNotNullParameter(appPreferences, "appPreferences");
        Intrinsics.checkNotNullParameter(categoriesHelper, "categoriesHelper");
        Intrinsics.checkNotNullParameter(actionBlockStore, "actionBlockStore");
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "premiumStatusHandler");
        Intrinsics.checkNotNullParameter(roomDatabase, "roomDatabase");
        this.f14069b = context;
        this.f14070c = screenLoader;
        this.f14071d = api;
        this.f14072e = userProvider;
        this.f14073f = localTemplateOverrideStore;
        this.f14074g = gson;
        this.f14075h = categoryManager;
        this.f14076i = templateRefreshNotifier;
        this.f14077j = appPreferences;
        this.f14078k = categoriesHelper;
        this.f14079l = actionBlockStore;
        this.f14080m = premiumStatusHandler;
        this.f14081n = roomDatabase;
        c4 = u.c(null, 1, null);
        this.f14082o = c4;
        this.f14083p = c4.plus(Dispatchers.getIO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(TemplateListPresenter this$0, MacroTemplate macroTemplate, String macroName, Task task) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(macroTemplate, "$macroTemplate");
        Intrinsics.checkNotNullParameter(macroName, "$macroName");
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            kotlinx.coroutines.e.e(this$0, null, null, new g(macroTemplate, macroName, null), 3, null);
            return;
        }
        TemplateStoreListViewContract view = this$0.getView();
        if (view != null) {
            view.refresh();
        }
        ToastCompat.makeText(this$0.f14069b, (int) R.string.template_store_subscription_failed, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(TemplateListPresenter this$0, Exception exception) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(exception, "exception");
        ToastCompat.makeText(this$0.f14069b, (int) R.string.template_store_subscription_failed, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(TemplateListPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ToastCompat.makeText(this$0.f14069b, (int) R.string.template_store_subscription_failed, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(TemplateListPresenter this$0, MacroTemplate macroTemplate, String macroName, Task task) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(macroTemplate, "$macroTemplate");
        Intrinsics.checkNotNullParameter(macroName, "$macroName");
        Intrinsics.checkNotNullParameter(task, "task");
        kotlinx.coroutines.e.e(this$0, null, null, new h(task, this$0, macroTemplate, macroName, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(TemplateListPresenter this$0, Exception exception) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(exception, "exception");
        ToastCompat.makeText(this$0.f14069b, (int) R.string.template_store_unsubscribe_failed, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(TemplateListPresenter this$0, MacroTemplate macroTemplate, String descriptionText) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(macroTemplate, "$macroTemplate");
        Intrinsics.checkNotNullParameter(descriptionText, "$descriptionText");
        this$0.f14073f.addLocalOverride(macroTemplate.getId(), macroTemplate.updateDescription(descriptionText));
        TemplateStoreListViewContract view = this$0.getView();
        if (view != null) {
            view.refresh();
        }
        TemplateStoreListViewContract view2 = this$0.getView();
        if (view2 != null) {
            view2.clearEditTextDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(TemplateListPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TemplateStoreListViewContract view = this$0.getView();
        if (view != null) {
            view.setUpdatingText(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(TemplateListPresenter this$0, MacroTemplate macroTemplate, String name) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(macroTemplate, "$macroTemplate");
        Intrinsics.checkNotNullParameter(name, "$name");
        this$0.f14073f.addLocalOverride(macroTemplate.getId(), macroTemplate.updateName(name));
        TemplateStoreListViewContract view = this$0.getView();
        if (view != null) {
            view.refresh();
        }
        TemplateStoreListViewContract view2 = this$0.getView();
        if (view2 != null) {
            view2.clearEditTextDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean M(String str, int i4, int i5) {
        int length = str.length();
        if (i4 > length || length > i5) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void loadCategory$default(TemplateListPresenter templateListPresenter, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        templateListPresenter.loadCategory(z3);
    }

    public static /* synthetic */ void takeView$default(TemplateListPresenter templateListPresenter, TemplateStoreListViewContract templateStoreListViewContract, SearchTermProvider searchTermProvider, int i4, int i5, boolean z3, int i6, Object obj) {
        int i7;
        int i8;
        boolean z4;
        if ((i6 & 4) != 0) {
            i7 = 0;
        } else {
            i7 = i4;
        }
        if ((i6 & 8) != 0) {
            i8 = 0;
        } else {
            i8 = i5;
        }
        if ((i6 & 16) != 0) {
            z4 = false;
        } else {
            z4 = z3;
        }
        templateListPresenter.takeView(templateStoreListViewContract, searchTermProvider, i7, i8, z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(TemplateListPresenter this$0, MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(macroTemplate, "$macroTemplate");
        this$0.f14073f.addLocalOverride(macroTemplate.getId(), macroTemplate.setDeleted());
        TemplateStoreListViewContract view = this$0.getView();
        if (view != null) {
            view.refresh();
        }
        TemplateStoreListViewContract view2 = this$0.getView();
        if (view2 != null) {
            view2.showDeleteSuccess();
        }
        EventBusUtils.getEventBus().post(new TemplateDeletedEvent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(TemplateListPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TemplateStoreListViewContract view = this$0.getView();
        if (view != null) {
            view.showReportUploading(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(TemplateListPresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TemplateStoreListViewContract view = this$0.getView();
        if (view != null) {
            view.showReported();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.arlosoft.macrodroid.app.mvp.Presenter
    protected void a() {
        CompositeDisposable compositeDisposable = this.f14084q;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        compositeDisposable.clear();
        this.f14075h.removeCategoryUpdatedListener(this);
        SearchTermProvider searchTermProvider = this.f14086s;
        if (searchTermProvider != null) {
            searchTermProvider.removeSearchTermListener(this);
        }
        this.f14086s = null;
        Job.DefaultImpls.cancel$default((Job) this.f14082o, (CancellationException) null, 1, (Object) null);
        EventBusUtils.getEventBus().unregister(this);
    }

    @Override // com.arlosoft.macrodroid.app.mvp.Presenter
    protected void b() {
        CompletableJob c4;
        CompositeDisposable compositeDisposable = null;
        if (this.f14082o.isCancelled()) {
            c4 = u.c(null, 1, null);
            this.f14082o = c4;
            setCoroutineContext(c4.plus(Dispatchers.getIO()));
        }
        this.f14084q = new CompositeDisposable();
        this.f14075h.addCategoryUpdatedListener(this);
        SearchTermProvider searchTermProvider = this.f14086s;
        if (searchTermProvider != null) {
            searchTermProvider.addSearchTermListener(this);
        }
        CompositeDisposable compositeDisposable2 = this.f14084q;
        if (compositeDisposable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
        } else {
            compositeDisposable = compositeDisposable2;
        }
        Flowable<Boolean> requiresRefreshFlowable = this.f14076i.requiresRefreshFlowable();
        final d dVar = new d();
        compositeDisposable.add(requiresRefreshFlowable.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TemplateListPresenter.w(Function1.this, obj);
            }
        }));
        EventBusUtils.getEventBus().register(this);
    }

    public final void blockMacro(int i4, @NotNull String macroName) {
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        kotlinx.coroutines.e.e(this, null, null, new a(i4, macroName, null), 3, null);
    }

    public final void blockUser(int i4, @NotNull String username) {
        Intrinsics.checkNotNullParameter(username, "username");
        kotlinx.coroutines.e.e(this, null, null, new b(i4, username, null), 3, null);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateCategoryManager.CategoryUpdatedListener
    public void categoryUpdated(int i4) {
        loadCategory$default(this, false, 1, null);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter
    public void commentsClicked(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        TemplateStoreListViewContract view = getView();
        if (view != null) {
            view.loadCommentsScreen(macroTemplate);
        }
    }

    public final void deleteTemplate(@NotNull final MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        int userId = macroTemplate.getUserId();
        int id = macroTemplate.getId();
        String sha256 = StringExtensionsKt.sha256(userId + TemplateStoreApiKt.TEMPLATE_API_SALT + id);
        CompositeDisposable compositeDisposable = this.f14084q;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        Completable observeOn = this.f14071d.deleteMacro(sha256, macroTemplate.getId(), macroTemplate.getUserId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Action action = new Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.f
            @Override // io.reactivex.functions.Action
            public final void run() {
                TemplateListPresenter.u(TemplateListPresenter.this, macroTemplate);
            }
        };
        final c cVar = new c();
        compositeDisposable.add(observeOn.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TemplateListPresenter.v(Function1.this, obj);
            }
        }));
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter
    public void flagClicked(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        this.f14073f.addLocalOverride(macroTemplate.getId(), macroTemplate.setUseTranslated(!macroTemplate.getUseTranslatedText()));
        TemplateStoreListViewContract view = getView();
        if (view != null) {
            view.refresh();
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.f14083p;
    }

    public final void loadCategory(boolean z3) {
        int userId = this.f14072e.getUser().getUserId();
        String language = Settings.getLocale(this.f14069b).getLanguage();
        SearchTermProvider searchTermProvider = this.f14086s;
        kotlinx.coroutines.e.e(this, null, null, new TemplateListPresenter$loadCategory$1(this, userId, (searchTermProvider == null || (r12 = searchTermProvider.getSearchTerm()) == null) ? "" : "", language, null), 3, null);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter
    public void menuClicked(@NotNull MacroTemplate macroTemplate) {
        boolean z3;
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        User user = this.f14072e.getUser();
        TemplateStoreListViewContract view = getView();
        if (view != null) {
            if (user.getUserId() == macroTemplate.getUserId()) {
                z3 = true;
            } else {
                z3 = false;
            }
            view.showOptionsMenu(macroTemplate, z3, user.isModerator());
        }
    }

    public final void onDeletePressed(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        TemplateStoreListViewContract view = getView();
        if (view != null) {
            view.showConfirmDelete(macroTemplate);
        }
    }

    public final void onEditDescriptionPressed(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        TemplateStoreListViewContract view = getView();
        if (view != null) {
            view.showEditDescriptionDialog(macroTemplate);
        }
    }

    public final void onEditMacroPressed(@NotNull MacroTemplate macroTemplate) {
        String str;
        String str2;
        Macro macro;
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        Iterator<Macro> it = MacroStore.getInstance().getAllCompletedMacros().iterator();
        do {
            str = "";
            str2 = null;
            if (it.hasNext()) {
                macro = it.next();
            } else {
                ScreenLoader screenLoader = this.f14070c;
                int id = macroTemplate.getId();
                String name = macroTemplate.getName();
                String description = macroTemplate.getDescription();
                Macro macro2 = macroTemplate.getMacro();
                if (macro2 != null) {
                    str2 = macro2.getCategory();
                }
                if (str2 != null) {
                    str = str2;
                }
                screenLoader.loadTemplateUploadScreen(id, name, description, str);
                return;
            }
        } while (!Intrinsics.areEqual(macro.getName(), macroTemplate.getName()));
        ScreenLoader screenLoader2 = this.f14070c;
        int id2 = macroTemplate.getId();
        Intrinsics.checkNotNullExpressionValue(macro, "macro");
        String description2 = macroTemplate.getDescription();
        Macro macro3 = macroTemplate.getMacro();
        if (macro3 != null) {
            str2 = macro3.getCategory();
        }
        if (str2 != null) {
            str = str2;
        }
        screenLoader2.loadTemplateUploadScreen(id2, macro, description2, str);
    }

    public final void onEditTitlePressed(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        TemplateStoreListViewContract view = getView();
        if (view != null) {
            view.showEditNameDialog(macroTemplate);
        }
    }

    public final void onEventMainThread(@NotNull UserBlockedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        loadCategory$default(this, false, 1, null);
    }

    public final void onReportMacro(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        if (this.f14072e.getUser().isGuest()) {
            TemplateStoreListViewContract view = getView();
            if (view != null) {
                view.showRequiresSignIn();
                return;
            }
            return;
        }
        TemplateStoreListViewContract view2 = getView();
        if (view2 != null) {
            view2.showReportMacroDialog(macroTemplate);
        }
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.SearchTermListener
    public void onSearchTermUpdated(@NotNull String searchTerm) {
        Intrinsics.checkNotNullParameter(searchTerm, "searchTerm");
        loadCategory$default(this, false, 1, null);
    }

    public final void onSwipeToRefresh() {
        loadCategory(true);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter
    public void reportClicked(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        this.f14070c.loadReportMacroScreen(macroTemplate);
    }

    public final void reportTemplate(@NotNull MacroTemplate macroTemplate, int i4, @NotNull String reasonText) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        Intrinsics.checkNotNullParameter(reasonText, "reasonText");
        TemplateStoreListViewContract view = getView();
        if (view != null) {
            view.showReportUploading(true);
        }
        CompositeDisposable compositeDisposable = this.f14084q;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        Completable doFinally = Completable.mergeArray(Completable.timer(1500L, TimeUnit.MILLISECONDS), this.f14071d.reportMacro(macroTemplate.getId(), this.f14072e.getUser().getUserId(), i4, reasonText)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.a
            @Override // io.reactivex.functions.Action
            public final void run() {
                TemplateListPresenter.x(TemplateListPresenter.this);
            }
        });
        Action action = new Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.j
            @Override // io.reactivex.functions.Action
            public final void run() {
                TemplateListPresenter.y(TemplateListPresenter.this);
            }
        };
        final e eVar = new e();
        compositeDisposable.add(doFinally.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TemplateListPresenter.z(Function1.this, obj);
            }
        }));
    }

    public void setCoroutineContext(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "<set-?>");
        this.f14083p = coroutineContext;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter
    public void starClicked(@NotNull MacroTemplate macroTemplate) {
        boolean starred;
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        int userId = this.f14072e.getUser().getUserId();
        if (userId == macroTemplate.getUserId()) {
            TemplateStoreListViewContract view = getView();
            if (view != null) {
                view.showOwnMacroStarMessage();
            }
            TemplateStoreListViewContract view2 = getView();
            if (view2 != null) {
                view2.refresh();
            }
        } else if (userId == 0) {
            TemplateStoreListViewContract view3 = getView();
            if (view3 != null) {
                view3.showRequiresSignIn();
            }
            TemplateStoreListViewContract view4 = getView();
            if (view4 != null) {
                view4.refresh();
            }
        } else {
            MacroTemplate localOverride = this.f14073f.getLocalOverride(macroTemplate.getId());
            if (localOverride != null) {
                starred = localOverride.getStarred();
            } else {
                starred = macroTemplate.getStarred();
            }
            boolean z3 = !starred;
            this.f14073f.addLocalOverride(macroTemplate.getId(), macroTemplate.updateStarRating(z3));
            String sha256 = StringExtensionsKt.sha256(macroTemplate.getId() + TemplateStoreApiKt.TEMPLATE_API_SALT + userId);
            CompositeDisposable compositeDisposable = this.f14084q;
            if (compositeDisposable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
                compositeDisposable = null;
            }
            Completable observeOn = this.f14071d.starMacro(sha256, macroTemplate.getId(), userId, z3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            Action action = new Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.h
                @Override // io.reactivex.functions.Action
                public final void run() {
                    TemplateListPresenter.A();
                }
            };
            final f fVar = new f(macroTemplate);
            compositeDisposable.add(observeOn.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.i
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    TemplateListPresenter.B(Function1.this, obj);
                }
            }));
        }
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter
    public void subscribeMacroClicked(@NotNull final MacroTemplate macroTemplate, boolean z3) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        if (!this.f14080m.getPremiumStatus().isPro()) {
            TemplateStoreListViewContract view = getView();
            if (view != null) {
                view.showSubscriptionProOnly();
            }
            TemplateStoreListViewContract view2 = getView();
            if (view2 != null) {
                view2.refresh();
            }
        } else if (this.f14072e.getUser().isGuest()) {
            TemplateStoreListViewContract view3 = getView();
            if (view3 != null) {
                view3.showSubscriptionSignedInOnly();
            }
            TemplateStoreListViewContract view4 = getView();
            if (view4 != null) {
                view4.refresh();
            }
        } else {
            final String nameTranslated = macroTemplate.getNameTranslated();
            if (nameTranslated == null) {
                nameTranslated = macroTemplate.getName();
            }
            if (z3) {
                FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
                int id = macroTemplate.getId();
                firebaseMessaging.subscribeToTopic("macro-" + id).addOnCompleteListener(new OnCompleteListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.l
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        TemplateListPresenter.C(TemplateListPresenter.this, macroTemplate, nameTranslated, task);
                    }
                }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.m
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        TemplateListPresenter.D(TemplateListPresenter.this, exc);
                    }
                }).addOnCanceledListener(new OnCanceledListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.n
                    @Override // com.google.android.gms.tasks.OnCanceledListener
                    public final void onCanceled() {
                        TemplateListPresenter.E(TemplateListPresenter.this);
                    }
                });
                return;
            }
            FirebaseMessaging firebaseMessaging2 = FirebaseMessaging.getInstance();
            int id2 = macroTemplate.getId();
            firebaseMessaging2.unsubscribeFromTopic("macro-" + id2).addOnCompleteListener(new OnCompleteListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.o
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    TemplateListPresenter.F(TemplateListPresenter.this, macroTemplate, nameTranslated, task);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.p
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    TemplateListPresenter.G(TemplateListPresenter.this, exc);
                }
            });
        }
    }

    public final void takeView(@NotNull TemplateStoreListViewContract view, @Nullable SearchTermProvider searchTermProvider, int i4, @OrderByOption int i5, boolean z3) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f14087t = i4;
        this.f14088u = i5;
        this.f14086s = searchTermProvider;
        this.f14089v = z3;
        super.takeView(view);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter
    public void templateClicked(@NotNull MacroTemplate macroTemplate) {
        boolean z3;
        String description;
        String name;
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        MacroTemplate localOverride = this.f14073f.getLocalOverride(macroTemplate.getId());
        if (localOverride == null) {
            localOverride = macroTemplate;
        }
        if (Settings.getTemplateStoreAutoTranslateLanguage(this.f14069b) != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Macro macro = localOverride.getMacro();
        if (macro != null) {
            if (!z3 && macroTemplate.getUseTranslatedText()) {
                name = macroTemplate.getNameTranslated();
                if (name == null) {
                    name = macroTemplate.getName();
                }
            } else {
                name = macroTemplate.getName();
            }
            macro.setName(name);
        }
        Macro macro2 = localOverride.getMacro();
        if (macro2 != null) {
            if (!z3 && macroTemplate.getUseTranslatedText()) {
                description = macroTemplate.getDescriptionTranslated();
                if (description == null) {
                    description = macroTemplate.getDescription();
                }
            } else {
                description = macroTemplate.getDescription();
            }
            macro2.setDescription(description);
        }
        Macro macro3 = localOverride.getMacro();
        Intrinsics.checkNotNull(macro3);
        Macro clonedMacro = macro3.cloneMacro(false, true);
        ActionBlockStore actionBlockStore = this.f14079l;
        Intrinsics.checkNotNullExpressionValue(clonedMacro, "clonedMacro");
        List<ActionBlock> actionBlocksToImport = clonedMacro.getActionBlocksToImport();
        Intrinsics.checkNotNullExpressionValue(actionBlocksToImport, "clonedMacro.actionBlocksToImport");
        ActionBlockHelper.addActionBlocks(actionBlockStore, clonedMacro, actionBlocksToImport, false);
        this.f14070c.loadEditMacroScreenFromTemplate(clonedMacro, true);
    }

    public final void updateMacroDescription(@NotNull final MacroTemplate macroTemplate, @NotNull final String descriptionText) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
        if (!M(descriptionText, 20, 2000)) {
            TemplateStoreListViewContract view = getView();
            if (view != null) {
                view.showInvalidText(false);
                return;
            }
            return;
        }
        TemplateStoreListViewContract view2 = getView();
        if (view2 != null) {
            view2.setUpdatingText(true);
        }
        int id = macroTemplate.getId();
        String sha256 = StringExtensionsKt.sha256(descriptionText + TemplateStoreApiKt.TEMPLATE_API_SALT + id);
        CompositeDisposable compositeDisposable = this.f14084q;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        Completable observeOn = Completable.mergeArray(Completable.timer(1500L, TimeUnit.MILLISECONDS), this.f14071d.updateMacroDescription(sha256, macroTemplate.getId(), descriptionText)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Action action = new Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.d
            @Override // io.reactivex.functions.Action
            public final void run() {
                TemplateListPresenter.H(TemplateListPresenter.this, macroTemplate, descriptionText);
            }
        };
        final i iVar = new i();
        compositeDisposable.add(observeOn.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TemplateListPresenter.I(Function1.this, obj);
            }
        }));
    }

    public final void updateMacroName(@NotNull final MacroTemplate macroTemplate, @NotNull final String name) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!M(name, 5, 100)) {
            TemplateStoreListViewContract view = getView();
            if (view != null) {
                view.showInvalidText(true);
                return;
            }
            return;
        }
        TemplateStoreListViewContract view2 = getView();
        if (view2 != null) {
            view2.setUpdatingText(true);
        }
        int id = macroTemplate.getId();
        String sha256 = StringExtensionsKt.sha256(name + TemplateStoreApiKt.TEMPLATE_API_SALT + id);
        CompositeDisposable compositeDisposable = this.f14084q;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        Completable doFinally = Completable.mergeArray(Completable.timer(1500L, TimeUnit.MILLISECONDS), this.f14071d.updateMacroName(sha256, macroTemplate.getId(), name)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.r
            @Override // io.reactivex.functions.Action
            public final void run() {
                TemplateListPresenter.J(TemplateListPresenter.this);
            }
        });
        Action action = new Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.b
            @Override // io.reactivex.functions.Action
            public final void run() {
                TemplateListPresenter.K(TemplateListPresenter.this, macroTemplate, name);
            }
        };
        final j jVar = new j();
        compositeDisposable.add(doFinally.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.presenter.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TemplateListPresenter.L(Function1.this, obj);
            }
        }));
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter
    public void usernameClicked(@NotNull MacroTemplate macroTemplate, @NotNull AvatarView avatarImage) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        Intrinsics.checkNotNullParameter(avatarImage, "avatarImage");
        if (this.f14089v) {
            this.f14070c.loadUserDetailsScreen(macroTemplate.getUsername(), macroTemplate.getUserImage(), macroTemplate.getUserId(), avatarImage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A() {
    }
}
