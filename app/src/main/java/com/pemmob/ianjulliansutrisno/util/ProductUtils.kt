package com.pemmob.ianjulliansutrisno.util

import android.content.Context
import com.pemmob.ianjulliansutrisno.R
import com.pemmob.ianjulliansutrisno.data.model.Product
import com.pemmob.ianjulliansutrisno.util.JualanConstants.BASE_URL

fun Product.getImageModel(context: Context): Any {
    val packageName = context.packageName

    // 1. Check if product.img directly corresponds to a drawable resource in res
    val cleanImgName = img.substringBeforeLast('.').lowercase().trim()
    if (cleanImgName.isNotEmpty() && cleanImgName != "dummy_product" && cleanImgName != "produk") {
        val imgResId = context.resources.getIdentifier(cleanImgName, "drawable", packageName)
        if (imgResId != 0) {
            return imgResId
        }
    }

    // 2. Check if product.name corresponds to a drawable name in res
    val cleanName = name.lowercase().trim().replace(" ", "_").replace("-", "_")
    val nameResId = context.resources.getIdentifier(cleanName, "drawable", packageName)
    if (nameResId != 0) {
        return nameResId
    }

    // 3. Check alias/partial matches for known product names
    when {
        cleanName.contains("kopi") -> return R.drawable.kopi
        cleanName.contains("sirup") -> return R.drawable.sirup
        cleanName.contains("gantungan") || cleanName.contains("ganci") -> return R.drawable.ganci
    }

    // 4. If product.img is a full URL, return it directly
    if (img.startsWith("http://") || img.startsWith("https://")) {
        return img
    }

    // 5. If product.img is a valid remote image filename
    if (img.isNotBlank() && img != "dummy_product" && img != "produk.jpeg") {
        return "${BASE_URL}img/$img"
    }

    // 6. Fallback to default dummy_product resource
    return R.drawable.dummy_product
}
