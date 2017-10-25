package com.douya.okhttplibrary.app;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/9/8 12:33
 */

public class MyApp extends Application {
    public static MyApp mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
         String path = Environment.getExternalStorageDirectory()+"/1507EPic";

                 File cacheDir = new File(path);

                 ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                         .threadPoolSize(5)
                         .threadPriority(100)
                         .memoryCacheExtraOptions(200,200)
                         .memoryCacheSize(2*1024*1024)
                         .diskCache(new UnlimitedDiskCache(cacheDir))
                         .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                         .diskCacheSize(50 * 1024)
                         .build();

                 ImageLoader.getInstance().init(config);

    }
    public static MyApp getInstance() {
        return mInstance;
    }
}
