package com.google.android.material.textfield;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class CustomEndIconDelegate extends EndIconDelegate {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomEndIconDelegate(@NonNull TextInputLayout textInputLayout, @DrawableRes int i4) {
        super(textInputLayout, i4);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void a() {
        this.f24595a.setEndIconDrawable(this.f24598d);
        this.f24595a.setEndIconOnClickListener(null);
        this.f24595a.setEndIconOnLongClickListener(null);
    }
}
