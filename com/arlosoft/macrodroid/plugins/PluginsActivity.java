package com.arlosoft.macrodroid.plugins;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.data.OrderByOption;
import com.arlosoft.macrodroid.databinding.ActivityPluginsBinding;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.plugins.PluginsViewModel;
import com.arlosoft.macrodroid.plugins.data.AppBrainPackageInfo;
import com.arlosoft.macrodroid.plugins.pluginlist.PluginListFragment;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.common.FlagProvider;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileActivity;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.user.signin.SignInHelper;
import com.arlosoft.macrodroid.utils.FragmentObserver;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.material.snackbar.SnackbarAnimate;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.firestore.util.ExponentialBackoff;
import de.mustafagercek.library.LoadingButton;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PluginsActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nPluginsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginsActivity.kt\ncom/arlosoft/macrodroid/plugins/PluginsActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,494:1\n262#2,2:495\n262#2,2:497\n262#2,2:499\n262#2,2:501\n262#2,2:503\n262#2,2:505\n262#2,2:507\n262#2,2:509\n*S KotlinDebug\n*F\n+ 1 PluginsActivity.kt\ncom/arlosoft/macrodroid/plugins/PluginsActivity\n*L\n119#1:495,2\n140#1:497,2\n148#1:499,2\n169#1:501,2\n183#1:503,2\n363#1:505,2\n371#1:507,2\n440#1:509,2\n*E\n"})
/* loaded from: classes3.dex */
public final class PluginsActivity extends MacroDroidDaggerBaseActivity {
    public static final int $stable = 8;

    /* renamed from: f  reason: collision with root package name */
    private a f13072f;
    @Inject
    public FlagProvider flagProvider;

    /* renamed from: g  reason: collision with root package name */
    private CompositeDisposable f13073g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private AppCompatDialog f13074h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private AppCompatDialog f13075i;

    /* renamed from: j  reason: collision with root package name */
    private ActivityPluginsBinding f13076j;
    @Inject
    public PremiumStatusHandler premiumStatusHandler;
    @Inject
    public ProfileImageProvider profileImageProvider;
    @Inject
    public ScreenLoader screenLoader;
    @Inject
    public SignInHelper signInHelper;
    @Inject
    public UserProvider userProvider;
    @Inject
    public PluginsViewModel viewModel;

    /* compiled from: PluginsActivity.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PluginsViewModel.UploadFailReason.values().length];
            try {
                iArr[PluginsViewModel.UploadFailReason.ALREADY_EXISTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PluginsViewModel.UploadFailReason.USER_NOT_ALLOWED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PluginsActivity.kt */
    /* loaded from: classes3.dex */
    public final class a extends FragmentStateAdapter {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final FragmentObserver f13077a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PluginsActivity f13078b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull PluginsActivity pluginsActivity, FragmentActivity fa) {
            super(fa);
            Intrinsics.checkNotNullParameter(fa, "fa");
            this.f13078b = pluginsActivity;
            this.f13077a = new FragmentObserver();
        }

        @OrderByOption
        private final int a(int i4) {
            if (i4 == 0) {
                return 0;
            }
            return 1;
        }

        public final void b() {
            this.f13077a.notifyObservers();
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @NotNull
        public Fragment createFragment(int i4) {
            PluginListFragment createInstance = PluginListFragment.Companion.createInstance(a(i4));
            this.f13077a.addObserver(createInstance);
            return createInstance;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginsActivity.kt */
    @SourceDebugExtension({"SMAP\nPluginsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginsActivity.kt\ncom/arlosoft/macrodroid/plugins/PluginsActivity$configureViewModelObservers$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,494:1\n262#2,2:495\n*S KotlinDebug\n*F\n+ 1 PluginsActivity.kt\ncom/arlosoft/macrodroid/plugins/PluginsActivity$configureViewModelObservers$1\n*L\n126#1:495,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class b implements Observer<PluginsViewModel.UiState> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(@Nullable PluginsViewModel.UiState uiState) {
            if (uiState != null) {
                PluginsActivity pluginsActivity = PluginsActivity.this;
                if (uiState instanceof PluginsViewModel.UiState.ShowLoadingBlocker) {
                    ActivityPluginsBinding activityPluginsBinding = pluginsActivity.f13076j;
                    if (activityPluginsBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityPluginsBinding = null;
                    }
                    FrameLayout frameLayout = activityPluginsBinding.loadingBlocker;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingBlocker");
                    frameLayout.setVisibility(0);
                } else if (uiState instanceof PluginsViewModel.UiState.ShowAppInfoDialog) {
                    pluginsActivity.C(((PluginsViewModel.UiState.ShowAppInfoDialog) uiState).getPackageInfo(), pluginsActivity.getUserProvider().getUser());
                } else if (uiState instanceof PluginsViewModel.UiState.UploadComplete) {
                    pluginsActivity.w(((PluginsViewModel.UiState.UploadComplete) uiState).getPluginName());
                } else if (uiState instanceof PluginsViewModel.UiState.UploadFailed) {
                    pluginsActivity.x(((PluginsViewModel.UiState.UploadFailed) uiState).getUploadFailReason());
                } else if (uiState instanceof PluginsViewModel.UiState.ShowPluginListDialog) {
                    pluginsActivity.K(((PluginsViewModel.UiState.ShowPluginListDialog) uiState).getAppInfoList());
                } else if (uiState instanceof PluginsViewModel.UiState.CheckConnection) {
                    pluginsActivity.E();
                } else if (uiState instanceof PluginsViewModel.UiState.PackageNotOnPlayStore) {
                    pluginsActivity.v(((PluginsViewModel.UiState.PackageNotOnPlayStore) uiState).getPackageName());
                } else if (uiState instanceof PluginsViewModel.UiState.MaxAttemptsPassed) {
                    pluginsActivity.u();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function0<Unit> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PluginsActivity.this.getScreenLoader().loadUpgradeScreen();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements Function0<Unit> {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PluginsActivity.this.getSignInHelper().signIn(PluginsActivity.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ EditText $apkDownloadLink;
        final /* synthetic */ String $applicationName;
        final /* synthetic */ TextView $descriptionText;
        final /* synthetic */ Drawable $icon;
        final /* synthetic */ String $packageName;
        int label;
        final /* synthetic */ PluginsActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(EditText editText, TextView textView, PluginsActivity pluginsActivity, String str, String str2, Drawable drawable, Continuation<? super e> continuation) {
            super(3, continuation);
            this.$apkDownloadLink = editText;
            this.$descriptionText = textView;
            this.this$0 = pluginsActivity;
            this.$packageName = str;
            this.$applicationName = str2;
            this.$icon = drawable;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e(this.$apkDownloadLink, this.$descriptionText, this.this$0, this.$packageName, this.$applicationName, this.$icon, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                String obj2 = this.$apkDownloadLink.getText().toString();
                String obj3 = this.$descriptionText.getText().toString();
                if (!URLUtil.isValidUrl(obj2)) {
                    ToastCompat.makeText(this.this$0.getApplicationContext(), (int) R.string.please_enter_valid_apk_download_link, 1).show();
                } else if (this.$descriptionText.getText().length() < 20) {
                    ToastCompat.makeText(this.this$0.getApplicationContext(), (int) R.string.invalid_plugin_name_or_description, 1).show();
                } else {
                    this.this$0.getViewModel().sumbitPlugin(this.$packageName, this.$applicationName, "", obj3, "", obj2, null, this.$icon);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class f extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $submitNewPluginDialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(AppCompatDialog appCompatDialog, Continuation<? super f> continuation) {
            super(3, continuation);
            this.$submitNewPluginDialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new f(this.$submitNewPluginDialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$submitNewPluginDialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(PluginsActivity this$0, TabLayout.Tab tab, int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        if (i4 == 0) {
            i5 = R.string.template_store_top_rated;
        } else {
            i5 = R.string.template_store_latest;
        }
        tab.setText(this$0.getString(i5));
        ActivityPluginsBinding activityPluginsBinding = this$0.f13076j;
        if (activityPluginsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginsBinding = null;
        }
        activityPluginsBinding.viewPager.setCurrentItem(tab.getPosition(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(final AppBrainPackageInfo appBrainPackageInfo, User user) {
        ActivityPluginsBinding activityPluginsBinding = this.f13076j;
        if (activityPluginsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginsBinding = null;
        }
        FrameLayout frameLayout = activityPluginsBinding.loadingBlocker;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingBlocker");
        frameLayout.setVisibility(8);
        AppCompatDialog appCompatDialog = this.f13074h;
        if (appCompatDialog != null) {
            appCompatDialog.dismiss();
        }
        AppCompatDialog appCompatDialog2 = new AppCompatDialog(this, R.style.Theme_App_Dialog_SubmitPlugin);
        appCompatDialog2.setTitle(R.string.submit_new_plugin);
        appCompatDialog2.setCancelable(true);
        appCompatDialog2.setContentView(R.layout.dialog_plugin_app_info);
        appCompatDialog2.show();
        View findViewById = appCompatDialog2.findViewById(R.id.pluginName);
        Intrinsics.checkNotNull(findViewById);
        View findViewById2 = appCompatDialog2.findViewById(R.id.developerName);
        Intrinsics.checkNotNull(findViewById2);
        View findViewById3 = appCompatDialog2.findViewById(R.id.description);
        Intrinsics.checkNotNull(findViewById3);
        View findViewById4 = appCompatDialog2.findViewById(R.id.link);
        Intrinsics.checkNotNull(findViewById4);
        View findViewById5 = appCompatDialog2.findViewById(R.id.avatarImage);
        Intrinsics.checkNotNull(findViewById5);
        View findViewById6 = appCompatDialog2.findViewById(R.id.usernameEdit);
        Intrinsics.checkNotNull(findViewById6);
        View findViewById7 = appCompatDialog2.findViewById(R.id.commentCount);
        Intrinsics.checkNotNull(findViewById7);
        View findViewById8 = appCompatDialog2.findViewById(R.id.timeLabel);
        Intrinsics.checkNotNull(findViewById8);
        View findViewById9 = appCompatDialog2.findViewById(R.id.submitButton);
        Intrinsics.checkNotNull(findViewById9);
        final LoadingButton loadingButton = (LoadingButton) findViewById9;
        View findViewById10 = appCompatDialog2.findViewById(R.id.pluginIcon);
        Intrinsics.checkNotNull(findViewById10);
        ((TextView) findViewById).setText(appBrainPackageInfo.getName());
        ((TextView) findViewById2).setText(appBrainPackageInfo.getDeveloperName());
        ((TextView) findViewById3).setText(appBrainPackageInfo.getShortDescription());
        String packageName = appBrainPackageInfo.getPackageName();
        ((TextView) findViewById4).setText("https://play.google.com/store/apps/details?id=" + packageName);
        getProfileImageProvider().loadImageFromUrl((AvatarView) findViewById5, user.getImage(), user.getUsername());
        ((TextView) findViewById6).setText(user.getUsername());
        ((TextView) findViewById7).setText("0");
        ((TextView) findViewById8).setText(String.valueOf(DateUtils.getRelativeTimeSpanString(System.currentTimeMillis(), Calendar.getInstance().getTimeInMillis(), (long) ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS)));
        Glide.with((FragmentActivity) this).m4157load(Uri.parse(appBrainPackageInfo.getIconUrl())).apply((BaseRequestOptions<?>) new RequestOptions().fitCenter()).into((ImageView) findViewById10);
        DialogExtensionsKt.setWidthToParent(appCompatDialog2, getResources().getDimensionPixelOffset(R.dimen.margin_medium));
        loadingButton.setButtonOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.plugins.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PluginsActivity.D(LoadingButton.this, appBrainPackageInfo, this, view);
            }
        });
        this.f13075i = appCompatDialog2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(LoadingButton submitButton, AppBrainPackageInfo appInfo, PluginsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(submitButton, "$submitButton");
        Intrinsics.checkNotNullParameter(appInfo, "$appInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        submitButton.onStartLoading();
        String packageName = appInfo.getPackageName();
        this$0.getViewModel().sumbitPlugin(appInfo.getPackageName(), appInfo.getName(), appInfo.getDeveloperName(), appInfo.getShortDescription(), appInfo.getWebsite(), "https://play.google.com/store/apps/details?id=" + packageName, appInfo.getIconUrl(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        ActivityPluginsBinding activityPluginsBinding = this.f13076j;
        ActivityPluginsBinding activityPluginsBinding2 = null;
        if (activityPluginsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginsBinding = null;
        }
        FrameLayout frameLayout = activityPluginsBinding.loadingBlocker;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingBlocker");
        frameLayout.setVisibility(8);
        ActivityPluginsBinding activityPluginsBinding3 = this.f13076j;
        if (activityPluginsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityPluginsBinding2 = activityPluginsBinding3;
        }
        SnackbarAnimate make = SnackbarAnimate.make(activityPluginsBinding2.coordinatorLayout, (int) R.string.check_connection_try_again, 0);
        Intrinsics.checkNotNullExpressionValue(make, "make(binding.coordinator…ckbarAnimate.LENGTH_LONG)");
        make.getView().setBackgroundResource(R.color.snack_bar_error);
        View findViewById = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(-1);
        make.show();
    }

    private final void F(String str, String str2, final Function0<Unit> function0) {
        ActivityPluginsBinding activityPluginsBinding = this.f13076j;
        if (activityPluginsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginsBinding = null;
        }
        SnackbarAnimate make = SnackbarAnimate.make(activityPluginsBinding.coordinatorLayout, str, 5000);
        Intrinsics.checkNotNullExpressionValue(make, "make(binding.coordinator…yout, errorMessage, 5000)");
        make.getView().setBackgroundResource(R.color.md_light_blue_600);
        View findViewById = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(-1);
        View findViewById2 = make.getView().findViewById(R.id.snackbar_action);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setTextColor(-1);
        make.setAction(str2, new View.OnClickListener() { // from class: com.arlosoft.macrodroid.plugins.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PluginsActivity.G(Function0.this, view);
            }
        });
        make.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Function0 action, View view) {
        Intrinsics.checkNotNullParameter(action, "$action");
        action.invoke();
    }

    private final void H() {
        ActivityPluginsBinding activityPluginsBinding = this.f13076j;
        ActivityPluginsBinding activityPluginsBinding2 = null;
        if (activityPluginsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginsBinding = null;
        }
        FrameLayout frameLayout = activityPluginsBinding.loadingBlocker;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingBlocker");
        frameLayout.setVisibility(8);
        ActivityPluginsBinding activityPluginsBinding3 = this.f13076j;
        if (activityPluginsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityPluginsBinding2 = activityPluginsBinding3;
        }
        SnackbarAnimate make = SnackbarAnimate.make(activityPluginsBinding2.coordinatorLayout, (int) R.string.plugin_already_exists, 0);
        Intrinsics.checkNotNullExpressionValue(make, "make(binding.coordinator…ckbarAnimate.LENGTH_LONG)");
        make.getView().setBackgroundResource(R.color.snack_bar_error);
        View findViewById = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(-1);
        make.show();
    }

    private final void I() {
        if (Settings.getShowPluginDialog(this)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.home_screen_tile_plugins);
            builder.setMessage(R.string.plugin_dialog_info_text);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.plugins.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    PluginsActivity.J(dialogInterface, i4);
                }
            });
            builder.show();
            Settings.setShowPluginDialog(this, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(DialogInterface dialog, int i4) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AlertDialog K(List<? extends AppInfo> list) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_Template);
        appCompatDialog.setContentView(R.layout.dialog_app_chooser);
        appCompatDialog.setTitle(R.string.select_plugin);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.button_bar);
        ListView listView = (ListView) appCompatDialog.findViewById(R.id.application_list);
        SearchView searchView = (SearchView) appCompatDialog.findViewById(R.id.searchView);
        if (searchView != null) {
            searchView.setVisibility(8);
        }
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        ApplicationAdapter applicationAdapter = new ApplicationAdapter(this, new ArrayList(list), null, new ApplicationAdapter.AppSelectionListener() { // from class: com.arlosoft.macrodroid.plugins.c
            @Override // com.arlosoft.macrodroid.applications.ApplicationAdapter.AppSelectionListener
            public final void appSelected(AppInfo appInfo) {
                PluginsActivity.L(PluginsActivity.this, appCompatDialog, appInfo);
            }
        });
        if (listView != null) {
            listView.setAdapter((ListAdapter) applicationAdapter);
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        appCompatDialog.show();
        Window window2 = appCompatDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(PluginsActivity this$0, AppCompatDialog dialog, AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        PluginsViewModel viewModel = this$0.getViewModel();
        String str = appInfo.packageName;
        Intrinsics.checkNotNullExpressionValue(str, "appInfo.packageName");
        viewModel.onSubmitAppPackage(str);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        ActivityPluginsBinding activityPluginsBinding = this.f13076j;
        ActivityPluginsBinding activityPluginsBinding2 = null;
        if (activityPluginsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginsBinding = null;
        }
        FrameLayout frameLayout = activityPluginsBinding.loadingBlocker;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingBlocker");
        frameLayout.setVisibility(8);
        ActivityPluginsBinding activityPluginsBinding3 = this.f13076j;
        if (activityPluginsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityPluginsBinding2 = activityPluginsBinding3;
        }
        SnackbarAnimate make = SnackbarAnimate.make(activityPluginsBinding2.coordinatorLayout, (int) R.string.could_not_sign_in, 0);
        Intrinsics.checkNotNullExpressionValue(make, "make(binding.coordinator…ckbarAnimate.LENGTH_LONG)");
        make.getView().setBackgroundResource(R.color.snack_bar_error);
        View findViewById = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(-1);
        make.show();
    }

    private final void N(String str) {
        ApplicationInfo applicationInfo;
        String str2;
        try {
            applicationInfo = getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            str2 = getPackageManager().getApplicationLabel(applicationInfo).toString();
        } else {
            str2 = "(unknown)";
        }
        String str3 = str2;
        Drawable applicationIcon = getPackageManager().getApplicationIcon(str);
        Intrinsics.checkNotNullExpressionValue(applicationIcon, "packageManager.getApplicationIcon(packageName)");
        AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_Plugins);
        appCompatDialog.setCancelable(false);
        appCompatDialog.setContentView(R.layout.dialog_submit_plugin);
        appCompatDialog.setTitle(R.string.submit_new_plugin);
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog, 0, 1, null);
        View findViewById = appCompatDialog.findViewById(R.id.appIcon);
        Intrinsics.checkNotNull(findViewById);
        View findViewById2 = appCompatDialog.findViewById(R.id.appName);
        Intrinsics.checkNotNull(findViewById2);
        View findViewById3 = appCompatDialog.findViewById(R.id.packageName);
        Intrinsics.checkNotNull(findViewById3);
        View findViewById4 = appCompatDialog.findViewById(R.id.apkDownloadLink);
        Intrinsics.checkNotNull(findViewById4);
        View findViewById5 = appCompatDialog.findViewById(R.id.descriptionText);
        Intrinsics.checkNotNull(findViewById5);
        View findViewById6 = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById6);
        ((ImageView) findViewById).setImageDrawable(applicationIcon);
        ((TextView) findViewById2).setText(str3);
        ((TextView) findViewById3).setText(str);
        appCompatDialog.show();
        ViewExtensionsKt.onClick$default((Button) findViewById6, null, new e((EditText) findViewById4, (TextView) findViewById5, this, str, str3, applicationIcon, null), 1, null);
        Button button = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        if (button != null) {
            ViewExtensionsKt.onClick$default(button, null, new f(appCompatDialog, null), 1, null);
        }
        DialogExtensionsKt.setWidthToParent(appCompatDialog, 0);
    }

    private final void s() {
        getViewModel().getUiState().observe(this, new b());
    }

    private final void t() {
        if (!getPremiumStatusHandler().getPremiumStatus().isPro()) {
            String string = getString(R.string.sorry_pro_users_only_submit_plugins);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.sorry…sers_only_submit_plugins)");
            String string2 = getString(R.string.upgrade);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.upgrade)");
            F(string, string2, new c());
        } else if (getUserProvider().getUser().isGuest()) {
            String string3 = getString(R.string.please_sign_in_to_submit_and_rate_new_plugins);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.pleas…mit_and_rate_new_plugins)");
            String string4 = getString(R.string.sign_in);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.sign_in)");
            F(string3, string4, new d());
        } else {
            getViewModel().getPluginList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        ActivityPluginsBinding activityPluginsBinding = this.f13076j;
        ActivityPluginsBinding activityPluginsBinding2 = null;
        if (activityPluginsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginsBinding = null;
        }
        FrameLayout frameLayout = activityPluginsBinding.loadingBlocker;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingBlocker");
        frameLayout.setVisibility(8);
        ActivityPluginsBinding activityPluginsBinding3 = this.f13076j;
        if (activityPluginsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityPluginsBinding2 = activityPluginsBinding3;
        }
        SnackbarAnimate make = SnackbarAnimate.make(activityPluginsBinding2.coordinatorLayout, (int) R.string.macrodroid_error, 0);
        Intrinsics.checkNotNullExpressionValue(make, "make(binding.coordinator…ckbarAnimate.LENGTH_LONG)");
        make.getView().setBackgroundResource(R.color.snack_bar_error);
        View findViewById = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(-1);
        make.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(String str) {
        ActivityPluginsBinding activityPluginsBinding = this.f13076j;
        if (activityPluginsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginsBinding = null;
        }
        FrameLayout frameLayout = activityPluginsBinding.loadingBlocker;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingBlocker");
        frameLayout.setVisibility(8);
        N(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(String str) {
        AppCompatDialog appCompatDialog = this.f13075i;
        if (appCompatDialog != null) {
            appCompatDialog.dismiss();
        }
        Context applicationContext = getApplicationContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.uploaded);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.uploaded)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        ToastCompat.makeText(applicationContext, (CharSequence) format, 1).show();
        a aVar = this.f13072f;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            aVar = null;
        }
        aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(PluginsViewModel.UploadFailReason uploadFailReason) {
        LoadingButton loadingButton;
        AppCompatDialog appCompatDialog = this.f13075i;
        if (appCompatDialog != null && (loadingButton = (LoadingButton) appCompatDialog.findViewById(R.id.submitButton)) != null) {
            loadingButton.onStopLoading();
        }
        int i4 = WhenMappings.$EnumSwitchMapping$0[uploadFailReason.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                ToastCompat.makeText(getApplicationContext(), (CharSequence) getString(R.string.upload_failed), 1).show();
                return;
            }
            ToastCompat.makeText(getApplicationContext(), (CharSequence) getString(R.string.not_allowed_to_submit_plugins), 1).show();
            AppCompatDialog appCompatDialog2 = this.f13075i;
            if (appCompatDialog2 != null) {
                appCompatDialog2.dismiss();
                return;
            }
            return;
        }
        H();
        AppCompatDialog appCompatDialog3 = this.f13075i;
        if (appCompatDialog3 != null) {
            appCompatDialog3.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(User user) {
        try {
            String string = getString(R.string.templates_signed_in_popup, user.getUsername());
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.templ…_in_popup, user.username)");
            ToastCompat.makeText(getApplicationContext(), (CharSequence) string, 1).show();
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(e4);
        }
    }

    private final void z() {
        this.f13072f = new a(this, this);
        ActivityPluginsBinding activityPluginsBinding = this.f13076j;
        ActivityPluginsBinding activityPluginsBinding2 = null;
        if (activityPluginsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginsBinding = null;
        }
        ViewPager2 viewPager2 = activityPluginsBinding.viewPager;
        a aVar = this.f13072f;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            aVar = null;
        }
        viewPager2.setAdapter(aVar);
        ActivityPluginsBinding activityPluginsBinding3 = this.f13076j;
        if (activityPluginsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginsBinding3 = null;
        }
        activityPluginsBinding3.viewPager.setOffscreenPageLimit(3);
        ActivityPluginsBinding activityPluginsBinding4 = this.f13076j;
        if (activityPluginsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginsBinding4 = null;
        }
        activityPluginsBinding4.tabBar.setTabTextColors(ContextCompat.getColor(this, R.color.white), ContextCompat.getColor(this, R.color.white));
        ActivityPluginsBinding activityPluginsBinding5 = this.f13076j;
        if (activityPluginsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginsBinding5 = null;
        }
        activityPluginsBinding5.tabBar.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white));
        ActivityPluginsBinding activityPluginsBinding6 = this.f13076j;
        if (activityPluginsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginsBinding6 = null;
        }
        TabLayout tabLayout = activityPluginsBinding6.tabBar;
        ActivityPluginsBinding activityPluginsBinding7 = this.f13076j;
        if (activityPluginsBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityPluginsBinding2 = activityPluginsBinding7;
        }
        new TabLayoutMediator(tabLayout, activityPluginsBinding2.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.arlosoft.macrodroid.plugins.a
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i4) {
                PluginsActivity.A(PluginsActivity.this, tab, i4);
            }
        }).attach();
    }

    @NotNull
    public final FlagProvider getFlagProvider() {
        FlagProvider flagProvider = this.flagProvider;
        if (flagProvider != null) {
            return flagProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("flagProvider");
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
    public final ScreenLoader getScreenLoader() {
        ScreenLoader screenLoader = this.screenLoader;
        if (screenLoader != null) {
            return screenLoader;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screenLoader");
        return null;
    }

    @NotNull
    public final SignInHelper getSignInHelper() {
        SignInHelper signInHelper = this.signInHelper;
        if (signInHelper != null) {
            return signInHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("signInHelper");
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
    public final PluginsViewModel getViewModel() {
        PluginsViewModel pluginsViewModel = this.viewModel;
        if (pluginsViewModel != null) {
            return pluginsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        Integer num;
        CompositeDisposable compositeDisposable;
        super.onActivityResult(i4, i5, intent);
        IdpResponse fromResultIntent = IdpResponse.fromResultIntent(intent);
        if (i4 == 9729) {
            Integer num2 = null;
            if (i5 == -1) {
                SignInHelper signInHelper = getSignInHelper();
                CompositeDisposable compositeDisposable2 = this.f13073g;
                if (compositeDisposable2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
                    compositeDisposable = null;
                } else {
                    compositeDisposable = compositeDisposable2;
                }
                SignInHelper.handleSignInResult$default(signInHelper, fromResultIntent, compositeDisposable, new SignInHelper.SignInCallbackHandler() { // from class: com.arlosoft.macrodroid.plugins.PluginsActivity$onActivityResult$1
                    @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                    public void onSignInError() {
                        PluginsActivity.this.M();
                    }

                    @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                    public void onSignInStarted() {
                        ActivityPluginsBinding activityPluginsBinding = PluginsActivity.this.f13076j;
                        if (activityPluginsBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityPluginsBinding = null;
                        }
                        FrameLayout frameLayout = activityPluginsBinding.loadingBlocker;
                        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingBlocker");
                        frameLayout.setVisibility(0);
                    }

                    @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                    public void onSignedIn(@NotNull User user) {
                        Intrinsics.checkNotNullParameter(user, "user");
                        PluginsActivity.this.getViewModel().onNewSignIn();
                        PluginsActivity.this.y(user);
                    }

                    @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                    public void onSignedInNoUser() {
                    }
                }, false, 8, null);
            } else if (fromResultIntent != null) {
                FirebaseUiException error = fromResultIntent.getError();
                if (error != null) {
                    num = Integer.valueOf(error.getErrorCode());
                } else {
                    num = null;
                }
                SystemLog.logError("Sign in error: " + num);
                FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
                FirebaseUiException error2 = fromResultIntent.getError();
                if (error2 != null) {
                    num2 = Integer.valueOf(error2.getErrorCode());
                }
                firebaseCrashlytics.recordException(new Exception("Template store Sign in error: " + num2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityPluginsBinding inflate = ActivityPluginsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f13076j = inflate;
        ActivityPluginsBinding activityPluginsBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        z();
        this.f13073g = new CompositeDisposable();
        ActivityPluginsBinding activityPluginsBinding2 = this.f13076j;
        if (activityPluginsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityPluginsBinding = activityPluginsBinding2;
        }
        setSupportActionBar(activityPluginsBinding.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setTitle(R.string.home_screen_tile_plugins);
        }
        s();
        I();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.plugin_menu, menu);
        View actionView = menu.findItem(R.id.menu_search).getActionView();
        Intrinsics.checkNotNull(actionView, "null cannot be cast to non-null type androidx.appcompat.widget.SearchView");
        SearchView searchView = (SearchView) actionView;
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.arlosoft.macrodroid.plugins.e
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z3) {
                PluginsActivity.B(view, z3);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.arlosoft.macrodroid.plugins.PluginsActivity$onCreateOptionsMenu$2
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(@NotNull String newText) {
                Intrinsics.checkNotNullParameter(newText, "newText");
                PluginsActivity.this.getViewModel().updateSearchText(newText);
                return true;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(@NotNull String query) {
                Intrinsics.checkNotNullParameter(query, "query");
                return false;
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CompositeDisposable compositeDisposable = this.f13073g;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        compositeDisposable.clear();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        switch (item.getItemId()) {
            case 16908332:
                onBackPressed();
                break;
            case R.id.add_new_plugin /* 2131361928 */:
                t();
                return true;
            case R.id.menu_my_profile /* 2131363412 */:
                startActivity(ProfileActivity.Companion.createIntent(this, false, "", true));
                break;
            case R.id.menu_sign_in /* 2131363435 */:
                getSignInHelper().signIn(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        ActivityPluginsBinding activityPluginsBinding = this.f13076j;
        ActivityPluginsBinding activityPluginsBinding2 = null;
        if (activityPluginsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginsBinding = null;
        }
        MenuItem findItem = activityPluginsBinding.toolbar.getMenu().findItem(R.id.menu_my_profile);
        ActivityPluginsBinding activityPluginsBinding3 = this.f13076j;
        if (activityPluginsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityPluginsBinding2 = activityPluginsBinding3;
        }
        MenuItem findItem2 = activityPluginsBinding2.toolbar.getMenu().findItem(R.id.menu_sign_in);
        findItem.setVisible(!getUserProvider().getUser().isGuest());
        findItem2.setVisible(!findItem.isVisible());
        return super.onPrepareOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ActivityPluginsBinding activityPluginsBinding = this.f13076j;
        if (activityPluginsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityPluginsBinding = null;
        }
        FrameLayout frameLayout = activityPluginsBinding.loadingBlocker;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingBlocker");
        frameLayout.setVisibility(8);
    }

    public final void setFlagProvider(@NotNull FlagProvider flagProvider) {
        Intrinsics.checkNotNullParameter(flagProvider, "<set-?>");
        this.flagProvider = flagProvider;
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public final void setProfileImageProvider(@NotNull ProfileImageProvider profileImageProvider) {
        Intrinsics.checkNotNullParameter(profileImageProvider, "<set-?>");
        this.profileImageProvider = profileImageProvider;
    }

    public final void setScreenLoader(@NotNull ScreenLoader screenLoader) {
        Intrinsics.checkNotNullParameter(screenLoader, "<set-?>");
        this.screenLoader = screenLoader;
    }

    public final void setSignInHelper(@NotNull SignInHelper signInHelper) {
        Intrinsics.checkNotNullParameter(signInHelper, "<set-?>");
        this.signInHelper = signInHelper;
    }

    public final void setUserProvider(@NotNull UserProvider userProvider) {
        Intrinsics.checkNotNullParameter(userProvider, "<set-?>");
        this.userProvider = userProvider;
    }

    public final void setViewModel(@NotNull PluginsViewModel pluginsViewModel) {
        Intrinsics.checkNotNullParameter(pluginsViewModel, "<set-?>");
        this.viewModel = pluginsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(View view, boolean z3) {
    }
}
