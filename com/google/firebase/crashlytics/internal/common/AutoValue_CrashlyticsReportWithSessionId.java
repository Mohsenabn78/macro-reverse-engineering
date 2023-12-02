package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

/* loaded from: classes5.dex */
final class AutoValue_CrashlyticsReportWithSessionId extends CrashlyticsReportWithSessionId {

    /* renamed from: a  reason: collision with root package name */
    private final CrashlyticsReport f29383a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29384b;

    /* renamed from: c  reason: collision with root package name */
    private final File f29385c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReport crashlyticsReport, String str, File file) {
        if (crashlyticsReport != null) {
            this.f29383a = crashlyticsReport;
            if (str != null) {
                this.f29384b = str;
                if (file != null) {
                    this.f29385c = file;
                    return;
                }
                throw new NullPointerException("Null reportFile");
            }
            throw new NullPointerException("Null sessionId");
        }
        throw new NullPointerException("Null report");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReportWithSessionId)) {
            return false;
        }
        CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) obj;
        if (this.f29383a.equals(crashlyticsReportWithSessionId.getReport()) && this.f29384b.equals(crashlyticsReportWithSessionId.getSessionId()) && this.f29385c.equals(crashlyticsReportWithSessionId.getReportFile())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public CrashlyticsReport getReport() {
        return this.f29383a;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public File getReportFile() {
        return this.f29385c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public String getSessionId() {
        return this.f29384b;
    }

    public int hashCode() {
        return ((((this.f29383a.hashCode() ^ 1000003) * 1000003) ^ this.f29384b.hashCode()) * 1000003) ^ this.f29385c.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f29383a + ", sessionId=" + this.f29384b + ", reportFile=" + this.f29385c + "}";
    }
}
