package com.pollfish.builder;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/pollfish/builder/Platform;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "toString", "", "NATIVE", "FLUTTER", "CORDOVA", "UNITY", "ADMOB", "MOPUB", "REACT_NATIVE", "MAX", "IRON_SOURCE", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public enum Platform {
    NATIVE(0),
    FLUTTER(1),
    CORDOVA(2),
    UNITY(3),
    ADMOB(4),
    MOPUB(5),
    REACT_NATIVE(6),
    MAX(7),
    IRON_SOURCE(8);
    
    private final int value;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Platform.values().length];
            try {
                iArr[Platform.NATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Platform.FLUTTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Platform.CORDOVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Platform.UNITY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Platform.ADMOB.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Platform.MOPUB.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Platform.REACT_NATIVE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Platform.MAX.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Platform.IRON_SOURCE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    Platform(int i4) {
        this.value = i4;
    }

    public final int getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "native";
            case 2:
                return "flutter";
            case 3:
                return "cordova";
            case 4:
                return "unity";
            case 5:
                return "adMob";
            case 6:
                return "moPub";
            case 7:
                return "react";
            case 8:
                return "max";
            case 9:
                return "ironsource";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
