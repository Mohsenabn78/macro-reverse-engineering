package com.google.android.play.core.ktx;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.install.InstallState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: com.google.android.play:app-update-ktx@@2.0.1 */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult;", "", "()V", "Available", "Downloaded", "InProgress", "NotAvailable", "Lcom/google/android/play/core/ktx/AppUpdateResult$Available;", "Lcom/google/android/play/core/ktx/AppUpdateResult$Downloaded;", "Lcom/google/android/play/core/ktx/AppUpdateResult$InProgress;", "Lcom/google/android/play/core/ktx/AppUpdateResult$NotAvailable;", "java.com.google.android.apps.play.store.sdk.playcore.ktx_playcore_app_update_ktx"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public class AppUpdateResult {

    /* compiled from: com.google.android.play:app-update-ktx@@2.0.1 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult$Downloaded;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "", "completeUpdate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "a", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "appUpdateManager", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lcom/google/android/play/core/appupdate/AppUpdateManager;)V", "java.com.google.android.apps.play.store.sdk.playcore.ktx_playcore_app_update_ktx"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class Downloaded extends AppUpdateResult {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final AppUpdateManager f25329a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Downloaded(@NotNull AppUpdateManager appUpdateManager) {
            super(null);
            Intrinsics.checkNotNullParameter(appUpdateManager, "appUpdateManager");
            this.f25329a = appUpdateManager;
        }

        @Nullable
        public final Object completeUpdate(@NotNull Continuation<? super Unit> continuation) {
            Object coroutine_suspended;
            Object requestCompleteUpdate = AppUpdateManagerKtxKt.requestCompleteUpdate(this.f25329a, continuation);
            coroutine_suspended = a.getCOROUTINE_SUSPENDED();
            if (requestCompleteUpdate == coroutine_suspended) {
                return requestCompleteUpdate;
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: com.google.android.play:app-update-ktx@@2.0.1 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult$InProgress;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "Lcom/google/android/play/core/install/InstallState;", "a", "Lcom/google/android/play/core/install/InstallState;", "getInstallState", "()Lcom/google/android/play/core/install/InstallState;", "installState", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lcom/google/android/play/core/install/InstallState;)V", "java.com.google.android.apps.play.store.sdk.playcore.ktx_playcore_app_update_ktx"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class InProgress extends AppUpdateResult {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final InstallState f25330a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InProgress(@NotNull InstallState installState) {
            super(null);
            Intrinsics.checkNotNullParameter(installState, "installState");
            this.f25330a = installState;
        }

        @NotNull
        public final InstallState getInstallState() {
            return this.f25330a;
        }
    }

    /* compiled from: com.google.android.play:app-update-ktx@@2.0.1 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult$NotAvailable;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "()V", "java.com.google.android.apps.play.store.sdk.playcore.ktx_playcore_app_update_ktx"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class NotAvailable extends AppUpdateResult {
        @NotNull
        public static final NotAvailable INSTANCE = new NotAvailable();

        private NotAvailable() {
            super(null);
        }
    }

    private AppUpdateResult() {
    }

    public /* synthetic */ AppUpdateResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: com.google.android.play:app-update-ktx@@2.0.1 */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdateResult$Available;", "Lcom/google/android/play/core/ktx/AppUpdateResult;", "Landroid/app/Activity;", "activity", "", "requestCode", "", "startFlexibleUpdate", "Landroidx/fragment/app/Fragment;", "fragment", "startImmediateUpdate", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "a", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "appUpdateManager", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "b", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "getUpdateInfo", "()Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "updateInfo", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lcom/google/android/play/core/appupdate/AppUpdateManager;Lcom/google/android/play/core/appupdate/AppUpdateInfo;)V", "java.com.google.android.apps.play.store.sdk.playcore.ktx_playcore_app_update_ktx"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class Available extends AppUpdateResult {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final AppUpdateManager f25327a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final AppUpdateInfo f25328b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Available(@NotNull AppUpdateManager appUpdateManager, @NotNull AppUpdateInfo updateInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(appUpdateManager, "appUpdateManager");
            Intrinsics.checkNotNullParameter(updateInfo, "updateInfo");
            this.f25327a = appUpdateManager;
            this.f25328b = updateInfo;
        }

        @NotNull
        public final AppUpdateInfo getUpdateInfo() {
            return this.f25328b;
        }

        public final boolean startFlexibleUpdate(@NotNull Activity activity, int i4) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return this.f25327a.startUpdateFlowForResult(this.f25328b, 0, activity, i4);
        }

        public final boolean startImmediateUpdate(@NotNull Activity activity, int i4) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            return this.f25327a.startUpdateFlowForResult(this.f25328b, 1, activity, i4);
        }

        public final boolean startFlexibleUpdate(@NotNull Fragment fragment, int i4) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            return AppUpdateManagerKtxKt.startUpdateFlowForResult(this.f25327a, this.f25328b, 0, fragment, i4);
        }

        public final boolean startImmediateUpdate(@NotNull Fragment fragment, int i4) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            return AppUpdateManagerKtxKt.startUpdateFlowForResult(this.f25327a, this.f25328b, 1, fragment, i4);
        }
    }
}
