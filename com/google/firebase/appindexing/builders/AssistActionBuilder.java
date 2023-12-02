package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.appindexing.Action;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class AssistActionBuilder extends Action.Builder {

    /* renamed from: h  reason: collision with root package name */
    private String f28791h;

    public AssistActionBuilder() {
        super("AssistAction");
    }

    @Override // com.google.firebase.appindexing.Action.Builder
    @NonNull
    public Action build() {
        String str;
        Preconditions.checkNotNull(this.f28791h, "setActionToken is required before calling build().");
        Preconditions.checkNotNull(c(), "setActionStatus is required before calling build().");
        put("actionToken", this.f28791h);
        if (a() == null) {
            setName("AssistAction");
        }
        if (b() == null) {
            String valueOf = String.valueOf(this.f28791h);
            if (valueOf.length() != 0) {
                str = "https://developers.google.com/actions?invocation=".concat(valueOf);
            } else {
                str = new String("https://developers.google.com/actions?invocation=");
            }
            setUrl(str);
        }
        return super.build();
    }

    @NonNull
    public AssistActionBuilder setActionToken(@NonNull String str) {
        Preconditions.checkNotNull(str);
        this.f28791h = str;
        return this;
    }
}
