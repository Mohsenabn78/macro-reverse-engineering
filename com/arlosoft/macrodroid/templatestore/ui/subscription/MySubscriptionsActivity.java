package com.arlosoft.macrodroid.templatestore.ui.subscription;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.databinding.ActivityMySubscriptionsBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MySubscriptionsActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class MySubscriptionsActivity extends MacroDroidDaggerBaseActivity {

    /* renamed from: f  reason: collision with root package name */
    private ActivityMySubscriptionsBinding f13858f;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: MySubscriptionsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void launchScreen(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            activity.startActivity(new Intent(activity, MySubscriptionsActivity.class));
        }
    }

    private final void n() {
        final b bVar = new b(this);
        ActivityMySubscriptionsBinding activityMySubscriptionsBinding = this.f13858f;
        ActivityMySubscriptionsBinding activityMySubscriptionsBinding2 = null;
        if (activityMySubscriptionsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMySubscriptionsBinding = null;
        }
        activityMySubscriptionsBinding.viewPager.setAdapter(bVar);
        ActivityMySubscriptionsBinding activityMySubscriptionsBinding3 = this.f13858f;
        if (activityMySubscriptionsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMySubscriptionsBinding3 = null;
        }
        TabLayout tabLayout = activityMySubscriptionsBinding3.tabLayout;
        ActivityMySubscriptionsBinding activityMySubscriptionsBinding4 = this.f13858f;
        if (activityMySubscriptionsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMySubscriptionsBinding2 = activityMySubscriptionsBinding4;
        }
        new TabLayoutMediator(tabLayout, activityMySubscriptionsBinding2.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.arlosoft.macrodroid.templatestore.ui.subscription.a
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i4) {
                MySubscriptionsActivity.o(b.this, tab, i4);
            }
        }).attach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(b adapter, TabLayout.Tab tab, int i4) {
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setText(adapter.a(i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityMySubscriptionsBinding inflate = ActivityMySubscriptionsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f13858f = inflate;
        ActivityMySubscriptionsBinding activityMySubscriptionsBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        ActivityMySubscriptionsBinding activityMySubscriptionsBinding2 = this.f13858f;
        if (activityMySubscriptionsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMySubscriptionsBinding = activityMySubscriptionsBinding2;
        }
        setSupportActionBar(activityMySubscriptionsBinding.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setTitle(R.string.my_subscriptions);
        }
        n();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
