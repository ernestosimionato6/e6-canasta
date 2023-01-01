package ven.canasta.apps.grocery

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.SvgDecoder
import com.google.samples.apps.nowinandroid.sync.initializers.Sync
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class NiaApplication : Application(), ImageLoaderFactory {
    override fun onCreate() {
        super.onCreate()
        Sync.initialize(context = this)
    }

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()
    }
}
