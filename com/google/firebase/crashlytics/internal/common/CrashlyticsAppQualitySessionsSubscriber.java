package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.sessions.api.SessionSubscriber;

/* loaded from: classes5.dex */
public class CrashlyticsAppQualitySessionsSubscriber implements SessionSubscriber {

    /* renamed from: a  reason: collision with root package name */
    private final DataCollectionArbiter f29412a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f29413b = null;

    public CrashlyticsAppQualitySessionsSubscriber(DataCollectionArbiter dataCollectionArbiter) {
        this.f29412a = dataCollectionArbiter;
    }

    @Nullable
    public String getAppQualitySessionId() {
        return this.f29413b;
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    @NonNull
    public SessionSubscriber.Name getSessionSubscriberName() {
        return SessionSubscriber.Name.CRASHLYTICS;
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    public boolean isDataCollectionEnabled() {
        return this.f29412a.isAutomaticDataCollectionEnabled();
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    public void onSessionChanged(@NonNull SessionSubscriber.SessionDetails sessionDetails) {
        Logger logger = Logger.getLogger();
        logger.d("App Quality Sessions session changed: " + sessionDetails);
        this.f29413b = sessionDetails.getSessionId();
    }
}
