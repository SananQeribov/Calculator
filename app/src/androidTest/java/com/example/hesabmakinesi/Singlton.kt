// Notification interface
interface Notification {
    fun send()
}


class EmailNotification : Notification {
    override fun send() {
        println("Sending email notification...")
    }
}


class SMSNotification : Notification {
    override fun send() {
        println("Sending SMS notification...")
    }
}

class PushNotification : Notification {
    override fun send() {
        println("Sending push notification...")
    }
}

object NotificationFactory {
    enum class NotificationType {
        EMAIL,
        SMS,
        PUSH
    }

    fun createNotification(type: NotificationType): Notification {
        return when (type) {
            NotificationType.EMAIL -> EmailNotification()
            NotificationType.SMS -> SMSNotification()
            NotificationType.PUSH -> PushNotification()
        }
    }
}

fun main() {
    val emailNotification = NotificationFactory.createNotification(NotificationFactory.NotificationType.EMAIL)
    val smsNotification = NotificationFactory.createNotification(NotificationFactory.NotificationType.SMS)
    val pushNotification = NotificationFactory.createNotification(NotificationFactory.NotificationType.PUSH)

    emailNotification.send()
    smsNotification.send()
    pushNotification.send()
}
