package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes5.dex */
public class BuildIdInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f29390a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29391b;

    /* renamed from: c  reason: collision with root package name */
    private final String f29392c;

    public BuildIdInfo(String str, String str2, String str3) {
        this.f29390a = str;
        this.f29391b = str2;
        this.f29392c = str3;
    }

    public String getArch() {
        return this.f29391b;
    }

    public String getBuildId() {
        return this.f29392c;
    }

    public String getLibraryName() {
        return this.f29390a;
    }
}
