package com.vinodmorya.giphy

import android.app.Application
import com.facebook.cache.disk.DiskCacheConfig
import com.facebook.common.internal.Supplier
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.core.ImagePipelineConfig
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.vinodmorya.giphy.ui.support.network.NetworkClientRx
import ren.yale.android.retrofitcachelibrx2.RetrofitCache

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
        NetworkClientRx.INSTANCE.init(this)
        RetrofitCache.getInstance().init(this).enableMock(true)
        configFresco()
    }

    private fun configFresco() {
        val diskSupplier = Supplier { applicationContext.cacheDir }
        val diskCacheConfig = DiskCacheConfig.newBuilder(this).setBaseDirectoryName("freshWorks").setBaseDirectoryPathSupplier(diskSupplier).build()
        val frescoConfig = ImagePipelineConfig.newBuilder(this).setMainDiskCacheConfig(diskCacheConfig).build()
        Fresco.initialize(this, frescoConfig)
    }
}
