package com.arlosoft.macrodroid.common;

/* loaded from: classes3.dex */
public class AppInfo {
    public String applicationName;
    public boolean launchable;
    public String packageName;

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            return this.packageName.equals(((AppInfo) obj).packageName);
        }
        return false;
    }

    public int hashCode() {
        return this.packageName.hashCode();
    }
}
