package com.firebase.ui.auth.util.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.firebase.ui.auth.util.data.EmailLinkParser;
import com.google.android.gms.common.internal.Preconditions;
import net.bytebuddy.description.type.TypeDescription;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class ContinueUrlBuilder {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f18211a;

    public ContinueUrlBuilder(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        this.f18211a = new StringBuilder(str + TypeDescription.Generic.OfWildcardType.SYMBOL);
    }

    private void a(String str, String str2) {
        boolean z3;
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        StringBuilder sb = this.f18211a;
        if (sb.charAt(sb.length() - 1) == '?') {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            str3 = "";
        } else {
            str3 = "&";
        }
        this.f18211a.append(String.format("%s%s=%s", str3, str, str2));
    }

    public ContinueUrlBuilder appendAnonymousUserId(@NonNull String str) {
        a(EmailLinkParser.LinkParameters.ANONYMOUS_USER_ID_IDENTIFIER, str);
        return this;
    }

    public ContinueUrlBuilder appendForceSameDeviceBit(@NonNull boolean z3) {
        String str;
        if (z3) {
            str = "1";
        } else {
            str = "0";
        }
        a(EmailLinkParser.LinkParameters.FORCE_SAME_DEVICE_IDENTIFIER, str);
        return this;
    }

    public ContinueUrlBuilder appendProviderId(@NonNull String str) {
        a(EmailLinkParser.LinkParameters.PROVIDER_ID_IDENTIFIER, str);
        return this;
    }

    public ContinueUrlBuilder appendSessionId(@NonNull String str) {
        a(EmailLinkParser.LinkParameters.SESSION_IDENTIFIER, str);
        return this;
    }

    public String build() {
        StringBuilder sb = this.f18211a;
        if (sb.charAt(sb.length() - 1) == '?') {
            StringBuilder sb2 = this.f18211a;
            sb2.setLength(sb2.length() - 1);
        }
        return this.f18211a.toString();
    }
}
