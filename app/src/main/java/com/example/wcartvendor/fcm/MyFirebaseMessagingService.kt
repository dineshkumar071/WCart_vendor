package com.example.wcartvendor.fcm

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.json.JSONException
import org.json.JSONObject
import java.util.*

/**
 * Created by akash on 17/10/16.
 */
/**
 * Created by Belal on 5/27/2016.
 */
class MyFirebaseMessagingService : FirebaseMessagingService() {
    var maximum = 10000
    var minimum = 1
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        var message = ""
        if (remoteMessage.data.isNotEmpty()) {
            try {
                val js = JSONObject(remoteMessage.data["payload"])
                message = JSONObject(js["aps"].toString())["alert"].toString()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            //Calling method to generate notification
            //    sendNotification(message);
        } else {
            Log.d(TAG, "Notification Message Body: " + remoteMessage.notification!!.body)
            //  sendNotification(remoteMessage.getNotification().getBody());
        }
    }

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
    }

    /* private void sendNotification(String messageBody) {
        Intent intent = new Intent(this, NotificationActivity.class);
        intent.putExtra(AppConstants.TAG_FROM_WHERE,AppConstants.FROM_NOTIFICATION_ON_STATUS_BAR);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getString(R.string.txt_fitstreet))
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setPriority(Notification.PRIORITY_MAX)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(messageBody))
                .setContentIntent(pendingIntent);

        notificationBuilder.getNotification().flags |= Notification.FLAG_AUTO_CANCEL;

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = getApplication().getString(R.string.default_notification_channel_id);
            NotificationChannel channel = new NotificationChannel(channelId,   getString(R.string.txt_fitstreet), NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(messageBody);
            notificationManager.createNotificationChannel(channel);
            notificationBuilder.setChannelId(channelId);
        }

        notificationManager.notify(generateRandom(), notificationBuilder.build());

    }*/
    fun generateRandom(): Int {
        val rn = Random()
        val n = maximum - minimum + 1
        val i = rn.nextInt() % n
        return minimum + i
    }

    companion object {
        private const val TAG = "MyFirebaseMsgService"
    }
}