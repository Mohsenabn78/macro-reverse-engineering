package com.google.android.play.core.integrity;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.Locale;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
public class IntegrityServiceException extends ApiException {

    /* renamed from: a  reason: collision with root package name */
    private final Throwable f25281a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntegrityServiceException(int i4, Throwable th) {
        super(new Status(i4, String.format(Locale.ROOT, "Integrity API error (%d): %s.", Integer.valueOf(i4), com.google.android.play.core.integrity.model.a.a(i4))));
        if (i4 != 0) {
            this.f25281a = th;
            return;
        }
        throw new IllegalArgumentException("ErrorCode should not be 0.");
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable getCause() {
        return this.f25281a;
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}
