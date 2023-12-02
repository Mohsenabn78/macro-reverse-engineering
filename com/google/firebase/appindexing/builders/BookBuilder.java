package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public class BookBuilder extends IndexableBuilder<BookBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BookBuilder() {
        super("Book");
    }

    @NonNull
    public BookBuilder setAuthor(@NonNull PersonBuilder... personBuilderArr) {
        return a("author", personBuilderArr);
    }
}
