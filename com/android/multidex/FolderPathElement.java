package com.android.multidex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

/* loaded from: classes2.dex */
class FolderPathElement implements ClassPathElement {
    private File baseFolder;

    public FolderPathElement(File file) {
        this.baseFolder = file;
    }

    private void collect(File file, String str, ArrayList<String> arrayList) {
        File[] listFiles;
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                collect(file2, str + '/' + file2.getName(), arrayList);
            } else {
                arrayList.add(str + '/' + file2.getName());
            }
        }
    }

    @Override // com.android.multidex.ClassPathElement
    public Iterable<String> list() {
        ArrayList<String> arrayList = new ArrayList<>();
        collect(this.baseFolder, "", arrayList);
        return arrayList;
    }

    @Override // com.android.multidex.ClassPathElement
    public InputStream open(String str) throws FileNotFoundException {
        return new FileInputStream(new File(this.baseFolder, str.replace('/', File.separatorChar)));
    }

    @Override // com.android.multidex.ClassPathElement
    public void close() {
    }
}
