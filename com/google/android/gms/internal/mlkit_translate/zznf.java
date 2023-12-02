package com.google.android.gms.internal.mlkit_translate;

import androidx.core.app.FrameMetricsAggregator;
import twitter4j.HttpResponseCode;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public enum zznf implements zzbe {
    NO_ERROR(0),
    METADATA_FILE_UNAVAILABLE(1),
    METADATA_ENTRY_NOT_FOUND(2),
    METADATA_JSON_INVALID(3),
    METADATA_HASH_NOT_FOUND(4),
    DOWNLOAD_MANAGER_SERVICE_MISSING(5),
    DOWNLOAD_MANAGER_HTTP_UNKNOWN_STATUS(6),
    DOWNLOAD_MANAGER_HTTP_BAD_REQUEST(400),
    DOWNLOAD_MANAGER_HTTP_UNAUTHORIZED(401),
    DOWNLOAD_MANAGER_HTTP_FORBIDDEN(403),
    DOWNLOAD_MANAGER_HTTP_NOT_FOUND(404),
    DOWNLOAD_MANAGER_HTTP_REQUEST_TIMEOUT(408),
    DOWNLOAD_MANAGER_HTTP_ABORTED(409),
    DOWNLOAD_MANAGER_HTTP_TOO_MANY_REQUESTS(HttpResponseCode.TOO_MANY_REQUESTS),
    DOWNLOAD_MANAGER_HTTP_CANCELLED(499),
    DOWNLOAD_MANAGER_HTTP_UNIMPLEMENTED(501),
    DOWNLOAD_MANAGER_HTTP_INTERNAL_SERVICE_ERROR(500),
    DOWNLOAD_MANAGER_HTTP_SERVICE_UNAVAILABLE(503),
    DOWNLOAD_MANAGER_HTTP_DEADLINE_EXCEEDED(504),
    DOWNLOAD_MANAGER_HTTP_NETWORK_AUTHENTICATION_REQUIRED(FrameMetricsAggregator.EVERY_DURATION),
    DOWNLOAD_MANAGER_FILE_ERROR(7),
    DOWNLOAD_MANAGER_UNHANDLED_HTTP_CODE(8),
    DOWNLOAD_MANAGER_HTTP_DATA_ERROR(9),
    DOWNLOAD_MANAGER_TOO_MANY_REDIRECTS(10),
    DOWNLOAD_MANAGER_INSUFFICIENT_SPACE(11),
    DOWNLOAD_MANAGER_DEVICE_NOT_FOUND(12),
    DOWNLOAD_MANAGER_CANNOT_RESUME(13),
    DOWNLOAD_MANAGER_FILE_ALREADY_EXISTS(14),
    DOWNLOAD_MANAGER_UNKNOWN_ERROR(15),
    POST_DOWNLOAD_FILE_NOT_FOUND(16),
    POST_DOWNLOAD_MOVE_FILE_FAILED(17),
    POST_DOWNLOAD_UNZIP_FAILED(18),
    RAPID_RESPONSE_COULD_NOT_BE_WRITTEN(19),
    DRIVER_OBJECT_DEALLOCATED(20);
    
    private final int zzJ;

    zznf(int i4) {
        this.zzJ = i4;
    }

    public static zznf zzb(int i4) {
        zznf[] values;
        for (zznf zznfVar : values()) {
            if (zznfVar.zzJ == i4) {
                return zznfVar;
            }
        }
        return NO_ERROR;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzbe
    public final int zza() {
        return this.zzJ;
    }
}
