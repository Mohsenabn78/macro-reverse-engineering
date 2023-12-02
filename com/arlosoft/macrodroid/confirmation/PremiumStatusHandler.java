package com.arlosoft.macrodroid.confirmation;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.app.di.modules.BillingModuleKt;
import com.arlosoft.macrodroid.confirmation.PremiumStatus;
import com.arlosoft.macrodroid.extensions.LiveDataExtensionsKt;
import com.arlosoft.macrodroid.extras.data.Extras;
import com.arlosoft.macrodroid.macro.DamnYouPirates;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PremiumStatusHandler.kt */
@StabilityInferred(parameters = 0)
@Singleton
@SourceDebugExtension({"SMAP\nPremiumStatusHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PremiumStatusHandler.kt\ncom/arlosoft/macrodroid/confirmation/PremiumStatusHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 5 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 6 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 7 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 8 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n+ 9 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,215:1\n1855#2:216\n1856#2:222\n1855#2,2:234\n1549#2:236\n1620#2,3:237\n47#3:217\n49#3:221\n50#4:218\n55#4:220\n106#5:219\n106#5:246\n526#6:223\n511#6,6:224\n125#7:230\n152#7,3:231\n287#8:240\n288#8:245\n37#9:241\n36#9,3:242\n*S KotlinDebug\n*F\n+ 1 PremiumStatusHandler.kt\ncom/arlosoft/macrodroid/confirmation/PremiumStatusHandler\n*L\n37#1:216\n37#1:222\n85#1:234,2\n136#1:236\n136#1:237,3\n38#1:217\n38#1:221\n38#1:218\n38#1:220\n38#1:219\n136#1:246\n68#1:223\n68#1:224,6\n68#1:230\n68#1:231,3\n136#1:240\n136#1:245\n136#1:241\n136#1:242,3\n*E\n"})
/* loaded from: classes3.dex */
public final class PremiumStatusHandler {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f10100a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final RemoteConfig f10101b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final BillingDataSource f10102c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, LiveData<PremiumStatus>> f10103d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final PremiumStatus.Pro f10104e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final LiveData<PremiumStatus> f10105f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final LiveData<Boolean> f10106g;

    /* compiled from: PremiumStatusHandler.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                BillingDataSource billingDataSource = PremiumStatusHandler.this.f10102c;
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
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: PremiumStatusHandler.kt */
    @SourceDebugExtension({"SMAP\nPremiumStatusHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PremiumStatusHandler.kt\ncom/arlosoft/macrodroid/confirmation/PremiumStatusHandler$combineTransform$1$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,215:1\n1549#2:216\n1620#2,3:217\n*S KotlinDebug\n*F\n+ 1 PremiumStatusHandler.kt\ncom/arlosoft/macrodroid/confirmation/PremiumStatusHandler$combineTransform$1$1$1\n*L\n87#1:216\n87#1:217,3\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class b<T> extends Lambda implements Function1<T, Unit> {
        final /* synthetic */ List<LiveData<T>> $sources;
        final /* synthetic */ MediatorLiveData<E> $this_apply;
        final /* synthetic */ Function1<List<? extends T>, E> $transform;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(MediatorLiveData<E> mediatorLiveData, Function1<? super List<? extends T>, ? extends E> function1, List<? extends LiveData<T>> list) {
            super(1);
            this.$this_apply = mediatorLiveData;
            this.$transform = function1;
            this.$sources = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((b<T>) obj);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(T t3) {
            int collectionSizeOrDefault;
            MediatorLiveData<E> mediatorLiveData = this.$this_apply;
            Function1<List<? extends T>, E> function1 = this.$transform;
            List<LiveData<T>> list = this.$sources;
            collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
            List<? extends T> arrayList = new ArrayList<>(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((LiveData) it.next()).getValue());
            }
            mediatorLiveData.setValue(function1.invoke(arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PremiumStatusHandler.kt */
    @SourceDebugExtension({"SMAP\nPremiumStatusHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PremiumStatusHandler.kt\ncom/arlosoft/macrodroid/confirmation/PremiumStatusHandler$getSubscriptionPremiumsStatusLiveDataList$combined$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,215:1\n1855#2,2:216\n*S KotlinDebug\n*F\n+ 1 PremiumStatusHandler.kt\ncom/arlosoft/macrodroid/confirmation/PremiumStatusHandler$getSubscriptionPremiumsStatusLiveDataList$combined$1\n*L\n70#1:216,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<List<? extends PremiumStatus>, PremiumStatus> {

        /* renamed from: d  reason: collision with root package name */
        public static final c f10110d = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final PremiumStatus invoke(@NotNull List<? extends PremiumStatus> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            for (PremiumStatus premiumStatus : it) {
                PremiumStatus.ActiveSubscription activeSubscription = PremiumStatus.ActiveSubscription.INSTANCE;
                if (Intrinsics.areEqual(premiumStatus, activeSubscription)) {
                    return activeSubscription;
                }
            }
            return PremiumStatus.Free.INSTANCE;
        }
    }

    /* compiled from: PremiumStatusHandler.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function2<PremiumStatus, PremiumStatus, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final d f10111d = new d();

        d() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        @NotNull
        /* renamed from: a */
        public final Boolean mo1invoke(@Nullable PremiumStatus premiumStatus, @Nullable PremiumStatus premiumStatus2) {
            boolean z3;
            if (!Intrinsics.areEqual(premiumStatus, PremiumStatus.Pro.INSTANCE) && !Intrinsics.areEqual(premiumStatus2, PremiumStatus.ActiveSubscription.INSTANCE)) {
                z3 = false;
            } else {
                z3 = true;
            }
            return Boolean.valueOf(z3);
        }
    }

    /* compiled from: PremiumStatusHandler.kt */
    /* loaded from: classes3.dex */
    static final class e extends SuspendLambda implements Function6<Boolean, Boolean, Boolean, Boolean, Boolean, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        /* synthetic */ Object L$3;
        /* synthetic */ Object L$4;
        int label;

        e(Continuation<? super e> continuation) {
            super(6, continuation);
        }

        @Override // kotlin.jvm.functions.Function6
        @Nullable
        /* renamed from: a */
        public final Object invoke(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Continuation<? super Boolean> continuation) {
            e eVar = new e(continuation);
            eVar.L$0 = bool;
            eVar.L$1 = bool2;
            eVar.L$2 = bool3;
            eVar.L$3 = bool4;
            eVar.L$4 = bool5;
            return eVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Boolean bool = (Boolean) this.L$0;
                Boolean bool2 = (Boolean) this.L$1;
                Boolean bool3 = (Boolean) this.L$2;
                Boolean bool4 = (Boolean) this.L$3;
                Boolean bool5 = (Boolean) this.L$4;
                boolean z3 = true;
                if (bool != null && bool.booleanValue()) {
                    PremiumStatusHandler premiumStatusHandler = PremiumStatusHandler.this;
                    premiumStatusHandler.c(premiumStatusHandler.f10100a, true);
                } else if (bool2 != null && bool2.booleanValue()) {
                    PremiumStatusHandler premiumStatusHandler2 = PremiumStatusHandler.this;
                    premiumStatusHandler2.c(premiumStatusHandler2.f10100a, true);
                } else if (bool3 != null && bool3.booleanValue()) {
                    PremiumStatusHandler premiumStatusHandler3 = PremiumStatusHandler.this;
                    premiumStatusHandler3.c(premiumStatusHandler3.f10100a, true);
                } else if (bool4 != null && bool4.booleanValue()) {
                    PremiumStatusHandler premiumStatusHandler4 = PremiumStatusHandler.this;
                    premiumStatusHandler4.c(premiumStatusHandler4.f10100a, true);
                } else if (bool5 != null && bool5.booleanValue()) {
                    PremiumStatusHandler premiumStatusHandler5 = PremiumStatusHandler.this;
                    premiumStatusHandler5.c(premiumStatusHandler5.f10100a, true);
                } else if (Settings.getUpgradeSerial(PremiumStatusHandler.this.f10100a) != null) {
                    PremiumStatusHandler premiumStatusHandler6 = PremiumStatusHandler.this;
                    premiumStatusHandler6.c(premiumStatusHandler6.f10100a, true);
                } else if (bool != null && bool2 != null && bool3 != null) {
                    if (!bool.booleanValue() && !bool2.booleanValue() && !bool3.booleanValue()) {
                        z3 = false;
                    }
                    PremiumStatusHandler premiumStatusHandler7 = PremiumStatusHandler.this;
                    premiumStatusHandler7.c(premiumStatusHandler7.f10100a, z3);
                } else {
                    z3 = Settings.getProDefault(PremiumStatusHandler.this.f10100a);
                }
                return Boxing.boxBoolean(z3);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: PremiumStatusHandler.kt */
    /* loaded from: classes3.dex */
    static final class f extends Lambda implements Function1<Boolean, PremiumStatus> {
        f() {
            super(1);
        }

        @NotNull
        public final PremiumStatus a(boolean z3) {
            return PremiumStatusHandler.this.b(z3);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ PremiumStatus invoke(Boolean bool) {
            return a(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PremiumStatusHandler.kt */
    /* loaded from: classes3.dex */
    public static final class g implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f10112a;

        g(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f10112a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Observer) || !(obj instanceof FunctionAdapter)) {
                return false;
            }
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f10112a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f10112a.invoke(obj);
        }
    }

    @Inject
    public PremiumStatusHandler(@ApplicationContext @NotNull Context context, @NotNull RemoteConfig remoteConfig, @NotNull BillingDataSource billingDataSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        Intrinsics.checkNotNullParameter(billingDataSource, "billingDataSource");
        this.f10100a = context;
        this.f10101b = remoteConfig;
        this.f10102c = billingDataSource;
        this.f10103d = new LinkedHashMap();
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new a(null), 2, null);
        for (String str : Extras.INSTANCE.getAllExtras()) {
            Map<String, LiveData<PremiumStatus>> map = this.f10103d;
            final Flow<Boolean> isPurchased = this.f10102c.isPurchased(str);
            map.put(str, FlowLiveDataConversions.asLiveData$default(FlowKt.distinctUntilChanged(new Flow<PremiumStatus>() { // from class: com.arlosoft.macrodroid.confirmation.PremiumStatusHandler$_init_$lambda$1$$inlined$map$1

                /* compiled from: Emitters.kt */
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PremiumStatusHandler.kt\ncom/arlosoft/macrodroid/confirmation/PremiumStatusHandler\n*L\n1#1,222:1\n48#2:223\n39#3,4:224\n*E\n"})
                /* renamed from: com.arlosoft.macrodroid.confirmation.PremiumStatusHandler$_init_$lambda$1$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ FlowCollector f10108a;

                    /* compiled from: Emitters.kt */
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                    /* renamed from: com.arlosoft.macrodroid.confirmation.PremiumStatusHandler$_init_$lambda$1$$inlined$map$1$2$1  reason: invalid class name */
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
                        this.f10108a = flowCollector;
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
                            boolean r0 = r6 instanceof com.arlosoft.macrodroid.confirmation.PremiumStatusHandler$_init_$lambda$1$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.arlosoft.macrodroid.confirmation.PremiumStatusHandler$_init_$lambda$1$$inlined$map$1$2$1 r0 = (com.arlosoft.macrodroid.confirmation.PremiumStatusHandler$_init_$lambda$1$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.arlosoft.macrodroid.confirmation.PremiumStatusHandler$_init_$lambda$1$$inlined$map$1$2$1 r0 = new com.arlosoft.macrodroid.confirmation.PremiumStatusHandler$_init_$lambda$1$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L50
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.f10108a
                            java.lang.Boolean r5 = (java.lang.Boolean) r5
                            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
                            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r2)
                            if (r5 == 0) goto L45
                            com.arlosoft.macrodroid.confirmation.PremiumStatus$ActiveSubscription r5 = com.arlosoft.macrodroid.confirmation.PremiumStatus.ActiveSubscription.INSTANCE
                            goto L47
                        L45:
                            com.arlosoft.macrodroid.confirmation.PremiumStatus$Free r5 = com.arlosoft.macrodroid.confirmation.PremiumStatus.Free.INSTANCE
                        L47:
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L50
                            return r1
                        L50:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.confirmation.PremiumStatusHandler$_init_$lambda$1$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super PremiumStatus> flowCollector, @NotNull Continuation continuation) {
                    Object coroutine_suspended;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                    coroutine_suspended = a.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            }), (CoroutineContext) null, 0L, 3, (Object) null));
        }
        this.f10104e = PremiumStatus.Pro.INSTANCE;
        LiveData<PremiumStatus> map2 = Transformations.map(FlowLiveDataConversions.asLiveData$default(FlowKt.distinctUntilChanged(FlowKt.combine(this.f10102c.isPurchased("com.arlosoft.macrodroid.pro"), this.f10102c.isPurchased(BillingModuleKt.SKU_PREMIUM_NEW), this.f10102c.isPurchased(BillingModuleKt.SKU_PREMIUM_NEW_2), this.f10102c.isPurchased(BillingModuleKt.SKU_PREMIUM_FLASH_SALE), this.f10102c.isPurchased(BillingModuleKt.SKU_PREMIUM_FLASH_SALE_2), new e(null))), (CoroutineContext) null, 0L, 3, (Object) null), new f());
        this.f10105f = map2;
        this.f10106g = LiveDataExtensionsKt.combineWith(map2, getSubscriptionPremiumsStatusLiveDataList(Extras.INSTANCE.getAllExtras()), d.f10111d);
    }

    private final <T, E> LiveData<E> a(List<? extends LiveData<T>> list, Function1<? super List<? extends T>, ? extends E> function1) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            mediatorLiveData.addSource(Transformations.distinctUntilChanged((LiveData) it.next()), new g(new b(mediatorLiveData, function1, list)));
        }
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumStatus b(boolean z3) {
        String name = this.f10100a.getApplicationContext().getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "context.applicationContext.javaClass.name");
        if (!StringsKt.endsWith$default(name, "MacroDroidApplication", false, 2, (Object) null)) {
            return PremiumStatus.Free.INSTANCE;
        }
        if (DamnYouPirates.isPirate(this.f10100a)) {
            return PremiumStatus.Free.INSTANCE;
        }
        if (Settings.getPurchaseInvalidated(this.f10100a)) {
            return PremiumStatus.Free.INSTANCE;
        }
        if (Settings.getUpgradeSerial(this.f10100a) != null) {
            return PremiumStatus.Pro.INSTANCE;
        }
        if (Settings.getSecondaryProEnabled(this.f10100a)) {
            return PremiumStatus.Pro.INSTANCE;
        }
        if (z3) {
            return PremiumStatus.Pro.INSTANCE;
        }
        return PremiumStatus.Free.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(Context context, boolean z3) {
        Settings.setProDefault(context, z3);
        if (this.f10101b.getProValveEnabled()) {
            if (z3) {
                Settings.setSecondaryProEnabled(context, true);
                return;
            }
            return;
        }
        Settings.setSecondaryProEnabled(context, z3);
    }

    @NotNull
    public final PremiumStatus getPremiumStatus() {
        if (Settings.getSecondaryProEnabled(this.f10100a)) {
            return PremiumStatus.Pro.INSTANCE;
        }
        if (Settings.getUpgradeSerial(this.f10100a) != null) {
            return PremiumStatus.Pro.INSTANCE;
        }
        Boolean value = this.f10106g.getValue();
        if (value != null) {
            if (value.booleanValue()) {
                return PremiumStatus.Pro.INSTANCE;
            }
            return PremiumStatus.Free.INSTANCE;
        } else if (Settings.getProDefault(this.f10100a)) {
            return PremiumStatus.Pro.INSTANCE;
        } else {
            return PremiumStatus.Free.INSTANCE;
        }
    }

    @NotNull
    public final LiveData<PremiumStatus> getSubscriptionPremiumsStatusLiveData(@NotNull String subscriptionId) {
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        LiveData<PremiumStatus> liveData = this.f10103d.get(subscriptionId);
        if (liveData != null) {
            return liveData;
        }
        throw new IllegalArgumentException("Subscription id " + subscriptionId + " not found");
    }

    @NotNull
    public final LiveData<PremiumStatus> getSubscriptionPremiumsStatusLiveDataList(@NotNull List<String> subscriptionIds) {
        Intrinsics.checkNotNullParameter(subscriptionIds, "subscriptionIds");
        Map<String, LiveData<PremiumStatus>> map = this.f10103d;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, LiveData<PremiumStatus>> entry : map.entrySet()) {
            if (subscriptionIds.contains(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            arrayList.add((LiveData) entry2.getValue());
        }
        return Transformations.distinctUntilChanged(a(arrayList, c.f10110d));
    }

    @NotNull
    public final LiveData<Boolean> isFailedValidation(@NotNull String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        return FlowLiveDataConversions.asLiveData$default(FlowKt.distinctUntilChanged(this.f10102c.isFailedValidation(sku)), (CoroutineContext) null, 0L, 3, (Object) null);
    }

    @NotNull
    public final LiveData<Boolean> isProLiveStatus() {
        return this.f10106g;
    }

    @NotNull
    public final LiveData<Boolean> isValidating(@NotNull List<String> subscriptionIds) {
        int collectionSizeOrDefault;
        List list;
        Intrinsics.checkNotNullParameter(subscriptionIds, "subscriptionIds");
        List<String> list2 = subscriptionIds;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str : list2) {
            arrayList.add(this.f10102c.isValidating(str));
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        Object[] array = list.toArray(new Flow[0]);
        if (array != null) {
            final Flow[] flowArr = (Flow[]) array;
            return FlowLiveDataConversions.asLiveData$default(FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: com.arlosoft.macrodroid.confirmation.PremiumStatusHandler$isValidating$$inlined$combine$1

                /* compiled from: Zip.kt */
                @SourceDebugExtension({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2\n+ 2 PremiumStatusHandler.kt\ncom/arlosoft/macrodroid/confirmation/PremiumStatusHandler\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,332:1\n137#2:333\n138#2,5:335\n143#2:341\n13309#3:334\n13310#3:340\n*S KotlinDebug\n*F\n+ 1 PremiumStatusHandler.kt\ncom/arlosoft/macrodroid/confirmation/PremiumStatusHandler\n*L\n137#1:334\n137#1:340\n*E\n"})
                /* renamed from: com.arlosoft.macrodroid.confirmation.PremiumStatusHandler$isValidating$$inlined$combine$1$3  reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super Boolean>, Boolean[], Continuation<? super Unit>, Object> {
                    private /* synthetic */ Object L$0;
                    /* synthetic */ Object L$1;
                    int label;

                    public AnonymousClass3(Continuation continuation) {
                        super(3, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended;
                        Boolean boxBoolean;
                        coroutine_suspended = a.getCOROUTINE_SUSPENDED();
                        int i4 = this.label;
                        if (i4 != 0) {
                            if (i4 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            FlowCollector flowCollector = (FlowCollector) this.L$0;
                            Boolean[] boolArr = (Boolean[]) ((Object[]) this.L$1);
                            int length = boolArr.length;
                            int i5 = 0;
                            while (true) {
                                if (i5 < length) {
                                    if (boolArr[i5].booleanValue()) {
                                        boxBoolean = Boxing.boxBoolean(true);
                                        break;
                                    }
                                    i5++;
                                } else {
                                    boxBoolean = Boxing.boxBoolean(false);
                                    break;
                                }
                            }
                            this.label = 1;
                            if (flowCollector.emit(boxBoolean, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    @Nullable
                    public final Object invoke(@NotNull FlowCollector<? super Boolean> flowCollector, @NotNull Boolean[] boolArr, @Nullable Continuation<? super Unit> continuation) {
                        AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                        anonymousClass3.L$0 = flowCollector;
                        anonymousClass3.L$1 = boolArr;
                        return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super Boolean> flowCollector, @NotNull Continuation continuation) {
                    Object coroutine_suspended;
                    final Flow[] flowArr2 = flowArr;
                    Object combineInternal = CombineKt.combineInternal(flowCollector, flowArr2, new Function0<Boolean[]>() { // from class: com.arlosoft.macrodroid.confirmation.PremiumStatusHandler$isValidating$$inlined$combine$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @Nullable
                        public final Boolean[] invoke() {
                            return new Boolean[flowArr2.length];
                        }
                    }, new AnonymousClass3(null), continuation);
                    coroutine_suspended = a.getCOROUTINE_SUSPENDED();
                    if (combineInternal == coroutine_suspended) {
                        return combineInternal;
                    }
                    return Unit.INSTANCE;
                }
            }), (CoroutineContext) null, 0L, 3, (Object) null);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Nullable
    public final Object refreshPurchases(@NotNull Continuation<? super Unit> continuation) {
        Object refreshPurchases = this.f10102c.refreshPurchases(continuation);
        if (refreshPurchases == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return refreshPurchases;
        }
        return Unit.INSTANCE;
    }
}
