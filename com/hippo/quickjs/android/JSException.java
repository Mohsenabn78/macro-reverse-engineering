package com.hippo.quickjs.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes6.dex */
public class JSException {

    /* renamed from: a  reason: collision with root package name */
    private boolean f34057a;

    /* renamed from: b  reason: collision with root package name */
    private String f34058b;

    /* renamed from: c  reason: collision with root package name */
    private String f34059c;

    @Nullable
    public String getException() {
        return this.f34058b;
    }

    @Nullable
    public String getStack() {
        return this.f34059c;
    }

    public boolean isError() {
        return this.f34057a;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f34057a) {
            sb.append("Throw: ");
        }
        sb.append(this.f34058b);
        sb.append("\n");
        String str = this.f34059c;
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }
}
