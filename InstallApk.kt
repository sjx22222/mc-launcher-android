import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.core.content.FileProvider
import java.io.File

fun installApk(context: Context, apkFile: File) {
    val uri: Uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", apkFile)
    } else {
        Uri.fromFile(apkFile)
    }

    val intent = Intent(Intent.ACTION_VIEW)
    intent.setDataAndType(uri, "application/vnd.android.package-archive")
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_GRANT_READ_URI_PERMISSION
    context.startActivity(intent)
}
