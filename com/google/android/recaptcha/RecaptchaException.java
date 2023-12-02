package com.google.android.recaptcha;

import androidx.annotation.NonNull;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/google/android/recaptcha/RecaptchaException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "Lcom/google/android/recaptcha/RecaptchaErrorCode;", "errorMessage", "", "(Lcom/google/android/recaptcha/RecaptchaErrorCode;Ljava/lang/String;)V", "getErrorCode", "()Lcom/google/android/recaptcha/RecaptchaErrorCode;", "getErrorMessage", "()Ljava/lang/String;", "java.com.google.android.libraries.abuse.recaptcha.enterprise.public_public"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecaptchaException extends Exception {
    @NotNull
    private final RecaptchaErrorCode errorCode;
    @NotNull
    private final String errorMessage;

    public RecaptchaException(@NonNull RecaptchaErrorCode recaptchaErrorCode, @NonNull String str) {
        super(str);
        this.errorCode = recaptchaErrorCode;
        this.errorMessage = str;
    }

    @NotNull
    public final RecaptchaErrorCode getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public /* synthetic */ RecaptchaException(@NonNull RecaptchaErrorCode recaptchaErrorCode, @NonNull String str, int i4, @NonNull DefaultConstructorMarker defaultConstructorMarker) {
        this(recaptchaErrorCode, (i4 & 2) != 0 ? recaptchaErrorCode.getErrorMessage() : str);
    }
}
