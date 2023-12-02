package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.model.RemoteModel;
import java.io.File;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public interface ModelValidator {

    /* compiled from: com.google.mlkit:common@@18.5.0 */
    @KeepForSdk
    /* loaded from: classes5.dex */
    public static class ValidationResult {
        @NonNull
        @KeepForSdk
        public static final ValidationResult VALID = new ValidationResult(ErrorCode.OK, null);

        /* renamed from: a  reason: collision with root package name */
        private final ErrorCode f33007a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final String f33008b;

        /* compiled from: com.google.mlkit:common@@18.5.0 */
        @KeepForSdk
        /* loaded from: classes5.dex */
        public enum ErrorCode {
            OK,
            TFLITE_VERSION_INCOMPATIBLE,
            MODEL_FORMAT_INVALID
        }

        @KeepForSdk
        public ValidationResult(@NonNull ErrorCode errorCode, @Nullable String str) {
            this.f33007a = errorCode;
            this.f33008b = str;
        }

        @NonNull
        @KeepForSdk
        public ErrorCode getErrorCode() {
            return this.f33007a;
        }

        @Nullable
        @KeepForSdk
        public String getErrorMessage() {
            return this.f33008b;
        }

        @KeepForSdk
        public boolean isValid() {
            if (this.f33007a == ErrorCode.OK) {
                return true;
            }
            return false;
        }
    }

    @NonNull
    @KeepForSdk
    ValidationResult validateModel(@NonNull File file, @NonNull RemoteModel remoteModel);
}
