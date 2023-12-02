package com.firebase.ui.auth.ui;

import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public interface ProgressView {
    void hideProgress();

    void showProgress(@StringRes int i4);
}
