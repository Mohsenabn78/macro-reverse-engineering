package com.pollfish.internal;

import android.content.Context;
import android.widget.Toast;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class s3 implements r3 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final Context f37206a;

    public s3(@NotNull Context context) {
        this.f37206a = context;
    }

    @Override // com.pollfish.internal.r3
    public final void a(@NotNull String str) {
        Toast.makeText(this.f37206a, str, 1).show();
    }
}
