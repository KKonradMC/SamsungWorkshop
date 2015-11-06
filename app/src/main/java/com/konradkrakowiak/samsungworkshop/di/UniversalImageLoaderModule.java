package com.konradkrakowiak.samsungworkshop.di;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.ext.LruDiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UniversalImageLoaderModule {

    public static final int MEMORY_SIZE = 2 * 1024 * 1024;
    public static final int MEMORY_SIZE2 = 4 * 1024 * 1024;
    public static final int MAX_FILE_COUNT = 10;
    private final Context context;

    public UniversalImageLoaderModule(Context context) {
        this.context = context;
    }

    @Provides
    ImageLoaderConfiguration provideImageLoaderConfiguration(
            DisplayImageOptions displayImageOptions,
            MemoryCache memoryCache,
            DiskCache diskCache){
        ImageLoaderConfiguration builder = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(displayImageOptions)
                .memoryCache(memoryCache)
                .diskCacheSize(MEMORY_SIZE2)
                .memoryCacheSize(MEMORY_SIZE)
                .diskCache(diskCache)
                .diskCacheFileCount(MAX_FILE_COUNT)
                .build();

        return builder;
    }

    @Provides
    DisplayImageOptions provideDisplayImageOptions(){
        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        return displayImageOptions;
    }

    @Singleton
    @Provides
    ImageLoader provideImageLoader(ImageLoaderConfiguration imageLoaderConfiguration){
        ImageLoader instance = ImageLoader.getInstance();
        instance.init(imageLoaderConfiguration);
        return instance;
    }

    @Provides
    MemoryCache provideMemoryCache(){
        return new LruMemoryCache(MEMORY_SIZE);
    }

    @Provides
    DiskCache provideDiskCache(){
        return new UnlimitedDiskCache(Environment.getExternalStorageDirectory());
    }
}
