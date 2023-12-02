package com.pollfish.internal;

import android.net.Uri;
import java.util.ArrayList;
import kotlin.NotImplementedError;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class l implements m {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final f f36994a;

    public l(@NotNull f fVar) {
        this.f36994a = fVar;
    }

    @Override // com.pollfish.internal.m
    @NotNull
    public final l4<Uri> a(@NotNull k kVar, @NotNull byte[] bArr) {
        throw new NotImplementedError("`Save asset operation is not supported by the API`");
    }

    @Override // com.pollfish.internal.m
    @NotNull
    public final l4<Unit> clear() {
        throw new NotImplementedError("`Clear operation is not supported by the API`");
    }

    @Override // com.pollfish.internal.m
    @NotNull
    public final l4<Unit> a(@NotNull String str) {
        throw new NotImplementedError("`Save content HTML page operation is not supported by the API`");
    }

    @Override // com.pollfish.internal.m
    @NotNull
    public final l4<byte[]> a(@NotNull k kVar) {
        return this.f36994a.b(kVar.c());
    }

    @Override // com.pollfish.internal.m
    @NotNull
    public final l4 a(@NotNull ArrayList arrayList) {
        throw new NotImplementedError("`Clear operation is not supported by the API`");
    }
}
