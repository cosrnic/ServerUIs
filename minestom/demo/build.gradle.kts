plugins {
    id("java")
}

group = "dev.cosrnic"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    project.parent?.let { implementation(it) }
    implementation("net.minestom:minestom-snapshots:f1d5940855")
}