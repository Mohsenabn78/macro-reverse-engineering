package com.arlosoft.macrodroid.autobackup.model;

import androidx.compose.runtime.internal.StabilityInferred;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BackupFile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class BackupFile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final File f9308a;

    public BackupFile(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.f9308a = file;
    }

    public static /* synthetic */ BackupFile copy$default(BackupFile backupFile, File file, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            file = backupFile.f9308a;
        }
        return backupFile.copy(file);
    }

    @NotNull
    public final File component1() {
        return this.f9308a;
    }

    @NotNull
    public final BackupFile copy(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return new BackupFile(file);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof BackupFile) && Intrinsics.areEqual(this.f9308a, ((BackupFile) obj).f9308a)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final File getFile() {
        return this.f9308a;
    }

    public int hashCode() {
        return this.f9308a.hashCode();
    }

    public final boolean isEncrypted() {
        boolean endsWith$default;
        String name = this.f9308a.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        endsWith$default = m.endsWith$default(name, ".emdr", false, 2, null);
        return endsWith$default;
    }

    @NotNull
    public String toString() {
        File file = this.f9308a;
        return "BackupFile(file=" + file + ")";
    }
}
