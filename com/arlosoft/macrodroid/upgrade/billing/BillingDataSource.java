package com.arlosoft.macrodroid.upgrade.billing;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.work.PeriodicWorkRequest;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.arlosoft.macrodroid.confirmation.PurchaseValidator;
import com.arlosoft.macrodroid.confirmation.validation.ExtraSubscriptionData;
import com.arlosoft.macrodroid.confirmation.validation.ExtraSubscriptions;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BillingDataSource.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nBillingDataSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BillingDataSource.kt\ncom/arlosoft/macrodroid/upgrade/billing/BillingDataSource\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,986:1\n47#2:987\n49#2:991\n47#2:992\n49#2:996\n47#2:997\n49#2:1001\n47#2:1002\n49#2:1006\n54#2:1007\n57#2:1011\n54#2:1012\n57#2:1016\n54#2:1022\n57#2:1026\n54#2:1027\n57#2:1031\n50#3:988\n55#3:990\n50#3:993\n55#3:995\n50#3:998\n55#3:1000\n50#3:1003\n55#3:1005\n50#3:1008\n55#3:1010\n50#3:1013\n55#3:1015\n50#3:1023\n55#3:1025\n50#3:1028\n55#3:1030\n106#4:989\n106#4:994\n106#4:999\n106#4:1004\n106#4:1009\n106#4:1014\n106#4:1024\n106#4:1029\n288#5,2:1017\n288#5,2:1020\n1549#5:1032\n1620#5,3:1033\n1549#5:1036\n1620#5,3:1037\n350#5,7:1040\n1#6:1019\n*S KotlinDebug\n*F\n+ 1 BillingDataSource.kt\ncom/arlosoft/macrodroid/upgrade/billing/BillingDataSource\n*L\n184#1:987\n184#1:991\n225#1:992\n225#1:996\n236#1:997\n236#1:1001\n243#1:1002\n243#1:1006\n274#1:1007\n274#1:1011\n281#1:1012\n281#1:1016\n310#1:1022\n310#1:1026\n351#1:1027\n351#1:1031\n184#1:988\n184#1:990\n225#1:993\n225#1:995\n236#1:998\n236#1:1000\n243#1:1003\n243#1:1005\n274#1:1008\n274#1:1010\n281#1:1013\n281#1:1015\n310#1:1023\n310#1:1025\n351#1:1028\n351#1:1030\n184#1:989\n225#1:994\n236#1:999\n243#1:1004\n274#1:1009\n281#1:1014\n310#1:1024\n351#1:1029\n297#1:1017,2\n300#1:1020,2\n467#1:1032\n467#1:1033,3\n484#1:1036\n484#1:1037,3\n806#1:1040,7\n*E\n"})
/* loaded from: classes3.dex */
public final class BillingDataSource implements LifecycleObserver, PurchasesUpdatedListener, BillingClientStateListener {
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private static volatile BillingDataSource f15917q;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Application f15919a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineScope f15920b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f15921c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f15922d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f15923e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final PurchaseValidator f15924f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final BillingClient f15925g;

    /* renamed from: h  reason: collision with root package name */
    private long f15926h;

    /* renamed from: i  reason: collision with root package name */
    private long f15927i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, MutableStateFlow<a>> f15928j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final Map<String, MutableStateFlow<ProductDetails>> f15929k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final Set<Purchase> f15930l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final MutableSharedFlow<List<String>> f15931m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final MutableSharedFlow<List<String>> f15932n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final MutableStateFlow<Boolean> f15933o;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private static final String f15916p = "TrivialDrive:" + BillingDataSource.class.getSimpleName();
    @NotNull

    /* renamed from: r  reason: collision with root package name */
    private static final Handler f15918r = new Handler(Looper.getMainLooper());

    /* compiled from: BillingDataSource.kt */
    @SourceDebugExtension({"SMAP\nBillingDataSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BillingDataSource.kt\ncom/arlosoft/macrodroid/upgrade/billing/BillingDataSource$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,986:1\n1#2:987\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final BillingDataSource getInstance(@NotNull Application application, @NotNull CoroutineScope defaultScope, @NotNull List<String> knownInappSKUs, @NotNull List<String> autoConsumeSKUs, @NotNull List<String> subscriptionSKUS, @NotNull PurchaseValidator purchaseValidator) {
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(defaultScope, "defaultScope");
            Intrinsics.checkNotNullParameter(knownInappSKUs, "knownInappSKUs");
            Intrinsics.checkNotNullParameter(autoConsumeSKUs, "autoConsumeSKUs");
            Intrinsics.checkNotNullParameter(subscriptionSKUS, "subscriptionSKUS");
            Intrinsics.checkNotNullParameter(purchaseValidator, "purchaseValidator");
            BillingDataSource billingDataSource = BillingDataSource.f15917q;
            if (billingDataSource == null) {
                synchronized (this) {
                    billingDataSource = BillingDataSource.f15917q;
                    if (billingDataSource == null) {
                        billingDataSource = new BillingDataSource(application, defaultScope, knownInappSKUs, autoConsumeSKUs, subscriptionSKUS, purchaseValidator);
                        BillingDataSource.f15917q = billingDataSource;
                    }
                }
            }
            return billingDataSource;
        }
    }

    /* compiled from: BillingDataSource.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class OfferDetailsWithProState {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ProductDetails.SubscriptionOfferDetails f15954a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f15955b;

        public OfferDetailsWithProState(@NotNull ProductDetails.SubscriptionOfferDetails offerDetails, boolean z3) {
            Intrinsics.checkNotNullParameter(offerDetails, "offerDetails");
            this.f15954a = offerDetails;
            this.f15955b = z3;
        }

        public static /* synthetic */ OfferDetailsWithProState copy$default(OfferDetailsWithProState offerDetailsWithProState, ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails, boolean z3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                subscriptionOfferDetails = offerDetailsWithProState.f15954a;
            }
            if ((i4 & 2) != 0) {
                z3 = offerDetailsWithProState.f15955b;
            }
            return offerDetailsWithProState.copy(subscriptionOfferDetails, z3);
        }

        @NotNull
        public final ProductDetails.SubscriptionOfferDetails component1() {
            return this.f15954a;
        }

        public final boolean component2() {
            return this.f15955b;
        }

        @NotNull
        public final OfferDetailsWithProState copy(@NotNull ProductDetails.SubscriptionOfferDetails offerDetails, boolean z3) {
            Intrinsics.checkNotNullParameter(offerDetails, "offerDetails");
            return new OfferDetailsWithProState(offerDetails, z3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OfferDetailsWithProState)) {
                return false;
            }
            OfferDetailsWithProState offerDetailsWithProState = (OfferDetailsWithProState) obj;
            if (Intrinsics.areEqual(this.f15954a, offerDetailsWithProState.f15954a) && this.f15955b == offerDetailsWithProState.f15955b) {
                return true;
            }
            return false;
        }

        @NotNull
        public final ProductDetails.SubscriptionOfferDetails getOfferDetails() {
            return this.f15954a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.f15954a.hashCode() * 31;
            boolean z3 = this.f15955b;
            int i4 = z3;
            if (z3 != 0) {
                i4 = 1;
            }
            return hashCode + i4;
        }

        public final boolean isProOnlyOffer() {
            return this.f15955b;
        }

        @NotNull
        public String toString() {
            ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails = this.f15954a;
            boolean z3 = this.f15955b;
            return "OfferDetailsWithProState(offerDetails=" + subscriptionOfferDetails + ", isProOnlyOffer=" + z3 + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BillingDataSource.kt */
    /* loaded from: classes3.dex */
    public enum a {
        SKU_STATE_UNKNOWN,
        SKU_STATE_UNPURCHASED,
        SKU_STATE_PENDING,
        SKU_STATE_PURCHASED,
        SKU_STATE_PURCHASED_AND_ACKNOWLEDGED,
        SKU_STATE_FAILED_VALIDATION,
        SKU_STATE_VALIDATING
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BillingDataSource.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Nullable
        public final Object a(boolean z3, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(Boolean.valueOf(z3), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            b bVar = new b(continuation);
            bVar.Z$0 = ((Boolean) obj).booleanValue();
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo1invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
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
                if (this.Z$0 && SystemClock.elapsedRealtime() - BillingDataSource.this.f15927i > 14400000) {
                    BillingDataSource.this.f15927i = SystemClock.elapsedRealtime();
                    String unused = BillingDataSource.f15916p;
                    BillingDataSource billingDataSource = BillingDataSource.this;
                    this.label = 1;
                    if (billingDataSource.k(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: BillingDataSource.kt */
    /* loaded from: classes3.dex */
    static final class c extends SuspendLambda implements Function3<a, ProductDetails, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        c(Continuation<? super c> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull a aVar, @Nullable ProductDetails productDetails, @Nullable Continuation<? super Boolean> continuation) {
            c cVar = new c(continuation);
            cVar.L$0 = aVar;
            cVar.L$1 = productDetails;
            return cVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z3;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                a aVar = (a) this.L$0;
                ProductDetails productDetails = (ProductDetails) this.L$1;
                if ((aVar == a.SKU_STATE_UNKNOWN || aVar == a.SKU_STATE_UNPURCHASED) && productDetails != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                return Boxing.boxBoolean(z3);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BillingDataSource.kt */
    /* loaded from: classes3.dex */
    public static final class d extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BillingDataSource.this.c(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BillingDataSource.kt */
    /* loaded from: classes3.dex */
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Purchase $purchase;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Purchase purchase, Continuation<? super e> continuation) {
            super(2, continuation);
            this.$purchase = purchase;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new e(this.$purchase, continuation);
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
                MutableSharedFlow mutableSharedFlow = BillingDataSource.this.f15932n;
                ArrayList<String> skus = this.$purchase.getSkus();
                Intrinsics.checkNotNullExpressionValue(skus, "purchase.skus");
                this.label = 1;
                if (mutableSharedFlow.emit(skus, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
    /* compiled from: BillingDataSource.kt */
    /* loaded from: classes3.dex */
    public static final class f extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BillingDataSource.this.e(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BillingDataSource.kt */
    /* loaded from: classes3.dex */
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ BillingFlowParams.Builder $billingFlowParamsBuilder;
        final /* synthetic */ String $sku;
        final /* synthetic */ String[] $upgradeSkus;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BillingDataSource.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Activity $activity;
            final /* synthetic */ String $sku;
            int label;
            final /* synthetic */ BillingDataSource this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(BillingDataSource billingDataSource, Activity activity, String str, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = billingDataSource;
                this.$activity = activity;
                this.$sku = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, this.$activity, this.$sku, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.f(this.$activity, this.$sku);
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
        g(String[] strArr, BillingFlowParams.Builder builder, Activity activity, String str, Continuation<? super g> continuation) {
            super(2, continuation);
            this.$upgradeSkus = strArr;
            this.$billingFlowParamsBuilder = builder;
            this.$activity = activity;
            this.$sku = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new g(this.$upgradeSkus, this.$billingFlowParamsBuilder, this.$activity, this.$sku, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2 && i4 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                BillingDataSource billingDataSource = BillingDataSource.this;
                String[] strArr = this.$upgradeSkus;
                this.label = 1;
                obj = billingDataSource.e(strArr, "subs", this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            List list = (List) obj;
            int size = list.size();
            if (size != 0) {
                if (size != 1) {
                    String str = BillingDataSource.f15916p;
                    int size2 = list.size();
                    Log.e(str, size2 + " subscriptions subscribed to. Upgrade not possible.");
                } else {
                    this.$billingFlowParamsBuilder.setSubscriptionUpdateParams(BillingFlowParams.SubscriptionUpdateParams.newBuilder().setOldSkuPurchaseToken(((Purchase) list.get(0)).getPurchaseToken()).build());
                }
            }
            BillingClient billingClient = BillingDataSource.this.f15925g;
            Activity activity = this.$activity;
            Intrinsics.checkNotNull(activity);
            BillingResult launchBillingFlow = billingClient.launchBillingFlow(activity, this.$billingFlowParamsBuilder.build());
            Intrinsics.checkNotNullExpressionValue(launchBillingFlow, "billingClient.launchBill…d()\n                    )");
            if (launchBillingFlow.getResponseCode() == 0) {
                MutableStateFlow mutableStateFlow = BillingDataSource.this.f15933o;
                Boolean boxBoolean = Boxing.boxBoolean(true);
                this.label = 2;
                if (mutableStateFlow.emit(boxBoolean, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                String debugMessage = launchBillingFlow.getDebugMessage();
                SystemLog.logDebug("Billing failed: + " + debugMessage);
                String str2 = BillingDataSource.f15916p;
                String debugMessage2 = launchBillingFlow.getDebugMessage();
                Log.e(str2, "Billing failed: + " + debugMessage2);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                a aVar = new a(BillingDataSource.this, this.$activity, this.$sku, null);
                this.label = 3;
                if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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

    /* compiled from: BillingDataSource.kt */
    /* loaded from: classes3.dex */
    static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        h(Continuation<? super h> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new h(continuation);
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
                BillingDataSource billingDataSource = BillingDataSource.this;
                this.label = 1;
                if (billingDataSource.k(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            BillingDataSource billingDataSource2 = BillingDataSource.this;
            this.label = 2;
            if (billingDataSource2.refreshPurchases(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: BillingDataSource.kt */
    /* loaded from: classes3.dex */
    static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        i(Continuation<? super i> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new i(continuation);
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
                MutableStateFlow mutableStateFlow = BillingDataSource.this.f15933o;
                Boolean boxBoolean = Boxing.boxBoolean(false);
                this.label = 1;
                if (mutableStateFlow.emit(boxBoolean, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((i) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BillingDataSource.kt */
    /* loaded from: classes3.dex */
    public static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.BooleanRef $isConsumable;
        final /* synthetic */ Purchase $purchase;
        int label;
        final /* synthetic */ BillingDataSource this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(Purchase purchase, BillingDataSource billingDataSource, Ref.BooleanRef booleanRef, Continuation<? super j> continuation) {
            super(2, continuation);
            this.$purchase = purchase;
            this.this$0 = billingDataSource;
            this.$isConsumable = booleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new j(this.$purchase, this.this$0, this.$isConsumable, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0109  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 593
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BillingDataSource.kt */
    /* loaded from: classes3.dex */
    public static final class k extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        k(Continuation<? super k> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BillingDataSource.this.k(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BillingDataSource.kt */
    /* loaded from: classes3.dex */
    public static final class l extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        l(Continuation<? super l> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BillingDataSource.this.refreshPurchases(this);
        }
    }

    /* compiled from: BillingDataSource.kt */
    /* loaded from: classes3.dex */
    static final class m extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        m(Continuation<? super m> continuation) {
            super(2, continuation);
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
                BillingDataSource billingDataSource = BillingDataSource.this;
                this.label = 1;
                if (billingDataSource.refreshPurchases(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((m) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public BillingDataSource(@NotNull Application application, @NotNull CoroutineScope defaultScope, @NotNull List<String> knownInappSKUs, @NotNull List<String> autoConsumeSKUs, @NotNull List<String> knownSubscriptionSKUs, @NotNull PurchaseValidator purchaseValidator) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(defaultScope, "defaultScope");
        Intrinsics.checkNotNullParameter(knownInappSKUs, "knownInappSKUs");
        Intrinsics.checkNotNullParameter(autoConsumeSKUs, "autoConsumeSKUs");
        Intrinsics.checkNotNullParameter(knownSubscriptionSKUs, "knownSubscriptionSKUs");
        Intrinsics.checkNotNullParameter(purchaseValidator, "purchaseValidator");
        this.f15919a = application;
        this.f15920b = defaultScope;
        this.f15921c = knownInappSKUs;
        this.f15922d = autoConsumeSKUs;
        this.f15923e = knownSubscriptionSKUs;
        this.f15924f = purchaseValidator;
        this.f15926h = 1000L;
        this.f15927i = -14400000L;
        this.f15928j = new HashMap();
        this.f15929k = new HashMap();
        this.f15930l = new HashSet();
        this.f15931m = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this.f15932n = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f15933o = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        g();
        BillingClient build = BillingClient.newBuilder(application).setListener(this).enablePendingPurchases().build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder(application)\n…\n                .build()");
        this.f15925g = build;
        build.startConnection(this);
    }

    private final void b(List<String> list) {
        Intrinsics.checkNotNull(list);
        for (String str : list) {
            MutableStateFlow<a> MutableStateFlow = StateFlowKt.MutableStateFlow(a.SKU_STATE_UNKNOWN);
            MutableStateFlow<ProductDetails> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
            final StateFlow<Integer> subscriptionCount = MutableStateFlow2.getSubscriptionCount();
            FlowKt.launchIn(FlowKt.onEach(FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$addSkuFlows$$inlined$map$1

                /* compiled from: Emitters.kt */
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 BillingDataSource.kt\ncom/arlosoft/macrodroid/upgrade/billing/BillingDataSource\n*L\n1#1,222:1\n48#2:223\n184#3:224\n*E\n"})
                /* renamed from: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$addSkuFlows$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ FlowCollector f15935a;

                    /* compiled from: Emitters.kt */
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                    /* renamed from: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$addSkuFlows$$inlined$map$1$2$1  reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.f15935a = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @org.jetbrains.annotations.Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$addSkuFlows$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$addSkuFlows$$inlined$map$1$2$1 r0 = (com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$addSkuFlows$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$addSkuFlows$$inlined$map$1$2$1 r0 = new com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$addSkuFlows$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L4e
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.f15935a
                            java.lang.Number r5 = (java.lang.Number) r5
                            int r5 = r5.intValue()
                            if (r5 <= 0) goto L40
                            r5 = 1
                            goto L41
                        L40:
                            r5 = 0
                        L41:
                            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L4e
                            return r1
                        L4e:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$addSkuFlows$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super Boolean> flowCollector, @NotNull Continuation continuation) {
                    Object coroutine_suspended;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                    coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            }), new b(null)), this.f15920b);
            this.f15928j.put(str, MutableStateFlow);
            this.f15929k.put(str, MutableStateFlow2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(com.android.billingclient.api.Purchase r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.d
            if (r0 == 0) goto L13
            r0 = r10
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$d r0 = (com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.d) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$d r0 = new com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$d
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r9 = r0.L$1
            com.android.billingclient.api.Purchase r9 = (com.android.billingclient.api.Purchase) r9
            java.lang.Object r0 = r0.L$0
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource r0 = (com.arlosoft.macrodroid.upgrade.billing.BillingDataSource) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L71
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.Set<com.android.billingclient.api.Purchase> r10 = r8.f15930l
            boolean r10 = r10.contains(r9)
            if (r10 == 0) goto L47
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L47:
            java.util.Set<com.android.billingclient.api.Purchase> r10 = r8.f15930l
            r10.add(r9)
            com.android.billingclient.api.BillingClient r10 = r8.f15925g
            com.android.billingclient.api.ConsumeParams$Builder r2 = com.android.billingclient.api.ConsumeParams.newBuilder()
            java.lang.String r4 = r9.getPurchaseToken()
            com.android.billingclient.api.ConsumeParams$Builder r2 = r2.setPurchaseToken(r4)
            com.android.billingclient.api.ConsumeParams r2 = r2.build()
            java.lang.String r4 = "newBuilder()\n           …                 .build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r10 = com.android.billingclient.api.BillingClientKotlinKt.consumePurchase(r10, r2, r0)
            if (r10 != r1) goto L70
            return r1
        L70:
            r0 = r8
        L71:
            com.android.billingclient.api.ConsumeResult r10 = (com.android.billingclient.api.ConsumeResult) r10
            java.util.Set<com.android.billingclient.api.Purchase> r1 = r0.f15930l
            r1.remove(r9)
            com.android.billingclient.api.BillingResult r1 = r10.getBillingResult()
            int r1 = r1.getResponseCode()
            if (r1 != 0) goto Lb0
            kotlinx.coroutines.CoroutineScope r2 = r0.f15920b
            r3 = 0
            r4 = 0
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$e r5 = new com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$e
            r10 = 0
            r5.<init>(r9, r10)
            r6 = 3
            r7 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r2, r3, r4, r5, r6, r7)
            java.util.ArrayList r9 = r9.getSkus()
            java.util.Iterator r9 = r9.iterator()
        L99:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto Lce
            java.lang.Object r10 = r9.next()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r1 = "sku"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r1)
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$a r1 = com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.a.SKU_STATE_UNPURCHASED
            r0.n(r10, r1)
            goto L99
        Lb0:
            java.lang.String r9 = com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.f15916p
            com.android.billingclient.api.BillingResult r10 = r10.getBillingResult()
            java.lang.String r10 = r10.getDebugMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error while consuming: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            android.util.Log.e(r9, r10)
        Lce:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.c(com.android.billingclient.api.Purchase, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OfferDetailsWithProState d(List<ProductDetails.SubscriptionOfferDetails> list, boolean z3) {
        Object obj;
        boolean z4;
        Object obj2;
        boolean z5;
        Object first;
        if (list == null) {
            return null;
        }
        if (list.size() == 1) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            return new OfferDetailsWithProState((ProductDetails.SubscriptionOfferDetails) first, false);
        } else if (list.size() <= 1) {
            return null;
        } else {
            if (z3) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj2 = it.next();
                        String offerId = ((ProductDetails.SubscriptionOfferDetails) obj2).getOfferId();
                        if (offerId != null) {
                            Intrinsics.checkNotNullExpressionValue(offerId, "offerId");
                            z5 = StringsKt__StringsKt.contains$default((CharSequence) offerId, (CharSequence) "existing-pro", false, 2, (Object) null);
                            continue;
                        } else {
                            z5 = false;
                            continue;
                        }
                        if (z5) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails = (ProductDetails.SubscriptionOfferDetails) obj2;
                if (subscriptionOfferDetails == null) {
                    return null;
                }
                return new OfferDetailsWithProState(subscriptionOfferDetails, true);
            }
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj = it2.next();
                    String offerId2 = ((ProductDetails.SubscriptionOfferDetails) obj).getOfferId();
                    if (offerId2 != null) {
                        Intrinsics.checkNotNullExpressionValue(offerId2, "offerId");
                        z4 = StringsKt__StringsKt.contains$default((CharSequence) offerId2, (CharSequence) "existing-pro", false, 2, (Object) null);
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails2 = (ProductDetails.SubscriptionOfferDetails) obj;
            if (subscriptionOfferDetails2 == null) {
                return null;
            }
            return new OfferDetailsWithProState(subscriptionOfferDetails2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(java.lang.String[] r7, java.lang.String r8, kotlin.coroutines.Continuation<? super java.util.List<? extends com.android.billingclient.api.Purchase>> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.f
            if (r0 == 0) goto L13
            r0 = r9
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$f r0 = (com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.f) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$f r0 = new com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$f
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.L$0
            java.lang.String[] r7 = (java.lang.String[]) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L45
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.throwOnFailure(r9)
            com.android.billingclient.api.BillingClient r9 = r6.f15925g
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r9 = com.android.billingclient.api.BillingClientKotlinKt.queryPurchasesAsync(r9, r8, r0)
            if (r9 != r1) goto L45
            return r1
        L45:
            com.android.billingclient.api.PurchasesResult r9 = (com.android.billingclient.api.PurchasesResult) r9
            com.android.billingclient.api.BillingResult r8 = r9.getBillingResult()
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            int r1 = r8.getResponseCode()
            if (r1 == 0) goto L71
            java.lang.String r7 = com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.f15916p
            java.lang.String r8 = r8.getDebugMessage()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "Problem getting purchases: "
            r9.append(r1)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            android.util.Log.e(r7, r8)
            goto Lac
        L71:
            java.util.List r8 = r9.getPurchasesList()
            java.util.Iterator r8 = r8.iterator()
        L79:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto Lac
            java.lang.Object r9 = r8.next()
            com.android.billingclient.api.Purchase r9 = (com.android.billingclient.api.Purchase) r9
            int r1 = r7.length
            r2 = 0
        L87:
            if (r2 >= r1) goto L79
            r3 = r7[r2]
            java.util.ArrayList r4 = r9.getSkus()
            java.util.Iterator r4 = r4.iterator()
        L93:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto La9
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r3)
            if (r5 == 0) goto L93
            r0.add(r9)
            goto L93
        La9:
            int r2 = r2 + 1
            goto L87
        Lac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.e(java.lang.String[], java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r3.equals(com.arlosoft.macrodroid.app.di.modules.BillingModuleKt.SKU_DONATION_2) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
        if (r3.equals(com.arlosoft.macrodroid.app.di.modules.BillingModuleKt.SKU_DONATION_1) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
        if (r3.equals(com.arlosoft.macrodroid.app.di.modules.BillingModuleKt.SKU_PREMIUM_NEW_2) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
        if (r3.equals("com.arlosoft.macrodroid.pro") == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
        if (r3.equals(com.arlosoft.macrodroid.app.di.modules.BillingModuleKt.SKU_PREMIUM_FLASH_SALE_2) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
        if (r3.equals(com.arlosoft.macrodroid.app.di.modules.BillingModuleKt.SKU_PREMIUM_FLASH_SALE) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
        r0.setTitle(r1.f15919a.getString(com.arlosoft.macrodroid.R.string.pro_upgrade_failed));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0065, code lost:
        if (r3.equals(com.arlosoft.macrodroid.app.di.modules.BillingModuleKt.SKU_DONATION_3) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
        r0.setTitle(r1.f15919a.getString(com.arlosoft.macrodroid.R.string.donation_failed));
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r3.equals(com.arlosoft.macrodroid.app.di.modules.BillingModuleKt.SKU_PREMIUM_NEW) == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(android.app.Activity r2, java.lang.String r3) {
        /*
            r1 = this;
            com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger.logUnableToPurchase(r3)
            if (r2 == 0) goto L97
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            r0.<init>(r2)
            int r2 = r3.hashCode()
            switch(r2) {
                case -2036336081: goto L5f;
                case -1557464622: goto L49;
                case -1036762976: goto L40;
                case -24621870: goto L37;
                case 929325926: goto L2e;
                case 1042694439: goto L25;
                case 1725480130: goto L1c;
                case 2108188236: goto L13;
                default: goto L11;
            }
        L11:
            goto L75
        L13:
            java.lang.String r2 = "com.arlosoft.macrodroid.pro.h"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L52
            goto L75
        L1c:
            java.lang.String r2 = "donation_medium"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L68
            goto L75
        L25:
            java.lang.String r2 = "donation_low"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L68
            goto L75
        L2e:
            java.lang.String r2 = "com.arlosoft.macrodroid.pro.h2"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L52
            goto L75
        L37:
            java.lang.String r2 = "com.arlosoft.macrodroid.pro"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L52
            goto L75
        L40:
            java.lang.String r2 = "com.arlosoft.macrodroid.pro.flash_sale2"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L52
            goto L75
        L49:
            java.lang.String r2 = "com.arlosoft.macrodroid.pro.flash_sale"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L52
            goto L75
        L52:
            android.app.Application r2 = r1.f15919a
            r3 = 2131954854(0x7f130ca6, float:1.9546219E38)
            java.lang.String r2 = r2.getString(r3)
            r0.setTitle(r2)
            goto L81
        L5f:
            java.lang.String r2 = "donation_high"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L68
            goto L75
        L68:
            android.app.Application r2 = r1.f15919a
            r3 = 2131953189(0x7f130625, float:1.9542842E38)
            java.lang.String r2 = r2.getString(r3)
            r0.setTitle(r2)
            goto L81
        L75:
            android.app.Application r2 = r1.f15919a
            r3 = 2131953315(0x7f1306a3, float:1.9543098E38)
            java.lang.String r2 = r2.getString(r3)
            r0.setTitle(r2)
        L81:
            android.app.Application r2 = r1.f15919a
            r3 = 2131956003(0x7f131123, float:1.954855E38)
            java.lang.String r2 = r2.getString(r3)
            r0.setMessage(r2)
            r2 = 17039370(0x104000a, float:2.42446E-38)
            r3 = 0
            r0.setPositiveButton(r2, r3)
            r0.show()
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.f(android.app.Activity, java.lang.String):void");
    }

    private final void g() {
        b(this.f15921c);
        b(this.f15923e);
    }

    @JvmStatic
    @NotNull
    public static final BillingDataSource getInstance(@NotNull Application application, @NotNull CoroutineScope coroutineScope, @NotNull List<String> list, @NotNull List<String> list2, @NotNull List<String> list3, @NotNull PurchaseValidator purchaseValidator) {
        return Companion.getInstance(application, coroutineScope, list, list2, list3, purchaseValidator);
    }

    private final boolean h(Purchase purchase) {
        return com.arlosoft.macrodroid.upgrade.billing.b.c(purchase.getOriginalJson(), purchase.getSignature());
    }

    private final void i(BillingResult billingResult, List<ProductDetails> list) {
        int responseCode = billingResult.getResponseCode();
        String debugMessage = billingResult.getDebugMessage();
        Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
        switch (responseCode) {
            case -2:
            case 7:
            case 8:
                String str = f15916p;
                Log.wtf(str, "onSkuDetailsResponse: " + responseCode + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + debugMessage);
                break;
            case -1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                String str2 = f15916p;
                Log.e(str2, "onSkuDetailsResponse: " + responseCode + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + debugMessage);
                break;
            case 0:
                String str3 = f15916p;
                Log.i(str3, "onSkuDetailsResponse: " + responseCode + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + debugMessage);
                if (list != null && !list.isEmpty()) {
                    for (ProductDetails productDetails : list) {
                        String productId = productDetails.getProductId();
                        Intrinsics.checkNotNullExpressionValue(productId, "productDetails.productId");
                        MutableStateFlow<ProductDetails> mutableStateFlow = this.f15929k.get(productId);
                        if (mutableStateFlow != null) {
                            mutableStateFlow.tryEmit(productDetails);
                        } else {
                            String str4 = f15916p;
                            Log.e(str4, "Unknown sku: " + productId);
                        }
                    }
                    break;
                } else {
                    Log.e(str3, "onSkuDetailsResponse: Found null or empty SkuDetails. Check to see if the SKUs you requested are correctly published in the Google Play Console.");
                    break;
                }
                break;
            case 1:
                String str5 = f15916p;
                Log.i(str5, "onSkuDetailsResponse: " + responseCode + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + debugMessage);
                break;
            default:
                String str6 = f15916p;
                Log.wtf(str6, "onSkuDetailsResponse: " + responseCode + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + debugMessage);
                break;
        }
        if (responseCode == 0) {
            this.f15927i = SystemClock.elapsedRealtime();
        } else {
            this.f15927i = -14400000L;
        }
    }

    private final void j(List<? extends Purchase> list, List<String> list2) {
        HashSet hashSet = new HashSet();
        if (list != null) {
            for (Purchase purchase : list) {
                Iterator<String> it = purchase.getSkus().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (this.f15928j.get(next) == null) {
                        String str = f15916p;
                        Log.e(str, "Unknown SKU " + next + ". Check to make sure SKU matches SKUS in the Play developer console.");
                    } else {
                        hashSet.add(next);
                    }
                }
                if (purchase.getPurchaseState() == 1) {
                    if (!h(purchase)) {
                        Log.e(f15916p, "Invalid signature. Check to make sure your public key is correct.");
                    } else {
                        o(purchase);
                        kotlinx.coroutines.e.e(this.f15920b, null, null, new j(purchase, this, new Ref.BooleanRef(), null), 3, null);
                    }
                } else {
                    o(purchase);
                }
            }
        }
        if (list2 != null) {
            for (String str2 : list2) {
                if (!hashSet.contains(str2)) {
                    n(str2, a.SKU_STATE_UNPURCHASED);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object k(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.k(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void l() {
        f15918r.postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.upgrade.billing.a
            @Override // java.lang.Runnable
            public final void run() {
                BillingDataSource.m(BillingDataSource.this);
            }
        }, this.f15926h);
        this.f15926h = Math.min(this.f15926h * 2, (long) PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS);
    }

    public static /* synthetic */ void launchBillingFlow$default(BillingDataSource billingDataSource, Activity activity, String str, String[] strArr, boolean z3, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            z3 = false;
        }
        billingDataSource.launchBillingFlow(activity, str, strArr, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(BillingDataSource this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.f15925g.endConnection();
        } catch (Exception unused) {
        }
        this$0.f15925g.startConnection(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String str, a aVar) {
        MutableStateFlow<a> mutableStateFlow = this.f15928j.get(str);
        if (mutableStateFlow != null) {
            mutableStateFlow.tryEmit(aVar);
            return;
        }
        String str2 = f15916p;
        Log.e(str2, "Unknown SKU " + str + ". Check to make sure SKU matches SKUS in the Play developer console.");
    }

    private final void o(Purchase purchase) {
        String str;
        Iterator<String> it = purchase.getSkus().iterator();
        while (it.hasNext()) {
            String next = it.next();
            MutableStateFlow<a> mutableStateFlow = this.f15928j.get(next);
            if (mutableStateFlow == null) {
                String str2 = f15916p;
                Log.e(str2, "Unknown SKU " + next + ". Check to make sure SKU matches SKUS in the Play developer console.");
            } else {
                int purchaseState = purchase.getPurchaseState();
                if (purchaseState != 0) {
                    if (purchaseState != 1) {
                        if (purchaseState != 2) {
                            String str3 = f15916p;
                            int purchaseState2 = purchase.getPurchaseState();
                            Log.e(str3, "Purchase in unknown state: " + purchaseState2);
                        } else {
                            mutableStateFlow.tryEmit(a.SKU_STATE_PENDING);
                        }
                    } else if (purchase.isAcknowledged()) {
                        ArrayList<String> skus = purchase.getSkus();
                        Intrinsics.checkNotNullExpressionValue(skus, "purchase.skus");
                        if ((!skus.isEmpty()) && this.f15923e.contains(purchase.getSkus().get(0))) {
                            ExtraSubscriptions extraSubscriptions = Settings.getExtraSubscriptions(this.f15919a);
                            if (extraSubscriptions == null) {
                                extraSubscriptions = new ExtraSubscriptions(new LinkedHashMap());
                            }
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            String sku = purchase.getSkus().get(0);
                            PurchaseValidator purchaseValidator = this.f15924f;
                            Intrinsics.checkNotNullExpressionValue(sku, "sku");
                            String validationCode = purchaseValidator.getValidationCode(sku);
                            ExtraSubscriptionData extraSubscriptionData = extraSubscriptions.getMap().get(sku);
                            if (extraSubscriptionData != null) {
                                str = extraSubscriptionData.getValidationCode();
                            } else {
                                str = null;
                            }
                            if (Intrinsics.areEqual(str, validationCode)) {
                                mutableStateFlow.tryEmit(a.SKU_STATE_PURCHASED_AND_ACKNOWLEDGED);
                            } else {
                                String purchaseToken = purchase.getPurchaseToken();
                                Intrinsics.checkNotNullExpressionValue(purchaseToken, "purchase.purchaseToken");
                                String orderId = purchase.getOrderId();
                                Intrinsics.checkNotNullExpressionValue(orderId, "purchase.orderId");
                                linkedHashMap.put(sku, new ExtraSubscriptionData(sku, purchaseToken, orderId, validationCode));
                                Settings.setExtraSubscriptions(this.f15919a, new ExtraSubscriptions(linkedHashMap));
                                n(sku, a.SKU_STATE_PURCHASED_AND_ACKNOWLEDGED);
                            }
                        } else {
                            Settings.setOrderId(this.f15919a, purchase.getOrderId());
                            Settings.setPurchaseToken(this.f15919a, purchase.getPurchaseToken());
                            Settings.setPurchaseSku(this.f15919a, next);
                            mutableStateFlow.tryEmit(a.SKU_STATE_PURCHASED_AND_ACKNOWLEDGED);
                        }
                    } else {
                        mutableStateFlow.tryEmit(a.SKU_STATE_PURCHASED);
                    }
                } else {
                    mutableStateFlow.tryEmit(a.SKU_STATE_UNPURCHASED);
                }
            }
        }
    }

    @NotNull
    public final Flow<Boolean> canPurchase(@NotNull String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        MutableStateFlow<ProductDetails> mutableStateFlow = this.f15929k.get(sku);
        Intrinsics.checkNotNull(mutableStateFlow);
        MutableStateFlow<a> mutableStateFlow2 = this.f15928j.get(sku);
        Intrinsics.checkNotNull(mutableStateFlow2);
        return FlowKt.flowCombine(mutableStateFlow2, mutableStateFlow, new c(null));
    }

    @NotNull
    public final Flow<Boolean> getBillingFlowInProcess() {
        return FlowKt.asStateFlow(this.f15933o);
    }

    @NotNull
    public final SharedFlow<List<String>> getConsumedPurchases() {
        return FlowKt.asSharedFlow(this.f15932n);
    }

    @NotNull
    public final SharedFlow<List<String>> getNewPurchases() {
        return FlowKt.asSharedFlow(this.f15931m);
    }

    @NotNull
    public final Flow<String> getSkuDescription(@NotNull String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        MutableStateFlow<ProductDetails> mutableStateFlow = this.f15929k.get(sku);
        Intrinsics.checkNotNull(mutableStateFlow);
        final MutableStateFlow<ProductDetails> mutableStateFlow2 = mutableStateFlow;
        return new Flow<String>() { // from class: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuDescription$$inlined$mapNotNull$1

            /* compiled from: Emitters.kt */
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 BillingDataSource.kt\ncom/arlosoft/macrodroid/upgrade/billing/BillingDataSource\n*L\n1#1,222:1\n55#2:223\n56#2:225\n352#3:224\n*E\n"})
            /* renamed from: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuDescription$$inlined$mapNotNull$1$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ FlowCollector f15937a;

                /* compiled from: Emitters.kt */
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuDescription$$inlined$mapNotNull$1$2$1  reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f15937a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuDescription$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuDescription$$inlined$mapNotNull$1$2$1 r0 = (com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuDescription$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuDescription$$inlined$mapNotNull$1$2$1 r0 = new com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuDescription$$inlined$mapNotNull$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4b
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f15937a
                        com.android.billingclient.api.ProductDetails r5 = (com.android.billingclient.api.ProductDetails) r5
                        if (r5 == 0) goto L3f
                        java.lang.String r5 = r5.getDescription()
                        goto L40
                    L3f:
                        r5 = 0
                    L40:
                        if (r5 == 0) goto L4b
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4b
                        return r1
                    L4b:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuDescription$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super String> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public final Flow<String> getSkuPrice(@NotNull String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        MutableStateFlow<ProductDetails> mutableStateFlow = this.f15929k.get(sku);
        Intrinsics.checkNotNull(mutableStateFlow);
        final MutableStateFlow<ProductDetails> mutableStateFlow2 = mutableStateFlow;
        return new Flow<String>() { // from class: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuPrice$$inlined$mapNotNull$1

            /* compiled from: Emitters.kt */
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 BillingDataSource.kt\ncom/arlosoft/macrodroid/upgrade/billing/BillingDataSource\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,222:1\n55#2:223\n56#2:227\n282#3:224\n283#3:226\n1#4:225\n*E\n"})
            /* renamed from: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuPrice$$inlined$mapNotNull$1$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ FlowCollector f15939a;

                /* compiled from: Emitters.kt */
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuPrice$$inlined$mapNotNull$1$2$1  reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f15939a = flowCollector;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                /* JADX WARN: Type inference failed for: r7v11 */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuPrice$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuPrice$$inlined$mapNotNull$1$2$1 r0 = (com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuPrice$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuPrice$$inlined$mapNotNull$1$2$1 r0 = new com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuPrice$$inlined$mapNotNull$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L8f
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        kotlin.ResultKt.throwOnFailure(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.f15939a
                        com.android.billingclient.api.ProductDetails r7 = (com.android.billingclient.api.ProductDetails) r7
                        r2 = 0
                        if (r7 == 0) goto L84
                        java.lang.String r4 = r7.getProductType()
                        java.lang.String r5 = "inapp"
                        boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
                        if (r4 == 0) goto L53
                        com.android.billingclient.api.ProductDetails$OneTimePurchaseOfferDetails r7 = r7.getOneTimePurchaseOfferDetails()
                        if (r7 == 0) goto L84
                        java.lang.String r7 = r7.getFormattedPrice()
                    L51:
                        r2 = r7
                        goto L84
                    L53:
                        java.util.List r7 = r7.getSubscriptionOfferDetails()
                        if (r7 == 0) goto L84
                        java.lang.String r4 = "subscriptionOfferDetails"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
                        java.lang.Object r7 = kotlin.collections.CollectionsKt.firstOrNull(r7)
                        com.android.billingclient.api.ProductDetails$SubscriptionOfferDetails r7 = (com.android.billingclient.api.ProductDetails.SubscriptionOfferDetails) r7
                        if (r7 == 0) goto L84
                        com.android.billingclient.api.ProductDetails$PricingPhases r7 = r7.getPricingPhases()
                        if (r7 == 0) goto L84
                        java.util.List r7 = r7.getPricingPhaseList()
                        if (r7 == 0) goto L84
                        java.lang.String r4 = "pricingPhaseList"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
                        java.lang.Object r7 = kotlin.collections.CollectionsKt.firstOrNull(r7)
                        com.android.billingclient.api.ProductDetails$PricingPhase r7 = (com.android.billingclient.api.ProductDetails.PricingPhase) r7
                        if (r7 == 0) goto L84
                        java.lang.String r7 = r7.getFormattedPrice()
                        goto L51
                    L84:
                        if (r2 == 0) goto L8f
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r2, r0)
                        if (r7 != r1) goto L8f
                        return r1
                    L8f:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuPrice$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super String> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public final Flow<SubscriptionPrice> getSkuSubscriptionPrice(@NotNull String sku, final boolean z3) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        MutableStateFlow<ProductDetails> mutableStateFlow = this.f15929k.get(sku);
        Intrinsics.checkNotNull(mutableStateFlow);
        final MutableStateFlow<ProductDetails> mutableStateFlow2 = mutableStateFlow;
        return new Flow<SubscriptionPrice>() { // from class: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuSubscriptionPrice$$inlined$mapNotNull$1

            /* compiled from: Emitters.kt */
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 BillingDataSource.kt\ncom/arlosoft/macrodroid/upgrade/billing/BillingDataSource\n*L\n1#1,222:1\n55#2:223\n56#2:257\n311#3,33:224\n*E\n"})
            /* renamed from: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuSubscriptionPrice$$inlined$mapNotNull$1$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ FlowCollector f15943a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ BillingDataSource f15944b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ boolean f15945c;

                /* compiled from: Emitters.kt */
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuSubscriptionPrice$$inlined$mapNotNull$1$2$1  reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, BillingDataSource billingDataSource, boolean z3) {
                    this.f15943a = flowCollector;
                    this.f15944b = billingDataSource;
                    this.f15945c = z3;
                }

                /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
                    r4 = r20.f15944b.d(r4.getSubscriptionOfferDetails(), r20.f15945c);
                 */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
                /* JADX WARN: Type inference failed for: r7v23, types: [com.arlosoft.macrodroid.upgrade.billing.SubscriptionPrice$FreeTrialWithDiscount] */
                /* JADX WARN: Type inference failed for: r7v45, types: [com.arlosoft.macrodroid.upgrade.billing.SubscriptionPrice$StandardPrice] */
                /* JADX WARN: Type inference failed for: r8v15, types: [com.arlosoft.macrodroid.upgrade.billing.SubscriptionPrice$FreeTrialStandardPrice] */
                /* JADX WARN: Type inference failed for: r9v8, types: [com.arlosoft.macrodroid.upgrade.billing.SubscriptionPrice$DiscountedPrice] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r21, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r22) {
                    /*
                        Method dump skipped, instructions count: 551
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuSubscriptionPrice$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super SubscriptionPrice> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this, z3), continuation);
                coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public final Flow<String> getSkuTitle(@NotNull String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        MutableStateFlow<ProductDetails> mutableStateFlow = this.f15929k.get(sku);
        Intrinsics.checkNotNull(mutableStateFlow);
        final MutableStateFlow<ProductDetails> mutableStateFlow2 = mutableStateFlow;
        return new Flow<String>() { // from class: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuTitle$$inlined$mapNotNull$1

            /* compiled from: Emitters.kt */
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 BillingDataSource.kt\ncom/arlosoft/macrodroid/upgrade/billing/BillingDataSource\n*L\n1#1,222:1\n55#2:223\n56#2:225\n275#3:224\n*E\n"})
            /* renamed from: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuTitle$$inlined$mapNotNull$1$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ FlowCollector f15947a;

                /* compiled from: Emitters.kt */
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuTitle$$inlined$mapNotNull$1$2$1  reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f15947a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuTitle$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuTitle$$inlined$mapNotNull$1$2$1 r0 = (com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuTitle$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuTitle$$inlined$mapNotNull$1$2$1 r0 = new com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuTitle$$inlined$mapNotNull$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4b
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f15947a
                        com.android.billingclient.api.ProductDetails r5 = (com.android.billingclient.api.ProductDetails) r5
                        if (r5 == 0) goto L3f
                        java.lang.String r5 = r5.getTitle()
                        goto L40
                    L3f:
                        r5 = 0
                    L40:
                        if (r5 == 0) goto L4b
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4b
                        return r1
                    L4b:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$getSkuTitle$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super String> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public final Flow<Boolean> isFailedValidation(@NotNull String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        MutableStateFlow<a> mutableStateFlow = this.f15928j.get(sku);
        Intrinsics.checkNotNull(mutableStateFlow);
        final MutableStateFlow<a> mutableStateFlow2 = mutableStateFlow;
        return new Flow<Boolean>() { // from class: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isFailedValidation$$inlined$map$1

            /* compiled from: Emitters.kt */
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 BillingDataSource.kt\ncom/arlosoft/macrodroid/upgrade/billing/BillingDataSource\n*L\n1#1,222:1\n48#2:223\n244#3:224\n*E\n"})
            /* renamed from: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isFailedValidation$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ FlowCollector f15949a;

                /* compiled from: Emitters.kt */
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isFailedValidation$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f15949a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isFailedValidation$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isFailedValidation$$inlined$map$1$2$1 r0 = (com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isFailedValidation$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isFailedValidation$$inlined$map$1$2$1 r0 = new com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isFailedValidation$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4c
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f15949a
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$a r5 = (com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.a) r5
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$a r2 = com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.a.SKU_STATE_FAILED_VALIDATION
                        if (r5 != r2) goto L3e
                        r5 = 1
                        goto L3f
                    L3e:
                        r5 = 0
                    L3f:
                        java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4c
                        return r1
                    L4c:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isFailedValidation$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Boolean> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public final Flow<Boolean> isPurchased(@NotNull String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        MutableStateFlow<a> mutableStateFlow = this.f15928j.get(sku);
        Intrinsics.checkNotNull(mutableStateFlow);
        final MutableStateFlow<a> mutableStateFlow2 = mutableStateFlow;
        return new Flow<Boolean>() { // from class: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isPurchased$$inlined$map$1

            /* compiled from: Emitters.kt */
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 BillingDataSource.kt\ncom/arlosoft/macrodroid/upgrade/billing/BillingDataSource\n*L\n1#1,222:1\n48#2:223\n226#3,4:224\n*E\n"})
            /* renamed from: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isPurchased$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ FlowCollector f15951a;

                /* compiled from: Emitters.kt */
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isPurchased$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f15951a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isPurchased$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isPurchased$$inlined$map$1$2$1 r0 = (com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isPurchased$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isPurchased$$inlined$map$1$2$1 r0 = new com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isPurchased$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L52
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f15951a
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$a r5 = (com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.a) r5
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$a r2 = com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.a.SKU_STATE_UNKNOWN
                        if (r5 != r2) goto L3e
                        r5 = 0
                        goto L49
                    L3e:
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$a r2 = com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.a.SKU_STATE_PURCHASED_AND_ACKNOWLEDGED
                        if (r5 != r2) goto L44
                        r5 = 1
                        goto L45
                    L44:
                        r5 = 0
                    L45:
                        java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                    L49:
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L52
                        return r1
                    L52:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isPurchased$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Boolean> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public final Flow<Boolean> isValidating(@NotNull String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        MutableStateFlow<a> mutableStateFlow = this.f15928j.get(sku);
        Intrinsics.checkNotNull(mutableStateFlow);
        final MutableStateFlow<a> mutableStateFlow2 = mutableStateFlow;
        return new Flow<Boolean>() { // from class: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isValidating$$inlined$map$1

            /* compiled from: Emitters.kt */
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 BillingDataSource.kt\ncom/arlosoft/macrodroid/upgrade/billing/BillingDataSource\n*L\n1#1,222:1\n48#2:223\n237#3:224\n*E\n"})
            /* renamed from: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isValidating$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ FlowCollector f15953a;

                /* compiled from: Emitters.kt */
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isValidating$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f15953a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isValidating$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isValidating$$inlined$map$1$2$1 r0 = (com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isValidating$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isValidating$$inlined$map$1$2$1 r0 = new com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isValidating$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4c
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f15953a
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$a r5 = (com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.a) r5
                        com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$a r2 = com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.a.SKU_STATE_VALIDATING
                        if (r5 != r2) goto L3e
                        r5 = 1
                        goto L3f
                    L3e:
                        r5 = 0
                    L3f:
                        java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4c
                        return r1
                    L4c:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$isValidating$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Boolean> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0088, code lost:
        r14 = r1.getSubscriptionOfferDetails();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008c, code lost:
        if (r14 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008e, code lost:
        r14 = r14.get(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0094, code lost:
        if (r14 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0096, code lost:
        r2 = r14.getOfferToken();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009a, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0083 A[Catch: Exception -> 0x0123, LOOP:0: B:16:0x004f->B:33:0x0083, LOOP_END, TryCatch #0 {Exception -> 0x0123, blocks: (B:7:0x0021, B:9:0x002d, B:48:0x00cc, B:35:0x0088, B:37:0x008e, B:39:0x0096, B:40:0x009a, B:47:0x00b3, B:41:0x009e, B:43:0x00a4, B:45:0x00ac, B:46:0x00b0, B:13:0x0044, B:15:0x004a, B:16:0x004f, B:18:0x0055, B:20:0x0061, B:23:0x006b, B:25:0x0071, B:33:0x0083, B:49:0x00f9), top: B:54:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0081 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void launchBillingFlow(@org.jetbrains.annotations.Nullable android.app.Activity r11, @org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.NotNull java.lang.String[] r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.launchBillingFlow(android.app.Activity, java.lang.String, java.lang.String[], boolean):void");
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingServiceDisconnected() {
        l();
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingSetupFinished(@NotNull BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        int responseCode = billingResult.getResponseCode();
        String debugMessage = billingResult.getDebugMessage();
        Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
        StringBuilder sb = new StringBuilder();
        sb.append("onBillingSetupFinished: ");
        sb.append(responseCode);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(debugMessage);
        if (responseCode == 0) {
            this.f15926h = 1000L;
            kotlinx.coroutines.e.e(this.f15920b, null, null, new h(null), 3, null);
            return;
        }
        l();
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(@NotNull BillingResult billingResult, @Nullable List<? extends Purchase> list) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        int responseCode = billingResult.getResponseCode();
        if (responseCode != 0) {
            if (responseCode != 1) {
                if (responseCode != 5) {
                    if (responseCode != 7) {
                        int responseCode2 = billingResult.getResponseCode();
                        String debugMessage = billingResult.getDebugMessage();
                        StringBuilder sb = new StringBuilder();
                        sb.append("BillingResult [");
                        sb.append(responseCode2);
                        sb.append("]: ");
                        sb.append(debugMessage);
                    } else {
                        Log.i(f15916p, "onPurchasesUpdated: The user already owns this item");
                    }
                } else {
                    Log.e(f15916p, "onPurchasesUpdated: Developer error means that Google Play does not recognize the configuration. If you are just getting started, make sure you have configured the application correctly in the Google Play Console. The SKU product ID must match and the APK you are using must be signed with release keys.");
                }
            } else {
                Log.i(f15916p, "onPurchasesUpdated: User canceled the purchase");
            }
        } else if (list != null) {
            j(list, null);
            return;
        }
        kotlinx.coroutines.e.e(this.f15920b, null, null, new i(null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ba  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object refreshPurchases(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.l
            if (r0 == 0) goto L13
            r0 = r8
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$l r0 = (com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.l) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$l r0 = new com.arlosoft.macrodroid.upgrade.billing.BillingDataSource$l
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r0 = r0.L$0
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource r0 = (com.arlosoft.macrodroid.upgrade.billing.BillingDataSource) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L93
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L38:
            java.lang.Object r2 = r0.L$0
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource r2 = (com.arlosoft.macrodroid.upgrade.billing.BillingDataSource) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L53
        L40:
            kotlin.ResultKt.throwOnFailure(r8)
            com.android.billingclient.api.BillingClient r8 = r7.f15925g
            r0.L$0 = r7
            r0.label = r4
            java.lang.String r2 = "inapp"
            java.lang.Object r8 = com.android.billingclient.api.BillingClientKotlinKt.queryPurchasesAsync(r8, r2, r0)
            if (r8 != r1) goto L52
            return r1
        L52:
            r2 = r7
        L53:
            com.android.billingclient.api.PurchasesResult r8 = (com.android.billingclient.api.PurchasesResult) r8
            com.android.billingclient.api.BillingResult r4 = r8.getBillingResult()
            int r5 = r4.getResponseCode()
            if (r5 == 0) goto L7a
            java.lang.String r8 = com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.f15916p
            java.lang.String r4 = r4.getDebugMessage()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Problem getting purchases: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            android.util.Log.e(r8, r4)
            goto L83
        L7a:
            java.util.List r8 = r8.getPurchasesList()
            java.util.List<java.lang.String> r4 = r2.f15921c
            r2.j(r8, r4)
        L83:
            com.android.billingclient.api.BillingClient r8 = r2.f15925g
            r0.L$0 = r2
            r0.label = r3
            java.lang.String r3 = "subs"
            java.lang.Object r8 = com.android.billingclient.api.BillingClientKotlinKt.queryPurchasesAsync(r8, r3, r0)
            if (r8 != r1) goto L92
            return r1
        L92:
            r0 = r2
        L93:
            com.android.billingclient.api.PurchasesResult r8 = (com.android.billingclient.api.PurchasesResult) r8
            com.android.billingclient.api.BillingResult r1 = r8.getBillingResult()
            int r2 = r1.getResponseCode()
            if (r2 == 0) goto Lba
            java.lang.String r8 = com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.f15916p
            java.lang.String r0 = r1.getDebugMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Problem getting subscriptions: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.util.Log.e(r8, r0)
            goto Lc3
        Lba:
            java.util.List r8 = r8.getPurchasesList()
            java.util.List<java.lang.String> r1 = r0.f15923e
            r0.j(r8, r1)
        Lc3:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.upgrade.billing.BillingDataSource.refreshPurchases(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void resume() {
        if (!this.f15933o.getValue().booleanValue() && this.f15925g.isReady()) {
            kotlinx.coroutines.e.e(this.f15920b, null, null, new m(null), 3, null);
        }
    }
}
