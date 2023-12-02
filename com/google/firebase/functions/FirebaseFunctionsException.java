package com.google.firebase.functions;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.firebase.FirebaseException;
import com.google.firebase.messaging.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class FirebaseFunctionsException extends FirebaseException {
    @NonNull
    private final Code code;
    @Nullable
    private final Object details;

    /* loaded from: classes5.dex */
    public enum Code {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);
        

        /* renamed from: a  reason: collision with root package name */
        private static final SparseArray<Code> f31370a = a();
        private final int value;

        Code(int i4) {
            this.value = i4;
        }

        private static SparseArray<Code> a() {
            Code[] values;
            SparseArray<Code> sparseArray = new SparseArray<>();
            for (Code code : values()) {
                Code code2 = sparseArray.get(code.ordinal());
                if (code2 == null) {
                    sparseArray.put(code.ordinal(), code);
                } else {
                    throw new IllegalStateException("Code value duplication between " + code2 + "&" + code.name());
                }
            }
            return sparseArray;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Code b(int i4) {
            if (i4 != 200) {
                if (i4 != 409) {
                    if (i4 != 429) {
                        if (i4 != 400) {
                            if (i4 != 401) {
                                if (i4 != 403) {
                                    if (i4 != 404) {
                                        if (i4 != 503) {
                                            if (i4 != 504) {
                                                switch (i4) {
                                                    case 499:
                                                        return CANCELLED;
                                                    case 500:
                                                        return INTERNAL;
                                                    case 501:
                                                        return UNIMPLEMENTED;
                                                    default:
                                                        return UNKNOWN;
                                                }
                                            }
                                            return DEADLINE_EXCEEDED;
                                        }
                                        return UNAVAILABLE;
                                    }
                                    return NOT_FOUND;
                                }
                                return PERMISSION_DENIED;
                            }
                            return UNAUTHENTICATED;
                        }
                        return INVALID_ARGUMENT;
                    }
                    return RESOURCE_EXHAUSTED;
                }
                return ABORTED;
            }
            return OK;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseFunctionsException(@NonNull String str, @NonNull Code code, @Nullable Object obj) {
        super(str);
        this.code = code;
        this.details = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static FirebaseFunctionsException a(Code code, @Nullable String str, Serializer serializer) {
        Object obj;
        String name = code.name();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            if (jSONObject.opt(NotificationCompat.CATEGORY_STATUS) instanceof String) {
                code = Code.valueOf(jSONObject.getString(NotificationCompat.CATEGORY_STATUS));
                name = code.name();
            }
            if ((jSONObject.opt("message") instanceof String) && !jSONObject.getString("message").isEmpty()) {
                name = jSONObject.getString("message");
            }
            obj = jSONObject.opt("details");
            if (obj != null) {
                try {
                    obj = serializer.a(obj);
                } catch (IllegalArgumentException unused) {
                    code = Code.INTERNAL;
                    name = code.name();
                } catch (JSONException unused2) {
                }
            }
        } catch (IllegalArgumentException unused3) {
            obj = null;
        } catch (JSONException unused4) {
            obj = null;
        }
        if (code == Code.OK) {
            return null;
        }
        return new FirebaseFunctionsException(name, code, obj);
    }

    @NonNull
    public Code getCode() {
        return this.code;
    }

    @Nullable
    public Object getDetails() {
        return this.details;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseFunctionsException(@NonNull String str, @NonNull Code code, @Nullable Object obj, Throwable th) {
        super(str, th);
        this.code = code;
        this.details = obj;
    }
}
