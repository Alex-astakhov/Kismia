package core;

import java.io.File;

/**
 * Created by Alex Astakhov on 18.12.2016.
 */
public class FileIO {

    protected void createDirectory(String path){
        File file = new File(path);
        if (!file.exists()){
            file.mkdir();
        }
    }
}
