package com.arlosoft.macrodroid.rest;

import androidx.compose.runtime.internal.StabilityInferred;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: BaseError.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class BaseError extends Exception {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final Type f13287a = Type.CLIENT;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy<Gson> f13288b;
    @Nullable
    private final Error error;
    @Nullable
    private final String errorBody;
    @Nullable
    private final Integer httpErrorCode;
    @NotNull
    private final Type type;

    /* compiled from: BaseError.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Type getDEFAULT() {
            return BaseError.f13287a;
        }

        @NotNull
        public final Gson getGson() {
            return (Gson) BaseError.f13288b.getValue();
        }
    }

    /* compiled from: BaseError.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Error {
        public static final int $stable = 0;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final String f13289a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final String f13290b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final String f13291c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final String f13292d;

        public Error(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.f13289a = str;
            this.f13290b = str2;
            this.f13291c = str3;
            this.f13292d = str4;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, String str2, String str3, String str4, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = error.f13289a;
            }
            if ((i4 & 2) != 0) {
                str2 = error.f13290b;
            }
            if ((i4 & 4) != 0) {
                str3 = error.f13291c;
            }
            if ((i4 & 8) != 0) {
                str4 = error.f13292d;
            }
            return error.copy(str, str2, str3, str4);
        }

        @Nullable
        public final String component1() {
            return this.f13289a;
        }

        @Nullable
        public final String component2() {
            return this.f13290b;
        }

        @Nullable
        public final String component3() {
            return this.f13291c;
        }

        @Nullable
        public final String component4() {
            return this.f13292d;
        }

        @NotNull
        public final Error copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            return new Error(str, str2, str3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            if (Intrinsics.areEqual(this.f13289a, error.f13289a) && Intrinsics.areEqual(this.f13290b, error.f13290b) && Intrinsics.areEqual(this.f13291c, error.f13291c) && Intrinsics.areEqual(this.f13292d, error.f13292d)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getError() {
            return this.f13289a;
        }

        @Nullable
        public final String getErrorCode() {
            return this.f13290b;
        }

        @Nullable
        public final String getErrorMessage() {
            return this.f13291c;
        }

        @Nullable
        public final String getErrorType() {
            return this.f13292d;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            String str = this.f13289a;
            int i4 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i5 = hashCode * 31;
            String str2 = this.f13290b;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i6 = (i5 + hashCode2) * 31;
            String str3 = this.f13291c;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i7 = (i6 + hashCode3) * 31;
            String str4 = this.f13292d;
            if (str4 != null) {
                i4 = str4.hashCode();
            }
            return i7 + i4;
        }

        @NotNull
        public String toString() {
            String str = this.f13289a;
            String str2 = this.f13290b;
            String str3 = this.f13291c;
            String str4 = this.f13292d;
            return "Error(error=" + str + ", errorCode=" + str2 + ", errorMessage=" + str3 + ", errorType=" + str4 + ")";
        }
    }

    /* compiled from: BaseError.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        CLIENT,
        SERVER,
        UNAUTHORISED,
        NETWORK_UNAVAILABLE,
        TIMEOUT,
        UNSUPPORTED_APP_VERSION,
        TERMS_AND_CONDITIONS_OUT_OF_DATE,
        WALLET_LOCKED,
        WALLET_SUPER_LOCKED,
        STEP_UP_REQUIRED,
        FRAUD_LOCKED,
        NOT_IMPLEMENTED
    }

    /* compiled from: BaseError.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function0<Gson> {

        /* renamed from: d  reason: collision with root package name */
        public static final a f13294d = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a */
        public final Gson invoke() {
            return new Gson();
        }
    }

    static {
        Lazy<Gson> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f13294d);
        f13288b = lazy;
    }

    @JvmOverloads
    public BaseError() {
        this(null, null, 3, null);
    }

    private final Error a(String str) {
        try {
            return (Error) Companion.getGson().fromJson(str, (Class<Object>) Error.class);
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }

    @Nullable
    public final Error getError() {
        return this.error;
    }

    @Nullable
    public final String getErrorBody() {
        return this.errorBody;
    }

    @Nullable
    public final Integer getHttpErrorCode() {
        return this.httpErrorCode;
    }

    @NotNull
    public final Type getType() {
        return this.type;
    }

    public final boolean isNetworkOrTimeoutError() {
        Type type = this.type;
        if (type != Type.NETWORK_UNAVAILABLE && type != Type.TIMEOUT) {
            return false;
        }
        return true;
    }

    @JvmOverloads
    public BaseError(@Nullable Throwable th) {
        this(th, null, 2, null);
    }

    public /* synthetic */ BaseError(Throwable th, Type type, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : th, (i4 & 2) != 0 ? null : type);
    }

    @JvmOverloads
    public BaseError(@Nullable Throwable th, @Nullable Type type) {
        super(th);
        String str;
        Integer num;
        Type type2;
        Error error = null;
        if (type == null) {
            boolean z3 = false;
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                Response<?> response = httpException.response();
                Intrinsics.checkNotNull(response);
                ResponseBody errorBody = response.errorBody();
                String string = errorBody != null ? errorBody.string() : null;
                Integer valueOf = Integer.valueOf(httpException.code());
                int intValue = valueOf.intValue();
                if (intValue == 400) {
                    error = a(string);
                    type2 = Type.CLIENT;
                } else if (intValue == 401) {
                    type2 = Type.UNAUTHORISED;
                } else if (intValue == 403) {
                    error = a(string);
                    type2 = f13287a;
                } else if (intValue == 404) {
                    type2 = Type.CLIENT;
                } else {
                    if (404 <= intValue && intValue < 500) {
                        type2 = Type.CLIENT;
                    } else {
                        if (500 <= intValue && intValue < 600) {
                            z3 = true;
                        }
                        if (z3) {
                            type2 = Type.SERVER;
                        } else {
                            type2 = f13287a;
                        }
                    }
                }
                Type type3 = type2;
                num = valueOf;
                str = string;
                type = type3;
                this.type = type;
                this.error = error;
                this.errorBody = str;
                this.httpErrorCode = num;
            } else if (th instanceof SocketTimeoutException) {
                type = Type.TIMEOUT;
            } else if (th instanceof SSLHandshakeException) {
                type = Type.TIMEOUT;
            } else if (th instanceof UnknownHostException) {
                Timber.i("UnknownHostException mapping to Type.TIMEOUT", new Object[0]);
                type = Type.TIMEOUT;
            } else {
                type = f13287a;
            }
        }
        str = null;
        num = null;
        this.type = type;
        this.error = error;
        this.errorBody = str;
        this.httpErrorCode = num;
    }
}
