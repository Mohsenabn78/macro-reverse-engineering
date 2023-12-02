package com.arlosoft.macrodroid.homescreen;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.core.net.MailTo;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.android.dx.rop.code.RegisterSpec;
import com.arlosoft.macrodroid.DonateActivity;
import com.arlosoft.macrodroid.HelpActivity;
import com.arlosoft.macrodroid.MacroDroidService;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.WikiActivity;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseFragment;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.celltowers.CellTowerListActivity;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.data.BasicTile;
import com.arlosoft.macrodroid.data.HomeScreenTileConfig;
import com.arlosoft.macrodroid.data.HomeTile;
import com.arlosoft.macrodroid.databinding.FragmentHomeBinding;
import com.arlosoft.macrodroid.drawer.DrawerOverlayHandleService;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.MacroDroidDisabledEvent;
import com.arlosoft.macrodroid.events.MacroDroidEnabledEvent;
import com.arlosoft.macrodroid.events.RefreshHomeScreenEvent;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.extras.stopclub.StopClubActivity;
import com.arlosoft.macrodroid.freeversion.AddDaysActivity;
import com.arlosoft.macrodroid.freeversion.FreeVersionHelper;
import com.arlosoft.macrodroid.geofences.GeofenceListActivity;
import com.arlosoft.macrodroid.homescreen.HomeFragment;
import com.arlosoft.macrodroid.homescreen.infobar.InfoBar;
import com.arlosoft.macrodroid.homescreen.infobar.InfoBarHandler;
import com.arlosoft.macrodroid.homescreen.tiles.HomeScreenTileFactory;
import com.arlosoft.macrodroid.homescreen.tiles.adapter.HomeScreenTilesAdapter;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.privacy.PrivacyActivity;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.stopwatch.StopWatchesActivity;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.translations.TranslationsActivity;
import com.arlosoft.macrodroid.triggers.services.FloatingTextService;
import com.arlosoft.macrodroid.troubleshooting.TroubleShootingActivity;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.upgrade.flashsale.FlashSaleManager;
import com.arlosoft.macrodroid.utils.AccessibilityInfoActivity;
import com.arlosoft.macrodroid.utils.FragmentViewBindingDelegate;
import com.arlosoft.macrodroid.utils.FragmentViewBindingDelegateKt;
import com.arlosoft.macrodroid.utils.UninstallHelper;
import com.arlosoft.macrodroid.utils.VersionHistoryHelper;
import com.arlosoft.macrodroid.variables.MacroDroidVariablesActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.gson.Gson;
import com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager;
import com.hanks.htextview.scale.ScaleTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.m;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import net.bytebuddy.jar.asm.Opcodes;
import net.cachapa.expandablelayout.ExpandableLayout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

/* compiled from: HomeFragment.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nHomeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeFragment.kt\ncom/arlosoft/macrodroid/homescreen/HomeFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,936:1\n1549#2:937\n1620#2,3:938\n1549#2:941\n1620#2,3:942\n766#2:945\n857#2,2:946\n262#3,2:948\n262#3,2:950\n262#3,2:952\n262#3,2:954\n262#3,2:956\n262#3,2:958\n262#3,2:960\n262#3,2:962\n262#3,2:964\n262#3,2:966\n262#3,2:968\n262#3,2:970\n262#3,2:972\n*S KotlinDebug\n*F\n+ 1 HomeFragment.kt\ncom/arlosoft/macrodroid/homescreen/HomeFragment\n*L\n175#1:937\n175#1:938,3\n361#1:941\n361#1:942,3\n364#1:945\n364#1:946,2\n385#1:948,2\n386#1:950,2\n389#1:952,2\n495#1:954,2\n500#1:956,2\n552#1:958,2\n557#1:960,2\n560#1:962,2\n561#1:964,2\n562#1:966,2\n567#1:968,2\n568#1:970,2\n569#1:972,2\n*E\n"})
/* loaded from: classes3.dex */
public final class HomeFragment extends MacroDroidDaggerBaseFragment {

    /* renamed from: k  reason: collision with root package name */
    private static boolean f12295k;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f12296l;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final FragmentViewBindingDelegate f12297b = FragmentViewBindingDelegateKt.viewBinding(this, a.f12305a);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Cache f12298c = MacroDroidApplication.Companion.getInstance().getCache("HomeScreenTiles");
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Gson f12299d = new Gson();

    /* renamed from: e  reason: collision with root package name */
    private List<HomeScreenTile> f12300e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private HomeScreenNavigator f12301f;
    @Inject
    public FlashSaleManager flashSaleManager;
    @Inject
    public FreeVersionHelper freeVersionHelper;

    /* renamed from: g  reason: collision with root package name */
    private UpgradeBanner f12302g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12303h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private CountDownTimer f12304i;
    @Inject
    public InfoBarHandler infoBarHandler;
    @Inject
    public PremiumStatusHandler premiumStatusHandler;
    @Inject
    public ProfileImageProvider profileImageProvider;
    @Inject
    public RemoteConfig remoteConfig;
    @Inject
    public UserProvider userProvider;

    /* renamed from: j  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f12294j = {Reflection.property1(new PropertyReference1Impl(HomeFragment.class, "binding", "getBinding()Lcom/arlosoft/macrodroid/databinding/FragmentHomeBinding;", 0))};
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: HomeFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: HomeFragment.kt */
    /* loaded from: classes3.dex */
    /* synthetic */ class a extends FunctionReferenceImpl implements Function1<View, FragmentHomeBinding> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f12305a = new a();

        a() {
            super(1, FragmentHomeBinding.class, "bind", "bind(Landroid/view/View;)Lcom/arlosoft/macrodroid/databinding/FragmentHomeBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final FragmentHomeBinding invoke(@NotNull View p02) {
            Intrinsics.checkNotNullParameter(p02, "p0");
            return FragmentHomeBinding.bind(p02);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<AppUpdateInfo, Unit> {
        final /* synthetic */ AppUpdateManager $appUpdateManager;
        final /* synthetic */ HomeFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AppUpdateManager appUpdateManager, HomeFragment homeFragment) {
            super(1);
            this.$appUpdateManager = appUpdateManager;
            this.this$0 = homeFragment;
        }

        public final void a(AppUpdateInfo appUpdateInfo) {
            if (appUpdateInfo.updateAvailability() == 2 && appUpdateInfo.isUpdateTypeAllowed(1)) {
                this.$appUpdateManager.startUpdateFlowForResult(appUpdateInfo, 1, this.this$0.requireActivity(), 0);
                this.this$0.requireActivity().finish();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AppUpdateInfo appUpdateInfo) {
            a(appUpdateInfo);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.kt */
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
                String stopClubMenuEntryName = HomeFragment.this.getRemoteConfig().getStopClubMenuEntryName();
                if (stopClubMenuEntryName != null) {
                    HomeFragment.this.A().navigationView.getMenu().findItem(R.id.drawer_stop_club).setTitle(stopClubMenuEntryName);
                }
                HomeFragment.this.F();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.kt */
    /* loaded from: classes3.dex */
    public static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ InfoBar $infoBarToDisplay;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InfoBar infoBar, Continuation<? super d> continuation) {
            super(3, continuation);
            this.$infoBarToDisplay = infoBar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(HomeFragment homeFragment, InfoBar infoBar, float f4, int i4) {
            if (i4 == 0) {
                try {
                    homeFragment.getInfoBarHandler().handleConfigureButton(infoBar);
                } catch (Exception e4) {
                    Timber.e(e4);
                }
            }
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: b */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(this.$infoBarToDisplay, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ExpandableLayout expandableLayout = HomeFragment.this.A().infoBar;
                final HomeFragment homeFragment = HomeFragment.this;
                final InfoBar infoBar = this.$infoBarToDisplay;
                expandableLayout.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() { // from class: com.arlosoft.macrodroid.homescreen.i
                    @Override // net.cachapa.expandablelayout.ExpandableLayout.OnExpansionUpdateListener
                    public final void onExpansionUpdate(float f4, int i4) {
                        HomeFragment.d.c(HomeFragment.this, infoBar, f4, i4);
                    }
                });
                HomeFragment.this.A().infoBar.collapse();
                HomeFragment.this.getInfoBarHandler().markAsShown(this.$infoBarToDisplay);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.kt */
    /* loaded from: classes3.dex */
    public static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ InfoBar $infoBarToDisplay;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InfoBar infoBar, Continuation<? super e> continuation) {
            super(3, continuation);
            this.$infoBarToDisplay = infoBar;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e(this.$infoBarToDisplay, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                HomeFragment.this.getInfoBarHandler().markAsShown(this.$infoBarToDisplay);
                HomeFragment.this.A().infoBar.collapse();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.kt */
    /* loaded from: classes3.dex */
    public static final class f extends Lambda implements Function1<Boolean, Unit> {
        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean isPro) {
            HomeFragment homeFragment = HomeFragment.this;
            Intrinsics.checkNotNullExpressionValue(isPro, "isPro");
            homeFragment.D(isPro.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.kt */
    /* loaded from: classes3.dex */
    public static final class g extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        g(Continuation<? super g> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new g(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                HomeFragment.this.startActivity(new Intent(HomeFragment.this.requireContext(), AddDaysActivity.class));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.kt */
    /* loaded from: classes3.dex */
    public static final class h extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        h(Continuation<? super h> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new h(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                UpgradeActivity2.Companion companion = UpgradeActivity2.Companion;
                FragmentActivity requireActivity = HomeFragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                companion.animateInUpgradeSceen(requireActivity);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.kt */
    /* loaded from: classes3.dex */
    public static final class i extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        i(Continuation<? super i> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new i(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                HomeFragment.this.startActivity(new Intent(HomeFragment.this.requireContext(), AddDaysActivity.class));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.kt */
    /* loaded from: classes3.dex */
    public static final class j extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        j(Continuation<? super j> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new j(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    FirebaseAnalyticsEventLogger.logHomeScreenUpgradeButtonClicked();
                    UpgradeActivity2.Companion companion = UpgradeActivity2.Companion;
                    FragmentActivity requireActivity = HomeFragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    companion.animateInUpgradeSceen(requireActivity);
                } catch (Exception unused) {
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.kt */
    /* loaded from: classes3.dex */
    public static final class k extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        k(Continuation<? super k> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new k(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    FirebaseAnalyticsEventLogger.logHomeScreenUpgradeButtonClicked();
                    UpgradeActivity2.Companion companion = UpgradeActivity2.Companion;
                    FragmentActivity requireActivity = HomeFragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    companion.animateInUpgradeSceen(requireActivity);
                } catch (Exception unused) {
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.kt */
    /* loaded from: classes3.dex */
    public static final class l implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f12308a;

        l(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f12308a = function;
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
            return this.f12308a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f12308a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentHomeBinding A() {
        return (FragmentHomeBinding) this.f12297b.getValue2((Fragment) this, f12294j[0]);
    }

    private final HomeScreenTileConfig B() {
        List mutableList;
        int collectionSizeOrDefault;
        List list;
        HomeScreenTileConfig homeScreenTileConfig = (HomeScreenTileConfig) this.f12298c.get("HomeScreenTiles", HomeScreenTileConfig.class);
        HomeScreenTileConfig.Companion companion = HomeScreenTileConfig.Companion;
        HomeScreenTileConfig defaultConfig = companion.getDefaultConfig();
        if (homeScreenTileConfig != null) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) homeScreenTileConfig.getTiles());
            List<HomeTile> tiles = homeScreenTileConfig.getTiles();
            collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(tiles, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (HomeTile homeTile : tiles) {
                arrayList.add(Long.valueOf(homeTile.getTileId()));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : defaultConfig.getTiles()) {
                if (!arrayList.contains(Long.valueOf(((HomeTile) obj).getTileId()))) {
                    arrayList2.add(obj);
                }
            }
            mutableList.addAll(0, arrayList2);
            list = CollectionsKt___CollectionsKt.toList(mutableList);
            return new HomeScreenTileConfig(list);
        }
        return companion.getDefaultConfig();
    }

    private final void C(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        try {
            switch (itemId) {
                case R.id.dont_kill_my_app /* 2131362674 */:
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://dontkillmyapp.com"));
                    intent.addFlags(268435456);
                    startActivity(intent);
                    break;
                case R.id.drawer_accessibility_services /* 2131362693 */:
                    startActivity(new Intent(requireActivity(), AccessibilityInfoActivity.class));
                    A().drawerLayout.closeDrawers();
                    break;
                case R.id.huawei_support_thread /* 2131363038 */:
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://macrodroidforum.com/index.php?threads/huawei-support-thread.2/")));
                    A().drawerLayout.closeDrawers();
                    break;
                case R.id.uninstall_macrodroid /* 2131364412 */:
                    Context requireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    UninstallHelper.uninstallMacroDroid(requireContext);
                    return;
                case R.id.xiaomi_support_thread /* 2131364676 */:
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://macrodroidforum.com/index.php?threads/xiaomi-support-thread.3/")));
                    A().drawerLayout.closeDrawers();
                    break;
                default:
                    switch (itemId) {
                        case R.id.drawer_blog /* 2131362696 */:
                            try {
                                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://medium.com/@macrodroid")));
                            } catch (ActivityNotFoundException unused) {
                            }
                            A().drawerLayout.closeDrawers();
                            return;
                        case R.id.drawer_cell_towers /* 2131362697 */:
                            Intent intent2 = new Intent(requireActivity(), CellTowerListActivity.class);
                            intent2.putExtra(CellTowerListActivity.EXTRA_EDIT_MODE_ON, true);
                            startActivity(intent2);
                            A().drawerLayout.closeDrawers();
                            return;
                        default:
                            switch (itemId) {
                                case R.id.drawer_donate /* 2131362700 */:
                                    startActivity(new Intent(requireActivity(), DonateActivity.class));
                                    A().drawerLayout.closeDrawers();
                                    return;
                                case R.id.drawer_drawer_options /* 2131362701 */:
                                    HomeScreenNavigator homeScreenNavigator = this.f12301f;
                                    if (homeScreenNavigator != null) {
                                        homeScreenNavigator.showDrawerSettings();
                                        return;
                                    }
                                    return;
                                case R.id.drawer_extras /* 2131362702 */:
                                    A().drawerLayout.closeDrawers();
                                    return;
                                case R.id.drawer_geofences /* 2131362703 */:
                                    Intent intent3 = new Intent(requireActivity(), GeofenceListActivity.class);
                                    intent3.putExtra(CellTowerListActivity.EXTRA_EDIT_MODE_ON, true);
                                    startActivity(intent3);
                                    A().drawerLayout.closeDrawers();
                                    return;
                                default:
                                    switch (itemId) {
                                        case R.id.drawer_help /* 2131362705 */:
                                            startActivity(new Intent(requireActivity(), HelpActivity.class));
                                            A().drawerLayout.closeDrawers();
                                            return;
                                        case R.id.drawer_invite_frieds /* 2131362706 */:
                                            Util.inviteFriends(requireActivity());
                                            A().drawerLayout.closeDrawers();
                                            return;
                                        default:
                                            switch (itemId) {
                                                case R.id.drawer_notification_bar_options /* 2131362709 */:
                                                    HomeScreenNavigator homeScreenNavigator2 = this.f12301f;
                                                    if (homeScreenNavigator2 != null) {
                                                        homeScreenNavigator2.showNotificationBarOptions();
                                                        return;
                                                    }
                                                    return;
                                                case R.id.drawer_privacy_policy /* 2131362710 */:
                                                    startActivity(new Intent(requireActivity(), PrivacyActivity.class));
                                                    A().drawerLayout.closeDrawers();
                                                    break;
                                                case R.id.drawer_quick_settings_options /* 2131362711 */:
                                                    HomeScreenNavigator homeScreenNavigator3 = this.f12301f;
                                                    if (homeScreenNavigator3 != null) {
                                                        homeScreenNavigator3.showQuickSettingsConfig();
                                                        return;
                                                    }
                                                    return;
                                                case R.id.drawer_stop_club /* 2131362712 */:
                                                    startActivity(new Intent(requireActivity(), StopClubActivity.class));
                                                    A().drawerLayout.closeDrawers();
                                                    return;
                                                case R.id.drawer_stopwatches /* 2131362713 */:
                                                    startActivity(new Intent(requireActivity(), StopWatchesActivity.class));
                                                    A().drawerLayout.closeDrawers();
                                                    return;
                                                case R.id.drawer_translations /* 2131362714 */:
                                                    startActivity(new Intent(requireActivity(), TranslationsActivity.class));
                                                    A().drawerLayout.closeDrawers();
                                                    return;
                                                case R.id.drawer_troubleshooting /* 2131362715 */:
                                                    startActivity(new Intent(requireActivity(), TroubleShootingActivity.class));
                                                    A().drawerLayout.closeDrawers();
                                                    return;
                                                case R.id.drawer_upgrade_to_pro /* 2131362716 */:
                                                    K();
                                                    A().drawerLayout.closeDrawers();
                                                    return;
                                                case R.id.drawer_variables /* 2131362717 */:
                                                    startActivity(new Intent(requireActivity(), MacroDroidVariablesActivity.class));
                                                    A().drawerLayout.closeDrawers();
                                                    return;
                                                case R.id.drawer_version_history /* 2131362718 */:
                                                    FragmentActivity requireActivity = requireActivity();
                                                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                                                    VersionHistoryHelper.displayVersionHistory(requireActivity, false);
                                                    A().drawerLayout.closeDrawers();
                                                    break;
                                                case R.id.drawer_wiki /* 2131362719 */:
                                                    startActivity(new Intent(requireActivity(), WikiActivity.class));
                                                    A().drawerLayout.closeDrawers();
                                                    return;
                                                default:
                                            }
                                    }
                            }
                    }
            }
        } catch (ActivityNotFoundException unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(boolean z3) {
        v(z3);
        if (!z3 && Settings.isProVersionLegacy(requireContext())) {
            w();
        }
        if (getPremiumStatusHandler().getPremiumStatus().isPro()) {
            A().navigationView.getMenu().findItem(R.id.drawer_upgrade_to_pro).setVisible(false);
        } else if (getFreeVersionHelper().haveFreeDaysExpired()) {
            Settings.setMacroDroidEnabled(getContext(), false);
            A().onOffSwitch.setChecked(false);
        }
    }

    private final boolean E() {
        if (getFlashSaleManager().isFlashSaleActive() && !this.f12303h) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        try {
            A().drawerLayout.openDrawer(GravityCompat.START);
        } catch (IllegalStateException unused) {
        }
    }

    private final void G() {
        int collectionSizeOrDefault;
        List<HomeScreenTile> mutableList;
        boolean z3;
        GridLayoutManager gridLayoutManager;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        HomeScreenNavigator homeScreenNavigator = this.f12301f;
        Intrinsics.checkNotNull(homeScreenNavigator);
        HomeScreenTileFactory homeScreenTileFactory = new HomeScreenTileFactory(requireActivity, homeScreenNavigator, getRemoteConfig(), getPremiumStatusHandler());
        List<HomeTile> tiles = B().getTiles();
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(tiles, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (HomeTile homeTile : tiles) {
            arrayList.add(homeScreenTileFactory.createHomeScreenTile(homeTile));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        this.f12300e = mutableList;
        Object systemService = requireContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        if (windowManager.getDefaultDisplay().getWidth() < windowManager.getDefaultDisplay().getHeight()) {
            z3 = true;
        } else {
            z3 = false;
        }
        RecyclerView recyclerView = A().homeScreenGrid;
        if (z3) {
            gridLayoutManager = new GridLayoutManager(requireActivity(), Settings.getHomeScreenTilesPerRow(requireContext()));
        } else {
            gridLayoutManager = new GridLayoutManager(requireActivity(), Settings.getHomeScreenTilesPerRowLandscape(requireContext()));
        }
        recyclerView.setLayoutManager(gridLayoutManager);
        RecyclerViewDragDropManager recyclerViewDragDropManager = new RecyclerViewDragDropManager();
        List<HomeScreenTile> list = this.f12300e;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tiles");
            list = null;
        }
        RecyclerView.Adapter createWrappedAdapter = recyclerViewDragDropManager.createWrappedAdapter(new HomeScreenTilesAdapter(list));
        Intrinsics.checkNotNullExpressionValue(createWrappedAdapter, "dragDropManager.createWrappedAdapter(tileAdapter)");
        A().homeScreenGrid.setAdapter(createWrappedAdapter);
        RecyclerView.ItemAnimator itemAnimator = A().homeScreenGrid.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        recyclerViewDragDropManager.setInitiateOnMove(false);
        recyclerViewDragDropManager.setInitiateOnLongPress(true);
        recyclerViewDragDropManager.attachRecyclerView(A().homeScreenGrid);
        recyclerViewDragDropManager.setOnItemDragEventListener(new RecyclerViewDragDropManager.OnItemDragEventListener() { // from class: com.arlosoft.macrodroid.homescreen.HomeFragment$refreshTiles$2
            @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.OnItemDragEventListener
            public void onItemDragFinished(int i4, int i5, boolean z4) {
                List list2;
                int collectionSizeOrDefault2;
                list2 = HomeFragment.this.f12300e;
                if (list2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tiles");
                    list2 = null;
                }
                List<HomeScreenTile> list3 = list2;
                collectionSizeOrDefault2 = kotlin.collections.f.collectionSizeOrDefault(list3, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                for (HomeScreenTile homeScreenTile : list3) {
                    arrayList2.add(new BasicTile(homeScreenTile.getId()));
                }
                HomeFragment.this.I(new HomeScreenTileConfig(arrayList2));
            }

            @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.OnItemDragEventListener
            public void onItemDragStarted(int i4) {
            }

            @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.OnItemDragEventListener
            public void onItemDragMoveDistanceUpdated(int i4, int i5) {
            }

            @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.OnItemDragEventListener
            public void onItemDragPositionChanged(int i4, int i5) {
            }
        });
    }

    private final void H() {
        String str = "The pro upgrade has been lost on my device.\n\nThe email account I purchased with was: <Please enter email address here>";
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(MailTo.MAILTO_SCHEME));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"support@macrodroid.com"});
        intent.putExtra("android.intent.extra.SUBJECT", requireContext().getString(R.string.pro_upgrade_failed));
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.addFlags(268435456);
        try {
            requireContext().startActivity(intent);
        } catch (Exception unused) {
            Timber.e("No application available to handle ACTION_SENDTO intent", new Object[0]);
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.setType("message/rfc822");
            intent2.putExtra("android.intent.extra.EMAIL", new String[]{"support@macrodroid.com"});
            intent2.putExtra("android.intent.extra.SUBJECT", requireContext().getString(R.string.pro_upgrade_failed));
            intent2.putExtra("android.intent.extra.TEXT", str);
            intent2.addFlags(268435456);
            try {
                requireContext().startActivity(Intent.createChooser(intent2, requireContext().getString(R.string.upgrade_support)));
            } catch (Exception unused2) {
                Timber.e("No application available to handle ACTION_SEND intent", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(HomeScreenTileConfig homeScreenTileConfig) {
        this.f12298c.put(this.f12299d, "HomeScreenTiles", homeScreenTileConfig);
    }

    private final void J() {
        try {
            PackageInfo packageInfo = requireContext().getPackageManager().getPackageInfo(requireContext().getPackageName(), 0);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "requireContext().package…Context().packageName, 0)");
            Settings.setLastVersionRun(getActivity(), packageInfo.versionCode);
        } catch (Exception unused) {
        }
    }

    private final void K() {
        UpgradeActivity2.Companion companion = UpgradeActivity2.Companion;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        companion.animateInUpgradeSceen(requireActivity);
    }

    private final void j() {
        if (MacroStore.getInstance().getAllCompletedMacros().size() > 5 && !Settings.hasPromptedForReview(requireContext())) {
            if (System.currentTimeMillis() - Settings.getLastPromptedForReviewTime(requireContext()) > 864000000) {
                AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
                builder.setTitle(R.string.review_application);
                builder.setMessage(R.string.if_you_like_please_review);
                builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.homescreen.f
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        HomeFragment.k(HomeFragment.this, dialogInterface, i4);
                    }
                });
                builder.setNegativeButton(R.string.no_thanks, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.homescreen.g
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        HomeFragment.l(HomeFragment.this, dialogInterface, i4);
                    }
                });
                builder.setNeutralButton(R.string.maybe_later, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.homescreen.h
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        HomeFragment.m(HomeFragment.this, dialogInterface, i4);
                    }
                });
                builder.show();
                FirebaseAnalyticsEventLogger.logReviewPromptShown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(HomeFragment this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            try {
                Settings.setPromptedForReview(this$0.requireContext());
                Intent intent = new Intent("android.intent.action.VIEW");
                String packageName = this$0.requireContext().getPackageName();
                intent.setData(Uri.parse("market://details?id=" + packageName));
                this$0.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
            }
        } catch (ActivityNotFoundException unused2) {
            String packageName2 = this$0.requireContext().getPackageName();
            this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + packageName2)));
        }
        FirebaseAnalyticsEventLogger.logReviewPromptAnswer("ok");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(HomeFragment this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Settings.setPromptedForReview(this$0.requireContext());
        FirebaseAnalyticsEventLogger.logReviewPromptAnswer("no_thanks");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(HomeFragment this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Settings.setLastPromptedForReviewTime(this$0.requireContext(), System.currentTimeMillis());
        FirebaseAnalyticsEventLogger.logReviewPromptAnswer("maybe_later");
    }

    private final void n() {
        if (getRemoteConfig().getForceUpdateToLatest()) {
            AppUpdateManager create = AppUpdateManagerFactory.create(requireContext());
            Intrinsics.checkNotNullExpressionValue(create, "create(requireContext())");
            Task<AppUpdateInfo> appUpdateInfo = create.getAppUpdateInfo();
            Intrinsics.checkNotNullExpressionValue(appUpdateInfo, "appUpdateManager.appUpdateInfo");
            final b bVar = new b(create, this);
            appUpdateInfo.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.homescreen.a
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    HomeFragment.o(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void p() {
        boolean equals;
        boolean equals2;
        String str;
        String str2 = " Pro";
        A().drawerLayout.setDescendantFocusability(Opcodes.ASM6);
        View inflate = LayoutInflater.from(requireActivity()).inflate(R.layout.nav_header, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.headerTitle)).setText(StringExtensionsKt.setMacroDroidSizePaths("MACRODROID"));
        A().navigationView.addHeaderView(inflate);
        A().navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() { // from class: com.arlosoft.macrodroid.homescreen.b
            @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean q4;
                q4 = HomeFragment.q(HomeFragment.this, menuItem);
                return q4;
            }
        });
        ImageButton imageButton = A().drawMenuToggle;
        Intrinsics.checkNotNullExpressionValue(imageButton, "binding.drawMenuToggle");
        ViewExtensionsKt.onClick$default(imageButton, null, new c(null), 1, null);
        if (Build.VERSION.SDK_INT < 24) {
            A().navigationView.getMenu().findItem(R.id.drawer_quick_settings_options).setVisible(false);
        }
        A().navigationView.getMenu().findItem(R.id.drawer_stop_club).setVisible(getRemoteConfig().getShowStopClub());
        String str3 = Build.MANUFACTURER;
        equals = m.equals(str3, "xiaomi", true);
        if (!equals) {
            equals2 = m.equals(str3, "huawei", true);
            if (equals2) {
                A().navigationView.getMenu().findItem(R.id.huawei_support_thread).setVisible(true);
            }
        } else {
            A().navigationView.getMenu().findItem(R.id.xiaomi_support_thread).setVisible(true);
        }
        if (getPremiumStatusHandler().getPremiumStatus().isPro()) {
            MenuItem findItem = A().navigationView.getMenu().findItem(R.id.drawer_upgrade_to_pro);
            Intrinsics.checkNotNullExpressionValue(findItem, "binding.navigationView.m…id.drawer_upgrade_to_pro)");
            findItem.setVisible(false);
        }
        try {
            View findViewById = inflate.findViewById(R.id.nav_header_version_info);
            Intrinsics.checkNotNullExpressionValue(findViewById, "navigationHeader.findVie….nav_header_version_info)");
            TextView textView = (TextView) findViewById;
            try {
                String str4 = requireContext().getPackageManager().getPackageInfo(requireContext().getPackageName(), 0).versionName;
                if (getPremiumStatusHandler().getPremiumStatus().isPro()) {
                    str = " Pro";
                } else {
                    str = "";
                }
                textView.setText(RegisterSpec.PREFIX + str4 + str);
            } catch (Exception unused) {
                if (!getPremiumStatusHandler().getPremiumStatus().isPro()) {
                    str2 = "";
                }
                textView.setText("v5.38.16" + str2);
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(HomeFragment this$0, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        this$0.C(menuItem);
        return true;
    }

    private final void r(int i4) {
        int i5;
        int i6;
        boolean z3;
        int i7;
        InfoBar infoBarToDisplay = getInfoBarHandler().getInfoBarToDisplay(i4);
        if (infoBarToDisplay != null) {
            if (infoBarToDisplay instanceof InfoBar.HelpTranslateMessage) {
                String language = Locale.getDefault().getLanguage();
                Intrinsics.checkNotNullExpressionValue(language, "getDefault().language");
                FirebaseAnalyticsEventLogger.logTranslationInfoBarShown(language);
            }
            Button button = A().configureButton;
            Intrinsics.checkNotNullExpressionValue(button, "binding.configureButton");
            int i8 = 8;
            if (infoBarToDisplay.getShowConfigure()) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            button.setVisibility(i5);
            View view = A().barBottomSpace;
            Intrinsics.checkNotNullExpressionValue(view, "binding.barBottomSpace");
            if (!infoBarToDisplay.getShowConfigure()) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            view.setVisibility(i6);
            Button button2 = A().configureButton;
            String configureOverride = infoBarToDisplay.getConfigureOverride();
            if (configureOverride == null) {
                Integer configureOverrideRes = infoBarToDisplay.getConfigureOverrideRes();
                if (configureOverrideRes != null) {
                    i7 = configureOverrideRes.intValue();
                } else {
                    i7 = R.string.configure;
                }
                configureOverride = getString(i7);
            }
            button2.setText(configureOverride);
            ImageView imageView = A().infoIcon;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.infoIcon");
            if (infoBarToDisplay.getIconRes() != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                i8 = 0;
            }
            imageView.setVisibility(i8);
            if (infoBarToDisplay.getIconRes() != null) {
                A().infoIcon.setImageResource(infoBarToDisplay.getIconRes().intValue());
            }
            Button button3 = A().configureButton;
            Intrinsics.checkNotNullExpressionValue(button3, "binding.configureButton");
            ViewExtensionsKt.onClick$default(button3, null, new d(infoBarToDisplay, null), 1, null);
            A().infoBarBg.setBackgroundColor(ContextCompat.getColor(requireContext(), infoBarToDisplay.getBgColor()));
            if (infoBarToDisplay.getMessageOveride() != null) {
                A().infoText.setText(infoBarToDisplay.getMessageOveride());
            } else {
                A().infoText.setText(getString(infoBarToDisplay.getMessage()));
            }
            if (!f12295k) {
                A().infoBar.expand();
                f12295k = true;
                FirebaseAnalyticsEventLogger.logBannerShown(infoBarToDisplay.getAnalyticsName());
            } else {
                A().infoBar.expand(false);
            }
            ImageView imageView2 = A().infoBarDismissButton;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.infoBarDismissButton");
            ViewExtensionsKt.onClick$default(imageView2, null, new e(infoBarToDisplay, null), 1, null);
            return;
        }
        A().infoBar.collapse(false);
    }

    private final void s() {
        final Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        boolean macroDroidEnabled = Settings.getMacroDroidEnabled(requireContext);
        A().onOffSwitch.setOnCheckedChangeListener(null);
        A().onOffSwitch.setChecked(macroDroidEnabled);
        A().onOffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.homescreen.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                HomeFragment.t(HomeFragment.this, requireContext, compoundButton, z3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(HomeFragment this$0, Context context, CompoundButton compoundButton, boolean z3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (z3) {
            if (this$0.getFreeVersionHelper().haveFreeDaysExpired()) {
                Settings.setMacroDroidEnabled(context, false);
                if (compoundButton != null) {
                    compoundButton.setChecked(false);
                }
                this$0.startActivity(new Intent(this$0.requireContext(), AddDaysActivity.class));
                return;
            }
            Settings.setMacroDroidEnabled(context, true);
            Macro.setMacroDroidEnabledState(true);
            MacroDroidService.Companion.startService(context);
            MacroStore.getInstance().updateEnabledStateOfAllCompletedMacros();
            ToastCompat.makeText(context, (CharSequence) this$0.getString(R.string.macrodroid_enabled), 0).show();
            FirebaseAnalyticsEventLogger.logMainSwitchToggle(true);
            if (Settings.isDrawerEnabled(this$0.requireActivity())) {
                this$0.requireContext().stopService(new Intent(context, DrawerOverlayHandleService.class));
                this$0.requireActivity().startService(new Intent(this$0.requireActivity(), DrawerOverlayHandleService.class));
                return;
            }
            return;
        }
        Settings.setMacroDroidEnabled(context, false);
        Macro.setMacroDroidEnabledState(false);
        MacroDroidService.Companion.stopService(context);
        FloatingTextService.Companion.stopService(context);
        MacroStore.getInstance().updateEnabledStateOfAllCompletedMacros();
        ToastCompat.makeText(context, (CharSequence) this$0.getString(R.string.macrodroid_disabled), 0).show();
        FirebaseAnalyticsEventLogger.logMainSwitchToggle(true);
        if (Settings.isDrawerEnabled(this$0.requireActivity())) {
            this$0.requireActivity().stopService(new Intent(this$0.requireActivity(), DrawerOverlayHandleService.class));
        }
    }

    private final void u() {
        try {
            if (getPremiumStatusHandler().getPremiumStatus().isPro()) {
                D(true);
            } else {
                getPremiumStatusHandler().isProLiveStatus().observe(getViewLifecycleOwner(), new l(new f()));
            }
        } catch (IllegalStateException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(boolean z3) {
        if (getActivity() != null) {
            if (z3) {
                LinearLayout linearLayout = A().upgradeBar;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.upgradeBar");
                linearLayout.setVisibility(8);
                return;
            }
            if (!getRemoteConfig().shouldShowUpgradeButtonShimmer()) {
                A().shimmerLayout.hideShimmer();
            }
            LinearLayout linearLayout2 = A().upgradeBar;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.upgradeBar");
            linearLayout2.setVisibility(0);
            Button button = A().addDaysButton;
            Intrinsics.checkNotNullExpressionValue(button, "binding.addDaysButton");
            ViewExtensionsKt.onClick$default(button, null, new g(null), 1, null);
            A().daysRemainingText.setText(getFreeVersionHelper().getTimeRemainingText());
            if (E()) {
                final Ref.IntRef intRef = new Ref.IntRef();
                final long flashSaleExpiry = getFlashSaleManager().getFlashSaleExpiry() - System.currentTimeMillis();
                CountDownTimer countDownTimer = this.f12304i;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                this.f12304i = new CountDownTimer(flashSaleExpiry) { // from class: com.arlosoft.macrodroid.homescreen.HomeFragment$configureUpgradeBar$2
                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        this.f12303h = true;
                        this.v(false);
                    }

                    @Override // android.os.CountDownTimer
                    public void onTick(long j4) {
                        String padStart;
                        String padStart2;
                        String padStart3;
                        long j5 = j4 / 1000;
                        TextView textView = this.A().flashSaleTimeRemaining;
                        padStart = StringsKt__StringsKt.padStart(String.valueOf(j5 / 3600), 2, '0');
                        long j6 = 60;
                        padStart2 = StringsKt__StringsKt.padStart(String.valueOf((j5 / j6) % j6), 2, '0');
                        padStart3 = StringsKt__StringsKt.padStart(String.valueOf(j5 % j6), 2, '0');
                        textView.setText(padStart + ":" + padStart2 + ":" + padStart3);
                        Ref.IntRef intRef2 = intRef;
                        int i4 = intRef2.element + 1;
                        intRef2.element = i4;
                        if (i4 % 9 == 0) {
                            this.A().flashSaleText.animateText(this.getString(R.string.flash_sale));
                        } else if ((i4 + 6) % 9 == 0) {
                            try {
                                ScaleTextView scaleTextView = this.A().flashSaleText;
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                String string = this.getString(R.string.flash_sale_percentage_off);
                                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.flash_sale_percentage_off)");
                                String format = String.format(string, Arrays.copyOf(new Object[]{50}, 1));
                                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                                scaleTextView.animateText(format);
                            } catch (Exception e4) {
                                FirebaseAnalyticsEventLogger.logHandledException(e4);
                                this.A().flashSaleText.animateText("50% off");
                            }
                        } else if ((i4 + 3) % 9 == 0) {
                            ScaleTextView scaleTextView2 = this.A().flashSaleText;
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                            String string2 = this.getString(R.string.flash_sale_24_hours_label);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.flash_sale_24_hours_label)");
                            String format2 = String.format(string2, Arrays.copyOf(new Object[]{50}, 1));
                            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                            scaleTextView2.animateText(format2);
                        }
                    }
                }.start();
                LinearLayout linearLayout3 = A().flashSaleBar;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.flashSaleBar");
                linearLayout3.setVisibility(0);
                LinearLayout linearLayout4 = A().flashSaleBar;
                Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.flashSaleBar");
                ViewExtensionsKt.onClick$default(linearLayout4, null, new h(null), 1, null);
            } else {
                LinearLayout linearLayout5 = A().flashSaleBar;
                Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.flashSaleBar");
                linearLayout5.setVisibility(8);
            }
            if (getRemoteConfig().getLimitedFreeUsageEnabledState() && !getFreeVersionHelper().isOldInstallAllowedUnlimitedUse()) {
                TextView textView = A().upgradeReason;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.upgradeReason");
                textView.setVisibility(8);
                FrameLayout frameLayout = A().addDaysButtonContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.addDaysButtonContainer");
                frameLayout.setVisibility(0);
                LinearLayout linearLayout6 = A().freeDaysInfoContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout6, "binding.freeDaysInfoContainer");
                linearLayout6.setVisibility(0);
                LinearLayout linearLayout7 = A().upgradeBar;
                Intrinsics.checkNotNullExpressionValue(linearLayout7, "binding.upgradeBar");
                ViewExtensionsKt.onClick$default(linearLayout7, null, new i(null), 1, null);
            } else {
                TextView textView2 = A().upgradeReason;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.upgradeReason");
                textView2.setVisibility(0);
                FrameLayout frameLayout2 = A().addDaysButtonContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.addDaysButtonContainer");
                frameLayout2.setVisibility(8);
                LinearLayout linearLayout8 = A().freeDaysInfoContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout8, "binding.freeDaysInfoContainer");
                linearLayout8.setVisibility(8);
                TextView textView3 = A().upgradeReason;
                UpgradeBanner upgradeBanner = this.f12302g;
                if (upgradeBanner == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("upgradeBanner");
                    upgradeBanner = null;
                }
                textView3.setText(upgradeBanner.getUpgradeReasonText());
                LinearLayout linearLayout9 = A().upgradeBar;
                Intrinsics.checkNotNullExpressionValue(linearLayout9, "binding.upgradeBar");
                ViewExtensionsKt.onClick$default(linearLayout9, null, new j(null), 1, null);
            }
            Button button2 = A().upgradeButton;
            Intrinsics.checkNotNullExpressionValue(button2, "binding.upgradeButton");
            ViewExtensionsKt.onClick$default(button2, null, new k(null), 1, null);
        }
    }

    private final void w() {
        int legacyProWarningCount;
        if (f12296l || (legacyProWarningCount = Settings.getLegacyProWarningCount(getContext())) > 1) {
            return;
        }
        Settings.setLegacyProWarningCount(getContext(), legacyProWarningCount + 1);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(R.string.pro_upgrade_failed);
        builder.setMessage(R.string.pro_upgrade_issue_detail);
        builder.setPositiveButton(R.string.action_clear_app_data, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.homescreen.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                HomeFragment.x(HomeFragment.this, dialogInterface, i4);
            }
        });
        if (legacyProWarningCount > 0) {
            builder.setNegativeButton(R.string.request_upgrade_support, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.homescreen.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    HomeFragment.y(HomeFragment.this, dialogInterface, i4);
                }
            });
            builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        } else {
            builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        }
        FirebaseAnalyticsEventLogger.logLegacyProUpgradeNotApplied();
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(HomeFragment this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", "com.android.vending", null));
            this$0.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(HomeFragment this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H();
    }

    private final void z() {
        if (Settings.getShowWhatsNew(requireContext())) {
            int i4 = requireContext().getPackageManager().getPackageInfo(requireContext().getPackageName(), 0).versionCode;
            int lastVersionRun = Settings.getLastVersionRun(requireContext());
            if (lastVersionRun != 0 && lastVersionRun < i4 - 2) {
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                VersionHistoryHelper.displayVersionHistory(requireActivity, true);
            }
        }
    }

    @NotNull
    public final FlashSaleManager getFlashSaleManager() {
        FlashSaleManager flashSaleManager = this.flashSaleManager;
        if (flashSaleManager != null) {
            return flashSaleManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("flashSaleManager");
        return null;
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
    public final InfoBarHandler getInfoBarHandler() {
        InfoBarHandler infoBarHandler = this.infoBarHandler;
        if (infoBarHandler != null) {
            return infoBarHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("infoBarHandler");
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
    public final ProfileImageProvider getProfileImageProvider() {
        ProfileImageProvider profileImageProvider = this.profileImageProvider;
        if (profileImageProvider != null) {
            return profileImageProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("profileImageProvider");
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
    public final UserProvider getUserProvider() {
        UserProvider userProvider = this.userProvider;
        if (userProvider != null) {
            return userProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userProvider");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!EventBusUtils.getEventBus().isRegistered(this)) {
            EventBusUtils.getEventBus().register(this);
        }
        MacroDroidService.Companion companion = MacroDroidService.Companion;
        Context applicationContext = requireContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "requireContext().applicationContext");
        companion.updateNotification(applicationContext, true, false);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_home, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f12301f = null;
        EventBusUtils.getEventBus().unregister(this);
    }

    public final void onEventMainThread(@NotNull MacroDroidDisabledEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        A().onOffSwitch.setChecked(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        CountDownTimer countDownTimer = this.f12304i;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!getPremiumStatusHandler().getPremiumStatus().isPro()) {
            getFlashSaleManager().startNewFlashSaleIfAppropriate();
        }
        s();
        u();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FirebaseAnalyticsEventLogger.logScreenView(requireActivity, "HomeFragment");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.f12302g = new UpgradeBanner(requireContext);
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
        this.f12301f = (HomeScreenNavigator) requireActivity2;
        A().titleText.setText(StringExtensionsKt.setMacroDroidSizePaths("MACRODROID"));
        G();
        p();
        z();
        J();
        j();
        u();
        r(Settings.getLastVersionRun(requireContext()));
        n();
    }

    public final void setFlashSaleManager(@NotNull FlashSaleManager flashSaleManager) {
        Intrinsics.checkNotNullParameter(flashSaleManager, "<set-?>");
        this.flashSaleManager = flashSaleManager;
    }

    public final void setFreeVersionHelper(@NotNull FreeVersionHelper freeVersionHelper) {
        Intrinsics.checkNotNullParameter(freeVersionHelper, "<set-?>");
        this.freeVersionHelper = freeVersionHelper;
    }

    public final void setInfoBarHandler(@NotNull InfoBarHandler infoBarHandler) {
        Intrinsics.checkNotNullParameter(infoBarHandler, "<set-?>");
        this.infoBarHandler = infoBarHandler;
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public final void setProfileImageProvider(@NotNull ProfileImageProvider profileImageProvider) {
        Intrinsics.checkNotNullParameter(profileImageProvider, "<set-?>");
        this.profileImageProvider = profileImageProvider;
    }

    public final void setRemoteConfig(@NotNull RemoteConfig remoteConfig) {
        Intrinsics.checkNotNullParameter(remoteConfig, "<set-?>");
        this.remoteConfig = remoteConfig;
    }

    public final void setUserProvider(@NotNull UserProvider userProvider) {
        Intrinsics.checkNotNullParameter(userProvider, "<set-?>");
        this.userProvider = userProvider;
    }

    public final void onEventMainThread(@NotNull MacroDroidEnabledEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        A().onOffSwitch.setChecked(true);
    }

    public final void onEventMainThread(@NotNull RefreshHomeScreenEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        G();
    }
}
