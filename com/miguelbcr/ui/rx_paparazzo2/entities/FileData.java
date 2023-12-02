package com.miguelbcr.ui.rx_paparazzo2.entities;

import android.util.Log;
import com.miguelbcr.ui.rx_paparazzo2.interactors.Dimensions;
import java.io.File;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class FileData implements Serializable {
    private boolean exceededMaximumFileSize;
    private File file;
    private String filename;
    private String mimeType;
    private Dimensions originalDimensions;
    private String title;
    private boolean transientFile;

    public FileData(FileData fileData, Dimensions dimensions) {
        this(fileData.getFile(), fileData.isTransientFile(), fileData.getFilename(), fileData.getMimeType(), fileData.getTitle(), dimensions, fileData.isExceededMaximumFileSize());
    }

    public static void deleteSourceFile(FileData fileData) {
        File file;
        if (fileData.isTransientFile() && (file = fileData.getFile()) != null && file.exists()) {
            try {
                Log.i(FileData.class.getSimpleName(), String.format("Removing source file '%s'", file.getAbsolutePath()));
                file.delete();
            } catch (Exception e4) {
                Log.i(FileData.class.getSimpleName(), String.format("Could not remove source file '%s'", file.getAbsolutePath()), e4);
            }
        }
    }

    public static FileData exceededMaximumFileSize(FileData fileData) {
        return new FileData(null, true, fileData.getFilename(), fileData.getMimeType(), fileData.getTitle(), fileData.getOriginalDimensions(), true);
    }

    public static FileData toFileDataDeleteSourceFileIfTransient(FileData fileData, File file, boolean z3, String str) {
        deleteSourceFile(fileData);
        return new FileData(fileData, file, z3, str);
    }

    public String describe() {
        String str = this.title;
        if (str == null) {
            return String.format("%s (%s)", this.filename, this.mimeType);
        }
        return String.format("%s (%s) - %s", this.filename, this.mimeType, str);
    }

    public File getFile() {
        return this.file;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Dimensions getOriginalDimensions() {
        return this.originalDimensions;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isExceededMaximumFileSize() {
        return this.exceededMaximumFileSize;
    }

    public boolean isTransientFile() {
        return this.transientFile;
    }

    public String toString() {
        String str;
        if (this.transientFile) {
            str = "Transient";
        } else {
            str = "Not transient";
        }
        return String.format("%s %s (%s) - %s", str, this.filename, this.mimeType, this.title);
    }

    public FileData(FileData fileData, File file, boolean z3, String str) {
        this(file, z3, fileData.getFilename(), str, fileData.getTitle(), fileData.getOriginalDimensions(), fileData.isExceededMaximumFileSize());
    }

    public FileData(File file, boolean z3, String str, String str2) {
        this(file, z3, str, str2, null, null, false);
    }

    public FileData(File file, boolean z3, String str, String str2, String str3) {
        this(file, z3, str, str2, str3, null, false);
    }

    public FileData(File file, boolean z3, String str, String str2, String str3, Dimensions dimensions, boolean z4) {
        this.filename = str;
        this.transientFile = z3;
        this.mimeType = str2;
        this.file = file;
        this.title = str3;
        this.exceededMaximumFileSize = z4;
        this.originalDimensions = dimensions;
    }
}
