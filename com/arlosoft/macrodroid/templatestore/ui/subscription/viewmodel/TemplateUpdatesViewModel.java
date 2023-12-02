package com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.arlosoft.macrodroid.app.di.annotations.ActivityScope;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.database.room.SubcriptionUpdateType;
import com.arlosoft.macrodroid.database.room.SubscriptionUpdateItem;
import com.arlosoft.macrodroid.database.room.SubscriptionUpdateItemDao;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.events.TemplateUpdateEvent;
import com.arlosoft.macrodroid.templatestore.events.UserUpdateEvent;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateUpdatesViewModel.kt */
@StabilityInferred(parameters = 0)
@ActivityScope
/* loaded from: classes3.dex */
public final class TemplateUpdatesViewModel extends ViewModel implements DefaultLifecycleObserver {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f13928a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final MacroDroidRoomDatabase f13929b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ScreenLoader f13930c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final TemplateStoreApi f13931d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final UserProvider f13932e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<Boolean> f13933f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final LiveData<Boolean> f13934g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final MutableLiveData<List<SubscriptionUpdateItem>> f13935h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final LiveData<List<SubscriptionUpdateItem>> f13936i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final SingleLiveEvent<ErrorType> f13937j;

    /* compiled from: TemplateUpdatesViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SubcriptionUpdateType.values().length];
            try {
                iArr[SubcriptionUpdateType.TYPE_MACRO_NEW_COMMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SubcriptionUpdateType.TYPE_MACRO_UPDATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SubcriptionUpdateType.TYPE_USER_NEW_MACRO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: TemplateUpdatesViewModel.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $position;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i4, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$position = i4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$position, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            SubscriptionUpdateItem subscriptionUpdateItem;
            TemplateUpdatesViewModel templateUpdatesViewModel;
            TemplateUpdatesViewModel templateUpdatesViewModel2;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        templateUpdatesViewModel2 = (TemplateUpdatesViewModel) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        templateUpdatesViewModel2.f13935h.postValue((List) obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                templateUpdatesViewModel = (TemplateUpdatesViewModel) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                List<SubscriptionUpdateItem> value = TemplateUpdatesViewModel.this.getUpdateItems().getValue();
                if (value != null) {
                    subscriptionUpdateItem = value.get(this.$position);
                } else {
                    subscriptionUpdateItem = null;
                }
                if (subscriptionUpdateItem != null) {
                    templateUpdatesViewModel = TemplateUpdatesViewModel.this;
                    SubscriptionUpdateItemDao subscriptionUpdateItemDao = templateUpdatesViewModel.f13929b.subscriptionUpdateItemDao();
                    long id = subscriptionUpdateItem.getId();
                    this.L$0 = templateUpdatesViewModel;
                    this.label = 1;
                    if (subscriptionUpdateItemDao.deleteSubscriptionUpdateItem(id, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            SubscriptionUpdateItemDao subscriptionUpdateItemDao2 = templateUpdatesViewModel.f13929b.subscriptionUpdateItemDao();
            this.L$0 = templateUpdatesViewModel;
            this.label = 2;
            obj = subscriptionUpdateItemDao2.getAllSubscriptionUpdateItems(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            templateUpdatesViewModel2 = templateUpdatesViewModel;
            templateUpdatesViewModel2.f13935h.postValue((List) obj);
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
    /* compiled from: TemplateUpdatesViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $macroId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i4, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$macroId = i4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$macroId, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0091 A[Catch: Exception -> 0x00d9, TryCatch #0 {Exception -> 0x00d9, blocks: (B:5:0x000b, B:23:0x00ae, B:25:0x00ba, B:26:0x00cd, B:10:0x0060, B:12:0x0085, B:18:0x0091, B:20:0x00a3), top: B:31:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00a1  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00ad A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r14.label
                r2 = 1
                if (r1 == 0) goto L18
                if (r1 != r2) goto L10
                kotlin.ResultKt.throwOnFailure(r15)     // Catch: java.lang.Exception -> Ld9
                goto Lae
            L10:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L18:
                kotlin.ResultKt.throwOnFailure(r15)
                com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel r15 = com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel.this
                com.arlosoft.macrodroid.templatestore.ui.user.UserProvider r15 = com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel.access$getUserProvider$p(r15)
                com.arlosoft.macrodroid.templatestore.model.User r15 = r15.getUser()
                com.arlosoft.macrodroid.utils.SigningHelper r1 = com.arlosoft.macrodroid.utils.SigningHelper.INSTANCE
                com.arlosoft.macrodroid.app.MacroDroidApplication$Companion r3 = com.arlosoft.macrodroid.app.MacroDroidApplication.Companion
                com.arlosoft.macrodroid.app.MacroDroidApplication r3 = r3.getInstance()
                java.lang.String r1 = r1.getSigningKeySha1(r3)
                int r3 = r15.getUserId()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r3)
                java.lang.String r3 = "adb97ac6-f780-4a41-8475-ce661b574999"
                r4.append(r3)
                r4.append(r1)
                java.lang.String r1 = "0"
                r4.append(r1)
                java.lang.String r1 = r4.toString()
                java.lang.String r4 = com.arlosoft.macrodroid.extensions.StringExtensionsKt.sha256(r1)
                com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel r1 = com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel.this
                android.content.Context r1 = com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel.access$getContext$p(r1)
                java.util.Locale r1 = com.arlosoft.macrodroid.settings.Settings.getLocale(r1)
                java.lang.String r1 = r1.getLanguage()
                com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel r3 = com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel.this     // Catch: java.lang.Exception -> Ld9
                com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi r3 = com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel.access$getTemplateStoreApi$p(r3)     // Catch: java.lang.Exception -> Ld9
                r5 = 0
                int r6 = r15.getUserId()     // Catch: java.lang.Exception -> Ld9
                r7 = 0
                r8 = 0
                r9 = 1
                r10 = 0
                int r15 = r14.$macroId     // Catch: java.lang.Exception -> Ld9
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld9
                r11.<init>()     // Catch: java.lang.Exception -> Ld9
                java.lang.String r12 = "id="
                r11.append(r12)     // Catch: java.lang.Exception -> Ld9
                r11.append(r15)     // Catch: java.lang.Exception -> Ld9
                java.lang.String r11 = r11.toString()     // Catch: java.lang.Exception -> Ld9
                r15 = 0
                if (r1 == 0) goto L8e
                int r12 = r1.length()     // Catch: java.lang.Exception -> Ld9
                if (r12 != 0) goto L8c
                goto L8e
            L8c:
                r12 = 0
                goto L8f
            L8e:
                r12 = 1
            L8f:
                if (r12 != 0) goto La1
                java.lang.String r12 = "language"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r12)     // Catch: java.lang.Exception -> Ld9
                r12 = 2
                java.lang.String r15 = r1.substring(r15, r12)     // Catch: java.lang.Exception -> Ld9
                java.lang.String r1 = "this as java.lang.String…ing(startIndex, endIndex)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r1)     // Catch: java.lang.Exception -> Ld9
                goto La3
            La1:
                java.lang.String r15 = "en"
            La3:
                r12 = r15
                r14.label = r2     // Catch: java.lang.Exception -> Ld9
                r13 = r14
                java.lang.Object r15 = r3.getMacrosCoroutine(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Exception -> Ld9
                if (r15 != r0) goto Lae
                return r0
            Lae:
                java.util.List r15 = (java.util.List) r15     // Catch: java.lang.Exception -> Ld9
                r0 = r15
                java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Exception -> Ld9
                boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> Ld9
                r0 = r0 ^ r2
                if (r0 == 0) goto Lcd
                java.lang.Object r15 = kotlin.collections.CollectionsKt.first(r15)     // Catch: java.lang.Exception -> Ld9
                com.arlosoft.macrodroid.templatestore.model.MacroTemplate r15 = (com.arlosoft.macrodroid.templatestore.model.MacroTemplate) r15     // Catch: java.lang.Exception -> Ld9
                r15.setUseTranslatedText(r2)     // Catch: java.lang.Exception -> Ld9
                com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel r0 = com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel.this     // Catch: java.lang.Exception -> Ld9
                com.arlosoft.macrodroid.app.navigation.ScreenLoader r0 = com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel.access$getScreenLoader$p(r0)     // Catch: java.lang.Exception -> Ld9
                r0.loadTemplateCommentsScreen(r15)     // Catch: java.lang.Exception -> Ld9
                goto Le4
            Lcd:
                com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel r15 = com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel.this     // Catch: java.lang.Exception -> Ld9
                com.arlosoft.macrodroid.utils.SingleLiveEvent r15 = r15.getShowError()     // Catch: java.lang.Exception -> Ld9
                com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.ErrorType r0 = com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.ErrorType.MACRO_NOT_AVAILABLE     // Catch: java.lang.Exception -> Ld9
                r15.postValue(r0)     // Catch: java.lang.Exception -> Ld9
                goto Le4
            Ld9:
                com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel r15 = com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel.this
                com.arlosoft.macrodroid.utils.SingleLiveEvent r15 = r15.getShowError()
                com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.ErrorType r0 = com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.ErrorType.UNKOWN_ERROR
                r15.postValue(r0)
            Le4:
                kotlin.Unit r15 = kotlin.Unit.INSTANCE
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: TemplateUpdatesViewModel.kt */
    /* loaded from: classes3.dex */
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(continuation);
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
                SubscriptionUpdateItemDao subscriptionUpdateItemDao = TemplateUpdatesViewModel.this.f13929b.subscriptionUpdateItemDao();
                this.label = 1;
                obj = subscriptionUpdateItemDao.getAllSubscriptionUpdateItems(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            TemplateUpdatesViewModel.this.f13935h.postValue((List) obj);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: TemplateUpdatesViewModel.kt */
    /* loaded from: classes3.dex */
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new d(continuation);
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
                SubscriptionUpdateItemDao subscriptionUpdateItemDao = TemplateUpdatesViewModel.this.f13929b.subscriptionUpdateItemDao();
                this.label = 1;
                obj = subscriptionUpdateItemDao.getAllSubscriptionUpdateItems(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            TemplateUpdatesViewModel.this.f13935h.postValue((List) obj);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: TemplateUpdatesViewModel.kt */
    /* loaded from: classes3.dex */
    static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new e(continuation);
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
                TemplateUpdatesViewModel.this.f13933f.postValue(Boxing.boxBoolean(true));
                SubscriptionUpdateItemDao subscriptionUpdateItemDao = TemplateUpdatesViewModel.this.f13929b.subscriptionUpdateItemDao();
                this.label = 1;
                obj = subscriptionUpdateItemDao.getAllSubscriptionUpdateItems(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            TemplateUpdatesViewModel.this.f13935h.postValue((List) obj);
            TemplateUpdatesViewModel.this.f13933f.postValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: TemplateUpdatesViewModel.kt */
    /* loaded from: classes3.dex */
    static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SubscriptionUpdateItem $updateItem;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(SubscriptionUpdateItem subscriptionUpdateItem, Continuation<? super f> continuation) {
            super(2, continuation);
            this.$updateItem = subscriptionUpdateItem;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new f(this.$updateItem, continuation);
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
                SubscriptionUpdateItemDao subscriptionUpdateItemDao = TemplateUpdatesViewModel.this.f13929b.subscriptionUpdateItemDao();
                long id = this.$updateItem.getId();
                this.label = 1;
                if (subscriptionUpdateItemDao.deleteSubscriptionUpdateItem(id, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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

    @Inject
    public TemplateUpdatesViewModel(@ApplicationContext @NotNull Context context, @NotNull MacroDroidRoomDatabase roomDatabase, @NotNull ScreenLoader screenLoader, @NotNull TemplateStoreApi templateStoreApi, @NotNull UserProvider userProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(roomDatabase, "roomDatabase");
        Intrinsics.checkNotNullParameter(screenLoader, "screenLoader");
        Intrinsics.checkNotNullParameter(templateStoreApi, "templateStoreApi");
        Intrinsics.checkNotNullParameter(userProvider, "userProvider");
        this.f13928a = context;
        this.f13929b = roomDatabase;
        this.f13930c = screenLoader;
        this.f13931d = templateStoreApi;
        this.f13932e = userProvider;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this.f13933f = mutableLiveData;
        this.f13934g = mutableLiveData;
        MutableLiveData<List<SubscriptionUpdateItem>> mutableLiveData2 = new MutableLiveData<>();
        this.f13935h = mutableLiveData2;
        this.f13936i = mutableLiveData2;
        this.f13937j = new SingleLiveEvent<>();
    }

    private final void a(int i4) {
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), null, null, new b(i4, null), 3, null);
    }

    private final void b(int i4) {
        this.f13930c.loadTemplateSearchScreen(i4);
    }

    public final void deleteItemAtPosition(int i4) {
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), null, null, new a(i4, null), 3, null);
    }

    @NotNull
    public final SingleLiveEvent<ErrorType> getShowError() {
        return this.f13937j;
    }

    @NotNull
    public final LiveData<List<SubscriptionUpdateItem>> getUpdateItems() {
        return this.f13936i;
    }

    @NotNull
    public final LiveData<Boolean> isLoading() {
        return this.f13934g;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.d.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.d.b(this, lifecycleOwner);
    }

    public final void onEventMainThread(@NotNull TemplateUpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new c(null), 2, null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        EventBusUtils.getEventBus().unregister(this);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        EventBusUtils.getEventBus().register(this);
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new e(null), 2, null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.d.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.d.f(this, lifecycleOwner);
    }

    public final void onUpdateItemClicked(@NotNull SubscriptionUpdateItem updateItem) {
        Intrinsics.checkNotNullParameter(updateItem, "updateItem");
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new f(updateItem, null), 2, null);
        int i4 = WhenMappings.$EnumSwitchMapping$0[updateItem.getType().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    b(updateItem.getMacroId());
                    return;
                }
                return;
            }
            b(updateItem.getMacroId());
            return;
        }
        a(updateItem.getMacroId());
    }

    public final void onUserClicked(@NotNull SubscriptionUpdateItem updateItem) {
        Intrinsics.checkNotNullParameter(updateItem, "updateItem");
        ScreenLoader.loadUserDetailsScreen$default(this.f13930c, updateItem.getUsername(), updateItem.getUserImage(), updateItem.getUserId(), null, 8, null);
    }

    public final void onEventMainThread(@NotNull UserUpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new d(null), 2, null);
    }
}
