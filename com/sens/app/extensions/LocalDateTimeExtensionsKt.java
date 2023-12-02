package com.sens.app.extensions;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;

/* compiled from: LocalDateTimeExtensions.kt */
/* loaded from: classes6.dex */
public final class LocalDateTimeExtensionsKt {
    public static final long toLong(@NotNull LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        return localDateTime.atZone2(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
