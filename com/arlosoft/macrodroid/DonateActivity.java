package com.arlosoft.macrodroid;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LifecycleOwnerKt;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.app.di.modules.BillingModuleKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DonateActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class DonateActivity extends MacroDroidDaggerBaseActivity {
    @Inject
    public BillingDataSource billingDataSource;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DonateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: DonateActivity.kt */
    /* loaded from: classes2.dex */
    static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        a(Continuation<? super a> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                DonateActivity.this.n(BillingModuleKt.SKU_DONATION_1);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: DonateActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        b(Continuation<? super b> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                DonateActivity.this.n(BillingModuleKt.SKU_DONATION_2);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: DonateActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        c(Continuation<? super c> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                DonateActivity.this.n(BillingModuleKt.SKU_DONATION_3);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: DonateActivity.kt */
    /* loaded from: classes2.dex */
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
                DonateActivity donateActivity = DonateActivity.this;
                this.label = 1;
                if (donateActivity.querySkuPrice(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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

    /* compiled from: DonateActivity.kt */
    /* loaded from: classes2.dex */
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
                DonateActivity donateActivity = DonateActivity.this;
                this.label = 1;
                if (donateActivity.registerPurchaseListener(this) == coroutine_suspended) {
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
    /* compiled from: DonateActivity.kt */
    /* loaded from: classes2.dex */
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
            return DonateActivity.this.querySkuPrice(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DonateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g implements FlowCollector<String> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DonateActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $it;
            int label;
            final /* synthetic */ DonateActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(DonateActivity donateActivity, String str, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = donateActivity;
                this.$it = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, this.$it, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    TextView textView = (TextView) this.this$0.findViewById(R.id.donate_1_price);
                    if (textView != null) {
                        textView.setText(this.$it);
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

        g() {
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /* renamed from: a */
        public final Object emit(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
            Object coroutine_suspended;
            Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new a(DonateActivity.this, str, null), continuation);
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (withContext == coroutine_suspended) {
                return withContext;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DonateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class h implements FlowCollector<String> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DonateActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $it;
            int label;
            final /* synthetic */ DonateActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(DonateActivity donateActivity, String str, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = donateActivity;
                this.$it = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, this.$it, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    TextView textView = (TextView) this.this$0.findViewById(R.id.donate_2_price);
                    if (textView != null) {
                        textView.setText(this.$it);
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

        h() {
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /* renamed from: a */
        public final Object emit(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
            Object coroutine_suspended;
            Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new a(DonateActivity.this, str, null), continuation);
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (withContext == coroutine_suspended) {
                return withContext;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DonateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class i implements FlowCollector<String> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DonateActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $it;
            int label;
            final /* synthetic */ DonateActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(DonateActivity donateActivity, String str, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = donateActivity;
                this.$it = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, this.$it, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    TextView textView = (TextView) this.this$0.findViewById(R.id.donate_3_price);
                    if (textView != null) {
                        textView.setText(this.$it);
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

        i() {
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /* renamed from: a */
        public final Object emit(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
            Object coroutine_suspended;
            Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new a(DonateActivity.this, str, null), continuation);
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (withContext == coroutine_suspended) {
                return withContext;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DonateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class j extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        j(Continuation<? super j> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DonateActivity.this.registerPurchaseListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DonateActivity.kt */
    /* loaded from: classes2.dex */
    public static final class k implements FlowCollector<List<? extends String>> {
        k() {
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /* renamed from: a */
        public final Object emit(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
            DonateActivity.this.m();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        ToastCompat.makeText(getApplicationContext(), (CharSequence) getString(R.string.donation_received), 1).show();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String str) {
        BillingDataSource.launchBillingFlow$default(getBillingDataSource(), this, str, new String[0], false, 8, null);
    }

    @NotNull
    public final BillingDataSource getBillingDataSource() {
        BillingDataSource billingDataSource = this.billingDataSource;
        if (billingDataSource != null) {
            return billingDataSource;
        }
        Intrinsics.throwUninitializedPropertyAccessException("billingDataSource");
        return null;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_donate);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        FloatingActionButton donateButton1 = (FloatingActionButton) findViewById(R.id.donate_button_1);
        FloatingActionButton donateButton2 = (FloatingActionButton) findViewById(R.id.donate_button_2);
        FloatingActionButton donateButton3 = (FloatingActionButton) findViewById(R.id.donate_button_3);
        Intrinsics.checkNotNullExpressionValue(donateButton1, "donateButton1");
        ViewExtensionsKt.onClick$default(donateButton1, null, new a(null), 1, null);
        Intrinsics.checkNotNullExpressionValue(donateButton2, "donateButton2");
        ViewExtensionsKt.onClick$default(donateButton2, null, new b(null), 1, null);
        Intrinsics.checkNotNullExpressionValue(donateButton3, "donateButton3");
        ViewExtensionsKt.onClick$default(donateButton3, null, new c(null), 1, null);
        kotlinx.coroutines.e.e(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new d(null), 2, null);
        kotlinx.coroutines.e.e(LifecycleOwnerKt.getLifecycleScope(this), null, null, new e(null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a6 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object querySkuPrice(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.arlosoft.macrodroid.DonateActivity.f
            if (r0 == 0) goto L13
            r0 = r8
            com.arlosoft.macrodroid.DonateActivity$f r0 = (com.arlosoft.macrodroid.DonateActivity.f) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.arlosoft.macrodroid.DonateActivity$f r0 = new com.arlosoft.macrodroid.DonateActivity$f
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L48
            if (r2 == r5) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            kotlin.ResultKt.throwOnFailure(r8)
            goto La7
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L38:
            java.lang.Object r2 = r0.L$0
            com.arlosoft.macrodroid.DonateActivity r2 = (com.arlosoft.macrodroid.DonateActivity) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L88
        L40:
            java.lang.Object r2 = r0.L$0
            com.arlosoft.macrodroid.DonateActivity r2 = (com.arlosoft.macrodroid.DonateActivity) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6a
        L48:
            kotlin.ResultKt.throwOnFailure(r8)
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource r8 = r7.getBillingDataSource()
            java.lang.String r2 = "donation_low"
            kotlinx.coroutines.flow.Flow r8 = r8.getSkuPrice(r2)
            kotlinx.coroutines.flow.Flow r8 = kotlinx.coroutines.flow.FlowKt.take(r8, r5)
            com.arlosoft.macrodroid.DonateActivity$g r2 = new com.arlosoft.macrodroid.DonateActivity$g
            r2.<init>()
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = r8.collect(r2, r0)
            if (r8 != r1) goto L69
            return r1
        L69:
            r2 = r7
        L6a:
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource r8 = r2.getBillingDataSource()
            java.lang.String r6 = "donation_medium"
            kotlinx.coroutines.flow.Flow r8 = r8.getSkuPrice(r6)
            kotlinx.coroutines.flow.Flow r8 = kotlinx.coroutines.flow.FlowKt.take(r8, r5)
            com.arlosoft.macrodroid.DonateActivity$h r6 = new com.arlosoft.macrodroid.DonateActivity$h
            r6.<init>()
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r8 = r8.collect(r6, r0)
            if (r8 != r1) goto L88
            return r1
        L88:
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource r8 = r2.getBillingDataSource()
            java.lang.String r4 = "donation_high"
            kotlinx.coroutines.flow.Flow r8 = r8.getSkuPrice(r4)
            kotlinx.coroutines.flow.Flow r8 = kotlinx.coroutines.flow.FlowKt.take(r8, r5)
            com.arlosoft.macrodroid.DonateActivity$i r4 = new com.arlosoft.macrodroid.DonateActivity$i
            r4.<init>()
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = r8.collect(r4, r0)
            if (r8 != r1) goto La7
            return r1
        La7:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.DonateActivity.querySkuPrice(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object registerPurchaseListener(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.arlosoft.macrodroid.DonateActivity.j
            if (r0 == 0) goto L13
            r0 = r5
            com.arlosoft.macrodroid.DonateActivity$j r0 = (com.arlosoft.macrodroid.DonateActivity.j) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.arlosoft.macrodroid.DonateActivity$j r0 = new com.arlosoft.macrodroid.DonateActivity$j
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2d:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4a
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            com.arlosoft.macrodroid.upgrade.billing.BillingDataSource r5 = r4.getBillingDataSource()
            kotlinx.coroutines.flow.SharedFlow r5 = r5.getNewPurchases()
            com.arlosoft.macrodroid.DonateActivity$k r2 = new com.arlosoft.macrodroid.DonateActivity$k
            r2.<init>()
            r0.label = r3
            java.lang.Object r5 = r5.collect(r2, r0)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.DonateActivity.registerPurchaseListener(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setBillingDataSource(@NotNull BillingDataSource billingDataSource) {
        Intrinsics.checkNotNullParameter(billingDataSource, "<set-?>");
        this.billingDataSource = billingDataSource;
    }
}
