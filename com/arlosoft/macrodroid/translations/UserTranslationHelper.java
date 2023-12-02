package com.arlosoft.macrodroid.translations;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.net.MailTo;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

/* compiled from: UserTranslationHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UserTranslationHelper {
    public static final int $stable = 0;
    @NotNull
    public static final UserTranslationHelper INSTANCE = new UserTranslationHelper();

    private UserTranslationHelper() {
    }

    public final void createTranslationOfferEmail(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Locale forLanguageTag = Locale.forLanguageTag("en");
        Intrinsics.checkNotNullExpressionValue(forLanguageTag, "forLanguageTag(\"en\")");
        String str = "I would like to help translate MacroDroid. Please grant me access to localize for the " + Locale.getDefault().getDisplayLanguage(forLanguageTag) + " language.";
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(MailTo.MAILTO_SCHEME));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"support@macrodroid.com"});
        intent.putExtra("android.intent.extra.SUBJECT", "MacroDroid Translation");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (Exception unused) {
            Timber.e("No application available to handle ACTION_SENDTO intent", new Object[0]);
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.setType("message/rfc822");
            intent2.putExtra("android.intent.extra.EMAIL", new String[]{"support@macrodroid.com"});
            intent2.putExtra("android.intent.extra.SUBJECT", "MacroDroid Translation");
            intent2.putExtra("android.intent.extra.TEXT", str);
            intent2.addFlags(268435456);
            try {
                context.startActivity(Intent.createChooser(intent2, "MacroDroid Translation"));
            } catch (Exception unused2) {
                Timber.e("No application available to handle ACTION_SEND intent", new Object[0]);
            }
        }
    }
}
