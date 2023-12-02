package com.twofortyfouram.locale.sdk.host.internal;

import android.content.pm.ResolveInfo;
import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.Comparator;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
final class PackageNameComparator implements Comparator<ResolveInfo>, Serializable {
    private static final long serialVersionUID = -5145288289897584068L;

    @Override // java.util.Comparator
    public int compare(@NonNull ResolveInfo resolveInfo, @NonNull ResolveInfo resolveInfo2) {
        return resolveInfo.activityInfo.packageName.compareToIgnoreCase(resolveInfo2.activityInfo.packageName);
    }
}
