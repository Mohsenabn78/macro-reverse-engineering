package com.arlosoft.macrodroid.extras.stopclub;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.araujo.jordan.excuseme.ExcuseMe;
import com.araujo.jordan.excuseme.model.PermissionStatus;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.accessibility.AccessibilityServiceState;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.confirmation.PurchaseValidator;
import com.arlosoft.macrodroid.database.room.LogLevel;
import com.arlosoft.macrodroid.databinding.ActivityStopclubBinding;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.RefreshStopClubEvent;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.IntExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.extras.ExtrasDownloader;
import com.arlosoft.macrodroid.extras.data.ExtraPackage;
import com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState;
import com.arlosoft.macrodroid.extras.data.ExtraPermissions;
import com.arlosoft.macrodroid.extras.data.ExtraVersionHistoryEntry;
import com.arlosoft.macrodroid.extras.data.ExtrasViewState;
import com.arlosoft.macrodroid.extras.data.StringWithLanguages;
import com.arlosoft.macrodroid.extras.data.SupportChannel;
import com.arlosoft.macrodroid.extras.data.SupportChannelType;
import com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel;
import com.arlosoft.macrodroid.extras.ui.ExtraPackageClickListener;
import com.arlosoft.macrodroid.extras.ui.management.ExtrasManager;
import com.arlosoft.macrodroid.logging.systemlog.SystemLogHelper;
import com.arlosoft.macrodroid.remoteconfig.ExtraMinVersion;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.troubleshooting.problem.PermissionChecker;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import com.arlosoft.macrodroid.upgrade.billing.SubscriptionPrice;
import com.arlosoft.macrodroid.upgrade.model.SubscriptionCheckStatus;
import com.arlosoft.macrodroid.utils.FileUtils;
import com.arlosoft.macrodroid.utils.gradients.Gradients;
import com.bumptech.glide.Glide;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.jaredrummler.android.device.DeviceName;
import java.io.File;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.zeroturnaround.zip.ZipUtil;
import xyz.kumaraswamy.autostart.Autostart;

/* compiled from: StopClubActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nStopClubActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StopClubActivity.kt\ncom/arlosoft/macrodroid/extras/stopclub/StopClubActivity\n+ 2 ContextUtils.kt\norg/jetbrains/anko/ContextUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 7 CustomViewProperties.kt\norg/jetbrains/anko/CustomViewPropertiesKt\n*L\n1#1,1066:1\n140#2:1067\n140#2:1095\n140#2:1096\n1#3:1068\n260#4:1069\n262#4,2:1070\n262#4,2:1072\n262#4,2:1074\n262#4,2:1076\n262#4,2:1078\n262#4,2:1080\n262#4,2:1082\n262#4,2:1084\n262#4,2:1086\n262#4,2:1088\n262#4,2:1090\n262#4,2:1092\n262#4,2:1098\n262#4,2:1100\n262#4,2:1102\n262#4,2:1104\n262#4,2:1106\n260#4:1108\n262#4,2:1109\n262#4,2:1111\n262#4,2:1113\n262#4,2:1115\n262#4,2:1117\n262#4,2:1119\n262#4,2:1121\n262#4,2:1123\n262#4,2:1125\n262#4,2:1127\n262#4,2:1143\n262#4,2:1145\n262#4,2:1147\n215#5:1094\n216#5:1097\n1963#6,14:1129\n1054#6:1150\n78#7:1149\n*S KotlinDebug\n*F\n+ 1 StopClubActivity.kt\ncom/arlosoft/macrodroid/extras/stopclub/StopClubActivity\n*L\n141#1:1067\n472#1:1095\n473#1:1096\n395#1:1069\n398#1:1070,2\n417#1:1072,2\n420#1:1074,2\n431#1:1076,2\n432#1:1078,2\n433#1:1080,2\n434#1:1082,2\n441#1:1084,2\n442#1:1086,2\n446#1:1088,2\n462#1:1090,2\n467#1:1092,2\n481#1:1098,2\n483#1:1100,2\n493#1:1102,2\n494#1:1104,2\n495#1:1106,2\n548#1:1108\n549#1:1109,2\n550#1:1111,2\n552#1:1113,2\n557#1:1115,2\n562#1:1117,2\n567#1:1119,2\n572#1:1121,2\n577#1:1123,2\n582#1:1125,2\n592#1:1127,2\n600#1:1143,2\n602#1:1145,2\n605#1:1147,2\n469#1:1094\n469#1:1097\n599#1:1129,14\n996#1:1150\n837#1:1149\n*E\n"})
/* loaded from: classes3.dex */
public final class StopClubActivity extends MacroDroidDaggerBaseActivity {
    public static final int VIEW_CONTENT = 1;
    public static final int VIEW_ERROR = 2;
    public static final int VIEW_LOADING = 0;
    @Inject
    public BillingDataSource billingDataSource;
    @Inject
    public ExtrasDownloader extrasDownloader;
    @Inject
    public ExtrasManager extrasManager;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12018f;

    /* renamed from: g  reason: collision with root package name */
    private ActivityStopclubBinding f12019g;

    /* renamed from: h  reason: collision with root package name */
    private String f12020h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private Boolean f12021i;
    @Inject
    public PermissionChecker permissionChecker;
    @Inject
    public PremiumStatusHandler premiumStatusHandler;
    @Inject
    public PurchaseValidator purchaseValidator;
    @Inject
    public RemoteConfig remoteConfig;
    @Inject
    public SystemLogHelper systemLogHelper;
    @Inject
    public StopClubViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StopClubActivity.kt */
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
            try {
                iArr[ExtraPackageClickListener.PurchasePeriod.WEEKLY_PREPAID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ExtraPackageClickListener.PurchasePeriod.MONTHLY_PREPAID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ExtraPackageClickListener.PurchasePeriod.YEARLY_PREPAID.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Function0<Unit> function0, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$callback = function0;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$callback, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$callback.invoke();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ SupportChannel $telegramChannel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a0(SupportChannel supportChannel, Continuation<? super a0> continuation) {
            super(3, continuation);
            this.$telegramChannel = supportChannel;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a0(this.$telegramChannel, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StopClubActivity.this.O(this.$telegramChannel.getLink());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function0<Unit> {
        final /* synthetic */ ViewGroup $container;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ViewGroup viewGroup) {
            super(0);
            this.$container = viewGroup;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
            intent.addFlags(268435456);
            this.$container.getContext().startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b0(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super b0> continuation) {
            super(3, continuation);
            this.$extraPackage = extraPackageWithPriceAndState;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b0(this.$extraPackage, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StopClubActivity.this.G(this.$extraPackage);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function0<Unit> {
        final /* synthetic */ ViewGroup $container;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ViewGroup viewGroup) {
            super(0);
            this.$container = viewGroup;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            String packageName = this.$container.getContext().getPackageName();
            intent.setData(Uri.parse("package:" + packageName));
            intent.addFlags(268435456);
            try {
                this.$container.getContext().startActivity(intent);
            } catch (Exception unused) {
                ToastCompat.makeText(this.$container.getContext().getApplicationContext(), (CharSequence) this.$container.getContext().getString(R.string.cannot_launch_settings), 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ SupportChannel $whatsappChannel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c0(SupportChannel supportChannel, Continuation<? super c0> continuation) {
            super(3, continuation);
            this.$whatsappChannel = supportChannel;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c0(this.$whatsappChannel, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StopClubActivity.this.Q(this.$whatsappChannel.getLink());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements Function0<Unit> {
        final /* synthetic */ ViewGroup $container;
        final /* synthetic */ AccessibilityServiceState $uiIInteractionAccessibilityEnabledState;
        final /* synthetic */ StopClubActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(AccessibilityServiceState accessibilityServiceState, StopClubActivity stopClubActivity, ViewGroup viewGroup) {
            super(0);
            this.$uiIInteractionAccessibilityEnabledState = accessibilityServiceState;
            this.this$0 = stopClubActivity;
            this.$container = viewGroup;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            try {
                if (this.$uiIInteractionAccessibilityEnabledState == AccessibilityServiceState.DISABLED) {
                    this.this$0.f0();
                } else {
                    this.this$0.e0();
                }
            } catch (Exception unused) {
                ToastCompat.makeText(this.$container.getContext().getApplicationContext(), (CharSequence) this.$container.getContext().getString(R.string.cannot_launch_accessibility_settings), 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class d0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d0(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super d0> continuation) {
            super(3, continuation);
            this.$extraPackage = extraPackageWithPriceAndState;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d0(this.$extraPackage, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StopClubActivity.this.N(this.$extraPackage);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class e extends Lambda implements Function0<Unit> {
        final /* synthetic */ ViewGroup $container;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(ViewGroup viewGroup) {
            super(0);
            this.$container = viewGroup;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            try {
                Context context = this.$container.getContext();
                Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (Exception unused) {
                ToastCompat.makeText(this.$container.getContext().getApplicationContext(), (CharSequence) this.$container.getContext().getString(R.string.cannot_launch_accessibility_settings), 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class e0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e0(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super e0> continuation) {
            super(3, continuation);
            this.$extraPackage = extraPackageWithPriceAndState;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e0(this.$extraPackage, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StopClubActivity.this.I(this.$extraPackage.getExtra());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class f extends Lambda implements Function0<Unit> {
        final /* synthetic */ String $permission;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: StopClubActivity.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<PermissionStatus, Unit> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f12022d = new a();

            a() {
                super(1);
            }

            public final void a(@NotNull PermissionStatus it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PermissionStatus permissionStatus) {
                a(permissionStatus);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str) {
            super(0);
            this.$permission = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ExcuseMe.Companion.couldYouGive((Activity) StopClubActivity.this).permissionFor(new String[]{this.$permission}, a.f12022d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class f0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f0(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super f0> continuation) {
            super(3, continuation);
            this.$extraPackage = extraPackageWithPriceAndState;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new f0(this.$extraPackage, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StopClubActivity.this.H(this.$extraPackage);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class g extends Lambda implements Function0<Unit> {
        g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StopClubActivity stopClubActivity = StopClubActivity.this;
            String packageName = StopClubActivity.this.getPackageName();
            stopClubActivity.startActivity(new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM", Uri.parse("package:" + packageName)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class g0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        g0(Continuation<? super g0> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new g0(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActivityStopclubBinding activityStopclubBinding = StopClubActivity.this.f12019g;
                if (activityStopclubBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityStopclubBinding = null;
                }
                activityStopclubBinding.infoBar.collapse();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class h extends Lambda implements Function0<Unit> {
        final /* synthetic */ ViewGroup $container;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(ViewGroup viewGroup) {
            super(0);
            this.$container = viewGroup;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=br.com.stopclub.app"));
                intent.addFlags(268435456);
                StopClubActivity.this.startActivity(intent);
            } catch (Exception unused) {
                ToastCompat.makeText(this.$container.getContext().getApplicationContext(), (CharSequence) this.$container.getContext().getString(R.string.error), 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class h0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        h0(Continuation<? super h0> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new h0(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StopClubActivity stopClubActivity = StopClubActivity.this;
                ActivityStopclubBinding activityStopclubBinding = stopClubActivity.f12019g;
                if (activityStopclubBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityStopclubBinding = null;
                }
                Context context = activityStopclubBinding.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
                stopClubActivity.F(context);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class i extends Lambda implements Function0<Unit> {
        final /* synthetic */ String $permission;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: StopClubActivity.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<PermissionStatus, Unit> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f12023d = new a();

            a() {
                super(1);
            }

            public final void a(@NotNull PermissionStatus it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PermissionStatus permissionStatus) {
                a(permissionStatus);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(String str) {
            super(0);
            this.$permission = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ExcuseMe.Companion.couldYouGive((Activity) StopClubActivity.this).permissionFor(new String[]{this.$permission}, a.f12023d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class i0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i0(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super i0> continuation) {
            super(3, continuation);
            this.$extraPackage = extraPackageWithPriceAndState;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new i0(this.$extraPackage, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StopClubActivity.this.P(this.$extraPackage.getExtra());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewGroup $container;
        final /* synthetic */ PowerManager $powerManager;
        final /* synthetic */ Button $powerManagerButton;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(PowerManager powerManager, ViewGroup viewGroup, Button button, Continuation<? super j> continuation) {
            super(2, continuation);
            this.$powerManager = powerManager;
            this.$container = viewGroup;
            this.$powerManagerButton = button;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new j(this.$powerManager, this.$container, this.$powerManagerButton, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            boolean isIgnoringBatteryOptimizations;
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
                this.label = 1;
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            try {
                isIgnoringBatteryOptimizations = this.$powerManager.isIgnoringBatteryOptimizations(this.$container.getContext().getPackageName());
                if (isIgnoringBatteryOptimizations) {
                    this.$container.removeView(this.$powerManagerButton);
                    this.$container.getParent().requestLayout();
                }
            } catch (Throwable unused) {
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class j0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        j0(Continuation<? super j0> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new j0(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StopClubActivity.this.L();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class k extends Lambda implements Function0<Unit> {
        final /* synthetic */ ViewGroup $container;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(ViewGroup viewGroup) {
            super(0);
            this.$container = viewGroup;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            try {
                Intent putExtra = new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("android.provider.extra.APP_PACKAGE", this.$container.getContext().getPackageName());
                Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(Settings.ACTION_A…iner.context.packageName)");
                this.$container.getContext().startActivity(putExtra);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class k0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k0(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super k0> continuation) {
            super(3, continuation);
            this.$extraPackage = extraPackageWithPriceAndState;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new k0(this.$extraPackage, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StopClubViewModel viewModel = StopClubActivity.this.getViewModel();
                String settingsMacroName = this.$extraPackage.getExtra().getSettingsMacroName();
                if (settingsMacroName == null) {
                    settingsMacroName = "";
                }
                viewModel.onMacroShortcutClicked(settingsMacroName);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class l extends Lambda implements Function0<Unit> {
        final /* synthetic */ ViewGroup $container;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(ViewGroup viewGroup) {
            super(0);
            this.$container = viewGroup;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            try {
                Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                String packageName = this.$container.getContext().getPackageName();
                intent.setData(Uri.parse("package:" + packageName));
                intent.addFlags(268435456);
                this.$container.getContext().startActivity(intent);
            } catch (Exception unused) {
                Intent intent2 = new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
                intent2.addFlags(268435456);
                this.$container.getContext().startActivity(intent2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class l0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map.Entry<String, StringWithLanguages> $entry;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l0(Map.Entry<String, StringWithLanguages> entry, Continuation<? super l0> continuation) {
            super(3, continuation);
            this.$entry = entry;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new l0(this.$entry, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StopClubActivity.this.getViewModel().onMacroShortcutClicked(this.$entry.getKey());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class m extends Lambda implements Function1<Unit, Unit> {
        m() {
            super(1);
        }

        public final void a(@Nullable Unit unit) {
            ActivityStopclubBinding activityStopclubBinding = StopClubActivity.this.f12019g;
            if (activityStopclubBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityStopclubBinding = null;
            }
            activityStopclubBinding.infoBar.expand();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            a(unit);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class m0 extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isSetupShown;
        /* synthetic */ Object L$0;
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ StopClubActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m0(boolean z3, StopClubActivity stopClubActivity, Continuation<? super m0> continuation) {
            super(4, continuation);
            this.$isSetupShown = z3;
            this.this$0 = stopClubActivity;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            m0 m0Var = new m0(this.$isSetupShown, this.this$0, continuation);
            m0Var.L$0 = compoundButton;
            m0Var.Z$0 = z3;
            return m0Var.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CompoundButton compoundButton = (CompoundButton) this.L$0;
                if (!this.Z$0) {
                    this.this$0.U(false);
                } else if (!this.$isSetupShown) {
                    this.this$0.U(true);
                } else {
                    if (compoundButton != null) {
                        compoundButton.setChecked(false);
                    }
                    StopClubActivity stopClubActivity = this.this$0;
                    Util.displayErrorDialog(stopClubActivity, stopClubActivity.getString(R.string.setup_required), this.this$0.getString(R.string.please_complete_all_setup_before_enabling));
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class n extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        n(Continuation<? super n> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new n(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StopClubActivity.this.getViewModel().onRetryClicked();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class n0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Dialog $dialog;
        final /* synthetic */ String $subscriptionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n0(String str, Dialog dialog, Continuation<? super n0> continuation) {
            super(3, continuation);
            this.$subscriptionId = str;
            this.$dialog = dialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new n0(this.$subscriptionId, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BillingDataSource billingDataSource = StopClubActivity.this.getBillingDataSource();
                StopClubActivity stopClubActivity = StopClubActivity.this;
                billingDataSource.launchBillingFlow(stopClubActivity, this.$subscriptionId, new String[0], stopClubActivity.getPremiumStatusHandler().getPremiumStatus().isPro());
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class o extends Lambda implements Function1<ExtrasViewState, Unit> {
        o() {
            super(1);
        }

        public final void a(ExtrasViewState extrasViewState) {
            ActivityStopclubBinding activityStopclubBinding = null;
            if (extrasViewState instanceof ExtrasViewState.Loading) {
                ActivityStopclubBinding activityStopclubBinding2 = StopClubActivity.this.f12019g;
                if (activityStopclubBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityStopclubBinding = activityStopclubBinding2;
                }
                activityStopclubBinding.viewFlipper.setDisplayedChild(0);
            } else if (extrasViewState instanceof ExtrasViewState.Error) {
                ActivityStopclubBinding activityStopclubBinding3 = StopClubActivity.this.f12019g;
                if (activityStopclubBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityStopclubBinding = activityStopclubBinding3;
                }
                activityStopclubBinding.viewFlipper.setDisplayedChild(2);
            } else if (extrasViewState instanceof ExtrasViewState.Loaded) {
                StopClubActivity.this.D(((ExtrasViewState.Loaded) extrasViewState).getExtra());
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExtrasViewState extrasViewState) {
            a(extrasViewState);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class o0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Dialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o0(Dialog dialog, Continuation<? super o0> continuation) {
            super(3, continuation);
            this.$dialog = dialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new o0(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
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
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class p extends Lambda implements Function1<String, Unit> {
        p() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable String str) {
            StopClubActivity stopClubActivity = StopClubActivity.this;
            String string = stopClubActivity.getString(R.string.update_installed);
            ToastCompat.makeText((Context) stopClubActivity, (CharSequence) (string + " (v" + str + ")"), 1).show();
        }
    }

    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    static final class p0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        p0(Continuation<? super p0> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new p0(continuation);
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
                BillingDataSource billingDataSource = StopClubActivity.this.getBillingDataSource();
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
            return ((p0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class q extends Lambda implements Function1<SubscriptionCheckStatus, Unit> {
        q() {
            super(1);
        }

        public final void a(@Nullable SubscriptionCheckStatus subscriptionCheckStatus) {
            if (subscriptionCheckStatus != null) {
                StopClubActivity.this.A(subscriptionCheckStatus);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubscriptionCheckStatus subscriptionCheckStatus) {
            a(subscriptionCheckStatus);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class q0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
        Object L$0;
        int label;
        final /* synthetic */ StopClubActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q0(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, StopClubActivity stopClubActivity, Continuation<? super q0> continuation) {
            super(2, continuation);
            this.$extraPackage = extraPackageWithPriceAndState;
            this.this$0 = stopClubActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new q0(this.$extraPackage, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Intent intent;
            String stringForLanguage;
            boolean z3;
            Object createHtmlLogFile;
            Intent intent2;
            Intent intent3;
            String stringForLanguage2;
            boolean z4;
            boolean z5;
            Object createHtmlLogFile2;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            try {
            } catch (Exception unused) {
                intent = new Intent("android.intent.action.SEND");
                intent.setFlags(268435456);
                intent.setType("vnd.android.cursor.item/email");
                SupportChannel supportChannel = this.$extraPackage.getExtra().getSupportChannels().getChannels().get(SupportChannelType.EMAIL);
                Intrinsics.checkNotNull(supportChannel);
                intent.putExtra("android.intent.extra.EMAIL", new String[]{supportChannel.getLink()});
                if (this.$extraPackage.getInstalledVersion() != null) {
                    StringWithLanguages premiumTitle = this.$extraPackage.getExtra().getSupportChannels().getPremiumTitle();
                    String str = this.this$0.f12020h;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
                        str = null;
                    }
                    stringForLanguage = premiumTitle.getStringForLanguage(str);
                } else {
                    StringWithLanguages basicTitle = this.$extraPackage.getExtra().getSupportChannels().getBasicTitle();
                    String str2 = this.this$0.f12020h;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
                        str2 = null;
                    }
                    stringForLanguage = basicTitle.getStringForLanguage(str2);
                }
                intent.putExtra("android.intent.extra.SUBJECT", stringForLanguage);
                intent.putExtra("android.intent.extra.TEXT", this.this$0.x(this.$extraPackage.getExtra()));
                if (this.$extraPackage.getInstalledVersion() != null) {
                    if ((this.this$0.getResources().getConfiguration().uiMode & 48) == 32) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    SystemLogHelper systemLogHelper = this.this$0.getSystemLogHelper();
                    LogLevel logLevel = LogLevel.DEBUG;
                    this.L$0 = intent;
                    this.label = 2;
                    createHtmlLogFile = systemLogHelper.createHtmlLogFile(z3, logLevel, this);
                    if (createHtmlLogFile == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    intent2 = intent;
                }
            }
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        intent2 = (Intent) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        createHtmlLogFile = obj;
                        String str3 = (String) createHtmlLogFile;
                        if (str3 != null) {
                            StopClubActivity stopClubActivity = this.this$0;
                            File externalFilesDir = Gradients.INSTANCE.getContext().getExternalFilesDir(null);
                            File file = new File(externalFilesDir + "/MacroDroidLog.zip");
                            ZipUtil.packEntry(new File(str3), file);
                            FileUtils.addFileStreamToIntent(stopClubActivity, intent2, file);
                        }
                        intent = intent2;
                        StopClubActivity stopClubActivity2 = this.this$0;
                        stopClubActivity2.startActivity(Intent.createChooser(intent, stopClubActivity2.getString(R.string.send_email)));
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                intent3 = (Intent) this.L$0;
                ResultKt.throwOnFailure(obj);
                createHtmlLogFile2 = obj;
            } else {
                ResultKt.throwOnFailure(obj);
                intent3 = new Intent("android.intent.action.SEND");
                intent3.setFlags(268435456);
                intent3.setType("vnd.android.cursor.item/email");
                intent3.setPackage("com.google.android.gm");
                SupportChannel supportChannel2 = this.$extraPackage.getExtra().getSupportChannels().getChannels().get(SupportChannelType.EMAIL);
                Intrinsics.checkNotNull(supportChannel2);
                intent3.putExtra("android.intent.extra.EMAIL", new String[]{supportChannel2.getLink()});
                if (this.$extraPackage.getInstalledVersion() != null) {
                    StringWithLanguages premiumTitle2 = this.$extraPackage.getExtra().getSupportChannels().getPremiumTitle();
                    String str4 = this.this$0.f12020h;
                    if (str4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
                        str4 = null;
                    }
                    stringForLanguage2 = premiumTitle2.getStringForLanguage(str4);
                } else {
                    StringWithLanguages basicTitle2 = this.$extraPackage.getExtra().getSupportChannels().getBasicTitle();
                    String str5 = this.this$0.f12020h;
                    if (str5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
                        str5 = null;
                    }
                    stringForLanguage2 = basicTitle2.getStringForLanguage(str5);
                }
                intent3.putExtra("android.intent.extra.SUBJECT", stringForLanguage2);
                intent3.putExtra("android.intent.extra.TEXT", this.this$0.x(this.$extraPackage.getExtra()));
                if (this.$extraPackage.getInstalledVersion() != null) {
                    if ((this.this$0.getResources().getConfiguration().uiMode & 48) == 32) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    SystemLogHelper systemLogHelper2 = this.this$0.getSystemLogHelper();
                    if (z4) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    LogLevel logLevel2 = LogLevel.DEBUG;
                    this.L$0 = intent3;
                    this.label = 1;
                    createHtmlLogFile2 = systemLogHelper2.createHtmlLogFile(z5, logLevel2, this);
                    if (createHtmlLogFile2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                StopClubActivity stopClubActivity3 = this.this$0;
                stopClubActivity3.startActivity(Intent.createChooser(intent3, stopClubActivity3.getString(R.string.send_email)));
                return Unit.INSTANCE;
            }
            String str6 = (String) createHtmlLogFile2;
            if (str6 != null) {
                StopClubActivity stopClubActivity4 = this.this$0;
                File externalFilesDir2 = Gradients.INSTANCE.getContext().getExternalFilesDir(null);
                File file2 = new File(externalFilesDir2 + "/MacroDroidLog.zip");
                ZipUtil.packEntry(new File(str6), file2);
                FileUtils.addFileStreamToIntent(stopClubActivity4, intent3, file2);
            }
            StopClubActivity stopClubActivity32 = this.this$0;
            stopClubActivity32.startActivity(Intent.createChooser(intent3, stopClubActivity32.getString(R.string.send_email)));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((q0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    @SourceDebugExtension({"SMAP\nStopClubActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StopClubActivity.kt\ncom/arlosoft/macrodroid/extras/stopclub/StopClubActivity$bindViewModel$5\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1066:1\n1#2:1067\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class r extends Lambda implements Function1<ExtraPackageWithPriceAndState, Unit> {
        r() {
            super(1);
        }

        public final void a(@Nullable ExtraPackageWithPriceAndState extraPackageWithPriceAndState) {
            if (extraPackageWithPriceAndState != null) {
                StopClubActivity.this.y(extraPackageWithPriceAndState);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExtraPackageWithPriceAndState extraPackageWithPriceAndState) {
            a(extraPackageWithPriceAndState);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class r0 implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f12024a;

        r0(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f12024a = function;
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
            return this.f12024a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f12024a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class s extends Lambda implements Function1<SubscriptionPrice, Unit> {
        s() {
            super(1);
        }

        public final void a(SubscriptionPrice price) {
            StopClubActivity stopClubActivity = StopClubActivity.this;
            Intrinsics.checkNotNullExpressionValue(price, "price");
            stopClubActivity.i0(price);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubscriptionPrice subscriptionPrice) {
            a(subscriptionPrice);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class s0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        s0(Continuation<? super s0> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new s0(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                StopClubActivity.this.getViewModel().removeBeta();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((s0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class t extends Lambda implements Function1<SubscriptionPrice, Unit> {
        t() {
            super(1);
        }

        public final void a(SubscriptionPrice price) {
            StopClubActivity stopClubActivity = StopClubActivity.this;
            Intrinsics.checkNotNullExpressionValue(price, "price");
            stopClubActivity.h0(price);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubscriptionPrice subscriptionPrice) {
            a(subscriptionPrice);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class t0 extends Lambda implements Function0<Unit> {
        t0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StopClubActivity.this.f0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class u extends Lambda implements Function1<SubscriptionPrice, Unit> {
        u() {
            super(1);
        }

        public final void a(SubscriptionPrice price) {
            StopClubActivity stopClubActivity = StopClubActivity.this;
            Intrinsics.checkNotNullExpressionValue(price, "price");
            stopClubActivity.j0(price);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubscriptionPrice subscriptionPrice) {
            a(subscriptionPrice);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class u0 extends Lambda implements Function0<Unit> {
        u0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StopClubActivity.this.R();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class v extends Lambda implements Function1<Unit, Unit> {
        v() {
            super(1);
        }

        public final void a(@Nullable Unit unit) {
            ActivityStopclubBinding activityStopclubBinding = StopClubActivity.this.f12019g;
            ActivityStopclubBinding activityStopclubBinding2 = null;
            if (activityStopclubBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityStopclubBinding = null;
            }
            activityStopclubBinding.scrollView.setFocusableInTouchMode(true);
            ActivityStopclubBinding activityStopclubBinding3 = StopClubActivity.this.f12019g;
            if (activityStopclubBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityStopclubBinding3 = null;
            }
            activityStopclubBinding3.scrollView.fullScroll(33);
            ActivityStopclubBinding activityStopclubBinding4 = StopClubActivity.this.f12019g;
            if (activityStopclubBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityStopclubBinding2 = activityStopclubBinding4;
            }
            activityStopclubBinding2.scrollView.smoothScrollTo(0, 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            a(unit);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class v0 extends Lambda implements Function0<Unit> {
        v0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StopClubActivity.this.R();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class w extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        w(Continuation<? super w> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new w(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActivityStopclubBinding activityStopclubBinding = StopClubActivity.this.f12019g;
                ActivityStopclubBinding activityStopclubBinding2 = null;
                if (activityStopclubBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityStopclubBinding = null;
                }
                activityStopclubBinding.weeklySubscriptionOption.setChecked(true);
                ActivityStopclubBinding activityStopclubBinding3 = StopClubActivity.this.f12019g;
                if (activityStopclubBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityStopclubBinding3 = null;
                }
                activityStopclubBinding3.monthlySubscriptionOption.setChecked(false);
                ActivityStopclubBinding activityStopclubBinding4 = StopClubActivity.this.f12019g;
                if (activityStopclubBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityStopclubBinding2 = activityStopclubBinding4;
                }
                activityStopclubBinding2.yearlySubscriptionOption.setChecked(false);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class w0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Dialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w0(Dialog dialog, Continuation<? super w0> continuation) {
            super(3, continuation);
            this.$dialog = dialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new w0(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
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
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class x extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        x(Continuation<? super x> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new x(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActivityStopclubBinding activityStopclubBinding = StopClubActivity.this.f12019g;
                ActivityStopclubBinding activityStopclubBinding2 = null;
                if (activityStopclubBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityStopclubBinding = null;
                }
                activityStopclubBinding.weeklySubscriptionOption.setChecked(false);
                ActivityStopclubBinding activityStopclubBinding3 = StopClubActivity.this.f12019g;
                if (activityStopclubBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityStopclubBinding3 = null;
                }
                activityStopclubBinding3.monthlySubscriptionOption.setChecked(true);
                ActivityStopclubBinding activityStopclubBinding4 = StopClubActivity.this.f12019g;
                if (activityStopclubBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityStopclubBinding2 = activityStopclubBinding4;
                }
                activityStopclubBinding2.yearlySubscriptionOption.setChecked(false);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class x0 extends Lambda implements Function1<ExtraVersionHistoryEntry, CharSequence> {
        x0() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull ExtraVersionHistoryEntry it) {
            Intrinsics.checkNotNullParameter(it, "it");
            String versionString = it.getVersionString();
            StringWithLanguages versionDescription = it.getVersionDescription();
            String str = StopClubActivity.this.f12020h;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException(RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
                str = null;
            }
            String stringForLanguage = versionDescription.getStringForLanguage(str);
            return "<b>" + versionString + "</b><br/><br/>" + stringForLanguage + "<br/><br/>";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class y extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        y(Continuation<? super y> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new y(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActivityStopclubBinding activityStopclubBinding = StopClubActivity.this.f12019g;
                ActivityStopclubBinding activityStopclubBinding2 = null;
                if (activityStopclubBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityStopclubBinding = null;
                }
                activityStopclubBinding.weeklySubscriptionOption.setChecked(false);
                ActivityStopclubBinding activityStopclubBinding3 = StopClubActivity.this.f12019g;
                if (activityStopclubBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityStopclubBinding3 = null;
                }
                activityStopclubBinding3.monthlySubscriptionOption.setChecked(false);
                ActivityStopclubBinding activityStopclubBinding4 = StopClubActivity.this.f12019g;
                if (activityStopclubBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityStopclubBinding2 = activityStopclubBinding4;
                }
                activityStopclubBinding2.yearlySubscriptionOption.setChecked(true);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubActivity.kt */
    /* loaded from: classes3.dex */
    public static final class z extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackageWithPriceAndState $extraPackage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, Continuation<? super z> continuation) {
            super(3, continuation);
            this.$extraPackage = extraPackageWithPriceAndState;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new z(this.$extraPackage, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            ExtraPackageClickListener.PurchasePeriod purchasePeriod;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (StopClubActivity.this.T(this.$extraPackage)) {
                    StopClubActivity.this.J(this.$extraPackage.getMinVersionRemoteConfig());
                } else if (StopClubActivity.this.S(this.$extraPackage)) {
                    StopClubActivity.this.J(this.$extraPackage.getExtra().getMinMacroDroidVersion());
                } else {
                    ActivityStopclubBinding activityStopclubBinding = StopClubActivity.this.f12019g;
                    ActivityStopclubBinding activityStopclubBinding2 = null;
                    if (activityStopclubBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityStopclubBinding = null;
                    }
                    if (!activityStopclubBinding.yearlySubscriptionOption.isChecked()) {
                        ActivityStopclubBinding activityStopclubBinding3 = StopClubActivity.this.f12019g;
                        if (activityStopclubBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            activityStopclubBinding2 = activityStopclubBinding3;
                        }
                        if (activityStopclubBinding2.monthlySubscriptionOption.isChecked()) {
                            purchasePeriod = ExtraPackageClickListener.PurchasePeriod.MONTHLY;
                        } else {
                            purchasePeriod = ExtraPackageClickListener.PurchasePeriod.WEEKLY;
                        }
                    } else {
                        purchasePeriod = ExtraPackageClickListener.PurchasePeriod.YEARLY;
                    }
                    StopClubActivity.this.K(this.$extraPackage, purchasePeriod);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(SubscriptionCheckStatus subscriptionCheckStatus) {
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
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(this).setTitle(R.string.payment_validation_failed).setMessage(string).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.retry, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.extras.stopclub.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                StopClubActivity.B(StopClubActivity.this, dialogInterface, i4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(positiveButton, "Builder(this)\n          …fresh()\n                }");
        AlertDialog create = positiveButton.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(StopClubActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f12021i = null;
        StopClubViewModel.refresh$default(this$0.getViewModel(), false, 1, null);
    }

    private final void C(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, ExtraPackageClickListener.PurchasePeriod purchasePeriod) {
        String weeklySubscriptionId;
        switch (WhenMappings.$EnumSwitchMapping$0[purchasePeriod.ordinal()]) {
            case 1:
                if (extraPackageWithPriceAndState.getUsedTrial()) {
                    weeklySubscriptionId = extraPackageWithPriceAndState.getExtra().getSubscriptionData().getWeeklySubscriptionIdNoTrial();
                    break;
                } else {
                    weeklySubscriptionId = extraPackageWithPriceAndState.getExtra().getSubscriptionData().getWeeklySubscriptionId();
                    break;
                }
            case 2:
                if (extraPackageWithPriceAndState.getUsedTrial()) {
                    weeklySubscriptionId = extraPackageWithPriceAndState.getExtra().getSubscriptionData().getMonthlySubscriptionIdNoTrial();
                    break;
                } else {
                    weeklySubscriptionId = extraPackageWithPriceAndState.getExtra().getSubscriptionData().getMonthlySubscriptionId();
                    break;
                }
            case 3:
                if (extraPackageWithPriceAndState.getUsedTrial()) {
                    weeklySubscriptionId = extraPackageWithPriceAndState.getExtra().getSubscriptionData().getYearlySubscriptionIdNoTrial();
                    break;
                } else {
                    weeklySubscriptionId = extraPackageWithPriceAndState.getExtra().getSubscriptionData().getYearlySubscriptionId();
                    break;
                }
            case 4:
                weeklySubscriptionId = extraPackageWithPriceAndState.getExtra().getSubscriptionData().getWeeklySubscriptionIdPrePaid();
                break;
            case 5:
                weeklySubscriptionId = extraPackageWithPriceAndState.getExtra().getSubscriptionData().getMonthlySubscriptionIdPrePaid();
                break;
            case 6:
                weeklySubscriptionId = extraPackageWithPriceAndState.getExtra().getSubscriptionData().getYearlySubscriptionIdPrePaid();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (weeklySubscriptionId != null) {
            if (extraPackageWithPriceAndState.getExtra().getDisclaimer() != null) {
                Dialog dialog = new Dialog(this);
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialog_extra_disclaimer);
                DialogExtensionsKt.setWidthToParent$default(dialog, 0, 1, null);
                ActivityStopclubBinding activityStopclubBinding = this.f12019g;
                if (activityStopclubBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityStopclubBinding = null;
                }
                Glide.with(activityStopclubBinding.getRoot().getContext()).m4161load(extraPackageWithPriceAndState.getExtra().getIconUrl()).into((ImageView) dialog.findViewById(R.id.extra_icon));
                TextView textView = (TextView) dialog.findViewById(R.id.disclaimer_text);
                StringWithLanguages disclaimer = extraPackageWithPriceAndState.getExtra().getDisclaimer();
                String str = this.f12020h;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
                    str = null;
                }
                textView.setText(disclaimer.getStringForLanguage(str));
                View findViewById = dialog.findViewById(R.id.acceptButton);
                Intrinsics.checkNotNullExpressionValue(findViewById, "dialog.findViewById<Button>(R.id.acceptButton)");
                ViewExtensionsKt.onClick$default(findViewById, null, new n0(weeklySubscriptionId, dialog, null), 1, null);
                View findViewById2 = dialog.findViewById(R.id.declineButton);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "dialog.findViewById<Button>(R.id.declineButton)");
                ViewExtensionsKt.onClick$default(findViewById2, null, new o0(dialog, null), 1, null);
                dialog.show();
                return;
            }
            getBillingDataSource().launchBillingFlow(this, weeklySubscriptionId, new String[0], getPremiumStatusHandler().getPremiumStatus().isPro());
            return;
        }
        throw new IllegalStateException("No subscription ID for purchase period " + purchasePeriod);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(ExtraPackageWithPriceAndState extraPackageWithPriceAndState) {
        ActivityStopclubBinding activityStopclubBinding = this.f12019g;
        if (activityStopclubBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityStopclubBinding = null;
        }
        activityStopclubBinding.viewFlipper.setDisplayedChild(1);
        w(extraPackageWithPriceAndState);
    }

    private final void E(Context context) {
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
    public final void F(Context context) {
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
    public final void G(ExtraPackageWithPriceAndState extraPackageWithPriceAndState) {
        kotlinx.coroutines.e.e(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new q0(extraPackageWithPriceAndState, this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(ExtraPackageWithPriceAndState extraPackageWithPriceAndState) {
        getViewModel().installVersionUpdate(extraPackageWithPriceAndState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(ExtraPackage extraPackage) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/account/subscriptions"));
        intent.addFlags(268435456);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(ExtraMinVersion extraMinVersion) {
        Z(extraMinVersion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(ExtraPackageWithPriceAndState extraPackageWithPriceAndState, ExtraPackageClickListener.PurchasePeriod purchasePeriod) {
        C(extraPackageWithPriceAndState, purchasePeriod);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(this).setTitle(R.string.reset_stop_club).setMessage(R.string.reset_stop_club_detail).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.extras.stopclub.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                StopClubActivity.M(StopClubActivity.this, dialogInterface, i4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(positiveButton, "Builder(this)\n          …ckage()\n                }");
        positiveButton.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(StopClubActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().resetPackage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(ExtraPackageWithPriceAndState extraPackageWithPriceAndState) {
        StopClubViewModel.activateMacroSet$default(getViewModel(), extraPackageWithPriceAndState.getExtra(), false, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(String str) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("tg://resolve?domain=" + str)));
        } catch (Exception unused) {
            ToastCompat.makeText(this, (int) R.string.app_not_found, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(ExtraPackage extraPackage) {
        g0(extraPackage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage("com.whatsapp");
            intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=" + str + "&text="));
            intent.addFlags(268435456);
            intent.addFlags(32768);
            startActivity(intent);
        } catch (Exception unused) {
            ToastCompat.makeText(this, (int) R.string.app_not_found, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
        intent.addFlags(268435456);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean S(ExtraPackageWithPriceAndState extraPackageWithPriceAndState) {
        if (extraPackageWithPriceAndState.getExtra().getMinMacroDroidVersion().getVersionCode() > 53800019) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean T(ExtraPackageWithPriceAndState extraPackageWithPriceAndState) {
        if (extraPackageWithPriceAndState.getMinVersionRemoteConfig().getVersionCode() > 53800019) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(boolean z3) {
        getViewModel().setActiveState(z3);
    }

    private final void V() {
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(this).setTitle(R.string.use_beta_channel).setMessage(R.string.beta_channel_info).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.extras.stopclub.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                StopClubActivity.W(StopClubActivity.this, dialogInterface, i4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(positiveButton, "Builder(this)\n          …State()\n                }");
        AlertDialog create = positiveButton.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(StopClubActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Settings.setUseExtraBetaChannel(this$0, true);
        StopClubViewModel.refreshWithLoadingState$default(this$0.getViewModel(), false, 1, null);
    }

    private final void X() {
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(this).setTitle(R.string.disable_beta_channel).setMessage(R.string.disable_beta_channel_warning).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.extras.stopclub.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                StopClubActivity.Y(StopClubActivity.this, dialogInterface, i4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(positiveButton, "Builder(this)\n          …      }\n                }");
        AlertDialog create = positiveButton.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(StopClubActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlinx.coroutines.e.e(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new s0(null), 3, null);
    }

    private final void Z(ExtraMinVersion extraMinVersion) {
        AlertDialog.Builder title = new AlertDialog.Builder(this).setTitle(R.string.update_required);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.macrodroid_specific_version_number_required);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.macro…_version_number_required)");
        String format = String.format(string, Arrays.copyOf(new Object[]{extraMinVersion.getVersionName()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        AlertDialog.Builder positiveButton = title.setMessage(format).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.install_update, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.extras.stopclub.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                StopClubActivity.a0(StopClubActivity.this, dialogInterface, i4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(positiveButton, "Builder(this)\n          …e(this)\n                }");
        AlertDialog create = positiveButton.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(StopClubActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E(this$0);
    }

    private final void b0(SubscriptionPrice subscriptionPrice) {
        boolean z3;
        ActivityStopclubBinding activityStopclubBinding = this.f12019g;
        ActivityStopclubBinding activityStopclubBinding2 = null;
        if (activityStopclubBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityStopclubBinding = null;
        }
        TextView textView = activityStopclubBinding.promotionText;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.promotionText");
        if (textView.getVisibility() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            if (subscriptionPrice.isProOnlyOffer()) {
                this.f12018f = true;
                ActivityStopclubBinding activityStopclubBinding3 = this.f12019g;
                if (activityStopclubBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityStopclubBinding3 = null;
                }
                TextView textView2 = activityStopclubBinding3.promotionText;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.promotionText");
                textView2.setVisibility(0);
                ActivityStopclubBinding activityStopclubBinding4 = this.f12019g;
                if (activityStopclubBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityStopclubBinding4 = null;
                }
                activityStopclubBinding4.promotionText.setText(getString(R.string.pro_user_exclusive_offer));
            }
            ActivityStopclubBinding activityStopclubBinding5 = this.f12019g;
            if (activityStopclubBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityStopclubBinding2 = activityStopclubBinding5;
            }
            activityStopclubBinding2.promotionText.setText(getString(R.string.pro_user_exclusive_offer));
        }
    }

    private final void c0(String str, final Function0<Unit> function0) {
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(this).setTitle(R.string.md_ui_interaction).setMessage(str).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.extras.stopclub.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                StopClubActivity.d0(Function0.this, dialogInterface, i4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(positiveButton, "Builder(this)\n          …ickOk()\n                }");
        AlertDialog create = positiveButton.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Function0 onClickOk, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(onClickOk, "$onClickOk");
        onClickOk.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.troubleshoot_accessibility_ui_interaction_malfunction);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.troub…_interaction_malfunction)");
        String format = String.format(string, Arrays.copyOf(new Object[]{getString(R.string.md_ui_interaction)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        c0(format, new t0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        boolean equals;
        boolean equals2;
        boolean equals3;
        String str = Build.MANUFACTURER;
        equals = kotlin.text.m.equals(str, "xiaomi", true);
        if (!equals) {
            equals2 = kotlin.text.m.equals(str, "oneplus", true);
            if (!equals2) {
                equals3 = kotlin.text.m.equals(str, "samsung", true);
                if (equals3) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = getString(R.string.enable_accessibility_samsung_specific_info);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.enabl…ty_samsung_specific_info)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{getString(R.string.md_ui_interaction)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    c0(format, new v0());
                    return;
                }
                R();
                return;
            }
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string2 = getString(R.string.enable_accessibility_xiaomi_specific_info);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.enabl…ity_xiaomi_specific_info)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{getString(R.string.md_ui_interaction)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        c0(format2, new u0());
    }

    private final void g0(ExtraPackage extraPackage) {
        List sortedWith;
        String joinToString$default;
        Dialog dialog = new Dialog(this);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_extra_version_history);
        DialogExtensionsKt.setWidthToParent$default(dialog, 0, 1, null);
        ActivityStopclubBinding activityStopclubBinding = this.f12019g;
        if (activityStopclubBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityStopclubBinding = null;
        }
        Glide.with(activityStopclubBinding.getRoot().getContext()).m4161load(extraPackage.getIconUrl()).into((ImageView) dialog.findViewById(R.id.extra_icon));
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(extraPackage.getVersionHistory(), new Comparator() { // from class: com.arlosoft.macrodroid.extras.stopclub.StopClubActivity$showVersionHistoryDialog$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                int compareValues;
                compareValues = kotlin.comparisons.f.compareValues(Integer.valueOf(((ExtraVersionHistoryEntry) t4).getVersionCode()), Integer.valueOf(((ExtraVersionHistoryEntry) t3).getVersionCode()));
                return compareValues;
            }
        });
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(sortedWith, "", null, null, 0, null, new x0(), 30, null);
        ((TextView) dialog.findViewById(R.id.version_history_text)).setText(Html.fromHtml(joinToString$default));
        View findViewById = dialog.findViewById(R.id.ok_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "dialog.findViewById<Button>(R.id.ok_button)");
        ViewExtensionsKt.onClick$default(findViewById, null, new w0(dialog, null), 1, null);
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(SubscriptionPrice subscriptionPrice) {
        ActivityStopclubBinding activityStopclubBinding = this.f12019g;
        if (activityStopclubBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityStopclubBinding = null;
        }
        activityStopclubBinding.monthlySubscriptionOption.setPrice(subscriptionPrice);
        b0(subscriptionPrice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(SubscriptionPrice subscriptionPrice) {
        ActivityStopclubBinding activityStopclubBinding = this.f12019g;
        if (activityStopclubBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityStopclubBinding = null;
        }
        activityStopclubBinding.weeklySubscriptionOption.setPrice(subscriptionPrice);
        b0(subscriptionPrice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(SubscriptionPrice subscriptionPrice) {
        ActivityStopclubBinding activityStopclubBinding = this.f12019g;
        if (activityStopclubBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityStopclubBinding = null;
        }
        activityStopclubBinding.yearlySubscriptionOption.setPrice(subscriptionPrice);
        b0(subscriptionPrice);
    }

    private final Button t(ViewGroup viewGroup, String str, Function0<Unit> function0) {
        Button button = new Button(viewGroup.getContext());
        button.setText(str);
        button.setAllCaps(false);
        Sdk27PropertiesKt.setTextColor(button, ContextCompat.getColor(viewGroup.getContext(), R.color.default_text_color_inverse));
        button.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(viewGroup.getContext(), R.color.extra_setup_required)));
        ViewExtensionsKt.onClick$default(button, null, new a(function0, null), 1, null);
        viewGroup.addView(button);
        ViewExtensionsKt.setMarginTop(button, IntExtensionsKt.getPx(4));
        return button;
    }

    private final boolean u(ExtraPackage extraPackage, ViewGroup viewGroup) {
        boolean isIgnoringBatteryOptimizations;
        boolean canDrawOverlays;
        boolean canScheduleExactAlarms;
        String str;
        viewGroup.removeAllViews();
        for (String str2 : extraPackage.getPermissions()) {
            switch (str2.hashCode()) {
                case -1885735535:
                    if (!str2.equals(ExtraPermissions.PERMISSION_DRAW_OVER_OTHER_APPS)) {
                        break;
                    } else if (Build.VERSION.SDK_INT >= 23) {
                        canDrawOverlays = android.provider.Settings.canDrawOverlays(viewGroup.getContext());
                        if (!canDrawOverlays) {
                            String string = viewGroup.getContext().getString(R.string.requires_draw_overlays);
                            Intrinsics.checkNotNullExpressionValue(string, "container.context.getStr…g.requires_draw_overlays)");
                            t(viewGroup, string, new c(viewGroup));
                        }
                    } else {
                        continue;
                    }
                case -714151487:
                    if (!str2.equals(ExtraPermissions.PERMISSION_ACCESSIBILITY_MACRODROID)) {
                        break;
                    } else if (Util.isMacroDroidAccessibilityEnabled(viewGroup.getContext())) {
                        continue;
                    } else {
                        String string2 = viewGroup.getContext().getString(R.string.action_accessibility_service);
                        Intrinsics.checkNotNullExpressionValue(string2, "container.context.getStr…on_accessibility_service)");
                        t(viewGroup, string2, new e(viewGroup));
                    }
                case -336366743:
                    if (!str2.equals(ExtraPermissions.SCHEDULE_EXACT_ALARM)) {
                        break;
                    } else {
                        Object systemService = getSystemService(NotificationCompat.CATEGORY_ALARM);
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
                        AlarmManager alarmManager = (AlarmManager) systemService;
                        if (Build.VERSION.SDK_INT >= 31) {
                            canScheduleExactAlarms = alarmManager.canScheduleExactAlarms();
                            if (!canScheduleExactAlarms) {
                                String string3 = viewGroup.getContext().getString(R.string.permission_schedule_allow_setting_alarms);
                                Intrinsics.checkNotNullExpressionValue(string3, "container.context.getStr…ule_allow_setting_alarms)");
                                t(viewGroup, string3, new g());
                            }
                        } else {
                            continue;
                        }
                    }
                case -294473293:
                    if (!str2.equals(ExtraPermissions.ACCESS_IMAGES)) {
                        break;
                    } else {
                        if (Build.VERSION.SDK_INT >= 33) {
                            str = "android.permission.READ_MEDIA_IMAGES";
                        } else {
                            str = "android.permission.READ_EXTERNAL_STORAGE";
                        }
                        if (getPermissionChecker().isStandardPermissionEnabled(str)) {
                            continue;
                        } else {
                            String string4 = viewGroup.getContext().getString(R.string.permission_write_to_image_gallery);
                            Intrinsics.checkNotNullExpressionValue(string4, "container.context.getStr…n_write_to_image_gallery)");
                            t(viewGroup, string4, new f(str));
                        }
                    }
                case 258614264:
                    if (!str2.equals(ExtraPermissions.PERMISSION_ACCESSIBILITY_UI_INTERACTION)) {
                        break;
                    } else {
                        AccessibilityServiceState isUIInteractionAccessibilityEnabledWithCrashCheck = Util.isUIInteractionAccessibilityEnabledWithCrashCheck(this);
                        if (isUIInteractionAccessibilityEnabledWithCrashCheck != AccessibilityServiceState.ENABLED) {
                            String string5 = viewGroup.getContext().getString(R.string.md_ui_interaction);
                            Intrinsics.checkNotNullExpressionValue(string5, "container.context.getStr…string.md_ui_interaction)");
                            t(viewGroup, string5, new d(isUIInteractionAccessibilityEnabledWithCrashCheck, this, viewGroup));
                        } else {
                            continue;
                        }
                    }
                case 1921778325:
                    if (!str2.equals(ExtraPermissions.STOP_CLUB_APP_INSTALLED)) {
                        break;
                    } else if (ApplicationChecker.isAppInstalled("br.com.stopclub.app")) {
                        continue;
                    } else {
                        String string6 = viewGroup.getContext().getString(R.string.install_stopclub_app);
                        Intrinsics.checkNotNullExpressionValue(string6, "container.context.getStr…ing.install_stopclub_app)");
                        t(viewGroup, string6, new h(viewGroup));
                    }
            }
            if (!getPermissionChecker().isStandardPermissionEnabled(str2)) {
                t(viewGroup, str2, new i(str2));
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            Object systemService2 = viewGroup.getContext().getSystemService("power");
            Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.os.PowerManager");
            PowerManager powerManager = (PowerManager) systemService2;
            isIgnoringBatteryOptimizations = powerManager.isIgnoringBatteryOptimizations(viewGroup.getContext().getPackageName());
            if (!isIgnoringBatteryOptimizations) {
                String string7 = viewGroup.getContext().getString(R.string.ignore_battery_optimisations);
                Intrinsics.checkNotNullExpressionValue(string7, "container.context.getStr…re_battery_optimisations)");
                kotlinx.coroutines.e.e(LifecycleOwnerKt.getLifecycleScope(this), null, null, new j(powerManager, viewGroup, t(viewGroup, string7, new l(viewGroup)), null), 3, null);
            }
            if (i4 >= 26 && !NotificationManagerCompat.from(viewGroup.getContext()).areNotificationsEnabled()) {
                String string8 = viewGroup.getContext().getString(R.string.configure_notifications);
                Intrinsics.checkNotNullExpressionValue(string8, "container.context.getStr….configure_notifications)");
                t(viewGroup, string8, new k(viewGroup));
            }
        }
        try {
            if (new Autostart(viewGroup.getContext()).getAutoStartState() == Autostart.State.DISABLED) {
                String string9 = viewGroup.getContext().getString(R.string.troubleshoot_miui_autostart_must_be_enabled);
                Intrinsics.checkNotNullExpressionValue(string9, "container.context.getStr…utostart_must_be_enabled)");
                t(viewGroup, string9, new b(viewGroup));
            }
        } catch (Exception unused) {
        }
        if (viewGroup.getChildCount() > 0) {
            return true;
        }
        return false;
    }

    private final void v() {
        ActivityStopclubBinding activityStopclubBinding = this.f12019g;
        if (activityStopclubBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityStopclubBinding = null;
        }
        Button button = activityStopclubBinding.retryButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.retryButton");
        ViewExtensionsKt.onClick$default(button, null, new n(null), 1, null);
        getViewModel().getViewState().observe(this, new r0(new o()));
        getViewModel().getUpdateInstalledEvent().observe(this, new r0(new p()));
        getViewModel().getValidationFailedEvent().observe(this, new r0(new q()));
        getViewModel().getUpdateFailedEvent().observe(this, new r0(new r()));
        getViewModel().getWeeklyPrice().observe(this, new r0(new s()));
        getViewModel().getMonthlyPrice().observe(this, new r0(new t()));
        getViewModel().getYearlyPrice().observe(this, new r0(new u()));
        getViewModel().getScrollToTopEvent().observe(this, new r0(new v()));
        getViewModel().getShowCategoriesDisabledWarning().observe(this, new r0(new m()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:401:0x0769, code lost:
        if (r11 != null) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x07fc, code lost:
        if (r11 != null) goto L367;
     */
    /* JADX WARN: Code restructure failed: missing block: B:459:0x087c, code lost:
        if (r9 != null) goto L390;
     */
    /* JADX WARN: Removed duplicated region for block: B:364:0x06dc  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x06e9  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x06eb  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x06f4  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0701  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0703  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x070c  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x071d  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x071f  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0722  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0724  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x07ae  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0830  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x08b4  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x08c8  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x08d2  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x08e6  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x08fd  */
    /* JADX WARN: Removed duplicated region for block: B:487:0x0914  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0921  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x0923  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0930  */
    /* JADX WARN: Removed duplicated region for block: B:535:0x0a08  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x0a0b  */
    /* JADX WARN: Removed duplicated region for block: B:547:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void w(com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState r17) {
        /*
            Method dump skipped, instructions count: 2593
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.extras.stopclub.StopClubActivity.w(com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String x(ExtraPackage extraPackage) {
        boolean z3;
        boolean z4;
        String str;
        boolean isNotificationPolicyAccessGranted;
        String str2;
        String trimIndent;
        boolean isIgnoringBatteryOptimizations;
        String str3 = ("\n<" + getString(R.string.enter_your_message_here) + ">") + "\n\n\n\n-------------------------------------------";
        StringWithLanguages title = extraPackage.getTitle();
        String str4 = this.f12020h;
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
            trimIndent = kotlin.text.f.trimIndent("\r\n\r\nLocation services: " + str2);
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
    public final void y(final ExtraPackageWithPriceAndState extraPackageWithPriceAndState) {
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(this).setTitle(R.string.update_failed).setMessage(R.string.check_connection_try_again).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.retry, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.extras.stopclub.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                StopClubActivity.z(StopClubActivity.this, extraPackageWithPriceAndState, dialogInterface, i4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(positiveButton, "Builder(this)\n          …fresh()\n                }");
        AlertDialog create = positiveButton.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(StopClubActivity this$0, ExtraPackageWithPriceAndState extraPackage, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(extraPackage, "$extraPackage");
        this$0.getViewModel().installVersionUpdate(extraPackage);
        StopClubViewModel.refresh$default(this$0.getViewModel(), false, 1, null);
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
    public final PermissionChecker getPermissionChecker() {
        PermissionChecker permissionChecker = this.permissionChecker;
        if (permissionChecker != null) {
            return permissionChecker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("permissionChecker");
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
    public final SystemLogHelper getSystemLogHelper() {
        SystemLogHelper systemLogHelper = this.systemLogHelper;
        if (systemLogHelper != null) {
            return systemLogHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("systemLogHelper");
        return null;
    }

    @NotNull
    public final StopClubViewModel getViewModel() {
        StopClubViewModel stopClubViewModel = this.viewModel;
        if (stopClubViewModel != null) {
            return stopClubViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityStopclubBinding inflate = ActivityStopclubBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f12019g = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        getLifecycle().addObserver(getViewModel());
        Resources resources = getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        Configuration configuration = resources.getConfiguration();
        Intrinsics.checkExpressionValueIsNotNull(configuration, "resources.configuration");
        String language = configuration.locale.getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "configuration.locale.language");
        this.f12020h = language;
        ActivityStopclubBinding activityStopclubBinding = this.f12019g;
        if (activityStopclubBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityStopclubBinding = null;
        }
        setSupportActionBar(activityStopclubBinding.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        String stopClubMenuEntryName = getRemoteConfig().getStopClubMenuEntryName();
        if (stopClubMenuEntryName != null) {
            ActivityStopclubBinding activityStopclubBinding2 = this.f12019g;
            if (activityStopclubBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityStopclubBinding2 = null;
            }
            activityStopclubBinding2.titleText.setText(stopClubMenuEntryName);
        }
        v();
        kotlinx.coroutines.e.e(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new p0(null), 2, null);
        EventBusUtils.getEventBus().register(this);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.stopclub_menu, menu);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        EventBusUtils.getEventBus().unregister(this);
        super.onDestroy();
    }

    public final void onEventMainThread(@NotNull RefreshStopClubEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        getViewModel().refresh(event.getForceActivate());
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == R.id.use_beta_channel) {
            item.setChecked(!item.isChecked());
            if (item.isChecked()) {
                V();
                return true;
            }
            X();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(@Nullable Menu menu) {
        MenuItem menuItem;
        if (menu != null) {
            menuItem = menu.findItem(R.id.use_beta_channel);
        } else {
            menuItem = null;
        }
        if (menuItem != null) {
            menuItem.setChecked(com.arlosoft.macrodroid.settings.Settings.getUseExtraBetaChannel(this));
        }
        return super.onPrepareOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        StopClubViewModel.refresh$default(getViewModel(), false, 1, null);
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

    public final void setPermissionChecker(@NotNull PermissionChecker permissionChecker) {
        Intrinsics.checkNotNullParameter(permissionChecker, "<set-?>");
        this.permissionChecker = permissionChecker;
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

    public final void setSystemLogHelper(@NotNull SystemLogHelper systemLogHelper) {
        Intrinsics.checkNotNullParameter(systemLogHelper, "<set-?>");
        this.systemLogHelper = systemLogHelper;
    }

    public final void setViewModel(@NotNull StopClubViewModel stopClubViewModel) {
        Intrinsics.checkNotNullParameter(stopClubViewModel, "<set-?>");
        this.viewModel = stopClubViewModel;
    }
}
