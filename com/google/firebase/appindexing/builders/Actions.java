package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import com.google.firebase.appindexing.Action;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class Actions {
    @NonNull
    public static Action newView(@NonNull String str, @NonNull String str2) {
        Action.Builder builder = new Action.Builder(Action.Builder.VIEW_ACTION);
        builder.setObject(str, str2);
        return builder.build();
    }
}
