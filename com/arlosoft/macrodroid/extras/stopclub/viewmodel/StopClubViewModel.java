package com.arlosoft.macrodroid.extras.stopclub.viewmodel;

import android.content.Context;
import android.provider.Settings;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.app.di.modules.BillingModuleKt;
import com.arlosoft.macrodroid.confirmation.PremiumStatus;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.confirmation.PurchaseValidator;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.events.CategoryEnabledStateChangeEvent;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.extras.ExtrasDownloader;
import com.arlosoft.macrodroid.extras.data.ExtraPackage;
import com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState;
import com.arlosoft.macrodroid.extras.data.ExtrasViewState;
import com.arlosoft.macrodroid.extras.data.UpdateState;
import com.arlosoft.macrodroid.extras.data.ValidationState;
import com.arlosoft.macrodroid.extras.stopclub.analytics.StopClubAnalytics;
import com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel;
import com.arlosoft.macrodroid.extras.ui.ExtraPackageClickListener;
import com.arlosoft.macrodroid.extras.ui.management.ExtrasManager;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.InvokedByRunMacroTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import com.arlosoft.macrodroid.upgrade.billing.SubscriptionPrice;
import com.arlosoft.macrodroid.upgrade.model.SubscriptionCheckStatus;
import com.arlosoft.macrodroid.utils.CountryCodeUtil;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Source;
import com.google.firebase.firestore.ktx.FirestoreKt;
import com.google.firebase.ktx.Firebase;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StopClubViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class StopClubViewModel extends ViewModel implements DefaultLifecycleObserver {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a */
    private final Context f12047a;
    @NotNull

    /* renamed from: b */
    private final ExtrasManager f12048b;
    @NotNull

    /* renamed from: c */
    private final MacroDroidRoomDatabase f12049c;
    @NotNull

    /* renamed from: d */
    private final RemoteConfig f12050d;
    @NotNull

    /* renamed from: e */
    private final ExtrasDownloader f12051e;
    @NotNull

    /* renamed from: f */
    private final PurchaseValidator f12052f;
    @NotNull

    /* renamed from: g */
    private final PremiumStatusHandler f12053g;
    @NotNull

    /* renamed from: h */
    private final BillingDataSource f12054h;
    @NotNull

    /* renamed from: i */
    private final SingleLiveEvent<ExtraPackageWithPriceAndState> f12055i;
    @NotNull

    /* renamed from: j */
    private final SingleLiveEvent<SubscriptionCheckStatus> f12056j;
    @NotNull

    /* renamed from: k */
    private final SingleLiveEvent<String> f12057k;
    @NotNull

    /* renamed from: l */
    private final SingleLiveEvent<Unit> f12058l;
    @NotNull

    /* renamed from: m */
    private final SingleLiveEvent<Unit> f12059m;
    @NotNull

    /* renamed from: n */
    private final MutableLiveData<ExtrasViewState> f12060n;
    @NotNull

    /* renamed from: o */
    private final LiveData<ExtrasViewState> f12061o;
    @Nullable

    /* renamed from: p */
    private ExtrasViewState.Loaded f12062p;
    @NotNull

    /* renamed from: q */
    private final FirebaseFirestore f12063q;
    @Nullable

    /* renamed from: r */
    private Boolean f12064r;
    @NotNull

    /* renamed from: s */
    private final MutableLiveData<SubscriptionPrice> f12065s;
    @NotNull

    /* renamed from: t */
    private final LiveData<SubscriptionPrice> f12066t;
    @NotNull

    /* renamed from: u */
    private final MutableLiveData<SubscriptionPrice> f12067u;
    @NotNull

    /* renamed from: v */
    private final LiveData<SubscriptionPrice> f12068v;
    @NotNull

    /* renamed from: w */
    private final MutableLiveData<SubscriptionPrice> f12069w;
    @NotNull

    /* renamed from: x */
    private final LiveData<SubscriptionPrice> f12070x;
    @Nullable

    /* renamed from: y */
    private ExtraPackage f12071y;

    /* compiled from: StopClubViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ExtraPackageClickListener.PurchasePeriod.values().length];
            try {
                iArr[ExtraPackageClickListener.PurchasePeriod.WEEKLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExtraPackageClickListener.PurchasePeriod.MONTHLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExtraPackageClickListener.PurchasePeriod.YEARLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: StopClubViewModel.kt */
    @SourceDebugExtension({"SMAP\nStopClubViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StopClubViewModel.kt\ncom/arlosoft/macrodroid/extras/stopclub/viewmodel/StopClubViewModel$activateMacroSet$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,517:1\n288#2,2:518\n*S KotlinDebug\n*F\n+ 1 StopClubViewModel.kt\ncom/arlosoft/macrodroid/extras/stopclub/viewmodel/StopClubViewModel$activateMacroSet$2\n*L\n289#1:518,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackage $extraPackage;
        final /* synthetic */ boolean $forceUpdate;
        final /* synthetic */ boolean $isUpdate;
        Object L$0;
        int label;

        /* compiled from: StopClubViewModel.kt */
        /* renamed from: com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel$a$a */
        /* loaded from: classes3.dex */
        public static final class C0100a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ StopClubViewModel this$0;

            /* compiled from: StopClubViewModel.kt */
            /* renamed from: com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel$a$a$a */
            /* loaded from: classes3.dex */
            public static final class C0101a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ StopClubViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0101a(StopClubViewModel stopClubViewModel, Continuation<? super C0101a> continuation) {
                    super(2, continuation);
                    this.this$0 = stopClubViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C0101a(this.this$0, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        ExtrasViewState.Loaded h4 = StopClubViewModel.h(this.this$0, false, 1, null);
                        if (h4 != null) {
                            this.this$0.n(h4.copy(ExtraPackageWithPriceAndState.copy$default(h4.getExtra(), null, null, null, null, null, null, null, ValidationState.NOT_VALIDATING, UpdateState.NOT_UPDATING, false, false, 1663, null)));
                            return Unit.INSTANCE;
                        }
                        return null;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                /* renamed from: invoke */
                public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C0101a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0100a(StopClubViewModel stopClubViewModel, Continuation<? super C0100a> continuation) {
                super(2, continuation);
                this.this$0 = stopClubViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0100a(this.this$0, continuation);
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
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    C0101a c0101a = new C0101a(this.this$0, null);
                    this.label = 1;
                    if (BuildersKt.withContext(main, c0101a, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.this$0.getValidationFailedEvent().postValue(new SubscriptionCheckStatus.ValidationFailed("No subscription details available"));
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((C0100a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ExtraPackage extraPackage, boolean z3, boolean z4, Continuation<? super a> continuation) {
            super(2, continuation);
            StopClubViewModel.this = r1;
            this.$extraPackage = extraPackage;
            this.$forceUpdate = z3;
            this.$isUpdate = z4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$extraPackage, this.$forceUpdate, this.$isUpdate, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:117:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x015d  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
            /*
                Method dump skipped, instructions count: 509
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: StopClubViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackage $extraPackage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ExtraPackage extraPackage, Continuation<? super b> continuation) {
            super(2, continuation);
            StopClubViewModel.this = r1;
            this.$extraPackage = extraPackage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$extraPackage, continuation);
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
                if (StopClubViewModel.this.f12048b.isExtraInstalled(this.$extraPackage.getId())) {
                    ExtrasManager extrasManager = StopClubViewModel.this.f12048b;
                    String id = this.$extraPackage.getId();
                    this.label = 1;
                    if (ExtrasManager.removeExtraPackage$default(extrasManager, id, false, this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: StopClubViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class c extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Continuation<? super c> continuation) {
            super(continuation);
            StopClubViewModel.this = r1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StopClubViewModel.this.i(null, false, this);
        }
    }

    /* compiled from: StopClubViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
        Object L$0;
        int label;

        /* compiled from: StopClubViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<SubscriptionPrice, Unit> {
            final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
            final /* synthetic */ String $subscriptionId;
            final /* synthetic */ StopClubViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, ExtraPackageWithPriceAndState extraPackageWithPriceAndState, StopClubViewModel stopClubViewModel) {
                super(1);
                this.$subscriptionId = str;
                this.$extraPackage = extraPackageWithPriceAndState;
                this.this$0 = stopClubViewModel;
            }

            public final void a(@NotNull SubscriptionPrice price) {
                Intrinsics.checkNotNullParameter(price, "price");
                String str = this.$subscriptionId;
                if (Intrinsics.areEqual(str, this.$extraPackage.getExtra().getSubscriptionData().getWeeklySubscriptionId())) {
                    this.this$0.f12065s.postValue(this.this$0.c(price, ExtraPackageClickListener.PurchasePeriod.WEEKLY));
                } else if (Intrinsics.areEqual(str, this.$extraPackage.getExtra().getSubscriptionData().getMonthlySubscriptionId())) {
                    this.this$0.f12067u.postValue(this.this$0.c(price, ExtraPackageClickListener.PurchasePeriod.MONTHLY));
                } else if (Intrinsics.areEqual(str, this.$extraPackage.getExtra().getSubscriptionData().getYearlySubscriptionId())) {
                    this.this$0.f12069w.postValue(this.this$0.c(price, ExtraPackageClickListener.PurchasePeriod.YEARLY));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SubscriptionPrice subscriptionPrice) {
                a(subscriptionPrice);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super d> continuation) {
            super(2, continuation);
            StopClubViewModel.this = r1;
            this.$extraPackage = extraPackageWithPriceAndState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new d(this.$extraPackage, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Iterator<String> it;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    it = (Iterator) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                if (!StopClubViewModel.this.f12048b.isExtraInstalled(this.$extraPackage.getExtra().getId()) || this.$extraPackage.getInstalledVersion() == null) {
                    it = this.$extraPackage.getExtra().getSubscriptionData().getAllSubscriptionIds().iterator();
                }
                return Unit.INSTANCE;
            }
            while (it.hasNext()) {
                String next = it.next();
                StopClubViewModel stopClubViewModel = StopClubViewModel.this;
                a aVar = new a(next, this.$extraPackage, stopClubViewModel);
                this.L$0 = it;
                this.label = 1;
                if (stopClubViewModel.k(next, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: StopClubViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
        int label;

        /* compiled from: StopClubViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<PremiumStatus, Boolean> {

            /* renamed from: d */
            public static final a f12072d = new a();

            a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            /* renamed from: a */
            public final Boolean invoke(@NotNull PremiumStatus it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.hasActiveSubscription());
            }
        }

        /* compiled from: StopClubViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class b implements FlowCollector<Boolean> {

            /* renamed from: a */
            final /* synthetic */ StopClubViewModel f12073a;

            /* renamed from: b */
            final /* synthetic */ ExtraPackageWithPriceAndState f12074b;

            /* compiled from: StopClubViewModel.kt */
            /* loaded from: classes3.dex */
            public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
                int label;
                final /* synthetic */ StopClubViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(StopClubViewModel stopClubViewModel, ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super a> continuation) {
                    super(2, continuation);
                    this.this$0 = stopClubViewModel;
                    this.$extraPackage = extraPackageWithPriceAndState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new a(this.this$0, this.$extraPackage, continuation);
                }

                /* JADX WARN: Removed duplicated region for block: B:43:0x0051  */
                /* JADX WARN: Removed duplicated region for block: B:46:0x0085  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r19) {
                    /*
                        r18 = this;
                        r0 = r18
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 0
                        r4 = 1
                        if (r2 == 0) goto L1c
                        if (r2 != r4) goto L14
                        kotlin.ResultKt.throwOnFailure(r19)
                        r2 = r19
                        goto L4a
                    L14:
                        java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                        java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                        r1.<init>(r2)
                        throw r1
                    L1c:
                        kotlin.ResultKt.throwOnFailure(r19)
                        com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel r2 = r0.this$0
                        com.arlosoft.macrodroid.extras.ui.management.ExtrasManager r2 = com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel.access$getExtrasManager$p(r2)
                        com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState r5 = r0.$extraPackage
                        com.arlosoft.macrodroid.extras.data.ExtraPackage r5 = r5.getExtra()
                        java.lang.String r5 = r5.getId()
                        boolean r2 = r2.isExtraInstalled(r5)
                        if (r2 == 0) goto L4d
                        com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel r2 = r0.this$0
                        com.arlosoft.macrodroid.extras.ui.management.ExtrasManager r2 = com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel.access$getExtrasManager$p(r2)
                        com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState r5 = r0.$extraPackage
                        com.arlosoft.macrodroid.extras.data.ExtraPackage r5 = r5.getExtra()
                        r0.label = r4
                        java.lang.Object r2 = r2.getInstalledVersion(r5, r0)
                        if (r2 != r1) goto L4a
                        return r1
                    L4a:
                        com.arlosoft.macrodroid.database.room.ExtraInstalled r2 = (com.arlosoft.macrodroid.database.room.ExtraInstalled) r2
                        goto L4e
                    L4d:
                        r2 = r3
                    L4e:
                        r1 = 0
                        if (r2 == 0) goto L85
                        com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel r5 = r0.this$0
                        com.arlosoft.macrodroid.extras.data.ExtrasViewState$Loaded r1 = com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel.h(r5, r1, r4, r3)
                        if (r1 == 0) goto Lc1
                        com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel r3 = r0.this$0
                        com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState r4 = r1.getExtra()
                        r5 = 0
                        r6 = 0
                        r7 = 0
                        r8 = 0
                        r9 = 0
                        int r2 = r2.getVersionCode()
                        java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
                        r11 = 0
                        r12 = 0
                        r13 = 0
                        r14 = 0
                        r15 = 0
                        r16 = 2015(0x7df, float:2.824E-42)
                        r17 = 0
                        com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState r2 = com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState.copy$default(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
                        com.arlosoft.macrodroid.extras.data.ExtrasViewState$Loaded r1 = r1.copy(r2)
                        androidx.lifecycle.MutableLiveData r2 = com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel.access$get_viewState$p(r3)
                        r2.postValue(r1)
                        goto Lc1
                    L85:
                        com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel r2 = r0.this$0
                        com.arlosoft.macrodroid.extras.data.ExtrasViewState$Loaded r1 = com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel.h(r2, r1, r4, r3)
                        if (r1 == 0) goto Lb2
                        com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel r2 = r0.this$0
                        com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState r3 = r1.getExtra()
                        r4 = 0
                        r5 = 0
                        r6 = 0
                        r7 = 0
                        r8 = 0
                        r9 = 0
                        r10 = 0
                        com.arlosoft.macrodroid.extras.data.ValidationState r11 = com.arlosoft.macrodroid.extras.data.ValidationState.VALIDATING
                        r12 = 0
                        r13 = 0
                        r14 = 0
                        r15 = 1919(0x77f, float:2.689E-42)
                        r16 = 0
                        com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState r3 = com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState.copy$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
                        com.arlosoft.macrodroid.extras.data.ExtrasViewState$Loaded r1 = r1.copy(r3)
                        androidx.lifecycle.MutableLiveData r2 = com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel.access$get_viewState$p(r2)
                        r2.postValue(r1)
                    Lb2:
                        com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel r3 = r0.this$0
                        com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState r1 = r0.$extraPackage
                        com.arlosoft.macrodroid.extras.data.ExtraPackage r4 = r1.getExtra()
                        r5 = 0
                        r6 = 0
                        r7 = 4
                        r8 = 0
                        com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel.activateMacroSet$default(r3, r4, r5, r6, r7, r8)
                    Lc1:
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel.e.b.a.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                /* renamed from: invoke */
                public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            b(StopClubViewModel stopClubViewModel, ExtraPackageWithPriceAndState extraPackageWithPriceAndState) {
                this.f12073a = stopClubViewModel;
                this.f12074b = extraPackageWithPriceAndState;
            }

            @Nullable
            public final Object a(boolean z3, @NotNull Continuation<? super Unit> continuation) {
                if (Intrinsics.areEqual(Boxing.boxBoolean(z3), this.f12073a.f12064r)) {
                    return Unit.INSTANCE;
                }
                this.f12073a.f12064r = Boxing.boxBoolean(z3);
                if (z3) {
                    if (this.f12074b.getMinVersionRemoteConfig().getVersionCode() <= 53800019) {
                        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this.f12073a), Dispatchers.getIO(), null, new a(this.f12073a, this.f12074b, null), 2, null);
                    } else {
                        ExtrasViewState.Loaded h4 = StopClubViewModel.h(this.f12073a, false, 1, null);
                        if (h4 != null) {
                            StopClubViewModel stopClubViewModel = this.f12073a;
                            stopClubViewModel.f12060n.postValue(h4.copy(ExtraPackageWithPriceAndState.copy$default(h4.getExtra(), null, null, null, null, null, null, null, null, null, false, false, 2015, null)));
                        }
                    }
                } else {
                    if (!Settings.getHasActivatedStopClub(this.f12073a.f12047a)) {
                        StopClubAnalytics.INSTANCE.setNoSubscription();
                    } else {
                        StopClubAnalytics.INSTANCE.setSubscriptionExpired();
                    }
                    this.f12073a.onExtraSubscriptionIsNotActive(this.f12074b.getExtra());
                }
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Boolean bool, Continuation continuation) {
                return a(bool.booleanValue(), continuation);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super e> continuation) {
            super(2, continuation);
            StopClubViewModel.this = r1;
            this.$extraPackage = extraPackageWithPriceAndState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new e(this.$extraPackage, continuation);
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
                Flow asFlow = FlowLiveDataConversions.asFlow(Transformations.map(StopClubViewModel.this.f12053g.getSubscriptionPremiumsStatusLiveDataList(this.$extraPackage.getExtra().getSubscriptionData().getAllSubscriptionIds()), a.f12072d));
                b bVar = new b(StopClubViewModel.this, this.$extraPackage);
                this.label = 1;
                if (asFlow.collect(bVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: StopClubViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super f> continuation) {
            super(2, continuation);
            StopClubViewModel.this = r1;
            this.$extraPackage = extraPackageWithPriceAndState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new f(this.$extraPackage, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ExtrasViewState.Loaded h4 = StopClubViewModel.h(StopClubViewModel.this, false, 1, null);
                if (h4 != null) {
                    ExtraPackageWithPriceAndState extraPackageWithPriceAndState = this.$extraPackage;
                    StopClubViewModel stopClubViewModel = StopClubViewModel.this;
                    stopClubViewModel.f12060n.postValue(h4.copy(ExtraPackageWithPriceAndState.copy$default(extraPackageWithPriceAndState, null, null, null, null, null, null, null, null, UpdateState.UPDATING, false, false, 1791, null)));
                }
                StopClubViewModel.this.activateMacroSet(this.$extraPackage.getExtra(), true, true);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: StopClubViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $chunk;
        final /* synthetic */ String $encryptedMacroSet;
        final /* synthetic */ ExtraPackage $extraPackage;
        final /* synthetic */ boolean $forceUpdate;
        int label;
        final /* synthetic */ StopClubViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(boolean z3, StopClubViewModel stopClubViewModel, ExtraPackage extraPackage, String str, String str2, Continuation<? super g> continuation) {
            super(2, continuation);
            this.$forceUpdate = z3;
            this.this$0 = stopClubViewModel;
            this.$extraPackage = extraPackage;
            this.$encryptedMacroSet = str;
            this.$chunk = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new g(this.$forceUpdate, this.this$0, this.$extraPackage, this.$encryptedMacroSet, this.$chunk, continuation);
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
                if (this.$forceUpdate || !this.this$0.f12048b.isExtraInstalled(this.$extraPackage.getId())) {
                    ExtrasManager extrasManager = this.this$0.f12048b;
                    ExtraPackage extraPackage = this.$extraPackage;
                    String str = this.$encryptedMacroSet;
                    String str2 = this.$chunk;
                    this.label = 1;
                    if (extrasManager.installExtraPackage(extraPackage, str, str2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            List<Macro> allCompletedMacros = MacroStore.getInstance().getAllCompletedMacros();
            Intrinsics.checkNotNullExpressionValue(allCompletedMacros, "getInstance().allCompletedMacros");
            if (!allCompletedMacros.isEmpty()) {
                this.this$0.e();
                this.this$0.getShowCategoriesDisabledWarning().postValue(Unit.INSTANCE);
            }
            if (this.this$0.f12048b.getActiveState()) {
                this.this$0.setActiveState(false);
                this.this$0.setActiveState(true);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: StopClubViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackage $extraPackage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(ExtraPackage extraPackage, Continuation<? super h> continuation) {
            super(2, continuation);
            StopClubViewModel.this = r1;
            this.$extraPackage = extraPackage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new h(this.$extraPackage, continuation);
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
                if (StopClubViewModel.this.f12048b.isExtraInstalled(this.$extraPackage.getId())) {
                    ExtrasManager extrasManager = StopClubViewModel.this.f12048b;
                    String id = this.$extraPackage.getId();
                    this.label = 1;
                    if (ExtrasManager.removeExtraPackage$default(extrasManager, id, false, this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: StopClubViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class i extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Continuation<? super i> continuation) {
            super(continuation);
            StopClubViewModel.this = r1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StopClubViewModel.this.k(null, null, this);
        }
    }

    /* compiled from: StopClubViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class j implements FlowCollector<SubscriptionPrice> {

        /* renamed from: a */
        final /* synthetic */ Function1<SubscriptionPrice, Unit> f12075a;

        /* JADX WARN: Multi-variable type inference failed */
        j(Function1<? super SubscriptionPrice, Unit> function1) {
            this.f12075a = function1;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /* renamed from: a */
        public final Object emit(@NotNull SubscriptionPrice subscriptionPrice, @NotNull Continuation<? super Unit> continuation) {
            this.f12075a.invoke(subscriptionPrice);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: StopClubViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class k extends Lambda implements Function1<DocumentSnapshot, Unit> {
        final /* synthetic */ boolean $forceActivate;

        /* compiled from: StopClubViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<DocumentSnapshot, Unit> {
            final /* synthetic */ ExtraPackage $extraPackage;
            final /* synthetic */ boolean $forceActivate;
            final /* synthetic */ StopClubViewModel this$0;

            /* compiled from: StopClubViewModel.kt */
            /* renamed from: com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel$k$a$a */
            /* loaded from: classes3.dex */
            public static final class C0102a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ ExtraPackage $extraPackage;
                final /* synthetic */ boolean $forceActivate;
                int label;
                final /* synthetic */ StopClubViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0102a(StopClubViewModel stopClubViewModel, ExtraPackage extraPackage, boolean z3, Continuation<? super C0102a> continuation) {
                    super(2, continuation);
                    this.this$0 = stopClubViewModel;
                    this.$extraPackage = extraPackage;
                    this.$forceActivate = z3;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C0102a(this.this$0, this.$extraPackage, this.$forceActivate, continuation);
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
                        StopClubViewModel stopClubViewModel = this.this$0;
                        ExtraPackage extraPackage = this.$extraPackage;
                        this.label = 1;
                        if (stopClubViewModel.i(extraPackage, true, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    if (this.$forceActivate) {
                        StopClubViewModel.activateMacroSet$default(this.this$0, this.$extraPackage, true, false, 4, null);
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                /* renamed from: invoke */
                public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C0102a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* compiled from: StopClubViewModel.kt */
            /* loaded from: classes3.dex */
            public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ ExtraPackage $extraPackage;
                final /* synthetic */ boolean $forceActivate;
                final /* synthetic */ DocumentSnapshot $result;
                int label;
                final /* synthetic */ StopClubViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(StopClubViewModel stopClubViewModel, ExtraPackage extraPackage, DocumentSnapshot documentSnapshot, boolean z3, Continuation<? super b> continuation) {
                    super(2, continuation);
                    this.this$0 = stopClubViewModel;
                    this.$extraPackage = extraPackage;
                    this.$result = documentSnapshot;
                    this.$forceActivate = z3;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new b(this.this$0, this.$extraPackage, this.$result, this.$forceActivate, continuation);
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
                        StopClubViewModel stopClubViewModel = this.this$0;
                        ExtraPackage extraPackage = this.$extraPackage;
                        boolean exists = this.$result.exists();
                        this.label = 1;
                        if (stopClubViewModel.i(extraPackage, exists, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    if (this.$forceActivate) {
                        StopClubViewModel.activateMacroSet$default(this.this$0, this.$extraPackage, true, false, 4, null);
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                /* renamed from: invoke */
                public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(StopClubViewModel stopClubViewModel, ExtraPackage extraPackage, boolean z3) {
                super(1);
                this.this$0 = stopClubViewModel;
                this.$extraPackage = extraPackage;
                this.$forceActivate = z3;
            }

            public final void a(DocumentSnapshot documentSnapshot) {
                if (Settings.getExtraNoFreeTrial(MacroDroidApplication.Companion.getInstance())) {
                    kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this.this$0), Dispatchers.getIO(), null, new C0102a(this.this$0, this.$extraPackage, this.$forceActivate, null), 2, null);
                } else {
                    kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this.this$0), Dispatchers.getIO(), null, new b(this.this$0, this.$extraPackage, documentSnapshot, this.$forceActivate, null), 2, null);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DocumentSnapshot documentSnapshot) {
                a(documentSnapshot);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: StopClubViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ExtraPackage $extraPackage;
            final /* synthetic */ boolean $forceActivate;
            int label;
            final /* synthetic */ StopClubViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(StopClubViewModel stopClubViewModel, ExtraPackage extraPackage, boolean z3, Continuation<? super b> continuation) {
                super(2, continuation);
                this.this$0 = stopClubViewModel;
                this.$extraPackage = extraPackage;
                this.$forceActivate = z3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new b(this.this$0, this.$extraPackage, this.$forceActivate, continuation);
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
                    StopClubViewModel stopClubViewModel = this.this$0;
                    ExtraPackage extraPackage = this.$extraPackage;
                    this.label = 1;
                    if (stopClubViewModel.i(extraPackage, false, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (this.$forceActivate) {
                    StopClubViewModel.activateMacroSet$default(this.this$0, this.$extraPackage, true, false, 4, null);
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(boolean z3) {
            super(1);
            StopClubViewModel.this = r1;
            this.$forceActivate = z3;
        }

        public static final void e(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }

        public static final void f(StopClubViewModel this$0, ExtraPackage extraPackage, boolean z3, Exception exception) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(exception, "exception");
            kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this$0), Dispatchers.getIO(), null, new b(this$0, extraPackage, z3, null), 2, null);
        }

        public final void c(DocumentSnapshot document) {
            StopClubViewModel stopClubViewModel = StopClubViewModel.this;
            Intrinsics.checkNotNullExpressionValue(document, "document");
            final ExtraPackage f4 = stopClubViewModel.f(document);
            if (f4 == null) {
                StopClubViewModel.this.f12060n.postValue(ExtrasViewState.Error.INSTANCE);
            } else if (!Intrinsics.areEqual(f4, StopClubViewModel.this.f12071y)) {
                StopClubViewModel.this.f12071y = f4;
                Task<DocumentSnapshot> task = StopClubViewModel.this.f12063q.collection(ExtrasManager.Companion.getExtrasCollection()).document(BillingModuleKt.SKU_STOPCLUB_SUB).collection("devices").document(Settings.Secure.getString(MacroDroidApplication.Companion.getInstance().getContentResolver(), "android_id")).get(Source.DEFAULT);
                final a aVar = new a(StopClubViewModel.this, f4, this.$forceActivate);
                Task<DocumentSnapshot> addOnSuccessListener = task.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.extras.stopclub.viewmodel.c
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        StopClubViewModel.k.e(Function1.this, obj);
                    }
                });
                final StopClubViewModel stopClubViewModel2 = StopClubViewModel.this;
                final boolean z3 = this.$forceActivate;
                addOnSuccessListener.addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.extras.stopclub.viewmodel.d
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        StopClubViewModel.k.f(StopClubViewModel.this, f4, z3, exc);
                    }
                });
            } else if (!StopClubViewModel.this.f12048b.isExtraInstalled(f4.getId())) {
                ExtrasViewState.Loaded g4 = StopClubViewModel.this.g(true);
                if (g4 != null) {
                    StopClubViewModel stopClubViewModel3 = StopClubViewModel.this;
                    boolean z4 = this.$forceActivate;
                    stopClubViewModel3.n(g4.copy(ExtraPackageWithPriceAndState.copy$default(g4.getExtra(), null, null, null, null, null, null, null, null, null, false, false, 2015, null)));
                    if (z4) {
                        StopClubViewModel.activateMacroSet$default(stopClubViewModel3, f4, true, false, 4, null);
                    }
                }
            } else {
                ExtrasViewState.Loaded g5 = StopClubViewModel.this.g(true);
                if (g5 != null) {
                    StopClubViewModel.this.f12060n.postValue(g5);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DocumentSnapshot documentSnapshot) {
            c(documentSnapshot);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: StopClubViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class l extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(Continuation<? super l> continuation) {
            super(2, continuation);
            StopClubViewModel.this = r1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new l(continuation);
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
                ExtrasViewState.Loaded h4 = StopClubViewModel.h(StopClubViewModel.this, false, 1, null);
                if (h4 != null) {
                    ExtrasManager extrasManager = StopClubViewModel.this.f12048b;
                    String id = h4.getExtra().getExtra().getId();
                    this.label = 1;
                    if (extrasManager.removeExtraPackage(id, true, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((l) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: StopClubViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class m extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(Continuation<? super m> continuation) {
            super(2, continuation);
            StopClubViewModel.this = r1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new m(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            ExtrasViewState.Loaded loaded;
            StopClubViewModel stopClubViewModel;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    loaded = (ExtrasViewState.Loaded) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    stopClubViewModel = (StopClubViewModel) this.L$0;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                ExtrasViewState.Loaded h4 = StopClubViewModel.h(StopClubViewModel.this, false, 1, null);
                if (h4 != null) {
                    StopClubViewModel stopClubViewModel2 = StopClubViewModel.this;
                    ExtrasManager extrasManager = stopClubViewModel2.f12048b;
                    String id = h4.getExtra().getExtra().getId();
                    this.L$0 = stopClubViewModel2;
                    this.L$1 = h4;
                    this.label = 1;
                    if (ExtrasManager.removeExtraPackage$default(extrasManager, id, false, this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    loaded = h4;
                    stopClubViewModel = stopClubViewModel2;
                }
                return Unit.INSTANCE;
            }
            stopClubViewModel.f12060n.postValue(loaded.copy(ExtraPackageWithPriceAndState.copy$default(loaded.getExtra(), null, null, null, null, null, null, null, ValidationState.VALIDATING, null, false, false, 895, null)));
            stopClubViewModel.getScrollToTopEvent().postValue(Unit.INSTANCE);
            StopClubViewModel.activateMacroSet$default(stopClubViewModel, loaded.getExtra().getExtra(), true, false, 4, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((m) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: StopClubViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class n extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isActive;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(boolean z3, Continuation<? super n> continuation) {
            super(2, continuation);
            StopClubViewModel.this = r1;
            this.$isActive = z3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new n(this.$isActive, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            ExtrasViewState.Loaded h4;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StopClubViewModel.this.f12048b.setActiveState(this.$isActive);
                ExtrasViewState extrasViewState = (ExtrasViewState) StopClubViewModel.this.f12060n.getValue();
                if ((extrasViewState instanceof ExtrasViewState.Loaded) && (h4 = StopClubViewModel.h(StopClubViewModel.this, false, 1, null)) != null) {
                    StopClubViewModel.this.n(h4.copy(ExtraPackageWithPriceAndState.copy$default(((ExtrasViewState.Loaded) extrasViewState).getExtra(), null, null, null, null, null, null, null, null, null, false, this.$isActive, Place.TYPE_SUBLOCALITY_LEVEL_1, null)));
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((n) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Inject
    public StopClubViewModel(@ApplicationContext @NotNull Context context, @NotNull ExtrasManager extrasManager, @NotNull MacroDroidRoomDatabase roomDatabase, @NotNull RemoteConfig remoteConfig, @NotNull ExtrasDownloader extrasDownloader, @NotNull PurchaseValidator purchaseValidator, @NotNull PremiumStatusHandler premiumStatusHandler, @NotNull BillingDataSource billingDataSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extrasManager, "extrasManager");
        Intrinsics.checkNotNullParameter(roomDatabase, "roomDatabase");
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        Intrinsics.checkNotNullParameter(extrasDownloader, "extrasDownloader");
        Intrinsics.checkNotNullParameter(purchaseValidator, "purchaseValidator");
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "premiumStatusHandler");
        Intrinsics.checkNotNullParameter(billingDataSource, "billingDataSource");
        this.f12047a = context;
        this.f12048b = extrasManager;
        this.f12049c = roomDatabase;
        this.f12050d = remoteConfig;
        this.f12051e = extrasDownloader;
        this.f12052f = purchaseValidator;
        this.f12053g = premiumStatusHandler;
        this.f12054h = billingDataSource;
        this.f12055i = new SingleLiveEvent<>();
        this.f12056j = new SingleLiveEvent<>();
        this.f12057k = new SingleLiveEvent<>();
        this.f12058l = new SingleLiveEvent<>();
        this.f12059m = new SingleLiveEvent<>();
        MutableLiveData<ExtrasViewState> mutableLiveData = new MutableLiveData<>();
        this.f12060n = mutableLiveData;
        this.f12061o = mutableLiveData;
        this.f12063q = FirestoreKt.getFirestore(Firebase.INSTANCE);
        MutableLiveData<SubscriptionPrice> mutableLiveData2 = new MutableLiveData<>();
        this.f12065s = mutableLiveData2;
        this.f12066t = mutableLiveData2;
        MutableLiveData<SubscriptionPrice> mutableLiveData3 = new MutableLiveData<>();
        this.f12067u = mutableLiveData3;
        this.f12068v = mutableLiveData3;
        MutableLiveData<SubscriptionPrice> mutableLiveData4 = new MutableLiveData<>();
        this.f12069w = mutableLiveData4;
        this.f12070x = mutableLiveData4;
        refreshWithLoadingState$default(this, false, 1, null);
    }

    public static /* synthetic */ void activateMacroSet$default(StopClubViewModel stopClubViewModel, ExtraPackage extraPackage, boolean z3, boolean z4, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        stopClubViewModel.activateMacroSet(extraPackage, z3, z4);
    }

    public final SubscriptionPrice c(SubscriptionPrice subscriptionPrice, ExtraPackageClickListener.PurchasePeriod purchasePeriod) {
        String originalPriceWeekly;
        ExtraPackage extraPackage = this.f12071y;
        if (extraPackage != null && (subscriptionPrice instanceof SubscriptionPrice.StandardPrice) && extraPackage.getSubscriptionData().getPromotionData() != null) {
            int i4 = WhenMappings.$EnumSwitchMapping$0[purchasePeriod.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        originalPriceWeekly = null;
                    } else {
                        originalPriceWeekly = extraPackage.getSubscriptionData().getPromotionData().getOriginalPriceYearly();
                    }
                } else {
                    originalPriceWeekly = extraPackage.getSubscriptionData().getPromotionData().getOriginalPriceMonthly();
                }
            } else {
                originalPriceWeekly = extraPackage.getSubscriptionData().getPromotionData().getOriginalPriceWeekly();
            }
            String str = originalPriceWeekly;
            if (str != null) {
                return new SubscriptionPrice.DiscountedPrice(((SubscriptionPrice.StandardPrice) subscriptionPrice).getPrice(), str, extraPackage.getSubscriptionData().getPromotionData().getOfferPercent(), false, 8, null);
            }
        }
        return subscriptionPrice;
    }

    private final void d(ExtraPackage extraPackage, int i4) {
        if (i4 > 53800019) {
            kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), null, null, new b(extraPackage, null), 3, null);
        }
    }

    public final boolean e() {
        List<Macro> allCompletedMacros = MacroStore.getInstance().getAllCompletedMacros();
        HashSet hashSet = new HashSet();
        for (Macro macro : allCompletedMacros) {
            String category = macro.getCategory();
            if (category != null) {
                hashSet.add(category);
            } else {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("disableAllStandardCategoriesInApp: Macro has a null category"));
            }
        }
        Set<String> disabledCategories = com.arlosoft.macrodroid.settings.Settings.getDisabledCategories(this.f12047a);
        disabledCategories.addAll(hashSet);
        com.arlosoft.macrodroid.settings.Settings.setDisabledCategories(this.f12047a, disabledCategories);
        MacroStore.resetEnabledMacroList();
        Iterator it = hashSet.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            for (Macro macro2 : MacroStore.getInstance().getAllCompletedMacros()) {
                if (Intrinsics.areEqual(macro2.getCategory(), str)) {
                    macro2.isEnabled();
                    if (macro2.isEnabled()) {
                        MacroStore.getInstance().disableMacroAndUpdate(macro2, true);
                        macro2.setEnabledFlag(true);
                        z3 = true;
                    }
                }
            }
            EventBusUtils.getEventBus().post(new CategoryEnabledStateChangeEvent(str, false));
        }
        return z3;
    }

    public final ExtraPackage f(DocumentSnapshot documentSnapshot) {
        String str;
        Map<String, Object> data = documentSnapshot.getData();
        if (data != null) {
            if (com.arlosoft.macrodroid.settings.Settings.getUseExtraBetaChannel(this.f12047a)) {
                str = "betaJsonData";
            } else {
                str = "jsonData";
            }
            try {
                return (ExtraPackage) GsonUtils.getGsonBuilder().create().fromJson(String.valueOf(data.get(str)), (Class<Object>) ExtraPackage.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final ExtrasViewState.Loaded g(boolean z3) {
        if (this.f12061o.getValue() instanceof ExtrasViewState.Loaded) {
            ExtrasViewState value = this.f12061o.getValue();
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.arlosoft.macrodroid.extras.data.ExtrasViewState.Loaded");
            return (ExtrasViewState.Loaded) value;
        } else if (z3) {
            return this.f12062p;
        } else {
            return null;
        }
    }

    static /* synthetic */ ExtrasViewState.Loaded h(StopClubViewModel stopClubViewModel, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        return stopClubViewModel.g(z3);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(com.arlosoft.macrodroid.extras.data.ExtraPackage r19, boolean r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r21
            boolean r2 = r1 instanceof com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel.c
            if (r2 == 0) goto L17
            r2 = r1
            com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel$c r2 = (com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel.c) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel$c r2 = new com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel$c
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L41
            if (r4 != r5) goto L39
            boolean r3 = r2.Z$0
            java.lang.Object r4 = r2.L$1
            com.arlosoft.macrodroid.extras.data.ExtraPackage r4 = (com.arlosoft.macrodroid.extras.data.ExtraPackage) r4
            java.lang.Object r2 = r2.L$0
            com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel r2 = (com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r14 = r3
            r5 = r4
            goto L64
        L39:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L41:
            kotlin.ResultKt.throwOnFailure(r1)
            com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase r1 = r0.f12049c
            com.arlosoft.macrodroid.database.room.ExtraInstalledDao r1 = r1.extraInstalledDao()
            java.lang.String r4 = r19.getId()
            r2.L$0 = r0
            r6 = r19
            r2.L$1 = r6
            r7 = r20
            r2.Z$0 = r7
            r2.label = r5
            java.lang.Object r1 = r1.getInstalledExtraById(r4, r2)
            if (r1 != r3) goto L61
            return r3
        L61:
            r2 = r0
            r5 = r6
            r14 = r7
        L64:
            com.arlosoft.macrodroid.database.room.ExtraInstalled r1 = (com.arlosoft.macrodroid.database.room.ExtraInstalled) r1
            com.arlosoft.macrodroid.extras.ui.management.ExtrasManager r3 = r2.f12048b
            java.lang.String r4 = r5.getId()
            boolean r3 = r3.isExtraInstalled(r4)
            com.arlosoft.macrodroid.remoteconfig.RemoteConfig r4 = r2.f12050d
            java.lang.String r6 = r5.getId()
            com.arlosoft.macrodroid.remoteconfig.ExtraMinVersion r6 = r4.getExtraMinVersion(r6)
            int r4 = r6.getVersionCode()
            r2.d(r5, r4)
            com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState r15 = new com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState
            r7 = 0
            r8 = 0
            r9 = 0
            r4 = 0
            if (r3 == 0) goto L95
            if (r1 == 0) goto L95
            int r1 = r1.getVersionCode()
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r10 = r1
            goto L96
        L95:
            r10 = r4
        L96:
            r11 = 0
            r12 = 0
            r13 = 0
            com.arlosoft.macrodroid.extras.ui.management.ExtrasManager r1 = r2.f12048b
            boolean r1 = r1.getActiveState()
            r16 = 448(0x1c0, float:6.28E-43)
            r17 = 0
            r4 = r15
            r3 = r15
            r15 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.add(r3)
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto Lbf
            androidx.lifecycle.MutableLiveData<com.arlosoft.macrodroid.extras.data.ExtrasViewState> r1 = r2.f12060n
            com.arlosoft.macrodroid.extras.data.ExtrasViewState$Error r2 = com.arlosoft.macrodroid.extras.data.ExtrasViewState.Error.INSTANCE
            r1.postValue(r2)
            goto Lca
        Lbf:
            com.arlosoft.macrodroid.extras.data.ExtrasViewState$Loaded r1 = new com.arlosoft.macrodroid.extras.data.ExtrasViewState$Loaded
            r1.<init>(r3)
            r2.n(r1)
            r2.j(r3)
        Lca:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel.i(com.arlosoft.macrodroid.extras.data.ExtraPackage, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void j(ExtraPackageWithPriceAndState extraPackageWithPriceAndState) {
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), null, null, new d(extraPackageWithPriceAndState, null), 3, null);
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), null, null, new e(extraPackageWithPriceAndState, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object k(java.lang.String r5, kotlin.jvm.functions.Function1<? super com.arlosoft.macrodroid.upgrade.billing.SubscriptionPrice, kotlin.Unit> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel.i
            if (r0 == 0) goto L13
            r0 = r7
            com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel$i r0 = (com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel.i) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel$i r0 = new com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel$i
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel r5 = (com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel) r5
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L5d
            goto L64
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource r7 = r4.f12054h     // Catch: java.lang.Exception -> L5c
            com.arlosoft.macrodroid.confirmation.PremiumStatusHandler r2 = r4.f12053g     // Catch: java.lang.Exception -> L5c
            com.arlosoft.macrodroid.confirmation.PremiumStatus r2 = r2.getPremiumStatus()     // Catch: java.lang.Exception -> L5c
            boolean r2 = r2.isPro()     // Catch: java.lang.Exception -> L5c
            kotlinx.coroutines.flow.Flow r5 = r7.getSkuSubscriptionPrice(r5, r2)     // Catch: java.lang.Exception -> L5c
            kotlinx.coroutines.flow.Flow r5 = kotlinx.coroutines.flow.FlowKt.take(r5, r3)     // Catch: java.lang.Exception -> L5c
            com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel$j r7 = new com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel$j     // Catch: java.lang.Exception -> L5c
            r7.<init>(r6)     // Catch: java.lang.Exception -> L5c
            r0.L$0 = r4     // Catch: java.lang.Exception -> L5c
            r0.label = r3     // Catch: java.lang.Exception -> L5c
            java.lang.Object r5 = r5.collect(r7, r0)     // Catch: java.lang.Exception -> L5c
            if (r5 != r1) goto L64
            return r1
        L5c:
            r5 = r4
        L5d:
            androidx.lifecycle.MutableLiveData<com.arlosoft.macrodroid.extras.data.ExtrasViewState> r5 = r5.f12060n
            com.arlosoft.macrodroid.extras.data.ExtrasViewState$Error r6 = com.arlosoft.macrodroid.extras.data.ExtrasViewState.Error.INSTANCE
            r5.postValue(r6)
        L64:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel.k(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void m(StopClubViewModel this$0, Exception exception) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(exception, "exception");
        this$0.f12060n.postValue(ExtrasViewState.Error.INSTANCE);
    }

    public final void n(ExtrasViewState.Loaded loaded) {
        this.f12062p = loaded;
        this.f12060n.postValue(loaded);
    }

    public final void onExtraSubscriptionIsActive(ExtraPackage extraPackage, String str, String str2, boolean z3) {
        this.f12048b.registerDeviceId(ExtrasManager.Companion.getExtrasCollection(), BillingModuleKt.SKU_STOPCLUB_SUB);
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), null, null, new g(z3, this, extraPackage, str, str2, null), 3, null);
    }

    public final void onExtraSubscriptionIsNotActive(ExtraPackage extraPackage) {
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), null, null, new h(extraPackage, null), 3, null);
    }

    public static /* synthetic */ void refresh$default(StopClubViewModel stopClubViewModel, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        stopClubViewModel.refresh(z3);
    }

    public static /* synthetic */ void refreshWithLoadingState$default(StopClubViewModel stopClubViewModel, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        stopClubViewModel.refreshWithLoadingState(z3);
    }

    public final void activateMacroSet(@NotNull ExtraPackage extraPackage, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(extraPackage, "extraPackage");
        ExtrasViewState.Loaded h4 = h(this, false, 1, null);
        if (h4 != null) {
            this.f12060n.postValue(h4.copy(ExtraPackageWithPriceAndState.copy$default(h4.getExtra(), null, null, null, null, null, null, null, ValidationState.VALIDATING, null, false, false, 1919, null)));
        }
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new a(extraPackage, z3, z4, null), 2, null);
    }

    @NotNull
    public final LiveData<SubscriptionPrice> getMonthlyPrice() {
        return this.f12068v;
    }

    @NotNull
    public final SingleLiveEvent<Unit> getScrollToTopEvent() {
        return this.f12059m;
    }

    @NotNull
    public final SingleLiveEvent<Unit> getShowCategoriesDisabledWarning() {
        return this.f12058l;
    }

    @NotNull
    public final SingleLiveEvent<ExtraPackageWithPriceAndState> getUpdateFailedEvent() {
        return this.f12055i;
    }

    @NotNull
    public final SingleLiveEvent<String> getUpdateInstalledEvent() {
        return this.f12057k;
    }

    @NotNull
    public final SingleLiveEvent<SubscriptionCheckStatus> getValidationFailedEvent() {
        return this.f12056j;
    }

    @NotNull
    public final LiveData<ExtrasViewState> getViewState() {
        return this.f12061o;
    }

    @NotNull
    public final LiveData<SubscriptionPrice> getWeeklyPrice() {
        return this.f12066t;
    }

    @NotNull
    public final LiveData<SubscriptionPrice> getYearlyPrice() {
        return this.f12070x;
    }

    public final void installVersionUpdate(@NotNull ExtraPackageWithPriceAndState extraPackage) {
        Intrinsics.checkNotNullParameter(extraPackage, "extraPackage");
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new f(extraPackage, null), 2, null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.d.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.d.b(this, lifecycleOwner);
    }

    public final void onMacroShortcutClicked(@NotNull String macroName) {
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        Macro macroByName = MacroStore.getInstance().getMacroByName(macroName);
        if (macroByName != null && macroByName.isExtra()) {
            macroByName.setTriggerThatInvoked(InvokedByRunMacroTrigger.getInstance());
            TriggerContextInfo triggerContextInfo = new TriggerContextInfo(macroByName.getTriggerThatInvoked());
            triggerContextInfo.setTrigger(InvokedByRunMacroTrigger.getInstance());
            macroByName.invokeActions(triggerContextInfo, true);
            return;
        }
        ToastCompat.makeText(this.f12047a, (int) R.string.macro_not_found, 1).show();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.d.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.d.d(this, lifecycleOwner);
    }

    public final void onRetryClicked() {
        refresh$default(this, false, 1, null);
    }

    public final void onSetupRequired() {
        if (this.f12048b.getActiveState()) {
            this.f12048b.setActiveState(false);
            ExtrasViewState.Loaded h4 = h(this, false, 1, null);
            if (h4 != null) {
                this.f12060n.setValue(h4.copy(ExtraPackageWithPriceAndState.copy$default(h4.getExtra(), null, null, null, null, null, null, null, null, null, false, false, Place.TYPE_SUBLOCALITY_LEVEL_1, null)));
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.d.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.d.f(this, lifecycleOwner);
    }

    public final void refresh(boolean z3) {
        String lowerCase = CountryCodeUtil.INSTANCE.getDetectedCountry(this.f12047a, "br").toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        Task<DocumentSnapshot> task = this.f12063q.collection(ExtrasManager.Companion.getExtrasCollection()).document(BillingModuleKt.SKU_STOPCLUB_SUB).collection("countries").document(lowerCase).get(Source.DEFAULT);
        final k kVar = new k(z3);
        task.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.extras.stopclub.viewmodel.a
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                StopClubViewModel.l(Function1.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.extras.stopclub.viewmodel.b
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                StopClubViewModel.m(StopClubViewModel.this, exc);
            }
        });
    }

    public final void refreshWithLoadingState(boolean z3) {
        refresh(z3);
        this.f12060n.postValue(ExtrasViewState.Loading.INSTANCE);
    }

    public final void removeBeta() {
        com.arlosoft.macrodroid.settings.Settings.setUseExtraBetaChannel(this.f12047a, false);
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), null, null, new l(null), 3, null);
    }

    public final void resetPackage() {
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), null, null, new m(null), 3, null);
    }

    public final void setActiveState(boolean z3) {
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), null, null, new n(z3, null), 3, null);
    }
}
