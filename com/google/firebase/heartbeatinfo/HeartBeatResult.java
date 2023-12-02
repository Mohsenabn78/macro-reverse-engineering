package com.google.firebase.heartbeatinfo;

import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue
/* loaded from: classes5.dex */
public abstract class HeartBeatResult {
    public static HeartBeatResult create(String str, List<String> list) {
        return new AutoValue_HeartBeatResult(str, list);
    }

    public abstract List<String> getUsedDates();

    public abstract String getUserAgent();
}
