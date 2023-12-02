package com.google.type;

import com.google.protobuf.Duration;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.type.DateTime;

/* loaded from: classes6.dex */
public interface DateTimeOrBuilder extends MessageLiteOrBuilder {
    int getDay();

    int getHours();

    int getMinutes();

    int getMonth();

    int getNanos();

    int getSeconds();

    DateTime.TimeOffsetCase getTimeOffsetCase();

    TimeZone getTimeZone();

    Duration getUtcOffset();

    int getYear();

    boolean hasTimeZone();

    boolean hasUtcOffset();
}
