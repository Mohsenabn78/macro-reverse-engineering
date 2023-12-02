package com.miguelbcr.ui.rx_paparazzo2.workers;

import android.content.pm.PackageManager;
import com.miguelbcr.ui.rx_paparazzo2.entities.Config;
import com.miguelbcr.ui.rx_paparazzo2.entities.FileData;
import com.miguelbcr.ui.rx_paparazzo2.entities.Ignore;
import com.miguelbcr.ui.rx_paparazzo2.entities.Response;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;
import com.miguelbcr.ui.rx_paparazzo2.interactors.CropImage;
import com.miguelbcr.ui.rx_paparazzo2.interactors.GrantPermissions;
import com.miguelbcr.ui.rx_paparazzo2.interactors.PermissionUtil;
import com.miguelbcr.ui.rx_paparazzo2.interactors.SaveFile;
import com.miguelbcr.ui.rx_paparazzo2.interactors.TakePhoto;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Arrays;

/* loaded from: classes6.dex */
public final class Camera extends com.miguelbcr.ui.rx_paparazzo2.workers.a {

    /* renamed from: b  reason: collision with root package name */
    private final TakePhoto f36259b;

    /* renamed from: c  reason: collision with root package name */
    private final CropImage f36260c;

    /* renamed from: d  reason: collision with root package name */
    private final SaveFile f36261d;

    /* renamed from: e  reason: collision with root package name */
    private final GrantPermissions f36262e;

    /* renamed from: f  reason: collision with root package name */
    private final TargetUi f36263f;

    /* renamed from: g  reason: collision with root package name */
    private final Config f36264g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes6.dex */
    public class a<T> implements Function<FileData, Response<T, FileData>> {
        a() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public Response<T, FileData> apply(FileData fileData) throws Exception {
            return new Response<>(Camera.this.f36263f.ui(), fileData, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements Function<FileData, ObservableSource<FileData>> {
        b() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<FileData> apply(FileData fileData) throws Exception {
            return Camera.this.i(fileData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements Function<Ignore, ObservableSource<FileData>> {
        c() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<FileData> apply(Ignore ignore) throws Exception {
            return Camera.this.f36259b.react();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements Function<FileData, ObservableSource<FileData>> {
        d() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<FileData> apply(FileData fileData) throws Exception {
            return Camera.this.f36261d.with(fileData).react();
        }
    }

    public Camera(TakePhoto takePhoto, CropImage cropImage, SaveFile saveFile, GrantPermissions grantPermissions, TargetUi targetUi, Config config) {
        super(targetUi);
        this.f36259b = takePhoto;
        this.f36260c = cropImage;
        this.f36261d = saveFile;
        this.f36262e = grantPermissions;
        this.f36263f = targetUi;
        this.f36264g = config;
    }

    private static <T> T[] g(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    private String[] h() {
        if (j()) {
            return new String[]{"android.permission.CAMERA"};
        }
        return new String[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<FileData> i(FileData fileData) {
        return this.f36260c.with(fileData).react().flatMap(new d());
    }

    private boolean j() {
        try {
            String[] strArr = this.f36263f.getContext().getPackageManager().getPackageInfo(this.f36263f.getContext().getPackageName(), 4096).requestedPermissions;
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (str.equals("android.permission.CAMERA")) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    private String[] k() {
        return (String[]) g(PermissionUtil.getReadAndWriteStoragePermissions(this.f36264g.isUseInternalStorage()), h());
    }

    public <T> Observable<Response<T, FileData>> takePhoto() {
        return this.f36262e.with(k()).react().flatMap(new c()).flatMap(new b()).map(new a()).compose(b());
    }
}
