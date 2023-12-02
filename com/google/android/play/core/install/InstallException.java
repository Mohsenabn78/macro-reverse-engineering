package com.google.android.play.core.install;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.play.core.install.model.InstallErrorCode;
import java.util.Locale;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public class InstallException extends ApiException {
    public InstallException(@InstallErrorCode int i4) {
        super(new Status(i4, String.format(Locale.getDefault(), "Install Error(%d): %s", Integer.valueOf(i4), com.google.android.play.core.install.model.zza.zza(i4))));
        if (i4 != 0) {
            return;
        }
        throw new IllegalArgumentException("errorCode should not be 0.");
    }

    @InstallErrorCode
    public int getErrorCode() {
        return super.getStatusCode();
    }
}
