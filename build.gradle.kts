import net.fabricmc.loom.api.LoomGradleExtensionAPI

plugins {
    java
    id("dev.architectury.loom") version "1.6-SNAPSHOT" apply false
    id("architectury-plugin") version "3.4-SNAPSHOT"
    id("com.github.johnrengelman.shadow") version "8.1.1" apply false
}

architectury {
    minecraft = rootProject.property("minecraft_version").toString()
}

allprojects {
    group = rootProject.property("maven_group").toString()
    version = rootProject.property("mod_version").toString()
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "dev.architectury.loom")
    apply(plugin = "architectury-plugin")
    apply(plugin = "maven-publish")

    base.archivesName.set(rootProject.property("archives_name").toString())

    val loom = project.extensions.getByName<LoomGradleExtensionAPI>("loom")

    repositories {
        // Add repositories to retrieve artifacts from in here.
        // You should only use this when depending on other mods because
        // Loom adds the essential maven repositories to download Minecraft and libraries from automatically.
        // See https://docs.gradle.org/current/userguide/declaring_repositories.html
        // for more information about repositories.
    }

    dependencies {
        "minecraft"("net.minecraft:minecraft:${project.property("minecraft_version")}")
        "mappings"(loom.officialMojangMappings())
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release.set(21)
    }

    java {
        withSourcesJar()
    }

//    // Configure Maven publishing.
//    publishing {
//        publications {
//            create<MavenPublication>("maven") {
//                artifactId = rootProject.property("archives_name").toString()
//                from(components.getByName<AdhocComponentWithVariants>("java"))
//            }
//        }
//
//        // See https://docs.gradle.org/current/userguide/publishing_maven.html for information on how to set up publishing.
//        repositories {
//            // Add repositories to publish to here.
//            // Notice: This block does NOT have the same function as the block in the top level.
//            // The repositories here will be used for publishing your artifact, not for
//            // retrieving dependencies.
//        }
//    }
}
