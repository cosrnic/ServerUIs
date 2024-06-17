pluginManagement {
    repositories {
        maven {
            name = "fabricmc"
            url = uri("https://maven.fabricmc.net/")
        }
        maven {
            name = "architectury"
            url = uri("https://maven.architectury.dev/")
        }
        maven {
            name = "forgemc"
            url  = uri("https://files.minecraftforge.net/maven/")
        }
        gradlePluginPortal()
    }
}

include("common")
include("fabric")
include("neoforge")

rootProject.name = "ServerUIs"
