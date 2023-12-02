package com.miguelbcr.ui.rx_paparazzo2.interactors;

import android.content.Intent;
import android.net.Uri;
import com.miguelbcr.ui.rx_paparazzo2.entities.Config;
import com.miguelbcr.ui.rx_paparazzo2.entities.FileData;
import com.miguelbcr.ui.rx_paparazzo2.entities.Options;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;
import com.yalantis.ucrop.UCrop;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes6.dex */
public final class CropImage extends com.miguelbcr.ui.rx_paparazzo2.interactors.a<FileData> {

    /* renamed from: a  reason: collision with root package name */
    private final Config f36191a;

    /* renamed from: b  reason: collision with root package name */
    private final StartIntent f36192b;

    /* renamed from: c  reason: collision with root package name */
    private final TargetUi f36193c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageUtils f36194d;

    /* renamed from: e  reason: collision with root package name */
    private FileData f36195e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Function<Intent, ObservableSource<FileData>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File f36196a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.miguelbcr.ui.rx_paparazzo2.interactors.CropImage$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0206a implements Function<Uri, ObservableSource<FileData>> {
            C0206a() {
            }

            @Override // io.reactivex.functions.Function
            /* renamed from: a */
            public ObservableSource<FileData> apply(Uri uri) throws Exception {
                if (a.this.f36196a.exists()) {
                    return Observable.just(FileData.toFileDataDeleteSourceFileIfTransient(CropImage.this.f36195e, a.this.f36196a, true, ImageUtils.MIME_TYPE_JPEG));
                }
                throw new FileNotFoundException(String.format("Cropped file not saved", a.this.f36196a.getAbsolutePath()));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public class b implements Function<Intent, Uri> {
            b() {
            }

            @Override // io.reactivex.functions.Function
            /* renamed from: a */
            public Uri apply(Intent intent) throws Exception {
                return UCrop.getOutput(intent);
            }
        }

        a(File file) {
            this.f36196a = file;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<FileData> apply(Intent intent) throws Exception {
            intent.addFlags(1);
            return CropImage.this.f36192b.c(intent).react().map(new b()).flatMap(new C0206a());
        }
    }

    public CropImage(TargetUi targetUi, Config config, StartIntent startIntent, ImageUtils imageUtils) {
        this.f36193c = targetUi;
        this.f36191a = config;
        this.f36192b = startIntent;
        this.f36194d = imageUtils;
    }

    private Observable<FileData> c() {
        File g4 = g();
        return Observable.just(e(Uri.fromFile(g4))).flatMap(new a(g4));
    }

    private Uri d() {
        return Uri.fromFile(this.f36195e.getFile());
    }

    private Intent e(Uri uri) {
        Uri d4 = d();
        UCrop.Options options = this.f36191a.getOptions();
        if (options == null) {
            return UCrop.of(d4, uri).getIntent(this.f36193c.getContext());
        }
        if (options instanceof Options) {
            return f((Options) options, uri);
        }
        return UCrop.of(d4, uri).withOptions(this.f36191a.getOptions()).getIntent(this.f36193c.getContext());
    }

    private Intent f(Options options, Uri uri) {
        UCrop withOptions = UCrop.of(Uri.fromFile(this.f36195e.getFile()), uri).withOptions(options);
        if (options.getX() != 0.0f) {
            withOptions.withAspectRatio(options.getX(), options.getY());
        }
        if (options.getWidth() != 0) {
            withOptions.withMaxResultSize(options.getWidth(), options.getHeight());
        }
        return withOptions.getIntent(this.f36193c.getContext());
    }

    private File g() {
        String fileExtension = this.f36194d.getFileExtension(this.f36195e.getFile().getAbsolutePath(), ImageUtils.JPG_FILE_EXTENSION);
        return this.f36194d.getPrivateFile(this.f36191a.getFileProviderDirectory(), this.f36194d.createTimestampedFilename("CROPPED-", fileExtension));
    }

    private boolean h() {
        return this.f36194d.isImage(this.f36195e.getFile());
    }

    public Observable<FileData> react() {
        if (this.f36191a.isDoCrop()) {
            if (!h()) {
                if (!this.f36191a.isFailCropIfNotImage()) {
                    return Observable.just(this.f36195e);
                }
                throw new IllegalArgumentException("Expected an image file, cannot perform image crop");
            }
            return c();
        }
        return Observable.just(this.f36195e);
    }

    public CropImage with(FileData fileData) {
        this.f36195e = fileData;
        return this;
    }
}
