package com.google.firebase.storage;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public class StorageException extends FirebaseException {
    public static final int ERROR_BUCKET_NOT_FOUND = -13011;
    public static final int ERROR_CANCELED = -13040;
    public static final int ERROR_INVALID_CHECKSUM = -13031;
    public static final int ERROR_NOT_AUTHENTICATED = -13020;
    public static final int ERROR_NOT_AUTHORIZED = -13021;
    public static final int ERROR_OBJECT_NOT_FOUND = -13010;
    public static final int ERROR_PROJECT_NOT_FOUND = -13012;
    public static final int ERROR_QUOTA_EXCEEDED = -13013;
    public static final int ERROR_RETRY_LIMIT_EXCEEDED = -13030;
    public static final int ERROR_UNKNOWN = -13000;
    private Throwable cause;
    private final int errorCode;
    private final int httpResultCode;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface ErrorCode {
    }

    StorageException(int i4, Throwable th, int i5) {
        super(c(i4));
        this.cause = th;
        this.errorCode = i4;
        this.httpResultCode = i5;
        Log.e("StorageException", "StorageException has occurred.\n" + c(i4) + "\n Code: " + i4 + " HttpResult: " + i5);
        Throwable th2 = this.cause;
        if (th2 != null) {
            Log.e("StorageException", th2.getMessage(), this.cause);
        }
    }

    private static int a(Status status) {
        if (status.isCanceled()) {
            return ERROR_CANCELED;
        }
        if (status.equals(Status.RESULT_TIMEOUT)) {
            return ERROR_RETRY_LIMIT_EXCEEDED;
        }
        return ERROR_UNKNOWN;
    }

    private static int b(@Nullable Throwable th, int i4) {
        if (th instanceof CancelException) {
            return ERROR_CANCELED;
        }
        if (i4 != -2) {
            if (i4 != 401) {
                if (i4 != 409) {
                    if (i4 != 403) {
                        if (i4 != 404) {
                            return ERROR_UNKNOWN;
                        }
                        return ERROR_OBJECT_NOT_FOUND;
                    }
                    return ERROR_NOT_AUTHORIZED;
                }
                return ERROR_INVALID_CHECKSUM;
            }
            return ERROR_NOT_AUTHENTICATED;
        }
        return ERROR_RETRY_LIMIT_EXCEEDED;
    }

    static String c(int i4) {
        if (i4 != -13040) {
            if (i4 != -13031) {
                if (i4 != -13030) {
                    if (i4 != -13021) {
                        if (i4 != -13020) {
                            switch (i4) {
                                case ERROR_QUOTA_EXCEEDED /* -13013 */:
                                    return "Quota for bucket exceeded, please view quota on www.firebase.google.com/storage.";
                                case ERROR_PROJECT_NOT_FOUND /* -13012 */:
                                    return "Project does not exist.";
                                case ERROR_BUCKET_NOT_FOUND /* -13011 */:
                                    return "Bucket does not exist.";
                                case ERROR_OBJECT_NOT_FOUND /* -13010 */:
                                    return "Object does not exist at location.";
                                default:
                                    return "An unknown error occurred, please check the HTTP result code and inner exception for server response.";
                            }
                        }
                        return "User is not authenticated, please authenticate using Firebase Authentication and try again.";
                    }
                    return "User does not have permission to access this object.";
                }
                return "The operation retry limit has been exceeded.";
            }
            return "Object has a checksum which does not match. Please retry the operation.";
        }
        return "The operation was cancelled.";
    }

    private static boolean e(int i4) {
        if (i4 != 0 && (i4 < 200 || i4 >= 300)) {
            return false;
        }
        return true;
    }

    @NonNull
    public static StorageException fromErrorStatus(@NonNull Status status) {
        Preconditions.checkNotNull(status);
        Preconditions.checkArgument(!status.isSuccess());
        return new StorageException(a(status), null, 0);
    }

    @NonNull
    public static StorageException fromException(@NonNull Throwable th) {
        return fromExceptionAndHttpCode(th, 0);
    }

    @Nullable
    public static StorageException fromExceptionAndHttpCode(@Nullable Throwable th, int i4) {
        if (th instanceof StorageException) {
            return (StorageException) th;
        }
        if (e(i4) && th == null) {
            return null;
        }
        return new StorageException(b(th, i4), th, i4);
    }

    @Override // java.lang.Throwable
    @Nullable
    public synchronized Throwable getCause() {
        Throwable th = this.cause;
        if (th == this) {
            return null;
        }
        return th;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getHttpResultCode() {
        return this.httpResultCode;
    }

    public boolean getIsRecoverableException() {
        if (getErrorCode() == -13030) {
            return true;
        }
        return false;
    }
}
