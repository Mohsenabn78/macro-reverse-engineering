package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class PersonBuilder extends IndexableBuilder<PersonBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PersonBuilder() {
        super("Person");
    }

    @NonNull
    public PersonBuilder setEmail(@NonNull String str) {
        put("email", str);
        return this;
    }

    @NonNull
    public PersonBuilder setIsSelf(@NonNull boolean z3) {
        put("isSelf", z3);
        return this;
    }

    @NonNull
    public PersonBuilder setTelephone(@NonNull String str) {
        put("telephone", str);
        return this;
    }
}
