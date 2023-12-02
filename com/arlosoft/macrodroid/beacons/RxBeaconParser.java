package com.arlosoft.macrodroid.beacons;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* compiled from: RxBeaconParser.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class RxBeaconParser {
    public static final int $stable = 0;
    @NotNull
    public static final String ALTBEACON = "m:2-3=beac,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25";
    @NotNull
    public static final String EDDYSTONE_TLM = "x,s:0-1=feaa,m:2-2=20,d:3-3,d:4-5,d:6-7,d:8-11,d:12-15";
    @NotNull
    public static final String EDDYSTONE_UID = "s:0-1=feaa,m:2-2=00,p:3-3:-41,i:4-13,i:14-19";
    @NotNull
    public static final String EDDYSTONE_URL = "s:0-1=feaa,m:2-2=10,p:3-3:-41,i:4-20v";
    @NotNull
    public static final String IBEACON = "m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24";
    @NotNull
    public static final RxBeaconParser INSTANCE = new RxBeaconParser();

    private RxBeaconParser() {
    }
}
