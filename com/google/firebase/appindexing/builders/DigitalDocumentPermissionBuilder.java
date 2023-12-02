package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class DigitalDocumentPermissionBuilder extends IndexableBuilder<DigitalDocumentPermissionBuilder> {
    @NonNull
    public static final String COMMENT_PERMISSION = "CommentPermission";
    @NonNull
    public static final String READ_PERMISSION = "ReadPermission";
    @NonNull
    public static final String WRITE_PERMISSION = "WritePermission";

    /* JADX INFO: Access modifiers changed from: package-private */
    public DigitalDocumentPermissionBuilder() {
        super("DigitalDocumentPermission");
    }

    @NonNull
    public DigitalDocumentPermissionBuilder setGrantee(@NonNull PersonBuilder... personBuilderArr) {
        a("grantee", personBuilderArr);
        return this;
    }

    @NonNull
    public DigitalDocumentPermissionBuilder setPermissionType(@NonNull String str) {
        put("permissionType", str);
        return this;
    }
}
