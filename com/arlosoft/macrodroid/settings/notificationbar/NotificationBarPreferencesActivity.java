package com.arlosoft.macrodroid.settings.notificationbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.databinding.ActivityNotificationBarPreferencesBinding;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.settings.notificationbar.NotificationBarPreferencesActivity;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotificationBarPreferencesActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class NotificationBarPreferencesActivity extends MacroDroidBaseActivity {
    public static final int $stable = 8;

    /* renamed from: f  reason: collision with root package name */
    private ActivityNotificationBarPreferencesBinding f13531f;

    private final void n() {
        ActivityNotificationBarPreferencesBinding activityNotificationBarPreferencesBinding = null;
        if (Settings.shouldHideInfoCardNotificationBar(this)) {
            ActivityNotificationBarPreferencesBinding activityNotificationBarPreferencesBinding2 = this.f13531f;
            if (activityNotificationBarPreferencesBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityNotificationBarPreferencesBinding = activityNotificationBarPreferencesBinding2;
            }
            activityNotificationBarPreferencesBinding.infoCard.infoCardView.setVisibility(8);
            return;
        }
        ActivityNotificationBarPreferencesBinding activityNotificationBarPreferencesBinding3 = this.f13531f;
        if (activityNotificationBarPreferencesBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityNotificationBarPreferencesBinding3 = null;
        }
        activityNotificationBarPreferencesBinding3.infoCard.infoCardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.notification_bar_primary));
        ActivityNotificationBarPreferencesBinding activityNotificationBarPreferencesBinding4 = this.f13531f;
        if (activityNotificationBarPreferencesBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityNotificationBarPreferencesBinding4 = null;
        }
        activityNotificationBarPreferencesBinding4.infoCard.infoCardTitle.setText(R.string.notification_bar_options);
        ActivityNotificationBarPreferencesBinding activityNotificationBarPreferencesBinding5 = this.f13531f;
        if (activityNotificationBarPreferencesBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityNotificationBarPreferencesBinding5 = null;
        }
        activityNotificationBarPreferencesBinding5.infoCard.infoCardDetail.setText(R.string.notification_bar_options_info_card);
        ActivityNotificationBarPreferencesBinding activityNotificationBarPreferencesBinding6 = this.f13531f;
        if (activityNotificationBarPreferencesBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityNotificationBarPreferencesBinding = activityNotificationBarPreferencesBinding6;
        }
        activityNotificationBarPreferencesBinding.infoCard.infoCardGotIt.setOnClickListener(new View.OnClickListener() { // from class: l0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationBarPreferencesActivity.o(NotificationBarPreferencesActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(NotificationBarPreferencesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Settings.hideInfoCardNotificationBar(this$0.getApplicationContext());
        ActivityNotificationBarPreferencesBinding activityNotificationBarPreferencesBinding = this$0.f13531f;
        if (activityNotificationBarPreferencesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityNotificationBarPreferencesBinding = null;
        }
        activityNotificationBarPreferencesBinding.infoCard.infoCardView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityNotificationBarPreferencesBinding inflate = ActivityNotificationBarPreferencesBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f13531f = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        setTitle(R.string.notification_bar_options);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
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
