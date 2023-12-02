package com.google.firebase.crashlytics.internal.settings;

/* loaded from: classes5.dex */
public class Settings {
    public final int cacheDuration;
    public final long expiresAtMillis;
    public final FeatureFlagData featureFlagData;
    public final double onDemandBackoffBase;
    public final int onDemandBackoffStepDurationSeconds;
    public final double onDemandUploadRatePerMinute;
    public final SessionData sessionData;
    public final int settingsVersion;

    /* loaded from: classes5.dex */
    public static class FeatureFlagData {
        public final boolean collectAnrs;
        public final boolean collectBuildIds;
        public final boolean collectReports;

        public FeatureFlagData(boolean z3, boolean z4, boolean z5) {
            this.collectReports = z3;
            this.collectAnrs = z4;
            this.collectBuildIds = z5;
        }
    }

    /* loaded from: classes5.dex */
    public static class SessionData {
        public final int maxCompleteSessionsCount;
        public final int maxCustomExceptionEvents;

        public SessionData(int i4, int i5) {
            this.maxCustomExceptionEvents = i4;
            this.maxCompleteSessionsCount = i5;
        }
    }

    public Settings(long j4, SessionData sessionData, FeatureFlagData featureFlagData, int i4, int i5, double d4, double d5, int i6) {
        this.expiresAtMillis = j4;
        this.sessionData = sessionData;
        this.featureFlagData = featureFlagData;
        this.settingsVersion = i4;
        this.cacheDuration = i5;
        this.onDemandUploadRatePerMinute = d4;
        this.onDemandBackoffBase = d5;
        this.onDemandBackoffStepDurationSeconds = i6;
    }

    public boolean isExpired(long j4) {
        if (this.expiresAtMillis < j4) {
            return true;
        }
        return false;
    }
}
