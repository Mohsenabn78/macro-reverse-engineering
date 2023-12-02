package com.arlosoft.macrodroid.utils;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.common.AppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class AppUtils {
    public static List<ResolveInfo> getLaunchableActivities(@NonNull PackageManager packageManager, @NonNull String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        return packageManager.queryIntentActivities(intent, 64);
    }

    public static List<AppInfo> reorderSelectedAppsToTop(List<AppInfo> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            AppInfo appInfo = (AppInfo) it.next();
            Iterator<String> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (it2.next().equals(appInfo.packageName)) {
                    it.remove();
                    arrayList.add(appInfo);
                    break;
                }
            }
        }
        arrayList2.addAll(0, arrayList);
        return arrayList2;
    }
}
