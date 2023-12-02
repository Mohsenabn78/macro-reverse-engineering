package com.arlosoft.macrodroid.cloudmessaging;

import android.text.TextUtils;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.database.room.MacroSubscription;
import com.arlosoft.macrodroid.database.room.MacroSubscriptionDao;
import com.arlosoft.macrodroid.database.room.SubcriptionUpdateType;
import com.arlosoft.macrodroid.database.room.SubscriptionUpdateItem;
import com.arlosoft.macrodroid.database.room.SubscriptionUpdateItemDao;
import com.arlosoft.macrodroid.database.room.UserSubscriptionDao;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Defaults;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.events.TemplateUpdateEvent;
import com.arlosoft.macrodroid.templatestore.events.UserUpdateEvent;
import com.arlosoft.macrodroid.templatestore.notifications.TemplateStoreNotificationHandler;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.WebHookTrigger;
import com.arlosoft.macrodroid.triggers.webtrigger.WebTriggerInteractor;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

/* compiled from: MacroDroidFirebaseMessagingService.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nMacroDroidFirebaseMessagingService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MacroDroidFirebaseMessagingService.kt\ncom/arlosoft/macrodroid/cloudmessaging/MacroDroidFirebaseMessagingService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,269:1\n1#2:270\n*E\n"})
/* loaded from: classes3.dex */
public final class MacroDroidFirebaseMessagingService extends FirebaseMessagingService implements CoroutineScope {
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final CompletableJob f9790g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final CoroutineContext f9791h;
    @Inject
    public MacroDroidRoomDatabase roomDatabase;
    @Inject
    public TemplateStoreNotificationHandler templateStoreNotificationHandler;
    @Inject
    public UserProvider userProvider;
    @Inject
    public WebTriggerInteractor webTriggerInteractor;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: MacroDroidFirebaseMessagingService.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MacroDroidFirebaseMessagingService.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $macroId;
        final /* synthetic */ int $userId;
        final /* synthetic */ String $userImage;
        final /* synthetic */ String $username;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i4, int i5, String str, String str2, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$userId = i4;
            this.$macroId = i5;
            this.$username = str;
            this.$userImage = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$userId, this.$macroId, this.$username, this.$userImage, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Object subscriptionByMacroId;
            MacroSubscription macroSubscription;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        macroSubscription = (MacroSubscription) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        MacroDroidFirebaseMessagingService.this.getTemplateStoreNotificationHandler().displayMacroDeletedNotification(macroSubscription.getMacroName());
                        EventBusUtils.getEventBus().post(new TemplateUpdateEvent());
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                subscriptionByMacroId = obj;
            } else {
                ResultKt.throwOnFailure(obj);
                if (MacroDroidFirebaseMessagingService.this.getUserProvider().getUser().getUserId() != this.$userId) {
                    MacroSubscriptionDao macroSubscriptionDao = MacroDroidFirebaseMessagingService.this.getRoomDatabase().macroSubscriptionDao();
                    int i5 = this.$macroId;
                    this.label = 1;
                    subscriptionByMacroId = macroSubscriptionDao.getSubscriptionByMacroId(i5, this);
                    if (subscriptionByMacroId == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            MacroSubscription macroSubscription2 = (MacroSubscription) subscriptionByMacroId;
            if (macroSubscription2 != null) {
                SubscriptionUpdateItem subscriptionUpdateItem = new SubscriptionUpdateItem(0L, SubcriptionUpdateType.TYPE_MACRO_DELETED, this.$macroId, macroSubscription2.getMacroName(), this.$username, this.$userId, this.$userImage, "", System.currentTimeMillis());
                SubscriptionUpdateItemDao subscriptionUpdateItemDao = MacroDroidFirebaseMessagingService.this.getRoomDatabase().subscriptionUpdateItemDao();
                this.L$0 = macroSubscription2;
                this.label = 2;
                if (subscriptionUpdateItemDao.addSubscriptionUpdateItem(subscriptionUpdateItem, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                macroSubscription = macroSubscription2;
                MacroDroidFirebaseMessagingService.this.getTemplateStoreNotificationHandler().displayMacroDeletedNotification(macroSubscription.getMacroName());
                EventBusUtils.getEventBus().post(new TemplateUpdateEvent());
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MacroDroidFirebaseMessagingService.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $comment;
        final /* synthetic */ int $macroId;
        final /* synthetic */ int $userId;
        final /* synthetic */ String $userImage;
        final /* synthetic */ String $username;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i4, int i5, String str, String str2, String str3, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$userId = i4;
            this.$macroId = i5;
            this.$username = str;
            this.$userImage = str2;
            this.$comment = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$userId, this.$macroId, this.$username, this.$userImage, this.$comment, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Object subscriptionByMacroId;
            Object addSubscriptionUpdateItem;
            MacroSubscription macroSubscription;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        macroSubscription = (MacroSubscription) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        addSubscriptionUpdateItem = obj;
                        MacroDroidFirebaseMessagingService.this.getTemplateStoreNotificationHandler().displayCommentNotification(macroSubscription.getMacroName(), this.$macroId, this.$comment, (int) ((Number) addSubscriptionUpdateItem).longValue());
                        EventBusUtils.getEventBus().post(new TemplateUpdateEvent());
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                subscriptionByMacroId = obj;
            } else {
                ResultKt.throwOnFailure(obj);
                if (MacroDroidFirebaseMessagingService.this.getUserProvider().getUser().getUserId() != this.$userId) {
                    MacroSubscriptionDao macroSubscriptionDao = MacroDroidFirebaseMessagingService.this.getRoomDatabase().macroSubscriptionDao();
                    int i5 = this.$macroId;
                    this.label = 1;
                    subscriptionByMacroId = macroSubscriptionDao.getSubscriptionByMacroId(i5, this);
                    if (subscriptionByMacroId == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            MacroSubscription macroSubscription2 = (MacroSubscription) subscriptionByMacroId;
            if (macroSubscription2 != null) {
                SubscriptionUpdateItem subscriptionUpdateItem = new SubscriptionUpdateItem(0L, SubcriptionUpdateType.TYPE_MACRO_NEW_COMMENT, this.$macroId, macroSubscription2.getMacroName(), this.$username, this.$userId, this.$userImage, this.$comment, System.currentTimeMillis());
                SubscriptionUpdateItemDao subscriptionUpdateItemDao = MacroDroidFirebaseMessagingService.this.getRoomDatabase().subscriptionUpdateItemDao();
                this.L$0 = macroSubscription2;
                this.label = 2;
                addSubscriptionUpdateItem = subscriptionUpdateItemDao.addSubscriptionUpdateItem(subscriptionUpdateItem, this);
                if (addSubscriptionUpdateItem == coroutine_suspended) {
                    return coroutine_suspended;
                }
                macroSubscription = macroSubscription2;
                MacroDroidFirebaseMessagingService.this.getTemplateStoreNotificationHandler().displayCommentNotification(macroSubscription.getMacroName(), this.$macroId, this.$comment, (int) ((Number) addSubscriptionUpdateItem).longValue());
                EventBusUtils.getEventBus().post(new TemplateUpdateEvent());
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MacroDroidFirebaseMessagingService.kt */
    /* loaded from: classes3.dex */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $macroId;
        final /* synthetic */ int $userId;
        final /* synthetic */ String $userImage;
        final /* synthetic */ String $username;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i4, int i5, String str, String str2, Continuation<? super c> continuation) {
            super(2, continuation);
            this.$userId = i4;
            this.$macroId = i5;
            this.$username = str;
            this.$userImage = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(this.$userId, this.$macroId, this.$username, this.$userImage, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Object subscriptionByMacroId;
            Object addSubscriptionUpdateItem;
            MacroSubscription macroSubscription;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        macroSubscription = (MacroSubscription) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        addSubscriptionUpdateItem = obj;
                        MacroDroidFirebaseMessagingService.this.getTemplateStoreNotificationHandler().displayMacroUpdatedNotification(macroSubscription.getMacroName(), this.$macroId, (int) ((Number) addSubscriptionUpdateItem).longValue());
                        EventBusUtils.getEventBus().post(new TemplateUpdateEvent());
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                subscriptionByMacroId = obj;
            } else {
                ResultKt.throwOnFailure(obj);
                if (MacroDroidFirebaseMessagingService.this.getUserProvider().getUser().getUserId() != this.$userId) {
                    MacroSubscriptionDao macroSubscriptionDao = MacroDroidFirebaseMessagingService.this.getRoomDatabase().macroSubscriptionDao();
                    int i5 = this.$macroId;
                    this.label = 1;
                    subscriptionByMacroId = macroSubscriptionDao.getSubscriptionByMacroId(i5, this);
                    if (subscriptionByMacroId == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            MacroSubscription macroSubscription2 = (MacroSubscription) subscriptionByMacroId;
            if (macroSubscription2 != null) {
                SubscriptionUpdateItem subscriptionUpdateItem = new SubscriptionUpdateItem(0L, SubcriptionUpdateType.TYPE_MACRO_UPDATED, this.$macroId, macroSubscription2.getMacroName(), this.$username, this.$userId, this.$userImage, "", System.currentTimeMillis());
                SubscriptionUpdateItemDao subscriptionUpdateItemDao = MacroDroidFirebaseMessagingService.this.getRoomDatabase().subscriptionUpdateItemDao();
                this.L$0 = macroSubscription2;
                this.label = 2;
                addSubscriptionUpdateItem = subscriptionUpdateItemDao.addSubscriptionUpdateItem(subscriptionUpdateItem, this);
                if (addSubscriptionUpdateItem == coroutine_suspended) {
                    return coroutine_suspended;
                }
                macroSubscription = macroSubscription2;
                MacroDroidFirebaseMessagingService.this.getTemplateStoreNotificationHandler().displayMacroUpdatedNotification(macroSubscription.getMacroName(), this.$macroId, (int) ((Number) addSubscriptionUpdateItem).longValue());
                EventBusUtils.getEventBus().post(new TemplateUpdateEvent());
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MacroDroidFirebaseMessagingService.kt */
    /* loaded from: classes3.dex */
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $macroId;
        final /* synthetic */ String $macroName;
        final /* synthetic */ int $userId;
        final /* synthetic */ String $userImage;
        final /* synthetic */ String $username;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i4, int i5, String str, String str2, String str3, Continuation<? super d> continuation) {
            super(2, continuation);
            this.$userId = i4;
            this.$macroId = i5;
            this.$macroName = str;
            this.$username = str2;
            this.$userImage = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new d(this.$userId, this.$macroId, this.$macroName, this.$username, this.$userImage, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Object subscriptionByUserId;
            Object addSubscriptionUpdateItem;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        ResultKt.throwOnFailure(obj);
                        addSubscriptionUpdateItem = obj;
                        MacroDroidFirebaseMessagingService.this.getTemplateStoreNotificationHandler().displayNewMacroNotification(this.$username, this.$macroName, this.$macroId, (int) ((Number) addSubscriptionUpdateItem).longValue());
                        EventBusUtils.getEventBus().post(new UserUpdateEvent());
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                subscriptionByUserId = obj;
            } else {
                ResultKt.throwOnFailure(obj);
                if (MacroDroidFirebaseMessagingService.this.getUserProvider().getUser().getUserId() != this.$userId) {
                    UserSubscriptionDao userSubscriptionDao = MacroDroidFirebaseMessagingService.this.getRoomDatabase().userSubscriptionDao();
                    int i5 = this.$userId;
                    this.label = 1;
                    subscriptionByUserId = userSubscriptionDao.getSubscriptionByUserId(i5, this);
                    if (subscriptionByUserId == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (subscriptionByUserId != null) {
                SubscriptionUpdateItem subscriptionUpdateItem = new SubscriptionUpdateItem(0L, SubcriptionUpdateType.TYPE_USER_NEW_MACRO, this.$macroId, this.$macroName, this.$username, this.$userId, this.$userImage, "", System.currentTimeMillis());
                SubscriptionUpdateItemDao subscriptionUpdateItemDao = MacroDroidFirebaseMessagingService.this.getRoomDatabase().subscriptionUpdateItemDao();
                this.label = 2;
                addSubscriptionUpdateItem = subscriptionUpdateItemDao.addSubscriptionUpdateItem(subscriptionUpdateItem, this);
                if (addSubscriptionUpdateItem == coroutine_suspended) {
                    return coroutine_suspended;
                }
                MacroDroidFirebaseMessagingService.this.getTemplateStoreNotificationHandler().displayNewMacroNotification(this.$username, this.$macroName, this.$macroId, (int) ((Number) addSubscriptionUpdateItem).longValue());
                EventBusUtils.getEventBus().post(new UserUpdateEvent());
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MacroDroidFirebaseMessagingService.kt */
    /* loaded from: classes3.dex */
    public static final class e extends Lambda implements Function1<Throwable, Unit> {

        /* renamed from: d  reason: collision with root package name */
        public static final e f9792d = new e();

        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            SystemLog.logError("Push token upload failed");
        }
    }

    public MacroDroidFirebaseMessagingService() {
        CompletableJob c4;
        c4 = u.c(null, 1, null);
        this.f9790g = c4;
        this.f9791h = c4.plus(Dispatchers.getIO());
    }

    private final void r(String str, int i4, int i5, String str2, String str3) {
        kotlinx.coroutines.e.e(this, null, null, new a(i5, i4, str2, str3, null), 3, null);
    }

    private final void s(String str, String str2, int i4, int i5, String str3, String str4) {
        kotlinx.coroutines.e.e(this, null, null, new b(i5, i4, str3, str4, str2, null), 3, null);
    }

    private final void t(String str, int i4, int i5, String str2, String str3) {
        kotlinx.coroutines.e.e(this, null, null, new c(i5, i4, str2, str3, null), 3, null);
    }

    private final void u(String str, String str2, int i4, int i5, String str3) {
        kotlinx.coroutines.e.e(this, null, null, new d(i5, i4, str2, str, str3, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(MacroDroidFirebaseMessagingService this$0, Task task) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isComplete()) {
            String str = (String) task.getResult();
            Timber.d("Refreshed token: $refreshedToken", new Object[0]);
            if (str != null) {
                this$0.w(str);
            }
        }
    }

    private final void w(final String str) {
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacros()) {
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof WebHookTrigger) {
                    WebTriggerInteractor webTriggerInteractor = getWebTriggerInteractor();
                    Intrinsics.checkNotNull(webTriggerInteractor);
                    String uniqueId = Settings.getUniqueId(this, false);
                    Intrinsics.checkNotNullExpressionValue(uniqueId, "getUniqueId(this, false)");
                    Completable uploadTriggerToken = webTriggerInteractor.uploadTriggerToken(uniqueId, "", str, Defaults.REGISTER_COMMERCIAL_DEVICE_COMPANY_ID);
                    Action action = new Action() { // from class: com.arlosoft.macrodroid.cloudmessaging.b
                        @Override // io.reactivex.functions.Action
                        public final void run() {
                            MacroDroidFirebaseMessagingService.x(MacroDroidFirebaseMessagingService.this, str);
                        }
                    };
                    final e eVar = e.f9792d;
                    uploadTriggerToken.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.cloudmessaging.c
                        @Override // io.reactivex.functions.Consumer
                        public final void accept(Object obj) {
                            MacroDroidFirebaseMessagingService.y(Function1.this, obj);
                        }
                    });
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(MacroDroidFirebaseMessagingService this$0, String token) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(token, "$token");
        Settings.setPushTokenUploadedId(this$0, token);
        SystemLog.logVerbose("Push token upload success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.f9791h;
    }

    @NotNull
    public final MacroDroidRoomDatabase getRoomDatabase() {
        MacroDroidRoomDatabase macroDroidRoomDatabase = this.roomDatabase;
        if (macroDroidRoomDatabase != null) {
            return macroDroidRoomDatabase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("roomDatabase");
        return null;
    }

    @NotNull
    public final TemplateStoreNotificationHandler getTemplateStoreNotificationHandler() {
        TemplateStoreNotificationHandler templateStoreNotificationHandler = this.templateStoreNotificationHandler;
        if (templateStoreNotificationHandler != null) {
            return templateStoreNotificationHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("templateStoreNotificationHandler");
        return null;
    }

    @NotNull
    public final UserProvider getUserProvider() {
        UserProvider userProvider = this.userProvider;
        if (userProvider != null) {
            return userProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userProvider");
        return null;
    }

    @NotNull
    public final WebTriggerInteractor getWebTriggerInteractor() {
        WebTriggerInteractor webTriggerInteractor = this.webTriggerInteractor;
        if (webTriggerInteractor != null) {
            return webTriggerInteractor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("webTriggerInteractor");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(@NotNull RemoteMessage remoteMessage) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        String from = remoteMessage.getFrom();
        StringBuilder sb = new StringBuilder();
        sb.append("From: ");
        sb.append(from);
        Map<String, String> data = remoteMessage.getData();
        Intrinsics.checkNotNullExpressionValue(data, "remoteMessage.data");
        if ((!data.isEmpty()) && data.containsKey(CloudMessages.VALUE_TYPE) && (str = data.get(CloudMessages.VALUE_TYPE)) != null) {
            switch (str.hashCode()) {
                case -1713859729:
                    if (str.equals(CloudMessages.TEMPLATE_STORE_MESSAGE_TYPE_MACRO_UPDATED)) {
                        String str4 = data.get(CloudMessages.TEMPLATE_STORE_DATA_MACRO_NAME);
                        String str5 = data.get(CloudMessages.TEMPLATE_STORE_DATA_MACRO_ID);
                        String str6 = data.get(CloudMessages.TEMPLATE_STORE_DATA_USER_ID);
                        String str7 = data.get(CloudMessages.TEMPLATE_STORE_DATA_USER_NAME);
                        String str8 = data.get(CloudMessages.TEMPLATE_STORE_DATA_USER_IMAGE);
                        if (str4 != null && str5 != null && str6 != null && str7 != null) {
                            Integer valueOf = Integer.valueOf(str5);
                            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(macroId)");
                            int intValue = valueOf.intValue();
                            Integer valueOf2 = Integer.valueOf(str6);
                            Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(userId)");
                            int intValue2 = valueOf2.intValue();
                            if (str8 == null) {
                                str2 = "";
                            } else {
                                str2 = str8;
                            }
                            t(str4, intValue, intValue2, str7, str2);
                            return;
                        }
                        return;
                    }
                    return;
                case -1478252181:
                    if (str.equals(CloudMessages.TEMPLATE_STORE_MESSAGE_TYPE_MACRO_NEW_COMMENT)) {
                        String str9 = data.get(CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT);
                        String str10 = data.get(CloudMessages.TEMPLATE_STORE_DATA_MACRO_NAME);
                        String str11 = data.get(CloudMessages.TEMPLATE_STORE_DATA_MACRO_ID);
                        String str12 = data.get(CloudMessages.TEMPLATE_STORE_DATA_USER_ID);
                        String str13 = data.get(CloudMessages.TEMPLATE_STORE_DATA_USER_NAME);
                        String str14 = data.get(CloudMessages.TEMPLATE_STORE_DATA_USER_IMAGE);
                        if (str10 != null && str9 != null && str11 != null && str13 != null) {
                            Integer valueOf3 = Integer.valueOf(str11);
                            Intrinsics.checkNotNullExpressionValue(valueOf3, "valueOf(macroId)");
                            int intValue3 = valueOf3.intValue();
                            Integer valueOf4 = Integer.valueOf(str12);
                            Intrinsics.checkNotNullExpressionValue(valueOf4, "valueOf(userId)");
                            int intValue4 = valueOf4.intValue();
                            if (str14 == null) {
                                str14 = "";
                            }
                            s(str10, str9, intValue3, intValue4, str13, str14);
                            return;
                        }
                        return;
                    }
                    return;
                case 71033549:
                    if (str.equals(CloudMessages.TEMPLATE_STORE_MESSAGE_TYPE_MACRO_DELETED)) {
                        String str15 = data.get(CloudMessages.TEMPLATE_STORE_DATA_MACRO_NAME);
                        String str16 = data.get(CloudMessages.TEMPLATE_STORE_DATA_MACRO_ID);
                        String str17 = data.get(CloudMessages.TEMPLATE_STORE_DATA_USER_ID);
                        String str18 = data.get(CloudMessages.TEMPLATE_STORE_DATA_USER_NAME);
                        String str19 = data.get(CloudMessages.TEMPLATE_STORE_DATA_USER_IMAGE);
                        if (str15 != null && str16 != null && str17 != null && str18 != null) {
                            Integer valueOf5 = Integer.valueOf(str16);
                            Intrinsics.checkNotNullExpressionValue(valueOf5, "valueOf(macroId)");
                            int intValue5 = valueOf5.intValue();
                            Integer valueOf6 = Integer.valueOf(str17);
                            Intrinsics.checkNotNullExpressionValue(valueOf6, "valueOf(userId)");
                            int intValue6 = valueOf6.intValue();
                            if (str19 == null) {
                                str3 = "";
                            } else {
                                str3 = str19;
                            }
                            r(str15, intValue5, intValue6, str18, str3);
                            return;
                        }
                        return;
                    }
                    return;
                case 434559337:
                    if (str.equals(CloudMessages.URL_TRIGGER)) {
                        String str20 = data.get("id");
                        String str21 = data.get("variables");
                        String str22 = data.get("b");
                        Gson create = GsonUtils.getGsonBuilder().create();
                        Map<String, String> hashMap = new HashMap<>();
                        if (str21 != null) {
                            Object fromJson = create.fromJson(str21, (Class<Object>) hashMap.getClass());
                            Intrinsics.checkNotNull(fromJson, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                            hashMap = (Map) fromJson;
                        }
                        String str23 = data.get("ip");
                        if (!TextUtils.isEmpty(str20)) {
                            WebHookTrigger.Companion companion = WebHookTrigger.Companion;
                            Intrinsics.checkNotNull(str20);
                            companion.checkTriggers(str20, hashMap, str23, str22);
                            return;
                        }
                        return;
                    }
                    return;
                case 756526871:
                    if (str.equals(CloudMessages.TEMPLATE_STORE_MESSAGE_TYPE_USER_NEW_MACRO)) {
                        String str24 = data.get(CloudMessages.TEMPLATE_STORE_DATA_USER_NAME);
                        String str25 = data.get(CloudMessages.TEMPLATE_STORE_DATA_MACRO_NAME);
                        String str26 = data.get(CloudMessages.TEMPLATE_STORE_DATA_MACRO_ID);
                        String str27 = data.get(CloudMessages.TEMPLATE_STORE_DATA_USER_ID);
                        String str28 = data.get(CloudMessages.TEMPLATE_STORE_DATA_USER_IMAGE);
                        if (str24 != null && str25 != null && str26 != null && str27 != null) {
                            Integer valueOf7 = Integer.valueOf(str26);
                            Intrinsics.checkNotNullExpressionValue(valueOf7, "valueOf(macroId)");
                            int intValue7 = valueOf7.intValue();
                            Integer valueOf8 = Integer.valueOf(str27);
                            Intrinsics.checkNotNullExpressionValue(valueOf8, "valueOf(userId)");
                            int intValue8 = valueOf8.intValue();
                            if (str28 == null) {
                                str28 = "";
                            }
                            u(str24, str25, intValue7, intValue8, str28);
                            return;
                        }
                        return;
                    }
                    return;
                case 1879016367:
                    if (str.equals(CloudMessages.TYPE_MACRO_POINTS_RECEIVED)) {
                        Integer valueOf9 = Integer.valueOf(data.get(CloudMessages.VALUE_POINTS));
                        Intrinsics.checkNotNullExpressionValue(valueOf9, "valueOf(data[CloudMessages.VALUE_POINTS])");
                        z(valueOf9.intValue());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(@NotNull String s3) {
        Intrinsics.checkNotNullParameter(s3, "s");
        super.onNewToken(s3);
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.arlosoft.macrodroid.cloudmessaging.a
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                MacroDroidFirebaseMessagingService.v(MacroDroidFirebaseMessagingService.this, task);
            }
        });
    }

    public final void setRoomDatabase(@NotNull MacroDroidRoomDatabase macroDroidRoomDatabase) {
        Intrinsics.checkNotNullParameter(macroDroidRoomDatabase, "<set-?>");
        this.roomDatabase = macroDroidRoomDatabase;
    }

    public final void setTemplateStoreNotificationHandler(@NotNull TemplateStoreNotificationHandler templateStoreNotificationHandler) {
        Intrinsics.checkNotNullParameter(templateStoreNotificationHandler, "<set-?>");
        this.templateStoreNotificationHandler = templateStoreNotificationHandler;
    }

    public final void setUserProvider(@NotNull UserProvider userProvider) {
        Intrinsics.checkNotNullParameter(userProvider, "<set-?>");
        this.userProvider = userProvider;
    }

    public final void setWebTriggerInteractor(@NotNull WebTriggerInteractor webTriggerInteractor) {
        Intrinsics.checkNotNullParameter(webTriggerInteractor, "<set-?>");
        this.webTriggerInteractor = webTriggerInteractor;
    }

    private final void z(int i4) {
    }
}
