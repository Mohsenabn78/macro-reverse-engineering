package com.arlosoft.macrodroid.freeversion;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.araujo.jordan.excuseme.ExcuseMe;
import com.araujo.jordan.excuseme.model.PermissionStatus;
import com.arlosoft.macrodroid.MacroDroidService;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.advert.MacroDroidProAdvertActivity2;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.databinding.ActivityAddDaysBinding;
import com.arlosoft.macrodroid.drawer.DrawerOverlayHandleService;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.MacroDroidDisabledEvent;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.freeversion.AddDaysActivity;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.troubleshooting.problem.PermissionChecker;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.SnackbarAnimate;
import com.pollfish.Pollfish;
import com.pollfish.builder.Params;
import com.pollfish.callback.PollfishSurveyCompletedListener;
import com.pollfish.callback.PollfishSurveyNotAvailableListener;
import com.pollfish.callback.PollfishSurveyReceivedListener;
import com.pollfish.callback.PollfishUserNotEligibleListener;
import com.pollfish.callback.PollfishUserRejectedSurveyListener;
import com.pollfish.callback.SurveyInfo;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

/* compiled from: AddDaysActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nAddDaysActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AddDaysActivity.kt\ncom/arlosoft/macrodroid/freeversion/AddDaysActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,665:1\n262#2,2:666\n262#2,2:668\n262#2,2:670\n262#2,2:672\n262#2,2:674\n262#2,2:676\n262#2,2:678\n262#2,2:680\n262#2,2:682\n262#2,2:684\n262#2,2:686\n262#2,2:688\n262#2,2:690\n262#2,2:692\n262#2,2:694\n262#2,2:698\n262#2,2:700\n37#3,2:696\n*S KotlinDebug\n*F\n+ 1 AddDaysActivity.kt\ncom/arlosoft/macrodroid/freeversion/AddDaysActivity\n*L\n107#1:666,2\n186#1:668,2\n190#1:670,2\n246#1:672,2\n247#1:674,2\n248#1:676,2\n249#1:678,2\n250#1:680,2\n256#1:682,2\n257#1:684,2\n258#1:686,2\n259#1:688,2\n261#1:690,2\n266#1:692,2\n268#1:694,2\n640#1:698,2\n661#1:700,2\n360#1:696,2\n*E\n"})
/* loaded from: classes3.dex */
public final class AddDaysActivity extends MacroDroidDaggerBaseActivity {

    /* renamed from: f  reason: collision with root package name */
    private ActivityAddDaysBinding f12159f;
    @Inject
    public FreeVersionHelper freeVersionHelper;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12160g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private RewardedAd f12161h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private DataSharingService f12162i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private AlertDialog f12163j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private DataSharingService f12164k;
    @Inject
    public PermissionChecker permissionChecker;
    @Inject
    public RemoteConfig remoteConfig;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: AddDaysActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AddDaysActivity.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataSharingPermission.values().length];
            try {
                iArr[DataSharingPermission.ACCESS_FINE_LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AddDaysActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
                AddDaysActivity.this.onBackPressed();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AddDaysActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
                AddDaysActivity.this.J();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AddDaysActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
                FirebaseAnalyticsEventLogger.INSTANCE.logSurveyClicked();
                Pollfish.Companion.show();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AddDaysActivity.kt */
    /* loaded from: classes3.dex */
    public static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        d(Continuation<? super d> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                UpgradeActivity2.Companion.animateInUpgradeSceen(AddDaysActivity.this);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AddDaysActivity.kt */
    /* loaded from: classes3.dex */
    public static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        e(Continuation<? super e> continuation) {
            super(3, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(AddDaysActivity addDaysActivity, RewardItem rewardItem) {
            addDaysActivity.r();
            FirebaseAnalyticsEventLogger.INSTANCE.logRewardAdvertCompleted(false);
            AddDaysActivity.C(addDaysActivity, false, 1, null);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: b */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            e eVar = new e(continuation);
            eVar.L$0 = coroutineScope;
            return eVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Unit unit;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                if (AddDaysActivity.this.f12160g) {
                    MacroDroidProAdvertActivity2.Companion.showRewardAdvert(AddDaysActivity.this, 0);
                    AddDaysActivity.this.B(false);
                } else {
                    FirebaseAnalyticsEventLogger.INSTANCE.logRewardAdvertClicked();
                    RewardedAd rewardedAd = AddDaysActivity.this.f12161h;
                    if (rewardedAd != null) {
                        final AddDaysActivity addDaysActivity = AddDaysActivity.this;
                        rewardedAd.show(addDaysActivity, new OnUserEarnedRewardListener() { // from class: com.arlosoft.macrodroid.freeversion.f
                            @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
                            public final void onUserEarnedReward(RewardItem rewardItem) {
                                AddDaysActivity.e.c(AddDaysActivity.this, rewardItem);
                            }
                        });
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        Timber.e("+++++ REWARD ADVERT NOT READY", new Object[0]);
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AddDaysActivity.kt */
    /* loaded from: classes3.dex */
    public static final class f extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ DataSharingService $service;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(DataSharingService dataSharingService, Continuation<? super f> continuation) {
            super(3, continuation);
            this.$service = dataSharingService;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new f(this.$service, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AddDaysActivity.this.R(this.$service);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AddDaysActivity.kt */
    /* loaded from: classes3.dex */
    public static final class g extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ DataSharingService $service;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(DataSharingService dataSharingService, Continuation<? super g> continuation) {
            super(3, continuation);
            this.$service = dataSharingService;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new g(this.$service, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AddDaysActivity.this.H(this.$service);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AddDaysActivity.kt */
    /* loaded from: classes3.dex */
    public static final class h extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ Dialog $dialog;
        final /* synthetic */ DataSharingService $service;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(DataSharingService dataSharingService, Dialog dialog) {
            super(1);
            this.$service = dataSharingService;
            this.$dialog = dialog;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z3) {
            if (z3) {
                AddDaysActivity.this.s(this.$service, this.$dialog);
                return;
            }
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                String packageName = AddDaysActivity.this.getPackageName();
                intent.setData(Uri.parse("package:" + packageName));
                AddDaysActivity.this.startActivityForResult(intent, 2);
                ToastCompat.makeText(AddDaysActivity.this.getApplicationContext(), (int) R.string.navigate_to_location_permissions_and_allow_all_the_time, 1).show();
            } catch (ActivityNotFoundException unused) {
                ToastCompat.makeText(AddDaysActivity.this.getApplicationContext(), (CharSequence) "android.settings.APPLICATION_DETAILS_SETTINGS not supported on this device", 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AddDaysActivity.kt */
    /* loaded from: classes3.dex */
    public static final class i extends Lambda implements Function1<PermissionStatus, Unit> {
        final /* synthetic */ Dialog $dialog;
        final /* synthetic */ DataSharingService $service;
        final /* synthetic */ List<String> $standardPermissions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(DataSharingService dataSharingService, List<String> list, Dialog dialog) {
            super(1);
            this.$service = dataSharingService;
            this.$standardPermissions = list;
            this.$dialog = dialog;
        }

        public final void a(@NotNull PermissionStatus it) {
            Intrinsics.checkNotNullParameter(it, "it");
            if (!it.getGranted().isEmpty()) {
                AddDaysActivity.this.f12162i = this.$service;
                if (this.$standardPermissions.contains("android.permission.ACCESS_FINE_LOCATION")) {
                    AddDaysActivity.this.E(this.$service, this.$dialog);
                } else {
                    AddDaysActivity.this.s(this.$service, this.$dialog);
                }
            } else if (it.getDenied().contains("android.permission.ACCESS_FINE_LOCATION")) {
                AddDaysActivity.this.E(this.$service, this.$dialog);
            } else {
                AddDaysActivity addDaysActivity = AddDaysActivity.this;
                ToastCompat.makeText((Context) addDaysActivity, (CharSequence) addDaysActivity.getString(R.string.permission_denied), 1).show();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PermissionStatus permissionStatus) {
            a(permissionStatus);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AddDaysActivity.kt */
    /* loaded from: classes3.dex */
    public static final class j extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ DataSharingService $service;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(DataSharingService dataSharingService, Continuation<? super j> continuation) {
            super(3, continuation);
            this.$service = dataSharingService;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new j(this.$service, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AddDaysActivity.this.R(this.$service);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AddDaysActivity.kt */
    /* loaded from: classes3.dex */
    public static final class k extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ DataSharingService $service;
        int label;
        final /* synthetic */ AddDaysActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(AppCompatDialog appCompatDialog, AddDaysActivity addDaysActivity, DataSharingService dataSharingService, Continuation<? super k> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
            this.this$0 = addDaysActivity;
            this.$service = dataSharingService;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new k(this.$dialog, this.this$0, this.$service, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$dialog.dismiss();
                this.this$0.G(this.$service, this.$dialog);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AddDaysActivity.kt */
    /* loaded from: classes3.dex */
    public static final class l extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(AppCompatDialog appCompatDialog, Continuation<? super l> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new l(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
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

    private final void A() {
        ActivityAddDaysBinding activityAddDaysBinding = this.f12159f;
        if (activityAddDaysBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding = null;
        }
        ProgressBar progressBar = activityAddDaysBinding.loadAdvertSpinner;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadAdvertSpinner");
        progressBar.setVisibility(0);
        ActivityAddDaysBinding activityAddDaysBinding2 = this.f12159f;
        if (activityAddDaysBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding2 = null;
        }
        activityAddDaysBinding2.watchAdvertButton.setText(getString(R.string.initialising));
        ActivityAddDaysBinding activityAddDaysBinding3 = this.f12159f;
        if (activityAddDaysBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding3 = null;
        }
        activityAddDaysBinding3.watchAdvertButton.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.white_transparent));
        this.f12161h = null;
        C(this, false, 1, null);
        ActivityAddDaysBinding activityAddDaysBinding4 = this.f12159f;
        if (activityAddDaysBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding4 = null;
        }
        Button button = activityAddDaysBinding4.watchAdvertButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.watchAdvertButton");
        ViewExtensionsKt.onClick$default(button, null, new e(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(final boolean z3) {
        this.f12161h = null;
        String string = getString(R.string.reward_ad_add_days_id);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.reward_ad_add_days_id)");
        AdRequest build = new AdRequest.Builder().build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().build()");
        RewardedAd.load(this, string, build, new RewardedAdLoadCallback() { // from class: com.arlosoft.macrodroid.freeversion.AddDaysActivity$loadRewardAd$1
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(@NotNull LoadAdError adError) {
                ActivityAddDaysBinding activityAddDaysBinding;
                ActivityAddDaysBinding activityAddDaysBinding2;
                ActivityAddDaysBinding activityAddDaysBinding3;
                ActivityAddDaysBinding activityAddDaysBinding4;
                ActivityAddDaysBinding activityAddDaysBinding5;
                ActivityAddDaysBinding activityAddDaysBinding6;
                ActivityAddDaysBinding activityAddDaysBinding7;
                ActivityAddDaysBinding activityAddDaysBinding8;
                Intrinsics.checkNotNullParameter(adError, "adError");
                Timber.e("Failed to load reward advert: %s", adError.toString());
                ActivityAddDaysBinding activityAddDaysBinding9 = null;
                AddDaysActivity.this.f12161h = null;
                if (AddDaysActivity.this.getFreeVersionHelper().getRoundedDaysRemaining() >= 2 || !z3) {
                    activityAddDaysBinding = AddDaysActivity.this.f12159f;
                    if (activityAddDaysBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityAddDaysBinding = null;
                    }
                    ProgressBar progressBar = activityAddDaysBinding.loadAdvertSpinner;
                    Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadAdvertSpinner");
                    progressBar.setVisibility(8);
                    activityAddDaysBinding2 = AddDaysActivity.this.f12159f;
                    if (activityAddDaysBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityAddDaysBinding2 = null;
                    }
                    activityAddDaysBinding2.watchAdvertButton.setText(AddDaysActivity.this.getString(R.string.no_adverts_available));
                    activityAddDaysBinding3 = AddDaysActivity.this.f12159f;
                    if (activityAddDaysBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityAddDaysBinding3 = null;
                    }
                    activityAddDaysBinding3.watchAdvertButton.setEnabled(false);
                    activityAddDaysBinding4 = AddDaysActivity.this.f12159f;
                    if (activityAddDaysBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityAddDaysBinding9 = activityAddDaysBinding4;
                    }
                    activityAddDaysBinding9.watchAdvertButton.setBackgroundTintList(ContextCompat.getColorStateList(AddDaysActivity.this, R.color.white_transparent));
                    return;
                }
                AddDaysActivity.this.f12160g = true;
                activityAddDaysBinding5 = AddDaysActivity.this.f12159f;
                if (activityAddDaysBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityAddDaysBinding5 = null;
                }
                Button button = activityAddDaysBinding5.watchAdvertButton;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string2 = AddDaysActivity.this.getString(R.string.watch_advert_button);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.watch_advert_button)");
                String format = String.format(string2, Arrays.copyOf(new Object[]{Long.valueOf(AddDaysActivity.this.getRemoteConfig().getRewardAdvertAdditionalDays())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                button.setText(format);
                activityAddDaysBinding6 = AddDaysActivity.this.f12159f;
                if (activityAddDaysBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityAddDaysBinding6 = null;
                }
                ProgressBar progressBar2 = activityAddDaysBinding6.loadAdvertSpinner;
                Intrinsics.checkNotNullExpressionValue(progressBar2, "binding.loadAdvertSpinner");
                progressBar2.setVisibility(8);
                activityAddDaysBinding7 = AddDaysActivity.this.f12159f;
                if (activityAddDaysBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityAddDaysBinding7 = null;
                }
                activityAddDaysBinding7.watchAdvertButton.setEnabled(true);
                activityAddDaysBinding8 = AddDaysActivity.this.f12159f;
                if (activityAddDaysBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityAddDaysBinding9 = activityAddDaysBinding8;
                }
                activityAddDaysBinding9.watchAdvertButton.setBackgroundTintList(ContextCompat.getColorStateList(AddDaysActivity.this, R.color.white));
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(@NotNull RewardedAd ad) {
                ActivityAddDaysBinding activityAddDaysBinding;
                ActivityAddDaysBinding activityAddDaysBinding2;
                ActivityAddDaysBinding activityAddDaysBinding3;
                ActivityAddDaysBinding activityAddDaysBinding4;
                Intrinsics.checkNotNullParameter(ad, "ad");
                AddDaysActivity.this.f12161h = ad;
                AddDaysActivity.this.f12160g = false;
                activityAddDaysBinding = AddDaysActivity.this.f12159f;
                ActivityAddDaysBinding activityAddDaysBinding5 = null;
                if (activityAddDaysBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityAddDaysBinding = null;
                }
                Button button = activityAddDaysBinding.watchAdvertButton;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string2 = AddDaysActivity.this.getString(R.string.watch_advert_button);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.watch_advert_button)");
                String format = String.format(string2, Arrays.copyOf(new Object[]{Long.valueOf(AddDaysActivity.this.getRemoteConfig().getRewardAdvertAdditionalDays())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                button.setText(format);
                activityAddDaysBinding2 = AddDaysActivity.this.f12159f;
                if (activityAddDaysBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityAddDaysBinding2 = null;
                }
                ProgressBar progressBar = activityAddDaysBinding2.loadAdvertSpinner;
                Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadAdvertSpinner");
                progressBar.setVisibility(8);
                activityAddDaysBinding3 = AddDaysActivity.this.f12159f;
                if (activityAddDaysBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityAddDaysBinding3 = null;
                }
                activityAddDaysBinding3.watchAdvertButton.setEnabled(true);
                activityAddDaysBinding4 = AddDaysActivity.this.f12159f;
                if (activityAddDaysBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityAddDaysBinding5 = activityAddDaysBinding4;
                }
                activityAddDaysBinding5.watchAdvertButton.setBackgroundTintList(ContextCompat.getColorStateList(AddDaysActivity.this, R.color.white));
            }
        });
    }

    static /* synthetic */ void C(AddDaysActivity addDaysActivity, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = true;
        }
        addDaysActivity.B(z3);
    }

    private final void D(DataSharingService dataSharingService) {
        String joinToString$default;
        ActivityAddDaysBinding activityAddDaysBinding = this.f12159f;
        if (activityAddDaysBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding = null;
        }
        TextView textView = activityAddDaysBinding.dataSharingInformation;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.share_anonymous_app_data_description);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.share…ous_app_data_description)");
        String format = String.format(string, Arrays.copyOf(new Object[]{dataSharingService.getServiceName()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        String string2 = getString(R.string.share_anonymous_requires_the_following_permissions);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.share…he_following_permissions)");
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(dataSharingService.getPermissionsAsString(resources), "\n• ", null, null, 0, null, null, 62, null);
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{"\n\n• " + joinToString$default}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        textView.setText(format + "\n\n" + format2);
        ActivityAddDaysBinding activityAddDaysBinding2 = this.f12159f;
        if (activityAddDaysBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding2 = null;
        }
        TextView textView2 = activityAddDaysBinding2.whatDataIsShared;
        ActivityAddDaysBinding activityAddDaysBinding3 = this.f12159f;
        if (activityAddDaysBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding3 = null;
        }
        textView2.setPaintFlags(activityAddDaysBinding3.whatDataIsShared.getPaintFlags() | 8);
        ActivityAddDaysBinding activityAddDaysBinding4 = this.f12159f;
        if (activityAddDaysBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding4 = null;
        }
        TextView textView3 = activityAddDaysBinding4.whatDataIsShared;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.whatDataIsShared");
        ViewExtensionsKt.onClick$default(textView3, null, new f(dataSharingService, null), 1, null);
        ActivityAddDaysBinding activityAddDaysBinding5 = this.f12159f;
        if (activityAddDaysBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding5 = null;
        }
        Button button = activityAddDaysBinding5.shareDataButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.shareDataButton");
        ViewExtensionsKt.onClick$default(button, null, new g(dataSharingService, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(DataSharingService dataSharingService, Dialog dialog) {
        if (Build.VERSION.SDK_INT <= 28) {
            s(dataSharingService, dialog);
        } else if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
            DataSharingService dataSharingService2 = this.f12162i;
            if (dataSharingService2 != null) {
                s(dataSharingService2, null);
            }
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            Observable<Boolean> observeOn = new RxPermissions(this).request("android.permission.ACCESS_BACKGROUND_LOCATION").observeOn(AndroidSchedulers.mainThread());
            final h hVar = new h(dataSharingService, dialog);
            observeOn.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.freeversion.e
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    AddDaysActivity.F(Function1.this, obj);
                }
            });
        } else {
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                String packageName = getPackageName();
                intent.setData(Uri.parse("package:" + packageName));
                startActivityForResult(intent, 2);
                ToastCompat.makeText(getApplicationContext(), (int) R.string.navigate_to_location_permissions_and_allow_all_the_time, 1).show();
            } catch (ActivityNotFoundException unused) {
                ToastCompat.makeText(getApplicationContext(), (CharSequence) "android.settings.APPLICATION_DETAILS_SETTINGS not supported on this device", 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(DataSharingService dataSharingService, Dialog dialog) {
        List listOf;
        ArrayList arrayList = new ArrayList();
        for (DataSharingPermission dataSharingPermission : dataSharingService.getListOfPermissions()) {
            if (WhenMappings.$EnumSwitchMapping$0[dataSharingPermission.ordinal()] == 1) {
                listOf = kotlin.collections.e.listOf("android.permission.ACCESS_FINE_LOCATION");
                arrayList.addAll(listOf);
            }
        }
        if (!arrayList.isEmpty()) {
            ExcuseMe.Companion couldYouGive = ExcuseMe.Companion.couldYouGive((Activity) this);
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            couldYouGive.permissionFor((String[]) Arrays.copyOf(strArr, strArr.length), new i(dataSharingService, arrayList, dialog));
            return;
        }
        s(dataSharingService, dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(DataSharingService dataSharingService) {
        String joinToString$default;
        AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog);
        appCompatDialog.setTitle(R.string.share_anonymous_app_data);
        appCompatDialog.setContentView(R.layout.dialog_confirm_data_sharing);
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog, 0, 1, null);
        View findViewById = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById);
        final Button button = (Button) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById2);
        View findViewById3 = appCompatDialog.findViewById(R.id.what_data_is_shared);
        Intrinsics.checkNotNull(findViewById3);
        TextView textView = (TextView) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.confirm_checkbox);
        Intrinsics.checkNotNull(findViewById4);
        CheckBox checkBox = (CheckBox) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.permissions_text);
        Intrinsics.checkNotNull(findViewById5);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(dataSharingService.getPermissionsAsString(resources), "\n", null, null, 0, null, null, 62, null);
        ((TextView) findViewById5).setText(joinToString$default);
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        ViewExtensionsKt.onClick$default(textView, null, new j(dataSharingService, null), 1, null);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.share_data_confirm_prompt);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.share_data_confirm_prompt)");
        String format = String.format(string, Arrays.copyOf(new Object[]{dataSharingService.getServiceName()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        checkBox.setText(format);
        button.setEnabled(false);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.freeversion.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                AddDaysActivity.I(button, compoundButton, z3);
            }
        });
        ViewExtensionsKt.onClick$default(button, null, new k(appCompatDialog, this, dataSharingService, null), 1, null);
        ViewExtensionsKt.onClick$default((Button) findViewById2, null, new l(appCompatDialog, null), 1, null);
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Button okButton, CompoundButton compoundButton, boolean z3) {
        Intrinsics.checkNotNullParameter(okButton, "$okButton");
        okButton.setEnabled(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.share_anonymous_app_data);
        builder.setMessage(R.string.disabling_data_sharing_warning);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.freeversion.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AddDaysActivity.K(AddDaysActivity.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(AddDaysActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DataSharingService enabledDataSharingService = this$0.getFreeVersionHelper().getEnabledDataSharingService();
        if (enabledDataSharingService != null) {
            enabledDataSharingService.getDataPartner().disableDataSharing(false);
        }
        this$0.getFreeVersionHelper().setEnabledDataSharingService(DataSharingService.NONE);
        if (this$0.getFreeVersionHelper().haveFreeDaysExpired()) {
            Settings.setMacroDroidEnabled(this$0, false);
            Macro.setMacroDroidEnabledState(false);
            MacroStore.getInstance().updateEnabledStateOfAllCompletedMacros();
            EventBusUtils.getEventBus().post(new MacroDroidDisabledEvent());
        }
        this$0.t();
    }

    private final void L(int i4) {
        ActivityAddDaysBinding activityAddDaysBinding = this.f12159f;
        if (activityAddDaysBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding = null;
        }
        LinearLayout linearLayout = activityAddDaysBinding.topLevelContainer;
        String string = getString(R.string.free_days_added);
        SnackbarAnimate make = SnackbarAnimate.make(linearLayout, string + " (" + i4 + ")", 5000);
        Intrinsics.checkNotNullExpressionValue(make, "make(binding.topLevelCon…+ \" ($daysAdded)\" , 5000)");
        make.getView().setBackgroundResource(R.color.md_light_blue_600);
        make.show();
    }

    private final void M(String str) {
        if (this.f12163j != null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(str);
        builder.setMessage(R.string.do_you_wish_to_renable_macrodroid);
        builder.setPositiveButton(R.string.dialog_option_yes, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.freeversion.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AddDaysActivity.N(AddDaysActivity.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(R.string.dialog_option_no, (DialogInterface.OnClickListener) null);
        this.f12163j = builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(AddDaysActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u();
        this$0.f12163j = null;
    }

    private final void O(final DataSharingService dataSharingService) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.usage_access_required);
        builder.setMessage(R.string.please_enable_usage_access);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.freeversion.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AddDaysActivity.P(AddDaysActivity.this, dataSharingService, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(AddDaysActivity this$0, DataSharingService service, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(service, "$service");
        this$0.Q(service);
    }

    private final void Q(DataSharingService dataSharingService) {
        Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
        intent.addFlags(268435456);
        try {
            this.f12164k = dataSharingService;
            startActivity(intent);
        } catch (Exception unused) {
            ToastCompat.makeText(getApplicationContext(), (CharSequence) getString(R.string.cannot_launch_accessibility_settings), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(DataSharingService dataSharingService) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.data_partner_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.data_partner_name)");
        String format = String.format(string, Arrays.copyOf(new Object[]{"<a href=\"" + dataSharingService.getServiceWebsite() + "\">" + dataSharingService.getServiceName() + "</a>"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        String str = format + "<br/><br/>" + getString(dataSharingService.getDataSharingInfoRes());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.what_data_shared_short_title);
        builder.setMessage(Html.fromHtml(str));
        builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
        ((TextView) builder.show().findViewById(16908299)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void S() {
        ActivityAddDaysBinding activityAddDaysBinding = this.f12159f;
        if (activityAddDaysBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding = null;
        }
        activityAddDaysBinding.title.setText(getFreeVersionHelper().getTimeRemainingText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        getFreeVersionHelper().addExtraDays((int) getRemoteConfig().getRewardAdvertAdditionalDays());
        S();
        if (!Settings.getMacroDroidEnabled(this)) {
            String string = getString(R.string.free_days_added);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.free_days_added)");
            M(string);
        }
        L((int) getRemoteConfig().getRewardAdvertAdditionalDays());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(DataSharingService dataSharingService, Dialog dialog) {
        if (dataSharingService.getListOfPermissions().contains(DataSharingPermission.LOCATION_SERVICES) && !getPermissionChecker().isLocationServicesEnabled()) {
            try {
                startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            } catch (ActivityNotFoundException unused) {
                ToastCompat.makeText(getApplicationContext(), (CharSequence) "Location source settings not available", 1).show();
            }
        } else if (dataSharingService.getListOfPermissions().contains(DataSharingPermission.USAGE_ACCESS) && !getPermissionChecker().isUsageAccessEnabled()) {
            O(dataSharingService);
        } else {
            getFreeVersionHelper().setEnabledDataSharingService(dataSharingService);
            t();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    private final void t() {
        int i4;
        Object first;
        DataSharingService enabledDataSharingService = getFreeVersionHelper().getEnabledDataSharingService();
        if (enabledDataSharingService != DataSharingService.NONE) {
            ActivityAddDaysBinding activityAddDaysBinding = this.f12159f;
            if (activityAddDaysBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityAddDaysBinding = null;
            }
            activityAddDaysBinding.title.setText(getString(R.string.unlimited_free_usage_enabled));
            ActivityAddDaysBinding activityAddDaysBinding2 = this.f12159f;
            if (activityAddDaysBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityAddDaysBinding2 = null;
            }
            MaterialCardView materialCardView = activityAddDaysBinding2.anonymousDataEnabledCard;
            Intrinsics.checkNotNullExpressionValue(materialCardView, "binding.anonymousDataEnabledCard");
            materialCardView.setVisibility(0);
            ActivityAddDaysBinding activityAddDaysBinding3 = this.f12159f;
            if (activityAddDaysBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityAddDaysBinding3 = null;
            }
            MaterialCardView materialCardView2 = activityAddDaysBinding3.dataSharingCard;
            Intrinsics.checkNotNullExpressionValue(materialCardView2, "binding.dataSharingCard");
            materialCardView2.setVisibility(8);
            ActivityAddDaysBinding activityAddDaysBinding4 = this.f12159f;
            if (activityAddDaysBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityAddDaysBinding4 = null;
            }
            MaterialCardView materialCardView3 = activityAddDaysBinding4.rewardAdvertsCard;
            Intrinsics.checkNotNullExpressionValue(materialCardView3, "binding.rewardAdvertsCard");
            materialCardView3.setVisibility(8);
            ActivityAddDaysBinding activityAddDaysBinding5 = this.f12159f;
            if (activityAddDaysBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityAddDaysBinding5 = null;
            }
            TextView textView = activityAddDaysBinding5.freeUsageInfoText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.freeUsageInfoText");
            textView.setVisibility(8);
            ActivityAddDaysBinding activityAddDaysBinding6 = this.f12159f;
            if (activityAddDaysBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityAddDaysBinding6 = null;
            }
            MaterialCardView materialCardView4 = activityAddDaysBinding6.surveysCard;
            Intrinsics.checkNotNullExpressionValue(materialCardView4, "binding.surveysCard");
            materialCardView4.setVisibility(8);
            if (!Settings.getMacroDroidEnabled(this)) {
                String string = getString(R.string.unlimited_free_usage_enabled);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.unlimited_free_usage_enabled)");
                M(string);
            }
        } else {
            ActivityAddDaysBinding activityAddDaysBinding7 = this.f12159f;
            if (activityAddDaysBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityAddDaysBinding7 = null;
            }
            MaterialCardView materialCardView5 = activityAddDaysBinding7.anonymousDataEnabledCard;
            Intrinsics.checkNotNullExpressionValue(materialCardView5, "binding.anonymousDataEnabledCard");
            materialCardView5.setVisibility(8);
            ActivityAddDaysBinding activityAddDaysBinding8 = this.f12159f;
            if (activityAddDaysBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityAddDaysBinding8 = null;
            }
            MaterialCardView materialCardView6 = activityAddDaysBinding8.dataSharingCard;
            Intrinsics.checkNotNullExpressionValue(materialCardView6, "binding.dataSharingCard");
            materialCardView6.setVisibility(0);
            ActivityAddDaysBinding activityAddDaysBinding9 = this.f12159f;
            if (activityAddDaysBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityAddDaysBinding9 = null;
            }
            MaterialCardView materialCardView7 = activityAddDaysBinding9.rewardAdvertsCard;
            Intrinsics.checkNotNullExpressionValue(materialCardView7, "binding.rewardAdvertsCard");
            materialCardView7.setVisibility(0);
            ActivityAddDaysBinding activityAddDaysBinding10 = this.f12159f;
            if (activityAddDaysBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityAddDaysBinding10 = null;
            }
            TextView textView2 = activityAddDaysBinding10.freeUsageInfoText;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.freeUsageInfoText");
            textView2.setVisibility(0);
            ActivityAddDaysBinding activityAddDaysBinding11 = this.f12159f;
            if (activityAddDaysBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityAddDaysBinding11 = null;
            }
            activityAddDaysBinding11.dataSharingCard.setStrokeWidth(0);
            ActivityAddDaysBinding activityAddDaysBinding12 = this.f12159f;
            if (activityAddDaysBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityAddDaysBinding12 = null;
            }
            MaterialCardView materialCardView8 = activityAddDaysBinding12.surveysCard;
            Intrinsics.checkNotNullExpressionValue(materialCardView8, "binding.surveysCard");
            if (getFreeVersionHelper().isPollfishEnabled()) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            materialCardView8.setVisibility(i4);
            List<DataSharingService> availableDataSharingServices = getFreeVersionHelper().getAvailableDataSharingServices();
            if (availableDataSharingServices.isEmpty()) {
                ActivityAddDaysBinding activityAddDaysBinding13 = this.f12159f;
                if (activityAddDaysBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityAddDaysBinding13 = null;
                }
                MaterialCardView materialCardView9 = activityAddDaysBinding13.dataSharingCard;
                Intrinsics.checkNotNullExpressionValue(materialCardView9, "binding.dataSharingCard");
                materialCardView9.setVisibility(8);
            } else {
                ActivityAddDaysBinding activityAddDaysBinding14 = this.f12159f;
                if (activityAddDaysBinding14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityAddDaysBinding14 = null;
                }
                MaterialCardView materialCardView10 = activityAddDaysBinding14.dataSharingCard;
                Intrinsics.checkNotNullExpressionValue(materialCardView10, "binding.dataSharingCard");
                materialCardView10.setVisibility(0);
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) availableDataSharingServices);
                D((DataSharingService) first);
            }
            S();
        }
        ActivityAddDaysBinding activityAddDaysBinding15 = this.f12159f;
        if (activityAddDaysBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding15 = null;
        }
        ImageButton imageButton = activityAddDaysBinding15.backButton;
        Intrinsics.checkNotNullExpressionValue(imageButton, "binding.backButton");
        ViewExtensionsKt.onClick$default(imageButton, null, new a(null), 1, null);
        ActivityAddDaysBinding activityAddDaysBinding16 = this.f12159f;
        if (activityAddDaysBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding16 = null;
        }
        TextView textView3 = activityAddDaysBinding16.currentlySharingText;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string2 = getString(R.string.currently_sharing_anonymous_data_with_data_ai);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.curre…nymous_data_with_data_ai)");
        String format = String.format(string2, Arrays.copyOf(new Object[]{enabledDataSharingService.getServiceName()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView3.setText(format);
        ActivityAddDaysBinding activityAddDaysBinding17 = this.f12159f;
        if (activityAddDaysBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding17 = null;
        }
        Button button = activityAddDaysBinding17.disableDataSharingButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.disableDataSharingButton");
        ViewExtensionsKt.onClick$default(button, null, new b(null), 1, null);
        ActivityAddDaysBinding activityAddDaysBinding18 = this.f12159f;
        if (activityAddDaysBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding18 = null;
        }
        TextView textView4 = activityAddDaysBinding18.rewardAdvertDescription;
        String string3 = getString(R.string.reward_advert_description);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.reward_advert_description)");
        String format2 = String.format(string3, Arrays.copyOf(new Object[]{Long.valueOf(getRemoteConfig().getRewardAdvertAdditionalDays())}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        textView4.setText(format2);
        ActivityAddDaysBinding activityAddDaysBinding19 = this.f12159f;
        if (activityAddDaysBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding19 = null;
        }
        Button button2 = activityAddDaysBinding19.takeSurveyButton;
        Intrinsics.checkNotNullExpressionValue(button2, "binding.takeSurveyButton");
        ViewExtensionsKt.onClick$default(button2, null, new c(null), 1, null);
        ActivityAddDaysBinding activityAddDaysBinding20 = this.f12159f;
        if (activityAddDaysBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding20 = null;
        }
        TextView textView5 = activityAddDaysBinding20.surveysDescription;
        String string4 = getString(R.string.surveys_description);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.surveys_description)");
        String format3 = String.format(string4, Arrays.copyOf(new Object[]{Long.valueOf(getRemoteConfig().getPollFishSurveyAdditionalDays())}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
        textView5.setText(format3);
        ActivityAddDaysBinding activityAddDaysBinding21 = this.f12159f;
        if (activityAddDaysBinding21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding21 = null;
        }
        Button button3 = activityAddDaysBinding21.upgradeToProButton;
        Intrinsics.checkNotNullExpressionValue(button3, "binding.upgradeToProButton");
        ViewExtensionsKt.onClick$default(button3, null, new d(null), 1, null);
    }

    private final void u() {
        Settings.setMacroDroidEnabled(this, true);
        Macro.setMacroDroidEnabledState(true);
        MacroDroidService.Companion.startService(this);
        MacroStore.getInstance().updateEnabledStateOfAllCompletedMacros();
        ToastCompat.makeText((Context) this, (CharSequence) getString(R.string.macrodroid_enabled), 0).show();
        FirebaseAnalyticsEventLogger.logMainSwitchToggle(true);
        if (Settings.isDrawerEnabled(this)) {
            stopService(new Intent(this, DrawerOverlayHandleService.class));
            startService(new Intent(this, DrawerOverlayHandleService.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(SurveyInfo surveyInfo) {
        FirebaseAnalyticsEventLogger.logPollfishSurveyAvailable();
        Timber.d("Pollfish survey available: " + surveyInfo, new Object[0]);
        ActivityAddDaysBinding activityAddDaysBinding = this.f12159f;
        ActivityAddDaysBinding activityAddDaysBinding2 = null;
        if (activityAddDaysBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding = null;
        }
        ProgressBar progressBar = activityAddDaysBinding.takeSurveySpinner;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.takeSurveySpinner");
        progressBar.setVisibility(8);
        ActivityAddDaysBinding activityAddDaysBinding3 = this.f12159f;
        if (activityAddDaysBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding3 = null;
        }
        activityAddDaysBinding3.takeSurveyButton.setEnabled(true);
        ActivityAddDaysBinding activityAddDaysBinding4 = this.f12159f;
        if (activityAddDaysBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding4 = null;
        }
        Button button = activityAddDaysBinding4.takeSurveyButton;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.take_survey);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.take_survey)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(getRemoteConfig().getPollFishSurveyAdditionalDays())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        button.setText(format);
        ActivityAddDaysBinding activityAddDaysBinding5 = this.f12159f;
        if (activityAddDaysBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityAddDaysBinding2 = activityAddDaysBinding5;
        }
        activityAddDaysBinding2.takeSurveyButton.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.white));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(SurveyInfo surveyInfo) {
        Timber.d("Pollfish survey complete: " + surveyInfo, new Object[0]);
        z();
        getFreeVersionHelper().addExtraDays((int) getRemoteConfig().getPollFishSurveyAdditionalDays());
        L((int) getRemoteConfig().getPollFishSurveyAdditionalDays());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        FirebaseAnalyticsEventLogger.logPollfishSurveyNotAvailable();
        Timber.d("Pollfish not available", new Object[0]);
        ActivityAddDaysBinding activityAddDaysBinding = this.f12159f;
        ActivityAddDaysBinding activityAddDaysBinding2 = null;
        if (activityAddDaysBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding = null;
        }
        ProgressBar progressBar = activityAddDaysBinding.takeSurveySpinner;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.takeSurveySpinner");
        progressBar.setVisibility(8);
        ActivityAddDaysBinding activityAddDaysBinding3 = this.f12159f;
        if (activityAddDaysBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding3 = null;
        }
        activityAddDaysBinding3.takeSurveyButton.setText(getString(R.string.no_surveys_available));
        ActivityAddDaysBinding activityAddDaysBinding4 = this.f12159f;
        if (activityAddDaysBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityAddDaysBinding2 = activityAddDaysBinding4;
        }
        activityAddDaysBinding2.takeSurveyButton.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        Timber.d("Pollfish not eligible", new Object[0]);
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        ActivityAddDaysBinding activityAddDaysBinding = null;
        if (!getFreeVersionHelper().isPollfishEnabled()) {
            ActivityAddDaysBinding activityAddDaysBinding2 = this.f12159f;
            if (activityAddDaysBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityAddDaysBinding = activityAddDaysBinding2;
            }
            MaterialCardView materialCardView = activityAddDaysBinding.surveysCard;
            Intrinsics.checkNotNullExpressionValue(materialCardView, "binding.surveysCard");
            materialCardView.setVisibility(8);
            return;
        }
        ActivityAddDaysBinding activityAddDaysBinding3 = this.f12159f;
        if (activityAddDaysBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding3 = null;
        }
        ProgressBar progressBar = activityAddDaysBinding3.takeSurveySpinner;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.takeSurveySpinner");
        progressBar.setVisibility(0);
        ActivityAddDaysBinding activityAddDaysBinding4 = this.f12159f;
        if (activityAddDaysBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding4 = null;
        }
        activityAddDaysBinding4.takeSurveyButton.setText(getString(R.string.initialising));
        ActivityAddDaysBinding activityAddDaysBinding5 = this.f12159f;
        if (activityAddDaysBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAddDaysBinding5 = null;
        }
        activityAddDaysBinding5.takeSurveyButton.setEnabled(true);
        ActivityAddDaysBinding activityAddDaysBinding6 = this.f12159f;
        if (activityAddDaysBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityAddDaysBinding = activityAddDaysBinding6;
        }
        activityAddDaysBinding.takeSurveyButton.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.white_transparent));
        Pollfish.Companion.initWith(this, new Params.Builder("c5441360-1d88-4af6-b909-d60b8d74fbb6").pollfishSurveyReceivedListener(new PollfishSurveyReceivedListener() { // from class: com.arlosoft.macrodroid.freeversion.AddDaysActivity$initialisePollfish$params$1
            @Override // com.pollfish.callback.PollfishSurveyReceivedListener
            public void onPollfishSurveyReceived(@Nullable SurveyInfo surveyInfo) {
                AddDaysActivity.this.v(surveyInfo);
            }
        }).pollfishSurveyCompletedListener(new PollfishSurveyCompletedListener() { // from class: com.arlosoft.macrodroid.freeversion.AddDaysActivity$initialisePollfish$params$2
            @Override // com.pollfish.callback.PollfishSurveyCompletedListener
            public void onPollfishSurveyCompleted(@NotNull SurveyInfo surveyInfo) {
                Intrinsics.checkNotNullParameter(surveyInfo, "surveyInfo");
                AddDaysActivity.this.w(surveyInfo);
            }
        }).pollfishUserNotEligibleListener(new PollfishUserNotEligibleListener() { // from class: com.arlosoft.macrodroid.freeversion.AddDaysActivity$initialisePollfish$params$3
            @Override // com.pollfish.callback.PollfishUserNotEligibleListener
            public void onUserNotEligible() {
                AddDaysActivity.this.y();
            }
        }).pollfishSurveyNotAvailableListener(new PollfishSurveyNotAvailableListener() { // from class: com.arlosoft.macrodroid.freeversion.AddDaysActivity$initialisePollfish$params$4
            @Override // com.pollfish.callback.PollfishSurveyNotAvailableListener
            public void onPollfishSurveyNotAvailable() {
                AddDaysActivity.this.x();
            }
        }).pollfishUserRejectedSurveyListener(new PollfishUserRejectedSurveyListener() { // from class: com.arlosoft.macrodroid.freeversion.AddDaysActivity$initialisePollfish$params$5
            @Override // com.pollfish.callback.PollfishUserRejectedSurveyListener
            public void onUserRejectedSurvey() {
                AddDaysActivity.this.z();
            }
        }).releaseMode(true).rewardMode(true).build());
    }

    @NotNull
    public final FreeVersionHelper getFreeVersionHelper() {
        FreeVersionHelper freeVersionHelper = this.freeVersionHelper;
        if (freeVersionHelper != null) {
            return freeVersionHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("freeVersionHelper");
        return null;
    }

    @NotNull
    public final PermissionChecker getPermissionChecker() {
        PermissionChecker permissionChecker = this.permissionChecker;
        if (permissionChecker != null) {
            return permissionChecker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("permissionChecker");
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        DataSharingService dataSharingService;
        if (i4 != 0) {
            if (i4 == 2 && ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0 && (dataSharingService = this.f12162i) != null) {
                s(dataSharingService, null);
            }
        } else if (i5 == -1) {
            r();
            FirebaseAnalyticsEventLogger.INSTANCE.logRewardAdvertCompleted(true);
        }
        super.onActivityResult(i4, i5, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityAddDaysBinding inflate = ActivityAddDaysBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f12159f = inflate;
        ActivityAddDaysBinding activityAddDaysBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        ActivityAddDaysBinding activityAddDaysBinding2 = this.f12159f;
        if (activityAddDaysBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityAddDaysBinding = activityAddDaysBinding2;
        }
        setSupportActionBar(activityAddDaysBinding.toolbar);
        Timber.d("Initialising Pollfish", new Object[0]);
        A();
        z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        DataSharingService dataSharingService = this.f12164k;
        if (dataSharingService != null) {
            s(dataSharingService, null);
            this.f12164k = null;
        }
        t();
    }

    public final void setFreeVersionHelper(@NotNull FreeVersionHelper freeVersionHelper) {
        Intrinsics.checkNotNullParameter(freeVersionHelper, "<set-?>");
        this.freeVersionHelper = freeVersionHelper;
    }

    public final void setPermissionChecker(@NotNull PermissionChecker permissionChecker) {
        Intrinsics.checkNotNullParameter(permissionChecker, "<set-?>");
        this.permissionChecker = permissionChecker;
    }

    public final void setRemoteConfig(@NotNull RemoteConfig remoteConfig) {
        Intrinsics.checkNotNullParameter(remoteConfig, "<set-?>");
        this.remoteConfig = remoteConfig;
    }
}
