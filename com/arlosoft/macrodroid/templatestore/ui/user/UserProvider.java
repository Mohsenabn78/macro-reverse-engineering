package com.arlosoft.macrodroid.templatestore.ui.user;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.FrameMetricsAggregator;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.model.User;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: UserProvider.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UserProvider {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f14195a;

    @Inject
    public UserProvider(@ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f14195a = context;
    }

    public final void clearUser() {
        Settings.setTemplateStoreAccount(this.f14195a, null);
    }

    @NotNull
    public final User getUser() {
        User templateStoreAccount = Settings.getTemplateStoreAccount(this.f14195a);
        if (templateStoreAccount == null || templateStoreAccount.isCloudBackupOnly()) {
            return new User(0, null, null, 0, null, 0, 0, 0, false, true, FrameMetricsAggregator.EVERY_DURATION, null);
        }
        return templateStoreAccount;
    }
}
