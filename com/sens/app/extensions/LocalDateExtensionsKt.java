package com.sens.app.extensions;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;

/* compiled from: LocalDateExtensions.kt */
/* loaded from: classes6.dex */
public final class LocalDateExtensionsKt {
    public static final long toLong(@NotNull LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
