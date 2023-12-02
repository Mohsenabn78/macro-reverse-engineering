package com.google.api;

import com.google.protobuf.Internal;

/* loaded from: classes5.dex */
public enum LaunchStage implements Internal.EnumLite {
    LAUNCH_STAGE_UNSPECIFIED(0),
    EARLY_ACCESS(1),
    ALPHA(2),
    BETA(3),
    GA(4),
    DEPRECATED(5),
    UNRECOGNIZED(-1);
    
    public static final int ALPHA_VALUE = 2;
    public static final int BETA_VALUE = 3;
    public static final int DEPRECATED_VALUE = 5;
    public static final int EARLY_ACCESS_VALUE = 1;
    public static final int GA_VALUE = 4;
    public static final int LAUNCH_STAGE_UNSPECIFIED_VALUE = 0;

    /* renamed from: a  reason: collision with root package name */
    private static final Internal.EnumLiteMap<LaunchStage> f25420a = new Internal.EnumLiteMap<LaunchStage>() { // from class: com.google.api.LaunchStage.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a */
        public LaunchStage findValueByNumber(int i4) {
            return LaunchStage.forNumber(i4);
        }
    };
    private final int value;

    /* loaded from: classes5.dex */
    private static final class LaunchStageVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        static final Internal.EnumVerifier f25422a = new LaunchStageVerifier();

        private LaunchStageVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i4) {
            if (LaunchStage.forNumber(i4) != null) {
                return true;
            }
            return false;
        }
    }

    LaunchStage(int i4) {
        this.value = i4;
    }

    public static LaunchStage forNumber(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                return null;
                            }
                            return DEPRECATED;
                        }
                        return GA;
                    }
                    return BETA;
                }
                return ALPHA;
            }
            return EARLY_ACCESS;
        }
        return LAUNCH_STAGE_UNSPECIFIED;
    }

    public static Internal.EnumLiteMap<LaunchStage> internalGetValueMap() {
        return f25420a;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return LaunchStageVerifier.f25422a;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static LaunchStage valueOf(int i4) {
        return forNumber(i4);
    }
}
