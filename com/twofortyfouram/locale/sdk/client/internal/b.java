package com.twofortyfouram.locale.sdk.client.internal;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.twofortyfouram.assertion.Assertions;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f38093a;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("com.twofortyfouram.locale");
        linkedHashSet.add("com.twofortyfouram.locale.example.host");
        f38093a = Collections.unmodifiableSet(linkedHashSet);
    }

    @Nullable
    public static String a(@NonNull PackageManager packageManager) {
        Assertions.assertNotNull(packageManager, "packageManager");
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        Set<String> set = f38093a;
        if (set.contains(null)) {
            Iterator<PackageInfo> it = installedPackages.iterator();
            if (it.hasNext()) {
                String str = it.next().packageName;
                throw null;
            }
        }
        for (String str2 : set) {
            if (!str2.equals(null)) {
                for (PackageInfo packageInfo : installedPackages) {
                    String str3 = packageInfo.packageName;
                    if (str2.equals(str3)) {
                        return str3;
                    }
                }
                continue;
            }
        }
        return null;
    }
}
