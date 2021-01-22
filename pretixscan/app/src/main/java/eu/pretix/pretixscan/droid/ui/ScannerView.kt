package eu.pretix.pretixscan.droid.ui

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import com.google.zxing.BarcodeFormat
import me.dm7.barcodescanner.zxing.ZXingScannerView


class ScannerView : ZXingScannerView {
    private var mFramingRectInPreview: Rect? = null

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        this.setFormats(
                listOf(
                        BarcodeFormat.QR_CODE
                )
        )
    }

    @Synchronized
    override fun getFramingRectInPreview(previewWidth: Int, previewHeight: Int): Rect {
        if (this.mFramingRectInPreview == null) {
            val rect = Rect()
            rect.left = 0
            rect.top = 0
            rect.right = previewWidth
            rect.bottom = previewHeight

            this.mFramingRectInPreview = rect
        }

        return this.mFramingRectInPreview!!
    }
}