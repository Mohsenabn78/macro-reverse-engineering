package com.google.firebase.crashlytics.internal.common;

import android.content.Context;

/* loaded from: classes5.dex */
class InstallerPackageNameProvider {

    /* renamed from: a  reason: collision with root package name */
    private String f29535a;

    private static String b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        if (installerPackageName == null) {
            return "";
        }
        return installerPackageName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String a(Context context) {
        String str;
        if (this.f29535a == null) {
            this.f29535a = b(context);
        }
        if ("".equals(this.f29535a)) {
            str = null;
        } else {
            str = this.f29535a;
        }
        return str;
    }
}
