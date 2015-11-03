package com.konradkrakowiak.samsungworkshop.di;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by przemyslawlukasz on 03/11/15.
 */
@Module
public class ImageLoaderModule {

    Context context;

    public ImageLoaderModule(Context context) {
        this.context = context;
    }

    @Provides
    ImageLoaderConfiguration provideImageLoaderConfiguration(DisplayImageOptions displayImageOptions, MemoryCache memoryCache, DiskCache diskCache) {
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(context);
        builder.defaultDisplayImageOptions(displayImageOptions)
                .memoryCache(memoryCache)
                .diskCache(diskCache);
        return builder.build();
    }

    @Provides
    DisplayImageOptions provideDisplayImageOptions() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        return options;
    }

    @Provides
    MemoryCache provideMemoryCache() {
        return new LruMemoryCache(2 * 1024 * 1024);
    }

    @Provides
    DiskCache provideDiskCache() {
        File directory = Environment.getExternalStorageDirectory();
        UnlimitedDiskCache cache = new UnlimitedDiskCache(directory);
        cache.setCompressFormat(Bitmap.CompressFormat.PNG);
        return cache;
    }

    @Singleton
    @Provides
    ImageLoader provideImageLoader(ImageLoaderConfiguration configuration) {
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(configuration);
        return imageLoader;
    }
}
