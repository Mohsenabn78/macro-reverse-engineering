package com.google.api.client.googleapis.media;

import com.google.api.client.http.HttpIOExceptionHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
/* loaded from: classes5.dex */
class MediaUploadErrorHandler implements HttpUnsuccessfulResponseHandler, HttpIOExceptionHandler {

    /* renamed from: d  reason: collision with root package name */
    static final Logger f25679d = Logger.getLogger(MediaUploadErrorHandler.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final MediaHttpUploader f25680a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpIOExceptionHandler f25681b;

    /* renamed from: c  reason: collision with root package name */
    private final HttpUnsuccessfulResponseHandler f25682c;

    public MediaUploadErrorHandler(MediaHttpUploader mediaHttpUploader, HttpRequest httpRequest) {
        this.f25680a = (MediaHttpUploader) Preconditions.checkNotNull(mediaHttpUploader);
        this.f25681b = httpRequest.getIOExceptionHandler();
        this.f25682c = httpRequest.getUnsuccessfulResponseHandler();
        httpRequest.setIOExceptionHandler(this);
        httpRequest.setUnsuccessfulResponseHandler(this);
    }

    @Override // com.google.api.client.http.HttpIOExceptionHandler
    public boolean handleIOException(HttpRequest httpRequest, boolean z3) throws IOException {
        boolean z4;
        HttpIOExceptionHandler httpIOExceptionHandler = this.f25681b;
        if (httpIOExceptionHandler != null && httpIOExceptionHandler.handleIOException(httpRequest, z3)) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            try {
                this.f25680a.i();
            } catch (IOException e4) {
                f25679d.log(Level.WARNING, "exception thrown while calling server callback", (Throwable) e4);
            }
        }
        return z4;
    }

    @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
    public boolean handleResponse(HttpRequest httpRequest, HttpResponse httpResponse, boolean z3) throws IOException {
        boolean z4;
        HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler = this.f25682c;
        if (httpUnsuccessfulResponseHandler != null && httpUnsuccessfulResponseHandler.handleResponse(httpRequest, httpResponse, z3)) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4 && z3 && httpResponse.getStatusCode() / 100 == 5) {
            try {
                this.f25680a.i();
            } catch (IOException e4) {
                f25679d.log(Level.WARNING, "exception thrown while calling server callback", (Throwable) e4);
            }
        }
        return z4;
    }
}
