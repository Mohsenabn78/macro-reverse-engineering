package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import java.util.Set;

@AutoValue
/* loaded from: classes5.dex */
public abstract class ConfigUpdate {
    @NonNull
    public static ConfigUpdate create(@NonNull Set<String> set) {
        return new AutoValue_ConfigUpdate(set);
    }

    @NonNull
    public abstract Set<String> getUpdatedKeys();
}
