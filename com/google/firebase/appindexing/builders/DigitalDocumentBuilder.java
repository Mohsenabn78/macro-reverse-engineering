package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import java.util.Date;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class DigitalDocumentBuilder extends IndexableBuilder<DigitalDocumentBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DigitalDocumentBuilder() {
        super("DigitalDocument");
    }

    @NonNull
    public DigitalDocumentBuilder setAuthor(@NonNull PersonBuilder... personBuilderArr) {
        a("author", personBuilderArr);
        return this;
    }

    @NonNull
    public DigitalDocumentBuilder setDateCreated(@NonNull Date date) {
        put("dateCreated", date.getTime());
        return this;
    }

    @NonNull
    public DigitalDocumentBuilder setDateModified(@NonNull Date date) {
        put("dateModified", date.getTime());
        return this;
    }

    @NonNull
    public DigitalDocumentBuilder setHasDigitalDocumentPermission(@NonNull DigitalDocumentPermissionBuilder... digitalDocumentPermissionBuilderArr) {
        a("hasDigitalDocumentPermission", digitalDocumentPermissionBuilderArr);
        return this;
    }

    @NonNull
    public DigitalDocumentBuilder setText(@NonNull String str) {
        put("text", str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DigitalDocumentBuilder(String str) {
        super(str);
    }
}
