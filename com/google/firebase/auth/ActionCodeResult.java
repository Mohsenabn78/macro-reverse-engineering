package com.google.firebase.auth;

import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public interface ActionCodeResult {
    public static final int EMAIL = 0;
    public static final int ERROR = 3;
    public static final int FROM_EMAIL = 1;
    public static final int PASSWORD_RESET = 0;
    public static final int RECOVER_EMAIL = 2;
    public static final int REVERT_SECOND_FACTOR_ADDITION = 6;
    public static final int SIGN_IN_WITH_EMAIL_LINK = 4;
    public static final int VERIFY_BEFORE_CHANGE_EMAIL = 5;
    public static final int VERIFY_EMAIL = 1;

    /* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface ActionDataKey {
    }

    /* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface Operation {
    }

    @Nullable
    @Deprecated
    String getData(int i4);

    @Nullable
    ActionCodeInfo getInfo();

    int getOperation();
}
