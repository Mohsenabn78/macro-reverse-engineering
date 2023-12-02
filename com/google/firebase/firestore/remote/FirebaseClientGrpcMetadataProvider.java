package com.google.firebase.firestore.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import io.grpc.Metadata;

/* loaded from: classes5.dex */
public class FirebaseClientGrpcMetadataProvider implements GrpcMetadataProvider {

    /* renamed from: d  reason: collision with root package name */
    private static final Metadata.Key<String> f31083d;

    /* renamed from: e  reason: collision with root package name */
    private static final Metadata.Key<String> f31084e;

    /* renamed from: f  reason: collision with root package name */
    private static final Metadata.Key<String> f31085f;

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HeartBeatInfo> f31086a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UserAgentPublisher> f31087b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseOptions f31088c;

    static {
        Metadata.AsciiMarshaller<String> asciiMarshaller = Metadata.ASCII_STRING_MARSHALLER;
        f31083d = Metadata.Key.of("x-firebase-client-log-type", asciiMarshaller);
        f31084e = Metadata.Key.of("x-firebase-client", asciiMarshaller);
        f31085f = Metadata.Key.of("x-firebase-gmpid", asciiMarshaller);
    }

    public FirebaseClientGrpcMetadataProvider(@NonNull Provider<UserAgentPublisher> provider, @NonNull Provider<HeartBeatInfo> provider2, @Nullable FirebaseOptions firebaseOptions) {
        this.f31087b = provider;
        this.f31086a = provider2;
        this.f31088c = firebaseOptions;
    }

    private void a(@NonNull Metadata metadata) {
        FirebaseOptions firebaseOptions = this.f31088c;
        if (firebaseOptions == null) {
            return;
        }
        String applicationId = firebaseOptions.getApplicationId();
        if (applicationId.length() != 0) {
            metadata.put(f31085f, applicationId);
        }
    }

    @Override // com.google.firebase.firestore.remote.GrpcMetadataProvider
    public void updateMetadata(@NonNull Metadata metadata) {
        if (this.f31086a.get() != null && this.f31087b.get() != null) {
            int code = this.f31086a.get().getHeartBeatCode("fire-fst").getCode();
            if (code != 0) {
                metadata.put(f31083d, Integer.toString(code));
            }
            metadata.put(f31084e, this.f31087b.get().getUserAgent());
            a(metadata);
        }
    }
}
