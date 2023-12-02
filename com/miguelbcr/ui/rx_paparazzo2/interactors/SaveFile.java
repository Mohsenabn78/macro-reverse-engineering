package com.miguelbcr.ui.rx_paparazzo2.interactors;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.miguelbcr.ui.rx_paparazzo2.entities.Config;
import com.miguelbcr.ui.rx_paparazzo2.entities.FileData;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/* loaded from: classes6.dex */
public final class SaveFile extends com.miguelbcr.ui.rx_paparazzo2.interactors.a<FileData> {

    /* renamed from: f  reason: collision with root package name */
    private static final String f36230f = "SaveFile";

    /* renamed from: a  reason: collision with root package name */
    private final TargetUi f36231a;

    /* renamed from: b  reason: collision with root package name */
    private final Config f36232b;

    /* renamed from: c  reason: collision with root package name */
    private final ScaledImageDimensions f36233c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageUtils f36234d;

    /* renamed from: e  reason: collision with root package name */
    private FileData f36235e;

    /* loaded from: classes6.dex */
    class a implements Function<Dimensions, ObservableSource<FileData>> {
        a() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<FileData> apply(Dimensions dimensions) throws Exception {
            return SaveFile.this.e(dimensions);
        }
    }

    public SaveFile(TargetUi targetUi, Config config, ScaledImageDimensions scaledImageDimensions, ImageUtils imageUtils) {
        this.f36231a = targetUi;
        this.f36232b = config;
        this.f36233c = scaledImageDimensions;
        this.f36234d = imageUtils;
    }

    private File b() {
        return this.f36234d.getOutputFile("SAVED-", this.f36234d.getFileExtension(this.f36235e.getFilename()));
    }

    private boolean c(File file) {
        if (file.exists() && file.length() > this.f36232b.getMaximumFileSize()) {
            return true;
        }
        return false;
    }

    private FileData d(Dimensions dimensions) throws Exception {
        Dimensions imageDimensions = ImageUtils.getImageDimensions(this.f36235e.getFile());
        if (imageDimensions.hasSize()) {
            return f(new FileData(this.f36235e, imageDimensions), dimensions);
        }
        return g(this.f36235e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObservableSource<FileData> e(Dimensions dimensions) throws Exception {
        FileData d4 = d(dimensions);
        if (this.f36232b.isSendToMediaScanner()) {
            if (this.f36232b.isUseInternalStorage()) {
                Log.w(f36230f, String.format("Media scanner will not be able to access internal storage '%s'", this.f36235e.getFile().getAbsolutePath()));
            }
            if (d4.getFile() != null && d4.getFile().exists()) {
                h(d4);
            }
        }
        return Observable.just(d4);
    }

    private FileData f(FileData fileData, Dimensions dimensions) {
        FileData o4 = this.f36234d.o(fileData, b(), dimensions);
        if (c(o4.getFile())) {
            FileData.deleteSourceFile(fileData);
            FileData.deleteSourceFile(o4);
            return FileData.exceededMaximumFileSize(fileData);
        }
        FileData.deleteSourceFile(fileData);
        return o4;
    }

    private FileData g(FileData fileData) throws Exception {
        File file = fileData.getFile();
        if (c(file)) {
            FileData.deleteSourceFile(fileData);
            return FileData.exceededMaximumFileSize(fileData);
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        File b4 = b();
        this.f36234d.copy(bufferedInputStream, b4);
        return FileData.toFileDataDeleteSourceFileIfTransient(fileData, b4, true, fileData.getMimeType());
    }

    private void h(FileData fileData) {
        File file = fileData.getFile();
        if (file.exists()) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            Context context = this.f36231a.getContext();
            intent.setData(Uri.fromFile(file));
            context.sendBroadcast(intent);
        }
    }

    public Observable<FileData> react() {
        return this.f36233c.with(this.f36235e).react().flatMap(new a());
    }

    public SaveFile with(FileData fileData) {
        this.f36235e = fileData;
        return this;
    }
}
