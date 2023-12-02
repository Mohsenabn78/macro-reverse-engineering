package com.google.mlkit.common.sdkinternal.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzi;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.LocalModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class LocalModelLoader {

    /* renamed from: a  reason: collision with root package name */
    private MappedByteBuffer f32997a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f32998b;

    /* renamed from: c  reason: collision with root package name */
    private final LocalModel f32999c;

    @KeepForSdk
    public LocalModelLoader(@NonNull Context context, @NonNull LocalModel localModel) {
        this.f32998b = context;
        this.f32999c = localModel;
    }

    @NonNull
    @KeepForSdk
    public LocalModel getLocalModel() {
        return this.f32999c;
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public MappedByteBuffer load() throws MlKitException {
        FileChannel channel;
        Preconditions.checkNotNull(this.f32998b, "Context can not be null");
        Preconditions.checkNotNull(this.f32999c, "Model source can not be null");
        MappedByteBuffer mappedByteBuffer = this.f32997a;
        if (mappedByteBuffer != null) {
            return mappedByteBuffer;
        }
        String absoluteFilePath = this.f32999c.getAbsoluteFilePath();
        String assetFilePath = this.f32999c.getAssetFilePath();
        Uri uri = this.f32999c.getUri();
        if (absoluteFilePath != null) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(absoluteFilePath, "r");
                FileChannel channel2 = randomAccessFile.getChannel();
                this.f32997a = channel2.map(FileChannel.MapMode.READ_ONLY, 0L, channel2.size());
                channel2.close();
                randomAccessFile.close();
                return this.f32997a;
            } catch (IOException e4) {
                throw new MlKitException("Can not open the local file: ".concat(String.valueOf(this.f32999c.getAbsoluteFilePath())), 14, e4);
            }
        } else if (assetFilePath != null) {
            try {
                AssetFileDescriptor openFd = this.f32998b.getAssets().openFd(assetFilePath);
                channel = new FileInputStream(openFd.getFileDescriptor()).getChannel();
                try {
                    this.f32997a = channel.map(FileChannel.MapMode.READ_ONLY, openFd.getStartOffset(), openFd.getDeclaredLength());
                    channel.close();
                    openFd.close();
                    return this.f32997a;
                } finally {
                }
            } catch (IOException e5) {
                throw new MlKitException("Can not load the file from asset: " + assetFilePath + ". Please double check your asset file name and ensure it's not compressed. See documentation for details how to use aaptOptions to skip file compression", 14, e5);
            }
        } else if (uri != null) {
            try {
                AssetFileDescriptor zza = zzi.zza(this.f32998b, uri, "r");
                channel = zza.createInputStream().getChannel();
                try {
                    this.f32997a = channel.map(FileChannel.MapMode.READ_ONLY, zza.getStartOffset(), zza.getLength());
                    channel.close();
                    zza.close();
                    return this.f32997a;
                } finally {
                }
            } catch (IOException e6) {
                throw new MlKitException("Can not load the file from URI: ".concat(uri.toString()), 14, e6);
            }
        } else {
            throw new MlKitException("Can not load the model. One of filePath, assetFilePath or URI must be set for the model.", 14);
        }
    }
}
