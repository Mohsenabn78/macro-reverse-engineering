package com.arlosoft.macrodroid.extensions;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;

/* compiled from: LongExtensions.kt */
/* loaded from: classes3.dex */
public final class LongExtensionsKt {
    public static final long getDaysToMilli(long j4) {
        return j4 * 86400000;
    }

    @NotNull
    public static final LocalDate toLocalDate(long j4) {
        LocalDate localDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(j4), ZoneId.systemDefault()).toLocalDate();
        Intrinsics.checkNotNullExpressionValue(localDate, "ofInstant(Instant.ofEpoc…mDefault()).toLocalDate()");
        return localDate;
    }

    @NotNull
    public static final LocalDateTime toLocalDateTime(long j4) {
        LocalDateTime ofInstant = LocalDateTime.ofInstant(Instant.ofEpochMilli(j4), ZoneId.systemDefault());
        Intrinsics.checkNotNullExpressionValue(ofInstant, "ofInstant(Instant.ofEpoc…, ZoneId.systemDefault())");
        return ofInstant;
    }

    @NotNull
    public static final LocalTime toLocalTime(long j4) {
        LocalTime localTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(j4), ZoneId.systemDefault()).toLocalTime();
        Intrinsics.checkNotNullExpressionValue(localTime, "ofInstant(Instant.ofEpoc…mDefault()).toLocalTime()");
        return localTime;
    }
}
