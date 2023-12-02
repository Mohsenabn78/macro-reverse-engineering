package com.arlosoft.macrodroid.extras.ui;

import android.app.Dialog;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.confirmation.PurchaseValidator;
import com.arlosoft.macrodroid.databinding.ActivityExtrasBinding;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.extras.ExtrasDownloader;
import com.arlosoft.macrodroid.extras.data.ExtraMacroSetData;
import com.arlosoft.macrodroid.extras.data.ExtraPackage;
import com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState;
import com.arlosoft.macrodroid.extras.data.ExtraVersionHistoryEntry;
import com.arlosoft.macrodroid.extras.data.StringWithLanguages;
import com.arlosoft.macrodroid.extras.ui.ExtraPackageClickListener;
import com.arlosoft.macrodroid.extras.ui.management.ExtrasManager;
import com.arlosoft.macrodroid.extras.ui.viewmodel.ExtrasViewModel;
import com.arlosoft.macrodroid.remoteconfig.ExtraMinVersion;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import com.arlosoft.macrodroid.upgrade.billing.SubscriptionPrice;
import com.arlosoft.macrodroid.upgrade.model.SubscriptionCheckStatus;
import com.bumptech.glide.Glide;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.jaredrummler.android.device.DeviceName;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.f;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtrasActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nExtrasActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtrasActivity.kt\ncom/arlosoft/macrodroid/extras/ui/ExtrasActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,502:1\n262#2,2:503\n1054#3:505\n*S KotlinDebug\n*F\n+ 1 ExtrasActivity.kt\ncom/arlosoft/macrodroid/extras/ui/ExtrasActivity\n*L\n220#1:503,2\n432#1:505\n*E\n"})
/* loaded from: classes3.dex */
public final class ExtrasActivity extends MacroDroidDaggerBaseActivity {
    public static final int VIEW_CONTENT = 1;
    public static final int VIEW_EMPTY = 2;
    public static final int VIEW_ERROR = 3;
    public static final int VIEW_LOADING = 0;
    @Inject
    public BillingDataSource billingDataSource;
    @Inject
    public ExtrasDownloader extrasDownloader;
    @Inject
    public ExtrasManager extrasManager;

    /* renamed from: f  reason: collision with root package name */
    private ActivityExtrasBinding f12091f;

    /* renamed from: g  reason: collision with root package name */
    private String f12092g;

    /* renamed from: h  reason: collision with root package name */
    private ExtrasAdapter f12093h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private Boolean f12094i;
    @Inject
    public PremiumStatusHandler premiumStatusHandler;
    @Inject
    public PurchaseValidator purchaseValidator;
    @Inject
    public RemoteConfig remoteConfig;
    @Inject
    public ExtrasViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ExtrasActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExtrasActivity.kt */
    @SourceDebugExtension({"SMAP\nExtrasActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtrasActivity.kt\ncom/arlosoft/macrodroid/extras/ui/ExtrasActivity$activateMacroSet$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,502:1\n288#2,2:503\n*S KotlinDebug\n*F\n+ 1 ExtrasActivity.kt\ncom/arlosoft/macrodroid/extras/ui/ExtrasActivity$activateMacroSet$1\n*L\n279#1:503,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
        final /* synthetic */ boolean $forceUpdate;
        Object L$0;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasActivity.kt */
        /* renamed from: com.arlosoft.macrodroid.extras.ui.ExtrasActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0103a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
            int label;
            final /* synthetic */ ExtrasActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0103a(ExtrasActivity extrasActivity, ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super C0103a> continuation) {
                super(2, continuation);
                this.this$0 = extrasActivity;
                this.$extraPackage = extraPackageWithPriceAndState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0103a(this.this$0, this.$extraPackage, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ExtrasAdapter extrasAdapter = this.this$0.f12093h;
                    ExtrasAdapter extrasAdapter2 = null;
                    if (extrasAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        extrasAdapter = null;
                    }
                    extrasAdapter.updateValidatingState(this.$extraPackage.getExtra().getSubscriptionId(), false, false);
                    ExtrasAdapter extrasAdapter3 = this.this$0.f12093h;
                    if (extrasAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    } else {
                        extrasAdapter2 = extrasAdapter3;
                    }
                    extrasAdapter2.updateInstalledVersion(this.$extraPackage.getExtra().getId(), Boxing.boxInt(this.$extraPackage.getExtra().getVersionCode()));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((C0103a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ExtrasActivity.kt */
        /* loaded from: classes3.dex */
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
            final /* synthetic */ ExtraMacroSetData $macroSetData;
            int label;
            final /* synthetic */ ExtrasActivity this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: ExtrasActivity.kt */
            /* renamed from: com.arlosoft.macrodroid.extras.ui.ExtrasActivity$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C0104a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
                int label;
                final /* synthetic */ ExtrasActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0104a(ExtrasActivity extrasActivity, ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super C0104a> continuation) {
                    super(2, continuation);
                    this.this$0 = extrasActivity;
                    this.$extraPackage = extraPackageWithPriceAndState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C0104a(this.this$0, this.$extraPackage, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        ExtrasAdapter extrasAdapter = this.this$0.f12093h;
                        if (extrasAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                            extrasAdapter = null;
                        }
                        extrasAdapter.updateValidatingState(this.$extraPackage.getExtra().getSubscriptionId(), false, true);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C0104a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(ExtrasActivity extrasActivity, ExtraMacroSetData extraMacroSetData, ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super b> continuation) {
                super(2, continuation);
                this.this$0 = extrasActivity;
                this.$macroSetData = extraMacroSetData;
                this.$extraPackage = extraPackageWithPriceAndState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new b(this.this$0, this.$macroSetData, this.$extraPackage, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended;
                String string;
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
                    C0104a c0104a = new C0104a(this.this$0, this.$extraPackage, null);
                    this.label = 1;
                    if (BuildersKt.withContext(main, c0104a, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                ExtrasActivity extrasActivity = this.this$0;
                ExtraMacroSetData extraMacroSetData = this.$macroSetData;
                if (extraMacroSetData == null || (string = extraMacroSetData.getMessage()) == null) {
                    string = this.this$0.getString(R.string.error);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.error)");
                }
                extrasActivity.q(new SubscriptionCheckStatus.ValidationFailed(string));
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
        /* compiled from: ExtrasActivity.kt */
        /* loaded from: classes3.dex */
        public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
            int label;
            final /* synthetic */ ExtrasActivity this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: ExtrasActivity.kt */
            /* renamed from: com.arlosoft.macrodroid.extras.ui.ExtrasActivity$a$c$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C0105a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
                int label;
                final /* synthetic */ ExtrasActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0105a(ExtrasActivity extrasActivity, ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super C0105a> continuation) {
                    super(2, continuation);
                    this.this$0 = extrasActivity;
                    this.$extraPackage = extraPackageWithPriceAndState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C0105a(this.this$0, this.$extraPackage, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        ExtrasAdapter extrasAdapter = this.this$0.f12093h;
                        if (extrasAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                            extrasAdapter = null;
                        }
                        extrasAdapter.updateValidatingState(this.$extraPackage.getExtra().getSubscriptionId(), false, true);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return ((C0105a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(ExtrasActivity extrasActivity, ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super c> continuation) {
                super(2, continuation);
                this.this$0 = extrasActivity;
                this.$extraPackage = extraPackageWithPriceAndState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new c(this.this$0, this.$extraPackage, continuation);
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
                    C0105a c0105a = new C0105a(this.this$0, this.$extraPackage, null);
                    this.label = 1;
                    if (BuildersKt.withContext(main, c0105a, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.this$0.q(new SubscriptionCheckStatus.ValidationFailed("No subscription details available"));
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, boolean z3, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$extraPackage = extraPackageWithPriceAndState;
            this.$forceUpdate = z3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$extraPackage, this.$forceUpdate, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 348
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.extras.ui.ExtrasActivity.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExtrasActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Dialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Dialog dialog, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$dialog = dialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExtrasActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c implements FlowCollector<SubscriptionPrice> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function1<SubscriptionPrice, Unit> f12095a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super SubscriptionPrice, Unit> function1) {
            this.f12095a = function1;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /* renamed from: a */
        public final Object emit(@NotNull SubscriptionPrice subscriptionPrice, @NotNull Continuation<? super Unit> continuation) {
            this.f12095a.invoke(subscriptionPrice);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExtrasActivity.kt */
    /* loaded from: classes3.dex */
    public static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Dialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Dialog dialog, Continuation<? super d> continuation) {
            super(3, continuation);
            this.$dialog = dialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExtrasActivity.kt */
    /* loaded from: classes3.dex */
    public static final class e extends Lambda implements Function1<ExtraVersionHistoryEntry, CharSequence> {
        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull ExtraVersionHistoryEntry it) {
            Intrinsics.checkNotNullParameter(it, "it");
            String versionString = it.getVersionString();
            StringWithLanguages versionDescription = it.getVersionDescription();
            String str = ExtrasActivity.this.f12092g;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException(RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
                str = null;
            }
            String stringForLanguage = versionDescription.getStringForLanguage(str);
            return "<b>" + versionString + "</b><br/><br/>" + stringForLanguage + "<br/><br/>";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, boolean z3) {
        kotlinx.coroutines.e.e(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new a(extraPackageWithPriceAndState, z3, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p(ExtraPackage extraPackage) {
        boolean z3;
        boolean z4;
        String str;
        boolean isNotificationPolicyAccessGranted;
        String str2;
        String trimIndent;
        boolean isIgnoringBatteryOptimizations;
        String str3 = ("\n<" + getString(R.string.enter_your_message_here) + ">") + "\n\n\n\n-------------------------------------------";
        StringWithLanguages title = extraPackage.getTitle();
        String str4 = this.f12092g;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
            str4 = null;
        }
        String str5 = (str3 + "\n" + title.getStringForLanguage(str4) + " - " + extraPackage.getVersionString()) + "\n[" + Build.MANUFACTURER + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + DeviceName.getDeviceName() + " - " + Build.VERSION.RELEASE + "], " + BuildConfig.VERSION_NAME;
        if (getPremiumStatusHandler().getPremiumStatus().isPro()) {
            String orderId = Settings.getOrderId(this);
            if (orderId != null) {
                str5 = str5 + "\r\n\r\nOrder id = " + orderId;
            } else if (Settings.getUpgradeSerial(this) != null) {
                str5 = str5 + "\r\n\r\nSerial = " + orderId;
            } else {
                str5 = str5 + "\r\n\r\nPurchase Info Unknown";
            }
        }
        boolean z5 = false;
        if (Settings.Global.getInt(getContentResolver(), "always_finish_activities", 0) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            str5 = str5 + "\r\n\r\nDon't keep activities enabled";
        }
        if (Build.VERSION.SDK_INT >= 23) {
            Object systemService = getSystemService("power");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            isIgnoringBatteryOptimizations = ((PowerManager) systemService).isIgnoringBatteryOptimizations(getPackageName());
            str5 = str5 + "\r\n\r\nBattery optimization disabled: " + isIgnoringBatteryOptimizations;
        }
        try {
            int i4 = Settings.Secure.getInt(getContentResolver(), "location_mode");
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        str2 = "High Accuracy";
                    } else {
                        str2 = "Battery Saving";
                    }
                } else {
                    str2 = "Sensors Only";
                }
            } else {
                str2 = "Off";
            }
            trimIndent = f.trimIndent("\r\n\r\nLocation services: " + str2);
            str5 = str5 + trimIndent;
        } catch (Settings.SettingNotFoundException unused) {
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        String str6 = "Enabled";
        if (z4) {
            str = "Enabled";
        } else {
            str = "Disabled";
        }
        String str7 = str5 + "\r\nCoarse location permission: " + str;
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            z5 = true;
        }
        if (!z5) {
            str6 = "Disabled";
        }
        String str8 = (str7 + "\r\nFine location permission: " + str6) + "\r\nAccessibility enabled: " + Util.isMacroDroidAccessibilityEnabled(this);
        if (Build.VERSION.SDK_INT >= 23) {
            Object systemService2 = getSystemService("notification");
            Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.app.NotificationManager");
            isNotificationPolicyAccessGranted = ((NotificationManager) systemService2).isNotificationPolicyAccessGranted();
            str8 = str8 + "\r\nNotification service enabled: " + isNotificationPolicyAccessGranted;
        }
        String macroDroidHelperVersionName = ApplicationChecker.getMacroDroidHelperVersionName();
        if (macroDroidHelperVersionName == null) {
            macroDroidHelperVersionName = "Not installed";
        }
        String str9 = str8 + "\r\nHelper File: " + macroDroidHelperVersionName;
        if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            str9 = str9 + "\r\nNotifications are disabled for MacroDroid.";
        }
        if (!ApplicationChecker.isPlayStoreInstalled()) {
            str9 = str9 + "\r\n\r\nGoogle Play Store is not installed";
        }
        return str9 + "\r\n\r\nId: " + com.arlosoft.macrodroid.settings.Settings.getAnonymousUserId(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(SubscriptionCheckStatus subscriptionCheckStatus) {
        String string;
        if (subscriptionCheckStatus instanceof SubscriptionCheckStatus.ValidationFailed) {
            string = ((SubscriptionCheckStatus.ValidationFailed) subscriptionCheckStatus).getMessage();
        } else if (subscriptionCheckStatus instanceof SubscriptionCheckStatus.Expired) {
            DateFormat dateTimeInstance = DateFormat.getDateTimeInstance();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string2 = getString(R.string.expired_with_date);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.expired_with_date)");
            string = String.format(string2, Arrays.copyOf(new Object[]{dateTimeInstance.format(((SubscriptionCheckStatus.Expired) subscriptionCheckStatus).getExpiryTime())}, 1));
            Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
        } else {
            string = getString(R.string.validation_service_unavailable);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            getString(…ce_unavailable)\n        }");
        }
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(this).setTitle(R.string.payment_validation_failed).setMessage(string).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.retry, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.extras.ui.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ExtrasActivity.r(ExtrasActivity.this, dialogInterface, i4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(positiveButton, "Builder(this)\n          …fresh()\n                }");
        AlertDialog create = positiveButton.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ExtrasActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f12094i = null;
        this$0.getViewModel().refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, ExtraPackageClickListener.PurchasePeriod purchasePeriod) {
        if (extraPackageWithPriceAndState.getExtra().getDisclaimer() != null) {
            Dialog dialog = new Dialog(this);
            dialog.setCancelable(true);
            dialog.setContentView(R.layout.dialog_extra_disclaimer);
            DialogExtensionsKt.setWidthToParent$default(dialog, 0, 1, null);
            ActivityExtrasBinding activityExtrasBinding = this.f12091f;
            if (activityExtrasBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityExtrasBinding = null;
            }
            Glide.with(activityExtrasBinding.getRoot().getContext()).m4161load(extraPackageWithPriceAndState.getExtra().getIconUrl()).into((ImageView) dialog.findViewById(R.id.extra_icon));
            TextView textView = (TextView) dialog.findViewById(R.id.disclaimer_text);
            StringWithLanguages disclaimer = extraPackageWithPriceAndState.getExtra().getDisclaimer();
            String str = this.f12092g;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException(RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
                str = null;
            }
            textView.setText(disclaimer.getStringForLanguage(str));
            View findViewById = dialog.findViewById(R.id.acceptButton);
            Intrinsics.checkNotNullExpressionValue(findViewById, "dialog.findViewById<Button>(R.id.acceptButton)");
            ViewExtensionsKt.onClick$default(findViewById, null, new ExtrasActivity$handlePurchaseClick$1(purchasePeriod, extraPackageWithPriceAndState, this, dialog, null), 1, null);
            View findViewById2 = dialog.findViewById(R.id.declineButton);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "dialog.findViewById<Button>(R.id.declineButton)");
            ViewExtensionsKt.onClick$default(findViewById2, null, new b(dialog, null), 1, null);
            dialog.show();
            return;
        }
        BillingDataSource.launchBillingFlow$default(getBillingDataSource(), this, extraPackageWithPriceAndState.getExtra().getSubscriptionId(), new String[0], false, 8, null);
    }

    private final void t(Context context) {
        try {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.arlosoft.macrodroid"));
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
            }
        } catch (ActivityNotFoundException unused2) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.arlosoft.macrodroid"));
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object u(String str, Function1<? super SubscriptionPrice, Unit> function1, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object collect = FlowKt.take(getBillingDataSource().getSkuSubscriptionPrice(str, getPremiumStatusHandler().getPremiumStatus().isPro()), 1).collect(new c(function1), continuation);
        coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
        if (collect == coroutine_suspended) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(ExtraMinVersion extraMinVersion) {
        AlertDialog.Builder title = new AlertDialog.Builder(this).setTitle(R.string.update_required);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.macrodroid_specific_version_number_required);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.macro…_version_number_required)");
        String format = String.format(string, Arrays.copyOf(new Object[]{extraMinVersion.getVersionName()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        AlertDialog.Builder positiveButton = title.setMessage(format).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.install_update, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.extras.ui.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ExtrasActivity.w(ExtrasActivity.this, dialogInterface, i4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(positiveButton, "Builder(this)\n          …e(this)\n                }");
        AlertDialog create = positiveButton.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(ExtrasActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(ExtraPackage extraPackage) {
        List sortedWith;
        String joinToString$default;
        Dialog dialog = new Dialog(this);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_extra_version_history);
        DialogExtensionsKt.setWidthToParent$default(dialog, 0, 1, null);
        ActivityExtrasBinding activityExtrasBinding = this.f12091f;
        if (activityExtrasBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityExtrasBinding = null;
        }
        Glide.with(activityExtrasBinding.getRoot().getContext()).m4161load(extraPackage.getIconUrl()).into((ImageView) dialog.findViewById(R.id.extra_icon));
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(extraPackage.getVersionHistory(), new Comparator() { // from class: com.arlosoft.macrodroid.extras.ui.ExtrasActivity$showVersionHistoryDialog$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                int compareValues;
                compareValues = kotlin.comparisons.f.compareValues(Integer.valueOf(((ExtraVersionHistoryEntry) t4).getVersionCode()), Integer.valueOf(((ExtraVersionHistoryEntry) t3).getVersionCode()));
                return compareValues;
            }
        });
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(sortedWith, "", null, null, 0, null, new e(), 30, null);
        ((TextView) dialog.findViewById(R.id.version_history_text)).setText(Html.fromHtml(joinToString$default));
        View findViewById = dialog.findViewById(R.id.ok_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "dialog.findViewById<Button>(R.id.ok_button)");
        ViewExtensionsKt.onClick$default(findViewById, null, new d(dialog, null), 1, null);
        dialog.show();
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

    @NotNull
    public final ExtrasDownloader getExtrasDownloader() {
        ExtrasDownloader extrasDownloader = this.extrasDownloader;
        if (extrasDownloader != null) {
            return extrasDownloader;
        }
        Intrinsics.throwUninitializedPropertyAccessException("extrasDownloader");
        return null;
    }

    @NotNull
    public final ExtrasManager getExtrasManager() {
        ExtrasManager extrasManager = this.extrasManager;
        if (extrasManager != null) {
            return extrasManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("extrasManager");
        return null;
    }

    @NotNull
    public final PremiumStatusHandler getPremiumStatusHandler() {
        PremiumStatusHandler premiumStatusHandler = this.premiumStatusHandler;
        if (premiumStatusHandler != null) {
            return premiumStatusHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("premiumStatusHandler");
        return null;
    }

    @NotNull
    public final PurchaseValidator getPurchaseValidator() {
        PurchaseValidator purchaseValidator = this.purchaseValidator;
        if (purchaseValidator != null) {
            return purchaseValidator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("purchaseValidator");
        return null;
    }

    @NotNull
    public final RemoteConfig getRemoteConfig() {
        RemoteConfig remoteConfig = this.remoteConfig;
        if (remoteConfig != null) {
            return remoteConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("remoteConfig");
        return null;
    }

    @NotNull
    public final ExtrasViewModel getViewModel() {
        ExtrasViewModel extrasViewModel = this.viewModel;
        if (extrasViewModel != null) {
            return extrasViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityExtrasBinding inflate = ActivityExtrasBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f12091f = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void setBillingDataSource(@NotNull BillingDataSource billingDataSource) {
        Intrinsics.checkNotNullParameter(billingDataSource, "<set-?>");
        this.billingDataSource = billingDataSource;
    }

    public final void setExtrasDownloader(@NotNull ExtrasDownloader extrasDownloader) {
        Intrinsics.checkNotNullParameter(extrasDownloader, "<set-?>");
        this.extrasDownloader = extrasDownloader;
    }

    public final void setExtrasManager(@NotNull ExtrasManager extrasManager) {
        Intrinsics.checkNotNullParameter(extrasManager, "<set-?>");
        this.extrasManager = extrasManager;
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public final void setPurchaseValidator(@NotNull PurchaseValidator purchaseValidator) {
        Intrinsics.checkNotNullParameter(purchaseValidator, "<set-?>");
        this.purchaseValidator = purchaseValidator;
    }

    public final void setRemoteConfig(@NotNull RemoteConfig remoteConfig) {
        Intrinsics.checkNotNullParameter(remoteConfig, "<set-?>");
        this.remoteConfig = remoteConfig;
    }

    public final void setViewModel(@NotNull ExtrasViewModel extrasViewModel) {
        Intrinsics.checkNotNullParameter(extrasViewModel, "<set-?>");
        this.viewModel = extrasViewModel;
    }
}
