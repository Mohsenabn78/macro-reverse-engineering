package com.arlosoft.macrodroid.autobackup.ui;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudFragment;
import com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalFragment;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoBackupActivity.kt */
/* loaded from: classes3.dex */
public final class d extends FragmentStateAdapter {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final AutoBackupActivity f9403a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull AutoBackupActivity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f9403a = activity;
    }

    @NotNull
    public final String a(int i4) {
        if (i4 == 0) {
            String string = this.f9403a.getString(R.string.local_backup);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.local_backup)");
            return string;
        }
        String string2 = this.f9403a.getString(R.string.cloud_backup);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.string.cloud_backup)");
        return string2;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int i4) {
        if (i4 == 0) {
            return AutoBackupLocalFragment.Companion.createFragment();
        }
        return AutoBackupCloudFragment.Companion.createFragment();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 2;
    }
}
