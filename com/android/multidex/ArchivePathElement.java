package com.android.multidex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes2.dex */
class ArchivePathElement implements ClassPathElement {
    private final ZipFile archive;

    /* loaded from: classes2.dex */
    static class DirectoryEntryException extends IOException {
        DirectoryEntryException() {
        }
    }

    public ArchivePathElement(ZipFile zipFile) {
        this.archive = zipFile;
    }

    @Override // com.android.multidex.ClassPathElement
    public void close() throws IOException {
        this.archive.close();
    }

    @Override // com.android.multidex.ClassPathElement
    public Iterable<String> list() {
        return new Iterable<String>() { // from class: com.android.multidex.ArchivePathElement.1
            @Override // java.lang.Iterable
            public Iterator<String> iterator() {
                return new Iterator<String>() { // from class: com.android.multidex.ArchivePathElement.1.1
                    Enumeration<? extends ZipEntry> delegate;
                    ZipEntry next = null;

                    {
                        this.delegate = ArchivePathElement.this.archive.entries();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        while (this.next == null && this.delegate.hasMoreElements()) {
                            ZipEntry nextElement = this.delegate.nextElement();
                            this.next = nextElement;
                            if (nextElement.isDirectory()) {
                                this.next = null;
                            }
                        }
                        if (this.next != null) {
                            return true;
                        }
                        return false;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    @Override // java.util.Iterator
                    public String next() {
                        if (hasNext()) {
                            String name = this.next.getName();
                            this.next = null;
                            return name;
                        }
                        throw new NoSuchElementException();
                    }
                };
            }
        };
    }

    @Override // com.android.multidex.ClassPathElement
    public InputStream open(String str) throws IOException {
        ZipEntry entry = this.archive.getEntry(str);
        if (entry != null) {
            if (!entry.isDirectory()) {
                return this.archive.getInputStream(entry);
            }
            throw new DirectoryEntryException();
        }
        throw new FileNotFoundException("File \"" + str + "\" not found");
    }
}
