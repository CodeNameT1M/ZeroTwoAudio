package projectmeli.yandereaudio.pdesire.core.yanderecore.framework.os

import projectmeli.yandereaudio.pdesire.core.yanderecore.framework.os.YandereRootUtility

object YanderePropertyControl {
    fun getprop(property : String) : String {
        try {
            val propertyValue = System.getProperty(property)
            if (propertyValue != null)
                return propertyValue
            else
                return ""
        } catch (e0 : NullPointerException){}

        return ""
    }

    fun setprop (property : String, value : String) {
        YandereRootUtility.sudo("setprop " + property + " " + value)
    }
}