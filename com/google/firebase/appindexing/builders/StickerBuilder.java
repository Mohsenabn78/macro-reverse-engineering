package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class StickerBuilder extends IndexableBuilder<StickerBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public StickerBuilder() {
        super("Sticker");
    }

    @NonNull
    public StickerBuilder setIsPartOf(@NonNull StickerPackBuilder stickerPackBuilder) {
        return (StickerBuilder) super.setIsPartOf(stickerPackBuilder);
    }
}
