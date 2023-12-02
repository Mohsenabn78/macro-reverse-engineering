package com.arlosoft.macrodroid.autobackup.ui.local;

import com.arlosoft.macrodroid.autobackup.model.BackupFile;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: AutoBackupLocalViewContract.kt */
/* loaded from: classes3.dex */
public interface AutoBackupLocalViewContract {
    void finishBackupScreen();

    void shareBackup(@NotNull BackupFile backupFile);

    void showBackupDialog(@NotNull BackupFile backupFile);

    void showBackupFiles(@NotNull List<BackupFile> list);

    void showBackupRestoreFailed();

    void showBackupRestored();

    void showDeleteAllDialog();

    void showDeleteDialog(@NotNull BackupFile backupFile);

    void showEmptyBackupFiles();

    void showPasswordDialog(@NotNull BackupFile backupFile);

    void showRestoringState(boolean z3);
}
