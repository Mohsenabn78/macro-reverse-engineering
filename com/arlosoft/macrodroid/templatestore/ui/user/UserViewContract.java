package com.arlosoft.macrodroid.templatestore.ui.user;

import com.arlosoft.macrodroid.templatestore.model.User;
import org.jetbrains.annotations.NotNull;

/* compiled from: UserViewContract.kt */
/* loaded from: classes3.dex */
public interface UserViewContract {
    void refreshMacros();

    void setUserBlocked();

    void setUserDetails(@NotNull User user);

    void setUserUnblocked();

    void showReportFailed();

    void showReportUploading(boolean z3);

    void showReported();

    void showSubscriptionInProgress();

    void showSubscriptionProOnly();

    void showSubscriptionSignedInOnly();

    void subscriptionUpdateFailed(boolean z3);

    void updateSubscribedState(boolean z3, boolean z4);
}
