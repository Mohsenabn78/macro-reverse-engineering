package com.pollfish.internal;

import android.net.Uri;
import java.util.ArrayList;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public interface m {
    @NotNull
    l4<byte[]> a(@NotNull k kVar);

    @NotNull
    l4<Uri> a(@NotNull k kVar, @NotNull byte[] bArr);

    @NotNull
    l4<Unit> a(@NotNull String str);

    @NotNull
    l4 a(@NotNull ArrayList arrayList);

    @NotNull
    l4<Unit> clear();
}
