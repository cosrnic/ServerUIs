plugins {
    id("java")
}

group = "dev.cosrnic"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("net.minestom:minestom-snapshots:f1d5940855")
}