package com.miguelbcr.ui.rx_paparazzo2.interactors;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.miguelbcr.ui.rx_paparazzo2.entities.Config;
import com.miguelbcr.ui.rx_paparazzo2.entities.FileData;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes6.dex */
public final class TakePhoto extends com.miguelbcr.ui.rx_paparazzo2.interactors.a<FileData> {

    /* renamed from: a  reason: collision with root package name */
    private final Config f36245a;

    /* renamed from: b  reason: collision with root package name */
    private final StartIntent f36246b;

    /* renamed from: c  reason: collision with root package name */
    private final TargetUi f36247c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageUtils f36248d;

    /* loaded from: classes6.dex */
    class a implements Function<Uri, FileData> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File f36249a;

        a(File file) {
            this.f36249a = file;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public FileData apply(Uri uri) throws Exception {
            if (this.f36249a.exists()) {
                File file = this.f36249a;
                return new FileData(file, true, file.getName(), ImageUtils.MIME_TYPE_JPEG);
            }
            throw new FileNotFoundException(String.format("Camera file not saved", this.f36249a.getAbsolutePath()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements Function<Intent, Uri> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TargetUi f36251a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Uri f36252b;

        b(TargetUi targetUi, Uri uri) {
            this.f36251a = targetUi;
            this.f36252b = uri;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public Uri apply(Intent intent) throws Exception {
            PermissionUtil.revokeFileReadWritePermissions(this.f36251a, this.f36252b);
            return this.f36252b;
        }
    }

    public TakePhoto(Config config, StartIntent startIntent, TargetUi targetUi, ImageUtils imageUtils) {
        this.f36245a = config;
        this.f36246b = startIntent;
        this.f36247c = targetUi;
        this.f36248d = imageUtils;
    }

    private Intent a(Uri uri) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", uri);
        return PermissionUtil.requestReadWritePermission(this.f36247c, intent, uri);
    }

    private File b() {
        String createTimestampedFilename = this.f36248d.createTimestampedFilename("PHOTO-", ImageUtils.JPG_FILE_EXTENSION);
        return this.f36248d.getPrivateFile(this.f36245a.getFileProviderDirectory(), createTimestampedFilename);
    }

    private Uri c(File file) {
        Context context = this.f36247c.getContext();
        return FileProvider.getUriForFile(context, this.f36245a.getFileProviderAuthority(context), file);
    }

    private Function<Intent, Uri> d(TargetUi targetUi, Uri uri) {
        return new b(targetUi, uri);
    }

    public Observable<FileData> react() {
        File b4 = b();
        Uri c4 = c(b4);
        return this.f36246b.c(a(c4)).react().map(d(this.f36247c, c4)).map(new a(b4));
    }
}
