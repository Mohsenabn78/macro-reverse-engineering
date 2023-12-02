package com.arlosoft.macrodroid.autobackup.ui.cloud;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AutoBackupCloudViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class AutoBackupUiState {
    public static final int $stable = 0;

    /* compiled from: AutoBackupCloudViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class BackingUp extends AutoBackupUiState {
        public static final int $stable = 0;
        @NotNull
        public static final BackingUp INSTANCE = new BackingUp();

        private BackingUp() {
            super(null);
        }
    }

    /* compiled from: AutoBackupCloudViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class BackupListScreen extends AutoBackupUiState {
        public static final int $stable = 8;

        /* renamed from: a  reason: collision with root package name */
        private final boolean f9375a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final List<BackupInfo> f9376b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f9377c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final String f9378d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BackupListScreen(boolean z3, @NotNull List<BackupInfo> backupList, boolean z4, @Nullable String str) {
            super(null);
            Intrinsics.checkNotNullParameter(backupList, "backupList");
            this.f9375a = z3;
            this.f9376b = backupList;
            this.f9377c = z4;
            this.f9378d = str;
        }

        @NotNull
        public final List<BackupInfo> getBackupList() {
            return this.f9376b;
        }

        @Nullable
        public final String getDeviceId() {
            return this.f9378d;
        }

        public final boolean getFailedState() {
            return this.f9377c;
        }

        public final boolean isLoading() {
            return this.f9375a;
        }

        public /* synthetic */ BackupListScreen(boolean z3, List list, boolean z4, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(z3, list, z4, (i4 & 8) != 0 ? null : str);
        }
    }

    /* compiled from: AutoBackupCloudViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Deleting extends AutoBackupUiState {
        public static final int $stable = 0;
        @NotNull
        public static final Deleting INSTANCE = new Deleting();

        private Deleting() {
            super(null);
        }
    }

    /* compiled from: AutoBackupCloudViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ProOnlyScreen extends AutoBackupUiState {
        public static final int $stable = 0;
        @NotNull
        public static final ProOnlyScreen INSTANCE = new ProOnlyScreen();

        private ProOnlyScreen() {
            super(null);
        }
    }

    /* compiled from: AutoBackupCloudViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Restoring extends AutoBackupUiState {
        public static final int $stable = 0;
        @NotNull
        public static final Restoring INSTANCE = new Restoring();

        private Restoring() {
            super(null);
        }
    }

    /* compiled from: AutoBackupCloudViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class SignInScreen extends AutoBackupUiState {
        public static final int $stable = 0;
        @NotNull
        public static final SignInScreen INSTANCE = new SignInScreen();

        private SignInScreen() {
            super(null);
        }
    }

    private AutoBackupUiState() {
    }

    public /* synthetic */ AutoBackupUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
