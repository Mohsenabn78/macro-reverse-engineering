package com.arlosoft.macrodroid.utils;

import android.content.Context;
import android.content.pm.Signature;
import android.util.Base64;
import androidx.compose.runtime.internal.StabilityInferred;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SigningHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class SigningHelper {
    public static final int $stable = 0;
    @NotNull
    public static final SigningHelper INSTANCE = new SigningHelper();

    private SigningHelper() {
    }

    @Nullable
    public final String getSigningKeySha1(@NotNull Context context) {
        boolean z3;
        CharSequence trim;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Signature[] sigs = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            Intrinsics.checkNotNullExpressionValue(sigs, "sigs");
            if (sigs.length == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                byte[] byteArray = sigs[0].toByteArray();
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(\"SHA\")");
                messageDigest.update(byteArray);
                String encodeToString = Base64.encodeToString(messageDigest.digest(), 0);
                Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(md.digest(), Base64.DEFAULT)");
                trim = StringsKt__StringsKt.trim(encodeToString);
                return trim.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
