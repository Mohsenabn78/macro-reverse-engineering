package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public class AudiobookBuilder extends IndexableBuilder<AudiobookBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AudiobookBuilder() {
        super("Audiobook");
    }

    @NonNull
    public AudiobookBuilder setAuthor(@NonNull PersonBuilder... personBuilderArr) {
        return a("author", personBuilderArr);
    }

    @NonNull
    public AudiobookBuilder setReadBy(@NonNull PersonBuilder... personBuilderArr) {
        return a("readBy", personBuilderArr);
    }
}
