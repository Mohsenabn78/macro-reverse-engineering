package com.arlosoft.macrodroid.action;

import android.content.Intent;
import android.os.Parcel;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProOnlyAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public abstract class ProOnlyAction extends Action {
    public static final int $stable = 8;
    @Inject
    public transient PremiumStatusHandler premiumStatusHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProOnlyAction(@NotNull Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        init();
    }

    private final void init() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String getEditModeWarning() {
        if (!getPremiumStatusHandler().getPremiumStatus().isPro()) {
            return SelectableItem.r(R.string.pro_version_required);
        }
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

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleWarningClick() {
        getActivity().startActivity(new Intent(getActivity(), UpgradeActivity2.class));
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeActionWithPermissionCheck(@Nullable TriggerContextInfo triggerContextInfo) {
        if (!getPremiumStatusHandler().getPremiumStatus().isPro()) {
            String str = getConfiguredName() + ": " + SelectableItem.r(R.string.pro_version_required);
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError(str, macroGuid.longValue());
        } else if (checkAllPermissions()) {
            invokeAction(triggerContextInfo);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        return getPremiumStatusHandler().getPremiumStatus().isPro();
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public ProOnlyAction() {
        init();
    }
}
