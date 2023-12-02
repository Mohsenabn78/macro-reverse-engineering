package com.arlosoft.macrodroid.action.activities.httprequest;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.HttpRequestAction;
import com.arlosoft.macrodroid.action.HttpRequestConfig;
import com.arlosoft.macrodroid.action.HttpRequestEditingStore;
import com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestParamsFragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.databinding.ActivityHttpRequestConfigBinding;
import com.google.android.material.tabs.TabLayout;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HttpRequestConfigActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class HttpRequestConfigActivity extends MacroDroidDaggerBaseActivity {
    @NotNull
    public static final String EXTRA_HTTP_REQUEST_CONFIG = "http_request_config";

    /* renamed from: f  reason: collision with root package name */
    private ActivityHttpRequestConfigBinding f3013f;

    /* renamed from: g  reason: collision with root package name */
    private HttpRequestConfig f3014g;

    /* renamed from: h  reason: collision with root package name */
    private HttpRequestAction f3015h;

    /* renamed from: i  reason: collision with root package name */
    private long f3016i;
    @Inject
    public HttpRequestConfigViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: HttpRequestConfigActivity.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: HttpRequestConfigActivity.kt */
    /* loaded from: classes2.dex */
    public final class PageAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final long f3017a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ HttpRequestConfigActivity f3018b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PageAdapter(@NotNull HttpRequestConfigActivity httpRequestConfigActivity, FragmentManager fm, long j4) {
            super(fm);
            Intrinsics.checkNotNullParameter(fm, "fm");
            this.f3018b = httpRequestConfigActivity;
            this.f3017a = j4;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 4;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        @NotNull
        public Fragment getItem(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            return HttpRequestSettingsFragment.Companion.newInstance(this.f3017a);
                        }
                        return HttpRequestParamsFragment.Companion.newInstance(HttpRequestParamsFragment.ParamType.HEADER_PARAMS, this.f3017a);
                    }
                    return HttpRequestContentBodyFragment.Companion.newInstance(this.f3017a);
                }
                return HttpRequestParamsFragment.Companion.newInstance(HttpRequestParamsFragment.ParamType.QUERY_PARAMS, this.f3017a);
            }
            return HttpRequestSettingsFragment.Companion.newInstance(this.f3017a);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            return "";
                        }
                        return this.f3018b.getString(R.string.http_request_header_params);
                    }
                    return this.f3018b.getString(R.string.http_request_content_body);
                }
                return this.f3018b.getString(R.string.http_request_query_params);
            }
            return this.f3018b.getString(R.string.settings);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestConfigActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<Unit, Unit> {
        a() {
            super(1);
        }

        public final void a(@Nullable Unit unit) {
            HttpRequestConfigActivity.this.setResult(-1);
            HttpRequestConfigActivity.this.finish();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            a(unit);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestConfigActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements Function1<Unit, Unit> {
        b() {
            super(1);
        }

        public final void a(@Nullable Unit unit) {
            HttpRequestConfigActivity.this.r();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            a(unit);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestConfigActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c extends Lambda implements Function1<String, Unit> {
        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable String str) {
            if (str != null) {
                HttpRequestConfigActivity.this.q(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpRequestConfigActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f3019a;

        d(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f3019a = function;
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
            return this.f3019a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f3019a.invoke(obj);
        }
    }

    private final void o() {
        getViewModel().getCloseConfigurationEvent().observe(this, new d(new a()));
        getViewModel().getShowExitPromptEvent().observe(this, new d(new b()));
        getViewModel().getErrorMessageEvent().observe(this, new d(new c()));
    }

    private final void p() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        PageAdapter pageAdapter = new PageAdapter(this, supportFragmentManager, this.f3016i);
        ActivityHttpRequestConfigBinding activityHttpRequestConfigBinding = this.f3013f;
        ActivityHttpRequestConfigBinding activityHttpRequestConfigBinding2 = null;
        if (activityHttpRequestConfigBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityHttpRequestConfigBinding = null;
        }
        activityHttpRequestConfigBinding.viewPager.setAdapter(pageAdapter);
        ActivityHttpRequestConfigBinding activityHttpRequestConfigBinding3 = this.f3013f;
        if (activityHttpRequestConfigBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityHttpRequestConfigBinding3 = null;
        }
        activityHttpRequestConfigBinding3.viewPager.setOffscreenPageLimit(8);
        ActivityHttpRequestConfigBinding activityHttpRequestConfigBinding4 = this.f3013f;
        if (activityHttpRequestConfigBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityHttpRequestConfigBinding4 = null;
        }
        TabLayout tabLayout = activityHttpRequestConfigBinding4.tabBar;
        ActivityHttpRequestConfigBinding activityHttpRequestConfigBinding5 = this.f3013f;
        if (activityHttpRequestConfigBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityHttpRequestConfigBinding2 = activityHttpRequestConfigBinding5;
        }
        tabLayout.setupWithViewPager(activityHttpRequestConfigBinding2.viewPager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(String str) {
        ToastCompat.makeText((Context) this, (CharSequence) str, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Action);
        builder.setTitle(R.string.action_http_request);
        builder.setMessage(R.string.do_you_wish_to_save_changes);
        builder.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                HttpRequestConfigActivity.s(HttpRequestConfigActivity.this, dialogInterface, i4);
            }
        });
        builder.setNeutralButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(R.string.discard, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                HttpRequestConfigActivity.t(HttpRequestConfigActivity.this, dialogInterface, i4);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(HttpRequestConfigActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().save();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(HttpRequestConfigActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setResult(0);
        this$0.finish();
    }

    @NotNull
    public final HttpRequestConfigViewModel getViewModel() {
        HttpRequestConfigViewModel httpRequestConfigViewModel = this.viewModel;
        if (httpRequestConfigViewModel != null) {
            return httpRequestConfigViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityHttpRequestConfigBinding inflate = ActivityHttpRequestConfigBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f3013f = inflate;
        ActivityHttpRequestConfigBinding activityHttpRequestConfigBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        this.f3016i = getIntent().getLongExtra(Constants.EXTRA_MACRO_GUID, 0L);
        ActivityHttpRequestConfigBinding activityHttpRequestConfigBinding2 = this.f3013f;
        if (activityHttpRequestConfigBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityHttpRequestConfigBinding = activityHttpRequestConfigBinding2;
        }
        setSupportActionBar(activityHttpRequestConfigBinding.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setTitle(R.string.action_http_request);
        }
        getLifecycle().addObserver(getViewModel());
        Parcelable parcelableExtra = getIntent().getParcelableExtra(EXTRA_HTTP_REQUEST_CONFIG);
        Intrinsics.checkNotNull(parcelableExtra);
        this.f3014g = (HttpRequestConfig) parcelableExtra;
        HttpRequestAction httpRequestAction = HttpRequestEditingStore.INSTANCE.getHttpRequestAction();
        Intrinsics.checkNotNull(httpRequestAction);
        this.f3015h = httpRequestAction;
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestConfigActivity$onCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                HttpRequestConfigActivity.this.getViewModel().onHandleBackPressed();
            }
        });
        p();
        o();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.http_request_config_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId != 16908332) {
            if (itemId == R.id.menu_save) {
                getViewModel().save();
            }
        } else {
            getViewModel().onHandleBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public final void setViewModel(@NotNull HttpRequestConfigViewModel httpRequestConfigViewModel) {
        Intrinsics.checkNotNullParameter(httpRequestConfigViewModel, "<set-?>");
        this.viewModel = httpRequestConfigViewModel;
    }
}
