package com.pollfish.internal;

import android.net.Uri;
import java.util.ArrayList;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public interface e2 {
    @NotNull
    l4 a(@NotNull String str);

    @NotNull
    l4<Uri> a(@NotNull String str, @NotNull byte[] bArr);

    @NotNull
    l4 a(@NotNull ArrayList arrayList);

    @NotNull
    l4<byte[]> b(@NotNull String str);

    @NotNull
    l4<Unit> clear();
}
