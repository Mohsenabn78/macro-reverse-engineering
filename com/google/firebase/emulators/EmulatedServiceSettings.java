package com.google.firebase.emulators;

import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public final class EmulatedServiceSettings {

    /* renamed from: a  reason: collision with root package name */
    private final String f30071a;

    /* renamed from: b  reason: collision with root package name */
    private final int f30072b;

    public EmulatedServiceSettings(@NonNull String str, int i4) {
        this.f30071a = str;
        this.f30072b = i4;
    }

    public String getHost() {
        return this.f30071a;
    }

    public int getPort() {
        return this.f30072b;
    }
}
