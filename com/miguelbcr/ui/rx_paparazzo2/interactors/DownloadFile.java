package com.miguelbcr.ui.rx_paparazzo2.interactors;

import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.miguelbcr.ui.rx_paparazzo2.entities.Config;
import com.miguelbcr.ui.rx_paparazzo2.entities.FileData;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

/* loaded from: classes6.dex */
public final class DownloadFile extends com.miguelbcr.ui.rx_paparazzo2.interactors.a<FileData> {

    /* renamed from: a  reason: collision with root package name */
    private final TargetUi f36200a;

    /* renamed from: b  reason: collision with root package name */
    private final Config f36201b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageUtils f36202c;

    /* renamed from: d  reason: collision with root package name */
    private Uri f36203d;

    /* renamed from: e  reason: collision with root package name */
    private FileData f36204e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements ObservableOnSubscribe<FileData> {
        a() {
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<FileData> observableEmitter) throws Exception {
            if (!observableEmitter.isDisposed()) {
                try {
                    if (FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(DownloadFile.this.f36203d.getScheme())) {
                        observableEmitter.onNext(DownloadFile.this.g());
                    } else {
                        observableEmitter.onNext(DownloadFile.this.d());
                    }
                    observableEmitter.onComplete();
                } catch (FileNotFoundException e4) {
                    observableEmitter.onError(e4);
                }
            }
        }
    }

    public DownloadFile(TargetUi targetUi, Config config, ImageUtils imageUtils) {
        this.f36200a = targetUi;
        this.f36201b = config;
        this.f36202c = imageUtils;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FileData d() throws Exception {
        String mimeType = ImageUtils.getMimeType(this.f36200a.getContext(), this.f36203d);
        String e4 = e(this.f36203d);
        File outputFile = this.f36202c.getOutputFile("DOWNLOAD-", this.f36202c.j(this.f36203d));
        URL url = new URL(this.f36203d.toString());
        url.openConnection().connect();
        this.f36202c.copy(new BufferedInputStream(url.openStream()), outputFile);
        return h(mimeType, e4, outputFile);
    }

    private String e(Uri uri) {
        String name;
        DocumentFile fromSingleUri = DocumentFile.fromSingleUri(this.f36200a.getContext(), uri);
        if (fromSingleUri != null && (name = fromSingleUri.getName()) != null) {
            return ImageUtils.stripPathFromFilename(name);
        }
        String replaceAll = uri.getLastPathSegment().replaceAll("[^A-Za-z0-9 ]", "");
        return replaceAll + "." + this.f36202c.j(uri);
    }

    private Observable<FileData> f() {
        return Observable.create(new a()).subscribeOn(Schedulers.io());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FileData g() throws FileNotFoundException {
        String mimeType = ImageUtils.getMimeType(this.f36200a.getContext(), this.f36203d);
        String e4 = e(this.f36203d);
        File outputFile = this.f36202c.getOutputFile("DOWNLOAD-", this.f36202c.j(this.f36203d));
        this.f36202c.copy(this.f36200a.getContext().getContentResolver().openInputStream(this.f36203d), outputFile);
        return h(mimeType, e4, outputFile);
    }

    private FileData h(String str, String str2, File file) {
        FileData fileData = this.f36204e;
        if (fileData != null && fileData.getFilename() != null) {
            String mimeType = this.f36204e.getMimeType();
            if (mimeType != null) {
                str = mimeType;
            }
            return FileData.toFileDataDeleteSourceFileIfTransient(this.f36204e, file, true, str);
        }
        return new FileData(file, true, str2, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Observable<FileData> react() {
        return f();
    }

    public DownloadFile with(Uri uri, FileData fileData) {
        this.f36203d = uri;
        this.f36204e = fileData;
        return this;
    }
}
