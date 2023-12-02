package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class StickerPackBuilder extends IndexableBuilder<StickerPackBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public StickerPackBuilder() {
        super("StickerPack");
    }

    @NonNull
    public StickerPackBuilder setHasSticker(@NonNull StickerBuilder... stickerBuilderArr) {
        a("hasSticker", stickerBuilderArr);
        return this;
    }
}
