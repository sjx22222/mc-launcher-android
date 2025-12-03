import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment

fun downloadApk(context: Context, apkUrl: String, fileName: String) {
    val request = DownloadManager.Request(Uri.parse(apkUrl))
        .setTitle(fileName)
        .setDescription("Downloading APK...")
        .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName)
        .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
    val manager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    manager.enqueue(request)
}
