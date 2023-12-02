package com.arlosoft.macrodroid.freeversion.datapartners;

import android.content.SharedPreferences;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.preference.PreferenceManager;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.freeversion.DataSharingService;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import io.huq.sourcekit.HISourceKit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: HuqDataPartner.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class HuqDataPartner extends DataPartner {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f12195a = PreferenceManager.getDefaultSharedPreferences(MacroDroidApplication.Companion.getInstance());
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: HuqDataPartner.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final SharedPreferences.Editor a() {
        SharedPreferences.Editor edit = this.f12195a.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "prefs.edit()");
        return edit;
    }

    @Override // com.arlosoft.macrodroid.freeversion.datapartners.DataPartner
    public void disableDataSharing(boolean z3) {
        if (this.f12195a.getBoolean("huq_enabled", false)) {
            SystemLog.logVerbose("Disabling data sharing with Huq");
            trackDataSharingDisabled();
            FirebaseAnalyticsEventLogger.INSTANCE.logDataSharingServiceDisabled(DataSharingService.HUQ, z3);
            a().putBoolean("huq_enabled", false).apply();
            HISourceKit.getInstance().stopRecording();
        }
    }

    @Override // com.arlosoft.macrodroid.freeversion.datapartners.DataPartner
    public void enableDataSharing() {
        if (!this.f12195a.getBoolean("huq_enabled", false)) {
            SystemLog.logVerbose("Enabling data sharing with Huq");
            trackDataSharingEnabled();
            FirebaseAnalyticsEventLogger.INSTANCE.logDataSharingServiceEnabled(DataSharingService.HUQ);
            a().putBoolean("huq_enabled", true).apply();
            HISourceKit.getInstance().recordWithAPIKey("3b7c8fd1-2f80-4ff1-aeaa-eab084c63c81", MacroDroidApplication.Companion.getInstance());
        }
    }

    @Override // com.arlosoft.macrodroid.freeversion.datapartners.DataPartner
    public void initialise(@NotNull Function1<? super Boolean, Unit> completeCallback) {
        Intrinsics.checkNotNullParameter(completeCallback, "completeCallback");
        completeCallback.invoke(Boolean.TRUE);
    }

    @Override // com.arlosoft.macrodroid.freeversion.datapartners.DataPartner
    @NotNull
    public String partnerName() {
        return "Huq";
    }
}
